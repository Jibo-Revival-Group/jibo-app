package com.salesforce.android.cases.ui.internal.features.casefeed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.ui.internal.features.shared.CasesSdkActivity;
import com.salesforce.android.cases.ui.internal.utils.ViewUtils;

public class CaseFeedActivity extends AppCompatActivity implements CasesSdkActivity {
   private CaseFeedContract.View a;
   private CaseFeedActivityDelegate b = new CaseFeedActivityDelegate(this);

   public static void a(Context var0, String var1) {
      Intent var2 = new Intent(var0, CaseFeedActivity.class);
      var2.putExtra("EXTRA_CASE_ID", var1);
      var0.startActivity(var2);
   }

   public CaseFeedContract.View a() {
      return this.a;
   }

   public void finish() {
      super.finish();
      this.b.e();
   }

   @Override
   public void onBackPressed() {
      if (!this.b.c()) {
         super.onBackPressed();
      }
   }

   @Override
   protected void onCreate(Bundle var1) {
      AppStartTrace.setLauncherActivityOnCreateTime("com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedActivity");
      super.onCreate(var1);
      this.setContentView(R.layout.activity_case_feed);
      ViewUtils.a(this);
      this.a = this.findViewById(R.id.case_feed_view);
      this.b.a(var1);
      this.a.setCaseId(this.getIntent().getStringExtra("EXTRA_CASE_ID"));
   }

   @Override
   protected void onDestroy() {
      super.onDestroy();
      this.b.a();
   }

   @Override
   protected void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedActivity");
      super.onResume();
   }

   @Override
   protected void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      this.b.b(var1);
   }

   @Override
   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedActivity");
      super.onStart();
   }
}
