package com.salesforce.android.knowledge.p022ui.internal.client;

import com.salesforce.android.knowledge.p022ui.internal.activity.FragmentLoader;
import com.salesforce.android.knowledge.p022ui.internal.logging.LiveAgentKnowledgeLogger;
import com.salesforce.android.knowledge.p022ui.internal.minimize.MinimizeControl;
import com.salesforce.android.knowledge.p022ui.internal.navigation.Navigator;
import com.salesforce.android.knowledge.p022ui.internal.presenter.PresenterFactory;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;

/* JADX INFO: loaded from: classes.dex */
public class RuntimeModuleProvider implements ModuleProvider {
    @Override // com.salesforce.android.knowledge.p022ui.internal.client.ModuleProvider
    /* JADX INFO: renamed from: a */
    public ActivityTracker mo13542a() {
        return new ActivityTracker();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.client.ModuleProvider
    /* JADX INFO: renamed from: b */
    public FragmentLoader mo13543b() {
        return FragmentLoader.m13422a().m13430a();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.client.ModuleProvider
    /* JADX INFO: renamed from: a */
    public PresenterFactory mo13541a(KnowledgeUIClientImpl knowledgeUIClientImpl) {
        return PresenterFactory.m13655a(knowledgeUIClientImpl);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.client.ModuleProvider
    /* JADX INFO: renamed from: b */
    public MinimizeControl mo13544b(KnowledgeUIClientImpl knowledgeUIClientImpl) {
        return new MinimizeControl(knowledgeUIClientImpl);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.client.ModuleProvider
    /* JADX INFO: renamed from: a */
    public Navigator mo13540a(KnowledgeUIClientImpl knowledgeUIClientImpl, Navigator.Listener... listenerArr) {
        Navigator.Builder builderM13633a = Navigator.m13633a(knowledgeUIClientImpl);
        for (Navigator.Listener listener : listenerArr) {
            builderM13633a.m13649a(listener);
        }
        return builderM13633a.m13650a();
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.client.ModuleProvider
    /* JADX INFO: renamed from: c */
    public LiveAgentKnowledgeLogger mo13545c(KnowledgeUIClientImpl knowledgeUIClientImpl) {
        return LiveAgentKnowledgeLogger.m13599a(knowledgeUIClientImpl.mo13393c().mo13069a(), knowledgeUIClientImpl.m13531f().m13402f(), knowledgeUIClientImpl.m13531f().m13398b(), knowledgeUIClientImpl.m13536k());
    }
}
