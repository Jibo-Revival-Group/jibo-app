package com.jibo.ui.fragment.wifi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.jibo.utils.Util;

public class WiFiError1Fragment extends WiFiHelpAbstractFragment {
   public static final String a = LogUtils.a(WiFiError1Fragment.class);
   final TextWatcher b = new TextWatcher(this) {
      final WiFiError1Fragment a;

      {
         this.a = var1;
      }

      public void afterTextChanged(Editable var1) {
         this.a.r();
      }

      public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
      }

      public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
      }
   };
   @BindView
   TextView btnTryAgain;
   final TextWatcher c = new TextWatcher(this) {
      final WiFiError1Fragment a;

      {
         this.a = var1;
      }

      public void afterTextChanged(Editable var1) {
         this.a.r();
      }

      public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
      }

      public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
      }
   };
   @BindView
   EditText editPassword;
   @BindView
   EditText editSSID;
   @BindView
   TextView txtPasswordHint;

   private String a() {
      String var2 = "";
      String var1 = var2;

      try {
         if (this.editSSID != null) {
            var1 = this.editSSID.getText().toString().trim();
         }
      } catch (Exception var3) {
         var1 = var2;
      }

      return var1;
   }

   private String q() {
      String var2 = "";
      String var1 = var2;

      try {
         if (this.editPassword != null) {
            var1 = this.editPassword.getText().toString().trim();
         }
      } catch (Exception var3) {
         var1 = var2;
      }

      return var1;
   }

   private void r() {
      StringBuilder var3 = new StringBuilder();
      if (Util.a(this.a()).isEmpty()) {
         var3.append(this.getString(2131755315)).append("\n");
      }

      if (!this.q().isEmpty() && this.q().length() < 8) {
         var3.append(this.getString(2131755311)).append("\n");
      }

      boolean var2;
      if (var3.toString().length() == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      TextView var4 = this.txtPasswordHint;
      FragmentActivity var5 = this.getActivity();
      int var1;
      if (!var2) {
         var1 = 2131099764;
      } else {
         var1 = 2131099846;
      }

      var4.setTextColor(ImageUtils.b(var5, var1));
      var4 = this.txtPasswordHint;
      String var6;
      if (!var2) {
         var6 = var3.toString();
      } else {
         var6 = this.getString(2131755477);
      }

      var4.setText(var6);
      EditText var9 = this.editPassword;
      String var7;
      if (Util.a(this.a()).length() > 0) {
         var7 = Util.a(this.a()) + this.getString(2131755369);
      } else {
         var7 = this.getString(2131755370);
      }

      var9.setHint(var7);
      this.btnTryAgain.setEnabled(var2);
   }

   @OnClick
   public void btnSupportClick(View var1) {
      this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.getString(2131755748))));
   }

   @OnClick
   public void btnTryAgainClick(View var1) {
      this.e();
      e.putString("ARG_SSID", Util.a(this.a()));
      e.putString("ARG_PASSWORD", this.q());
      this.getActivity().getSupportFragmentManager().a(WiFiQRCodeFragment.class.getSimpleName(), 0);
   }

   @Override
   protected String o() {
      return this.getString(2131756076);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427479, var2, false);
   }

   @Override
   public void onPause() {
      super.onPause();
      this.editSSID.removeTextChangedListener(this.b);
      this.editPassword.removeTextChangedListener(this.c);
   }

   @Override
   public void onResume() {
      super.onResume();
      this.editSSID.addTextChangedListener(this.b);
      this.editPassword.addTextChangedListener(this.c);
      this.r();
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      if (var2 == null) {
         this.editSSID.setText(e.getString("ARG_SSID"));
         this.editPassword.setText(e.getString("ARG_PASSWORD"));
      }
   }
}
