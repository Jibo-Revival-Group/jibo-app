package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.UserManager;
import android.os.Build.VERSION;
import android.support.v4.content.PermissionChecker;

public abstract class zzcui<T> {
   private static final Object b = new Object();
   private static Context c = null;
   private static boolean d = false;
   private static Boolean e = null;
   final String a;
   private final zzcup f;
   private final String g;
   private final T h;
   private T i = (T)null;

   private zzcui(zzcup var1, String var2, T var3) {
      if (zzcup.a(var1) == null && zzcup.b(var1) == null) {
         throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
      }

      if (zzcup.a(var1) != null && zzcup.b(var1) != null) {
         throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
      }

      this.f = var1;
      String var5 = String.valueOf(zzcup.c(var1));
      String var4 = String.valueOf(var2);
      if (var4.length() != 0) {
         var4 = var5.concat(var4);
      } else {
         var4 = new String(var5);
      }

      this.g = var4;
      String var6 = String.valueOf(zzcup.d(var1));
      var2 = String.valueOf(var2);
      String var7;
      if (var2.length() != 0) {
         var7 = var6.concat(var2);
      } else {
         var7 = new String(var6);
      }

      this.a = var7;
      this.h = (T)var3;
   }

   private static <V> V a(zzcuo<V> var0) {
      Object var3;
      try {
         var3 = var0.a();
      } catch (SecurityException var7) {
         long var1 = Binder.clearCallingIdentity();

         try {
            return (V)var0.a();
         } finally {
            Binder.restoreCallingIdentity(var1);
         }
      }

      return (V)var3;
   }

   public static void a(Context param0) {
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
      // 00: getstatic com/google/android/gms/internal/zzcui.c Landroid/content/Context;
      // 03: ifnonnull 30
      // 06: getstatic com/google/android/gms/internal/zzcui.b Ljava/lang/Object;
      // 09: astore 2
      // 0a: aload 2
      // 0b: monitorenter
      // 0c: getstatic android/os/Build$VERSION.SDK_INT I
      // 0f: bipush 24
      // 11: if_icmplt 31
      // 14: aload 0
      // 15: invokevirtual android/content/Context.isDeviceProtectedStorage ()Z
      // 18: ifeq 31
      // 1b: getstatic com/google/android/gms/internal/zzcui.c Landroid/content/Context;
      // 1e: aload 0
      // 1f: if_acmpeq 26
      // 22: aconst_null
      // 23: putstatic com/google/android/gms/internal/zzcui.e Ljava/lang/Boolean;
      // 26: aload 0
      // 27: putstatic com/google/android/gms/internal/zzcui.c Landroid/content/Context;
      // 2a: aload 2
      // 2b: monitorexit
      // 2c: bipush 0
      // 2d: putstatic com/google/android/gms/internal/zzcui.d Z
      // 30: return
      // 31: aload 0
      // 32: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 35: astore 1
      // 36: aload 1
      // 37: ifnull 1b
      // 3a: aload 1
      // 3b: astore 0
      // 3c: goto 1b
      // 3f: astore 0
      // 40: aload 2
      // 41: monitorexit
      // 42: aload 0
      // 43: athrow
      // try (6 -> 12): 32 null
      // try (12 -> 17): 32 null
      // try (17 -> 21): 32 null
      // try (24 -> 27): 32 null
      // try (33 -> 35): 32 null
   }

   static boolean a(String var0, boolean var1) {
      var1 = false;
      if (e()) {
         var1 = a(new zzcul(var0, false));
      }

      return var1;
   }

   private static zzcui<String> b(zzcup var0, String var1, String var2) {
      return new zzcun(var0, var1, var2);
   }

   @TargetApi(24)
   private final T c() {
      if (!a("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
         if (zzcup.b(this.f) != null) {
            String var1 = a(new zzcuj(this, zzctv.a(c.getContentResolver(), zzcup.b(this.f))));
            if (var1 != null) {
               return this.a(var1);
            }
         } else if (zzcup.a(this.f) != null) {
            if (VERSION.SDK_INT >= 24 && !c.isDeviceProtectedStorage() && !((UserManager)c.getSystemService(UserManager.class)).isUserUnlocked()) {
               return null;
            }

            SharedPreferences var3 = c.getSharedPreferences(zzcup.a(this.f), 0);
            if (var3.contains(this.a)) {
               return this.a(var3);
            }
         }
      }

      return null;
   }

   private final T d() {
      if (!zzcup.f(this.f) && e()) {
         String var1 = a(new zzcuk(this));
         if (var1 != null) {
            return this.a(var1);
         }
      }

      return null;
   }

   private static boolean e() {
      boolean var0 = false;
      boolean var1 = false;
      if (e == null) {
         if (c == null) {
            return var0;
         }

         var0 = var1;
         if (PermissionChecker.b(c, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
            var0 = true;
         }

         e = var0;
      }

      return e;
   }

   public final T a() {
      if (c == null) {
         throw new IllegalStateException("Must call PhenotypeFlag.init() first");
      }

      if (zzcup.e(this.f)) {
         Object var1 = this.d();
         if (var1 != null) {
            return (T)var1;
         }

         Object var2 = this.c();
         var1 = var2;
         if (var2 != null) {
            return (T)var1;
         }
      } else {
         Object var3 = this.c();
         Object var5 = var3;
         if (var3 != null) {
            return (T)var5;
         }

         var5 = this.d();
         if (var5 != null) {
            return (T)var5;
         }
      }

      return this.h;
   }

   public abstract T a(SharedPreferences var1);

   public abstract T a(String var1);
}
