package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
public enum zzewm {
    APP_START_TRACE_NAME("_as"),
    ON_CREATE_TRACE_NAME("_astui"),
    ON_START_TRACE_NAME("_astfd"),
    ON_RESUME_TRACE_NAME("_asti"),
    FOREGROUND_TRACE_NAME("_fs"),
    BACKGROUND_TRACE_NAME("_bs");

    private String mName;

    zzewm(String str) {
        this.mName = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.mName;
    }
}
