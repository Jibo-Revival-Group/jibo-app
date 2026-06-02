package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v7.view.ActionMode;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.TintTypedArray;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import java.lang.Thread.UncaughtExceptionHandler;

abstract class AppCompatDelegateImplBase extends AppCompatDelegate {
   private static boolean m;
   private static final boolean n;
   private static final int[] o;
   final Context a;
   final Window b;
   final Callback c;
   final Callback d;
   final AppCompatCallback e;
   ActionBar f;
   MenuInflater g;
   boolean h;
   boolean i;
   boolean j;
   boolean k;
   boolean l;
   private CharSequence p;
   private boolean q;
   private boolean r;

   static {
      boolean var0;
      if (VERSION.SDK_INT < 21) {
         var0 = true;
      } else {
         var0 = false;
      }

      n = var0;
      if (n && !m) {
         Thread.setDefaultUncaughtExceptionHandler(
            new UncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler()) {
               final UncaughtExceptionHandler a;

               {
                  this.a = var1;
               }

               private boolean a(Throwable var1) {
                  boolean var3 = false;
                  boolean var2 = var3;
                  if (var1 instanceof NotFoundException) {
                     String var4 = var1.getMessage();
                     var2 = var3;
                     if (var4 != null) {
                        if (!var4.contains("drawable")) {
                           var2 = var3;
                           if (!var4.contains("Drawable")) {
                              return var2;
                           }
                        }

                        var2 = true;
                     }
                  }

                  return var2;
               }

               @Override
               public void uncaughtException(Thread var1, Throwable var2) {
                  if (this.a(var2)) {
                     NotFoundException var3 = new NotFoundException(
                        var2.getMessage()
                           + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info."
                     );
                     var3.initCause(var2.getCause());
                     var3.setStackTrace(var2.getStackTrace());
                     this.a.uncaughtException(var1, var3);
                  } else {
                     this.a.uncaughtException(var1, var2);
                  }
               }
            }
         );
         m = true;
      }

      o = new int[]{16842836};
   }

   AppCompatDelegateImplBase(Context var1, Window var2, AppCompatCallback var3) {
      this.a = var1;
      this.b = var2;
      this.e = var3;
      this.c = this.b.getCallback();
      if (this.c instanceof AppCompatDelegateImplBase.AppCompatWindowCallbackBase) {
         throw new IllegalStateException("AppCompat has already installed itself into the Window");
      }

      this.d = this.a(this.c);
      this.b.setCallback(this.d);
      TintTypedArray var4 = TintTypedArray.a(var1, null, o);
      Drawable var5 = var4.b(0);
      if (var5 != null) {
         this.b.setBackgroundDrawable(var5);
      }

      var4.a();
   }

   @Override
   public ActionBar a() {
      this.m();
      return this.f;
   }

   Callback a(Callback var1) {
      return new AppCompatDelegateImplBase.AppCompatWindowCallbackBase(this, var1);
   }

   abstract void a(int var1, Menu var2);

   @Override
   public final void a(CharSequence var1) {
      this.p = var1;
      this.b(var1);
   }

   abstract boolean a(int var1, KeyEvent var2);

   abstract boolean a(KeyEvent var1);

   abstract ActionMode b(ActionMode.Callback var1);

   @Override
   public MenuInflater b() {
      if (this.g == null) {
         this.m();
         Context var1;
         if (this.f != null) {
            var1 = this.f.getThemedContext();
         } else {
            var1 = this.a;
         }

         this.g = new SupportMenuInflater(var1);
      }

      return this.g;
   }

   abstract void b(CharSequence var1);

   abstract boolean b(int var1, Menu var2);

   @Override
   public void c() {
      this.q = true;
   }

   @Override
   public void c(Bundle var1) {
   }

   @Override
   public void d() {
      this.q = false;
   }

   @Override
   public void g() {
      this.r = true;
   }

   @Override
   public final ActionBarDrawerToggle.Delegate h() {
      return new AppCompatDelegateImplBase.ActionBarDrawableToggleImpl(this);
   }

   @Override
   public boolean j() {
      return false;
   }

   abstract void m();

   final ActionBar n() {
      return this.f;
   }

   final Context o() {
      Context var1 = null;
      ActionBar var2 = this.a();
      if (var2 != null) {
         var1 = var2.getThemedContext();
      }

      Context var3 = var1;
      if (var1 == null) {
         var3 = this.a;
      }

      return var3;
   }

   public boolean p() {
      return false;
   }

   final boolean q() {
      return this.r;
   }

   final Callback r() {
      return this.b.getCallback();
   }

   final CharSequence s() {
      CharSequence var1;
      if (this.c instanceof Activity) {
         var1 = ((Activity)this.c).getTitle();
      } else {
         var1 = this.p;
      }

      return var1;
   }

   private class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
      final AppCompatDelegateImplBase a;

      ActionBarDrawableToggleImpl(AppCompatDelegateImplBase var1) {
         this.a = var1;
      }

      @Override
      public void a(int var1) {
         ActionBar var2 = this.a.a();
         if (var2 != null) {
            var2.setHomeActionContentDescription(var1);
         }
      }
   }

   class AppCompatWindowCallbackBase extends WindowCallbackWrapper {
      final AppCompatDelegateImplBase a;

      AppCompatWindowCallbackBase(AppCompatDelegateImplBase var1, Callback var2) {
         super(var2);
         this.a = var1;
      }

      @Override
      public boolean dispatchKeyEvent(KeyEvent var1) {
         boolean var2;
         if (!this.a.a(var1) && !super.dispatchKeyEvent(var1)) {
            var2 = false;
         } else {
            var2 = true;
         }

         return var2;
      }

      @Override
      public boolean dispatchKeyShortcutEvent(KeyEvent var1) {
         boolean var2;
         if (!super.dispatchKeyShortcutEvent(var1) && !this.a.a(var1.getKeyCode(), var1)) {
            var2 = false;
         } else {
            var2 = true;
         }

         return var2;
      }

      @Override
      public void onContentChanged() {
      }

      @Override
      public boolean onCreatePanelMenu(int var1, Menu var2) {
         boolean var3;
         if (var1 == 0 && !(var2 instanceof MenuBuilder)) {
            var3 = false;
         } else {
            var3 = super.onCreatePanelMenu(var1, var2);
         }

         return var3;
      }

      @Override
      public boolean onMenuOpened(int var1, Menu var2) {
         super.onMenuOpened(var1, var2);
         this.a.b(var1, var2);
         return true;
      }

      @Override
      public void onPanelClosed(int var1, Menu var2) {
         super.onPanelClosed(var1, var2);
         this.a.a(var1, var2);
      }

      @Override
      public boolean onPreparePanel(int var1, View var2, Menu var3) {
         MenuBuilder var6;
         if (var3 instanceof MenuBuilder) {
            var6 = (MenuBuilder)var3;
         } else {
            var6 = null;
         }

         boolean var4;
         if (var1 == 0 && var6 == null) {
            var4 = false;
         } else {
            if (var6 != null) {
               var6.c(true);
            }

            boolean var5 = super.onPreparePanel(var1, var2, var3);
            var4 = var5;
            if (var6 != null) {
               var6.c(false);
               var4 = var5;
            }
         }

         return var4;
      }
   }
}
