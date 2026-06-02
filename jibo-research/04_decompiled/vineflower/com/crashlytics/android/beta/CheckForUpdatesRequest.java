package com.crashlytics.android.beta;

import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.HashMap;
import java.util.Map;

class CheckForUpdatesRequest extends AbstractSpiCall {
   private final CheckForUpdatesResponseTransform b;

   public CheckForUpdatesRequest(Kit var1, String var2, String var3, HttpRequestFactory var4, CheckForUpdatesResponseTransform var5) {
      super(var1, var2, var3, var4, HttpMethod.GET);
      this.b = var5;
   }

   private HttpRequest a(HttpRequest var1, String var2, String var3) {
      return var1.a("Accept", "application/json")
         .a("User-Agent", "Crashlytics Android SDK/" + this.a.a())
         .a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa")
         .a("X-CRASHLYTICS-API-CLIENT-TYPE", "android")
         .a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a())
         .a("X-CRASHLYTICS-API-KEY", var2)
         .a("X-CRASHLYTICS-BETA-TOKEN", a(var3));
   }

   static String a(String var0) {
      return "3:" + var0;
   }

   private Map<String, String> a(BuildProperties var1) {
      HashMap var2 = new HashMap();
      var2.put("build_version", var1.a);
      var2.put("display_version", var1.b);
      var2.put("instance", var1.c);
      var2.put("source", "3");
      return var2;
   }

   public CheckForUpdatesResponse a(String param1, String param2, BuildProperties param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 6
      // 003: aload 0
      // 004: aload 3
      // 005: invokespecial com/crashlytics/android/beta/CheckForUpdatesRequest.a (Lcom/crashlytics/android/beta/BuildProperties;)Ljava/util/Map;
      // 008: astore 7
      // 00a: aload 0
      // 00b: aload 7
      // 00d: invokevirtual com/crashlytics/android/beta/CheckForUpdatesRequest.a (Ljava/util/Map;)Lio/fabric/sdk/android/services/network/HttpRequest;
      // 010: astore 5
      // 012: aload 5
      // 014: astore 3
      // 015: aload 5
      // 017: astore 4
      // 019: aload 0
      // 01a: aload 5
      // 01c: aload 1
      // 01d: aload 2
      // 01e: invokespecial com/crashlytics/android/beta/CheckForUpdatesRequest.a (Lio/fabric/sdk/android/services/network/HttpRequest;Ljava/lang/String;Ljava/lang/String;)Lio/fabric/sdk/android/services/network/HttpRequest;
      // 021: astore 1
      // 022: aload 1
      // 023: astore 3
      // 024: aload 1
      // 025: astore 4
      // 027: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 02a: astore 5
      // 02c: aload 1
      // 02d: astore 3
      // 02e: aload 1
      // 02f: astore 4
      // 031: new java/lang/StringBuilder
      // 034: astore 2
      // 035: aload 1
      // 036: astore 3
      // 037: aload 1
      // 038: astore 4
      // 03a: aload 2
      // 03b: invokespecial java/lang/StringBuilder.<init> ()V
      // 03e: aload 1
      // 03f: astore 3
      // 040: aload 1
      // 041: astore 4
      // 043: aload 5
      // 045: ldc "Beta"
      // 047: aload 2
      // 048: ldc "Checking for updates from "
      // 04a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 04d: aload 0
      // 04e: invokevirtual com/crashlytics/android/beta/CheckForUpdatesRequest.a ()Ljava/lang/String;
      // 051: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 054: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 057: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 05c: aload 1
      // 05d: astore 3
      // 05e: aload 1
      // 05f: astore 4
      // 061: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 064: astore 5
      // 066: aload 1
      // 067: astore 3
      // 068: aload 1
      // 069: astore 4
      // 06b: new java/lang/StringBuilder
      // 06e: astore 2
      // 06f: aload 1
      // 070: astore 3
      // 071: aload 1
      // 072: astore 4
      // 074: aload 2
      // 075: invokespecial java/lang/StringBuilder.<init> ()V
      // 078: aload 1
      // 079: astore 3
      // 07a: aload 1
      // 07b: astore 4
      // 07d: aload 5
      // 07f: ldc "Beta"
      // 081: aload 2
      // 082: ldc "Checking for updates query params are: "
      // 084: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 087: aload 7
      // 089: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 08c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 08f: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 094: aload 1
      // 095: astore 3
      // 096: aload 1
      // 097: astore 4
      // 099: aload 1
      // 09a: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.c ()Z
      // 09d: ifeq 105
      // 0a0: aload 1
      // 0a1: astore 3
      // 0a2: aload 1
      // 0a3: astore 4
      // 0a5: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 0a8: ldc "Beta"
      // 0aa: ldc "Checking for updates was successful"
      // 0ac: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 0b1: aload 1
      // 0b2: astore 3
      // 0b3: aload 1
      // 0b4: astore 4
      // 0b6: new org/json/JSONObject
      // 0b9: astore 2
      // 0ba: aload 1
      // 0bb: astore 3
      // 0bc: aload 1
      // 0bd: astore 4
      // 0bf: aload 2
      // 0c0: aload 1
      // 0c1: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.e ()Ljava/lang/String;
      // 0c4: invokespecial org/json/JSONObject.<init> (Ljava/lang/String;)V
      // 0c7: aload 1
      // 0c8: astore 3
      // 0c9: aload 1
      // 0ca: astore 4
      // 0cc: aload 0
      // 0cd: getfield com/crashlytics/android/beta/CheckForUpdatesRequest.b Lcom/crashlytics/android/beta/CheckForUpdatesResponseTransform;
      // 0d0: aload 2
      // 0d1: invokevirtual com/crashlytics/android/beta/CheckForUpdatesResponseTransform.a (Lorg/json/JSONObject;)Lcom/crashlytics/android/beta/CheckForUpdatesResponse;
      // 0d4: astore 2
      // 0d5: aload 2
      // 0d6: astore 3
      // 0d7: aload 3
      // 0d8: astore 2
      // 0d9: aload 1
      // 0da: ifnull 103
      // 0dd: aload 1
      // 0de: ldc "X-REQUEST-ID"
      // 0e0: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.b (Ljava/lang/String;)Ljava/lang/String;
      // 0e3: astore 1
      // 0e4: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 0e7: ldc "Fabric"
      // 0e9: new java/lang/StringBuilder
      // 0ec: dup
      // 0ed: invokespecial java/lang/StringBuilder.<init> ()V
      // 0f0: ldc "Checking for updates request ID: "
      // 0f2: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0f5: aload 1
      // 0f6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0f9: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0fc: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 101: aload 3
      // 102: astore 2
      // 103: aload 2
      // 104: areturn
      // 105: aload 1
      // 106: astore 3
      // 107: aload 1
      // 108: astore 4
      // 10a: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 10d: astore 2
      // 10e: aload 1
      // 10f: astore 3
      // 110: aload 1
      // 111: astore 4
      // 113: new java/lang/StringBuilder
      // 116: astore 5
      // 118: aload 1
      // 119: astore 3
      // 11a: aload 1
      // 11b: astore 4
      // 11d: aload 5
      // 11f: invokespecial java/lang/StringBuilder.<init> ()V
      // 122: aload 1
      // 123: astore 3
      // 124: aload 1
      // 125: astore 4
      // 127: aload 2
      // 128: ldc "Beta"
      // 12a: aload 5
      // 12c: ldc "Checking for updates failed. Response code: "
      // 12e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 131: aload 1
      // 132: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.b ()I
      // 135: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 138: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 13b: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;)V 3
      // 140: aload 6
      // 142: astore 2
      // 143: aload 1
      // 144: ifnull 103
      // 147: aload 1
      // 148: ldc "X-REQUEST-ID"
      // 14a: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.b (Ljava/lang/String;)Ljava/lang/String;
      // 14d: astore 1
      // 14e: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 151: ldc "Fabric"
      // 153: new java/lang/StringBuilder
      // 156: dup
      // 157: invokespecial java/lang/StringBuilder.<init> ()V
      // 15a: ldc "Checking for updates request ID: "
      // 15c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 15f: aload 1
      // 160: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 163: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 166: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 16b: aload 6
      // 16d: astore 2
      // 16e: goto 103
      // 171: astore 1
      // 172: aconst_null
      // 173: astore 4
      // 175: aload 4
      // 177: astore 3
      // 178: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 17b: astore 2
      // 17c: aload 4
      // 17e: astore 3
      // 17f: new java/lang/StringBuilder
      // 182: astore 5
      // 184: aload 4
      // 186: astore 3
      // 187: aload 5
      // 189: invokespecial java/lang/StringBuilder.<init> ()V
      // 18c: aload 4
      // 18e: astore 3
      // 18f: aload 2
      // 190: ldc "Beta"
      // 192: aload 5
      // 194: ldc "Error while checking for updates from "
      // 196: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 199: aload 0
      // 19a: invokevirtual com/crashlytics/android/beta/CheckForUpdatesRequest.a ()Ljava/lang/String;
      // 19d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1a0: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1a3: aload 1
      // 1a4: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 1a9: aload 6
      // 1ab: astore 2
      // 1ac: aload 4
      // 1ae: ifnull 103
      // 1b1: aload 4
      // 1b3: ldc "X-REQUEST-ID"
      // 1b5: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.b (Ljava/lang/String;)Ljava/lang/String;
      // 1b8: astore 1
      // 1b9: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 1bc: ldc "Fabric"
      // 1be: new java/lang/StringBuilder
      // 1c1: dup
      // 1c2: invokespecial java/lang/StringBuilder.<init> ()V
      // 1c5: ldc "Checking for updates request ID: "
      // 1c7: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1ca: aload 1
      // 1cb: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1ce: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1d1: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 1d6: aload 6
      // 1d8: astore 2
      // 1d9: goto 103
      // 1dc: astore 1
      // 1dd: aconst_null
      // 1de: astore 3
      // 1df: aload 3
      // 1e0: ifnull 207
      // 1e3: aload 3
      // 1e4: ldc "X-REQUEST-ID"
      // 1e6: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.b (Ljava/lang/String;)Ljava/lang/String;
      // 1e9: astore 2
      // 1ea: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 1ed: ldc "Fabric"
      // 1ef: new java/lang/StringBuilder
      // 1f2: dup
      // 1f3: invokespecial java/lang/StringBuilder.<init> ()V
      // 1f6: ldc "Checking for updates request ID: "
      // 1f8: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1fb: aload 2
      // 1fc: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1ff: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 202: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 207: aload 1
      // 208: athrow
      // 209: astore 1
      // 20a: goto 1df
      // 20d: astore 1
      // 20e: goto 175
      // try (2 -> 10): 200 java/lang/Exception
      // try (2 -> 10): 250 null
      // try (14 -> 20): 274 java/lang/Exception
      // try (14 -> 20): 272 null
      // try (24 -> 26): 274 java/lang/Exception
      // try (24 -> 26): 272 null
      // try (30 -> 32): 274 java/lang/Exception
      // try (30 -> 32): 272 null
      // try (36 -> 38): 274 java/lang/Exception
      // try (36 -> 38): 272 null
      // try (42 -> 52): 274 java/lang/Exception
      // try (42 -> 52): 272 null
      // try (56 -> 58): 274 java/lang/Exception
      // try (56 -> 58): 272 null
      // try (62 -> 64): 274 java/lang/Exception
      // try (62 -> 64): 272 null
      // try (68 -> 70): 274 java/lang/Exception
      // try (68 -> 70): 272 null
      // try (74 -> 83): 274 java/lang/Exception
      // try (74 -> 83): 272 null
      // try (87 -> 90): 274 java/lang/Exception
      // try (87 -> 90): 272 null
      // try (94 -> 98): 274 java/lang/Exception
      // try (94 -> 98): 272 null
      // try (102 -> 104): 274 java/lang/Exception
      // try (102 -> 104): 272 null
      // try (108 -> 112): 274 java/lang/Exception
      // try (108 -> 112): 272 null
      // try (116 -> 121): 274 java/lang/Exception
      // try (116 -> 121): 272 null
      // try (150 -> 152): 274 java/lang/Exception
      // try (150 -> 152): 272 null
      // try (156 -> 158): 274 java/lang/Exception
      // try (156 -> 158): 272 null
      // try (162 -> 164): 274 java/lang/Exception
      // try (162 -> 164): 272 null
      // try (168 -> 178): 274 java/lang/Exception
      // try (168 -> 178): 272 null
      // try (205 -> 207): 272 null
      // try (209 -> 211): 272 null
      // try (213 -> 215): 272 null
      // try (217 -> 228): 272 null
   }
}
