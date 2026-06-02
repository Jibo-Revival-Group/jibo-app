package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class HintRequest extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<HintRequest> CREATOR = new zzh();

    /* JADX INFO: renamed from: a */
    private int f5936a;

    /* JADX INFO: renamed from: b */
    private final CredentialPickerConfig f5937b;

    /* JADX INFO: renamed from: c */
    private final boolean f5938c;

    /* JADX INFO: renamed from: d */
    private final boolean f5939d;

    /* JADX INFO: renamed from: e */
    private final String[] f5940e;

    /* JADX INFO: renamed from: f */
    private final boolean f5941f;

    /* JADX INFO: renamed from: g */
    private final String f5942g;

    /* JADX INFO: renamed from: h */
    private final String f5943h;

    HintRequest(int i, CredentialPickerConfig credentialPickerConfig, boolean z, boolean z2, String[] strArr, boolean z3, String str, String str2) {
        this.f5936a = i;
        this.f5937b = (CredentialPickerConfig) zzbq.m7373a(credentialPickerConfig);
        this.f5938c = z;
        this.f5939d = z2;
        this.f5940e = (String[]) zzbq.m7373a(strArr);
        if (this.f5936a < 2) {
            this.f5941f = true;
            this.f5942g = null;
            this.f5943h = null;
        } else {
            this.f5941f = z3;
            this.f5942g = str;
            this.f5943h = str2;
        }
    }

    /* JADX INFO: renamed from: a */
    public final CredentialPickerConfig m6705a() {
        return this.f5937b;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m6706b() {
        return this.f5938c;
    }

    /* JADX INFO: renamed from: c */
    public final String[] m6707c() {
        return this.f5940e;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m6708d() {
        return this.f5941f;
    }

    /* JADX INFO: renamed from: e */
    public final String m6709e() {
        return this.f5942g;
    }

    /* JADX INFO: renamed from: f */
    public final String m6710f() {
        return this.f5943h;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7743a(parcel, 1, (Parcelable) m6705a(), i, false);
        zzbfp.m7751a(parcel, 2, m6706b());
        zzbfp.m7751a(parcel, 3, this.f5939d);
        zzbfp.m7755a(parcel, 4, m6707c(), false);
        zzbfp.m7751a(parcel, 5, m6708d());
        zzbfp.m7748a(parcel, 6, m6709e(), false);
        zzbfp.m7748a(parcel, 7, m6710f(), false);
        zzbfp.m7738a(parcel, 1000, this.f5936a);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
