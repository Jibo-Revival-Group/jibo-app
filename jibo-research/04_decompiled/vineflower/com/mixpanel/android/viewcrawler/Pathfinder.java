package com.mixpanel.android.viewcrawler;

import android.view.View;
import android.view.ViewGroup;
import com.mixpanel.android.util.MPLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class Pathfinder {
   private final Pathfinder.IntStack a = new Pathfinder.IntStack();

   public Pathfinder() {
   }

   private View a(Pathfinder.PathElement var1, View var2, int var3) {
      int var4 = this.a.a(var3);
      if (this.a(var1, var2)) {
         this.a.b(var3);
         View var6 = var2;
         if (var1.c == -1) {
            return var6;
         }

         if (var1.c == var4) {
            var6 = var2;
            return var6;
         }
      }

      if (var1.a == 1 && var2 instanceof ViewGroup) {
         ViewGroup var7 = (ViewGroup)var2;
         int var5 = var7.getChildCount();

         for (int var8 = 0; var8 < var5; var8++) {
            View var9 = this.a(var1, var7.getChildAt(var8), var3);
            if (var9 != null) {
               return var9;
            }
         }
      }

      return null;
   }

   private boolean a(Pathfinder.PathElement var1, View var2) {
      boolean var4 = false;
      boolean var9;
      if (var1.b != null && !a(var2, var1.b)) {
         var9 = var4;
      } else {
         if (-1 != var1.d) {
            var9 = var4;
            if (var2.getId() != var1.d) {
               return var9;
            }
         }

         if (var1.e != null) {
            var9 = var4;
            if (!var1.e.equals(var2.getContentDescription())) {
               return var9;
            }
         }

         String var5 = var1.f;
         if (var1.f != null) {
            var9 = var4;
            if (var2.getTag() == null) {
               return var9;
            }

            var9 = var4;
            if (!var5.equals(var2.getTag().toString())) {
               return var9;
            }
         }

         var9 = true;
      }

      return var9;
   }

   private static boolean a(Object var0, String var1) {
      var0 = var0.getClass();

      boolean var2;
      while (true) {
         if (var0.getCanonicalName().equals(var1)) {
            var2 = true;
            break;
         }

         if (var0 == Object.class) {
            var2 = false;
            break;
         }

         var0 = var0.getSuperclass();
      }

      return var2;
   }

   private void b(View var1, List<Pathfinder.PathElement> var2, Pathfinder.Accumulator var3) {
      int var4 = 0;
      if (var2.isEmpty()) {
         var3.a(var1);
      } else if (var1 instanceof ViewGroup) {
         if (this.a.a()) {
            MPLog.a("MixpanelAPI.PathFinder", "Path is too deep, will not match");
         } else {
            ViewGroup var7 = (ViewGroup)var1;
            Pathfinder.PathElement var9 = (Pathfinder.PathElement)var2.get(0);
            var2 = var2.subList(1, var2.size());
            int var6 = var7.getChildCount();
            int var5 = this.a.b();

            while (var4 < var6) {
               View var8 = this.a(var9, var7.getChildAt(var4), var5);
               if (var8 != null) {
                  this.b(var8, var2, var3);
               }

               if (var9.c >= 0 && this.a.a(var5) > var9.c) {
                  break;
               }

               var4++;
            }

            this.a.c();
         }
      }
   }

   public void a(View var1, List<Pathfinder.PathElement> var2, Pathfinder.Accumulator var3) {
      if (!var2.isEmpty()) {
         if (this.a.a()) {
            MPLog.d("MixpanelAPI.PathFinder", "There appears to be a concurrency issue in the pathfinding code. Path will not be matched.");
         } else {
            Pathfinder.PathElement var4 = (Pathfinder.PathElement)var2.get(0);
            var2 = var2.subList(1, var2.size());
            var1 = this.a(var4, var1, this.a.b());
            this.a.c();
            if (var1 != null) {
               this.b(var1, var2, var3);
            }
         }
      }
   }

   public interface Accumulator {
      void a(View var1);
   }

   private static class IntStack {
      private final int[] a = new int[256];
      private int b = 0;

      public IntStack() {
      }

      public int a(int var1) {
         return this.a[var1];
      }

      public boolean a() {
         boolean var1;
         if (this.a.length == this.b) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public int b() {
         int var1 = this.b++;
         this.a[var1] = 0;
         return var1;
      }

      public void b(int var1) {
         int[] var2 = this.a;
         var2[var1]++;
      }

      public void c() {
         this.b--;
         if (this.b < 0) {
            throw new ArrayIndexOutOfBoundsException(this.b);
         }
      }
   }

   public static class PathElement {
      public final int a;
      public final String b;
      public final int c;
      public final int d;
      public final String e;
      public final String f;

      public PathElement(int var1, String var2, int var3, int var4, String var5, String var6) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
         this.f = var6;
      }

      @Override
      public String toString() {
         try {
            JSONObject var1 = new JSONObject();
            if (this.a == 1) {
               var1.put("prefix", "shortest");
            }

            if (this.b != null) {
               var1.put("view_class", this.b);
            }

            if (this.c > -1) {
               var1.put("index", this.c);
            }

            if (this.d > -1) {
               var1.put("id", this.d);
            }

            if (this.e != null) {
               var1.put("contentDescription", this.e);
            }

            if (this.f != null) {
               var1.put("tag", this.f);
            }

            return var1.toString();
         } catch (JSONException var2) {
            throw new RuntimeException("Can't serialize PathElement to String", var2);
         }
      }
   }
}
