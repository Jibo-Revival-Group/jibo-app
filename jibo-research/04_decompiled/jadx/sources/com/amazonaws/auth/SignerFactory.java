package com.amazonaws.auth;

import com.amazonaws.internal.config.InternalConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class SignerFactory {
    private static final Map<String, Class<? extends Signer>> SIGNERS = new ConcurrentHashMap();

    static {
        SIGNERS.put("QueryStringSignerType", QueryStringSigner.class);
        SIGNERS.put("AWS3SignerType", AWS3Signer.class);
        SIGNERS.put("AWS4SignerType", AWS4Signer.class);
        SIGNERS.put("NoOpSignerType", NoOpSigner.class);
    }

    private static Signer createSigner(String str, String str2) {
        Class<? extends Signer> cls = SIGNERS.get(str);
        if (cls == null) {
            throw new IllegalArgumentException();
        }
        try {
            Signer signerNewInstance = cls.newInstance();
            if (signerNewInstance instanceof ServiceAwareSigner) {
                ((ServiceAwareSigner) signerNewInstance).setServiceName(str2);
            }
            return signerNewInstance;
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Cannot create an instance of " + cls.getName(), e);
        } catch (InstantiationException e2) {
            throw new IllegalStateException("Cannot create an instance of " + cls.getName(), e2);
        }
    }

    public static Signer getSigner(String str, String str2) {
        return lookupAndCreateSigner(str, str2);
    }

    public static Signer getSignerByTypeAndService(String str, String str2) {
        return createSigner(str, str2);
    }

    private static Signer lookupAndCreateSigner(String str, String str2) {
        return createSigner(InternalConfig.Factory.getInternalConfig().getSignerConfig(str, str2).getSignerType(), str);
    }
}
