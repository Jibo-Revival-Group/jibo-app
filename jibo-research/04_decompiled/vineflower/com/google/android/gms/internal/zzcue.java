package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.Api;

public final class zzcue {
   private static final Api.zzf<zzcut> a = new Api.zzf<>();
   private static final Api.zza<zzcut, Object> b = new zzcuf();
   @Deprecated
   private static Api<Object> c = new Api<>("Phenotype.API", b, a);
   @Deprecated
   private static zzcug d = new zzcus();

   public static Uri a(String var0) {
      var0 = String.valueOf(Uri.encode(var0));
      if (var0.length() != 0) {
         var0 = "content://com.google.android.gms.phenotype/".concat(var0);
      } else {
         var0 = new String("content://com.google.android.gms.phenotype/");
      }

      return Uri.parse(var0);
   }
}
