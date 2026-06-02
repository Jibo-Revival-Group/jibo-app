package com.salesforce.android.knowledge.p022ui.internal.articlewebview;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.p022ui.KnowledgeCssProvider;
import com.salesforce.android.knowledge.p022ui.KnowledgeJsProvider;
import com.salesforce.android.knowledge.p022ui.R;
import com.salesforce.android.knowledge.p022ui.internal.util.HtmlBuilder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ArticleDetailRenderer {

    /* JADX INFO: renamed from: a */
    static final List<String> f13167a = new ArrayList<String>() { // from class: com.salesforce.android.knowledge.ui.internal.articlewebview.ArticleDetailRenderer.1
        {
            add("Summary");
            add("ArticleNumber");
            add("UrlName");
        }
    };

    /* JADX INFO: renamed from: b */
    protected final ArticleSummary f13168b;

    /* JADX INFO: renamed from: c */
    private final KnowledgeCssProvider f13169c;

    /* JADX INFO: renamed from: d */
    private final KnowledgeJsProvider f13170d;

    /* JADX INFO: renamed from: e */
    private final int f13171e;

    /* JADX INFO: renamed from: f */
    private final int f13172f;

    /* JADX INFO: renamed from: a */
    public static ArticleDetailRenderer m13479a(Context context, ArticleSummary articleSummary, KnowledgeCssProvider knowledgeCssProvider, KnowledgeJsProvider knowledgeJsProvider) {
        return new ArticleDetailRenderer(context, articleSummary, knowledgeCssProvider, knowledgeJsProvider);
    }

    private ArticleDetailRenderer(Context context, ArticleSummary articleSummary, KnowledgeCssProvider knowledgeCssProvider, KnowledgeJsProvider knowledgeJsProvider) {
        this.f13171e = ContextCompat.m1840c(context, R.color.salesforce_brand_secondary);
        this.f13172f = ContextCompat.m1840c(context, R.color.salesforce_contrast_primary);
        this.f13168b = articleSummary;
        this.f13169c = knowledgeCssProvider;
        this.f13170d = knowledgeJsProvider;
    }

    /* JADX INFO: renamed from: a */
    public String m13480a(ArticleDetails articleDetails) {
        ArticleBuilder articleBuilderM13481a = ArticleBuilder.m13481a();
        articleBuilderM13481a.m13486b().m13482a(this.f13172f).m13487b(this.f13171e).m13489c(articleDetails.mo13219i()).m13484a(articleDetails.mo13200c()).m13485a(articleDetails.mo13203f()).m13483a(this.f13169c.mo13353a(this.f13168b)).m13488b(this.f13170d.mo13356a(this.f13168b));
        return articleBuilderM13481a.m13490c();
    }

    static class ArticleBuilder {

        /* JADX INFO: renamed from: a */
        private final HtmlBuilder f13173a = HtmlBuilder.m13688a();

        /* JADX INFO: renamed from: a */
        public static ArticleBuilder m13481a() {
            return new ArticleBuilder();
        }

        private ArticleBuilder() {
        }

        /* JADX INFO: renamed from: b */
        public ArticleBuilder m13486b() {
            this.f13173a.m13689a("CSS_FILE_PLACEHOLDER");
            return this;
        }

        /* JADX INFO: renamed from: a */
        public ArticleBuilder m13483a(String str) {
            if (!str.isEmpty()) {
                this.f13173a.m13693b(str);
            }
            return this;
        }

        /* JADX INFO: renamed from: b */
        public ArticleBuilder m13488b(String str) {
            if (!str.isEmpty()) {
                this.f13173a.m13695c(str);
            }
            return this;
        }

        /* JADX INFO: renamed from: c */
        public ArticleBuilder m13489c(String str) {
            this.f13173a.m13696d(str);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public ArticleBuilder m13482a(int i) {
            this.f13173a.m13691a("*", "color:#" + Integer.toHexString(16777215 & i));
            return this;
        }

        /* JADX INFO: renamed from: b */
        public ArticleBuilder m13487b(int i) {
            this.f13173a.m13691a("a", "color:#" + Integer.toHexString(16777215 & i));
            return this;
        }

        /* JADX INFO: renamed from: a */
        public ArticleBuilder m13484a(Date date) {
            this.f13173a.m13690a("modified_date", new SimpleDateFormat("MMMM dd, y", Locale.getDefault()).format(date));
            return this;
        }

        /* JADX INFO: renamed from: a */
        public ArticleBuilder m13485a(List<ArticleDetails.Field> list) {
            for (ArticleDetails.Field field : list) {
                if (field.mo13208c() != null && field.mo13209d() != 0 && !ArticleDetailRenderer.f13167a.contains(field.mo13207b())) {
                    this.f13173a.m13692b().m13698e(field.mo13208c()).m13694c();
                }
            }
            return this;
        }

        /* JADX INFO: renamed from: c */
        public String m13490c() {
            return this.f13173a.m13697d();
        }
    }
}
