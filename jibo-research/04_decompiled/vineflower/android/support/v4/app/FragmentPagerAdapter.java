package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentPagerAdapter extends PagerAdapter {
   private final FragmentManager a;
   private FragmentTransaction b = null;
   private Fragment c = null;

   public FragmentPagerAdapter(FragmentManager var1) {
      this.a = var1;
   }

   private static String a(int var0, long var1) {
      return "android:switcher:" + var0 + ":" + var1;
   }

   @Override
   public Parcelable a() {
      return null;
   }

   public abstract Fragment a(int var1);

   @Override
   public Object a(ViewGroup var1, int var2) {
      if (this.b == null) {
         this.b = this.a.a();
      }

      long var3 = this.b(var2);
      String var5 = a(var1.getId(), var3);
      Fragment var7 = this.a.a(var5);
      Fragment var6;
      if (var7 != null) {
         this.b.c(var7);
         var6 = var7;
      } else {
         Fragment var8 = this.a(var2);
         this.b.a(var1.getId(), var8, a(var1.getId(), var3));
         var6 = var8;
      }

      if (var6 != this.c) {
         var6.setMenuVisibility(false);
         var6.setUserVisibleHint(false);
      }

      return var6;
   }

   @Override
   public void a(Parcelable var1, ClassLoader var2) {
   }

   @Override
   public void a(ViewGroup var1) {
      if (var1.getId() == -1) {
         throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
      }
   }

   @Override
   public void a(ViewGroup var1, int var2, Object var3) {
      if (this.b == null) {
         this.b = this.a.a();
      }

      this.b.b((Fragment)var3);
   }

   @Override
   public boolean a(View var1, Object var2) {
      boolean var3;
      if (((Fragment)var2).getView() == var1) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public long b(int var1) {
      return var1;
   }

   @Override
   public void b(ViewGroup var1) {
      if (this.b != null) {
         this.b.g();
         this.b = null;
      }
   }

   @Override
   public void b(ViewGroup var1, int var2, Object var3) {
      Fragment var4 = (Fragment)var3;
      if (var4 != this.c) {
         if (this.c != null) {
            this.c.setMenuVisibility(false);
            this.c.setUserVisibleHint(false);
         }

         if (var4 != null) {
            var4.setMenuVisibility(true);
            var4.setUserVisibleHint(true);
         }

         this.c = var4;
      }
   }
}
