package com.salesforce.android.cases.p020ui.internal.features.casefeed;

import android.content.Context;
import com.salesforce.android.cases.p020ui.internal.features.shared.BasePresenter;
import com.salesforce.android.cases.p020ui.internal.features.shared.BaseView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface CaseFeedContract {

    public interface Presenter extends BasePresenter<String, View> {

        public interface Listener {
            /* JADX INFO: renamed from: b */
            void mo12747b();
        }

        /* JADX INFO: renamed from: a */
        void mo12749a();

        /* JADX INFO: renamed from: a */
        void mo12750a(Listener listener);

        /* JADX INFO: renamed from: a */
        void mo12751a(String str);

        /* JADX INFO: renamed from: b */
        void mo12752b();

        /* JADX INFO: renamed from: c */
        void mo12753c();
    }

    public interface View extends BaseView {
        /* JADX INFO: renamed from: a */
        void mo12754a(Object obj);

        /* JADX INFO: renamed from: a */
        void mo12755a(List<Object> list);

        /* JADX INFO: renamed from: e */
        void mo12756e();

        /* JADX INFO: renamed from: f */
        void mo12757f();

        /* JADX INFO: renamed from: g */
        void mo12758g();

        Context getApplicationContext();

        /* JADX INFO: renamed from: h */
        void mo12759h();

        /* JADX INFO: renamed from: h_ */
        void mo12760h_();

        /* JADX INFO: renamed from: i */
        void mo12761i();

        /* JADX INFO: renamed from: i_ */
        void mo12762i_();

        /* JADX INFO: renamed from: j */
        void mo12763j();

        /* JADX INFO: renamed from: j_ */
        void mo12764j_();

        /* JADX INFO: renamed from: k */
        void mo12765k();

        /* JADX INFO: renamed from: k_ */
        void mo12766k_();

        /* JADX INFO: renamed from: l */
        void mo12767l();

        /* JADX INFO: renamed from: m */
        void mo12768m();

        /* JADX INFO: renamed from: n */
        void mo12769n();

        /* JADX INFO: renamed from: o */
        void mo12770o();

        void setCaseId(String str);

        void setPresenter(Presenter presenter);

        void setTitle(String str);
    }
}
