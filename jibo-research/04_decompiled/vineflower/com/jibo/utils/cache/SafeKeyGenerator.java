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

public class SafeKeyGenerator {
   private final LruCache<Key, String> a = new LruCache<>(1000);
   private final Pools.Pool<SafeKeyGenerator.PoolableDigestContainer> b = FactoryPools.a(
      10, new FactoryPools.Factory<SafeKeyGenerator.PoolableDigestContainer>(this) {
         final SafeKeyGenerator a;

         {
            this.a = var1;
         }

         public SafeKeyGenerator.PoolableDigestContainer a() {
            try {
               return new SafeKeyGenerator.PoolableDigestContainer(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException var2) {
               throw new RuntimeException(var2);
            }
         }
      }
   );

   private String b(Key var1) {
      SafeKeyGenerator.PoolableDigestContainer var2 = this.b.a();

      try {
         var1.updateDiskCacheKey(var2.a);
         return Util.a(var2.a.digest());
      } catch (UnsupportedEncodingException var5) {
      } finally {
         this.b.a(var2);
      }

      return null;
   }

   public String a(Key param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/jibo/utils/cache/SafeKeyGenerator.a Lcom/bumptech/glide/util/LruCache;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/jibo/utils/cache/SafeKeyGenerator.a Lcom/bumptech/glide/util/LruCache;
      // 0b: aload 1
      // 0c: invokevirtual com/bumptech/glide/util/LruCache.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 0f: checkcast java/lang/String
      // 12: astore 3
      // 13: aload 2
      // 14: monitorexit
      // 15: aload 3
      // 16: astore 2
      // 17: aload 3
      // 18: ifnonnull 21
      // 1b: aload 0
      // 1c: aload 1
      // 1d: invokespecial com/jibo/utils/cache/SafeKeyGenerator.b (Lcom/bumptech/glide/load/Key;)Ljava/lang/String;
      // 20: astore 2
      // 21: aload 0
      // 22: getfield com/jibo/utils/cache/SafeKeyGenerator.a Lcom/bumptech/glide/util/LruCache;
      // 25: astore 3
      // 26: aload 3
      // 27: monitorenter
      // 28: aload 0
      // 29: getfield com/jibo/utils/cache/SafeKeyGenerator.a Lcom/bumptech/glide/util/LruCache;
      // 2c: aload 1
      // 2d: aload 2
      // 2e: invokevirtual com/bumptech/glide/util/LruCache.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 31: pop
      // 32: aload 3
      // 33: monitorexit
      // 34: aload 2
      // 35: areturn
      // 36: astore 1
      // 37: aload 2
      // 38: monitorexit
      // 39: aload 1
      // 3a: athrow
      // 3b: astore 1
      // 3c: aload 3
      // 3d: monitorexit
      // 3e: aload 1
      // 3f: athrow
      // try (5 -> 13): 36 null
      // try (26 -> 34): 41 null
      // try (37 -> 39): 36 null
      // try (42 -> 44): 41 null
   }

   private static final class PoolableDigestContainer implements FactoryPools.Poolable {
      private final MessageDigest a;
      private final StateVerifier b = StateVerifier.a();

      PoolableDigestContainer(MessageDigest var1) {
         this.a = var1;
      }

      @Override
      public StateVerifier a() {
         return this.b;
      }
   }
}
