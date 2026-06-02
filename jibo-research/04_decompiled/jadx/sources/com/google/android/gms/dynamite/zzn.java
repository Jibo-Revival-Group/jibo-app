package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

/* JADX INFO: loaded from: classes.dex */
public final class zzn extends zzeu implements zzm {
    zzn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    @Override // com.google.android.gms.dynamite.zzm
    /* JADX INFO: renamed from: a */
    public final IObjectWrapper mo7574a(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8575a(parcelM8526c, iObjectWrapper);
        parcelM8526c.writeString(str);
        parcelM8526c.writeInt(i);
        zzew.m8575a(parcelM8526c, iObjectWrapper2);
        Parcel parcelM8524a = m8524a(2, parcelM8526c);
        IObjectWrapper iObjectWrapperM7552a = IObjectWrapper.zza.m7552a(parcelM8524a.readStrongBinder());
        parcelM8524a.recycle();
        return iObjectWrapperM7552a;
    }
}
