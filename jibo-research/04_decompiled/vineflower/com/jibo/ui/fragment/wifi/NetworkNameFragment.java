package com.jibo.ui.fragment.wifi;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.jibo.utils.Util;

public class NetworkNameFragment extends WiFiValidatedFragment {
   public static final String a = LogUtils.a(NetworkNameFragment.class);
   final TextWatcher b = new TextWatcher(this) {
      final NetworkNameFragment a;

      {
         this.a = var1;
      }

      public void afterTextChanged(Editable var1) {
         this.a.getActivity().invalidateOptionsMenu();
         this.a.r();
      }

      public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
      }

      public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
      }
   };
   @BindView
   EditText editSSID;
   @BindView
   TextView footer;

   private String q() {
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

   private void r() {
      StringBuilder var2 = new StringBuilder();
      String var1 = this.getString(2131755475);
      var2.append(this.getString(2131755476));
      var2.append(" ");
      var2.append(var1);
      var2.append(" ");
      var2.append(this.getString(2131755478));
      SpannableStringBuilder var3 = new SpannableStringBuilder(var2);
      if (this.q().length() >= 32) {
         var3.setSpan(
            new ForegroundColorSpan(this.getContext().getResources().getColor(2131099764)), var2.indexOf(var1), var2.indexOf(var1) + var1.length(), 18
         );
      }

      this.footer.setText(var3);
   }

   @Override
   protected void a() {
      e.putString("ARG_SSID", Util.a(this.q()));
      Bundle var1 = new Bundle();
      var1.putParcelable(Loop.class.getSimpleName(), this.k);
      ((BaseActivity)this.getActivity()).c(NetworkPwdFragment.class, var1);
   }

   @Override
   protected void a(MenuItem var1) {
      if (this.q().length() > 0) {
         var1.setEnabled(true);
      } else {
         var1.setEnabled(false);
      }

      FragmentActivity var3 = this.getActivity();
      int var2;
      if (var1.isEnabled()) {
         var2 = 2131099871;
      } else {
         var2 = 2131099701;
      }

      ImageUtils.a(var3, var1, var2);
   }

   @Override
   protected String o() {
      return this.getString(2131756051);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427485, var2, false);
   }

   @Override
   public void onPause() {
      super.onPause();
      this.editSSID.removeTextChangedListener(this.b);
   }

   @Override
   public void onResume() {
      super.onResume();
      this.editSSID.addTextChangedListener(this.b);
      this.editSSID.requestFocus();
      this.a(this.editSSID);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.r();
   }
}
