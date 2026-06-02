package android.support.v4.os;

import android.os.Trace;
import android.os.Build.VERSION;

public final class TraceCompat {
   public static void a() {
      if (VERSION.SDK_INT >= 18) {
         Trace.endSection();
      }
   }

   public static void a(String var0) {
      if (VERSION.SDK_INT >= 18) {
         Trace.beginSection(var0);
      }
   }
}
