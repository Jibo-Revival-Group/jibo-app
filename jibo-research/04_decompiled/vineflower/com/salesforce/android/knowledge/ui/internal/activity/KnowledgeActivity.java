package com.salesforce.android.knowledge.ui.internal.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.salesforce.android.knowledge.ui.R;
import com.salesforce.android.knowledge.ui.internal.client.KnowledgeUIClientImpl;

public class KnowledgeActivity extends AppCompatActivity {
   private KnowledgeUIClientImpl a;

   public static void a(Context var0) {
      Intent var1 = new Intent(var0, KnowledgeActivity.class);
      var1.addFlags(65536);
      var0.startActivity(var1);
   }

   public KnowledgeUIClientImpl a() {
      return this.a;
   }

   public void a(KnowledgeUIClientImpl var1) {
      this.a = var1;
   }

   @Override
   public void onBackPressed() {
      if (this.a != null) {
         this.a.m();
      } else {
         super.onBackPressed();
      }
   }

   @Override
   protected void onCreate(Bundle var1) {
      AppStartTrace.setLauncherActivityOnCreateTime("com.salesforce.android.knowledge.ui.internal.activity.KnowledgeActivity");
      super.onCreate(var1);
      this.setContentView(R.layout.knowledge_activity);
   }

   @Override
   protected void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.salesforce.android.knowledge.ui.internal.activity.KnowledgeActivity");
      super.onResume();
   }

   @Override
   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.salesforce.android.knowledge.ui.internal.activity.KnowledgeActivity");
      super.onStart();
   }
}
