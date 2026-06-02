package com.jibo.ui.fragment.invite;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import butterknife.BindView;
import com.jibo.JiboAnalytics;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.fragment.dialog.DialogUtils;
import com.jibo.ui.fragment.jibos.adapter.LoopMembersListAdapter;
import com.jibo.ui.helpers.Items;
import com.jibo.utils.UIUtils;
import java.util.ArrayList;
import java.util.List;

public class SelectGuardianFragment extends BaseLoopInviteFragment implements DialogUtils.DialogFragmentWrapperClickListener {
   private List<Items.Item> a = new ArrayList<>();
   @BindView
   RecyclerView list;
   private LoopMembersListAdapter r;
   private boolean s = false;
   private OnClickListener t = new OnClickListener(this) {
      final SelectGuardianFragment a;

      {
         this.a = var1;
      }

      public void onClick(View var1) {
         Items.MemberItem var2 = (Items.MemberItem)var1.getTag();
         if (var2.b().getAccount() != null) {
            if (!TextUtils.isEmpty(var2.b().getAccount().getEmail()) && var2.b().getStatus() == Member.InvitationStatus.accepted) {
               this.a.m = var2.b();
               this.a.o = true;
               this.a.a(LegalGuardianFragment.class);
            } else {
               this.a.m = var2.b();
               DialogUtils.a(
                  this.a,
                  this.a.getFragmentManager(),
                  119,
                  this.a.getString(2131755267),
                  this.a.getString(2131755259, this.a.m.getAccount().getFirstName()),
                  this.a.getString(2131755081),
                  this.a.getString(17039360)
               );
            }
         }
      }
   };
   private OnClickListener u = new OnClickListener(this) {
      final SelectGuardianFragment a;

      {
         this.a = var1;
      }

      public void onClick(View var1) {
         JiboAnalytics.i(this.a.getActivity());
         Intent var2 = new Intent("android.intent.action.VIEW", Uri.parse("https://www.consumer.ftc.gov/articles/0031-protecting-your-childs-privacy-online"));
         if (var2.resolveActivity(this.a.getActivity().getPackageManager()) != null) {
            this.a.getActivity().startActivity(var2);
         } else {
            UIUtils.a(this.a.list, this.a.getString(2131755554));
         }
      }
   };

   @Override
   public void a() {
      Account var3 = EntityData.a(this.getActivity()).i();
      Member var4 = LoopHelper.getMemberForAccount(this.k, var3);
      boolean var2 = LoopHelper.isOwner(this.k, var3.getId());
      this.a.clear();
      this.a.add(new Items.SubheaderItem(2131755351));

      for (Member var5 : LoopHelper.sortMembers(this.k, var4)) {
         if (DateTimeUtils.isAdult(var5.getAccount().getBirthday())
            && (var5.getStatus() == Member.InvitationStatus.accepted || TextUtils.isEmpty(var5.getAccount().getEmail()))) {
            this.a.add(new Items.MemberItem(this.t, this.k, var5));
         }
      }

      int var1 = LoopHelper.getActiveMembersCount(this.k);
      if (var2 && var1 < 16) {
         this.a.add(new Items.SimpleItem(Items.ItemType.invite, new OnClickListener(this) {
            final SelectGuardianFragment a;

            {
               this.a = var1;
            }

            public void onClick(View var1) {
               this.a.b = false;
               this.a.o = true;
               this.a.c = new Account();
               this.a.d = null;
               this.a.a(NameBirthdayGenderFragment.class);
            }
         }, 2131755796));
      }

      this.a.add(new Items.FooterItem(this.getString(2131755506)));
      this.a.add(new Items.SimpleItem(Items.ItemType.text_button, this.u, 2131755250));
      this.r = new LoopMembersListAdapter(this.a, this.k, var3);
      this.list.setHasFixedSize(true);
      this.list.setItemAnimator(new DefaultItemAnimator());
      this.list.setLayoutManager(new LinearLayoutManager(this.getActivity(), 1, false));
      this.list.addItemDecoration(new LoopMembersListAdapter.SpacesItemDecoration(this.getActivity(), -1, 2131165263, 2131165366));
      this.list.setAdapter(this.r);
   }

   @Override
   public void a(int var1, int var2, Object var3) {
      super.a(var1, var2, var3);
      if (var1 == 119 && var2 == -1) {
         this.b = false;
         var3 = new Bundle();
         var3.putParcelable(Loop.class.getSimpleName(), this.k);
         var3.putParcelable(Account.class.getSimpleName(), EntityData.a(this.getActivity()).a(this.m.getAccountId()));
         var3.putString("ARG_NICKNAME", this.m.getNickname());
         var3.putParcelable(Member.class.getSimpleName(), this.m);
         var3.putBoolean("ARG_IS_PARENT", true);
         var3.putInt("ARG_MODE", EmailFragment.LaunchMode.set_email.ordinal());
         ((BaseActivity)this.getActivity()).c(EmailFragment.class, var3);
      }
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setHomeAsUpIndicator(2131230814);
      var1.setDisplayShowTitleEnabled(true);
      var1.setDisplayShowCustomEnabled(false);
   }

   @Override
   public void b() {
   }

   @Override
   public String o() {
      return this.getString(2131756071);
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if (var1 != null) {
         this.s = var1.getBoolean("ARG_DIALOGSHOWN", false);
      }

      this.setHasOptionsMenu(false);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427459, var2, false);
   }

   @Override
   public void onResume() {
      super.onResume();
      if (!this.s) {
         this.s = true;
         DialogUtils.d(this, 103, this.getString(2131755268), this.getString(2131755260));
      }
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putBoolean("ARG_DIALOGSHOWN", this.s);
   }
}
