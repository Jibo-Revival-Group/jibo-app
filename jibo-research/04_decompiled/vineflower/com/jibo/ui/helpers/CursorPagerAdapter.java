package com.jibo.ui.helpers;

import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public abstract class CursorPagerAdapter extends PagerAdapter {
   private boolean a;
   private Cursor b;
   private int c;
   private CursorPagerAdapter.ChangeObserver d;
   private DataSetObserver e;

   public CursorPagerAdapter(Cursor var1) {
      this.b(var1);
   }

   private void b(Cursor var1) {
      boolean var3;
      if (var1 != null) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.b = var1;
      this.a = var3;
      int var2;
      if (var3) {
         var2 = var1.getColumnIndexOrThrow("_id");
      } else {
         var2 = -1;
      }

      this.c = var2;
      this.d = new CursorPagerAdapter.ChangeObserver(this);
      this.e = new CursorPagerAdapter.MyDataSetObserver(this);
      if (var3) {
         if (this.d != null) {
            var1.registerContentObserver(this.d);
         }

         if (this.e != null) {
            var1.registerDataSetObserver(this.e);
         }
      }
   }

   public Cursor a(Cursor var1) {
      if (var1 == this.b) {
         var1 = null;
      } else {
         Cursor var2 = this.b;
         if (var2 != null) {
            if (this.d != null) {
               var2.unregisterContentObserver(this.d);
            }

            if (this.e != null) {
               var2.unregisterDataSetObserver(this.e);
            }
         }

         this.b = var1;
         if (var1 != null && !var1.isClosed()) {
            if (this.d != null) {
               var1.registerContentObserver(this.d);
            }

            if (this.e != null) {
               var1.registerDataSetObserver(this.e);
            }

            this.c = var1.getColumnIndexOrThrow("_id");
            this.a = true;
            this.c();
            var1 = var2;
         } else {
            this.c = -1;
            this.a = false;
            this.c();
            var1 = var2;
         }
      }

      return var1;
   }

   @Override
   public Object a(View var1, int var2) {
      this.b(var2);
      return this.a((ViewGroup)var1, this.b, var2);
   }

   public abstract Object a(ViewGroup var1, Cursor var2, int var3);

   @Override
   public void a(View var1, int var2, Object var3) {
   }

   @Override
   public int b() {
      int var1;
      if (this.a && this.b != null) {
         var1 = this.b.getCount();
      } else {
         var1 = 0;
      }

      return var1;
   }

   protected void b(int var1) {
      if (!this.a) {
         throw new IllegalStateException("this should only be called when the cursor is valid");
      }

      if (!this.b.moveToPosition(var1)) {
         throw new IllegalStateException("couldn't move cursor to position " + var1);
      }
   }

   public Cursor d() {
      return this.b;
   }

   protected void e() {
      if (this.b != null && !this.b.isClosed()) {
         this.a = this.b.requery();
      }
   }

   public boolean f() {
      return this.a;
   }

   private class ChangeObserver extends ContentObserver {
      final CursorPagerAdapter a;

      public ChangeObserver(CursorPagerAdapter var1) {
         super(new Handler());
         this.a = var1;
      }

      public boolean deliverSelfNotifications() {
         return true;
      }

      public void onChange(boolean var1) {
         this.a.e();
      }
   }

   private class MyDataSetObserver extends DataSetObserver {
      final CursorPagerAdapter a;

      private MyDataSetObserver(CursorPagerAdapter var1) {
         this.a = var1;
      }

      public void onChanged() {
         this.a.a = true;
         this.a.c();
      }

      public void onInvalidated() {
         this.a.a = false;
         this.a.c();
      }
   }
}
