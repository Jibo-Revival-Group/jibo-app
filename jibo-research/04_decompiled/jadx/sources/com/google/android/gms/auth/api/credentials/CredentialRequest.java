package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class CredentialRequest extends zzbfm {
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new zze();

    /* JADX INFO: renamed from: a */
    private int f5927a;

    /* JADX INFO: renamed from: b */
    private final boolean f5928b;

    /* JADX INFO: renamed from: c */
    private final String[] f5929c;

    /* JADX INFO: renamed from: d */
    private final CredentialPickerConfig f5930d;

    /* JADX INFO: renamed from: e */
    private final CredentialPickerConfig f5931e;

    /* JADX INFO: renamed from: f */
    private final boolean f5932f;

    /* JADX INFO: renamed from: g */
    private final String f5933g;

    /* JADX INFO: renamed from: h */
    private final String f5934h;

    /* JADX INFO: renamed from: i */
    private final boolean f5935i;

    CredentialRequest(int i, boolean z, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2, boolean z2, String str, String str2, boolean z3) {
        this.f5927a = i;
        this.f5928b = z;
        this.f5929c = (String[]) zzbq.m7373a(strArr);
        this.f5930d = credentialPickerConfig == null ? new CredentialPickerConfig.Builder().m6697a() : credentialPickerConfig;
        this.f5931e = credentialPickerConfig2 == null ? new CredentialPickerConfig.Builder().m6697a() : credentialPickerConfig2;
        if (i < 3) {
            this.f5932f = true;
            this.f5933g = null;
            this.f5934h = null;
        } else {
            this.f5932f = z2;
            this.f5933g = str;
            this.f5934h = str2;
        }
        this.f5935i = z3;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m6698a() {
        return this.f5928b;
    }

    /* JADX INFO: renamed from: b */
    public final String[] m6699b() {
        return this.f5929c;
    }

    /* JADX INFO: renamed from: c */
    public final CredentialPickerConfig m6700c() {
        return this.f5930d;
    }

    /* JADX INFO: renamed from: d */
    public final CredentialPickerConfig m6701d() {
        return this.f5931e;
    }

    /* JADX INFO: renamed from: e */
    public final boolean m6702e() {
        return this.f5932f;
    }

    /* JADX INFO: renamed from: f */
    public final String m6703f() {
        return this.f5933g;
    }

    /* JADX INFO: renamed from: g */
    public final String m6704g() {
        return this.f5934h;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7751a(parcel, 1, m6698a());
        zzbfp.m7755a(parcel, 2, m6699b(), false);
        zzbfp.m7743a(parcel, 3, (Parcelable) m6700c(), i, false);
        zzbfp.m7743a(parcel, 4, (Parcelable) m6701d(), i, false);
        zzbfp.m7751a(parcel, 5, m6702e());
        zzbfp.m7748a(parcel, 6, m6703f(), false);
        zzbfp.m7748a(parcel, 7, m6704g(), false);
        zzbfp.m7738a(parcel, 1000, this.f5927a);
        zzbfp.m7751a(parcel, 8, this.f5935i);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
