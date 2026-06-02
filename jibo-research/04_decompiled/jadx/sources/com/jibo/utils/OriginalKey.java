package com.jibo.utils;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.signature.EmptySignature;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class OriginalKey implements Key {

    /* JADX INFO: renamed from: a */
    private final String f11683a;

    /* JADX INFO: renamed from: b */
    private final Key f11684b;

    public OriginalKey(String str, Key key) {
        this.f11683a = str;
        this.f11684b = key;
    }

    /* JADX INFO: renamed from: a */
    public String m11419a() {
        return this.f11683a;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OriginalKey originalKey = (OriginalKey) obj;
        return this.f11683a.equals(originalKey.f11683a) && this.f11684b.equals(originalKey.f11684b);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.f11683a.hashCode() * 31) + this.f11684b.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.f11683a.getBytes(HTTP.UTF_8));
        this.f11684b.updateDiskCacheKey(messageDigest);
    }

    /* JADX INFO: renamed from: a */
    public static String m11418a(String str) {
        try {
            OriginalKey originalKey = new OriginalKey(str, EmptySignature.m5570a());
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            originalKey.updateDiskCacheKey(messageDigest);
            return com.bumptech.glide.util.Util.m5588a(messageDigest.digest()) + ".0";
        } catch (UnsupportedEncodingException e) {
            return null;
        } catch (NoSuchAlgorithmException e2) {
            return null;
        }
    }
}
