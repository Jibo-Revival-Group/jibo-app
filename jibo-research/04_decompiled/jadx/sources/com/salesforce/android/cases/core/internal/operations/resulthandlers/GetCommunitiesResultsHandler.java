package com.salesforce.android.cases.core.internal.operations.resulthandlers;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.model.CompleteCaseFeedModel;
import com.salesforce.android.cases.core.internal.operations.MultipartOperationObserver;
import com.salesforce.android.cases.core.internal.operations.OperationFactory;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.CaseFeed;
import com.salesforce.android.cases.core.model.Community;
import com.salesforce.android.cases.core.requests.CaseFeedRequest;
import com.salesforce.android.cases.core.requests.CompleteCaseFeedRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GetCommunitiesResultsHandler extends AbstractMultipartRequestHandler<List<Community>> {

    /* JADX INFO: renamed from: b */
    private Async<CaseFeed> f12551b;

    /* JADX INFO: renamed from: c */
    private final CompleteCaseFeedModel f12552c;

    /* JADX INFO: renamed from: d */
    private final OperationFactory f12553d;

    /* JADX INFO: renamed from: e */
    private final LocalRepository f12554e;

    /* JADX INFO: renamed from: f */
    private final RemoteRepository f12555f;

    /* JADX INFO: renamed from: g */
    private final CompleteCaseFeedRequest f12556g;

    @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo9875a(Async async, Object obj) {
        m12591a((Async<?>) async, (List<Community>) obj);
    }

    public GetCommunitiesResultsHandler(MultipartOperationObserver multipartOperationObserver, CompleteCaseFeedRequest completeCaseFeedRequest, CompleteCaseFeedModel completeCaseFeedModel, OperationFactory operationFactory, LocalRepository localRepository, RemoteRepository remoteRepository) {
        super(multipartOperationObserver);
        this.f12552c = completeCaseFeedModel;
        this.f12553d = operationFactory;
        this.f12554e = localRepository;
        this.f12555f = remoteRepository;
        this.f12556g = completeCaseFeedRequest;
    }

    /* JADX INFO: renamed from: a */
    public void m12591a(Async<?> async, List<Community> list) {
        String strM12588a = m12588a(list, this.f12556g.m12651c());
        if (m12589a(strM12588a)) {
            this.f12552c.m12483a(strM12588a);
            this.f12546a.mo12558g();
            m12590b(strM12588a);
        }
    }

    /* JADX INFO: renamed from: a */
    private String m12588a(List<Community> list, String str) {
        for (Community community : list) {
            if (community.mo12478b().equals(str)) {
                return community.mo12477a();
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private boolean m12589a(String str) {
        return (str == null || str.equals(this.f12552c.mo12486c())) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    private void m12590b(String str) {
        Async<CaseFeed> asyncMo12557f = this.f12553d.m12560a(new CaseFeedRequest.CaseFeedRequestBuilder(str, this.f12556g.m12649a()).mo12687c(this.f12556g.m13739l()).mo12688d(this.f12556g.m13740m()).m13742e(this.f12556g.m13741n()).m12633b(), this.f12554e, this.f12555f).mo12556e().mo12557f();
        asyncMo12557f.mo14077b(new GetCaseFeedHandler(this.f12546a, this.f12552c));
        this.f12546a.mo12555c(asyncMo12557f);
        if (this.f12551b != null) {
            this.f12546a.mo12554b(this.f12551b);
        }
        this.f12551b = asyncMo12557f;
    }
}
