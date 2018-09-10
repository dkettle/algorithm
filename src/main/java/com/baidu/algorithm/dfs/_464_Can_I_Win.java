/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * _464_Can_I_Win
 *
 * @author xuhaoran01
 */
public class _464_Can_I_Win {
    private boolean[] used;
    private Map<Integer, Boolean> winMap;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return true;
        } else if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }

        used = new boolean[maxChoosableInteger];
        winMap = new HashMap<>();

        return canWin(desiredTotal);
    }

    private boolean canWin(int desiredTotal) {
        if (desiredTotal <= 0) {
            return false;
        }

        int curState = getState();
        if (!winMap.containsKey(curState)) {
            for (int i = 0; i < used.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    if (!canWin(desiredTotal - i - 1)) {
                        winMap.put(curState, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }

            winMap.put(curState, false);
        }

        return winMap.get(curState);
    }

    private int getState() {
        int res = 0;
        for (int i = 0; i < used.length; i++) {
            if (used[i]) {
                res |= 1 << (i + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new _464_Can_I_Win().canIWin(10, 11);
    }

}
