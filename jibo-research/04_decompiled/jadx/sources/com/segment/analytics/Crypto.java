package com.segment.analytics;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class Crypto {
    abstract InputStream decrypt(InputStream inputStream);

    abstract OutputStream encrypt(OutputStream outputStream);

    public static Crypto none() {
        return new Crypto() { // from class: com.segment.analytics.Crypto.1
            @Override // com.segment.analytics.Crypto
            InputStream decrypt(InputStream inputStream) {
                return inputStream;
            }

            @Override // com.segment.analytics.Crypto
            OutputStream encrypt(OutputStream outputStream) {
                return outputStream;
            }
        };
    }
}
