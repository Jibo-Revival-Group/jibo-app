package com.jibo.utils;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.signature.EmptySignature;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class OriginalKey implements Key {
   private final String a;
   private final Key b;

   public OriginalKey(String var1, Key var2) {
      this.a = var1;
      this.b = var2;
   }

   public static String a(String var0) {
      Object var1 = null;

      try {
         OriginalKey var2 = new OriginalKey(var0, EmptySignature.a());
         MessageDigest var6 = MessageDigest.getInstance("SHA-256");
         var2.updateDiskCacheKey(var6);
         StringBuilder var7 = new StringBuilder();
         var0 = var7.append(com.bumptech.glide.util.Util.a(var6.digest())).append(".0").toString();
      } catch (UnsupportedEncodingException var3) {
         var0 = (String)var1;
      } catch (NoSuchAlgorithmException var4) {
         var0 = (String)var1;
      }

      return var0;
   }

   public String a() {
      return this.a;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 != null && this.getClass() == var1.getClass()) {
            var1 = var1;
            if (!this.a.equals(var1.a)) {
               var2 = false;
            } else if (!this.b.equals(var1.b)) {
               var2 = false;
            }
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return this.a.hashCode() * 31 + this.b.hashCode();
   }

   @Override
   public void updateDiskCacheKey(MessageDigest var1) throws UnsupportedEncodingException {
      var1.update(this.a.getBytes("UTF-8"));
      this.b.updateDiskCacheKey(var1);
   }
}
