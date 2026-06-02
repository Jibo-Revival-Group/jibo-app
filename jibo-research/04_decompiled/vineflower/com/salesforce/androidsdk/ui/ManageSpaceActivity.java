package com.salesforce.androidsdk.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.salesforce.androidsdk.app.SalesforceSDKManager;

public class ManageSpaceActivity extends Activity {
   private SalesforceR a;
   private AlertDialog b;

   protected AlertDialog a() {
      return new Builder(this).setMessage(this.a.aj()).setPositiveButton(this.getString(this.a.F()), new OnClickListener(this) {
         final ManageSpaceActivity a;

         {
            this.a = var1;
         }

         public void onClick(DialogInterface var1, int var2) {
            SalesforceSDKManager.a().a(this.a, false);
         }
      }).setNegativeButton(this.getString(this.a.G()), new OnClickListener(this) {
         final ManageSpaceActivity a;

         {
            this.a = var1;
         }

         public void onClick(DialogInterface var1, int var2) {
            this.a.finish();
         }
      }).create();
   }

   public void onCreate(Bundle var1) {
      AppStartTrace.setLauncherActivityOnCreateTime("com.salesforce.androidsdk.ui.ManageSpaceActivity");
      super.onCreate(var1);
      this.a = SalesforceSDKManager.a().e();
      this.setContentView(this.a.ai());
      this.b = this.a();
      this.b.show();
   }

   public void onDestroy() {
      this.b.dismiss();
      super.onDestroy();
   }

   protected void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.salesforce.androidsdk.ui.ManageSpaceActivity");
      super.onResume();
   }

   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.salesforce.androidsdk.ui.ManageSpaceActivity");
      super.onStart();
   }
}
