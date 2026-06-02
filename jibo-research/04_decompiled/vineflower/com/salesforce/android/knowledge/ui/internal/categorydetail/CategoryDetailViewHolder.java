package com.salesforce.android.knowledge.ui.internal.categorydetail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.ui.R;
import com.salesforce.android.knowledge.ui.internal.models.DataCategoryInfo;
import com.salesforce.android.knowledge.ui.internal.views.ArticleItemView;

public abstract class CategoryDetailViewHolder<T> extends RecyclerView.ViewHolder {
   T a;
   private final CategoryDetailPresenter b;

   CategoryDetailViewHolder(CategoryDetailPresenter var1, View var2) {
      super(var2);
      this.b = var1;
   }

   static CategoryDetailViewHolder.Article a(CategoryDetailPresenter var0, LayoutInflater var1, ViewGroup var2) {
      return new CategoryDetailViewHolder.Article(var0, (ArticleItemView)var1.inflate(R.layout.knowledge_article_item, var2, false));
   }

   static CategoryDetailViewHolder.Category b(CategoryDetailPresenter var0, LayoutInflater var1, ViewGroup var2) {
      return new CategoryDetailViewHolder.Category(var0, var1.inflate(R.layout.knowledge_cd_category_item, var2, false));
   }

   CategoryDetailPresenter a() {
      return this.b;
   }

   void a(T var1) {
      this.a = (T)var1;
      this.c();
   }

   T b() {
      return this.a;
   }

   void c() {
   }

   static class Article extends CategoryDetailViewHolder<ArticleSummary> implements OnClickListener {
      static final boolean b;

      static {
         boolean var0;
         if (!CategoryDetailViewHolder.class.desiredAssertionStatus()) {
            var0 = true;
         } else {
            var0 = false;
         }

         b = var0;
      }

      Article(CategoryDetailPresenter var1, ArticleItemView var2) {
         super(var1, var2);
         var2.setOnClickListener(this);
      }

      @Override
      void c() {
         ArticleSummary var1 = (ArticleSummary)this.b();
         if (!b && var1 == null) {
            throw new AssertionError();
         }

         ((ArticleItemView)this.itemView).a(var1, this.a().b(var1));
      }

      public void onClick(View var1) {
         this.a().a((ArticleSummary)this.b());
      }
   }

   static class Category extends CategoryDetailViewHolder<DataCategoryInfo> implements OnClickListener {
      static final boolean b;

      static {
         boolean var0;
         if (!CategoryDetailViewHolder.class.desiredAssertionStatus()) {
            var0 = true;
         } else {
            var0 = false;
         }

         b = var0;
      }

      public Category(CategoryDetailPresenter var1, View var2) {
         super(var1, var2);
         var2.setOnClickListener(this);
      }

      @Override
      void c() {
         DataCategoryInfo var1 = (DataCategoryInfo)this.b();
         if (!b && var1 == null) {
            throw new AssertionError();
         }

         ((TextView)this.itemView.findViewById(R.id.knowledge_category_category_label)).setText(var1.b());
      }

      public void onClick(View var1) {
         this.a().a((DataCategoryInfo)this.b());
      }
   }

   static class MoreArticles extends CategoryDetailViewHolder<Void> implements OnClickListener {
      public MoreArticles(CategoryDetailPresenter var1, View var2) {
         super(var1, var2);
         var2.setOnClickListener(this);
      }

      public void onClick(View var1) {
         this.a().a();
      }
   }

   static class SubCategories extends CategoryDetailViewHolder<Void> {
      public SubCategories(CategoryDetailPresenter var1, View var2) {
         super(var1, var2);
      }
   }
}
