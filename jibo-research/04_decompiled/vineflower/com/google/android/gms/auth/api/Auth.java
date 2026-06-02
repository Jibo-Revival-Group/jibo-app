package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.zzaur;
import com.google.android.gms.internal.zzaus;
import com.google.android.gms.internal.zzaut;
import com.google.android.gms.internal.zzavp;
import com.google.android.gms.internal.zzavy;
import com.google.android.gms.internal.zzawx;

public final class Auth {
   public static final Api.zzf<zzavy> a = new Api.zzf<>();
   public static final Api.zzf<com.google.android.gms.auth.api.signin.internal.zzd> b = new Api.zzf<>();
   public static final Api<zzf> c = zzd.a;
   public static final Api<Auth.AuthCredentialsOptions> d = new Api<>("Auth.CREDENTIALS_API", Auth.j, a);
   public static final Api<GoogleSignInOptions> e = new Api<>("Auth.GOOGLE_SIGN_IN_API", Auth.l, b);
   public static final ProxyApi f = new zzawx();
   public static final CredentialsApi g = new zzavp();
   public static final GoogleSignInApi h = new com.google.android.gms.auth.api.signin.internal.zzc();
   private static Api.zzf<zzaut> i = new Api.zzf<>();
   private static final Api.zza<zzavy, Auth.AuthCredentialsOptions> j = new zza();
   private static final Api.zza<zzaut, Object> k = new zzb();
   private static final Api.zza<com.google.android.gms.auth.api.signin.internal.zzd, GoogleSignInOptions> l = new zzc();
   private static Api<Object> m = new Api<>("Auth.ACCOUNT_STATUS_API", k, i);
   private static zzaur n = new zzaus();

   @Deprecated
   public static class AuthCredentialsOptions implements Api.ApiOptions.Optional {
      private static Auth.AuthCredentialsOptions a = new Auth.AuthCredentialsOptions.Builder().a();
      private final String b = null;
      private final PasswordSpecification c;
      private final boolean d;

      public AuthCredentialsOptions(Auth.AuthCredentialsOptions.Builder var1) {
         this.c = var1.a;
         this.d = var1.b;
      }

      public final Bundle a() {
         Bundle var1 = new Bundle();
         var1.putString("consumer_package", null);
         var1.putParcelable("password_specification", this.c);
         var1.putBoolean("force_save_dialog", this.d);
         return var1;
      }

      @Deprecated
      public static class Builder {
         protected PasswordSpecification a;
         protected Boolean b;

         public Builder() {
            this.a = PasswordSpecification.a;
            this.b = false;
         }

         public Auth.AuthCredentialsOptions a() {
            return new Auth.AuthCredentialsOptions(this);
         }
      }
   }
}
