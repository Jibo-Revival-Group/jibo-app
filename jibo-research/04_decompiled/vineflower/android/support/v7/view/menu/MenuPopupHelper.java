package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;

public class MenuPopupHelper {
   private final Context a;
   private final MenuBuilder b;
   private final boolean c;
   private final int d;
   private final int e;
   private View f;
   private int g = 8388611;
   private boolean h;
   private MenuPresenter.Callback i;
   private MenuPopup j;
   private OnDismissListener k;
   private final OnDismissListener l = new OnDismissListener(this) {
      final MenuPopupHelper a;

      {
         this.a = var1;
      }

      public void onDismiss() {
         this.a.e();
      }
   };

   public MenuPopupHelper(Context var1, MenuBuilder var2, View var3, boolean var4, int var5) {
      this(var1, var2, var3, var4, var5, 0);
   }

   public MenuPopupHelper(Context var1, MenuBuilder var2, View var3, boolean var4, int var5, int var6) {
      this.a = var1;
      this.b = var2;
      this.f = var3;
      this.c = var4;
      this.d = var5;
      this.e = var6;
   }

   private void a(int var1, int var2, boolean var3, boolean var4) {
      MenuPopup var6 = this.b();
      var6.c(var4);
      if (var3) {
         int var5 = var1;
         if ((GravityCompat.a(this.g, ViewCompat.e(this.f)) & 7) == 5) {
            var5 = var1 + this.f.getWidth();
         }

         var6.b(var5);
         var6.c(var2);
         var1 = (int)(this.a.getResources().getDisplayMetrics().density * 48.0F / 2.0F);
         var6.a(new Rect(var5 - var1, var2 - var1, var5 + var1, var1 + var2));
      }

      var6.d();
   }

   private MenuPopup g() {
      Display var2 = ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay();
      Point var3 = new Point();
      if (VERSION.SDK_INT >= 17) {
         var2.getRealSize(var3);
      } else {
         var2.getSize(var3);
      }

      boolean var1;
      if (Math.min(var3.x, var3.y) >= this.a.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
         var1 = true;
      } else {
         var1 = false;
      }

      MenuPopup var4;
      if (var1) {
         var4 = new CascadingMenuPopup(this.a, this.f, this.d, this.e, this.c);
      } else {
         var4 = new StandardMenuPopup(this.a, this.b, this.f, this.d, this.e, this.c);
      }

      var4.a(this.b);
      var4.a(this.l);
      var4.a(this.f);
      var4.a(this.i);
      var4.b(this.h);
      var4.a(this.g);
      return var4;
   }

   public void a() {
      if (!this.c()) {
         throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
      }
   }

   public void a(int var1) {
      this.g = var1;
   }

   public void a(MenuPresenter.Callback var1) {
      this.i = var1;
      if (this.j != null) {
         this.j.a(var1);
      }
   }

   public void a(View var1) {
      this.f = var1;
   }

   public void a(OnDismissListener var1) {
      this.k = var1;
   }

   public void a(boolean var1) {
      this.h = var1;
      if (this.j != null) {
         this.j.b(var1);
      }
   }

   public boolean a(int var1, int var2) {
      boolean var3 = true;
      if (!this.f()) {
         if (this.f == null) {
            var3 = false;
         } else {
            this.a(var1, var2, true, true);
         }
      }

      return var3;
   }

   public MenuPopup b() {
      if (this.j == null) {
         this.j = this.g();
      }

      return this.j;
   }

   public boolean c() {
      boolean var1 = true;
      if (!this.f()) {
         if (this.f == null) {
            var1 = false;
         } else {
            this.a(0, 0, false, false);
         }
      }

      return var1;
   }

   public void d() {
      if (this.f()) {
         this.j.e();
      }
   }

   protected void e() {
      this.j = null;
      if (this.k != null) {
         this.k.onDismiss();
      }
   }

   public boolean f() {
      boolean var1;
      if (this.j != null && this.j.f()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }
}
