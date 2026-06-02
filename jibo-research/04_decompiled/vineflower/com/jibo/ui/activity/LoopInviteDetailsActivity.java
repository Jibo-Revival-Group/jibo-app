package com.jibo.ui.activity;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.handlers.AsyncHandler;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.jibo.JiboAnalytics;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.exception.ResourceNotFoundException;
import com.jibo.aws.integration.aws.services.loop.model.AcceptLoopInvitationRequest;
import com.jibo.aws.integration.aws.services.loop.model.DeclineLoopInvitationRequest;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.db.EntityData;
import com.jibo.service.SyncHelper;
import com.jibo.ui.fragment.dialog.CircleProgressFragment;
import com.jibo.ui.fragment.dialog.DialogUtils;
import com.jibo.ui.fragment.jibos.adapter.LoopMembersListAdapter;
import com.jibo.ui.helpers.Items;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LoopInviteDetailsActivity extends BaseActivity {
   @BindView
   View buttonAccept;
   @BindView
   View buttonDecline;
   private LoopMembersListAdapter h;
   private Loop i;
   private List<Items.Item> j = new ArrayList<>();
   private CircleProgressFragment k;
   private List<Loop> l;
   private boolean m;
   private boolean n = false;
   @BindView
   RecyclerView recyclerView;

   private void q() {
      DialogUtils.c(null, this.getSupportFragmentManager(), 103, this.getString(2131755508), this.getString(2131755509, new Object[]{this.i.getName()}));
   }

   private void r() {
      this.buttonAccept.setClickable(true);
      this.buttonDecline.setClickable(true);
      Loop var1;
      if (this.l != null && !this.l.isEmpty()) {
         var1 = this.l.get(0);
      } else {
         var1 = this.i;
      }

      this.i = var1;
      Account var4 = EntityData.a(this).i();
      Member var2 = LoopHelper.getMemberByIdOrEmail(this.i, var4.getId());
      this.j.clear();
      this.j.add(new Items.SubheaderItem(2131755352));
      List var3 = LoopHelper.sortMembers(this.i, var2);
      var3.remove(var2);

      for (Member var5 : var3) {
         this.j.add(new Items.MemberItem(this.i, var5));
      }

      this.j.add(new Items.FooterItem(this.getString(2131755505)));
      this.h = new LoopMembersListAdapter(this.j, this.i, var4);
      this.recyclerView.setAdapter(this.h);
      if (this.m) {
         this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         this.getSupportActionBar().setHomeAsUpIndicator(2131231362);
      } else {
         this.getSupportActionBar().setDisplayShowHomeEnabled(false);
         this.getSupportActionBar().setHomeButtonEnabled(false);
         this.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
         this.getSupportActionBar().setHomeAsUpIndicator(0);
      }

      this.getSupportActionBar().setTitle(this.getString(2131756043, new Object[]{this.i.getName()}));
   }

   private void s() {
      if (this.l != null && this.l.size() > 1) {
         this.l.remove(0);
         this.r();
      } else {
         if (this.n) {
            TabbedActivity.a(this, this.getIntent().getExtras().getBundle("ARG_EXTRAS"));
         }

         this.onBackPressed();
      }
   }

   private void t() {
      ((NotificationManager)this.getSystemService("notification")).cancel(this.i.getId(), 2);
   }

   @Override
   protected void onCreate(Bundle var1) {
      boolean var2 = false;
      AppStartTrace.setLauncherActivityOnCreateTime("com.jibo.ui.activity.LoopInviteDetailsActivity");
      this.getIntent().putExtra(b, 2131427360);
      super.onCreate(var1);
      ArrayList var3 = null;
      if (this.getIntent() != null) {
         this.i = (Loop)this.getIntent().getParcelableExtra(Loop.class.getSimpleName());
         var3 = this.getIntent().getParcelableArrayListExtra(" ARGS_LOOPS_LIST");
         this.m = this.getIntent().getBooleanExtra(" ARGS_HAS_ACCEPTED_LOOPS", false);
      } else if (var1 != null) {
         this.i = (Loop)var1.getParcelable(Loop.class.getSimpleName());
         var3 = var1.getParcelableArrayList(" ARGS_LOOPS_LIST");
         this.m = var1.getBoolean(" ARGS_HAS_ACCEPTED_LOOPS", false);
      }

      if (!this.m) {
         var2 = true;
      }

      this.n = var2;
      if (var3 != null) {
         this.l = new LinkedList<>(var3);
      }

      this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      this.recyclerView.setHasFixedSize(true);
      this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
      this.recyclerView.addItemDecoration(new LoopMembersListAdapter.SpacesItemDecoration(this, -1, 2131165263, 2131165366));
      this.r();
   }

   @OnClick
   public void onDeclineClick(View var1) {
      if (this.i.isSuspended()) {
         this.q();
      } else {
         this.buttonAccept.setClickable(false);
         this.buttonDecline.setClickable(false);
         this.t();
         if (this.k == null) {
            this.k = new CircleProgressFragment();
            this.k.c(this.getString(2131755241, new Object[]{this.i.getName()}));
            this.k.show(this.getSupportFragmentManager(), "CircleFragment");
            this.k.a(new CircleProgressFragment.OnDismissListener(this) {
               final LoopInviteDetailsActivity a;

               {
                  this.a = var1;
               }

               @Override
               public void a(CircleProgressFragment.Status var1) {
                  if (var1 == CircleProgressFragment.Status.Success) {
                     this.a.s();
                  } else {
                     this.a.buttonAccept.setClickable(true);
                     this.a.buttonDecline.setClickable(true);
                  }
               }
            });
         }

         EntityData.a(this).b().declineInvitation(this.i.getId(), new AsyncHandler<DeclineLoopInvitationRequest, Loop>(this) {
            final LoopInviteDetailsActivity a;

            {
               this.a = var1;
            }

            public void a(DeclineLoopInvitationRequest var1, Loop var2) {
               this.a.setResult(0);
               JiboAnalytics.b(this.a, var2.getRobot());
               EntityData.a(this.a).b(var2.getId());
               this.a.k.a(this.a.getString(2131755240));
               this.a.k = null;
            }

            @Override
            public void onError(Exception var1) {
               this.a.k.b(this.a.getString(2131755239));
               this.a.a(var1, "decline invitation");
            }
         });
      }
   }

   @OnClick
   public void onJoinClick(View var1) {
      if (this.i.isSuspended()) {
         this.q();
      } else {
         this.buttonAccept.setClickable(false);
         this.buttonDecline.setClickable(false);
         this.t();
         if (this.k == null) {
            this.k = new CircleProgressFragment();
            this.k.c(this.getString(2131755450, new Object[]{this.i.getName()}));
            this.k.show(this.getSupportFragmentManager(), "CircleFragment");
            this.k.a(new CircleProgressFragment.OnDismissListener(this) {
               final LoopInviteDetailsActivity a;

               {
                  this.a = var1;
               }

               @Override
               public void a(CircleProgressFragment.Status var1) {
                  if (var1 == CircleProgressFragment.Status.Success) {
                     this.a.s();
                  } else {
                     this.a.buttonAccept.setClickable(true);
                     this.a.buttonDecline.setClickable(true);
                  }
               }
            });
         }

         EntityData.a(this).b().acceptInvitation(this.i.getId(), new AsyncHandler<AcceptLoopInvitationRequest, Loop>(this) {
            final LoopInviteDetailsActivity a;

            {
               this.a = var1;
            }

            public void a(AcceptLoopInvitationRequest var1, Loop var2) {
               this.a.m = true;
               this.a.setResult(-1);
               JiboAnalytics.c(this.a, true);
               EntityData.a(this.a).a(var2, true);
               SyncHelper.b(this.a, this.a.i.getId());
               this.a.k.a(this.a.getString(2131755449));
               this.a.k = null;
            }

            @Override
            public void onError(Exception var1) {
               this.a.k.b(this.a.getString(2131755448));
               this.a.a(var1, "accept invitation");
               this.a.buttonAccept.setClickable(true);
               this.a.buttonDecline.setClickable(true);
               if (var1 instanceof ResourceNotFoundException && "LOOP_NOT_FOUND".equals(((ResourceNotFoundException)var1).getErrorCode())) {
                  SyncHelper.b(this.a, this.a.i.getId());
                  this.a.finish();
               }
            }
         });
      }
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (16908332 == var1.getItemId()) {
         this.finish();
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   @Override
   protected void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.jibo.ui.activity.LoopInviteDetailsActivity");
      super.onResume();
   }

   @Override
   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.jibo.ui.activity.LoopInviteDetailsActivity");
      super.onStart();
   }
}
