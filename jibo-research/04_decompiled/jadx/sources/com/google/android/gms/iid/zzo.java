package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.zzv;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class zzo {

    /* JADX INFO: renamed from: a */
    private SharedPreferences f6837a;

    /* JADX INFO: renamed from: b */
    private Context f6838b;

    public zzo(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    private zzo(Context context, String str) {
        this.f6838b = context;
        this.f6837a = context.getSharedPreferences(str, 0);
        String strValueOf = String.valueOf(str);
        String strValueOf2 = String.valueOf("-no-backup");
        File file = new File(zzv.m7521a(this.f6838b), strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf));
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || m7649a()) {
                return;
            }
            Log.i("InstanceID/Store", "App restored, clearing state");
            InstanceIDListenerService.m7612a(this.f6838b, this);
        } catch (IOException e) {
            if (Log.isLoggable("InstanceID/Store", 3)) {
                String strValueOf3 = String.valueOf(e.getMessage());
                Log.d("InstanceID/Store", strValueOf3.length() != 0 ? "Error creating file in no backup dir: ".concat(strValueOf3) : new String("Error creating file in no backup dir: "));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private final synchronized void m7642a(SharedPreferences.Editor editor, String str, String str2, String str3) {
        editor.putString(new StringBuilder(String.valueOf(str).length() + String.valueOf("|S|").length() + String.valueOf(str2).length()).append(str).append("|S|").append(str2).toString(), str3);
    }

    /* JADX INFO: renamed from: c */
    private static String m7643c(String str, String str2, String str3) {
        return new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf("|T|").length() + String.valueOf(str2).length() + String.valueOf(str3).length()).append(str).append("|T|").append(str2).append("|").append(str3).toString();
    }

    /* JADX INFO: renamed from: a */
    final synchronized String m7644a(String str) {
        return this.f6837a.getString(str, null);
    }

    /* JADX INFO: renamed from: a */
    final synchronized String m7645a(String str, String str2) {
        return this.f6837a.getString(new StringBuilder(String.valueOf(str).length() + String.valueOf("|S|").length() + String.valueOf(str2).length()).append(str).append("|S|").append(str2).toString(), null);
    }

    /* JADX INFO: renamed from: a */
    public final synchronized String m7646a(String str, String str2, String str3) {
        return this.f6837a.getString(m7643c(str, str2, str3), null);
    }

    /* JADX INFO: renamed from: a */
    final synchronized KeyPair m7647a(String str, long j) {
        KeyPair keyPairM7616a;
        keyPairM7616a = zza.m7616a();
        SharedPreferences.Editor editorEdit = this.f6837a.edit();
        m7642a(editorEdit, str, "|P|", InstanceID.m7602a(keyPairM7616a.getPublic().getEncoded()));
        m7642a(editorEdit, str, "|K|", InstanceID.m7602a(keyPairM7616a.getPrivate().getEncoded()));
        m7642a(editorEdit, str, "cre", Long.toString(j));
        editorEdit.commit();
        return keyPairM7616a;
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m7648a(String str, String str2, String str3, String str4, String str5) {
        String strM7643c = m7643c(str, str2, str3);
        SharedPreferences.Editor editorEdit = this.f6837a.edit();
        editorEdit.putString(strM7643c, str4);
        editorEdit.putString("appVersion", str5);
        editorEdit.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000));
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: a */
    public final boolean m7649a() {
        return this.f6837a.getAll().isEmpty();
    }

    /* JADX INFO: renamed from: b */
    public final synchronized void m7650b() {
        this.f6837a.edit().clear().commit();
    }

    /* JADX INFO: renamed from: b */
    public final synchronized void m7651b(String str) {
        SharedPreferences.Editor editorEdit = this.f6837a.edit();
        for (String str2 : this.f6837a.getAll().keySet()) {
            if (str2.startsWith(str)) {
                editorEdit.remove(str2);
            }
        }
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: b */
    public final synchronized void m7652b(String str, String str2, String str3) {
        String strM7643c = m7643c(str, str2, str3);
        SharedPreferences.Editor editorEdit = this.f6837a.edit();
        editorEdit.remove(strM7643c);
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: c */
    public final void m7653c(String str) {
        m7651b(String.valueOf(str).concat("|T|"));
    }

    /* JADX INFO: renamed from: d */
    final KeyPair m7654d(String str) {
        String strM7645a = m7645a(str, "|P|");
        String strM7645a2 = m7645a(str, "|K|");
        if (strM7645a == null || strM7645a2 == null) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(strM7645a, 8);
            byte[] bArrDecode2 = Base64.decode(strM7645a2, 8);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return new KeyPair(keyFactory.generatePublic(new X509EncodedKeySpec(bArrDecode)), keyFactory.generatePrivate(new PKCS8EncodedKeySpec(bArrDecode2)));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            String strValueOf = String.valueOf(e);
            Log.w("InstanceID/Store", new StringBuilder(String.valueOf(strValueOf).length() + 19).append("Invalid key stored ").append(strValueOf).toString());
            InstanceIDListenerService.m7612a(this.f6838b, this);
            return null;
        }
    }
}
