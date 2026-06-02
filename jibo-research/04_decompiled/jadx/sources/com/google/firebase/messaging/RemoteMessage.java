package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteMessage extends zzbfm {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new zzf();

    /* JADX INFO: renamed from: a */
    Bundle f8709a;

    /* JADX INFO: renamed from: b */
    private Map<String, String> f8710b;

    RemoteMessage(Bundle bundle) {
        this.f8709a = bundle;
    }

    /* JADX INFO: renamed from: a */
    public final Map<String, String> m9199a() {
        if (this.f8710b == null) {
            this.f8710b = new ArrayMap();
            for (String str : this.f8709a.keySet()) {
                Object obj = this.f8709a.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        this.f8710b.put(str, str2);
                    }
                }
            }
        }
        return this.f8710b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7740a(parcel, 2, this.f8709a, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
