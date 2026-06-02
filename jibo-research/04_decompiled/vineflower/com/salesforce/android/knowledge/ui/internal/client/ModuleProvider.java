package com.salesforce.android.knowledge.ui.internal.client;

import com.salesforce.android.knowledge.ui.internal.activity.FragmentLoader;
import com.salesforce.android.knowledge.ui.internal.logging.LiveAgentKnowledgeLogger;
import com.salesforce.android.knowledge.ui.internal.minimize.MinimizeControl;
import com.salesforce.android.knowledge.ui.internal.navigation.Navigator;
import com.salesforce.android.knowledge.ui.internal.presenter.PresenterFactory;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;

interface ModuleProvider {
   Navigator a(KnowledgeUIClientImpl var1, Navigator.Listener... var2);

   PresenterFactory a(KnowledgeUIClientImpl var1);

   ActivityTracker a();

   FragmentLoader b();

   MinimizeControl b(KnowledgeUIClientImpl var1);

   LiveAgentKnowledgeLogger c(KnowledgeUIClientImpl var1);
}
