package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzcle;

/* JADX INFO: loaded from: classes.dex */
public final class zzcla<T extends Context & zzcle> {

    /* JADX INFO: renamed from: a */
    private final T f7572a;

    public zzcla(T t) {
        zzbq.m7373a(t);
        this.f7572a = t;
    }

    /* JADX INFO: renamed from: a */
    private final void m8352a(Runnable runnable) {
        zzcim zzcimVarM8191a = zzcim.m8191a(this.f7572a);
        zzcimVarM8191a.m8233f();
        zzcimVarM8191a.m8235h().m8173a(new zzcld(this, zzcimVarM8191a, runnable));
    }

    /* JADX INFO: renamed from: a */
    public static boolean m8353a(Context context, boolean z) {
        zzbq.m7373a(context);
        return Build.VERSION.SDK_INT >= 24 ? zzclq.m8390a(context, "com.google.android.gms.measurement.AppMeasurementJobService") : zzclq.m8390a(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    /* JADX INFO: renamed from: c */
    private final zzchm m8354c() {
        return zzcim.m8191a(this.f7572a).m8233f();
    }

    /* JADX INFO: renamed from: a */
    public final int m8355a(final Intent intent, int i, final int i2) {
        final zzchm zzchmVarM8233f = zzcim.m8191a(this.f7572a).m8233f();
        if (intent == null) {
            zzchmVarM8233f.m8097A().m8108a("AppMeasurementService started with null intent");
        } else {
            String action = intent.getAction();
            zzchmVarM8233f.m8101E().m8110a("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                m8352a(new Runnable(this, i2, zzchmVarM8233f, intent) { // from class: com.google.android.gms.internal.zzclb

                    /* JADX INFO: renamed from: a */
                    private final zzcla f7573a;

                    /* JADX INFO: renamed from: b */
                    private final int f7574b;

                    /* JADX INFO: renamed from: c */
                    private final zzchm f7575c;

                    /* JADX INFO: renamed from: d */
                    private final Intent f7576d;

                    {
                        this.f7573a = this;
                        this.f7574b = i2;
                        this.f7575c = zzchmVarM8233f;
                        this.f7576d = intent;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7573a.m8358a(this.f7574b, this.f7575c, this.f7576d);
                    }
                });
            }
        }
        return 2;
    }

    /* JADX INFO: renamed from: a */
    public final IBinder m8356a(Intent intent) {
        if (intent == null) {
            m8354c().m8106y().m8108a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzcir(zzcim.m8191a(this.f7572a));
        }
        m8354c().m8097A().m8109a("onBind received unknown action", action);
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final void m8357a() {
        zzcim.m8191a(this.f7572a).m8233f().m8101E().m8108a("Local AppMeasurementService is starting up");
    }

    /* JADX INFO: renamed from: a */
    final /* synthetic */ void m8358a(int i, zzchm zzchmVar, Intent intent) {
        if (this.f7572a.mo8366a(i)) {
            zzchmVar.m8101E().m8109a("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            m8354c().m8101E().m8108a("Completed wakeful intent.");
            this.f7572a.mo8365a(intent);
        }
    }

    /* JADX INFO: renamed from: a */
    final /* synthetic */ void m8359a(zzchm zzchmVar, JobParameters jobParameters) {
        zzchmVar.m8101E().m8108a("AppMeasurementJobService processed last upload request.");
        this.f7572a.mo8364a(jobParameters, false);
    }

    @TargetApi(24)
    /* JADX INFO: renamed from: a */
    public final boolean m8360a(final JobParameters jobParameters) {
        final zzchm zzchmVarM8233f = zzcim.m8191a(this.f7572a).m8233f();
        String string = jobParameters.getExtras().getString(NativeProtocol.WEB_DIALOG_ACTION);
        zzchmVarM8233f.m8101E().m8109a("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        m8352a(new Runnable(this, zzchmVarM8233f, jobParameters) { // from class: com.google.android.gms.internal.zzclc

            /* JADX INFO: renamed from: a */
            private final zzcla f7577a;

            /* JADX INFO: renamed from: b */
            private final zzchm f7578b;

            /* JADX INFO: renamed from: c */
            private final JobParameters f7579c;

            {
                this.f7577a = this;
                this.f7578b = zzchmVarM8233f;
                this.f7579c = jobParameters;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f7577a.m8359a(this.f7578b, this.f7579c);
            }
        });
        return true;
    }

    /* JADX INFO: renamed from: b */
    public final void m8361b() {
        zzcim.m8191a(this.f7572a).m8233f().m8101E().m8108a("Local AppMeasurementService is shutting down");
    }

    /* JADX INFO: renamed from: b */
    public final boolean m8362b(Intent intent) {
        if (intent == null) {
            m8354c().m8106y().m8108a("onUnbind called with null intent");
        } else {
            m8354c().m8101E().m8109a("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }

    /* JADX INFO: renamed from: c */
    public final void m8363c(Intent intent) {
        if (intent == null) {
            m8354c().m8106y().m8108a("onRebind called with null intent");
        } else {
            m8354c().m8101E().m8109a("onRebind called. action", intent.getAction());
        }
    }
}
