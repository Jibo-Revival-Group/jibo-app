package com.salesforce.android.cases.p020ui.internal.features.casefeed;

import android.content.Context;
import android.text.TextUtils;
import com.salesforce.android.cases.core.model.CaseField;
import com.salesforce.android.cases.core.model.CommentPost;
import com.salesforce.android.cases.core.model.CompleteCaseFeed;
import com.salesforce.android.cases.core.model.PushNotification;
import com.salesforce.android.cases.core.requests.CommentPostRequest;
import com.salesforce.android.cases.core.requests.CompleteCaseFeedRequest;
import com.salesforce.android.cases.core.requests.SetCaseLastReadDateRequest;
import com.salesforce.android.cases.p020ui.CaseUIClient;
import com.salesforce.android.cases.p020ui.CasesUIAnalyticsEmit;
import com.salesforce.android.cases.p020ui.internal.features.casefeed.CaseFeedContract;
import com.salesforce.android.cases.p020ui.internal.features.casefeed.viewmodel.CaseFeedViewModel;
import com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler;
import com.salesforce.android.cases.p020ui.internal.features.shared.PushNotificationBroadcastReceiver;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.functional.Function;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CaseFeedPresenter implements CaseFeedContract.Presenter {

    /* JADX INFO: renamed from: d */
    WeakReference<CaseFeedContract.Presenter.Listener> f12637d;

    /* JADX INFO: renamed from: e */
    CaseFeedViewModel f12638e;

    /* JADX INFO: renamed from: f */
    boolean f12639f;

    /* JADX INFO: renamed from: g */
    String f12640g;

    /* JADX INFO: renamed from: h */
    private final CaseUIClient f12641h;

    /* JADX INFO: renamed from: b */
    GetCaseFeedHandler f12635b = new GetCaseFeedHandler();

    /* JADX INFO: renamed from: i */
    private final ServiceLogger f12642i = ServiceLogging.m14203a((Class<?>) CaseFeedPresenter.class);

    /* JADX INFO: renamed from: c */
    CaseFeedContract.View f12636c = new NullCaseFeedView();

    /* JADX INFO: renamed from: a */
    final PushNotificationBroadcastReceiver f12634a = new PushNotificationBroadcastReceiver() { // from class: com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedPresenter.1
        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.PushNotificationBroadcastReceiver
        /* JADX INFO: renamed from: a */
        public void mo12792a(PushNotification pushNotification) {
            if (CaseFeedPresenter.this.f12640g != null && CaseFeedPresenter.this.f12640g.equals(pushNotification.m12621a())) {
                CaseFeedPresenter.this.mo12753c();
            }
        }
    };

    CaseFeedPresenter(CaseUIClient caseUIClient) {
        this.f12641h = caseUIClient;
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BasePresenter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void mo12787a(String str) {
        this.f12640g = str;
        m12791f();
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BasePresenter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo12786a(CaseFeedContract.View view) {
        view.setPresenter(this);
        this.f12636c = view;
        this.f12634a.m13011a(view.getApplicationContext());
        CasesUIAnalyticsEmit.m12734c(this.f12641h.mo12716b(), this.f12641h.mo12719d(), this.f12641h.mo12718c(), this.f12641h.mo12720e() ? "authenticated" : "guest", "detail_launched", this.f12640g);
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BasePresenter
    /* JADX INFO: renamed from: d */
    public void mo12789d() {
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BasePresenter
    /* JADX INFO: renamed from: e */
    public void mo12790e() {
        this.f12634a.m13012b(this.f12636c.getApplicationContext());
        this.f12636c = new NullCaseFeedView();
        this.f12635b.m13001e();
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.Presenter
    /* JADX INFO: renamed from: a */
    public void mo12749a() {
        this.f12636c.mo12770o();
        m12779g();
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.Presenter
    /* JADX INFO: renamed from: a */
    public void mo12750a(CaseFeedContract.Presenter.Listener listener) {
        this.f12637d = new WeakReference<>(listener);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.Presenter
    /* JADX INFO: renamed from: b */
    public void mo12752b() {
        if (this.f12637d != null) {
            this.f12637d.clear();
            this.f12637d = null;
        }
    }

    /* JADX INFO: renamed from: f */
    public void m12791f() {
        this.f12635b.m12796a(true);
        this.f12639f = false;
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.Presenter
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void mo12751a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f12636c.mo12767l();
            this.f12641h.mo12713a().mo12166a(new CommentPostRequest.CommentPostRequestBuilder(this.f12638e.m12824d(), this.f12640g, str).m12646b()).mo14074a(new PostCommentResult(this.f12638e)).mo14073a(new PostCommentError());
        }
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.Presenter
    /* JADX INFO: renamed from: c */
    public void mo12753c() {
        this.f12639f = true;
        this.f12635b.m13001e();
        this.f12635b.m12796a(false);
    }

    /* JADX INFO: renamed from: g */
    private void m12779g() {
        if (this.f12637d != null && this.f12637d.get() != null) {
            CasesUIAnalyticsEmit.m12734c(this.f12641h.mo12716b(), this.f12641h.mo12719d(), this.f12641h.mo12718c(), this.f12641h.mo12720e() ? "authenticated" : "guest", "detail_dismissed", this.f12640g);
            this.f12637d.get().mo12747b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h */
    public void m12780h() {
        this.f12636c.mo12760h_();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m12773a(CaseFeedViewModel caseFeedViewModel) {
        CasesUIAnalyticsEmit.m12734c(this.f12641h.mo12716b(), this.f12641h.mo12719d(), this.f12641h.mo12718c(), this.f12641h.mo12720e() ? "authenticated" : "guest", "detail_loaded", this.f12640g);
        if (caseFeedViewModel.m12822b() != null) {
            this.f12636c.setTitle(caseFeedViewModel.m12822b());
        }
        this.f12636c.mo12762i_();
        this.f12636c.mo12756e();
        this.f12636c.mo12757f();
        this.f12636c.mo12764j_();
        this.f12636c.mo12755a(caseFeedViewModel.m12820a());
        if (this.f12639f) {
            m12783k();
            SetCaseReadHandler setCaseReadHandler = new SetCaseReadHandler(this.f12640g);
            this.f12641h.mo12713a().mo12174a(SetCaseLastReadDateRequest.m12698a(this.f12640g, caseFeedViewModel.m12823c())).mo14072a((Async.CompletionHandler) setCaseReadHandler).mo14073a((Async.ErrorHandler) setCaseReadHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i */
    public void m12781i() {
        this.f12636c.mo12762i_();
        this.f12636c.mo12766k_();
        this.f12636c.mo12757f();
        this.f12636c.mo12758g();
        if (this.f12639f) {
            m12783k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: j */
    public void m12782j() {
        this.f12636c.mo12762i_();
        this.f12636c.mo12766k_();
        this.f12636c.mo12756e();
        this.f12636c.mo12759h();
        if (this.f12639f) {
            m12783k();
        }
    }

    /* JADX INFO: renamed from: k */
    private void m12783k() {
        this.f12636c.mo12761i();
        this.f12639f = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: l */
    public void m12784l() {
        CasesUIAnalyticsEmit.m12731a(this.f12641h.mo12716b(), this.f12641h.mo12719d(), this.f12641h.mo12718c(), this.f12641h.mo12720e() ? "authenticated" : "guest", "customer", this.f12640g);
    }

    static class MapCaseFeedViewModelFunction implements Function<CompleteCaseFeed, CaseFeedViewModel> {

        /* JADX INFO: renamed from: a */
        private final Context f12646a;

        MapCaseFeedViewModelFunction(Context context) {
            this.f12646a = context.getApplicationContext();
        }

        @Override // com.salesforce.android.service.common.utilities.functional.Function
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public CaseFeedViewModel mo12236a(CompleteCaseFeed completeCaseFeed) {
            Map<String, String> mapMo12497a = completeCaseFeed.mo12490g().mo12497a();
            for (CaseField caseField : completeCaseFeed.mo12489f().mo12458a()) {
                if (mapMo12497a.containsKey(caseField.mo12446a())) {
                    caseField.mo12447a(mapMo12497a.get(caseField.mo12446a()));
                }
            }
            return new CaseFeedViewModel(this.f12646a, completeCaseFeed.mo12488e(), completeCaseFeed.mo12489f(), completeCaseFeed.mo12487d(), completeCaseFeed.mo12486c());
        }
    }

    class PostCommentResult implements Async.ResultHandler<CommentPost> {

        /* JADX INFO: renamed from: b */
        private final CaseFeedViewModel f12649b;

        PostCommentResult(CaseFeedViewModel caseFeedViewModel) {
            this.f12649b = caseFeedViewModel;
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo9875a(Async async, CommentPost commentPost) {
            CaseFeedPresenter.this.m12784l();
            CaseFeedPresenter.this.f12636c.mo12769n();
            CaseFeedPresenter.this.f12636c.mo12763j();
            CaseFeedPresenter.this.f12636c.mo12768m();
            Iterator<Object> it = this.f12649b.m12821a(commentPost).iterator();
            while (it.hasNext()) {
                CaseFeedPresenter.this.f12636c.mo12754a(it.next());
            }
        }
    }

    class PostCommentError implements Async.ErrorHandler {
        PostCommentError() {
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
        /* JADX INFO: renamed from: a */
        public void mo12581a(Async<?> async, Throwable th) {
            CaseFeedPresenter.this.f12636c.mo12765k();
            CaseFeedPresenter.this.f12636c.mo12763j();
            CaseFeedPresenter.this.f12636c.mo12768m();
        }
    }

    class GetCaseFeedHandler extends AbstractHandler<CaseFeedViewModel> {

        /* JADX INFO: renamed from: b */
        private boolean f12645b;

        GetCaseFeedHandler() {
        }

        /* JADX INFO: renamed from: a */
        public void m12796a(boolean z) {
            this.f12645b = z;
            super.m13000d();
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: a */
        protected Async<CaseFeedViewModel> mo12793a() {
            return CaseFeedPresenter.this.f12641h.mo12713a().mo12167a(new CompleteCaseFeedRequest.CompleteCaseFeedRequestBuilder(CaseFeedPresenter.this.f12640g, CaseFeedPresenter.this.f12641h.mo12718c(), CaseFeedPresenter.this.f12641h.mo12716b()).m13742e(true).mo12688d(true).mo12687c(true).m12656b()).mo14076a(new MapCaseFeedViewModelFunction(CaseFeedPresenter.this.f12636c.getApplicationContext()));
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: b */
        protected void mo12797b() {
            if (this.f12645b) {
                CaseFeedPresenter.this.m12780h();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo12794a(CaseFeedViewModel caseFeedViewModel) {
            CaseFeedPresenter.this.f12638e = caseFeedViewModel;
            CaseFeedPresenter.this.m12773a(caseFeedViewModel);
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: c */
        protected void mo12798c() {
            CaseFeedPresenter.this.m12782j();
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: a */
        protected void mo12795a(Throwable th) {
            CaseFeedPresenter.this.m12781i();
        }
    }

    private class SetCaseReadHandler implements Async.CompletionHandler, Async.ErrorHandler {

        /* JADX INFO: renamed from: b */
        private final String f12651b;

        SetCaseReadHandler(String str) {
            this.f12651b = str;
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
        /* JADX INFO: renamed from: a */
        public void mo12580a(Async<?> async) {
            CaseFeedPresenter.this.f12642i.mo14191c("Successfully updated case {} last read date.", this.f12651b);
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
        /* JADX INFO: renamed from: a */
        public void mo12581a(Async<?> async, Throwable th) {
            CaseFeedPresenter.this.f12642i.mo14193d("An error occurred while trying to update case {} last read date.\n\n{}", this.f12651b, th.getMessage());
        }
    }
}
