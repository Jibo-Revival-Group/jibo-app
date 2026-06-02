package com.salesforce.android.knowledge.ui.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.core.model.DataCategorySummary;
import com.salesforce.android.knowledge.ui.KnowledgeImageProvider;

public class ImageProviderWrapper implements KnowledgeImageProvider {
   private final KnowledgeImageProvider a;

   private ImageProviderWrapper(KnowledgeImageProvider var1) {
      this.a = var1;
   }

   public static ImageProviderWrapper a(KnowledgeImageProvider var0) {
      return new ImageProviderWrapper(var0);
   }

   @Override
   public Drawable a(Context var1, ArticleSummary var2) {
      Drawable var3 = null;
      if (this.a != null) {
         var3 = this.a.a(var1, var2);
      }

      Drawable var4 = var3;
      if (var3 != null) {
         var4 = var3.getConstantState().newDrawable().mutate();
      }

      return var4;
   }

   @Override
   public Drawable a(Context var1, DataCategorySummary var2) {
      Drawable var3 = null;
      if (this.a != null) {
         var3 = this.a.a(var1, var2);
      }

      Drawable var4 = var3;
      if (var3 != null) {
         var4 = var3.getConstantState().newDrawable().mutate();
      }

      return var4;
   }
}
