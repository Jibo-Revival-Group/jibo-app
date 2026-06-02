package com.salesforce.android.knowledge.ui.internal.categorydetail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.ui.R;
import com.salesforce.android.knowledge.ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.ui.internal.util.ListController;
import java.util.ArrayList;
import java.util.List;

class CategoryDetailListController extends ListController<RecyclerView.ViewHolder> {
   private boolean a = false;
   private final List<ArticleSummary> b = new ArrayList<>();
   private final List<DataCategoryInfo> c = new ArrayList<>();
   private final CategoryDetailPresenter d;

   private CategoryDetailListController(CategoryDetailPresenter var1) {
      this.d = var1;
   }

   static CategoryDetailListController a(CategoryDetailPresenter var0) {
      return new CategoryDetailListController(var0);
   }

   private int b() {
      int var1;
      if (this.a) {
         var1 = this.b.size() + 2;
      } else {
         var1 = this.b.size() + 1;
      }

      return var1;
   }

   @Override
   public int a() {
      int var2 = this.b.size() + this.c.size();
      int var1 = var2;
      if (this.a) {
         var1 = var2 + 1;
      }

      var2 = var1;
      if (this.c.size() > 0) {
         var2 = var1 + 1;
      }

      return var2;
   }

   @Override
   public int a(int var1) {
      byte var2;
      if (var1 < this.b.size()) {
         var2 = 0;
      } else if (var1 == this.b.size() && this.a) {
         var2 = 1;
      } else if (var1 != this.b.size() && (var1 != this.b.size() + 1 || !this.a)) {
         var2 = 3;
      } else {
         var2 = 2;
      }

      return var2;
   }

   @Override
   public RecyclerView.ViewHolder a(ViewGroup var1, int var2) {
      LayoutInflater var3 = LayoutInflater.from(var1.getContext());
      CategoryDetailViewHolder var4;
      switch (var2) {
         case 0:
            var4 = CategoryDetailViewHolder.a(this.d, var3, var1);
            break;
         case 1:
            View var6 = var3.inflate(R.layout.knowledge_cd_showmore_item, var1, false);
            var4 = new CategoryDetailViewHolder.MoreArticles(this.d, var6);
            break;
         case 2:
            View var5 = var3.inflate(R.layout.knowledge_cd_category_header, var1, false);
            var4 = new CategoryDetailViewHolder.SubCategories(this.d, var5);
            break;
         case 3:
            var4 = CategoryDetailViewHolder.b(this.d, var3, var1);
            break;
         default:
            throw new IllegalArgumentException("Unknown viewType");
      }

      return var4;
   }

   @Override
   public void a(RecyclerView.ViewHolder var1, int var2) {
      switch (this.a(var2)) {
         case 0:
            ((CategoryDetailViewHolder.Article)var1).a(this.b.get(var2));
         case 1:
         case 2:
         default:
            break;
         case 3:
            ((CategoryDetailViewHolder.Category)var1).a(this.c.get(var2 - this.b()));
      }
   }

   void a(List<ArticleSummary> var1) {
      this.c().notifyItemRangeRemoved(0, this.b.size());
      this.b.clear();
      this.b.addAll(var1);
      this.c().notifyItemRangeInserted(0, var1.size());
   }

   void a(boolean var1) {
      if (this.a && !var1) {
         this.a = false;
         this.c().notifyItemRangeRemoved(this.b.size(), 1);
      } else if (!this.a && var1) {
         this.a = true;
         this.c().notifyItemRangeInserted(this.b.size(), 1);
      }
   }

   void b(List<DataCategoryInfo> var1) {
      if (var1.size() != 0) {
         this.c.addAll(var1);
         int var2 = this.b();
         this.c().notifyItemRangeInserted(var2 - 1, var1.size() + 1);
      }
   }
}
