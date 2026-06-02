package com.salesforce.android.knowledge.p022ui.internal.navigation;

import android.content.Context;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.p022ui.KnowledgeScene;
import com.salesforce.android.knowledge.p022ui.KnowledgeUIAnalyticsEmit;
import com.salesforce.android.knowledge.p022ui.internal.client.KnowledgeUIClientImpl;
import com.salesforce.android.knowledge.p022ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.p022ui.internal.navigation.NavigationStack;
import com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class Navigator {

    /* JADX INFO: renamed from: a */
    private final KnowledgeUIClientImpl f13373a;

    /* JADX INFO: renamed from: b */
    private final NavigationStack f13374b;

    /* JADX INFO: renamed from: c */
    private final ViewBinderFactory f13375c;

    /* JADX INFO: renamed from: d */
    private final Set<Listener> f13376d;

    public interface Listener {
        /* JADX INFO: renamed from: a */
        void mo13426a(KnowledgeScene knowledgeScene, KnowledgeScene knowledgeScene2);

        /* JADX INFO: renamed from: b */
        void mo13428b(KnowledgeScene knowledgeScene, KnowledgeScene knowledgeScene2);
    }

    /* JADX INFO: renamed from: a */
    public static Builder m13633a(KnowledgeUIClientImpl knowledgeUIClientImpl) {
        return new Builder(knowledgeUIClientImpl);
    }

    Navigator(Builder builder) {
        this.f13373a = builder.f13377a;
        this.f13374b = builder.f13378b;
        this.f13375c = builder.f13379c;
        this.f13376d = Collections.unmodifiableSet(new HashSet(builder.f13380d));
    }

    /* JADX INFO: renamed from: a */
    public ViewState m13637a(Context context) {
        NavigationStack.Entry entryPeek = this.f13374b.peek();
        return new ViewState(this.f13375c.m13651a(context, entryPeek.m13630a()), entryPeek.m13632c());
    }

    /* JADX INFO: renamed from: a */
    public void m13639a(Context context, String str) {
        if (this.f13374b.isEmpty()) {
            m13642b(context, str);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m13642b(Context context, String str) {
        m13635a(KnowledgeScene.SCENE_HOME, this.f13373a.m13533h().m13658a(context, str));
    }

    /* JADX INFO: renamed from: a */
    public void m13640a(ArticleSummary articleSummary) {
        m13635a(KnowledgeScene.SCENE_ARTICLE_DETAIL, this.f13373a.m13533h().m13656a(articleSummary));
    }

    /* JADX INFO: renamed from: a */
    public void m13641a(DataCategoryInfo dataCategoryInfo) {
        m13635a(KnowledgeScene.SCENE_ARTICLE_LIST, this.f13373a.m13533h().m13657a(dataCategoryInfo));
    }

    /* JADX INFO: renamed from: b */
    public void m13643b(DataCategoryInfo dataCategoryInfo) {
        m13635a(KnowledgeScene.SCENE_CATEGORY_DETAIL, this.f13373a.m13533h().m13660b(dataCategoryInfo));
    }

    /* JADX INFO: renamed from: a */
    public void m13638a() {
        this.f13374b.m13626a(KnowledgeScene.SCENE_SEARCH);
        m13635a(KnowledgeScene.SCENE_SEARCH, this.f13373a.m13533h().m13659a());
    }

    /* JADX INFO: renamed from: b */
    public boolean m13644b() {
        NavigationStack.Entry entryM13628b = this.f13374b.m13628b();
        return entryM13628b != null && entryM13628b.m13631b() == KnowledgeScene.SCENE_HOME;
    }

    /* JADX INFO: renamed from: c */
    public boolean m13645c() {
        return this.f13374b.isEmpty();
    }

    /* JADX INFO: renamed from: d */
    public void m13646d() {
        if (!m13645c()) {
            m13636b(this.f13374b.pop().m13631b(), this.f13374b.m13625a());
        }
    }

    /* JADX INFO: renamed from: e */
    public KnowledgeScene m13647e() {
        return this.f13374b.m13625a();
    }

    /* JADX INFO: renamed from: a */
    private void m13635a(KnowledgeScene knowledgeScene, Presenter<?> presenter) {
        KnowledgeScene knowledgeSceneM13631b = this.f13374b.isEmpty() ? KnowledgeScene.SCENE_NONE : this.f13374b.peek().m13631b();
        this.f13374b.push(new NavigationStack.Entry(knowledgeScene, presenter));
        m13634a(knowledgeSceneM13631b, knowledgeScene);
    }

    /* JADX INFO: renamed from: a */
    private void m13634a(KnowledgeScene knowledgeScene, KnowledgeScene knowledgeScene2) {
        Iterator<Listener> it = this.f13376d.iterator();
        while (it.hasNext()) {
            it.next().mo13426a(knowledgeScene, knowledgeScene2);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m13636b(KnowledgeScene knowledgeScene, KnowledgeScene knowledgeScene2) {
        KnowledgeUIAnalyticsEmit.m13362a(knowledgeScene, knowledgeScene2);
        Iterator<Listener> it = this.f13376d.iterator();
        while (it.hasNext()) {
            it.next().mo13428b(knowledgeScene, knowledgeScene2);
        }
    }

    /* JADX INFO: renamed from: f */
    public void m13648f() {
        while (!this.f13374b.isEmpty()) {
            this.f13374b.pop();
        }
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        final KnowledgeUIClientImpl f13377a;

        /* JADX INFO: renamed from: b */
        NavigationStack f13378b;

        /* JADX INFO: renamed from: c */
        ViewBinderFactory f13379c;

        /* JADX INFO: renamed from: d */
        final Set<Listener> f13380d = new HashSet();

        public Builder(KnowledgeUIClientImpl knowledgeUIClientImpl) {
            this.f13377a = knowledgeUIClientImpl;
        }

        /* JADX INFO: renamed from: a */
        public Builder m13649a(Listener listener) {
            this.f13380d.add(listener);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Navigator m13650a() {
            if (this.f13378b == null) {
                this.f13378b = new NavigationStack();
            }
            if (this.f13379c == null) {
                this.f13379c = new ViewBinderFactory();
            }
            return new Navigator(this);
        }
    }
}
