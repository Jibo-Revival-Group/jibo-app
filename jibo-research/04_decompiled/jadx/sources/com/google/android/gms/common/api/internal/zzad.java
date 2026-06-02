package com.google.android.gms.common.api.internal;

import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzad implements OnCompleteListener<Map<zzh<?>, String>> {

    /* JADX INFO: renamed from: a */
    private zzcu f6178a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzaa f6179b;

    zzad(zzaa zzaaVar, zzcu zzcuVar) {
        this.f6179b = zzaaVar;
        this.f6178a = zzcuVar;
    }

    /* JADX INFO: renamed from: a */
    final void m7002a() {
        this.f6178a.mo6767h();
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    /* JADX INFO: renamed from: a */
    public final void mo7001a(Task<Map<zzh<?>, String>> task) {
        this.f6179b.f6164f.lock();
        try {
            if (!this.f6179b.f6172n) {
                this.f6178a.mo6767h();
                return;
            }
            if (task.mo8930b()) {
                this.f6179b.f6174p = new ArrayMap(this.f6179b.f6160b.size());
                Iterator it = this.f6179b.f6160b.values().iterator();
                while (it.hasNext()) {
                    this.f6179b.f6174p.put(((zzz) it.next()).m6877b(), ConnectionResult.f6064a);
                }
            } else if (task.mo8932d() instanceof AvailabilityException) {
                AvailabilityException availabilityException = (AvailabilityException) task.mo8932d();
                if (this.f6179b.f6170l) {
                    this.f6179b.f6174p = new ArrayMap(this.f6179b.f6160b.size());
                    for (zzz zzzVar : this.f6179b.f6160b.values()) {
                        Object objM6877b = zzzVar.m6877b();
                        ConnectionResult connectionResultM6869a = availabilityException.m6869a(zzzVar);
                        if (this.f6179b.m6970a((zzz<?>) zzzVar, connectionResultM6869a)) {
                            this.f6179b.f6174p.put(objM6877b, new ConnectionResult(16));
                        } else {
                            this.f6179b.f6174p.put(objM6877b, connectionResultM6869a);
                        }
                    }
                } else {
                    this.f6179b.f6174p = availabilityException.m6868a();
                }
            } else {
                Log.e("ConnectionlessGAC", "Unexpected availability exception", task.mo8932d());
                this.f6179b.f6174p = Collections.emptyMap();
            }
            if (this.f6179b.mo6997d()) {
                this.f6179b.f6173o.putAll(this.f6179b.f6174p);
                if (this.f6179b.m6985k() == null) {
                    this.f6179b.m6981i();
                    this.f6179b.m6983j();
                    this.f6179b.f6167i.signalAll();
                }
            }
            this.f6178a.mo6767h();
        } finally {
            this.f6179b.f6164f.unlock();
        }
    }
}
