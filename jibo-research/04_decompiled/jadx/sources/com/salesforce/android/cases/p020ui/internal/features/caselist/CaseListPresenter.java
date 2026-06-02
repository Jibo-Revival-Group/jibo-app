package com.salesforce.android.cases.p020ui.internal.features.caselist;

import com.salesforce.android.cases.core.internal.util.StringUtils;
import com.salesforce.android.cases.core.model.CaseListRecord;
import com.salesforce.android.cases.core.model.ListViewDescribe;
import com.salesforce.android.cases.core.model.PushNotification;
import com.salesforce.android.cases.core.requests.CaseListRequest;
import com.salesforce.android.cases.core.requests.ListViewDescribeRequest;
import com.salesforce.android.cases.core.requests.ListViewRequest;
import com.salesforce.android.cases.core.requests.SetCaseHiddenRequest;
import com.salesforce.android.cases.core.requests.SetCaseLastReadDateRequest;
import com.salesforce.android.cases.p020ui.CaseUIClient;
import com.salesforce.android.cases.p020ui.CasesUIAnalyticsEmit;
import com.salesforce.android.cases.p020ui.internal.features.caselist.CaseListContract;
import com.salesforce.android.cases.p020ui.internal.features.caselist.viewmodel.CaseListItemViewModel;
import com.salesforce.android.cases.p020ui.internal.features.caselist.viewmodel.CaseListViewModel;
import com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler;
import com.salesforce.android.cases.p020ui.internal.features.shared.PushNotificationBroadcastReceiver;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.functional.Function;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CaseListPresenter implements CaseListContract.Presenter {

    /* JADX INFO: renamed from: c */
    WeakReference<CaseListContract.Presenter.Listener> f12716c;

    /* JADX INFO: renamed from: f */
    boolean f12719f;

    /* JADX INFO: renamed from: g */
    boolean f12720g;

    /* JADX INFO: renamed from: h */
    CaseListViewModel f12721h;

    /* JADX INFO: renamed from: k */
    private final CaseUIClient f12724k;

    /* JADX INFO: renamed from: i */
    private final Comparator<CaseListItemViewModel> f12722i = new CaseListComparator();

    /* JADX INFO: renamed from: j */
    private final ServiceLogger f12723j = ServiceLogging.m14203a((Class<?>) CaseListPresenter.class);

    /* JADX INFO: renamed from: d */
    CaseListDataHandler f12717d = new CaseListDataHandler();

    /* JADX INFO: renamed from: e */
    CaseListLabelHandler f12718e = new CaseListLabelHandler();

    /* JADX INFO: renamed from: b */
    CaseListContract.View f12715b = new NullCaseListContractView();

    /* JADX INFO: renamed from: a */
    PushNotificationBroadcastReceiver f12714a = new PushNotificationBroadcastReceiver() { // from class: com.salesforce.android.cases.ui.internal.features.caselist.CaseListPresenter.1
        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.PushNotificationBroadcastReceiver
        /* JADX INFO: renamed from: a */
        public void mo12792a(PushNotification pushNotification) {
            CaseListPresenter.this.f12715b.mo12875n();
        }
    };

    public CaseListPresenter(CaseUIClient caseUIClient) {
        this.f12724k = caseUIClient;
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BasePresenter
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo12787a(Void r1) {
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BasePresenter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo12786a(CaseListContract.View view) {
        view.setPresenter(this);
        this.f12715b = view;
        this.f12717d.m13000d();
        this.f12718e.m13000d();
        this.f12720g = false;
        this.f12714a.m13011a(view.getContext());
        CasesUIAnalyticsEmit.m12730a(this.f12724k.mo12716b(), this.f12724k.mo12719d(), this.f12724k.mo12718c(), this.f12724k.mo12720e() ? "authenticated" : "guest", "list_launched", (Integer) null);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.Presenter
    /* JADX INFO: renamed from: i */
    public void mo12857i() {
        if (this.f12720g) {
            mo12856h();
        }
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BasePresenter
    /* JADX INFO: renamed from: d */
    public void mo12789d() {
        this.f12720g = true;
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.shared.BasePresenter
    /* JADX INFO: renamed from: e */
    public void mo12790e() {
        this.f12714a.m13012b(this.f12715b.getContext());
        this.f12715b = new NullCaseListContractView();
        this.f12717d.m13001e();
        this.f12718e.m13001e();
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.Presenter
    /* JADX INFO: renamed from: a */
    public void mo12847a() {
        if (this.f12715b.getContext() != null) {
            this.f12724k.mo12717b(this.f12715b.getContext());
        }
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.Presenter
    /* JADX INFO: renamed from: b */
    public void mo12850b() {
        m12898n();
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.Presenter
    /* JADX INFO: renamed from: c */
    public void mo12852c() {
        mo12856h();
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.Presenter
    /* JADX INFO: renamed from: f */
    public void mo12854f() {
        mo12856h();
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.Presenter
    /* JADX INFO: renamed from: a */
    public void mo12849a(CaseListItemViewModel caseListItemViewModel) {
        String strM12922c = caseListItemViewModel.m12922c();
        if (StringUtils.m12616a(strM12922c)) {
            this.f12723j.mo14192d("Case list item without case id was clicked.");
            return;
        }
        m12887d(caseListItemViewModel);
        if (this.f12715b.getContext() != null) {
            this.f12724k.mo12715a(this.f12715b.getContext(), strM12922c);
        }
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.Presenter
    /* JADX INFO: renamed from: b */
    public void mo12851b(CaseListItemViewModel caseListItemViewModel) {
        String strM12922c = caseListItemViewModel.m12922c();
        if (StringUtils.m12616a(strM12922c)) {
            this.f12723j.mo14192d("Case list item without case id was swiped.");
        } else {
            SetCaseHiddenHandler setCaseHiddenHandler = new SetCaseHiddenHandler(caseListItemViewModel, true);
            this.f12724k.mo12713a().mo12173a(SetCaseHiddenRequest.m12691a(strM12922c, true)).mo14072a((Async.CompletionHandler) setCaseHiddenHandler).mo14073a((Async.ErrorHandler) setCaseHiddenHandler);
        }
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.Presenter
    /* JADX INFO: renamed from: c */
    public void mo12853c(CaseListItemViewModel caseListItemViewModel) {
        if (this.f12721h != null) {
            String strM12922c = caseListItemViewModel.m12922c();
            if (StringUtils.m12616a(strM12922c)) {
                this.f12723j.mo14192d("Case list item without case id was unhidden.");
            } else {
                SetCaseHiddenHandler setCaseHiddenHandler = new SetCaseHiddenHandler(caseListItemViewModel, false);
                this.f12724k.mo12713a().mo12173a(SetCaseHiddenRequest.m12691a(strM12922c, false)).mo14072a((Async.CompletionHandler) setCaseHiddenHandler).mo14073a((Async.ErrorHandler) setCaseHiddenHandler);
            }
        }
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.Presenter
    /* JADX INFO: renamed from: a */
    public void mo12848a(CaseListContract.Presenter.Listener listener) {
        this.f12716c = new WeakReference<>(listener);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.Presenter
    /* JADX INFO: renamed from: g */
    public void mo12855g() {
        if (this.f12716c != null) {
            this.f12716c.clear();
            this.f12716c = null;
        }
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.Presenter
    /* JADX INFO: renamed from: h */
    public void mo12856h() {
        if (!this.f12717d.m13004h()) {
            this.f12719f = true;
            this.f12717d.m13001e();
            this.f12717d.m13000d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m12881a(String str) {
        this.f12715b.setTitle(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: j */
    public void m12894j() {
        if (this.f12719f) {
            this.f12715b.mo12874m_();
        } else {
            this.f12715b.mo12872l_();
            this.f12715b.mo12866g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m12880a(CaseListViewModel caseListViewModel) {
        CasesUIAnalyticsEmit.m12730a(this.f12724k.mo12716b(), this.f12724k.mo12719d(), this.f12724k.mo12718c(), this.f12724k.mo12720e() ? "authenticated" : "guest", "list_loaded", Integer.valueOf(caseListViewModel.m12927a().size()));
        this.f12715b.mo12862c();
        if (caseListViewModel.m12927a().isEmpty()) {
            this.f12715b.mo12867h();
        } else {
            this.f12715b.mo12868i();
            this.f12715b.mo12860a(caseListViewModel);
        }
        this.f12715b.mo12865f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: k */
    public void m12895k() {
        if (this.f12719f) {
            this.f12715b.mo12873m();
        } else {
            this.f12715b.mo12871l();
        }
        this.f12715b.mo12865f();
        m12897m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: l */
    public void m12896l() {
        if (this.f12719f) {
            this.f12715b.mo12870k();
        } else {
            this.f12715b.mo12869j();
        }
        this.f12715b.mo12865f();
        m12897m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: m */
    public void m12897m() {
        if (this.f12719f) {
            this.f12715b.mo12864e();
            this.f12719f = false;
        } else {
            this.f12715b.mo12862c();
        }
    }

    /* JADX INFO: renamed from: n */
    private void m12898n() {
        if (this.f12716c != null && this.f12716c.get() != null) {
            CasesUIAnalyticsEmit.m12730a(this.f12724k.mo12716b(), this.f12724k.mo12719d(), this.f12724k.mo12718c(), this.f12724k.mo12720e() ? "authenticated" : "guest", "list_dismissed", (Integer) null);
            this.f12716c.get().mo12835d();
        }
    }

    /* JADX INFO: renamed from: d */
    private void m12887d(CaseListItemViewModel caseListItemViewModel) {
        if (!StringUtils.m12616a(caseListItemViewModel.m12922c())) {
            SetCaseReadHandler setCaseReadHandler = new SetCaseReadHandler(caseListItemViewModel);
            this.f12724k.mo12713a().mo12174a(SetCaseLastReadDateRequest.m12698a(caseListItemViewModel.m12922c(), caseListItemViewModel.m12926g() == null ? new Date() : caseListItemViewModel.m12926g())).mo14072a((Async.CompletionHandler) setCaseReadHandler).mo14073a((Async.ErrorHandler) setCaseReadHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public void m12889e(CaseListItemViewModel caseListItemViewModel) {
        this.f12715b.mo12858a(caseListItemViewModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public void m12891f(CaseListItemViewModel caseListItemViewModel) {
        this.f12721h.m12927a().remove(caseListItemViewModel);
        this.f12715b.mo12861b(caseListItemViewModel);
        this.f12715b.mo12863c(caseListItemViewModel);
        m12887d(caseListItemViewModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public void m12893g(CaseListItemViewModel caseListItemViewModel) {
        List<CaseListItemViewModel> listM12927a = this.f12721h.m12927a();
        listM12927a.add(caseListItemViewModel);
        Collections.sort(listM12927a, this.f12722i);
        int iIndexOf = listM12927a.indexOf(caseListItemViewModel);
        if (iIndexOf >= 0) {
            this.f12715b.mo12859a(caseListItemViewModel, iIndexOf);
        }
    }

    private static class CaseListComparator implements Comparator<CaseListItemViewModel> {
        private CaseListComparator() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(CaseListItemViewModel caseListItemViewModel, CaseListItemViewModel caseListItemViewModel2) {
            Date dateM12926g = caseListItemViewModel.m12926g();
            Date dateM12926g2 = caseListItemViewModel2.m12926g();
            if (dateM12926g2 == null || dateM12926g == null) {
                return -1;
            }
            return dateM12926g2.compareTo(dateM12926g);
        }
    }

    class CaseListLabelHandler extends AbstractHandler<String> {
        CaseListLabelHandler() {
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: a */
        protected Async<String> mo12793a() {
            return CaseListPresenter.this.f12724k.mo12713a().mo12175b(ListViewRequest.m12678a(CaseListPresenter.this.f12724k.mo12719d()));
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: b */
        protected void mo12797b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo12794a(String str) {
            CaseListPresenter.this.m12881a(str);
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: c */
        protected void mo12798c() {
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: a */
        protected void mo12795a(Throwable th) {
        }
    }

    class CaseListDataHandler extends AbstractHandler<CaseListViewModel> {
        CaseListDataHandler() {
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: a */
        protected Async<CaseListViewModel> mo12793a() {
            return CaseListPresenter.this.f12724k.mo12713a().mo12172a(ListViewRequest.m12678a(CaseListPresenter.this.f12724k.mo12719d())).mo14078b(new GetListViewDescribeFunction());
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: b */
        protected void mo12797b() {
            CaseListPresenter.this.m12894j();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo12794a(CaseListViewModel caseListViewModel) {
            CaseListPresenter.this.m12880a(caseListViewModel);
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: c */
        protected void mo12798c() {
            CaseListPresenter.this.m12895k();
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler
        /* JADX INFO: renamed from: a */
        protected void mo12795a(Throwable th) {
            CaseListPresenter.this.m12896l();
        }

        @Override // com.salesforce.android.cases.p020ui.internal.features.shared.AbstractHandler, com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
        /* JADX INFO: renamed from: a */
        public void mo12580a(Async<?> async) {
            CaseListPresenter.this.m12897m();
        }

        private class GetListViewDescribeFunction implements Function<String, Async<? extends CaseListViewModel>> {
            private GetListViewDescribeFunction() {
            }

            @Override // com.salesforce.android.service.common.utilities.functional.Function
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public Async<? extends CaseListViewModel> mo12236a(String str) {
                return CaseListPresenter.this.f12724k.mo12713a().mo12171a(ListViewDescribeRequest.m12673a(str)).mo14078b(new GetCaseListFunction());
            }
        }

        private class GetCaseListFunction implements Function<ListViewDescribe, Async<? extends CaseListViewModel>> {
            private GetCaseListFunction() {
            }

            @Override // com.salesforce.android.service.common.utilities.functional.Function
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public Async<? extends CaseListViewModel> mo12236a(ListViewDescribe listViewDescribe) {
                return CaseListPresenter.this.f12724k.mo12713a().mo12165a(CaseListRequest.m12634a(listViewDescribe.mo12500a())).mo14076a(new CreateCaseListItemViewModelsFunction());
            }
        }

        private class CreateCaseListItemViewModelsFunction implements Function<List<CaseListRecord>, CaseListViewModel> {
            private CreateCaseListItemViewModelsFunction() {
            }

            @Override // com.salesforce.android.service.common.utilities.functional.Function
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public CaseListViewModel mo12236a(List<CaseListRecord> list) {
                ArrayList arrayList = new ArrayList(list.size());
                for (CaseListRecord caseListRecord : list) {
                    if (!caseListRecord.mo12471f() && CaseListPresenter.this.f12715b.getContext() != null) {
                        arrayList.add(new CaseListItemViewModel(CaseListPresenter.this.f12715b.getContext().getApplicationContext(), caseListRecord));
                    }
                }
                Collections.sort(arrayList, CaseListPresenter.this.f12722i);
                CaseListPresenter.this.f12721h = new CaseListViewModel(arrayList);
                return CaseListPresenter.this.f12721h;
            }
        }
    }

    private class SetCaseReadHandler implements Async.CompletionHandler, Async.ErrorHandler {

        /* JADX INFO: renamed from: b */
        private final CaseListItemViewModel f12735b;

        SetCaseReadHandler(CaseListItemViewModel caseListItemViewModel) {
            this.f12735b = caseListItemViewModel;
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
        /* JADX INFO: renamed from: a */
        public void mo12580a(Async<?> async) {
            CaseListPresenter.this.f12723j.mo14190c("Successfully updated case last read date.");
            this.f12735b.m12920a(false);
            CaseListPresenter.this.m12889e(this.f12735b);
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
        /* JADX INFO: renamed from: a */
        public void mo12581a(Async<?> async, Throwable th) {
            CaseListPresenter.this.f12723j.mo14193d("An error occurred while trying to update a case last read date.\n\n{}", th.getMessage());
        }
    }

    private class SetCaseHiddenHandler implements Async.CompletionHandler, Async.ErrorHandler {

        /* JADX INFO: renamed from: b */
        private final CaseListItemViewModel f12732b;

        /* JADX INFO: renamed from: c */
        private final boolean f12733c;

        SetCaseHiddenHandler(CaseListItemViewModel caseListItemViewModel, boolean z) {
            this.f12732b = caseListItemViewModel;
            this.f12733c = z;
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
        /* JADX INFO: renamed from: a */
        public void mo12580a(Async<?> async) {
            CaseListPresenter.this.f12723j.mo14191c("Successfully set case {} hidden to {}.", this.f12732b.m12922c(), Boolean.valueOf(this.f12733c));
            if (this.f12733c) {
                CaseListPresenter.this.m12891f(this.f12732b);
            } else {
                CaseListPresenter.this.m12893g(this.f12732b);
            }
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
        /* JADX INFO: renamed from: a */
        public void mo12581a(Async<?> async, Throwable th) {
            CaseListPresenter.this.f12723j.mo14193d("An error occurred while trying to set case {} hidden to {}.\n\n{}", this.f12732b.m12922c(), Boolean.valueOf(this.f12733c), th.getMessage());
        }
    }
}
