package com.jibo.ui.fragment.settings;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.SpannableStringBuilder;
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
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.ChangePasswordRequest;
import com.jibo.db.EntityData;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.utils.Commons;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.jibo.utils.UIUtils;

public class ChangePasswordFragment extends BaseFragment {
   public static final String a = LogUtils.a(ChangePasswordFragment.class);
   MenuItem b;
   private JiboAccountAsyncClient c;
   private String d;
   private TextWatcher e = new TextWatcher(this) {
      final ChangePasswordFragment a;

      {
         this.a = var1;
      }

      public void afterTextChanged(Editable var1) {
      }

      public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
      }

      public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         this.a.getActivity().invalidateOptionsMenu();
         this.a.b(this.a.b());
      }
   };
   @BindView
   TextView footer;
   @BindView
   EditText password;

   private void b(boolean var1) {
      String var2 = this.getString(2131755171);
      UIUtils.a(this.password.getText().toString(), this.footer);
      this.footer.setText(new SpannableStringBuilder(var2).append("\n\n").append(this.footer.getText()));
   }

   private boolean b() {
      boolean var1;
      if (!TextUtils.isEmpty(this.password.getText().toString()) && Commons.b.matcher(this.password.getText().toString()).matches()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void a() {
      this.a(false);
      this.b.setEnabled(false);
      this.c.changePassword(this.d, this.password.getText().toString(), new AsyncHandler<ChangePasswordRequest, Account>(this) {
         final ChangePasswordFragment a;

         {
            this.a = var1;
         }

         public void a(ChangePasswordRequest var1, Account var2) {
            this.a.a(new Runnable(this) {
               final <unrepresentable> a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  this.a.a.g();
                  this.a.a.b.setEnabled(true);
                  this.a.a.getActivity().finish();
               }
            });
         }

         @Override
         public void onError(Exception var1) {
            this.a.a(var1, "change password", false);
         }
      });
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayShowTitleEnabled(true);
      var1.setDisplayShowCustomEnabled(false);
      var1.setHomeAsUpIndicator(2131231362);
      this.n();
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      this.d = var1.getString("ARGS_OLD_PASSWORD");
   }

   @Override
   protected String o() {
      return this.getString(2131756029);
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setHasOptionsMenu(true);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      var2.inflate(2131492871, var1);
      super.onCreateOptionsMenu(var1, var2);
      this.b = var1.findItem(2131296304);
      ImageUtils.a(this.getActivity(), var1);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427428, var2, false);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (2131296304 == var1.getItemId()) {
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
      this.b.setEnabled(this.b());
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.password.addTextChangedListener(this.e);
      this.c = EntityData.a(this.getContext()).a();
      this.b(true);
   }
}
