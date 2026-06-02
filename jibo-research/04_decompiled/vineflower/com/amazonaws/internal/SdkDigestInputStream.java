package com.amazonaws.internal;

import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class SdkDigestInputStream extends DigestInputStream {
   static final boolean $assertionsDisabled;

   static {
      boolean var0;
      if (!SdkDigestInputStream.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public SdkDigestInputStream(InputStream var1, MessageDigest var2) {
      super(var1, var2);
   }

   @Override
   public final long skip(long var1) {
      long var6;
      if (var1 <= 0L) {
         var6 = var1;
      } else {
         byte[] var8 = new byte[(int)Math.min(2048L, var1)];
         long var4 = var1;

         while (true) {
            if (var4 <= 0L) {
               var6 = var1;
               if (!$assertionsDisabled) {
                  var6 = var1;
                  if (var4 != 0L) {
                     throw new AssertionError();
                  }
               }
               break;
            }

            int var3 = this.read(var8, 0, (int)Math.min(var4, var8.length));
            if (var3 == -1) {
               if (var4 == var1) {
                  var1 = -1L;
               } else {
                  var1 -= var4;
               }

               var6 = var1;
               break;
            }

            var4 -= var3;
         }
      }

      return var6;
   }
}
