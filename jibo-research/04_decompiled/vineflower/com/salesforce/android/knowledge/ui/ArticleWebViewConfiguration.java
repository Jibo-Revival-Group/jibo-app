package com.salesforce.android.knowledge.ui;

import com.salesforce.android.knowledge.core.KnowledgeClient;
import com.salesforce.android.knowledge.ui.internal.CssProviderWrapper;
import com.salesforce.android.knowledge.ui.internal.JsProviderWrapper;
import com.salesforce.android.knowledge.ui.internal.articlewebview.WebResourcesErrorListenerWrapper;

public class ArticleWebViewConfiguration {
   final KnowledgeClient a;
   final KnowledgeCssProvider b;
   final KnowledgeJsProvider c;
   final ArticleWebView.WebResourceErrorListener d;

   ArticleWebViewConfiguration(ArticleWebViewConfiguration.Builder var1) {
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
   }

   public KnowledgeClient a() {
      return this.a;
   }

   public KnowledgeCssProvider b() {
      return this.b;
   }

   public KnowledgeJsProvider c() {
      return this.c;
   }

   public ArticleWebView.WebResourceErrorListener d() {
      return this.d;
   }

   public static class Builder {
      KnowledgeClient a;
      KnowledgeCssProvider b;
      KnowledgeJsProvider c;
      ArticleWebView.WebResourceErrorListener d;

      public Builder(KnowledgeClient var1) {
         this.a = var1;
      }

      public ArticleWebViewConfiguration.Builder a(KnowledgeCssProvider var1) {
         this.b = var1;
         return this;
      }

      public ArticleWebViewConfiguration.Builder a(KnowledgeJsProvider var1) {
         this.c = var1;
         return this;
      }

      public ArticleWebViewConfiguration a() {
         this.b = CssProviderWrapper.a(this.b);
         this.c = JsProviderWrapper.a(this.c);
         this.d = new WebResourcesErrorListenerWrapper(this.d);
         return new ArticleWebViewConfiguration(this);
      }
   }
}
