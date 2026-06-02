package com.google.android.gms.common.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzbx extends com.google.android.gms.dynamic.zzp<zzbd> {
   private static final zzbx a = new zzbx();

   private zzbx() {
      super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
   }

   public static View a(Context var0, int var1, int var2) throws com.google.android.gms.dynamic.zzq {
      return a.b(var0, var1, var2);
   }

   private final View b(Context var1, int var2, int var3) throws com.google.android.gms.dynamic.zzq {
      try {
         zzbv var5 = new zzbv(var2, var3, null);
         IObjectWrapper var4 = com.google.android.gms.dynamic.zzn.a(var1);
         return com.google.android.gms.dynamic.zzn.a(((zzbd)this.a(var1)).a(var4, var5));
      } catch (Exception var6) {
         throw new com.google.android.gms.dynamic.zzq(
            new StringBuilder(64).append("Could not get button with size ").append(var2).append(" and color ").append(var3).toString(), var6
         );
      }
   }
}
