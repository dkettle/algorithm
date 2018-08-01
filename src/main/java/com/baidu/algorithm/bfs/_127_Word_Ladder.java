/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bfs;

import java.util.*;

/**
 * _127_Word_Ladder
 *
 * @author xuhaoran01
 */
public class _127_Word_Ladder {

    // bfs
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int level = 1;
        while(!queue.isEmpty()) {
            int sz = queue.size();
            for(int i = 0; i < sz; i++) {
                String t = queue.remove();
                if(t.equals(endWord)) {
                    return level;
                }

                char[] chars = t.toCharArray();
                for(int j = 0; j < chars.length; j++) {
                    char c = chars[j];
                    for(char k = 'a'; k <= 'z'; k++) {
                        if(k == c) {
                            continue;
                        }
                        chars[j] = k;
                        String next = new String(chars);
                        if(wordSet.contains(next)) {
                            queue.add(next);
                            wordSet.remove(next);
                        }
                        chars[j] = c;
                    }
                }
            }

            level++;
        }

        return 0;
    }
}
