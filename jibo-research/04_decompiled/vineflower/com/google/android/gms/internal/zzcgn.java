package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import java.lang.reflect.InvocationTargetException;

public final class zzcgn extends zzcjk {
   private Boolean a;

   zzcgn(zzcim var1) {
      super(var1);
   }

   public static boolean B() {
      return zzchc.a.b();
   }

   public static long y() {
      return zzchc.F.b();
   }

   public static long z() {
      return zzchc.f.b();
   }

   public final String A() {
      try {
         return (String)Class.forName("android.os.SystemProperties")
            .getMethod("get", String.class, String.class)
            .invoke(null, "debug.firebase.analytics.app", "");
      } catch (ClassNotFoundException var2) {
         this.t().y().a("Could not find SystemProperties class", var2);
      } catch (NoSuchMethodException var3) {
         this.t().y().a("Could not find SystemProperties.get() method", var3);
      } catch (IllegalAccessException var4) {
         this.t().y().a("Could not access SystemProperties.get()", var4);
      } catch (InvocationTargetException var5) {
         this.t().y().a("SystemProperties.get() threw an exception", var5);
      }

      return "";
   }

   public final int a(String var1) {
      return this.b(var1, zzchc.q);
   }

   public final long a(String var1, zzchd<Long> var2) {
      long var3;
      if (var1 == null) {
         var3 = (Long)var2.b();
      } else {
         var1 = this.q().a(var1, var2.a());
         if (TextUtils.isEmpty(var1)) {
            var3 = (Long)var2.b();
         } else {
            try {
               var3 = var2.a(Long.valueOf(var1));
            } catch (NumberFormatException var5) {
               var3 = (Long)var2.b();
            }
         }
      }

      return var3;
   }

   public final int b(String var1, zzchd<Integer> var2) {
      int var3;
      if (var1 == null) {
         var3 = (Integer)var2.b();
      } else {
         var1 = this.q().a(var1, var2.a());
         if (TextUtils.isEmpty(var1)) {
            var3 = (Integer)var2.b();
         } else {
            try {
               var3 = var2.a(Integer.valueOf(var1));
            } catch (NumberFormatException var4) {
               var3 = (Integer)var2.b();
            }
         }
      }

      return var3;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   final Boolean b(String var1) {
      Object var4 = null;
      zzbq.a(var1);

      try {
         if (this.l().getPackageManager() == null) {
            this.t().y().a("Failed to load metadata: PackageManager is null");
            return (Boolean)var4;
         }
      } catch (NameNotFoundException var10) {
         this.t().y().a("Failed to load metadata: Package name not found", var10);
         return (Boolean)var4;
      }

      ApplicationInfo var5;
      try {
         var5 = zzbhf.a(this.l()).a(this.l().getPackageName(), 128);
      } catch (NameNotFoundException var9) {
         this.t().y().a("Failed to load metadata: Package name not found", var9);
         return (Boolean)var4;
      }

      Object var3;
      if (var5 == null) {
         try {
            this.t().y().a("Failed to load metadata: ApplicationInfo is null");
         } catch (NameNotFoundException var8) {
            this.t().y().a("Failed to load metadata: Package name not found", var8);
            return (Boolean)var4;
         }

         var3 = var4;
      } else {
         label82: {
            try {
               if (var5.metaData == null) {
                  this.t().y().a("Failed to load metadata: Metadata bundle is null");
                  break label82;
               }
            } catch (NameNotFoundException var7) {
               this.t().y().a("Failed to load metadata: Package name not found", var7);
               return (Boolean)var4;
            }

            var3 = var4;

            boolean var2;
            try {
               if (!var5.metaData.containsKey(var1)) {
                  return (Boolean)var3;
               }

               var2 = var5.metaData.getBoolean(var1);
            } catch (NameNotFoundException var6) {
               this.t().y().a("Failed to load metadata: Package name not found", var6);
               return (Boolean)var4;
            }

            return var2;
         }

         var3 = var4;
      }

      return (Boolean)var3;
   }

   public final boolean c(String var1) {
      return "1".equals(this.q().a(var1, "gaia_collection_enabled"));
   }

   public final boolean w() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.util.collections.fixed.FastFixedSet.contains(Object)" because "predset" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.lambda$removeErroneousNodes$1(FastExtendedPostdominanceHelper.java:231)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.iterateReachability(FastExtendedPostdominanceHelper.java:373)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.removeErroneousNodes(FastExtendedPostdominanceHelper.java:207)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.getExtendedPostdominators(FastExtendedPostdominanceHelper.java:63)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.findGeneralStatement(DomHelper.java:537)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:472)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:379)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:208)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/google/android/gms/internal/zzcgn.a Ljava/lang/Boolean;
      // 04: ifnonnull 58
      // 07: aload 0
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield com/google/android/gms/internal/zzcgn.a Ljava/lang/Boolean;
      // 0d: ifnonnull 56
      // 10: aload 0
      // 11: invokevirtual com/google/android/gms/internal/zzcjk.l ()Landroid/content/Context;
      // 14: invokevirtual android/content/Context.getApplicationInfo ()Landroid/content/pm/ApplicationInfo;
      // 17: astore 3
      // 18: invokestatic com/google/android/gms/common/util/zzs.a ()Ljava/lang/String;
      // 1b: astore 2
      // 1c: aload 3
      // 1d: ifnull 3b
      // 20: aload 3
      // 21: getfield android/content/pm/ApplicationInfo.processName Ljava/lang/String;
      // 24: astore 3
      // 25: aload 3
      // 26: ifnull 60
      // 29: aload 3
      // 2a: aload 2
      // 2b: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 2e: ifeq 60
      // 31: bipush 1
      // 32: istore 1
      // 33: aload 0
      // 34: iload 1
      // 35: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 38: putfield com/google/android/gms/internal/zzcgn.a Ljava/lang/Boolean;
      // 3b: aload 0
      // 3c: getfield com/google/android/gms/internal/zzcgn.a Ljava/lang/Boolean;
      // 3f: ifnonnull 56
      // 42: aload 0
      // 43: getstatic java/lang/Boolean.TRUE Ljava/lang/Boolean;
      // 46: putfield com/google/android/gms/internal/zzcgn.a Ljava/lang/Boolean;
      // 49: aload 0
      // 4a: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 4d: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 50: ldc_w "My process not in the list of running processes"
      // 53: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 56: aload 0
      // 57: monitorexit
      // 58: aload 0
      // 59: getfield com/google/android/gms/internal/zzcgn.a Ljava/lang/Boolean;
      // 5c: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 5f: ireturn
      // 60: bipush 0
      // 61: istore 1
      // 62: goto 33
      // 65: astore 2
      // 66: aload 0
      // 67: monitorexit
      // 68: aload 2
      // 69: athrow
      // try (5 -> 14): 51 null
      // try (16 -> 19): 51 null
      // try (21 -> 25): 51 null
      // try (27 -> 31): 51 null
      // try (31 -> 42): 51 null
      // try (42 -> 44): 51 null
      // try (52 -> 54): 51 null
   }

   public final boolean x() {
      Boolean var2 = this.b("firebase_analytics_collection_deactivated");
      boolean var1;
      if (var2 != null && var2) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }
}
