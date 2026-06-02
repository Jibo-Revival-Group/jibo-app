package com.salesforce.android.knowledge.ui.internal.search;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.ui.R;
import com.salesforce.android.knowledge.ui.internal.ViewBinder;
import com.salesforce.android.knowledge.ui.internal.util.InfiniteScrollListener;
import com.salesforce.android.service.common.ui.internal.text.SalesforceTextWatcher;
import java.util.List;

public class SearchViewBinder
   extends ViewBinder
   implements SearchListController.OnArticleSelectedListener,
   SearchView,
   InfiniteScrollListener.BehaviorListener,
   SalesforceTextWatcher.OnAfterTextChangedListener {
   private final InputMethodManager a;
   private final SearchPresenter b;
   private final SearchListController c;
   private final SalesforceTextWatcher d = new SalesforceTextWatcher();
   private InfiniteScrollListener e;
   private View f;
   private EditText g;
   private View h;
   private View i;
   private View j;
   private View k;
   private RecyclerView l;

   private SearchViewBinder(SearchPresenter var1, SearchListController var2, InputMethodManager var3) {
      this.b = var1;
      this.c = var2;
      this.a = var3;
      this.d.a(this);
   }

   public static SearchViewBinder a(SearchPresenter var0, InputMethodManager var1) {
      return new SearchViewBinder(var0, SearchListController.a(var0), var1);
   }

   private void f() {
      this.a.hideSoftInputFromWindow(this.g.getWindowToken(), 0);
   }

   @Override
   public Context a() {
      return this.f.getContext();
   }

   @Override
   public View a(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.f = var1.inflate(R.layout.knowledge_fragment_search, var2, false);
      this.a(this.f);
      this.c.a(this);
      this.b.b(this);
      if (var3 == null) {
         this.g.requestFocus();
         this.a.toggleSoftInput(2, 0);
      }

      return this.f;
   }

   @Override
   public void a(int var1) {
      byte var3 = 0;
      RecyclerView var4 = this.l;
      byte var2;
      if (var1 == 2) {
         var2 = 0;
      } else {
         var2 = 4;
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
      if (var1 == 1) {
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
      byte var5;
      if (var1 == 4) {
         var5 = var3;
      } else {
         var5 = 8;
      }

      var12.setVisibility(var5);
   }

   @Override
   public void a(Bundle var1) {
      super.a(var1);
      var1.putParcelable("layout_manager_state", this.l.getLayoutManager().d());
   }

   @Override
   public void a(Editable var1) {
      this.b.a(var1);
   }

   void a(View var1) {
      this.g = (EditText)var1.findViewById(R.id.knowledge_search_input);
      this.h = var1.findViewById(R.id.knowledge_search_help);
      this.i = var1.findViewById(R.id.knowledge_search_empty);
      this.j = var1.findViewById(R.id.knowledge_error);
      this.k = var1.findViewById(R.id.knowledge_indeterminate_progress);
      this.l = (RecyclerView)var1.findViewById(R.id.knowledge_search_list);
      LinearLayoutManager var2 = new LinearLayoutManager(this.a());
      this.e = InfiniteScrollListener.a(var2).a(2).a(this);
      this.l.setLayoutManager(var2);
      this.l.setAdapter(this.c.c());
      this.l.addOnScrollListener(this.e);
      this.g.addTextChangedListener(this.d);
   }

   @Override
   public void a(ArticleSummary var1) {
      this.f();
      this.b.a(var1);
   }

   @Override
   public void a(CharSequence var1) {
      this.g.setText(var1);
   }

   @Override
   public void a(List<ArticleSummary> var1, boolean var2) {
      this.c.a(var1, var2);
      this.e.a(var2);
   }

   @Override
   public void b() {
      this.l.stopScroll();
      this.b.a(this);
      this.c.b(this);
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      if (!var1.isEmpty()) {
         Parcelable var2 = var1.getParcelable("layout_manager_state");
         this.l.getLayoutManager().a(var2);
      }
   }

   @Override
   public void b(List<ArticleSummary> var1, boolean var2) {
      this.c.b(var1, var2);
      this.e.a(var2);
   }

   @Override
   public void c() {
      this.c.b();
   }

   @Override
   public void s_() {
      this.b.a();
   }
}
