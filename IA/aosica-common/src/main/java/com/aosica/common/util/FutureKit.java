package com.aosica.common.util;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by yuzp on 2016/6/13.
 */
public class FutureKit {

    public static final int TIMEOUT_SECONDS = 15;

    public static void end(CompletableFuture... fus){
        CompletableFuture<Void> endFu = CompletableFuture.allOf(fus);
        try {
            endFu.get(TIMEOUT_SECONDS, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void end(Runnable action, CompletableFuture ... fus){
        CompletableFuture<Void> endFu = CompletableFuture.allOf(fus);
        if (null != action){
            endFu.thenRun(action);
        }
        try {
            endFu.get(TIMEOUT_SECONDS, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
