package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class FragmentTransitionImpl {
   static String a(Map<String, String> var0, String var1) {
      Iterator var2 = var0.entrySet().iterator();

      while (true) {
         if (var2.hasNext()) {
            Entry var4 = (Entry)var2.next();
            if (!var1.equals(var4.getValue())) {
               continue;
            }

            var3 = (String)var4.getKey();
            break;
         }

         var3 = null;
         break;
      }

      return var3;
   }

   protected static void a(List<View> var0, View var1) {
      int var4 = var0.size();
      if (!a(var0, var1, var4)) {
         var0.add(var1);

         for (int var2 = var4; var2 < var0.size(); var2++) {
            var1 = (View)var0.get(var2);
            if (var1 instanceof ViewGroup) {
               ViewGroup var8 = (ViewGroup)var1;
               int var5 = var8.getChildCount();

               for (int var3 = 0; var3 < var5; var3++) {
                  View var6 = var8.getChildAt(var3);
                  if (!a(var0, var6, var4)) {
                     var0.add(var6);
                  }
               }
            }
         }
      }
   }

   protected static boolean a(List var0) {
      boolean var1;
      if (var0 != null && !var0.isEmpty()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   private static boolean a(List<View> var0, View var1, int var2) {
      boolean var5 = false;
      int var3 = 0;

      boolean var4;
      while (true) {
         var4 = var5;
         if (var3 >= var2) {
            break;
         }

         if (var0.get(var3) == var1) {
            var4 = true;
            break;
         }

         var3++;
      }

      return var4;
   }

   public abstract Object a(Object var1, Object var2, Object var3);

   ArrayList<String> a(ArrayList<View> var1) {
      ArrayList var4 = new ArrayList();
      int var3 = var1.size();

      for (int var2 = 0; var2 < var3; var2++) {
         View var5 = (View)var1.get(var2);
         var4.add(ViewCompat.o(var5));
         ViewCompat.a(var5, (String)null);
      }

      return var4;
   }

   protected void a(View var1, Rect var2) {
      int[] var3 = new int[2];
      var1.getLocationOnScreen(var3);
      var2.set(var3[0], var3[1], var3[0] + var1.getWidth(), var3[1] + var1.getHeight());
   }

   void a(View var1, ArrayList<View> var2, ArrayList<View> var3, ArrayList<String> var4, Map<String, String> var5) {
      int var8 = var3.size();
      ArrayList var10 = new ArrayList();

      for (int var6 = 0; var6 < var8; var6++) {
         View var11 = (View)var2.get(var6);
         String var9 = ViewCompat.o(var11);
         var10.add(var9);
         if (var9 != null) {
            ViewCompat.a(var11, (String)null);
            String var12 = (String)var5.get(var9);

            for (int var7 = 0; var7 < var8; var7++) {
               if (var12.equals(var4.get(var7))) {
                  ViewCompat.a((View)var3.get(var7), var9);
                  break;
               }
            }
         }
      }

      OneShotPreDrawListener.a(var1, new Runnable(this, var8, var3, var4, var2, var10) {
         final int a;
         final ArrayList b;
         final ArrayList c;
         final ArrayList d;
         final ArrayList e;
         final FragmentTransitionImpl f;

         {
            this.f = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4x;
            this.d = var5x;
            this.e = var6;
         }

         @Override
         public void run() {
            for (int var1x = 0; var1x < this.a; var1x++) {
               ViewCompat.a((View)this.b.get(var1x), (String)this.c.get(var1x));
               ViewCompat.a((View)this.d.get(var1x), (String)this.e.get(var1x));
            }
         }
      });
   }

   void a(View var1, ArrayList<View> var2, Map<String, String> var3) {
      OneShotPreDrawListener.a(var1, new Runnable(this, var2, var3) {
         final ArrayList a;
         final Map b;
         final FragmentTransitionImpl c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3x;
         }

         @Override
         public void run() {
            int var2x = this.a.size();

            for (int var1x = 0; var1x < var2x; var1x++) {
               View var3x = (View)this.a.get(var1x);
               String var4 = ViewCompat.o(var3x);
               if (var4 != null) {
                  ViewCompat.a(var3x, FragmentTransitionImpl.a(this.b, var4));
               }
            }
         }
      });
   }

   public abstract void a(ViewGroup var1, Object var2);

   void a(ViewGroup var1, ArrayList<View> var2, Map<String, String> var3) {
      OneShotPreDrawListener.a(var1, new Runnable(this, var2, var3) {
         final ArrayList a;
         final Map b;
         final FragmentTransitionImpl c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3x;
         }

         @Override
         public void run() {
            int var2x = this.a.size();

            for (int var1x = 0; var1x < var2x; var1x++) {
               View var4 = (View)this.a.get(var1x);
               String var3x = ViewCompat.o(var4);
               ViewCompat.a(var4, (String)this.b.get(var3x));
            }
         }
      });
   }

   public abstract void a(Object var1, Rect var2);

   public abstract void a(Object var1, View var2);

   public abstract void a(Object var1, View var2, ArrayList<View> var3);

   public abstract void a(Object var1, Object var2, ArrayList<View> var3, Object var4, ArrayList<View> var5, Object var6, ArrayList<View> var7);

   public abstract void a(Object var1, ArrayList<View> var2);

   public abstract void a(Object var1, ArrayList<View> var2, ArrayList<View> var3);

   void a(ArrayList<View> var1, View var2) {
      if (var2.getVisibility() == 0) {
         if (var2 instanceof ViewGroup) {
            ViewGroup var5 = (ViewGroup)var2;
            if (ViewGroupCompat.a(var5)) {
               var1.add(var5);
            } else {
               int var4 = var5.getChildCount();

               for (int var3 = 0; var3 < var4; var3++) {
                  this.a(var1, var5.getChildAt(var3));
               }
            }
         } else {
            var1.add(var2);
         }
      }
   }

   void a(Map<String, View> var1, View var2) {
      if (var2.getVisibility() == 0) {
         String var5 = ViewCompat.o(var2);
         if (var5 != null) {
            var1.put(var5, var2);
         }

         if (var2 instanceof ViewGroup) {
            ViewGroup var6 = (ViewGroup)var2;
            int var4 = var6.getChildCount();

            for (int var3 = 0; var3 < var4; var3++) {
               this.a(var1, var6.getChildAt(var3));
            }
         }
      }
   }

   public abstract boolean a(Object var1);

   public abstract Object b(Object var1);

   public abstract Object b(Object var1, Object var2, Object var3);

   public abstract void b(Object var1, View var2);

   public abstract void b(Object var1, View var2, ArrayList<View> var3);

   public abstract void b(Object var1, ArrayList<View> var2, ArrayList<View> var3);

   public abstract Object c(Object var1);

   public abstract void c(Object var1, View var2);
}
