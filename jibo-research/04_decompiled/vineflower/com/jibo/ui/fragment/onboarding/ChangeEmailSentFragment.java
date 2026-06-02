package com.jibo.ui.fragment.onboarding;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.account.model.ChangeEmailRequest;
import com.jibo.aws.integration.aws.services.common.model.IdResponse;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.TabbedActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.fragment.dialog.DialogUtils;
import com.jibo.ui.fragment.dialog.EmailChangeFailedDialog;

public class ChangeEmailSentFragment extends BaseFragment implements DialogUtils.DialogFragmentWrapperClickListener {
   public static final String a = ChangeEmailSentFragment.class.getSimpleName();
   private String b;
   private boolean c = false;
   private boolean d = false;
   private String e;
   @BindView
   TextView text_instructions;

   private void a() {
      Bundle var2 = new Bundle();
      var2.putString("ARGS_EMAIL", this.b);
      EmailChangeFailedDialog var1 = new EmailChangeFailedDialog();
      var1.setArguments(var2);
      var1.setTargetFragment(this, 1);
      var1.show(this.getFragmentManager(), EmailChangeFailedDialog.class.getSimpleName());
   }

   @Override
   public void a(int var1, int var2, Object var3) {
      this.a(false);
      EntityData.a(this.getContext()).a().changeEmail(this.b, this.e, new AsyncHandler<ChangeEmailRequest, IdResponse>(this) {
         final ChangeEmailSentFragment a;

         {
            this.a = var1;
         }

         public void a(ChangeEmailRequest var1, IdResponse var2x) {
            this.a.a(new Runnable(this) {
               final <unrepresentable> a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  this.a.a.g();
               }
            });
         }

         @Override
         public void onError(Exception var1) {
            this.a.a(var1, "change email", false);
            this.a.a(new Runnable(this) {
               final <unrepresentable> a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  this.a.a.g();
                  this.a.a.a();
               }
            });
         }
      });
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      this.l();
      var1.setDisplayHomeAsUpEnabled(true);
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      this.b = var1.getString("ARGS_EMAIL");
      this.e = var1.getString("ARGS_PASSWORD");
      this.d = var1.getBoolean("ARGS_IS_ERROR", false);
   }

   @OnClick
   public void logout(View var1) {
      this.getActivity().setResult(TabbedActivity.c);
      this.getActivity().finish();
   }

   @Override
   protected String o() {
      return this.getString(2131755772);
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427434, var2, false);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.text_instructions.setText(Html.fromHtml(String.format(this.getString(2131755168), this.b)));
      if (this.d) {
         this.d = false;
         this.a();
      }
   }
}
