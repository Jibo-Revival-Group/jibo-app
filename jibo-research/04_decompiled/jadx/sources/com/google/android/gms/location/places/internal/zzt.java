package com.google.android.gms.location.places.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzt extends zzeu implements zzs {
    zzt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.places.internal.IGooglePlacesService");
    }

    @Override // com.google.android.gms.location.places.internal.zzs
    /* JADX INFO: renamed from: a */
    public final void mo8802a(String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter, zzat zzatVar, zzw zzwVar) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        parcelM8526c.writeString(str);
        zzew.m8576a(parcelM8526c, latLngBounds);
        zzew.m8576a(parcelM8526c, autocompleteFilter);
        zzew.m8576a(parcelM8526c, zzatVar);
        zzew.m8575a(parcelM8526c, zzwVar);
        m8525b(13, parcelM8526c);
    }

    @Override // com.google.android.gms.location.places.internal.zzs
    /* JADX INFO: renamed from: a */
    public final void mo8803a(List<String> list, zzat zzatVar, zzw zzwVar) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        parcelM8526c.writeStringList(list);
        zzew.m8576a(parcelM8526c, zzatVar);
        zzew.m8575a(parcelM8526c, zzwVar);
        m8525b(17, parcelM8526c);
    }
}
