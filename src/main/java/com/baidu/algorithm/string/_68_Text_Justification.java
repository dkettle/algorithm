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

//    private String nSpaceStr(int n) {
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < n; i++) {
//            sb.append(' ');
//        }
//
//        return sb.toString();
//    }
//
//    public List<String> fullJustify(String[] words, int maxWidth) {
//
//        List<String> res = new ArrayList<>();
//        int i = 0, len = words.length;
//
//        while (i < len) {
//            int sum = words[i].length(), j = i + 1;
//            while (j < len) {
//                if (sum + words[j].length() + 1 > maxWidth) {
//                    break;
//                }
//                sum += words[j].length() + 1;
//                j++;
//            }
//
//            String str = "";
//            if (j == len || j == i + 1) { // last line or only one word
//                for (int u = i; u < j - 1; u++){
//                    str += words[u] + " ";
//                }
//                str += words[j - 1];
//
//                str += nSpaceStr(maxWidth - str.length());
//            }
//            else {
//                int m = (maxWidth - sum) / (j - i - 1);
//                int n = (maxWidth - sum) % (j - i - 1);
//                for (int u = i; u < j - 1; u++) {
//                    str += words[u] + nSpaceStr(m + (n > 0 ? 2 : 1));
//                    n--;
//                }
//                str += words[j - 1];
//            }
//
//            i = j;
//            res.add(str);
//        }
//
//        return res;
//    }

    public static void main(String[] args) {
        new _68_Text_Justification().fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20);
    }

    private String nSpaceStr(int n) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }

        return sb.toString();
    }


    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0 || maxWidth == 0) {
            return res;
        }

        int i = 0, n = words.length;
        while (i < n) {
            int j = i + 1, curLen = words[i].length();
            while (j < n && curLen <= maxWidth) {
                curLen += words[j].length() + 1;
                j++;
            }

            if (curLen > maxWidth) {
                curLen -= (words[j - 1].length() + 1);
                j -= 2;

                int numOfWords = j - i + 1, wordsLen = curLen - numOfWords + 1, spaceLen = maxWidth - wordsLen;
                if (numOfWords == 1) {
                    res.add(words[i] + nSpaceStr(spaceLen));
                } else {
                    int avgSpace = spaceLen / (numOfWords - 1);
                    int avgRemain = spaceLen % (numOfWords - 1);
                    StringBuilder sb = new StringBuilder();
                    for (int k = i; k < j; k++) {
                        sb.append(words[k]);
                        sb.append(nSpaceStr(avgSpace));
                        if (avgRemain > 0) {
                            sb.append(' ');
                            avgRemain--;
                        }
                    }
                    sb.append(words[j]);

                    res.add(sb.toString());
                }
            } else {
                String curRes = "";
                for (int k = i; k < n; k++) {
                    curRes += words[k] + " ";
                }
                curRes = curRes.substring(0, curRes.length() - 1);
                curRes += nSpaceStr(maxWidth - curRes.length());
                res.add(curRes);
            }

            i = j + 1;
        }

        return res;
    }
}
