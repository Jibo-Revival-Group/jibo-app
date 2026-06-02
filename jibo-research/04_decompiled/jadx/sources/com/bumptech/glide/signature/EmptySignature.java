package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class EmptySignature implements Key {

    /* JADX INFO: renamed from: a */
    private static final EmptySignature f4996a = new EmptySignature();

    /* JADX INFO: renamed from: a */
    public static EmptySignature m5570a() {
        return f4996a;
    }

    private EmptySignature() {
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
    }
}
