package com.jibo.service;

import android.app.IntentService;
import android.content.Intent;
import com.jibo.aws.integration.aws.services.push.JiboPushAsyncClient;

public class DeviceUnRegistrationService extends IntentService {
   private static final String a = DeviceUnRegistrationService.class.getSimpleName();
   private JiboPushAsyncClient b;

   public DeviceUnRegistrationService() {
      super(a);
   }

   protected void onHandleIntent(Intent param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: aload 0
      // 02: ldc 2131755063
      // 04: invokevirtual com/jibo/service/DeviceUnRegistrationService.getString (I)Ljava/lang/String;
      // 07: bipush 0
      // 08: invokevirtual com/jibo/service/DeviceUnRegistrationService.getSharedPreferences (Ljava/lang/String;I)Landroid/content/SharedPreferences;
      // 0b: astore 2
      // 0c: aload 2
      // 0d: ldc "PREF_INSTANCE_ID"
      // 0f: aconst_null
      // 10: invokeinterface android/content/SharedPreferences.getString (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 3
      // 15: astore 2
      // 16: aload 0
      // 17: invokestatic com/jibo/utils/SharedPreferencesUtil.b (Landroid/content/Context;)V
      // 1a: aload 1
      // 1b: ldc com/jibo/aws/integration/aws/services/account/model/Account
      // 1d: invokevirtual java/lang/Class.getSimpleName ()Ljava/lang/String;
      // 20: invokevirtual android/content/Intent.getSerializableExtra (Ljava/lang/String;)Ljava/io/Serializable;
      // 23: checkcast com/jibo/aws/integration/aws/services/account/model/Account
      // 26: astore 4
      // 28: aload 4
      // 2a: ifnonnull 44
      // 2d: aload 0
      // 2e: getfield com/jibo/service/DeviceUnRegistrationService.b Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;
      // 31: ifnull 3b
      // 34: aload 0
      // 35: getfield com/jibo/service/DeviceUnRegistrationService.b Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;
      // 38: invokevirtual com/jibo/aws/integration/aws/services/push/JiboPushAsyncClient.shutdown ()V
      // 3b: return
      // 3c: astore 1
      // 3d: aload 1
      // 3e: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 41: goto 3b
      // 44: aload 0
      // 45: aload 4
      // 47: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getId ()Ljava/lang/String;
      // 4a: invokestatic com/jibo/aws/integration/util/KeyManager.getInstance (Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;
      // 4d: aload 0
      // 4e: invokevirtual com/jibo/aws/integration/util/KeyManager.logout (Landroid/content/Context;)V
      // 51: aload 2
      // 52: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 55: ifne 7a
      // 58: new com/jibo/aws/integration/aws/services/push/JiboPushAsyncClient
      // 5b: astore 3
      // 5c: new com/jibo/service/DeviceUnRegistrationService$1
      // 5f: astore 1
      // 60: aload 1
      // 61: aload 0
      // 62: aload 4
      // 64: invokespecial com/jibo/service/DeviceUnRegistrationService$1.<init> (Lcom/jibo/service/DeviceUnRegistrationService;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
      // 67: aload 3
      // 68: aload 1
      // 69: invokespecial com/jibo/aws/integration/aws/services/push/JiboPushAsyncClient.<init> (Lcom/amazonaws/auth/AWSCredentials;)V
      // 6c: aload 0
      // 6d: aload 3
      // 6e: putfield com/jibo/service/DeviceUnRegistrationService.b Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;
      // 71: aload 0
      // 72: getfield com/jibo/service/DeviceUnRegistrationService.b Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;
      // 75: aload 2
      // 76: invokevirtual com/jibo/aws/integration/aws/services/push/JiboPushAsyncClient.removeDevice (Ljava/lang/String;)Ljava/util/List;
      // 79: pop
      // 7a: aload 0
      // 7b: getfield com/jibo/service/DeviceUnRegistrationService.b Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;
      // 7e: ifnull 3b
      // 81: aload 0
      // 82: getfield com/jibo/service/DeviceUnRegistrationService.b Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;
      // 85: invokevirtual com/jibo/aws/integration/aws/services/push/JiboPushAsyncClient.shutdown ()V
      // 88: goto 3b
      // 8b: astore 1
      // 8c: aload 1
      // 8d: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 90: goto 3b
      // 93: astore 1
      // 94: aload 1
      // 95: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 98: aload 0
      // 99: getfield com/jibo/service/DeviceUnRegistrationService.b Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;
      // 9c: ifnull 3b
      // 9f: aload 0
      // a0: getfield com/jibo/service/DeviceUnRegistrationService.b Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;
      // a3: invokevirtual com/jibo/aws/integration/aws/services/push/JiboPushAsyncClient.shutdown ()V
      // a6: goto 3b
      // a9: astore 1
      // aa: aload 1
      // ab: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // ae: goto 3b
      // b1: astore 1
      // b2: aload 0
      // b3: getfield com/jibo/service/DeviceUnRegistrationService.b Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;
      // b6: ifnull c0
      // b9: aload 0
      // ba: getfield com/jibo/service/DeviceUnRegistrationService.b Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;
      // bd: invokevirtual com/jibo/aws/integration/aws/services/push/JiboPushAsyncClient.shutdown ()V
      // c0: aload 1
      // c1: athrow
      // c2: astore 2
      // c3: aload 2
      // c4: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // c7: goto c0
      // try (7 -> 20): 72 java/lang/Exception
      // try (7 -> 20): 86 null
      // try (22 -> 28): 29 java/lang/Exception
      // try (33 -> 61): 72 java/lang/Exception
      // try (33 -> 61): 86 null
      // try (61 -> 67): 68 java/lang/Exception
      // try (73 -> 75): 86 null
      // try (75 -> 81): 82 java/lang/Exception
      // try (87 -> 93): 95 java/lang/Exception
   }
}
