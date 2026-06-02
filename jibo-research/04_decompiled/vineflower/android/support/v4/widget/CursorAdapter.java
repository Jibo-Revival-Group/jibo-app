package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class CursorAdapter extends BaseAdapter implements CursorFilter.CursorFilterClient, Filterable {
   protected boolean a;
   protected boolean b;
   protected Cursor c;
   protected Context d;
   protected int e;
   protected CursorAdapter.ChangeObserver f;
   protected DataSetObserver g;
   protected CursorFilter h;
   protected FilterQueryProvider i;

   public CursorAdapter(Context var1, Cursor var2, boolean var3) {
      byte var4;
      if (var3) {
         var4 = 1;
      } else {
         var4 = 2;
      }

      this.a(var1, var2, var4);
   }

   @Override
   public Cursor a() {
      return this.c;
   }

   @Override
   public Cursor a(CharSequence var1) {
      Cursor var2;
      if (this.i != null) {
         var2 = this.i.runQuery(var1);
      } else {
         var2 = this.c;
      }

      return var2;
   }

   public abstract View a(Context var1, Cursor var2, ViewGroup var3);

   void a(Context var1, Cursor var2, int var3) {
      boolean var5 = true;
      if ((var3 & 1) == 1) {
         var3 |= 2;
         this.b = true;
      } else {
         this.b = false;
      }

      if (var2 == null) {
         var5 = false;
      }

      this.c = var2;
      this.a = var5;
      this.d = var1;
      int var4;
      if (var5) {
         var4 = var2.getColumnIndexOrThrow("_id");
      } else {
         var4 = -1;
      }

      this.e = var4;
      if ((var3 & 2) == 2) {
         this.f = new CursorAdapter.ChangeObserver(this);
         this.g = new CursorAdapter.MyDataSetObserver(this);
      } else {
         this.f = null;
         this.g = null;
      }

      if (var5) {
         if (this.f != null) {
            var2.registerContentObserver(this.f);
         }

         if (this.g != null) {
            var2.registerDataSetObserver(this.g);
         }
      }
   }

   @Override
   public void a(Cursor var1) {
      var1 = this.b(var1);
      if (var1 != null) {
         var1.close();
      }
   }

   public abstract void a(View var1, Context var2, Cursor var3);

   public Cursor b(Cursor var1) {
      if (var1 == this.c) {
         var1 = null;
      } else {
         Cursor var2 = this.c;
         if (var2 != null) {
            if (this.f != null) {
               var2.unregisterContentObserver(this.f);
            }

            if (this.g != null) {
               var2.unregisterDataSetObserver(this.g);
            }
         }

         this.c = var1;
         if (var1 != null) {
            if (this.f != null) {
               var1.registerContentObserver(this.f);
            }

            if (this.g != null) {
               var1.registerDataSetObserver(this.g);
            }

            this.e = var1.getColumnIndexOrThrow("_id");
            this.a = true;
            this.notifyDataSetChanged();
            var1 = var2;
         } else {
            this.e = -1;
            this.a = false;
            this.notifyDataSetInvalidated();
            var1 = var2;
         }
      }

      return var1;
   }

   public View b(Context var1, Cursor var2, ViewGroup var3) {
      return this.a(var1, var2, var3);
   }

   protected void b() {
      if (this.b && this.c != null && !this.c.isClosed()) {
         this.a = this.c.requery();
      }
   }

   @Override
   public CharSequence c(Cursor var1) {
      String var2;
      if (var1 == null) {
         var2 = "";
      } else {
         var2 = var1.toString();
      }

      return var2;
   }

   public int getCount() {
      int var1;
      if (this.a && this.c != null) {
         var1 = this.c.getCount();
      } else {
         var1 = 0;
      }

      return var1;
   }

   public View getDropDownView(int var1, View var2, ViewGroup var3) {
      View var4;
      if (this.a) {
         this.c.moveToPosition(var1);
         var4 = var2;
         if (var2 == null) {
            var4 = this.b(this.d, this.c, var3);
         }

         this.a(var4, this.d, this.c);
      } else {
         var4 = null;
      }

      return var4;
   }

   public Filter getFilter() {
      if (this.h == null) {
         this.h = new CursorFilter(this);
      }

      return this.h;
   }

   public Object getItem(int var1) {
      Cursor var2;
      if (this.a && this.c != null) {
         this.c.moveToPosition(var1);
         var2 = this.c;
      } else {
         var2 = null;
      }

      return var2;
   }

   public long getItemId(int var1) {
      long var4 = 0L;
      long var2 = var4;
      if (this.a) {
         var2 = var4;
         if (this.c != null) {
            var2 = var4;
            if (this.c.moveToPosition(var1)) {
               var2 = this.c.getLong(this.e);
            }
         }
      }

      return var2;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      if (!this.a) {
         throw new IllegalStateException("this should only be called when the cursor is valid");
      }

      if (!this.c.moveToPosition(var1)) {
         throw new IllegalStateException("couldn't move cursor to position " + var1);
      }

      View var4 = var2;
      if (var2 == null) {
         var4 = this.a(this.d, this.c, var3);
      }

      this.a(var4, this.d, this.c);
      return var4;
   }

   public boolean hasStableIds() {
      return true;
   }

   private class ChangeObserver extends ContentObserver {
      final CursorAdapter a;

      ChangeObserver(CursorAdapter var1) {
         super(new Handler());
         this.a = var1;
      }

      public boolean deliverSelfNotifications() {
         return true;
      }

      public void onChange(boolean var1) {
         this.a.b();
      }
   }

   private class MyDataSetObserver extends DataSetObserver {
      final CursorAdapter a;

      MyDataSetObserver(CursorAdapter var1) {
         this.a = var1;
      }

      public void onChanged() {
         this.a.a = true;
         this.a.notifyDataSetChanged();
      }

      public void onInvalidated() {
         this.a.a = false;
         this.a.notifyDataSetInvalidated();
      }
   }
}
