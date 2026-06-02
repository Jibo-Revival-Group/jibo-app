package com.google.api.client.http;

import com.google.api.client.util.Beta;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@Beta
@Deprecated
public interface BackOffPolicy {
    public static final long STOP = -1;

    long getNextBackOffMillis() throws IOException;

    boolean isBackOffRequired(int i);

    void reset();
}
