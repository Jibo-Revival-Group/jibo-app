package com.jibo.ui.fragment.jibos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.activity.WifiActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.fragment.account.AccountSettingsFragment;
import com.jibo.ui.fragment.dialog.DialogUtils;
import com.jibo.ui.helpers.skills.SkillsJsonParser;
import com.jibo.utils.ImageUtils;

public class NoLoopsFragment extends BaseFragment {
   @BindView
   View icon;

   @Override
   protected String o() {
      return this.getString(2131756082);
   }

   @OnClick
   public void onConnectWifi(View var1) {
      WifiActivity.a(this.getActivity(), null);
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setHasOptionsMenu(true);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      super.onCreateOptionsMenu(var1, var2);
      var2.inflate(2131492879, var1);
      ImageUtils.a(this.getActivity(), var1);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427577, var2, false);
   }

   @OnClick
   public void onInviteInfo(View var1) {
      DialogUtils.d(this, 1, this.getString(2131755546), String.format(this.getString(2131755545), EntityData.a(this.getActivity()).i().getEmail()));
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (var1.getItemId() == 2131296306) {
         SkillsJsonParser.getInstance().clearSkills();
         new SingleFragmentActivity.Builder(this.getActivity(), AccountSettingsFragment.class.getName()).a(1001);
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      float var3 = this.getResources().getConfiguration().fontScale;
      LayoutParams var5 = (LayoutParams)this.icon.getLayoutParams();
      int var4 = var5.topMargin;
      var5.setMargins(var5.leftMargin, (int)(var4 / var3), var5.rightMargin, var5.bottomMargin);
   }
}
