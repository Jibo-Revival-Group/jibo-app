package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.api.client.googleapis.extensions.android.accounts.GoogleAccountManager;

/* JADX INFO: loaded from: classes.dex */
public class AccountChangeEventsRequest extends zzbfm {
    public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new zzb();

    /* JADX INFO: renamed from: a */
    private int f5842a;

    /* JADX INFO: renamed from: b */
    private int f5843b;

    /* JADX INFO: renamed from: c */
    @Deprecated
    private String f5844c;

    /* JADX INFO: renamed from: d */
    private Account f5845d;

    public AccountChangeEventsRequest() {
        this.f5842a = 1;
    }

    AccountChangeEventsRequest(int i, int i2, String str, Account account) {
        this.f5842a = i;
        this.f5843b = i2;
        this.f5844c = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.f5845d = account;
        } else {
            this.f5845d = new Account(str, GoogleAccountManager.ACCOUNT_TYPE);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f5842a);
        zzbfp.m7738a(parcel, 2, this.f5843b);
        zzbfp.m7748a(parcel, 3, this.f5844c, false);
        zzbfp.m7743a(parcel, 4, (Parcelable) this.f5845d, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
