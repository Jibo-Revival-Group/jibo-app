package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.ShowableListMenu;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

public class ListPopupWindow implements ShowableListMenu {
   private static Method a;
   private static Method b;
   private static Method h;
   private Drawable A;
   private OnItemClickListener B;
   private OnItemSelectedListener C;
   private final ListPopupWindow.PopupTouchInterceptor D;
   private final ListPopupWindow.PopupScrollListener E;
   private final ListPopupWindow.ListSelectorHider F;
   private Runnable G;
   private final Rect H;
   private Rect I;
   private boolean J;
   DropDownListView c;
   int d;
   final ListPopupWindow.ResizePopupRunnable e;
   final Handler f;
   PopupWindow g;
   private Context i;
   private ListAdapter j;
   private int k = -2;
   private int l = -2;
   private int m;
   private int n;
   private int o = 1002;
   private boolean p;
   private boolean q = true;
   private boolean r;
   private boolean s;
   private int t = 0;
   private boolean u = false;
   private boolean v = false;
   private View w;
   private int x;
   private DataSetObserver y;
   private View z;

   static {
      try {
         a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", boolean.class);
      } catch (NoSuchMethodException var3) {
         Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
      }

      try {
         b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, int.class, boolean.class);
      } catch (NoSuchMethodException var2) {
         Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
      }

      try {
         h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
      } catch (NoSuchMethodException var1) {
         Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
      }
   }

   public ListPopupWindow(Context var1) {
      this(var1, null, R.attr.listPopupWindowStyle);
   }

   public ListPopupWindow(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.listPopupWindowStyle);
   }

   public ListPopupWindow(Context var1, AttributeSet var2, int var3) {
      this(var1, var2, var3, 0);
   }

   public ListPopupWindow(Context var1, AttributeSet var2, int var3, int var4) {
      this.d = Integer.MAX_VALUE;
      this.x = 0;
      this.e = new ListPopupWindow.ResizePopupRunnable(this);
      this.D = new ListPopupWindow.PopupTouchInterceptor(this);
      this.E = new ListPopupWindow.PopupScrollListener(this);
      this.F = new ListPopupWindow.ListSelectorHider(this);
      this.H = new Rect();
      this.i = var1;
      this.f = new Handler(var1.getMainLooper());
      TypedArray var5 = var1.obtainStyledAttributes(var2, R.styleable.ListPopupWindow, var3, var4);
      this.m = var5.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
      this.n = var5.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
      if (this.n != 0) {
         this.p = true;
      }

      var5.recycle();
      this.g = new AppCompatPopupWindow(var1, var2, var3, var4);
      this.g.setInputMethodMode(1);
   }

   private int a(View var1, int var2, boolean var3) {
      if (b != null) {
         int var4;
         try {
            var4 = (Integer)b.invoke(this.g, var1, var2, var3);
         } catch (Exception var6) {
            Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            return this.g.getMaxAvailableHeight(var1, var2);
         }

         return var4;
      } else {
         return this.g.getMaxAvailableHeight(var1, var2);
      }
   }

   private void a() {
      if (this.w != null) {
         ViewParent var1 = this.w.getParent();
         if (var1 instanceof ViewGroup) {
            ((ViewGroup)var1).removeView(this.w);
         }
      }
   }

   private int b() {
      boolean var6 = true;
      int var12;
      if (this.c == null) {
         Context var8 = this.i;
         this.G = new Runnable(this) {
            final ListPopupWindow a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               View var1 = this.a.i();
               if (var1 != null && var1.getWindowToken() != null) {
                  this.a.d();
               }
            }
         };
         boolean var5;
         if (!this.J) {
            var5 = true;
         } else {
            var5 = false;
         }

         this.c = this.a(var8, var5);
         if (this.A != null) {
            this.c.setSelector(this.A);
         }

         this.c.setAdapter(this.j);
         this.c.setOnItemClickListener(this.B);
         this.c.setFocusable(true);
         this.c.setFocusableInTouchMode(true);
         this.c.setOnItemSelectedListener(new OnItemSelectedListener(this) {
            final ListPopupWindow a;

            {
               this.a = var1;
            }

            public void onItemSelected(AdapterView<?> var1, View var2, int var3, long var4) {
               if (var3 != -1) {
                  DropDownListView var6x = this.a.c;
                  if (var6x != null) {
                     var6x.setListSelectionHidden(false);
                  }
               }
            }

            public void onNothingSelected(AdapterView<?> var1) {
            }
         });
         this.c.setOnScrollListener(this.E);
         if (this.C != null) {
            this.c.setOnItemSelectedListener(this.C);
         }

         Object var7 = this.c;
         View var9 = this.w;
         if (var9 != null) {
            LinearLayout var25 = new LinearLayout(var8);
            var25.setOrientation(1);
            LayoutParams var10 = new LayoutParams(-1, 0, 1.0F);
            switch (this.x) {
               case 0:
                  var25.addView(var9);
                  var25.addView((View)var7, var10);
                  break;
               case 1:
                  var25.addView((View)var7, var10);
                  var25.addView(var9);
                  break;
               default:
                  Log.e("ListPopupWindow", "Invalid hint position " + this.x);
            }

            int var2;
            if (this.l >= 0) {
               var2 = this.l;
               var12 = Integer.MIN_VALUE;
            } else {
               var12 = 0;
               var2 = 0;
            }

            var9.measure(MeasureSpec.makeMeasureSpec(var2, var12), 0);
            LayoutParams var21 = (LayoutParams)var9.getLayoutParams();
            var12 = var9.getMeasuredHeight();
            var2 = var21.topMargin;
            var12 = var21.bottomMargin + var12 + var2;
            var7 = var25;
         } else {
            var12 = 0;
         }

         this.g.setContentView((View)var7);
      } else {
         ViewGroup var22 = (ViewGroup)this.g.getContentView();
         View var23 = this.w;
         if (var23 != null) {
            LayoutParams var26 = (LayoutParams)var23.getLayoutParams();
            var12 = var23.getMeasuredHeight();
            int var16 = var26.topMargin;
            var12 = var26.bottomMargin + var12 + var16;
         } else {
            var12 = 0;
         }
      }

      Drawable var24 = this.g.getBackground();
      int var17;
      if (var24 != null) {
         var24.getPadding(this.H);
         var17 = this.H.top + this.H.bottom;
         if (!this.p) {
            this.n = -this.H.top;
         }
      } else {
         this.H.setEmpty();
         var17 = 0;
      }

      boolean var20;
      if (this.g.getInputMethodMode() == 2) {
         var20 = var6;
      } else {
         var20 = false;
      }

      int var4 = this.a(this.i(), this.n, var20);
      if (!this.u && this.k != -1) {
         int var3;
         switch (this.l) {
            case -2:
               var3 = MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), Integer.MIN_VALUE);
               break;
            case -1:
               var3 = MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), 1073741824);
               break;
            default:
               var3 = MeasureSpec.makeMeasureSpec(this.l, 1073741824);
         }

         var4 = this.c.a(var3, 0, -1, var4 - var12, -1);
         var3 = var12;
         if (var4 > 0) {
            var3 = var12 + this.c.getPaddingTop() + this.c.getPaddingBottom() + var17;
         }

         var12 = var4 + var3;
      } else {
         var12 = var4 + var17;
      }

      return var12;
   }

   private void c(boolean var1) {
      if (a != null) {
         try {
            a.invoke(this.g, var1);
         } catch (Exception var3) {
            Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
         }
      }
   }

   DropDownListView a(Context var1, boolean var2) {
      return new DropDownListView(var1, var2);
   }

   public void a(int var1) {
      this.x = var1;
   }

   public void a(Rect var1) {
      this.I = var1;
   }

   public void a(Drawable var1) {
      this.g.setBackgroundDrawable(var1);
   }

   public void a(OnItemClickListener var1) {
      this.B = var1;
   }

   public void a(ListAdapter var1) {
      if (this.y == null) {
         this.y = new ListPopupWindow.PopupDataSetObserver(this);
      } else if (this.j != null) {
         this.j.unregisterDataSetObserver(this.y);
      }

      this.j = var1;
      if (var1 != null) {
         var1.registerDataSetObserver(this.y);
      }

      if (this.c != null) {
         this.c.setAdapter(this.j);
      }
   }

   public void a(OnDismissListener var1) {
      this.g.setOnDismissListener(var1);
   }

   public void a(boolean var1) {
      this.J = var1;
      this.g.setFocusable(var1);
   }

   public void b(int var1) {
      this.g.setAnimationStyle(var1);
   }

   public void b(View var1) {
      this.z = var1;
   }

   public void b(boolean var1) {
      this.s = true;
      this.r = var1;
   }

   public void c(int var1) {
      this.m = var1;
   }

   public boolean c() {
      return this.J;
   }

   @Override
   public void d() {
      boolean var7 = true;
      boolean var8 = false;
      byte var4 = -1;
      int var1 = this.b();
      boolean var9 = this.n();
      PopupWindowCompat.a(this.g, this.o);
      if (this.g.isShowing()) {
         if (ViewCompat.B(this.i())) {
            int var2;
            if (this.l == -1) {
               var2 = -1;
            } else if (this.l == -2) {
               var2 = this.i().getWidth();
            } else {
               var2 = this.l;
            }

            if (this.k == -1) {
               if (!var9) {
                  var1 = -1;
               }

               if (var9) {
                  PopupWindow var10 = this.g;
                  byte var3;
                  if (this.l == -1) {
                     var3 = -1;
                  } else {
                     var3 = 0;
                  }

                  var10.setWidth(var3);
                  this.g.setHeight(0);
               } else {
                  PopupWindow var17 = this.g;
                  byte var14;
                  if (this.l == -1) {
                     var14 = -1;
                  } else {
                     var14 = 0;
                  }

                  var17.setWidth(var14);
                  this.g.setHeight(-1);
               }
            } else if (this.k != -2) {
               var1 = this.k;
            }

            PopupWindow var18 = this.g;
            var7 = var8;
            if (!this.v) {
               var7 = var8;
               if (!this.u) {
                  var7 = true;
               }
            }

            var18.setOutsideTouchable(var7);
            PopupWindow var11 = this.g;
            View var19 = this.i();
            int var6 = this.m;
            int var5 = this.n;
            int var15 = var2;
            if (var2 < 0) {
               var15 = -1;
            }

            if (var1 < 0) {
               var1 = var4;
            }

            var11.update(var19, var6, var5, var15, var1);
         }
      } else {
         int var13;
         if (this.l == -1) {
            var13 = -1;
         } else if (this.l == -2) {
            var13 = this.i().getWidth();
         } else {
            var13 = this.l;
         }

         if (this.k == -1) {
            var1 = -1;
         } else if (this.k != -2) {
            var1 = this.k;
         }

         this.g.setWidth(var13);
         this.g.setHeight(var1);
         this.c(true);
         PopupWindow var20 = this.g;
         if (this.v || this.u) {
            var7 = false;
         }

         var20.setOutsideTouchable(var7);
         this.g.setTouchInterceptor(this.D);
         if (this.s) {
            PopupWindowCompat.a(this.g, this.r);
         }

         if (h != null) {
            try {
               h.invoke(this.g, this.I);
            } catch (Exception var12) {
               Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", var12);
            }
         }

         PopupWindowCompat.a(this.g, this.i(), this.m, this.n, this.t);
         this.c.setSelection(-1);
         if (!this.J || this.c.isInTouchMode()) {
            this.m();
         }

         if (!this.J) {
            this.f.post(this.F);
         }
      }
   }

   public void d(int var1) {
      this.n = var1;
      this.p = true;
   }

   @Override
   public void e() {
      this.g.dismiss();
      this.a();
      this.g.setContentView(null);
      this.c = null;
      this.f.removeCallbacks(this.e);
   }

   public void e(int var1) {
      this.t = var1;
   }

   public void f(int var1) {
      this.l = var1;
   }

   @Override
   public boolean f() {
      return this.g.isShowing();
   }

   @Override
   public ListView g() {
      return this.c;
   }

   public void g(int var1) {
      Drawable var2 = this.g.getBackground();
      if (var2 != null) {
         var2.getPadding(this.H);
         this.l = this.H.left + this.H.right + var1;
      } else {
         this.f(var1);
      }
   }

   public Drawable h() {
      return this.g.getBackground();
   }

   public void h(int var1) {
      this.g.setInputMethodMode(var1);
   }

   public View i() {
      return this.z;
   }

   public void i(int var1) {
      DropDownListView var2 = this.c;
      if (this.f() && var2 != null) {
         var2.setListSelectionHidden(false);
         var2.setSelection(var1);
         if (var2.getChoiceMode() != 0) {
            var2.setItemChecked(var1, true);
         }
      }
   }

   public int j() {
      return this.m;
   }

   public int k() {
      int var1;
      if (!this.p) {
         var1 = 0;
      } else {
         var1 = this.n;
      }

      return var1;
   }

   public int l() {
      return this.l;
   }

   public void m() {
      DropDownListView var1 = this.c;
      if (var1 != null) {
         var1.setListSelectionHidden(true);
         var1.requestLayout();
      }
   }

   public boolean n() {
      boolean var1;
      if (this.g.getInputMethodMode() == 2) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private class ListSelectorHider implements Runnable {
      final ListPopupWindow a;

      ListSelectorHider(ListPopupWindow var1) {
         this.a = var1;
      }

      @Override
      public void run() {
         this.a.m();
      }
   }

   private class PopupDataSetObserver extends DataSetObserver {
      final ListPopupWindow a;

      PopupDataSetObserver(ListPopupWindow var1) {
         this.a = var1;
      }

      public void onChanged() {
         if (this.a.f()) {
            this.a.d();
         }
      }

      public void onInvalidated() {
         this.a.e();
      }
   }

   private class PopupScrollListener implements OnScrollListener {
      final ListPopupWindow a;

      PopupScrollListener(ListPopupWindow var1) {
         this.a = var1;
      }

      public void onScroll(AbsListView var1, int var2, int var3, int var4) {
      }

      public void onScrollStateChanged(AbsListView var1, int var2) {
         if (var2 == 1 && !this.a.n() && this.a.g.getContentView() != null) {
            this.a.f.removeCallbacks(this.a.e);
            this.a.e.run();
         }
      }
   }

   private class PopupTouchInterceptor implements OnTouchListener {
      final ListPopupWindow a;

      PopupTouchInterceptor(ListPopupWindow var1) {
         this.a = var1;
      }

      public boolean onTouch(View var1, MotionEvent var2) {
         int var4 = var2.getAction();
         int var3 = (int)var2.getX();
         int var5 = (int)var2.getY();
         if (var4 == 0 && this.a.g != null && this.a.g.isShowing() && var3 >= 0 && var3 < this.a.g.getWidth() && var5 >= 0 && var5 < this.a.g.getHeight()) {
            this.a.f.postDelayed(this.a.e, 250L);
         } else if (var4 == 1) {
            this.a.f.removeCallbacks(this.a.e);
         }

         return false;
      }
   }

   private class ResizePopupRunnable implements Runnable {
      final ListPopupWindow a;

      ResizePopupRunnable(ListPopupWindow var1) {
         this.a = var1;
      }

      @Override
      public void run() {
         if (this.a.c != null && ViewCompat.B(this.a.c) && this.a.c.getCount() > this.a.c.getChildCount() && this.a.c.getChildCount() <= this.a.d) {
            this.a.g.setInputMethodMode(2);
            this.a.d();
         }
      }
   }
}
