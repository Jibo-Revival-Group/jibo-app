package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
public enum zzewl {
    TRACE_EVENT_RATE_LIMITED("_fstec"),
    NETWORK_TRACE_EVENT_RATE_LIMITED("_fsntc"),
    TRACE_STARTED_NOT_STOPPED("_tsns");

    private String mName;

    zzewl(String str) {
        this.mName = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.mName;
    }
}
