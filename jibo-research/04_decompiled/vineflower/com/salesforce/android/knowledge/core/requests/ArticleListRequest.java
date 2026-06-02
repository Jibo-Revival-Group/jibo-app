package com.salesforce.android.knowledge.core.requests;

import com.salesforce.android.knowledge.core.KnowledgeClient;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class ArticleListRequest extends KnowledgeRequest {
   private final String a;
   private final String b;
   private final int c;
   private final int d;
   private final int e;
   private final CharSequence f;
   private final int g;
   private final int h;

   ArticleListRequest(ArticleListRequest.Builder var1) {
      super(var1);
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
      this.e = var1.e;
      this.f = var1.f;
      this.g = var1.g;
      this.h = var1.h;
   }

   public static ArticleListRequest.Builder a() {
      return new ArticleListRequest.Builder();
   }

   public int b() {
      return this.c;
   }

   public int c() {
      return this.d;
   }

   public String d() {
      switch (this.e) {
         case 1:
            return "BELOW";
         default:
            throw new IllegalArgumentException("Unknown query method");
      }
   }

   public int e() {
      return this.g;
   }

   public String f() {
      String var1;
      switch (this.g) {
         case 1:
            var1 = "LastPublishedDate";
            break;
         case 2:
            var1 = "Title";
            break;
         case 3:
            var1 = "ViewScore";
            break;
         default:
            throw new IllegalArgumentException("Unknown sortBy");
      }

      return var1;
   }

   public int g() {
      return this.h;
   }

   public String h() {
      String var1;
      if (this.h == 1) {
         var1 = "ASC";
      } else {
         var1 = "DESC";
      }

      return var1;
   }

   public String i() {
      return this.b;
   }

   public String j() {
      return this.a;
   }

   public CharSequence k() {
      return this.f;
   }

   public static class Builder extends KnowledgeRequest.KnowledgeRequestBuilder<ArticleListRequest.Builder> {
      String a;
      String b;
      int c = 1;
      int d = 3;
      int e = 1;
      CharSequence f;
      int g = 1;
      int h = 2;

      Builder() {
      }

      public ArticleListRequest.Builder a(int var1) {
         boolean var2 = true;
         if (var1 < 1) {
            var2 = false;
         }

         Arguments.a(var2, "Page number must be greater than zero.");
         this.c = var1;
         return this;
      }

      public ArticleListRequest.Builder a(CharSequence var1) {
         this.f = var1;
         return this;
      }

      public ArticleListRequest.Builder a(String var1, String var2) {
         this.a = var1;
         this.b = var2;
         return this;
      }

      public ArticleListRequest a() {
         return new ArticleListRequest(this);
      }

      public Async<ArticleList> a(KnowledgeClient var1) {
         return var1.a(this.a());
      }

      public ArticleListRequest.Builder b(int var1) {
         boolean var2 = true;
         if (var1 < 1) {
            var2 = false;
         }

         Arguments.a(var2, "Page size must be greater than zero.");
         this.d = var1;
         return this;
      }

      public ArticleListRequest.Builder c(int var1) {
         this.e = var1;
         return this;
      }

      protected ArticleListRequest.Builder e() {
         return this;
      }
   }
}
