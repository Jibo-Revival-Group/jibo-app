package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.design.R;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.TooltipCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.FrameLayout.LayoutParams;

public class BottomNavigationItemView extends FrameLayout implements MenuView.ItemView {
   private static final int[] a = new int[]{16842912};
   private final int b;
   private final int c;
   private final float d;
   private final float e;
   private boolean f;
   private ImageView g;
   private final TextView h;
   private final TextView i;
   private int j = -1;
   private MenuItemImpl k;
   private ColorStateList l;

   public BottomNavigationItemView(Context var1) {
      this(var1, null);
   }

   public BottomNavigationItemView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public BottomNavigationItemView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      Resources var5 = this.getResources();
      var3 = var5.getDimensionPixelSize(R.dimen.design_bottom_navigation_text_size);
      int var4 = var5.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_text_size);
      this.b = var5.getDimensionPixelSize(R.dimen.design_bottom_navigation_margin);
      this.c = var3 - var4;
      this.d = var4 * 1.0F / var3;
      this.e = var3 * 1.0F / var4;
      LayoutInflater.from(var1).inflate(R.layout.design_bottom_navigation_item, this, true);
      this.setBackgroundResource(R.drawable.design_bottom_navigation_item_background);
      this.g = (ImageView)this.findViewById(R.id.icon);
      this.h = (TextView)this.findViewById(R.id.smallLabel);
      this.i = (TextView)this.findViewById(R.id.largeLabel);
   }

   @Override
   public void a(MenuItemImpl var1, int var2) {
      this.k = var1;
      this.setCheckable(var1.isCheckable());
      this.setChecked(var1.isChecked());
      this.setEnabled(var1.isEnabled());
      this.setIcon(var1.getIcon());
      this.setTitle(var1.getTitle());
      this.setId(var1.getItemId());
      this.setContentDescription(var1.getContentDescription());
      TooltipCompat.a(this, var1.getTooltipText());
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public MenuItemImpl getItemData() {
      return this.k;
   }

   public int getItemPosition() {
      return this.j;
   }

   public int[] onCreateDrawableState(int var1) {
      int[] var2 = super.onCreateDrawableState(var1 + 1);
      if (this.k != null && this.k.isCheckable() && this.k.isChecked()) {
         mergeDrawableStates(var2, a);
      }

      return var2;
   }

   public void setCheckable(boolean var1) {
      this.refreshDrawableState();
   }

   public void setChecked(boolean var1) {
      this.i.setPivotX(this.i.getWidth() / 2);
      this.i.setPivotY(this.i.getBaseline());
      this.h.setPivotX(this.h.getWidth() / 2);
      this.h.setPivotY(this.h.getBaseline());
      if (this.f) {
         if (var1) {
            LayoutParams var2 = (LayoutParams)this.g.getLayoutParams();
            var2.gravity = 49;
            var2.topMargin = this.b;
            this.g.setLayoutParams(var2);
            this.i.setVisibility(0);
            this.i.setScaleX(1.0F);
            this.i.setScaleY(1.0F);
         } else {
            LayoutParams var3 = (LayoutParams)this.g.getLayoutParams();
            var3.gravity = 17;
            var3.topMargin = this.b;
            this.g.setLayoutParams(var3);
            this.i.setVisibility(4);
            this.i.setScaleX(0.5F);
            this.i.setScaleY(0.5F);
         }

         this.h.setVisibility(4);
      } else if (var1) {
         LayoutParams var4 = (LayoutParams)this.g.getLayoutParams();
         var4.gravity = 49;
         var4.topMargin = this.b + this.c;
         this.g.setLayoutParams(var4);
         this.i.setVisibility(0);
         this.h.setVisibility(4);
         this.i.setScaleX(1.0F);
         this.i.setScaleY(1.0F);
         this.h.setScaleX(this.d);
         this.h.setScaleY(this.d);
      } else {
         LayoutParams var5 = (LayoutParams)this.g.getLayoutParams();
         var5.gravity = 49;
         var5.topMargin = this.b;
         this.g.setLayoutParams(var5);
         this.i.setVisibility(4);
         this.h.setVisibility(0);
         this.i.setScaleX(this.e);
         this.i.setScaleY(this.e);
         this.h.setScaleX(1.0F);
         this.h.setScaleY(1.0F);
      }

      this.refreshDrawableState();
   }

   public void setEnabled(boolean var1) {
      super.setEnabled(var1);
      this.h.setEnabled(var1);
      this.i.setEnabled(var1);
      this.g.setEnabled(var1);
      if (var1) {
         ViewCompat.a(this, PointerIconCompat.a(this.getContext(), 1002));
      } else {
         ViewCompat.a(this, null);
      }
   }

   public void setIcon(Drawable var1) {
      Drawable var2 = var1;
      if (var1 != null) {
         ConstantState var3 = var1.getConstantState();
         if (var3 != null) {
            var1 = var3.newDrawable();
         }

         var2 = DrawableCompat.g(var1).mutate();
         DrawableCompat.a(var2, this.l);
      }

      this.g.setImageDrawable(var2);
   }

   public void setIconTintList(ColorStateList var1) {
      this.l = var1;
      if (this.k != null) {
         this.setIcon(this.k.getIcon());
      }
   }

   public void setItemBackground(int var1) {
      Drawable var2;
      if (var1 == 0) {
         var2 = null;
      } else {
         var2 = ContextCompat.a(this.getContext(), var1);
      }

      ViewCompat.a(this, var2);
   }

   public void setItemPosition(int var1) {
      this.j = var1;
   }

   public void setShiftingMode(boolean var1) {
      this.f = var1;
   }

   public void setTextColor(ColorStateList var1) {
      this.h.setTextColor(var1);
      this.i.setTextColor(var1);
   }

   public void setTitle(CharSequence var1) {
      this.h.setText(var1);
      this.i.setText(var1);
   }
}
