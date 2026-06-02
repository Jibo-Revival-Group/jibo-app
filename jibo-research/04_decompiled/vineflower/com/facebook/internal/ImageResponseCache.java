package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import com.facebook.LoggingBehavior;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

class ImageResponseCache {
   static final String TAG = ImageResponseCache.class.getSimpleName();
   private static volatile FileLruCache imageCache;

   static void clearCache(Context var0) {
      try {
         getCache(var0).clearCache();
      } catch (IOException var1) {
         Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + var1.getMessage());
      }
   }

   static FileLruCache getCache(Context var0) throws IOException {
      synchronized (ImageResponseCache.class) {
         if (imageCache == null) {
            String var1 = TAG;
            FileLruCache.Limits var2 = new FileLruCache.Limits();
            FileLruCache var5 = new FileLruCache(var1, var2);
            imageCache = var5;
         }

         return imageCache;
      }
   }

   static InputStream getCachedImageStream(Uri var0, Context var1) {
      Object var3 = null;
      InputStream var2 = (InputStream)var3;
      if (var0 != null) {
         var2 = (InputStream)var3;
         if (isCDNURL(var0)) {
            try {
               var2 = getCache(var1).get(var0.toString());
            } catch (IOException var4) {
               Logger.log(LoggingBehavior.CACHE, 5, TAG, var4.toString());
               var2 = (InputStream)var3;
            }
         }
      }

      return var2;
   }

   static InputStream interceptAndCacheImageStream(Context var0, HttpURLConnection var1) throws IOException {
      InputStream var2 = null;
      if (var1.getResponseCode() == 200) {
         Uri var4 = Uri.parse(var1.getURL().toString());
         InputStream var3 = var1.getInputStream();
         var2 = var3;

         try {
            if (isCDNURL(var4)) {
               FileLruCache var6 = getCache(var0);
               String var8 = var4.toString();
               var2 = new ImageResponseCache.BufferedHttpInputStream(var3, var1);
               var2 = var6.interceptAndPut(var8, var2);
            }
         } catch (IOException var5) {
            var2 = var3;
         }
      }

      return var2;
   }

   private static boolean isCDNURL(Uri var0) {
      boolean var1 = true;
      if (var0 != null) {
         String var2 = var0.getHost();
         if (var2.endsWith("fbcdn.net") || var2.startsWith("fbcdn") && var2.endsWith("akamaihd.net")) {
            return var1;
         }
      }

      return false;
   }

   private static class BufferedHttpInputStream extends BufferedInputStream {
      HttpURLConnection connection;

      BufferedHttpInputStream(InputStream var1, HttpURLConnection var2) {
         super(var1, 8192);
         this.connection = var2;
      }

      @Override
      public void close() throws IOException {
         super.close();
         Utility.disconnectQuietly(this.connection);
      }
   }
}
