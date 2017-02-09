/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.stack;

import java.util.Stack;

/**
 * _394_Decode_String
 *
 * @author xuhaoran01
 */
public class _394_Decode_String {

    public String decodeString(String s) {

        Stack<String> st = new Stack<>();
        Stack<Integer> num = new Stack<>();
        String curStr = "";
        Integer curNum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curNum = curNum * 10 + Integer.parseInt(String.valueOf(c));
            }
            else if (c == '[') {
                num.push(curNum);
                curNum = 0;

                st.push(curStr);
                curStr = "";
            }
            else if (c == ']') {
                StringBuilder sb = new StringBuilder(st.pop());
                curNum = num.pop();
                while (curNum > 0) {
                    sb.append(curStr);
                    curNum--;
                }

                curStr = sb.toString();
            }
            else {
                curStr += c;
            }
        }

        return curStr;
    }

    public static void main(String[] args) {
        new _394_Decode_String().decodeString("3[a2[c]]");
    }
}
