package com.salesforce.android.knowledge.core.requests;

import com.salesforce.android.knowledge.core.KnowledgeClient;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.service.common.utilities.control.Async;

public class ArticleDetailRequest extends KnowledgeRequest {
   final String a;
   final boolean b;

   ArticleDetailRequest(ArticleDetailRequest.Builder var1) {
      super(var1);
      this.a = var1.a;
      this.b = var1.b;
   }

   public static ArticleDetailRequest.Builder a(ArticleSummary var0) {
      return new ArticleDetailRequest.Builder(var0.g());
   }

   public String a() {
      return this.a;
   }

   public boolean b() {
      return this.b;
   }

   public static class Builder extends KnowledgeRequest.KnowledgeRequestBuilder<ArticleDetailRequest.Builder> {
      final String a;
      boolean b = true;

      Builder(String var1) {
         this.a = var1;
      }

      public ArticleDetailRequest a() {
         return new ArticleDetailRequest(this);
      }

      public Async<ArticleDetails> a(KnowledgeClient var1) {
         return var1.a(this.a());
      }

      protected ArticleDetailRequest.Builder e() {
         return this;
      }
   }
}
