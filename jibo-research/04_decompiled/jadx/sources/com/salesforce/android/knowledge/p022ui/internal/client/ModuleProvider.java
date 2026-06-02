package com.salesforce.android.knowledge.p022ui.internal.client;

import com.salesforce.android.knowledge.p022ui.internal.activity.FragmentLoader;
import com.salesforce.android.knowledge.p022ui.internal.logging.LiveAgentKnowledgeLogger;
import com.salesforce.android.knowledge.p022ui.internal.minimize.MinimizeControl;
import com.salesforce.android.knowledge.p022ui.internal.navigation.Navigator;
import com.salesforce.android.knowledge.p022ui.internal.presenter.PresenterFactory;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;

/* JADX INFO: loaded from: classes.dex */
interface ModuleProvider {
    /* JADX INFO: renamed from: a */
    Navigator mo13540a(KnowledgeUIClientImpl knowledgeUIClientImpl, Navigator.Listener... listenerArr);

    /* JADX INFO: renamed from: a */
    PresenterFactory mo13541a(KnowledgeUIClientImpl knowledgeUIClientImpl);

    /* JADX INFO: renamed from: a */
    ActivityTracker mo13542a();

    /* JADX INFO: renamed from: b */
    FragmentLoader mo13543b();

    /* JADX INFO: renamed from: b */
    MinimizeControl mo13544b(KnowledgeUIClientImpl knowledgeUIClientImpl);

    /* JADX INFO: renamed from: c */
    LiveAgentKnowledgeLogger mo13545c(KnowledgeUIClientImpl knowledgeUIClientImpl);
}
