package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzca;
import com.google.android.gms.common.util.zzu;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseOptions {

    /* JADX INFO: renamed from: a */
    private final String f8612a;

    /* JADX INFO: renamed from: b */
    private final String f8613b;

    /* JADX INFO: renamed from: c */
    private final String f8614c;

    /* JADX INFO: renamed from: d */
    private final String f8615d;

    /* JADX INFO: renamed from: e */
    private final String f8616e;

    /* JADX INFO: renamed from: f */
    private final String f8617f;

    /* JADX INFO: renamed from: g */
    private final String f8618g;

    private FirebaseOptions(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        zzbq.m7379a(!zzu.m7520a(str), "ApplicationId must be set.");
        this.f8613b = str;
        this.f8612a = str2;
        this.f8614c = str3;
        this.f8615d = str4;
        this.f8616e = str5;
        this.f8617f = str6;
        this.f8618g = str7;
    }

    /* JADX INFO: renamed from: a */
    public static FirebaseOptions m9091a(Context context) {
        zzca zzcaVar = new zzca(context);
        String strM7398a = zzcaVar.m7398a("google_app_id");
        if (TextUtils.isEmpty(strM7398a)) {
            return null;
        }
        return new FirebaseOptions(strM7398a, zzcaVar.m7398a("google_api_key"), zzcaVar.m7398a("firebase_database_url"), zzcaVar.m7398a("ga_trackingId"), zzcaVar.m7398a("gcm_defaultSenderId"), zzcaVar.m7398a("google_storage_bucket"), zzcaVar.m7398a("project_id"));
    }

    /* JADX INFO: renamed from: a */
    public final String m9092a() {
        return this.f8613b;
    }

    /* JADX INFO: renamed from: b */
    public final String m9093b() {
        return this.f8616e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        return zzbg.m7371a(this.f8613b, firebaseOptions.f8613b) && zzbg.m7371a(this.f8612a, firebaseOptions.f8612a) && zzbg.m7371a(this.f8614c, firebaseOptions.f8614c) && zzbg.m7371a(this.f8615d, firebaseOptions.f8615d) && zzbg.m7371a(this.f8616e, firebaseOptions.f8616e) && zzbg.m7371a(this.f8617f, firebaseOptions.f8617f) && zzbg.m7371a(this.f8618g, firebaseOptions.f8618g);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8613b, this.f8612a, this.f8614c, this.f8615d, this.f8616e, this.f8617f, this.f8618g});
    }

    public final String toString() {
        return zzbg.m7370a(this).m7372a("applicationId", this.f8613b).m7372a("apiKey", this.f8612a).m7372a("databaseUrl", this.f8614c).m7372a("gcmSenderId", this.f8616e).m7372a("storageBucket", this.f8617f).m7372a("projectId", this.f8618g).toString();
    }
}
