package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.security.KeyPair;

final class zzy {
   private SharedPreferences a;
   private Context b;

   public zzy(Context var1) {
      this(var1, "com.google.android.gms.appid");
   }

   private zzy(Context var1, String var2) {
      this.b = var1;
      this.a = var1.getSharedPreferences(var2, 0);
      var2 = String.valueOf(var2);
      String var4 = String.valueOf("-no-backup");
      String var5;
      if (var4.length() != 0) {
         var5 = var2.concat(var4);
      } else {
         var5 = new String(var2);
      }

      File var6 = new File(com.google.android.gms.common.util.zzv.a(this.b), var5);
      if (!var6.exists()) {
         try {
            if (var6.createNewFile() && !this.c()) {
               Log.i("FirebaseInstanceId", "App restored, clearing state");
               this.b();
               FirebaseInstanceId.a().i();
            }
         } catch (IOException var3) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
               String var7 = String.valueOf(var3.getMessage());
               String var8;
               if (var7.length() != 0) {
                  var8 = "Error creating file in no backup dir: ".concat(var7);
               } else {
                  var8 = new String("Error creating file in no backup dir: ");
               }

               Log.d("FirebaseInstanceId", var8);
            }
         }
      }
   }

   private static String a(String var0, String var1) {
      return new StringBuilder(String.valueOf(var0).length() + String.valueOf("|S|").length() + String.valueOf(var1).length())
         .append(var0)
         .append("|S|")
         .append(var1)
         .toString();
   }

   private static String b(String var0, String var1, String var2) {
      return new StringBuilder(
            String.valueOf(var0).length() + 1 + String.valueOf("|T|").length() + String.valueOf(var1).length() + String.valueOf(var2).length()
         )
         .append(var0)
         .append("|T|")
         .append(var1)
         .append("|")
         .append(var2)
         .toString();
   }

   private final boolean c() {
      synchronized (this) {
         return this.a.getAll().isEmpty();
      }
   }

   private final void f(String var1) {
      Editor var3 = this.a.edit();

      for (String var2 : this.a.getAll().keySet()) {
         if (var2.startsWith(var1)) {
            var3.remove(var2);
         }
      }

      var3.commit();
   }

   public final zzz a(String var1, String var2, String var3) {
      synchronized (this) {
         return zzz.a(this.a.getString(b(var1, var2, var3), null));
      }
   }

   public final String a() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 2
      // 02: aload 0
      // 03: monitorenter
      // 04: aload 0
      // 05: getfield com/google/firebase/iid/zzy.a Landroid/content/SharedPreferences;
      // 08: ldc "topic_operaion_queue"
      // 0a: aconst_null
      // 0b: invokeinterface android/content/SharedPreferences.getString (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 3
      // 10: astore 3
      // 11: aload 2
      // 12: astore 1
      // 13: aload 3
      // 14: ifnull 35
      // 17: aload 3
      // 18: ldc ","
      // 1a: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 1d: astore 3
      // 1e: aload 2
      // 1f: astore 1
      // 20: aload 3
      // 21: arraylength
      // 22: bipush 1
      // 23: if_icmple 35
      // 26: aload 2
      // 27: astore 1
      // 28: aload 3
      // 29: bipush 1
      // 2a: aaload
      // 2b: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 2e: ifne 35
      // 31: aload 3
      // 32: bipush 1
      // 33: aaload
      // 34: astore 1
      // 35: aload 0
      // 36: monitorexit
      // 37: aload 1
      // 38: areturn
      // 39: astore 1
      // 3a: aload 0
      // 3b: monitorexit
      // 3c: aload 1
      // 3d: athrow
      // try (4 -> 10): 39 null
      // try (14 -> 18): 39 null
      // try (20 -> 24): 39 null
      // try (26 -> 31): 39 null
   }

   public final void a(String param1, String param2, String param3, String param4, String param5) {
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
      // 02: aload 4
      // 04: aload 5
      // 06: invokestatic java/lang/System.currentTimeMillis ()J
      // 09: invokestatic com/google/firebase/iid/zzz.a (Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
      // 0c: astore 4
      // 0e: aload 4
      // 10: ifnonnull 16
      // 13: aload 0
      // 14: monitorexit
      // 15: return
      // 16: aload 0
      // 17: getfield com/google/firebase/iid/zzy.a Landroid/content/SharedPreferences;
      // 1a: invokeinterface android/content/SharedPreferences.edit ()Landroid/content/SharedPreferences$Editor; 1
      // 1f: astore 5
      // 21: aload 5
      // 23: aload 1
      // 24: aload 2
      // 25: aload 3
      // 26: invokestatic com/google/firebase/iid/zzy.b (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 29: aload 4
      // 2b: invokeinterface android/content/SharedPreferences$Editor.putString (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor; 3
      // 30: pop
      // 31: aload 5
      // 33: invokeinterface android/content/SharedPreferences$Editor.commit ()Z 1
      // 38: pop
      // 39: goto 13
      // 3c: astore 1
      // 3d: aload 0
      // 3e: monitorexit
      // 3f: aload 1
      // 40: athrow
      // try (2 -> 7): 28 null
      // try (12 -> 27): 28 null
   }

   public final boolean a(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/google/firebase/iid/zzy.a Landroid/content/SharedPreferences;
      // 06: ldc "topic_operaion_queue"
      // 08: ldc ""
      // 0a: invokeinterface android/content/SharedPreferences.getString (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 3
      // 0f: astore 4
      // 11: ldc ","
      // 13: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 16: astore 5
      // 18: aload 1
      // 19: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 1c: astore 3
      // 1d: aload 3
      // 1e: invokevirtual java/lang/String.length ()I
      // 21: ifeq 72
      // 24: aload 5
      // 26: aload 3
      // 27: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 2a: astore 3
      // 2b: aload 4
      // 2d: aload 3
      // 2e: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 31: ifeq 90
      // 34: ldc ","
      // 36: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 39: astore 3
      // 3a: aload 1
      // 3b: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 3e: astore 1
      // 3f: aload 1
      // 40: invokevirtual java/lang/String.length ()I
      // 43: ifeq 84
      // 46: aload 3
      // 47: aload 1
      // 48: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 4b: astore 1
      // 4c: aload 4
      // 4e: aload 1
      // 4f: invokevirtual java/lang/String.length ()I
      // 52: invokevirtual java/lang/String.substring (I)Ljava/lang/String;
      // 55: astore 1
      // 56: aload 0
      // 57: getfield com/google/firebase/iid/zzy.a Landroid/content/SharedPreferences;
      // 5a: invokeinterface android/content/SharedPreferences.edit ()Landroid/content/SharedPreferences$Editor; 1
      // 5f: ldc "topic_operaion_queue"
      // 61: aload 1
      // 62: invokeinterface android/content/SharedPreferences$Editor.putString (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor; 3
      // 67: invokeinterface android/content/SharedPreferences$Editor.apply ()V 1
      // 6c: bipush 1
      // 6d: istore 2
      // 6e: aload 0
      // 6f: monitorexit
      // 70: iload 2
      // 71: ireturn
      // 72: new java/lang/String
      // 75: dup
      // 76: aload 5
      // 78: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // 7b: astore 3
      // 7c: goto 2b
      // 7f: astore 1
      // 80: aload 0
      // 81: monitorexit
      // 82: aload 1
      // 83: athrow
      // 84: new java/lang/String
      // 87: dup
      // 88: aload 3
      // 89: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // 8c: astore 1
      // 8d: goto 4c
      // 90: bipush 0
      // 91: istore 2
      // 92: goto 6e
      // try (2 -> 21): 62 null
      // try (21 -> 38): 62 null
      // try (38 -> 50): 62 null
      // try (56 -> 61): 62 null
      // try (67 -> 72): 62 null
   }

   final KeyPair b(String var1) {
      KeyPair var5;
      synchronized (this) {
         var5 = zza.a();
         long var2 = System.currentTimeMillis();
         Editor var4 = this.a.edit();
         var4.putString(a(var1, "|P|"), Base64.encodeToString(var5.getPublic().getEncoded(), 11));
         var4.putString(a(var1, "|K|"), Base64.encodeToString(var5.getPrivate().getEncoded(), 11));
         var4.putString(a(var1, "cre"), Long.toString(var2));
         var4.commit();
      }

      return var5;
   }

   public final void b() {
      synchronized (this) {
         this.a.edit().clear().commit();
      }
   }

   final void c(String var1) {
      synchronized (this) {
         this.f(String.valueOf(var1).concat("|"));
      }
   }

   public final void d(String var1) {
      synchronized (this) {
         this.f(String.valueOf(var1).concat("|T|"));
      }
   }

   public final KeyPair e(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/google/firebase/iid/zzy.a Landroid/content/SharedPreferences;
      // 06: aload 1
      // 07: ldc "|P|"
      // 09: invokestatic com/google/firebase/iid/zzy.a (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 0c: aconst_null
      // 0d: invokeinterface android/content/SharedPreferences.getString (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 3
      // 12: astore 3
      // 13: aload 0
      // 14: getfield com/google/firebase/iid/zzy.a Landroid/content/SharedPreferences;
      // 17: aload 1
      // 18: ldc "|K|"
      // 1a: invokestatic com/google/firebase/iid/zzy.a (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 1d: aconst_null
      // 1e: invokeinterface android/content/SharedPreferences.getString (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 3
      // 23: astore 1
      // 24: aload 3
      // 25: ifnull 2c
      // 28: aload 1
      // 29: ifnonnull 32
      // 2c: aconst_null
      // 2d: astore 1
      // 2e: aload 0
      // 2f: monitorexit
      // 30: aload 1
      // 31: areturn
      // 32: aload 3
      // 33: bipush 8
      // 35: invokestatic android/util/Base64.decode (Ljava/lang/String;I)[B
      // 38: astore 3
      // 39: aload 1
      // 3a: bipush 8
      // 3c: invokestatic android/util/Base64.decode (Ljava/lang/String;I)[B
      // 3f: astore 4
      // 41: ldc_w "RSA"
      // 44: invokestatic java/security/KeyFactory.getInstance (Ljava/lang/String;)Ljava/security/KeyFactory;
      // 47: astore 1
      // 48: new java/security/spec/X509EncodedKeySpec
      // 4b: astore 5
      // 4d: aload 5
      // 4f: aload 3
      // 50: invokespecial java/security/spec/X509EncodedKeySpec.<init> ([B)V
      // 53: aload 1
      // 54: aload 5
      // 56: invokevirtual java/security/KeyFactory.generatePublic (Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
      // 59: astore 3
      // 5a: new java/security/spec/PKCS8EncodedKeySpec
      // 5d: astore 5
      // 5f: aload 5
      // 61: aload 4
      // 63: invokespecial java/security/spec/PKCS8EncodedKeySpec.<init> ([B)V
      // 66: aload 1
      // 67: aload 5
      // 69: invokevirtual java/security/KeyFactory.generatePrivate (Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;
      // 6c: astore 4
      // 6e: new java/security/KeyPair
      // 71: astore 1
      // 72: aload 1
      // 73: aload 3
      // 74: aload 4
      // 76: invokespecial java/security/KeyPair.<init> (Ljava/security/PublicKey;Ljava/security/PrivateKey;)V
      // 79: goto 2e
      // 7c: astore 1
      // 7d: aload 1
      // 7e: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 81: astore 3
      // 82: aload 3
      // 83: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 86: invokevirtual java/lang/String.length ()I
      // 89: istore 2
      // 8a: new java/lang/StringBuilder
      // 8d: astore 1
      // 8e: aload 1
      // 8f: iload 2
      // 90: bipush 19
      // 92: iadd
      // 93: invokespecial java/lang/StringBuilder.<init> (I)V
      // 96: ldc "FirebaseInstanceId"
      // 98: aload 1
      // 99: ldc_w "Invalid key stored "
      // 9c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 9f: aload 3
      // a0: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // a3: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // a6: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // a9: pop
      // aa: invokestatic com/google/firebase/iid/FirebaseInstanceId.a ()Lcom/google/firebase/iid/FirebaseInstanceId;
      // ad: invokevirtual com/google/firebase/iid/FirebaseInstanceId.i ()V
      // b0: aconst_null
      // b1: astore 1
      // b2: goto 2e
      // b5: astore 1
      // b6: aload 0
      // b7: monitorexit
      // b8: aload 1
      // b9: athrow
      // ba: astore 1
      // bb: goto 7d
      // try (2 -> 18): 93 null
      // try (28 -> 63): 64 java/security/spec/InvalidKeySpecException
      // try (28 -> 63): 98 java/security/NoSuchAlgorithmException
      // try (28 -> 63): 93 null
      // try (65 -> 90): 93 null
   }
}
