package com.salesforce.android.cases.p020ui.internal.features.caselist;

import android.content.Context;
import com.salesforce.android.cases.p020ui.internal.features.caselist.viewmodel.CaseListItemViewModel;
import com.salesforce.android.cases.p020ui.internal.features.caselist.viewmodel.CaseListViewModel;
import com.salesforce.android.cases.p020ui.internal.features.shared.BasePresenter;
import com.salesforce.android.cases.p020ui.internal.features.shared.BaseView;

/* JADX INFO: loaded from: classes.dex */
public interface CaseListContract {

    public interface Presenter extends BasePresenter<Void, View> {

        public interface Listener {
            /* JADX INFO: renamed from: d */
            void mo12835d();
        }

        /* JADX INFO: renamed from: a */
        void mo12847a();

        /* JADX INFO: renamed from: a */
        void mo12848a(Listener listener);

        /* JADX INFO: renamed from: a */
        void mo12849a(CaseListItemViewModel caseListItemViewModel);

        /* JADX INFO: renamed from: b */
        void mo12850b();

        /* JADX INFO: renamed from: b */
        void mo12851b(CaseListItemViewModel caseListItemViewModel);

        /* JADX INFO: renamed from: c */
        void mo12852c();

        /* JADX INFO: renamed from: c */
        void mo12853c(CaseListItemViewModel caseListItemViewModel);

        /* JADX INFO: renamed from: f */
        void mo12854f();

        /* JADX INFO: renamed from: g */
        void mo12855g();

        /* JADX INFO: renamed from: h */
        void mo12856h();

        /* JADX INFO: renamed from: i */
        void mo12857i();
    }

    public interface View extends BaseView {
        /* JADX INFO: renamed from: a */
        void mo12858a(CaseListItemViewModel caseListItemViewModel);

        /* JADX INFO: renamed from: a */
        void mo12859a(CaseListItemViewModel caseListItemViewModel, int i);

        /* JADX INFO: renamed from: a */
        void mo12860a(CaseListViewModel caseListViewModel);

        /* JADX INFO: renamed from: b */
        void mo12861b(CaseListItemViewModel caseListItemViewModel);

        /* JADX INFO: renamed from: c */
        void mo12862c();

        /* JADX INFO: renamed from: c */
        void mo12863c(CaseListItemViewModel caseListItemViewModel);

        /* JADX INFO: renamed from: e */
        void mo12864e();

        /* JADX INFO: renamed from: f */
        void mo12865f();

        /* JADX INFO: renamed from: g */
        void mo12866g();

        Context getContext();

        /* JADX INFO: renamed from: h */
        void mo12867h();

        /* JADX INFO: renamed from: i */
        void mo12868i();

        /* JADX INFO: renamed from: j */
        void mo12869j();

        /* JADX INFO: renamed from: k */
        void mo12870k();

        /* JADX INFO: renamed from: l */
        void mo12871l();

        /* JADX INFO: renamed from: l_ */
        void mo12872l_();

        /* JADX INFO: renamed from: m */
        void mo12873m();

        /* JADX INFO: renamed from: m_ */
        void mo12874m_();

        /* JADX INFO: renamed from: n */
        void mo12875n();

        void setPresenter(Presenter presenter);

        void setTitle(String str);
    }
}
