/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * _166_Fraction_to_Recurring_Decimal
 *
 * @author xuhaoran01
 */
public class _166_Fraction_to_Recurring_Decimal {
    private String helper(long n, long d) {
        int index = 0;

        Map<Long, Integer> map = new HashMap<>();
        map.put(n, index);

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n *= 10;
            sb.append(n / d);
            n %= d;

            if (map.containsKey(n)) {
                int x = map.get(n);
                sb.insert(x, '(');
                sb.append(')');
                break;
            }

            index += 1;
            map.put(n, index);
        }

        return sb.toString();
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        String sign = ((numerator ^ denominator) & (1 << 31)) != 0 ? "-" : "";

        String left = String.valueOf(n / d);
        String right = (n % d != 0) ? helper(n % d, d) : "0";

        if ("0".equals(right)) {
            return sign + left;
        } else {
            return sign + left + "." + right;
        }
    }
}
