package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfjr extends IOException {
    public zzfjr(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: a */
    static zzfjr m8705a() {
        return new zzfjr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: renamed from: b */
    static zzfjr m8706b() {
        return new zzfjr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: renamed from: c */
    static zzfjr m8707c() {
        return new zzfjr("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: renamed from: d */
    static zzfjr m8708d() {
        return new zzfjr("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
