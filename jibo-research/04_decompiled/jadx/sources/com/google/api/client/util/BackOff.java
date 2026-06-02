package com.google.api.client.util;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface BackOff {
    public static final long STOP = -1;
    public static final BackOff ZERO_BACKOFF = new BackOff() { // from class: com.google.api.client.util.BackOff.1
        @Override // com.google.api.client.util.BackOff
        public void reset() throws IOException {
        }

        @Override // com.google.api.client.util.BackOff
        public long nextBackOffMillis() throws IOException {
            return 0L;
        }
    };
    public static final BackOff STOP_BACKOFF = new BackOff() { // from class: com.google.api.client.util.BackOff.2
        @Override // com.google.api.client.util.BackOff
        public void reset() throws IOException {
        }

        @Override // com.google.api.client.util.BackOff
        public long nextBackOffMillis() throws IOException {
            return -1L;
        }
    };

    long nextBackOffMillis() throws IOException;

    void reset() throws IOException;
}
