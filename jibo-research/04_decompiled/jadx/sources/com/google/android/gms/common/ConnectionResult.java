package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class ConnectionResult extends zzbfm {

    /* JADX INFO: renamed from: b */
    private int f6065b;

    /* JADX INFO: renamed from: c */
    private final int f6066c;

    /* JADX INFO: renamed from: d */
    private final PendingIntent f6067d;

    /* JADX INFO: renamed from: e */
    private final String f6068e;

    /* JADX INFO: renamed from: a */
    public static final ConnectionResult f6064a = new ConnectionResult(0);
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new zzb();

    public ConnectionResult(int i) {
        this(i, null, null);
    }

    ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f6065b = i;
        this.f6066c = i2;
        this.f6067d = pendingIntent;
        this.f6068e = str;
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    /* JADX INFO: renamed from: a */
    static String m6819a(int i) {
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            case 13:
                return "CANCELED";
            case 14:
                return "TIMEOUT";
            case 15:
                return "INTERRUPTED";
            case 16:
                return "API_UNAVAILABLE";
            case 17:
                return "SIGN_IN_FAILED";
            case 18:
                return "SERVICE_UPDATING";
            case 19:
                return "SERVICE_MISSING_PERMISSION";
            case 20:
                return "RESTRICTED_PROFILE";
            case 21:
                return "API_VERSION_UPDATE_REQUIRED";
            case 99:
                return "UNFINISHED";
            case 1500:
                return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
            default:
                return new StringBuilder(31).append("UNKNOWN_ERROR_CODE(").append(i).append(")").toString();
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m6820a() {
        return (this.f6066c == 0 || this.f6067d == null) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m6821b() {
        return this.f6066c == 0;
    }

    /* JADX INFO: renamed from: c */
    public final int m6822c() {
        return this.f6066c;
    }

    /* JADX INFO: renamed from: d */
    public final PendingIntent m6823d() {
        return this.f6067d;
    }

    /* JADX INFO: renamed from: e */
    public final String m6824e() {
        return this.f6068e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f6066c == connectionResult.f6066c && zzbg.m7371a(this.f6067d, connectionResult.f6067d) && zzbg.m7371a(this.f6068e, connectionResult.f6068e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f6066c), this.f6067d, this.f6068e});
    }

    public final String toString() {
        return zzbg.m7370a(this).m7372a("statusCode", m6819a(this.f6066c)).m7372a("resolution", this.f6067d).m7372a(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, this.f6068e).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6065b);
        zzbfp.m7738a(parcel, 2, m6822c());
        zzbfp.m7743a(parcel, 3, (Parcelable) m6823d(), i, false);
        zzbfp.m7748a(parcel, 4, m6824e(), false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
