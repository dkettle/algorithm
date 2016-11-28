/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * _127_Word_Ladder
 *
 * @author xuhaoran01
 */
public class _127_Word_Ladder {

    // bfs
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {

        int res = 0, current = 1, next = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            String str = queue.remove();
            if (str.equals(endWord)) {
                return res + 1;
            }

            char[] sArr = str.toCharArray();
            for (int i = 0; i < sArr.length; i++) {
                char c = sArr[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    if (j == c) {
                        continue;
                    }

                    sArr[i] = j;
                    String temp = new String(sArr);
                    if (wordList.contains(temp)) {
                        wordList.remove(temp);
                        queue.add(temp);
                        next++;
                    }
                    sArr[i] = c;
                }
            }

            if (--current == 0) {
                current = next;
                next = 0;
                res++;
            }
        }


        return 0;
    }
}
