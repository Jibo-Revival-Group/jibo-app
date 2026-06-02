package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.model.CompleteCaseFeedModel;
import com.salesforce.android.cases.core.internal.operations.resulthandlers.CreateCaseQuickActionHandler;
import com.salesforce.android.cases.core.internal.operations.resulthandlers.DefaultValuesHandler;
import com.salesforce.android.cases.core.internal.operations.resulthandlers.GetCaseDetailHandler;
import com.salesforce.android.cases.core.internal.operations.resulthandlers.GetCommunitiesResultsHandler;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.CaseDetailRecord;
import com.salesforce.android.cases.core.model.CaseLayoutData;
import com.salesforce.android.cases.core.model.Community;
import com.salesforce.android.cases.core.model.CompleteCaseFeed;
import com.salesforce.android.cases.core.model.DefaultValues;
import com.salesforce.android.cases.core.requests.CaseDetailRequest;
import com.salesforce.android.cases.core.requests.CommunitiesListRequest;
import com.salesforce.android.cases.core.requests.CompleteCaseFeedRequest;
import com.salesforce.android.cases.core.requests.CreateCaseQuickActionRequest;
import com.salesforce.android.cases.core.requests.DefaultValuesRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.androidsdk.accounts.UserAccount;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GetCompleteCaseFeedOp extends MultipartOperation<CompleteCaseFeed> {

    /* JADX INFO: renamed from: a */
    private final CompleteCaseFeedRequest f12525a;

    /* JADX INFO: renamed from: b */
    private final OperationFactory f12526b;

    /* JADX INFO: renamed from: c */
    private final CompleteCaseFeedModel f12527c = new CompleteCaseFeedModel();

    /* JADX INFO: renamed from: d */
    private final RemoteRepository f12528d;

    /* JADX INFO: renamed from: e */
    private final LocalRepository f12529e;

    /* JADX INFO: renamed from: f */
    private final UserAccount f12530f;

    public GetCompleteCaseFeedOp(CompleteCaseFeedRequest completeCaseFeedRequest, LocalRepository localRepository, RemoteRepository remoteRepository, OperationFactory operationFactory, UserAccount userAccount) {
        this.f12525a = completeCaseFeedRequest;
        this.f12526b = operationFactory;
        this.f12529e = localRepository;
        this.f12528d = remoteRepository;
        this.f12530f = userAccount;
    }

    @Override // com.salesforce.android.cases.core.internal.operations.MultipartOperation
    /* JADX INFO: renamed from: a */
    public void mo12533a() {
        boolean zL = this.f12525a.m13739l();
        boolean zM = this.f12525a.m13740m();
        boolean zN = this.f12525a.m13741n();
        Async<List<Community>> asyncMo12557f = this.f12526b.m12563a(new CommunitiesListRequest.CommunitiesListRequestBuilder().mo12687c(zL).mo12688d(zM).m13742e(zN).m12648b(), this.f12529e, this.f12528d).mo12556e().mo12557f();
        asyncMo12557f.mo14077b(new GetCommunitiesResultsHandler(this, this.f12525a, this.f12527c, this.f12526b, this.f12529e, this.f12528d));
        mo12555c(asyncMo12557f);
        Async<CaseDetailRecord> asyncMo12557f2 = this.f12526b.m12559a(new CaseDetailRequest.CaseDetailRequestBuilder(this.f12525a.m12649a()).mo12687c(zL).mo12688d(zM).m13742e(zN).m12626b(), this.f12529e, this.f12528d).mo12556e().mo12557f();
        asyncMo12557f2.mo14077b(new GetCaseDetailHandler(this, this.f12527c));
        mo12555c(asyncMo12557f2);
        Async<DefaultValues> asyncMo12557f3 = this.f12526b.m12567a(new DefaultValuesRequest.DefaultValuesRequestBuilder(this.f12525a.m12650b()).mo12687c(zL).mo12688d(zM).m13742e(zN).m12672b(), this.f12529e, this.f12528d).mo12556e().mo12557f();
        asyncMo12557f3.mo14077b(new DefaultValuesHandler(this, this.f12527c));
        mo12555c(asyncMo12557f3);
        Async<CaseLayoutData> asyncMo12557f4 = this.f12526b.m12565a(new CreateCaseQuickActionRequest.CreateCaseQuickActionRequestBuilder(this.f12525a.m12650b()).mo12687c(zL).mo12688d(zM).m13742e(zN).m12661b(), this.f12529e, this.f12528d, this.f12530f).mo12556e().mo12557f();
        asyncMo12557f4.mo14077b(new CreateCaseQuickActionHandler(this, this.f12527c));
        mo12555c(asyncMo12557f4);
    }

    @Override // com.salesforce.android.cases.core.internal.operations.MultipartOperation
    /* JADX INFO: renamed from: b */
    boolean mo12534b() {
        return this.f12527c.m12484a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.salesforce.android.cases.core.internal.operations.MultipartOperation
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public CompleteCaseFeed mo12536d() {
        return this.f12527c.m12485b();
    }
}
