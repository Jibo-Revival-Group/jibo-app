package com.jibo;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.module.GlideModule;
import com.jibo.utils.cache.ExternalCacheDiskCacheFactory;
import java.io.File;

public class JiboGlideModule implements GlideModule {
   private static ExternalCacheDiskCacheFactory a;

   public static ExternalCacheDiskCacheFactory a(Context param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: ldc com/jibo/JiboGlideModule
      // 02: monitorenter
      // 03: aload 0
      // 04: invokestatic com/jibo/JiboGlideModule.b (Landroid/content/Context;)V
      // 07: getstatic com/jibo/JiboGlideModule.a Lcom/jibo/utils/cache/ExternalCacheDiskCacheFactory;
      // 0a: ifnonnull 2c
      // 0d: ldc com/jibo/JiboGlideModule
      // 0f: monitorenter
      // 10: getstatic com/jibo/JiboGlideModule.a Lcom/jibo/utils/cache/ExternalCacheDiskCacheFactory;
      // 13: ifnonnull 29
      // 16: new com/jibo/utils/cache/ExternalCacheDiskCacheFactory
      // 19: astore 1
      // 1a: aload 1
      // 1b: aload 0
      // 1c: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 1f: aconst_null
      // 20: ldc 262144000
      // 22: invokespecial com/jibo/utils/cache/ExternalCacheDiskCacheFactory.<init> (Landroid/content/Context;Ljava/lang/String;I)V
      // 25: aload 1
      // 26: putstatic com/jibo/JiboGlideModule.a Lcom/jibo/utils/cache/ExternalCacheDiskCacheFactory;
      // 29: ldc com/jibo/JiboGlideModule
      // 2b: monitorexit
      // 2c: getstatic com/jibo/JiboGlideModule.a Lcom/jibo/utils/cache/ExternalCacheDiskCacheFactory;
      // 2f: astore 0
      // 30: ldc com/jibo/JiboGlideModule
      // 32: monitorexit
      // 33: aload 0
      // 34: areturn
      // 35: astore 0
      // 36: ldc com/jibo/JiboGlideModule
      // 38: monitorexit
      // 39: aload 0
      // 3a: athrow
      // 3b: astore 0
      // 3c: ldc com/jibo/JiboGlideModule
      // 3e: monitorexit
      // 3f: aload 0
      // 40: athrow
      // try (2 -> 8): 33 null
      // try (8 -> 20): 28 null
      // try (20 -> 22): 28 null
      // try (22 -> 24): 33 null
      // try (29 -> 31): 28 null
      // try (31 -> 33): 33 null
   }

   public static void b(Context var0) {
      File var1 = new File(var0.getExternalCacheDir(), "share");
      if (!var1.exists()) {
         var1.mkdirs();
      }
   }

   @Override
   public void a(Context var1, Glide var2) {
   }

   @Override
   public void a(Context var1, GlideBuilder var2) {
      var2.a(a(var1));
   }
}
