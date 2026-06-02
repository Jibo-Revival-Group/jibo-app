package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzcba extends zzeu implements zzcay {
    zzcba(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.flags.IFlagProvider");
    }

    @Override // com.google.android.gms.internal.zzcay
    public final boolean getBooleanFlagValue(String str, boolean z, int i) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        parcelM8526c.writeString(str);
        zzew.m8577a(parcelM8526c, z);
        parcelM8526c.writeInt(i);
        Parcel parcelM8524a = m8524a(2, parcelM8526c);
        boolean zM8578a = zzew.m8578a(parcelM8524a);
        parcelM8524a.recycle();
        return zM8578a;
    }

    @Override // com.google.android.gms.internal.zzcay
    public final int getIntFlagValue(String str, int i, int i2) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        parcelM8526c.writeString(str);
        parcelM8526c.writeInt(i);
        parcelM8526c.writeInt(i2);
        Parcel parcelM8524a = m8524a(3, parcelM8526c);
        int i3 = parcelM8524a.readInt();
        parcelM8524a.recycle();
        return i3;
    }

    @Override // com.google.android.gms.internal.zzcay
    public final long getLongFlagValue(String str, long j, int i) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        parcelM8526c.writeString(str);
        parcelM8526c.writeLong(j);
        parcelM8526c.writeInt(i);
        Parcel parcelM8524a = m8524a(4, parcelM8526c);
        long j2 = parcelM8524a.readLong();
        parcelM8524a.recycle();
        return j2;
    }

    @Override // com.google.android.gms.internal.zzcay
    public final String getStringFlagValue(String str, String str2, int i) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        parcelM8526c.writeString(str);
        parcelM8526c.writeString(str2);
        parcelM8526c.writeInt(i);
        Parcel parcelM8524a = m8524a(5, parcelM8526c);
        String string = parcelM8524a.readString();
        parcelM8524a.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.zzcay
    public final void init(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8575a(parcelM8526c, iObjectWrapper);
        m8525b(1, parcelM8526c);
    }
}
