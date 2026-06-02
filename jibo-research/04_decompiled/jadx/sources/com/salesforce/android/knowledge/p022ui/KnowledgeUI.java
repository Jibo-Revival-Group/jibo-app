package com.salesforce.android.knowledge.p022ui;

import android.content.Context;
import com.salesforce.android.knowledge.core.KnowledgeClient;
import com.salesforce.android.knowledge.core.KnowledgeCore;
import com.salesforce.android.knowledge.p022ui.internal.client.KnowledgeUIClientImpl;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.functional.Function;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class KnowledgeUI {

    /* JADX INFO: renamed from: a */
    final KnowledgeUIConfiguration f13085a;

    /* JADX INFO: renamed from: b */
    KnowledgeClient f13086b;

    /* JADX INFO: renamed from: c */
    final Set<KnowledgeViewAddition> f13087c = new HashSet();

    /* JADX INFO: renamed from: a */
    public static KnowledgeUI m13357a(KnowledgeUIConfiguration knowledgeUIConfiguration) {
        return new KnowledgeUI(knowledgeUIConfiguration);
    }

    private KnowledgeUI(KnowledgeUIConfiguration knowledgeUIConfiguration) {
        this.f13085a = knowledgeUIConfiguration;
    }

    /* JADX INFO: renamed from: a */
    public KnowledgeUI m13358a(KnowledgeViewAddition knowledgeViewAddition) {
        this.f13087c.add(knowledgeViewAddition);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public Async<KnowledgeUIClient> m13360a(Context context) {
        Async asyncMo14076a;
        KnowledgeUIAnalyticsEmit.m13365a(this.f13085a.m13397a().m13075a(), this.f13085a.m13402f(), this.f13085a.m13398b(), Boolean.valueOf(this.f13086b != null), Boolean.valueOf(this.f13085a.m13399c() != null));
        if (this.f13086b != null) {
            asyncMo14076a = BasicAsync.m14084c(m13359a(this.f13086b));
        } else {
            asyncMo14076a = KnowledgeCore.m13081a(this.f13085a.m13397a()).m13083a(context).mo14076a(new Function<KnowledgeClient, KnowledgeUIClient>() { // from class: com.salesforce.android.knowledge.ui.KnowledgeUI.1
                @Override // com.salesforce.android.service.common.utilities.functional.Function
                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public KnowledgeUIClient mo12236a(KnowledgeClient knowledgeClient) {
                    KnowledgeUIClientImpl knowledgeUIClientImplM13359a = KnowledgeUI.this.m13359a(knowledgeClient);
                    knowledgeClient.mo13070a(knowledgeUIClientImplM13359a);
                    return knowledgeUIClientImplM13359a;
                }
            });
        }
        asyncMo14076a.mo14074a(new Async.ResultHandler<KnowledgeUIClient>() { // from class: com.salesforce.android.knowledge.ui.KnowledgeUI.2
            @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
            /* JADX INFO: renamed from: a */
            public /* bridge */ /* synthetic */ void mo9875a(Async async, KnowledgeUIClient knowledgeUIClient) {
                a2((Async<?>) async, knowledgeUIClient);
            }

            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
            public void a2(Async<?> async, KnowledgeUIClient knowledgeUIClient) {
                KnowledgeUIAnalyticsEmit.m13366b();
            }
        });
        return asyncMo14076a;
    }

    /* JADX INFO: renamed from: a */
    KnowledgeUIClientImpl m13359a(KnowledgeClient knowledgeClient) {
        return KnowledgeUIClientImpl.m13526a(this.f13085a, knowledgeClient, this.f13087c);
    }
}
