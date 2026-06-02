package android.support.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewGroupUtilsApi14 implements ViewGroupUtilsImpl {
   private static LayoutTransition a;
   private static Field b;
   private static boolean c;
   private static Method d;
   private static boolean e;

   private static void a(LayoutTransition var0) {
      if (!e) {
         try {
            d = LayoutTransition.class.getDeclaredMethod("cancel");
            d.setAccessible(true);
         } catch (NoSuchMethodException var4) {
            Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
         }

         e = true;
      }

      if (d != null) {
         try {
            d.invoke(var0);
         } catch (IllegalAccessException var2) {
            Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
         } catch (InvocationTargetException var3) {
            Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
         }
      }
   }

   @Override
   public ViewGroupOverlayImpl a(ViewGroup var1) {
      return ViewGroupOverlayApi14.a(var1);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public void a(ViewGroup var1, boolean var2) {
      boolean var3 = false;
      boolean var4 = false;
      if (a == null) {
         a = new LayoutTransition(this) {
            final ViewGroupUtilsApi14 a;

            {
               this.a = var1;
            }

            public boolean isChangingLayout() {
               return true;
            }
         };
         a.setAnimator(2, null);
         a.setAnimator(0, null);
         a.setAnimator(1, null);
         a.setAnimator(3, null);
         a.setAnimator(4, null);
      }

      if (var2) {
         LayoutTransition var5 = var1.getLayoutTransition();
         if (var5 != null) {
            if (var5.isRunning()) {
               a(var5);
            }

            if (var5 != a) {
               var1.setTag(R.id.transition_layout_save, var5);
            }
         }

         var1.setLayoutTransition(a);
      } else {
         var1.setLayoutTransition(null);
         if (!c) {
            try {
               b = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
               b.setAccessible(true);
            } catch (NoSuchFieldException var6) {
               Log.i("ViewGroupUtilsApi14", "Failed to access mLayoutSuppressed field by reflection");
            }

            c = true;
         }

         var2 = var4;
         label56:
         if (b != null) {
            var2 = var3;

            try {
               var3 = b.getBoolean(var1);
            } catch (IllegalAccessException var8) {
               Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
               break label56;
            }

            var2 = var3;
            label51:
            if (var3) {
               var2 = var3;

               try {
                  b.setBoolean(var1, false);
               } catch (IllegalAccessException var7) {
                  Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
                  break label51;
               }

               var2 = var3;
            }
         }

         if (var2) {
            var1.requestLayout();
         }

         LayoutTransition var11 = (LayoutTransition)var1.getTag(R.id.transition_layout_save);
         if (var11 != null) {
            var1.setTag(R.id.transition_layout_save, null);
            var1.setLayoutTransition(var11);
         }
      }
   }
}
