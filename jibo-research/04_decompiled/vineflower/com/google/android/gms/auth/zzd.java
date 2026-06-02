package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.zzp;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgg;
import java.io.IOException;

public class zzd {
   @SuppressLint("InlinedApi")
   public static final String a = "callerUid";
   @SuppressLint("InlinedApi")
   public static final String b = "androidPackageName";
   private static String[] c = new String[]{"com.google", "com.google.work", "cn.google"};
   private static final ComponentName d = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
   private static final zzbgg e = new zzbgg("Auth", "GoogleAuthUtil");

   private static <T> T a(Context var0, ComponentName var1, zzj<T> var2) throws IOException, GoogleAuthException {
      com.google.android.gms.common.zza var3 = new com.google.android.gms.common.zza();
      zzag var4 = zzag.a(var0);
      if (var4.a(var1, var3, "GoogleAuthUtil")) {
         try {
            try {
               return (T)var2.a(var3.a());
            } catch (RemoteException var8) {
               var11 = var8;
            } catch (InterruptedException var9) {
               var11 = var9;
            }

            e.b("GoogleAuthUtil", "Error on service connection.", var11);
            IOException var12 = new IOException("Error on service connection.", (Throwable)var11);
            throw var12;
         } finally {
            var4.b(var1, var3, "GoogleAuthUtil");
         }
      } else {
         throw new IOException("Could not bind to service.");
      }
   }

   public static String a(Context var0, Account var1, String var2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
      return a(var0, var1, var2, new Bundle());
   }

   public static String a(Context var0, Account var1, String var2, Bundle var3) throws IOException, UserRecoverableAuthException, GoogleAuthException {
      a(var1);
      return b(var0, var1, var2, var3).a();
   }

   private static void a(Account var0) {
      if (var0 == null) {
         throw new IllegalArgumentException("Account cannot be null");
      }

      if (TextUtils.isEmpty(var0.name)) {
         throw new IllegalArgumentException("Account name cannot be empty!");
      }

      String[] var3 = c;
      int var2 = var3.length;

      for (int var1 = 0; var1 < var2; var1++) {
         if (var3[var1].equals(var0.type)) {
            return;
         }
      }

      throw new IllegalArgumentException("Account type not supported");
   }

   private static void a(Context var0) throws GoogleAuthException {
      try {
         zzp.zzbp(var0.getApplicationContext());
      } catch (GooglePlayServicesRepairableException var1) {
         throw new GooglePlayServicesAvailabilityException(var1.a(), var1.getMessage(), var1.b());
      } catch (GooglePlayServicesNotAvailableException var2) {
         throw new GoogleAuthException(var2.getMessage());
      }
   }

   public static TokenData b(Context var0, Account var1, String var2, Bundle var3) throws IOException, UserRecoverableAuthException, GoogleAuthException {
      zzbq.c("Calling this from your main thread can lead to deadlock");
      zzbq.a(var2, "Scope cannot be empty or null.");
      a(var1);
      a(var0);
      if (var3 == null) {
         var3 = new Bundle();
      } else {
         var3 = new Bundle(var3);
      }

      String var4 = var0.getApplicationInfo().packageName;
      var3.putString("clientPackageName", var4);
      if (TextUtils.isEmpty(var3.getString(b))) {
         var3.putString(b, var4);
      }

      var3.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
      zze var5 = new zze(var1, var2, var3);
      return a(var0, d, var5);
   }

   private static <T> T b(T var0) throws IOException {
      if (var0 == null) {
         e.c("GoogleAuthUtil", "Binder call returned null.");
         throw new IOException("Service unavailable.");
      } else {
         return (T)var0;
      }
   }

   @Deprecated
   public static String b(Context var0, String var1, String var2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
      return a(var0, new Account(var1, "com.google"), var2);
   }

   @Deprecated
   public static void b(Context var0, String var1) {
      AccountManager.get(var0).invalidateAuthToken("com.google", var1);
   }
}
