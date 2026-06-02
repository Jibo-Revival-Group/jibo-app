package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.ArraySet;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.internal.zzaxc;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzbgo;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class zzu extends zzaxc {
    public static final Parcelable.Creator<zzu> CREATOR = new zzv();

    /* JADX INFO: renamed from: a */
    private static final HashMap<String, zzbgo<?, ?>> f5901a;

    /* JADX INFO: renamed from: b */
    private Set<Integer> f5902b;

    /* JADX INFO: renamed from: c */
    private int f5903c;

    /* JADX INFO: renamed from: d */
    private String f5904d;

    /* JADX INFO: renamed from: e */
    private int f5905e;

    /* JADX INFO: renamed from: f */
    private byte[] f5906f;

    /* JADX INFO: renamed from: g */
    private PendingIntent f5907g;

    /* JADX INFO: renamed from: h */
    private DeviceMetaData f5908h;

    static {
        HashMap<String, zzbgo<?, ?>> map = new HashMap<>();
        f5901a = map;
        map.put("accountType", zzbgo.m7788b("accountType", 2));
        f5901a.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, zzbgo.m7785a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 3));
        f5901a.put("transferBytes", (zzbgo<?, ?>) zzbgo.m7791d("transferBytes", 4));
    }

    public zzu() {
        this.f5902b = new ArraySet(3);
        this.f5903c = 1;
    }

    zzu(Set<Integer> set, int i, String str, int i2, byte[] bArr, PendingIntent pendingIntent, DeviceMetaData deviceMetaData) {
        this.f5902b = set;
        this.f5903c = i;
        this.f5904d = str;
        this.f5905e = i2;
        this.f5906f = bArr;
        this.f5907g = pendingIntent;
        this.f5908h = deviceMetaData;
    }

    @Override // com.google.android.gms.internal.zzbgn
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Map mo6679a() {
        return f5901a;
    }

    @Override // com.google.android.gms.internal.zzbgn
    /* JADX INFO: renamed from: a */
    protected final boolean mo6680a(zzbgo zzbgoVar) {
        return this.f5902b.contains(Integer.valueOf(zzbgoVar.m7793a()));
    }

    @Override // com.google.android.gms.internal.zzbgn
    /* JADX INFO: renamed from: b */
    protected final Object mo6681b(zzbgo zzbgoVar) {
        switch (zzbgoVar.m7793a()) {
            case 1:
                return Integer.valueOf(this.f5903c);
            case 2:
                return this.f5904d;
            case 3:
                return Integer.valueOf(this.f5905e);
            case 4:
                return this.f5906f;
            default:
                throw new IllegalStateException(new StringBuilder(37).append("Unknown SafeParcelable id=").append(zzbgoVar.m7793a()).toString());
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        Set<Integer> set = this.f5902b;
        if (set.contains(1)) {
            zzbfp.m7738a(parcel, 1, this.f5903c);
        }
        if (set.contains(2)) {
            zzbfp.m7748a(parcel, 2, this.f5904d, true);
        }
        if (set.contains(3)) {
            zzbfp.m7738a(parcel, 3, this.f5905e);
        }
        if (set.contains(4)) {
            zzbfp.m7752a(parcel, 4, this.f5906f, true);
        }
        if (set.contains(5)) {
            zzbfp.m7743a(parcel, 5, (Parcelable) this.f5907g, i, true);
        }
        if (set.contains(6)) {
            zzbfp.m7743a(parcel, 6, (Parcelable) this.f5908h, i, true);
        }
        zzbfp.m7734a(parcel, iM7733a);
    }
}
