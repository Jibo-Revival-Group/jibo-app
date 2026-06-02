package com.jibo.ui.fragment.invite;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.utils.SharedPreferencesUtil;

public class CongratsFragment extends BaseLoopInviteFragment {
   @BindView
   TextView text;
   @BindView
   TextView title;
   @BindView
   VideoView video;

   private void r() {
      this.getActivity().setResult(-1);
      this.getActivity().finish();
   }

   private int s() {
      int var1;
      if (this.c.getGender().equals(Account.Gender.male)) {
         var1 = 2131755372;
      } else if (this.c.getGender().equals(Account.Gender.female)) {
         var1 = 2131755360;
      } else {
         var1 = 2131755898;
      }

      return var1;
   }

   @Override
   public void a() {
      String var1;
      if (TextUtils.isEmpty(this.d)) {
         var1 = this.c.getFirstName();
      } else {
         var1 = this.d;
      }

      this.title.setText(this.getString(2131755379, var1));
      this.text.setText(this.getString(2131755378, var1, this.getString(this.s())));
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
   protected String o() {
      return this.getString(2131756082);
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427442, var2, false);
   }

   @OnClick
   public void onDontShowAgain(View var1) {
      SharedPreferencesUtil.l(this.getContext());
      this.r();
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.c().postDelayed(new Runnable(this) {
         final CongratsFragment a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            String var1x = "android.resource://" + this.a.getContext().getPackageName() + "/" + 2131689473;
            this.a.video.setVideoURI(Uri.parse(var1x));
            this.a.video.start();
         }
      }, 800L);
   }

   @OnClick
   public void onViewMyLoop(View var1) {
      this.r();
   }
}
