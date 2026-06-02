package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.internal.zzbfl;

/* JADX INFO: loaded from: classes.dex */
public abstract class zza {

    /* JADX INFO: renamed from: a */
    final zzb f6515a;

    /* JADX INFO: renamed from: b */
    protected int f6516b;

    /* JADX INFO: renamed from: a */
    final void m7305a(Context context, Bitmap bitmap, boolean z) {
        zzc.m7396a(bitmap);
        mo7307a(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    /* JADX INFO: renamed from: a */
    final void m7306a(Context context, zzbfl zzbflVar, boolean z) {
        Drawable drawable = null;
        if (this.f6516b != 0) {
            drawable = context.getResources().getDrawable(this.f6516b);
        }
        mo7307a(drawable, z, false, false);
    }

    /* JADX INFO: renamed from: a */
    protected abstract void mo7307a(Drawable drawable, boolean z, boolean z2, boolean z3);
}
