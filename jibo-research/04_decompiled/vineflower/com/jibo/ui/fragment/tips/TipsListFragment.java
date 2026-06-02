package com.jibo.ui.fragment.tips;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import butterknife.BindView;
import com.jibo.JiboAnalytics;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.TipsActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.utils.Lists;
import com.jibo.utils.SharedPreferencesUtil;
import java.util.List;

public class TipsListFragment extends BaseFragment {
   public static final List<String> a = Lists.a("TAG_TIP4", "TAG_TIP0", "TAG_TIP1", "TAG_TIP2", "TAG_TIP3");
   private OnClickListener b = new OnClickListener(this) {
      final TipsListFragment a;

      {
         this.a = var1;
      }

      public void onClick(View var1) {
         switch ((String)var1.getTag()) {
            case "TAG_TIP0":
               JiboAnalytics.f(this.a.getActivity(), JiboAnalytics.aK);
               break;
            case "TAG_TIP1":
               JiboAnalytics.f(this.a.getActivity(), JiboAnalytics.aL);
               break;
            case "TAG_TIP2":
               JiboAnalytics.f(this.a.getActivity(), JiboAnalytics.aM);
               break;
            case "TAG_TIP3":
               JiboAnalytics.f(this.a.getActivity(), JiboAnalytics.aN);
               break;
            case "TAG_TIP4":
               JiboAnalytics.f(this.a.getActivity(), JiboAnalytics.aO);
               break;
            case "TAG_TIP5":
               JiboAnalytics.f(this.a.getActivity(), JiboAnalytics.aP);
         }

         Intent var3 = new Intent();
         var3.setClass(this.a.getContext(), TipsActivity.class);
         String var4;
         var3.putExtra("ARGS_TAG", var4);
         this.a.startActivity(var3);
      }
   };
   @BindView
   View tip0;
   @BindView
   View tip1;
   @BindView
   View tip2;
   @BindView
   View tip3;
   @BindView
   View tip4;
   @BindView
   View tip5;

   @Override
   public String o() {
      return this.getString(2131756074);
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setHasOptionsMenu(true);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      var2.inflate(2131492873, var1);
      super.onCreateOptionsMenu(var1, var2);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427476, var2, false);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (2131296309 == var1.getItemId()) {
         this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.getString(2131755752))));
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      Account var3 = EntityData.a(this.getActivity()).i();
      this.k = SharedPreferencesUtil.f(this.getActivity());
      if (var3 != null && LoopHelper.isOwner(this.k, var3.getId())) {
         this.tip0.setVisibility(0);
         this.tip0.setOnClickListener(this.b);
      } else {
         this.tip0.setVisibility(8);
      }

      this.tip1.setOnClickListener(this.b);
      this.tip2.setOnClickListener(this.b);
      this.tip3.setOnClickListener(this.b);
      this.tip4.setOnClickListener(this.b);
      this.tip5.setOnClickListener(this.b);
   }
}
