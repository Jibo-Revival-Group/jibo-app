package com.salesforce.android.knowledge.p022ui.internal.client;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import com.salesforce.android.knowledge.p022ui.KnowledgeScene;
import com.salesforce.android.knowledge.p022ui.KnowledgeViewAddition;
import com.salesforce.android.knowledge.p022ui.internal.activity.KnowledgeActivity;
import com.salesforce.android.knowledge.p022ui.internal.navigation.Navigator;
import com.salesforce.android.service.common.utilities.activity.ActivityReference;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class ViewAdditionController implements Navigator.Listener {

    /* JADX INFO: renamed from: a */
    private final KnowledgeViewAddition f13229a;

    /* JADX INFO: renamed from: b */
    private ActivityReference<KnowledgeActivity> f13230b = ActivityReference.m14053a();

    /* JADX INFO: renamed from: c */
    private WeakReference<View> f13231c = new WeakReference<>(null);

    /* JADX INFO: renamed from: d */
    private Animator f13232d;

    ViewAdditionController(KnowledgeViewAddition knowledgeViewAddition) {
        this.f13229a = knowledgeViewAddition;
    }

    /* JADX INFO: renamed from: a */
    void m13548a(KnowledgeActivity knowledgeActivity, KnowledgeScene knowledgeScene) {
        if (!this.f13230b.m14098a(knowledgeActivity)) {
            View viewMo9878a = this.f13229a.mo9878a((ViewGroup) knowledgeActivity.getWindow().getDecorView(), knowledgeActivity);
            Arguments.m14236a(viewMo9878a, "View addition cannot be null");
            this.f13229a.mo9879a(viewMo9878a, this.f13229a.mo9880a(knowledgeScene));
            knowledgeActivity.addContentView(viewMo9878a, viewMo9878a.getLayoutParams());
            this.f13231c = new WeakReference<>(viewMo9878a);
            this.f13230b = ActivityReference.m14054a(knowledgeActivity);
        }
    }

    @Override // com.salesforce.android.knowledge.ui.internal.navigation.Navigator.Listener
    /* JADX INFO: renamed from: a */
    public void mo13426a(KnowledgeScene knowledgeScene, KnowledgeScene knowledgeScene2) {
        m13547c(knowledgeScene, knowledgeScene2);
    }

    @Override // com.salesforce.android.knowledge.ui.internal.navigation.Navigator.Listener
    /* JADX INFO: renamed from: b */
    public void mo13428b(KnowledgeScene knowledgeScene, KnowledgeScene knowledgeScene2) {
        m13547c(knowledgeScene, knowledgeScene2);
    }

    /* JADX INFO: renamed from: c */
    private void m13547c(KnowledgeScene knowledgeScene, KnowledgeScene knowledgeScene2) {
        View view = this.f13231c.get();
        if (view != null) {
            if (this.f13229a.mo9880a(knowledgeScene2) && !this.f13229a.mo9880a(knowledgeScene)) {
                m13546a(this.f13229a.mo9877a(view));
            } else if (!this.f13229a.mo9880a(knowledgeScene2) && this.f13229a.mo9880a(knowledgeScene)) {
                m13546a(this.f13229a.mo9881b(view));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m13546a(Animator animator) {
        if (this.f13232d != null) {
            this.f13232d.cancel();
        }
        if (animator != null) {
            animator.start();
        }
        this.f13232d = animator;
    }
}
