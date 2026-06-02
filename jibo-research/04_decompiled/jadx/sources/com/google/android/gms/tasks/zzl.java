package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
final class zzl<TResult> {

    /* JADX INFO: renamed from: a */
    private final Object f8423a = new Object();

    /* JADX INFO: renamed from: b */
    private Queue<zzk<TResult>> f8424b;

    /* JADX INFO: renamed from: c */
    private boolean f8425c;

    zzl() {
    }

    /* JADX INFO: renamed from: a */
    public final void m8954a(Task<TResult> task) {
        zzk<TResult> zzkVarPoll;
        synchronized (this.f8423a) {
            if (this.f8424b == null || this.f8425c) {
                return;
            }
            this.f8425c = true;
            while (true) {
                synchronized (this.f8423a) {
                    zzkVarPoll = this.f8424b.poll();
                    if (zzkVarPoll == null) {
                        this.f8425c = false;
                        return;
                    }
                }
                zzkVarPoll.mo8949a(task);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8955a(zzk<TResult> zzkVar) {
        synchronized (this.f8423a) {
            if (this.f8424b == null) {
                this.f8424b = new ArrayDeque();
            }
            this.f8424b.add(zzkVar);
        }
    }
}
