package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.appcompat.R;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ForwardingListener;
import android.support.v7.widget.TooltipCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;

public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, ActionMenuView.ActionMenuChildView, OnClickListener {
   MenuItemImpl b;
   MenuBuilder.ItemInvoker c;
   ActionMenuItemView.PopupCallback d;
   private CharSequence e;
   private Drawable f;
   private ForwardingListener g;
   private boolean h;
   private boolean i;
   private int j;
   private int k;
   private int l;

   public ActionMenuItemView(Context var1) {
      this(var1, null);
   }

   public ActionMenuItemView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public ActionMenuItemView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      Resources var4 = var1.getResources();
      this.h = this.e();
      TypedArray var5 = var1.obtainStyledAttributes(var2, R.styleable.ActionMenuItemView, var3, 0);
      this.j = var5.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
      var5.recycle();
      this.l = (int)(var4.getDisplayMetrics().density * 32.0F + 0.5F);
      this.setOnClickListener(this);
      this.k = -1;
      this.setSaveEnabled(false);
   }

   private boolean e() {
      Configuration var4 = this.getContext().getResources().getConfiguration();
      int var1 = var4.screenWidthDp;
      int var2 = var4.screenHeightDp;
      boolean var3;
      if (var1 < 480 && (var1 < 640 || var2 < 480) && var4.orientation != 2) {
         var3 = false;
      } else {
         var3 = true;
      }

      return var3;
   }

   private void f() {
      boolean var3 = false;
      Object var5 = null;
      boolean var1;
      if (!TextUtils.isEmpty(this.e)) {
         var1 = true;
      } else {
         var1 = false;
      }

      boolean var2;
      label45: {
         if (this.f != null) {
            var2 = var3;
            if (!this.b.m()) {
               break label45;
            }

            if (!this.h) {
               var2 = var3;
               if (!this.i) {
                  break label45;
               }
            }
         }

         var2 = true;
      }

      var1 &= var2;
      CharSequence var4;
      if (var1) {
         var4 = this.e;
      } else {
         var4 = null;
      }

      this.setText(var4);
      var4 = this.b.getContentDescription();
      if (TextUtils.isEmpty(var4)) {
         if (var1) {
            var4 = null;
         } else {
            var4 = this.b.getTitle();
         }

         this.setContentDescription(var4);
      } else {
         this.setContentDescription(var4);
      }

      var4 = this.b.getTooltipText();
      if (TextUtils.isEmpty(var4)) {
         if (var1) {
            var4 = (CharSequence)var5;
         } else {
            var4 = this.b.getTitle();
         }

         TooltipCompat.a(this, var4);
      } else {
         TooltipCompat.a(this, var4);
      }
   }

   @Override
   public void a(MenuItemImpl var1, int var2) {
      this.b = var1;
      this.setIcon(var1.getIcon());
      this.setTitle(var1.a(this));
      this.setId(var1.getItemId());
      byte var3;
      if (var1.isVisible()) {
         var3 = 0;
      } else {
         var3 = 8;
      }

      this.setVisibility(var3);
      this.setEnabled(var1.isEnabled());
      if (var1.hasSubMenu() && this.g == null) {
         this.g = new ActionMenuItemView.ActionMenuItemForwardingListener(this);
      }
   }

   @Override
   public boolean a() {
      return true;
   }

   public boolean b() {
      boolean var1;
      if (!TextUtils.isEmpty(this.getText())) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public boolean c() {
      boolean var1;
      if (this.b() && this.b.getIcon() == null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public boolean d() {
      return this.b();
   }

   @Override
   public MenuItemImpl getItemData() {
      return this.b;
   }

   public void onClick(View var1) {
      if (this.c != null) {
         this.c.a(this.b);
      }
   }

   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      this.h = this.e();
      this.f();
   }

   protected void onMeasure(int var1, int var2) {
      boolean var5 = this.b();
      if (var5 && this.k >= 0) {
         super.setPadding(this.k, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
      }

      super.onMeasure(var1, var2);
      int var3 = MeasureSpec.getMode(var1);
      var1 = MeasureSpec.getSize(var1);
      int var4 = this.getMeasuredWidth();
      if (var3 == Integer.MIN_VALUE) {
         var1 = Math.min(var1, this.j);
      } else {
         var1 = this.j;
      }

      if (var3 != 1073741824 && this.j > 0 && var4 < var1) {
         super.onMeasure(MeasureSpec.makeMeasureSpec(var1, 1073741824), var2);
      }

      if (!var5 && this.f != null) {
         super.setPadding((this.getMeasuredWidth() - this.f.getBounds().width()) / 2, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
      }
   }

   public void onRestoreInstanceState(Parcelable var1) {
      super.onRestoreInstanceState(null);
   }

   public boolean onTouchEvent(MotionEvent var1) {
      boolean var2;
      if (this.b.hasSubMenu() && this.g != null && this.g.onTouch(this, var1)) {
         var2 = true;
      } else {
         var2 = super.onTouchEvent(var1);
      }

      return var2;
   }

   public void setCheckable(boolean var1) {
   }

   public void setChecked(boolean var1) {
   }

   public void setExpandedFormat(boolean var1) {
      if (this.i != var1) {
         this.i = var1;
         if (this.b != null) {
            this.b.h();
         }
      }
   }

   public void setIcon(Drawable var1) {
      this.f = var1;
      if (var1 != null) {
         int var6 = var1.getIntrinsicWidth();
         int var5 = var1.getIntrinsicHeight();
         int var4 = var5;
         int var3 = var6;
         if (var6 > this.l) {
            float var2 = (float)this.l / var6;
            var3 = this.l;
            var4 = (int)(var5 * var2);
         }

         var6 = var4;
         var5 = var3;
         if (var4 > this.l) {
            float var7 = (float)this.l / var4;
            var6 = this.l;
            var5 = (int)(var3 * var7);
         }

         var1.setBounds(0, 0, var5, var6);
      }

      this.setCompoundDrawables(var1, null, null, null);
      this.f();
   }

   public void setItemInvoker(MenuBuilder.ItemInvoker var1) {
      this.c = var1;
   }

   public void setPadding(int var1, int var2, int var3, int var4) {
      this.k = var1;
      super.setPadding(var1, var2, var3, var4);
   }

   public void setPopupCallback(ActionMenuItemView.PopupCallback var1) {
      this.d = var1;
   }

   public void setTitle(CharSequence var1) {
      this.e = var1;
      this.f();
   }

   private class ActionMenuItemForwardingListener extends ForwardingListener {
      final ActionMenuItemView a;

      public ActionMenuItemForwardingListener(ActionMenuItemView var1) {
         super(var1);
         this.a = var1;
      }

      @Override
      public ShowableListMenu a() {
         ShowableListMenu var1;
         if (this.a.d != null) {
            var1 = this.a.d.a();
         } else {
            var1 = null;
         }

         return var1;
      }

      @Override
      protected boolean b() {
         boolean var2 = false;
         boolean var1 = var2;
         if (this.a.c != null) {
            var1 = var2;
            if (this.a.c.a(this.a.b)) {
               ShowableListMenu var3 = this.a();
               var1 = var2;
               if (var3 != null) {
                  var1 = var2;
                  if (var3.f()) {
                     var1 = true;
                  }
               }
            }
         }

         return var1;
      }
   }

   public abstract static class PopupCallback {
      public abstract ShowableListMenu a();
   }
}
