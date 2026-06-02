package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;

public final class zzx {
   private static zzx b;
   final Queue<Intent> a;
   private final SimpleArrayMap<String, String> c = new SimpleArrayMap<>();
   private Boolean d = null;
   private Queue<Intent> e;

   private zzx() {
      this.a = new ArrayDeque<>();
      this.e = new ArrayDeque<>();
   }

   private final int a(Context param1, Intent param2) {
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
      // 000: aload 0
      // 001: getfield com/google/firebase/iid/zzx.c Landroid/support/v4/util/SimpleArrayMap;
      // 004: astore 5
      // 006: aload 5
      // 008: monitorenter
      // 009: aload 0
      // 00a: getfield com/google/firebase/iid/zzx.c Landroid/support/v4/util/SimpleArrayMap;
      // 00d: aload 2
      // 00e: invokevirtual android/content/Intent.getAction ()Ljava/lang/String;
      // 011: invokevirtual android/support/v4/util/SimpleArrayMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 014: checkcast java/lang/String
      // 017: astore 6
      // 019: aload 5
      // 01b: monitorexit
      // 01c: aload 6
      // 01e: astore 5
      // 020: aload 6
      // 022: ifnonnull 140
      // 025: aload 1
      // 026: invokevirtual android/content/Context.getPackageManager ()Landroid/content/pm/PackageManager;
      // 029: aload 2
      // 02a: bipush 0
      // 02b: invokevirtual android/content/pm/PackageManager.resolveService (Landroid/content/Intent;I)Landroid/content/pm/ResolveInfo;
      // 02e: astore 5
      // 030: aload 5
      // 032: ifnull 03d
      // 035: aload 5
      // 037: getfield android/content/pm/ResolveInfo.serviceInfo Landroid/content/pm/ServiceInfo;
      // 03a: ifnonnull 089
      // 03d: ldc "FirebaseInstanceId"
      // 03f: ldc "Failed to resolve target intent service, skipping classname enforcement"
      // 041: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 044: pop
      // 045: aload 0
      // 046: getfield com/google/firebase/iid/zzx.d Ljava/lang/Boolean;
      // 049: ifnonnull 061
      // 04c: aload 1
      // 04d: ldc "android.permission.WAKE_LOCK"
      // 04f: invokevirtual android/content/Context.checkCallingOrSelfPermission (Ljava/lang/String;)I
      // 052: ifne 199
      // 055: bipush 1
      // 056: istore 4
      // 058: aload 0
      // 059: iload 4
      // 05b: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 05e: putfield com/google/firebase/iid/zzx.d Ljava/lang/Boolean;
      // 061: aload 0
      // 062: getfield com/google/firebase/iid/zzx.d Ljava/lang/Boolean;
      // 065: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 068: ifeq 19f
      // 06b: aload 1
      // 06c: aload 2
      // 06d: invokestatic android/support/v4/content/WakefulBroadcastReceiver.a_ (Landroid/content/Context;Landroid/content/Intent;)Landroid/content/ComponentName;
      // 070: astore 1
      // 071: aload 1
      // 072: ifnonnull 1c1
      // 075: ldc "FirebaseInstanceId"
      // 077: ldc "Error while delivering the message: ServiceIntent not found."
      // 079: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 07c: pop
      // 07d: sipush 404
      // 080: istore 3
      // 081: iload 3
      // 082: ireturn
      // 083: astore 1
      // 084: aload 5
      // 086: monitorexit
      // 087: aload 1
      // 088: athrow
      // 089: aload 5
      // 08b: getfield android/content/pm/ResolveInfo.serviceInfo Landroid/content/pm/ServiceInfo;
      // 08e: astore 6
      // 090: aload 1
      // 091: invokevirtual android/content/Context.getPackageName ()Ljava/lang/String;
      // 094: aload 6
      // 096: getfield android/content/pm/ServiceInfo.packageName Ljava/lang/String;
      // 099: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 09c: ifeq 0a7
      // 09f: aload 6
      // 0a1: getfield android/content/pm/ServiceInfo.name Ljava/lang/String;
      // 0a4: ifnonnull 0f0
      // 0a7: aload 6
      // 0a9: getfield android/content/pm/ServiceInfo.packageName Ljava/lang/String;
      // 0ac: astore 5
      // 0ae: aload 6
      // 0b0: getfield android/content/pm/ServiceInfo.name Ljava/lang/String;
      // 0b3: astore 6
      // 0b5: ldc "FirebaseInstanceId"
      // 0b7: new java/lang/StringBuilder
      // 0ba: dup
      // 0bb: aload 5
      // 0bd: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 0c0: invokevirtual java/lang/String.length ()I
      // 0c3: bipush 94
      // 0c5: iadd
      // 0c6: aload 6
      // 0c8: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 0cb: invokevirtual java/lang/String.length ()I
      // 0ce: iadd
      // 0cf: invokespecial java/lang/StringBuilder.<init> (I)V
      // 0d2: ldc "Error resolving target intent service, skipping classname enforcement. Resolved service was: "
      // 0d4: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0d7: aload 5
      // 0d9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0dc: ldc "/"
      // 0de: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e1: aload 6
      // 0e3: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e6: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0e9: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 0ec: pop
      // 0ed: goto 045
      // 0f0: aload 6
      // 0f2: getfield android/content/pm/ServiceInfo.name Ljava/lang/String;
      // 0f5: astore 6
      // 0f7: aload 6
      // 0f9: astore 5
      // 0fb: aload 6
      // 0fd: ldc "."
      // 0ff: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 102: ifeq 126
      // 105: aload 1
      // 106: invokevirtual android/content/Context.getPackageName ()Ljava/lang/String;
      // 109: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 10c: astore 5
      // 10e: aload 6
      // 110: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 113: astore 6
      // 115: aload 6
      // 117: invokevirtual java/lang/String.length ()I
      // 11a: ifeq 177
      // 11d: aload 5
      // 11f: aload 6
      // 121: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 124: astore 5
      // 126: aload 0
      // 127: getfield com/google/firebase/iid/zzx.c Landroid/support/v4/util/SimpleArrayMap;
      // 12a: astore 6
      // 12c: aload 6
      // 12e: monitorenter
      // 12f: aload 0
      // 130: getfield com/google/firebase/iid/zzx.c Landroid/support/v4/util/SimpleArrayMap;
      // 133: aload 2
      // 134: invokevirtual android/content/Intent.getAction ()Ljava/lang/String;
      // 137: aload 5
      // 139: invokevirtual android/support/v4/util/SimpleArrayMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 13c: pop
      // 13d: aload 6
      // 13f: monitorexit
      // 140: ldc "FirebaseInstanceId"
      // 142: bipush 3
      // 143: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 146: ifeq 169
      // 149: aload 5
      // 14b: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 14e: astore 6
      // 150: aload 6
      // 152: invokevirtual java/lang/String.length ()I
      // 155: ifeq 18b
      // 158: ldc "Restricting intent to a specific service: "
      // 15a: aload 6
      // 15c: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 15f: astore 6
      // 161: ldc "FirebaseInstanceId"
      // 163: aload 6
      // 165: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 168: pop
      // 169: aload 2
      // 16a: aload 1
      // 16b: invokevirtual android/content/Context.getPackageName ()Ljava/lang/String;
      // 16e: aload 5
      // 170: invokevirtual android/content/Intent.setClassName (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      // 173: pop
      // 174: goto 045
      // 177: new java/lang/String
      // 17a: dup
      // 17b: aload 5
      // 17d: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // 180: astore 5
      // 182: goto 126
      // 185: astore 1
      // 186: aload 6
      // 188: monitorexit
      // 189: aload 1
      // 18a: athrow
      // 18b: new java/lang/String
      // 18e: dup
      // 18f: ldc "Restricting intent to a specific service: "
      // 191: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // 194: astore 6
      // 196: goto 161
      // 199: bipush 0
      // 19a: istore 4
      // 19c: goto 058
      // 19f: aload 1
      // 1a0: aload 2
      // 1a1: invokevirtual android/content/Context.startService (Landroid/content/Intent;)Landroid/content/ComponentName;
      // 1a4: astore 1
      // 1a5: ldc "FirebaseInstanceId"
      // 1a7: ldc "Missing wake lock permission, service start may be delayed"
      // 1a9: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 1ac: pop
      // 1ad: goto 071
      // 1b0: astore 1
      // 1b1: ldc "FirebaseInstanceId"
      // 1b3: ldc "Error while delivering the message to the serviceIntent"
      // 1b5: aload 1
      // 1b6: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 1b9: pop
      // 1ba: sipush 401
      // 1bd: istore 3
      // 1be: goto 081
      // 1c1: bipush -1
      // 1c2: istore 3
      // 1c3: goto 081
      // 1c6: astore 1
      // 1c7: aload 1
      // 1c8: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 1cb: astore 1
      // 1cc: ldc "FirebaseInstanceId"
      // 1ce: new java/lang/StringBuilder
      // 1d1: dup
      // 1d2: aload 1
      // 1d3: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 1d6: invokevirtual java/lang/String.length ()I
      // 1d9: bipush 45
      // 1db: iadd
      // 1dc: invokespecial java/lang/StringBuilder.<init> (I)V
      // 1df: ldc "Failed to start service while in background: "
      // 1e1: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1e4: aload 1
      // 1e5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1e8: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1eb: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 1ee: pop
      // 1ef: sipush 402
      // 1f2: istore 3
      // 1f3: goto 081
      // try (5 -> 14): 64 null
      // try (33 -> 40): 203 java/lang/SecurityException
      // try (33 -> 40): 215 java/lang/IllegalStateException
      // try (42 -> 46): 203 java/lang/SecurityException
      // try (42 -> 46): 215 java/lang/IllegalStateException
      // try (46 -> 54): 203 java/lang/SecurityException
      // try (46 -> 54): 215 java/lang/IllegalStateException
      // try (56 -> 60): 203 java/lang/SecurityException
      // try (56 -> 60): 215 java/lang/IllegalStateException
      // try (65 -> 67): 64 null
      // try (140 -> 149): 180 null
      // try (181 -> 183): 180 null
      // try (194 -> 202): 203 java/lang/SecurityException
      // try (194 -> 202): 215 java/lang/IllegalStateException
   }

   public static PendingIntent a(Context var0, int var1, Intent var2, int var3) {
      Intent var4 = new Intent(var0, FirebaseInstanceIdReceiver.class);
      var4.setAction("com.google.firebase.MESSAGING_EVENT");
      var4.putExtra("wrapped_intent", var2);
      return PendingIntent.getBroadcast(var0, var1, var4, 1073741824);
   }

   public static zzx a() {
      synchronized (zzx.class) {
         if (b == null) {
            zzx var0 = new zzx();
            b = var0;
         }

         return b;
      }
   }

   public final int a(Context var1, String var2, Intent var3) {
      switch (var2) {
         case "com.google.firebase.INSTANCE_ID_EVENT":
            this.a.offer(var3);
            break;
         case "com.google.firebase.MESSAGING_EVENT":
            this.e.offer(var3);
            break;
         default:
            String var5 = String.valueOf(var2);
            String var6;
            if (var5.length() != 0) {
               var6 = "Unknown service action: ".concat(var5);
            } else {
               var6 = new String("Unknown service action: ");
            }

            Log.w("FirebaseInstanceId", var6);
            return 500;
      }

      Intent var7 = new Intent(var2);
      var7.setPackage(var1.getPackageName());
      return this.a(var1, var7);
   }

   public final Intent b() {
      return this.e.poll();
   }
}
