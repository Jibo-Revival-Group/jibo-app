package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.common.GooglePlayServicesUtil;

public final class zzw extends zzr {
   private final Context a;

   public zzw(Context var1) {
      this.a = var1;
   }

   private final void c() {
      if (!GooglePlayServicesUtil.zzf(this.a, Binder.getCallingUid())) {
         int var1 = Binder.getCallingUid();
         throw new SecurityException(new StringBuilder(52).append("Calling UID ").append(var1).append(" is not Google Play services.").toString());
      }
   }

   @Override
   public final void a() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokespecial com/google/android/gms/auth/api/signin/internal/zzw.c ()V
      // 04: aload 0
      // 05: getfield com/google/android/gms/auth/api/signin/internal/zzw.a Landroid/content/Context;
      // 08: invokestatic com/google/android/gms/auth/api/signin/internal/zzz.a (Landroid/content/Context;)Lcom/google/android/gms/auth/api/signin/internal/zzz;
      // 0b: astore 3
      // 0c: aload 3
      // 0d: invokevirtual com/google/android/gms/auth/api/signin/internal/zzz.a ()Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;
      // 10: astore 2
      // 11: getstatic com/google/android/gms/auth/api/signin/GoogleSignInOptions.f Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;
      // 14: astore 1
      // 15: aload 2
      // 16: ifnull 1e
      // 19: aload 3
      // 1a: invokevirtual com/google/android/gms/auth/api/signin/internal/zzz.b ()Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;
      // 1d: astore 1
      // 1e: new com/google/android/gms/common/api/GoogleApiClient$Builder
      // 21: dup
      // 22: aload 0
      // 23: getfield com/google/android/gms/auth/api/signin/internal/zzw.a Landroid/content/Context;
      // 26: invokespecial com/google/android/gms/common/api/GoogleApiClient$Builder.<init> (Landroid/content/Context;)V
      // 29: getstatic com/google/android/gms/auth/api/Auth.e Lcom/google/android/gms/common/api/Api;
      // 2c: aload 1
      // 2d: invokevirtual com/google/android/gms/common/api/GoogleApiClient$Builder.a (Lcom/google/android/gms/common/api/Api;Lcom/google/android/gms/common/api/Api$ApiOptions$HasOptions;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;
      // 30: invokevirtual com/google/android/gms/common/api/GoogleApiClient$Builder.b ()Lcom/google/android/gms/common/api/GoogleApiClient;
      // 33: astore 1
      // 34: aload 1
      // 35: invokevirtual com/google/android/gms/common/api/GoogleApiClient.f ()Lcom/google/android/gms/common/ConnectionResult;
      // 38: invokevirtual com/google/android/gms/common/ConnectionResult.b ()Z
      // 3b: ifeq 4c
      // 3e: aload 2
      // 3f: ifnull 51
      // 42: getstatic com/google/android/gms/auth/api/Auth.h Lcom/google/android/gms/auth/api/signin/GoogleSignInApi;
      // 45: aload 1
      // 46: invokeinterface com/google/android/gms/auth/api/signin/GoogleSignInApi.a (Lcom/google/android/gms/common/api/GoogleApiClient;)Lcom/google/android/gms/common/api/PendingResult; 2
      // 4b: pop
      // 4c: aload 1
      // 4d: invokevirtual com/google/android/gms/common/api/GoogleApiClient.g ()V
      // 50: return
      // 51: aload 1
      // 52: invokevirtual com/google/android/gms/common/api/GoogleApiClient.i ()Lcom/google/android/gms/common/api/PendingResult;
      // 55: pop
      // 56: goto 4c
      // 59: astore 2
      // 5a: aload 1
      // 5b: invokevirtual com/google/android/gms/common/api/GoogleApiClient.g ()V
      // 5e: aload 2
      // 5f: athrow
      // try (26 -> 30): 43 null
      // try (32 -> 36): 43 null
      // try (39 -> 42): 43 null
   }

   @Override
   public final void b() {
      this.c();
      zzo.a(this.a).a();
   }
}
