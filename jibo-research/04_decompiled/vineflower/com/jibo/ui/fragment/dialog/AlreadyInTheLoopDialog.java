package com.jibo.ui.fragment.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.fragment.profile.ProfileFragment;

public class AlreadyInTheLoopDialog extends DialogFragment {
   Unbinder a;
   private Loop b;
   private Account c;
   @BindView
   TextView textView;

   @OnClick
   public void onAdultClicked(View var1) {
      this.dismiss();
   }

   @Override
   public Dialog onCreateDialog(Bundle var1) {
      TextView var3 = (TextView)LayoutInflater.from(this.getActivity()).inflate(2131427417, null);
      var3.setText(2131755295);
      View var2 = LayoutInflater.from(this.getActivity()).inflate(2131427396, null);
      AlertDialog.Builder var7 = new AlertDialog.Builder(this.getActivity()).a(var3).b(var2);
      this.a = ButterKnife.a(this, var2);
      Parcelable var6;
      if (var1 != null) {
         var6 = var1.getParcelable(Loop.class.getSimpleName());
      } else {
         var6 = this.getArguments().getParcelable(Loop.class.getSimpleName());
      }

      this.b = (Loop)var6;
      Parcelable var4;
      if (var1 != null) {
         var4 = var1.getParcelable(Account.class.getSimpleName());
      } else {
         var4 = this.getArguments().getParcelable(Account.class.getSimpleName());
      }

      this.c = (Account)var4;
      if (this.c != null) {
         SpannableStringBuilder var5 = new SpannableStringBuilder(this.getString(2131755284, this.c.getFullName(), this.c.getEmail()));
         var5.setSpan(new StyleSpan(1), 0, this.c.getFullName().length(), 33);
         this.textView.setText(var5);
      }

      return var7.b();
   }

   @Override
   public void onDestroyView() {
      super.onDestroyView();
      this.a.unbind();
   }

   @OnClick
   public void onViewProfileClicked(View var1) {
      Member var5 = null;

      for (Member var2 : this.b.getMembers()) {
         if (var2.getAccount() != null) {
            String var4 = var2.getAccount().getEmail();
            if (var4 != null && var4.equals(this.c.getEmail())) {
               var5 = var2;
            }
         }
      }

      if (var5 != null) {
         SingleFragmentActivity.Builder var6 = new SingleFragmentActivity.Builder(this.getActivity(), ProfileFragment.class.getName());
         var6.a(Member.class.getSimpleName(), var5).a(Loop.class.getSimpleName(), this.b).a("ARGS_ALLOW_EDIT", false);
         var6.a(1007);
         this.dismiss();
      }
   }
}
