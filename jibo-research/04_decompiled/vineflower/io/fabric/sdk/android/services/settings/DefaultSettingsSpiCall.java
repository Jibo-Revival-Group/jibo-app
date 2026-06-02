package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class DefaultSettingsSpiCall extends AbstractSpiCall implements SettingsSpiCall {
   public DefaultSettingsSpiCall(Kit var1, String var2, String var3, HttpRequestFactory var4) {
      this(var1, var2, var3, var4, HttpMethod.GET);
   }

   DefaultSettingsSpiCall(Kit var1, String var2, String var3, HttpRequestFactory var4, HttpMethod var5) {
      super(var1, var2, var3, var4, var5);
   }

   private HttpRequest a(HttpRequest var1, SettingsRequest var2) {
      this.a(var1, "X-CRASHLYTICS-API-KEY", var2.a);
      this.a(var1, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
      this.a(var1, "X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a());
      this.a(var1, "Accept", "application/json");
      this.a(var1, "X-CRASHLYTICS-DEVICE-MODEL", var2.b);
      this.a(var1, "X-CRASHLYTICS-OS-BUILD-VERSION", var2.c);
      this.a(var1, "X-CRASHLYTICS-OS-DISPLAY-VERSION", var2.d);
      this.a(var1, "X-CRASHLYTICS-ADVERTISING-TOKEN", var2.e);
      this.a(var1, "X-CRASHLYTICS-INSTALLATION-ID", var2.f);
      this.a(var1, "X-CRASHLYTICS-ANDROID-ID", var2.g);
      return var1;
   }

   private JSONObject a(String var1) {
      JSONObject var2;
      try {
         var2 = new JSONObject(var1);
      } catch (Exception var3) {
         Fabric.h().a("Fabric", "Failed to parse settings JSON from " + this.a(), var3);
         Fabric.h().a("Fabric", "Settings response " + var1);
         return null;
      }

      return var2;
   }

   private void a(HttpRequest var1, String var2, String var3) {
      if (var3 != null) {
         var1.a(var2, var3);
      }
   }

   private Map<String, String> b(SettingsRequest var1) {
      HashMap var2 = new HashMap();
      var2.put("build_version", var1.j);
      var2.put("display_version", var1.i);
      var2.put("source", Integer.toString(var1.k));
      if (var1.l != null) {
         var2.put("icon_hash", var1.l);
      }

      String var3 = var1.h;
      if (!CommonUtils.c(var3)) {
         var2.put("instance", var3);
      }

      return var2;
   }

   JSONObject a(HttpRequest var1) {
      int var2 = var1.b();
      Fabric.h().a("Fabric", "Settings result was: " + var2);
      JSONObject var3;
      if (this.a(var2)) {
         var3 = this.a(var1.e());
      } else {
         Fabric.h().e("Fabric", "Failed to retrieve settings from " + this.a());
         var3 = null;
      }

      return var3;
   }

   @Override
   public JSONObject a(SettingsRequest param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 5
      // 003: aload 0
      // 004: aload 1
      // 005: invokespecial io/fabric/sdk/android/services/settings/DefaultSettingsSpiCall.b (Lio/fabric/sdk/android/services/settings/SettingsRequest;)Ljava/util/Map;
      // 008: astore 6
      // 00a: aload 0
      // 00b: aload 6
      // 00d: invokevirtual io/fabric/sdk/android/services/settings/DefaultSettingsSpiCall.a (Ljava/util/Map;)Lio/fabric/sdk/android/services/network/HttpRequest;
      // 010: astore 4
      // 012: aload 4
      // 014: astore 2
      // 015: aload 4
      // 017: astore 3
      // 018: aload 0
      // 019: aload 4
      // 01b: aload 1
      // 01c: invokespecial io/fabric/sdk/android/services/settings/DefaultSettingsSpiCall.a (Lio/fabric/sdk/android/services/network/HttpRequest;Lio/fabric/sdk/android/services/settings/SettingsRequest;)Lio/fabric/sdk/android/services/network/HttpRequest;
      // 01f: astore 1
      // 020: aload 1
      // 021: astore 2
      // 022: aload 1
      // 023: astore 3
      // 024: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 027: astore 7
      // 029: aload 1
      // 02a: astore 2
      // 02b: aload 1
      // 02c: astore 3
      // 02d: new java/lang/StringBuilder
      // 030: astore 4
      // 032: aload 1
      // 033: astore 2
      // 034: aload 1
      // 035: astore 3
      // 036: aload 4
      // 038: invokespecial java/lang/StringBuilder.<init> ()V
      // 03b: aload 1
      // 03c: astore 2
      // 03d: aload 1
      // 03e: astore 3
      // 03f: aload 7
      // 041: ldc "Fabric"
      // 043: aload 4
      // 045: ldc "Requesting settings from "
      // 047: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 04a: aload 0
      // 04b: invokevirtual io/fabric/sdk/android/services/settings/DefaultSettingsSpiCall.a ()Ljava/lang/String;
      // 04e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 051: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 054: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 059: aload 1
      // 05a: astore 2
      // 05b: aload 1
      // 05c: astore 3
      // 05d: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 060: astore 4
      // 062: aload 1
      // 063: astore 2
      // 064: aload 1
      // 065: astore 3
      // 066: new java/lang/StringBuilder
      // 069: astore 7
      // 06b: aload 1
      // 06c: astore 2
      // 06d: aload 1
      // 06e: astore 3
      // 06f: aload 7
      // 071: invokespecial java/lang/StringBuilder.<init> ()V
      // 074: aload 1
      // 075: astore 2
      // 076: aload 1
      // 077: astore 3
      // 078: aload 4
      // 07a: ldc "Fabric"
      // 07c: aload 7
      // 07e: ldc "Settings query params were: "
      // 080: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 083: aload 6
      // 085: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 088: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 08b: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 090: aload 1
      // 091: astore 2
      // 092: aload 1
      // 093: astore 3
      // 094: aload 0
      // 095: aload 1
      // 096: invokevirtual io/fabric/sdk/android/services/settings/DefaultSettingsSpiCall.a (Lio/fabric/sdk/android/services/network/HttpRequest;)Lorg/json/JSONObject;
      // 099: astore 4
      // 09b: aload 4
      // 09d: astore 3
      // 09e: aload 3
      // 09f: astore 2
      // 0a0: aload 1
      // 0a1: ifnull 0c8
      // 0a4: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 0a7: ldc "Fabric"
      // 0a9: new java/lang/StringBuilder
      // 0ac: dup
      // 0ad: invokespecial java/lang/StringBuilder.<init> ()V
      // 0b0: ldc "Settings request ID: "
      // 0b2: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0b5: aload 1
      // 0b6: ldc "X-REQUEST-ID"
      // 0b8: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.b (Ljava/lang/String;)Ljava/lang/String;
      // 0bb: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0be: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0c1: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 0c6: aload 3
      // 0c7: astore 2
      // 0c8: aload 2
      // 0c9: areturn
      // 0ca: astore 1
      // 0cb: aconst_null
      // 0cc: astore 3
      // 0cd: aload 3
      // 0ce: astore 2
      // 0cf: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 0d2: ldc "Fabric"
      // 0d4: ldc "Settings request failed."
      // 0d6: aload 1
      // 0d7: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 0dc: aload 5
      // 0de: astore 2
      // 0df: aload 3
      // 0e0: ifnull 0c8
      // 0e3: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 0e6: ldc "Fabric"
      // 0e8: new java/lang/StringBuilder
      // 0eb: dup
      // 0ec: invokespecial java/lang/StringBuilder.<init> ()V
      // 0ef: ldc "Settings request ID: "
      // 0f1: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0f4: aload 3
      // 0f5: ldc "X-REQUEST-ID"
      // 0f7: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.b (Ljava/lang/String;)Ljava/lang/String;
      // 0fa: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0fd: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 100: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 105: aload 5
      // 107: astore 2
      // 108: goto 0c8
      // 10b: astore 1
      // 10c: aconst_null
      // 10d: astore 2
      // 10e: aload 2
      // 10f: ifnull 134
      // 112: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 115: ldc "Fabric"
      // 117: new java/lang/StringBuilder
      // 11a: dup
      // 11b: invokespecial java/lang/StringBuilder.<init> ()V
      // 11e: ldc "Settings request ID: "
      // 120: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 123: aload 2
      // 124: ldc "X-REQUEST-ID"
      // 126: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.b (Ljava/lang/String;)Ljava/lang/String;
      // 129: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 12c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 12f: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 134: aload 1
      // 135: athrow
      // 136: astore 1
      // 137: goto 10e
      // 13a: astore 1
      // 13b: goto 0cd
      // try (2 -> 10): 113 io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
      // try (2 -> 10): 143 null
      // try (14 -> 19): 165 io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
      // try (14 -> 19): 163 null
      // try (23 -> 25): 165 io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
      // try (23 -> 25): 163 null
      // try (29 -> 31): 165 io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
      // try (29 -> 31): 163 null
      // try (35 -> 37): 165 io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
      // try (35 -> 37): 163 null
      // try (41 -> 51): 165 io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
      // try (41 -> 51): 163 null
      // try (55 -> 57): 165 io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
      // try (55 -> 57): 163 null
      // try (61 -> 63): 165 io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
      // try (61 -> 63): 163 null
      // try (67 -> 69): 165 io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
      // try (67 -> 69): 163 null
      // try (73 -> 82): 165 io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
      // try (73 -> 82): 163 null
      // try (86 -> 90): 165 io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
      // try (86 -> 90): 163 null
      // try (118 -> 123): 163 null
   }

   boolean a(int var1) {
      boolean var2;
      if (var1 != 200 && var1 != 201 && var1 != 202 && var1 != 203) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }
}
