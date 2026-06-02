package com.google.api.client.util;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@Beta
public final class BackOffUtils {
    public static boolean next(Sleeper sleeper, BackOff backOff) throws InterruptedException, IOException {
        long jNextBackOffMillis = backOff.nextBackOffMillis();
        if (jNextBackOffMillis == -1) {
            return false;
        }
        sleeper.sleep(jNextBackOffMillis);
        return true;
    }

    private BackOffUtils() {
    }
}
