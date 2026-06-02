package com.salesforce.android.knowledge.ui.internal.search;

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
import java.util.Collections;
import java.util.List;

class SearchListController extends ListController<RecyclerView.ViewHolder> {
   final SearchPresenter a;
   SearchListController.OnArticleSelectedListener b;
   List<ArticleSummary> c = Collections.emptyList();
   boolean d;

   private SearchListController(SearchPresenter var1) {
      this.a = var1;
      this.d();
   }

   static SearchListController a(SearchPresenter var0) {
      return new SearchListController(var0);
   }

   private void d() {
      this.c().setHasStableIds(true);
   }

   @Override
   public int a() {
      int var2 = this.c.size();
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
      if (var1 >= this.c.size()) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      return var2;
   }

   @Override
   public RecyclerView.ViewHolder a(ViewGroup var1, int var2) {
      SearchListController.ViewHolder var3;
      if (var2 == 0) {
         var3 = new SearchListController.ViewHolder(LayoutInflater.from(var1.getContext()).inflate(R.layout.knowledge_article_item, var1, false));
      } else {
         if (var2 != 1) {
            throw new IllegalArgumentException("Unknown item type");
         }

         var3 = new SearchListController.ViewHolder(LayoutInflater.from(var1.getContext()).inflate(R.layout.knowledge_loading_more_items, var1, false));
      }

      return var3;
   }

   @Override
   public void a(RecyclerView.ViewHolder var1, int var2) {
      if (this.a(var2) == 0) {
         ArticleSummary var4 = this.c.get(var2);
         Drawable var3 = this.a.b(var4);
         ArticleItemView var5 = (ArticleItemView)var1.itemView;
         var5.a(var4, var3);
         var5.setOnClickListener(new OnClickListener(this, var4) {
            final ArticleSummary a;
            final SearchListController b;

            {
               this.b = var1;
               this.a = var2x;
            }

            public void onClick(View var1) {
               if (this.b.b != null) {
                  this.b.b.a(this.a);
               }
            }
         });
      }
   }

   void a(SearchListController.OnArticleSelectedListener var1) {
      this.b = var1;
   }

   void a(List<ArticleSummary> var1, boolean var2) {
      this.c = new ArrayList<>(var1);
      this.d = var2;
      this.c().notifyItemRangeInserted(0, var1.size());
   }

   @Override
   public long b(int var1) {
      long var2;
      if (this.a(var1) == 0) {
         var2 = this.c.get(var1).g().hashCode();
      } else {
         var2 = 0L;
      }

      return var2;
   }

   void b() {
      int var1 = this.a();
      this.c = Collections.emptyList();
      this.d = false;
      this.c().notifyItemRangeRemoved(0, var1);
   }

   void b(SearchListController.OnArticleSelectedListener var1) {
      if (this.b == var1) {
         this.b = null;
      }
   }

   void b(List<ArticleSummary> var1, boolean var2) {
      int var3 = this.c.size();
      if (this.d && !var2) {
         this.d = false;
         this.c().notifyItemRemoved(var3);
      }

      this.c.addAll(var1);
      this.c().notifyItemRangeInserted(var3, var1.size());
   }

   interface OnArticleSelectedListener {
      void a(ArticleSummary var1);
   }

   public static class ViewHolder extends RecyclerView.ViewHolder {
      public ViewHolder(View var1) {
         super(var1);
      }
   }
}
