package com.salesforce.android.cases.p020ui.internal.features.publisher;

import android.os.Looper;
import com.facebook.GraphResponse;
import com.salesforce.android.cases.core.internal.model.CreateCaseRecordModel;
import com.salesforce.android.cases.core.model.CaseField;
import com.salesforce.android.cases.core.model.CaseLayoutData;
import com.salesforce.android.cases.core.model.CreateCaseRecordResult;
import com.salesforce.android.cases.core.model.DefaultValues;
import com.salesforce.android.cases.core.requests.CreateCaseQuickActionRequest;
import com.salesforce.android.cases.core.requests.CreateCaseRecordRequest;
import com.salesforce.android.cases.core.requests.DefaultValuesRequest;
import com.salesforce.android.cases.p020ui.CaseUIClient;
import com.salesforce.android.cases.p020ui.CasesUIAnalyticsEmit;
import com.salesforce.android.cases.p020ui.internal.features.publisher.CasePublisherContract;
import com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel.CaseFieldViewModel;
import com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler;
import com.salesforce.android.cases.p020ui.internal.utils.CollectionUtils;
import com.salesforce.android.cases.p020ui.internal.utils.HandlerFactory;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.functional.Function;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CasePublisherPresenter implements CasePublisherContract.Presenter {

    /* JADX INFO: renamed from: a */
    List<CaseFieldViewModel> f12777a;

    /* JADX INFO: renamed from: b */
    String f12778b;

    /* JADX INFO: renamed from: c */
    WeakReference<CasePublisherContract.Presenter.Listener> f12779c;

    /* JADX INFO: renamed from: g */
    boolean f12783g;

    /* JADX INFO: renamed from: h */
    private final CaseUIClient f12784h;

    /* JADX INFO: renamed from: i */
    private final HandlerFactory f12785i;

    /* JADX INFO: renamed from: j */
    private List<CaseField> f12786j;

    /* JADX INFO: renamed from: e */
    CaseLayoutDataHandler f12781e = new CaseLayoutDataHandler();

    /* JADX INFO: renamed from: f */
    CreateCaseHandler f12782f = new CreateCaseHandler();

    /* JADX INFO: renamed from: d */
    CasePublisherContract.View f12780d = new NulledCasePublisherView();

    public CasePublisherPresenter(CaseUIClient caseUIClient, HandlerFactory handlerFactory) {
        this.f12784h = caseUIClient;
        this.f12785i = handlerFactory;
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BasePresenter
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo12787a(Void r1) {
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BasePresenter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo12786a(CasePublisherContract.View view) {
        view.setPresenter(this);
        this.f12780d = view;
        this.f12781e.m13000d();
        if (this.f12782f.m13005i()) {
            this.f12782f.m13000d();
        }
        CasesUIAnalyticsEmit.m12729a(this.f12784h.mo12716b(), this.f12784h.mo12719d(), this.f12784h.mo12718c(), m12977r(), "publisher_launched");
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BasePresenter
    /* JADX INFO: renamed from: d */
    public void mo12789d() {
        if (!CollectionUtils.m13044a(this.f12777a)) {
            for (CaseFieldViewModel caseFieldViewModel : this.f12777a) {
                if (caseFieldViewModel.mo12991b()) {
                    this.f12778b = caseFieldViewModel.mo12993d().mo12446a();
                    return;
                }
            }
        }
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BasePresenter
    /* JADX INFO: renamed from: e */
    public void mo12790e() {
        this.f12780d = new NulledCasePublisherView();
        this.f12781e.m13001e();
        this.f12782f.m13001e();
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.Presenter
    /* JADX INFO: renamed from: a */
    public void mo12933a(CasePublisherContract.Presenter.Listener listener) {
        this.f12779c = new WeakReference<>(listener);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.Presenter
    /* JADX INFO: renamed from: f */
    public void mo12936f() {
        if (this.f12779c != null) {
            this.f12779c.clear();
            this.f12779c = null;
        }
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.Presenter
    /* JADX INFO: renamed from: a */
    public void mo12932a() {
        m12971l();
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.Presenter
    /* JADX INFO: renamed from: b */
    public void mo12934b() {
        m12976q();
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.Presenter
    /* JADX INFO: renamed from: c */
    public void mo12935c() {
        m12971l();
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.Presenter
    /* JADX INFO: renamed from: g */
    public boolean mo12937g() {
        if (!this.f12783g && !CollectionUtils.m13044a(this.f12777a)) {
            Iterator<CaseFieldViewModel> it = this.f12777a.iterator();
            while (it.hasNext()) {
                if (it.next().mo12996g()) {
                    this.f12780d.mo12951n();
                    return true;
                }
            }
        }
        m12976q();
        return false;
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.Presenter
    /* JADX INFO: renamed from: h */
    public void mo12938h() {
        m12976q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i */
    public void m12968i() {
        this.f12780d.mo12952p_();
        this.f12780d.mo12949l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m12957a(CaseLayoutData caseLayoutData) {
        CasesUIAnalyticsEmit.m12729a(this.f12784h.mo12716b(), this.f12784h.mo12719d(), this.f12784h.mo12718c(), m12977r(), "publisher_loaded");
        m12962b(caseLayoutData);
        this.f12780d.mo12953q_();
        this.f12780d.mo12941c();
        if (!this.f12782f.m13005i()) {
            this.f12780d.mo12950m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: j */
    public void m12969j() {
        this.f12780d.mo12953q_();
        this.f12780d.mo12942e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: k */
    public void m12970k() {
        this.f12780d.mo12953q_();
        this.f12780d.mo12943f();
    }

    /* JADX INFO: renamed from: l */
    private void m12971l() {
        this.f12782f.m13001e();
        this.f12780d.mo12946i();
        if (m12972m()) {
            CreateCaseRecordModel.Builder builder = new CreateCaseRecordModel.Builder();
            for (CaseFieldViewModel caseFieldViewModel : this.f12777a) {
                builder.m12492a(caseFieldViewModel.mo12993d().mo12446a(), caseFieldViewModel.mo12995f());
            }
            if (this.f12786j != null) {
                for (CaseField caseField : this.f12786j) {
                    builder.m12492a(caseField.mo12446a(), caseField.mo12455h());
                }
            }
            m12956a(builder.m12493a());
        }
    }

    /* JADX INFO: renamed from: m */
    private boolean m12972m() {
        for (CaseFieldViewModel caseFieldViewModel : this.f12777a) {
            if (!caseFieldViewModel.mo12994e()) {
                caseFieldViewModel.mo12992c();
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m12956a(CreateCaseRecordModel createCaseRecordModel) {
        this.f12782f.f12793a = createCaseRecordModel;
        m12973n();
        CasesUIAnalyticsEmit.m12732a(this.f12784h.mo12716b(), this.f12784h.mo12719d(), this.f12784h.mo12718c(), m12977r(), "submit_started", null, null, 0);
        this.f12785i.m13047a(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                CasePublisherPresenter.this.f12782f.m13000d();
            }
        }, 1500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: n */
    public void m12973n() {
        this.f12783g = false;
        this.f12780d.mo12947j();
        this.f12780d.mo12949l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m12960a(String str) {
        CasesUIAnalyticsEmit.m12732a(this.f12784h.mo12716b(), this.f12784h.mo12719d(), this.f12784h.mo12718c(), m12977r(), "submit_complete", GraphResponse.SUCCESS_KEY, str, Integer.valueOf(m12978s()));
        this.f12783g = true;
        this.f12780d.mo12954r_();
        this.f12780d.mo12948k();
        if (this.f12784h.mo12720e()) {
            m12976q();
        } else {
            this.f12780d.mo12944g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: o */
    public void m12974o() {
        CasesUIAnalyticsEmit.m12732a(this.f12784h.mo12716b(), this.f12784h.mo12719d(), this.f12784h.mo12718c(), m12977r(), "submit_complete", "failure", null, Integer.valueOf(m12978s()));
        this.f12783g = false;
        this.f12780d.mo12948k();
        this.f12780d.mo12945h();
        this.f12780d.mo12950m();
    }

    /* JADX INFO: renamed from: b */
    private void m12962b(CaseLayoutData caseLayoutData) {
        CaseFieldViewModel caseFieldViewModelMo12940b;
        this.f12777a = new ArrayList();
        this.f12786j = new ArrayList();
        for (CaseField caseField : caseLayoutData.mo12458a()) {
            if (caseField.mo12453f().isTextField() && !this.f12784h.mo12720e()) {
                caseField.mo12447a((String) null);
            }
            if (!caseField.mo12452e()) {
                if (m12975p().containsKey(caseField.mo12446a())) {
                    caseField.mo12448a(true);
                    caseField.mo12447a(m12975p().get(caseField.mo12446a()));
                    this.f12786j.add(caseField);
                } else {
                    switch (caseField.mo12453f()) {
                        case TEXT:
                        case EMAIL:
                        case TEXT_AREA:
                            caseFieldViewModelMo12940b = this.f12780d.mo12939a(caseField);
                            break;
                        case PICK_LIST:
                            caseFieldViewModelMo12940b = this.f12780d.mo12940b(caseField);
                            break;
                        default:
                            caseFieldViewModelMo12940b = null;
                            break;
                    }
                    if (caseFieldViewModelMo12940b != null) {
                        if (caseField.mo12446a().equals(this.f12778b)) {
                            caseFieldViewModelMo12940b.mo12992c();
                        }
                        this.f12777a.add(caseFieldViewModelMo12940b);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: p */
    private Map<String, String> m12975p() {
        return (this.f12784h.mo12713a().mo12164a() == null || this.f12784h.mo12713a().mo12164a().mo9872a() == null) ? Collections.emptyMap() : this.f12784h.mo12713a().mo12164a().mo9872a();
    }

    /* JADX INFO: renamed from: q */
    private void m12976q() {
        String strMo12716b = this.f12784h.mo12716b();
        String strMo12719d = this.f12784h.mo12719d();
        String strMo12718c = this.f12784h.mo12718c();
        String strM12977r = m12977r();
        CasesUIAnalyticsEmit.m12729a(strMo12716b, strMo12719d, strMo12718c, strM12977r, "publisher_dismissed");
        CasesUIAnalyticsEmit.m12728a(strMo12716b, strMo12719d, strMo12718c, strM12977r, Integer.valueOf(m12978s()));
        if (this.f12779c != null && this.f12779c.get() != null) {
            this.f12779c.get().mo12931d();
        }
    }

    /* JADX INFO: renamed from: r */
    private String m12977r() {
        return this.f12784h.mo12720e() ? "authenticated" : "guest";
    }

    /* JADX INFO: renamed from: s */
    private int m12978s() {
        int i = 0;
        if (this.f12777a == null) {
            return 0;
        }
        Iterator<CaseFieldViewModel> it = this.f12777a.iterator();
        while (true) {
            int iM12961b = i;
            if (!it.hasNext()) {
                return iM12961b;
            }
            String strMo12995f = it.next().mo12995f();
            if (strMo12995f != null && !strMo12995f.trim().isEmpty()) {
                iM12961b += m12961b(strMo12995f);
            }
            i = iM12961b;
        }
    }

    /* JADX INFO: renamed from: b */
    private int m12961b(String str) {
        return str.trim().split("\\s+").length;
    }

    class CaseLayoutDataHandler extends AbstractHandler<CaseLayoutData> {
        CaseLayoutDataHandler() {
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: a */
        protected Async<CaseLayoutData> mo12793a() {
            if (CasePublisherPresenter.this.f12784h.mo12720e()) {
                return CasePublisherPresenter.this.f12784h.mo12713a().mo12170a(DefaultValuesRequest.m12668a(CasePublisherPresenter.this.f12784h.mo12718c())).mo14078b(new Function<DefaultValues, Async<? extends CaseLayoutData>>() { // from class: com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherPresenter.CaseLayoutDataHandler.1
                    @Override // com.salesforce.android.service.common.utilities.functional.Function
                    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public Async<? extends CaseLayoutData> mo12236a(final DefaultValues defaultValues) {
                        return CasePublisherPresenter.this.f12784h.mo12713a().mo12168a(CreateCaseQuickActionRequest.m12657a(CasePublisherPresenter.this.f12784h.mo12718c())).mo14076a(new Function<CaseLayoutData, CaseLayoutData>() { // from class: com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherPresenter.CaseLayoutDataHandler.1.1
                            @Override // com.salesforce.android.service.common.utilities.functional.Function
                            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                            public CaseLayoutData mo12236a(CaseLayoutData caseLayoutData) {
                                Map<String, String> mapMo12497a = defaultValues.mo12497a();
                                for (CaseField caseField : caseLayoutData.mo12458a()) {
                                    if (mapMo12497a.containsKey(caseField.mo12446a())) {
                                        caseField.mo12447a(mapMo12497a.get(caseField.mo12446a()));
                                    }
                                }
                                return caseLayoutData;
                            }
                        });
                    }
                });
            }
            return CasePublisherPresenter.this.f12784h.mo12713a().mo12168a(CreateCaseQuickActionRequest.m12657a(CasePublisherPresenter.this.f12784h.mo12718c()));
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: b */
        protected void mo12797b() {
            CasePublisherPresenter.this.m12968i();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo12794a(CaseLayoutData caseLayoutData) {
            CasePublisherPresenter.this.m12957a(caseLayoutData);
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: c */
        protected void mo12798c() {
            CasePublisherPresenter.this.m12970k();
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: a */
        protected void mo12795a(Throwable th) {
            CasePublisherPresenter.this.m12969j();
        }
    }

    class CreateCaseHandler extends AbstractHandler<CreateCaseRecordResult> {

        /* JADX INFO: renamed from: a */
        CreateCaseRecordModel f12793a;

        CreateCaseHandler() {
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: a */
        protected Async<CreateCaseRecordResult> mo12793a() {
            return CasePublisherPresenter.this.f12784h.mo12713a().mo12169a(new CreateCaseRecordRequest.NewCaseRecordRequestBuilder(CasePublisherPresenter.this.f12784h.mo12718c(), this.f12793a).m12667b());
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: b */
        protected void mo12797b() {
            CasePublisherPresenter.this.m12973n();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo12794a(CreateCaseRecordResult createCaseRecordResult) {
            CasePublisherPresenter.this.m12960a(createCaseRecordResult.mo12495a());
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: c */
        protected void mo12798c() {
            CasePublisherPresenter.this.m12974o();
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: a */
        protected void mo12795a(Throwable th) {
            CasePublisherPresenter.this.m12974o();
        }
    }
}
