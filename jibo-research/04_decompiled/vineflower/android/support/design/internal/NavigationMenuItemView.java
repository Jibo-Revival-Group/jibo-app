package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.design.R;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.TooltipCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {
   private static final int[] d = new int[]{16842912};
   boolean c;
   private final int e;
   private boolean f;
   private final CheckedTextView g;
   private FrameLayout h;
   private MenuItemImpl i;
   private ColorStateList j;
   private boolean k;
   private Drawable l;
   private final AccessibilityDelegateCompat m = new AccessibilityDelegateCompat(this) {
      final NavigationMenuItemView a;

      {
         this.a = var1;
      }

      @Override
      public void a(View var1, AccessibilityNodeInfoCompat var2) {
         super.a(var1, var2);
         var2.a(this.a.c);
      }
   };

   public NavigationMenuItemView(Context var1) {
      this(var1, null);
   }

   public NavigationMenuItemView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public NavigationMenuItemView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.setOrientation(0);
      LayoutInflater.from(var1).inflate(R.layout.design_navigation_menu_item, this, true);
      this.e = var1.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size);
      this.g = (CheckedTextView)this.findViewById(R.id.design_menu_item_text);
      this.g.setDuplicateParentStateEnabled(true);
      ViewCompat.a(this.g, this.m);
   }

   private boolean c() {
      boolean var1;
      if (this.i.getTitle() == null && this.i.getIcon() == null && this.i.getActionView() != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private void d() {
      if (this.c()) {
         this.g.setVisibility(8);
         if (this.h != null) {
            LinearLayoutCompat.LayoutParams var1 = (LinearLayoutCompat.LayoutParams)this.h.getLayoutParams();
            var1.width = -1;
            this.h.setLayoutParams(var1);
         }
      } else {
         this.g.setVisibility(0);
         if (this.h != null) {
            LinearLayoutCompat.LayoutParams var2 = (LinearLayoutCompat.LayoutParams)this.h.getLayoutParams();
            var2.width = -2;
            this.h.setLayoutParams(var2);
         }
      }
   }

   private StateListDrawable e() {
      TypedValue var2 = new TypedValue();
      StateListDrawable var1;
      if (this.getContext().getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.colorControlHighlight, var2, true)) {
         var1 = new StateListDrawable();
         var1.addState(d, new ColorDrawable(var2.data));
         var1.addState(EMPTY_STATE_SET, new ColorDrawable(0));
      } else {
         var1 = null;
      }

      return var1;
   }

   private void setActionView(View var1) {
      if (var1 != null) {
         if (this.h == null) {
            this.h = (FrameLayout)((ViewStub)this.findViewById(R.id.design_menu_item_action_area_stub)).inflate();
         }

         this.h.removeAllViews();
         this.h.addView(var1);
      }
   }

   @Override
   public void a(MenuItemImpl var1, int var2) {
      this.i = var1;
      byte var3;
      if (var1.isVisible()) {
         var3 = 0;
      } else {
         var3 = 8;
      }

      this.setVisibility(var3);
      if (this.getBackground() == null) {
         ViewCompat.a(this, this.e());
      }

      this.setCheckable(var1.isCheckable());
      this.setChecked(var1.isChecked());
      this.setEnabled(var1.isEnabled());
      this.setTitle(var1.getTitle());
      this.setIcon(var1.getIcon());
      this.setActionView(var1.getActionView());
      this.setContentDescription(var1.getContentDescription());
      TooltipCompat.a(this, var1.getTooltipText());
      this.d();
   }

   @Override
   public boolean a() {
      return false;
   }

   public void b() {
      if (this.h != null) {
         this.h.removeAllViews();
      }

      this.g.setCompoundDrawables(null, null, null, null);
   }

   @Override
   public MenuItemImpl getItemData() {
      return this.i;
   }

   protected int[] onCreateDrawableState(int var1) {
      int[] var2 = super.onCreateDrawableState(var1 + 1);
      if (this.i != null && this.i.isCheckable() && this.i.isChecked()) {
         mergeDrawableStates(var2, d);
      }

      return var2;
   }

   public void setCheckable(boolean var1) {
      this.refreshDrawableState();
      if (this.c != var1) {
         this.c = var1;
         this.m.a(this.g, 2048);
      }
   }

   public void setChecked(boolean var1) {
      this.refreshDrawableState();
      this.g.setChecked(var1);
   }

   public void setIcon(Drawable var1) {
      if (var1 != null) {
         Drawable var2 = var1;
         if (this.k) {
            ConstantState var3 = var1.getConstantState();
            if (var3 != null) {
               var1 = var3.newDrawable();
            }

            var2 = DrawableCompat.g(var1).mutate();
            DrawableCompat.a(var2, this.j);
         }

         var2.setBounds(0, 0, this.e, this.e);
         var1 = var2;
      } else if (this.f) {
         if (this.l == null) {
            this.l = ResourcesCompat.a(this.getResources(), R.drawable.navigation_empty_icon, this.getContext().getTheme());
            if (this.l != null) {
               this.l.setBounds(0, 0, this.e, this.e);
            }
         }

         var1 = this.l;
      }

      TextViewCompat.a(this.g, var1, null, null, null);
   }

   void setIconTintList(ColorStateList var1) {
      this.j = var1;
      boolean var2;
      if (this.j != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.k = var2;
      if (this.i != null) {
         this.setIcon(this.i.getIcon());
      }
   }

   public void setNeedsEmptyIcon(boolean var1) {
      this.f = var1;
   }

   public void setTextAppearance(int var1) {
      TextViewCompat.a(this.g, var1);
   }

   public void setTextColor(ColorStateList var1) {
      this.g.setTextColor(var1);
   }

   public void setTitle(CharSequence var1) {
      this.g.setText(var1);
   }
}
