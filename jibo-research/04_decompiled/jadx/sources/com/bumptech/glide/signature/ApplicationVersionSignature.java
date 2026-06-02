package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationVersionSignature {

    /* JADX INFO: renamed from: a */
    private static final ConcurrentHashMap<String, Key> f4995a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a */
    public static Key m5568a(Context context) {
        String packageName = context.getPackageName();
        Key key = f4995a.get(packageName);
        if (key == null) {
            Key keyM5569b = m5569b(context);
            Key keyPutIfAbsent = f4995a.putIfAbsent(packageName, keyM5569b);
            return keyPutIfAbsent == null ? keyM5569b : keyPutIfAbsent;
        }
        return key;
    }

    /* JADX INFO: renamed from: b */
    private static Key m5569b(Context context) {
        PackageInfo packageInfo;
        String string;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            string = String.valueOf(packageInfo.versionCode);
        } else {
            string = UUID.randomUUID().toString();
        }
        return new StringSignature(string);
    }
}
