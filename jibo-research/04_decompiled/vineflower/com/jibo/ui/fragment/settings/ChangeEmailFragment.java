package com.jibo.ui.fragment.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.account.model.ChangeEmailRequest;
import com.jibo.aws.integration.aws.services.common.model.IdResponse;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.fragment.onboarding.ChangeEmailSentFragment;
import com.jibo.utils.Commons;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;

public class ChangeEmailFragment extends BaseFragment {
   public static final String a = LogUtils.a(ChangeEmailFragment.class);
   MenuItem b;
   private String c;
   private TextWatcher d = new TextWatcher(this) {
      final ChangeEmailFragment a;

      {
         this.a = var1;
      }

      public void afterTextChanged(Editable var1) {
      }

      public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
      }

      public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         this.a.getActivity().invalidateOptionsMenu();
         this.a.s();
      }
   };
   @BindView
   EditText email;
   @BindView
   TextView footer;
   @BindView
   TextView footerError;

   private boolean q() {
      boolean var1;
      if (!TextUtils.isEmpty(this.email.getText().toString()) && Commons.a.matcher(this.email.getText().toString()).matches()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private void r() {
      this.footer.setVisibility(8);
      this.footerError.setVisibility(0);
   }

   private void s() {
      this.footer.setVisibility(0);
      this.footerError.setVisibility(8);
   }

   public void a() {
      this.a(false);
      this.b.setEnabled(false);
      EntityData.a(this.getContext()).a().changeEmail(this.email.getText().toString(), this.c, new AsyncHandler<ChangeEmailRequest, IdResponse>(this) {
         final ChangeEmailFragment a;

         {
            this.a = var1;
         }

         public void a(ChangeEmailRequest var1, IdResponse var2) {
            this.a.a(new Runnable(this) {
               final <unrepresentable> a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  this.a.a.g();
                  this.a.a.b.setEnabled(true);
                  this.a.a.b(true);
               }
            });
         }

         @Override
         public void onError(Exception var1) {
            this.a.a(var1, "change email", false);
            if (!ErrorHelper.b((AmazonServiceException)var1) && !ErrorHelper.a((AmazonServiceException)var1)) {
               this.a.a(new Runnable(this, var1) {
                  final Exception a;
                  final <unrepresentable> b;

                  {
                     this.b = var1;
                     this.a = var2;
                  }

                  @Override
                  public void run() {
                     this.b.a.g();
                     this.b.a.b.setEnabled(true);
                     if (((AmazonServiceException)this.a).getErrorCode().equals("EMAIL_ALREADY_EXISTS")) {
                        this.b.a.b.setEnabled(false);
                        this.b.a.footerError.setText(2131755164);
                        this.b.a.r();
                     } else {
                        this.b.a.b(false);
                     }
                  }
               });
            }
         }
      });
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayShowTitleEnabled(true);
      var1.setDisplayShowCustomEnabled(false);
      this.n();
   }

   protected int b() {
      return 2131427427;
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      this.c = var1.getString("ARGS_PASSWORD");
   }

   protected void b(boolean var1) {
      SingleFragmentActivity.Builder var2 = new SingleFragmentActivity.Builder(this, ChangeEmailSentFragment.class.getName());
      var2.a("ARGS_EMAIL", this.email.getText().toString());
      var2.a("ARGS_PASSWORD", this.c);
      if (!var1) {
         var1 = true;
      } else {
         var1 = false;
      }

      var2.a("ARGS_IS_ERROR", var1);
      var2.a(999);
   }

   @Override
   protected String o() {
      return this.getString(2131756028);
   }

   @Override
   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var1 == 999) {
         this.getActivity().setResult(var2);
         this.getActivity().finish();
      }
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setHasOptionsMenu(true);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      var2.inflate(2131492870, var1);
      super.onCreateOptionsMenu(var1, var2);
      this.b = var1.findItem(2131296294);
      ImageUtils.a(this.getActivity(), var1);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(this.b(), var2, false);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (2131296294 == var1.getItemId()) {
         this.a();
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   @Override
   public void onPrepareOptionsMenu(Menu var1) {
      super.onPrepareOptionsMenu(var1);
      this.b.setEnabled(this.q());
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.email.addTextChangedListener(this.d);
   }
}
