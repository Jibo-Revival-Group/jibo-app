package com.salesforce.android.knowledge.p022ui.internal.articlewebview;

import android.net.Uri;
import com.salesforce.android.knowledge.p022ui.ArticleWebView;

/* JADX INFO: loaded from: classes.dex */
public class WebResourcesErrorListenerWrapper implements ArticleWebView.WebResourceErrorListener {

    /* JADX INFO: renamed from: a */
    private final ArticleWebView.WebResourceErrorListener f13178a;

    public WebResourcesErrorListenerWrapper(ArticleWebView.WebResourceErrorListener webResourceErrorListener) {
        this.f13178a = webResourceErrorListener;
    }

    @Override // com.salesforce.android.knowledge.ui.ArticleWebView.WebResourceErrorListener
    /* JADX INFO: renamed from: a */
    public void mo13345a(Uri uri, int i, String str) {
        if (this.f13178a != null) {
            this.f13178a.mo13345a(uri, i, str);
        }
    }
}
