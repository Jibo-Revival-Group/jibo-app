package android.support.v7.widget;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.Pools;

class ViewInfoStore {
   final ArrayMap<RecyclerView.ViewHolder, ViewInfoStore.InfoRecord> a = new ArrayMap<>();
   final LongSparseArray<RecyclerView.ViewHolder> b = new LongSparseArray<>();

   private RecyclerView.ItemAnimator.ItemHolderInfo a(RecyclerView.ViewHolder var1, int var2) {
      Object var5 = null;
      int var3 = this.a.a(var1);
      RecyclerView.ItemAnimator.ItemHolderInfo var4;
      if (var3 < 0) {
         var4 = (RecyclerView.ItemAnimator.ItemHolderInfo)var5;
      } else {
         ViewInfoStore.InfoRecord var6 = this.a.c(var3);
         var4 = (RecyclerView.ItemAnimator.ItemHolderInfo)var5;
         if (var6 != null) {
            var4 = (RecyclerView.ItemAnimator.ItemHolderInfo)var5;
            if ((var6.a & var2) != 0) {
               var6.a &= ~var2;
               RecyclerView.ItemAnimator.ItemHolderInfo var7;
               if (var2 == 4) {
                  var7 = var6.b;
               } else {
                  if (var2 != 8) {
                     throw new IllegalArgumentException("Must provide flag PRE or POST");
                  }

                  var7 = var6.c;
               }

               var4 = var7;
               if ((var6.a & 12) == 0) {
                  this.a.d(var3);
                  ViewInfoStore.InfoRecord.a(var6);
                  var4 = var7;
               }
            }
         }
      }

      return var4;
   }

   RecyclerView.ViewHolder a(long var1) {
      return this.b.a(var1);
   }

   void a() {
      this.a.clear();
      this.b.c();
   }

   void a(long var1, RecyclerView.ViewHolder var3) {
      this.b.b(var1, var3);
   }

   void a(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2) {
      ViewInfoStore.InfoRecord var4 = this.a.get(var1);
      ViewInfoStore.InfoRecord var3 = var4;
      if (var4 == null) {
         var3 = ViewInfoStore.InfoRecord.a();
         this.a.put(var1, var3);
      }

      var3.b = var2;
      var3.a |= 4;
   }

   void a(ViewInfoStore.ProcessCallback var1) {
      for (int var2 = this.a.size() - 1; var2 >= 0; var2--) {
         RecyclerView.ViewHolder var4 = this.a.b(var2);
         ViewInfoStore.InfoRecord var3 = this.a.d(var2);
         if ((var3.a & 3) == 3) {
            var1.a(var4);
         } else if ((var3.a & 1) != 0) {
            if (var3.b == null) {
               var1.a(var4);
            } else {
               var1.a(var4, var3.b, var3.c);
            }
         } else if ((var3.a & 14) == 14) {
            var1.b(var4, var3.b, var3.c);
         } else if ((var3.a & 12) == 12) {
            var1.c(var4, var3.b, var3.c);
         } else if ((var3.a & 4) != 0) {
            var1.a(var4, var3.b, null);
         } else if ((var3.a & 8) != 0) {
            var1.b(var4, var3.b, var3.c);
         } else if ((var3.a & 2) != 0) {
         }

         ViewInfoStore.InfoRecord.a(var3);
      }
   }

   boolean a(RecyclerView.ViewHolder var1) {
      ViewInfoStore.InfoRecord var3 = this.a.get(var1);
      boolean var2;
      if (var3 != null && (var3.a & 1) != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   RecyclerView.ItemAnimator.ItemHolderInfo b(RecyclerView.ViewHolder var1) {
      return this.a(var1, 4);
   }

   void b() {
      ViewInfoStore.InfoRecord.b();
   }

   void b(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2) {
      ViewInfoStore.InfoRecord var4 = this.a.get(var1);
      ViewInfoStore.InfoRecord var3 = var4;
      if (var4 == null) {
         var3 = ViewInfoStore.InfoRecord.a();
         this.a.put(var1, var3);
      }

      var3.a |= 2;
      var3.b = var2;
   }

   RecyclerView.ItemAnimator.ItemHolderInfo c(RecyclerView.ViewHolder var1) {
      return this.a(var1, 8);
   }

   void c(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2) {
      ViewInfoStore.InfoRecord var4 = this.a.get(var1);
      ViewInfoStore.InfoRecord var3 = var4;
      if (var4 == null) {
         var3 = ViewInfoStore.InfoRecord.a();
         this.a.put(var1, var3);
      }

      var3.c = var2;
      var3.a |= 8;
   }

   boolean d(RecyclerView.ViewHolder var1) {
      ViewInfoStore.InfoRecord var3 = this.a.get(var1);
      boolean var2;
      if (var3 != null && (var3.a & 4) != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   void e(RecyclerView.ViewHolder var1) {
      ViewInfoStore.InfoRecord var3 = this.a.get(var1);
      ViewInfoStore.InfoRecord var2 = var3;
      if (var3 == null) {
         var2 = ViewInfoStore.InfoRecord.a();
         this.a.put(var1, var2);
      }

      var2.a |= 1;
   }

   void f(RecyclerView.ViewHolder var1) {
      ViewInfoStore.InfoRecord var2 = this.a.get(var1);
      if (var2 != null) {
         var2.a &= -2;
      }
   }

   void g(RecyclerView.ViewHolder var1) {
      for (int var2 = this.b.b() - 1; var2 >= 0; var2--) {
         if (var1 == this.b.c(var2)) {
            this.b.a(var2);
            break;
         }
      }

      ViewInfoStore.InfoRecord var3 = this.a.remove(var1);
      if (var3 != null) {
         ViewInfoStore.InfoRecord.a(var3);
      }
   }

   public void h(RecyclerView.ViewHolder var1) {
      this.f(var1);
   }

   static class InfoRecord {
      static Pools.Pool<ViewInfoStore.InfoRecord> d = new Pools.SimplePool<>(20);
      int a;
      RecyclerView.ItemAnimator.ItemHolderInfo b;
      RecyclerView.ItemAnimator.ItemHolderInfo c;

      private InfoRecord() {
      }

      static ViewInfoStore.InfoRecord a() {
         ViewInfoStore.InfoRecord var1 = d.a();
         ViewInfoStore.InfoRecord var0 = var1;
         if (var1 == null) {
            var0 = new ViewInfoStore.InfoRecord();
         }

         return var0;
      }

      static void a(ViewInfoStore.InfoRecord var0) {
         var0.a = 0;
         var0.b = null;
         var0.c = null;
         d.a(var0);
      }

      static void b() {
         while (d.a() != null) {
         }
      }
   }

   interface ProcessCallback {
      void a(RecyclerView.ViewHolder var1);

      void a(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2, RecyclerView.ItemAnimator.ItemHolderInfo var3);

      void b(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2, RecyclerView.ItemAnimator.ItemHolderInfo var3);

      void c(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2, RecyclerView.ItemAnimator.ItemHolderInfo var3);
   }
}
