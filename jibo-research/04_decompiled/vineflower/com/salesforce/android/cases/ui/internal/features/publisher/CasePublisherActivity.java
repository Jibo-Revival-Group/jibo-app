package com.salesforce.android.cases.ui.internal.features.publisher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.ui.internal.features.shared.CasesSdkActivity;
import com.salesforce.android.cases.ui.internal.utils.ViewUtils;

public class CasePublisherActivity extends AppCompatActivity implements CasesSdkActivity {
   private CasePublisherContract.View a;
   private CasePublisherActivityDelegate b = new CasePublisherActivityDelegate(this);

   public static void a(Context var0) {
      var0.startActivity(new Intent(var0, CasePublisherActivity.class));
   }

   public CasePublisherContract.View a() {
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
      AppStartTrace.setLauncherActivityOnCreateTime("com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherActivity");
      super.onCreate(var1);
      this.setContentView(R.layout.activity_case_publisher);
      ViewUtils.a(this);
      this.a = this.findViewById(R.id.case_publisher_view);
      this.b.a(var1);
   }

   @Override
   protected void onDestroy() {
      super.onDestroy();
      this.b.a();
   }

   @Override
   protected void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherActivity");
      super.onResume();
   }

   @Override
   protected void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      this.b.b(var1);
   }

   @Override
   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherActivity");
      super.onStart();
   }
}
