package com.salesforce.android.knowledge.ui.internal.client;

import com.salesforce.android.knowledge.ui.internal.activity.FragmentLoader;
import com.salesforce.android.knowledge.ui.internal.logging.LiveAgentKnowledgeLogger;
import com.salesforce.android.knowledge.ui.internal.minimize.MinimizeControl;
import com.salesforce.android.knowledge.ui.internal.navigation.Navigator;
import com.salesforce.android.knowledge.ui.internal.presenter.PresenterFactory;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;

public class RuntimeModuleProvider implements ModuleProvider {
   @Override
   public Navigator a(KnowledgeUIClientImpl var1, Navigator.Listener... var2) {
      Navigator.Builder var5 = Navigator.a(var1);
      int var4 = var2.length;

      for (int var3 = 0; var3 < var4; var3++) {
         var5.a(var2[var3]);
      }

      return var5.a();
   }

   @Override
   public PresenterFactory a(KnowledgeUIClientImpl var1) {
      return PresenterFactory.a(var1);
   }

   @Override
   public ActivityTracker a() {
      return new ActivityTracker();
   }

   @Override
   public FragmentLoader b() {
      return FragmentLoader.a().a();
   }

   @Override
   public MinimizeControl b(KnowledgeUIClientImpl var1) {
      return new MinimizeControl(var1);
   }

   @Override
   public LiveAgentKnowledgeLogger c(KnowledgeUIClientImpl var1) {
      return LiveAgentKnowledgeLogger.a(var1.c().a(), var1.f().f(), var1.f().b(), var1.k());
   }
}
