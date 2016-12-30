/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.redis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;

import com.baidu.algorithm.annotation.Note;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.ZParams;

/**
 * chapter06
 *
 * @author xuhaoran01
 */
public class chapter06 {

    public static void main(String[] args) throws Exception {

        new chapter06().run();
    }

    public void run() throws Exception {

        Jedis conn = new Jedis("localhost");
        conn.select(15);

        testAddUpdateContact(conn);
        testAddressBookAutoComplete(conn);
        testDistributedLocking(conn);
        testCountingSemaphore(conn);
        testDelayTasks(conn);
        testMultiRecipientMessaging(conn);
        testFileDistribution(conn);
    }

    public void testAddUpdateContact(Jedis conn) {

        System.out.println("\n--------testAddUpdateContact----------");
        conn.del("recent:user");

        for (int i = 0; i < 10; i++) {
            addUpdateContact(conn, "user", "contact-" + (int) Math.floor(i / 3) + '-' + i);
        }

        List<String> contacts = conn.lrange("recent:user", 0, -1);
        contacts.stream().forEach(System.out::println);

        addUpdateContact(conn, "user", "contact-1-4");
        contacts = conn.lrange("recent:user", 0, 2);

        System.out.println("new top 3 contacts: ");
        contacts.stream().forEach(System.out::println);

        System.out.println("remove a contact: ");
        removeContact(conn, "user", "contact-2-6");

        contacts = conn.lrange("recent:user", 0, -1);
        contacts.stream().forEach(System.out::println);

        List<String> matches = new ArrayList<>();
        contacts.stream().forEach(x -> {
            if (x.startsWith("contact-2-")) {
                matches.add(x);
            }
        });

        contacts = fetchAutoCompleteList(conn, "user", "contact-2-");
        assert contacts.equals(matches);

        conn.del("recent:user");
    }

    public void addUpdateContact(Jedis conn, String user, String contact) {

        String auList = "recent:" + user;

        Transaction trans = conn.multi();
        trans.lrem(auList, 0, contact);
        trans.lpush(auList, contact);
        trans.ltrim(auList, 0, 99);

        trans.exec();
    }

    public void removeContact(Jedis conn, String user, String contact) {

        conn.lrem("recent:" + user, 0, contact);
    }

    public List<String> fetchAutoCompleteList(Jedis conn, String user, String prefix) {

        List<String> contacts = conn.lrange("recent:" + user, 0, -1);
        List<String> res = new ArrayList<>();

        for (String contact : contacts) {
            if (contact.startsWith(prefix)) {
                res.add(contact);
            }
        }

        return res;
    }

    public void testAddressBookAutoComplete(Jedis conn) {

        System.out.println("\n---------testAddressBookAutoComplete------------");
        conn.del("members:test");

        System.out.println("the start/end range of 'abc' is: " + Arrays.toString(findPrefixRange("abc")));

        for (String name : Arrays.asList("jeff", "jenny", "jack", "jennifer")) {
            joinGuild(conn, "test", name);
        }

        Set<String> set = autoCompleteOnPrefix(conn, "test", "je");
        set.stream().forEach(System.out::println);
        assert set.size() == 3;

        leaveGuild(conn, "test", "jeff");
        set = autoCompleteOnPrefix(conn, "test", "je");
        set.stream().forEach(System.out::println);
        assert set.size() == 2;

        conn.del("members:test");
    }

    public static final String VALID_CHARACTERS = "`abcdefghijklmnopqrstuvwxyz{";
    public String[] findPrefixRange(String prefix) {

        int pos = VALID_CHARACTERS.indexOf(prefix.charAt(prefix.length() - 1));
        char suffix = VALID_CHARACTERS.charAt(pos > 0 ? pos - 1 : 0);

        return new String[] {prefix.substring(0, prefix.length() - 1) + suffix + '{', prefix + '{'};
    }

    public void joinGuild(Jedis conn, String guild, String user) {

        conn.zadd("members:" + guild, 0, user);
    }

    public void leaveGuild(Jedis conn, String guild, String user) {

        conn.zrem("members:" + guild, user);
    }

    @Note(desc = "delete item in set, must use iter")
    public Set<String> autoCompleteOnPrefix(Jedis conn, String guild, String prefix) {

        String[] range = findPrefixRange(prefix);
        String identifier = UUID.randomUUID().toString();

        String start = range[0] + identifier;
        String end = range[1] + identifier;

        String zsetName = "members:" + guild;
        conn.zadd(zsetName, 0, start);
        conn.zadd(zsetName, 0, end);

        Set<String> res = null;
        while (true) {
            conn.watch(zsetName);
            int sIndex = conn.zrank(zsetName, start).intValue();
            int eIndex = conn.zrank(zsetName, end).intValue();
            int eRange = Math.min(sIndex + 9, eIndex - 2);

            Transaction trans = conn.multi();
            trans.zrem(zsetName, start);
            trans.zrem(zsetName, end);
            trans.zrange(zsetName, sIndex, eRange);

            List<Object> results = trans.exec();
            if (results != null) {
                res = (Set<String>) results.get(results.size() - 1);
                break;
            }
        }

        for (Iterator<String> iter = res.iterator(); iter.hasNext(); ) {

            if (iter.next().indexOf('{') != -1) {
                iter.remove();
            }
        }

        return res;
    }

    public String acquireLock(Jedis conn, String lockName) {
        return acquireLock(conn, lockName, 10000);
    }

    public String acquireLock(Jedis conn, String lockName, long acquireTimeout) {

        String identifier = UUID.randomUUID().toString();
        long end = System.currentTimeMillis() + acquireTimeout;

        while (System.currentTimeMillis() < end) {
            if (conn.setnx("lock:" + lockName, identifier) == 1) {
                return identifier;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return null;
    }

    public String acquireLockWithTimeout(Jedis conn, String lockName, long acquireTimeOut, long lockTimeOut) {

        String identifier = UUID.randomUUID().toString();
        String lockKey = "lock:" + lockName;
        int lockExpire = (int) (lockTimeOut / 1000);

        long end = System.currentTimeMillis() + acquireTimeOut;
        while (System.currentTimeMillis() < end) {
            if (conn.setnx(lockKey, identifier) == 1) {
                conn.expire(lockKey, lockExpire);
                return identifier;
            }

            if (conn.ttl(lockKey) == -1) {
                conn.expire(lockKey, lockExpire);
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return null;
    }

    public boolean releaseLock(Jedis conn, String lockName, String identifier) {

        String lockKey = "lock:" + lockName;

        while (true) {

            conn.watch(lockKey);
            if (identifier.equals(conn.get(lockKey))) {
                Transaction trans = conn.multi();
                trans.del(lockKey);

                if (trans.exec() == null) {
                    continue;
                }

                return true;
            }
            conn.unwatch();
            break;
        }

        return false;
    }

    public void testDistributedLocking(Jedis conn) throws InterruptedException {

        System.out.println("\n--------testDistributedLocking--------");
        conn.del("lock:testLock");

        assert acquireLockWithTimeout(conn, "testLock", 1000, 1000) != null;

        assert acquireLockWithTimeout(conn, "testLock", 10, 1000) == null;

        Thread.sleep(2000);

        String lockId = acquireLockWithTimeout(conn, "testLock", 1000, 1000);
        assert lockId != null;

        assert releaseLock(conn, "testLock", lockId);

        assert acquireLockWithTimeout(conn, "testLock", 1000, 1000) != null;

        conn.del("lock:testLock");
    }

    public void testCountingSemaphore(Jedis conn) throws InterruptedException {

        System.out.println("\n--------testCountingSemaphore-----------");
        conn.del("testsem", "testsem:owner", "testsem:counter");

        for (int i = 0; i < 3; i++) {
            assert acquireFairSemaphore(conn, "testsem", 3, 1000) != null;
        }

        assert acquireFairSemaphore(conn, "testsem", 3, 1000) == null;

        Thread.sleep(2000);

        String id = acquireFairSemaphore(conn, "testsem", 3, 1000);
        assert id != null;

        assert releaseFairSemaphore(conn, "testsem", id);

        for (int i = 0; i < 3; i++) {
            assert acquireFairSemaphore(conn, "testsem", 3, 1000) != null;
        }

        conn.del("testsem", "testsem:owner", "testsem:counter");
    }

    public String acquireFairSemaphore(Jedis conn, String semname, int limit, long timeout) {

        String identifier = UUID.randomUUID().toString();
        String owner = semname + ":owner";
        String counter = semname + ":counter";

        long now = System.currentTimeMillis();
        Transaction trans = conn.multi();
        trans.zremrangeByScore(semname, Double.MIN_VALUE, now - timeout);

        ZParams params = new ZParams();
        params.weightsByDouble(1, 0);

        trans.zinterstore(owner, params, owner, semname);
        trans.incr(counter);

        List<Object> results = trans.exec();
        int cnt = ((Long) results.get(results.size() - 1)).intValue();

        trans = conn.multi();
        trans.zadd(semname, now, identifier);
        trans.zadd(owner, cnt, identifier);
        trans.zrank(owner, identifier);

        results = trans.exec();

        if ((long) results.get(results.size() - 1) < limit) {
            return identifier;
        }

        trans = conn.multi();
        trans.zrem(semname, identifier);
        trans.zrem(owner, identifier);
        trans.exec();

        return null;
    }

    public boolean releaseFairSemaphore(Jedis conn, String semname, String identifier) {

        Transaction trans = conn.multi();
        trans.zrem(semname, identifier);
        trans.zrem(semname + ":owner", identifier);

        List<Object> results = trans.exec();

        return (long) results.get(results.size() - 1) == 1;
    }

    public void testDelayTasks(Jedis conn) throws InterruptedException {

        System.out.println("\n------testDelayTasks--------");
        conn.del("queue:tqueue", "delayed:");

        for (long delay : Arrays.asList(0, 500, 0, 1500)) {
            assert executeLater(conn, "tqueue", new ArrayList<String>(), delay) != null;
        }

        assert conn.llen("queue:tqueue") == 2;

        PollQueueThread thread = new PollQueueThread();
        thread.start();

        Thread.sleep(2000);
        thread.quit();
        thread.join();

        assert conn.llen("queue:tqueue") == 4;
    }

    public String executeLater(Jedis conn, String queue, List<String> args, long delay) {

        Gson gson = new Gson();
        String identifier = UUID.randomUUID().toString();
        String itemArgs = gson.toJson(args);
        String item = gson.toJson(Arrays.asList(identifier, queue, itemArgs));

        if (delay > 0) {
            conn.zadd("delayed:", System.currentTimeMillis() + delay, item);
        }
        else {
            conn.rpush("queue:" + queue, item);
        }

        return identifier;
    }

    private class PollQueueThread extends Thread {

        private Jedis conn;
        private boolean quit;
        private Gson gson;

        public PollQueueThread() {
            conn = new Jedis("localhost");
            conn.select(15);
        }

        public void quit() {
            quit = true;
        }

        public void run() {
            while (!quit) {
                Set<Tuple> items = conn.zrangeWithScores("delayed:", 0, 0);
                Tuple item = items.size() > 0 ? items.iterator().next() : null;

                if (item == null || item.getScore() > System.currentTimeMillis()) {
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    continue;
                }

                String json = item.getElement();
                String[] vals = gson.fromJson(json, String[].class);

                String identifier = vals[0];
                String queue = vals[1];

                String lockId = acquireLock(conn, identifier);
                if (lockId == null) {
                    continue;
                }

                if (conn.zrem("delayed:", json) == 1) {
                    conn.rpush("queue:" + queue, json);
                }

                releaseLock(conn, identifier, lockId);
            }

        }
    }

    public void testMultiRecipientMessaging(Jedis conn) {

        System.out.println("\n---------testMultiRecipientMessaging-------");
        conn.del("ids:chat:", "msgs:1", "chat:1", "ids:1", "seen:joe", "seen:jeff", "seen:jenny");

        Set<String> recipients = new HashSet<>();
        recipients.add("jeff");
        recipients.add("jenny");

        String chatId = createChat(conn, "joe", recipients, "message 1");
        for (int i = 2; i <= 5; i++) {
            sendMessage(conn, chatId, "joe", "message " + i);
        }

        List<ChatMessage> m1 = fetchPendingMessages(conn, "jeff");
        List<ChatMessage> m2 = fetchPendingMessages(conn, "jenny");

        assert m1.equals(m2);

        for (ChatMessage chat : m1) {
            System.out.println(" chatId: " + chat.chatId);
            for (Map<String, Object> message : chat.messages) {
                System.out.println(" "+ message);
            }
        }

        conn.del("ids:chat:", "msgs:1", "chat:1", "ids:1", "seen:joe", "seen:jeff", "seen:jenny");
    }

    public String createChat(Jedis conn, String sender, Set<String> recipients, String message) {

        String chatId = Long.toString(conn.incr("ids:chat:"));

        return createChat(conn, sender, recipients, message, chatId);
    }

    public String createChat(Jedis conn, String sender, Set<String> recipients, String message, String chatId) {

        recipients.add(sender);

        Transaction trans = conn.multi();
        for (String recipient : recipients) {
            trans.zadd("chat:" + chatId, 0, recipient);
            trans.zadd("seen:" + recipient, 0, chatId);
        }
        trans.exec();

        return sendMessage(conn, chatId, sender, message);
    }

    public String sendMessage(Jedis conn, String chatId, String sender, String message) {

        String identifier = acquireLock(conn, "chat:" + chatId);
        if (identifier == null) {
            throw new RuntimeException("cannot get the lock");
        }

        try {
            long messageId = conn.incr("ids:" + chatId);

            Map<String, Object> vals = new HashMap<>();
            vals.put("id", messageId);
            vals.put("time", System.currentTimeMillis());
            vals.put("sender", sender);
            vals.put("message", message);

            conn.zadd("msgs:" + chatId, messageId, new Gson().toJson(vals));
        } finally {
            releaseLock(conn, "chat:" + chatId, identifier);
        }

        return chatId;
    }

    public List<ChatMessage> fetchPendingMessages(Jedis conn, String recipient) {

        Set<Tuple> seenSet = conn.zrangeWithScores("seen:" + recipient, 0, -1);
        List<Tuple> seenList = new ArrayList<>(seenSet);

        Transaction trans = conn.multi();
        for (Tuple tuple : seenList) {
            String chatId = tuple.getElement();
            int seenId = (int) tuple.getScore();
            trans.zrangeByScore("msgs:" + chatId, String.valueOf(seenId + 1), "inf");
        }

        List<Object> results = trans.exec();

        Gson gson = new Gson();
        Iterator<Tuple> seenIter = seenList.iterator();
        Iterator<Object> resultIter = results.iterator();

        List<ChatMessage> chatMessages = new ArrayList<>();

        while (seenIter.hasNext()) {
            Tuple seen = seenIter.next();
            Set<String> seenMessages = (Set<String>) resultIter.next();
            if (seenMessages.size() == 0) {
                continue;
            }

            int seenId = 0;
            String chatId = seen.getElement();
            List<Map<String, Object>> messages = new ArrayList<>();
            for (String messageJson : seenMessages) {
                Map<String, Object> message = gson.fromJson(messageJson, new TypeToken<Map<String, Object>>(){}.getType());
                int messageId = ((Double) message.get("id")).intValue();
                if (messageId > seenId) {
                    seenId = messageId;
                }

                messages.add(message);
            }

            conn.zadd("chat:" + chatId, seenId, recipient);
            conn.zadd("seen:" + recipient, seenId, chatId);

            Set<Tuple> minIdSet = conn.zrangeWithScores("chat:" + chatId, 0, 0);
            if (minIdSet.size() > 0) {
                conn.zremrangeByScore("msgs:" + chatId, 0, minIdSet.iterator().next().getScore());
            }

            chatMessages.add(new ChatMessage(chatId, messages));
        }

        return chatMessages;
    }

    public class ChatMessage {
        public String chatId;
        public List<Map<String, Object>> messages;

        public ChatMessage(String chatId, List<Map<String, Object>> messages) {
            this.chatId = chatId;
            this.messages = messages;
        }

        public boolean equals(Object o) {
            if (o instanceof ChatMessage) {
                ChatMessage cm = (ChatMessage) o;
                return chatId.equals(cm.chatId) && messages.equals(cm.messages);
            }

            return false;
        }
    }

    public void testFileDistribution(Jedis conn) throws InterruptedException, IOException {

        System.out.println("\n-------testFileDistribution--------");
        String[] keys = conn.keys("*").toArray(new String[0]);

        conn.del(keys);

        File f1 = File.createTempFile("tmp_redis_1_", ".txt");
        f1.deleteOnExit();
        Writer writer = new FileWriter(f1);
        writer.write("one line\n");
        writer.close();

        File f2 = File.createTempFile("tmp_redis_2_", ".txt");
        f2.deleteOnExit();
        writer = new FileWriter(f2);
        for (int i = 0; i < 100; i++) {
            writer.write("many lines " + i + '\n');
        }
        writer.close();

        File f3 = File.createTempFile("tmp_redis_3_", ".txt");
        f3.deleteOnExit();
        writer = new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(f3)));
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            writer.write("random line " + Long.toHexString(rand.nextLong()) + '\n');
        }
        writer.close();

        File path = f1.getParentFile();
//        CopyLogsThread copyLogsThread = new CopyLogsThread(path, "test:", 1, f3.length());
    }
}
