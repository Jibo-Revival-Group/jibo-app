package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgj extends zzbfm implements zzbgp<String, Integer> {
    public static final Parcelable.Creator<zzbgj> CREATOR = new zzbgl();

    /* JADX INFO: renamed from: a */
    private int f6942a;

    /* JADX INFO: renamed from: b */
    private final HashMap<String, Integer> f6943b;

    /* JADX INFO: renamed from: c */
    private final SparseArray<String> f6944c;

    /* JADX INFO: renamed from: d */
    private final ArrayList<zzbgk> f6945d;

    public zzbgj() {
        this.f6942a = 1;
        this.f6943b = new HashMap<>();
        this.f6944c = new SparseArray<>();
        this.f6945d = null;
    }

    zzbgj(int i, ArrayList<zzbgk> arrayList) {
        this.f6942a = i;
        this.f6943b = new HashMap<>();
        this.f6944c = new SparseArray<>();
        this.f6945d = null;
        m7777a(arrayList);
    }

    /* JADX INFO: renamed from: a */
    private final void m7777a(ArrayList<zzbgk> arrayList) {
        ArrayList<zzbgk> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            zzbgk zzbgkVar = arrayList2.get(i);
            i++;
            zzbgk zzbgkVar2 = zzbgkVar;
            m7778a(zzbgkVar2.f6946a, zzbgkVar2.f6947b);
        }
    }

    /* JADX INFO: renamed from: a */
    public final zzbgj m7778a(String str, int i) {
        this.f6943b.put(str, Integer.valueOf(i));
        this.f6944c.put(i, str);
        return this;
    }

    @Override // com.google.android.gms.internal.zzbgp
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ String mo7779a(Integer num) {
        String str = this.f6944c.get(num.intValue());
        return (str == null && this.f6943b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6942a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f6943b.keySet()) {
            arrayList.add(new zzbgk(str, this.f6943b.get(str).intValue()));
        }
        zzbfp.m7762c(parcel, 2, arrayList, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
