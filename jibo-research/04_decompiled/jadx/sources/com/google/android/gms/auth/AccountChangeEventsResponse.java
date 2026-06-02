package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccountChangeEventsResponse extends zzbfm {
    public static final Parcelable.Creator<AccountChangeEventsResponse> CREATOR = new zzc();

    /* JADX INFO: renamed from: a */
    private int f5846a;

    /* JADX INFO: renamed from: b */
    private List<AccountChangeEvent> f5847b;

    AccountChangeEventsResponse(int i, List<AccountChangeEvent> list) {
        this.f5846a = i;
        this.f5847b = (List) zzbq.m7373a(list);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f5846a);
        zzbfp.m7762c(parcel, 2, this.f5847b, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
