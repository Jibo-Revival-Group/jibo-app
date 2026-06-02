package com.salesforce.android.knowledge.ui;

import android.app.Activity;
import com.salesforce.android.knowledge.core.KnowledgeClient;

public interface KnowledgeUIClient {
   void a(KnowledgeUIClient.OnCloseListener var1);

   void b();

   void b(Activity var1);

   KnowledgeClient c();

   KnowledgeCssProvider d();

   KnowledgeJsProvider e();

   interface OnCloseListener {
      void a();
   }
}
