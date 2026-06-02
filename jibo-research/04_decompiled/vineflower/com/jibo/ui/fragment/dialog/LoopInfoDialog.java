package com.jibo.ui.fragment.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.db.EntityData;
import com.jibo.utils.SharedPreferencesUtil;

public class LoopInfoDialog extends BaseDialogFragment {
   private Loop d;
   @BindView
   TextView peopleCountMessage;
   @BindView
   TextView text;

   @OnClick
   public void okayClicked(View var1) {
      this.dismiss();
   }

   @Override
   public Dialog onCreateDialog(Bundle var1) {
      AppCompatDialog var3 = new AppCompatDialog(this.getActivity(), 16974132);
      View var4 = this.getActivity().getLayoutInflater().inflate(2131427406, null);
      ButterKnife.a(this, var4);
      this.d = SharedPreferencesUtil.f(this.getContext());
      if (LoopHelper.isOwner(this.d, EntityData.a(this.getContext()).i().getId())) {
         int var2 = LoopHelper.getActiveMembersCount(this.d);
         if (var2 >= 16) {
            this.peopleCountMessage.setText(this.getString(2131755439));
         } else {
            this.peopleCountMessage.setText(String.format(this.getString(2131755500), String.valueOf(16 - var2)));
         }
      } else {
         this.text.setText(2131755502);
         this.peopleCountMessage.setVisibility(8);
      }

      var3.setContentView(var4);
      var3.setCancelable(true);
      return var3;
   }
}
