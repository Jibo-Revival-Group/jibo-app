package com.salesforce.android.knowledge.ui.internal;

import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.ui.KnowledgeJsProvider;

public class JsProviderWrapper implements KnowledgeJsProvider {
   private final KnowledgeJsProvider a;

   private JsProviderWrapper(KnowledgeJsProvider var1) {
      this.a = var1;
   }

   public static JsProviderWrapper a(KnowledgeJsProvider var0) {
      return new JsProviderWrapper(var0);
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
