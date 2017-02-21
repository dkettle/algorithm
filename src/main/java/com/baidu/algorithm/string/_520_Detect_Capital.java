/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

/**
 * _520_Detect_Capital
 *
 * @author xuhaoran01
 */
public class _520_Detect_Capital {

    public boolean detectCapitalUse(String word) {

        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }
}
