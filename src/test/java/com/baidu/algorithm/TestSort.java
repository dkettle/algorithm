/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.baidu.algorithm.sort.BubbleSort;
import com.baidu.algorithm.sort.HeapSort;
import com.baidu.algorithm.sort.InsertSort;
import com.baidu.algorithm.sort.MergeSort;
import com.baidu.algorithm.sort.QuickSort;
import com.baidu.algorithm.sort.SelectSort;
import com.baidu.algorithm.sort.ShellSort;
import com.baidu.algorithm.sort.Sort;

/**
 * TestSort
 *
 * @author xuhaoran01
 */
public class TestSort {

    private List<Integer> nums = Arrays.asList(1, 7, 2, 3, 0, 9, 6, 5, 8, 3, 2, -3, 121);

    private Sort sort = null;


    @Before
    public void beforeEachTest() {
        // 随机重排
        Collections.shuffle(nums);

        System.out.print("Before sort: ");
        System.out.println(nums);
    }

    @After
    public void afterEachTest() {

        sort.sort(nums);

        System.out.print("After sort: ");
        nums.stream().forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println();

        for (int i = 1; i < nums.size(); i++) {
            Assert.assertTrue(nums.get(i) >= nums.get(i - 1));
        }
    }

    @Test
    public void testInsertSort() {

        sort = new InsertSort();
    }

    @Test
    public void testMergeSort() {

        sort = new MergeSort();
    }

    @Test
    public void testQuickSort() {

        sort = new QuickSort();
    }

    @Test
    public void testSelectSort() {

        sort = new SelectSort();
    }

    @Test
    public void testBubbleSort() {

        sort = new BubbleSort();
    }

    @Test
    public void testShellSort() {

        sort = new ShellSort();
    }

    @Test
    public void testHeapSort() {

        sort = new HeapSort();
    }
}
