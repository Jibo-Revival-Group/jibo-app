package com.jibo.ui.fragment.settings;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.ui.fragment.BaseFragment;

public class RobotAboutFragment extends BaseFragment {
   public static final String a = RobotAboutFragment.class.getSimpleName();
   private Robot b;
   @BindView
   TextView osVersion;
   @BindView
   TextView ownerEmail;
   @BindView
   TextView ownerName;
   @BindView
   TextView serialName;

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
   }

   @Override
   protected String o() {
      return this.getString(2131756069);
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if (var1 != null) {
         this.b = (Robot)var1.getParcelable(Robot.class.getSimpleName());
      } else if (this.getArguments() != null) {
         this.b = (Robot)this.getArguments().getParcelable(Robot.class.getSimpleName());
      }
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427464, var2, false);
   }

   @Override
   public void onResume() {
      super.onResume();
      if (this.k == null) {
         this.getActivity().onBackPressed();
      }
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putParcelable(Robot.class.getSimpleName(), this.b);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      Member var3 = LoopHelper.getOwner(this.k);
      if (TextUtils.isEmpty(var3.getNickname())) {
         this.ownerName.setText(var3.getAccount().getFullName());
      } else {
         this.ownerName.setText(var3.getNickname());
      }

      this.ownerEmail.setText(var3.getAccount().getEmail());
      TextView var6 = this.osVersion;
      String var4;
      if (TextUtils.isEmpty(RobotHelper.getRobotOS(this.b))) {
         var4 = this.getString(2131755640);
      } else {
         var4 = RobotHelper.getRobotOS(this.b);
      }

      var6.setText(var4);
      TextView var7 = this.serialName;
      String var5;
      if (TextUtils.isEmpty(RobotHelper.getRobotSerialName(this.b))) {
         var5 = this.getString(2131755640);
      } else {
         var5 = RobotHelper.getRobotSerialName(this.b);
      }

      var7.setText(var5);
   }
}
