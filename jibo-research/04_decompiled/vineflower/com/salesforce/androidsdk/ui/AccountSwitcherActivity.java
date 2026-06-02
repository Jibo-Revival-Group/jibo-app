package com.salesforce.androidsdk.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.accounts.UserAccountManager;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import java.util.List;

public class AccountSwitcherActivity extends Activity {
   private SalesforceR a;
   private UserAccountManager b;

   private void a() {
      int var1 = 0;
      RadioGroup var6 = (RadioGroup)this.findViewById(this.a.al());
      var6.removeAllViews();
      UserAccount var4 = this.b.b();
      List var5 = this.b.d();
      if (var5 != null && var5.size() != 0) {
         if (var4 == null) {
            var4 = (UserAccount)var5.get(0);
         }

         int var2 = 0;

         while (var1 < var5.size()) {
            UserAccount var7 = (UserAccount)var5.get(var1);
            int var3 = var2;
            if (var7 != null) {
               this.a(var6, var7);
               var3 = var2;
               if (var7.equals(var4)) {
                  var3 = var1;
               }
            }

            var1++;
            var2 = var3;
         }

         SalesforceAccountRadioButton var8 = (SalesforceAccountRadioButton)var6.getChildAt(var2);
         if (var8 != null) {
            var8.setChecked(true);
         }
      }
   }

   private void a(RadioGroup var1, UserAccount var2) {
      var1.addView(new SalesforceAccountRadioButton(this, var2));
   }

   public void onCreate(Bundle var1) {
      AppStartTrace.setLauncherActivityOnCreateTime("com.salesforce.androidsdk.ui.AccountSwitcherActivity");
      super.onCreate(var1);
      this.a = SalesforceSDKManager.a().e();
      this.b = SalesforceSDKManager.a().o();
      this.setContentView(this.a.ak());
   }

   public void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.salesforce.androidsdk.ui.AccountSwitcherActivity");
      super.onResume();
      this.a();
   }

   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.salesforce.androidsdk.ui.AccountSwitcherActivity");
      super.onStart();
   }

   public void switchToExistingAccount(View var1) {
      RadioGroup var2 = (RadioGroup)this.findViewById(this.a.al());
      SalesforceAccountRadioButton var3 = (SalesforceAccountRadioButton)var2.findViewById(var2.getCheckedRadioButtonId());
      if (var3 != null) {
         UserAccount var4 = var3.getAccount();
         this.b.a(var4, -1, null);
      }

      this.finish();
   }

   public void switchToNewAccount(View var1) {
      this.b.e();
      this.finish();
   }
}
