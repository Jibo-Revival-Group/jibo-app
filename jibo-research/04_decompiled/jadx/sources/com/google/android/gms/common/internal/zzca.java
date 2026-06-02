package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.R;

/* JADX INFO: loaded from: classes.dex */
public final class zzca {

    /* JADX INFO: renamed from: a */
    private final Resources f6588a;

    /* JADX INFO: renamed from: b */
    private final String f6589b;

    public zzca(Context context) {
        zzbq.m7373a(context);
        this.f6588a = context.getResources();
        this.f6589b = this.f6588a.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }

    /* JADX INFO: renamed from: a */
    public final String m7398a(String str) {
        int identifier = this.f6588a.getIdentifier(str, "string", this.f6589b);
        if (identifier == 0) {
            return null;
        }
        return this.f6588a.getString(identifier);
    }
}
