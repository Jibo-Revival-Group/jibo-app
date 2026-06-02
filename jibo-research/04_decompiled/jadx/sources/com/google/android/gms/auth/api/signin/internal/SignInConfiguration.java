package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class SignInConfiguration extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zzx();

    /* JADX INFO: renamed from: a */
    private final String f6024a;

    /* JADX INFO: renamed from: b */
    private GoogleSignInOptions f6025b;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        this.f6024a = zzbq.m7375a(str);
        this.f6025b = googleSignInOptions;
    }

    /* JADX INFO: renamed from: a */
    public final GoogleSignInOptions m6758a() {
        return this.f6025b;
    }

    public final boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
                if (this.f6024a.equals(signInConfiguration.f6024a) && (this.f6025b != null ? this.f6025b.equals(signInConfiguration.f6025b) : signInConfiguration.f6025b == null)) {
                    z = true;
                }
            } catch (ClassCastException e) {
            }
        }
        return z;
    }

    public final int hashCode() {
        return new zzp().m6786a(this.f6024a).m6786a(this.f6025b).m6785a();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 2, this.f6024a, false);
        zzbfp.m7743a(parcel, 5, (Parcelable) this.f6025b, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
