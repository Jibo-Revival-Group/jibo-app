package com.salesforce.android.knowledge.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Xml.Encoding;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.ui.internal.articlewebview.ArticleDetailRenderer;
import com.salesforce.android.knowledge.ui.internal.articlewebview.ArticleDetailWebClient;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;

public class ArticleWebView extends WebView {
   BasicAsync<Void> a;
   ArticleWebView.WebResourceErrorListener b;

   public ArticleWebView(Context var1) {
      super(var1);
   }

   public ArticleWebView(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public ArticleWebView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   @SuppressLint("SetJavaScriptEnabled")
   public Async<Void> a(ArticleDetails var1, ArticleWebViewConfiguration var2) {
      this.a = BasicAsync.g();
      this.b = var2.d();
      this.setBackgroundColor(ContextCompat.c(this.getContext(), R.color.salesforce_contrast_inverted));
      WebSettings var3 = this.getSettings();
      var3.setDefaultTextEncodingName("utf-8");
      var3.setJavaScriptEnabled(true);
      ArticleDetailWebClient var4 = ArticleDetailWebClient.a(var2.a().b().b());
      var4.a(new ArticleWebView.ArticleWebViewResultsListener(this));
      this.setWebViewClient(var4);
      ArticleDetailRenderer var5 = ArticleDetailRenderer.a(this.getContext(), var1, var2.b(), var2.c());
      this.loadDataWithBaseURL(var2.a().a(), var5.a(var1), "text/html", Encoding.UTF_8.toString(), null);
      return this.a;
   }

   public void a() {
      ViewParent var1 = this.getParent();
      if (var1 instanceof ViewGroup) {
         ((ViewGroup)var1).removeAllViews();
      }

      this.clearHistory();
      this.clearCache(true);
      this.destroy();
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if (this.a != null && !this.a.d()) {
         this.a.c();
      }

      this.a = null;
   }

   class ArticleWebViewResultsListener implements ArticleDetailWebClient.Listener {
      final ArticleWebView a;

      ArticleWebViewResultsListener(ArticleWebView var1) {
         this.a = var1;
      }

      @Override
      public void a() {
         if (this.a.a != null) {
            this.a.a.a();
            this.a.a = null;
         }
      }

      @Override
      public void a(Uri var1, int var2, String var3) {
         this.a.b.a(var1, var2, var3);
      }
   }

   public interface WebResourceErrorListener {
      void a(Uri var1, int var2, String var3);
   }
}
