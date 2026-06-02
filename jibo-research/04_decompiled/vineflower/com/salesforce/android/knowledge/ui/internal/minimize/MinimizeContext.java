package com.salesforce.android.knowledge.ui.internal.minimize;

import android.graphics.drawable.Drawable;
import com.salesforce.android.knowledge.core.model.ArticleSummary;

public class MinimizeContext {
   final Drawable a;
   final ArticleSummary b;

   private MinimizeContext(Drawable var1, ArticleSummary var2) {
      this.a = var1;
      this.b = var2;
   }

   public static MinimizeContext a(Drawable var0, ArticleSummary var1) {
      Drawable var2 = var0;
      if (var0 != null) {
         var2 = var0.getConstantState().newDrawable().mutate();
      }

      return new MinimizeContext(var2, var1);
   }

   public Drawable a() {
      return this.a;
   }

   public String b() {
      return this.b.i();
   }

   public String c() {
      return this.b.g();
   }
}
