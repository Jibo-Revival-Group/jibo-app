package com.salesforce.android.knowledge.ui.internal.articlewebview;

import android.net.Uri;
import com.salesforce.android.knowledge.ui.ArticleWebView;

public class WebResourcesErrorListenerWrapper implements ArticleWebView.WebResourceErrorListener {
   private final ArticleWebView.WebResourceErrorListener a;

   public WebResourcesErrorListenerWrapper(ArticleWebView.WebResourceErrorListener var1) {
      this.a = var1;
   }

   @Override
   public void a(Uri var1, int var2, String var3) {
      if (this.a != null) {
         this.a.a(var1, var2, var3);
      }
   }
}
