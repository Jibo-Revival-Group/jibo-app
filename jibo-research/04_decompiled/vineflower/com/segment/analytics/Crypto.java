package com.segment.analytics;

import java.io.InputStream;
import java.io.OutputStream;

public abstract class Crypto {
   public static Crypto none() {
      return new Crypto() {
         @Override
         InputStream decrypt(InputStream var1) {
            return var1;
         }

         @Override
         OutputStream encrypt(OutputStream var1) {
            return var1;
         }
      };
   }

   abstract InputStream decrypt(InputStream var1);

   abstract OutputStream encrypt(OutputStream var1);
}
