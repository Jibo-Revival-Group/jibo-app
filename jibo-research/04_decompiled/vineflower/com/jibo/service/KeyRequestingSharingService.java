package com.jibo.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.crashlytics.android.Crashlytics;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.key.model.Request;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.db.DatabaseContract;
import com.jibo.db.EntityData;
import com.jibo.utils.ServiceUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class KeyRequestingSharingService extends IntentService {
   public static final String a = KeyRequestingSharingService.class.getSimpleName();
   private Account b;

   public KeyRequestingSharingService() {
      super(a);
   }

   private void a() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 1
      // 02: aload 0
      // 03: invokevirtual com/jibo/service/KeyRequestingSharingService.getContentResolver ()Landroid/content/ContentResolver;
      // 06: bipush 8
      // 08: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (I)Landroid/net/Uri;
      // 0b: getstatic com/jibo/db/DatabaseContract$EntityEntry.a [Ljava/lang/String;
      // 0e: aconst_null
      // 0f: aconst_null
      // 10: aconst_null
      // 11: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 14: astore 2
      // 15: aload 2
      // 16: astore 1
      // 17: aload 1
      // 18: ifnull 73
      // 1b: aload 1
      // 1c: invokeinterface android/database/Cursor.isClosed ()Z 1
      // 21: ifne 73
      // 24: aload 1
      // 25: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 2a: ifeq 73
      // 2d: aload 1
      // 2e: invokeinterface android/database/Cursor.isAfterLast ()Z 1
      // 33: ifne 73
      // 36: aload 0
      // 37: invokestatic com/jibo/db/EntityData.a (Landroid/content/Context;)Lcom/jibo/db/EntityData;
      // 3a: pop
      // 3b: aload 1
      // 3c: invokestatic com/jibo/db/EntityData.a (Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
      // 3f: astore 2
      // 40: aload 2
      // 41: aload 0
      // 42: invokestatic com/jibo/db/EntityData.a (Landroid/content/Context;)Lcom/jibo/db/EntityData;
      // 45: invokevirtual com/jibo/db/EntityData.i ()Lcom/jibo/aws/integration/aws/services/account/model/Account;
      // 48: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getId ()Ljava/lang/String;
      // 4b: invokestatic com/jibo/aws/integration/helpers/LoopHelper.isMemberAccepted (Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z
      // 4e: ifeq 5d
      // 51: aload 0
      // 52: aload 0
      // 53: invokevirtual com/jibo/service/KeyRequestingSharingService.getApplicationContext ()Landroid/content/Context;
      // 56: aload 2
      // 57: invokevirtual com/jibo/aws/integration/aws/services/loop/model/Loop.getId ()Ljava/lang/String;
      // 5a: invokespecial com/jibo/service/KeyRequestingSharingService.a (Landroid/content/Context;Ljava/lang/String;)V
      // 5d: aload 1
      // 5e: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 63: pop
      // 64: goto 2d
      // 67: astore 2
      // 68: aload 1
      // 69: ifnull 72
      // 6c: aload 1
      // 6d: invokeinterface android/database/Cursor.close ()V 1
      // 72: return
      // 73: aload 1
      // 74: ifnull 72
      // 77: aload 1
      // 78: invokeinterface android/database/Cursor.close ()V 1
      // 7d: goto 72
      // 80: astore 2
      // 81: aload 1
      // 82: ifnull 8b
      // 85: aload 1
      // 86: invokeinterface android/database/Cursor.close ()V 1
      // 8b: aload 2
      // 8c: athrow
      // 8d: astore 2
      // 8e: goto 81
      // 91: astore 1
      // 92: aconst_null
      // 93: astore 1
      // 94: goto 68
      // try (2 -> 12): 68 java/lang/Exception
      // try (2 -> 12): 59 null
      // try (16 -> 22): 48 java/lang/Exception
      // try (16 -> 22): 66 null
      // try (22 -> 44): 48 java/lang/Exception
      // try (22 -> 44): 66 null
      // try (44 -> 47): 48 java/lang/Exception
      // try (44 -> 47): 66 null
   }

   public static void a(Context var0) {
      Intent var1 = new Intent(var0, KeyRequestingSharingService.class);
      var1.setAction("ACTION_CHECK_ALL_LOOPS");
      ServiceUtils.a(var0, var1);
   }

   private void a(Context var1, String var2) {
      label15: {
         KeyManager.SymmetricKeyHolder var3;
         try {
            var3 = KeyManager.getInstance(var1.getApplicationContext(), this.b.getId()).obtainKeyHolder(var1.getApplicationContext(), var2);
         } catch (Exception var4) {
            Crashlytics.a(var4);
            break label15;
         }

         if (var3 != null) {
            return;
         }
      }

      Intent var5 = new Intent(var1, KeyRequestingSharingService.class);
      var5.setAction("ACTION_REQUEST_KEY");
      var5.putExtra("loopId", var2);
      ServiceUtils.a(var1, var5);
   }

   public static void a(Context var0, Map<String, String> var1) {
      Intent var2 = new Intent(var0, KeyRequestingSharingService.class);
      var2.setAction("ACTION_KEY_REQUESTED");
      var2.putExtra("loopId", (String)var1.get("loopId"));
      ServiceUtils.a(var0, var2);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void a(Bundle var1) {
      String var7 = var1.getString("loopId");
      if (!TextUtils.isEmpty(var7)) {
         SharedPreferences var2;
         try {
            var2 = this.getSharedPreferences(this.getString(2131755063), 0);
            if (TextUtils.isEmpty(var2.getString("PREF_PUSH_SERVICE_TOKEN", null))) {
               Thread.sleep(2000L);
            }
         } catch (Exception var6) {
            Crashlytics.a(var6);
            return;
         }

         Request var3;
         try {
            if (TextUtils.isEmpty(var2.getString("PREF_PUSH_SERVICE_TOKEN", null))) {
               return;
            }

            var8 = KeyManager.getInstance(this.getApplicationContext(), this.b.getId());
            var3 = EntityData.a(this.getApplicationContext()).d().createRequest(var7, var8.getPublicKeyForSharing());
         } catch (Exception var5) {
            Crashlytics.a(var5);
            return;
         }

         if (var3 != null) {
            try {
               this.a(var8, var3, var7);
            } catch (Exception var4) {
               Crashlytics.a(var4);
            }
         }
      }
   }

   private void a(KeyManager var1, Request var2, String var3) throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException, NoSuchPaddingException, BadPaddingException, KeyStoreException, NoSuchProviderException, IllegalBlockSizeException {
      if (!TextUtils.isEmpty(var2.getEncryptedKey())) {
         var1.saveSymmetricKey(this.getApplicationContext(), var3, var2.getEncryptedKey());
         this.getContentResolver().notifyChange(DatabaseContract.EntityEntry.a(8), null);
         LocalBroadcastManager var5 = LocalBroadcastManager.a(this);
         Intent var4 = new Intent();
         var4.setAction("ACTION_KEY_SAVED");
         var4.putExtra("loopId", var3);
         var5.a(var4);
      }
   }

   public static void b(Context var0, Map<String, String> var1) {
      Intent var2 = new Intent(var0, KeyRequestingSharingService.class);
      var2.setAction("ACTION_KEY_SHARED");
      var2.putExtra("loopId", (String)var1.get("loopId"));
      var2.putExtra("id", (String)var1.get("id"));
      ServiceUtils.a(var0, var2);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void b(Bundle var1) {
      String var3 = var1.getString("loopId");
      if (!TextUtils.isEmpty(var3)) {
         EntityData var2;
         try {
            var12 = KeyManager.getInstance(this.getApplicationContext(), this.b.getId()).obtainKeyHolder(this.getApplicationContext(), var3);
            var2 = EntityData.a(this.getApplicationContext());
         } catch (Exception var11) {
            Crashlytics.a(var11);
            return;
         }

         label43: {
            try {
               var14 = var2.d().listIncomingRequests(var3).iterator();
            } catch (Exception var10) {
               var13 = var10;
               break label43;
            }

            while (true) {
               Request var4;
               String var5;
               try {
                  if (!var14.hasNext()) {
                     return;
                  }

                  var4 = (Request)var14.next();
                  var5 = var12.shareSymmetricKey(var4.getPublicKey());
               } catch (Exception var9) {
                  var13 = var9;
                  break;
               }

               try {
                  var2.d().share(var4.getId(), var5);
               } catch (Exception var8) {
                  Exception var15 = var8;

                  try {
                     Crashlytics.a(var15);
                  } catch (Exception var7) {
                     var13 = var7;
                     break;
                  }
               }
            }
         }

         try {
            Crashlytics.a(var13);
         } catch (Exception var6) {
            Crashlytics.a(var6);
         }
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void c(Bundle var1) {
      if (var1 != null) {
         String var2 = var1.getString("loopId");
         String var5 = var1.getString("id");
         if (!TextUtils.isEmpty(var2) && !TextUtils.isEmpty(var5)) {
            try {
               var6 = EntityData.a(this.getApplicationContext()).d().getRequest(var5);
            } catch (Exception var4) {
               Crashlytics.a(var4);
               return;
            }

            if (var6 != null) {
               try {
                  this.a(KeyManager.getInstance(this.getApplicationContext(), this.b.getId()), var6, var2);
               } catch (Exception var3) {
                  Crashlytics.a(var3);
               }
            }
         }
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

   protected void onHandleIntent(Intent var1) {
      this.b = EntityData.a(this).i();
      if ("ACTION_CHECK_ALL_LOOPS".equals(var1.getAction())) {
         this.a();
      } else if ("ACTION_REQUEST_KEY".equals(var1.getAction())) {
         this.a(var1.getExtras());
      } else if ("ACTION_KEY_REQUESTED".equals(var1.getAction())) {
         this.b(var1.getExtras());
      } else if ("ACTION_KEY_SHARED".equals(var1.getAction())) {
         this.c(var1.getExtras());
      }
   }
}
