package com.google.android.gms.location.places;

import com.google.android.gms.location.places.internal.zzah;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class zzi implements Comparator<zzah> {
    zzi() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzah zzahVar, zzah zzahVar2) {
        return -Float.compare(zzahVar.m8784a(), zzahVar2.m8784a());
    }
}
