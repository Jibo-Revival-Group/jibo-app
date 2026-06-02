package com.jibo.ui.helpers;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class FragmentStateCursorPagerAdapter extends CursorPagerAdapter {
   private final FragmentManager a;
   private FragmentTransaction b = null;
   private ArrayList<Fragment.SavedState> c = new ArrayList<>();
   private ArrayList<Fragment> d = new ArrayList<>();
   private Fragment e = null;

   public FragmentStateCursorPagerAdapter(FragmentManager var1, Cursor var2) {
      super(var2);
      this.a = var1;
   }

   @Override
   public Parcelable a() {
      Bundle var2 = null;
      if (this.c.size() > 0) {
         var2 = new Bundle();
         Fragment.SavedState[] var3 = new Fragment.SavedState[this.c.size()];
         this.c.toArray(var3);
         var2.putParcelableArray("states", var3);
      }

      int var1 = 0;
      Bundle var6 = var2;

      while (var1 < this.d.size()) {
         Fragment var4 = this.d.get(var1);
         var2 = var6;
         if (var4 != null) {
            var2 = var6;
            if (var4.isAdded()) {
               var2 = var6;
               if (var6 == null) {
                  var2 = new Bundle();
               }

               String var7 = "f" + var1;
               this.a.a(var2, var7, var4);
            }
         }

         var1++;
         var6 = var2;
      }

      return var6;
   }

   public abstract Fragment a(int var1);

   @Override
   public Object a(ViewGroup var1, Cursor var2, int var3) {
      if (this.d.size() > var3) {
         Fragment var4 = this.d.get(var3);
         if (var4 != null) {
            this.a(var4, var2, var3);
            return var4;
         }
      }

      if (this.b == null) {
         this.b = this.a.a();
      }

      Fragment var7 = this.a(var3);
      this.a(var7, var2, var3);
      if (this.c.size() > var3) {
         Fragment.SavedState var6 = this.c.get(var3);
         if (var6 != null) {
            var7.setInitialSavedState(var6);
         }
      }

      while (this.d.size() <= var3) {
         this.d.add(null);
      }

      var7.setMenuVisibility(false);
      var7.setUserVisibleHint(false);
      this.d.set(var3, var7);
      this.b.a(var1.getId(), var7);
      return var7;
   }

   @Override
   public void a(Parcelable var1, ClassLoader var2) {
      if (var1 != null) {
         Bundle var6 = (Bundle)var1;
         var6.setClassLoader(var2);
         Parcelable[] var7 = var6.getParcelableArray("states");
         this.c.clear();
         this.d.clear();
         if (var7 != null) {
            for (int var3 = 0; var3 < var7.length; var3++) {
               this.c.add((Fragment.SavedState)var7[var3]);
            }
         }

         for (String var8 : var6.keySet()) {
            if (var8.startsWith("f")) {
               int var9 = Integer.parseInt(var8.substring(1));
               Fragment var4 = this.a.a(var6, var8);
               if (var4 != null) {
                  while (this.d.size() <= var9) {
                     this.d.add(null);
                  }

                  var4.setMenuVisibility(false);
                  this.d.set(var9, var4);
               } else {
                  Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + var8);
               }
            }
         }
      }
   }

   public abstract void a(Fragment var1, Cursor var2, int var3);

   @Override
   public void a(ViewGroup var1) {
   }

   @Override
   public void a(ViewGroup var1, int var2, Object var3) {
      var3 = var3;
      if (this.b == null) {
         this.b = this.a.a();
      }

      while (this.c.size() <= var2) {
         this.c.add(null);
      }

      ArrayList var4 = this.c;
      Fragment.SavedState var5;
      if (var3.isAdded()) {
         var5 = this.a.a(var3);
      } else {
         var5 = null;
      }

      var4.set(var2, var5);
      this.d.set(var2, null);
      this.b.a(var3);
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

   @Override
   public void b(ViewGroup var1) {
      if (this.b != null) {
         this.b.e();
         this.b = null;
         this.a.b();
      }
   }

   @Override
   public void b(ViewGroup var1, int var2, Object var3) {
      Fragment var4 = (Fragment)var3;
      if (var4 != this.e) {
         if (this.e != null) {
            this.e.setMenuVisibility(false);
            this.e.setUserVisibleHint(false);
         }

         if (var4 != null) {
            var4.setMenuVisibility(true);
            var4.setUserVisibleHint(true);
         }

         this.e = var4;
      }
   }
}
