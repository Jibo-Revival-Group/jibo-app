package com.salesforce.android.knowledge.p022ui;

import com.salesforce.android.knowledge.core.KnowledgeClient;
import com.salesforce.android.knowledge.p022ui.ArticleWebView;
import com.salesforce.android.knowledge.p022ui.internal.CssProviderWrapper;
import com.salesforce.android.knowledge.p022ui.internal.JsProviderWrapper;
import com.salesforce.android.knowledge.p022ui.internal.articlewebview.WebResourcesErrorListenerWrapper;

/* JADX INFO: loaded from: classes.dex */
public class ArticleWebViewConfiguration {

    /* JADX INFO: renamed from: a */
    final KnowledgeClient f13077a;

    /* JADX INFO: renamed from: b */
    final KnowledgeCssProvider f13078b;

    /* JADX INFO: renamed from: c */
    final KnowledgeJsProvider f13079c;

    /* JADX INFO: renamed from: d */
    final ArticleWebView.WebResourceErrorListener f13080d;

    ArticleWebViewConfiguration(Builder builder) {
        this.f13077a = builder.f13081a;
        this.f13078b = builder.f13082b;
        this.f13079c = builder.f13083c;
        this.f13080d = builder.f13084d;
    }

    /* JADX INFO: renamed from: a */
    public KnowledgeClient m13346a() {
        return this.f13077a;
    }

    /* JADX INFO: renamed from: b */
    public KnowledgeCssProvider m13347b() {
        return this.f13078b;
    }

    /* JADX INFO: renamed from: c */
    public KnowledgeJsProvider m13348c() {
        return this.f13079c;
    }

    /* JADX INFO: renamed from: d */
    public ArticleWebView.WebResourceErrorListener m13349d() {
        return this.f13080d;
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        KnowledgeClient f13081a;

        /* JADX INFO: renamed from: b */
        KnowledgeCssProvider f13082b;

        /* JADX INFO: renamed from: c */
        KnowledgeJsProvider f13083c;

        /* JADX INFO: renamed from: d */
        ArticleWebView.WebResourceErrorListener f13084d;

        public Builder(KnowledgeClient knowledgeClient) {
            this.f13081a = knowledgeClient;
        }

        /* JADX INFO: renamed from: a */
        public Builder m13350a(KnowledgeCssProvider knowledgeCssProvider) {
            this.f13082b = knowledgeCssProvider;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m13351a(KnowledgeJsProvider knowledgeJsProvider) {
            this.f13083c = knowledgeJsProvider;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public ArticleWebViewConfiguration m13352a() {
            this.f13082b = CssProviderWrapper.m13410a(this.f13082b);
            this.f13083c = JsProviderWrapper.m13412a(this.f13083c);
            this.f13084d = new WebResourcesErrorListenerWrapper(this.f13084d);
            return new ArticleWebViewConfiguration(this);
        }
    }
}
