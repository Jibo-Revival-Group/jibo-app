package io.fabric.sdk.android.services.settings;

import android.content.Context;
import android.graphics.BitmapFactory;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.CommonUtils;

/* JADX INFO: loaded from: classes2.dex */
public class IconRequest {

    /* JADX INFO: renamed from: a */
    public final String f14764a;

    /* JADX INFO: renamed from: b */
    public final int f14765b;

    /* JADX INFO: renamed from: c */
    public final int f14766c;

    /* JADX INFO: renamed from: d */
    public final int f14767d;

    public IconRequest(String str, int i, int i2, int i3) {
        this.f14764a = str;
        this.f14765b = i;
        this.f14766c = i2;
        this.f14767d = i3;
    }

    /* JADX INFO: renamed from: a */
    public static IconRequest m15454a(Context context, String str) {
        if (str != null) {
            try {
                int iM15209l = CommonUtils.m15209l(context);
                Fabric.m15085h().mo15063a("Fabric", "App icon resource ID is " + iM15209l);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), iM15209l, options);
                return new IconRequest(str, iM15209l, options.outWidth, options.outHeight);
            } catch (Exception e) {
                Fabric.m15085h().mo15073e("Fabric", "Failed to load icon", e);
            }
        }
        return null;
    }
}
