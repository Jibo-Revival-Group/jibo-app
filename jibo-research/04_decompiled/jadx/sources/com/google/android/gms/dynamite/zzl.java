package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

/* JADX INFO: loaded from: classes.dex */
public final class zzl extends zzeu implements zzk {
    zzl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // com.google.android.gms.dynamite.zzk
    /* JADX INFO: renamed from: a */
    public final int mo7572a(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8575a(parcelM8526c, iObjectWrapper);
        parcelM8526c.writeString(str);
        zzew.m8577a(parcelM8526c, z);
        Parcel parcelM8524a = m8524a(3, parcelM8526c);
        int i = parcelM8524a.readInt();
        parcelM8524a.recycle();
        return i;
    }

    @Override // com.google.android.gms.dynamite.zzk
    /* JADX INFO: renamed from: a */
    public final IObjectWrapper mo7573a(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8575a(parcelM8526c, iObjectWrapper);
        parcelM8526c.writeString(str);
        parcelM8526c.writeInt(i);
        Parcel parcelM8524a = m8524a(2, parcelM8526c);
        IObjectWrapper iObjectWrapperM7552a = IObjectWrapper.zza.m7552a(parcelM8524a.readStrongBinder());
        parcelM8524a.recycle();
        return iObjectWrapperM7552a;
    }
}
