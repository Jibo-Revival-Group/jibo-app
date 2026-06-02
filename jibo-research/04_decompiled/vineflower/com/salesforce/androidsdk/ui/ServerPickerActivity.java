package com.salesforce.androidsdk.ui;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.salesforce.androidsdk.R;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.config.LoginServerManager;
import com.salesforce.androidsdk.config.RuntimeConfig;
import java.util.Iterator;
import java.util.List;

public class ServerPickerActivity extends Activity implements OnCheckedChangeListener {
   private CustomServerUrlEditor a;
   private SalesforceR b;
   private LoginServerManager c;

   private void a(RadioGroup var1, LoginServerManager.LoginServer var2) {
      var1.addView(new SalesforceServerRadioButton(this, var2.a, var2.b, var2.c));
   }

   private void d() {
      this.c.b();
      this.c();
      this.a = new CustomServerUrlEditor();
   }

   protected int a() {
      return this.b.W();
   }

   protected void b() {
      RadioGroup var1 = (RadioGroup)this.findViewById(this.a());
      List var2 = this.c.c();
      if (var2 != null) {
         Iterator var3 = var2.iterator();

         while (var3.hasNext()) {
            this.a(var1, (LoginServerManager.LoginServer)var3.next());
         }
      }
   }

   public void c() {
      RadioGroup var3 = (RadioGroup)this.findViewById(this.a());
      var3.removeAllViews();
      this.b();
      LoginServerManager.LoginServer var4 = this.c.a();
      int var2 = var3.getChildCount();

      for (int var1 = 0; var1 < var2; var1++) {
         SalesforceServerRadioButton var5 = (SalesforceServerRadioButton)var3.getChildAt(var1);
         if (var5 != null && new LoginServerManager.LoginServer(var5.getName(), var5.getUrl(), var5.b()).equals(var4)) {
            var5.setChecked(true);
         }
      }
   }

   public void onCheckedChanged(RadioGroup var1, int var2) {
      if (var1 != null) {
         SalesforceServerRadioButton var4 = (SalesforceServerRadioButton)var1.findViewById(var2);
         if (var4 != null) {
            String var6 = var4.getName();
            String var5 = var4.getUrl();
            boolean var3 = var4.b();
            this.c.a(new LoginServerManager.LoginServer(var6, var5, var3));
         }
      }
   }

   public void onCreate(Bundle var1) {
      AppStartTrace.setLauncherActivityOnCreateTime("com.salesforce.androidsdk.ui.ServerPickerActivity");
      super.onCreate(var1);
      this.b = SalesforceSDKManager.a().e();
      this.c = SalesforceSDKManager.a().l();
      this.setContentView(this.b.X());
      Button var2 = (Button)this.findViewById(R.id.sf__show_custom_url_edit);
      if (var2 != null && RuntimeConfig.a(this).c(RuntimeConfig.ConfigKey.OnlyShowAuthorizedHosts)) {
         var2.setVisibility(8);
      }

      ((RadioGroup)this.findViewById(this.a())).setOnCheckedChangeListener(this);
      this.a = new CustomServerUrlEditor();
      this.a.setRetainInstance(true);
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(this.b.aa(), var1);
      return super.onCreateOptionsMenu(var1);
   }

   public void onDestroy() {
      ((RadioGroup)this.findViewById(this.a())).setOnCheckedChangeListener(null);
      this.a = null;
      super.onDestroy();
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (var1.getItemId() == this.b.ab()) {
         this.d();
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   public void onResetClick(View var1) {
      this.d();
   }

   public void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.salesforce.androidsdk.ui.ServerPickerActivity");
      super.onResume();
      this.c();
   }

   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.salesforce.androidsdk.ui.ServerPickerActivity");
      super.onStart();
   }

   public void setCancelReturnValue(View var1) {
      this.onBackPressed();
   }

   public void setPositiveReturnValue(View var1) {
      this.setResult(-1, null);
      this.finish();
   }

   public void showCustomUrlDialog(View var1) {
      FragmentManager var2 = this.getFragmentManager();
      if (!this.a.isAdded()) {
         this.a.show(var2, "custom_server_dialog");
      }
   }
}
