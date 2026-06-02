package com.salesforce.android.knowledge.ui.internal.articledetail;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.ui.ArticleWebView;
import com.salesforce.android.knowledge.ui.ArticleWebViewConfiguration;
import com.salesforce.android.knowledge.ui.KnowledgeUIClient;
import com.salesforce.android.knowledge.ui.R;
import com.salesforce.android.knowledge.ui.internal.toolbar.ToolbarViewBinder;
import com.salesforce.android.knowledge.ui.internal.views.TintedCollapsingToolbarLayout;
import com.salesforce.android.service.common.utilities.control.Async;

public class ArticleDetailViewBinder extends ToolbarViewBinder implements ArticleDetailView {
   protected TintedCollapsingToolbarLayout a;
   private final ArticleDetailPresenter b;
   private AppBarLayout c;
   private ImageView d;
   private View e;
   private ArticleWebView f;
   private View g;
   private View h;
   private View i;
   private View j;
   private View k;

   private ArticleDetailViewBinder(ArticleDetailPresenter var1) {
      super(var1);
      this.b = var1;
   }

   public static ArticleDetailViewBinder a(ArticleDetailPresenter var0) {
      return new ArticleDetailViewBinder(var0);
   }

   @Override
   public Context a() {
      return this.g.getContext();
   }

   @Override
   public View a(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.g = var1.inflate(R.layout.knowledge_fragment_article_detail, var2, false);
      this.a(this.g);
      this.b.b(this);
      return this.g;
   }

   @Override
   public Async<Void> a(KnowledgeUIClient var1, ArticleDetails var2) {
      ArticleWebViewConfiguration var3 = new ArticleWebViewConfiguration.Builder(var1.c()).a(var1.d()).a(var1.e()).a();
      return this.f.a(var2, var3);
   }

   @Override
   public void a(int var1) {
      byte var3 = 8;
      ArticleWebView var4 = this.f;
      byte var2;
      if (var1 == 1) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      var4.setVisibility(var2);
      View var9 = this.h;
      if (var1 == 0) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      var9.setVisibility(var2);
      View var10 = this.i;
      if (var1 == 2) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      var10.setVisibility(var2);
      View var11 = this.j;
      if (var1 == 3) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      var11.setVisibility(var2);
      View var12 = this.k;
      var2 = var3;
      if (var1 == 4) {
         var2 = 0;
      }

      var12.setVisibility(var2);
      if (this.f.getVisibility() != 0) {
         this.c.setExpanded(false);
      }
   }

   @Override
   public void a(Drawable var1) {
      this.d.setImageDrawable(var1);
      this.e.setBackgroundResource(R.drawable.knowledge_header_gradient);
      this.c.setExpanded(true);
   }

   @Override
   public void a(Menu var1, MenuInflater var2) {
      super.a(var1, var2);
      var2.inflate(R.menu.knowledge_article_menu, var1);
   }

   void a(View var1) {
      this.c = (AppBarLayout)var1.findViewById(R.id.knowledge_article_detail_app_bar_layout);
      this.a = (TintedCollapsingToolbarLayout)var1.findViewById(R.id.knowledge_article_collapsing_toolbar);
      this.e = var1.findViewById(R.id.knowledge_article_header_gradient);
      this.d = (ImageView)var1.findViewById(R.id.knowledge_article_header_image);
      this.h = var1.findViewById(R.id.knowledge_indeterminate_progress);
      this.i = var1.findViewById(R.id.knowledge_empty_article);
      this.j = var1.findViewById(R.id.knowledge_error);
      this.k = var1.findViewById(R.id.knowledge_network_error);
      this.f = (ArticleWebView)var1.findViewById(R.id.knowledge_article_webview);
      this.a.post(new Runnable(this) {
         final ArticleDetailViewBinder a;

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
   public boolean a(MenuItem var1) {
      boolean var2;
      if (var1.getItemId() == R.id.knowledge_action_minimize) {
         this.b.a();
         var2 = true;
      } else {
         var2 = super.a(var1);
      }

      return var2;
   }

   @Override
   public void b() {
      this.b.a(this);
      this.f.a();
   }

   @Override
   public Toolbar d() {
      return (Toolbar)this.g.findViewById(R.id.knowledge_article_toolbar);
   }
}
