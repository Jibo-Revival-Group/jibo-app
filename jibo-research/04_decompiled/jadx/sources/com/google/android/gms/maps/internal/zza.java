package com.google.android.gms.maps.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zza {
    /* JADX INFO: renamed from: a */
    public static byte m8841a(Boolean bool) {
        if (bool != null) {
            return bool.booleanValue() ? (byte) 1 : (byte) 0;
        }
        return (byte) -1;
    }

    /* JADX INFO: renamed from: a */
    public static Boolean m8842a(byte b) {
        switch (b) {
            case 0:
                return Boolean.FALSE;
            case 1:
                return Boolean.TRUE;
            default:
                return null;
        }
    }
}
