package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.zzv;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public final class zzo {
   private SharedPreferences a;
   private Context b;

   public zzo(Context var1) {
      this(var1, "com.google.android.gms.appid");
   }

   private zzo(Context var1, String var2) {
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

      File var6 = new File(zzv.a(this.b), var5);
      if (!var6.exists()) {
         try {
            if (var6.createNewFile() && !this.a()) {
               Log.i("InstanceID/Store", "App restored, clearing state");
               InstanceIDListenerService.a(this.b, this);
            }
         } catch (IOException var3) {
            if (Log.isLoggable("InstanceID/Store", 3)) {
               String var7 = String.valueOf(var3.getMessage());
               String var8;
               if (var7.length() != 0) {
                  var8 = "Error creating file in no backup dir: ".concat(var7);
               } else {
                  var8 = new String("Error creating file in no backup dir: ");
               }

               Log.d("InstanceID/Store", var8);
            }
         }
      }
   }

   private final void a(Editor var1, String var2, String var3, String var4) {
      synchronized (this) {
         int var6 = String.valueOf(var2).length();
         int var7 = String.valueOf("|S|").length();
         int var5 = String.valueOf(var3).length();
         StringBuilder var8 = new StringBuilder(var6 + var7 + var5);
         var1.putString(var8.append(var2).append("|S|").append(var3).toString(), var4);
      }
   }

   private static String c(String var0, String var1, String var2) {
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

   final String a(String var1) {
      synchronized (this) {
         return this.a.getString(var1, null);
      }
   }

   final String a(String var1, String var2) {
      synchronized (this) {
         SharedPreferences var7 = this.a;
         int var5 = String.valueOf(var1).length();
         int var3 = String.valueOf("|S|").length();
         int var4 = String.valueOf(var2).length();
         StringBuilder var6 = new StringBuilder(var5 + var3 + var4);
         return var7.getString(var6.append(var1).append("|S|").append(var2).toString(), null);
      }
   }

   public final String a(String var1, String var2, String var3) {
      synchronized (this) {
         var1 = c(var1, var2, var3);
         return this.a.getString(var1, null);
      }
   }

   final KeyPair a(String var1, long var2) {
      KeyPair var4;
      synchronized (this) {
         var4 = zza.a();
         Editor var5 = this.a.edit();
         this.a(var5, var1, "|P|", InstanceID.a(var4.getPublic().getEncoded()));
         this.a(var5, var1, "|K|", InstanceID.a(var4.getPrivate().getEncoded()));
         this.a(var5, var1, "cre", Long.toString(var2));
         var5.commit();
      }

      return var4;
   }

   public final void a(String var1, String var2, String var3, String var4, String var5) {
      synchronized (this) {
         var2 = c(var1, var2, var3);
         Editor var8 = this.a.edit();
         var8.putString(var2, var4);
         var8.putString("appVersion", var5);
         var8.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000L));
         var8.commit();
      }
   }

   public final boolean a() {
      return this.a.getAll().isEmpty();
   }

   public final void b() {
      synchronized (this) {
         this.a.edit().clear().commit();
      }
   }

   public final void b(String param1) {
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
      // 03: getfield com/google/android/gms/iid/zzo.a Landroid/content/SharedPreferences;
      // 06: invokeinterface android/content/SharedPreferences.edit ()Landroid/content/SharedPreferences$Editor; 1
      // 0b: astore 2
      // 0c: aload 0
      // 0d: getfield com/google/android/gms/iid/zzo.a Landroid/content/SharedPreferences;
      // 10: invokeinterface android/content/SharedPreferences.getAll ()Ljava/util/Map; 1
      // 15: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
      // 1a: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 1f: astore 4
      // 21: aload 4
      // 23: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 28: ifeq 4e
      // 2b: aload 4
      // 2d: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 32: checkcast java/lang/String
      // 35: astore 3
      // 36: aload 3
      // 37: aload 1
      // 38: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 3b: ifeq 21
      // 3e: aload 2
      // 3f: aload 3
      // 40: invokeinterface android/content/SharedPreferences$Editor.remove (Ljava/lang/String;)Landroid/content/SharedPreferences$Editor; 2
      // 45: pop
      // 46: goto 21
      // 49: astore 1
      // 4a: aload 0
      // 4b: monitorexit
      // 4c: aload 1
      // 4d: athrow
      // 4e: aload 2
      // 4f: invokeinterface android/content/SharedPreferences$Editor.commit ()Z 1
      // 54: pop
      // 55: aload 0
      // 56: monitorexit
      // 57: return
      // try (2 -> 12): 28 null
      // try (12 -> 27): 28 null
      // try (33 -> 36): 28 null
   }

   public final void b(String var1, String var2, String var3) {
      synchronized (this) {
         var1 = c(var1, var2, var3);
         Editor var7 = this.a.edit();
         var7.remove(var1);
         var7.commit();
      }
   }

   public final void c(String var1) {
      this.b(String.valueOf(var1).concat("|T|"));
   }

   final KeyPair d(String var1) {
      String var2 = this.a(var1, "|P|");
      var1 = this.a(var1, "|K|");
      Object var8;
      if (var2 != null && var1 != null) {
         try {
            byte[] var12 = Base64.decode(var2, 8);
            byte[] var11 = Base64.decode(var1, 8);
            KeyFactory var3 = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec var4 = new X509EncodedKeySpec(var12);
            PublicKey var13 = var3.generatePublic(var4);
            PKCS8EncodedKeySpec var15 = new PKCS8EncodedKeySpec(var11);
            PrivateKey var14 = var3.generatePrivate(var15);
            KeyPair var16 = new KeyPair(var13, var14);
            return var16;
         } catch (InvalidKeySpecException var5) {
            var9 = var5;
         } catch (NoSuchAlgorithmException var6) {
            var9 = var6;
         }

         String var10 = String.valueOf(var9);
         Log.w("InstanceID/Store", new StringBuilder(String.valueOf(var10).length() + 19).append("Invalid key stored ").append(var10).toString());
         InstanceIDListenerService.a(this.b, this);
         var8 = null;
      } else {
         var8 = null;
      }

      return (KeyPair)var8;
   }
}
