package com.mixpanel.android.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.LruCache;
import android.util.Base64;
import com.mixpanel.android.mpmetrics.MPConfig;
import java.io.File;
import java.security.MessageDigest;

public class ImageStore {
   private static LruCache<String, Bitmap> e;
   private final File a;
   private final RemoteService b;
   private final MessageDigest c;
   private final MPConfig d;

   public ImageStore(Context var1, String var2) {
      this(var1, "MixpanelAPI.Images." + var2, new HttpService());
   }

   public ImageStore(Context param1, String param2, RemoteService param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokespecial java/lang/Object.<init> ()V
      // 04: aload 0
      // 05: aload 1
      // 06: aload 2
      // 07: bipush 0
      // 08: invokevirtual android/content/Context.getDir (Ljava/lang/String;I)Ljava/io/File;
      // 0b: putfield com/mixpanel/android/util/ImageStore.a Ljava/io/File;
      // 0e: aload 0
      // 0f: aload 3
      // 10: putfield com/mixpanel/android/util/ImageStore.b Lcom/mixpanel/android/util/RemoteService;
      // 13: aload 0
      // 14: aload 1
      // 15: invokestatic com/mixpanel/android/mpmetrics/MPConfig.a (Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/MPConfig;
      // 18: putfield com/mixpanel/android/util/ImageStore.d Lcom/mixpanel/android/mpmetrics/MPConfig;
      // 1b: ldc "SHA1"
      // 1d: invokestatic java/security/MessageDigest.getInstance (Ljava/lang/String;)Ljava/security/MessageDigest;
      // 20: astore 1
      // 21: aload 0
      // 22: aload 1
      // 23: putfield com/mixpanel/android/util/ImageStore.c Ljava/security/MessageDigest;
      // 26: getstatic com/mixpanel/android/util/ImageStore.e Landroid/support/v4/util/LruCache;
      // 29: ifnonnull 5c
      // 2c: ldc com/mixpanel/android/util/ImageStore
      // 2e: monitorenter
      // 2f: getstatic com/mixpanel/android/util/ImageStore.e Landroid/support/v4/util/LruCache;
      // 32: ifnonnull 59
      // 35: invokestatic java/lang/Runtime.getRuntime ()Ljava/lang/Runtime;
      // 38: invokevirtual java/lang/Runtime.maxMemory ()J
      // 3b: ldc2_w 1024
      // 3e: ldiv
      // 3f: l2i
      // 40: aload 0
      // 41: getfield com/mixpanel/android/util/ImageStore.d Lcom/mixpanel/android/mpmetrics/MPConfig;
      // 44: invokevirtual com/mixpanel/android/mpmetrics/MPConfig.A ()I
      // 47: idiv
      // 48: istore 4
      // 4a: new com/mixpanel/android/util/ImageStore$1
      // 4d: astore 1
      // 4e: aload 1
      // 4f: aload 0
      // 50: iload 4
      // 52: invokespecial com/mixpanel/android/util/ImageStore$1.<init> (Lcom/mixpanel/android/util/ImageStore;I)V
      // 55: aload 1
      // 56: putstatic com/mixpanel/android/util/ImageStore.e Landroid/support/v4/util/LruCache;
      // 59: ldc com/mixpanel/android/util/ImageStore
      // 5b: monitorexit
      // 5c: return
      // 5d: astore 1
      // 5e: ldc "MixpanelAPI.ImageStore"
      // 60: ldc "Images won't be stored because this platform doesn't supply a SHA1 hash function"
      // 62: invokestatic com/mixpanel/android/util/MPLog.d (Ljava/lang/String;Ljava/lang/String;)V
      // 65: aconst_null
      // 66: astore 1
      // 67: goto 21
      // 6a: astore 1
      // 6b: ldc com/mixpanel/android/util/ImageStore
      // 6d: monitorexit
      // 6e: aload 1
      // 6f: athrow
      // try (15 -> 18): 48 java/security/NoSuchAlgorithmException
      // try (25 -> 45): 55 null
      // try (45 -> 47): 55 null
      // try (56 -> 58): 55 null
   }

   private static float a() {
      Runtime var1 = Runtime.getRuntime();
      float var0 = (float)(var1.totalMemory() - var1.freeMemory());
      return (float)var1.maxMemory() - var0;
   }

   private static Bitmap a(File var0) throws ImageStore.CantGetImageException {
      Options var2 = new Options();
      var2.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(var0.getAbsolutePath(), var2);
      float var1 = var2.outHeight;
      if (var2.outWidth * var1 > a()) {
         throw new ImageStore.CantGetImageException("Do not have enough memory for the image");
      } else {
         Bitmap var3 = BitmapFactory.decodeFile(var0.getAbsolutePath());
         if (var3 == null) {
            var0.delete();
            throw new ImageStore.CantGetImageException("Bitmap on disk can't be opened or was corrupt");
         } else {
            return var3;
         }
      }
   }

   public static void a(String param0, Bitmap param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokestatic com/mixpanel/android/util/ImageStore.d (Ljava/lang/String;)Landroid/graphics/Bitmap;
      // 04: ifnonnull 18
      // 07: getstatic com/mixpanel/android/util/ImageStore.e Landroid/support/v4/util/LruCache;
      // 0a: astore 2
      // 0b: aload 2
      // 0c: monitorenter
      // 0d: getstatic com/mixpanel/android/util/ImageStore.e Landroid/support/v4/util/LruCache;
      // 10: aload 0
      // 11: aload 1
      // 12: invokevirtual android/support/v4/util/LruCache.a (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 15: pop
      // 16: aload 2
      // 17: monitorexit
      // 18: return
      // 19: astore 0
      // 1a: aload 2
      // 1b: monitorexit
      // 1c: aload 0
      // 1d: athrow
      // try (7 -> 14): 15 null
      // try (16 -> 18): 15 null
   }

   public static Bitmap d(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: getstatic com/mixpanel/android/util/ImageStore.e Landroid/support/v4/util/LruCache;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: getstatic com/mixpanel/android/util/ImageStore.e Landroid/support/v4/util/LruCache;
      // 09: aload 0
      // 0a: invokevirtual android/support/v4/util/LruCache.a (Ljava/lang/Object;)Ljava/lang/Object;
      // 0d: checkcast android/graphics/Bitmap
      // 10: astore 0
      // 11: aload 1
      // 12: monitorexit
      // 13: aload 0
      // 14: areturn
      // 15: astore 0
      // 16: aload 1
      // 17: monitorexit
      // 18: aload 0
      // 19: athrow
      // try (4 -> 11): 13 null
      // try (14 -> 16): 13 null
   }

   public static void e(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: getstatic com/mixpanel/android/util/ImageStore.e Landroid/support/v4/util/LruCache;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: getstatic com/mixpanel/android/util/ImageStore.e Landroid/support/v4/util/LruCache;
      // 09: aload 0
      // 0a: invokevirtual android/support/v4/util/LruCache.b (Ljava/lang/Object;)Ljava/lang/Object;
      // 0d: pop
      // 0e: aload 1
      // 0f: monitorexit
      // 10: return
      // 11: astore 0
      // 12: aload 1
      // 13: monitorexit
      // 14: aload 0
      // 15: athrow
      // try (4 -> 10): 11 null
      // try (12 -> 14): 11 null
   }

   private File f(String var1) {
      File var2;
      if (this.c == null) {
         var2 = null;
      } else {
         byte[] var3 = this.c.digest(var1.getBytes());
         var1 = "MP_IMG_" + Base64.encodeToString(var3, 10);
         var2 = new File(this.a, var1);
      }

      return var2;
   }

   public File a(String param1) throws ImageStore.CantGetImageException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 3
      // 02: aconst_null
      // 03: astore 4
      // 05: aload 0
      // 06: aload 1
      // 07: invokespecial com/mixpanel/android/util/ImageStore.f (Ljava/lang/String;)Ljava/io/File;
      // 0a: astore 5
      // 0c: aload 5
      // 0e: ifnull 19
      // 11: aload 5
      // 13: invokevirtual java/io/File.exists ()Z
      // 16: ifne 5f
      // 19: aload 0
      // 1a: getfield com/mixpanel/android/util/ImageStore.d Lcom/mixpanel/android/mpmetrics/MPConfig;
      // 1d: invokevirtual com/mixpanel/android/mpmetrics/MPConfig.y ()Ljavax/net/ssl/SSLSocketFactory;
      // 20: astore 2
      // 21: aload 0
      // 22: getfield com/mixpanel/android/util/ImageStore.b Lcom/mixpanel/android/util/RemoteService;
      // 25: aload 1
      // 26: aconst_null
      // 27: aload 2
      // 28: invokeinterface com/mixpanel/android/util/RemoteService.a (Ljava/lang/String;Ljava/util/Map;Ljavax/net/ssl/SSLSocketFactory;)[B 4
      // 2d: astore 6
      // 2f: aload 6
      // 31: ifnull 5f
      // 34: aload 5
      // 36: ifnull 5f
      // 39: aload 6
      // 3b: arraylength
      // 3c: ldc 10000000
      // 3e: if_icmpge 5f
      // 41: aload 3
      // 42: astore 2
      // 43: new java/io/FileOutputStream
      // 46: astore 1
      // 47: aload 3
      // 48: astore 2
      // 49: aload 1
      // 4a: aload 5
      // 4c: invokespecial java/io/FileOutputStream.<init> (Ljava/io/File;)V
      // 4f: aload 1
      // 50: astore 2
      // 51: aload 1
      // 52: aload 6
      // 54: invokevirtual java/io/OutputStream.write ([B)V
      // 57: aload 1
      // 58: ifnull 5f
      // 5b: aload 1
      // 5c: invokevirtual java/io/OutputStream.close ()V
      // 5f: aload 5
      // 61: areturn
      // 62: astore 1
      // 63: new com/mixpanel/android/util/ImageStore$CantGetImageException
      // 66: dup
      // 67: ldc "Can't download bitmap"
      // 69: aload 1
      // 6a: invokespecial com/mixpanel/android/util/ImageStore$CantGetImageException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 6d: athrow
      // 6e: astore 1
      // 6f: new com/mixpanel/android/util/ImageStore$CantGetImageException
      // 72: dup
      // 73: ldc "Couldn't download image due to service availability"
      // 75: aload 1
      // 76: invokespecial com/mixpanel/android/util/ImageStore$CantGetImageException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 79: athrow
      // 7a: astore 1
      // 7b: ldc "MixpanelAPI.ImageStore"
      // 7d: ldc "Problem closing output file"
      // 7f: aload 1
      // 80: invokestatic com/mixpanel/android/util/MPLog.d (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 83: goto 5f
      // 86: astore 3
      // 87: aconst_null
      // 88: astore 1
      // 89: aload 1
      // 8a: astore 2
      // 8b: new com/mixpanel/android/util/ImageStore$CantGetImageException
      // 8e: astore 4
      // 90: aload 1
      // 91: astore 2
      // 92: aload 4
      // 94: ldc "It appears that ImageStore is misconfigured, or disk storage is unavailable- can't write to bitmap directory"
      // 96: aload 3
      // 97: invokespecial com/mixpanel/android/util/ImageStore$CantGetImageException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 9a: aload 1
      // 9b: astore 2
      // 9c: aload 4
      // 9e: athrow
      // 9f: astore 1
      // a0: aload 2
      // a1: ifnull a8
      // a4: aload 2
      // a5: invokevirtual java/io/OutputStream.close ()V
      // a8: aload 1
      // a9: athrow
      // aa: astore 3
      // ab: aload 4
      // ad: astore 1
      // ae: aload 1
      // af: astore 2
      // b0: new com/mixpanel/android/util/ImageStore$CantGetImageException
      // b3: astore 4
      // b5: aload 1
      // b6: astore 2
      // b7: aload 4
      // b9: ldc "Can't store bitmap"
      // bb: aload 3
      // bc: invokespecial com/mixpanel/android/util/ImageStore$CantGetImageException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // bf: aload 1
      // c0: astore 2
      // c1: aload 4
      // c3: athrow
      // c4: astore 1
      // c5: goto a0
      // c8: astore 2
      // c9: ldc "MixpanelAPI.ImageStore"
      // cb: ldc "Problem closing output file"
      // cd: aload 2
      // ce: invokestatic com/mixpanel/android/util/MPLog.d (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // d1: goto a8
      // d4: astore 3
      // d5: goto ae
      // d8: astore 3
      // d9: goto 89
      // try (13 -> 24): 52 java/io/IOException
      // try (13 -> 24): 59 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
      // try (34 -> 36): 72 java/io/FileNotFoundException
      // try (34 -> 36): 96 java/io/IOException
      // try (34 -> 36): 113 null
      // try (38 -> 41): 72 java/io/FileNotFoundException
      // try (38 -> 41): 96 java/io/IOException
      // try (38 -> 41): 113 null
      // try (43 -> 46): 123 java/io/FileNotFoundException
      // try (43 -> 46): 121 java/io/IOException
      // try (43 -> 46): 89 null
      // try (48 -> 50): 66 java/io/IOException
      // try (77 -> 79): 89 null
      // try (81 -> 85): 89 null
      // try (87 -> 89): 89 null
      // try (92 -> 94): 115 java/io/IOException
      // try (101 -> 103): 113 null
      // try (105 -> 109): 113 null
      // try (111 -> 113): 113 null
   }

   public Bitmap b(String var1) throws ImageStore.CantGetImageException {
      Bitmap var3 = d(var1);
      Bitmap var2 = var3;
      if (var3 == null) {
         var2 = a(this.a(var1));
         a(var1, var2);
      }

      return var2;
   }

   public void c(String var1) {
      File var2 = this.f(var1);
      if (var2 != null) {
         var2.delete();
         e(var1);
      }
   }

   public static class CantGetImageException extends Exception {
      public CantGetImageException(String var1) {
         super(var1);
      }

      public CantGetImageException(String var1, Throwable var2) {
         super(var1, var2);
      }
   }
}
