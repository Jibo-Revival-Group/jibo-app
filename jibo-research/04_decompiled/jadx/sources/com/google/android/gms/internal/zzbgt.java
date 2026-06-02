package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgt extends zzbfm {
    public static final Parcelable.Creator<zzbgt> CREATOR = new zzbgw();

    /* JADX INFO: renamed from: a */
    private int f6960a;

    /* JADX INFO: renamed from: b */
    private final HashMap<String, Map<String, zzbgo<?, ?>>> f6961b;

    /* JADX INFO: renamed from: c */
    private final ArrayList<zzbgu> f6962c = null;

    /* JADX INFO: renamed from: d */
    private final String f6963d;

    zzbgt(int i, ArrayList<zzbgu> arrayList, String str) {
        this.f6960a = i;
        HashMap<String, Map<String, zzbgo<?, ?>>> map = new HashMap<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzbgu zzbguVar = arrayList.get(i2);
            map.put(zzbguVar.f6964a, zzbguVar.m7801a());
        }
        this.f6961b = map;
        this.f6963d = (String) zzbq.m7373a(str);
        m7798b();
    }

    /* JADX INFO: renamed from: b */
    private final void m7798b() {
        Iterator<String> it = this.f6961b.keySet().iterator();
        while (it.hasNext()) {
            Map<String, zzbgo<?, ?>> map = this.f6961b.get(it.next());
            Iterator<String> it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                map.get(it2.next()).m7795a(this);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final String m7799a() {
        return this.f6963d;
    }

    /* JADX INFO: renamed from: a */
    public final Map<String, zzbgo<?, ?>> m7800a(String str) {
        return this.f6961b.get(str);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.f6961b.keySet()) {
            sb.append(str).append(":\n");
            Map<String, zzbgo<?, ?>> map = this.f6961b.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ").append(str2).append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6960a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f6961b.keySet()) {
            arrayList.add(new zzbgu(str, this.f6961b.get(str)));
        }
        zzbfp.m7762c(parcel, 2, arrayList, false);
        zzbfp.m7748a(parcel, 3, this.f6963d, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
