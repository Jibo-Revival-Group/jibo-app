package android.support.v7.widget;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionMode;
import android.support.v7.view.menu.MenuBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends AbsActionBarView {
   private CharSequence g;
   private CharSequence h;
   private View i;
   private View j;
   private LinearLayout k;
   private TextView l;
   private TextView m;
   private int n;
   private int o;
   private boolean p;
   private int q;

   public ActionBarContextView(Context var1) {
      this(var1, null);
   }

   public ActionBarContextView(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.actionModeStyle);
   }

   public ActionBarContextView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      TintTypedArray var4 = TintTypedArray.a(var1, var2, R.styleable.ActionMode, var3, 0);
      ViewCompat.a(this, var4.a(R.styleable.ActionMode_background));
      this.n = var4.g(R.styleable.ActionMode_titleTextStyle, 0);
      this.o = var4.g(R.styleable.ActionMode_subtitleTextStyle, 0);
      this.e = var4.f(R.styleable.ActionMode_height, 0);
      this.q = var4.g(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
      var4.a();
   }

   private void e() {
      byte var4 = 8;
      boolean var2 = true;
      if (this.k == null) {
         LayoutInflater.from(this.getContext()).inflate(R.layout.abc_action_bar_title_item, this);
         this.k = (LinearLayout)this.getChildAt(this.getChildCount() - 1);
         this.l = (TextView)this.k.findViewById(R.id.action_bar_title);
         this.m = (TextView)this.k.findViewById(R.id.action_bar_subtitle);
         if (this.n != 0) {
            this.l.setTextAppearance(this.getContext(), this.n);
         }

         if (this.o != 0) {
            this.m.setTextAppearance(this.getContext(), this.o);
         }
      }

      this.l.setText(this.g);
      this.m.setText(this.h);
      boolean var1;
      if (!TextUtils.isEmpty(this.g)) {
         var1 = 1;
      } else {
         var1 = 0;
      }

      if (TextUtils.isEmpty(this.h)) {
         var2 = false;
      }

      TextView var5 = this.m;
      byte var3;
      if (var2) {
         var3 = 0;
      } else {
         var3 = 8;
      }

      label33: {
         var5.setVisibility(var3);
         var7 = this.k;
         if (!var1) {
            var1 = var4;
            if (!var2) {
               break label33;
            }
         }

         var1 = 0;
      }

      var7.setVisibility(var1);
      if (this.k.getParent() == null) {
         this.addView(this.k);
      }
   }

   public void a(ActionMode var1) {
      if (this.i == null) {
         this.i = LayoutInflater.from(this.getContext()).inflate(this.q, this, false);
         this.addView(this.i);
      } else if (this.i.getParent() == null) {
         this.addView(this.i);
      }

      this.i.findViewById(R.id.action_mode_close_button).setOnClickListener(new OnClickListener(this, var1) {
         final ActionMode a;
         final ActionBarContextView b;

         {
            this.b = var1;
            this.a = var2;
         }

         public void onClick(View var1) {
            this.a.c();
         }
      });
      MenuBuilder var3 = (MenuBuilder)var1.b();
      if (this.d != null) {
         this.d.h();
      }

      this.d = new ActionMenuPresenter(this.getContext());
      this.d.c(true);
      LayoutParams var2 = new LayoutParams(-2, -1);
      var3.a(this.d, this.b);
      this.c = (ActionMenuView)this.d.a(this);
      ViewCompat.a(this.c, null);
      this.addView(this.c, var2);
   }

   @Override
   public boolean a() {
      boolean var1;
      if (this.d != null) {
         var1 = this.d.f();
      } else {
         var1 = false;
      }

      return var1;
   }

   public void b() {
      if (this.i == null) {
         this.c();
      }
   }

   public void c() {
      this.removeAllViews();
      this.j = null;
      this.c = null;
   }

   public boolean d() {
      return this.p;
   }

   protected LayoutParams generateDefaultLayoutParams() {
      return new MarginLayoutParams(-1, -2);
   }

   public LayoutParams generateLayoutParams(AttributeSet var1) {
      return new MarginLayoutParams(this.getContext(), var1);
   }

   public CharSequence getSubtitle() {
      return this.h;
   }

   public CharSequence getTitle() {
      return this.g;
   }

   public void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if (this.d != null) {
         this.d.g();
         this.d.i();
      }
   }

   public void onInitializeAccessibilityEvent(AccessibilityEvent var1) {
      if (var1.getEventType() == 32) {
         var1.setSource(this);
         var1.setClassName(this.getClass().getName());
         var1.setPackageName(this.getContext().getPackageName());
         var1.setContentDescription(this.g);
      } else {
         super.onInitializeAccessibilityEvent(var1);
      }
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      var1 = ViewUtils.a(this);
      int var6;
      if (var1) {
         var6 = var4 - var2 - this.getPaddingRight();
      } else {
         var6 = this.getPaddingLeft();
      }

      int var7 = this.getPaddingTop();
      int var8 = var5 - var3 - this.getPaddingTop() - this.getPaddingBottom();
      if (this.i != null && this.i.getVisibility() != 8) {
         MarginLayoutParams var9 = (MarginLayoutParams)this.i.getLayoutParams();
         if (var1) {
            var3 = var9.rightMargin;
         } else {
            var3 = var9.leftMargin;
         }

         if (var1) {
            var5 = var9.leftMargin;
         } else {
            var5 = var9.rightMargin;
         }

         var3 = a(var6, var3, var1);
         var3 = a(this.a(this.i, var3, var7, var8, var1) + var3, var5, var1);
      } else {
         var3 = var6;
      }

      var5 = var3;
      if (this.k != null) {
         var5 = var3;
         if (this.j == null) {
            var5 = var3;
            if (this.k.getVisibility() != 8) {
               var5 = var3 + this.a(this.k, var3, var7, var8, var1);
            }
         }
      }

      if (this.j != null) {
         this.a(this.j, var5, var7, var8, var1);
      }

      if (var1) {
         var2 = this.getPaddingLeft();
      } else {
         var2 = var4 - var2 - this.getPaddingRight();
      }

      if (this.c != null) {
         ActionMenuView var18 = this.c;
         if (!var1) {
            var1 = true;
         } else {
            var1 = false;
         }

         this.a(var18, var2, var7, var8, var1);
      }
   }

   protected void onMeasure(int var1, int var2) {
      int var5 = 1073741824;
      byte var6 = 0;
      if (MeasureSpec.getMode(var1) != 1073741824) {
         throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
      }

      if (MeasureSpec.getMode(var2) == 0) {
         throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
      }

      int var8 = MeasureSpec.getSize(var1);
      int var3;
      if (this.e > 0) {
         var3 = this.e;
      } else {
         var3 = MeasureSpec.getSize(var2);
      }

      int var9 = this.getPaddingTop() + this.getPaddingBottom();
      var1 = var8 - this.getPaddingLeft() - this.getPaddingRight();
      int var7 = var3 - var9;
      int var4 = MeasureSpec.makeMeasureSpec(var7, Integer.MIN_VALUE);
      var2 = var1;
      if (this.i != null) {
         var1 = this.a(this.i, var1, var4, 0);
         MarginLayoutParams var11 = (MarginLayoutParams)this.i.getLayoutParams();
         var2 = var11.leftMargin;
         var2 = var1 - (var11.rightMargin + var2);
      }

      var1 = var2;
      if (this.c != null) {
         var1 = var2;
         if (this.c.getParent() == this) {
            var1 = this.a(this.c, var2, var4, 0);
         }
      }

      var2 = var1;
      if (this.k != null) {
         var2 = var1;
         if (this.j == null) {
            if (this.p) {
               var2 = MeasureSpec.makeMeasureSpec(0, 0);
               this.k.measure(var2, var4);
               int var10 = this.k.getMeasuredWidth();
               boolean var25;
               if (var10 <= var1) {
                  var25 = true;
               } else {
                  var25 = false;
               }

               var2 = var1;
               if (var25) {
                  var2 = var1 - var10;
               }

               LinearLayout var29 = this.k;
               byte var15;
               if (var25) {
                  var15 = 0;
               } else {
                  var15 = 8;
               }

               var29.setVisibility(var15);
            } else {
               var2 = this.a(this.k, var1, var4, 0);
            }
         }
      }

      if (this.j != null) {
         LayoutParams var30 = this.j.getLayoutParams();
         if (var30.width != -2) {
            var1 = 1073741824;
         } else {
            var1 = Integer.MIN_VALUE;
         }

         var4 = var2;
         if (var30.width >= 0) {
            var4 = Math.min(var30.width, var2);
         }

         if (var30.height != -2) {
            var2 = var5;
         } else {
            var2 = Integer.MIN_VALUE;
         }

         if (var30.height >= 0) {
            var5 = Math.min(var30.height, var7);
         } else {
            var5 = var7;
         }

         this.j.measure(MeasureSpec.makeMeasureSpec(var4, var1), MeasureSpec.makeMeasureSpec(var5, var2));
      }

      if (this.e <= 0) {
         var4 = this.getChildCount();
         var1 = 0;

         for (int var23 = var6; var23 < var4; var23++) {
            var3 = this.getChildAt(var23).getMeasuredHeight() + var9;
            if (var3 > var1) {
               var1 = var3;
            }
         }

         this.setMeasuredDimension(var8, var1);
      } else {
         this.setMeasuredDimension(var8, var3);
      }
   }

   @Override
   public void setContentHeight(int var1) {
      this.e = var1;
   }

   public void setCustomView(View var1) {
      if (this.j != null) {
         this.removeView(this.j);
      }

      this.j = var1;
      if (var1 != null && this.k != null) {
         this.removeView(this.k);
         this.k = null;
      }

      if (var1 != null) {
         this.addView(var1);
      }

      this.requestLayout();
   }

   public void setSubtitle(CharSequence var1) {
      this.h = var1;
      this.e();
   }

   public void setTitle(CharSequence var1) {
      this.g = var1;
      this.e();
   }

   public void setTitleOptional(boolean var1) {
      if (var1 != this.p) {
         this.requestLayout();
      }

      this.p = var1;
   }

   public boolean shouldDelayChildPressedState() {
      return false;
   }
}
