package com.facebook.messenger;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import bolts.AppLinks;
import com.facebook.FacebookSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class MessengerUtils {
   public static final String EXTRA_APP_ID = "com.facebook.orca.extra.APPLICATION_ID";
   public static final String EXTRA_EXTERNAL_URI = "com.facebook.orca.extra.EXTERNAL_URI";
   public static final String EXTRA_IS_COMPOSE = "com.facebook.orca.extra.IS_COMPOSE";
   public static final String EXTRA_IS_REPLY = "com.facebook.orca.extra.IS_REPLY";
   public static final String EXTRA_METADATA = "com.facebook.orca.extra.METADATA";
   public static final String EXTRA_PARTICIPANTS = "com.facebook.orca.extra.PARTICIPANTS";
   public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.orca.extra.PROTOCOL_VERSION";
   public static final String EXTRA_REPLY_TOKEN_KEY = "com.facebook.orca.extra.REPLY_TOKEN";
   public static final String EXTRA_THREAD_TOKEN_KEY = "com.facebook.orca.extra.THREAD_TOKEN";
   public static final String ORCA_THREAD_CATEGORY_20150314 = "com.facebook.orca.category.PLATFORM_THREAD_20150314";
   public static final String PACKAGE_NAME = "com.facebook.orca";
   public static final int PROTOCOL_VERSION_20150314 = 20150314;
   private static final String TAG = "MessengerUtils";

   public static void finishShareToMessenger(Activity var0, ShareToMessengerParams var1) {
      Intent var3 = var0.getIntent();
      Set var2 = var3.getCategories();
      if (var2 == null) {
         var0.setResult(0, null);
         var0.finish();
      } else if (var2.contains("com.facebook.orca.category.PLATFORM_THREAD_20150314")) {
         Bundle var4 = AppLinks.b(var3);
         var3 = new Intent();
         if (!var2.contains("com.facebook.orca.category.PLATFORM_THREAD_20150314")) {
            throw new RuntimeException();
         }

         var3.putExtra("com.facebook.orca.extra.PROTOCOL_VERSION", 20150314);
         var3.putExtra("com.facebook.orca.extra.THREAD_TOKEN", var4.getString("com.facebook.orca.extra.THREAD_TOKEN"));
         var3.setDataAndType(var1.uri, var1.mimeType);
         var3.setFlags(1);
         var3.putExtra("com.facebook.orca.extra.APPLICATION_ID", FacebookSdk.getApplicationId());
         var3.putExtra("com.facebook.orca.extra.METADATA", var1.metaData);
         var3.putExtra("com.facebook.orca.extra.EXTERNAL_URI", var1.externalUri);
         var0.setResult(-1, var3);
         var0.finish();
      } else {
         var0.setResult(0, null);
         var0.finish();
      }
   }

   private static Set<Integer> getAllAvailableProtocolVersions(Context param0) {
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
      // 00: aload 0
      // 01: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 04: astore 2
      // 05: new java/util/HashSet
      // 08: dup
      // 09: invokespecial java/util/HashSet.<init> ()V
      // 0c: astore 0
      // 0d: aload 2
      // 0e: ldc "content://com.facebook.orca.provider.MessengerPlatformProvider/versions"
      // 10: invokestatic android/net/Uri.parse (Ljava/lang/String;)Landroid/net/Uri;
      // 13: bipush 1
      // 14: anewarray 153
      // 17: dup
      // 18: bipush 0
      // 19: ldc "version"
      // 1b: aastore
      // 1c: aconst_null
      // 1d: aconst_null
      // 1e: aconst_null
      // 1f: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 22: astore 2
      // 23: aload 2
      // 24: ifnull 5c
      // 27: aload 2
      // 28: ldc "version"
      // 2a: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 2f: istore 1
      // 30: aload 2
      // 31: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 36: ifeq 56
      // 39: aload 0
      // 3a: aload 2
      // 3b: iload 1
      // 3c: invokeinterface android/database/Cursor.getInt (I)I 2
      // 41: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 44: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 49: pop
      // 4a: goto 30
      // 4d: astore 0
      // 4e: aload 2
      // 4f: invokeinterface android/database/Cursor.close ()V 1
      // 54: aload 0
      // 55: athrow
      // 56: aload 2
      // 57: invokeinterface android/database/Cursor.close ()V 1
      // 5c: aload 0
      // 5d: areturn
      // try (23 -> 27): 38 null
      // try (27 -> 37): 38 null
   }

   public static MessengerThreadParams getMessengerThreadParamsForIntent(Intent var0) {
      MessengerThreadParams var3 = null;
      Set var4 = var0.getCategories();
      if (var4 != null && var4.contains("com.facebook.orca.category.PLATFORM_THREAD_20150314")) {
         Bundle var6 = AppLinks.b(var0);
         String var8 = var6.getString("com.facebook.orca.extra.THREAD_TOKEN");
         String var5 = var6.getString("com.facebook.orca.extra.METADATA");
         String var9 = var6.getString("com.facebook.orca.extra.PARTICIPANTS");
         boolean var2 = var6.getBoolean("com.facebook.orca.extra.IS_REPLY");
         boolean var1 = var6.getBoolean("com.facebook.orca.extra.IS_COMPOSE");
         MessengerThreadParams.Origin var7 = MessengerThreadParams.Origin.UNKNOWN;
         if (var2) {
            var7 = MessengerThreadParams.Origin.REPLY_FLOW;
         } else if (var1) {
            var7 = MessengerThreadParams.Origin.COMPOSE_FLOW;
         }

         var3 = new MessengerThreadParams(var7, var8, var5, parseParticipants(var9));
      }

      return var3;
   }

   public static boolean hasMessengerInstalled(Context var0) {
      boolean var1 = false;

      try {
         var0.getPackageManager().getPackageInfo("com.facebook.orca", 0);
      } catch (NameNotFoundException var2) {
         return var1;
      }

      return true;
   }

   public static void openMessengerInPlayStore(Context var0) {
      try {
         startViewUri(var0, "market://details?id=com.facebook.orca");
      } catch (ActivityNotFoundException var2) {
         startViewUri(var0, "http://play.google.com/store/apps/details?id=com.facebook.orca");
      }
   }

   private static List<String> parseParticipants(String var0) {
      List var5;
      if (var0 != null && var0.length() != 0) {
         String[] var4 = var0.split(",");
         ArrayList var3 = new ArrayList();
         int var2 = var4.length;
         int var1 = 0;

         while (true) {
            var5 = var3;
            if (var1 >= var2) {
               break;
            }

            var3.add(var4[var1].trim());
            var1++;
         }
      } else {
         var5 = Collections.emptyList();
      }

      return var5;
   }

   public static void shareToMessenger(Activity var0, int var1, ShareToMessengerParams var2) {
      if (!hasMessengerInstalled(var0)) {
         openMessengerInPlayStore(var0);
      } else if (getAllAvailableProtocolVersions(var0).contains(20150314)) {
         shareToMessenger20150314(var0, var1, var2);
      } else {
         openMessengerInPlayStore(var0);
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static void shareToMessenger20150314(Activity var0, int var1, ShareToMessengerParams var2) {
      String var3;
      Intent var4;
      try {
         var4 = new Intent("android.intent.action.SEND");
         var4.setFlags(1);
         var4.setPackage("com.facebook.orca");
         var4.putExtra("android.intent.extra.STREAM", var2.uri);
         var4.setType(var2.mimeType);
         var3 = FacebookSdk.getApplicationId();
      } catch (ActivityNotFoundException var7) {
         var0.startActivity(var0.getPackageManager().getLaunchIntentForPackage("com.facebook.orca"));
         return;
      }

      if (var3 != null) {
         try {
            var4.putExtra("com.facebook.orca.extra.PROTOCOL_VERSION", 20150314);
            var4.putExtra("com.facebook.orca.extra.APPLICATION_ID", var3);
            var4.putExtra("com.facebook.orca.extra.METADATA", var2.metaData);
            var4.putExtra("com.facebook.orca.extra.EXTERNAL_URI", var2.externalUri);
         } catch (ActivityNotFoundException var6) {
            var0.startActivity(var0.getPackageManager().getLaunchIntentForPackage("com.facebook.orca"));
            return;
         }
      }

      try {
         var0.startActivityForResult(var4, var1);
      } catch (ActivityNotFoundException var5) {
         var0.startActivity(var0.getPackageManager().getLaunchIntentForPackage("com.facebook.orca"));
      }
   }

   private static void startViewUri(Context var0, String var1) {
      var0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var1)));
   }
}
