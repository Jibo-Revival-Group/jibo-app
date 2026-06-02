package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ActivityRecognitionResult extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new zzb();

    /* JADX INFO: renamed from: a */
    private List<DetectedActivity> f8037a;

    /* JADX INFO: renamed from: b */
    private long f8038b;

    /* JADX INFO: renamed from: c */
    private long f8039c;

    /* JADX INFO: renamed from: d */
    private int f8040d;

    /* JADX INFO: renamed from: e */
    private Bundle f8041e;

    public ActivityRecognitionResult(List<DetectedActivity> list, long j, long j2, int i, Bundle bundle) {
        zzbq.m7383b(list != null && list.size() > 0, "Must have at least 1 detected activity");
        zzbq.m7383b(j > 0 && j2 > 0, "Must set times");
        this.f8037a = list;
        this.f8038b = j;
        this.f8039c = j2;
        this.f8040d = i;
        this.f8041e = bundle;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m8735a(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return true;
        }
        if ((bundle == null && bundle2 != null) || (bundle != null && bundle2 == null)) {
            return false;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundle2.containsKey(str)) {
                return false;
            }
            if (bundle.get(str) == null) {
                if (bundle2.get(str) != null) {
                    return false;
                }
            } else if (bundle.get(str) instanceof Bundle) {
                if (!m8735a(bundle.getBundle(str), bundle2.getBundle(str))) {
                    return false;
                }
            } else if (!bundle.get(str).equals(bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
        return this.f8038b == activityRecognitionResult.f8038b && this.f8039c == activityRecognitionResult.f8039c && this.f8040d == activityRecognitionResult.f8040d && zzbg.m7371a(this.f8037a, activityRecognitionResult.f8037a) && m8735a(this.f8041e, activityRecognitionResult.f8041e);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f8038b), Long.valueOf(this.f8039c), Integer.valueOf(this.f8040d), this.f8037a, this.f8041e});
    }

    public String toString() {
        String strValueOf = String.valueOf(this.f8037a);
        long j = this.f8038b;
        return new StringBuilder(String.valueOf(strValueOf).length() + 124).append("ActivityRecognitionResult [probableActivities=").append(strValueOf).append(", timeMillis=").append(j).append(", elapsedRealtimeMillis=").append(this.f8039c).append("]").toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7762c(parcel, 1, this.f8037a, false);
        zzbfp.m7739a(parcel, 2, this.f8038b);
        zzbfp.m7739a(parcel, 3, this.f8039c);
        zzbfp.m7738a(parcel, 4, this.f8040d);
        zzbfp.m7740a(parcel, 5, this.f8041e, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
