package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import java.io.IOException;

class UrlRedirectCache {
   private static final String REDIRECT_CONTENT_TAG = UrlRedirectCache.TAG + "_Redirect";
   static final String TAG = UrlRedirectCache.class.getSimpleName();
   private static volatile FileLruCache urlRedirectCache;

   static void cacheUriRedirect(Uri param0, Uri param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: ifnull 08
      // 04: aload 1
      // 05: ifnonnull 09
      // 08: return
      // 09: aconst_null
      // 0a: astore 2
      // 0b: invokestatic com/facebook/internal/UrlRedirectCache.getCache ()Lcom/facebook/internal/FileLruCache;
      // 0e: aload 0
      // 0f: invokevirtual android/net/Uri.toString ()Ljava/lang/String;
      // 12: getstatic com/facebook/internal/UrlRedirectCache.REDIRECT_CONTENT_TAG Ljava/lang/String;
      // 15: invokevirtual com/facebook/internal/FileLruCache.openPutStream (Ljava/lang/String;Ljava/lang/String;)Ljava/io/OutputStream;
      // 18: astore 0
      // 19: aload 0
      // 1a: astore 2
      // 1b: aload 0
      // 1c: aload 1
      // 1d: invokevirtual android/net/Uri.toString ()Ljava/lang/String;
      // 20: invokevirtual java/lang/String.getBytes ()[B
      // 23: invokevirtual java/io/OutputStream.write ([B)V
      // 26: aload 0
      // 27: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 2a: goto 08
      // 2d: astore 0
      // 2e: aload 2
      // 2f: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 32: goto 08
      // 35: astore 1
      // 36: aconst_null
      // 37: astore 0
      // 38: aload 0
      // 39: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 3c: aload 1
      // 3d: athrow
      // 3e: astore 1
      // 3f: goto 38
      // try (7 -> 13): 23 java/io/IOException
      // try (7 -> 13): 27 null
      // try (15 -> 20): 23 java/io/IOException
      // try (15 -> 20): 34 null
   }

   static void clearCache() {
      try {
         getCache().clearCache();
      } catch (IOException var1) {
         Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + var1.getMessage());
      }
   }

   static FileLruCache getCache() throws IOException {
      synchronized (UrlRedirectCache.class) {
         if (urlRedirectCache == null) {
            String var1 = TAG;
            FileLruCache.Limits var0 = new FileLruCache.Limits();
            FileLruCache var2 = new FileLruCache(var1, var0);
            urlRedirectCache = var2;
         }

         return urlRedirectCache;
      }
   }

   static Uri getRedirectedUri(Uri param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 4
      // 03: bipush 0
      // 04: istore 1
      // 05: aload 0
      // 06: ifnonnull 0e
      // 09: aload 4
      // 0b: astore 2
      // 0c: aload 2
      // 0d: areturn
      // 0e: aload 0
      // 0f: invokevirtual android/net/Uri.toString ()Ljava/lang/String;
      // 12: astore 3
      // 13: invokestatic com/facebook/internal/UrlRedirectCache.getCache ()Lcom/facebook/internal/FileLruCache;
      // 16: astore 5
      // 18: aconst_null
      // 19: astore 0
      // 1a: aload 5
      // 1c: aload 3
      // 1d: getstatic com/facebook/internal/UrlRedirectCache.REDIRECT_CONTENT_TAG Ljava/lang/String;
      // 20: invokevirtual com/facebook/internal/FileLruCache.get (Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
      // 23: astore 6
      // 25: aload 6
      // 27: ifnull 75
      // 2a: new java/io/InputStreamReader
      // 2d: astore 2
      // 2e: aload 2
      // 2f: aload 6
      // 31: invokespecial java/io/InputStreamReader.<init> (Ljava/io/InputStream;)V
      // 34: sipush 128
      // 37: newarray 5
      // 39: astore 0
      // 3a: new java/lang/StringBuilder
      // 3d: astore 3
      // 3e: aload 3
      // 3f: invokespecial java/lang/StringBuilder.<init> ()V
      // 42: aload 2
      // 43: aload 0
      // 44: bipush 0
      // 45: aload 0
      // 46: arraylength
      // 47: invokevirtual java/io/InputStreamReader.read ([CII)I
      // 4a: istore 1
      // 4b: iload 1
      // 4c: ifle 65
      // 4f: aload 3
      // 50: aload 0
      // 51: bipush 0
      // 52: iload 1
      // 53: invokevirtual java/lang/StringBuilder.append ([CII)Ljava/lang/StringBuilder;
      // 56: pop
      // 57: goto 42
      // 5a: astore 0
      // 5b: aload 2
      // 5c: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 5f: aload 4
      // 61: astore 2
      // 62: goto 0c
      // 65: aload 2
      // 66: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 69: aload 3
      // 6a: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 6d: astore 3
      // 6e: aload 2
      // 6f: astore 0
      // 70: bipush 1
      // 71: istore 1
      // 72: goto 1a
      // 75: iload 1
      // 76: ifeq 85
      // 79: aload 3
      // 7a: invokestatic android/net/Uri.parse (Ljava/lang/String;)Landroid/net/Uri;
      // 7d: astore 2
      // 7e: aload 0
      // 7f: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 82: goto 0c
      // 85: aload 0
      // 86: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 89: aload 4
      // 8b: astore 2
      // 8c: goto 0c
      // 8f: astore 0
      // 90: aconst_null
      // 91: astore 2
      // 92: aload 2
      // 93: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 96: aload 0
      // 97: athrow
      // 98: astore 0
      // 99: goto 92
      // 9c: astore 2
      // 9d: aload 0
      // 9e: astore 3
      // 9f: aload 2
      // a0: astore 0
      // a1: aload 3
      // a2: astore 2
      // a3: goto 92
      // a6: astore 0
      // a7: aconst_null
      // a8: astore 2
      // a9: goto 5b
      // ac: astore 2
      // ad: aload 0
      // ae: astore 2
      // af: goto 5b
      // try (13 -> 15): 98 java/io/IOException
      // try (13 -> 15): 81 null
      // try (17 -> 22): 102 java/io/IOException
      // try (17 -> 22): 90 null
      // try (24 -> 29): 102 java/io/IOException
      // try (24 -> 29): 90 null
      // try (29 -> 36): 52 java/io/IOException
      // try (29 -> 36): 88 null
      // try (36 -> 43): 52 java/io/IOException
      // try (36 -> 43): 88 null
      // try (45 -> 51): 52 java/io/IOException
      // try (45 -> 51): 88 null
      // try (58 -> 63): 52 java/io/IOException
      // try (58 -> 63): 88 null
      // try (70 -> 73): 102 java/io/IOException
      // try (70 -> 73): 90 null
   }
}
