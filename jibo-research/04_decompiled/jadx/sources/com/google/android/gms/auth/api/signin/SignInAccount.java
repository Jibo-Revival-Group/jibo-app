package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public class SignInAccount extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new zzf();

    /* JADX INFO: renamed from: a */
    @Deprecated
    private String f6021a;

    /* JADX INFO: renamed from: b */
    private GoogleSignInAccount f6022b;

    /* JADX INFO: renamed from: c */
    @Deprecated
    private String f6023c;

    SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.f6022b = googleSignInAccount;
        this.f6021a = zzbq.m7376a(str, (Object) "8.3 and 8.4 SDKs require non-null email");
        this.f6023c = zzbq.m7376a(str2, (Object) "8.3 and 8.4 SDKs require non-null userId");
    }

    /* JADX INFO: renamed from: a */
    public final GoogleSignInAccount m6757a() {
        return this.f6022b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 4, this.f6021a, false);
        zzbfp.m7743a(parcel, 7, (Parcelable) this.f6022b, i, false);
        zzbfp.m7748a(parcel, 8, this.f6023c, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
