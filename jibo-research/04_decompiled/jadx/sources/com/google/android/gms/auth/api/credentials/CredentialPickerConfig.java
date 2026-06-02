package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class CredentialPickerConfig extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zzc();

    /* JADX INFO: renamed from: a */
    private int f5919a;

    /* JADX INFO: renamed from: b */
    private final boolean f5920b;

    /* JADX INFO: renamed from: c */
    private final boolean f5921c;

    /* JADX INFO: renamed from: d */
    @Deprecated
    private final boolean f5922d;

    /* JADX INFO: renamed from: e */
    private final int f5923e;

    public static class Builder {

        /* JADX INFO: renamed from: a */
        private boolean f5924a = false;

        /* JADX INFO: renamed from: b */
        private boolean f5925b = true;

        /* JADX INFO: renamed from: c */
        private int f5926c = 1;

        /* JADX INFO: renamed from: a */
        public CredentialPickerConfig m6697a() {
            return new CredentialPickerConfig(this);
        }
    }

    CredentialPickerConfig(int i, boolean z, boolean z2, boolean z3, int i2) {
        this.f5919a = i;
        this.f5920b = z;
        this.f5921c = z2;
        if (i < 2) {
            this.f5922d = z3;
            this.f5923e = z3 ? 3 : 1;
        } else {
            this.f5922d = i2 == 3;
            this.f5923e = i2;
        }
    }

    private CredentialPickerConfig(Builder builder) {
        this(2, builder.f5924a, builder.f5925b, false, builder.f5926c);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m6691a() {
        return this.f5920b;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m6692b() {
        return this.f5921c;
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public final boolean m6693c() {
        return this.f5923e == 3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7751a(parcel, 1, m6691a());
        zzbfp.m7751a(parcel, 2, m6692b());
        zzbfp.m7751a(parcel, 3, m6693c());
        zzbfp.m7738a(parcel, 4, this.f5923e);
        zzbfp.m7738a(parcel, 1000, this.f5919a);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
