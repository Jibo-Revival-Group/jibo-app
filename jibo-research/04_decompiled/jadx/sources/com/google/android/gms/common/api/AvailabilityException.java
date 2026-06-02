package com.google.android.gms.common.api;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.internal.zzbq;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AvailabilityException extends Exception {

    /* JADX INFO: renamed from: a */
    private final ArrayMap<zzh<?>, ConnectionResult> f6092a;

    public AvailabilityException(ArrayMap<zzh<?>, ConnectionResult> arrayMap) {
        this.f6092a = arrayMap;
    }

    /* JADX INFO: renamed from: a */
    public final ArrayMap<zzh<?>, ConnectionResult> m6868a() {
        return this.f6092a;
    }

    /* JADX INFO: renamed from: a */
    public ConnectionResult m6869a(GoogleApi<? extends Api.ApiOptions> googleApi) {
        Object objM6877b = googleApi.m6877b();
        zzbq.m7383b(this.f6092a.get(objM6877b) != null, "The given API was not part of the availability request.");
        return this.f6092a.get(objM6877b);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (zzh<?> zzhVar : this.f6092a.keySet()) {
            ConnectionResult connectionResult = this.f6092a.get(zzhVar);
            if (connectionResult.m6821b()) {
                z = false;
            }
            String strM7210a = zzhVar.m7210a();
            String strValueOf = String.valueOf(connectionResult);
            arrayList.add(new StringBuilder(String.valueOf(strM7210a).length() + 2 + String.valueOf(strValueOf).length()).append(strM7210a).append(": ").append(strValueOf).toString());
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("None of the queried APIs are available. ");
        } else {
            sb.append("Some of the queried APIs are unavailable. ");
        }
        sb.append(TextUtils.join("; ", arrayList));
        return sb.toString();
    }
}
