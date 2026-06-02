package com.jibo.ui.fragment.wifi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.fragment.invite.NameBirthdayGenderFragment;
import com.jibo.ui.view.proxima.CustomFontButton;
import com.jibo.utils.LogUtils;

public class InviteLoopMembersFragment extends WiFiBaseFragment {
   public static final String a = LogUtils.a(InviteLoopMembersFragment.class);
   private Loop b = null;
   @BindView
   CustomFontButton btnInvitePeople;
   @BindView
   ImageView closeButton;

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      this.k();
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      this.b = (Loop)var1.getParcelable(Loop.class.getSimpleName());
   }

   @OnClick
   public void btnInvitePeople(View var1) {
      if (PermissionChecker.a(this.getActivity(), "android.permission.READ_CONTACTS") == 0) {
         SingleFragmentActivity.Builder var2 = new SingleFragmentActivity.Builder(this, NameBirthdayGenderFragment.class.getName());
         var2.a(Loop.class.getSimpleName(), this.b);
         var2.a(1005);
      } else {
         this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 96);
      }
   }

   @Override
   protected String o() {
      return "";
   }

   @Override
   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var1 == 1005) {
         var3 = new Intent();
         var3.putExtra(Loop.class.getSimpleName(), this.b);
         var3.putExtra("ARG_TAB_SELECTED", 0);
         this.getActivity().setResult(-1, var3);
         this.getActivity().finish();
      }
   }

   @OnClick
   public void onCloseClick(View var1) {
      this.getActivity().onBackPressed();
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427482, var2, false);
   }

   @Override
   public void onRequestPermissionsResult(int var1, String[] var2, int[] var3) {
      if (var1 == 96) {
         SingleFragmentActivity.Builder var4 = new SingleFragmentActivity.Builder(this, NameBirthdayGenderFragment.class.getName());
         var4.a(Loop.class.getSimpleName(), this.b);
         var4.a(1005);
      }
   }

   @Override
   public void onResume() {
      super.onResume();
      if (this.b == null) {
         this.getActivity().finish();
      }
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putParcelable(Loop.class.getSimpleName(), this.b);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.closeButton.setImageResource(2131230811);
   }
}
