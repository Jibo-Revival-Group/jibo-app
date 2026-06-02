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
final class zzac implements OnCompleteListener<Map<zzh<?>, String>> {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzaa f6177a;

    private zzac(zzaa zzaaVar) {
        this.f6177a = zzaaVar;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    /* JADX INFO: renamed from: a */
    public final void mo7001a(Task<Map<zzh<?>, String>> task) {
        this.f6177a.f6164f.lock();
        try {
            if (this.f6177a.f6172n) {
                if (task.mo8930b()) {
                    this.f6177a.f6173o = new ArrayMap(this.f6177a.f6159a.size());
                    Iterator it = this.f6177a.f6159a.values().iterator();
                    while (it.hasNext()) {
                        this.f6177a.f6173o.put(((zzz) it.next()).m6877b(), ConnectionResult.f6064a);
                    }
                } else if (task.mo8932d() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) task.mo8932d();
                    if (this.f6177a.f6170l) {
                        this.f6177a.f6173o = new ArrayMap(this.f6177a.f6159a.size());
                        for (zzz zzzVar : this.f6177a.f6159a.values()) {
                            Object objM6877b = zzzVar.m6877b();
                            ConnectionResult connectionResultM6869a = availabilityException.m6869a(zzzVar);
                            if (this.f6177a.m6970a((zzz<?>) zzzVar, connectionResultM6869a)) {
                                this.f6177a.f6173o.put(objM6877b, new ConnectionResult(16));
                            } else {
                                this.f6177a.f6173o.put(objM6877b, connectionResultM6869a);
                            }
                        }
                    } else {
                        this.f6177a.f6173o = availabilityException.m6868a();
                    }
                    this.f6177a.f6176r = this.f6177a.m6985k();
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", task.mo8932d());
                    this.f6177a.f6173o = Collections.emptyMap();
                    this.f6177a.f6176r = new ConnectionResult(8);
                }
                if (this.f6177a.f6174p != null) {
                    this.f6177a.f6173o.putAll(this.f6177a.f6174p);
                    this.f6177a.f6176r = this.f6177a.m6985k();
                }
                if (this.f6177a.f6176r == null) {
                    this.f6177a.m6981i();
                    this.f6177a.m6983j();
                } else {
                    zzaa.m6969a(this.f6177a, false);
                    this.f6177a.f6163e.mo7071a(this.f6177a.f6176r);
                }
                this.f6177a.f6167i.signalAll();
            }
        } finally {
            this.f6177a.f6164f.unlock();
        }
    }
}
