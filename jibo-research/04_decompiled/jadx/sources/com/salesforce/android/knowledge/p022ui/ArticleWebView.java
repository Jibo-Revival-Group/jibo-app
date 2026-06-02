package com.salesforce.android.knowledge.p022ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.p022ui.internal.articlewebview.ArticleDetailRenderer;
import com.salesforce.android.knowledge.p022ui.internal.articlewebview.ArticleDetailWebClient;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;

/* JADX INFO: loaded from: classes.dex */
public class ArticleWebView extends WebView {

    /* JADX INFO: renamed from: a */
    BasicAsync<Void> f13074a;

    /* JADX INFO: renamed from: b */
    WebResourceErrorListener f13075b;

    public interface WebResourceErrorListener {
        /* JADX INFO: renamed from: a */
        void mo13345a(Uri uri, int i, String str);
    }

    public ArticleWebView(Context context) {
        super(context);
    }

    public ArticleWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ArticleWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f13074a != null && !this.f13074a.mo14081d()) {
            this.f13074a.mo14080c();
        }
        this.f13074a = null;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* JADX INFO: renamed from: a */
    public Async<Void> m13341a(ArticleDetails articleDetails, ArticleWebViewConfiguration articleWebViewConfiguration) {
        this.f13074a = BasicAsync.m14086g();
        this.f13075b = articleWebViewConfiguration.m13349d();
        setBackgroundColor(ContextCompat.m1840c(getContext(), R.color.salesforce_contrast_inverted));
        WebSettings settings = getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        settings.setJavaScriptEnabled(true);
        ArticleDetailWebClient articleDetailWebClientM13491a = ArticleDetailWebClient.m13491a(articleWebViewConfiguration.m13346a().mo13071b().m13295b());
        articleDetailWebClientM13491a.m13494a(new ArticleWebViewResultsListener());
        setWebViewClient(articleDetailWebClientM13491a);
        loadDataWithBaseURL(articleWebViewConfiguration.m13346a().mo13069a(), ArticleDetailRenderer.m13479a(getContext(), articleDetails, articleWebViewConfiguration.m13347b(), articleWebViewConfiguration.m13348c()).m13480a(articleDetails), "text/html", Xml.Encoding.UTF_8.toString(), null);
        return this.f13074a;
    }

    /* JADX INFO: renamed from: a */
    public void m13342a() {
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeAllViews();
        }
        clearHistory();
        clearCache(true);
        destroy();
    }

    class ArticleWebViewResultsListener implements ArticleDetailWebClient.Listener {
        ArticleWebViewResultsListener() {
        }

        @Override // com.salesforce.android.knowledge.ui.internal.articlewebview.ArticleDetailWebClient.Listener
        /* JADX INFO: renamed from: a */
        public void mo13343a() {
            if (ArticleWebView.this.f13074a != null) {
                ArticleWebView.this.f13074a.mo12613b();
                ArticleWebView.this.f13074a = null;
            }
        }

        @Override // com.salesforce.android.knowledge.ui.internal.articlewebview.ArticleDetailWebClient.Listener
        /* JADX INFO: renamed from: a */
        public void mo13344a(Uri uri, int i, String str) {
            ArticleWebView.this.f13075b.mo13345a(uri, i, str);
        }
    }
}
