package com.google.android.gms.maps.model.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.maps.model.Tile;

/* JADX INFO: loaded from: classes.dex */
public final class zzab extends zzeu implements zzz {
    zzab(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }

    @Override // com.google.android.gms.maps.model.internal.zzz
    /* JADX INFO: renamed from: a */
    public final Tile mo8915a(int i, int i2, int i3) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        parcelM8526c.writeInt(i);
        parcelM8526c.writeInt(i2);
        parcelM8526c.writeInt(i3);
        Parcel parcelM8524a = m8524a(1, parcelM8526c);
        Tile tile = (Tile) zzew.m8574a(parcelM8524a, Tile.CREATOR);
        parcelM8524a.recycle();
        return tile;
    }
}
