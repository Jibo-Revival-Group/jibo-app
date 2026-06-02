package com.salesforce.android.knowledge.p022ui.internal.articlewebview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.salesforce.android.knowledge.core.offline.OfflineResourceCache;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class ArticleDetailWebClient extends WebViewClient {

    /* JADX INFO: renamed from: b */
    private static final ServiceLogger f13174b = ServiceLogging.m14203a((Class<?>) ArticleDetailWebClient.class);

    /* JADX INFO: renamed from: a */
    Listener f13175a;

    /* JADX INFO: renamed from: c */
    private final OfflineResourceCache f13176c;

    /* JADX INFO: renamed from: d */
    private final IntentFactory f13177d;

    public interface Listener {
        /* JADX INFO: renamed from: a */
        void mo13343a();

        /* JADX INFO: renamed from: a */
        void mo13344a(Uri uri, int i, String str);
    }

    /* JADX INFO: renamed from: a */
    public static ArticleDetailWebClient m13491a(OfflineResourceCache offlineResourceCache) {
        return new ArticleDetailWebClient(offlineResourceCache, new IntentFactory());
    }

    ArticleDetailWebClient(OfflineResourceCache offlineResourceCache, IntentFactory intentFactory) {
        this.f13176c = offlineResourceCache;
        this.f13177d = intentFactory;
    }

    /* JADX INFO: renamed from: a */
    public void m13494a(Listener listener) {
        this.f13175a = listener;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(19)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (m13495a(Uri.parse(str))) {
            return m13493a(webView.getContext());
        }
        InputStream inputStreamM13290a = this.f13176c.m13290a(str);
        if (inputStreamM13290a != null) {
            return new WebResourceResponse(null, null, inputStreamM13290a);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.getContext().startActivity(this.f13177d.m13496a("android.intent.action.VIEW", Uri.parse(str)));
        return true;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        webView.getContext().startActivity(this.f13177d.m13496a("android.intent.action.VIEW", webResourceRequest.getUrl()));
        return true;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (m13495a(webResourceRequest.getUrl())) {
            return m13493a(webView.getContext());
        }
        InputStream inputStreamM13290a = this.f13176c.m13290a(webResourceRequest.getUrl().toString());
        if (inputStreamM13290a != null) {
            return new WebResourceResponse(null, null, inputStreamM13290a);
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (this.f13175a != null) {
            this.f13175a.mo13343a();
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        m13492a(webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        m13492a(i, str, Uri.parse(str2));
    }

    /* JADX INFO: renamed from: a */
    private void m13492a(int i, String str, Uri uri) {
        if (this.f13175a != null) {
            this.f13175a.mo13344a(uri, i, str);
        }
    }

    /* JADX INFO: renamed from: a */
    boolean m13495a(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        return lastPathSegment != null && lastPathSegment.equals("CSS_FILE_PLACEHOLDER");
    }

    /* JADX INFO: renamed from: a */
    WebResourceResponse m13493a(Context context) {
        try {
            return new WebResourceResponse("text/css", "utf-8", context.getAssets().open("knowledge_article_details.css"));
        } catch (IOException e) {
            f13174b.mo14195e("Unable to load CSS asset file {}: {}", "knowledge_article_details.css", e.getMessage());
            return null;
        }
    }

    static class IntentFactory {
        IntentFactory() {
        }

        /* JADX INFO: renamed from: a */
        Intent m13496a(String str, Uri uri) {
            return new Intent(str, uri);
        }
    }
}
