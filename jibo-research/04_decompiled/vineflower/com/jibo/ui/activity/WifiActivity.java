package com.jibo.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.ui.fragment.wifi.JiboPreparationsFragment;
import com.jibo.ui.fragment.wifi.NetworkSelectionFragment;
import com.jibo.ui.fragment.wifi.SetupOrReconnectFragment;
import com.jibo.ui.fragment.wifi.WaitForTapFragment;
import com.jibo.ui.fragment.wifi.WiFiQRCodeFragment;
import java.util.ArrayList;

public class WifiActivity extends BaseActivity {
   public static final String h = WifiActivity.class.getSimpleName();
   private Loop i;
   private ArrayList<Loop> j;
   private WifiActivity.Mode k = WifiActivity.Mode.INIT_OR_RECONNECT;

   private static void a(Activity var0, Intent var1) {
      var0.startActivityForResult(var1, 1000);
   }

   public static void a(Activity var0, Loop var1) {
      Intent var3 = new Intent(var0, WifiActivity.class);
      int var2;
      if (var1.isSuspended()) {
         var2 = WifiActivity.Mode.RECONNECT_SUSPENDED.ordinal();
      } else {
         var2 = WifiActivity.Mode.RECONNECT.ordinal();
      }

      var3.putExtra("ARGS_MODE", var2);
      var3.putExtra(Loop.class.getSimpleName(), var1);
      a(var0, var3);
   }

   public static void a(Activity var0, ArrayList<Loop> var1) {
      Intent var2 = new Intent(var0, WifiActivity.class);
      if (var1 != null && !var1.isEmpty()) {
         ArrayList var3 = new ArrayList();

         for (Loop var4 : var1) {
            if (var4.isSuspended()) {
               var3.add(var4);
            }
         }

         if (var3.isEmpty()) {
            a(var0, var2.putExtra("ARGS_MODE", WifiActivity.Mode.INIT.ordinal()).putExtra("ARGS_SHOW_INTRO", false));
         } else {
            var2.putParcelableArrayListExtra("ARGS_SUSPENDED_LOOP_LIST", var3);
            a(var0, var2.putExtra("ARGS_MODE", WifiActivity.Mode.INIT_OR_RECONNECT.ordinal()));
         }
      } else {
         a(var0, var2.putExtra("ARGS_MODE", WifiActivity.Mode.INIT.ordinal()).putExtra("ARGS_SHOW_INTRO", true));
      }
   }

   public void a(WifiActivity.Mode var1) {
      this.k = var1;
   }

   @Override
   protected void onCreate(Bundle var1) {
      AppStartTrace.setLauncherActivityOnCreateTime("com.jibo.ui.activity.WifiActivity");
      this.getIntent().putExtra(BaseActivity.b, 2131427358);
      super.onCreate(var1);
      if (var1 != null) {
         this.i = (Loop)var1.getParcelable(Loop.class.getSimpleName());
         this.j = var1.getParcelableArrayList("ARGS_SUSPENDED_LOOP_LIST");
         this.k = WifiActivity.Mode.values()[var1.getInt("ARGS_MODE", WifiActivity.Mode.INIT.ordinal())];
      } else {
         this.i = (Loop)this.getIntent().getParcelableExtra(Loop.class.getSimpleName());
         this.j = this.getIntent().getParcelableArrayListExtra("ARGS_SUSPENDED_LOOP_LIST");
         this.k = WifiActivity.Mode.values()[this.getIntent().getIntExtra("ARGS_MODE", WifiActivity.Mode.INIT.ordinal())];
      }

      if (var1 == null) {
         if (this.k == WifiActivity.Mode.INIT_OR_RECONNECT) {
            this.s();
         } else if (this.getIntent().hasExtra("ARGS_SHOW_INTRO") && this.getIntent().getBooleanExtra("ARGS_SHOW_INTRO", false)) {
            this.r();
         } else {
            this.q();
         }
      }
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2 = true;
      if (16908332 == var1.getItemId()) {
         if (this.getSupportFragmentManager().a(2131296575) != null && this.getSupportFragmentManager().a(2131296575) instanceof WiFiQRCodeFragment) {
            this.getSupportFragmentManager().a(WaitForTapFragment.class.getSimpleName(), 1);
         } else {
            var2 = super.onOptionsItemSelected(var1);
         }
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   @Override
   protected void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.jibo.ui.activity.WifiActivity");
      super.onResume();
   }

   @Override
   protected void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putParcelable(Loop.class.getSimpleName(), this.i);
      var1.putParcelableArrayList("ARGS_SUSPENDED_LOOP_LIST", this.j);
      var1.putInt("ARGS_MODE", this.k.ordinal());
   }

   @Override
   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.jibo.ui.activity.WifiActivity");
      super.onStart();
   }

   public void q() {
      Bundle var1 = new Bundle();
      if (this.i == null) {
         this.k = WifiActivity.Mode.INIT;
      } else {
         var1.putParcelable(Loop.class.getSimpleName(), this.i);
      }

      this.c(NetworkSelectionFragment.class, var1);
   }

   public void r() {
      this.c(JiboPreparationsFragment.class, null);
   }

   public void s() {
      Bundle var1 = new Bundle();
      var1.putParcelableArrayList("ARGS_SUSPENDED_LOOP_LIST", this.j);
      this.c(SetupOrReconnectFragment.class, var1);
   }

   public WifiActivity.Mode t() {
      return this.k;
   }

   public enum Mode {
      INIT,
      INIT_OR_RECONNECT,
      RECONNECT,
      RECONNECT_SUSPENDED;

      private static final WifiActivity.Mode[] $VALUES = new WifiActivity.Mode[]{
         WifiActivity.Mode.INIT_OR_RECONNECT, WifiActivity.Mode.INIT, WifiActivity.Mode.RECONNECT, WifiActivity.Mode.RECONNECT_SUSPENDED
      };
   }
}
