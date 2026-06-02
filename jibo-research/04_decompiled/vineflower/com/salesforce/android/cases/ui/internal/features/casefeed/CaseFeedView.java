package com.salesforce.android.cases.ui.internal.features.casefeed;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.core.internal.util.StringUtils;
import com.salesforce.android.cases.ui.internal.features.casefeed.adapter.MessageViewFactory;
import com.salesforce.android.cases.ui.internal.utils.ViewUtils;
import com.salesforce.android.service.common.ui.internal.android.LayoutInflaterFactory;
import com.salesforce.android.service.common.ui.internal.messaging.MessageFeedAdapter;
import com.salesforce.android.service.common.ui.internal.text.SalesforceTextWatcher;
import com.salesforce.android.service.common.ui.views.SalesforceProgressSpinner;
import com.salesforce.android.service.common.ui.views.SalesforceTitleTextToolbar;
import java.util.Iterator;
import java.util.List;

public class CaseFeedView extends CoordinatorLayout implements CaseFeedContract.View, SalesforceTextWatcher.OnAfterTextChangedListener {
   CaseFeedContract.Presenter f;
   SalesforceProgressSpinner g;
   View h;
   ViewGroup i;
   ViewGroup j;
   SalesforceTitleTextToolbar k;
   SwipeRefreshLayout l;
   EditText m;
   View n;
   MessageFeedAdapter o;
   RecyclerView p;
   SalesforceTextWatcher q;

   public CaseFeedView(Context var1) {
      this(var1, null);
   }

   public CaseFeedView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public CaseFeedView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a(var1);
   }

   private void a(Context var1) {
      LayoutInflater.from(var1).inflate(R.layout.case_feed_view, this, true);
      this.k = (SalesforceTitleTextToolbar)this.findViewById(R.id.toolbar);
      this.h = this.findViewById(R.id.case_feed_container);
      this.p = (RecyclerView)this.findViewById(R.id.recycler_view);
      this.g = (SalesforceProgressSpinner)this.findViewById(R.id.progress_spinner);
      this.i = (ViewGroup)this.findViewById(R.id.case_generic_error_view);
      this.j = (ViewGroup)this.findViewById(R.id.case_network_error_view);
      this.m = (EditText)this.findViewById(R.id.salesforce_message_input);
      this.n = this.findViewById(R.id.salesforce_send_message_button);
      this.q = new SalesforceTextWatcher();
      this.q.a(this);
      if (this.m != null) {
         this.m.getBackground().setColorFilter(ContextCompat.c(var1.getApplicationContext(), R.color.salesforce_contrast_secondary), Mode.SRC_IN);
         Drawable var2 = this.m.getBackground();
         this.m.setHorizontallyScrolling(false);
         this.m.setMaxLines(Integer.MAX_VALUE);
         this.m.addTextChangedListener(this.q);
         this.m.setOnEditorActionListener(new OnEditorActionListener(this) {
            final CaseFeedView a;

            {
               this.a = var1;
            }

            public boolean onEditorAction(TextView var1, int var2x, KeyEvent var3) {
               boolean var4;
               if (var2x == 4 && this.a.n.isEnabled()) {
                  this.a.q();
                  var4 = true;
               } else {
                  var4 = false;
               }

               return var4;
            }
         });
         this.m.setOnFocusChangeListener(new OnFocusChangeListener(this, var1, var2) {
            final Context a;
            final Drawable b;
            final CaseFeedView c;

            {
               this.c = var1;
               this.a = var2x;
               this.b = var3;
            }

            public void onFocusChange(View var1, boolean var2x) {
               if (var2x) {
                  this.c.m.setBackgroundColor(ContextCompat.c(this.a, 17170445));
               } else {
                  this.c.m.setBackground(this.b);
               }
            }
         });
      }

      this.l = (SwipeRefreshLayout)this.findViewById(R.id.swipe_refresh_layout);
      if (this.l != null) {
         this.l.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) {
            final CaseFeedView a;

            {
               this.a = var1;
            }

            @Override
            public void n_() {
               this.a.f.c();
            }
         });
      }

      if (this.k != null) {
         this.k.setNavigationIcon(VectorDrawableCompat.a(this.getResources(), R.drawable.cases_ic_arrow_back, null));
         this.k.setNavigationOnClickListener(new OnClickListener(this) {
            final CaseFeedView a;

            {
               this.a = var1;
            }

            public void onClick(View var1) {
               this.a.p();
            }
         });
         this.k.setNavigationContentDescription(R.string.cases_navigate_back_content_description);
      }

      this.o = new MessageFeedAdapter.Builder().a(new MessageViewFactory()).a(new LayoutInflaterFactory()).a();
      if (this.p != null) {
         this.o.a(this.p);
      }

      if (this.n != null) {
         this.n.setEnabled(false);
         this.n.setOnClickListener(new OnClickListener(this) {
            final CaseFeedView a;

            {
               this.a = var1;
            }

            public void onClick(View var1) {
               this.a.q();
            }
         });
      }
   }

   private void q() {
      this.a(this.m.getText().toString());
   }

   @Override
   public void a(Editable var1) {
      boolean var2;
      if (var1.length() > 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.n.setEnabled(var2);
   }

   @Override
   public void a(Object var1) {
      this.o.a(var1);
      this.p.getLayoutManager().e(this.o.getItemCount() - 1);
   }

   void a(String var1) {
      if (this.f != null && StringUtils.b(var1)) {
         this.f.a(var1);
      }
   }

   @Override
   public void a(List<Object> var1) {
      this.o.a();
      Iterator var2 = var1.iterator();

      while (var2.hasNext()) {
         this.a(var2.next());
      }
   }

   @Override
   public void e() {
      ViewUtils.c(this.i);
   }

   @Override
   public void f() {
      ViewUtils.c(this.j);
   }

   @Override
   public void g() {
      ViewUtils.b(this.i);
   }

   @Override
   public Context getApplicationContext() {
      return this.getContext().getApplicationContext();
   }

   @Override
   public void h() {
      ViewUtils.b(this.j);
   }

   @Override
   public void h_() {
      ViewUtils.b(this.g);
   }

   @Override
   public void i() {
      this.l.setRefreshing(false);
   }

   @Override
   public void i_() {
      ViewUtils.c(this.g);
   }

   @Override
   public void j() {
      this.m.setEnabled(true);
   }

   @Override
   public void j_() {
      ViewUtils.b(this.h);
   }

   @Override
   public void k() {
      Snackbar var1 = Snackbar.a(this, R.string.cases_post_comment_error_snackbar_text, -2)
         .e(ContextCompat.c(this.getContext(), R.color.cases_error_snackbar_action_text_color))
         .a(R.string.cases_snackbar_retry_action_text, new OnClickListener(this) {
            final CaseFeedView a;

            {
               this.a = var1;
            }

            public void onClick(View var1) {
               this.a.q();
            }
         });
      ViewUtils.a(
         var1,
         ContextCompat.c(this.getContext(), R.color.cases_error_snackbar_background_color),
         ContextCompat.c(this.getContext(), R.color.cases_error_snackbar_text_color)
      );
      var1.c();
   }

   @Override
   public void k_() {
      ViewUtils.c(this.h);
   }

   @Override
   public void l() {
      this.n.setEnabled(false);
   }

   @Override
   public void m() {
      this.n.setEnabled(true);
   }

   @Override
   public void n() {
      this.m.setText("");
   }

   @Override
   public void o() {
      ViewUtils.a(this);
   }

   public void p() {
      this.f.a();
   }

   @Override
   public void setCaseId(String var1) {
      if (this.f != null && var1 != null) {
         this.f.a(var1);
      } else {
         throw new IllegalStateException("CaseFeedContract.Presenter and caseId cannot be null.");
      }
   }

   @Override
   public void setPresenter(CaseFeedContract.Presenter var1) {
      this.f = var1;
   }

   @Override
   public void setTitle(String var1) {
      this.k.setTitleText(var1);
   }
}
