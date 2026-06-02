package com.salesforce.android.cases.ui.internal.features.caselist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.ui.internal.features.caselist.viewmodel.CaseListItemViewModel;
import com.salesforce.android.cases.ui.internal.features.caselist.viewmodel.CaseListViewModel;
import com.salesforce.android.cases.ui.internal.utils.VerticalDividerItemDecoration;
import com.salesforce.android.cases.ui.internal.utils.ViewUtils;
import com.salesforce.android.service.common.ui.views.SalesforceProgressSpinner;
import com.salesforce.android.service.common.ui.views.SalesforceTitleTextToolbar;

public class CaseListView extends CoordinatorLayout implements SwipeRefreshLayout.OnRefreshListener, CaseListContract.View {
   SalesforceTitleTextToolbar f;
   SalesforceProgressSpinner g;
   SwipeRefreshLayout h;
   RecyclerView i;
   ViewGroup j;
   ViewGroup k;
   ViewGroup l;
   Snackbar m;
   Snackbar n;
   Snackbar o;
   FloatingActionButton p;
   CaseListAdapter q;
   private CaseListContract.Presenter r;
   private int s;

   public CaseListView(Context var1) {
      this(var1, null);
   }

   public CaseListView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public CaseListView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a(var1, var2, var3);
   }

   private void a(Context var1, AttributeSet var2, int var3) {
      var1.getTheme().obtainStyledAttributes(var2, new int[]{R.attr.colorControlNormal}, var3, 0).recycle();
      LayoutInflater.from(var1).inflate(R.layout.case_list_view, this, true);
      this.f = (SalesforceTitleTextToolbar)this.findViewById(R.id.toolbar);
      this.g = (SalesforceProgressSpinner)this.findViewById(R.id.progress_spinner);
      this.h = (SwipeRefreshLayout)this.findViewById(R.id.case_list_swipe_refresh);
      this.i = (RecyclerView)this.findViewById(R.id.case_list_recycler);
      this.j = (ViewGroup)this.findViewById(R.id.case_list_empty_view);
      this.k = (ViewGroup)this.findViewById(R.id.case_generic_error_view);
      this.l = (ViewGroup)this.findViewById(R.id.case_network_error_view);
      this.p = (FloatingActionButton)this.findViewById(R.id.create_case_button);
      if (this.p != null) {
         this.p.setOnClickListener(new OnClickListener(this) {
            final CaseListView a;

            {
               this.a = var1;
            }

            public void onClick(View var1) {
               this.a.q();
            }
         });
      }

      if (this.f != null) {
         this.f.setNavigationIcon(VectorDrawableCompat.a(this.getResources(), R.drawable.cases_ic_clear, null));
         this.f.setNavigationOnClickListener(new OnClickListener(this) {
            final CaseListView a;

            {
               this.a = var1;
            }

            public void onClick(View var1) {
               this.a.r();
            }
         });
         this.f.setNavigationContentDescription(R.string.cases_close_button_text);
      }

      if (this.k != null) {
         ((TextView)this.k.findViewById(R.id.case_generic_error_message)).setText(R.string.cases_list_view_error_subtitle_text);
      }

      this.s();
      this.u();
   }

   private void a(Snackbar var1) {
      ViewUtils.a(
         var1,
         ContextCompat.c(this.getContext(), R.color.cases_error_snackbar_background_color),
         ContextCompat.c(this.getContext(), R.color.cases_error_snackbar_text_color)
      );
      var1.c();
   }

   private void s() {
      if (this.h != null) {
         this.h.setOnRefreshListener(this);
      }
   }

   private void t() {
      this.i.getLayoutManager().e(0);
   }

   private void u() {
      if (this.i != null) {
         Resources var1 = this.getResources();
         this.i.setLayoutManager(new LinearLayoutManager(this.getContext(), 1, false));
         this.i
            .addItemDecoration(
               new VerticalDividerItemDecoration(
                  ContextCompat.a(this.getContext(), R.drawable.cases_list_divider),
                  var1.getDimensionPixelSize(R.dimen.cases_case_list_divider_left_padding),
                  0
               )
            );
         this.q = new CaseListAdapter(this, this.getContext()) {
            final CaseListView a;

            {
               this.a = var1;
            }

            @Override
            void a(CaseListItemViewModel var1) {
               this.a.d(var1);
            }
         };
         this.q.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(this) {
            final CaseListView a;

            {
               this.a = var1;
            }

            @Override
            public void a(int var1, int var2) {
               if (var1 == 0) {
                  this.a.t();
               }
            }

            @Override
            public void b(int var1, int var2) {
               if (var1 == 0) {
                  this.a.t();
               }
            }
         });
         this.i.setAdapter(this.q);
         new ItemTouchHelper(new CaseListView.SwipeCallback(this)).a(this.i);
         this.i.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
            final CaseListView a;

            {
               this.a = var1;
            }

            @Override
            public void a(RecyclerView var1, int var2, int var3) {
               this.a.b(var3);
            }
         });
      }
   }

   @Override
   public void a(CaseListItemViewModel var1) {
      if (this.q != null && this.q.getItemCount() > 0) {
         this.q.b(var1);
      }
   }

   @Override
   public void a(CaseListItemViewModel var1, int var2) {
      if (this.q != null) {
         this.q.a(var1, var2);
      }
   }

   @Override
   public void a(CaseListViewModel var1) {
      ViewUtils.b(this.h);
      ViewUtils.b(this.i);
      this.i.requestLayout();
      this.q.a(var1.a());
   }

   void b(int var1) {
      if (this.o != null) {
         this.s = this.s + Math.abs(var1);
         if (this.s >= 200) {
            this.o.d();
            this.o = null;
         }
      }
   }

   @Override
   public void b(CaseListItemViewModel var1) {
      if (this.q != null && this.q.getItemCount() > 0) {
         this.q.c(var1);
      }
   }

   @Override
   public void c() {
      ViewUtils.c(this.g);
   }

   @Override
   public void c(CaseListItemViewModel var1) {
      this.o = Snackbar.a(this, R.string.cases_case_list_item_removed_snackbar_message_text, -2)
         .a(new Snackbar.Callback(this) {
            final CaseListView a;

            {
               this.a = var1;
            }

            @Override
            public void a(Snackbar var1) {
               this.a.s = 0;
            }

            @Override
            public void a(Snackbar var1, int var2) {
               this.a.s = 0;
               this.a.o = null;
            }
         })
         .e(ContextCompat.c(this.getContext(), R.color.cases_default_snackbar_text_color))
         .a(R.string.cases_snackbar_undo_action_text, new OnClickListener(this, var1) {
            final CaseListItemViewModel a;
            final CaseListView b;

            {
               this.b = var1;
               this.a = var2;
            }

            public void onClick(View var1) {
               if (this.b.r != null) {
                  this.b.r.c(this.a);
               }
            }
         });
      ViewUtils.a(this.o, ContextCompat.c(this.getContext(), R.color.cases_default_snackbar_text_color));
      this.o.c();
   }

   void d(CaseListItemViewModel var1) {
      if (this.r != null) {
         this.r.a(var1);
      }
   }

   @Override
   public void e() {
      this.h.setRefreshing(false);
   }

   void e(CaseListItemViewModel var1) {
      if (this.r != null) {
         this.r.b(var1);
      }
   }

   @Override
   public void f() {
      this.p.a();
   }

   @Override
   public void g() {
      this.p.b();
   }

   @Override
   public void h() {
      ViewUtils.b(this.h);
      ViewUtils.b(this.j);
   }

   @Override
   public void i() {
      ViewUtils.c(this.j);
   }

   @Override
   public void j() {
      ViewUtils.b(this.k);
   }

   @Override
   public void k() {
      this.m = Snackbar.a(this, R.string.cases_generic_error_title_text, -2)
         .e(ContextCompat.c(this.getContext(), R.color.cases_error_snackbar_action_text_color))
         .a(R.string.cases_snackbar_retry_action_text, new OnClickListener(this) {
            final CaseListView a;

            {
               this.a = var1;
            }

            public void onClick(View var1) {
               this.a.o();
               this.a.m = null;
            }
         });
      this.a(this.m);
   }

   @Override
   public void l() {
      ViewUtils.b(this.l);
   }

   @Override
   public void l_() {
      ViewUtils.b(this.g);
   }

   @Override
   public void m() {
      this.n = Snackbar.a(this, R.string.cases_network_error_title_text, -2)
         .e(ContextCompat.c(this.getContext(), R.color.cases_error_snackbar_action_text_color))
         .a(R.string.cases_snackbar_retry_action_text, new OnClickListener(this) {
            final CaseListView a;

            {
               this.a = var1;
            }

            public void onClick(View var1) {
               this.a.p();
               this.a.n = null;
            }
         });
      this.a(this.n);
   }

   @Override
   public void m_() {
      this.h.setRefreshing(true);
   }

   @Override
   public void n() {
      Snackbar var1 = Snackbar.a(this, R.string.cases_case_list_out_of_date_snackbar_text, -2)
         .a(R.string.cases_snackbar_refresh_action_text, new OnClickListener(this) {
            final CaseListView a;

            {
               this.a = var1;
            }

            public void onClick(View var1) {
               this.a.r.h();
            }
         });
      ViewUtils.b(var1, ContextCompat.c(this.getContext(), R.color.cases_snackbar_refresh_text_color));
      var1.c();
   }

   @Override
   public void n_() {
      if (this.r != null) {
         this.r.h();
      }

      if (this.o != null && this.o.e()) {
         this.o.d();
      }
   }

   void o() {
      if (this.r != null) {
         this.r.c();
      }
   }

   void p() {
      if (this.r != null) {
         this.r.f();
      }
   }

   void q() {
      if (this.r != null) {
         this.r.a();
      }
   }

   void r() {
      if (this.r != null) {
         this.r.b();
      }
   }

   @Override
   public void setPresenter(CaseListContract.Presenter var1) {
      this.r = var1;
   }

   @Override
   public void setTitle(String var1) {
      this.f.setTitleText(var1);
   }

   private class SwipeCallback extends ItemTouchHelper.SimpleCallback {
      final CaseListView a;
      private Drawable b;
      private Drawable c;
      private int d;

      SwipeCallback(CaseListView var1) {
         super(0, 12);
         this.a = var1;
         this.b = new ColorDrawable(ContextCompat.c(var1.getContext(), R.color.salesforce_feedback_secondary));
         this.c = VectorDrawableCompat.a(var1.getResources(), R.drawable.cases_ic_check, var1.getContext().getTheme());
         this.d = var1.getResources().getDimensionPixelSize(R.dimen.cases_case_list_check_horizontal_margin);
      }

      @Override
      public void a(Canvas var1, RecyclerView var2, RecyclerView.ViewHolder var3, float var4, float var5, int var6, boolean var7) {
         if (var6 == 1) {
            SwipeRefreshLayout var22 = this.a.h;
            boolean var21;
            if (!var7) {
               var21 = true;
            } else {
               var21 = false;
            }

            var22.setEnabled(var21);
            View var29 = var3.itemView;
            float var9 = Math.abs(var4) / var29.getWidth();
            int var14 = var29.getBottom();
            int var11 = var29.getTop();
            int var13 = var29.getRight();
            int var12 = var29.getLeft();
            int var16 = var29.getTop();
            int var15 = var29.getBottom();
            float var8 = 0.5F * var9;
            int var18 = this.c.getIntrinsicWidth();
            int var17 = this.c.getIntrinsicHeight();
            float var10 = var18;
            int var20 = (int)(var18 * var8 + var10);
            var10 = var17;
            var17 = (int)(var8 * var17 + var10);
            var18 = var16 + (var14 - var11 - var17) / 2;
            int var19 = (int)(var9 * 255.0F);
            if (var4 > 0.0F) {
               var11 = var29.getLeft();
               var13 = (int)var4;
               var14 = var12 + this.d;
               var12 = var14 + var20;
            } else {
               var11 = (int)(var13 + var4);
               var12 = var13 - this.d;
               var14 = var12 - var20;
            }

            this.b.setBounds(var11, var16, var13, var15);
            this.b.draw(var1);
            this.c.setBounds(var14, var18, var12, var17 + var18);
            this.c.setAlpha(var19);
            this.c.draw(var1);
            super.a(var1, var2, var3, var4, var5, var6, var7);
         }
      }

      @Override
      public void a(RecyclerView.ViewHolder var1, int var2) {
         CaseListItemViewModel var3 = this.a.q.a(var1.getAdapterPosition());
         if (var3 != null) {
            this.a.e(var3);
         }
      }

      @Override
      public boolean b(RecyclerView var1, RecyclerView.ViewHolder var2, RecyclerView.ViewHolder var3) {
         return false;
      }
   }
}
