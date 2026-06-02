package com.salesforce.android.knowledge.ui.internal.home;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.ui.R;
import com.salesforce.android.knowledge.ui.internal.ViewBinder;
import com.salesforce.android.knowledge.ui.internal.models.DataCategoryInfo;
import com.salesforce.android.service.common.utilities.functional.Consumer;
import java.util.List;

public class HomeViewBinder extends ViewBinder implements HomeView {
   final HomePresenter a;
   final HomeListController b;
   View c;
   View d;
   View e;
   View f;
   RecyclerView g;

   private HomeViewBinder(HomePresenter var1, HomeListController var2) {
      this.a = var1;
      this.b = var2;
   }

   public static HomeViewBinder a(Context var0, HomePresenter var1) {
      return a(var1, HomeListController.a(LayoutInflater.from(var0), var1));
   }

   static HomeViewBinder a(HomePresenter var0, HomeListController var1) {
      return new HomeViewBinder(var0, var1);
   }

   @Override
   public Context a() {
      return this.c.getContext();
   }

   @Override
   public View a(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.c = var1.inflate(R.layout.knowledge_fragment_home, var2, false);
      this.a(this.c);
      this.a.b(this);
      return this.c;
   }

   @Override
   public void a(int var1) {
      byte var3 = 0;
      View var4 = this.d;
      byte var2;
      if (var1 == 0) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      var4.setVisibility(var2);
      RecyclerView var8 = this.g;
      if (var1 == 1) {
         var2 = 0;
      } else {
         var2 = 4;
      }

      var8.setVisibility(var2);
      var4 = this.e;
      if (var1 == 3) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      var4.setVisibility(var2);
      var4 = this.f;
      byte var5;
      if (var1 == 4) {
         var5 = var3;
      } else {
         var5 = 8;
      }

      var4.setVisibility(var5);
   }

   void a(int var1, boolean var2) {
      CategoryHeaderViewHolder var3 = (CategoryHeaderViewHolder)this.g.findViewHolderForAdapterPosition(var1);
      if (var3 != null) {
         var3.a(var2);
      }
   }

   @Override
   public void a(Bundle var1) {
      super.a(var1);
      var1.putParcelable("layout_manager_state", this.g.getLayoutManager().d());
   }

   void a(View var1) {
      this.d = var1.findViewById(R.id.knowledge_indeterminate_progress);
      this.g = (RecyclerView)var1.findViewById(R.id.knowledge_category_list);
      this.e = var1.findViewById(R.id.knowledge_error);
      this.f = var1.findViewById(R.id.knowledge_network_error);
      var1.findViewById(R.id.knowledge_home_close).setOnClickListener(new OnClickListener(this) {
         final HomeViewBinder a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            this.a.a.a();
         }
      });
      var1.findViewById(R.id.knowledge_home_search).setOnClickListener(new OnClickListener(this) {
         final HomeViewBinder a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            this.a.a.d();
         }
      });
      this.g.setLayoutManager(new ScrollToTopLayoutManager(var1.getContext()));
      this.g.setAdapter(this.b.c());
   }

   @Override
   public void a(DataCategoryInfo var1) {
      this.b.a(var1).a(new Consumer<Integer>(this, var1) {
         final DataCategoryInfo a;
         final HomeViewBinder b;

         {
            this.b = var1;
            this.a = var2;
         }

         public void a(Integer var1) {
            this.b.a(var1, false);
            this.b.b.b(this.a);
         }
      });
   }

   @Override
   public void a(DataCategoryInfo var1, ArticleList var2) {
      this.b.a(var1).a(new Consumer<Integer>(this, var1, var2) {
         final DataCategoryInfo a;
         final ArticleList b;
         final HomeViewBinder c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public void a(Integer var1) {
            this.c.a(var1, true);
            this.c.b.a(this.a, this.b);
            this.c.g.scrollToPosition(var1);
         }
      });
   }

   @Override
   public void a(List<DataCategoryInfo> var1) {
      this.b.a(var1);
   }

   @Override
   public void b() {
      this.g.stopScroll();
      this.a.a(this);
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      if (!var1.isEmpty()) {
         Parcelable var2 = var1.getParcelable("layout_manager_state");
         this.g.getLayoutManager().a(var2);
      }
   }

   @Override
   public int e() {
      return 17170445;
   }
}
