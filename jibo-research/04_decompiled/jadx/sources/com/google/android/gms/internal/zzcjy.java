package com.google.android.gms.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
final class zzcjy implements Callable<String> {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcjn f7487a;

    zzcjy(zzcjn zzcjnVar) {
        this.f7487a = zzcjnVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        String strM8133z = this.f7487a.mo7873u().m8133z();
        if (strM8133z == null) {
            zzcjn zzcjnVarMo7858f = this.f7487a.mo7858f();
            if (zzcjnVarMo7858f.mo7871s().m8176z()) {
                zzcjnVarMo7858f.mo7872t().m8106y().m8108a("Cannot retrieve app instance id from analytics worker thread");
                strM8133z = null;
            } else {
                zzcjnVarMo7858f.mo7871s();
                if (zzcih.m8170y()) {
                    zzcjnVarMo7858f.mo7872t().m8106y().m8108a("Cannot retrieve app instance id from main thread");
                    strM8133z = null;
                } else {
                    long jMo7497b = zzcjnVarMo7858f.mo7863k().mo7497b();
                    strM8133z = zzcjnVarMo7858f.m8300c(120000L);
                    long jMo7497b2 = zzcjnVarMo7858f.mo7863k().mo7497b() - jMo7497b;
                    if (strM8133z == null && jMo7497b2 < 120000) {
                        strM8133z = zzcjnVarMo7858f.m8300c(120000 - jMo7497b2);
                    }
                }
            }
            if (strM8133z == null) {
                throw new TimeoutException();
            }
            this.f7487a.mo7873u().m8131d(strM8133z);
        }
        return strM8133z;
    }
}
