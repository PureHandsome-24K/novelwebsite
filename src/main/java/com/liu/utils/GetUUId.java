package com.liu.utils;

import java.util.UUID;

public class GetUUId {
    public static String getShortUUID() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 6);
    }
}
