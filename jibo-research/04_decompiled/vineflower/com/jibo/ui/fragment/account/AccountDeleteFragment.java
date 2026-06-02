package com.jibo.ui.fragment.account;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.JiboAnalytics;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.view.proxima.ProximaHelper;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.Util;

public class AccountDeleteFragment extends BaseFragment {
   public static final String a = AccountDeleteFragment.class.getSimpleName();
   boolean b = false;
   @BindView
   View btnDelete;
   @BindView
   TextView footer;
   @BindView
   RadioGroup mLeaveReasonGroup;
   @BindView
   RadioButton reason1;
   @BindView
   RadioButton reason2;
   @BindView
   RadioButton reason3;
   @BindView
   RadioButton reason4;

   private void a() {
      byte var1 = 0;
      String var4 = this.getString(2131755244, this.getString(2131755233));
      int var2 = var4.indexOf(this.getString(2131755233));
      SpannableStringBuilder var5 = new SpannableStringBuilder(var4);
      int var3 = this.getString(2131755233).length();
      var5.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.c), var2, var2 + var3, 33);
      var5.setSpan(new ForegroundColorSpan(ImageUtils.b(this.getActivity(), 2131099771)), var2, var2 + var3, 33);
      var5.setSpan(new ClickableSpan(this) {
         final AccountDeleteFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            Intent var2x = new Intent("android.intent.action.VIEW", Uri.parse(this.a.getString(2131755752)));
            this.a.startActivity(var2x);
         }

         public void updateDrawState(TextPaint var1) {
            var1.setUnderlineText(false);
         }
      }, var2, var3 + var2, 33);
      this.footer.setText(var5);
      this.footer.setMovementMethod(LinkMovementMethod.getInstance());
      this.mLeaveReasonGroup.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
         final AccountDeleteFragment a;

         {
            this.a = var1;
         }

         public void onCheckedChanged(RadioGroup var1, int var2x) {
            this.a.getActivity().invalidateOptionsMenu();
            this.a.btnDelete.setVisibility(0);
         }
      });
      View var6 = this.btnDelete;
      if (this.mLeaveReasonGroup.getCheckedRadioButtonId() == -1) {
         var1 = 4;
      }

      var6.setVisibility(var1);
      this.reason1.setTag(JiboAnalytics.aD);
      this.reason2.setTag(JiboAnalytics.aE);
      this.reason3.setTag(JiboAnalytics.aF);
      this.reason4.setTag(JiboAnalytics.aG);
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
   }

   @Override
   protected String o() {
      return this.getString(2131756034);
   }

   @OnClick
   public void onBtnDelete() {
      Bundle var1 = new Bundle();
      if (this.mLeaveReasonGroup.getCheckedRadioButtonId() != -1) {
         var1.putString(JiboAnalytics.ak, (String)this.getView().findViewById(this.mLeaveReasonGroup.getCheckedRadioButtonId()).getTag());
      }

      var1.putBoolean("ARG_IS_OWNER_AND_SUSPENDED", this.b);
      ((BaseActivity)this.getActivity()).a(AccountDeleteConfirmFragment.class, var1);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      boolean var3 = false;
      super.onCreateOptionsMenu(var1, var2);
      var2.inflate(2131492872, var1);
      MenuItem var4 = var1.getItem(0);
      if (this.mLeaveReasonGroup.getCheckedRadioButtonId() == -1) {
         var3 = true;
      }

      var4.setVisible(var3);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.setHasOptionsMenu(true);
      this.l();
      return var1.inflate(2131427419, var2, false);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (var1.getItemId() == 2131296308) {
         this.onBtnDelete();
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      if (this.getArguments() != null && this.getArguments().containsKey("ARG_IS_OWNER_AND_SUSPENDED")) {
         this.b = this.getArguments().getBoolean("ARG_IS_OWNER_AND_SUSPENDED");
      }

      this.a();
   }
}
