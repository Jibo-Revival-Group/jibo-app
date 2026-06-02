package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import com.google.android.gms.common.api.zze;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
final class zzdl implements IBinder.DeathRecipient, zzdm {

    /* JADX INFO: renamed from: a */
    private final WeakReference<BasePendingResult<?>> f6396a;

    /* JADX INFO: renamed from: b */
    private final WeakReference<zze> f6397b;

    /* JADX INFO: renamed from: c */
    private final WeakReference<IBinder> f6398c;

    private zzdl(BasePendingResult<?> basePendingResult, zze zzeVar, IBinder iBinder) {
        this.f6397b = new WeakReference<>(zzeVar);
        this.f6396a = new WeakReference<>(basePendingResult);
        this.f6398c = new WeakReference<>(iBinder);
    }

    /* synthetic */ zzdl(BasePendingResult basePendingResult, zze zzeVar, IBinder iBinder, zzdk zzdkVar) {
        this(basePendingResult, null, iBinder);
    }

    /* JADX INFO: renamed from: a */
    private final void m7206a() {
        BasePendingResult<?> basePendingResult = this.f6396a.get();
        zze zzeVar = this.f6397b.get();
        if (zzeVar != null && basePendingResult != null) {
            zzeVar.m7260a(basePendingResult.mo6922c().intValue());
        }
        IBinder iBinder = this.f6398c.get();
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this, 0);
            } catch (NoSuchElementException e) {
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzdm
    /* JADX INFO: renamed from: a */
    public final void mo7205a(BasePendingResult<?> basePendingResult) {
        m7206a();
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        m7206a();
    }
}
