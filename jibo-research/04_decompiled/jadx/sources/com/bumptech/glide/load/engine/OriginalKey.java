package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
class OriginalKey implements Key {

    /* JADX INFO: renamed from: id */
    private final String f4885id;
    private final Key signature;

    public OriginalKey(String str, Key key) {
        this.f4885id = str;
        this.signature = key;
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
        return this.f4885id.equals(originalKey.f4885id) && this.signature.equals(originalKey.signature);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.f4885id.hashCode() * 31) + this.signature.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.f4885id.getBytes(HTTP.UTF_8));
        this.signature.updateDiskCacheKey(messageDigest);
    }
}
