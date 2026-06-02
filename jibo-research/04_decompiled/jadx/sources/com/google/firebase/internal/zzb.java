package com.google.firebase.internal;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzb {

    /* JADX INFO: renamed from: a */
    private static final AtomicReference<zzb> f8707a = new AtomicReference<>();

    private zzb(Context context) {
    }

    /* JADX INFO: renamed from: a */
    public static zzb m9191a(Context context) {
        f8707a.compareAndSet(null, new zzb(context));
        return f8707a.get();
    }

    /* JADX INFO: renamed from: a */
    public static void m9192a(FirebaseApp firebaseApp) {
    }
}
