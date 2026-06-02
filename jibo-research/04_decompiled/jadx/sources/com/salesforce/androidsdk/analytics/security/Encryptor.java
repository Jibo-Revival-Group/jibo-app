package com.salesforce.androidsdk.analytics.security;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.salesforce.androidsdk.analytics.util.SalesforceAnalyticsLogger;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class Encryptor {

    /* JADX INFO: renamed from: a */
    private static String f14074a;

    /* JADX INFO: renamed from: b */
    private static boolean f14075b;

    /* JADX INFO: renamed from: a */
    public static boolean m14368a(Context context) {
        f14075b = ((DevicePolicyManager) context.getSystemService("device_policy")).getStorageEncryptionStatus() == 3;
        f14074a = null;
        try {
            m14367a();
        } catch (GeneralSecurityException e) {
            SalesforceAnalyticsLogger.m14396a(context, "Encryptor", "Security exception thrown", e);
        }
        if (f14074a == null) {
            return false;
        }
        try {
            Mac.getInstance("HmacSHA256", "BC");
            return true;
        } catch (GeneralSecurityException e2) {
            SalesforceAnalyticsLogger.m14396a(context, "Encryptor", "No MAC transformation available", e2);
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public static Cipher m14367a() throws GeneralSecurityException {
        GeneralSecurityException e;
        Cipher cipher;
        if (f14074a != null) {
            return Cipher.getInstance(f14074a, "BC");
        }
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
            if (cipher != null) {
                try {
                    f14074a = "AES/CBC/PKCS5Padding";
                } catch (GeneralSecurityException e2) {
                    e = e2;
                    SalesforceAnalyticsLogger.m14396a((Context) null, "Encryptor", "Preferred combo not available", e);
                }
            }
        } catch (GeneralSecurityException e3) {
            e = e3;
            cipher = null;
        }
        if (f14074a == null) {
            SalesforceAnalyticsLogger.m14395a((Context) null, "Encryptor", "No cipher transformation available");
            return cipher;
        }
        return cipher;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m14372b() {
        return f14075b;
    }

    /* JADX INFO: renamed from: a */
    public static String m14365a(String str, String str2) {
        return (TextUtils.isEmpty(str2) || str == null) ? str : m14366a(str.getBytes(), str2);
    }

    /* JADX INFO: renamed from: a */
    public static String m14366a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            if (bArr != null) {
                return new String(bArr, Charset.forName(HTTP.UTF_8));
            }
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            byte[] bArrDecode2 = Base64.decode(bArr, 0);
            byte[] bArrM14369a = m14369a(bArrDecode2, 0, bArrDecode2.length, bArrDecode);
            return new String(bArrM14369a, 0, bArrM14369a.length, HTTP.UTF_8);
        } catch (Exception e) {
            SalesforceAnalyticsLogger.m14400b(null, "Encryptor", "Error during decryption", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static String m14371b(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str != null) {
            byte[] bArrM14374c = m14374c(str, str2);
            if (bArrM14374c == null) {
                return null;
            }
            try {
                return new String(bArrM14374c, "US-ASCII");
            } catch (UnsupportedEncodingException e) {
                SalesforceAnalyticsLogger.m14400b(null, "Encryptor", "Error during encryption", e);
                return null;
            }
        }
        return str;
    }

    /* JADX INFO: renamed from: c */
    public static byte[] m14374c(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            if (str == null) {
                return null;
            }
            return str.getBytes();
        }
        try {
            return Base64.encode(m14370a(str.getBytes(HTTP.UTF_8), Base64.decode(str2, 0)), 0);
        } catch (Exception e) {
            SalesforceAnalyticsLogger.m14400b(null, "Encryptor", "Error during encryption", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    public static String m14375d(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes(HTTP.UTF_8);
            byte[] bytes2 = str.getBytes(HTTP.UTF_8);
            Mac mac = Mac.getInstance("HmacSHA256", "BC");
            mac.init(new SecretKeySpec(bytes, mac.getAlgorithm()));
            return Base64.encodeToString(mac.doFinal(bytes2), 2);
        } catch (Exception e) {
            SalesforceAnalyticsLogger.m14400b(null, "Encryptor", "Error during hashing", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    private static byte[] m14373c() throws NoSuchAlgorithmException, NoSuchProviderException {
        byte[] bArr = new byte[16];
        SecureRandom.getInstance("SHA1PRNG").nextBytes(bArr);
        return bArr;
    }

    /* JADX INFO: renamed from: a */
    private static byte[] m14370a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher cipherM14367a = m14367a();
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, cipherM14367a.getAlgorithm());
        byte[] bArrM14373c = m14373c();
        cipherM14367a.init(1, secretKeySpec, new IvParameterSpec(bArrM14373c));
        byte[] bArrDoFinal = cipherM14367a.doFinal(bArr);
        byte[] bArr3 = new byte[bArrM14373c.length + bArrDoFinal.length];
        System.arraycopy(bArrM14373c, 0, bArr3, 0, bArrM14373c.length);
        System.arraycopy(bArrDoFinal, 0, bArr3, bArrM14373c.length, bArrDoFinal.length);
        return bArr3;
    }

    /* JADX INFO: renamed from: a */
    private static byte[] m14369a(byte[] bArr, int i, int i2, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr, i, bArr3, 0, bArr3.length);
        int length = i2 - bArr3.length;
        byte[] bArr4 = new byte[length];
        System.arraycopy(bArr, bArr3.length + i, bArr4, 0, length);
        Cipher cipherM14367a = m14367a();
        cipherM14367a.init(2, new SecretKeySpec(bArr2, cipherM14367a.getAlgorithm()), new IvParameterSpec(bArr3));
        return cipherM14367a.doFinal(bArr4, 0, length);
    }
}
