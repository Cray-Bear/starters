package com.fty1.lock;

import lombok.NonNull;

import java.util.concurrent.TimeUnit;

public interface Fty1Lock {

    boolean tryLock(@NonNull String lock, long expireTime);

    boolean tryLock(@NonNull String key, long timeout, @NonNull TimeUnit unit);

    boolean tryLock(@NonNull String key);

    void unLock();

}
