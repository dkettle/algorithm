/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * _535_Encode_and_Decode_TinyURL
 *
 * @author xuhaoran01
 */
public class _535_Encode_and_Decode_TinyURL {

    public class Codec {

        List<String> db = new ArrayList<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {

            db.add(longUrl);
            return String.valueOf(db.size() - 1);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {

            int index = Integer.valueOf(shortUrl);
            return index < db.size() ? db.get(index) : "";
        }
    }
}
