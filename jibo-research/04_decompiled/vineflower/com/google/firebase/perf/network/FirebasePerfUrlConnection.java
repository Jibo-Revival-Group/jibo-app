package com.google.firebase.perf.network;

import android.support.annotation.Keep;
import com.google.android.gms.internal.zzevv;
import com.google.android.gms.internal.zzevz;
import com.google.android.gms.internal.zzewn;
import com.google.android.gms.internal.zzewp;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class FirebasePerfUrlConnection {
   private FirebasePerfUrlConnection() {
   }

   private static InputStream a(zzewp var0, zzevz var1, zzewn var2) throws IOException {
      var2.a();
      long var3 = var2.b();
      zzevv var5 = zzevv.a(var1);

      try {
         URLConnection var9 = var0.a();
         if (var9 instanceof HttpsURLConnection) {
            zzd var13 = new zzd((HttpsURLConnection)var9, var2, var5);
            return var13.getInputStream();
         }

         if (var9 instanceof HttpURLConnection) {
            zzc var6 = new zzc((HttpURLConnection)var9, var2, var5);
            return var6.getInputStream();
         }

         var10 = var9.getInputStream();
      } catch (IOException var7) {
         var5.c(var3);
         var5.f(var2.c());
         var5.a(var0.toString());
         zzh.a(var5);
         throw var7;
      }

      return var10;
   }

   private static Object a(zzewp var0, Class[] var1, zzevz var2, zzewn var3) throws IOException {
      var3.a();
      long var4 = var3.b();
      zzevv var13 = zzevv.a(var2);

      try {
         URLConnection var6 = var0.a();
         if (var6 instanceof HttpsURLConnection) {
            zzd var14 = new zzd((HttpsURLConnection)var6, var3, var13);
            return var14.getContent(var1);
         }

         if (var6 instanceof HttpURLConnection) {
            zzc var7 = new zzc((HttpURLConnection)var6, var3, var13);
            return var7.getContent(var1);
         }

         var10 = var6.getContent(var1);
      } catch (IOException var8) {
         var13.c(var4);
         var13.f(var3.c());
         var13.a(var0.toString());
         zzh.a(var13);
         throw var8;
      }

      return var10;
   }

   private static Object b(zzewp var0, zzevz var1, zzewn var2) throws IOException {
      var2.a();
      long var3 = var2.b();
      zzevv var5 = zzevv.a(var1);

      try {
         URLConnection var9 = var0.a();
         if (var9 instanceof HttpsURLConnection) {
            zzd var13 = new zzd((HttpsURLConnection)var9, var2, var5);
            return var13.getContent();
         }

         if (var9 instanceof HttpURLConnection) {
            zzc var6 = new zzc((HttpURLConnection)var9, var2, var5);
            return var6.getContent();
         }

         var10 = var9.getContent();
      } catch (IOException var7) {
         var5.c(var3);
         var5.f(var2.c());
         var5.a(var0.toString());
         zzh.a(var5);
         throw var7;
      }

      return var10;
   }

   @Keep
   public static Object getContent(URL var0) throws IOException {
      return b(new zzewp(var0), zzevz.a(), new zzewn());
   }

   @Keep
   public static Object getContent(URL var0, Class[] var1) throws IOException {
      return a(new zzewp(var0), var1, zzevz.a(), new zzewn());
   }

   @Keep
   public static Object instrument(Object var0) throws IOException {
      Object var1;
      if (var0 instanceof HttpsURLConnection) {
         var1 = new zzd((HttpsURLConnection)var0, new zzewn(), zzevv.a(zzevz.a()));
      } else {
         var1 = var0;
         if (var0 instanceof HttpURLConnection) {
            var1 = new zzc((HttpURLConnection)var0, new zzewn(), zzevv.a(zzevz.a()));
         }
      }

      return var1;
   }

   @Keep
   public static InputStream openStream(URL var0) throws IOException {
      return a(new zzewp(var0), zzevz.a(), new zzewn());
   }
}
