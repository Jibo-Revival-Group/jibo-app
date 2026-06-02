package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;

/* JADX INFO: loaded from: classes.dex */
public interface zzbh {
    /* JADX INFO: renamed from: a */
    <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T mo7014a(T t);

    /* JADX INFO: renamed from: a */
    void mo7015a();

    /* JADX INFO: renamed from: a */
    void mo7016a(int i);

    /* JADX INFO: renamed from: a */
    void mo7017a(Bundle bundle);

    /* JADX INFO: renamed from: a */
    void mo7018a(ConnectionResult connectionResult, Api<?> api, boolean z);

    /* JADX INFO: renamed from: b */
    <A extends Api.zzb, T extends zzm<? extends Result, A>> T mo7019b(T t);

    /* JADX INFO: renamed from: b */
    boolean mo7020b();

    /* JADX INFO: renamed from: c */
    void mo7021c();
}
