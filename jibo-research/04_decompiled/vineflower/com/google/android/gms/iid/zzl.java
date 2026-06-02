package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.zzq;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public final class zzl {
   private static String a = null;
   private static boolean b = false;
   private static int c = 0;
   private static int d = 0;
   private static int e = 0;
   private static BroadcastReceiver f = null;
   private Context g;
   private Map<String, Object> h = new HashMap<>();
   private Messenger i;
   private Messenger j;
   private MessengerCompat k;
   private PendingIntent l;
   private long m;
   private long n;
   private int o;
   private int p;
   private long q;

   public zzl(Context var1) {
      this.g = var1;
   }

   public static String a(Context var0) {
      String var3;
      if (a != null) {
         var3 = a;
      } else {
         c = Process.myUid();
         PackageManager var4 = var0.getPackageManager();
         if (!zzq.h()) {
            Iterator var2 = var4.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0).iterator();

            boolean var1;
            while (true) {
               if (!var2.hasNext()) {
                  var1 = false;
                  break;
               }

               if (a(var4, ((ResolveInfo)var2.next()).serviceInfo.packageName, "com.google.android.c2dm.intent.REGISTER")) {
                  b = false;
                  var1 = true;
                  break;
               }
            }

            if (var1) {
               String var5 = a;
               return var5;
            }
         }

         if (a(var4)) {
            var3 = a;
         } else {
            Log.w("InstanceID/Rpc", "Failed to resolve IID implementation package, falling back");
            if (a(var4, "com.google.android.gms")) {
               b = zzq.h();
               var3 = a;
            } else if (!zzq.f() && a(var4, "com.google.android.gsf")) {
               b = false;
               var3 = a;
            } else {
               Log.w("InstanceID/Rpc", "Google Play services is missing, unable to get tokens");
               var3 = null;
            }
         }
      }

      return var3;
   }

   static String a(Intent var0) throws IOException {
      if (var0 == null) {
         throw new IOException("SERVICE_NOT_AVAILABLE");
      }

      String var2 = var0.getStringExtra("registration_id");
      String var1 = var2;
      if (var2 == null) {
         var1 = var0.getStringExtra("unregistered");
      }

      var0.getLongExtra("Retry-After", 0L);
      if (var1 == null) {
         var1 = var0.getStringExtra("error");
         if (var1 != null) {
            throw new IOException(var1);
         }

         String var3 = String.valueOf(var0.getExtras());
         Log.w(
            "InstanceID/Rpc",
            new StringBuilder(String.valueOf(var3).length() + 29).append("Unexpected response from GCM ").append(var3).toString(),
            new Throwable()
         );
         throw new IOException("SERVICE_NOT_AVAILABLE");
      } else {
         return var1;
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static String a(KeyPair var0, String... var1) {
      Object var2 = null;

      try {
         var10 = TextUtils.join("\n", var1).getBytes("UTF-8");
      } catch (UnsupportedEncodingException var6) {
         Log.e("InstanceID/Rpc", "Unable to encode string", var6);
         return (String)var2;
      }

      PrivateKey var3;
      label25: {
         label24: {
            try {
               var3 = var0.getPrivate();
               if (var3 instanceof RSAPrivateKey) {
                  break label24;
               }
            } catch (GeneralSecurityException var5) {
               Log.e("InstanceID/Rpc", "Unable to sign registration request", var5);
               return (String)var2;
            }

            var8 = "SHA256withECDSA";
            break label25;
         }

         var8 = "SHA256withRSA";
      }

      try {
         Signature var9 = Signature.getInstance(var8);
         var9.initSign(var3);
         var9.update(var10);
         var7 = InstanceID.a(var9.sign());
      } catch (GeneralSecurityException var4) {
         Log.e("InstanceID/Rpc", "Unable to sign registration request", var4);
         var7 = (String)var2;
      }

      return var7;
   }

   private final void a() {
      if (this.i == null) {
         a(this.g);
         this.i = new Messenger(new zzm(this, Looper.getMainLooper()));
      }
   }

   private final void a(Object param1) {
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
      // 01: invokevirtual java/lang/Object.getClass ()Ljava/lang/Class;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/iid/zzl.h Ljava/util/Map;
      // 0b: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
      // 10: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 15: astore 5
      // 17: aload 5
      // 19: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1e: ifeq 53
      // 21: aload 5
      // 23: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 28: checkcast java/lang/String
      // 2b: astore 4
      // 2d: aload 0
      // 2e: getfield com/google/android/gms/iid/zzl.h Ljava/util/Map;
      // 31: aload 4
      // 33: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 38: astore 3
      // 39: aload 0
      // 3a: getfield com/google/android/gms/iid/zzl.h Ljava/util/Map;
      // 3d: aload 4
      // 3f: aload 1
      // 40: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 45: pop
      // 46: aload 3
      // 47: aload 1
      // 48: invokestatic com/google/android/gms/iid/zzl.a (Ljava/lang/Object;Ljava/lang/Object;)V
      // 4b: goto 17
      // 4e: astore 1
      // 4f: aload 2
      // 50: monitorexit
      // 51: aload 1
      // 52: athrow
      // 53: aload 2
      // 54: monitorexit
      // 55: return
      // try (5 -> 10): 32 null
      // try (10 -> 31): 32 null
      // try (33 -> 35): 32 null
      // try (37 -> 39): 32 null
   }

   private static void a(Object var0, Object var1) {
      if (var0 instanceof ConditionVariable) {
         ((ConditionVariable)var0).open();
      }

      if (var0 instanceof Messenger) {
         Messenger var4 = (Messenger)var0;
         Message var2 = Message.obtain();
         var2.obj = var1;

         try {
            var4.send(var2);
         } catch (RemoteException var3) {
            String var5 = String.valueOf(var3);
            Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(var5).length() + 24).append("Failed to send response ").append(var5).toString());
         }
      }
   }

   private final void a(String param1, Object param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual java/lang/Object.getClass ()Ljava/lang/Class;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/iid/zzl.h Ljava/util/Map;
      // 0b: aload 1
      // 0c: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 11: astore 4
      // 13: aload 0
      // 14: getfield com/google/android/gms/iid/zzl.h Ljava/util/Map;
      // 17: aload 1
      // 18: aload 2
      // 19: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 1e: pop
      // 1f: aload 4
      // 21: aload 2
      // 22: invokestatic com/google/android/gms/iid/zzl.a (Ljava/lang/Object;Ljava/lang/Object;)V
      // 25: aload 3
      // 26: monitorexit
      // 27: return
      // 28: astore 1
      // 29: aload 3
      // 2a: monitorexit
      // 2b: aload 1
      // 2c: athrow
      // try (5 -> 21): 22 null
      // try (23 -> 25): 22 null
   }

   private static boolean a(PackageManager var0) {
      Iterator var2 = var0.queryBroadcastReceivers(new Intent("com.google.iid.TOKEN_REQUEST"), 0).iterator();

      boolean var1;
      while (true) {
         if (var2.hasNext()) {
            if (!a(var0, ((ResolveInfo)var2.next()).activityInfo.packageName, "com.google.iid.TOKEN_REQUEST")) {
               continue;
            }

            b = true;
            var1 = true;
            break;
         }

         var1 = false;
         break;
      }

      return var1;
   }

   private static boolean a(PackageManager var0, String var1) {
      boolean var2 = false;

      try {
         ApplicationInfo var4 = var0.getApplicationInfo(var1, 0);
         a = var4.packageName;
         d = var4.uid;
      } catch (NameNotFoundException var3) {
         return var2;
      }

      return true;
   }

   private static boolean a(PackageManager var0, String var1, String var2) {
      boolean var3;
      if (var0.checkPermission("com.google.android.c2dm.permission.SEND", var1) == 0) {
         var3 = a(var0, var1);
      } else {
         Log.w(
            "InstanceID/Rpc",
            new StringBuilder(String.valueOf(var1).length() + 56 + String.valueOf(var2).length())
               .append("Possible malicious package ")
               .append(var1)
               .append(" declares ")
               .append(var2)
               .append(" without permission")
               .toString()
         );
         var3 = false;
      }

      return var3;
   }

   private static int b(Context var0) {
      PackageManager var2 = var0.getPackageManager();

      int var1;
      try {
         var1 = var2.getPackageInfo(a(var0), 0).versionCode;
      } catch (NameNotFoundException var3) {
         var1 = -1;
      }

      return var1;
   }

   private final Intent b(Bundle param1, KeyPair param2) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.util.collections.fixed.FastFixedSet.contains(Object)" because "predset" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.lambda$removeErroneousNodes$1(FastExtendedPostdominanceHelper.java:231)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.iterateReachability(FastExtendedPostdominanceHelper.java:373)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.removeErroneousNodes(FastExtendedPostdominanceHelper.java:207)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.getExtendedPostdominators(FastExtendedPostdominanceHelper.java:63)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.findGeneralStatement(DomHelper.java:537)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:472)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:379)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:208)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: new android/os/ConditionVariable
      // 003: dup
      // 004: invokespecial android/os/ConditionVariable.<init> ()V
      // 007: astore 11
      // 009: invokestatic com/google/android/gms/iid/zzl.b ()Ljava/lang/String;
      // 00c: astore 10
      // 00e: aload 0
      // 00f: invokevirtual java/lang/Object.getClass ()Ljava/lang/Class;
      // 012: astore 9
      // 014: aload 9
      // 016: monitorenter
      // 017: aload 0
      // 018: getfield com/google/android/gms/iid/zzl.h Ljava/util/Map;
      // 01b: aload 10
      // 01d: aload 11
      // 01f: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 024: pop
      // 025: aload 9
      // 027: monitorexit
      // 028: invokestatic android/os/SystemClock.elapsedRealtime ()J
      // 02b: lstore 7
      // 02d: aload 0
      // 02e: getfield com/google/android/gms/iid/zzl.q J
      // 031: lconst_0
      // 032: lcmp
      // 033: ifeq 086
      // 036: lload 7
      // 038: aload 0
      // 039: getfield com/google/android/gms/iid/zzl.q J
      // 03c: lcmp
      // 03d: ifgt 086
      // 040: aload 0
      // 041: getfield com/google/android/gms/iid/zzl.q J
      // 044: lstore 5
      // 046: aload 0
      // 047: getfield com/google/android/gms/iid/zzl.p I
      // 04a: istore 3
      // 04b: ldc "InstanceID/Rpc"
      // 04d: new java/lang/StringBuilder
      // 050: dup
      // 051: bipush 78
      // 053: invokespecial java/lang/StringBuilder.<init> (I)V
      // 056: ldc_w "Backoff mode, next request attempt: "
      // 059: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 05c: lload 5
      // 05e: lload 7
      // 060: lsub
      // 061: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 064: ldc_w " interval: "
      // 067: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 06a: iload 3
      // 06b: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 06e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 071: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 074: pop
      // 075: new java/io/IOException
      // 078: dup
      // 079: ldc_w "RETRY_LATER"
      // 07c: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 07f: athrow
      // 080: astore 1
      // 081: aload 9
      // 083: monitorexit
      // 084: aload 1
      // 085: athrow
      // 086: aload 0
      // 087: invokespecial com/google/android/gms/iid/zzl.a ()V
      // 08a: getstatic com/google/android/gms/iid/zzl.a Ljava/lang/String;
      // 08d: ifnonnull 09b
      // 090: new java/io/IOException
      // 093: dup
      // 094: ldc_w "MISSING_INSTANCEID_SERVICE"
      // 097: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 09a: athrow
      // 09b: aload 0
      // 09c: invokestatic android/os/SystemClock.elapsedRealtime ()J
      // 09f: putfield com/google/android/gms/iid/zzl.m J
      // 0a2: getstatic com/google/android/gms/iid/zzl.b Z
      // 0a5: ifeq 263
      // 0a8: ldc_w "com.google.iid.TOKEN_REQUEST"
      // 0ab: astore 9
      // 0ad: new android/content/Intent
      // 0b0: dup
      // 0b1: aload 9
      // 0b3: invokespecial android/content/Intent.<init> (Ljava/lang/String;)V
      // 0b6: astore 9
      // 0b8: aload 9
      // 0ba: getstatic com/google/android/gms/iid/zzl.a Ljava/lang/String;
      // 0bd: invokevirtual android/content/Intent.setPackage (Ljava/lang/String;)Landroid/content/Intent;
      // 0c0: pop
      // 0c1: aload 1
      // 0c2: ldc_w "gmsv"
      // 0c5: aload 0
      // 0c6: getfield com/google/android/gms/iid/zzl.g Landroid/content/Context;
      // 0c9: invokestatic com/google/android/gms/iid/zzl.b (Landroid/content/Context;)I
      // 0cc: invokestatic java/lang/Integer.toString (I)Ljava/lang/String;
      // 0cf: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 0d2: aload 1
      // 0d3: ldc_w "osv"
      // 0d6: getstatic android/os/Build$VERSION.SDK_INT I
      // 0d9: invokestatic java/lang/Integer.toString (I)Ljava/lang/String;
      // 0dc: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 0df: aload 1
      // 0e0: ldc_w "app_ver"
      // 0e3: aload 0
      // 0e4: getfield com/google/android/gms/iid/zzl.g Landroid/content/Context;
      // 0e7: invokestatic com/google/android/gms/iid/InstanceID.a (Landroid/content/Context;)I
      // 0ea: invokestatic java/lang/Integer.toString (I)Ljava/lang/String;
      // 0ed: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 0f0: aload 1
      // 0f1: ldc_w "app_ver_name"
      // 0f4: aload 0
      // 0f5: getfield com/google/android/gms/iid/zzl.g Landroid/content/Context;
      // 0f8: invokestatic com/google/android/gms/iid/InstanceID.b (Landroid/content/Context;)Ljava/lang/String;
      // 0fb: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 0fe: aload 1
      // 0ff: ldc_w "cliv"
      // 102: ldc_w "iid-11910000"
      // 105: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 108: aload 1
      // 109: ldc_w "appid"
      // 10c: aload 2
      // 10d: invokestatic com/google/android/gms/iid/InstanceID.a (Ljava/security/KeyPair;)Ljava/lang/String;
      // 110: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 113: aload 2
      // 114: invokevirtual java/security/KeyPair.getPublic ()Ljava/security/PublicKey;
      // 117: invokeinterface java/security/PublicKey.getEncoded ()[B 1
      // 11c: invokestatic com/google/android/gms/iid/InstanceID.a ([B)Ljava/lang/String;
      // 11f: astore 12
      // 121: aload 1
      // 122: ldc_w "pub2"
      // 125: aload 12
      // 127: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 12a: aload 1
      // 12b: ldc_w "sig"
      // 12e: aload 2
      // 12f: bipush 2
      // 130: anewarray 170
      // 133: dup
      // 134: bipush 0
      // 135: aload 0
      // 136: getfield com/google/android/gms/iid/zzl.g Landroid/content/Context;
      // 139: invokevirtual android/content/Context.getPackageName ()Ljava/lang/String;
      // 13c: aastore
      // 13d: dup
      // 13e: bipush 1
      // 13f: aload 12
      // 141: aastore
      // 142: invokestatic com/google/android/gms/iid/zzl.a (Ljava/security/KeyPair;[Ljava/lang/String;)Ljava/lang/String;
      // 145: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 148: aload 9
      // 14a: aload 1
      // 14b: invokevirtual android/content/Intent.putExtras (Landroid/os/Bundle;)Landroid/content/Intent;
      // 14e: pop
      // 14f: aload 0
      // 150: aload 9
      // 152: invokespecial com/google/android/gms/iid/zzl.c (Landroid/content/Intent;)V
      // 155: aload 0
      // 156: invokestatic android/os/SystemClock.elapsedRealtime ()J
      // 159: putfield com/google/android/gms/iid/zzl.m J
      // 15c: aload 9
      // 15e: ldc_w "kid"
      // 161: new java/lang/StringBuilder
      // 164: dup
      // 165: aload 10
      // 167: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 16a: invokevirtual java/lang/String.length ()I
      // 16d: bipush 5
      // 16e: iadd
      // 16f: invokespecial java/lang/StringBuilder.<init> (I)V
      // 172: ldc_w "|ID|"
      // 175: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 178: aload 10
      // 17a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 17d: ldc_w "|"
      // 180: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 183: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 186: invokevirtual android/content/Intent.putExtra (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      // 189: pop
      // 18a: aload 9
      // 18c: ldc_w "X-kid"
      // 18f: new java/lang/StringBuilder
      // 192: dup
      // 193: aload 10
      // 195: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 198: invokevirtual java/lang/String.length ()I
      // 19b: bipush 5
      // 19c: iadd
      // 19d: invokespecial java/lang/StringBuilder.<init> (I)V
      // 1a0: ldc_w "|ID|"
      // 1a3: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1a6: aload 10
      // 1a8: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1ab: ldc_w "|"
      // 1ae: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1b1: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1b4: invokevirtual android/content/Intent.putExtra (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      // 1b7: pop
      // 1b8: ldc "com.google.android.gsf"
      // 1ba: getstatic com/google/android/gms/iid/zzl.a Ljava/lang/String;
      // 1bd: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 1c0: istore 4
      // 1c2: aload 9
      // 1c4: ldc_w "useGsf"
      // 1c7: invokevirtual android/content/Intent.getStringExtra (Ljava/lang/String;)Ljava/lang/String;
      // 1ca: astore 1
      // 1cb: aload 1
      // 1cc: ifnull 1d8
      // 1cf: ldc_w "1"
      // 1d2: aload 1
      // 1d3: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 1d6: istore 4
      // 1d8: ldc "InstanceID/Rpc"
      // 1da: bipush 3
      // 1db: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 1de: ifeq 20e
      // 1e1: aload 9
      // 1e3: invokevirtual android/content/Intent.getExtras ()Landroid/os/Bundle;
      // 1e6: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 1e9: astore 1
      // 1ea: ldc "InstanceID/Rpc"
      // 1ec: new java/lang/StringBuilder
      // 1ef: dup
      // 1f0: aload 1
      // 1f1: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 1f4: invokevirtual java/lang/String.length ()I
      // 1f7: bipush 8
      // 1f9: iadd
      // 1fa: invokespecial java/lang/StringBuilder.<init> (I)V
      // 1fd: ldc_w "Sending "
      // 200: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 203: aload 1
      // 204: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 207: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 20a: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 20d: pop
      // 20e: aload 0
      // 20f: getfield com/google/android/gms/iid/zzl.j Landroid/os/Messenger;
      // 212: ifnull 27d
      // 215: aload 9
      // 217: ldc_w "google.messenger"
      // 21a: aload 0
      // 21b: getfield com/google/android/gms/iid/zzl.i Landroid/os/Messenger;
      // 21e: invokevirtual android/content/Intent.putExtra (Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
      // 221: pop
      // 222: invokestatic android/os/Message.obtain ()Landroid/os/Message;
      // 225: astore 1
      // 226: aload 1
      // 227: aload 9
      // 229: putfield android/os/Message.obj Ljava/lang/Object;
      // 22c: aload 0
      // 22d: getfield com/google/android/gms/iid/zzl.j Landroid/os/Messenger;
      // 230: aload 1
      // 231: invokevirtual android/os/Messenger.send (Landroid/os/Message;)V
      // 234: aload 11
      // 236: ldc2_w 30000
      // 239: invokevirtual android/os/ConditionVariable.block (J)Z
      // 23c: pop
      // 23d: aload 0
      // 23e: invokevirtual java/lang/Object.getClass ()Ljava/lang/Class;
      // 241: astore 1
      // 242: aload 1
      // 243: monitorenter
      // 244: aload 0
      // 245: getfield com/google/android/gms/iid/zzl.h Ljava/util/Map;
      // 248: aload 10
      // 24a: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 24f: astore 9
      // 251: aload 9
      // 253: instanceof android/content/Intent
      // 256: ifeq 349
      // 259: aload 9
      // 25b: checkcast android/content/Intent
      // 25e: astore 2
      // 25f: aload 1
      // 260: monitorexit
      // 261: aload 2
      // 262: areturn
      // 263: ldc "com.google.android.c2dm.intent.REGISTER"
      // 265: astore 9
      // 267: goto 0ad
      // 26a: astore 1
      // 26b: ldc "InstanceID/Rpc"
      // 26d: bipush 3
      // 26e: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 271: ifeq 27d
      // 274: ldc "InstanceID/Rpc"
      // 276: ldc_w "Messenger failed, fallback to startService"
      // 279: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 27c: pop
      // 27d: iload 4
      // 27f: ifeq 2e2
      // 282: aload 0
      // 283: monitorenter
      // 284: getstatic com/google/android/gms/iid/zzl.f Landroid/content/BroadcastReceiver;
      // 287: ifnonnull 2cf
      // 28a: new com/google/android/gms/iid/zzn
      // 28d: astore 1
      // 28e: aload 1
      // 28f: aload 0
      // 290: invokespecial com/google/android/gms/iid/zzn.<init> (Lcom/google/android/gms/iid/zzl;)V
      // 293: aload 1
      // 294: putstatic com/google/android/gms/iid/zzl.f Landroid/content/BroadcastReceiver;
      // 297: ldc "InstanceID/Rpc"
      // 299: bipush 3
      // 29a: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 29d: ifeq 2a9
      // 2a0: ldc "InstanceID/Rpc"
      // 2a2: ldc_w "Registered GSF callback receiver"
      // 2a5: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 2a8: pop
      // 2a9: new android/content/IntentFilter
      // 2ac: astore 1
      // 2ad: aload 1
      // 2ae: ldc_w "com.google.android.c2dm.intent.REGISTRATION"
      // 2b1: invokespecial android/content/IntentFilter.<init> (Ljava/lang/String;)V
      // 2b4: aload 1
      // 2b5: aload 0
      // 2b6: getfield com/google/android/gms/iid/zzl.g Landroid/content/Context;
      // 2b9: invokevirtual android/content/Context.getPackageName ()Ljava/lang/String;
      // 2bc: invokevirtual android/content/IntentFilter.addCategory (Ljava/lang/String;)V
      // 2bf: aload 0
      // 2c0: getfield com/google/android/gms/iid/zzl.g Landroid/content/Context;
      // 2c3: getstatic com/google/android/gms/iid/zzl.f Landroid/content/BroadcastReceiver;
      // 2c6: aload 1
      // 2c7: ldc_w "com.google.android.c2dm.permission.SEND"
      // 2ca: aconst_null
      // 2cb: invokevirtual android/content/Context.registerReceiver (Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
      // 2ce: pop
      // 2cf: aload 0
      // 2d0: monitorexit
      // 2d1: aload 0
      // 2d2: getfield com/google/android/gms/iid/zzl.g Landroid/content/Context;
      // 2d5: aload 9
      // 2d7: invokevirtual android/content/Context.sendBroadcast (Landroid/content/Intent;)V
      // 2da: goto 234
      // 2dd: astore 1
      // 2de: aload 0
      // 2df: monitorexit
      // 2e0: aload 1
      // 2e1: athrow
      // 2e2: aload 9
      // 2e4: ldc_w "google.messenger"
      // 2e7: aload 0
      // 2e8: getfield com/google/android/gms/iid/zzl.i Landroid/os/Messenger;
      // 2eb: invokevirtual android/content/Intent.putExtra (Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
      // 2ee: pop
      // 2ef: aload 9
      // 2f1: ldc_w "messenger2"
      // 2f4: ldc_w "1"
      // 2f7: invokevirtual android/content/Intent.putExtra (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      // 2fa: pop
      // 2fb: aload 0
      // 2fc: getfield com/google/android/gms/iid/zzl.k Lcom/google/android/gms/iid/MessengerCompat;
      // 2ff: ifnull 32a
      // 302: invokestatic android/os/Message.obtain ()Landroid/os/Message;
      // 305: astore 1
      // 306: aload 1
      // 307: aload 9
      // 309: putfield android/os/Message.obj Ljava/lang/Object;
      // 30c: aload 0
      // 30d: getfield com/google/android/gms/iid/zzl.k Lcom/google/android/gms/iid/MessengerCompat;
      // 310: aload 1
      // 311: invokevirtual com/google/android/gms/iid/MessengerCompat.a (Landroid/os/Message;)V
      // 314: goto 234
      // 317: astore 1
      // 318: ldc "InstanceID/Rpc"
      // 31a: bipush 3
      // 31b: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 31e: ifeq 32a
      // 321: ldc "InstanceID/Rpc"
      // 323: ldc_w "Messenger failed, fallback to startService"
      // 326: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 329: pop
      // 32a: getstatic com/google/android/gms/iid/zzl.b Z
      // 32d: ifeq 33c
      // 330: aload 0
      // 331: getfield com/google/android/gms/iid/zzl.g Landroid/content/Context;
      // 334: aload 9
      // 336: invokevirtual android/content/Context.sendBroadcast (Landroid/content/Intent;)V
      // 339: goto 234
      // 33c: aload 0
      // 33d: getfield com/google/android/gms/iid/zzl.g Landroid/content/Context;
      // 340: aload 9
      // 342: invokevirtual android/content/Context.startService (Landroid/content/Intent;)Landroid/content/ComponentName;
      // 345: pop
      // 346: goto 234
      // 349: aload 9
      // 34b: instanceof java/lang/String
      // 34e: ifeq 365
      // 351: new java/io/IOException
      // 354: astore 2
      // 355: aload 2
      // 356: aload 9
      // 358: checkcast java/lang/String
      // 35b: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 35e: aload 2
      // 35f: athrow
      // 360: astore 2
      // 361: aload 1
      // 362: monitorexit
      // 363: aload 2
      // 364: athrow
      // 365: aload 9
      // 367: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 36a: astore 9
      // 36c: aload 9
      // 36e: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 371: invokevirtual java/lang/String.length ()I
      // 374: istore 3
      // 375: new java/lang/StringBuilder
      // 378: astore 2
      // 379: aload 2
      // 37a: iload 3
      // 37b: bipush 12
      // 37d: iadd
      // 37e: invokespecial java/lang/StringBuilder.<init> (I)V
      // 381: ldc "InstanceID/Rpc"
      // 383: aload 2
      // 384: ldc_w "No response "
      // 387: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 38a: aload 9
      // 38c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 38f: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 392: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 395: pop
      // 396: new java/io/IOException
      // 399: astore 2
      // 39a: aload 2
      // 39b: ldc_w "TIMEOUT"
      // 39e: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 3a1: aload 2
      // 3a2: athrow
      // try (11 -> 19): 60 null
      // try (61 -> 63): 60 null
      // try (250 -> 254): 281 android/os/RemoteException
      // try (263 -> 276): 398 null
      // try (294 -> 311): 336 null
      // try (311 -> 329): 336 null
      // try (329 -> 331): 336 null
      // try (337 -> 339): 336 null
      // try (360 -> 364): 365 android/os/RemoteException
      // try (387 -> 398): 398 null
      // try (399 -> 401): 398 null
      // try (403 -> 433): 398 null
   }

   private static String b() {
      synchronized (zzl.class) {
         int var0 = e++;
         return Integer.toString(var0);
      }
   }

   private final void c(Intent var1) {
      synchronized (this) {
         if (this.l == null) {
            Intent var2 = new Intent();
            var2.setPackage("com.google.example.invalidpackage");
            this.l = PendingIntent.getBroadcast(this.g, 0, var2, 0);
         }

         var1.putExtra("app", this.l);
      }
   }

   final Intent a(Bundle var1, KeyPair var2) throws IOException {
      Intent var4 = this.b(var1, var2);
      Intent var3 = var4;
      if (var4 != null) {
         var3 = var4;
         if (var4.hasExtra("google.messenger")) {
            Intent var5 = this.b(var1, var2);
            var3 = var5;
            if (var5 != null) {
               var3 = var5;
               if (var5.hasExtra("google.messenger")) {
                  var3 = null;
               }
            }
         }
      }

      return var3;
   }

   public final void a(Message var1) {
      if (var1 != null) {
         if (var1.obj instanceof Intent) {
            Intent var2 = (Intent)var1.obj;
            var2.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
            if (var2.hasExtra("google.messenger")) {
               Parcelable var3 = var2.getParcelableExtra("google.messenger");
               if (var3 instanceof MessengerCompat) {
                  this.k = (MessengerCompat)var3;
               }

               if (var3 instanceof Messenger) {
                  this.j = (Messenger)var3;
               }
            }

            this.b((Intent)var1.obj);
         } else {
            Log.w("InstanceID/Rpc", "Dropping invalid message");
         }
      }
   }

   public final void b(Intent var1) {
      if (var1 == null) {
         if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Unexpected response: null");
         }
      } else {
         String var5 = var1.getAction();
         if ("com.google.android.c2dm.intent.REGISTRATION".equals(var5) || "com.google.android.gms.iid.InstanceID".equals(var5)) {
            var5 = var1.getStringExtra("registration_id");
            if (var5 == null) {
               var5 = var1.getStringExtra("unregistered");
            }

            if (var5 == null) {
               String var6 = var1.getStringExtra("error");
               if (var6 == null) {
                  String var11 = String.valueOf(var1.getExtras());
                  Log.w(
                     "InstanceID/Rpc",
                     new StringBuilder(String.valueOf(var11).length() + 49)
                        .append("Unexpected response, no error or registration id ")
                        .append(var11)
                        .toString()
                  );
               } else {
                  if (Log.isLoggable("InstanceID/Rpc", 3)) {
                     var5 = String.valueOf(var6);
                     if (var5.length() != 0) {
                        var5 = "Received InstanceID error ".concat(var5);
                     } else {
                        var5 = new String("Received InstanceID error ");
                     }

                     Log.d("InstanceID/Rpc", var5);
                  }

                  if (var6.startsWith("|")) {
                     String[] var8 = var6.split("\\|");
                     if (!"ID".equals(var8[1])) {
                        var5 = String.valueOf(var6);
                        if (var5.length() != 0) {
                           var5 = "Unexpected structured response ".concat(var5);
                        } else {
                           var5 = new String("Unexpected structured response ");
                        }

                        Log.w("InstanceID/Rpc", var5);
                     }

                     if (var8.length > 2) {
                        String var7 = var8[2];
                        String var29 = var8[3];
                        var6 = var7;
                        var5 = var29;
                        if (var29.startsWith(":")) {
                           var5 = var29.substring(1);
                           var6 = var7;
                        }
                     } else {
                        var5 = "UNKNOWN";
                        var6 = null;
                     }

                     var1.putExtra("error", var5);
                  } else {
                     Object var26 = null;
                     var5 = var6;
                     var6 = (String)var26;
                  }

                  if (var6 == null) {
                     this.a(var5);
                  } else {
                     this.a(var6, var5);
                  }

                  long var3 = var1.getLongExtra("Retry-After", 0L);
                  if (var3 > 0L) {
                     this.n = SystemClock.elapsedRealtime();
                     this.p = (int)var3 * 1000;
                     this.q = SystemClock.elapsedRealtime() + this.p;
                     int var2 = this.p;
                     Log.w("InstanceID/Rpc", new StringBuilder(52).append("Explicit request from server to backoff: ").append(var2).toString());
                  } else if (("SERVICE_NOT_AVAILABLE".equals(var5) || "AUTHENTICATION_FAILED".equals(var5)) && "com.google.android.gsf".equals(a)) {
                     this.o++;
                     if (this.o >= 3) {
                        if (this.o == 3) {
                           this.p = new Random().nextInt(1000) + 1000;
                        }

                        this.p <<= 1;
                        this.q = SystemClock.elapsedRealtime() + this.p;
                        int var12 = this.p;
                        Log.w(
                           "InstanceID/Rpc",
                           new StringBuilder(String.valueOf(var5).length() + 31)
                              .append("Backoff due to ")
                              .append(var5)
                              .append(" for ")
                              .append(var12)
                              .toString()
                        );
                     }
                  }
               }
            } else {
               this.m = SystemClock.elapsedRealtime();
               this.q = 0L;
               this.o = 0;
               this.p = 0;
               String var25 = null;
               if (var5.startsWith("|")) {
                  String[] var27 = var5.split("\\|");
                  if (!"ID".equals(var27[1])) {
                     var5 = String.valueOf(var5);
                     if (var5.length() != 0) {
                        var5 = "Unexpected structured response ".concat(var5);
                     } else {
                        var5 = new String("Unexpected structured response ");
                     }

                     Log.w("InstanceID/Rpc", var5);
                  }

                  var25 = var27[2];
                  if (var27.length > 4) {
                     if ("SYNC".equals(var27[3])) {
                        Context var21 = this.g;
                        Intent var30 = new Intent("com.google.android.gms.iid.InstanceID");
                        var30.putExtra("CMD", "SYNC");
                        var30.setClassName(var21, "com.google.android.gms.gcm.GcmReceiver");
                        var21.sendBroadcast(var30);
                     } else if ("RST".equals(var27[3])) {
                        Context var23 = this.g;
                        InstanceID.c(this.g);
                        InstanceIDListenerService.a(var23, InstanceID.c());
                        var1.removeExtra("registration_id");
                        this.a(var25, var1);
                        return;
                     }
                  }

                  String var28 = var27[var27.length - 1];
                  var5 = var28;
                  if (var28.startsWith(":")) {
                     var5 = var28.substring(1);
                  }

                  var1.putExtra("registration_id", var5);
               }

               if (var25 == null) {
                  this.a((Object)var1);
               } else {
                  this.a(var25, var1);
               }
            }
         } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String var9 = String.valueOf(var1.getAction());
            String var10;
            if (var9.length() != 0) {
               var10 = "Unexpected response ".concat(var9);
            } else {
               var10 = new String("Unexpected response ");
            }

            Log.d("InstanceID/Rpc", var10);
         }
      }
   }
}
