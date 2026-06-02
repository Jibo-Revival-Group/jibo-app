package com.google.android.gms.common.util;

import android.util.Base64;

/* JADX INFO: loaded from: classes.dex */
public final class zzb {
    /* JADX INFO: renamed from: a */
    public static String m7493a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }

    /* JADX INFO: renamed from: b */
    public static String m7494b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 10);
    }
}
