package com.jibo.ui.fragment.invite;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.db.EntityData;
import com.jibo.ui.fragment.jibos.adapter.LoopMembersListAdapter;
import com.jibo.ui.helpers.Items;
import java.util.ArrayList;
import java.util.List;

public class LoopMembersFragment extends BaseLoopInviteFragment {
   private List<Items.Item> a = new ArrayList<>();
   @BindView
   RecyclerView list;
   private LoopMembersListAdapter r;

   @Override
   public void a() {
      Account var1 = EntityData.a(this.getActivity()).i();
      Member var2 = LoopHelper.getMemberForAccount(this.k, var1);
      this.a.clear();

      for (var2 : LoopHelper.sortMembers(this.k, var2)) {
         this.a.add(new Items.MemberItem(this.k, var2));
      }

      this.r = new LoopMembersListAdapter(this.a, this.k, var1);
      this.list.setHasFixedSize(true);
      this.list.setItemAnimator(new DefaultItemAnimator());
      this.list.setLayoutManager(new LinearLayoutManager(this.getActivity(), 1, false));
      this.list.addItemDecoration(new LoopMembersListAdapter.SpacesItemDecoration(this.getActivity(), 2131165263, 2131165263, 2131165366));
      this.list.setAdapter(this.r);
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setHomeAsUpIndicator(2131231362);
   }

   @Override
   public void b() {
   }

   @Override
   public String o() {
      return this.getString(2131756081);
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setHasOptionsMenu(false);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427459, var2, false);
   }
}
