package com.salesforce.android.knowledge.ui.internal.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.ui.R;
import com.salesforce.android.knowledge.ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.ui.internal.util.ListController;
import com.salesforce.android.service.common.utilities.functional.Consumer;
import com.salesforce.android.service.common.utilities.functional.Optional;
import java.util.LinkedList;
import java.util.List;

class HomeListController extends ListController<RecyclerView.ViewHolder> {
   List<Object> a = new LinkedList<>();
   private final LayoutInflater b;
   private final HomePresenter c;

   private HomeListController(LayoutInflater var1, HomePresenter var2) {
      this.b = var1;
      this.c = var2;
   }

   static HomeListController a(LayoutInflater var0, HomePresenter var1) {
      return new HomeListController(var0, var1);
   }

   @Override
   public int a() {
      return this.a.size();
   }

   @Override
   public int a(int var1) {
      Object var2 = this.a.get(var1);
      byte var3;
      if (var2 instanceof DataCategoryInfo) {
         var3 = 1;
      } else {
         if (!(var2 instanceof ArticleList)) {
            throw new IllegalStateException("Item does not exist at position " + var1);
         }

         var3 = 2;
      }

      return var3;
   }

   @Override
   public RecyclerView.ViewHolder a(ViewGroup var1, int var2) {
      RecyclerView.ViewHolder var3;
      switch (var2) {
         case 1:
            var3 = CategoryHeaderViewHolder.a(this.b.inflate(R.layout.knowledge_home_category_item, var1, false), this.c);
            break;
         case 2:
            var3 = CategorySummaryViewHolder.a(this.b.inflate(R.layout.knowledge_home_category_summary, var1, false), this.b, this.c);
            break;
         default:
            throw new IllegalArgumentException("Unknown viewType");
      }

      return var3;
   }

   public Optional<Integer> a(DataCategoryInfo var1) {
      int var2 = this.a.indexOf(var1);
      Optional var3;
      if (var2 == -1) {
         var3 = Optional.a();
      } else {
         var3 = Optional.a(var2);
      }

      return var3;
   }

   @Override
   public void a(RecyclerView.ViewHolder var1, int var2) {
      if (var1.getItemViewType() == 1) {
         DataCategoryInfo var3 = (DataCategoryInfo)this.a.get(var2);
         CategoryHeaderViewHolder var5 = (CategoryHeaderViewHolder)var1;
         var5.a(var5.a(), var3);
      } else if (var1.getItemViewType() == 2) {
         DataCategoryInfo var6 = (DataCategoryInfo)this.a.get(var2 - 1);
         ArticleList var4 = (ArticleList)this.a.get(var2);
         ((CategorySummaryViewHolder)var1).a(var6, var4);
      }
   }

   public void a(DataCategoryInfo var1, ArticleList var2) {
      if (var2 != null) {
         this.a(var1).a(new Consumer<Integer>(this, var2) {
            final ArticleList a;
            final HomeListController b;

            {
               this.b = var1;
               this.a = var2x;
            }

            public void a(Integer var1) {
               int var2x = var1 + 1;
               this.b.a.add(var2x, this.a);
               this.b.c().notifyItemRangeInserted(var2x, 1);
            }
         });
      }
   }

   public void a(List<DataCategoryInfo> var1) {
      this.a.clear();
      this.a.addAll(var1);
      this.c().notifyDataSetChanged();
   }

   public boolean a_(int var1) {
      boolean var2;
      if (var1 < this.a.size()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public void b(DataCategoryInfo var1) {
      this.a(var1).a(new Consumer<Integer>(this) {
         final HomeListController a;

         {
            this.a = var1;
         }

         public void a(Integer var1) {
            int var2 = var1 + 1;
            if (this.a.a_(var2) && this.a.a(var2) == 2) {
               this.a.a.remove(var2);
               this.a.c().notifyItemRangeRemoved(var2, 1);
            }
         }
      });
   }
}
