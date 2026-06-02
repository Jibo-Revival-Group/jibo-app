package com.salesforce.android.knowledge.ui.internal.categorydetail;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.ui.R;
import com.salesforce.android.knowledge.ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.ui.internal.toolbar.ToolbarViewBinder;
import com.salesforce.android.knowledge.ui.internal.util.DividerDecoration;
import com.salesforce.android.knowledge.ui.internal.util.ScrollPositionListener;
import com.salesforce.android.knowledge.ui.internal.views.TintedCollapsingToolbarLayout;
import java.util.List;

public class CategoryDetailViewBinder extends ToolbarViewBinder implements CategoryDetailView {
   protected TintedCollapsingToolbarLayout a;
   private final CategoryDetailPresenter b;
   private final CategoryDetailListController c;
   private final ScrollPositionListener d;
   private AppBarLayout e;
   private ImageView f;
   private View g;
   private RecyclerView h;
   private View i;
   private View j;
   private View k;

   private CategoryDetailViewBinder(CategoryDetailPresenter var1, CategoryDetailListController var2, ScrollPositionListener var3) {
      super(var1);
      this.b = var1;
      this.c = var2;
      this.d = var3;
   }

   public static CategoryDetailViewBinder a(CategoryDetailPresenter var0) {
      return new CategoryDetailViewBinder(var0, CategoryDetailListController.a(var0), new ScrollPositionListener());
   }

   @Override
   public Context a() {
      return this.g.getContext();
   }

   @Override
   public View a(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.g = var1.inflate(R.layout.knowledge_fragment_category_detail, var2, false);
      this.a(this.g);
      this.b.b(this);
      return this.g;
   }

   @Override
   public void a(int var1) {
      byte var3 = 8;
      View var4 = this.i;
      byte var2;
      if (var1 == 0) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      var4.setVisibility(var2);
      RecyclerView var8 = this.h;
      if (var1 == 1) {
         var2 = 0;
      } else {
         var2 = 4;
      }

      var8.setVisibility(var2);
      var4 = this.j;
      if (var1 == 2) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      var4.setVisibility(var2);
      var4 = this.k;
      var2 = var3;
      if (var1 == 3) {
         var2 = 0;
      }

      var4.setVisibility(var2);
      if (this.h.getVisibility() != 0) {
         this.e.setExpanded(false);
      }
   }

   @Override
   public void a(Drawable var1) {
      this.f.setImageDrawable(var1);
   }

   @Override
   public void a(Bundle var1) {
      super.a(var1);
      var1.putParcelable("layout_manager_state", this.h.getLayoutManager().d());
      this.d.a(var1);
   }

   void a(View var1) {
      this.e = (AppBarLayout)var1.findViewById(R.id.knowledge_category_detail_app_bar_layout);
      this.a = (TintedCollapsingToolbarLayout)var1.findViewById(R.id.knowledge_category_detail_collapse_toolbar);
      this.f = (ImageView)var1.findViewById(R.id.knowledge_category_detail_header_image);
      this.h = (RecyclerView)var1.findViewById(R.id.knowledge_category_detail_body);
      this.i = var1.findViewById(R.id.knowledge_indeterminate_progress);
      this.j = var1.findViewById(R.id.knowledge_empty_category);
      this.k = var1.findViewById(R.id.knowledge_error);
      DividerDecoration var2 = new DividerDecoration(ContextCompat.a(var1.getContext(), R.drawable.knowledge_background_border));
      this.h.addItemDecoration(var2);
      this.h.setLayoutManager(new LinearLayoutManager(var1.getContext()));
      this.h.setAdapter(this.c.c());
      this.h.addOnScrollListener(this.d);
      this.a.post(new Runnable(this) {
         final CategoryDetailViewBinder a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.a.requestLayout();
         }
      });
   }

   @Override
   public void a(String var1) {
      this.a.setTitle(var1);
   }

   @Override
   public void a(List<ArticleSummary> var1, List<DataCategoryInfo> var2, boolean var3) {
      this.c.a(var1);
      this.c.b(var2);
      this.c.a(var3);
   }

   @Override
   public void b() {
      this.h.stopScroll();
      this.b.a(this);
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      if (!var1.isEmpty()) {
         Parcelable var2 = var1.getParcelable("layout_manager_state");
         this.d.b(var1);
         if (this.d.b() > 0) {
            this.e.a(false, false);
         }

         RecyclerView var3 = this.h;
         var3.post(new Runnable(this, var3, var2) {
            final RecyclerView a;
            final Parcelable b;
            final CategoryDetailViewBinder c;

            {
               this.c = var1;
               this.a = var2x;
               this.b = var3x;
            }

            @Override
            public void run() {
               this.a.getLayoutManager().a(this.b);
            }
         });
      }
   }

   @Override
   public Toolbar d() {
      return (Toolbar)this.g.findViewById(R.id.knowledge_category_detail_toolbar);
   }
}
