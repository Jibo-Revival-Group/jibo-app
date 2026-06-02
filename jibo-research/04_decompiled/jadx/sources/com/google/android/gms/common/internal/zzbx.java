package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class zzbx extends com.google.android.gms.dynamic.zzp<zzbd> {

    /* JADX INFO: renamed from: a */
    private static final zzbx f6587a = new zzbx();

    private zzbx() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    /* JADX INFO: renamed from: a */
    public static View m7390a(Context context, int i, int i2) throws com.google.android.gms.dynamic.zzq {
        return f6587a.m7391b(context, i, i2);
    }

    /* JADX INFO: renamed from: b */
    private final View m7391b(Context context, int i, int i2) throws com.google.android.gms.dynamic.zzq {
        try {
            zzbv zzbvVar = new zzbv(i, i2, null);
            return (View) com.google.android.gms.dynamic.zzn.m7554a(m7555a(context).mo7366a(com.google.android.gms.dynamic.zzn.m7553a(context), zzbvVar));
        } catch (Exception e) {
            throw new com.google.android.gms.dynamic.zzq(new StringBuilder(64).append("Could not get button with size ").append(i).append(" and color ").append(i2).toString(), e);
        }
    }

    @Override // com.google.android.gms.dynamic.zzp
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ zzbd mo7392a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return iInterfaceQueryLocalInterface instanceof zzbd ? (zzbd) iInterfaceQueryLocalInterface : new zzbe(iBinder);
    }
}
