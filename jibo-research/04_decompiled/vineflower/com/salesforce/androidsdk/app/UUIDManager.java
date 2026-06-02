package com.salesforce.androidsdk.app;

import java.util.HashMap;
import java.util.Map;

public class UUIDManager {
   private static Map<String, String> a = new HashMap<>();

   public static String a(String param0) {
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
      // 00: ldc com/salesforce/androidsdk/app/UUIDManager
      // 02: monitorenter
      // 03: getstatic com/salesforce/androidsdk/app/UUIDManager.a Ljava/util/Map;
      // 06: aload 0
      // 07: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0c: checkcast java/lang/String
      // 0f: astore 1
      // 10: aload 1
      // 11: ifnull 19
      // 14: ldc com/salesforce/androidsdk/app/UUIDManager
      // 16: monitorexit
      // 17: aload 1
      // 18: areturn
      // 19: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.a ()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
      // 1c: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.k ()Landroid/content/Context;
      // 1f: ldc "uuids2"
      // 21: bipush 0
      // 22: invokevirtual android/content/Context.getSharedPreferences (Ljava/lang/String;I)Landroid/content/SharedPreferences;
      // 25: astore 3
      // 26: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.a ()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
      // 29: aload 0
      // 2a: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.b (Ljava/lang/String;)Ljava/lang/String;
      // 2d: astore 2
      // 2e: aload 3
      // 2f: aload 0
      // 30: invokeinterface android/content/SharedPreferences.contains (Ljava/lang/String;)Z 2
      // 35: ifne 5d
      // 38: invokestatic java/util/UUID.randomUUID ()Ljava/util/UUID;
      // 3b: invokevirtual java/util/UUID.toString ()Ljava/lang/String;
      // 3e: astore 1
      // 3f: aload 3
      // 40: invokeinterface android/content/SharedPreferences.edit ()Landroid/content/SharedPreferences$Editor; 1
      // 45: astore 4
      // 47: aload 4
      // 49: aload 0
      // 4a: aload 1
      // 4b: aload 2
      // 4c: invokestatic com/salesforce/androidsdk/analytics/security/Encryptor.b (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 4f: invokeinterface android/content/SharedPreferences$Editor.putString (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor; 3
      // 54: pop
      // 55: aload 4
      // 57: invokeinterface android/content/SharedPreferences$Editor.commit ()Z 1
      // 5c: pop
      // 5d: aload 3
      // 5e: aload 0
      // 5f: aconst_null
      // 60: invokeinterface android/content/SharedPreferences.getString (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 3
      // 65: aload 2
      // 66: invokestatic com/salesforce/androidsdk/analytics/security/Encryptor.a (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 69: astore 2
      // 6a: aload 2
      // 6b: astore 1
      // 6c: aload 2
      // 6d: ifnull 14
      // 70: getstatic com/salesforce/androidsdk/app/UUIDManager.a Ljava/util/Map;
      // 73: aload 0
      // 74: aload 2
      // 75: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 7a: pop
      // 7b: aload 2
      // 7c: astore 1
      // 7d: goto 14
      // 80: astore 0
      // 81: ldc com/salesforce/androidsdk/app/UUIDManager
      // 83: monitorexit
      // 84: aload 0
      // 85: athrow
      // try (2 -> 7): 62 null
      // try (13 -> 43): 62 null
      // try (43 -> 50): 62 null
      // try (54 -> 59): 62 null
   }

   public static void a() {
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
      // 00: ldc com/salesforce/androidsdk/app/UUIDManager
      // 02: monitorenter
      // 03: getstatic com/salesforce/androidsdk/app/UUIDManager.a Ljava/util/Map;
      // 06: invokeinterface java/util/Map.clear ()V 1
      // 0b: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.a ()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
      // 0e: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.k ()Landroid/content/Context;
      // 11: ldc "uuids2"
      // 13: bipush 0
      // 14: invokevirtual android/content/Context.getSharedPreferences (Ljava/lang/String;I)Landroid/content/SharedPreferences;
      // 17: astore 0
      // 18: aload 0
      // 19: ifnull 2d
      // 1c: aload 0
      // 1d: invokeinterface android/content/SharedPreferences.edit ()Landroid/content/SharedPreferences$Editor; 1
      // 22: invokeinterface android/content/SharedPreferences$Editor.clear ()Landroid/content/SharedPreferences$Editor; 1
      // 27: invokeinterface android/content/SharedPreferences$Editor.commit ()Z 1
      // 2c: pop
      // 2d: ldc com/salesforce/androidsdk/app/UUIDManager
      // 2f: monitorexit
      // 30: return
      // 31: astore 0
      // 32: ldc com/salesforce/androidsdk/app/UUIDManager
      // 34: monitorexit
      // 35: aload 0
      // 36: athrow
      // try (2 -> 10): 20 null
      // try (12 -> 17): 20 null
   }
}
