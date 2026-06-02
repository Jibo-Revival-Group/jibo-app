package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;

/* JADX INFO: loaded from: classes.dex */
final class zzdh implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Result f6387a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzdg f6388b;

    zzdh(zzdg zzdgVar, Result result) {
        this.f6388b = zzdgVar;
        this.f6387a = result;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                BasePendingResult.f6140a.set(true);
                this.f6388b.f6385h.sendMessage(this.f6388b.f6385h.obtainMessage(0, this.f6388b.f6378a.m6931a(this.f6387a)));
                BasePendingResult.f6140a.set(false);
                zzdg zzdgVar = this.f6388b;
                zzdg.m7194b(this.f6387a);
                GoogleApiClient googleApiClient = (GoogleApiClient) this.f6388b.f6384g.get();
                if (googleApiClient != null) {
                    googleApiClient.mo6898b(this.f6388b);
                }
            } catch (RuntimeException e) {
                this.f6388b.f6385h.sendMessage(this.f6388b.f6385h.obtainMessage(1, e));
                BasePendingResult.f6140a.set(false);
                zzdg zzdgVar2 = this.f6388b;
                zzdg.m7194b(this.f6387a);
                GoogleApiClient googleApiClient2 = (GoogleApiClient) this.f6388b.f6384g.get();
                if (googleApiClient2 != null) {
                    googleApiClient2.mo6898b(this.f6388b);
                }
            }
        } finally {
        }
    }
}
