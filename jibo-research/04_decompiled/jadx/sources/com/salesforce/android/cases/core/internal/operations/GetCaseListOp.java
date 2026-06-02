package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.http.util.CaseConstants;
import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.internal.util.StringUtils;
import com.salesforce.android.cases.core.model.CaseListFeedRecord;
import com.salesforce.android.cases.core.model.CaseListRecord;
import com.salesforce.android.cases.core.requests.CaseListRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.functional.Function;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GetCaseListOp extends CaseFetchSaveOperation<CaseListRequest, List<CaseListRecord>> {
    GetCaseListOp(CaseListRequest caseListRequest, LocalRepository localRepository, RemoteRepository remoteRepository) {
        super(caseListRequest, localRepository, remoteRepository);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<List<CaseListRecord>> mo12510a(RemoteRepository remoteRepository, CaseListRequest caseListRequest) {
        return remoteRepository.m12596a(caseListRequest).mo14078b(new SetUnreadStatusFunction()).mo14078b(new SetHiddenStatusFunction());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<List<CaseListRecord>> mo12508a(LocalRepository localRepository, CaseListRequest caseListRequest) {
        return localRepository.mo12379a(caseListRequest).mo14078b(new SetUnreadStatusFunction()).mo14078b(new SetHiddenStatusFunction());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<Void> mo12509a(LocalRepository localRepository, CaseListRequest caseListRequest, List<CaseListRecord> list) {
        return localRepository.mo12380a(caseListRequest, list);
    }

    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: b */
    protected String mo12514b() {
        return "Cannot Get Case List, Offline";
    }

    private class SetUnreadStatusFunction implements Function<List<CaseListRecord>, Async<List<CaseListRecord>>> {
        private SetUnreadStatusFunction() {
        }

        @Override // com.salesforce.android.service.common.utilities.functional.Function
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public Async<List<CaseListRecord>> mo12236a(List<CaseListRecord> list) {
            return m12529b(list);
        }

        /* JADX INFO: renamed from: b */
        private Async<List<CaseListRecord>> m12529b(final List<CaseListRecord> list) {
            if (GetCaseListOp.this.f12516a == null) {
                return BasicAsync.m14087h();
            }
            return GetCaseListOp.this.f12516a.mo12374a().mo14078b(new Function<Map<String, Date>, Async<List<CaseListRecord>>>() { // from class: com.salesforce.android.cases.core.internal.operations.GetCaseListOp.SetUnreadStatusFunction.1
                @Override // com.salesforce.android.service.common.utilities.functional.Function
                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public Async<List<CaseListRecord>> mo12236a(Map<String, Date> map) {
                    List<UserAccount> listM14277d = SalesforceSDKManager.m14403a().m14450o().m14277d();
                    for (CaseListRecord caseListRecord : list) {
                        String strMo12466b = caseListRecord.mo12466b();
                        if (!map.containsKey(strMo12466b)) {
                            caseListRecord.mo12465a(SetUnreadStatusFunction.this.m12528a(caseListRecord, CaseConstants.f12329a, listM14277d));
                        } else {
                            caseListRecord.mo12465a(SetUnreadStatusFunction.this.m12528a(caseListRecord, map.get(strMo12466b), listM14277d));
                        }
                    }
                    return BasicAsync.m14084c(list);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public boolean m12528a(CaseListRecord caseListRecord, Date date, List<UserAccount> list) {
            Date dateMo12462c;
            CaseListFeedRecord caseListFeedRecordMo12472g = caseListRecord.mo12472g();
            if (caseListFeedRecordMo12472g == null || (dateMo12462c = caseListFeedRecordMo12472g.mo12462c()) == null) {
                return false;
            }
            if (!dateMo12462c.after(date)) {
                return false;
            }
            String strMo12461b = caseListFeedRecordMo12472g.mo12461b();
            if (strMo12461b == null || strMo12461b.isEmpty()) {
                return false;
            }
            Iterator<UserAccount> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().m14247g().equals(strMo12461b)) {
                    return false;
                }
            }
            return true;
        }
    }

    private class SetHiddenStatusFunction implements Function<List<CaseListRecord>, Async<List<CaseListRecord>>> {
        private SetHiddenStatusFunction() {
        }

        @Override // com.salesforce.android.service.common.utilities.functional.Function
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public Async<List<CaseListRecord>> mo12236a(List<CaseListRecord> list) {
            return m12526b(list);
        }

        /* JADX INFO: renamed from: b */
        private Async<List<CaseListRecord>> m12526b(final List<CaseListRecord> list) {
            if (GetCaseListOp.this.f12516a == null) {
                return BasicAsync.m14087h();
            }
            return GetCaseListOp.this.f12516a.mo12392b().mo14078b(new Function<Map<String, Boolean>, Async<List<CaseListRecord>>>() { // from class: com.salesforce.android.cases.core.internal.operations.GetCaseListOp.SetHiddenStatusFunction.1
                @Override // com.salesforce.android.service.common.utilities.functional.Function
                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public Async<List<CaseListRecord>> mo12236a(Map<String, Boolean> map) {
                    for (CaseListRecord caseListRecord : list) {
                        String strMo12466b = caseListRecord.mo12466b();
                        if (map.containsKey(strMo12466b)) {
                            if (map.get(strMo12466b).booleanValue()) {
                                if (caseListRecord.mo12470e()) {
                                    if (StringUtils.m12617b(caseListRecord.mo12466b())) {
                                        GetCaseListOp.this.f12516a.mo12391a(caseListRecord.mo12466b(), false);
                                    }
                                } else {
                                    caseListRecord.mo12467b(true);
                                }
                            } else {
                                caseListRecord.mo12467b(false);
                            }
                        }
                    }
                    return BasicAsync.m14084c(list);
                }
            });
        }
    }
}
