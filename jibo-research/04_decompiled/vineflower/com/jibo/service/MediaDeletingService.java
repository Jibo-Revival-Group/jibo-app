package com.jibo.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.jibo.aws.integration.aws.services.media.JiboMediaClient;
import com.jibo.aws.integration.aws.services.media.model.Media;
import com.jibo.utils.ServiceUtils;

public class MediaDeletingService extends IntentService {
   public static final String a = MediaDeletingService.class.getSimpleName();
   private JiboMediaClient b = null;

   public MediaDeletingService() {
      super(a);
   }

   public static void a(Context var0, Media var1) {
      if (var1 != null) {
         Intent var2 = new Intent(var0, MediaDeletingService.class);
         var2.putExtra("EXTRA_IDS", new String[]{var1.getPath()});
         var2.putExtra("EXTRA_FROM_OUTSIDE", false);
         ServiceUtils.a(var0, var2);
      }
   }

   public static void a(Context var0, String[] var1, boolean var2) {
      if (var1 != null && var1.length != 0) {
         Intent var3 = new Intent(var0, MediaDeletingService.class);
         var3.putExtra("EXTRA_IDS", var1);
         var3.putExtra("EXTRA_FROM_OUTSIDE", var2);
         ServiceUtils.a(var0, var3);
      }
   }

   public void onCreate() {
      super.onCreate();
      ServiceUtils.a(this);
   }

   public void onDestroy() {
      super.onDestroy();
      ServiceUtils.b(this);
   }

   protected void onHandleIntent(Intent param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 1
      // 001: ldc "EXTRA_IDS"
      // 003: invokevirtual android/content/Intent.getStringArrayExtra (Ljava/lang/String;)[Ljava/lang/String;
      // 006: astore 7
      // 008: aload 1
      // 009: ldc "EXTRA_FROM_OUTSIDE"
      // 00b: bipush 0
      // 00c: invokevirtual android/content/Intent.getBooleanExtra (Ljava/lang/String;Z)Z
      // 00f: istore 3
      // 010: aload 7
      // 012: ifnull 01b
      // 015: aload 7
      // 017: arraylength
      // 018: ifne 01c
      // 01b: return
      // 01c: getstatic com/jibo/service/MediaDeletingService.a Ljava/lang/String;
      // 01f: ldc "onHandleIntent-start"
      // 021: invokestatic com/jibo/utils/LogUtils.a (Ljava/lang/String;Ljava/lang/String;)V
      // 024: new java/util/ArrayList
      // 027: dup
      // 028: invokespecial java/util/ArrayList.<init> ()V
      // 02b: astore 6
      // 02d: aload 0
      // 02e: invokestatic com/jibo/db/EntityData.a (Landroid/content/Context;)Lcom/jibo/db/EntityData;
      // 031: invokevirtual com/jibo/db/EntityData.i ()Lcom/jibo/aws/integration/aws/services/account/model/Account;
      // 034: astore 5
      // 036: bipush 0
      // 037: istore 2
      // 038: iload 2
      // 039: aload 7
      // 03b: arraylength
      // 03c: if_icmpge 0e3
      // 03f: aload 0
      // 040: invokestatic com/jibo/db/EntityData.a (Landroid/content/Context;)Lcom/jibo/db/EntityData;
      // 043: aload 7
      // 045: iload 2
      // 046: aaload
      // 047: invokevirtual com/jibo/db/EntityData.e (Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/media/model/Media;
      // 04a: astore 4
      // 04c: aload 4
      // 04e: astore 1
      // 04f: aload 4
      // 051: ifnonnull 060
      // 054: aload 0
      // 055: invokestatic com/jibo/db/EntityData.a (Landroid/content/Context;)Lcom/jibo/db/EntityData;
      // 058: aload 7
      // 05a: iload 2
      // 05b: aaload
      // 05c: invokevirtual com/jibo/db/EntityData.d (Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/media/model/Media;
      // 05f: astore 1
      // 060: aload 1
      // 061: ifnull 0b6
      // 064: aload 0
      // 065: invokestatic com/jibo/db/EntityData.a (Landroid/content/Context;)Lcom/jibo/db/EntityData;
      // 068: aload 1
      // 069: invokevirtual com/jibo/aws/integration/aws/services/media/model/Media.getLoopId ()Ljava/lang/String;
      // 06c: invokevirtual com/jibo/db/EntityData.c (Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
      // 06f: astore 4
      // 071: iload 3
      // 072: ifne 091
      // 075: aload 4
      // 077: aload 5
      // 079: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getId ()Ljava/lang/String;
      // 07c: invokestatic com/jibo/aws/integration/helpers/LoopHelper.isOwner (Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z
      // 07f: ifne 091
      // 082: aload 1
      // 083: invokevirtual com/jibo/aws/integration/aws/services/media/model/Media.getAccountId ()Ljava/lang/String;
      // 086: aload 5
      // 088: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getId ()Ljava/lang/String;
      // 08b: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 08e: ifeq 0b0
      // 091: aload 6
      // 093: aload 1
      // 094: invokevirtual com/jibo/aws/integration/aws/services/media/model/Media.getPath ()Ljava/lang/String;
      // 097: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 09c: pop
      // 09d: aload 1
      // 09e: invokevirtual com/jibo/aws/integration/aws/services/media/model/Media.getReference ()Ljava/lang/String;
      // 0a1: ifnull 0b0
      // 0a4: aload 6
      // 0a6: aload 1
      // 0a7: invokevirtual com/jibo/aws/integration/aws/services/media/model/Media.getReference ()Ljava/lang/String;
      // 0aa: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0af: pop
      // 0b0: iinc 2 1
      // 0b3: goto 038
      // 0b6: aload 6
      // 0b8: aload 7
      // 0ba: iload 2
      // 0bb: aaload
      // 0bc: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0c1: pop
      // 0c2: goto 0b0
      // 0c5: astore 1
      // 0c6: aload 1
      // 0c7: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 0ca: aload 0
      // 0cb: getfield com/jibo/service/MediaDeletingService.b Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;
      // 0ce: ifnull 0d8
      // 0d1: aload 0
      // 0d2: getfield com/jibo/service/MediaDeletingService.b Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;
      // 0d5: invokevirtual com/jibo/aws/integration/aws/services/media/JiboMediaClient.shutdown ()V
      // 0d8: getstatic com/jibo/service/MediaDeletingService.a Ljava/lang/String;
      // 0db: ldc "onHandleIntent-end"
      // 0dd: invokestatic com/jibo/utils/LogUtils.a (Ljava/lang/String;Ljava/lang/String;)V
      // 0e0: goto 01b
      // 0e3: aload 0
      // 0e4: invokestatic com/jibo/db/EntityData.a (Landroid/content/Context;)Lcom/jibo/db/EntityData;
      // 0e7: aload 6
      // 0e9: invokevirtual com/jibo/db/EntityData.a (Ljava/util/List;)V
      // 0ec: iload 3
      // 0ed: ifne 127
      // 0f0: aload 6
      // 0f2: invokeinterface java/util/List.isEmpty ()Z 1
      // 0f7: ifne 127
      // 0fa: new com/jibo/aws/integration/aws/services/media/JiboMediaClient
      // 0fd: astore 1
      // 0fe: new com/amazonaws/auth/BasicAWSCredentials
      // 101: astore 4
      // 103: aload 4
      // 105: aload 5
      // 107: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getAccessKeyId ()Ljava/lang/String;
      // 10a: aload 5
      // 10c: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getSecretAccessKey ()Ljava/lang/String;
      // 10f: invokespecial com/amazonaws/auth/BasicAWSCredentials.<init> (Ljava/lang/String;Ljava/lang/String;)V
      // 112: aload 1
      // 113: aload 4
      // 115: invokespecial com/jibo/aws/integration/aws/services/media/JiboMediaClient.<init> (Lcom/amazonaws/auth/AWSCredentials;)V
      // 118: aload 0
      // 119: aload 1
      // 11a: putfield com/jibo/service/MediaDeletingService.b Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;
      // 11d: aload 0
      // 11e: getfield com/jibo/service/MediaDeletingService.b Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;
      // 121: aload 6
      // 123: invokevirtual com/jibo/aws/integration/aws/services/media/JiboMediaClient.remove (Ljava/util/List;)Ljava/util/List;
      // 126: pop
      // 127: aload 0
      // 128: getfield com/jibo/service/MediaDeletingService.b Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;
      // 12b: ifnull 0d8
      // 12e: aload 0
      // 12f: getfield com/jibo/service/MediaDeletingService.b Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;
      // 132: invokevirtual com/jibo/aws/integration/aws/services/media/JiboMediaClient.shutdown ()V
      // 135: goto 0d8
      // 138: astore 1
      // 139: aload 0
      // 13a: getfield com/jibo/service/MediaDeletingService.b Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;
      // 13d: ifnull 147
      // 140: aload 0
      // 141: getfield com/jibo/service/MediaDeletingService.b Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;
      // 144: invokevirtual com/jibo/aws/integration/aws/services/media/JiboMediaClient.shutdown ()V
      // 147: aload 1
      // 148: athrow
      // try (22 -> 26): 93 java/lang/Exception
      // try (22 -> 26): 143 null
      // try (28 -> 39): 93 java/lang/Exception
      // try (28 -> 39): 143 null
      // try (43 -> 50): 93 java/lang/Exception
      // try (43 -> 50): 143 null
      // try (52 -> 58): 93 java/lang/Exception
      // try (52 -> 58): 143 null
      // try (60 -> 71): 93 java/lang/Exception
      // try (60 -> 71): 143 null
      // try (71 -> 84): 93 java/lang/Exception
      // try (71 -> 84): 143 null
      // try (86 -> 92): 93 java/lang/Exception
      // try (86 -> 92): 143 null
      // try (94 -> 96): 143 null
      // try (106 -> 110): 93 java/lang/Exception
      // try (106 -> 110): 143 null
      // try (112 -> 136): 93 java/lang/Exception
      // try (112 -> 136): 143 null
   }
}
