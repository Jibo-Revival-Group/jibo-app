package com.google.android.gms.tasks;

/* JADX INFO: loaded from: classes.dex */
public class TaskCompletionSource<TResult> {

    /* JADX INFO: renamed from: a */
    private final zzn<TResult> f8403a = new zzn<>();

    /* JADX INFO: renamed from: a */
    public Task<TResult> m8933a() {
        return this.f8403a;
    }

    /* JADX INFO: renamed from: a */
    public void m8934a(Exception exc) {
        this.f8403a.m8959a(exc);
    }

    /* JADX INFO: renamed from: a */
    public void m8935a(TResult tresult) {
        this.f8403a.m8960a(tresult);
    }

    /* JADX INFO: renamed from: b */
    public boolean m8936b(Exception exc) {
        return this.f8403a.m8961b(exc);
    }

    /* JADX INFO: renamed from: b */
    public boolean m8937b(TResult tresult) {
        return this.f8403a.m8962b(tresult);
    }
}
