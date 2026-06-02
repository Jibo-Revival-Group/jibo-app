package android.support.transition;

import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionManager {
   private static Transition a = new AutoTransition();
   private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> b = new ThreadLocal<>();
   private static ArrayList<ViewGroup> c = new ArrayList<>();

   static ArrayMap<ViewGroup, ArrayList<Transition>> a() {
      WeakReference var1 = b.get();
      if (var1 != null) {
         WeakReference var0 = var1;
         if (var1.get() != null) {
            return (ArrayMap<ViewGroup, ArrayList<Transition>>)var0.get();
         }
      }

      WeakReference var2 = new WeakReference<>(new ArrayMap());
      b.set(var2);
      return (ArrayMap<ViewGroup, ArrayList<Transition>>)var2.get();
   }

   public static void a(ViewGroup var0, Transition var1) {
      if (!c.contains(var0) && ViewCompat.y(var0)) {
         c.add(var0);
         Transition var2 = var1;
         if (var1 == null) {
            var2 = a;
         }

         var1 = var2.n();
         c(var0, var1);
         Scene.a(var0, null);
         b(var0, var1);
      }
   }

   private static void b(ViewGroup var0, Transition var1) {
      if (var1 != null && var0 != null) {
         TransitionManager.MultiListener var2 = new TransitionManager.MultiListener(var1, var0);
         var0.addOnAttachStateChangeListener(var2);
         var0.getViewTreeObserver().addOnPreDrawListener(var2);
      }
   }

   private static void c(ViewGroup var0, Transition var1) {
      ArrayList var2 = a().get(var0);
      if (var2 != null && var2.size() > 0) {
         Iterator var4 = var2.iterator();

         while (var4.hasNext()) {
            ((Transition)var4.next()).e(var0);
         }
      }

      if (var1 != null) {
         var1.a(var0, true);
      }

      Scene var3 = Scene.a(var0);
      if (var3 != null) {
         var3.a();
      }
   }

   private static class MultiListener implements OnAttachStateChangeListener, OnPreDrawListener {
      Transition a;
      ViewGroup b;

      MultiListener(Transition var1, ViewGroup var2) {
         this.a = var1;
         this.b = var2;
      }

      private void a() {
         this.b.getViewTreeObserver().removeOnPreDrawListener(this);
         this.b.removeOnAttachStateChangeListener(this);
      }

      public boolean onPreDraw() {
         this.a();
         if (TransitionManager.c.remove(this.b)) {
            ArrayMap var3 = TransitionManager.a();
            ArrayList var2 = (ArrayList)var3.get(this.b);
            ArrayList var1;
            if (var2 == null) {
               var2 = new ArrayList();
               var3.put(this.b, var2);
               var1 = null;
            } else if (var2.size() > 0) {
               var1 = new ArrayList(var2);
            } else {
               var1 = null;
            }

            var2.add(this.a);
            this.a.a(new TransitionListenerAdapter(this, var3) {
               final ArrayMap a;
               final TransitionManager.MultiListener b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               @Override
               public void a(Transition var1) {
                  ((ArrayList)this.a.get(this.b.b)).remove(var1);
               }
            });
            this.a.a(this.b, false);
            if (var1 != null) {
               Iterator var4 = var1.iterator();

               while (var4.hasNext()) {
                  ((Transition)var4.next()).f(this.b);
               }
            }

            this.a.a(this.b);
         }

         return true;
      }

      public void onViewAttachedToWindow(View var1) {
      }

      public void onViewDetachedFromWindow(View var1) {
         this.a();
         TransitionManager.c.remove(this.b);
         ArrayList var2 = TransitionManager.a().get(this.b);
         if (var2 != null && var2.size() > 0) {
            Iterator var3 = var2.iterator();

            while (var3.hasNext()) {
               ((Transition)var3.next()).f(this.b);
            }
         }

         this.a.b(true);
      }
   }
}
