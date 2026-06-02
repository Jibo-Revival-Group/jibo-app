package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.transition.Transition.EpicenterCallback;
import android.transition.Transition.TransitionListener;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

class FragmentTransitionCompat21 extends FragmentTransitionImpl {
   private static boolean a(Transition var0) {
      boolean var1;
      if (a(var0.getTargetIds()) && a(var0.getTargetNames()) && a(var0.getTargetTypes())) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   @Override
   public Object a(Object var1, Object var2, Object var3) {
      TransitionSet var4 = new TransitionSet();
      if (var1 != null) {
         var4.addTransition((Transition)var1);
      }

      if (var2 != null) {
         var4.addTransition((Transition)var2);
      }

      if (var3 != null) {
         var4.addTransition((Transition)var3);
      }

      return var4;
   }

   @Override
   public void a(ViewGroup var1, Object var2) {
      TransitionManager.beginDelayedTransition(var1, (Transition)var2);
   }

   @Override
   public void a(Object var1, Rect var2) {
      if (var1 != null) {
         ((Transition)var1).setEpicenterCallback(new EpicenterCallback(this, var2) {
            final Rect a;
            final FragmentTransitionCompat21 b;

            {
               this.b = var1;
               this.a = var2x;
            }

            public Rect onGetEpicenter(Transition var1) {
               Rect var2x;
               if (this.a != null && !this.a.isEmpty()) {
                  var2x = this.a;
               } else {
                  var2x = null;
               }

               return var2x;
            }
         });
      }
   }

   @Override
   public void a(Object var1, View var2) {
      if (var2 != null) {
         Transition var3 = (Transition)var1;
         Rect var4 = new Rect();
         this.a(var2, var4);
         var3.setEpicenterCallback(new EpicenterCallback(this, var4) {
            final Rect a;
            final FragmentTransitionCompat21 b;

            {
               this.b = var1;
               this.a = var2x;
            }

            public Rect onGetEpicenter(Transition var1) {
               return this.a;
            }
         });
      }
   }

   @Override
   public void a(Object var1, View var2, ArrayList<View> var3) {
      var1 = var1;
      List var6 = var1.getTargets();
      var6.clear();
      int var5 = var3.size();

      for (int var4 = 0; var4 < var5; var4++) {
         a(var6, (View)var3.get(var4));
      }

      var6.add(var2);
      var3.add(var2);
      this.a(var1, var3);
   }

   @Override
   public void a(Object var1, Object var2, ArrayList<View> var3, Object var4, ArrayList<View> var5, Object var6, ArrayList<View> var7) {
      ((Transition)var1).addListener(new TransitionListener(this, var2, var3, var4, var5, var6, var7) {
         final Object a;
         final ArrayList b;
         final Object c;
         final ArrayList d;
         final Object e;
         final ArrayList f;
         final FragmentTransitionCompat21 g;

         {
            this.g = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4x;
            this.d = var5x;
            this.e = var6x;
            this.f = var7x;
         }

         public void onTransitionCancel(Transition var1) {
         }

         public void onTransitionEnd(Transition var1) {
         }

         public void onTransitionPause(Transition var1) {
         }

         public void onTransitionResume(Transition var1) {
         }

         public void onTransitionStart(Transition var1) {
            if (this.a != null) {
               this.g.b(this.a, this.b, null);
            }

            if (this.c != null) {
               this.g.b(this.c, this.d, null);
            }

            if (this.e != null) {
               this.g.b(this.e, this.f, null);
            }
         }
      });
   }

   @Override
   public void a(Object var1, ArrayList<View> var2) {
      int var3 = 0;
      var1 = var1;
      if (var1 != null) {
         if (var1 instanceof TransitionSet) {
            TransitionSet var6 = (TransitionSet)var1;

            for (int var4 = var6.getTransitionCount(); var3 < var4; var3++) {
               this.a(var6.getTransitionAt(var3), var2);
            }
         } else if (!a(var1) && a(var1.getTargets())) {
            int var8 = var2.size();

            for (int var7 = 0; var7 < var8; var7++) {
               var1.addTarget((View)var2.get(var7));
            }
         }
      }
   }

   @Override
   public void a(Object var1, ArrayList<View> var2, ArrayList<View> var3) {
      var1 = var1;
      if (var1 != null) {
         var1.getTargets().clear();
         var1.getTargets().addAll(var3);
         this.b(var1, var2, var3);
      }
   }

   @Override
   public boolean a(Object var1) {
      return var1 instanceof Transition;
   }

   @Override
   public Object b(Object var1) {
      Transition var2 = null;
      if (var1 != null) {
         var2 = ((Transition)var1).clone();
      }

      return var2;
   }

   @Override
   public Object b(Object var1, Object var2, Object var3) {
      Object var4 = null;
      var1 = (Transition)var1;
      var2 = var2;
      var3 = var3;
      if (var1 != null && var2 != null) {
         var1 = new TransitionSet().addTransition((Transition)var1).addTransition(var2).setOrdering(1);
      } else if (var1 == null) {
         var1 = var4;
         if (var2 != null) {
            var1 = var2;
         }
      }

      if (var3 != null) {
         TransitionSet var7 = new TransitionSet();
         if (var1 != null) {
            var7.addTransition((Transition)var1);
         }

         var7.addTransition(var3);
         var1 = var7;
      }

      return var1;
   }

   @Override
   public void b(Object var1, View var2) {
      if (var1 != null) {
         ((Transition)var1).addTarget(var2);
      }
   }

   @Override
   public void b(Object var1, View var2, ArrayList<View> var3) {
      ((Transition)var1).addListener(new TransitionListener(this, var2, var3) {
         final View a;
         final ArrayList b;
         final FragmentTransitionCompat21 c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3x;
         }

         public void onTransitionCancel(Transition var1) {
         }

         public void onTransitionEnd(Transition var1) {
            var1.removeListener(this);
            this.a.setVisibility(8);
            int var3x = this.b.size();

            for (int var2x = 0; var2x < var3x; var2x++) {
               ((View)this.b.get(var2x)).setVisibility(0);
            }
         }

         public void onTransitionPause(Transition var1) {
         }

         public void onTransitionResume(Transition var1) {
         }

         public void onTransitionStart(Transition var1) {
         }
      });
   }

   @Override
   public void b(Object var1, ArrayList<View> var2, ArrayList<View> var3) {
      int var4 = 0;
      var1 = var1;
      if (var1 instanceof TransitionSet) {
         TransitionSet var8 = (TransitionSet)var1;

         for (int var5 = var8.getTransitionCount(); var4 < var5; var4++) {
            this.b(var8.getTransitionAt(var4), var2, var3);
         }
      } else if (!a(var1)) {
         List var6 = var1.getTargets();
         if (var6 != null && var6.size() == var2.size() && var6.containsAll(var2)) {
            if (var3 == null) {
               var4 = 0;
            } else {
               var4 = var3.size();
            }

            for (int var11 = 0; var11 < var4; var11++) {
               var1.addTarget((View)var3.get(var11));
            }

            for (int var10 = var2.size() - 1; var10 >= 0; var10--) {
               var1.removeTarget((View)var2.get(var10));
            }
         }
      }
   }

   @Override
   public Object c(Object var1) {
      TransitionSet var3;
      if (var1 == null) {
         var3 = null;
      } else {
         TransitionSet var2 = new TransitionSet();
         var2.addTransition((Transition)var1);
         var3 = var2;
      }

      return var3;
   }

   @Override
   public void c(Object var1, View var2) {
      if (var1 != null) {
         ((Transition)var1).removeTarget(var2);
      }
   }
}
