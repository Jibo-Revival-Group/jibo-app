package com.google.maps.internal;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
public class UrlSigner {
    private static final String ALGORITHM_HMAC_SHA1 = "HmacSHA1";
    private final Mac mac;

    public UrlSigner(String str) throws NoSuchAlgorithmException, InvalidKeyException {
        ByteString byteStringM16319b = ByteString.m16319b(str.replace('-', '+').replace('_', '/'));
        if (byteStringM16319b == null) {
            throw new IllegalArgumentException("Private key is invalid.");
        }
        this.mac = Mac.getInstance(ALGORITHM_HMAC_SHA1);
        this.mac.init(new SecretKeySpec(byteStringM16319b.mo16337i(), ALGORITHM_HMAC_SHA1));
    }

    public String getSignature(String str) {
        return ByteString.m16318a(getMac().doFinal(str.getBytes())).mo16330b().replace('+', '-').replace('/', '_');
    }

    private Mac getMac() {
        try {
            return (Mac) this.mac.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
    }
}
