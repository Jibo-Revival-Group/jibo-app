package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class DetectedActivity extends zzbfm {

    /* JADX INFO: renamed from: d */
    private int f8045d;

    /* JADX INFO: renamed from: e */
    private int f8046e;

    /* JADX INFO: renamed from: a */
    private static Comparator<DetectedActivity> f8042a = new zzc();

    /* JADX INFO: renamed from: b */
    private static int[] f8043b = {9, 10};

    /* JADX INFO: renamed from: c */
    private static int[] f8044c = {0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 16, 17};
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new zzd();

    public DetectedActivity(int i, int i2) {
        this.f8045d = i;
        this.f8046e = i2;
    }

    /* JADX INFO: renamed from: a */
    public int m8736a() {
        int i = this.f8045d;
        if (i > 17) {
            return 4;
        }
        return i;
    }

    /* JADX INFO: renamed from: b */
    public int m8737b() {
        return this.f8046e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DetectedActivity detectedActivity = (DetectedActivity) obj;
        return this.f8045d == detectedActivity.f8045d && this.f8046e == detectedActivity.f8046e;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8045d), Integer.valueOf(this.f8046e)});
    }

    public String toString() {
        String string;
        int iM8736a = m8736a();
        switch (iM8736a) {
            case 0:
                string = "IN_VEHICLE";
                break;
            case 1:
                string = "ON_BICYCLE";
                break;
            case 2:
                string = "ON_FOOT";
                break;
            case 3:
                string = "STILL";
                break;
            case 4:
                string = "UNKNOWN";
                break;
            case 5:
                string = "TILTING";
                break;
            case 6:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            default:
                string = Integer.toString(iM8736a);
                break;
            case 7:
                string = "WALKING";
                break;
            case 8:
                string = "RUNNING";
                break;
            case 16:
                string = "IN_ROAD_VEHICLE";
                break;
            case 17:
                string = "IN_RAIL_VEHICLE";
                break;
        }
        return new StringBuilder(String.valueOf(string).length() + 48).append("DetectedActivity [type=").append(string).append(", confidence=").append(this.f8046e).append("]").toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f8045d);
        zzbfp.m7738a(parcel, 2, this.f8046e);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
