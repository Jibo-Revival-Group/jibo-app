package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class IdToken extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<IdToken> CREATOR = new zzi();

    /* JADX INFO: renamed from: a */
    private final String f5944a;

    /* JADX INFO: renamed from: b */
    private final String f5945b;

    public IdToken(String str, String str2) {
        zzbq.m7383b(!TextUtils.isEmpty(str), "account type string cannot be null or empty");
        zzbq.m7383b(TextUtils.isEmpty(str2) ? false : true, "id token string cannot be null or empty");
        this.f5944a = str;
        this.f5945b = str2;
    }

    /* JADX INFO: renamed from: a */
    public final String m6711a() {
        return this.f5944a;
    }

    /* JADX INFO: renamed from: b */
    public final String m6712b() {
        return this.f5945b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 1, m6711a(), false);
        zzbfp.m7748a(parcel, 2, m6712b(), false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
