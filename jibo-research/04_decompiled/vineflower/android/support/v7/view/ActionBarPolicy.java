package android.support.v7.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R;
import android.view.ViewConfiguration;

public class ActionBarPolicy {
   private Context a;

   private ActionBarPolicy(Context var1) {
      this.a = var1;
   }

   public static ActionBarPolicy a(Context var0) {
      return new ActionBarPolicy(var0);
   }

   public int a() {
      Configuration var3 = this.a.getResources().getConfiguration();
      int var1 = var3.screenWidthDp;
      int var2 = var3.screenHeightDp;
      byte var4;
      if (var3.smallestScreenWidthDp <= 600 && var1 <= 600 && (var1 <= 960 || var2 <= 720) && (var1 <= 720 || var2 <= 960)) {
         if (var1 < 500 && (var1 <= 640 || var2 <= 480) && (var1 <= 480 || var2 <= 640)) {
            if (var1 >= 360) {
               var4 = 3;
            } else {
               var4 = 2;
            }
         } else {
            var4 = 4;
         }
      } else {
         var4 = 5;
      }

      return var4;
   }

   public boolean b() {
      boolean var1 = true;
      if (VERSION.SDK_INT < 19 && ViewConfiguration.get(this.a).hasPermanentMenuKey()) {
         var1 = false;
      }

      return var1;
   }

   public int c() {
      return this.a.getResources().getDisplayMetrics().widthPixels / 2;
   }

   public boolean d() {
      return this.a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
   }

   public int e() {
      TypedArray var4 = this.a.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
      int var2 = var4.getLayoutDimension(R.styleable.ActionBar_height, 0);
      Resources var3 = this.a.getResources();
      int var1 = var2;
      if (!this.d()) {
         var1 = Math.min(var2, var3.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
      }

      var4.recycle();
      return var1;
   }

   public boolean f() {
      boolean var1;
      if (this.a.getApplicationInfo().targetSdkVersion < 14) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public int g() {
      return this.a.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
   }
}
