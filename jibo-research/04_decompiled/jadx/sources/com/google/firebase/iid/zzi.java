package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzi {

    /* JADX INFO: renamed from: a */
    private static zzi f8659a;

    /* JADX INFO: renamed from: b */
    private final Context f8660b;

    /* JADX INFO: renamed from: c */
    private final ScheduledExecutorService f8661c;

    /* JADX INFO: renamed from: d */
    private zzk f8662d = new zzk(this);

    /* JADX INFO: renamed from: e */
    private int f8663e = 1;

    private zzi(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f8661c = scheduledExecutorService;
        this.f8660b = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: a */
    private final synchronized int m9133a() {
        int i;
        i = this.f8663e;
        this.f8663e = i + 1;
        return i;
    }

    /* JADX INFO: renamed from: a */
    private final synchronized <T> Task<T> m9135a(zzr<T> zzrVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(zzrVar);
            Log.d("MessengerIpcClient", new StringBuilder(String.valueOf(strValueOf).length() + 9).append("Queueing ").append(strValueOf).toString());
        }
        if (!this.f8662d.m9146a(zzrVar)) {
            this.f8662d = new zzk(this);
            this.f8662d.m9146a(zzrVar);
        }
        return zzrVar.f8678b.m8933a();
    }

    /* JADX INFO: renamed from: a */
    public static synchronized zzi m9136a(Context context) {
        if (f8659a == null) {
            f8659a = new zzi(context, Executors.newSingleThreadScheduledExecutor());
        }
        return f8659a;
    }

    /* JADX INFO: renamed from: a */
    public final Task<Void> m9138a(int i, Bundle bundle) {
        return m9135a(new zzq(m9133a(), 2, bundle));
    }

    /* JADX INFO: renamed from: b */
    public final Task<Bundle> m9139b(int i, Bundle bundle) {
        return m9135a(new zzt(m9133a(), 1, bundle));
    }
}
