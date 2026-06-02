package com.jibo.ui.fragment.invite;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Member;

public class EmailInviteInfoFragment extends BaseLoopInviteFragment {
   private EmailFragment.LaunchMode a;
   private Member r;
   @BindView
   TextView text;
   @BindView
   TextView title;

   @Override
   public void a() {
      String var1;
      if (this.n != null) {
         var1 = this.n.getFirstName() + " " + this.n.getLastName();
      } else {
         var1 = this.c.getFirstName() + " " + this.c.getLastName();
      }

      String var2;
      if (TextUtils.isEmpty(this.d)) {
         var2 = var1;
      } else {
         var2 = this.d;
      }

      this.title.setText(this.getString(2131755292, var1));
      Account.Gender var4;
      if (this.n == null) {
         var4 = this.c.getGender();
      } else {
         var4 = this.n.getGender();
      }

      String var3 = this.getString(2131755898);
      if (var4 == Account.Gender.female) {
         var1 = this.getString(2131755372);
      } else if (var4 == Account.Gender.male) {
         var1 = this.getString(2131755360);
      } else {
         var1 = var3;
      }

      this.text.setText(this.getString(2131755291, var2, var1));
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      this.k();
   }

   @Override
   public void b() {
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      if (var1.containsKey("ARG_MODE")) {
         this.a = EmailFragment.LaunchMode.values()[var1.getInt("ARG_MODE")];
      }

      if (var1.containsKey(Member.class.getSimpleName())) {
         this.r = (Member)var1.getParcelable(Member.class.getSimpleName());
      }
   }

   @OnClick
   public void dontGoToEMail(View var1) {
      if (this.a == EmailFragment.LaunchMode.add_email) {
         this.getActivity().finish();
      } else {
         this.c.setEmail(null);
         this.q();
      }
   }

   @OnClick
   public void goToEmail(View var1) {
      if (this.a == EmailFragment.LaunchMode.add_email) {
         Bundle var2 = new Bundle();
         var2.putInt("ARG_MODE", EmailFragment.LaunchMode.add_email.ordinal());
         var2.putParcelable(Member.class.getSimpleName(), this.r);
         this.a(NewEmailFragment.class, var2);
      } else {
         this.a(EmailFragment.class);
      }
   }

   @Override
   protected String o() {
      return this.getString(2131755383);
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427435, var2, false);
   }
}
