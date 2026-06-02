package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.KitInfo;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.ResponseParser;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.Locale;

abstract class AbstractAppSpiCall extends AbstractSpiCall {
   public AbstractAppSpiCall(Kit var1, String var2, String var3, HttpRequestFactory var4, HttpMethod var5) {
      super(var1, var2, var3, var4, var5);
   }

   private HttpRequest a(HttpRequest var1, AppRequestData var2) {
      return var1.a("X-CRASHLYTICS-API-KEY", var2.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a());
   }

   private HttpRequest b(HttpRequest param1, AppRequestData param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 1
      // 001: ldc "app[identifier]"
      // 003: aload 2
      // 004: getfield io/fabric/sdk/android/services/settings/AppRequestData.b Ljava/lang/String;
      // 007: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.e (Ljava/lang/String;Ljava/lang/String;)Lio/fabric/sdk/android/services/network/HttpRequest;
      // 00a: ldc "app[name]"
      // 00c: aload 2
      // 00d: getfield io/fabric/sdk/android/services/settings/AppRequestData.f Ljava/lang/String;
      // 010: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.e (Ljava/lang/String;Ljava/lang/String;)Lio/fabric/sdk/android/services/network/HttpRequest;
      // 013: ldc "app[display_version]"
      // 015: aload 2
      // 016: getfield io/fabric/sdk/android/services/settings/AppRequestData.c Ljava/lang/String;
      // 019: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.e (Ljava/lang/String;Ljava/lang/String;)Lio/fabric/sdk/android/services/network/HttpRequest;
      // 01c: ldc "app[build_version]"
      // 01e: aload 2
      // 01f: getfield io/fabric/sdk/android/services/settings/AppRequestData.d Ljava/lang/String;
      // 022: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.e (Ljava/lang/String;Ljava/lang/String;)Lio/fabric/sdk/android/services/network/HttpRequest;
      // 025: ldc "app[source]"
      // 027: aload 2
      // 028: getfield io/fabric/sdk/android/services/settings/AppRequestData.g I
      // 02b: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 02e: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.a (Ljava/lang/String;Ljava/lang/Number;)Lio/fabric/sdk/android/services/network/HttpRequest;
      // 031: ldc "app[minimum_sdk_version]"
      // 033: aload 2
      // 034: getfield io/fabric/sdk/android/services/settings/AppRequestData.h Ljava/lang/String;
      // 037: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.e (Ljava/lang/String;Ljava/lang/String;)Lio/fabric/sdk/android/services/network/HttpRequest;
      // 03a: ldc "app[built_sdk_version]"
      // 03c: aload 2
      // 03d: getfield io/fabric/sdk/android/services/settings/AppRequestData.i Ljava/lang/String;
      // 040: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.e (Ljava/lang/String;Ljava/lang/String;)Lio/fabric/sdk/android/services/network/HttpRequest;
      // 043: astore 5
      // 045: aload 2
      // 046: getfield io/fabric/sdk/android/services/settings/AppRequestData.e Ljava/lang/String;
      // 049: invokestatic io/fabric/sdk/android/services/common/CommonUtils.c (Ljava/lang/String;)Z
      // 04c: ifne 05b
      // 04f: aload 5
      // 051: ldc "app[instance_identifier]"
      // 053: aload 2
      // 054: getfield io/fabric/sdk/android/services/settings/AppRequestData.e Ljava/lang/String;
      // 057: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.e (Ljava/lang/String;Ljava/lang/String;)Lio/fabric/sdk/android/services/network/HttpRequest;
      // 05a: pop
      // 05b: aload 2
      // 05c: getfield io/fabric/sdk/android/services/settings/AppRequestData.j Lio/fabric/sdk/android/services/settings/IconRequest;
      // 05f: ifnull 0c1
      // 062: aconst_null
      // 063: astore 1
      // 064: aconst_null
      // 065: astore 3
      // 066: aload 0
      // 067: getfield io/fabric/sdk/android/services/settings/AbstractAppSpiCall.a Lio/fabric/sdk/android/Kit;
      // 06a: invokevirtual io/fabric/sdk/android/Kit.r ()Landroid/content/Context;
      // 06d: invokevirtual android/content/Context.getResources ()Landroid/content/res/Resources;
      // 070: aload 2
      // 071: getfield io/fabric/sdk/android/services/settings/AppRequestData.j Lio/fabric/sdk/android/services/settings/IconRequest;
      // 074: getfield io/fabric/sdk/android/services/settings/IconRequest.b I
      // 077: invokevirtual android/content/res/Resources.openRawResource (I)Ljava/io/InputStream;
      // 07a: astore 4
      // 07c: aload 4
      // 07e: astore 3
      // 07f: aload 4
      // 081: astore 1
      // 082: aload 5
      // 084: ldc "app[icon][hash]"
      // 086: aload 2
      // 087: getfield io/fabric/sdk/android/services/settings/AppRequestData.j Lio/fabric/sdk/android/services/settings/IconRequest;
      // 08a: getfield io/fabric/sdk/android/services/settings/IconRequest.a Ljava/lang/String;
      // 08d: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.e (Ljava/lang/String;Ljava/lang/String;)Lio/fabric/sdk/android/services/network/HttpRequest;
      // 090: ldc "app[icon][data]"
      // 092: ldc "icon.png"
      // 094: ldc "application/octet-stream"
      // 096: aload 4
      // 098: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)Lio/fabric/sdk/android/services/network/HttpRequest;
      // 09b: ldc "app[icon][width]"
      // 09d: aload 2
      // 09e: getfield io/fabric/sdk/android/services/settings/AppRequestData.j Lio/fabric/sdk/android/services/settings/IconRequest;
      // 0a1: getfield io/fabric/sdk/android/services/settings/IconRequest.c I
      // 0a4: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 0a7: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.a (Ljava/lang/String;Ljava/lang/Number;)Lio/fabric/sdk/android/services/network/HttpRequest;
      // 0aa: ldc "app[icon][height]"
      // 0ac: aload 2
      // 0ad: getfield io/fabric/sdk/android/services/settings/AppRequestData.j Lio/fabric/sdk/android/services/settings/IconRequest;
      // 0b0: getfield io/fabric/sdk/android/services/settings/IconRequest.d I
      // 0b3: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 0b6: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.a (Ljava/lang/String;Ljava/lang/Number;)Lio/fabric/sdk/android/services/network/HttpRequest;
      // 0b9: pop
      // 0ba: aload 4
      // 0bc: ldc "Failed to close app icon InputStream."
      // 0be: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 0c1: aload 2
      // 0c2: getfield io/fabric/sdk/android/services/settings/AppRequestData.k Ljava/util/Collection;
      // 0c5: ifnull 150
      // 0c8: aload 2
      // 0c9: getfield io/fabric/sdk/android/services/settings/AppRequestData.k Ljava/util/Collection;
      // 0cc: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 0d1: astore 2
      // 0d2: aload 2
      // 0d3: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0d8: ifeq 150
      // 0db: aload 2
      // 0dc: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0e1: checkcast io/fabric/sdk/android/KitInfo
      // 0e4: astore 1
      // 0e5: aload 5
      // 0e7: aload 0
      // 0e8: aload 1
      // 0e9: invokevirtual io/fabric/sdk/android/services/settings/AbstractAppSpiCall.a (Lio/fabric/sdk/android/KitInfo;)Ljava/lang/String;
      // 0ec: aload 1
      // 0ed: invokevirtual io/fabric/sdk/android/KitInfo.b ()Ljava/lang/String;
      // 0f0: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.e (Ljava/lang/String;Ljava/lang/String;)Lio/fabric/sdk/android/services/network/HttpRequest;
      // 0f3: pop
      // 0f4: aload 5
      // 0f6: aload 0
      // 0f7: aload 1
      // 0f8: invokevirtual io/fabric/sdk/android/services/settings/AbstractAppSpiCall.b (Lio/fabric/sdk/android/KitInfo;)Ljava/lang/String;
      // 0fb: aload 1
      // 0fc: invokevirtual io/fabric/sdk/android/KitInfo.c ()Ljava/lang/String;
      // 0ff: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.e (Ljava/lang/String;Ljava/lang/String;)Lio/fabric/sdk/android/services/network/HttpRequest;
      // 102: pop
      // 103: goto 0d2
      // 106: astore 7
      // 108: aload 3
      // 109: astore 1
      // 10a: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 10d: astore 6
      // 10f: aload 3
      // 110: astore 1
      // 111: new java/lang/StringBuilder
      // 114: astore 4
      // 116: aload 3
      // 117: astore 1
      // 118: aload 4
      // 11a: invokespecial java/lang/StringBuilder.<init> ()V
      // 11d: aload 3
      // 11e: astore 1
      // 11f: aload 6
      // 121: ldc "Fabric"
      // 123: aload 4
      // 125: ldc "Failed to find app icon with resource ID: "
      // 127: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 12a: aload 2
      // 12b: getfield io/fabric/sdk/android/services/settings/AppRequestData.j Lio/fabric/sdk/android/services/settings/IconRequest;
      // 12e: getfield io/fabric/sdk/android/services/settings/IconRequest.b I
      // 131: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 134: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 137: aload 7
      // 139: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 13e: aload 3
      // 13f: ldc "Failed to close app icon InputStream."
      // 141: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 144: goto 0c1
      // 147: astore 2
      // 148: aload 1
      // 149: ldc "Failed to close app icon InputStream."
      // 14b: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 14e: aload 2
      // 14f: athrow
      // 150: aload 5
      // 152: areturn
      // try (48 -> 57): 119 android/content/res/Resources$NotFoundException
      // try (48 -> 57): 150 null
      // try (61 -> 85): 119 android/content/res/Resources$NotFoundException
      // try (61 -> 85): 150 null
      // try (122 -> 124): 150 null
      // try (126 -> 128): 150 null
      // try (130 -> 132): 150 null
      // try (134 -> 146): 150 null
   }

   String a(KitInfo var1) {
      return String.format(Locale.US, "app[build][libraries][%s][version]", var1.a());
   }

   public boolean a(AppRequestData var1) {
      HttpRequest var4 = this.b(this.a(this.b(), var1), var1);
      Fabric.h().a("Fabric", "Sending app info to " + this.a());
      if (var1.j != null) {
         Fabric.h().a("Fabric", "App icon hash is " + var1.j.a);
         Fabric.h().a("Fabric", "App icon size is " + var1.j.c + "x" + var1.j.d);
      }

      int var2 = var4.b();
      String var5;
      if ("POST".equals(var4.p())) {
         var5 = "Create";
      } else {
         var5 = "Update";
      }

      Fabric.h().a("Fabric", var5 + " app request ID: " + var4.b("X-REQUEST-ID"));
      Fabric.h().a("Fabric", "Result was " + var2);
      boolean var3;
      if (ResponseParser.a(var2) == 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   String b(KitInfo var1) {
      return String.format(Locale.US, "app[build][libraries][%s][type]", var1.a());
   }
}
