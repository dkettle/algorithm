/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * _843_Guess_the_Word
 *
 * @author xuhaoran01
 */
public class _843_Guess_the_Word {

    class Master {
        public int guess(String w) {
            return -1;
        }
    }

    private int getMatch(String s1, String s2) {
        int match = 0;
        for (int i = 0; i < 6; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                match++;
            }
        }

        return match;
    }

    public void findSecretWord(String[] wordlist, Master master) {
        List<String> words = Arrays.asList(wordlist);
        for (int i = 0; i < 10; i++) {
            int choice = new Random().nextInt(words.size());
            int match = master.guess(words.get(choice));
            if (match == 6) {
                return;
            }

            List<String> nextWords = new ArrayList<>();
            for (String word: words) {
                if (getMatch(word, words.get(choice)) == match) {
                    nextWords.add(word);
                }
            }

            words = nextWords;
        }
    }
}
