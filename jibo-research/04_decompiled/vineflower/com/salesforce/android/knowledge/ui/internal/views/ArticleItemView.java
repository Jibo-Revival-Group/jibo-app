package com.salesforce.android.knowledge.ui.internal.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.ui.R;
import com.salesforce.android.knowledge.ui.internal.util.AnimatedOnClickListener;

public class ArticleItemView extends RelativeLayout {
   public ArticleItemView(Context var1) {
      super(var1);
   }

   public ArticleItemView(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public void a(ArticleSummary var1, Drawable var2) {
      TextView var5 = ViewUtil.a(this, R.id.knowledge_article_item_title);
      TextView var4 = ViewUtil.a(this, R.id.knowledge_article_item_summary);
      ImageView var6 = ViewUtil.a(this, R.id.knowledge_article_item_thumbnail);
      if (var5 != null) {
         var5.setText(var1.i());
         var5.addOnLayoutChangeListener(new OnLayoutChangeListener(this, var4, var5, var1) {
            final TextView a;
            final TextView b;
            final ArticleSummary c;
            final ArticleItemView d;

            {
               this.d = var1;
               this.a = var2x;
               this.b = var3;
               this.c = var4x;
            }

            public void onLayoutChange(View var1, int var2x, int var3, int var4x, int var5x, int var6x, int var7, int var8, int var9) {
               if (this.a != null) {
                  var2x = Math.max(1, 3 - this.b.getLineCount());
                  this.a.setMaxLines(var2x);
                  this.a.setText(this.c.j());
               }

               this.b.removeOnLayoutChangeListener(this);
            }
         });
      }

      if (var4 != null) {
         var4.setText(var1.j());
      }

      if (var6 != null) {
         byte var3;
         if (var2 == null) {
            var3 = 8;
         } else {
            var3 = 0;
         }

         var6.setVisibility(var3);
         var6.setImageDrawable(var2);
      }
   }

   public void setOnClickListener(OnClickListener var1) {
      super.setOnClickListener(AnimatedOnClickListener.a(this.getContext(), var1));
   }
}
