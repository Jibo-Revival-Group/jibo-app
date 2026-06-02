package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
final class zzh extends Handler {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzd f6620a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzh(zzd zzdVar, Looper looper) {
        super(looper);
        this.f6620a = zzdVar;
    }

    /* JADX INFO: renamed from: a */
    private static void m7444a(Message message) {
        ((zzi) message.obj).m7447c();
    }

    /* JADX INFO: renamed from: b */
    private static boolean m7445b(Message message) {
        return message.what == 2 || message.what == 1 || message.what == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.f6620a.f6593c.get() != message.arg1) {
            if (m7445b(message)) {
                m7444a(message);
                return;
            }
            return;
        }
        if ((message.what == 1 || message.what == 7 || message.what == 4 || message.what == 5) && !this.f6620a.m7430h()) {
            m7444a(message);
            return;
        }
        if (message.what == 4) {
            this.f6620a.f6615y = new ConnectionResult(message.arg2);
            if (this.f6620a.m7416x() && !this.f6620a.f6616z) {
                this.f6620a.m7402a(3, (IInterface) null);
                return;
            }
            ConnectionResult connectionResult = this.f6620a.f6615y != null ? this.f6620a.f6615y : new ConnectionResult(8);
            this.f6620a.f6592b.mo7054a(connectionResult);
            this.f6620a.m7422a(connectionResult);
            return;
        }
        if (message.what == 5) {
            ConnectionResult connectionResult2 = this.f6620a.f6615y != null ? this.f6620a.f6615y : new ConnectionResult(8);
            this.f6620a.f6592b.mo7054a(connectionResult2);
            this.f6620a.m7422a(connectionResult2);
            return;
        }
        if (message.what == 3) {
            ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, message.obj instanceof PendingIntent ? (PendingIntent) message.obj : null);
            this.f6620a.f6592b.mo7054a(connectionResult3);
            this.f6620a.m7422a(connectionResult3);
            return;
        }
        if (message.what == 6) {
            this.f6620a.m7402a(5, (IInterface) null);
            if (this.f6620a.f6611u != null) {
                this.f6620a.f6611u.mo7315a(message.arg2);
            }
            this.f6620a.m7418a(message.arg2);
            this.f6620a.m7405a(5, 1, (IInterface) null);
            return;
        }
        if (message.what == 2 && !this.f6620a.m7429g()) {
            m7444a(message);
        } else if (m7445b(message)) {
            ((zzi) message.obj).m7446b();
        } else {
            Log.wtf("GmsClient", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
        }
    }
}
