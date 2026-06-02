package com.jibo.ui.fragment.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.jibo.aws.integration.helpers.RobotHelper;

public class LocationSetDialog extends DialogFragment {
   Unbinder a;
   @BindView
   TextView location;
   @BindView
   TextView timezone;

   @OnClick
   public void onBtnSetClicked(View var1) {
      this.dismiss();
   }

   @Override
   public Dialog onCreateDialog(Bundle var1) {
      TextView var3 = (TextView)LayoutInflater.from(this.getActivity()).inflate(2131427417, null);
      var3.setText(2131755345);
      View var2 = LayoutInflater.from(this.getActivity()).inflate(2131427405, null);
      AlertDialog.Builder var4 = new AlertDialog.Builder(this.getActivity()).a(var3).b(var2);
      this.a = ButterKnife.a(this, var2);
      String var8;
      if (var1 != null) {
         var8 = var1.getString("ARGS_LOCATION");
      } else {
         var8 = this.getArguments().getString("ARGS_LOCATION");
      }

      String var6;
      if (var1 != null) {
         var6 = var1.getString("ARGS_TIMEZONE");
      } else {
         var6 = this.getArguments().getString("ARGS_TIMEZONE");
      }

      TextView var5 = this.location;
      String var9 = var8;
      if (TextUtils.isEmpty(var8)) {
         var9 = this.getString(2131755640);
      }

      var5.setText(var9);
      String var7;
      if (var6 != null) {
         var7 = var6.replace("\\/", "/");
      } else {
         var7 = "";
      }

      this.timezone.setText(RobotHelper.getTimeZoneFriendly(var7, this.getString(2131755802)));
      return var4.b();
   }

   @Override
   public void onDestroyView() {
      super.onDestroyView();
      this.a.unbind();
   }
}
