package android.support.v4.widget;

import android.support.v4.util.Pools;
import android.support.v4.util.SimpleArrayMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class DirectedAcyclicGraph<T> {
   private final Pools.Pool<ArrayList<T>> a = new Pools.SimplePool<>(10);
   private final SimpleArrayMap<T, ArrayList<T>> b = new SimpleArrayMap<>();
   private final ArrayList<T> c = new ArrayList<>();
   private final HashSet<T> d = new HashSet<>();

   private void a(T var1, ArrayList<T> var2, HashSet<T> var3) {
      if (!var2.contains(var1)) {
         if (var3.contains(var1)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
         }

         var3.add(var1);
         ArrayList var6 = this.b.get(var1);
         if (var6 != null) {
            int var4 = 0;

            for (int var5 = var6.size(); var4 < var5; var4++) {
               this.a((T)var6.get(var4), var2, var3);
            }
         }

         var3.remove(var1);
         var2.add(var1);
      }
   }

   private void a(ArrayList<T> var1) {
      var1.clear();
      this.a.a(var1);
   }

   private ArrayList<T> c() {
      ArrayList var2 = this.a.a();
      ArrayList var1 = var2;
      if (var2 == null) {
         var1 = new ArrayList();
      }

      return var1;
   }

   public void a() {
      int var2 = this.b.size();

      for (int var1 = 0; var1 < var2; var1++) {
         ArrayList var3 = this.b.c(var1);
         if (var3 != null) {
            this.a(var3);
         }
      }

      this.b.clear();
   }

   public void a(T var1) {
      if (!this.b.containsKey(var1)) {
         this.b.put((T)var1, null);
      }
   }

   public void a(T var1, T var2) {
      if (this.b.containsKey(var1) && this.b.containsKey(var2)) {
         ArrayList var4 = this.b.get(var1);
         ArrayList var3 = var4;
         if (var4 == null) {
            var3 = this.c();
            this.b.put((T)var1, var3);
         }

         var3.add(var2);
      } else {
         throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
      }
   }

   public ArrayList<T> b() {
      this.c.clear();
      this.d.clear();
      int var1 = 0;

      for (int var2 = this.b.size(); var1 < var2; var1++) {
         this.a(this.b.b(var1), this.c, this.d);
      }

      return this.c;
   }

   public boolean b(T var1) {
      return this.b.containsKey(var1);
   }

   public List c(T var1) {
      return this.b.get(var1);
   }

   public List<T> d(T var1) {
      ArrayList var4 = null;
      int var3 = this.b.size();
      int var2 = 0;

      while (var2 < var3) {
         ArrayList var6 = this.b.c(var2);
         ArrayList var5 = var4;
         if (var6 != null) {
            var5 = var4;
            if (var6.contains(var1)) {
               if (var4 == null) {
                  var4 = new ArrayList();
               }

               var4.add(this.b.b(var2));
               var5 = var4;
            }
         }

         var2++;
         var4 = var5;
      }

      return var4;
   }

   public boolean e(T var1) {
      int var3 = this.b.size();
      int var2 = 0;

      boolean var4;
      while (true) {
         if (var2 >= var3) {
            var4 = false;
            break;
         }

         ArrayList var5 = this.b.c(var2);
         if (var5 != null && var5.contains(var1)) {
            var4 = true;
            break;
         }

         var2++;
      }

      return var4;
   }
}
