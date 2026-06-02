package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzca;

@Deprecated
public final class zzbz {
   private static final Object a = new Object();
   private static zzbz b;
   private final String c;
   private final Status d;
   private final boolean e;
   private final boolean f;

   private zzbz(Context var1) {
      boolean var3 = true;
      boolean var4 = true;
      super();
      Resources var5 = var1.getResources();
      int var2 = var5.getIdentifier("google_app_measurement_enable", "integer", var5.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
      if (var2 != 0) {
         if (var5.getInteger(var2) != 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         if (var3) {
            var4 = false;
         }

         this.f = var4;
      } else {
         this.f = false;
      }

      this.e = var3;
      String var6 = com.google.android.gms.common.internal.zzbf.a(var1);
      String var7 = var6;
      if (var6 == null) {
         var7 = new zzca(var1).a("google_app_id");
      }

      if (TextUtils.isEmpty(var7)) {
         this.d = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
         this.c = null;
      } else {
         this.c = var7;
         this.d = Status.a;
      }
   }

   public static Status a(Context param0) {
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
      // 01: ldc "Context must not be null."
      // 03: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 06: pop
      // 07: getstatic com/google/android/gms/common/api/internal/zzbz.a Ljava/lang/Object;
      // 0a: astore 1
      // 0b: aload 1
      // 0c: monitorenter
      // 0d: getstatic com/google/android/gms/common/api/internal/zzbz.b Lcom/google/android/gms/common/api/internal/zzbz;
      // 10: ifnonnull 20
      // 13: new com/google/android/gms/common/api/internal/zzbz
      // 16: astore 2
      // 17: aload 2
      // 18: aload 0
      // 19: invokespecial com/google/android/gms/common/api/internal/zzbz.<init> (Landroid/content/Context;)V
      // 1c: aload 2
      // 1d: putstatic com/google/android/gms/common/api/internal/zzbz.b Lcom/google/android/gms/common/api/internal/zzbz;
      // 20: getstatic com/google/android/gms/common/api/internal/zzbz.b Lcom/google/android/gms/common/api/internal/zzbz;
      // 23: getfield com/google/android/gms/common/api/internal/zzbz.d Lcom/google/android/gms/common/api/Status;
      // 26: astore 0
      // 27: aload 1
      // 28: monitorexit
      // 29: aload 0
      // 2a: areturn
      // 2b: astore 0
      // 2c: aload 1
      // 2d: monitorexit
      // 2e: aload 0
      // 2f: athrow
      // try (8 -> 17): 24 null
      // try (17 -> 22): 24 null
      // try (25 -> 27): 24 null
   }

   private static zzbz a(String param0) {
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
      // 00: getstatic com/google/android/gms/common/api/internal/zzbz.a Ljava/lang/Object;
      // 03: astore 2
      // 04: aload 2
      // 05: monitorenter
      // 06: getstatic com/google/android/gms/common/api/internal/zzbz.b Lcom/google/android/gms/common/api/internal/zzbz;
      // 09: ifnonnull 44
      // 0c: new java/lang/IllegalStateException
      // 0f: astore 4
      // 11: aload 0
      // 12: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 15: invokevirtual java/lang/String.length ()I
      // 18: istore 1
      // 19: new java/lang/StringBuilder
      // 1c: astore 3
      // 1d: aload 3
      // 1e: iload 1
      // 1f: bipush 34
      // 21: iadd
      // 22: invokespecial java/lang/StringBuilder.<init> (I)V
      // 25: aload 4
      // 27: aload 3
      // 28: ldc "Initialize must be called before "
      // 2a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2d: aload 0
      // 2e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 31: ldc "."
      // 33: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 36: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 39: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 3c: aload 4
      // 3e: athrow
      // 3f: astore 0
      // 40: aload 2
      // 41: monitorexit
      // 42: aload 0
      // 43: athrow
      // 44: getstatic com/google/android/gms/common/api/internal/zzbz.b Lcom/google/android/gms/common/api/internal/zzbz;
      // 47: astore 0
      // 48: aload 2
      // 49: monitorexit
      // 4a: aload 0
      // 4b: areturn
      // try (4 -> 31): 31 null
      // try (32 -> 34): 31 null
      // try (36 -> 40): 31 null
   }

   public static String a() {
      return a("getGoogleAppId").c;
   }

   public static boolean b() {
      return a("isMeasurementExplicitlyDisabled").f;
   }
}
