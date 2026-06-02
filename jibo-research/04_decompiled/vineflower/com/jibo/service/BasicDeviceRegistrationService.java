package com.jibo.service;

import android.app.IntentService;
import android.content.Intent;
import com.jibo.aws.integration.aws.services.account.JiboAccountClient;

public abstract class BasicDeviceRegistrationService extends IntentService {
   private JiboAccountClient a;

   public BasicDeviceRegistrationService() {
      super("DeviceRegisterService");
   }

   protected abstract String a();

   protected abstract String b();

   protected void onHandleIntent(Intent param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: aload 0
      // 002: ldc 2131755063
      // 004: invokevirtual com/jibo/service/BasicDeviceRegistrationService.getString (I)Ljava/lang/String;
      // 007: bipush 0
      // 008: invokevirtual com/jibo/service/BasicDeviceRegistrationService.getSharedPreferences (Ljava/lang/String;I)Landroid/content/SharedPreferences;
      // 00b: astore 1
      // 00c: aload 0
      // 00d: invokestatic com/jibo/db/EntityData.a (Landroid/content/Context;)Lcom/jibo/db/EntityData;
      // 010: invokevirtual com/jibo/db/EntityData.i ()Lcom/jibo/aws/integration/aws/services/account/model/Account;
      // 013: astore 4
      // 015: aload 4
      // 017: ifnonnull 031
      // 01a: aload 0
      // 01b: getfield com/jibo/service/BasicDeviceRegistrationService.a Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;
      // 01e: ifnull 028
      // 021: aload 0
      // 022: getfield com/jibo/service/BasicDeviceRegistrationService.a Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;
      // 025: invokevirtual com/jibo/aws/integration/aws/services/account/JiboAccountClient.shutdown ()V
      // 028: return
      // 029: astore 1
      // 02a: aload 1
      // 02b: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 02e: goto 028
      // 031: aload 0
      // 032: invokevirtual com/jibo/service/BasicDeviceRegistrationService.a ()Ljava/lang/String;
      // 035: astore 3
      // 036: aload 0
      // 037: invokevirtual com/jibo/service/BasicDeviceRegistrationService.b ()Ljava/lang/String;
      // 03a: astore 2
      // 03b: new com/jibo/aws/integration/aws/services/account/JiboAccountClient
      // 03e: astore 5
      // 040: new com/jibo/service/BasicDeviceRegistrationService$1
      // 043: astore 6
      // 045: aload 6
      // 047: aload 0
      // 048: aload 4
      // 04a: invokespecial com/jibo/service/BasicDeviceRegistrationService$1.<init> (Lcom/jibo/service/BasicDeviceRegistrationService;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
      // 04d: aload 5
      // 04f: aload 6
      // 051: invokespecial com/jibo/aws/integration/aws/services/account/JiboAccountClient.<init> (Lcom/amazonaws/auth/AWSCredentials;)V
      // 054: aload 0
      // 055: aload 5
      // 057: putfield com/jibo/service/BasicDeviceRegistrationService.a Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;
      // 05a: aload 0
      // 05b: invokestatic com/jibo/db/EntityData.a (Landroid/content/Context;)Lcom/jibo/db/EntityData;
      // 05e: invokevirtual com/jibo/db/EntityData.f ()Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;
      // 061: astore 4
      // 063: new com/jibo/aws/integration/aws/services/common/model/Device
      // 066: astore 5
      // 068: aload 5
      // 06a: aload 2
      // 06b: aload 3
      // 06c: getstatic com/jibo/aws/integration/aws/services/common/model/Device$Type.android Lcom/jibo/aws/integration/aws/services/common/model/Device$Type;
      // 06f: invokespecial com/jibo/aws/integration/aws/services/common/model/Device.<init> (Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/common/model/Device$Type;)V
      // 072: aload 4
      // 074: aload 5
      // 076: invokevirtual com/jibo/aws/integration/aws/services/push/JiboPushAsyncClient.createDevice (Lcom/jibo/aws/integration/aws/services/common/model/Device;)Ljava/util/List;
      // 079: pop
      // 07a: aload 1
      // 07b: invokeinterface android/content/SharedPreferences.edit ()Landroid/content/SharedPreferences$Editor; 1
      // 080: ldc "PREF_PUSH_SERVICE_TOKEN"
      // 082: aload 3
      // 083: invokeinterface android/content/SharedPreferences$Editor.putString (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor; 3
      // 088: invokeinterface android/content/SharedPreferences$Editor.apply ()V 1
      // 08d: aload 1
      // 08e: invokeinterface android/content/SharedPreferences.edit ()Landroid/content/SharedPreferences$Editor; 1
      // 093: ldc "PREF_INSTANCE_ID"
      // 095: aload 2
      // 096: invokeinterface android/content/SharedPreferences$Editor.putString (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor; 3
      // 09b: invokeinterface android/content/SharedPreferences$Editor.apply ()V 1
      // 0a0: aload 0
      // 0a1: getfield com/jibo/service/BasicDeviceRegistrationService.a Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;
      // 0a4: ifnull 028
      // 0a7: aload 0
      // 0a8: getfield com/jibo/service/BasicDeviceRegistrationService.a Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;
      // 0ab: invokevirtual com/jibo/aws/integration/aws/services/account/JiboAccountClient.shutdown ()V
      // 0ae: goto 028
      // 0b1: astore 1
      // 0b2: aload 1
      // 0b3: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 0b6: goto 028
      // 0b9: astore 2
      // 0ba: aload 2
      // 0bb: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 0be: aload 1
      // 0bf: invokeinterface android/content/SharedPreferences.edit ()Landroid/content/SharedPreferences$Editor; 1
      // 0c4: ldc "PREF_PUSH_SERVICE_TOKEN"
      // 0c6: ldc ""
      // 0c8: invokeinterface android/content/SharedPreferences$Editor.putString (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor; 3
      // 0cd: invokeinterface android/content/SharedPreferences$Editor.apply ()V 1
      // 0d2: aload 1
      // 0d3: invokeinterface android/content/SharedPreferences.edit ()Landroid/content/SharedPreferences$Editor; 1
      // 0d8: ldc "PREF_INSTANCE_ID"
      // 0da: ldc ""
      // 0dc: invokeinterface android/content/SharedPreferences$Editor.putString (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor; 3
      // 0e1: invokeinterface android/content/SharedPreferences$Editor.apply ()V 1
      // 0e6: aload 0
      // 0e7: getfield com/jibo/service/BasicDeviceRegistrationService.a Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;
      // 0ea: ifnull 028
      // 0ed: aload 0
      // 0ee: getfield com/jibo/service/BasicDeviceRegistrationService.a Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;
      // 0f1: invokevirtual com/jibo/aws/integration/aws/services/account/JiboAccountClient.shutdown ()V
      // 0f4: goto 028
      // 0f7: astore 1
      // 0f8: aload 1
      // 0f9: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 0fc: goto 028
      // 0ff: astore 1
      // 100: aload 0
      // 101: getfield com/jibo/service/BasicDeviceRegistrationService.a Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;
      // 104: ifnull 10e
      // 107: aload 0
      // 108: getfield com/jibo/service/BasicDeviceRegistrationService.a Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;
      // 10b: invokevirtual com/jibo/aws/integration/aws/services/account/JiboAccountClient.shutdown ()V
      // 10e: aload 1
      // 10f: athrow
      // 110: astore 2
      // 111: aload 2
      // 112: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 115: goto 10e
      // try (7 -> 11): 82 java/lang/Exception
      // try (7 -> 11): 108 null
      // try (13 -> 19): 20 java/lang/Exception
      // try (24 -> 71): 82 java/lang/Exception
      // try (24 -> 71): 108 null
      // try (71 -> 77): 78 java/lang/Exception
      // try (83 -> 97): 108 null
      // try (97 -> 103): 104 java/lang/Exception
      // try (109 -> 115): 117 java/lang/Exception
   }
}
