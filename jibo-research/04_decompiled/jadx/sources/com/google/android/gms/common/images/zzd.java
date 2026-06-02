package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.zzbg;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzd extends zza {

    /* JADX INFO: renamed from: c */
    private WeakReference<ImageManager.OnImageLoadedListener> f6518c;

    @Override // com.google.android.gms.common.images.zza
    /* JADX INFO: renamed from: a */
    protected final void mo7307a(Drawable drawable, boolean z, boolean z2, boolean z3) {
        ImageManager.OnImageLoadedListener onImageLoadedListener;
        if (z2 || (onImageLoadedListener = this.f6518c.get()) == null) {
            return;
        }
        onImageLoadedListener.m7301a(this.f6515a.f6517a, drawable, z3);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzd)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzd zzdVar = (zzd) obj;
        ImageManager.OnImageLoadedListener onImageLoadedListener = this.f6518c.get();
        ImageManager.OnImageLoadedListener onImageLoadedListener2 = zzdVar.f6518c.get();
        return onImageLoadedListener2 != null && onImageLoadedListener != null && zzbg.m7371a(onImageLoadedListener2, onImageLoadedListener) && zzbg.m7371a(zzdVar.f6515a, this.f6515a);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6515a});
    }
}
