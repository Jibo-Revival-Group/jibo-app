package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzat;
import com.google.android.gms.common.internal.zzau;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
abstract class zzh extends zzau {

    /* JADX INFO: renamed from: a */
    private int f6708a;

    protected zzh(byte[] bArr) {
        if (bArr.length != 25) {
            int length = bArr.length;
            String strM7506a = com.google.android.gms.common.util.zzl.m7506a(bArr, 0, bArr.length, false);
            Log.wtf("GoogleCertificates", new StringBuilder(String.valueOf(strM7506a).length() + 51).append("Cert hash data has incorrect length (").append(length).append("):\n").append(strM7506a).toString(), new Exception());
            bArr = Arrays.copyOfRange(bArr, 0, 25);
            zzbq.m7383b(bArr.length == 25, new StringBuilder(55).append("cert hash data has incorrect length. length=").append(bArr.length).toString());
        }
        this.f6708a = Arrays.hashCode(bArr);
    }

    /* JADX INFO: renamed from: a */
    protected static byte[] m7541a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.android.gms.common.internal.zzat
    /* JADX INFO: renamed from: a */
    public final IObjectWrapper mo7358a() {
        return com.google.android.gms.dynamic.zzn.m7553a(mo7542c());
    }

    @Override // com.google.android.gms.common.internal.zzat
    /* JADX INFO: renamed from: b */
    public final int mo7359b() {
        return hashCode();
    }

    /* JADX INFO: renamed from: c */
    abstract byte[] mo7542c();

    public boolean equals(Object obj) {
        IObjectWrapper iObjectWrapperMo7358a;
        if (obj == null || !(obj instanceof zzat)) {
            return false;
        }
        try {
            zzat zzatVar = (zzat) obj;
            if (zzatVar.mo7359b() == hashCode() && (iObjectWrapperMo7358a = zzatVar.mo7358a()) != null) {
                return Arrays.equals(mo7542c(), (byte[]) com.google.android.gms.dynamic.zzn.m7554a(iObjectWrapperMo7358a));
            }
            return false;
        } catch (RemoteException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            return false;
        }
    }

    public int hashCode() {
        return this.f6708a;
    }
}
