package com.jibo.ui.fragment.wifi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.ui.activity.GuidedExperienceActivity;
import com.jibo.ui.activity.WifiActivity;
import com.jibo.ui.view.proxima.CustomFontButton;
import com.jibo.utils.LogUtils;

public class WiFiSuccessFragment extends WiFiBaseFragment {
   public static final String a = LogUtils.a(WiFiSuccessFragment.class);
   private WifiActivity.Mode b;
   @BindView
   CustomFontButton btnContinue;
   @BindView
   ImageView jiboImage;
   @BindView
   TextView txtInfo;
   @BindView
   TextView txtTitle;

   @Override
   protected void a(ActionBar var1) {
   }

   @Override
   public boolean h() {
      if (this.b == WifiActivity.Mode.INIT) {
         Intent var1 = new Intent();
         var1.putExtra(Loop.class.getSimpleName(), this.k);
         var1.putExtra("ARG_TAB_SELECTED", 0);
         this.getActivity().setResult(-1, var1);
      }

      this.getActivity().finish();
      return true;
   }

   @Override
   protected String o() {
      return "";
   }

   @OnClick
   public void onBtnContinueClick(View var1) {
      if (this.b != WifiActivity.Mode.INIT) {
         this.h();
      } else {
         Intent var2 = new Intent();
         var2.putExtra(Loop.class.getSimpleName(), this.k);
         var2.setClass(this.getContext(), GuidedExperienceActivity.class);
         this.getActivity().finish();
         this.getActivity().startActivity(var2);
      }
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.k();
      WifiActivity.Mode var4;
      if (this.getActivity() instanceof WifiActivity) {
         var4 = ((WifiActivity)this.getActivity()).t();
      } else {
         var4 = WifiActivity.Mode.INIT;
      }

      this.b = var4;
      return var1.inflate(2131427491, var2, false);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      switch (<unrepresentable>.a[this.b.ordinal()]) {
         case 1:
            this.txtTitle.setText(2131755885);
            this.txtInfo.setText(2131755882);
            this.jiboImage.setImageResource(2131231092);
            this.btnContinue.setText(2131755879);
            break;
         case 2:
            this.txtTitle.setText(2131755883);
            this.txtInfo.setText(2131755880);
            this.jiboImage.setImageResource(2131230980);
            this.btnContinue.setText(2131755877);
            break;
         case 3:
            this.txtTitle.setText(2131755884);
            this.txtInfo.setText(2131755881);
            this.jiboImage.setImageResource(2131231092);
            this.btnContinue.setText(2131755878);
      }
   }
}
