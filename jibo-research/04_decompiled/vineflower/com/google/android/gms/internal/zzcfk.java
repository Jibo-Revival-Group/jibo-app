package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.location.LocationAvailability;

public final class zzcfk extends zzcdt {
   private final zzcfd e;

   public zzcfk(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String var5, zzr var6) {
      super(var1, var2, var3, var4, var5, var6);
      this.e = new zzcfd(var1, this.d);
   }

   public final Location e() throws RemoteException {
      return this.e.a();
   }

   @Override
   public final void f() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/google/android/gms/internal/zzcfk.e Lcom/google/android/gms/internal/zzcfd;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: invokevirtual com/google/android/gms/common/internal/zzd.g ()Z
      // 0b: istore 1
      // 0c: iload 1
      // 0d: ifeq 1e
      // 10: aload 0
      // 11: getfield com/google/android/gms/internal/zzcfk.e Lcom/google/android/gms/internal/zzcfd;
      // 14: invokevirtual com/google/android/gms/internal/zzcfd.c ()V
      // 17: aload 0
      // 18: getfield com/google/android/gms/internal/zzcfk.e Lcom/google/android/gms/internal/zzcfd;
      // 1b: invokevirtual com/google/android/gms/internal/zzcfd.d ()V
      // 1e: aload 0
      // 1f: invokespecial com/google/android/gms/internal/zzcdt.f ()V
      // 22: aload 2
      // 23: monitorexit
      // 24: return
      // 25: astore 3
      // 26: ldc "LocationClientImpl"
      // 28: ldc "Client disconnected before listeners could be cleaned up"
      // 2a: aload 3
      // 2b: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 2e: pop
      // 2f: goto 1e
      // 32: astore 3
      // 33: aload 2
      // 34: monitorexit
      // 35: aload 3
      // 36: athrow
      // try (5 -> 8): 28 null
      // try (10 -> 16): 21 java/lang/Exception
      // try (10 -> 16): 28 null
      // try (16 -> 20): 28 null
      // try (22 -> 27): 28 null
      // try (29 -> 31): 28 null
   }

   public final LocationAvailability x() throws RemoteException {
      return this.e.b();
   }
}
