package com.salesforce.android.knowledge.ui.internal.articlewebview;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.ui.KnowledgeCssProvider;
import com.salesforce.android.knowledge.ui.KnowledgeJsProvider;
import com.salesforce.android.knowledge.ui.R;
import com.salesforce.android.knowledge.ui.internal.util.HtmlBuilder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ArticleDetailRenderer {
   static final List<String> a = new ArrayList<String>() {
      {
         this.add("Summary");
         this.add("ArticleNumber");
         this.add("UrlName");
      }
   };
   protected final ArticleSummary b;
   private final KnowledgeCssProvider c;
   private final KnowledgeJsProvider d;
   private final int e;
   private final int f;

   private ArticleDetailRenderer(Context var1, ArticleSummary var2, KnowledgeCssProvider var3, KnowledgeJsProvider var4) {
      this.e = ContextCompat.c(var1, R.color.salesforce_brand_secondary);
      this.f = ContextCompat.c(var1, R.color.salesforce_contrast_primary);
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public static ArticleDetailRenderer a(Context var0, ArticleSummary var1, KnowledgeCssProvider var2, KnowledgeJsProvider var3) {
      return new ArticleDetailRenderer(var0, var1, var2, var3);
   }

   public String a(ArticleDetails var1) {
      ArticleDetailRenderer.ArticleBuilder var2 = ArticleDetailRenderer.ArticleBuilder.a();
      var2.b().a(this.f).b(this.e).c(var1.i()).a(var1.c()).a(var1.f()).a(this.c.a(this.b)).b(this.d.a(this.b));
      return var2.c();
   }

   static class ArticleBuilder {
      private final HtmlBuilder a = HtmlBuilder.a();

      private ArticleBuilder() {
      }

      public static ArticleDetailRenderer.ArticleBuilder a() {
         return new ArticleDetailRenderer.ArticleBuilder();
      }

      public ArticleDetailRenderer.ArticleBuilder a(int var1) {
         this.a.a("*", new String[]{"color:#" + Integer.toHexString(16777215 & var1)});
         return this;
      }

      public ArticleDetailRenderer.ArticleBuilder a(String var1) {
         if (!var1.isEmpty()) {
            this.a.b(var1);
         }

         return this;
      }

      public ArticleDetailRenderer.ArticleBuilder a(Date var1) {
         SimpleDateFormat var2 = new SimpleDateFormat("MMMM dd, y", Locale.getDefault());
         this.a.a("modified_date", var2.format(var1));
         return this;
      }

      public ArticleDetailRenderer.ArticleBuilder a(List<ArticleDetails.Field> var1) {
         for (ArticleDetails.Field var2 : var1) {
            if (var2.c() != null && var2.d() != 0 && !ArticleDetailRenderer.a.contains(var2.b())) {
               this.a.b().e(var2.c()).c();
            }
         }

         return this;
      }

      public ArticleDetailRenderer.ArticleBuilder b() {
         this.a.a("CSS_FILE_PLACEHOLDER");
         return this;
      }

      public ArticleDetailRenderer.ArticleBuilder b(int var1) {
         this.a.a("a", new String[]{"color:#" + Integer.toHexString(16777215 & var1)});
         return this;
      }

      public ArticleDetailRenderer.ArticleBuilder b(String var1) {
         if (!var1.isEmpty()) {
            this.a.c(var1);
         }

         return this;
      }

      public ArticleDetailRenderer.ArticleBuilder c(String var1) {
         this.a.d(var1);
         return this;
      }

      public String c() {
         return this.a.d();
      }
   }
}
