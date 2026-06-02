package com.jibo.ui.fragment.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.fragment.settings.HolidaySettingsFragment;
import com.jibo.utils.LoopHolidaysAlarmReceiver;

public class HolidaysPopupFragment extends DialogFragment {
   private Loop a;

   public static void a(FragmentManager var0, Loop var1) {
      HolidaysPopupFragment var2 = new HolidaysPopupFragment();
      Bundle var3 = new Bundle();
      var3.putParcelable(Loop.class.getSimpleName(), var1);
      var2.setArguments(var3);
      var2.show(var0, HolidaysPopupFragment.class.getSimpleName());
   }

   @OnClick
   public void onBtnAddHolidaysClick() {
      new SingleFragmentActivity.Builder(this.getActivity(), HolidaySettingsFragment.class.getName()).a(Loop.class.getSimpleName(), this.a).a(1022);
      this.dismiss();
   }

   @OnClick
   public void onBtnCancelClick() {
      this.dismiss();
   }

   @Override
   public Dialog onCreateDialog(Bundle var1) {
      AppCompatDialog var2 = new AppCompatDialog(this.getActivity(), 16973833);
      View var3 = this.getActivity().getLayoutInflater().inflate(2131427404, null);
      ButterKnife.a(this, var3);
      this.setCancelable(true);
      var2.setContentView(var3);
      var2.setCancelable(true);
      if (var1 != null) {
         this.a = (Loop)var1.getParcelable(Loop.class.getSimpleName());
      } else if (this.getArguments() != null) {
         this.a = (Loop)this.getArguments().getParcelable(Loop.class.getSimpleName());
      }

      LoopHolidaysAlarmReceiver.b(this.getActivity(), this.a);
      return var2;
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      if (this.a != null) {
         var1.putParcelable(Loop.class.getSimpleName(), this.a);
      }
   }
}
