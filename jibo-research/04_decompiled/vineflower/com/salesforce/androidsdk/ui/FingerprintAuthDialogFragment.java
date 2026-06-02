package com.salesforce.androidsdk.ui;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import javax.crypto.Cipher;

@TargetApi(23)
public class FingerprintAuthDialogFragment extends DialogFragment {
   private Button a;
   private TextView b;
   private SalesforceR c;
   private Cipher d;
   private PasscodeActivity e;

   public void a(PasscodeActivity var1) {
      this.e = var1;
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setRetainInstance(true);
      this.setStyle(0, 16974393);
      this.c = SalesforceSDKManager.a().e();
   }

   public Dialog onCreateDialog(Bundle var1) {
      Dialog var2 = super.onCreateDialog(var1);
      var2.getWindow().requestFeature(1);
      return var2;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(this.c.H(), var2, false);
      this.a = (Button)var4.findViewById(this.c.I());
      this.a.setOnClickListener(new OnClickListener(this) {
         final FingerprintAuthDialogFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            this.a.dismiss();
         }
      });
      this.b = (TextView)var4.findViewById(this.c.J());
      return var4;
   }

   public void onResume() {
      super.onResume();
      if (VERSION.SDK_INT >= 23) {
         FingerprintManager var1 = (FingerprintManager)this.e.getSystemService("fingerprint");
         if (this.e.checkSelfPermission("android.permission.USE_FINGERPRINT") == 0) {
            var1.authenticate(new CryptoObject(this.d), null, 0, new AuthenticationCallback(this) {
               final FingerprintAuthDialogFragment a;

               {
                  this.a = var1;
               }

               public void onAuthenticationError(int var1, CharSequence var2) {
                  super.onAuthenticationError(var1, var2);
               }

               public void onAuthenticationFailed() {
                  super.onAuthenticationFailed();
                  if (this.a.b != null) {
                     this.a.b.setText(this.a.c.L());
                     this.a.b.setTextColor(-65536);
                  }
               }

               public void onAuthenticationHelp(int var1, CharSequence var2) {
                  super.onAuthenticationHelp(var1, var2);
                  if (this.a.b != null) {
                     this.a.b.setText(var2.toString());
                     this.a.b.setTextColor(-65536);
                  }
               }

               public void onAuthenticationSucceeded(AuthenticationResult var1) {
                  super.onAuthenticationSucceeded(var1);
                  if (this.a.b != null) {
                     this.a.b.setText(this.a.c.K());
                     this.a.b.setTextColor(-16711936);
                  }

                  if (this.a.getFragmentManager() != null) {
                     this.a.dismiss();
                  }

                  this.a.e.x();
               }
            }, null);
         }
      }
   }
}
