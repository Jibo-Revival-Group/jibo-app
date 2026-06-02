package com.salesforce.android.knowledge.ui.internal.articlelist;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.ui.R;
import com.salesforce.android.knowledge.ui.internal.util.ListController;
import com.salesforce.android.knowledge.ui.internal.views.ArticleItemView;
import java.util.ArrayList;
import java.util.List;

public class ArticleListController extends ListController<RecyclerView.ViewHolder> {
   final ArticleListPresenter a;
   private final List<ArticleSummary> b = new ArrayList<>();
   private final Context c;
   private boolean d;

   ArticleListController(Context var1, ArticleListPresenter var2) {
      this.c = var1;
      this.a = var2;
   }

   @Override
   public int a() {
      int var2 = this.b.size();
      byte var1;
      if (this.d) {
         var1 = 1;
      } else {
         var1 = 0;
      }

      return var1 + var2;
   }

   @Override
   public int a(int var1) {
      byte var2;
      if (var1 == this.b.size()) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      return var2;
   }

   @Override
   public RecyclerView.ViewHolder a(ViewGroup var1, int var2) {
      ArticleListController.ViewHolder var3;
      if (var2 == 0) {
         var3 = new ArticleListController.ViewHolder(LayoutInflater.from(this.c).inflate(R.layout.knowledge_article_item, var1, false));
      } else {
         if (var2 != 1) {
            throw new IllegalArgumentException("Unknown item type");
         }

         var3 = new ArticleListController.ViewHolder(LayoutInflater.from(this.c).inflate(R.layout.knowledge_loading_more_items, var1, false));
      }

      return var3;
   }

   @Override
   public void a(RecyclerView.ViewHolder var1, int var2) {
      if (this.a(var2) == 0) {
         ArticleSummary var4 = this.b.get(var2);
         Drawable var3 = this.a.b(var4);
         ArticleItemView var5 = (ArticleItemView)var1.itemView;
         var5.a(var4, var3);
         var5.setOnClickListener(new OnClickListener(this, var4) {
            final ArticleSummary a;
            final ArticleListController b;

            {
               this.b = var1;
               this.a = var2x;
            }

            public void onClick(View var1) {
               this.b.a.a(this.a);
            }
         });
      }
   }

   void a(List<ArticleSummary> var1, boolean var2) {
      int var5 = this.b.size();
      this.b.addAll(var1);
      int var4 = var1.size();
      int var3;
      if (var2 && !this.d) {
         var3 = var4 + 1;
         this.d = true;
      } else {
         var3 = var4;
         if (!var2) {
            var3 = var4;
            if (this.d) {
               this.c().notifyItemRemoved(var5);
               this.d = false;
               var3 = var4;
            }
         }
      }

      this.c().notifyItemRangeInserted(var5, var3);
   }

   static class ViewHolder extends RecyclerView.ViewHolder {
      public ViewHolder(View var1) {
         super(var1);
      }
   }
}
