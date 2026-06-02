package com.jibo.ui.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.common.GoogleApiAvailability;
import com.jibo.JiboApplication;
import com.jibo.ui.fragment.IBaseFragment;
import com.jibo.ui.fragment.dialog.DialogUtils;
import com.jibo.ui.view.proxima.ProximaHelper;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.LogUtils;
import com.jibo.utils.NetworkStateReceiver;
import com.jibo.utils.SharedPreferencesUtil;
import com.jibo.utils.UIUtils;
import java.lang.reflect.Field;

public class BaseActivity extends AppCompatActivity implements DialogUtils.DialogFragmentWrapperClickListener {
   public static final String a = BaseActivity.class.getSimpleName();
   public static final String b = BaseActivity.class.getName() + ".LAYOUT_ID";
   public static int c = 100;
   public static int d = c + 1;
   Toolbar e;
   Unbinder f;
   protected Handler g;
   private boolean h = false;
   private Runnable i;
   private Runnable j;
   private NetworkStateReceiver k;
   @BindView
   View mDimmer;
   @BindView
   ProgressBar mProgressBar;
   @BindView
   View viewNetworkDown;

   public BaseActivity() {
      this.g = new Handler(Looper.getMainLooper());
      this.i = new Runnable(this) {
         final BaseActivity a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.h = false;
            this.a.g.removeCallbacks(this.a.i);
         }
      };
      this.j = new Runnable(this) {
         final BaseActivity a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            Toast.makeText(this.a, 2131755375, 0).show();
            this.a.g.removeCallbacks(this.a.j);
         }
      };
      this.k = new NetworkStateReceiver(this) {
         final BaseActivity a;

         {
            this.a = var1;
         }

         @Override
         public void a(boolean var1) {
            if (var1) {
               this.a.c();
            } else {
               this.a.b();
            }

            this.a.invalidateOptionsMenu();
         }
      };
   }

   protected TextView a() {
      TextView var1;
      try {
         Field var4 = this.getSupportActionBar().getClass().getDeclaredField("mDecorToolbar");
         var4.setAccessible(true);
         Toolbar var2 = (Toolbar)((ToolbarWidgetWrapper)var4.get(this.getSupportActionBar())).a();
         Field var5 = var2.getClass().getDeclaredField("mTitleTextView");
         var5.setAccessible(true);
         var1 = (TextView)var5.get(var2);
      } catch (Exception var3) {
         var1 = null;
      }

      return var1;
   }

   @Override
   public void a(int var1, int var2, Object var3) {
      if (100 == var1) {
         this.setResult(d);
         this.finish();
      }
   }

   public void a(Class var1, Bundle var2) {
      this.getSupportFragmentManager().a().b(2131296575, Fragment.instantiate(this, var1.getName(), var2), var1.getSimpleName()).a(var1.getSimpleName()).d();
   }

   protected void a(Exception var1, String var2) {
      Crashlytics.a(var1);
      this.runOnUiThread(new Runnable(this, var1) {
         final Exception a;
         final BaseActivity b;

         {
            this.b = var1;
            this.a = var2x;
         }

         @Override
         public void run() {
            ErrorHelper.a(this.b, null, this.a);
         }
      });
   }

   public void a(boolean var1) {
      this.runOnUiThread(new Runnable(this, var1) {
         final boolean a;
         final BaseActivity b;

         {
            this.b = var1;
            this.a = var2;
         }

         @Override
         public void run() {
            byte var1x = 0;
            if (this.b.mProgressBar != null) {
               this.b.mProgressBar.setVisibility(0);
            }

            if (this.b.mDimmer != null) {
               View var2 = this.b.mDimmer;
               if (!this.a) {
                  var1x = 8;
               }

               var2.setVisibility(var1x);
            }
         }
      });
   }

   protected void b() {
      if (this.viewNetworkDown != null) {
         this.viewNetworkDown.setVisibility(0);
      }
   }

   public void b(Class var1, Bundle var2) {
      this.getSupportFragmentManager().a().a(2131296575, Fragment.instantiate(this, var1.getName(), var2), var1.getSimpleName()).a(var1.getSimpleName()).d();
   }

   protected void c() {
      if (this.viewNetworkDown != null) {
         this.viewNetworkDown.setVisibility(8);
      }
   }

   public void c(Class var1, Bundle var2) {
      this.getSupportFragmentManager()
         .a()
         .a(2130771990, 2130771992, 2130771989, 2130771991)
         .b(2131296575, Fragment.instantiate(this, var1.getName(), var2), var1.getSimpleName())
         .a(var1.getSimpleName())
         .d();
   }

   protected void d() {
      ((JiboApplication)this.getApplication()).b();
      SharedPreferencesUtil.b(this);
      OnBoardingActivity.a(this, OnBoardingActivity.j, true);
   }

   public void e() {
      this.setResult(TabbedActivity.c);
      this.finish();
   }

   public void f() {
      try {
         if (this.getWindow().getCurrentFocus() != null) {
            ((InputMethodManager)this.getSystemService("input_method")).hideSoftInputFromWindow(this.getWindow().getCurrentFocus().getWindowToken(), 0);
         }
      } catch (Exception var2) {
         LogUtils.a(a, "hideSoftwareKeyboard", var2);
      }
   }

   public Toolbar g() {
      return this.e;
   }

   public ProgressBar h() {
      return this.mProgressBar;
   }

   public void i() {
      if (this.mDimmer != null) {
         this.mDimmer.setVisibility(0);
      }
   }

   public void j() {
      if (this.mDimmer != null) {
         this.mDimmer.setVisibility(8);
      }
   }

   public void k() {
      this.runOnUiThread(new Runnable(this) {
         final BaseActivity a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            if (this.a.mProgressBar != null) {
               this.a.mProgressBar.setVisibility(0);
            }

            this.a.i();
         }
      });
   }

   public void l() {
      this.runOnUiThread(new Runnable(this) {
         final BaseActivity a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            if (this.a.mProgressBar != null) {
               this.a.mProgressBar.setVisibility(8);
            }

            this.a.j();
         }
      });
   }

   public void m() {
      FragmentManager.BackStackEntry var1;
      if (this.getSupportFragmentManager().e() > 0) {
         var1 = this.getSupportFragmentManager().b(0);
      } else {
         var1 = null;
      }

      if (var1 != null) {
         this.getSupportFragmentManager().b(var1.a(), 1);
      }
   }

   public Fragment n() {
      return this.getSupportFragmentManager().a(2131296575);
   }

   public AppBarLayout o() {
      return this.findViewById(2131296320);
   }

   @Override
   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var2 == d) {
         this.setResult(d);
         this.finish();
      }

      if (var2 == c) {
         this.e();
      }
   }

   @Override
   public void onBackPressed() {
      this.l();
      this.f();
      Fragment var1 = this.getSupportFragmentManager().a(2131296575);
      if (var1 == null || !(var1 instanceof IBaseFragment) || !((IBaseFragment)var1).h()) {
         if (this.getSupportFragmentManager().e() > 1) {
            super.onBackPressed();
         } else if (!(this instanceof BaseActivity.OnDoubleBackButtonListener)
            || this.getSupportFragmentManager().e() != 1
            || this.h
            || this.getIntent().getAction() != null
               && !this.getIntent().getAction().equals("android.intent.action.MAIN")
               && !this.getIntent().getAction().equals(OnBoardingActivity.j)) {
            this.finish();
         } else {
            this.h = true;
            this.g.postDelayed(this.j, 400L);
            this.g.postDelayed(this.i, 1200L);
         }
      }
   }

   @Override
   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.overridePendingTransition(17432576, 17432577);
      this.setContentView(this.getIntent().getIntExtra(b, 2131427358));
      this.f = ButterKnife.a(this);
      this.l();
      if (this.findViewById(2131297022) instanceof Toolbar) {
         this.e = this.findViewById(2131297022);
         this.setSupportActionBar(this.e);
         TextView var2 = this.a();
         if (var2 != null) {
            ProximaHelper.a(var2);
         }
      }
   }

   @Override
   protected void onDestroy() {
      super.onDestroy();
      this.f.unbind();
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (var1.getItemId() == 16908332) {
         this.onBackPressed();
         this.overridePendingTransition(17432576, 17432577);
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   @Override
   protected void onPause() {
      super.onPause();
      this.g.removeCallbacks(this.j);
      this.g.removeCallbacks(this.i);
      this.unregisterReceiver(this.k);
   }

   @Override
   protected void onResume() {
      super.onResume();
      IntentFilter var1 = new IntentFilter();
      var1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      var1.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      this.registerReceiver(this.k, var1);
   }

   protected boolean p() {
      GoogleApiAvailability var3 = GoogleApiAvailability.a();
      int var1 = var3.a(this);
      boolean var2;
      if (var1 != 0) {
         if (var3.a(var1)) {
            var3.a(this, var1, 9000).show();
         } else {
            UIUtils.a(this.findViewById(2131296575), "Play Services not available");
         }

         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   public interface OnDoubleBackButtonListener {
   }
}
