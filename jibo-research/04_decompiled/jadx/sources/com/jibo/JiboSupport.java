package com.jibo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.OnBoardingActivity;
import com.salesforce.android.cases.core.CaseClientCallbacks;
import com.salesforce.android.cases.core.CaseConfiguration;
import com.salesforce.android.cases.p020ui.CaseUI;
import com.salesforce.android.cases.p020ui.CaseUIClient;
import com.salesforce.android.cases.p020ui.CaseUIConfiguration;
import com.salesforce.android.knowledge.core.KnowledgeConfiguration;
import com.salesforce.android.knowledge.p022ui.KnowledgeUI;
import com.salesforce.android.knowledge.p022ui.KnowledgeUIClient;
import com.salesforce.android.knowledge.p022ui.KnowledgeUIConfiguration;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.androidsdk.analytics.security.Encryptor;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.smartstore.app.SmartStoreSDKManager;
import com.segment.analytics.Options;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class JiboSupport {

    /* JADX INFO: renamed from: a */
    private static KnowledgeUIClient f9269a = null;

    /* JADX INFO: renamed from: a */
    public static void m9869a(Context context) {
        SmartStoreSDKManager.m14662a(context, new SalesforceSDKManager.KeyInterface() { // from class: com.jibo.JiboSupport.1
            @Override // com.salesforce.androidsdk.app.SalesforceSDKManager.KeyInterface
            /* JADX INFO: renamed from: a */
            public String mo9871a(String str) {
                return Encryptor.m14375d(str + "12s9adpahk;n12-97sdainkasd=012", str + "12kl0dsakj4-cxh1qewkjasdol8");
            }
        }, (Class<? extends Activity>) OnBoardingActivity.class);
    }

    /* JADX INFO: renamed from: b */
    public static void m9870b(final Context context) {
        CaseUI.m12706a(context).m12711a(CaseUIConfiguration.m12723a(new CaseConfiguration.Builder("https://jibo.force.com/jibo", "NewCase").m12185a(new CaseClientCallbacks() { // from class: com.jibo.JiboSupport.2
            @Override // com.salesforce.android.cases.core.CaseClientCallbacks
            /* JADX INFO: renamed from: a */
            public Map<String, String> mo9872a() {
                Account accountM10134i = EntityData.m10089a(context).m10134i();
                HashMap map = new HashMap();
                map.put("Unauthenticated_User_Email__c", accountM10134i.getEmail());
                map.put("Account_ID__c", accountM10134i.getId());
                map.put("Account_OID__c", accountM10134i.getId());
                return map;
            }

            @Override // com.salesforce.android.cases.core.CaseClientCallbacks
            /* JADX INFO: renamed from: a */
            public boolean mo9873a(Bundle bundle) {
                return false;
            }

            @Override // com.salesforce.android.cases.core.CaseClientCallbacks
            /* JADX INFO: renamed from: b */
            public boolean mo9874b(Bundle bundle) {
                return false;
            }
        }).m12186a()));
        CaseUI.m12706a(context).m12712a().mo14074a(new Async.ResultHandler<CaseUIClient>() { // from class: com.jibo.JiboSupport.3
            @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
            /* JADX INFO: renamed from: a */
            public /* bridge */ /* synthetic */ void mo9875a(Async async, CaseUIClient caseUIClient) {
                a2((Async<?>) async, caseUIClient);
            }

            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
            public void a2(Async<?> async, CaseUIClient caseUIClient) {
                caseUIClient.mo12714a(context);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m9868a(final Activity activity) {
        if (f9269a != null) {
            f9269a.mo13391b();
            f9269a = null;
        }
        if (f9269a == null) {
            JiboAnalytics.m9856h(activity);
            KnowledgeUI.m13357a(KnowledgeUIConfiguration.m13396a(KnowledgeConfiguration.m13073a("https://jibo.force.com/jibo"), "Robot", Options.ALL_INTEGRATIONS_KEY)).m13358a(new JiboViewAddition()).m13360a(activity).mo14074a(new Async.ResultHandler<KnowledgeUIClient>() { // from class: com.jibo.JiboSupport.4
                @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
                /* JADX INFO: renamed from: a */
                public /* bridge */ /* synthetic */ void mo9875a(Async async, KnowledgeUIClient knowledgeUIClient) {
                    a2((Async<?>) async, knowledgeUIClient);
                }

                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
                public void a2(Async<?> async, KnowledgeUIClient knowledgeUIClient) {
                    KnowledgeUIClient unused = JiboSupport.f9269a = knowledgeUIClient;
                    knowledgeUIClient.mo13390a(new KnowledgeUIClient.OnCloseListener() { // from class: com.jibo.JiboSupport.4.1
                        @Override // com.salesforce.android.knowledge.ui.KnowledgeUIClient.OnCloseListener
                        /* JADX INFO: renamed from: a */
                        public void mo9876a() {
                            KnowledgeUIClient unused2 = JiboSupport.f9269a = null;
                        }
                    });
                    knowledgeUIClient.mo13392b(activity);
                }
            });
        }
    }
}
