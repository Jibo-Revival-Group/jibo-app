package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class FragmentManager {
   public abstract Fragment.SavedState a(Fragment var1);

   public abstract Fragment a(int var1);

   public abstract Fragment a(Bundle var1, String var2);

   public abstract Fragment a(String var1);

   public abstract FragmentTransaction a();

   public abstract void a(int var1, int var2);

   public abstract void a(Bundle var1, String var2, Fragment var3);

   public abstract void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4);

   public abstract boolean a(String var1, int var2);

   public abstract FragmentManager.BackStackEntry b(int var1);

   public abstract boolean b();

   public abstract boolean b(int var1, int var2);

   public abstract void c();

   public abstract boolean d();

   public abstract int e();

   public abstract List<Fragment> f();

   public abstract boolean g();

   public interface BackStackEntry {
      int a();
   }

   public abstract static class FragmentLifecycleCallbacks {
      public void a(FragmentManager var1, Fragment var2) {
      }

      public void a(FragmentManager var1, Fragment var2, Context var3) {
      }

      public void a(FragmentManager var1, Fragment var2, Bundle var3) {
      }

      public void a(FragmentManager var1, Fragment var2, View var3, Bundle var4) {
      }

      public void b(FragmentManager var1, Fragment var2) {
      }

      public void b(FragmentManager var1, Fragment var2, Context var3) {
      }

      public void b(FragmentManager var1, Fragment var2, Bundle var3) {
      }

      public void c(FragmentManager var1, Fragment var2) {
      }

      public void c(FragmentManager var1, Fragment var2, Bundle var3) {
      }

      public void d(FragmentManager var1, Fragment var2) {
      }

      public void d(FragmentManager var1, Fragment var2, Bundle var3) {
      }

      public void e(FragmentManager var1, Fragment var2) {
      }

      public void f(FragmentManager var1, Fragment var2) {
      }

      public void g(FragmentManager var1, Fragment var2) {
      }
   }

   public interface OnBackStackChangedListener {
      void a();
   }
}
