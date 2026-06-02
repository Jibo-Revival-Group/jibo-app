package com.google.android.gms.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.zzck;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import java.util.HashMap;
import java.util.Map;

public final class zzcfd {
   private final zzcfu<zzcez> a;
   private final Context b;
   private ContentProviderClient c = null;
   private boolean d = false;
   private final Map<zzck<LocationListener>, zzcfi> e = new HashMap<>();
   private final Map<zzck<Object>, zzcfh> f = new HashMap<>();
   private final Map<zzck<LocationCallback>, zzcfe> g = new HashMap<>();

   public zzcfd(Context var1, zzcfu<zzcez> var2) {
      this.b = var1;
      this.a = var2;
   }

   public final Location a() throws RemoteException {
      this.a.a();
      return this.a.b().a(this.b.getPackageName());
   }

   public final void a(boolean var1) throws RemoteException {
      this.a.a();
      this.a.b().a(var1);
      this.d = var1;
   }

   public final LocationAvailability b() throws RemoteException {
      this.a.a();
      return this.a.b().b(this.b.getPackageName());
   }

   public final void c() throws RemoteException {
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
      // 000: aload 0
      // 001: getfield com/google/android/gms/internal/zzcfd.e Ljava/util/Map;
      // 004: astore 1
      // 005: aload 1
      // 006: monitorenter
      // 007: aload 0
      // 008: getfield com/google/android/gms/internal/zzcfd.e Ljava/util/Map;
      // 00b: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 010: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 015: astore 3
      // 016: aload 3
      // 017: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 01c: ifeq 04b
      // 01f: aload 3
      // 020: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 025: checkcast com/google/android/gms/internal/zzcfi
      // 028: astore 2
      // 029: aload 2
      // 02a: ifnull 016
      // 02d: aload 0
      // 02e: getfield com/google/android/gms/internal/zzcfd.a Lcom/google/android/gms/internal/zzcfu;
      // 031: invokeinterface com/google/android/gms/internal/zzcfu.b ()Landroid/os/IInterface; 1
      // 036: checkcast com/google/android/gms/internal/zzcez
      // 039: aload 2
      // 03a: aconst_null
      // 03b: invokestatic com/google/android/gms/internal/zzcfq.a (Lcom/google/android/gms/location/zzs;Lcom/google/android/gms/internal/zzceu;)Lcom/google/android/gms/internal/zzcfq;
      // 03e: invokeinterface com/google/android/gms/internal/zzcez.a (Lcom/google/android/gms/internal/zzcfq;)V 2
      // 043: goto 016
      // 046: astore 2
      // 047: aload 1
      // 048: monitorexit
      // 049: aload 2
      // 04a: athrow
      // 04b: aload 0
      // 04c: getfield com/google/android/gms/internal/zzcfd.e Ljava/util/Map;
      // 04f: invokeinterface java/util/Map.clear ()V 1
      // 054: aload 1
      // 055: monitorexit
      // 056: aload 0
      // 057: getfield com/google/android/gms/internal/zzcfd.g Ljava/util/Map;
      // 05a: astore 1
      // 05b: aload 1
      // 05c: monitorenter
      // 05d: aload 0
      // 05e: getfield com/google/android/gms/internal/zzcfd.g Ljava/util/Map;
      // 061: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 066: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 06b: astore 3
      // 06c: aload 3
      // 06d: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 072: ifeq 0a1
      // 075: aload 3
      // 076: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 07b: checkcast com/google/android/gms/internal/zzcfe
      // 07e: astore 2
      // 07f: aload 2
      // 080: ifnull 06c
      // 083: aload 0
      // 084: getfield com/google/android/gms/internal/zzcfd.a Lcom/google/android/gms/internal/zzcfu;
      // 087: invokeinterface com/google/android/gms/internal/zzcfu.b ()Landroid/os/IInterface; 1
      // 08c: checkcast com/google/android/gms/internal/zzcez
      // 08f: aload 2
      // 090: aconst_null
      // 091: invokestatic com/google/android/gms/internal/zzcfq.a (Lcom/google/android/gms/location/zzp;Lcom/google/android/gms/internal/zzceu;)Lcom/google/android/gms/internal/zzcfq;
      // 094: invokeinterface com/google/android/gms/internal/zzcez.a (Lcom/google/android/gms/internal/zzcfq;)V 2
      // 099: goto 06c
      // 09c: astore 2
      // 09d: aload 1
      // 09e: monitorexit
      // 09f: aload 2
      // 0a0: athrow
      // 0a1: aload 0
      // 0a2: getfield com/google/android/gms/internal/zzcfd.g Ljava/util/Map;
      // 0a5: invokeinterface java/util/Map.clear ()V 1
      // 0aa: aload 1
      // 0ab: monitorexit
      // 0ac: aload 0
      // 0ad: getfield com/google/android/gms/internal/zzcfd.f Ljava/util/Map;
      // 0b0: astore 1
      // 0b1: aload 1
      // 0b2: monitorenter
      // 0b3: aload 0
      // 0b4: getfield com/google/android/gms/internal/zzcfd.f Ljava/util/Map;
      // 0b7: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 0bc: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 0c1: astore 3
      // 0c2: aload 3
      // 0c3: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0c8: ifeq 10b
      // 0cb: aload 3
      // 0cc: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0d1: checkcast com/google/android/gms/internal/zzcfh
      // 0d4: astore 2
      // 0d5: aload 2
      // 0d6: ifnull 0c2
      // 0d9: aload 0
      // 0da: getfield com/google/android/gms/internal/zzcfd.a Lcom/google/android/gms/internal/zzcfu;
      // 0dd: invokeinterface com/google/android/gms/internal/zzcfu.b ()Landroid/os/IInterface; 1
      // 0e2: checkcast com/google/android/gms/internal/zzcez
      // 0e5: astore 5
      // 0e7: new com/google/android/gms/internal/zzcdz
      // 0ea: astore 4
      // 0ec: aload 4
      // 0ee: bipush 2
      // 0ef: aconst_null
      // 0f0: aload 2
      // 0f1: invokeinterface com/google/android/gms/location/zzm.asBinder ()Landroid/os/IBinder; 1
      // 0f6: aconst_null
      // 0f7: invokespecial com/google/android/gms/internal/zzcdz.<init> (ILcom/google/android/gms/internal/zzcdx;Landroid/os/IBinder;Landroid/os/IBinder;)V
      // 0fa: aload 5
      // 0fc: aload 4
      // 0fe: invokeinterface com/google/android/gms/internal/zzcez.a (Lcom/google/android/gms/internal/zzcdz;)V 2
      // 103: goto 0c2
      // 106: astore 2
      // 107: aload 1
      // 108: monitorexit
      // 109: aload 2
      // 10a: athrow
      // 10b: aload 0
      // 10c: getfield com/google/android/gms/internal/zzcfd.f Ljava/util/Map;
      // 10f: invokeinterface java/util/Map.clear ()V 1
      // 114: aload 1
      // 115: monitorexit
      // 116: return
      // try (5 -> 10): 28 null
      // try (10 -> 17): 28 null
      // try (19 -> 27): 28 null
      // try (29 -> 31): 28 null
      // try (33 -> 38): 28 null
      // try (43 -> 48): 66 null
      // try (48 -> 55): 66 null
      // try (57 -> 65): 66 null
      // try (67 -> 69): 66 null
      // try (71 -> 76): 66 null
      // try (81 -> 86): 113 null
      // try (86 -> 93): 113 null
      // try (95 -> 112): 113 null
      // try (114 -> 116): 113 null
      // try (118 -> 123): 113 null
   }

   public final void d() throws RemoteException {
      if (this.d) {
         this.a(false);
      }
   }
}
