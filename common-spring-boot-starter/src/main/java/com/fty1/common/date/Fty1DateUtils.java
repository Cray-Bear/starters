package com.fty1.common.date;

import lombok.NonNull;

import java.util.concurrent.TimeUnit;

public class Fty1DateUtils {

    /**
     *
     * Returns the time in milliseconds.
     *
     * @param time
     * @param unit
     * @return
     */
    public static long toMilliSeconds(@NonNull long time, @NonNull TimeUnit unit) {
        return unit.toMillis(time);
    }
}
