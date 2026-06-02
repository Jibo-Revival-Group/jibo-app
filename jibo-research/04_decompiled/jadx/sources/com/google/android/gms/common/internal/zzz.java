package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class zzz extends zzbfm {
    public static final Parcelable.Creator<zzz> CREATOR = new zzaa();

    /* JADX INFO: renamed from: a */
    String f6659a;

    /* JADX INFO: renamed from: b */
    IBinder f6660b;

    /* JADX INFO: renamed from: c */
    Scope[] f6661c;

    /* JADX INFO: renamed from: d */
    Bundle f6662d;

    /* JADX INFO: renamed from: e */
    Account f6663e;

    /* JADX INFO: renamed from: f */
    com.google.android.gms.common.zzc[] f6664f;

    /* JADX INFO: renamed from: g */
    private int f6665g;

    /* JADX INFO: renamed from: h */
    private int f6666h;

    /* JADX INFO: renamed from: i */
    private int f6667i;

    public zzz(int i) {
        this.f6665g = 3;
        this.f6667i = com.google.android.gms.common.zzf.f6704b;
        this.f6666h = i;
    }

    zzz(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, com.google.android.gms.common.zzc[] zzcVarArr) {
        Account accountM7308a = null;
        zzan zzapVar = null;
        this.f6665g = i;
        this.f6666h = i2;
        this.f6667i = i3;
        if ("com.google.android.gms".equals(str)) {
            this.f6659a = "com.google.android.gms";
        } else {
            this.f6659a = str;
        }
        if (i < 2) {
            if (iBinder != null) {
                if (iBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                    zzapVar = iInterfaceQueryLocalInterface instanceof zzan ? (zzan) iInterfaceQueryLocalInterface : new zzap(iBinder);
                }
                accountM7308a = zza.m7308a(zzapVar);
            }
            this.f6663e = accountM7308a;
        } else {
            this.f6660b = iBinder;
            this.f6663e = account;
        }
        this.f6661c = scopeArr;
        this.f6662d = bundle;
        this.f6664f = zzcVarArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6665g);
        zzbfp.m7738a(parcel, 2, this.f6666h);
        zzbfp.m7738a(parcel, 3, this.f6667i);
        zzbfp.m7748a(parcel, 4, this.f6659a, false);
        zzbfp.m7741a(parcel, 5, this.f6660b, false);
        zzbfp.m7754a(parcel, 6, (Parcelable[]) this.f6661c, i, false);
        zzbfp.m7740a(parcel, 7, this.f6662d, false);
        zzbfp.m7743a(parcel, 8, (Parcelable) this.f6663e, i, false);
        zzbfp.m7754a(parcel, 10, (Parcelable[]) this.f6664f, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
