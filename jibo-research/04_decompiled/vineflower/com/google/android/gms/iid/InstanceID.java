package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class InstanceID {
   private static Map<String, InstanceID> a = new ArrayMap<>();
   private static zzo c;
   private static zzl d;
   private static String h;
   private Context b;
   private KeyPair e;
   private String f = "";
   private long g;

   private InstanceID(Context var1, String var2, Bundle var3) {
      this.b = var1.getApplicationContext();
      this.f = var2;
   }

   static int a(Context var0) {
      byte var2 = 0;

      int var1;
      try {
         var1 = var0.getPackageManager().getPackageInfo(var0.getPackageName(), 0).versionCode;
      } catch (NameNotFoundException var3) {
         String var4 = String.valueOf(var3);
         Log.w("InstanceID", new StringBuilder(String.valueOf(var4).length() + 38).append("Never happens: can't find own package ").append(var4).toString());
         var1 = var2;
      }

      return var1;
   }

   public static InstanceID a(Context param0, Bundle param1) {
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
      // 00: ldc com/google/android/gms/iid/InstanceID
      // 02: monitorenter
      // 03: aload 1
      // 04: ifnonnull 73
      // 07: ldc ""
      // 09: astore 2
      // 0a: aload 2
      // 0b: ifnonnull 83
      // 0e: ldc ""
      // 10: astore 2
      // 11: aload 0
      // 12: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 15: astore 4
      // 17: getstatic com/google/android/gms/iid/InstanceID.c Lcom/google/android/gms/iid/zzo;
      // 1a: ifnonnull 39
      // 1d: new com/google/android/gms/iid/zzo
      // 20: astore 0
      // 21: aload 0
      // 22: aload 4
      // 24: invokespecial com/google/android/gms/iid/zzo.<init> (Landroid/content/Context;)V
      // 27: aload 0
      // 28: putstatic com/google/android/gms/iid/InstanceID.c Lcom/google/android/gms/iid/zzo;
      // 2b: new com/google/android/gms/iid/zzl
      // 2e: astore 0
      // 2f: aload 0
      // 30: aload 4
      // 32: invokespecial com/google/android/gms/iid/zzl.<init> (Landroid/content/Context;)V
      // 35: aload 0
      // 36: putstatic com/google/android/gms/iid/InstanceID.d Lcom/google/android/gms/iid/zzl;
      // 39: aload 4
      // 3b: invokestatic com/google/android/gms/iid/InstanceID.a (Landroid/content/Context;)I
      // 3e: invokestatic java/lang/Integer.toString (I)Ljava/lang/String;
      // 41: putstatic com/google/android/gms/iid/InstanceID.h Ljava/lang/String;
      // 44: getstatic com/google/android/gms/iid/InstanceID.a Ljava/util/Map;
      // 47: aload 2
      // 48: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 4d: checkcast com/google/android/gms/iid/InstanceID
      // 50: astore 3
      // 51: aload 3
      // 52: astore 0
      // 53: aload 3
      // 54: ifnonnull 6e
      // 57: new com/google/android/gms/iid/InstanceID
      // 5a: astore 0
      // 5b: aload 0
      // 5c: aload 4
      // 5e: aload 2
      // 5f: aload 1
      // 60: invokespecial com/google/android/gms/iid/InstanceID.<init> (Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V
      // 63: getstatic com/google/android/gms/iid/InstanceID.a Ljava/util/Map;
      // 66: aload 2
      // 67: aload 0
      // 68: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 6d: pop
      // 6e: ldc com/google/android/gms/iid/InstanceID
      // 70: monitorexit
      // 71: aload 0
      // 72: areturn
      // 73: aload 1
      // 74: ldc "subtype"
      // 76: invokevirtual android/os/Bundle.getString (Ljava/lang/String;)Ljava/lang/String;
      // 79: astore 2
      // 7a: goto 0a
      // 7d: astore 0
      // 7e: ldc com/google/android/gms/iid/InstanceID
      // 80: monitorexit
      // 81: aload 0
      // 82: athrow
      // 83: goto 11
      // try (10 -> 29): 63 null
      // try (29 -> 38): 63 null
      // try (42 -> 54): 63 null
      // try (58 -> 62): 63 null
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   static String a(KeyPair var0) {
      byte[] var3 = var0.getPublic().getEncoded();

      try {
         var5 = MessageDigest.getInstance("SHA1").digest(var3);
      } catch (NoSuchAlgorithmException var2) {
         Log.w("InstanceID", "Unexpected error, device missing required algorithms");
         return null;
      }

      var5[0] = (byte)((var5[0] & 15) + 112);

      try {
         var4 = Base64.encodeToString(var5, 0, 8, 11);
      } catch (NoSuchAlgorithmException var1) {
         Log.w("InstanceID", "Unexpected error, device missing required algorithms");
         var4 = null;
      }

      return var4;
   }

   static String a(byte[] var0) {
      return Base64.encodeToString(var0, 11);
   }

   static String b(Context var0) {
      try {
         var3 = var0.getPackageManager().getPackageInfo(var0.getPackageName(), 0).versionName;
      } catch (NameNotFoundException var1) {
         String var2 = String.valueOf(var1);
         Log.w("InstanceID", new StringBuilder(String.valueOf(var2).length() + 38).append("Never happens: can't find own package ").append(var2).toString());
         var3 = null;
      }

      return var3;
   }

   public static InstanceID c(Context var0) {
      return a(var0, null);
   }

   public static zzo c() {
      return c;
   }

   private final KeyPair d() {
      if (this.e == null) {
         this.e = c.d(this.f);
      }

      if (this.e == null) {
         this.g = System.currentTimeMillis();
         this.e = c.a(this.f, this.g);
      }

      return this.e;
   }

   public void a() throws IOException {
      this.a("*", "*", null);
      this.b();
   }

   public final void a(String var1, String var2, Bundle var3) throws IOException {
      if (Looper.getMainLooper() == Looper.myLooper()) {
         throw new IOException("MAIN_THREAD");
      }

      c.b(this.f, var1, var2);
      Bundle var4 = var3;
      if (var3 == null) {
         var4 = new Bundle();
      }

      var4.putString("sender", var1);
      if (var2 != null) {
         var4.putString("scope", var2);
      }

      var4.putString("subscription", var1);
      var4.putString("delete", "1");
      var4.putString("X-delete", "1");
      if ("".equals(this.f)) {
         var2 = var1;
      } else {
         var2 = this.f;
      }

      var4.putString("subtype", var2);
      if (!"".equals(this.f)) {
         var1 = this.f;
      }

      var4.putString("X-subtype", var1);
      zzl.a(d.a(var4, this.d()));
   }

   public String b(String var1, String var2, Bundle var3) throws IOException {
      boolean var5 = false;
      boolean var6 = true;
      if (Looper.getMainLooper() == Looper.myLooper()) {
         throw new IOException("MAIN_THREAD");
      }

      String var9 = c.a("appVersion");
      boolean var4;
      if (var9 != null && var9.equals(h)) {
         var9 = c.a("lastToken");
         if (var9 == null) {
            var4 = true;
         } else {
            long var7 = Long.parseLong(var9);
            if (System.currentTimeMillis() / 1000L - Long.valueOf(var7) > 604800L) {
               var4 = true;
            } else {
               var4 = false;
            }
         }
      } else {
         var4 = true;
      }

      if (var4) {
         var9 = null;
      } else {
         var9 = c.a(this.f, var1, var2);
      }

      if (var9 == null) {
         Bundle var14 = var3;
         if (var3 == null) {
            var14 = new Bundle();
         }

         var4 = var6;
         if (var14.getString("ttl") != null) {
            var4 = false;
         }

         if ("jwt".equals(var14.getString("type"))) {
            var4 = var5;
         }

         String var10 = this.c(var1, var2, var14);
         var9 = var10;
         if (var10 != null) {
            var9 = var10;
            if (var4) {
               c.a(this.f, var1, var2, var10, h);
               var9 = var10;
            }
         }
      }

      return var9;
   }

   public final void b() {
      this.g = 0L;
      c.b(String.valueOf(this.f).concat("|"));
      this.e = null;
   }

   public final String c(String var1, String var2, Bundle var3) throws IOException {
      if (var2 != null) {
         var3.putString("scope", var2);
      }

      var3.putString("sender", var1);
      if ("".equals(this.f)) {
         var2 = var1;
      } else {
         var2 = this.f;
      }

      if (!var3.containsKey("legacy.register")) {
         var3.putString("subscription", var1);
         var3.putString("subtype", var2);
         var3.putString("X-subscription", var1);
         var3.putString("X-subtype", var2);
      }

      return zzl.a(d.a(var3, this.d()));
   }
}
