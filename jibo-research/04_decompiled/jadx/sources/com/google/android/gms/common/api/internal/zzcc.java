package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public interface zzcc {
    /* JADX INFO: renamed from: a */
    <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T mo6990a(T t);

    /* JADX INFO: renamed from: a */
    void mo6991a();

    /* JADX INFO: renamed from: a */
    void mo6992a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    /* JADX INFO: renamed from: a */
    boolean mo6993a(zzcu zzcuVar);

    /* JADX INFO: renamed from: b */
    ConnectionResult mo6994b();

    /* JADX INFO: renamed from: b */
    <A extends Api.zzb, T extends zzm<? extends Result, A>> T mo6995b(T t);

    /* JADX INFO: renamed from: c */
    void mo6996c();

    /* JADX INFO: renamed from: d */
    boolean mo6997d();

    /* JADX INFO: renamed from: f */
    void mo6999f();

    /* JADX INFO: renamed from: g */
    void mo7000g();
}
