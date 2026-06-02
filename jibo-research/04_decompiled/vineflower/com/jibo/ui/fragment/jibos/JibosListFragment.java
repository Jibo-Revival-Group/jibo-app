package com.jibo.ui.fragment.jibos;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.auth.BasicAWSCredentials;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.db.DatabaseContract;
import com.jibo.db.EntityData;
import com.jibo.service.SyncHelper;
import com.jibo.ui.activity.LoopInviteDetailsActivity;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.activity.TabbedActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.fragment.account.AccountSettingsDetailsFragment;
import com.jibo.ui.fragment.dialog.DialogUtils;
import com.jibo.ui.fragment.jibos.adapter.JibosListAdapter;
import com.jibo.ui.view.LoopSelectionListView;
import com.jibo.utils.ImageUtils;
import java.util.ArrayList;
import java.util.List;

public class JibosListFragment
   extends BaseFragment
   implements LoaderManager.LoaderCallbacks<Cursor>,
   SwipeRefreshLayout.OnRefreshListener,
   LoopSelectionListView.OnLoopSelectedListener {
   private static int a = 1000;
   private static int b = 1001;
   private JibosListAdapter c;
   private JiboRobotPropertiesAsyncClient d;
   private boolean e;
   @BindView
   View emptyView;
   @BindView
   View fab;
   private Loop l;
   @BindView
   RecyclerView list;
   private List<Loop> m;
   @BindView
   SwipeRefreshLayout swipeRefreshLayout;

   private void b(Loop var1) {
      Intent var2 = new Intent();
      var2.putExtra(" ARGS_LOOPS_LIST", this.c(var1));
      var2.putExtra(" ARGS_HAS_ACCEPTED_LOOPS", true);
      var2.setClass(this.getContext(), LoopInviteDetailsActivity.class);
      this.startActivity(var2);
   }

   private ArrayList<Loop> c(Loop var1) {
      ArrayList var3 = new ArrayList();
      String var2 = EntityData.a(this.getContext()).i().getEmail();
      var3.add(var1);

      for (Loop var4 : this.m) {
         if (!var4.equals(var1) && LoopHelper.isMemberInvited(var4, var2)) {
            var3.add(var4);
         }
      }

      return var3;
   }

   @Override
   public Loader<Cursor> a(int var1, Bundle var2) {
      CursorLoader var3;
      switch (var1) {
         case 2131296709:
            var3 = new CursorLoader(this.getActivity(), DatabaseContract.EntityEntry.a(8), DatabaseContract.EntityEntry.a, null, null, "name");
            break;
         default:
            var3 = null;
      }

      return var3;
   }

   @Override
   public void a(Loader<Cursor> var1) {
      this.c.a(EntityData.a(this.getActivity()).i(), null);
      this.c.notifyDataSetChanged();
   }

   public void a(Loader<Cursor> var1, Cursor var2) {
      if (var1.n() == 2131296709) {
         EntityData var7 = EntityData.a(this.getActivity());
         boolean var3;
         if (var2 != null && !var2.isClosed() && var2.getCount() != 0 && var2.moveToFirst() && var7.i() != null) {
            var3 = false;
         } else {
            var3 = true;
         }

         ArrayList var6 = new ArrayList();
         Loop var9 = null;
         Loop var5 = null;
         boolean var4 = var3;
         if (!var3) {
            String var8 = var7.i().getId();
            var9 = var5;

            while (!var2.isAfterLast()) {
               var5 = EntityData.a(var2);
               if (!LoopHelper.isMemberDeclined(var5, var8)) {
                  var6.add(var5);
                  if (this.getArguments() != null && var5.getId().equals(this.getArguments().getString("ARG_ENTITY_SELECTED"))) {
                     var9 = var5;
                  }
               }

               var2.moveToNext();
            }

            if (var6.size() == 0) {
               var4 = true;
            } else {
               var4 = false;
            }

            var4 = var3 | var4;
         }

         if (var4) {
            this.emptyView.setVisibility(0);
            this.list.setVisibility(8);
            this.fab.setVisibility(8);
            this.e = false;
         } else {
            this.emptyView.setVisibility(8);
            this.list.setVisibility(0);
            this.fab.setVisibility(0);
            this.e = true;
            this.c.a(var7.i(), var6);
            this.c.notifyDataSetChanged();
            this.m = var6;
         }

         ((TabbedActivity)this.getActivity()).w();
         if (var9 != null) {
            this.a(var9);
         }
      }
   }

   @Override
   public void a(Loop var1) {
      Bundle var2 = new Bundle();
      var2.putParcelable(Loop.class.getSimpleName(), var1);
      if (LoopHelper.isMemberInvited(var1, EntityData.a(this.getActivity()).i().getId())) {
         this.b(var1);
      } else {
         ((TabbedActivity)this.getActivity()).a(JiboDetailsFragment.class, var2);
      }
   }

   public void b() {
      new SingleFragmentActivity.Builder(this.getActivity(), AccountSettingsDetailsFragment.class.getName()).a(b);
   }

   @Override
   public void n_() {
      SyncHelper.b(this.getActivity());
      this.getView().postDelayed(new Runnable(this) {
         final JibosListFragment a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            if (this.a.d()) {
               this.a.swipeRefreshLayout.setRefreshing(false);
            }
         }
      }, 1500L);
   }

   @Override
   public String o() {
      return this.getString(2131756039);
   }

   @Override
   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var1 == a && var2 == -1 && var3 != null) {
         Bundle var4 = new Bundle();
         this.l = (Loop)var3.getParcelableExtra(Loop.class.getSimpleName());
         var1 = var3.getIntExtra("ARG_TAB_SELECTED", 0);
         if (this.c != null && this.c.a() + this.c.b() == 0) {
            if (this.l != null) {
               var4.putString("ARG_ENTITY_SELECTED", this.l.getId());
            }

            var4.putInt("ARG_TAB_SELECTED", var1);
            this.getActivity().getIntent().putExtra("ARG_EXTRAS", var4);
         } else if (this.c != null && this.c.a() + this.c.b() > 0 && var1 == 2 && this.getParentFragment() != null) {
            this.l = null;
            ((TabbedActivity)this.getActivity()).u();
         }
      }
   }

   @OnClick
   public void onConnectWifi(View var1) {
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      super.onCreateOptionsMenu(var1, var2);
      var2.inflate(2131492879, var1);
      ImageUtils.a(this.getActivity(), var1);
      var1.findItem(2131296306).setVisible(true);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427448, var2, false);
   }

   @OnClick
   public void onInviteInfo(View var1) {
      DialogUtils.d(this, 1, this.getString(2131755546), String.format(this.getString(2131755545), EntityData.a(this.getActivity()).i().getEmail()));
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (var1.getItemId() == 2131296306) {
         this.b();
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   @Override
   public void onResume() {
      super.onResume();
      if (this.l != null && this.d() && this.c != null && this.c.a() + this.c.b() > 0) {
         this.a(this.l);
         this.l = null;
      }
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.swipeRefreshLayout.setOnRefreshListener(this);
      this.swipeRefreshLayout.setColorSchemeResources(2131099771, 2131099672, 2131099672, 2131099672);
      this.c = new JibosListAdapter(null);
      LinearLayoutManager var3 = new LinearLayoutManager(this.getActivity(), 1, false);
      this.getLoaderManager().a(2131296709, null, this);
      this.list.setHasFixedSize(true);
      this.list.setItemAnimator(new DefaultItemAnimator());
      this.list.setLayoutManager(var3);
      this.list.setAdapter(this.c);
      if (this.getArguments() != null && this.getArguments().getString("ARG_MESSAGE") != null) {
         this.c().postDelayed(new Runnable(this) {
            final JibosListFragment a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               DialogUtils.d(this.a, 1, this.a.getString(2131755546), this.a.getArguments().getString("ARG_MESSAGE"));
               this.a.getArguments().remove("ARG_MESSAGE");
            }
         }, 100L);
      }

      Account var4 = EntityData.a(this.getActivity()).i();
      if (var4 != null) {
         JiboRobotPropertiesAsyncClient var5 = new JiboRobotPropertiesAsyncClient(new BasicAWSCredentials(var4.getAccessKeyId(), var4.getSecretAccessKey()));
         this.d = var5;
         this.a(var5);
      }
   }

   @OnClick
   public void setUpNewJibo(View var1) {
      this.onConnectWifi(var1);
   }
}
