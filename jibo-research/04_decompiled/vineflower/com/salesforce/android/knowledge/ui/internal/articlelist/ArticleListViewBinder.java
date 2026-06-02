package com.salesforce.android.knowledge.ui.internal.articlelist;

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
import com.salesforce.android.knowledge.ui.internal.toolbar.ToolbarViewBinder;
import com.salesforce.android.knowledge.ui.internal.util.DividerDecoration;
import com.salesforce.android.knowledge.ui.internal.util.InfiniteScrollListener;
import com.salesforce.android.knowledge.ui.internal.views.TintedCollapsingToolbarLayout;
import java.util.List;

public class ArticleListViewBinder extends ToolbarViewBinder implements ArticleListView {
   final ArticleListPresenter a;
   final ArticleListController b;
   private final InfiniteScrollListener c;
   private View d;
   private ImageView e;
   private AppBarLayout f;
   private TintedCollapsingToolbarLayout g;
   private RecyclerView h;
   private View i;
   private View j;
   private View k;

   private ArticleListViewBinder(ArticleListPresenter var1, ArticleListController var2, InfiniteScrollListener var3) {
      super(var1);
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public static ArticleListViewBinder a(Context var0, ArticleListPresenter var1) {
      return new ArticleListViewBinder(var1, new ArticleListController(var0, var1), InfiniteScrollListener.a(new LinearLayoutManager(var0)));
   }

   @Override
   public Context a() {
      return this.d.getContext();
   }

   @Override
   public View a(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.d = var1.inflate(R.layout.knowledge_fragment_article_list, var2, false);
      this.a(this.d);
      this.a.b(this);
      return this.d;
   }

   @Override
   public void a(int var1) {
      byte var3 = 8;
      RecyclerView var4 = this.h;
      byte var2;
      if (var1 == 1) {
         var2 = 0;
      } else {
         var2 = 4;
      }

      var4.setVisibility(var2);
      View var8 = this.i;
      if (var1 == 2) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      var8.setVisibility(var2);
      View var9 = this.j;
      if (var1 == 3) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      var9.setVisibility(var2);
      View var10 = this.k;
      var2 = var3;
      if (var1 == 4) {
         var2 = 0;
      }

      var10.setVisibility(var2);
      if (var1 == 2 || var1 == 3) {
         this.f.setExpanded(false);
      }
   }

   @Override
   public void a(Drawable var1) {
      this.e.setImageDrawable(var1);
   }

   @Override
   public void a(Bundle var1) {
      super.a(var1);
      var1.putParcelable("layout_manager_state", this.h.getLayoutManager().d());
      this.c.a(var1);
   }

   void a(View var1) {
      this.h = (RecyclerView)var1.findViewById(R.id.knowledge_article_list_body);
      this.i = var1.findViewById(R.id.knowledge_empty_category);
      this.e = (ImageView)var1.findViewById(R.id.knowledge_article_list_header_image);
      this.f = (AppBarLayout)var1.findViewById(R.id.knowledge_article_list_app_bar_layout);
      this.g = (TintedCollapsingToolbarLayout)var1.findViewById(R.id.knowledge_article_list_collapse_toolbar);
      this.j = var1.findViewById(R.id.knowledge_error);
      this.k = var1.findViewById(R.id.knowledge_indeterminate_progress);
      this.c.a(2).a(new InfiniteScrollListener.BehaviorListener(this) {
         final ArticleListViewBinder a;

         {
            this.a = var1;
         }

         @Override
         public void s_() {
            this.a.a.a();
         }
      });
      DividerDecoration var2 = new DividerDecoration(ContextCompat.a(var1.getContext(), R.drawable.knowledge_background_border));
      this.h.addItemDecoration(var2);
      this.h.setLayoutManager(this.c.a());
      this.h.setAdapter(this.b.c());
      this.h.addOnScrollListener(this.c);
      this.h.setVisibility(8);
      this.i.setVisibility(8);
      this.j.setVisibility(8);
      this.g.post(new Runnable(this) {
         final ArticleListViewBinder a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.g.requestLayout();
         }
      });
   }

   @Override
   public void a(String var1) {
      this.g.setTitle(var1);
   }

   @Override
   public void a(List<ArticleSummary> var1, boolean var2) {
      this.b.a(var1, var2);
      this.c.a(var2);
   }

   @Override
   public void b() {
      this.h.stopScroll();
      this.a.a(this);
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      if (!var1.isEmpty()) {
         Parcelable var2 = var1.getParcelable("layout_manager_state");
         this.c.b(var1);
         if (this.c.b() > 0) {
            this.f.a(false, false);
         }

         RecyclerView var3 = this.h;
         var3.post(new Runnable(this, var3, var2) {
            final RecyclerView a;
            final Parcelable b;
            final ArticleListViewBinder c;

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
      return (Toolbar)this.d.findViewById(R.id.knowledge_article_list_toolbar);
   }
}
