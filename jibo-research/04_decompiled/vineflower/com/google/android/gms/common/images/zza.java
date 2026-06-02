package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.internal.zzbfl;

public abstract class zza {
   final zzb a;
   protected int b;

   final void a(Context var1, Bitmap var2, boolean var3) {
      zzc.a(var2);
      this.a(new BitmapDrawable(var1.getResources(), var2), var3, false, true);
   }

   final void a(Context var1, zzbfl var2, boolean var3) {
      Drawable var5 = null;
      if (this.b != 0) {
         int var4 = this.b;
         var5 = var1.getResources().getDrawable(var4);
      }

      this.a(var5, var3, false, false);
   }

   protected abstract void a(Drawable var1, boolean var2, boolean var3, boolean var4);
}
