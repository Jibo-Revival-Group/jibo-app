package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class AccountChangeEvent extends zzbfm {
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();

    /* JADX INFO: renamed from: a */
    private int f5836a;

    /* JADX INFO: renamed from: b */
    private long f5837b;

    /* JADX INFO: renamed from: c */
    private String f5838c;

    /* JADX INFO: renamed from: d */
    private int f5839d;

    /* JADX INFO: renamed from: e */
    private int f5840e;

    /* JADX INFO: renamed from: f */
    private String f5841f;

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.f5836a = i;
        this.f5837b = j;
        this.f5838c = (String) zzbq.m7373a(str);
        this.f5839d = i2;
        this.f5840e = i3;
        this.f5841f = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.f5836a == accountChangeEvent.f5836a && this.f5837b == accountChangeEvent.f5837b && zzbg.m7371a(this.f5838c, accountChangeEvent.f5838c) && this.f5839d == accountChangeEvent.f5839d && this.f5840e == accountChangeEvent.f5840e && zzbg.m7371a(this.f5841f, accountChangeEvent.f5841f);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5836a), Long.valueOf(this.f5837b), this.f5838c, Integer.valueOf(this.f5839d), Integer.valueOf(this.f5840e), this.f5841f});
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.f5839d) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        String str2 = this.f5838c;
        String str3 = this.f5841f;
        return new StringBuilder(String.valueOf(str2).length() + 91 + String.valueOf(str).length() + String.valueOf(str3).length()).append("AccountChangeEvent {accountName = ").append(str2).append(", changeType = ").append(str).append(", changeData = ").append(str3).append(", eventIndex = ").append(this.f5840e).append("}").toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f5836a);
        zzbfp.m7739a(parcel, 2, this.f5837b);
        zzbfp.m7748a(parcel, 3, this.f5838c, false);
        zzbfp.m7738a(parcel, 4, this.f5839d);
        zzbfp.m7738a(parcel, 5, this.f5840e);
        zzbfp.m7748a(parcel, 6, this.f5841f, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
