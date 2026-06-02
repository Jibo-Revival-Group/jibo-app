package android.support.transition;

import android.graphics.Rect;
import android.support.v4.app.FragmentTransitionImpl;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class FragmentTransitionSupport extends FragmentTransitionImpl {
   private static boolean a(Transition var0) {
      boolean var1;
      if (a(var0.f()) && a(var0.h()) && a(var0.i())) {
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
         var4.b((Transition)var1);
      }

      if (var2 != null) {
         var4.b((Transition)var2);
      }

      if (var3 != null) {
         var4.b((Transition)var3);
      }

      return var4;
   }

   @Override
   public void a(ViewGroup var1, Object var2) {
      TransitionManager.a(var1, (Transition)var2);
   }

   @Override
   public void a(Object var1, Rect var2) {
      if (var1 != null) {
         ((Transition)var1).a(new Transition.EpicenterCallback(this, var2) {
            final Rect a;
            final FragmentTransitionSupport b;

            {
               this.b = var1;
               this.a = var2x;
            }

            @Override
            public Rect a(Transition var1) {
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
         var1 = var1;
         Rect var3 = new Rect();
         this.a(var2, var3);
         var1.a(new Transition.EpicenterCallback(this, var3) {
            final Rect a;
            final FragmentTransitionSupport b;

            {
               this.b = var1;
               this.a = var2x;
            }

            @Override
            public Rect a(Transition var1) {
               return this.a;
            }
         });
      }
   }

   @Override
   public void a(Object var1, View var2, ArrayList<View> var3) {
      TransitionSet var6 = (TransitionSet)var1;
      List var7 = var6.g();
      var7.clear();
      int var5 = var3.size();

      for (int var4 = 0; var4 < var5; var4++) {
         a(var7, (View)var3.get(var4));
      }

      var7.add(var2);
      var3.add(var2);
      this.a(var6, var3);
   }

   @Override
   public void a(Object var1, Object var2, ArrayList<View> var3, Object var4, ArrayList<View> var5, Object var6, ArrayList<View> var7) {
      ((Transition)var1).a(new Transition.TransitionListener(this, var2, var3, var4, var5, var6, var7) {
         final Object a;
         final ArrayList b;
         final Object c;
         final ArrayList d;
         final Object e;
         final ArrayList f;
         final FragmentTransitionSupport g;

         {
            this.g = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4x;
            this.d = var5x;
            this.e = var6x;
            this.f = var7x;
         }

         @Override
         public void a(Transition var1) {
         }

         @Override
         public void b(Transition var1) {
         }

         @Override
         public void c(Transition var1) {
         }

         @Override
         public void d(Transition var1) {
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
            var1 = var1;

            for (int var4 = var1.p(); var3 < var4; var3++) {
               this.a(var1.b(var3), var2);
            }
         } else if (!a(var1) && a(var1.g())) {
            int var8 = var2.size();

            for (int var7 = 0; var7 < var8; var7++) {
               var1.c((View)var2.get(var7));
            }
         }
      }
   }

   @Override
   public void a(Object var1, ArrayList<View> var2, ArrayList<View> var3) {
      var1 = var1;
      if (var1 != null) {
         var1.g().clear();
         var1.g().addAll(var3);
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
         var2 = ((Transition)var1).n();
      }

      return var2;
   }

   @Override
   public Object b(Object var1, Object var2, Object var3) {
      Object var4 = null;
      var1 = var1;
      var2 = var2;
      var3 = var3;
      if (var1 != null && var2 != null) {
         var1 = new TransitionSet().b(var1).b(var2).a(1);
      } else if (var1 == null) {
         var1 = (Transition)var4;
         if (var2 != null) {
            var1 = var2;
         }
      }

      if (var3 != null) {
         var2 = new TransitionSet();
         if (var1 != null) {
            var2.b(var1);
         }

         var2.b(var3);
         var1 = var2;
      }

      return var1;
   }

   @Override
   public void b(Object var1, View var2) {
      if (var1 != null) {
         ((Transition)var1).c(var2);
      }
   }

   @Override
   public void b(Object var1, View var2, ArrayList<View> var3) {
      ((Transition)var1).a(new Transition.TransitionListener(this, var2, var3) {
         final View a;
         final ArrayList b;
         final FragmentTransitionSupport c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3x;
         }

         @Override
         public void a(Transition var1) {
            var1.b(this);
            this.a.setVisibility(8);
            int var3x = this.b.size();

            for (int var2x = 0; var2x < var3x; var2x++) {
               ((View)this.b.get(var2x)).setVisibility(0);
            }
         }

         @Override
         public void b(Transition var1) {
         }

         @Override
         public void c(Transition var1) {
         }

         @Override
         public void d(Transition var1) {
         }
      });
   }

   @Override
   public void b(Object var1, ArrayList<View> var2, ArrayList<View> var3) {
      int var4 = 0;
      Transition var6 = var1;
      if (var6 instanceof TransitionSet) {
         var1 = (TransitionSet)var6;

         for (int var5 = var1.p(); var4 < var5; var4++) {
            this.b(var1.b(var4), var2, var3);
         }
      } else if (!a(var6)) {
         List var8 = var6.g();
         if (var8.size() == var2.size() && var8.containsAll(var2)) {
            if (var3 == null) {
               var4 = 0;
            } else {
               var4 = var3.size();
            }

            for (int var11 = 0; var11 < var4; var11++) {
               var6.c((View)var3.get(var11));
            }

            for (int var10 = var2.size() - 1; var10 >= 0; var10--) {
               var6.d((View)var2.get(var10));
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
         var2.b((Transition)var1);
         var3 = var2;
      }

      return var3;
   }

   @Override
   public void c(Object var1, View var2) {
      if (var1 != null) {
         ((Transition)var1).d(var2);
      }
   }
}
