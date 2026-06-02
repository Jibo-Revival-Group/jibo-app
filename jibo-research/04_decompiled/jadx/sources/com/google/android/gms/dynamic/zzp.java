package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzp<T> {

    /* JADX INFO: renamed from: a */
    private final String f6721a;

    /* JADX INFO: renamed from: b */
    private T f6722b;

    protected zzp(String str) {
        this.f6721a = str;
    }

    /* JADX INFO: renamed from: a */
    protected final T m7555a(Context context) throws zzq {
        if (this.f6722b == null) {
            zzbq.m7373a(context);
            Context remoteContext = com.google.android.gms.common.zzp.getRemoteContext(context);
            if (remoteContext == null) {
                throw new zzq("Could not get remote context.");
            }
            try {
                this.f6722b = mo7392a((IBinder) remoteContext.getClassLoader().loadClass(this.f6721a).newInstance());
            } catch (ClassNotFoundException e) {
                throw new zzq("Could not load creator class.", e);
            } catch (IllegalAccessException e2) {
                throw new zzq("Could not access creator.", e2);
            } catch (InstantiationException e3) {
                throw new zzq("Could not instantiate creator.", e3);
            }
        }
        return this.f6722b;
    }

    /* JADX INFO: renamed from: a */
    protected abstract T mo7392a(IBinder iBinder);
}
