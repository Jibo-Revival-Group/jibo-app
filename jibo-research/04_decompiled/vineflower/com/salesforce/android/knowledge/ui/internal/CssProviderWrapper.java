package com.salesforce.android.knowledge.ui.internal;

import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.ui.KnowledgeCssProvider;

public class CssProviderWrapper implements KnowledgeCssProvider {
   private final KnowledgeCssProvider a;

   private CssProviderWrapper(KnowledgeCssProvider var1) {
      this.a = var1;
   }

   public static CssProviderWrapper a(KnowledgeCssProvider var0) {
      return new CssProviderWrapper(var0);
   }

   @Override
   public String a(ArticleSummary var1) {
      if (this.a != null) {
         String var2 = this.a.a(var1);
         if (var2 != null) {
            return var2;
         }
      }

      return "";
   }
}
