package com.jibo.service;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.amazonaws.services.cognitoidentity.model.InvalidParameterException;
import com.google.gson.JsonObject;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.jot.model.Message;
import com.jibo.aws.integration.aws.services.jot.model.MessagePart;
import com.jibo.aws.integration.aws.services.media.JiboMediaClient;
import com.jibo.aws.integration.aws.services.media.model.Media;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.ServiceUtils;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class MessageSendingService extends IntentService {
   public static final String a = MessageSendingService.class.getSimpleName();
   private Account b;
   private JiboMediaClient c = null;

   public MessageSendingService() {
      super(a);
   }

   private MessagePart a(String var1, String var2, String var3, int var4, int var5) throws IOException {
      ImageUtils.a(var1, var2, var4, var5);
      Options var6 = new Options();
      var6.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(var2, var6);
      JsonObject var7 = new JsonObject();
      var7.a("mime-type", var6.outMimeType);
      MessagePart var8 = new MessagePart();
      var8.setType(var3);
      var8.setUrl(var2);
      var8.setMeta(var7);
      return var8;
   }

   private File a(File var1, Message var2) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidAlgorithmParameterException, KeyManager.NoKeyForLoopException {
      if (var2.isEncrypted()) {
         File var3 = new File(var1.getAbsolutePath() + "_");
         var3.delete();
         KeyManager.getInstance(this.getApplicationContext(), this.b.getId())
            .obtainKeyHolder(this.getApplicationContext(), var2.getLoopId())
            .encodeFile(var1, var3);
         if (var3.length() > 0L) {
            var1 = var3;
         } else {
            var1 = null;
         }
      }

      return var1;
   }

   private void a(Message var1, MessagePart var2, MessagePart var3) throws NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, KeyManager.NoKeyForLoopException, InvalidKeyException {
      if (var2 == null) {
         throw new InvalidParameterException("messagePart cant be null");
      }

      if (!var2.getUrl().startsWith("http")) {
         File var7 = this.a(new File(var2.getUrl()), var1);
         JiboMediaClient var4 = this.c;
         String var6 = var1.getLoopId();
         String var5 = var2.getType();
         String var9;
         if (var3 != null) {
            var9 = var3.getPath();
         } else {
            var9 = null;
         }

         Media var8 = var4.create(var6, var5, var9, null, var7, var1.isEncrypted());
         var2.setUrl(var8.getUrl());
         var2.setPath(var8.getPath());
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
      // 001: ldc "EXTRA_MESSAGE"
      // 003: invokevirtual android/content/Intent.getParcelableExtra (Ljava/lang/String;)Landroid/os/Parcelable;
      // 006: checkcast com/jibo/aws/integration/aws/services/jot/model/Message
      // 009: astore 4
      // 00b: aload 4
      // 00d: ifnonnull 011
      // 010: return
      // 011: aload 4
      // 013: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.getId ()Ljava/lang/String;
      // 016: astore 5
      // 018: aload 0
      // 019: aload 0
      // 01a: invokestatic com/jibo/db/EntityData.a (Landroid/content/Context;)Lcom/jibo/db/EntityData;
      // 01d: invokevirtual com/jibo/db/EntityData.i ()Lcom/jibo/aws/integration/aws/services/account/model/Account;
      // 020: putfield com/jibo/service/MessageSendingService.b Lcom/jibo/aws/integration/aws/services/account/model/Account;
      // 023: aload 4
      // 025: invokestatic com/jibo/aws/integration/helpers/JotHelper.hasPhoto (Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Z
      // 028: ifeq 0f9
      // 02b: new com/jibo/aws/integration/aws/services/media/JiboMediaClient
      // 02e: astore 2
      // 02f: new com/amazonaws/auth/BasicAWSCredentials
      // 032: astore 1
      // 033: aload 1
      // 034: aload 0
      // 035: getfield com/jibo/service/MessageSendingService.b Lcom/jibo/aws/integration/aws/services/account/model/Account;
      // 038: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getAccessKeyId ()Ljava/lang/String;
      // 03b: aload 0
      // 03c: getfield com/jibo/service/MessageSendingService.b Lcom/jibo/aws/integration/aws/services/account/model/Account;
      // 03f: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getSecretAccessKey ()Ljava/lang/String;
      // 042: invokespecial com/amazonaws/auth/BasicAWSCredentials.<init> (Ljava/lang/String;Ljava/lang/String;)V
      // 045: aload 2
      // 046: aload 1
      // 047: invokespecial com/jibo/aws/integration/aws/services/media/JiboMediaClient.<init> (Lcom/amazonaws/auth/AWSCredentials;)V
      // 04a: aload 0
      // 04b: aload 2
      // 04c: putfield com/jibo/service/MessageSendingService.c Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;
      // 04f: aload 4
      // 051: invokestatic com/jibo/aws/integration/helpers/JotHelper.getPhoto (Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;
      // 054: astore 6
      // 056: aload 4
      // 058: invokestatic com/jibo/aws/integration/helpers/JotHelper.getThumbnail (Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;
      // 05b: astore 3
      // 05c: aload 4
      // 05e: invokestatic com/jibo/aws/integration/helpers/JotHelper.getRobotThumbnail (Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;
      // 061: astore 2
      // 062: aload 6
      // 064: ifnull 0f9
      // 067: aload 6
      // 069: invokevirtual com/jibo/aws/integration/aws/services/jot/model/MessagePart.getUrl ()Ljava/lang/String;
      // 06c: astore 7
      // 06e: aload 3
      // 06f: astore 1
      // 070: aload 3
      // 071: ifnonnull 0a7
      // 074: new java/lang/StringBuilder
      // 077: astore 1
      // 078: aload 1
      // 079: invokespecial java/lang/StringBuilder.<init> ()V
      // 07c: aload 0
      // 07d: aload 7
      // 07f: aload 1
      // 080: aload 7
      // 082: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 085: ldc_w ".thumb"
      // 088: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 08b: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 08e: ldc_w "thumb"
      // 091: sipush 720
      // 094: sipush 405
      // 097: invokespecial com/jibo/service/MessageSendingService.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;
      // 09a: astore 1
      // 09b: aload 4
      // 09d: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.getParts ()Ljava/util/List;
      // 0a0: aload 1
      // 0a1: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0a6: pop
      // 0a7: aload 2
      // 0a8: ifnonnull 15c
      // 0ab: new java/lang/StringBuilder
      // 0ae: astore 2
      // 0af: aload 2
      // 0b0: invokespecial java/lang/StringBuilder.<init> ()V
      // 0b3: aload 0
      // 0b4: aload 7
      // 0b6: aload 2
      // 0b7: aload 7
      // 0b9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0bc: ldc_w ".robot_thumb"
      // 0bf: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0c2: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0c5: ldc_w "thumb_robot"
      // 0c8: sipush 330
      // 0cb: sipush 330
      // 0ce: invokespecial com/jibo/service/MessageSendingService.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;
      // 0d1: astore 2
      // 0d2: aload 4
      // 0d4: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.getParts ()Ljava/util/List;
      // 0d7: aload 2
      // 0d8: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0dd: pop
      // 0de: aload 0
      // 0df: aload 4
      // 0e1: aload 6
      // 0e3: aconst_null
      // 0e4: invokespecial com/jibo/service/MessageSendingService.a (Lcom/jibo/aws/integration/aws/services/jot/model/Message;Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;)V
      // 0e7: aload 0
      // 0e8: aload 4
      // 0ea: aload 1
      // 0eb: aload 6
      // 0ed: invokespecial com/jibo/service/MessageSendingService.a (Lcom/jibo/aws/integration/aws/services/jot/model/Message;Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;)V
      // 0f0: aload 0
      // 0f1: aload 4
      // 0f3: aload 2
      // 0f4: aload 6
      // 0f6: invokespecial com/jibo/service/MessageSendingService.a (Lcom/jibo/aws/integration/aws/services/jot/model/Message;Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;)V
      // 0f9: aload 0
      // 0fa: getfield com/jibo/service/MessageSendingService.c Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;
      // 0fd: ifnull 010
      // 100: aload 0
      // 101: getfield com/jibo/service/MessageSendingService.c Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;
      // 104: invokevirtual com/jibo/aws/integration/aws/services/media/JiboMediaClient.shutdown ()V
      // 107: goto 010
      // 10a: astore 1
      // 10b: aload 1
      // 10c: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 10f: new java/lang/StringBuilder
      // 112: astore 1
      // 113: aload 1
      // 114: invokespecial java/lang/StringBuilder.<init> ()V
      // 117: aload 4
      // 119: aload 1
      // 11a: ldc_w "TEMP_FAILED_"
      // 11d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 120: invokestatic java/lang/System.currentTimeMillis ()J
      // 123: invokestatic java/lang/String.valueOf (J)Ljava/lang/String;
      // 126: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 129: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 12c: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.setId (Ljava/lang/String;)V
      // 12f: aload 0
      // 130: invokestatic com/jibo/db/EntityData.a (Landroid/content/Context;)Lcom/jibo/db/EntityData;
      // 133: aload 4
      // 135: aload 5
      // 137: invokevirtual com/jibo/db/EntityData.a (Lcom/jibo/aws/integration/aws/services/jot/model/Message;Ljava/lang/String;)V
      // 13a: aload 0
      // 13b: getfield com/jibo/service/MessageSendingService.c Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;
      // 13e: ifnull 010
      // 141: aload 0
      // 142: getfield com/jibo/service/MessageSendingService.c Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;
      // 145: invokevirtual com/jibo/aws/integration/aws/services/media/JiboMediaClient.shutdown ()V
      // 148: goto 010
      // 14b: astore 1
      // 14c: aload 0
      // 14d: getfield com/jibo/service/MessageSendingService.c Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;
      // 150: ifnull 15a
      // 153: aload 0
      // 154: getfield com/jibo/service/MessageSendingService.c Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;
      // 157: invokevirtual com/jibo/aws/integration/aws/services/media/JiboMediaClient.shutdown ()V
      // 15a: aload 1
      // 15b: athrow
      // 15c: goto 0de
      // try (11 -> 46): 123 java/lang/Exception
      // try (11 -> 46): 151 null
      // try (48 -> 51): 123 java/lang/Exception
      // try (48 -> 51): 151 null
      // try (55 -> 77): 123 java/lang/Exception
      // try (55 -> 77): 151 null
      // try (79 -> 101): 123 java/lang/Exception
      // try (79 -> 101): 151 null
      // try (101 -> 116): 123 java/lang/Exception
      // try (101 -> 116): 151 null
      // try (124 -> 144): 151 null
   }
}
