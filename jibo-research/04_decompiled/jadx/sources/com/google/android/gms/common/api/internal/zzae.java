package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzae {

    /* JADX INFO: renamed from: a */
    private final Map<BasePendingResult<?>, Boolean> f6180a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: b */
    private final Map<TaskCompletionSource<?>, Boolean> f6181b = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: a */
    private final void m7004a(boolean z, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (this.f6180a) {
            map = new HashMap(this.f6180a);
        }
        synchronized (this.f6181b) {
            map2 = new HashMap(this.f6181b);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).m6944b(status);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).m8936b((Exception) new ApiException(status));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    final void m7005a(BasePendingResult<? extends Result> basePendingResult, boolean z) {
        this.f6180a.put(basePendingResult, Boolean.valueOf(z));
        basePendingResult.mo6919a(new zzaf(this, basePendingResult));
    }

    /* JADX INFO: renamed from: a */
    final boolean m7006a() {
        return (this.f6180a.isEmpty() && this.f6181b.isEmpty()) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    public final void m7007b() {
        m7004a(false, zzbm.f6284a);
    }

    /* JADX INFO: renamed from: c */
    public final void m7008c() {
        m7004a(true, zzdj.f6390a);
    }
}
