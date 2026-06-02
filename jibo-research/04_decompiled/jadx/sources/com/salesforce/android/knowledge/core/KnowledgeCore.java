package com.salesforce.android.knowledge.core;

import android.content.Context;
import com.salesforce.android.knowledge.core.internal.client.KnowledgeClientImpl;
import com.salesforce.android.knowledge.core.offline.OfflineResourceCache;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.functional.Function;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.smartstore.app.SmartStoreSDKManager;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class KnowledgeCore {

    /* JADX INFO: renamed from: b */
    private static final ServiceLogger f12883b = ServiceLogging.m14203a((Class<?>) KnowledgeCore.class);

    /* JADX INFO: renamed from: a */
    private final KnowledgeConfiguration f12884a;

    /* JADX INFO: renamed from: a */
    public static KnowledgeCore m13081a(KnowledgeConfiguration knowledgeConfiguration) {
        return new KnowledgeCore(knowledgeConfiguration);
    }

    private KnowledgeCore(KnowledgeConfiguration knowledgeConfiguration) {
        this.f12884a = knowledgeConfiguration;
    }

    /* JADX INFO: renamed from: a */
    public Async<KnowledgeClient> m13083a(Context context) {
        try {
            Arguments.m14237a(context);
            if (!m13082a()) {
                throw new IllegalStateException("Smartstore was not initialized. Offline storage will not work if SmartStoreSDKManager.initNative is not called.");
            }
            final KnowledgeClientImpl knowledgeClientImplM13086a = KnowledgeClientImpl.m13085a(this.f12884a).m13086a(context);
            return knowledgeClientImplM13086a.mo13071b().m13295b().m13289a().mo14076a(new Function<OfflineResourceCache, KnowledgeClient>() { // from class: com.salesforce.android.knowledge.core.KnowledgeCore.1
                @Override // com.salesforce.android.service.common.utilities.functional.Function
                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public KnowledgeClient mo12236a(OfflineResourceCache offlineResourceCache) {
                    return knowledgeClientImplM13086a;
                }
            });
        } catch (GeneralSecurityException e) {
            return BasicAsync.m14085c((Throwable) e);
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m13082a() {
        return SalesforceSDKManager.m14415b() && (SalesforceSDKManager.m14403a() instanceof SmartStoreSDKManager);
    }
}
