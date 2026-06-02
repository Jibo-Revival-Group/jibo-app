package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class StringSignature implements Key {
   private final String a;

   public StringSignature(String var1) {
      if (var1 == null) {
         throw new NullPointerException("Signature cannot be null!");
      }

      this.a = var1;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (this == var1) {
         var2 = true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         var1 = var1;
         var2 = this.a.equals(var1.a);
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return this.a.hashCode();
   }

   @Override
   public String toString() {
      return "StringSignature{signature='" + this.a + '\'' + '}';
   }

   @Override
   public void updateDiskCacheKey(MessageDigest var1) throws UnsupportedEncodingException {
      var1.update(this.a.getBytes("UTF-8"));
   }
}
