package com.salesforce.android.knowledge.p022ui.internal.activity;

import android.support.v7.app.AppCompatActivity;
import com.salesforce.android.knowledge.p022ui.KnowledgeScene;
import com.salesforce.android.knowledge.p022ui.R;
import com.salesforce.android.knowledge.p022ui.internal.activity.KnowledgeFragment;
import com.salesforce.android.knowledge.p022ui.internal.navigation.Navigator;
import com.salesforce.android.service.common.utilities.activity.ActivityReference;
import com.salesforce.android.service.common.utilities.functional.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class FragmentLoader implements Navigator.Listener {

    /* JADX INFO: renamed from: a */
    private final KnowledgeFragment.Factory f13101a;

    /* JADX INFO: renamed from: b */
    private ActivityReference<AppCompatActivity> f13102b = ActivityReference.m14053a();

    FragmentLoader(Builder builder) {
        this.f13101a = builder.f13105a;
    }

    /* JADX INFO: renamed from: a */
    public static Builder m13422a() {
        return new Builder();
    }

    /* JADX INFO: renamed from: a */
    public void m13425a(AppCompatActivity appCompatActivity) {
        this.f13102b = ActivityReference.m14054a(appCompatActivity);
        if (!m13424d(appCompatActivity)) {
            m13427b(appCompatActivity);
        }
    }

    @Override // com.salesforce.android.knowledge.ui.internal.navigation.Navigator.Listener
    /* JADX INFO: renamed from: a */
    public void mo13426a(KnowledgeScene knowledgeScene, KnowledgeScene knowledgeScene2) {
        this.f13102b.m14097a(new Consumer<AppCompatActivity>() { // from class: com.salesforce.android.knowledge.ui.internal.activity.FragmentLoader.1
            @Override // com.salesforce.android.service.common.utilities.functional.Consumer
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo13033a(AppCompatActivity appCompatActivity) {
                FragmentLoader.this.m13427b(appCompatActivity);
            }
        });
    }

    @Override // com.salesforce.android.knowledge.ui.internal.navigation.Navigator.Listener
    /* JADX INFO: renamed from: b */
    public void mo13428b(KnowledgeScene knowledgeScene, KnowledgeScene knowledgeScene2) {
        if (knowledgeScene2 != KnowledgeScene.SCENE_NONE) {
            this.f13102b.m14097a(new Consumer<AppCompatActivity>() { // from class: com.salesforce.android.knowledge.ui.internal.activity.FragmentLoader.2
                @Override // com.salesforce.android.service.common.utilities.functional.Consumer
                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public void mo13033a(AppCompatActivity appCompatActivity) {
                    FragmentLoader.this.m13429c(appCompatActivity);
                }
            });
        }
    }

    /* JADX INFO: renamed from: b */
    void m13427b(AppCompatActivity appCompatActivity) {
        m13423a(appCompatActivity, false);
    }

    /* JADX INFO: renamed from: c */
    void m13429c(AppCompatActivity appCompatActivity) {
        m13423a(appCompatActivity, true);
    }

    /* JADX INFO: renamed from: d */
    private boolean m13424d(AppCompatActivity appCompatActivity) {
        return appCompatActivity.getSupportFragmentManager().mo1470a("KnowledgeFragment") != null;
    }

    /* JADX INFO: renamed from: a */
    private void m13423a(AppCompatActivity appCompatActivity, boolean z) {
        appCompatActivity.getSupportFragmentManager().mo1471a().mo1362a(z ? 0 : R.anim.knowledge_fragment_in, z ? R.anim.knowledge_fragment_out : 0).mo1379b(R.id.knowledge_fragment_container, this.f13101a.m13435a(), "KnowledgeFragment").mo1385d();
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        KnowledgeFragment.Factory f13105a;

        Builder() {
        }

        /* JADX INFO: renamed from: a */
        public FragmentLoader m13430a() {
            if (this.f13105a == null) {
                this.f13105a = new KnowledgeFragment.Factory();
            }
            return new FragmentLoader(this);
        }
    }
}
