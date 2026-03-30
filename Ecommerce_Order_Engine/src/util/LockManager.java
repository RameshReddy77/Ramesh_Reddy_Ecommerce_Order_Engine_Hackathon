package util;

import java.util.concurrent.*;

public class LockManager {
    private static final ConcurrentHashMap<String, Object> locks = new ConcurrentHashMap<>();

    public static Object getLock(String key) {
        locks.putIfAbsent(key, new Object());
        return locks.get(key);
    }
}