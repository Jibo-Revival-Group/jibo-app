package com.jibo.ui.activity;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.amazonaws.handlers.AsyncHandler;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.jibo.JiboAnalytics;
import com.jibo.JiboSupport;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.db.DatabaseContract;
import com.jibo.db.EntityData;
import com.jibo.service.DeviceRegistrationService;
import com.jibo.service.SyncHelper;
import com.jibo.ui.fragment.AvatarBaseFragment;
import com.jibo.ui.fragment.home.MediaFragment;
import com.jibo.ui.fragment.jibos.JiboDetailsFragment;
import com.jibo.ui.fragment.jibos.NoLoopsFragment;
import com.jibo.ui.fragment.jibos.adapter.JibosListAdapter;
import com.jibo.ui.fragment.settings.AvatarSelectionFragment;
import com.jibo.ui.fragment.tips.TipsListFragment;
import com.jibo.ui.view.BottomPanelButton;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.SharedPreferencesUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class TabbedActivity extends BaseActivity implements LoaderCallbacks<Cursor>, BaseActivity.OnDoubleBackButtonListener {
   private static final boolean[] h = new boolean[]{true, true, true, true};
   private static final boolean[] i = new boolean[]{true, true, true, true};
   private static boolean[] l = i;
   private static boolean[] m = new boolean[]{true, false, true, true};
   private static String[] n = new String[]{
      JiboDetailsFragment.class.getName(), MediaFragment.class.getName(), TipsListFragment.class.getName(), TipsListFragment.class.getName()
   };
   private static String[] o = new String[]{NoLoopsFragment.class.getName(), MediaFragment.class.getName(), TipsListFragment.class.getName()};
   private ArrayList<Loop> j;
   @BindView
   RecyclerView jiboList;
   @BindView
   View jiboListContainer;
   private CountDownTimer k;
   @BindView
   View mSelectorDimmer;
   private int p = -1;
   private TabbedActivity.TabsState q = null;
   private Fragment r;
   private String s = null;
   private Loop t = null;
   @BindView
   LinearLayout tabs;
   private JibosListAdapter u;
   private ActionMode v;
   private boolean w;
   private OnClickListener x = new OnClickListener(this) {
      final TabbedActivity a;

      {
         this.a = var1;
      }

      public void onClick(View var1) {
         this.a.B();
      }
   };
   private OnClickListener y = new OnClickListener(this) {
      final TabbedActivity a;

      {
         this.a = var1;
      }

      public void onClick(View var1) {
         this.a.d((Loop)var1.getTag());
      }
   };
   private OnClickListener z = new OnClickListener(this) {
      final TabbedActivity a;

      {
         this.a = var1;
      }

      public void onClick(View var1) {
         this.a.a((Integer)var1.getTag(), false);
      }
   };

   private void A() {
      if (this.v != null) {
         this.v.c();
      }
   }

   private void B() {
      this.z();
      if (this.jiboList.getTag() == null || !(Boolean)this.jiboList.getTag()) {
         if (this.jiboListContainer.isShown()) {
            this.D();
         } else {
            this.C();
         }
      }
   }

   private void C() {
      this.jiboList.setTag(true);
      if (this.mSelectorDimmer != null) {
         this.mSelectorDimmer.setAlpha(0.0F);
         this.mSelectorDimmer.setVisibility(0);
         this.mSelectorDimmer.animate().alpha(1.0F).setListener(null).setDuration(500L).start();
      }

      this.jiboListContainer.setY(-this.u.getItemCount() * this.getResources().getDimensionPixelOffset(2131165319));
      this.jiboListContainer.setVisibility(0);
      this.jiboListContainer.animate().y(0.0F).setDuration(600L).setListener(null).setInterpolator(new DecelerateInterpolator()).start();
      this.jiboList.postDelayed(new Runnable(this) {
         final TabbedActivity a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.jiboList.setTag(false);
         }
      }, 600L);
      TextView var1 = this.a();
      if (var1 != null) {
         var1.setCompoundDrawablesWithIntrinsicBounds(null, null, ImageUtils.a(this, 2131231006, 2131099871), null);
      }
   }

   private void D() {
      this.jiboList.setTag(true);
      if (this.mSelectorDimmer != null) {
         this.mSelectorDimmer.setAlpha(1.0F);
         this.mSelectorDimmer.animate().alpha(0.0F).setDuration(500L).setListener(new AnimatorListener(this) {
            final TabbedActivity a;

            {
               this.a = var1;
            }

            public void onAnimationCancel(Animator var1) {
               this.a.mSelectorDimmer.setVisibility(8);
            }

            public void onAnimationEnd(Animator var1) {
               this.a.mSelectorDimmer.setVisibility(8);
            }

            public void onAnimationRepeat(Animator var1) {
            }

            public void onAnimationStart(Animator var1) {
            }
         }).start();
      }

      this.jiboListContainer
         .animate()
         .y(-this.u.getItemCount() * this.getResources().getDimensionPixelOffset(2131165319))
         .setDuration(400L)
         .setListener(new AnimatorListener(this) {
            final TabbedActivity a;

            {
               this.a = var1;
            }

            public void onAnimationCancel(Animator var1) {
               this.a.jiboListContainer.setVisibility(8);
            }

            public void onAnimationEnd(Animator var1) {
               this.a.jiboListContainer.setVisibility(8);
            }

            public void onAnimationRepeat(Animator var1) {
            }

            public void onAnimationStart(Animator var1) {
            }
         })
         .setInterpolator(new AccelerateInterpolator())
         .start();
      this.jiboList.postDelayed(new Runnable(this) {
         final TabbedActivity a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.jiboList.setTag(false);
         }
      }, 600L);
      TextView var1 = this.a();
      if (var1 != null) {
         var1.setCompoundDrawablesWithIntrinsicBounds(null, null, ImageUtils.a(this, 2131231005, 2131099871), null);
      }
   }

   private void E() {
      this.mSelectorDimmer.setVisibility(8);
      this.jiboListContainer.setVisibility(8);
      TextView var1 = this.a();
      if (var1 != null) {
         var1.setCompoundDrawablesWithIntrinsicBounds(null, null, ImageUtils.a(this, 2131231005, 2131099871), null);
      }
   }

   private void F() {
      if (this.j != null && !this.j.isEmpty()) {
         Iterator var1 = this.j.iterator();

         while (var1.hasNext()) {
            this.a((Loop)var1.next());
         }
      }
   }

   private void a(int var1) {
      this.mSelectorDimmer.setOnClickListener(null);
      TextView var3 = this.a();
      this.getSupportActionBar().setSubtitle("");
      if (var3 != null) {
         if (var1 == 0) {
            var3.setCompoundDrawablePadding(this.getResources().getDimensionPixelSize(2131165321));
            var3.setCompoundDrawablesWithIntrinsicBounds(null, null, ImageUtils.a(this, 2131231005, 2131099871), null);
            if (var3.getParent() != null) {
               ((View)var3.getParent()).setOnClickListener(this.x);
            }

            this.mSelectorDimmer.setOnClickListener(this.x);
         } else {
            var3.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            ((View)var3.getParent()).setOnClickListener(null);
         }
      }

      this.b(var1);

      for (int var2 = 0; var2 < n.length; var2++) {
         this.tabs.getChildAt(var2).setSelected(false);
      }

      this.tabs.getChildAt(var1).setSelected(true);
   }

   private void a(int var1, boolean var2) {
      if (var1 == 3) {
         JiboAnalytics.e(this, JiboAnalytics.aI);
         JiboSupport.a(this);
      } else if (this.p != var1 || var2) {
         this.f();
         this.a(var1);
         this.p = var1;
         this.A();
      }
   }

   public static void a(Activity var0, Bundle var1) {
      Intent var2 = new Intent(var0, TabbedActivity.class);
      var2.setFlags(335577088);
      var2.putExtra("ARG_EXTRAS", var1);
      var0.startActivity(var2);
      var0.finish();
   }

   private void a(Loop var1) {
      if (var1 != null) {
         EntityData.a(this).g().getRobot(var1.getRobotFriendlyId(), new AsyncHandler<GetRobotRequest, Robot>(this) {
            final TabbedActivity a;

            {
               this.a = var1;
            }

            public void a(GetRobotRequest var1, Robot var2) {
               this.a.runOnUiThread(new Runnable(this, var1, var2) {
                  final GetRobotRequest a;
                  final Robot b;
                  final <unrepresentable> c;

                  {
                     this.c = var1;
                     this.a = var2x;
                     this.b = var3;
                  }

                  @Override
                  public void run() {
                     this.c.a.u.a(this.a.getId(), this.b);
                  }
               });
            }

            @Override
            public void onError(Exception var1) {
               this.a.a(var1, "get robot");
            }
         });
      }
   }

   private void a(TabbedActivity.TabsState var1) {
      if (!this.isFinishing()) {
         boolean[] var4;
         if (var1 == TabbedActivity.TabsState.initial) {
            var4 = m;
         } else {
            var4 = l;
         }

         int var2;
         if (this.p == -1) {
            if (var1 == TabbedActivity.TabsState.initial) {
            }

            var2 = 0;
         } else {
            var2 = this.p;
         }

         if (var1 != this.q) {
            this.q = var1;
            int var3 = var2;
            if (this.q() != null) {
               var3 = this.q().getInt("ARG_TAB_SELECTED", var2);
            }

            this.a(var3, true);
         }

         for (int var6 = 0; var6 < n.length; var6++) {
            View var5 = this.tabs.getChildAt(var6);
            byte var7;
            if (var4[var6]) {
               var7 = 0;
            } else {
               var7 = 8;
            }

            var5.setVisibility(var7);
            this.tabs.getChildAt(var6).setTag(var6);
            this.tabs.getChildAt(var6).setOnClickListener(this.z);
         }
      }
   }

   private void b(int var1) {
      if (var1 == 1) {
         JiboAnalytics.d(this);
      } else if (var1 == 2) {
         JiboAnalytics.g(this);
      }

      FragmentTransaction var2 = this.getSupportFragmentManager().a();
      if (this.q == TabbedActivity.TabsState.complete) {
         this.r = Fragment.instantiate(this, n[var1], this.getIntent().getExtras());
      } else {
         this.r = Fragment.instantiate(this, o[var1], this.getIntent().getExtras());
      }

      var2.b(2131296575, this.r, this.r.getClass().getSimpleName()).d();
   }

   private void b(Loop var1) {
      this.l();
      Intent var2 = new Intent();
      var2.putExtra(" ARGS_LOOPS_LIST", this.c(var1));
      var2.putExtra(" ARGS_HAS_ACCEPTED_LOOPS", true);
      var2.setClass(this, LoopInviteDetailsActivity.class);
      this.startActivityForResult(var2, 1006);
   }

   private ArrayList<Loop> c(Loop var1) {
      ArrayList var5 = new ArrayList();
      String var2 = EntityData.a(this).i().getEmail();
      var5.add(var1);

      for (Loop var3 : this.u.c()) {
         if (!var3.equals(var1) && LoopHelper.isMemberInvited(var3, var2)) {
            var5.add(var3);
         }
      }

      return var5;
   }

   private void d(Loop var1) {
      if (var1 != null) {
         this.D();
         new Bundle().putParcelable(Loop.class.getSimpleName(), var1);
         if (LoopHelper.isMemberInvited(var1, EntityData.a(this).i().getId())) {
            this.b(var1);
         } else {
            EntityData.a(this).a(var1);
         }
      } else {
         this.E();
         WifiActivity.a(this, this.j);
      }
   }

   private void y() {
      this.k = (new CountDownTimer(this, 3000L, 3000L) {
         final TabbedActivity a;

         {
            this.a = var1;
         }

         public void onFinish() {
            this.a.D();
         }

         public void onTick(long var1) {
         }
      }).start();
   }

   private void z() {
      if (this.k != null) {
         this.k.cancel();
         this.k = null;
      }
   }

   public void a(Loader<Cursor> var1, Cursor var2) {
      if (var1.getId() == 2131296707) {
         if (var2 != null && !var2.isClosed()) {
            var2.moveToFirst();
            int var4 = 0;

            while (!var2.isAfterLast()) {
               int var3 = var4;
               if (!var2.getString(0).contains("TEMP_SENDING")) {
                  var3 = var4;
                  if (!var2.getString(0).contains("TEMP_FAILED")) {
                     var3 = var4 + 1;
                  }
               }

               var2.moveToNext();
               var4 = var3;
            }

            ((BottomPanelButton)this.tabs.getChildAt(0)).setBadgeNumber(var4);
         }
      } else if (var1.getId() == 2131296705) {
         if ((var2 == null || var2.isClosed() || !var2.moveToFirst()) && !this.isFinishing()) {
            OnBoardingActivity.a(this, OnBoardingActivity.j, true);
         }
      } else if (var1.getId() == 2131296709) {
         ArrayList var9 = new ArrayList();
         Account var8 = EntityData.a(this).i();
         this.t = SharedPreferencesUtil.f(this);
         TabbedActivity.TabsState var10 = null;
         Object var7 = null;
         Loop var6 = var10;
         if (var2 != null) {
            var6 = var10;
            if (!var2.isClosed()) {
               var6 = var10;
               if (var2.moveToFirst()) {
                  var10 = var7;

                  while (true) {
                     var6 = (Loop)var10;
                     if (var2.isAfterLast()) {
                        break;
                     }

                     EntityData.a(this);
                     var6 = EntityData.a(var2);
                     var9.add(var6);
                     if (this.s != null && this.s.equalsIgnoreCase(var6.getId())) {
                        this.t = var6;
                        SharedPreferencesUtil.a(this, this.t);
                     }

                     var2.moveToNext();
                     if (this.q() != null
                        && var6.getId().equals(this.q().getString("ARG_ENTITY_SELECTED"))
                        && LoopHelper.isMemberInvited(var6, EntityData.a(this).i().getId())) {
                        var10 = var6;
                     }
                  }
               }
            }
         }

         this.j = var9;
         this.u.a(var8, var9);
         this.u.notifyDataSetChanged();
         this.F();
         if (this.t == null) {
            var10 = TabbedActivity.TabsState.initial;
         } else {
            var10 = TabbedActivity.TabsState.complete;
         }

         this.a(var10);
         if (var6 != null) {
            this.q().remove("ARG_ENTITY_SELECTED");
            this.jiboList.postDelayed(new Runnable(this, var6) {
               final Loop a;
               final TabbedActivity b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               @Override
               public void run() {
                  this.b.b(this.a);
               }
            }, 500L);
         }

         if (this.t()) {
            Account var13 = EntityData.a(this).i();
            boolean var5;
            if (var6 == null) {
               var5 = true;
            } else {
               var5 = false;
            }

            JiboAnalytics.a(this, var13, var5, SharedPreferencesUtil.e(this));
            this.b(false);
         }
      }
   }

   public void a(ActionMode var1) {
      this.v = var1;
   }

   public void b(boolean var1) {
      this.w = var1;
   }

   @Override
   public void e() {
      this.d();
   }

   @Override
   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var2 == -1) {
         if (var3 != null && var3.hasExtra("ARG_TAB_SELECTED")) {
            this.a(var3.getIntExtra("ARG_TAB_SELECTED", 0), true);
         }

         if (var1 == 1001) {
            SyncHelper.b(this);
         } else if (var1 == 1003 && var3 != null && var3.getAction().equals(AvatarSelectionFragment.class.getSimpleName())) {
            this.a(this.t);
         } else if (var1 == 1006) {
            this.C();
            this.y();
         }
      }
   }

   @Override
   public void onBackPressed() {
      if (this.jiboList.isShown()) {
         this.D();
      } else {
         super.onBackPressed();
      }
   }

   @Override
   protected void onCreate(Bundle var1) {
      AppStartTrace.setLauncherActivityOnCreateTime("com.jibo.ui.activity.TabbedActivity");
      this.getIntent().putExtra(BaseActivity.b, 2131427363);
      super.onCreate(var1);
      this.e.setContentInsetsAbsolute(this.getResources().getDimensionPixelSize(2131165265), this.getResources().getDimensionPixelSize(2131165265));
      if (this.getSupportActionBar() != null) {
         this.getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
         this.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
         this.getSupportActionBar().setIcon(null);
      }

      if (this.getIntent() != null && this.getIntent().getExtras() != null) {
         Bundle var2 = this.getIntent().getExtras();
         if (var2 != null && var2.containsKey("ARG_EXTRAS")) {
            Bundle var3 = var2.getBundle("ARG_EXTRAS");
            if (var3 != null) {
               if (var3.containsKey(AvatarBaseFragment.a)) {
                  this.w = var3.getBoolean(AvatarBaseFragment.a, false);
                  var2.remove("ARG_EXTRAS");
               }

               if (var3.containsKey("ARG_FROM_NOTIFICATION")) {
                  JiboAnalytics.c(this, JiboAnalytics.aB);
               }

               if (var3.containsKey("ARG_LOOP_ID")) {
                  this.s = var3.getString("ARG_LOOP_ID");
               }
            }
         }
      }

      this.p = -1;
      if (var1 == null) {
         if (this.getIntent() != null && this.getIntent().getExtras() != null) {
            this.p = this.getIntent().getExtras().getInt("ARG_CURRENT_TAB", -1);
         }
      } else {
         this.p = var1.getInt("ARG_CURRENT_TAB", 0);
         TabbedActivity.TabsState var4;
         if (var1.getInt("ARG_TABS_STATE", -1) == -1) {
            var4 = null;
         } else {
            var4 = TabbedActivity.TabsState.values()[var1.getInt("ARG_TABS_STATE", 0)];
         }

         this.q = var4;
         this.a(this.p, true);
      }

      this.u = new JibosListAdapter(this.y);
      LinearLayoutManager var5 = new LinearLayoutManager(this, 1, false);
      this.jiboList.setItemAnimator(new DefaultItemAnimator());
      this.jiboList.addItemDecoration(new JibosListAdapter.SpacesItemDecoration(this, 2131165366));
      this.jiboList.setLayoutManager(var5);
      this.jiboList.setAdapter(this.u);
      this.getLoaderManager().initLoader(2131296705, null, this);
      this.getLoaderManager().initLoader(2131296709, null, this);
      this.getLoaderManager().initLoader(2131296707, null, this);
   }

   public Loader<Cursor> onCreateLoader(int var1, Bundle var2) {
      CursorLoader var3;
      switch (var1) {
         case 2131296705:
            var3 = new CursorLoader(this, DatabaseContract.EntityEntry.a(1), DatabaseContract.EntityEntry.a, null, null, null);
            break;
         case 2131296706:
         case 2131296708:
         default:
            var3 = null;
            break;
         case 2131296707:
            var3 = new CursorLoader(this, DatabaseContract.JotEntry.a, new String[]{"_id"}, "is_read = 0", null, null);
            break;
         case 2131296709:
            var3 = new CursorLoader(this, DatabaseContract.EntityEntry.a(8), DatabaseContract.EntityEntry.a, null, null, "_id");
      }

      return var3;
   }

   public void onLoaderReset(Loader<Cursor> var1) {
   }

   @Override
   protected void onNewIntent(Intent var1) {
      super.onNewIntent(var1);
   }

   @Override
   protected void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.jibo.ui.activity.TabbedActivity");
      super.onResume();
      this.v();
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putInt("ARG_CURRENT_TAB", this.p);
      int var2;
      if (this.q != null) {
         var2 = this.q.ordinal();
      } else {
         var2 = -1;
      }

      var1.putInt("ARG_TABS_STATE", var2);
   }

   @Override
   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.jibo.ui.activity.TabbedActivity");
      super.onStart();
   }

   public Bundle q() {
      return this.getIntent().getExtras().getBundle("ARG_EXTRAS");
   }

   public ActionMode r() {
      return this.v;
   }

   public void s() {
      if (this.v != null) {
         this.v.d();
      }
   }

   public boolean t() {
      return this.w;
   }

   public void u() {
      this.a(2, false);
   }

   protected void v() {
      if (this.p() && TextUtils.isEmpty(this.getSharedPreferences(this.getString(2131755063), 0).getString("PREF_PUSH_SERVICE_TOKEN", null))) {
         this.startService(new Intent(this, DeviceRegistrationService.class));
      }
   }

   public void w() {
   }

   public ArrayList<Loop> x() {
      return this.j;
   }

   private enum TabsState {
      complete,
      initial;

      private static final TabbedActivity.TabsState[] $VALUES = new TabbedActivity.TabsState[]{
         TabbedActivity.TabsState.initial, TabbedActivity.TabsState.complete
      };
   }
}
