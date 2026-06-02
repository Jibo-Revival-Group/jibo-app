package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class ActionProvider {
   private final Context a;
   private ActionProvider.SubUiVisibilityListener b;
   private ActionProvider.VisibilityListener c;

   public ActionProvider(Context var1) {
      this.a = var1;
   }

   public abstract View a();

   public View a(MenuItem var1) {
      return this.a();
   }

   public void a(ActionProvider.SubUiVisibilityListener var1) {
      this.b = var1;
   }

   public void a(ActionProvider.VisibilityListener var1) {
      if (this.c != null && var1 != null) {
         Log.w(
            "ActionProvider(support)",
            "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this "
               + this.getClass().getSimpleName()
               + " instance while it is still in use somewhere else?"
         );
      }

      this.c = var1;
   }

   public void a(SubMenu var1) {
   }

   public void a(boolean var1) {
      if (this.b != null) {
         this.b.b(var1);
      }
   }

   public boolean b() {
      return false;
   }

   public boolean c() {
      return true;
   }

   public boolean d() {
      return false;
   }

   public boolean e() {
      return false;
   }

   public void f() {
      this.c = null;
      this.b = null;
   }

   public interface SubUiVisibilityListener {
      void b(boolean var1);
   }

   public interface VisibilityListener {
      void a(boolean var1);
   }
}
