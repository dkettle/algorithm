/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.practice.model;

/**
 * LinkedList
 *
 * @author xuhaoran01
 */
public class LinkedList {
    public int val;
    public LinkedList next;

    public LinkedList(int val) {
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "val=" + val +
                '}';
    }
}
