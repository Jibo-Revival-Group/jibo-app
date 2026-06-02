package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;

public class ActionMenuItem implements SupportMenuItem {
   private final int a;
   private final int b;
   private final int c;
   private final int d;
   private CharSequence e;
   private CharSequence f;
   private Intent g;
   private char h;
   private int i = 4096;
   private char j;
   private int k = 4096;
   private Drawable l;
   private int m = 0;
   private Context n;
   private OnMenuItemClickListener o;
   private CharSequence p;
   private CharSequence q;
   private ColorStateList r = null;
   private Mode s = null;
   private boolean t = false;
   private boolean u = false;
   private int v = 16;

   public ActionMenuItem(Context var1, int var2, int var3, int var4, int var5, CharSequence var6) {
      this.n = var1;
      this.a = var3;
      this.b = var2;
      this.c = var4;
      this.d = var5;
      this.e = var6;
   }

   private void b() {
      if (this.l != null && (this.t || this.u)) {
         this.l = DrawableCompat.g(this.l);
         this.l = this.l.mutate();
         if (this.t) {
            DrawableCompat.a(this.l, this.r);
         }

         if (this.u) {
            DrawableCompat.a(this.l, this.s);
         }
      }
   }

   public SupportMenuItem a(int var1) {
      throw new UnsupportedOperationException();
   }

   @Override
   public SupportMenuItem a(ActionProvider var1) {
      throw new UnsupportedOperationException();
   }

   public SupportMenuItem a(View var1) {
      throw new UnsupportedOperationException();
   }

   @Override
   public SupportMenuItem a(CharSequence var1) {
      this.p = var1;
      return this;
   }

   @Override
   public ActionProvider a() {
      return null;
   }

   public SupportMenuItem b(int var1) {
      this.setShowAsAction(var1);
      return this;
   }

   @Override
   public SupportMenuItem b(CharSequence var1) {
      this.q = var1;
      return this;
   }

   @Override
   public boolean collapseActionView() {
      return false;
   }

   @Override
   public boolean expandActionView() {
      return false;
   }

   public android.view.ActionProvider getActionProvider() {
      throw new UnsupportedOperationException();
   }

   @Override
   public View getActionView() {
      return null;
   }

   @Override
   public int getAlphabeticModifiers() {
      return this.k;
   }

   public char getAlphabeticShortcut() {
      return this.j;
   }

   @Override
   public CharSequence getContentDescription() {
      return this.p;
   }

   public int getGroupId() {
      return this.b;
   }

   public Drawable getIcon() {
      return this.l;
   }

   @Override
   public ColorStateList getIconTintList() {
      return this.r;
   }

   @Override
   public Mode getIconTintMode() {
      return this.s;
   }

   public Intent getIntent() {
      return this.g;
   }

   public int getItemId() {
      return this.a;
   }

   public ContextMenuInfo getMenuInfo() {
      return null;
   }

   @Override
   public int getNumericModifiers() {
      return this.i;
   }

   public char getNumericShortcut() {
      return this.h;
   }

   public int getOrder() {
      return this.d;
   }

   public SubMenu getSubMenu() {
      return null;
   }

   public CharSequence getTitle() {
      return this.e;
   }

   public CharSequence getTitleCondensed() {
      CharSequence var1;
      if (this.f != null) {
         var1 = this.f;
      } else {
         var1 = this.e;
      }

      return var1;
   }

   @Override
   public CharSequence getTooltipText() {
      return this.q;
   }

   public boolean hasSubMenu() {
      return false;
   }

   @Override
   public boolean isActionViewExpanded() {
      return false;
   }

   public boolean isCheckable() {
      boolean var1;
      if ((this.v & 1) != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean isChecked() {
      boolean var1;
      if ((this.v & 2) != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean isEnabled() {
      boolean var1;
      if ((this.v & 16) != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean isVisible() {
      boolean var1;
      if ((this.v & 8) == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public MenuItem setActionProvider(android.view.ActionProvider var1) {
      throw new UnsupportedOperationException();
   }

   public MenuItem setAlphabeticShortcut(char var1) {
      this.j = Character.toLowerCase(var1);
      return this;
   }

   @Override
   public MenuItem setAlphabeticShortcut(char var1, int var2) {
      this.j = Character.toLowerCase(var1);
      this.k = KeyEvent.normalizeMetaState(var2);
      return this;
   }

   public MenuItem setCheckable(boolean var1) {
      int var3 = this.v;
      byte var2;
      if (var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      this.v = var2 | var3 & -2;
      return this;
   }

   public MenuItem setChecked(boolean var1) {
      int var3 = this.v;
      byte var2;
      if (var1) {
         var2 = 2;
      } else {
         var2 = 0;
      }

      this.v = var2 | var3 & -3;
      return this;
   }

   public MenuItem setEnabled(boolean var1) {
      int var3 = this.v;
      byte var2;
      if (var1) {
         var2 = 16;
      } else {
         var2 = 0;
      }

      this.v = var2 | var3 & -17;
      return this;
   }

   public MenuItem setIcon(int var1) {
      this.m = var1;
      this.l = ContextCompat.a(this.n, var1);
      this.b();
      return this;
   }

   public MenuItem setIcon(Drawable var1) {
      this.l = var1;
      this.m = 0;
      this.b();
      return this;
   }

   @Override
   public MenuItem setIconTintList(ColorStateList var1) {
      this.r = var1;
      this.t = true;
      this.b();
      return this;
   }

   @Override
   public MenuItem setIconTintMode(Mode var1) {
      this.s = var1;
      this.u = true;
      this.b();
      return this;
   }

   public MenuItem setIntent(Intent var1) {
      this.g = var1;
      return this;
   }

   public MenuItem setNumericShortcut(char var1) {
      this.h = var1;
      return this;
   }

   @Override
   public MenuItem setNumericShortcut(char var1, int var2) {
      this.h = var1;
      this.i = KeyEvent.normalizeMetaState(var2);
      return this;
   }

   public MenuItem setOnActionExpandListener(OnActionExpandListener var1) {
      throw new UnsupportedOperationException();
   }

   public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener var1) {
      this.o = var1;
      return this;
   }

   public MenuItem setShortcut(char var1, char var2) {
      this.h = var1;
      this.j = Character.toLowerCase(var2);
      return this;
   }

   @Override
   public MenuItem setShortcut(char var1, char var2, int var3, int var4) {
      this.h = var1;
      this.i = KeyEvent.normalizeMetaState(var3);
      this.j = Character.toLowerCase(var2);
      this.k = KeyEvent.normalizeMetaState(var4);
      return this;
   }

   @Override
   public void setShowAsAction(int var1) {
   }

   public MenuItem setTitle(int var1) {
      this.e = this.n.getResources().getString(var1);
      return this;
   }

   public MenuItem setTitle(CharSequence var1) {
      this.e = var1;
      return this;
   }

   public MenuItem setTitleCondensed(CharSequence var1) {
      this.f = var1;
      return this;
   }

   public MenuItem setVisible(boolean var1) {
      int var3 = this.v;
      byte var2;
      if (var1) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      this.v = var2 | var3 & 8;
      return this;
   }
}
