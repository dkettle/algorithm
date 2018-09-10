/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * _609_Find_Duplicate_File_in_System
 *
 * @author xuhaoran01
 */
public class _609_Find_Duplicate_File_in_System {

    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        if (paths == null || paths.length == 0) {
            return res;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] fields = path.split(" ");
            for (int i = 1; i < fields.length; i++) {
                int j = fields[i].indexOf('(');
                String filePath = fields[0] + "/" + fields[i].substring(0, j);
                String content = fields[i].substring(j + 1, fields[i].length() - 1);
                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }
                map.get(content).add(filePath);
            }
        }

        for (List<String> subRes : map.values()) {
            if (subRes.size() > 1) {
                res.add(subRes);
            }
        }

        return res;
    }
}
