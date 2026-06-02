package com.google.android.gms.location.places.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface zzs extends IInterface {
    /* JADX INFO: renamed from: a */
    void mo8802a(String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter, zzat zzatVar, zzw zzwVar) throws RemoteException;

    /* JADX INFO: renamed from: a */
    void mo8803a(List<String> list, zzat zzatVar, zzw zzwVar) throws RemoteException;
}
