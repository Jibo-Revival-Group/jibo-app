package com.google.android.gms.internal;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.util.concurrent.Callable;

public final class zzcbc {
   public static <T> T a(Callable<T> var0) throws Exception {
      ThreadPolicy var1 = StrictMode.getThreadPolicy();

      try {
         StrictMode.setThreadPolicy(ThreadPolicy.LAX);
         return (T)var0.call();
      } finally {
         StrictMode.setThreadPolicy(var1);
      }
   }
}
