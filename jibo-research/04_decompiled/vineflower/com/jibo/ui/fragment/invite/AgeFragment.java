package com.jibo.ui.fragment.invite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import butterknife.BindView;
import com.jibo.utils.LogUtils;
import com.jibo.utils.UIUtils;

public class AgeFragment extends BaseLoopInviteFragment {
   public static final String a = LogUtils.a(AgeFragment.class);
   @BindView
   RadioButton mChild;
   @BindView
   RadioButton mTeenageOrAdult;

   @Override
   public void a() {
      this.mTeenageOrAdult.setText(UIUtils.a(this.getActivity(), this.getString(2131756073), this.getString(2131755057)));
      this.mChild.setText(UIUtils.a(this.getActivity(), this.getString(2131756030), this.getString(2131755058)));
      this.mTeenageOrAdult.setChecked(true);
   }

   @Override
   public void b() {
      this.b = this.mChild.isChecked();
      this.c.setBirthday(null);
      if (!this.b) {
         this.a(NameBirthdayGenderFragment.class);
      } else {
         this.a(SelectGuardianFragment.class);
      }
   }

   @Override
   protected String o() {
      return this.getString(2131756038);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      super.onCreateOptionsMenu(var1, var2);
      this.p.setEnabled(true);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427424, var2, false);
   }
}
