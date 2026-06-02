package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

public final class zzcjn extends zzcjl {
   protected zzckb a;
   private AppMeasurement.EventInterceptor b;
   private final Set<AppMeasurement.OnEventListener> c = new CopyOnWriteArraySet<>();
   private boolean d;
   private final AtomicReference<String> e = new AtomicReference<>();

   protected zzcjn(zzcim var1) {
      super(var1);
   }

   private final void a(String var1, String var2, long var3, Bundle var5, boolean var6, boolean var7, boolean var8, String var9) {
      if (var5 == null) {
         var5 = new Bundle();
      } else {
         Bundle var11 = new Bundle(var5);
         Iterator var12 = var11.keySet().iterator();

         while (true) {
            var5 = var11;
            if (!var12.hasNext()) {
               break;
            }

            String var13 = (String)var12.next();
            Object var15 = var11.get(var13);
            if (var15 instanceof Bundle) {
               var11.putBundle(var13, new Bundle((Bundle)var15));
            } else if (var15 instanceof Parcelable[]) {
               Parcelable[] var17 = (Parcelable[])var15;

               for (int var18 = 0; var18 < var17.length; var18++) {
                  if (var17[var18] instanceof Bundle) {
                     var17[var18] = new Bundle((Bundle)var17[var18]);
                  }
               }
            } else if (var15 instanceof ArrayList) {
               ArrayList var16 = (ArrayList)var15;

               for (int var10 = 0; var10 < var16.size(); var10++) {
                  Object var19 = var16.get(var10);
                  if (var19 instanceof Bundle) {
                     var16.set(var10, new Bundle((Bundle)var19));
                  }
               }
            }
         }
      }

      this.s().a(new zzcjv(this, var1, var2, var3, var5, var6, var7, var8, var9));
   }

   private final void a(String var1, String var2, long var3, Object var5) {
      this.s().a(new zzcjw(this, var1, var2, var5, var3));
   }

   private final void a(String var1, String var2, Bundle var3, boolean var4, boolean var5, boolean var6, String var7) {
      this.a(var1, var2, this.k().a(), var3, true, var5, var6, null);
   }

   private final void a(String var1, String var2, Object var3, long var4) {
      zzbq.a(var1);
      zzbq.a(var2);
      this.c();
      this.Q();
      if (!this.p.B()) {
         this.t().D().a("User property not set since app measurement is disabled");
      } else if (this.p.b()) {
         this.t().D().a("Setting user property (FE)", this.o().a(var2), var3);
         zzcln var6 = new zzcln(var2, var4, var3, var1);
         this.i().a(var6);
      }
   }

   private final List<AppMeasurement.ConditionalUserProperty> b(String param1, String param2, String param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: invokevirtual com/google/android/gms/internal/zzcjk.s ()Lcom/google/android/gms/internal/zzcih;
      // 004: invokevirtual com/google/android/gms/internal/zzcih.z ()Z
      // 007: ifeq 01c
      // 00a: aload 0
      // 00b: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 00e: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 011: ldc "Cannot get conditional user properties from analytics worker thread"
      // 013: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 016: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 019: astore 1
      // 01a: aload 1
      // 01b: areturn
      // 01c: aload 0
      // 01d: invokevirtual com/google/android/gms/internal/zzcjk.s ()Lcom/google/android/gms/internal/zzcih;
      // 020: pop
      // 021: invokestatic com/google/android/gms/internal/zzcih.y ()Z
      // 024: ifeq 03a
      // 027: aload 0
      // 028: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 02b: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 02e: ldc "Cannot get conditional user properties from main thread"
      // 030: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 033: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 036: astore 1
      // 037: goto 01a
      // 03a: new java/util/concurrent/atomic/AtomicReference
      // 03d: dup
      // 03e: invokespecial java/util/concurrent/atomic/AtomicReference.<init> ()V
      // 041: astore 4
      // 043: aload 4
      // 045: monitorenter
      // 046: aload 0
      // 047: getfield com/google/android/gms/internal/zzcjn.p Lcom/google/android/gms/internal/zzcim;
      // 04a: invokevirtual com/google/android/gms/internal/zzcim.h ()Lcom/google/android/gms/internal/zzcih;
      // 04d: astore 5
      // 04f: new com/google/android/gms/internal/zzcjr
      // 052: astore 6
      // 054: aload 6
      // 056: aload 0
      // 057: aload 4
      // 059: aload 1
      // 05a: aload 2
      // 05b: aload 3
      // 05c: invokespecial com/google/android/gms/internal/zzcjr.<init> (Lcom/google/android/gms/internal/zzcjn;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      // 05f: aload 5
      // 061: aload 6
      // 063: invokevirtual com/google/android/gms/internal/zzcih.a (Ljava/lang/Runnable;)V
      // 066: aload 4
      // 068: ldc2_w 5000
      // 06b: invokevirtual java/lang/Object.wait (J)V
      // 06e: aload 4
      // 070: monitorexit
      // 071: aload 4
      // 073: invokevirtual java/util/concurrent/atomic/AtomicReference.get ()Ljava/lang/Object;
      // 076: checkcast java/util/List
      // 079: astore 4
      // 07b: aload 4
      // 07d: ifnonnull 0ac
      // 080: aload 0
      // 081: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 084: invokevirtual com/google/android/gms/internal/zzchm.A ()Lcom/google/android/gms/internal/zzcho;
      // 087: ldc "Timed out waiting for get conditional user properties"
      // 089: aload 1
      // 08a: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 08d: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 090: astore 1
      // 091: goto 01a
      // 094: astore 3
      // 095: aload 0
      // 096: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 099: invokevirtual com/google/android/gms/internal/zzchm.A ()Lcom/google/android/gms/internal/zzcho;
      // 09c: ldc "Interrupted waiting for get conditional user properties"
      // 09e: aload 1
      // 09f: aload 3
      // 0a0: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 0a3: goto 06e
      // 0a6: astore 1
      // 0a7: aload 4
      // 0a9: monitorexit
      // 0aa: aload 1
      // 0ab: athrow
      // 0ac: new java/util/ArrayList
      // 0af: dup
      // 0b0: aload 4
      // 0b2: invokeinterface java/util/List.size ()I 1
      // 0b7: invokespecial java/util/ArrayList.<init> (I)V
      // 0ba: astore 3
      // 0bb: aload 4
      // 0bd: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0c2: astore 4
      // 0c4: aload 4
      // 0c6: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0cb: ifeq 1e4
      // 0ce: aload 4
      // 0d0: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0d5: checkcast com/google/android/gms/internal/zzcgl
      // 0d8: astore 5
      // 0da: new com/google/android/gms/measurement/AppMeasurement$ConditionalUserProperty
      // 0dd: dup
      // 0de: invokespecial com/google/android/gms/measurement/AppMeasurement$ConditionalUserProperty.<init> ()V
      // 0e1: astore 6
      // 0e3: aload 6
      // 0e5: aload 1
      // 0e6: putfield com/google/android/gms/measurement/AppMeasurement$ConditionalUserProperty.mAppId Ljava/lang/String;
      // 0e9: aload 6
      // 0eb: aload 2
      // 0ec: putfield com/google/android/gms/measurement/AppMeasurement$ConditionalUserProperty.mOrigin Ljava/lang/String;
      // 0ef: aload 6
      // 0f1: aload 5
      // 0f3: getfield com/google/android/gms/internal/zzcgl.d J
      // 0f6: putfield com/google/android/gms/measurement/AppMeasurement$ConditionalUserProperty.mCreationTimestamp J
      // 0f9: aload 6
      // 0fb: aload 5
      // 0fd: getfield com/google/android/gms/internal/zzcgl.c Lcom/google/android/gms/internal/zzcln;
      // 100: getfield com/google/android/gms/internal/zzcln.a Ljava/lang/String;
      // 103: putfield com/google/android/gms/measurement/AppMeasurement$ConditionalUserProperty.mName Ljava/lang/String;
      // 106: aload 6
      // 108: aload 5
      // 10a: getfield com/google/android/gms/internal/zzcgl.c Lcom/google/android/gms/internal/zzcln;
      // 10d: invokevirtual com/google/android/gms/internal/zzcln.a ()Ljava/lang/Object;
      // 110: putfield com/google/android/gms/measurement/AppMeasurement$ConditionalUserProperty.mValue Ljava/lang/Object;
      // 113: aload 6
      // 115: aload 5
      // 117: getfield com/google/android/gms/internal/zzcgl.e Z
      // 11a: putfield com/google/android/gms/measurement/AppMeasurement$ConditionalUserProperty.mActive Z
      // 11d: aload 6
      // 11f: aload 5
      // 121: getfield com/google/android/gms/internal/zzcgl.f Ljava/lang/String;
      // 124: putfield com/google/android/gms/measurement/AppMeasurement$ConditionalUserProperty.mTriggerEventName Ljava/lang/String;
      // 127: aload 5
      // 129: getfield com/google/android/gms/internal/zzcgl.g Lcom/google/android/gms/internal/zzcha;
      // 12c: ifnull 157
      // 12f: aload 6
      // 131: aload 5
      // 133: getfield com/google/android/gms/internal/zzcgl.g Lcom/google/android/gms/internal/zzcha;
      // 136: getfield com/google/android/gms/internal/zzcha.a Ljava/lang/String;
      // 139: putfield com/google/android/gms/measurement/AppMeasurement$ConditionalUserProperty.mTimedOutEventName Ljava/lang/String;
      // 13c: aload 5
      // 13e: getfield com/google/android/gms/internal/zzcgl.g Lcom/google/android/gms/internal/zzcha;
      // 141: getfield com/google/android/gms/internal/zzcha.b Lcom/google/android/gms/internal/zzcgx;
      // 144: ifnull 157
      // 147: aload 6
      // 149: aload 5
      // 14b: getfield com/google/android/gms/internal/zzcgl.g Lcom/google/android/gms/internal/zzcha;
      // 14e: getfield com/google/android/gms/internal/zzcha.b Lcom/google/android/gms/internal/zzcgx;
      // 151: invokevirtual com/google/android/gms/internal/zzcgx.b ()Landroid/os/Bundle;
      // 154: putfield com/google/android/gms/measurement/AppMeasurement$ConditionalUserProperty.mTimedOutEventParams Landroid/os/Bundle;
      // 157: aload 6
      // 159: aload 5
      // 15b: getfield com/google/android/gms/internal/zzcgl.h J
      // 15e: putfield com/google/android/gms/measurement/AppMeasurement$ConditionalUserProperty.mTriggerTimeout J
      // 161: aload 5
      // 163: getfield com/google/android/gms/internal/zzcgl.i Lcom/google/android/gms/internal/zzcha;
      // 166: ifnull 191
      // 169: aload 6
      // 16b: aload 5
      // 16d: getfield com/google/android/gms/internal/zzcgl.i Lcom/google/android/gms/internal/zzcha;
      // 170: getfield com/google/android/gms/internal/zzcha.a Ljava/lang/String;
      // 173: putfield com/google/android/gms/measurement/AppMeasurement$ConditionalUserProperty.mTriggeredEventName Ljava/lang/String;
      // 176: aload 5
      // 178: getfield com/google/android/gms/internal/zzcgl.i Lcom/google/android/gms/internal/zzcha;
      // 17b: getfield com/google/android/gms/internal/zzcha.b Lcom/google/android/gms/internal/zzcgx;
      // 17e: ifnull 191
      // 181: aload 6
      // 183: aload 5
      // 185: getfield com/google/android/gms/internal/zzcgl.i Lcom/google/android/gms/internal/zzcha;
      // 188: getfield com/google/android/gms/internal/zzcha.b Lcom/google/android/gms/internal/zzcgx;
      // 18b: invokevirtual com/google/android/gms/internal/zzcgx.b ()Landroid/os/Bundle;
      // 18e: putfield com/google/android/gms/measurement/AppMeasurement$ConditionalUserProperty.mTriggeredEventParams Landroid/os/Bundle;
      // 191: aload 6
      // 193: aload 5
      // 195: getfield com/google/android/gms/internal/zzcgl.c Lcom/google/android/gms/internal/zzcln;
      // 198: getfield com/google/android/gms/internal/zzcln.b J
      // 19b: putfield com/google/android/gms/measurement/AppMeasurement$ConditionalUserProperty.mTriggeredTimestamp J
      // 19e: aload 6
      // 1a0: aload 5
      // 1a2: getfield com/google/android/gms/internal/zzcgl.j J
      // 1a5: putfield com/google/android/gms/measurement/AppMeasurement$ConditionalUserProperty.mTimeToLive J
      // 1a8: aload 5
      // 1aa: getfield com/google/android/gms/internal/zzcgl.k Lcom/google/android/gms/internal/zzcha;
      // 1ad: ifnull 1d8
      // 1b0: aload 6
      // 1b2: aload 5
      // 1b4: getfield com/google/android/gms/internal/zzcgl.k Lcom/google/android/gms/internal/zzcha;
      // 1b7: getfield com/google/android/gms/internal/zzcha.a Ljava/lang/String;
      // 1ba: putfield com/google/android/gms/measurement/AppMeasurement$ConditionalUserProperty.mExpiredEventName Ljava/lang/String;
      // 1bd: aload 5
      // 1bf: getfield com/google/android/gms/internal/zzcgl.k Lcom/google/android/gms/internal/zzcha;
      // 1c2: getfield com/google/android/gms/internal/zzcha.b Lcom/google/android/gms/internal/zzcgx;
      // 1c5: ifnull 1d8
      // 1c8: aload 6
      // 1ca: aload 5
      // 1cc: getfield com/google/android/gms/internal/zzcgl.k Lcom/google/android/gms/internal/zzcha;
      // 1cf: getfield com/google/android/gms/internal/zzcha.b Lcom/google/android/gms/internal/zzcgx;
      // 1d2: invokevirtual com/google/android/gms/internal/zzcgx.b ()Landroid/os/Bundle;
      // 1d5: putfield com/google/android/gms/measurement/AppMeasurement$ConditionalUserProperty.mExpiredEventParams Landroid/os/Bundle;
      // 1d8: aload 3
      // 1d9: aload 6
      // 1db: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1e0: pop
      // 1e1: goto 0c4
      // 1e4: aload 3
      // 1e5: astore 1
      // 1e6: goto 01a
      // try (32 -> 48): 77 null
      // try (48 -> 51): 68 java/lang/InterruptedException
      // try (48 -> 51): 77 null
      // try (51 -> 53): 77 null
      // try (69 -> 76): 77 null
      // try (78 -> 80): 77 null
   }

   private final Map<String, Object> b(String param1, String param2, String param3, boolean param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual com/google/android/gms/internal/zzcjk.s ()Lcom/google/android/gms/internal/zzcih;
      // 04: invokevirtual com/google/android/gms/internal/zzcih.z ()Z
      // 07: ifeq 1d
      // 0a: aload 0
      // 0b: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 0e: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 11: ldc_w "Cannot get user properties from analytics worker thread"
      // 14: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 17: invokestatic java/util/Collections.emptyMap ()Ljava/util/Map;
      // 1a: astore 1
      // 1b: aload 1
      // 1c: areturn
      // 1d: aload 0
      // 1e: invokevirtual com/google/android/gms/internal/zzcjk.s ()Lcom/google/android/gms/internal/zzcih;
      // 21: pop
      // 22: invokestatic com/google/android/gms/internal/zzcih.y ()Z
      // 25: ifeq 3c
      // 28: aload 0
      // 29: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 2c: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 2f: ldc_w "Cannot get user properties from main thread"
      // 32: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 35: invokestatic java/util/Collections.emptyMap ()Ljava/util/Map;
      // 38: astore 1
      // 39: goto 1b
      // 3c: new java/util/concurrent/atomic/AtomicReference
      // 3f: dup
      // 40: invokespecial java/util/concurrent/atomic/AtomicReference.<init> ()V
      // 43: astore 5
      // 45: aload 5
      // 47: monitorenter
      // 48: aload 0
      // 49: getfield com/google/android/gms/internal/zzcjn.p Lcom/google/android/gms/internal/zzcim;
      // 4c: invokevirtual com/google/android/gms/internal/zzcim.h ()Lcom/google/android/gms/internal/zzcih;
      // 4f: astore 6
      // 51: new com/google/android/gms/internal/zzcjs
      // 54: astore 7
      // 56: aload 7
      // 58: aload 0
      // 59: aload 5
      // 5b: aload 1
      // 5c: aload 2
      // 5d: aload 3
      // 5e: iload 4
      // 60: invokespecial com/google/android/gms/internal/zzcjs.<init> (Lcom/google/android/gms/internal/zzcjn;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
      // 63: aload 6
      // 65: aload 7
      // 67: invokevirtual com/google/android/gms/internal/zzcih.a (Ljava/lang/Runnable;)V
      // 6a: aload 5
      // 6c: ldc2_w 5000
      // 6f: invokevirtual java/lang/Object.wait (J)V
      // 72: aload 5
      // 74: monitorexit
      // 75: aload 5
      // 77: invokevirtual java/util/concurrent/atomic/AtomicReference.get ()Ljava/lang/Object;
      // 7a: checkcast java/util/List
      // 7d: astore 2
      // 7e: aload 2
      // 7f: ifnonnull ae
      // 82: aload 0
      // 83: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 86: invokevirtual com/google/android/gms/internal/zzchm.A ()Lcom/google/android/gms/internal/zzcho;
      // 89: ldc_w "Timed out waiting for get user properties"
      // 8c: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 8f: invokestatic java/util/Collections.emptyMap ()Ljava/util/Map;
      // 92: astore 1
      // 93: goto 1b
      // 96: astore 1
      // 97: aload 0
      // 98: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 9b: invokevirtual com/google/android/gms/internal/zzchm.A ()Lcom/google/android/gms/internal/zzcho;
      // 9e: ldc_w "Interrupted waiting for get user properties"
      // a1: aload 1
      // a2: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // a5: goto 72
      // a8: astore 1
      // a9: aload 5
      // ab: monitorexit
      // ac: aload 1
      // ad: athrow
      // ae: new android/support/v4/util/ArrayMap
      // b1: dup
      // b2: aload 2
      // b3: invokeinterface java/util/List.size ()I 1
      // b8: invokespecial android/support/v4/util/ArrayMap.<init> (I)V
      // bb: astore 1
      // bc: aload 2
      // bd: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // c2: astore 3
      // c3: aload 3
      // c4: invokeinterface java/util/Iterator.hasNext ()Z 1
      // c9: ifeq e8
      // cc: aload 3
      // cd: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // d2: checkcast com/google/android/gms/internal/zzcln
      // d5: astore 2
      // d6: aload 1
      // d7: aload 2
      // d8: getfield com/google/android/gms/internal/zzcln.a Ljava/lang/String;
      // db: aload 2
      // dc: invokevirtual com/google/android/gms/internal/zzcln.a ()Ljava/lang/Object;
      // df: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // e4: pop
      // e5: goto c3
      // e8: goto 1b
      // try (32 -> 49): 76 null
      // try (49 -> 52): 68 java/lang/InterruptedException
      // try (49 -> 52): 76 null
      // try (52 -> 54): 76 null
      // try (69 -> 75): 76 null
      // try (77 -> 79): 76 null
   }

   private final void b(String var1, String var2, long var3, Bundle var5, boolean var6, boolean var7, boolean var8, String var9) {
      zzbq.a(var1);
      zzbq.a(var2);
      zzbq.a(var5);
      this.c();
      this.Q();
      if (!this.p.B()) {
         this.t().D().a("Event not sent since app measurement is disabled");
      } else {
         if (!this.d) {
            this.d = true;

            try {
               Class var18 = Class.forName("com.google.android.gms.tagmanager.TagManagerService");

               try {
                  var18.getDeclaredMethod("initialize", Context.class).invoke(null, this.l());
               } catch (Exception var24) {
                  this.t().A().a("Failed to invoke Tag Manager's initialize() method", var24);
               }
            } catch (ClassNotFoundException var25) {
               this.t().C().a("Tag Manager is not found and thus will not be used");
            }
         }

         boolean var14 = "am".equals(var1);
         boolean var15 = zzclq.i(var2);
         if (var6 && this.b != null && !var15 && !var14) {
            this.t().D().a("Passing event to registered event handler (FE)", this.o().a(var2), this.o().a(var5));
            this.b.a(var1, var2, var5, var3);
         } else if (this.p.b()) {
            int var11 = this.p().c(var2);
            if (var11 != 0) {
               this.p();
               var1 = zzclq.a(var2, 40, true);
               int var10;
               if (var2 != null) {
                  var10 = var2.length();
               } else {
                  var10 = 0;
               }

               this.p.o().a(var9, var11, "_ev", var1, var10);
            } else {
               List var20 = Collections.singletonList("_o");
               Bundle var35 = this.p().a(var2, var5, var20, var8, true);
               ArrayList var19 = new ArrayList();
               var19.add(var35);
               long var16 = this.p().z().nextLong();
               int var31 = 0;
               String[] var27 = var35.keySet().toArray(new String[var5.size()]);
               Arrays.sort(var27);

               for (String var21 : var27) {
                  Bundle[] var22 = (Bundle[])var35.get(var21);
                  this.p();
                  var22 = zzclq.a(var22);
                  if (var22 != null) {
                     var35.putInt(var21, var22.length);

                     for (int var12 = 0; var12 < var22.length; var12++) {
                        Bundle var23 = var22[var12];
                        var23 = this.p().a("_ep", var23, var20, var8, false);
                        var23.putString("_en", var2);
                        var23.putLong("_eid", var16);
                        var23.putString("_gn", var21);
                        var23.putInt("_ll", var22.length);
                        var23.putInt("_i", var12);
                        var19.add(var23);
                     }

                     var31 += var22.length;
                  }
               }

               if (var31 != 0) {
                  var35.putLong("_eid", var16);
                  var35.putInt("_epc", var31);
               }

               zzckf var37 = this.j().y();
               if (var37 != null && !var35.containsKey("_sc")) {
                  var37.a = true;
               }

               for (int var32 = 0; var32 < var19.size(); var32++) {
                  var35 = (Bundle)var19.get(var32);
                  boolean var34;
                  if (var32 != 0) {
                     var34 = true;
                  } else {
                     var34 = false;
                  }

                  String var28;
                  if (var34) {
                     var28 = "_ep";
                  } else {
                     var28 = var2;
                  }

                  var35.putString("_o", var1);
                  if (!var35.containsKey("_sc")) {
                     zzckc.a(var37, var35);
                  }

                  if (var7) {
                     var35 = this.p().a(var35);
                  }

                  this.t().D().a("Logging event (FE)", this.o().a(var2), this.o().a(var35));
                  zzcha var29 = new zzcha(var28, new zzcgx(var35), var1, var3);
                  this.i().a(var29, var9);
                  if (!var14) {
                     Iterator var30 = this.c.iterator();

                     while (var30.hasNext()) {
                        ((AppMeasurement.OnEventListener)var30.next()).a(var1, var2, new Bundle(var35), var3);
                     }
                  }
               }

               if (this.j().y() != null && "_ae".equals(var2)) {
                  this.r().a(true);
               }
            }
         }
      }
   }

   private final void b(String var1, String var2, String var3, Bundle var4) {
      long var5 = this.k().a();
      zzbq.a(var2);
      AppMeasurement.ConditionalUserProperty var7 = new AppMeasurement.ConditionalUserProperty();
      var7.mAppId = var1;
      var7.mName = var2;
      var7.mCreationTimestamp = var5;
      if (var3 != null) {
         var7.mExpiredEventName = var3;
         var7.mExpiredEventParams = var4;
      }

      this.s().a(new zzcjq(this, var7));
   }

   private final void c(AppMeasurement.ConditionalUserProperty var1) {
      long var2 = this.k().a();
      zzbq.a(var1);
      zzbq.a(var1.mName);
      zzbq.a(var1.mOrigin);
      zzbq.a(var1.mValue);
      var1.mCreationTimestamp = var2;
      String var5 = var1.mName;
      Object var4 = var1.mValue;
      if (this.p().e(var5) != 0) {
         this.t().y().a("Invalid conditional user property name", this.o().c(var5));
      } else if (this.p().b(var5, var4) != 0) {
         this.t().y().a("Invalid conditional user property value", this.o().c(var5), var4);
      } else {
         Object var6 = this.p().c(var5, var4);
         if (var6 == null) {
            this.t().y().a("Unable to normalize conditional user property value", this.o().c(var5), var4);
         } else {
            var1.mValue = var6;
            var2 = var1.mTriggerTimeout;
            if (TextUtils.isEmpty(var1.mTriggerEventName) || var2 <= 15552000000L && var2 >= 1L) {
               var2 = var1.mTimeToLive;
               if (var2 <= 15552000000L && var2 >= 1L) {
                  this.s().a(new zzcjp(this, var1));
               } else {
                  this.t().y().a("Invalid conditional user property time to live", this.o().c(var5), var2);
               }
            } else {
               this.t().y().a("Invalid conditional user property timeout", this.o().c(var5), var2);
            }
         }
      }
   }

   private final void c(boolean var1) {
      this.c();
      this.Q();
      this.t().D().a("Setting app measurement enabled (FE)", var1);
      this.u().b(var1);
      this.i().z();
   }

   private final void d(AppMeasurement.ConditionalUserProperty var1) {
      this.c();
      this.Q();
      zzbq.a(var1);
      zzbq.a(var1.mName);
      zzbq.a(var1.mOrigin);
      zzbq.a(var1.mValue);
      if (!this.p.B()) {
         this.t().D().a("Conditional property not sent since Firebase Analytics is disabled");
      } else {
         zzcln var4 = new zzcln(var1.mName, var1.mTriggeredTimestamp, var1.mValue, var1.mOrigin);

         zzcha var2;
         zzcha var3;
         zzcha var5;
         try {
            var3 = this.p().a(var1.mTriggeredEventName, var1.mTriggeredEventParams, var1.mOrigin, 0L, true, false);
            var2 = this.p().a(var1.mTimedOutEventName, var1.mTimedOutEventParams, var1.mOrigin, 0L, true, false);
            var5 = this.p().a(var1.mExpiredEventName, var1.mExpiredEventParams, var1.mOrigin, 0L, true, false);
         } catch (IllegalArgumentException var6) {
            return;
         }

         zzcgl var7 = new zzcgl(
            var1.mAppId, var1.mOrigin, var4, var1.mCreationTimestamp, false, var1.mTriggerEventName, var2, var1.mTriggerTimeout, var3, var1.mTimeToLive, var5
         );
         this.i().a(var7);
      }
   }

   private final void e(AppMeasurement.ConditionalUserProperty var1) {
      this.c();
      this.Q();
      zzbq.a(var1);
      zzbq.a(var1.mName);
      if (!this.p.B()) {
         this.t().D().a("Conditional property not cleared since Firebase Analytics is disabled");
      } else {
         zzcln var2 = new zzcln(var1.mName, 0L, null, null);

         zzcha var3;
         try {
            var3 = this.p().a(var1.mExpiredEventName, var1.mExpiredEventParams, var1.mOrigin, var1.mCreationTimestamp, true, false);
         } catch (IllegalArgumentException var4) {
            return;
         }

         zzcgl var5 = new zzcgl(
            var1.mAppId,
            var1.mOrigin,
            var2,
            var1.mCreationTimestamp,
            var1.mActive,
            var1.mTriggerEventName,
            null,
            var1.mTriggerTimeout,
            null,
            var1.mTimeToLive,
            var3
         );
         this.i().a(var5);
      }
   }

   public final void A() {
      this.s().a(new zzcka(this));
   }

   public final List<AppMeasurement.ConditionalUserProperty> a(String var1, String var2) {
      return this.b(null, var1, var2);
   }

   public final List<AppMeasurement.ConditionalUserProperty> a(String var1, String var2, String var3) {
      zzbq.a(var1);
      this.a();
      return this.b(var1, var2, var3);
   }

   public final Map<String, Object> a(String var1, String var2, String var3, boolean var4) {
      zzbq.a(var1);
      this.a();
      return this.b(var1, var2, var3, var4);
   }

   public final Map<String, Object> a(String var1, String var2, boolean var3) {
      return this.b(null, var1, var2, var3);
   }

   public final void a(long var1) {
      this.s().a(new zzcjt(this, var1));
   }

   public final void a(AppMeasurement.ConditionalUserProperty var1) {
      zzbq.a(var1);
      var1 = new AppMeasurement.ConditionalUserProperty(var1);
      if (!TextUtils.isEmpty(var1.mAppId)) {
         this.t().A().a("Package name should be null when calling setConditionalUserProperty");
      }

      var1.mAppId = null;
      this.c(var1);
   }

   public final void a(AppMeasurement.EventInterceptor var1) {
      this.c();
      this.Q();
      if (var1 != null && var1 != this.b) {
         boolean var2;
         if (this.b == null) {
            var2 = true;
         } else {
            var2 = false;
         }

         zzbq.a(var2, "EventInterceptor already set.");
      }

      this.b = var1;
   }

   public final void a(AppMeasurement.OnEventListener var1) {
      this.Q();
      zzbq.a(var1);
      if (!this.c.add(var1)) {
         this.t().A().a("OnEventListener already registered");
      }
   }

   final void a(String var1) {
      this.e.set(var1);
   }

   public final void a(String var1, String var2, Bundle var3) {
      boolean var4;
      if (this.b != null && !zzclq.i(var2)) {
         var4 = false;
      } else {
         var4 = true;
      }

      this.a(var1, var2, var3, true, var4, false, null);
   }

   public final void a(String var1, String var2, Bundle var3, long var4) {
      this.a(var1, var2, var4, var3, false, true, true, null);
   }

   public final void a(String var1, String var2, Bundle var3, boolean var4) {
      if (this.b != null && !zzclq.i(var2)) {
         var4 = false;
      } else {
         var4 = true;
      }

      this.a(var1, var2, var3, true, var4, true, null);
   }

   public final void a(String var1, String var2, Object var3) {
      int var4 = 0;
      int var5 = 0;
      zzbq.a(var1);
      long var7 = this.k().a();
      int var6 = this.p().e(var2);
      if (var6 != 0) {
         this.p();
         var1 = zzclq.a(var2, 24, true);
         var4 = var5;
         if (var2 != null) {
            var4 = var2.length();
         }

         this.p.o().a(var6, "_ev", var1, var4);
      } else if (var3 != null) {
         var5 = this.p().b(var2, var3);
         if (var5 != 0) {
            this.p();
            var1 = zzclq.a(var2, 24, true);
            if (var3 instanceof String || var3 instanceof CharSequence) {
               var4 = String.valueOf(var3).length();
            }

            this.p.o().a(var5, "_ev", var1, var4);
         } else {
            var3 = this.p().c(var2, var3);
            if (var3 != null) {
               this.a(var1, var2, var7, var3);
            }
         }
      } else {
         this.a(var1, var2, var7, null);
      }
   }

   public final void a(String var1, String var2, String var3, Bundle var4) {
      zzbq.a(var1);
      this.a();
      this.b(var1, var2, var3, var4);
   }

   public final void a(boolean var1) {
      this.Q();
      this.s().a(new zzcjo(this, var1));
   }

   public final List<zzcln> b(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 04: aload 0
      // 05: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 08: invokevirtual com/google/android/gms/internal/zzchm.D ()Lcom/google/android/gms/internal/zzcho;
      // 0b: ldc_w "Fetching user attributes (FE)"
      // 0e: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 11: aload 0
      // 12: invokevirtual com/google/android/gms/internal/zzcjk.s ()Lcom/google/android/gms/internal/zzcih;
      // 15: invokevirtual com/google/android/gms/internal/zzcih.z ()Z
      // 18: ifeq 2e
      // 1b: aload 0
      // 1c: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 1f: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 22: ldc_w "Cannot get all user properties from analytics worker thread"
      // 25: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 28: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 2b: astore 2
      // 2c: aload 2
      // 2d: areturn
      // 2e: aload 0
      // 2f: invokevirtual com/google/android/gms/internal/zzcjk.s ()Lcom/google/android/gms/internal/zzcih;
      // 32: pop
      // 33: invokestatic com/google/android/gms/internal/zzcih.y ()Z
      // 36: ifeq 4d
      // 39: aload 0
      // 3a: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 3d: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 40: ldc_w "Cannot get all user properties from main thread"
      // 43: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 46: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 49: astore 2
      // 4a: goto 2c
      // 4d: new java/util/concurrent/atomic/AtomicReference
      // 50: dup
      // 51: invokespecial java/util/concurrent/atomic/AtomicReference.<init> ()V
      // 54: astore 2
      // 55: aload 2
      // 56: monitorenter
      // 57: aload 0
      // 58: getfield com/google/android/gms/internal/zzcjn.p Lcom/google/android/gms/internal/zzcim;
      // 5b: invokevirtual com/google/android/gms/internal/zzcim.h ()Lcom/google/android/gms/internal/zzcih;
      // 5e: astore 4
      // 60: new com/google/android/gms/internal/zzcjx
      // 63: astore 3
      // 64: aload 3
      // 65: aload 0
      // 66: aload 2
      // 67: iload 1
      // 68: invokespecial com/google/android/gms/internal/zzcjx.<init> (Lcom/google/android/gms/internal/zzcjn;Ljava/util/concurrent/atomic/AtomicReference;Z)V
      // 6b: aload 4
      // 6d: aload 3
      // 6e: invokevirtual com/google/android/gms/internal/zzcih.a (Ljava/lang/Runnable;)V
      // 71: aload 2
      // 72: ldc2_w 5000
      // 75: invokevirtual java/lang/Object.wait (J)V
      // 78: aload 2
      // 79: monitorexit
      // 7a: aload 2
      // 7b: invokevirtual java/util/concurrent/atomic/AtomicReference.get ()Ljava/lang/Object;
      // 7e: checkcast java/util/List
      // 81: astore 3
      // 82: aload 3
      // 83: astore 2
      // 84: aload 3
      // 85: ifnonnull 2c
      // 88: aload 0
      // 89: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 8c: invokevirtual com/google/android/gms/internal/zzchm.A ()Lcom/google/android/gms/internal/zzcho;
      // 8f: ldc_w "Timed out waiting for get user properties"
      // 92: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 95: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 98: astore 2
      // 99: goto 2c
      // 9c: astore 3
      // 9d: aload 0
      // 9e: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // a1: invokevirtual com/google/android/gms/internal/zzchm.A ()Lcom/google/android/gms/internal/zzcho;
      // a4: ldc_w "Interrupted waiting for get user properties"
      // a7: aload 3
      // a8: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // ab: goto 78
      // ae: astore 3
      // af: aload 2
      // b0: monitorexit
      // b1: aload 3
      // b2: athrow
      // try (39 -> 53): 82 null
      // try (53 -> 56): 74 java/lang/InterruptedException
      // try (53 -> 56): 82 null
      // try (56 -> 58): 82 null
      // try (75 -> 81): 82 null
      // try (83 -> 85): 82 null
   }

   public final void b(long var1) {
      this.s().a(new zzcju(this, var1));
   }

   public final void b(AppMeasurement.ConditionalUserProperty var1) {
      zzbq.a(var1);
      zzbq.a(var1.mAppId);
      this.a();
      this.c(new AppMeasurement.ConditionalUserProperty(var1));
   }

   public final void b(AppMeasurement.OnEventListener var1) {
      this.Q();
      zzbq.a(var1);
      if (!this.c.remove(var1)) {
         this.t().A().a("OnEventListener had not been registered");
      }
   }

   public final void b(String var1, String var2, Bundle var3) {
      this.b(null, var1, var2, var3);
   }

   final String c(long param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: new java/util/concurrent/atomic/AtomicReference
      // 03: dup
      // 04: invokespecial java/util/concurrent/atomic/AtomicReference.<init> ()V
      // 07: astore 4
      // 09: aload 4
      // 0b: monitorenter
      // 0c: aload 0
      // 0d: invokevirtual com/google/android/gms/internal/zzcjk.s ()Lcom/google/android/gms/internal/zzcih;
      // 10: astore 3
      // 11: new com/google/android/gms/internal/zzcjz
      // 14: astore 5
      // 16: aload 5
      // 18: aload 0
      // 19: aload 4
      // 1b: invokespecial com/google/android/gms/internal/zzcjz.<init> (Lcom/google/android/gms/internal/zzcjn;Ljava/util/concurrent/atomic/AtomicReference;)V
      // 1e: aload 3
      // 1f: aload 5
      // 21: invokevirtual com/google/android/gms/internal/zzcih.a (Ljava/lang/Runnable;)V
      // 24: aload 4
      // 26: lload 1
      // 27: invokevirtual java/lang/Object.wait (J)V
      // 2a: aload 4
      // 2c: monitorexit
      // 2d: aload 4
      // 2f: invokevirtual java/util/concurrent/atomic/AtomicReference.get ()Ljava/lang/Object;
      // 32: checkcast java/lang/String
      // 35: astore 3
      // 36: aload 3
      // 37: areturn
      // 38: astore 3
      // 39: aload 0
      // 3a: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 3d: invokevirtual com/google/android/gms/internal/zzchm.A ()Lcom/google/android/gms/internal/zzcho;
      // 40: ldc_w "Interrupted waiting for app instance id"
      // 43: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 46: aconst_null
      // 47: astore 3
      // 48: aload 4
      // 4a: monitorexit
      // 4b: goto 36
      // 4e: astore 3
      // 4f: aload 4
      // 51: monitorexit
      // 52: aload 3
      // 53: athrow
      // try (6 -> 18): 40 null
      // try (18 -> 21): 29 java/lang/InterruptedException
      // try (18 -> 21): 40 null
      // try (21 -> 23): 40 null
      // try (30 -> 35): 40 null
      // try (37 -> 39): 40 null
      // try (41 -> 43): 40 null
   }

   @Override
   protected final boolean w() {
      return false;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public final Task<String> y() {
      String var6;
      try {
         var6 = this.u().z();
      } catch (Exception var5) {
         this.t().A().a("Failed to schedule task for getAppInstanceId");
         return Tasks.a(var5);
      }

      Task var1;
      if (var6 != null) {
         try {
            var1 = Tasks.a(var6);
         } catch (Exception var4) {
            this.t().A().a("Failed to schedule task for getAppInstanceId");
            var1 = Tasks.a(var4);
         }
      } else {
         try {
            ExecutorService var7 = this.s().A();
            zzcjy var2 = new zzcjy(this);
            var1 = Tasks.a(var7, var2);
         } catch (Exception var3) {
            this.t().A().a("Failed to schedule task for getAppInstanceId");
            var1 = Tasks.a(var3);
         }
      }

      return var1;
   }

   public final String z() {
      return this.e.get();
   }
}
