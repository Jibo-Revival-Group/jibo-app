package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {
   private Context a;
   private ActionBarContextView b;
   private ActionMode.Callback c;
   private WeakReference<View> d;
   private boolean e;
   private boolean f;
   private MenuBuilder g;

   public StandaloneActionMode(Context var1, ActionBarContextView var2, ActionMode.Callback var3, boolean var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.g = new MenuBuilder(var2.getContext()).a(1);
      this.g.a(this);
      this.f = var4;
   }

   @Override
   public MenuInflater a() {
      return new SupportMenuInflater(this.b.getContext());
   }

   @Override
   public void a(int var1) {
      this.b(this.a.getString(var1));
   }

   @Override
   public void a(MenuBuilder var1) {
      this.d();
      this.b.a();
   }

   @Override
   public void a(View var1) {
      this.b.setCustomView(var1);
      WeakReference var2;
      if (var1 != null) {
         var2 = new WeakReference<>(var1);
      } else {
         var2 = null;
      }

      this.d = var2;
   }

   @Override
   public void a(CharSequence var1) {
      this.b.setSubtitle(var1);
   }

   @Override
   public void a(boolean var1) {
      super.a(var1);
      this.b.setTitleOptional(var1);
   }

   @Override
   public boolean a(MenuBuilder var1, MenuItem var2) {
      return this.c.a(this, var2);
   }

   @Override
   public Menu b() {
      return this.g;
   }

   @Override
   public void b(int var1) {
      this.a(this.a.getString(var1));
   }

   @Override
   public void b(CharSequence var1) {
      this.b.setTitle(var1);
   }

   @Override
   public void c() {
      if (!this.e) {
         this.e = true;
         this.b.sendAccessibilityEvent(32);
         this.c.a(this);
      }
   }

   @Override
   public void d() {
      this.c.b(this, this.g);
   }

   @Override
   public CharSequence f() {
      return this.b.getTitle();
   }

   @Override
   public CharSequence g() {
      return this.b.getSubtitle();
   }

   @Override
   public boolean h() {
      return this.b.d();
   }

   @Override
   public View i() {
      View var1;
      if (this.d != null) {
         var1 = this.d.get();
      } else {
         var1 = null;
      }

      return var1;
   }
}
