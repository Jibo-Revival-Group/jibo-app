package com.google.android.gms.common.util;

import java.io.Closeable;
import java.io.IOException;

public final class zzn {
   public static void a(Closeable var0) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (IOException var1) {
         }
      }
   }
}
