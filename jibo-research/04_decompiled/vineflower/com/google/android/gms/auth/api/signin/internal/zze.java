package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzbm;
import com.google.android.gms.internal.zzbgg;
import java.util.Iterator;

public final class zze {
   private static zzbgg a = new zzbgg("GoogleSignInCommon");

   public static Intent a(Context var0, GoogleSignInOptions var1) {
      a.a("getSignInIntent()");
      SignInConfiguration var4 = new SignInConfiguration(var0.getPackageName(), var1);
      Intent var2 = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
      var2.setPackage(var0.getPackageName());
      var2.setClass(var0, SignInHubActivity.class);
      Bundle var3 = new Bundle();
      var3.putParcelable("config", var4);
      var2.putExtra("config", var3);
      return var2;
   }

   public static PendingResult<Status> a(GoogleApiClient var0, Context var1, boolean var2) {
      a.a("Revoking access");
      a(var1);
      PendingResult var3;
      if (var2) {
         var3 = PendingResults.a(Status.f, var0);
      } else {
         var3 = var0.b(new zzj(var0));
      }

      return var3;
   }

   private static void a(Context var0) {
      zzo.a(var0).a();
      Iterator var1 = GoogleApiClient.a().iterator();

      while (var1.hasNext()) {
         ((GoogleApiClient)var1.next()).d();
      }

      zzbm.b();
   }
}
