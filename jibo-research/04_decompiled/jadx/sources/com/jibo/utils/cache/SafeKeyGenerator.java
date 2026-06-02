package com.jibo.utils.cache;

import android.support.v4.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import com.jibo.utils.cache.pool.FactoryPools;
import com.jibo.utils.cache.pool.StateVerifier;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public class SafeKeyGenerator {

    /* JADX INFO: renamed from: a */
    private final LruCache<Key, String> f11714a = new LruCache<>(1000);

    /* JADX INFO: renamed from: b */
    private final Pools.Pool<PoolableDigestContainer> f11715b = FactoryPools.m11518a(10, new FactoryPools.Factory<PoolableDigestContainer>() { // from class: com.jibo.utils.cache.SafeKeyGenerator.1
        @Override // com.jibo.utils.cache.pool.FactoryPools.Factory
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoolableDigestContainer mo11515b() {
            try {
                return new PoolableDigestContainer(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    });

    /* JADX INFO: renamed from: a */
    public String m11513a(Key key) {
        String strM11512b;
        synchronized (this.f11714a) {
            strM11512b = this.f11714a.get(key);
        }
        if (strM11512b == null) {
            strM11512b = m11512b(key);
        }
        synchronized (this.f11714a) {
            this.f11714a.put(key, strM11512b);
        }
        return strM11512b;
    }

    /* JADX INFO: renamed from: b */
    private String m11512b(Key key) {
        PoolableDigestContainer poolableDigestContainerMo2438a = this.f11715b.mo2438a();
        try {
            key.updateDiskCacheKey(poolableDigestContainerMo2438a.f11717a);
            String strM5588a = Util.m5588a(poolableDigestContainerMo2438a.f11717a.digest());
            this.f11715b.mo2439a(poolableDigestContainerMo2438a);
            return strM5588a;
        } catch (UnsupportedEncodingException e) {
            this.f11715b.mo2439a(poolableDigestContainerMo2438a);
            return null;
        } catch (Throwable th) {
            this.f11715b.mo2439a(poolableDigestContainerMo2438a);
            throw th;
        }
    }

    private static final class PoolableDigestContainer implements FactoryPools.Poolable {

        /* JADX INFO: renamed from: a */
        private final MessageDigest f11717a;

        /* JADX INFO: renamed from: b */
        private final StateVerifier f11718b = StateVerifier.m11523a();

        PoolableDigestContainer(MessageDigest messageDigest) {
            this.f11717a = messageDigest;
        }

        @Override // com.jibo.utils.cache.pool.FactoryPools.Poolable
        /* JADX INFO: renamed from: a */
        public StateVerifier mo11517a() {
            return this.f11718b;
        }
    }
}
