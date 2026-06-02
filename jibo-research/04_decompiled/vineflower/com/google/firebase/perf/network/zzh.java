package com.google.firebase.perf.network;

import android.util.Log;
import com.google.android.gms.internal.zzevv;
import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;

public final class zzh {
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static Long a(HttpMessage var0) {
      try {
         var5 = var0.getFirstHeader("content-length");
      } catch (NumberFormatException var4) {
         Log.d("FirebasePerformance", "The content-length value is not a valid number");
         return null;
      }

      if (var5 != null) {
         long var1;
         try {
            var1 = Long.parseLong(var5.getValue());
         } catch (NumberFormatException var3) {
            Log.d("FirebasePerformance", "The content-length value is not a valid number");
            return null;
         }

         return var1;
      } else {
         return null;
      }
   }

   public static String a(HttpResponse var0) {
      Header var1 = var0.getFirstHeader("content-type");
      if (var1 != null) {
         String var2 = var1.getValue();
         if (var2 != null) {
            return var2;
         }
      }

      return null;
   }

   public static void a(zzevv var0) {
      if (var0.a() == null) {
         var0.b();
      }

      var0.d();
   }
}
