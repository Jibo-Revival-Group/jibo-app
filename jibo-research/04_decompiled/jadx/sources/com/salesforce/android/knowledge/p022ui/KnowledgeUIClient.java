package com.salesforce.android.knowledge.p022ui;

import android.app.Activity;
import com.salesforce.android.knowledge.core.KnowledgeClient;

/* JADX INFO: loaded from: classes.dex */
public interface KnowledgeUIClient {

    public interface OnCloseListener {
        /* JADX INFO: renamed from: a */
        void mo9876a();
    }

    /* JADX INFO: renamed from: a */
    void mo13390a(OnCloseListener onCloseListener);

    /* JADX INFO: renamed from: b */
    void mo13391b();

    /* JADX INFO: renamed from: b */
    void mo13392b(Activity activity);

    /* JADX INFO: renamed from: c */
    KnowledgeClient mo13393c();

    /* JADX INFO: renamed from: d */
    KnowledgeCssProvider mo13394d();

    /* JADX INFO: renamed from: e */
    KnowledgeJsProvider mo13395e();
}
