package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes.dex */
final class zzy {

    /* JADX INFO: renamed from: a */
    private SharedPreferences f8701a;

    /* JADX INFO: renamed from: b */
    private Context f8702b;

    public zzy(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    private zzy(Context context, String str) {
        this.f8702b = context;
        this.f8701a = context.getSharedPreferences(str, 0);
        String strValueOf = String.valueOf(str);
        String strValueOf2 = String.valueOf("-no-backup");
        File file = new File(com.google.android.gms.common.util.zzv.m7521a(this.f8702b), strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf));
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || m9177c()) {
                return;
            }
            Log.i("FirebaseInstanceId", "App restored, clearing state");
            m9184b();
            FirebaseInstanceId.m9094a().m9111i();
        } catch (IOException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf3 = String.valueOf(e.getMessage());
                Log.d("FirebaseInstanceId", strValueOf3.length() != 0 ? "Error creating file in no backup dir: ".concat(strValueOf3) : new String("Error creating file in no backup dir: "));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m9175a(String str, String str2) {
        return new StringBuilder(String.valueOf(str).length() + String.valueOf("|S|").length() + String.valueOf(str2).length()).append(str).append("|S|").append(str2).toString();
    }

    /* JADX INFO: renamed from: b */
    private static String m9176b(String str, String str2, String str3) {
        return new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf("|T|").length() + String.valueOf(str2).length() + String.valueOf(str3).length()).append(str).append("|T|").append(str2).append("|").append(str3).toString();
    }

    /* JADX INFO: renamed from: c */
    private final synchronized boolean m9177c() {
        return this.f8701a.getAll().isEmpty();
    }

    /* JADX INFO: renamed from: f */
    private final void m9178f(String str) {
        SharedPreferences.Editor editorEdit = this.f8701a.edit();
        for (String str2 : this.f8701a.getAll().keySet()) {
            if (str2.startsWith(str)) {
                editorEdit.remove(str2);
            }
        }
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: a */
    public final synchronized zzz m9179a(String str, String str2, String str3) {
        return zzz.m9188a(this.f8701a.getString(m9176b(str, str2, str3), null));
    }

    /* JADX INFO: renamed from: a */
    public final synchronized String m9180a() {
        String str = null;
        synchronized (this) {
            String string = this.f8701a.getString("topic_operaion_queue", null);
            if (string != null) {
                String[] strArrSplit = string.split(",");
                if (strArrSplit.length > 1 && !TextUtils.isEmpty(strArrSplit[1])) {
                    str = strArrSplit[1];
                }
            }
        }
        return str;
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m9181a(String str, String str2, String str3, String str4, String str5) {
        String strM9189a = zzz.m9189a(str4, str5, System.currentTimeMillis());
        if (strM9189a != null) {
            SharedPreferences.Editor editorEdit = this.f8701a.edit();
            editorEdit.putString(m9176b(str, str2, str3), strM9189a);
            editorEdit.commit();
        }
    }

    /* JADX INFO: renamed from: a */
    public final synchronized boolean m9182a(String str) {
        boolean z;
        String string = this.f8701a.getString("topic_operaion_queue", "");
        String strValueOf = String.valueOf(",");
        String strValueOf2 = String.valueOf(str);
        if (string.startsWith(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf))) {
            String strValueOf3 = String.valueOf(",");
            String strValueOf4 = String.valueOf(str);
            this.f8701a.edit().putString("topic_operaion_queue", string.substring((strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3)).length())).apply();
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    /* JADX INFO: renamed from: b */
    final synchronized KeyPair m9183b(String str) {
        KeyPair keyPairM9118a;
        keyPairM9118a = zza.m9118a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.f8701a.edit();
        editorEdit.putString(m9175a(str, "|P|"), Base64.encodeToString(keyPairM9118a.getPublic().getEncoded(), 11));
        editorEdit.putString(m9175a(str, "|K|"), Base64.encodeToString(keyPairM9118a.getPrivate().getEncoded(), 11));
        editorEdit.putString(m9175a(str, "cre"), Long.toString(jCurrentTimeMillis));
        editorEdit.commit();
        return keyPairM9118a;
    }

    /* JADX INFO: renamed from: b */
    public final synchronized void m9184b() {
        this.f8701a.edit().clear().commit();
    }

    /* JADX INFO: renamed from: c */
    final synchronized void m9185c(String str) {
        m9178f(String.valueOf(str).concat("|"));
    }

    /* JADX INFO: renamed from: d */
    public final synchronized void m9186d(String str) {
        m9178f(String.valueOf(str).concat("|T|"));
    }

    /* JADX INFO: renamed from: e */
    public final synchronized KeyPair m9187e(String str) {
        KeyPair keyPair;
        String string = this.f8701a.getString(m9175a(str, "|P|"), null);
        String string2 = this.f8701a.getString(m9175a(str, "|K|"), null);
        if (string == null || string2 == null) {
            keyPair = null;
        } else {
            try {
                byte[] bArrDecode = Base64.decode(string, 8);
                byte[] bArrDecode2 = Base64.decode(string2, 8);
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                keyPair = new KeyPair(keyFactory.generatePublic(new X509EncodedKeySpec(bArrDecode)), keyFactory.generatePrivate(new PKCS8EncodedKeySpec(bArrDecode2)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                String strValueOf = String.valueOf(e);
                Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf).length() + 19).append("Invalid key stored ").append(strValueOf).toString());
                FirebaseInstanceId.m9094a().m9111i();
                keyPair = null;
            }
        }
        return keyPair;
    }
}
