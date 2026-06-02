package com.jibo.ui.fragment.wifi;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import butterknife.OnClick;
import butterknife.Optional;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.utils.LogUtils;

public abstract class WiFiBaseFragment extends BaseFragment {
   public static final String d = LogUtils.a(WiFiBaseFragment.class);
   static Bundle e = new Bundle();

   private void b(ActionBar var1) {
      var1.setBackgroundDrawable(new ColorDrawable(this.getResources().getColor(2131099771)));
      var1.setHomeAsUpIndicator(2131230814);
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
      var1.setHomeButtonEnabled(true);
      this.l();
      this.b(var1);
   }

   protected void b() {
      LayoutParams var1 = this.getActivity().getWindow().getAttributes();
      var1.screenBrightness = -1.0F;
      this.getActivity().getWindow().setAttributes(var1);
   }

   @OnClick
   @Optional
   public void onBtnHelpClick(View var1) {
      ((BaseActivity)this.getActivity()).c(WiFiHelpFragment.class, null);
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if (var1 != null) {
         e.putAll(var1);
      }

      this.setHasOptionsMenu(true);
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putAll(e);
   }
}
