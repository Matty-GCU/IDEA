package xyz.wuhang.utils;

import java.util.UUID;

public class IdUtils {
    public static String randomId() {
        return UUID.randomUUID().toString();
    }
}
