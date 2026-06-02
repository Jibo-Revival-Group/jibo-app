package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzb {

    /* JADX INFO: renamed from: a */
    public final Uri f6517a;

    public zzb(Uri uri) {
        this.f6517a = uri;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzb)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return zzbg.m7371a(((zzb) obj).f6517a, this.f6517a);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6517a});
    }
}
