package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.common.api.internal.zzcf;

public abstract class zzv implements OnClickListener {
   public static zzv a(Activity var0, Intent var1, int var2) {
      return new zzw(var1, var0, var2);
   }

   public static zzv a(Fragment var0, Intent var1, int var2) {
      return new zzx(var1, var0, var2);
   }

   public static zzv a(zzcf var0, Intent var1, int var2) {
      return new zzy(var1, var0, 2);
   }

   protected abstract void a();

   public void onClick(DialogInterface var1, int var2) {
      try {
         this.a();
      } catch (ActivityNotFoundException var6) {
         Log.e("DialogRedirect", "Failed to start resolution intent", var6);
      } finally {
         var1.dismiss();
      }
   }
}
