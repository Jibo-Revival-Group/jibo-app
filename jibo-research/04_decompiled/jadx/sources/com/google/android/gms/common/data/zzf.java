package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zzf implements Parcelable.Creator<DataHolder> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataHolder createFromParcel(Parcel parcel) {
        int iM7712f = 0;
        Bundle bundleM7724r = null;
        int iM7700a = zzbfn.m7700a(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArrM7732z = null;
        int iM7712f2 = 0;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    strArrM7732z = zzbfn.m7732z(parcel, i);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) zzbfn.m7707b(parcel, i, CursorWindow.CREATOR);
                    break;
                case 3:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 4:
                    bundleM7724r = zzbfn.m7724r(parcel, i);
                    break;
                case 1000:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        DataHolder dataHolder = new DataHolder(iM7712f2, strArrM7732z, cursorWindowArr, iM7712f, bundleM7724r);
        dataHolder.m7271a();
        return dataHolder;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataHolder[] newArray(int i) {
        return new DataHolder[i];
    }
}
