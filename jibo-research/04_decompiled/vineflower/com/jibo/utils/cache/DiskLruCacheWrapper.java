package com.jibo.utils.cache;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.jibo.utils.OriginalKey;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class DiskLruCacheWrapper implements DiskCache {
   private static DiskLruCacheWrapper a = null;
   private final SafeKeyGenerator b;
   private Context c;
   private final File d;
   private final int e;
   private final DiskCacheWriteLocker f = new DiskCacheWriteLocker();
   private DiskLruCache g;

   protected DiskLruCacheWrapper(Context var1, File var2, int var3) {
      this.c = var1;
      this.d = var2;
      this.e = var3;
      this.b = new SafeKeyGenerator();
   }

   private DiskLruCache a() throws IOException {
      synchronized (this) {
         if (this.g == null) {
            this.g = DiskLruCache.a(this.d, 1, 1, this.e);
         }

         return this.g;
      }
   }

   public static DiskCache a(Context var0, File var1, int var2) {
      synchronized (DiskLruCacheWrapper.class) {
         if (a == null) {
            DiskLruCacheWrapper var3 = new DiskLruCacheWrapper(var0, var1, var2);
            a = var3;
         }

         return a;
      }
   }

   public void a(OriginalKey param1, InputStream param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 3
      // 002: aload 0
      // 003: getfield com/jibo/utils/cache/DiskLruCacheWrapper.f Lcom/jibo/utils/cache/DiskCacheWriteLocker;
      // 006: aload 1
      // 007: invokevirtual com/jibo/utils/cache/DiskCacheWriteLocker.a (Lcom/bumptech/glide/load/Key;)V
      // 00a: aload 1
      // 00b: invokevirtual com/jibo/utils/OriginalKey.a ()Ljava/lang/String;
      // 00e: invokestatic android/net/Uri.parse (Ljava/lang/String;)Landroid/net/Uri;
      // 011: astore 4
      // 013: aload 4
      // 015: ldc "loopId"
      // 017: invokevirtual android/net/Uri.getQueryParameter (Ljava/lang/String;)Ljava/lang/String;
      // 01a: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 01d: ifne 19b
      // 020: aload 4
      // 022: ldc "loopId"
      // 024: invokevirtual android/net/Uri.getQueryParameter (Ljava/lang/String;)Ljava/lang/String;
      // 027: astore 3
      // 028: new java/io/File
      // 02b: astore 4
      // 02d: aload 0
      // 02e: getfield com/jibo/utils/cache/DiskLruCacheWrapper.d Ljava/io/File;
      // 031: astore 6
      // 033: new java/lang/StringBuilder
      // 036: astore 5
      // 038: aload 5
      // 03a: invokespecial java/lang/StringBuilder.<init> ()V
      // 03d: aload 4
      // 03f: aload 6
      // 041: aload 5
      // 043: aload 0
      // 044: getfield com/jibo/utils/cache/DiskLruCacheWrapper.b Lcom/jibo/utils/cache/SafeKeyGenerator;
      // 047: aload 1
      // 048: invokevirtual com/jibo/utils/cache/SafeKeyGenerator.a (Lcom/bumptech/glide/load/Key;)Ljava/lang/String;
      // 04b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 04e: ldc "_enc"
      // 050: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 053: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 056: invokespecial java/io/File.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 059: aload 0
      // 05a: getfield com/jibo/utils/cache/DiskLruCacheWrapper.b Lcom/jibo/utils/cache/SafeKeyGenerator;
      // 05d: aload 1
      // 05e: invokevirtual com/jibo/utils/cache/SafeKeyGenerator.a (Lcom/bumptech/glide/load/Key;)Ljava/lang/String;
      // 061: astore 5
      // 063: ldc "DiskLruCacheWrapper"
      // 065: bipush 2
      // 066: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 069: ifeq 094
      // 06c: new java/lang/StringBuilder
      // 06f: astore 6
      // 071: aload 6
      // 073: invokespecial java/lang/StringBuilder.<init> ()V
      // 076: ldc "DiskLruCacheWrapper"
      // 078: aload 6
      // 07a: ldc "Put: Obtained: "
      // 07c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 07f: aload 5
      // 081: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 084: ldc " for for Key: "
      // 086: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 089: aload 1
      // 08a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 08d: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 090: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 093: pop
      // 094: aload 0
      // 095: invokespecial com/jibo/utils/cache/DiskLruCacheWrapper.a ()Lcom/bumptech/glide/disklrucache/DiskLruCache;
      // 098: astore 7
      // 09a: aload 7
      // 09c: aload 5
      // 09e: invokevirtual com/bumptech/glide/disklrucache/DiskLruCache.a (Ljava/lang/String;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Value;
      // 0a1: astore 6
      // 0a3: aload 6
      // 0a5: ifnull 0c1
      // 0a8: aload 0
      // 0a9: getfield com/jibo/utils/cache/DiskLruCacheWrapper.f Lcom/jibo/utils/cache/DiskCacheWriteLocker;
      // 0ac: aload 1
      // 0ad: invokevirtual com/jibo/utils/cache/DiskCacheWriteLocker.b (Lcom/bumptech/glide/load/Key;)V
      // 0b0: return
      // 0b1: astore 2
      // 0b2: aload 2
      // 0b3: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 0b6: aload 0
      // 0b7: getfield com/jibo/utils/cache/DiskLruCacheWrapper.f Lcom/jibo/utils/cache/DiskCacheWriteLocker;
      // 0ba: aload 1
      // 0bb: invokevirtual com/jibo/utils/cache/DiskCacheWriteLocker.b (Lcom/bumptech/glide/load/Key;)V
      // 0be: goto 0b0
      // 0c1: aload 7
      // 0c3: aload 5
      // 0c5: invokevirtual com/bumptech/glide/disklrucache/DiskLruCache.b (Ljava/lang/String;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;
      // 0c8: astore 6
      // 0ca: aload 6
      // 0cc: ifnonnull 10d
      // 0cf: new java/lang/IllegalStateException
      // 0d2: astore 3
      // 0d3: new java/lang/StringBuilder
      // 0d6: astore 2
      // 0d7: aload 2
      // 0d8: invokespecial java/lang/StringBuilder.<init> ()V
      // 0db: aload 3
      // 0dc: aload 2
      // 0dd: ldc "Had two simultaneous puts for: "
      // 0df: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e2: aload 5
      // 0e4: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e7: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0ea: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 0ed: aload 3
      // 0ee: athrow
      // 0ef: astore 2
      // 0f0: ldc "DiskLruCacheWrapper"
      // 0f2: bipush 5
      // 0f3: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 0f6: ifeq 102
      // 0f9: ldc "DiskLruCacheWrapper"
      // 0fb: ldc "Unable to put to disk cache"
      // 0fd: aload 2
      // 0fe: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 101: pop
      // 102: aload 0
      // 103: getfield com/jibo/utils/cache/DiskLruCacheWrapper.f Lcom/jibo/utils/cache/DiskCacheWriteLocker;
      // 106: aload 1
      // 107: invokevirtual com/jibo/utils/cache/DiskCacheWriteLocker.b (Lcom/bumptech/glide/load/Key;)V
      // 10a: goto 0b0
      // 10d: aload 6
      // 10f: bipush 0
      // 110: invokevirtual com/bumptech/glide/disklrucache/DiskLruCache$Editor.a (I)Ljava/io/File;
      // 113: astore 5
      // 115: aload 4
      // 117: ifnull 174
      // 11a: aload 3
      // 11b: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 11e: ifne 174
      // 121: new java/io/FileOutputStream
      // 124: astore 7
      // 126: aload 7
      // 128: aload 4
      // 12a: invokespecial java/io/FileOutputStream.<init> (Ljava/io/File;)V
      // 12d: aload 2
      // 12e: aload 7
      // 130: invokestatic com/jibo/utils/Util.a (Ljava/io/InputStream;Ljava/io/OutputStream;)V
      // 133: aload 0
      // 134: getfield com/jibo/utils/cache/DiskLruCacheWrapper.c Landroid/content/Context;
      // 137: aload 0
      // 138: getfield com/jibo/utils/cache/DiskLruCacheWrapper.c Landroid/content/Context;
      // 13b: invokestatic com/jibo/db/EntityData.a (Landroid/content/Context;)Lcom/jibo/db/EntityData;
      // 13e: invokevirtual com/jibo/db/EntityData.i ()Lcom/jibo/aws/integration/aws/services/account/model/Account;
      // 141: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getId ()Ljava/lang/String;
      // 144: invokestatic com/jibo/aws/integration/util/KeyManager.getInstance (Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;
      // 147: aload 0
      // 148: getfield com/jibo/utils/cache/DiskLruCacheWrapper.c Landroid/content/Context;
      // 14b: aload 3
      // 14c: invokevirtual com/jibo/aws/integration/util/KeyManager.obtainKeyHolder (Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager$SymmetricKeyHolder;
      // 14f: aload 4
      // 151: aload 5
      // 153: invokevirtual com/jibo/aws/integration/util/KeyManager$SymmetricKeyHolder.decodeFile (Ljava/io/File;Ljava/io/File;)V
      // 156: aload 4
      // 158: invokevirtual java/io/File.delete ()Z
      // 15b: pop
      // 15c: aload 6
      // 15e: invokevirtual com/bumptech/glide/disklrucache/DiskLruCache$Editor.a ()V
      // 161: aload 6
      // 163: invokevirtual com/bumptech/glide/disklrucache/DiskLruCache$Editor.c ()V
      // 166: goto 102
      // 169: astore 2
      // 16a: aload 0
      // 16b: getfield com/jibo/utils/cache/DiskLruCacheWrapper.f Lcom/jibo/utils/cache/DiskCacheWriteLocker;
      // 16e: aload 1
      // 16f: invokevirtual com/jibo/utils/cache/DiskCacheWriteLocker.b (Lcom/bumptech/glide/load/Key;)V
      // 172: aload 2
      // 173: athrow
      // 174: new java/io/FileOutputStream
      // 177: astore 3
      // 178: aload 3
      // 179: aload 5
      // 17b: invokespecial java/io/FileOutputStream.<init> (Ljava/io/File;)V
      // 17e: aload 2
      // 17f: aload 3
      // 180: invokestatic com/jibo/utils/Util.a (Ljava/io/InputStream;Ljava/io/OutputStream;)V
      // 183: goto 15c
      // 186: astore 2
      // 187: aload 2
      // 188: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 18b: aload 6
      // 18d: invokevirtual com/bumptech/glide/disklrucache/DiskLruCache$Editor.c ()V
      // 190: goto 102
      // 193: astore 2
      // 194: aload 6
      // 196: invokevirtual com/bumptech/glide/disklrucache/DiskLruCache$Editor.c ()V
      // 199: aload 2
      // 19a: athrow
      // 19b: aconst_null
      // 19c: astore 4
      // 19e: goto 059
      // try (6 -> 40): 80 java/lang/Exception
      // try (6 -> 40): 165 null
      // try (40 -> 66): 165 null
      // try (66 -> 73): 110 java/io/IOException
      // try (66 -> 73): 165 null
      // try (81 -> 83): 165 null
      // try (88 -> 92): 110 java/io/IOException
      // try (88 -> 92): 165 null
      // try (94 -> 110): 110 java/io/IOException
      // try (94 -> 110): 165 null
      // try (111 -> 120): 165 null
      // try (125 -> 129): 181 java/lang/Exception
      // try (125 -> 129): 187 null
      // try (131 -> 160): 181 java/lang/Exception
      // try (131 -> 160): 187 null
      // try (160 -> 162): 181 java/lang/Exception
      // try (160 -> 162): 187 null
      // try (162 -> 164): 110 java/io/IOException
      // try (162 -> 164): 165 null
      // try (172 -> 180): 181 java/lang/Exception
      // try (172 -> 180): 187 null
      // try (182 -> 184): 187 null
      // try (184 -> 186): 110 java/io/IOException
      // try (184 -> 186): 165 null
      // try (188 -> 192): 110 java/io/IOException
      // try (188 -> 192): 165 null
   }

   @Override
   public void delete(Key var1) {
      String var3 = this.b.a(var1);

      try {
         this.a().c(var3);
      } catch (IOException var2) {
         if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
            Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", var2);
         }
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public File get(Key var1) {
      String var3 = this.b.a(var1);
      if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
         Log.v("DiskLruCacheWrapper", "Get: Obtained: " + var3 + " for for Key: " + var1);
      }

      Object var2 = null;

      label33: {
         try {
            var8 = this.a().a(var3);
         } catch (IOException var5) {
            var7 = var5;
            Object var6 = var2;
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
               return (File)var6;
            }
            break label33;
         }

         File var9 = (File)var2;
         if (var8 == null) {
            return var9;
         }

         try {
            var9 = var8.a(0);
            return var9;
         } catch (IOException var4) {
            var7 = var4;
            var9 = (File)var2;
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
               return var9;
            }
         }
      }

      Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", var7);
      return (File)var2;
   }

   @Override
   public void put(Key param1, DiskCache.Writer param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 4
      // 003: aload 0
      // 004: getfield com/jibo/utils/cache/DiskLruCacheWrapper.f Lcom/jibo/utils/cache/DiskCacheWriteLocker;
      // 007: aload 1
      // 008: invokevirtual com/jibo/utils/cache/DiskCacheWriteLocker.a (Lcom/bumptech/glide/load/Key;)V
      // 00b: aload 1
      // 00c: invokevirtual java/lang/Object.getClass ()Ljava/lang/Class;
      // 00f: invokevirtual java/lang/Class.getSimpleName ()Ljava/lang/String;
      // 012: ldc "OriginalKey"
      // 014: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 017: istore 3
      // 018: iload 3
      // 019: ifeq 1c3
      // 01c: aload 1
      // 01d: invokevirtual java/lang/Object.getClass ()Ljava/lang/Class;
      // 020: ldc "id"
      // 022: invokevirtual java/lang/Class.getDeclaredField (Ljava/lang/String;)Ljava/lang/reflect/Field;
      // 025: astore 5
      // 027: aload 5
      // 029: bipush 1
      // 02a: invokevirtual java/lang/reflect/Field.setAccessible (Z)V
      // 02d: aload 5
      // 02f: aload 1
      // 030: invokevirtual java/lang/reflect/Field.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 033: checkcast java/lang/String
      // 036: invokestatic android/net/Uri.parse (Ljava/lang/String;)Landroid/net/Uri;
      // 039: astore 5
      // 03b: aload 5
      // 03d: ldc "loopId"
      // 03f: invokevirtual android/net/Uri.getQueryParameter (Ljava/lang/String;)Ljava/lang/String;
      // 042: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 045: ifne 1c3
      // 048: aload 5
      // 04a: ldc "loopId"
      // 04c: invokevirtual android/net/Uri.getQueryParameter (Ljava/lang/String;)Ljava/lang/String;
      // 04f: astore 5
      // 051: new java/io/File
      // 054: astore 4
      // 056: aload 0
      // 057: getfield com/jibo/utils/cache/DiskLruCacheWrapper.d Ljava/io/File;
      // 05a: astore 6
      // 05c: new java/lang/StringBuilder
      // 05f: astore 7
      // 061: aload 7
      // 063: invokespecial java/lang/StringBuilder.<init> ()V
      // 066: aload 4
      // 068: aload 6
      // 06a: aload 7
      // 06c: aload 0
      // 06d: getfield com/jibo/utils/cache/DiskLruCacheWrapper.b Lcom/jibo/utils/cache/SafeKeyGenerator;
      // 070: aload 1
      // 071: invokevirtual com/jibo/utils/cache/SafeKeyGenerator.a (Lcom/bumptech/glide/load/Key;)Ljava/lang/String;
      // 074: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 077: ldc "_enc"
      // 079: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 07c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 07f: invokespecial java/io/File.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 082: aload 0
      // 083: getfield com/jibo/utils/cache/DiskLruCacheWrapper.b Lcom/jibo/utils/cache/SafeKeyGenerator;
      // 086: aload 1
      // 087: invokevirtual com/jibo/utils/cache/SafeKeyGenerator.a (Lcom/bumptech/glide/load/Key;)Ljava/lang/String;
      // 08a: astore 6
      // 08c: ldc "DiskLruCacheWrapper"
      // 08e: bipush 2
      // 08f: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 092: ifeq 0bd
      // 095: new java/lang/StringBuilder
      // 098: astore 7
      // 09a: aload 7
      // 09c: invokespecial java/lang/StringBuilder.<init> ()V
      // 09f: ldc "DiskLruCacheWrapper"
      // 0a1: aload 7
      // 0a3: ldc "Put: Obtained: "
      // 0a5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a8: aload 6
      // 0aa: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0ad: ldc " for for Key: "
      // 0af: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0b2: aload 1
      // 0b3: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 0b6: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0b9: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 0bc: pop
      // 0bd: aload 0
      // 0be: invokespecial com/jibo/utils/cache/DiskLruCacheWrapper.a ()Lcom/bumptech/glide/disklrucache/DiskLruCache;
      // 0c1: astore 8
      // 0c3: aload 8
      // 0c5: aload 6
      // 0c7: invokevirtual com/bumptech/glide/disklrucache/DiskLruCache.a (Ljava/lang/String;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Value;
      // 0ca: astore 7
      // 0cc: aload 7
      // 0ce: ifnull 0ea
      // 0d1: aload 0
      // 0d2: getfield com/jibo/utils/cache/DiskLruCacheWrapper.f Lcom/jibo/utils/cache/DiskCacheWriteLocker;
      // 0d5: aload 1
      // 0d6: invokevirtual com/jibo/utils/cache/DiskCacheWriteLocker.b (Lcom/bumptech/glide/load/Key;)V
      // 0d9: return
      // 0da: astore 2
      // 0db: aload 2
      // 0dc: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 0df: aload 0
      // 0e0: getfield com/jibo/utils/cache/DiskLruCacheWrapper.f Lcom/jibo/utils/cache/DiskCacheWriteLocker;
      // 0e3: aload 1
      // 0e4: invokevirtual com/jibo/utils/cache/DiskCacheWriteLocker.b (Lcom/bumptech/glide/load/Key;)V
      // 0e7: goto 0d9
      // 0ea: aload 8
      // 0ec: aload 6
      // 0ee: invokevirtual com/bumptech/glide/disklrucache/DiskLruCache.b (Ljava/lang/String;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;
      // 0f1: astore 7
      // 0f3: aload 7
      // 0f5: ifnonnull 139
      // 0f8: new java/lang/IllegalStateException
      // 0fb: astore 4
      // 0fd: new java/lang/StringBuilder
      // 100: astore 2
      // 101: aload 2
      // 102: invokespecial java/lang/StringBuilder.<init> ()V
      // 105: aload 4
      // 107: aload 2
      // 108: ldc "Had two simultaneous puts for: "
      // 10a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 10d: aload 6
      // 10f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 112: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 115: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 118: aload 4
      // 11a: athrow
      // 11b: astore 2
      // 11c: ldc "DiskLruCacheWrapper"
      // 11e: bipush 5
      // 11f: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 122: ifeq 12e
      // 125: ldc "DiskLruCacheWrapper"
      // 127: ldc "Unable to put to disk cache"
      // 129: aload 2
      // 12a: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 12d: pop
      // 12e: aload 0
      // 12f: getfield com/jibo/utils/cache/DiskLruCacheWrapper.f Lcom/jibo/utils/cache/DiskCacheWriteLocker;
      // 132: aload 1
      // 133: invokevirtual com/jibo/utils/cache/DiskCacheWriteLocker.b (Lcom/bumptech/glide/load/Key;)V
      // 136: goto 0d9
      // 139: aload 7
      // 13b: bipush 0
      // 13c: invokevirtual com/bumptech/glide/disklrucache/DiskLruCache$Editor.a (I)Ljava/io/File;
      // 13f: astore 6
      // 141: aload 4
      // 143: ifnull 19b
      // 146: aload 5
      // 148: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 14b: ifne 19b
      // 14e: aload 2
      // 14f: aload 4
      // 151: invokeinterface com/bumptech/glide/load/engine/cache/DiskCache$Writer.write (Ljava/io/File;)Z 2
      // 156: ifeq 188
      // 159: aload 0
      // 15a: getfield com/jibo/utils/cache/DiskLruCacheWrapper.c Landroid/content/Context;
      // 15d: aload 0
      // 15e: getfield com/jibo/utils/cache/DiskLruCacheWrapper.c Landroid/content/Context;
      // 161: invokestatic com/jibo/db/EntityData.a (Landroid/content/Context;)Lcom/jibo/db/EntityData;
      // 164: invokevirtual com/jibo/db/EntityData.i ()Lcom/jibo/aws/integration/aws/services/account/model/Account;
      // 167: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getId ()Ljava/lang/String;
      // 16a: invokestatic com/jibo/aws/integration/util/KeyManager.getInstance (Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;
      // 16d: aload 0
      // 16e: getfield com/jibo/utils/cache/DiskLruCacheWrapper.c Landroid/content/Context;
      // 171: aload 5
      // 173: invokevirtual com/jibo/aws/integration/util/KeyManager.obtainKeyHolder (Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager$SymmetricKeyHolder;
      // 176: aload 4
      // 178: aload 6
      // 17a: invokevirtual com/jibo/aws/integration/util/KeyManager$SymmetricKeyHolder.decodeFile (Ljava/io/File;Ljava/io/File;)V
      // 17d: aload 4
      // 17f: invokevirtual java/io/File.delete ()Z
      // 182: pop
      // 183: aload 7
      // 185: invokevirtual com/bumptech/glide/disklrucache/DiskLruCache$Editor.a ()V
      // 188: aload 7
      // 18a: invokevirtual com/bumptech/glide/disklrucache/DiskLruCache$Editor.c ()V
      // 18d: goto 12e
      // 190: astore 2
      // 191: aload 0
      // 192: getfield com/jibo/utils/cache/DiskLruCacheWrapper.f Lcom/jibo/utils/cache/DiskCacheWriteLocker;
      // 195: aload 1
      // 196: invokevirtual com/jibo/utils/cache/DiskCacheWriteLocker.b (Lcom/bumptech/glide/load/Key;)V
      // 199: aload 2
      // 19a: athrow
      // 19b: aload 2
      // 19c: aload 6
      // 19e: invokeinterface com/bumptech/glide/load/engine/cache/DiskCache$Writer.write (Ljava/io/File;)Z 2
      // 1a3: ifeq 188
      // 1a6: aload 7
      // 1a8: invokevirtual com/bumptech/glide/disklrucache/DiskLruCache$Editor.a ()V
      // 1ab: goto 188
      // 1ae: astore 2
      // 1af: aload 2
      // 1b0: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 1b3: aload 7
      // 1b5: invokevirtual com/bumptech/glide/disklrucache/DiskLruCache$Editor.c ()V
      // 1b8: goto 12e
      // 1bb: astore 2
      // 1bc: aload 7
      // 1be: invokevirtual com/bumptech/glide/disklrucache/DiskLruCache$Editor.c ()V
      // 1c1: aload 2
      // 1c2: athrow
      // 1c3: aconst_null
      // 1c4: astore 5
      // 1c6: goto 082
      // try (6 -> 12): 179 null
      // try (14 -> 58): 98 java/lang/Exception
      // try (14 -> 58): 179 null
      // try (58 -> 84): 179 null
      // try (84 -> 91): 128 java/io/IOException
      // try (84 -> 91): 179 null
      // try (99 -> 101): 179 null
      // try (106 -> 110): 128 java/io/IOException
      // try (106 -> 110): 179 null
      // try (112 -> 128): 128 java/io/IOException
      // try (112 -> 128): 179 null
      // try (129 -> 138): 179 null
      // try (143 -> 147): 193 java/lang/Exception
      // try (143 -> 147): 199 null
      // try (149 -> 176): 193 java/lang/Exception
      // try (149 -> 176): 199 null
      // try (176 -> 178): 128 java/io/IOException
      // try (176 -> 178): 179 null
      // try (186 -> 192): 193 java/lang/Exception
      // try (186 -> 192): 199 null
      // try (194 -> 196): 199 null
      // try (196 -> 198): 128 java/io/IOException
      // try (196 -> 198): 179 null
      // try (200 -> 204): 128 java/io/IOException
      // try (200 -> 204): 179 null
   }
}
