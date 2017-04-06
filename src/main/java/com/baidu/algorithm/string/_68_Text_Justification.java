/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * _68_Text_Justification
 *
 * @author xuhaoran01
 */
public class _68_Text_Justification {

    private String nSpaceStr(int n) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }

        return sb.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> res = new ArrayList<>();
        int i = 0, len = words.length;

        while (i < len) {
            int sum = words[i].length(), j = i + 1;
            while (j < len) {
                if (sum + words[j].length() + 1 > maxWidth) {
                    break;
                }
                sum += words[j].length() + 1;
                j++;
            }

            String str = "";
            if (j == len || j == i + 1) { // last line or only one word
                for (int u = i; u < j - 1; u++){
                    str += words[u] + " ";
                }
                str += words[j - 1];

                str += nSpaceStr(maxWidth - str.length());
            }
            else {
                int m = (maxWidth - sum) / (j - i - 1);
                int n = (maxWidth - sum) % (j - i - 1);
                for (int u = i; u < j - 1; u++) {
                    str += words[u] + nSpaceStr(m + (n > 0 ? 2 : 1));
                    n--;
                }
                str += words[j - 1];
            }

            i = j;
            res.add(str);
        }

        return res;
    }

    public static void main(String[] args) {
        new _68_Text_Justification().fullJustify(new String[] {"a", "b", "c", "d", "e"}, 1);
    }
}
