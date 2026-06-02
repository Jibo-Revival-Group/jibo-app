package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zzckc extends zzcjl {
   protected zzckf a;
   private volatile AppMeasurement.zzb b;
   private AppMeasurement.zzb c;
   private long d;
   private final Map<Activity, zzckf> e = new ArrayMap<>();
   private final CopyOnWriteArrayList<AppMeasurement.zza> f = new CopyOnWriteArrayList<>();
   private boolean g;
   private AppMeasurement.zzb h;
   private String i;

   public zzckc(zzcim var1) {
      super(var1);
   }

   private static String a(String var0) {
      String[] var1 = var0.split("\\.");
      if (var1.length == 0) {
         var0 = var0.substring(0, 36);
      } else {
         String var3 = var1[var1.length - 1];
         var0 = var3;
         if (var3.length() > 36) {
            var0 = var3.substring(0, 36);
         }
      }

      return var0;
   }

   private final void a(Activity param1, zzckf param2, boolean param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: bipush 1
      // 001: istore 5
      // 003: bipush 1
      // 004: istore 4
      // 006: aload 0
      // 007: getfield com/google/android/gms/internal/zzckc.b Lcom/google/android/gms/measurement/AppMeasurement$zzb;
      // 00a: ifnull 065
      // 00d: aload 0
      // 00e: getfield com/google/android/gms/internal/zzckc.b Lcom/google/android/gms/measurement/AppMeasurement$zzb;
      // 011: astore 7
      // 013: aload 7
      // 015: ifnull 134
      // 018: new com/google/android/gms/measurement/AppMeasurement$zzb
      // 01b: dup
      // 01c: aload 7
      // 01e: invokespecial com/google/android/gms/measurement/AppMeasurement$zzb.<init> (Lcom/google/android/gms/measurement/AppMeasurement$zzb;)V
      // 021: astore 7
      // 023: aload 0
      // 024: bipush 1
      // 025: putfield com/google/android/gms/internal/zzckc.g Z
      // 028: aload 0
      // 029: getfield com/google/android/gms/internal/zzckc.f Ljava/util/concurrent/CopyOnWriteArrayList;
      // 02c: invokevirtual java/util/concurrent/CopyOnWriteArrayList.iterator ()Ljava/util/Iterator;
      // 02f: astore 8
      // 031: iload 4
      // 033: istore 5
      // 035: aload 8
      // 037: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 03c: ifeq 11b
      // 03f: iload 4
      // 041: istore 5
      // 043: aload 8
      // 045: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 04a: checkcast com/google/android/gms/measurement/AppMeasurement$zza
      // 04d: astore 9
      // 04f: aload 9
      // 051: aload 7
      // 053: aload 2
      // 054: invokeinterface com/google/android/gms/measurement/AppMeasurement$zza.a (Lcom/google/android/gms/measurement/AppMeasurement$zzb;Lcom/google/android/gms/measurement/AppMeasurement$zzb;)Z 3
      // 059: istore 6
      // 05b: iload 4
      // 05d: iload 6
      // 05f: iand
      // 060: istore 4
      // 062: goto 031
      // 065: aload 0
      // 066: getfield com/google/android/gms/internal/zzckc.c Lcom/google/android/gms/measurement/AppMeasurement$zzb;
      // 069: ifnull 13a
      // 06c: aload 0
      // 06d: invokevirtual com/google/android/gms/internal/zzcjk.k ()Lcom/google/android/gms/common/util/zzd;
      // 070: invokeinterface com/google/android/gms/common/util/zzd.b ()J 1
      // 075: aload 0
      // 076: getfield com/google/android/gms/internal/zzckc.d J
      // 079: lsub
      // 07a: invokestatic java/lang/Math.abs (J)J
      // 07d: ldc2_w 1000
      // 080: lcmp
      // 081: ifge 13a
      // 084: aload 0
      // 085: getfield com/google/android/gms/internal/zzckc.c Lcom/google/android/gms/measurement/AppMeasurement$zzb;
      // 088: astore 7
      // 08a: goto 013
      // 08d: astore 9
      // 08f: iload 4
      // 091: istore 5
      // 093: aload 0
      // 094: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 097: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 09a: ldc "onScreenChangeCallback threw exception"
      // 09c: aload 9
      // 09e: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 0a1: goto 031
      // 0a4: astore 7
      // 0a6: iload 5
      // 0a8: istore 4
      // 0aa: aload 0
      // 0ab: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 0ae: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 0b1: ldc "onScreenChangeCallback loop threw exception"
      // 0b3: aload 7
      // 0b5: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 0b8: aload 0
      // 0b9: bipush 0
      // 0ba: putfield com/google/android/gms/internal/zzckc.g Z
      // 0bd: aload 0
      // 0be: getfield com/google/android/gms/internal/zzckc.b Lcom/google/android/gms/measurement/AppMeasurement$zzb;
      // 0c1: ifnonnull 12b
      // 0c4: aload 0
      // 0c5: getfield com/google/android/gms/internal/zzckc.c Lcom/google/android/gms/measurement/AppMeasurement$zzb;
      // 0c8: astore 7
      // 0ca: iload 4
      // 0cc: ifeq 11a
      // 0cf: aload 2
      // 0d0: getfield com/google/android/gms/internal/zzckf.c Ljava/lang/String;
      // 0d3: ifnonnull 0e4
      // 0d6: aload 2
      // 0d7: aload 1
      // 0d8: invokevirtual java/lang/Object.getClass ()Ljava/lang/Class;
      // 0db: invokevirtual java/lang/Class.getCanonicalName ()Ljava/lang/String;
      // 0de: invokestatic com/google/android/gms/internal/zzckc.a (Ljava/lang/String;)Ljava/lang/String;
      // 0e1: putfield com/google/android/gms/internal/zzckf.c Ljava/lang/String;
      // 0e4: new com/google/android/gms/internal/zzckf
      // 0e7: dup
      // 0e8: aload 2
      // 0e9: invokespecial com/google/android/gms/internal/zzckf.<init> (Lcom/google/android/gms/internal/zzckf;)V
      // 0ec: astore 1
      // 0ed: aload 0
      // 0ee: aload 0
      // 0ef: getfield com/google/android/gms/internal/zzckc.b Lcom/google/android/gms/measurement/AppMeasurement$zzb;
      // 0f2: putfield com/google/android/gms/internal/zzckc.c Lcom/google/android/gms/measurement/AppMeasurement$zzb;
      // 0f5: aload 0
      // 0f6: aload 0
      // 0f7: invokevirtual com/google/android/gms/internal/zzcjk.k ()Lcom/google/android/gms/common/util/zzd;
      // 0fa: invokeinterface com/google/android/gms/common/util/zzd.b ()J 1
      // 0ff: putfield com/google/android/gms/internal/zzckc.d J
      // 102: aload 0
      // 103: aload 1
      // 104: putfield com/google/android/gms/internal/zzckc.b Lcom/google/android/gms/measurement/AppMeasurement$zzb;
      // 107: aload 0
      // 108: invokevirtual com/google/android/gms/internal/zzcjk.s ()Lcom/google/android/gms/internal/zzcih;
      // 10b: new com/google/android/gms/internal/zzckd
      // 10e: dup
      // 10f: aload 0
      // 110: iload 3
      // 111: aload 7
      // 113: aload 1
      // 114: invokespecial com/google/android/gms/internal/zzckd.<init> (Lcom/google/android/gms/internal/zzckc;ZLcom/google/android/gms/measurement/AppMeasurement$zzb;Lcom/google/android/gms/internal/zzckf;)V
      // 117: invokevirtual com/google/android/gms/internal/zzcih.a (Ljava/lang/Runnable;)V
      // 11a: return
      // 11b: aload 0
      // 11c: bipush 0
      // 11d: putfield com/google/android/gms/internal/zzckc.g Z
      // 120: goto 0bd
      // 123: astore 1
      // 124: aload 0
      // 125: bipush 0
      // 126: putfield com/google/android/gms/internal/zzckc.g Z
      // 129: aload 1
      // 12a: athrow
      // 12b: aload 0
      // 12c: getfield com/google/android/gms/internal/zzckc.b Lcom/google/android/gms/measurement/AppMeasurement$zzb;
      // 12f: astore 7
      // 131: goto 0ca
      // 134: aconst_null
      // 135: astore 7
      // 137: goto 023
      // 13a: aconst_null
      // 13b: astore 7
      // 13d: goto 013
      // try (20 -> 24): 72 java/lang/Exception
      // try (20 -> 24): 133 null
      // try (26 -> 29): 72 java/lang/Exception
      // try (26 -> 29): 133 null
      // try (31 -> 35): 72 java/lang/Exception
      // try (31 -> 35): 133 null
      // try (35 -> 40): 62 java/lang/Exception
      // try (35 -> 40): 133 null
      // try (65 -> 71): 72 java/lang/Exception
      // try (65 -> 71): 133 null
      // try (75 -> 81): 133 null
   }

   private final void a(zzckf var1) {
      this.d().a(this.k().b());
      if (this.r().a(var1.a)) {
         var1.a = false;
      }
   }

   public static void a(AppMeasurement.zzb var0, Bundle var1) {
      if (var1 != null && var0 != null && !var1.containsKey("_sc")) {
         if (var0.b != null) {
            var1.putString("_sn", var0.b);
         }

         var1.putString("_sc", var0.c);
         var1.putLong("_si", var0.d);
      }
   }

   final zzckf a(Activity var1) {
      zzbq.a(var1);
      zzckf var3 = this.e.get(var1);
      zzckf var2 = var3;
      if (var3 == null) {
         var2 = new zzckf(null, a(var1.getClass().getCanonicalName()), this.p().y());
         this.e.put(var1, var2);
      }

      return var2;
   }

   public final void a(Activity var1, Bundle var2) {
      if (var2 != null) {
         zzckf var3 = this.e.get(var1);
         if (var3 != null) {
            Bundle var4 = new Bundle();
            var4.putLong("id", var3.d);
            var4.putString("name", var3.b);
            var4.putString("referrer_name", var3.c);
            var2.putBundle("com.google.firebase.analytics.screen_service", var4);
         }
      }
   }

   public final void a(Activity var1, String var2, String var3) {
      if (var1 == null) {
         this.t().A().a("setCurrentScreen must be called with a non-null activity");
      } else {
         this.s();
         if (!zzcih.y()) {
            this.t().A().a("setCurrentScreen must be called from the main thread");
         } else if (this.g) {
            this.t().A().a("Cannot call setCurrentScreen from onScreenChangeCallback");
         } else if (this.b == null) {
            this.t().A().a("setCurrentScreen cannot be called while no activity active");
         } else if (this.e.get(var1) == null) {
            this.t().A().a("setCurrentScreen must be called with an activity in the activity lifecycle");
         } else {
            String var6 = var3;
            if (var3 == null) {
               var6 = a(var1.getClass().getCanonicalName());
            }

            boolean var4 = this.b.c.equals(var6);
            boolean var5 = zzclq.a(this.b.b, var2);
            if (var4 && var5) {
               this.t().B().a("setCurrentScreen cannot be called with the same class and name");
            } else if (var2 == null || var2.length() > 0 && var2.length() <= 100) {
               if (var6 == null || var6.length() > 0 && var6.length() <= 100) {
                  zzcho var7 = this.t().E();
                  if (var2 == null) {
                     var3 = "null";
                  } else {
                     var3 = var2;
                  }

                  var7.a("Setting current screen to name, class", var3, var6);
                  zzckf var8 = new zzckf(var2, var6, this.p().y());
                  this.e.put(var1, var8);
                  this.a(var1, var8, true);
               } else {
                  this.t().A().a("Invalid class name length in setCurrentScreen. Length", var6.length());
               }
            } else {
               this.t().A().a("Invalid screen name length in setCurrentScreen. Length", var2.length());
            }
         }
      }
   }

   public final void a(AppMeasurement.zza var1) {
      if (var1 == null) {
         this.t().A().a("Attempting to register null OnScreenChangeCallback");
      } else {
         this.f.remove(var1);
         this.f.add(var1);
      }
   }

   public final void a(String param1, AppMeasurement.zzb param2) {
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
      // 01: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 04: aload 0
      // 05: monitorenter
      // 06: aload 0
      // 07: getfield com/google/android/gms/internal/zzckc.i Ljava/lang/String;
      // 0a: ifnull 1c
      // 0d: aload 0
      // 0e: getfield com/google/android/gms/internal/zzckc.i Ljava/lang/String;
      // 11: aload 1
      // 12: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 15: ifne 1c
      // 18: aload 2
      // 19: ifnull 26
      // 1c: aload 0
      // 1d: aload 1
      // 1e: putfield com/google/android/gms/internal/zzckc.i Ljava/lang/String;
      // 21: aload 0
      // 22: aload 2
      // 23: putfield com/google/android/gms/internal/zzckc.h Lcom/google/android/gms/measurement/AppMeasurement$zzb;
      // 26: aload 0
      // 27: monitorexit
      // 28: return
      // 29: astore 1
      // 2a: aload 0
      // 2b: monitorexit
      // 2c: aload 1
      // 2d: athrow
      // try (4 -> 12): 23 null
      // try (14 -> 20): 23 null
      // try (20 -> 22): 23 null
      // try (24 -> 26): 23 null
   }

   public final void b(Activity var1) {
      this.a(var1, this.a(var1), false);
      zzcgd var4 = this.d();
      long var2 = var4.k().b();
      var4.s().a(new zzcgg(var4, var2));
   }

   public final void b(AppMeasurement.zza var1) {
      this.f.remove(var1);
   }

   public final void c(Activity var1) {
      zzckf var2 = this.a(var1);
      this.c = this.b;
      this.d = this.k().b();
      this.b = null;
      this.s().a(new zzcke(this, var2));
   }

   public final void d(Activity var1) {
      this.e.remove(var1);
   }

   @Override
   protected final boolean w() {
      return false;
   }

   public final zzckf y() {
      this.Q();
      this.c();
      return this.a;
   }

   public final AppMeasurement.zzb z() {
      AppMeasurement.zzb var1 = this.b;
      if (var1 == null) {
         var1 = null;
      } else {
         var1 = new AppMeasurement.zzb(var1);
      }

      return var1;
   }
}
