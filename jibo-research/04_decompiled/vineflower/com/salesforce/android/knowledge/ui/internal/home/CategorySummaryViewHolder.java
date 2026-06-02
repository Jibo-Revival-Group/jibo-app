package com.salesforce.android.knowledge.ui.internal.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.ui.R;
import com.salesforce.android.knowledge.ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.ui.internal.views.ArticleItemView;
import java.util.List;

class CategorySummaryViewHolder extends RecyclerView.ViewHolder {
   final LayoutInflater a;
   final HomePresenter b;
   final LinearLayout c;
   final View d;
   final View e;

   private CategorySummaryViewHolder(View var1, LayoutInflater var2, HomePresenter var3) {
      super(var1);
      this.d = var1.findViewById(R.id.knowledge_empty_category);
      this.c = (LinearLayout)var1.findViewById(R.id.knowledge_category_article_summary_list);
      this.e = var1.findViewById(R.id.knowledge_category_show_more_container);
      this.a = var2;
      this.b = var3;
   }

   public static CategorySummaryViewHolder a(View var0, LayoutInflater var1, HomePresenter var2) {
      return new CategorySummaryViewHolder(var0, var1, var2);
   }

   public void a(DataCategoryInfo var1, ArticleList var2) {
      byte var4 = 8;
      List var7 = var2.a();
      boolean var6 = var7.isEmpty();
      boolean var5 = var2.c();
      View var9 = this.d;
      byte var3;
      if (var6) {
         var3 = 0;
      } else {
         var3 = 8;
      }

      var9.setVisibility(var3);
      LinearLayout var10 = this.c;
      if (var6) {
         var3 = 8;
      } else {
         var3 = 0;
      }

      var10.setVisibility(var3);
      View var11 = this.e;
      var3 = var4;
      if (var5) {
         var3 = 0;
      }

      var11.setVisibility(var3);
      this.e.setOnClickListener(new OnClickListener(this, var1) {
         final DataCategoryInfo a;
         final CategorySummaryViewHolder b;

         {
            this.b = var1;
            this.a = var2x;
         }

         public void onClick(View var1) {
            this.b.b.b(this.a);
         }
      });
      this.c.removeAllViews();

      for (ArticleSummary var15 : var7) {
         ArticleItemView var12 = (ArticleItemView)this.a.inflate(R.layout.knowledge_article_item, this.c, false);
         var12.a(var15, this.b.b(var15));
         var12.setOnClickListener(new OnClickListener(this, var15) {
            final ArticleSummary a;
            final CategorySummaryViewHolder b;

            {
               this.b = var1;
               this.a = var2x;
            }

            public void onClick(View var1) {
               this.b.b.a(this.a);
            }
         });
         this.c.addView(var12);
      }
   }
}
