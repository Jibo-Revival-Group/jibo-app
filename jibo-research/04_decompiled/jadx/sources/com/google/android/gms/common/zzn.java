package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzau;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class zzn extends zzbfm {
    public static final Parcelable.Creator<zzn> CREATOR = new zzo();

    /* JADX INFO: renamed from: a */
    private final String f6713a;

    /* JADX INFO: renamed from: b */
    private final zzh f6714b;

    /* JADX INFO: renamed from: c */
    private final boolean f6715c;

    zzn(String str, IBinder iBinder, boolean z) {
        this.f6713a = str;
        this.f6714b = m7544a(iBinder);
        this.f6715c = z;
    }

    zzn(String str, zzh zzhVar, boolean z) {
        this.f6713a = str;
        this.f6714b = zzhVar;
        this.f6715c = z;
    }

    /* JADX INFO: renamed from: a */
    private static zzh m7544a(IBinder iBinder) {
        zzi zziVar;
        if (iBinder == null) {
            return null;
        }
        try {
            IObjectWrapper iObjectWrapperMo7358a = zzau.m7360a(iBinder).mo7358a();
            byte[] bArr = iObjectWrapperMo7358a == null ? null : (byte[]) com.google.android.gms.dynamic.zzn.m7554a(iObjectWrapperMo7358a);
            if (bArr != null) {
                zziVar = new zzi(bArr);
            } else {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                zziVar = null;
            }
            return zziVar;
        } catch (RemoteException e) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinderAsBinder;
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 1, this.f6713a, false);
        if (this.f6714b == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            iBinderAsBinder = null;
        } else {
            iBinderAsBinder = this.f6714b.asBinder();
        }
        zzbfp.m7741a(parcel, 2, iBinderAsBinder, false);
        zzbfp.m7751a(parcel, 3, this.f6715c);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
