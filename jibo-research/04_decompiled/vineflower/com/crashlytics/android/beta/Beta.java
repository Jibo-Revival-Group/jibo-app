package com.crashlytics.android.beta;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.cache.MemoryValueCache;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeviceIdentifierProvider;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.SystemCurrentTimeProvider;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import io.fabric.sdk.android.services.settings.BetaSettingsData;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.util.HashMap;
import java.util.Map;

public class Beta extends Kit<Boolean> implements DeviceIdentifierProvider {
   private final MemoryValueCache<String> a = new MemoryValueCache<>();
   private final DeviceTokenLoader b = new DeviceTokenLoader();
   private UpdatesController c;

   private BuildProperties a(Context param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 1
      // 01: invokevirtual android/content/Context.getAssets ()Landroid/content/res/AssetManager;
      // 04: ldc "crashlytics-build.properties"
      // 06: invokevirtual android/content/res/AssetManager.open (Ljava/lang/String;)Ljava/io/InputStream;
      // 09: astore 2
      // 0a: aload 2
      // 0b: ifnull ec
      // 0e: aload 2
      // 0f: astore 3
      // 10: aload 2
      // 11: invokestatic com/crashlytics/android/beta/BuildProperties.a (Ljava/io/InputStream;)Lcom/crashlytics/android/beta/BuildProperties;
      // 14: astore 1
      // 15: aload 2
      // 16: astore 3
      // 17: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 1a: astore 4
      // 1c: aload 2
      // 1d: astore 3
      // 1e: new java/lang/StringBuilder
      // 21: astore 5
      // 23: aload 2
      // 24: astore 3
      // 25: aload 5
      // 27: invokespecial java/lang/StringBuilder.<init> ()V
      // 2a: aload 2
      // 2b: astore 3
      // 2c: aload 4
      // 2e: ldc "Beta"
      // 30: aload 5
      // 32: aload 1
      // 33: getfield com/crashlytics/android/beta/BuildProperties.d Ljava/lang/String;
      // 36: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 39: ldc " build properties: "
      // 3b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3e: aload 1
      // 3f: getfield com/crashlytics/android/beta/BuildProperties.b Ljava/lang/String;
      // 42: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 45: ldc " ("
      // 47: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 4a: aload 1
      // 4b: getfield com/crashlytics/android/beta/BuildProperties.a Ljava/lang/String;
      // 4e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 51: ldc ") - "
      // 53: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 56: aload 1
      // 57: getfield com/crashlytics/android/beta/BuildProperties.c Ljava/lang/String;
      // 5a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 5d: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 60: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 65: aload 1
      // 66: astore 3
      // 67: aload 2
      // 68: ifnull 71
      // 6b: aload 2
      // 6c: invokevirtual java/io/InputStream.close ()V
      // 6f: aload 1
      // 70: astore 3
      // 71: aload 3
      // 72: areturn
      // 73: astore 2
      // 74: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 77: ldc "Beta"
      // 79: ldc "Error closing Beta build properties asset"
      // 7b: aload 2
      // 7c: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 81: aload 1
      // 82: astore 3
      // 83: goto 71
      // 86: astore 4
      // 88: aconst_null
      // 89: astore 2
      // 8a: aconst_null
      // 8b: astore 1
      // 8c: aload 2
      // 8d: astore 3
      // 8e: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 91: ldc "Beta"
      // 93: ldc "Error reading Beta build properties"
      // 95: aload 4
      // 97: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 9c: aload 1
      // 9d: astore 3
      // 9e: aload 2
      // 9f: ifnull 71
      // a2: aload 2
      // a3: invokevirtual java/io/InputStream.close ()V
      // a6: aload 1
      // a7: astore 3
      // a8: goto 71
      // ab: astore 2
      // ac: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // af: ldc "Beta"
      // b1: ldc "Error closing Beta build properties asset"
      // b3: aload 2
      // b4: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // b9: aload 1
      // ba: astore 3
      // bb: goto 71
      // be: astore 1
      // bf: aconst_null
      // c0: astore 3
      // c1: aload 3
      // c2: ifnull c9
      // c5: aload 3
      // c6: invokevirtual java/io/InputStream.close ()V
      // c9: aload 1
      // ca: athrow
      // cb: astore 2
      // cc: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // cf: ldc "Beta"
      // d1: ldc "Error closing Beta build properties asset"
      // d3: aload 2
      // d4: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // d9: goto c9
      // dc: astore 1
      // dd: goto c1
      // e0: astore 4
      // e2: aconst_null
      // e3: astore 1
      // e4: goto 8c
      // e7: astore 4
      // e9: goto 8c
      // ec: aconst_null
      // ed: astore 1
      // ee: goto 65
      // try (0 -> 5): 68 java/lang/Exception
      // try (0 -> 5): 98 null
      // try (9 -> 12): 116 java/lang/Exception
      // try (9 -> 12): 114 null
      // try (14 -> 16): 120 java/lang/Exception
      // try (14 -> 16): 114 null
      // try (18 -> 20): 120 java/lang/Exception
      // try (18 -> 20): 114 null
      // try (22 -> 24): 120 java/lang/Exception
      // try (22 -> 24): 114 null
      // try (26 -> 49): 120 java/lang/Exception
      // try (26 -> 49): 114 null
      // try (53 -> 55): 59 java/io/IOException
      // try (75 -> 80): 114 null
      // try (84 -> 86): 89 java/io/IOException
      // try (103 -> 105): 107 java/io/IOException
   }

   private String a(Context var1, String var2) {
      label19: {
         boolean var3;
         try {
            var6 = this.a.a(var1, this.b);
            var3 = "".equals(var6);
         } catch (Exception var5) {
            Fabric.h().e("Beta", "Failed to load the Beta device token", var5);
            var6 = null;
            break label19;
         }

         if (var3) {
            var6 = null;
         }
      }

      Logger var4 = Fabric.h();
      StringBuilder var7 = new StringBuilder().append("Beta device token present: ");
      boolean var8;
      if (!TextUtils.isEmpty(var6)) {
         var8 = true;
      } else {
         var8 = false;
      }

      var4.a("Beta", var7.append(var8).toString());
      return var6;
   }

   private BetaSettingsData h() {
      SettingsData var1 = Settings.a().b();
      BetaSettingsData var2;
      if (var1 != null) {
         var2 = var1.f;
      } else {
         var2 = null;
      }

      return var2;
   }

   @TargetApi(14)
   UpdatesController a(int var1, Application var2) {
      AbstractCheckForUpdatesController var3;
      if (var1 >= 14) {
         var3 = new ActivityLifecycleCheckForUpdatesController(this.s().e(), this.s().f());
      } else {
         var3 = new ImmediateCheckForUpdatesController();
      }

      return var3;
   }

   @Override
   public String a() {
      return "1.2.5.dev";
   }

   boolean a(BetaSettingsData var1, BuildProperties var2) {
      boolean var3;
      if (var1 != null && !TextUtils.isEmpty(var1.a) && var2 != null) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   @TargetApi(14)
   @Override
   protected boolean a_() {
      Application var1 = (Application)this.r().getApplicationContext();
      this.c = this.a(VERSION.SDK_INT, var1);
      return true;
   }

   @Override
   public String b() {
      return "com.crashlytics.sdk.android:beta";
   }

   protected Boolean d() {
      Fabric.h().a("Beta", "Beta kit initializing...");
      Context var2 = this.r();
      IdManager var3 = this.q();
      Boolean var1;
      if (TextUtils.isEmpty(this.a(var2, var3.j()))) {
         Fabric.h().a("Beta", "A Beta device token was not found for this app");
         var1 = false;
      } else {
         Fabric.h().a("Beta", "Beta device token is present, checking for app updates.");
         BetaSettingsData var4 = this.h();
         BuildProperties var5 = this.a(var2);
         if (this.a(var4, var5)) {
            this.c.a(var2, this, var3, var4, var5, new PreferenceStoreImpl(this), new SystemCurrentTimeProvider(), new DefaultHttpRequestFactory(Fabric.h()));
         }

         var1 = true;
      }

      return var1;
   }

   @Override
   public Map<IdManager.DeviceIdentifierType, String> e() {
      String var1 = this.q().j();
      var1 = this.a(this.r(), var1);
      HashMap var2 = new HashMap();
      if (!TextUtils.isEmpty(var1)) {
         var2.put(IdManager.DeviceIdentifierType.FONT_TOKEN, var1);
      }

      return var2;
   }

   String g() {
      return CommonUtils.b(this.r(), "com.crashlytics.ApiEndpoint");
   }
}
