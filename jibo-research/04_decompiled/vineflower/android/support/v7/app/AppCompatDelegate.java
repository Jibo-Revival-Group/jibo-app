package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;

public abstract class AppCompatDelegate {
   private static int a = -1;
   private static boolean b = false;

   AppCompatDelegate() {
   }

   public static AppCompatDelegate a(Activity var0, AppCompatCallback var1) {
      return a(var0, var0.getWindow(), var1);
   }

   public static AppCompatDelegate a(Dialog var0, AppCompatCallback var1) {
      return a(var0.getContext(), var0.getWindow(), var1);
   }

   private static AppCompatDelegate a(Context var0, Window var1, AppCompatCallback var2) {
      AppCompatDelegateImplV14 var3;
      if (VERSION.SDK_INT >= 24) {
         var3 = new AppCompatDelegateImplN(var0, var1, var2);
      } else if (VERSION.SDK_INT >= 23) {
         var3 = new AppCompatDelegateImplV23(var0, var1, var2);
      } else {
         var3 = new AppCompatDelegateImplV14(var0, var1, var2);
      }

      return var3;
   }

   public static int k() {
      return a;
   }

   public static boolean l() {
      return b;
   }

   public abstract ActionBar a();

   public abstract ActionMode a(ActionMode.Callback var1);

   public abstract <T extends View> T a(int var1);

   public abstract void a(Configuration var1);

   public abstract void a(Bundle var1);

   public abstract void a(Toolbar var1);

   public abstract void a(View var1);

   public abstract void a(View var1, LayoutParams var2);

   public abstract void a(CharSequence var1);

   public abstract MenuInflater b();

   public abstract void b(int var1);

   public abstract void b(Bundle var1);

   public abstract void b(View var1, LayoutParams var2);

   public abstract void c();

   public abstract void c(Bundle var1);

   public abstract boolean c(int var1);

   public abstract void d();

   public abstract void e();

   public abstract void f();

   public abstract void g();

   public abstract ActionBarDrawerToggle.Delegate h();

   public abstract void i();

   public abstract boolean j();
}
