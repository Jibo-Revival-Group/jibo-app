package com.google.android.gms.location.places.internal;

import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzbfq;
import com.google.android.gms.internal.zzbfr;
import com.google.android.gms.internal.zzdmz;
import com.google.android.gms.internal.zzfjr;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzav extends com.google.android.gms.common.data.zzc {
    public zzav(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    /* JADX INFO: renamed from: a */
    private final byte[] m8790a(String str, byte[] bArr) {
        if (!m7283a(str) || m7288f(str)) {
            return null;
        }
        return m7287e(str);
    }

    /* JADX INFO: renamed from: a */
    protected final float m8791a(String str, float f) {
        return (!m7283a(str) || m7288f(str)) ? f : m7286d(str);
    }

    /* JADX INFO: renamed from: a */
    protected final int m8792a(String str, int i) {
        return (!m7283a(str) || m7288f(str)) ? i : m7284b(str);
    }

    /* JADX INFO: renamed from: a */
    protected final <E extends zzbfq> E m8793a(String str, Parcelable.Creator<E> creator) {
        byte[] bArrM8790a = m8790a(str, (byte[]) null);
        if (bArrM8790a == null) {
            return null;
        }
        return (E) zzbfr.m7764a(bArrM8790a, creator);
    }

    /* JADX INFO: renamed from: a */
    protected final String m8794a(String str, String str2) {
        return (!m7283a(str) || m7288f(str)) ? str2 : m7285c(str);
    }

    /* JADX INFO: renamed from: a */
    protected final <E extends zzbfq> List<E> m8795a(String str, Parcelable.Creator<E> creator, List<E> list) {
        byte[] bArrM8790a = m8790a(str, (byte[]) null);
        if (bArrM8790a == null) {
            return list;
        }
        try {
            zzdmz zzdmzVarM8523a = zzdmz.m8523a(bArrM8790a);
            if (zzdmzVarM8523a.f7812c == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList(zzdmzVarM8523a.f7812c.length);
            byte[][] bArr = zzdmzVarM8523a.f7812c;
            for (byte[] bArr2 : bArr) {
                arrayList.add(zzbfr.m7764a(bArr2, creator));
            }
            return arrayList;
        } catch (zzfjr e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    /* JADX INFO: renamed from: a */
    protected final List<Integer> m8796a(String str, List<Integer> list) {
        byte[] bArrM8790a = m8790a(str, (byte[]) null);
        if (bArrM8790a == null) {
            return list;
        }
        try {
            zzdmz zzdmzVarM8523a = zzdmz.m8523a(bArrM8790a);
            if (zzdmzVarM8523a.f7811b == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList(zzdmzVarM8523a.f7811b.length);
            for (int i = 0; i < zzdmzVarM8523a.f7811b.length; i++) {
                arrayList.add(Integer.valueOf(zzdmzVarM8523a.f7811b[i]));
            }
            return arrayList;
        } catch (zzfjr e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }
}
