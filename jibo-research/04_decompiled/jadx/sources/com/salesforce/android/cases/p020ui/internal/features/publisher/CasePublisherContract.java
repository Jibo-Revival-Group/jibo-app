package com.salesforce.android.cases.p020ui.internal.features.publisher;

import android.support.v4.app.FragmentManager;
import com.salesforce.android.cases.core.model.CaseField;
import com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel.CasePickListViewModel;
import com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel.CaseTextInputViewModel;
import com.salesforce.android.cases.p020ui.internal.features.shared.BasePresenter;
import com.salesforce.android.cases.p020ui.internal.features.shared.BaseView;

/* JADX INFO: loaded from: classes.dex */
public interface CasePublisherContract {

    public interface Presenter extends BasePresenter<Void, View> {

        public interface Listener {
            /* JADX INFO: renamed from: d */
            void mo12931d();
        }

        /* JADX INFO: renamed from: a */
        void mo12932a();

        /* JADX INFO: renamed from: a */
        void mo12933a(Listener listener);

        /* JADX INFO: renamed from: b */
        void mo12934b();

        /* JADX INFO: renamed from: c */
        void mo12935c();

        /* JADX INFO: renamed from: f */
        void mo12936f();

        /* JADX INFO: renamed from: g */
        boolean mo12937g();

        /* JADX INFO: renamed from: h */
        void mo12938h();
    }

    public interface View extends BaseView {
        /* JADX INFO: renamed from: a */
        CaseTextInputViewModel mo12939a(CaseField caseField);

        /* JADX INFO: renamed from: b */
        CasePickListViewModel mo12940b(CaseField caseField);

        /* JADX INFO: renamed from: c */
        void mo12941c();

        /* JADX INFO: renamed from: e */
        void mo12942e();

        /* JADX INFO: renamed from: f */
        void mo12943f();

        /* JADX INFO: renamed from: g */
        void mo12944g();

        /* JADX INFO: renamed from: h */
        void mo12945h();

        /* JADX INFO: renamed from: i */
        void mo12946i();

        /* JADX INFO: renamed from: j */
        void mo12947j();

        /* JADX INFO: renamed from: k */
        void mo12948k();

        /* JADX INFO: renamed from: l */
        void mo12949l();

        /* JADX INFO: renamed from: m */
        void mo12950m();

        /* JADX INFO: renamed from: n */
        void mo12951n();

        /* JADX INFO: renamed from: p_ */
        void mo12952p_();

        /* JADX INFO: renamed from: q_ */
        void mo12953q_();

        /* JADX INFO: renamed from: r_ */
        void mo12954r_();

        void setFragmentManager(FragmentManager fragmentManager);

        void setPresenter(Presenter presenter);
    }
}
