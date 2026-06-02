package com.jibo.ui.fragment.onboarding;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.crashlytics.android.Crashlytics;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.OnBoardingActivity;
import com.jibo.ui.view.proxima.ProximaHelper;
import com.jibo.utils.UIUtils;
import com.jibo.utils.Util;

public class SignupFragment extends SocialMediaBaseFragment {
   public static final String a = SignupFragment.class.getSimpleName();
   private String d;
   @BindView
   TextView footerText;
   @BindView
   CheckBox termsCheckbox;
   @BindView
   TextView validationFooterText;

   private void a(boolean var1, boolean var2) {
      if (var2 || var1) {
         String var3;
         if (var1) {
            var3 = this.getString(2131755297);
         } else {
            var3 = this.getString(2131755289);
         }

         SpannableStringBuilder var4 = new SpannableStringBuilder(var3);
         var4.setSpan(new ForegroundColorSpan(this.getResources().getColor(2131099764)), 0, var3.length(), 33);
         this.validationFooterText.setText(var4);
      }
   }

   private boolean a(String var1) {
      boolean var2;
      if (var1.length() > 80) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private boolean b(String var1) {
      boolean var2 = false;
      String[] var3 = var1.split("@");
      if (var3.length > 0 && var3[0].length() > 64) {
         var2 = true;
      }

      return var2;
   }

   private void q() {
      this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.getString(2131755604))));
   }

   private void r() {
      this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.getString(2131755758))));
   }

   @Override
   protected void a() {
      try {
         this.b.setEnabled(false);
         this.e();
         String var1 = this.emailEditText.getText().toString();
         String var2 = this.passwordEditText.getText().toString();
         this.f();
         EntityData.a(this.getActivity()).a().create(var1, var2, this.d, this.c);
      } catch (Exception var3) {
         this.g();
         this.b.setEnabled(true);
         ((OnBoardingActivity)this.getActivity()).l();
         Crashlytics.a(var3);
      }
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
      this.l();
   }

   @Override
   protected void b() {
      super.b();
      if (this.b != null) {
         MenuItem var2 = this.b;
         boolean var1;
         if (this.b.isEnabled() && this.termsCheckbox.isChecked()) {
            var1 = true;
         } else {
            var1 = false;
         }

         var2.setEnabled(var1);
      }

      String var4 = this.passwordEditText.getText().toString();
      String var3 = this.emailEditText.getText().toString();
      UIUtils.a(var4, this.validationFooterText);
      this.a(this.a(var3), this.b(var3));
   }

   @Override
   protected String o() {
      return this.getString(2131756072);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427430, var2, false);
   }

   @OnClick
   public void onTermsCheckboxClick() {
      this.b();
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      if (var2 == null && this.getArguments() != null && !TextUtils.isEmpty(this.getArguments().getString("email"))) {
         this.emailEditText.setText(this.getArguments().getString("email"));
      }

      String var6;
      if (this.getArguments() != null && !TextUtils.isEmpty(this.getArguments().getString("code"))) {
         var6 = this.getArguments().getString("code");
      } else {
         var6 = null;
      }

      this.d = var6;
      String var8 = this.getString(2131755757);
      String var7 = this.getString(2131755603);
      String var5 = this.getString(2131755225, var8, var7);
      int var3 = var5.indexOf(var8);
      int var4 = var5.indexOf(var7);
      SpannableStringBuilder var9 = new SpannableStringBuilder(var5);
      var9.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.c), var3, var8.length() + var3, 33);
      var9.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.c), var4, var7.length() + var4, 33);
      var9.setSpan(new ForegroundColorSpan(this.getResources().getColor(2131099771)), var4, var7.length() + var4, 33);
      var9.setSpan(new ForegroundColorSpan(this.getResources().getColor(2131099771)), var3, var8.length() + var3, 33);
      var9.setSpan(new ClickableSpan(this) {
         final SignupFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            this.a.q();
         }

         public void updateDrawState(TextPaint var1) {
            var1.setUnderlineText(false);
         }
      }, var4, var7.length() + var4, 33);
      var9.setSpan(new ClickableSpan(this) {
         final SignupFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            this.a.r();
         }

         public void updateDrawState(TextPaint var1) {
            var1.setUnderlineText(false);
         }
      }, var3, var8.length() + var3, 33);
      this.footerText.setText(var9);
      this.footerText.setMovementMethod(LinkMovementMethod.getInstance());
   }
}
