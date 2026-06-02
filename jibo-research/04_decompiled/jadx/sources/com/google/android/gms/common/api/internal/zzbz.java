package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzca;
import com.yalantis.ucrop.util.FileUtils;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzbz {

    /* JADX INFO: renamed from: a */
    private static final Object f6331a = new Object();

    /* JADX INFO: renamed from: b */
    private static zzbz f6332b;

    /* JADX INFO: renamed from: c */
    private final String f6333c;

    /* JADX INFO: renamed from: d */
    private final Status f6334d;

    /* JADX INFO: renamed from: e */
    private final boolean f6335e;

    /* JADX INFO: renamed from: f */
    private final boolean f6336f;

    private zzbz(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            boolean z = resources.getInteger(identifier) != 0;
            this.f6336f = z ? false : true;
            z = z;
        } else {
            this.f6336f = false;
        }
        this.f6335e = z;
        String strM7367a = com.google.android.gms.common.internal.zzbf.m7367a(context);
        strM7367a = strM7367a == null ? new zzca(context).m7398a("google_app_id") : strM7367a;
        if (TextUtils.isEmpty(strM7367a)) {
            this.f6334d = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f6333c = null;
        } else {
            this.f6333c = strM7367a;
            this.f6334d = Status.f6129a;
        }
    }

    /* JADX INFO: renamed from: a */
    public static Status m7155a(Context context) {
        Status status;
        com.google.android.gms.common.internal.zzbq.m7374a(context, "Context must not be null.");
        synchronized (f6331a) {
            if (f6332b == null) {
                f6332b = new zzbz(context);
            }
            status = f6332b.f6334d;
        }
        return status;
    }

    /* JADX INFO: renamed from: a */
    private static zzbz m7156a(String str) {
        zzbz zzbzVar;
        synchronized (f6331a) {
            if (f6332b == null) {
                throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 34).append("Initialize must be called before ").append(str).append(FileUtils.HIDDEN_PREFIX).toString());
            }
            zzbzVar = f6332b;
        }
        return zzbzVar;
    }

    /* JADX INFO: renamed from: a */
    public static String m7157a() {
        return m7156a("getGoogleAppId").f6333c;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m7158b() {
        return m7156a("isMeasurementExplicitlyDisabled").f6336f;
    }
}
