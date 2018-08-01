/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.greedy;

/**
 * _134_Gas_Station
 *
 * @author xuhaoran01
 */
public class _134_Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || gas.length != cost.length) {
            return -1;
        }

        int remain = 0;
        for(int i = 0; i < gas.length; i++) {
            remain += gas[i] - cost[i];
        }

        if(remain < 0) {
            return -1;
        }

        int sum = 0, start = 0;
        for(int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if(sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }

        return start;
    }
}
