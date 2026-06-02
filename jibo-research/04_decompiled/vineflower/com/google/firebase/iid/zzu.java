package com.google.firebase.iid;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class zzu {
   private final Context a;
   private String b;
   private String c;
   private int d;
   private int e = 0;

   public zzu(Context var1) {
      this.a = var1;
   }

   private final PackageInfo a(String var1) {
      try {
         var4 = this.a.getPackageManager().getPackageInfo(var1, 0);
      } catch (NameNotFoundException var2) {
         var1 = String.valueOf(var2);
         Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(var1).length() + 23).append("Failed to find package ").append(var1).toString());
         var4 = null;
      }

      return var4;
   }

   public static String a(FirebaseApp var0) {
      String var1 = var0.c().b();
      String var2;
      if (var1 != null) {
         var2 = var1;
      } else {
         var1 = var0.c().a();
         var2 = var1;
         if (var1.startsWith("1:")) {
            String[] var3 = var1.split(":");
            if (var3.length < 2) {
               var2 = null;
            } else {
               var1 = var3[1];
               var2 = var1;
               if (var1.isEmpty()) {
                  var2 = null;
               }
            }
         }
      }

      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static String a(KeyPair var0) {
      byte[] var3 = var0.getPublic().getEncoded();

      try {
         var5 = MessageDigest.getInstance("SHA1").digest(var3);
      } catch (NoSuchAlgorithmException var2) {
         Log.w("FirebaseInstanceId", "Unexpected error, device missing required algorithms");
         return null;
      }

      var5[0] = (byte)((var5[0] & 15) + 112);

      try {
         var4 = Base64.encodeToString(var5, 0, 8, 11);
      } catch (NoSuchAlgorithmException var1) {
         Log.w("FirebaseInstanceId", "Unexpected error, device missing required algorithms");
         var4 = null;
      }

      return var4;
   }

   private final void e() {
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
      // 01: monitorenter
      // 02: aload 0
      // 03: aload 0
      // 04: getfield com/google/firebase/iid/zzu.a Landroid/content/Context;
      // 07: invokevirtual android/content/Context.getPackageName ()Ljava/lang/String;
      // 0a: invokespecial com/google/firebase/iid/zzu.a (Ljava/lang/String;)Landroid/content/pm/PackageInfo;
      // 0d: astore 1
      // 0e: aload 1
      // 0f: ifnull 25
      // 12: aload 0
      // 13: aload 1
      // 14: getfield android/content/pm/PackageInfo.versionCode I
      // 17: invokestatic java/lang/Integer.toString (I)Ljava/lang/String;
      // 1a: putfield com/google/firebase/iid/zzu.b Ljava/lang/String;
      // 1d: aload 0
      // 1e: aload 1
      // 1f: getfield android/content/pm/PackageInfo.versionName Ljava/lang/String;
      // 22: putfield com/google/firebase/iid/zzu.c Ljava/lang/String;
      // 25: aload 0
      // 26: monitorexit
      // 27: return
      // 28: astore 1
      // 29: aload 0
      // 2a: monitorexit
      // 2b: aload 1
      // 2c: athrow
      // try (2 -> 8): 22 null
      // try (10 -> 19): 22 null
   }

   public final int a() {
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
      // 00: bipush 0
      // 01: istore 1
      // 02: aload 0
      // 03: monitorenter
      // 04: aload 0
      // 05: getfield com/google/firebase/iid/zzu.e I
      // 08: ifeq 14
      // 0b: aload 0
      // 0c: getfield com/google/firebase/iid/zzu.e I
      // 0f: istore 1
      // 10: aload 0
      // 11: monitorexit
      // 12: iload 1
      // 13: ireturn
      // 14: aload 0
      // 15: getfield com/google/firebase/iid/zzu.a Landroid/content/Context;
      // 18: invokevirtual android/content/Context.getPackageManager ()Landroid/content/pm/PackageManager;
      // 1b: astore 2
      // 1c: aload 2
      // 1d: ldc "com.google.android.c2dm.permission.SEND"
      // 1f: ldc "com.google.android.gms"
      // 21: invokevirtual android/content/pm/PackageManager.checkPermission (Ljava/lang/String;Ljava/lang/String;)I
      // 24: bipush -1
      // 25: if_icmpne 38
      // 28: ldc "FirebaseInstanceId"
      // 2a: ldc "Google Play services missing or without correct permission."
      // 2c: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 2f: pop
      // 30: goto 10
      // 33: astore 2
      // 34: aload 0
      // 35: monitorexit
      // 36: aload 2
      // 37: athrow
      // 38: invokestatic com/google/android/gms/common/util/zzq.h ()Z
      // 3b: ifne 70
      // 3e: new android/content/Intent
      // 41: astore 3
      // 42: aload 3
      // 43: ldc "com.google.android.c2dm.intent.REGISTER"
      // 45: invokespecial android/content/Intent.<init> (Ljava/lang/String;)V
      // 48: aload 3
      // 49: ldc "com.google.android.gms"
      // 4b: invokevirtual android/content/Intent.setPackage (Ljava/lang/String;)Landroid/content/Intent;
      // 4e: pop
      // 4f: aload 2
      // 50: aload 3
      // 51: bipush 0
      // 52: invokevirtual android/content/pm/PackageManager.queryIntentServices (Landroid/content/Intent;I)Ljava/util/List;
      // 55: astore 3
      // 56: aload 3
      // 57: ifnull 70
      // 5a: aload 3
      // 5b: invokeinterface java/util/List.size ()I 1
      // 60: ifle 70
      // 63: aload 0
      // 64: bipush 1
      // 65: putfield com/google/firebase/iid/zzu.e I
      // 68: aload 0
      // 69: getfield com/google/firebase/iid/zzu.e I
      // 6c: istore 1
      // 6d: goto 10
      // 70: new android/content/Intent
      // 73: astore 3
      // 74: aload 3
      // 75: ldc "com.google.iid.TOKEN_REQUEST"
      // 77: invokespecial android/content/Intent.<init> (Ljava/lang/String;)V
      // 7a: aload 3
      // 7b: ldc "com.google.android.gms"
      // 7d: invokevirtual android/content/Intent.setPackage (Ljava/lang/String;)Landroid/content/Intent;
      // 80: pop
      // 81: aload 2
      // 82: aload 3
      // 83: bipush 0
      // 84: invokevirtual android/content/pm/PackageManager.queryBroadcastReceivers (Landroid/content/Intent;I)Ljava/util/List;
      // 87: astore 2
      // 88: aload 2
      // 89: ifnull a2
      // 8c: aload 2
      // 8d: invokeinterface java/util/List.size ()I 1
      // 92: ifle a2
      // 95: aload 0
      // 96: bipush 2
      // 97: putfield com/google/firebase/iid/zzu.e I
      // 9a: aload 0
      // 9b: getfield com/google/firebase/iid/zzu.e I
      // 9e: istore 1
      // 9f: goto 10
      // a2: ldc "FirebaseInstanceId"
      // a4: ldc "Failed to resolve IID implementation package, falling back"
      // a6: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // a9: pop
      // aa: invokestatic com/google/android/gms/common/util/zzq.h ()Z
      // ad: ifeq bd
      // b0: aload 0
      // b1: bipush 2
      // b2: putfield com/google/firebase/iid/zzu.e I
      // b5: aload 0
      // b6: getfield com/google/firebase/iid/zzu.e I
      // b9: istore 1
      // ba: goto 10
      // bd: aload 0
      // be: bipush 1
      // bf: putfield com/google/firebase/iid/zzu.e I
      // c2: goto b5
      // try (4 -> 10): 29 null
      // try (14 -> 28): 29 null
      // try (34 -> 50): 29 null
      // try (52 -> 61): 29 null
      // try (62 -> 76): 29 null
      // try (78 -> 87): 29 null
      // try (88 -> 97): 29 null
      // try (97 -> 100): 29 null
      // try (101 -> 104): 29 null
   }

   public final String b() {
      synchronized (this) {
         if (this.b == null) {
            this.e();
         }

         return this.b;
      }
   }

   public final String c() {
      synchronized (this) {
         if (this.c == null) {
            this.e();
         }

         return this.c;
      }
   }

   public final int d() {
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
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/google/firebase/iid/zzu.d I
      // 06: ifne 1c
      // 09: aload 0
      // 0a: ldc "com.google.android.gms"
      // 0c: invokespecial com/google/firebase/iid/zzu.a (Ljava/lang/String;)Landroid/content/pm/PackageInfo;
      // 0f: astore 2
      // 10: aload 2
      // 11: ifnull 1c
      // 14: aload 0
      // 15: aload 2
      // 16: getfield android/content/pm/PackageInfo.versionCode I
      // 19: putfield com/google/firebase/iid/zzu.d I
      // 1c: aload 0
      // 1d: getfield com/google/firebase/iid/zzu.d I
      // 20: istore 1
      // 21: aload 0
      // 22: monitorexit
      // 23: iload 1
      // 24: ireturn
      // 25: astore 2
      // 26: aload 0
      // 27: monitorexit
      // 28: aload 2
      // 29: athrow
      // try (2 -> 9): 22 null
      // try (11 -> 15): 22 null
      // try (15 -> 18): 22 null
   }
}
