package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.zzz;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzan;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzbr;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.internal.zzr;

public final class zzcxn extends zzab<zzcxl> implements zzcxd {
   private final boolean d = true;
   private final zzr e;
   private final Bundle f;
   private Integer g;

   private zzcxn(
      Context var1, Looper var2, boolean var3, zzr var4, Bundle var5, GoogleApiClient.ConnectionCallbacks var6, GoogleApiClient.OnConnectionFailedListener var7
   ) {
      super(var1, var2, 44, var4, var6, var7);
      this.e = var4;
      this.f = var5;
      this.g = var4.j();
   }

   public zzcxn(
      Context var1, Looper var2, boolean var3, zzr var4, zzcxe var5, GoogleApiClient.ConnectionCallbacks var6, GoogleApiClient.OnConnectionFailedListener var7
   ) {
      this(var1, var2, true, var4, a(var4), var6, var7);
   }

   public static Bundle a(zzr var0) {
      zzcxe var2 = var0.i();
      Integer var1 = var0.j();
      Bundle var3 = new Bundle();
      var3.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", var0.b());
      if (var1 != null) {
         var3.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", var1);
      }

      if (var2 != null) {
         var3.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", var2.a());
         var3.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", var2.b());
         var3.putString("com.google.android.gms.signin.internal.serverClientId", var2.c());
         var3.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
         var3.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", var2.d());
         var3.putString("com.google.android.gms.signin.internal.hostedDomain", var2.e());
         var3.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", var2.f());
         if (var2.g() != null) {
            var3.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", var2.g());
         }

         if (var2.h() != null) {
            var3.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", var2.h());
         }
      }

      return var3;
   }

   @Override
   public final void a(zzan var1, boolean var2) {
      try {
         ((zzcxl)this.v()).a(var1, this.g, var2);
      } catch (RemoteException var3) {
         Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public final void a(zzcxj var1) {
      zzbq.a(var1, "Expecting a valid ISignInCallbacks");

      RemoteException var2;
      label40: {
         Account var4;
         try {
            var4 = this.e.c();
         } catch (RemoteException var8) {
            var2 = var8;
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            break label40;
         }

         GoogleSignInAccount var9 = null;

         try {
            if ("<<default account>>".equals(var4.name)) {
               var9 = zzz.a(this.s()).a();
            }
         } catch (RemoteException var7) {
            var2 = var7;
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            break label40;
         }

         try {
            zzbr var11 = new zzbr(var4, this.g, var9);
            zzcxl var10 = (zzcxl)this.v();
            zzcxo var12 = new zzcxo(var11);
            var10.a(var12, var1);
            return;
         } catch (RemoteException var6) {
            var2 = var6;
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
         }
      }

      try {
         zzcxq var3 = new zzcxq(8);
         var1.a(var3);
      } catch (RemoteException var5) {
         Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", var2);
      }
   }

   @Override
   protected final String b() {
      return "com.google.android.gms.signin.internal.ISignInService";
   }

   @Override
   protected final String b_() {
      return "com.google.android.gms.signin.service.START";
   }

   @Override
   public final void e() {
      try {
         ((zzcxl)this.v()).a(this.g);
      } catch (RemoteException var2) {
         Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
      }
   }

   @Override
   public final boolean i() {
      return this.d;
   }

   @Override
   public final void m() {
      this.a(new zzm(this));
   }

   @Override
   protected final Bundle t() {
      String var1 = this.e.g();
      if (!this.s().getPackageName().equals(var1)) {
         this.f.putString("com.google.android.gms.signin.internal.realClientPackageName", this.e.g());
      }

      return this.f;
   }
}
