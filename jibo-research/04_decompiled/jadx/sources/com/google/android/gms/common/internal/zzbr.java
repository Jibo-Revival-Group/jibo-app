package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class zzbr extends zzbfm {
    public static final Parcelable.Creator<zzbr> CREATOR = new zzbs();

    /* JADX INFO: renamed from: a */
    private int f6574a;

    /* JADX INFO: renamed from: b */
    private final Account f6575b;

    /* JADX INFO: renamed from: c */
    private final int f6576c;

    /* JADX INFO: renamed from: d */
    private final GoogleSignInAccount f6577d;

    zzbr(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f6574a = i;
        this.f6575b = account;
        this.f6576c = i2;
        this.f6577d = googleSignInAccount;
    }

    public zzbr(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6574a);
        zzbfp.m7743a(parcel, 2, (Parcelable) this.f6575b, i, false);
        zzbfp.m7738a(parcel, 3, this.f6576c);
        zzbfp.m7743a(parcel, 4, (Parcelable) this.f6577d, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
