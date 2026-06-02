package com.google.firebase.perf.metrics;

import com.google.android.gms.internal.zzewy;
import com.google.android.gms.internal.zzewz;
import com.google.android.gms.internal.zzexa;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zze {

    /* JADX INFO: renamed from: a */
    private final Trace f8754a;

    zze(Trace trace) {
        this.f8754a = trace;
    }

    /* JADX INFO: renamed from: a */
    final zzewy m9261a() {
        int i = 0;
        zzewy zzewyVar = new zzewy();
        zzewyVar.f7926a = this.f8754a.m9254a();
        zzewyVar.f7927b = Long.valueOf(this.f8754a.m9256c().m8601b());
        zzewyVar.f7928c = Long.valueOf(this.f8754a.m9256c().m8599a(this.f8754a.m9257d()));
        Map<String, zza> mapM9255b = this.f8754a.m9255b();
        if (!mapM9255b.isEmpty()) {
            zzewyVar.f7929d = new zzewz[mapM9255b.size()];
            int i2 = 0;
            for (String str : mapM9255b.keySet()) {
                zza zzaVar = mapM9255b.get(str);
                zzewz zzewzVar = new zzewz();
                zzewzVar.f7934a = str;
                zzewzVar.f7935b = Long.valueOf(zzaVar.m9259a());
                zzewyVar.f7929d[i2] = zzewzVar;
                i2++;
            }
        }
        List<Trace> listM9258h = this.f8754a.m9258h();
        if (!listM9258h.isEmpty()) {
            zzewyVar.f7930e = new zzewy[listM9258h.size()];
            Iterator<Trace> it = listM9258h.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                zzewyVar.f7930e[i3] = new zze(it.next()).m9261a();
                i3++;
            }
        }
        Map<String, String> attributes = this.f8754a.getAttributes();
        if (!attributes.isEmpty()) {
            zzewyVar.f7931f = new zzexa[attributes.size()];
            for (String str2 : attributes.keySet()) {
                String str3 = attributes.get(str2);
                zzexa zzexaVar = new zzexa();
                zzexaVar.f7937a = str2;
                zzexaVar.f7938b = str3;
                zzewyVar.f7931f[i] = zzexaVar;
                i++;
            }
        }
        return zzewyVar;
    }
}
