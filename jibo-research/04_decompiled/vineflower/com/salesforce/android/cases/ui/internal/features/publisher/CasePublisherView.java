package com.salesforce.android.cases.ui.internal.features.publisher;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.core.model.CaseField;
import com.salesforce.android.cases.core.model.CaseFieldType;
import com.salesforce.android.cases.ui.internal.features.publisher.viewmodel.CaseFieldViewModel;
import com.salesforce.android.cases.ui.internal.features.publisher.viewmodel.CasePickListViewModel;
import com.salesforce.android.cases.ui.internal.features.publisher.viewmodel.CaseTextInputViewModel;
import com.salesforce.android.cases.ui.internal.features.shared.SalesforceProgressDialogFragment;
import com.salesforce.android.cases.ui.internal.utils.DrawableUtils;
import com.salesforce.android.cases.ui.internal.utils.ViewUtils;
import com.salesforce.android.service.common.ui.views.SalesforcePickListView;
import com.salesforce.android.service.common.ui.views.SalesforceProgressSpinner;
import com.salesforce.android.service.common.ui.views.SalesforceTextInputLayout;
import com.salesforce.android.service.common.ui.views.SalesforceTitleTextToolbar;

public class CasePublisherView
   extends CoordinatorLayout
   implements Toolbar.OnMenuItemClickListener,
   CasePublisherContract.View,
   SalesforceConfirmationDialogFragment.SalesforceConfirmationDialogListener {
   SalesforceTitleTextToolbar f;
   SalesforceProgressSpinner g;
   ScrollView h;
   LinearLayout i;
   ViewGroup j;
   ViewGroup k;
   ViewGroup l;
   MenuItem m;
   Snackbar n;
   private int o;
   private CasePublisherContract.Presenter p;
   private FragmentManager q;

   public CasePublisherView(Context var1) {
      this(var1, null);
   }

   public CasePublisherView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public CasePublisherView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a(var1);
   }

   private void a(Context var1) {
      this.o = var1.getResources().getDimensionPixelSize(R.dimen.cases_case_publisher_field_spacing);
      LayoutInflater.from(this.getContext()).inflate(R.layout.case_publisher_view, this, true);
      this.f = (SalesforceTitleTextToolbar)this.findViewById(R.id.toolbar);
      this.g = (SalesforceProgressSpinner)this.findViewById(R.id.progress_spinner);
      this.h = (ScrollView)this.findViewById(R.id.case_layout_frame);
      this.i = (LinearLayout)this.findViewById(R.id.case_layout_container);
      this.j = (ViewGroup)this.findViewById(R.id.case_generic_error_view);
      this.k = (ViewGroup)this.findViewById(R.id.case_network_error_view);
      this.l = (ViewGroup)this.findViewById(R.id.case_created_view);
      if (this.f != null) {
         this.f.setNavigationContentDescription(R.string.cases_cancel_button_text);
         this.f.setNavigationIcon(VectorDrawableCompat.a(this.getResources(), R.drawable.cases_ic_clear, null));
         this.f.setNavigationOnClickListener(new OnClickListener(this) {
            final CasePublisherView a;

            {
               this.a = var1;
            }

            public void onClick(View var1) {
               this.a.p();
            }
         });
         this.f.inflateMenu(R.menu.case_publisher_menu);
         this.f.setOnMenuItemClickListener(this);
         DrawableUtils.a(this.f.getMenu(), ContextCompat.c(this.getContext(), R.color.salesforce_contrast_primary), R.id.action_send);
         this.m = this.f.getMenu().findItem(R.id.action_send);
      }
   }

   private void a(CaseFieldViewModel var1) {
      android.widget.LinearLayout.LayoutParams var2 = new android.widget.LinearLayout.LayoutParams(-1, -2);
      var2.bottomMargin = this.o;
      this.i.addView(var1.a(), var2);
   }

   private SalesforceProgressDialogFragment getCreatingCaseDialogFragment() {
      return (SalesforceProgressDialogFragment)this.q.a("createCaseDialogFragment");
   }

   private SalesforceConfirmationDialogFragment getDiscardCaseDialogFragment() {
      return (SalesforceConfirmationDialogFragment)this.q.a("discardCaseDialogFragment");
   }

   private void q() {
      SalesforceConfirmationDialogFragment var1 = this.getDiscardCaseDialogFragment();
      if (var1 != null) {
         var1.a(this);
      }
   }

   @Override
   public CaseTextInputViewModel a(CaseField var1) {
      CaseFieldType var2 = var1.f();
      if (var2 != CaseFieldType.TEXT && var2 != CaseFieldType.EMAIL && var2 != CaseFieldType.TEXT_AREA) {
         throw new IllegalArgumentException("CaseField must be of type CaseFieldType.TEXT, CaseFieldType.EMAIL or CaseFieldType.TEXT_AREA.");
      }

      CaseTextInputViewModel var3 = new CaseTextInputViewModel(
         (SalesforceTextInputLayout)LayoutInflater.from(this.getContext()).inflate(R.layout.case_text_input_view, null, false), var1
      );
      this.a(var3);
      return var3;
   }

   @Override
   public boolean a(MenuItem var1) {
      int var2 = var1.getItemId();
      boolean var3;
      if (R.id.action_send == var2) {
         if (this.p != null) {
            this.p.a();
         }

         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   @Override
   public CasePickListViewModel b(CaseField var1) {
      if (var1.f() != CaseFieldType.PICK_LIST) {
         throw new IllegalArgumentException("CaseField must be of type CaseFieldType.PICK_LIST.");
      }

      CasePickListViewModel var2 = new CasePickListViewModel(
         (SalesforcePickListView)LayoutInflater.from(this.getContext()).inflate(R.layout.case_pick_list_view, null, false), var1
      );
      this.a(var2);
      return var2;
   }

   @Override
   public void c() {
      ViewUtils.b(this.h);
   }

   @Override
   public void e() {
      ViewUtils.b(this.j);
   }

   @Override
   public void f() {
      ViewUtils.b(this.k);
   }

   @Override
   public void g() {
      ViewUtils.b(this.l);
   }

   @Override
   public void h() {
      this.n = Snackbar.a(this, R.string.cases_case_create_error_snackbar_text, -2)
         .e(ContextCompat.c(this.getContext(), R.color.cases_error_snackbar_action_text_color))
         .a(R.string.cases_snackbar_retry_action_text, new OnClickListener(this) {
            final CasePublisherView a;

            {
               this.a = var1;
            }

            public void onClick(View var1) {
               if (this.a.p != null) {
                  this.a.p.c();
               }
            }
         });
      ViewUtils.a(
         this.n,
         ContextCompat.c(this.getContext(), R.color.cases_error_snackbar_background_color),
         ContextCompat.c(this.getContext(), R.color.cases_error_snackbar_text_color)
      );
      this.n.c();
   }

   @Override
   public void i() {
      if (this.n != null) {
         this.n.d();
      }
   }

   @Override
   public void j() {
      if (this.getCreatingCaseDialogFragment() == null) {
         SalesforceProgressDialogFragment.a(R.string.cases_creating_case_progress_dialog_title_text, R.string.cases_creating_case_progress_dialog_message_text)
            .show(this.q, "createCaseDialogFragment");
      }
   }

   @Override
   public void k() {
      SalesforceProgressDialogFragment var1 = this.getCreatingCaseDialogFragment();
      if (var1 != null) {
         var1.dismiss();
      }
   }

   @Override
   public void l() {
      this.m.setVisible(false);
   }

   @Override
   public void m() {
      this.m.setVisible(true);
   }

   @Override
   public void n() {
      if (this.getDiscardCaseDialogFragment() == null) {
         SalesforceConfirmationDialogFragment var1 = SalesforceConfirmationDialogFragment.a(
            R.string.cases_discard_case_confirmation_dialog_title_text, R.string.case_discard_case_confirmation_dialog_message_text
         );
         var1.a(this);
         var1.show(this.q, "discardCaseDialogFragment");
      }
   }

   @Override
   public void o() {
      this.p.h();
   }

   void p() {
      if (this.p != null) {
         this.p.b();
      }
   }

   @Override
   public void p_() {
      ViewUtils.b(this.g);
   }

   @Override
   public void q_() {
      ViewUtils.c(this.g);
   }

   @Override
   public void r_() {
      ViewUtils.c(this.h);
   }

   @Override
   public void setFragmentManager(FragmentManager var1) {
      this.q = var1;
      this.q();
   }

   @Override
   public void setPresenter(CasePublisherContract.Presenter var1) {
      this.p = var1;
   }
}
