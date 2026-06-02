package com.google.android.gms.internal;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbgq extends zzbgn implements zzbfq {
    @Override // com.google.android.gms.internal.zzbgn
    /* JADX INFO: renamed from: a */
    public Object mo7783a(String str) {
        return null;
    }

    @Override // com.google.android.gms.internal.zzbgn
    /* JADX INFO: renamed from: b */
    public boolean mo7784b(String str) {
        return false;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        zzbgn zzbgnVar = (zzbgn) obj;
        for (zzbgo<?, ?> zzbgoVar : mo6679a().values()) {
            if (mo6680a(zzbgoVar)) {
                if (zzbgnVar.mo6680a(zzbgoVar) && mo6681b(zzbgoVar).equals(zzbgnVar.mo6681b(zzbgoVar))) {
                }
                return false;
            }
            if (zzbgnVar.mo6680a(zzbgoVar)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int iHashCode = 0;
        Iterator<zzbgo<?, ?>> it = mo6679a().values().iterator();
        while (true) {
            int i = iHashCode;
            if (!it.hasNext()) {
                return i;
            }
            zzbgo<?, ?> next = it.next();
            if (mo6680a(next)) {
                iHashCode = mo6681b(next).hashCode() + (i * 31);
            } else {
                iHashCode = i;
            }
        }
    }
}
