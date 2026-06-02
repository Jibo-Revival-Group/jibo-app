package com.jibo.ui.helpers;

import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;

public abstract class RecyclerCursorAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
   private boolean a;
   boolean b = false;
   boolean c = false;
   private int d;
   private Cursor e;
   private RecyclerCursorAdapter<VH>.ChangeObserver f;
   private DataSetObserver g;

   public RecyclerCursorAdapter(Cursor var1) {
      this.a(var1);
   }

   public Cursor a() {
      return this.e;
   }

   void a(Cursor var1) {
      boolean var3;
      if (var1 != null) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.e = var1;
      this.a = var3;
      int var2;
      if (var3) {
         var2 = var1.getColumnIndexOrThrow("_id");
      } else {
         var2 = -1;
      }

      this.d = var2;
      this.f = new RecyclerCursorAdapter.ChangeObserver(this);
      this.g = new RecyclerCursorAdapter.MyDataSetObserver(this);
      if (var3) {
         if (this.f != null) {
            var1.registerContentObserver(this.f);
         }

         if (this.g != null) {
            var1.registerDataSetObserver(this.g);
         }
      }
   }

   public abstract void a(VH var1, Cursor var2);

   public Cursor b(Cursor var1) {
      if (var1 == this.e) {
         var1 = null;
      } else {
         Cursor var2 = this.e;
         if (var2 != null) {
            if (this.f != null) {
               var2.unregisterContentObserver(this.f);
            }

            if (this.g != null) {
               var2.unregisterDataSetObserver(this.g);
            }
         }

         this.e = var1;
         if (var1 != null) {
            if (this.f != null) {
               var1.registerContentObserver(this.f);
            }

            if (this.g != null) {
               var1.registerDataSetObserver(this.g);
            }

            this.d = var1.getColumnIndexOrThrow("_id");
            this.a = true;
            this.notifyDataSetChanged();
            var1 = var2;
         } else {
            this.d = -1;
            this.a = false;
            this.notifyItemRangeRemoved(0, this.getItemCount());
            var1 = var2;
         }
      }

      return var1;
   }

   protected void b() {
   }

   public boolean c() {
      return this.a;
   }

   @Override
   public int getItemCount() {
      byte var3 = 0;
      byte var1;
      if (this.b) {
         var1 = 1;
      } else {
         var1 = 0;
      }

      int var2 = var1;
      if (this.c) {
         var2 = var1 + 1;
      }

      var1 = var3;
      if (this.a) {
         var1 = var3;
         if (this.e != null) {
            var1 = this.e.getCount() + var2;
         }
      }

      return var1;
   }

   @Override
   public long getItemId(int var1) {
      long var5 = 0L;
      int var2 = var1;
      if (this.b) {
         var2 = var1 - 1;
      }

      long var3 = var5;
      if (this.a) {
         var3 = var5;
         if (this.e != null) {
            var3 = var5;
            if (this.e.moveToPosition(var2)) {
               var3 = this.e.getLong(this.d);
            }
         }
      }

      return var3;
   }

   @Override
   public void onBindViewHolder(VH var1, int var2) {
      if (!this.e.isClosed()) {
         int var3 = var2;
         if (this.b) {
            if (var2 == 0) {
               this.a((VH)var1, this.e);
               return;
            }

            var3 = var2 - 1;
         }

         if (!this.a && this.getItemCount() == 0) {
         }

         if (this.e == null || this.getItemCount() <= 0 || this.e.moveToPosition(var3) || this.b || this.c) {
            this.a((VH)var1, this.e);
         }
      }
   }

   private class ChangeObserver extends ContentObserver {
      final RecyclerCursorAdapter a;

      public ChangeObserver(RecyclerCursorAdapter var1) {
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
      final RecyclerCursorAdapter a;

      private MyDataSetObserver(RecyclerCursorAdapter var1) {
         this.a = var1;
      }

      public void onChanged() {
         this.a.a = true;
         this.a.notifyDataSetChanged();
      }

      public void onInvalidated() {
         this.a.a = false;
         this.a.notifyItemRangeRemoved(0, this.a.getItemCount());
      }
   }
}
