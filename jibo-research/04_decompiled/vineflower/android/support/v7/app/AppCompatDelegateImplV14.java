package android.support.v7.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v7.view.SupportActionModeWrapper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

class AppCompatDelegateImplV14 extends AppCompatDelegateImplV9 {
   private int t = -100;
   private boolean u;
   private boolean v = true;
   private AppCompatDelegateImplV14.AutoNightModeManager w;

   AppCompatDelegateImplV14(Context var1, Window var2, AppCompatCallback var3) {
      super(var1, var2, var3);
   }

   private boolean h(int var1) {
      Resources var4 = this.a.getResources();
      Configuration var5 = var4.getConfiguration();
      int var2 = var5.uiMode;
      byte var7;
      if (var1 == 2) {
         var7 = 32;
      } else {
         var7 = 16;
      }

      boolean var3;
      if ((var2 & 48) != var7) {
         if (this.z()) {
            ((Activity)this.a).recreate();
         } else {
            Configuration var6 = new Configuration(var5);
            DisplayMetrics var8 = var4.getDisplayMetrics();
            var6.uiMode = var7 | var6.uiMode & -49;
            var4.updateConfiguration(var6, var8);
            if (VERSION.SDK_INT < 26) {
               ResourcesFlusher.a(var4);
            }
         }

         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   private int x() {
      int var1;
      if (this.t != -100) {
         var1 = this.t;
      } else {
         var1 = k();
      }

      return var1;
   }

   private void y() {
      if (this.w == null) {
         this.w = new AppCompatDelegateImplV14.AutoNightModeManager(this, TwilightManager.a(this.a));
      }
   }

   private boolean z() {
      boolean var2 = true;
      if (this.u && this.a instanceof Activity) {
         PackageManager var4 = this.a.getPackageManager();

         int var1;
         try {
            ComponentName var3 = new ComponentName(this.a, this.a.getClass());
            var1 = var4.getActivityInfo(var3, 0).configChanges;
         } catch (NameNotFoundException var5) {
            Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", var5);
            return var2;
         }

         if ((var1 & 512) != 0) {
            var2 = false;
         }
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   View a(View var1, String var2, Context var3, AttributeSet var4) {
      return null;
   }

   @Override
   Callback a(Callback var1) {
      return new AppCompatDelegateImplV14.AppCompatWindowCallbackV14(this, var1);
   }

   @Override
   public void a(Bundle var1) {
      super.a(var1);
      if (var1 != null && this.t == -100) {
         this.t = var1.getInt("appcompat:local_night_mode", -100);
      }
   }

   @Override
   public void c() {
      super.c();
      this.j();
   }

   @Override
   public void c(Bundle var1) {
      super.c(var1);
      if (this.t != -100) {
         var1.putInt("appcompat:local_night_mode", this.t);
      }
   }

   int d(int var1) {
      switch (var1) {
         case -100:
            var1 = -1;
            break;
         case 0:
            this.y();
            var1 = this.w.a();
      }

      return var1;
   }

   @Override
   public void d() {
      super.d();
      if (this.w != null) {
         this.w.d();
      }
   }

   @Override
   public void g() {
      super.g();
      if (this.w != null) {
         this.w.d();
      }
   }

   @Override
   public boolean j() {
      boolean var3 = false;
      int var1 = this.x();
      int var2 = this.d(var1);
      if (var2 != -1) {
         var3 = this.h(var2);
      }

      if (var1 == 0) {
         this.y();
         this.w.c();
      }

      this.u = true;
      return var3;
   }

   @Override
   public boolean p() {
      return this.v;
   }

   class AppCompatWindowCallbackV14 extends AppCompatDelegateImplBase.AppCompatWindowCallbackBase {
      final AppCompatDelegateImplV14 c;

      AppCompatWindowCallbackV14(AppCompatDelegateImplV14 var1, Callback var2) {
         super(var1, var2);
         this.c = var1;
      }

      final ActionMode a(android.view.ActionMode.Callback var1) {
         SupportActionModeWrapper.CallbackWrapper var3 = new SupportActionModeWrapper.CallbackWrapper(this.c.a, var1);
         android.support.v7.view.ActionMode var2 = this.c.a(var3);
         ActionMode var4;
         if (var2 != null) {
            var4 = var3.b(var2);
         } else {
            var4 = null;
         }

         return var4;
      }

      @Override
      public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback var1) {
         ActionMode var2;
         if (this.c.p()) {
            var2 = this.a(var1);
         } else {
            var2 = super.onWindowStartingActionMode(var1);
         }

         return var2;
      }
   }

   final class AutoNightModeManager {
      final AppCompatDelegateImplV14 a;
      private TwilightManager b;
      private boolean c;
      private BroadcastReceiver d;
      private IntentFilter e;

      AutoNightModeManager(AppCompatDelegateImplV14 var1, TwilightManager var2) {
         this.a = var1;
         this.b = var2;
         this.c = var2.a();
      }

      final int a() {
         this.c = this.b.a();
         byte var1;
         if (this.c) {
            var1 = 2;
         } else {
            var1 = 1;
         }

         return var1;
      }

      final void b() {
         boolean var1 = this.b.a();
         if (var1 != this.c) {
            this.c = var1;
            this.a.j();
         }
      }

      final void c() {
         this.d();
         if (this.d == null) {
            this.d = new BroadcastReceiver(this) {
               final AppCompatDelegateImplV14.AutoNightModeManager a;

               {
                  this.a = var1;
               }

               public void onReceive(Context var1, Intent var2) {
                  this.a.b();
               }
            };
         }

         if (this.e == null) {
            this.e = new IntentFilter();
            this.e.addAction("android.intent.action.TIME_SET");
            this.e.addAction("android.intent.action.TIMEZONE_CHANGED");
            this.e.addAction("android.intent.action.TIME_TICK");
         }

         this.a.a.registerReceiver(this.d, this.e);
      }

      final void d() {
         if (this.d != null) {
            this.a.a.unregisterReceiver(this.d);
            this.d = null;
         }
      }
   }
}
