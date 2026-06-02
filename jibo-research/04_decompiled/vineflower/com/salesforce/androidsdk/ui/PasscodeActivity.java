package com.salesforce.androidsdk.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.accounts.UserAccountManager;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.security.PasscodeManager;
import java.util.List;

public class PasscodeActivity extends Activity implements OnClickListener, OnEditorActionListener {
   private final int a = 11;
   private PasscodeActivity.PasscodeMode b;
   private TextView c;
   private TextView d;
   private TextView e;
   private EditText f;
   private PasscodeManager g;
   private String h;
   private SalesforceR i;
   private boolean j;
   private AlertDialog k;
   private boolean l;
   private FingerprintManager m;
   private FingerprintAuthDialogFragment n;

   @TargetApi(23)
   private boolean A() {
      if (VERSION.SDK_INT >= 23) {
         this.m = (FingerprintManager)this.getSystemService("fingerprint");
         if (this.checkSelfPermission("android.permission.USE_FINGERPRINT") == 0) {
            boolean var1;
            if (this.m != null && this.m.isHardwareDetected() && this.m.hasEnrolledFingerprints()) {
               var1 = true;
            } else {
               var1 = false;
            }

            return var1;
         }

         this.requestPermissions(new String[]{"android.permission.USE_FINGERPRINT"}, 11);
      }

      return false;
   }

   private AlertDialog y() {
      return new Builder(this).setMessage(this.n()).setPositiveButton(this.o(), new android.content.DialogInterface.OnClickListener(this) {
         final PasscodeActivity a;

         {
            this.a = var1;
         }

         public void onClick(DialogInterface var1, int var2) {
            UserAccountManager var4 = SalesforceSDKManager.a().o();
            List var5 = var4.d();
            if (var5 != null) {
               int var3 = var5.size();
               if (var3 > 0) {
                  for (int var6 = 0; var6 < var3 - 1; var6++) {
                     var4.a((UserAccount)var5.get(var6), null, false);
                  }

                  var4.a((UserAccount)var5.get(var3 - 1), this.a);
               }
            } else {
               var4.a(this.a);
            }
         }
      }).setNegativeButton(this.p(), new android.content.DialogInterface.OnClickListener(this) {
         final PasscodeActivity a;

         {
            this.a = var1;
         }

         public void onClick(DialogInterface var1, int var2) {
            this.a.l = false;
         }
      }).create();
   }

   private void z() {
      if (this.g != null && this.g.d() != null && this.A()) {
         this.n = new FingerprintAuthDialogFragment();
         this.n.a(this);
         this.n.show(this.getFragmentManager(), "fingerprintDialog");
      }
   }

   public PasscodeActivity.PasscodeMode a() {
      return this.b;
   }

   protected String a(int var1) {
      return this.getString(this.i.z(), new Object[]{var1});
   }

   public void a(PasscodeActivity.PasscodeMode var1) {
      if (var1 != this.b) {
         switch (<unrepresentable>.a[var1.ordinal()]) {
            case 1:
               this.c.setText(this.j());
               this.d.setText(this.l());
               this.e().setVisibility(0);
               break;
            case 2:
               this.c.setText(this.i());
               this.d.setText(this.q());
               this.e().setVisibility(4);
               break;
            case 3:
               this.c.setText(this.k());
               this.d.setText(this.s());
               this.e().setVisibility(4);
               break;
            case 4:
               this.c.setText(this.i());
               this.d.setText(this.r());
               this.e().setVisibility(4);
         }

         this.f.setText("");
         this.e.setText("");
         this.b = var1;
         this.f.requestFocus();
      }
   }

   protected boolean a(String var1) {
      boolean var5 = true;
      boolean var4;
      switch (<unrepresentable>.a[this.a().ordinal()]) {
         case 1:
            if (this.g.a(this, var1)) {
               this.g.a(var1);
               this.b();
               var4 = var5;
            } else {
               int var2 = this.g.b();
               this.f.setText("");
               int var3 = this.w();
               if (var2 < var3 - 1) {
                  this.e.setText(this.b(var3 - var2));
                  var4 = var5;
               } else if (var2 < var3) {
                  this.e.setText(this.t());
                  var4 = var5;
               } else {
                  this.g.a(this);
                  var4 = var5;
                  if (this.j) {
                     SalesforceSDKManager.a().a(this);
                     var4 = var5;
                  }
               }
            }
            break;
         case 2:
            this.h = var1;
            this.a(PasscodeActivity.PasscodeMode.CreateConfirm);
            var4 = var5;
            break;
         case 3:
            if (var1.equals(this.h)) {
               String var6 = this.g.d();
               this.g.b(this, var1);
               SalesforceSDKManager.a().b(var6, this.g.c(var1));
               this.g.a(var1);
               this.b();
               var4 = var5;
            } else {
               this.e.setText(this.u());
               var4 = var5;
            }
            break;
         case 4:
            this.h = var1;
            this.a(PasscodeActivity.PasscodeMode.CreateConfirm);
            var4 = var5;
            break;
         default:
            var4 = false;
      }

      return var4;
   }

   protected String b(int var1) {
      return this.getString(this.i.A(), new Object[]{var1});
   }

   protected void b() {
      this.setResult(-1);
      this.finish();
   }

   protected int c() {
      return this.i.m();
   }

   protected TextView d() {
      return (TextView)this.findViewById(this.i.n());
   }

   protected TextView e() {
      return (TextView)this.findViewById(this.i.r());
   }

   protected TextView f() {
      return (TextView)this.findViewById(this.i.o());
   }

   protected TextView g() {
      return (TextView)this.findViewById(this.i.p());
   }

   protected EditText h() {
      return (EditText)this.findViewById(this.i.q());
   }

   protected String i() {
      return String.format(this.getString(this.i.s()), SalesforceSDKManager.a().s());
   }

   protected String j() {
      return String.format(this.getString(this.i.t()), SalesforceSDKManager.a().s());
   }

   protected String k() {
      return String.format(this.getString(this.i.u()), SalesforceSDKManager.a().s());
   }

   protected String l() {
      return String.format(this.getString(this.i.v()), SalesforceSDKManager.a().s());
   }

   protected String m() {
      return this.getString(this.i.D());
   }

   protected String n() {
      return this.getString(this.i.E());
   }

   protected String o() {
      return this.getString(this.i.F());
   }

   public void onClick(View var1) {
      if (var1.equals(this.e())) {
         this.k.show();
         this.l = true;
      }
   }

   protected void onCreate(Bundle var1) {
      boolean var2 = false;
      AppStartTrace.setLauncherActivityOnCreateTime("com.salesforce.androidsdk.ui.PasscodeActivity");
      super.onCreate(var1);
      this.i = SalesforceSDKManager.a().e();
      this.getWindow().setFlags(8192, 8192);
      this.setContentView(this.c());
      TextView var3 = this.e();
      if (var3 != null) {
         var3.setText(Html.fromHtml(this.m()));
      }

      var3.setOnClickListener(this);
      this.k = this.y();
      this.c = this.d();
      this.e = this.f();
      this.d = this.g();
      this.f = this.h();
      this.f.setOnEditorActionListener(this);
      this.g = SalesforceSDKManager.a().n();
      Intent var4 = this.getIntent();
      if (var4 != null) {
         var2 = var4.getBooleanExtra("change_passcode", false);
      }

      if (var2) {
         this.a(PasscodeActivity.PasscodeMode.Change);
      } else {
         PasscodeActivity.PasscodeMode var5;
         if (this.g.b(this)) {
            var5 = PasscodeActivity.PasscodeMode.Check;
         } else {
            var5 = PasscodeActivity.PasscodeMode.Create;
         }

         this.a(var5);
         this.z();
      }

      this.j = true;
      if (var1 != null) {
         String var6 = var1.getString("input_text");
         if (this.f != null && var6 != null) {
            this.f.setText(var6.trim());
         }

         this.l = var1.getBoolean("logout_key");
         if (this.l) {
            this.k.show();
         }
      }
   }

   public boolean onEditorAction(TextView var1, int var2, KeyEvent var3) {
      boolean var5 = true;
      if (var2 != 2) {
         boolean var4 = var5;
         if (var3 == null) {
            return var4;
         }

         var4 = var5;
         if (var3.getAction() != 1) {
            return var4;
         }
      }

      String var6 = this.f.getText().toString();
      boolean var8;
      if (var6.length() >= 0 && var6.length() < this.v()) {
         this.e.setText(this.a(this.v()));
         var8 = var5;
      } else if (var6.length() > 0) {
         var8 = this.a(var6);
      } else {
         var8 = false;
      }

      return var8;
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      boolean var3 = true;
      if (var1 == 4) {
         this.moveTaskToBack(true);
      } else {
         var3 = super.onKeyDown(var1, var2);
      }

      return var3;
   }

   public void onRequestPermissionsResult(int var1, String[] var2, int[] var3) {
      if (var1 == 11 && var3[0] == 0) {
         this.z();
      } else {
         super.onRequestPermissionsResult(var1, var2, var3);
      }
   }

   protected void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.salesforce.androidsdk.ui.PasscodeActivity");
      super.onResume();
   }

   protected void onSaveInstanceState(Bundle var1) {
      if (this.f != null && this.f.getText() != null) {
         var1.putString("input_text", this.f.getText().toString());
      }

      if (this.l) {
         this.k.dismiss();
         var1.putBoolean("logout_key", true);
         this.l = false;
      }
   }

   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.salesforce.androidsdk.ui.PasscodeActivity");
      super.onStart();
   }

   protected String p() {
      return this.getString(this.i.G());
   }

   protected String q() {
      return String.format(this.getString(this.i.w()), SalesforceSDKManager.a().s());
   }

   protected String r() {
      return this.getString(this.i.x());
   }

   protected String s() {
      return String.format(this.getString(this.i.y()), SalesforceSDKManager.a().s());
   }

   protected String t() {
      return this.getString(this.i.B());
   }

   protected String u() {
      return this.getString(this.i.C());
   }

   protected int v() {
      return this.g.h();
   }

   protected int w() {
      return 10;
   }

   public void x() {
      this.g.j();
      this.b();
   }

   public enum PasscodeMode {
      Change,
      Check,
      Create,
      CreateConfirm;

      private static final PasscodeActivity.PasscodeMode[] $VALUES = new PasscodeActivity.PasscodeMode[]{
         PasscodeActivity.PasscodeMode.Create,
         PasscodeActivity.PasscodeMode.CreateConfirm,
         PasscodeActivity.PasscodeMode.Check,
         PasscodeActivity.PasscodeMode.Change
      };
   }
}
