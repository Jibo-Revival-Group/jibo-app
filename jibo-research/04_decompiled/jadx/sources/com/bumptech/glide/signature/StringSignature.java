package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class StringSignature implements Key {

    /* JADX INFO: renamed from: a */
    private final String f4997a;

    public StringSignature(String str) {
        if (str == null) {
            throw new NullPointerException("Signature cannot be null!");
        }
        this.f4997a = str;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f4997a.equals(((StringSignature) obj).f4997a);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f4997a.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.f4997a.getBytes(HTTP.UTF_8));
    }

    public String toString() {
        return "StringSignature{signature='" + this.f4997a + "'}";
    }
}
