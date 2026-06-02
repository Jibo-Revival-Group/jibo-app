package com.google.firebase.perf.network;

import android.support.annotation.Keep;
import com.google.android.gms.internal.zzevv;
import com.google.android.gms.internal.zzevz;
import com.google.android.gms.internal.zzewn;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class FirebasePerfOkHttpClient {
   private FirebasePerfOkHttpClient() {
   }

   static void a(Response var0, zzevv var1, long var2, long var4) throws IOException {
      Request var8 = var0.a();
      if (var8 != null) {
         var1.a(var8.a().a().toString());
         var1.b(var8.b());
         if (var8.d() != null) {
            long var6 = var8.d().b();
            if (var6 != -1L) {
               var1.a(var6);
            }
         }

         ResponseBody var10 = var0.h();
         if (var10 != null) {
            long var9 = var10.b();
            if (var9 != -1L) {
               var1.b(var9);
            }

            MediaType var11 = var10.a();
            if (var11 != null) {
               var1.c(var11.toString());
            }
         }

         var1.a(var0.c());
         var1.c(var2);
         var1.f(var4);
         var1.d();
      }
   }

   @Keep
   public static void enqueue(Call var0, Callback var1) {
      zzewn var4 = new zzewn();
      long var2 = var4.b();
      var0.a(new zzg(var1, zzevz.a(), var4, var2));
   }

   @Keep
   public static Response execute(Call var0) throws IOException {
      zzevv var4 = zzevv.a(zzevz.a());
      zzewn var3 = new zzewn();
      long var1 = var3.b();

      try {
         Response var5 = var0.b();
         a(var5, var4, var1, var3.c());
         return var5;
      } catch (IOException var7) {
         Request var6 = var0.a();
         if (var6 != null) {
            HttpUrl var8 = var6.a();
            if (var8 != null) {
               var4.a(var8.a().toString());
            }

            if (var6.b() != null) {
               var4.b(var6.b());
            }
         }

         var4.c(var1);
         var4.f(var3.c());
         zzh.a(var4);
         throw var7;
      }
   }
}
