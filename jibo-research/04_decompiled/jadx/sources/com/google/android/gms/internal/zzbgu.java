package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgu extends zzbfm {
    public static final Parcelable.Creator<zzbgu> CREATOR = new zzbgx();

    /* JADX INFO: renamed from: a */
    final String f6964a;

    /* JADX INFO: renamed from: b */
    private int f6965b;

    /* JADX INFO: renamed from: c */
    private ArrayList<zzbgv> f6966c;

    zzbgu(int i, String str, ArrayList<zzbgv> arrayList) {
        this.f6965b = i;
        this.f6964a = str;
        this.f6966c = arrayList;
    }

    zzbgu(String str, Map<String, zzbgo<?, ?>> map) {
        ArrayList<zzbgv> arrayList;
        this.f6965b = 1;
        this.f6964a = str;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList<zzbgv> arrayList2 = new ArrayList<>();
            for (String str2 : map.keySet()) {
                arrayList2.add(new zzbgv(str2, map.get(str2)));
            }
            arrayList = arrayList2;
        }
        this.f6966c = arrayList;
    }

    /* JADX INFO: renamed from: a */
    final HashMap<String, zzbgo<?, ?>> m7801a() {
        HashMap<String, zzbgo<?, ?>> map = new HashMap<>();
        int size = this.f6966c.size();
        for (int i = 0; i < size; i++) {
            zzbgv zzbgvVar = this.f6966c.get(i);
            map.put(zzbgvVar.f6967a, zzbgvVar.f6968b);
        }
        return map;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6965b);
        zzbfp.m7748a(parcel, 2, this.f6964a, false);
        zzbfp.m7762c(parcel, 3, this.f6966c, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
