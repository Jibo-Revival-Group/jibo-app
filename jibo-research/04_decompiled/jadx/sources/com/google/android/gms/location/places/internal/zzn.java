package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzn extends com.google.android.gms.common.internal.zzab<zzs> {

    /* JADX INFO: renamed from: d */
    private final zzat f8209d;

    private zzn(Context context, Looper looper, com.google.android.gms.common.internal.zzr zzrVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, PlacesOptions placesOptions) {
        super(context, looper, 65, zzrVar, connectionCallbacks, onConnectionFailedListener);
        this.f8209d = new zzat(str, Locale.getDefault(), zzrVar.m7452b() != null ? zzrVar.m7452b().name : null, null, 0);
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: a */
    protected final /* synthetic */ IInterface mo6768a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        return iInterfaceQueryLocalInterface instanceof zzs ? (zzs) iInterfaceQueryLocalInterface : new zzt(iBinder);
    }

    /* JADX INFO: renamed from: a */
    public final void m8800a(com.google.android.gms.location.places.zzm zzmVar, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) throws RemoteException {
        zzbq.m7374a(zzmVar, "callback == null");
        ((zzs) m7439v()).mo8802a(str == null ? "" : str, latLngBounds, autocompleteFilter == null ? new AutocompleteFilter.Builder().m8759a() : autocompleteFilter, this.f8209d, zzmVar);
    }

    /* JADX INFO: renamed from: a */
    public final void m8801a(com.google.android.gms.location.places.zzm zzmVar, List<String> list) throws RemoteException {
        zzbq.m7374a(zzmVar, "callback == null");
        ((zzs) m7439v()).mo8803a(list, this.f8209d, zzmVar);
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: b */
    protected final String mo6769b() {
        return "com.google.android.gms.location.places.internal.IGooglePlacesService";
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: b_ */
    protected final String mo6770b_() {
        return "com.google.android.gms.location.places.GeoDataApi";
    }
}
