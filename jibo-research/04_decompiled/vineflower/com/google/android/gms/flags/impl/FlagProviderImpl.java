package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzcaz;

@DynamiteApi
public class FlagProviderImpl extends zzcaz {
   private boolean a = false;
   private SharedPreferences b;

   @Override
   public boolean getBooleanFlagValue(String var1, boolean var2, int var3) {
      if (this.a) {
         var2 = zzb.a(this.b, var1, var2);
      }

      return var2;
   }

   @Override
   public int getIntFlagValue(String var1, int var2, int var3) {
      if (this.a) {
         var2 = zzd.a(this.b, var1, var2);
      }

      return var2;
   }

   @Override
   public long getLongFlagValue(String var1, long var2, int var4) {
      if (this.a) {
         var2 = zzf.a(this.b, var1, var2);
      }

      return var2;
   }

   @Override
   public String getStringFlagValue(String var1, String var2, int var3) {
      if (this.a) {
         var2 = zzh.a(this.b, var1, var2);
      }

      return var2;
   }

   @Override
   public void init(IObjectWrapper var1) {
      Context var4 = zzn.a(var1);
      if (!this.a) {
         try {
            this.b = zzj.a(var4.createPackageContext("com.google.android.gms", 0));
            this.a = true;
         } catch (NameNotFoundException var2) {
         } catch (Exception var3) {
            String var5 = String.valueOf(var3.getMessage());
            String var6;
            if (var5.length() != 0) {
               var6 = "Could not retrieve sdk flags, continuing with defaults: ".concat(var5);
            } else {
               var6 = new String("Could not retrieve sdk flags, continuing with defaults: ");
            }

            Log.w("FlagProviderImpl", var6);
         }
      }
   }
}
