package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v7.content.res.AppCompatResources;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class MenuItemImpl implements SupportMenuItem {
   private static String F;
   private static String G;
   private static String H;
   private static String I;
   private View A;
   private ActionProvider B;
   private OnActionExpandListener C;
   private boolean D;
   private ContextMenuInfo E;
   MenuBuilder a;
   private final int b;
   private final int c;
   private final int d;
   private final int e;
   private CharSequence f;
   private CharSequence g;
   private Intent h;
   private char i;
   private int j = 4096;
   private char k;
   private int l = 4096;
   private Drawable m;
   private int n = 0;
   private SubMenuBuilder o;
   private Runnable p;
   private OnMenuItemClickListener q;
   private CharSequence r;
   private CharSequence s;
   private ColorStateList t = null;
   private Mode u = null;
   private boolean v = false;
   private boolean w = false;
   private boolean x = false;
   private int y = 16;
   private int z = 0;

   MenuItemImpl(MenuBuilder var1, int var2, int var3, int var4, int var5, CharSequence var6, int var7) {
      this.D = false;
      this.a = var1;
      this.b = var3;
      this.c = var2;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      this.z = var7;
   }

   private Drawable a(Drawable var1) {
      Drawable var2 = var1;
      if (var1 != null) {
         var2 = var1;
         if (this.x) {
            if (!this.v) {
               var2 = var1;
               if (!this.w) {
                  return var2;
               }
            }

            var2 = DrawableCompat.g(var1).mutate();
            if (this.v) {
               DrawableCompat.a(var2, this.t);
            }

            if (this.w) {
               DrawableCompat.a(var2, this.u);
            }

            this.x = false;
         }
      }

      return var2;
   }

   public SupportMenuItem a(int var1) {
      Context var2 = this.a.e();
      this.a(LayoutInflater.from(var2).inflate(var1, new LinearLayout(var2), false));
      return this;
   }

   @Override
   public SupportMenuItem a(ActionProvider var1) {
      if (this.B != null) {
         this.B.f();
      }

      this.A = null;
      this.B = var1;
      this.a.a(true);
      if (this.B != null) {
         this.B.a(new ActionProvider.VisibilityListener(this) {
            final MenuItemImpl a;

            {
               this.a = var1;
            }

            @Override
            public void a(boolean var1) {
               this.a.a.a(this.a);
            }
         });
      }

      return this;
   }

   public SupportMenuItem a(View var1) {
      this.A = var1;
      this.B = null;
      if (var1 != null && var1.getId() == -1 && this.b > 0) {
         var1.setId(this.b);
      }

      this.a.b(this);
      return this;
   }

   @Override
   public SupportMenuItem a(CharSequence var1) {
      this.r = var1;
      this.a.a(false);
      return this;
   }

   @Override
   public ActionProvider a() {
      return this.B;
   }

   CharSequence a(MenuView.ItemView var1) {
      CharSequence var2;
      if (var1 != null && var1.a()) {
         var2 = this.getTitleCondensed();
      } else {
         var2 = this.getTitle();
      }

      return var2;
   }

   public void a(SubMenuBuilder var1) {
      this.o = var1;
      var1.setHeaderTitle(this.getTitle());
   }

   void a(ContextMenuInfo var1) {
      this.E = var1;
   }

   public void a(boolean var1) {
      int var3 = this.y;
      byte var2;
      if (var1) {
         var2 = 4;
      } else {
         var2 = 0;
      }

      this.y = var2 | var3 & -5;
   }

   public SupportMenuItem b(int var1) {
      this.setShowAsAction(var1);
      return this;
   }

   @Override
   public SupportMenuItem b(CharSequence var1) {
      this.s = var1;
      this.a.a(false);
      return this;
   }

   void b(boolean var1) {
      int var3 = this.y;
      int var4 = this.y;
      byte var2;
      if (var1) {
         var2 = 2;
      } else {
         var2 = 0;
      }

      this.y = var2 | var4 & -3;
      if (var3 != this.y) {
         this.a.a(false);
      }
   }

   public boolean b() {
      boolean var2 = true;
      boolean var1;
      if (this.q != null && this.q.onMenuItemClick(this)) {
         var1 = var2;
      } else {
         var1 = var2;
         if (!this.a.a(this.a, this)) {
            if (this.p != null) {
               this.p.run();
               var1 = var2;
            } else {
               label28:
               if (this.h != null) {
                  try {
                     this.a.e().startActivity(this.h);
                  } catch (ActivityNotFoundException var4) {
                     Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", var4);
                     break label28;
                  }

                  var1 = var2;
                  return var1;
               }

               if (this.B != null) {
                  var1 = var2;
                  if (this.B.d()) {
                     return var1;
                  }
               }

               var1 = false;
            }
         }
      }

      return var1;
   }

   public int c() {
      return this.e;
   }

   boolean c(boolean var1) {
      boolean var5 = false;
      int var3 = this.y;
      int var4 = this.y;
      byte var2;
      if (var1) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      this.y = var2 | var4 & -9;
      var1 = var5;
      if (var3 != this.y) {
         var1 = true;
      }

      return var1;
   }

   @Override
   public boolean collapseActionView() {
      boolean var1 = false;
      if ((this.z & 8) != 0) {
         if (this.A == null) {
            var1 = true;
         } else if (this.C == null || this.C.onMenuItemActionCollapse(this)) {
            var1 = this.a.d(this);
         }
      }

      return var1;
   }

   char d() {
      char var1;
      if (this.a.b()) {
         var1 = this.k;
      } else {
         var1 = this.i;
      }

      return var1;
   }

   public void d(boolean var1) {
      if (var1) {
         this.y |= 32;
      } else {
         this.y &= -33;
      }
   }

   String e() {
      char var1 = this.d();
      String var2;
      if (var1 == 0) {
         var2 = "";
      } else {
         StringBuilder var3 = new StringBuilder(F);
         switch (var1) {
            case '\b':
               var3.append(H);
               break;
            case '\n':
               var3.append(G);
               break;
            case ' ':
               var3.append(I);
               break;
            default:
               var3.append(var1);
         }

         var2 = var3.toString();
      }

      return var2;
   }

   public void e(boolean var1) {
      this.D = var1;
      this.a.a(false);
   }

   @Override
   public boolean expandActionView() {
      boolean var1 = false;
      if (this.n() && (this.C == null || this.C.onMenuItemActionExpand(this))) {
         var1 = this.a.c(this);
      }

      return var1;
   }

   boolean f() {
      boolean var1;
      if (this.a.c() && this.d() != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean g() {
      boolean var1;
      if ((this.y & 4) != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public android.view.ActionProvider getActionProvider() {
      throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
   }

   @Override
   public View getActionView() {
      View var1;
      if (this.A != null) {
         var1 = this.A;
      } else if (this.B != null) {
         this.A = this.B.a(this);
         var1 = this.A;
      } else {
         var1 = null;
      }

      return var1;
   }

   @Override
   public int getAlphabeticModifiers() {
      return this.l;
   }

   public char getAlphabeticShortcut() {
      return this.k;
   }

   @Override
   public CharSequence getContentDescription() {
      return this.r;
   }

   public int getGroupId() {
      return this.c;
   }

   public Drawable getIcon() {
      Drawable var1;
      if (this.m != null) {
         var1 = this.a(this.m);
      } else if (this.n != 0) {
         var1 = AppCompatResources.b(this.a.e(), this.n);
         this.n = 0;
         this.m = var1;
         var1 = this.a(var1);
      } else {
         var1 = null;
      }

      return var1;
   }

   @Override
   public ColorStateList getIconTintList() {
      return this.t;
   }

   @Override
   public Mode getIconTintMode() {
      return this.u;
   }

   public Intent getIntent() {
      return this.h;
   }

   @CapturedViewProperty
   public int getItemId() {
      return this.b;
   }

   public ContextMenuInfo getMenuInfo() {
      return this.E;
   }

   @Override
   public int getNumericModifiers() {
      return this.j;
   }

   public char getNumericShortcut() {
      return this.i;
   }

   public int getOrder() {
      return this.d;
   }

   public SubMenu getSubMenu() {
      return this.o;
   }

   @CapturedViewProperty
   public CharSequence getTitle() {
      return this.f;
   }

   public CharSequence getTitleCondensed() {
      CharSequence var1;
      if (this.g != null) {
         var1 = this.g;
      } else {
         var1 = this.f;
      }

      CharSequence var2 = var1;
      if (VERSION.SDK_INT < 18) {
         var2 = var1;
         if (var1 != null) {
            var2 = var1;
            if (!(var1 instanceof String)) {
               var2 = var1.toString();
            }
         }
      }

      return var2;
   }

   @Override
   public CharSequence getTooltipText() {
      return this.s;
   }

   public void h() {
      this.a.b(this);
   }

   public boolean hasSubMenu() {
      boolean var1;
      if (this.o != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean i() {
      return this.a.q();
   }

   @Override
   public boolean isActionViewExpanded() {
      return this.D;
   }

   public boolean isCheckable() {
      boolean var1 = true;
      if ((this.y & 1) != 1) {
         var1 = false;
      }

      return var1;
   }

   public boolean isChecked() {
      boolean var1;
      if ((this.y & 2) == 2) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean isEnabled() {
      boolean var1;
      if ((this.y & 16) != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean isVisible() {
      boolean var1 = true;
      if (this.B != null && this.B.b()) {
         if ((this.y & 8) != 0 || !this.B.c()) {
            var1 = false;
         }
      } else if ((this.y & 8) != 0) {
         var1 = false;
      }

      return var1;
   }

   public boolean j() {
      boolean var1;
      if ((this.y & 32) == 32) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean k() {
      boolean var1 = true;
      if ((this.z & 1) != 1) {
         var1 = false;
      }

      return var1;
   }

   public boolean l() {
      boolean var1;
      if ((this.z & 2) == 2) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean m() {
      boolean var1;
      if ((this.z & 4) == 4) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean n() {
      boolean var2 = false;
      boolean var1 = var2;
      if ((this.z & 8) != 0) {
         if (this.A == null && this.B != null) {
            this.A = this.B.a(this);
         }

         var1 = var2;
         if (this.A != null) {
            var1 = true;
         }
      }

      return var1;
   }

   public MenuItem setActionProvider(android.view.ActionProvider var1) {
      throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
   }

   public MenuItem setAlphabeticShortcut(char var1) {
      if (this.k != var1) {
         this.k = Character.toLowerCase(var1);
         this.a.a(false);
      }

      return this;
   }

   @Override
   public MenuItem setAlphabeticShortcut(char var1, int var2) {
      if (this.k != var1 || this.l != var2) {
         this.k = Character.toLowerCase(var1);
         this.l = KeyEvent.normalizeMetaState(var2);
         this.a.a(false);
      }

      return this;
   }

   public MenuItem setCheckable(boolean var1) {
      int var3 = this.y;
      int var4 = this.y;
      byte var2;
      if (var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      this.y = var2 | var4 & -2;
      if (var3 != this.y) {
         this.a.a(false);
      }

      return this;
   }

   public MenuItem setChecked(boolean var1) {
      if ((this.y & 4) != 0) {
         this.a.a((MenuItem)this);
      } else {
         this.b(var1);
      }

      return this;
   }

   public MenuItem setEnabled(boolean var1) {
      if (var1) {
         this.y |= 16;
      } else {
         this.y &= -17;
      }

      this.a.a(false);
      return this;
   }

   public MenuItem setIcon(int var1) {
      this.m = null;
      this.n = var1;
      this.x = true;
      this.a.a(false);
      return this;
   }

   public MenuItem setIcon(Drawable var1) {
      this.n = 0;
      this.m = var1;
      this.x = true;
      this.a.a(false);
      return this;
   }

   @Override
   public MenuItem setIconTintList(ColorStateList var1) {
      this.t = var1;
      this.v = true;
      this.x = true;
      this.a.a(false);
      return this;
   }

   @Override
   public MenuItem setIconTintMode(Mode var1) {
      this.u = var1;
      this.w = true;
      this.x = true;
      this.a.a(false);
      return this;
   }

   public MenuItem setIntent(Intent var1) {
      this.h = var1;
      return this;
   }

   public MenuItem setNumericShortcut(char var1) {
      if (this.i != var1) {
         this.i = var1;
         this.a.a(false);
      }

      return this;
   }

   @Override
   public MenuItem setNumericShortcut(char var1, int var2) {
      if (this.i != var1 || this.j != var2) {
         this.i = var1;
         this.j = KeyEvent.normalizeMetaState(var2);
         this.a.a(false);
      }

      return this;
   }

   public MenuItem setOnActionExpandListener(OnActionExpandListener var1) {
      this.C = var1;
      return this;
   }

   public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener var1) {
      this.q = var1;
      return this;
   }

   public MenuItem setShortcut(char var1, char var2) {
      this.i = var1;
      this.k = Character.toLowerCase(var2);
      this.a.a(false);
      return this;
   }

   @Override
   public MenuItem setShortcut(char var1, char var2, int var3, int var4) {
      this.i = var1;
      this.j = KeyEvent.normalizeMetaState(var3);
      this.k = Character.toLowerCase(var2);
      this.l = KeyEvent.normalizeMetaState(var4);
      this.a.a(false);
      return this;
   }

   @Override
   public void setShowAsAction(int var1) {
      switch (var1 & 3) {
         case 0:
         case 1:
         case 2:
            this.z = var1;
            this.a.b(this);
            return;
         default:
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
      }
   }

   public MenuItem setTitle(int var1) {
      return this.setTitle(this.a.e().getString(var1));
   }

   public MenuItem setTitle(CharSequence var1) {
      this.f = var1;
      this.a.a(false);
      if (this.o != null) {
         this.o.setHeaderTitle(var1);
      }

      return this;
   }

   public MenuItem setTitleCondensed(CharSequence var1) {
      this.g = var1;
      if (var1 == null) {
         var1 = this.f;
      }

      this.a.a(false);
      return this;
   }

   public MenuItem setVisible(boolean var1) {
      if (this.c(var1)) {
         this.a.a(this);
      }

      return this;
   }

   @Override
   public String toString() {
      String var1;
      if (this.f != null) {
         var1 = this.f.toString();
      } else {
         var1 = null;
      }

      return var1;
   }
}
