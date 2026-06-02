package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

@KeepName
public class SignInHubActivity extends FragmentActivity {
   private static boolean a = false;
   private boolean b = false;
   private SignInConfiguration c;
   private boolean d;
   private int e;
   private Intent f;

   private final void a() {
      this.getSupportLoaderManager().a(0, null, new SignInHubActivity.zza(this, null));
      a = false;
   }

   private final void a(int var1) {
      Status var3 = new Status(var1);
      Intent var2 = new Intent();
      var2.putExtra("googleSignInStatus", var3);
      this.setResult(0, var2);
      this.finish();
      a = false;
   }

   public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent var1) {
      return true;
   }

   @Override
   protected void onActivityResult(int var1, int var2, Intent var3) {
      if (!this.b) {
         this.setResult(0);
         switch (var1) {
            case 40962:
               if (var3 != null) {
                  SignInAccount var4 = (SignInAccount)var3.getParcelableExtra("signInAccount");
                  if (var4 != null && var4.a() != null) {
                     GoogleSignInAccount var5 = var4.a();
                     zzo.a(this).a(this.c.a(), var5);
                     var3.removeExtra("signInAccount");
                     var3.putExtra("googleSignInAccount", var5);
                     this.d = true;
                     this.e = var2;
                     this.f = var3;
                     this.a();
                     return;
                  }

                  if (var3.hasExtra("errorCode")) {
                     this.a(var3.getIntExtra("errorCode", 8));
                     return;
                  }
               }

               this.a(8);
         }
      }
   }

   @Override
   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      Intent var3 = this.getIntent();
      String var2 = var3.getAction();
      if ("com.google.android.gms.auth.NO_IMPL".equals(var2)) {
         this.a(12500);
      } else if (a) {
         this.setResult(0);
         this.a(12502);
      } else {
         a = true;
         if (!var2.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !var2.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            String var6 = String.valueOf(var3.getAction());
            String var7;
            if (var6.length() != 0) {
               var7 = "Unknown action: ".concat(var6);
            } else {
               var7 = new String("Unknown action: ");
            }

            Log.e("AuthSignInClient", var7);
            this.finish();
         } else {
            this.c = (SignInConfiguration)var3.getBundleExtra("config").getParcelable("config");
            if (this.c == null) {
               Log.e("AuthSignInClient", "Activity started with invalid configuration.");
               this.setResult(0);
               this.finish();
            } else if (var1 == null) {
               Intent var5 = new Intent(var2);
               if (var2.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
                  var5.setPackage("com.google.android.gms");
               } else {
                  var5.setPackage(this.getPackageName());
               }

               var5.putExtra("config", this.c);

               try {
                  this.startActivityForResult(var5, 40962);
               } catch (ActivityNotFoundException var4) {
                  this.b = true;
                  Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
                  this.a(17);
               }
            } else {
               this.d = var1.getBoolean("signingInGoogleApiClients");
               if (this.d) {
                  this.e = var1.getInt("signInResultCode");
                  this.f = (Intent)var1.getParcelable("signInResultData");
                  this.a();
               }
            }
         }
      }
   }

   @Override
   protected void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putBoolean("signingInGoogleApiClients", this.d);
      if (this.d) {
         var1.putInt("signInResultCode", this.e);
         var1.putParcelable("signInResultData", this.f);
      }
   }

   final class zza implements LoaderManager.LoaderCallbacks<Void> {
      private SignInHubActivity a;

      private zza(SignInHubActivity var1) {
         this.a = var1;
         super();
      }

      @Override
      public final Loader<Void> a(int var1, Bundle var2) {
         return new zzb(this.a, GoogleApiClient.a());
      }

      @Override
      public final void a(Loader<Void> var1) {
      }
   }
}
