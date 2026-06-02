package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements MenuView.ItemView {
   private MenuItemImpl a;
   private ImageView b;
   private RadioButton c;
   private TextView d;
   private CheckBox e;
   private TextView f;
   private ImageView g;
   private Drawable h;
   private int i;
   private Context j;
   private boolean k;
   private Drawable l;
   private int m;
   private LayoutInflater n;
   private boolean o;

   public ListMenuItemView(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.listMenuViewStyle);
   }

   public ListMenuItemView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2);
      TintTypedArray var4 = TintTypedArray.a(this.getContext(), var2, R.styleable.MenuView, var3, 0);
      this.h = var4.a(R.styleable.MenuView_android_itemBackground);
      this.i = var4.g(R.styleable.MenuView_android_itemTextAppearance, -1);
      this.k = var4.a(R.styleable.MenuView_preserveIconSpacing, false);
      this.j = var1;
      this.l = var4.a(R.styleable.MenuView_subMenuArrow);
      var4.a();
   }

   private void b() {
      this.b = (ImageView)this.getInflater().inflate(R.layout.abc_list_menu_item_icon, this, false);
      this.addView(this.b, 0);
   }

   private void c() {
      this.c = (RadioButton)this.getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false);
      this.addView(this.c);
   }

   private void d() {
      this.e = (CheckBox)this.getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false);
      this.addView(this.e);
   }

   private LayoutInflater getInflater() {
      if (this.n == null) {
         this.n = LayoutInflater.from(this.getContext());
      }

      return this.n;
   }

   private void setSubMenuArrowVisible(boolean var1) {
      if (this.g != null) {
         ImageView var3 = this.g;
         byte var2;
         if (var1) {
            var2 = 0;
         } else {
            var2 = 8;
         }

         var3.setVisibility(var2);
      }
   }

   @Override
   public void a(MenuItemImpl var1, int var2) {
      this.a = var1;
      this.m = var2;
      byte var3;
      if (var1.isVisible()) {
         var3 = 0;
      } else {
         var3 = 8;
      }

      this.setVisibility(var3);
      this.setTitle(var1.a(this));
      this.setCheckable(var1.isCheckable());
      this.a(var1.f(), var1.d());
      this.setIcon(var1.getIcon());
      this.setEnabled(var1.isEnabled());
      this.setSubMenuArrowVisible(var1.hasSubMenu());
      this.setContentDescription(var1.getContentDescription());
   }

   public void a(boolean var1, char var2) {
      byte var3;
      if (var1 && this.a.f()) {
         var3 = 0;
      } else {
         var3 = 8;
      }

      if (var3 == 0) {
         this.f.setText(this.a.e());
      }

      if (this.f.getVisibility() != var3) {
         this.f.setVisibility(var3);
      }
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public MenuItemImpl getItemData() {
      return this.a;
   }

   protected void onFinishInflate() {
      super.onFinishInflate();
      ViewCompat.a(this, this.h);
      this.d = (TextView)this.findViewById(R.id.title);
      if (this.i != -1) {
         this.d.setTextAppearance(this.j, this.i);
      }

      this.f = (TextView)this.findViewById(R.id.shortcut);
      this.g = (ImageView)this.findViewById(R.id.submenuarrow);
      if (this.g != null) {
         this.g.setImageDrawable(this.l);
      }
   }

   protected void onMeasure(int var1, int var2) {
      if (this.b != null && this.k) {
         LayoutParams var3 = this.getLayoutParams();
         android.widget.LinearLayout.LayoutParams var4 = (android.widget.LinearLayout.LayoutParams)this.b.getLayoutParams();
         if (var3.height > 0 && var4.width <= 0) {
            var4.width = var3.height;
         }
      }

      super.onMeasure(var1, var2);
   }

   public void setCheckable(boolean var1) {
      if (var1 || this.c != null || this.e != null) {
         Object var3;
         Object var4;
         if (this.a.g()) {
            if (this.c == null) {
               this.c();
            }

            var3 = this.c;
            var4 = this.e;
         } else {
            if (this.e == null) {
               this.d();
            }

            var3 = this.e;
            var4 = this.c;
         }

         if (var1) {
            var3.setChecked(this.a.isChecked());
            byte var2;
            if (var1) {
               var2 = 0;
            } else {
               var2 = 8;
            }

            if (var3.getVisibility() != var2) {
               var3.setVisibility(var2);
            }

            if (var4 != null && var4.getVisibility() != 8) {
               var4.setVisibility(8);
            }
         } else {
            if (this.e != null) {
               this.e.setVisibility(8);
            }

            if (this.c != null) {
               this.c.setVisibility(8);
            }
         }
      }
   }

   public void setChecked(boolean var1) {
      Object var2;
      if (this.a.g()) {
         if (this.c == null) {
            this.c();
         }

         var2 = this.c;
      } else {
         if (this.e == null) {
            this.d();
         }

         var2 = this.e;
      }

      var2.setChecked(var1);
   }

   public void setForceShowIcon(boolean var1) {
      this.o = var1;
      this.k = var1;
   }

   public void setIcon(Drawable var1) {
      boolean var2;
      if (!this.a.i() && !this.o) {
         var2 = false;
      } else {
         var2 = true;
      }

      if ((var2 || this.k) && (this.b != null || var1 != null || this.k)) {
         if (this.b == null) {
            this.b();
         }

         if (var1 == null && !this.k) {
            this.b.setVisibility(8);
         } else {
            ImageView var3 = this.b;
            if (!var2) {
               var1 = null;
            }

            var3.setImageDrawable(var1);
            if (this.b.getVisibility() != 0) {
               this.b.setVisibility(0);
            }
         }
      }
   }

   public void setTitle(CharSequence var1) {
      if (var1 != null) {
         this.d.setText(var1);
         if (this.d.getVisibility() != 0) {
            this.d.setVisibility(0);
         }
      } else if (this.d.getVisibility() != 8) {
         this.d.setVisibility(8);
      }
   }
}
