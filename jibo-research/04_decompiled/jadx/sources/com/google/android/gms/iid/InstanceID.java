package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.util.Base64;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class InstanceID {

    /* JADX INFO: renamed from: a */
    private static Map<String, InstanceID> f6785a = new ArrayMap();

    /* JADX INFO: renamed from: c */
    private static zzo f6786c;

    /* JADX INFO: renamed from: d */
    private static zzl f6787d;

    /* JADX INFO: renamed from: h */
    private static String f6788h;

    /* JADX INFO: renamed from: b */
    private Context f6789b;

    /* JADX INFO: renamed from: e */
    private KeyPair f6790e;

    /* JADX INFO: renamed from: f */
    private String f6791f;

    /* JADX INFO: renamed from: g */
    private long f6792g;

    private InstanceID(Context context, String str, Bundle bundle) {
        this.f6791f = "";
        this.f6789b = context.getApplicationContext();
        this.f6791f = str;
    }

    /* JADX INFO: renamed from: a */
    static int m7599a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            String strValueOf = String.valueOf(e);
            Log.w("InstanceID", new StringBuilder(String.valueOf(strValueOf).length() + 38).append("Never happens: can't find own package ").append(strValueOf).toString());
            return 0;
        }
    }

    /* JADX INFO: renamed from: a */
    public static synchronized InstanceID m7600a(Context context, Bundle bundle) {
        InstanceID instanceID;
        String string = bundle == null ? "" : bundle.getString("subtype");
        String str = string == null ? "" : string;
        Context applicationContext = context.getApplicationContext();
        if (f6786c == null) {
            f6786c = new zzo(applicationContext);
            f6787d = new zzl(applicationContext);
        }
        f6788h = Integer.toString(m7599a(applicationContext));
        instanceID = f6785a.get(str);
        if (instanceID == null) {
            instanceID = new InstanceID(applicationContext, str, bundle);
            f6785a.put(str, instanceID);
        }
        return instanceID;
    }

    /* JADX INFO: renamed from: a */
    static String m7601a(KeyPair keyPair) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            bArrDigest[0] = (byte) ((bArrDigest[0] & 15) + 112);
            return Base64.encodeToString(bArrDigest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("InstanceID", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    static String m7602a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    /* JADX INFO: renamed from: b */
    static String m7603b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            String strValueOf = String.valueOf(e);
            Log.w("InstanceID", new StringBuilder(String.valueOf(strValueOf).length() + 38).append("Never happens: can't find own package ").append(strValueOf).toString());
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static InstanceID m7604c(Context context) {
        return m7600a(context, null);
    }

    /* JADX INFO: renamed from: c */
    public static zzo m7605c() {
        return f6786c;
    }

    /* JADX INFO: renamed from: d */
    private final KeyPair m7606d() {
        if (this.f6790e == null) {
            this.f6790e = f6786c.m7654d(this.f6791f);
        }
        if (this.f6790e == null) {
            this.f6792g = System.currentTimeMillis();
            this.f6790e = f6786c.m7647a(this.f6791f, this.f6792g);
        }
        return this.f6790e;
    }

    /* JADX INFO: renamed from: a */
    public void m7607a() throws IOException {
        m7608a("*", "*", null);
        m7610b();
    }

    /* JADX INFO: renamed from: a */
    public final void m7608a(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        f6786c.m7652b(this.f6791f, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        bundle.putString("X-delete", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        bundle.putString("subtype", "".equals(this.f6791f) ? str : this.f6791f);
        if (!"".equals(this.f6791f)) {
            str = this.f6791f;
        }
        bundle.putString("X-subtype", str);
        zzl.m7626a(f6787d.m7639a(bundle, m7606d()));
    }

    /* JADX INFO: renamed from: b */
    public String m7609b(String str, String str2, Bundle bundle) throws IOException {
        String strM7644a;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        String strM7644a2 = f6786c.m7644a("appVersion");
        boolean z = (strM7644a2 == null || !strM7644a2.equals(f6788h) || (strM7644a = f6786c.m7644a("lastToken")) == null) ? true : (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(strM7644a)).longValue() > 604800;
        String strM7646a = z ? null : f6786c.m7646a(this.f6791f, str, str2);
        if (strM7646a == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            boolean z2 = "jwt".equals(bundle.getString(ShareConstants.MEDIA_TYPE)) ? false : bundle.getString("ttl") == null;
            strM7646a = m7611c(str, str2, bundle);
            if (strM7646a != null && z2) {
                f6786c.m7648a(this.f6791f, str, str2, strM7646a, f6788h);
            }
        }
        return strM7646a;
    }

    /* JADX INFO: renamed from: b */
    public final void m7610b() {
        this.f6792g = 0L;
        f6786c.m7651b(String.valueOf(this.f6791f).concat("|"));
        this.f6790e = null;
    }

    /* JADX INFO: renamed from: c */
    public final String m7611c(String str, String str2, Bundle bundle) throws IOException {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.f6791f) ? str : this.f6791f;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        return zzl.m7626a(f6787d.m7639a(bundle, m7606d()));
    }
}
