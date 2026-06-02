package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.R;
import com.google.android.gms.internal.zzbhf;

public final class zzu {
   private static final SimpleArrayMap<String, String> a = new SimpleArrayMap<>();

   public static String a(Context var0) {
      return var0.getResources().getString(R.string.common_google_play_services_notification_channel_name);
   }

   public static String a(Context var0, int var1) {
      Object var3 = null;
      Resources var4 = var0.getResources();
      String var2 = (String)var3;
      switch (var1) {
         case 1:
            var2 = var4.getString(R.string.common_google_play_services_install_title);
            break;
         case 2:
            var2 = var4.getString(R.string.common_google_play_services_update_title);
            break;
         case 3:
            var2 = var4.getString(R.string.common_google_play_services_enable_title);
         case 4:
         case 6:
         case 18:
            break;
         case 5:
            Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
            var2 = a(var0, "common_google_play_services_invalid_account_title");
            break;
         case 7:
            Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
            var2 = a(var0, "common_google_play_services_network_error_title");
            break;
         case 8:
            Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
            var2 = (String)var3;
            break;
         case 9:
            Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
            var2 = (String)var3;
            break;
         case 10:
            Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
            var2 = (String)var3;
            break;
         case 11:
            Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
            var2 = (String)var3;
            break;
         case 12:
         case 13:
         case 14:
         case 15:
         case 19:
         default:
            Log.e("GoogleApiAvailability", new StringBuilder(33).append("Unexpected error code ").append(var1).toString());
            var2 = (String)var3;
            break;
         case 16:
            Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
            var2 = (String)var3;
            break;
         case 17:
            Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
            var2 = a(var0, "common_google_play_services_sign_in_failed_title");
            break;
         case 20:
            Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
            var2 = a(var0, "common_google_play_services_restricted_profile_title");
      }

      return var2;
   }

   private static String a(Context param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic com/google/android/gms/common/internal/zzu.a Landroid/support/v4/util/SimpleArrayMap;
      // 03: astore 4
      // 05: aload 4
      // 07: monitorenter
      // 08: getstatic com/google/android/gms/common/internal/zzu.a Landroid/support/v4/util/SimpleArrayMap;
      // 0b: aload 1
      // 0c: invokevirtual android/support/v4/util/SimpleArrayMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 0f: checkcast java/lang/String
      // 12: astore 3
      // 13: aload 3
      // 14: ifnull 1e
      // 17: aload 4
      // 19: monitorexit
      // 1a: aload 3
      // 1b: astore 0
      // 1c: aload 0
      // 1d: areturn
      // 1e: aload 0
      // 1f: invokestatic com/google/android/gms/common/GooglePlayServicesUtil.getRemoteResource (Landroid/content/Context;)Landroid/content/res/Resources;
      // 22: astore 0
      // 23: aload 0
      // 24: ifnonnull 2f
      // 27: aload 4
      // 29: monitorexit
      // 2a: aconst_null
      // 2b: astore 0
      // 2c: goto 1c
      // 2f: aload 0
      // 30: aload 1
      // 31: ldc "string"
      // 33: ldc "com.google.android.gms"
      // 35: invokevirtual android/content/res/Resources.getIdentifier (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
      // 38: istore 2
      // 39: iload 2
      // 3a: ifne 72
      // 3d: aload 1
      // 3e: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 41: astore 0
      // 42: aload 0
      // 43: invokevirtual java/lang/String.length ()I
      // 46: ifeq 5f
      // 49: ldc "Missing resource: "
      // 4b: aload 0
      // 4c: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 4f: astore 0
      // 50: ldc "GoogleApiAvailability"
      // 52: aload 0
      // 53: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 56: pop
      // 57: aload 4
      // 59: monitorexit
      // 5a: aconst_null
      // 5b: astore 0
      // 5c: goto 1c
      // 5f: new java/lang/String
      // 62: dup
      // 63: ldc "Missing resource: "
      // 65: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // 68: astore 0
      // 69: goto 50
      // 6c: astore 0
      // 6d: aload 4
      // 6f: monitorexit
      // 70: aload 0
      // 71: athrow
      // 72: aload 0
      // 73: iload 2
      // 74: invokevirtual android/content/res/Resources.getString (I)Ljava/lang/String;
      // 77: astore 0
      // 78: aload 0
      // 79: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 7c: ifeq ae
      // 7f: aload 1
      // 80: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 83: astore 0
      // 84: aload 0
      // 85: invokevirtual java/lang/String.length ()I
      // 88: ifeq a1
      // 8b: ldc "Got empty resource: "
      // 8d: aload 0
      // 8e: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 91: astore 0
      // 92: ldc "GoogleApiAvailability"
      // 94: aload 0
      // 95: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 98: pop
      // 99: aload 4
      // 9b: monitorexit
      // 9c: aconst_null
      // 9d: astore 0
      // 9e: goto 1c
      // a1: new java/lang/String
      // a4: dup
      // a5: ldc "Got empty resource: "
      // a7: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // aa: astore 0
      // ab: goto 92
      // ae: getstatic com/google/android/gms/common/internal/zzu.a Landroid/support/v4/util/SimpleArrayMap;
      // b1: aload 1
      // b2: aload 0
      // b3: invokevirtual android/support/v4/util/SimpleArrayMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // b6: pop
      // b7: aload 4
      // b9: monitorexit
      // ba: goto 1c
      // try (4 -> 9): 60 null
      // try (11 -> 13): 60 null
      // try (17 -> 20): 60 null
      // try (22 -> 24): 60 null
      // try (27 -> 33): 60 null
      // try (35 -> 45): 60 null
      // try (45 -> 51): 60 null
      // try (54 -> 59): 60 null
      // try (61 -> 63): 60 null
      // try (65 -> 82): 60 null
      // try (82 -> 88): 60 null
      // try (91 -> 96): 60 null
      // try (97 -> 104): 60 null
   }

   private static String a(Context var0, String var1, String var2) {
      Resources var3 = var0.getResources();
      var1 = a(var0, var1);
      String var4 = var1;
      if (var1 == null) {
         var4 = var3.getString(R.string.common_google_play_services_unknown_issue);
      }

      return String.format(var3.getConfiguration().locale, var4, var2);
   }

   private static String b(Context var0) {
      String var1 = var0.getPackageName();

      try {
         return zzbhf.a(var0).b(var1).toString();
      } catch (NameNotFoundException var3) {
      } catch (NullPointerException var4) {
      }

      String var2 = var0.getApplicationInfo().name;
      String var5 = var1;
      if (!TextUtils.isEmpty(var2)) {
         var5 = var2;
      }

      return var5;
   }

   public static String b(Context var0, int var1) {
      String var2;
      if (var1 == 6) {
         var2 = a(var0, "common_google_play_services_resolution_required_title");
      } else {
         var2 = a(var0, var1);
      }

      String var3 = var2;
      if (var2 == null) {
         var3 = var0.getResources().getString(R.string.common_google_play_services_notification_ticker);
      }

      return var3;
   }

   public static String c(Context var0, int var1) {
      Resources var3 = var0.getResources();
      String var2 = b(var0);
      String var4;
      switch (var1) {
         case 1:
            var4 = var3.getString(R.string.common_google_play_services_install_text, new Object[]{var2});
            break;
         case 2:
            if (com.google.android.gms.common.util.zzi.b(var0)) {
               var4 = var3.getString(R.string.common_google_play_services_wear_update_text);
            } else {
               var4 = var3.getString(R.string.common_google_play_services_update_text, new Object[]{var2});
            }
            break;
         case 3:
            var4 = var3.getString(R.string.common_google_play_services_enable_text, new Object[]{var2});
            break;
         case 4:
         case 6:
         case 8:
         case 10:
         case 11:
         case 12:
         case 13:
         case 14:
         case 15:
         case 19:
         default:
            var4 = var3.getString(R.string.common_google_play_services_unknown_issue, new Object[]{var2});
            break;
         case 5:
            var4 = a(var0, "common_google_play_services_invalid_account_text", var2);
            break;
         case 7:
            var4 = a(var0, "common_google_play_services_network_error_text", var2);
            break;
         case 9:
            var4 = var3.getString(R.string.common_google_play_services_unsupported_text, new Object[]{var2});
            break;
         case 16:
            var4 = a(var0, "common_google_play_services_api_unavailable_text", var2);
            break;
         case 17:
            var4 = a(var0, "common_google_play_services_sign_in_failed_text", var2);
            break;
         case 18:
            var4 = var3.getString(R.string.common_google_play_services_updating_text, new Object[]{var2});
            break;
         case 20:
            var4 = a(var0, "common_google_play_services_restricted_profile_text", var2);
      }

      return var4;
   }

   public static String d(Context var0, int var1) {
      String var2;
      if (var1 == 6) {
         var2 = a(var0, "common_google_play_services_resolution_required_text", b(var0));
      } else {
         var2 = c(var0, var1);
      }

      return var2;
   }

   public static String e(Context var0, int var1) {
      Resources var2 = var0.getResources();
      String var3;
      switch (var1) {
         case 1:
            var3 = var2.getString(R.string.common_google_play_services_install_button);
            break;
         case 2:
            var3 = var2.getString(R.string.common_google_play_services_update_button);
            break;
         case 3:
            var3 = var2.getString(R.string.common_google_play_services_enable_button);
            break;
         default:
            var3 = var2.getString(17039370);
      }

      return var3;
   }
}
