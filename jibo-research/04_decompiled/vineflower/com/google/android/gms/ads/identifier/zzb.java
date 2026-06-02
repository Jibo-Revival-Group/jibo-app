package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.zzp;

public final class zzb {
   private SharedPreferences a;

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public zzb(Context var1) {
      try {
         var1 = zzp.getRemoteContext(var1);
      } catch (Throwable var4) {
         Log.w("GmscoreFlag", "Error while getting SharedPreferences ", var4);
         this.a = null;
         return;
      }

      SharedPreferences var6;
      if (var1 == null) {
         var6 = null;
      } else {
         try {
            var6 = var1.getSharedPreferences("google_ads_flags", 0);
         } catch (Throwable var3) {
            Log.w("GmscoreFlag", "Error while getting SharedPreferences ", var3);
            this.a = null;
            return;
         }
      }

      try {
         this.a = var6;
      } catch (Throwable var2) {
         Log.w("GmscoreFlag", "Error while getting SharedPreferences ", var2);
         this.a = null;
      }
   }

   final float a(String var1, float var2) {
      var2 = 0.0F;

      float var3;
      try {
         if (this.a == null) {
            return var2;
         }

         var3 = this.a.getFloat(var1, 0.0F);
      } catch (Throwable var4) {
         Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", var4);
         return var2;
      }

      return var3;
   }

   final String a(String var1, String var2) {
      try {
         if (this.a == null) {
            return var2;
         }

         var1 = this.a.getString(var1, var2);
      } catch (Throwable var3) {
         Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", var3);
         return var2;
      }

      return var1;
   }

   public final boolean a(String var1, boolean var2) {
      var2 = false;

      boolean var3;
      try {
         if (this.a == null) {
            return var2;
         }

         var3 = this.a.getBoolean(var1, false);
      } catch (Throwable var4) {
         Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", var4);
         return var2;
      }

      return var3;
   }
}
