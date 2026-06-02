package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TokenData extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<TokenData> CREATOR = new zzk();

    /* JADX INFO: renamed from: a */
    private int f5851a;

    /* JADX INFO: renamed from: b */
    private final String f5852b;

    /* JADX INFO: renamed from: c */
    private final Long f5853c;

    /* JADX INFO: renamed from: d */
    private final boolean f5854d;

    /* JADX INFO: renamed from: e */
    private final boolean f5855e;

    /* JADX INFO: renamed from: f */
    private final List<String> f5856f;

    TokenData(int i, String str, Long l, boolean z, boolean z2, List<String> list) {
        this.f5851a = i;
        this.f5852b = zzbq.m7375a(str);
        this.f5853c = l;
        this.f5854d = z;
        this.f5855e = z2;
        this.f5856f = list;
    }

    /* JADX INFO: renamed from: a */
    public static TokenData m6671a(Bundle bundle, String str) {
        bundle.setClassLoader(TokenData.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(TokenData.class.getClassLoader());
        return (TokenData) bundle2.getParcelable("TokenData");
    }

    /* JADX INFO: renamed from: a */
    public final String m6672a() {
        return this.f5852b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.f5852b, tokenData.f5852b) && zzbg.m7371a(this.f5853c, tokenData.f5853c) && this.f5854d == tokenData.f5854d && this.f5855e == tokenData.f5855e && zzbg.m7371a(this.f5856f, tokenData.f5856f);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5852b, this.f5853c, Boolean.valueOf(this.f5854d), Boolean.valueOf(this.f5855e), this.f5856f});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f5851a);
        zzbfp.m7748a(parcel, 2, this.f5852b, false);
        zzbfp.m7747a(parcel, 3, this.f5853c, false);
        zzbfp.m7751a(parcel, 4, this.f5854d);
        zzbfp.m7751a(parcel, 5, this.f5855e);
        zzbfp.m7760b(parcel, 6, this.f5856f, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
