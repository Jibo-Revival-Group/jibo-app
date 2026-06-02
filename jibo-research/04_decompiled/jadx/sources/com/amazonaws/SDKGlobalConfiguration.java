package com.amazonaws;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class SDKGlobalConfiguration {
    private static final AtomicInteger globalTimeOffset = new AtomicInteger(0);

    public static int getGlobalTimeOffset() {
        return globalTimeOffset.get();
    }

    public static void setGlobalTimeOffset(int i) {
        globalTimeOffset.set(i);
    }
}
