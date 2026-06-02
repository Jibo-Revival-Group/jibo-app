package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;

/* JADX INFO: loaded from: classes.dex */
public final class zzak {

    /* JADX INFO: renamed from: a */
    private static final Uri f6557a;

    /* JADX INFO: renamed from: b */
    private static final Uri f6558b;

    static {
        Uri uri = Uri.parse("https://plus.google.com/");
        f6557a = uri;
        f6558b = uri.buildUpon().appendPath("circles").appendPath("find").build();
    }

    /* JADX INFO: renamed from: a */
    public static Intent m7351a() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }

    /* JADX INFO: renamed from: a */
    public static Intent m7352a(String str) {
        Uri uriFromParts = Uri.fromParts("package", str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(uriFromParts);
        return intent;
    }

    /* JADX INFO: renamed from: a */
    public static Intent m7353a(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri.Builder builderAppendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter(ShareConstants.WEB_DIALOG_PARAM_ID, str);
        if (!TextUtils.isEmpty(str2)) {
            builderAppendQueryParameter.appendQueryParameter("pcampaignid", str2);
        }
        intent.setData(builderAppendQueryParameter.build());
        intent.setPackage("com.android.vending");
        intent.addFlags(524288);
        return intent;
    }
}
