package android.support.v4.view;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

public final class ViewParentCompat {
   static final ViewParentCompat.ViewParentCompatBaseImpl a;

   static {
      if (VERSION.SDK_INT >= 21) {
         a = new ViewParentCompat.ViewParentCompatApi21Impl();
      } else if (VERSION.SDK_INT >= 19) {
         a = new ViewParentCompat.ViewParentCompatApi19Impl();
      } else {
         a = new ViewParentCompat.ViewParentCompatBaseImpl();
      }
   }

   public static void a(ViewParent var0, View var1, int var2) {
      if (var0 instanceof NestedScrollingParent2) {
         ((NestedScrollingParent2)var0).c(var1, var2);
      } else if (var2 == 0) {
         a.a(var0, var1);
      }
   }

   public static void a(ViewParent var0, View var1, int var2, int var3, int var4, int var5, int var6) {
      if (var0 instanceof NestedScrollingParent2) {
         ((NestedScrollingParent2)var0).a(var1, var2, var3, var4, var5, var6);
      } else if (var6 == 0) {
         a.a(var0, var1, var2, var3, var4, var5);
      }
   }

   public static void a(ViewParent var0, View var1, int var2, int var3, int[] var4, int var5) {
      if (var0 instanceof NestedScrollingParent2) {
         ((NestedScrollingParent2)var0).a(var1, var2, var3, var4, var5);
      } else if (var5 == 0) {
         a.a(var0, var1, var2, var3, var4);
      }
   }

   public static boolean a(ViewParent var0, View var1, float var2, float var3) {
      return a.a(var0, var1, var2, var3);
   }

   public static boolean a(ViewParent var0, View var1, float var2, float var3, boolean var4) {
      return a.a(var0, var1, var2, var3, var4);
   }

   public static boolean a(ViewParent var0, View var1, View var2, int var3, int var4) {
      boolean var5;
      if (var0 instanceof NestedScrollingParent2) {
         var5 = ((NestedScrollingParent2)var0).a(var1, var2, var3, var4);
      } else if (var4 == 0) {
         var5 = a.a(var0, var1, var2, var3);
      } else {
         var5 = false;
      }

      return var5;
   }

   public static void b(ViewParent var0, View var1, View var2, int var3, int var4) {
      if (var0 instanceof NestedScrollingParent2) {
         ((NestedScrollingParent2)var0).b(var1, var2, var3, var4);
      } else if (var4 == 0) {
         a.b(var0, var1, var2, var3);
      }
   }

   static class ViewParentCompatApi19Impl extends ViewParentCompat.ViewParentCompatBaseImpl {
   }

   static class ViewParentCompatApi21Impl extends ViewParentCompat.ViewParentCompatApi19Impl {
      @Override
      public void a(ViewParent var1, View var2) {
         try {
            var1.onStopNestedScroll(var2);
         } catch (AbstractMethodError var3) {
            Log.e("ViewParentCompat", "ViewParent " + var1 + " does not implement interface " + "method onStopNestedScroll", var3);
         }
      }

      @Override
      public void a(ViewParent var1, View var2, int var3, int var4, int var5, int var6) {
         try {
            var1.onNestedScroll(var2, var3, var4, var5, var6);
         } catch (AbstractMethodError var7) {
            Log.e("ViewParentCompat", "ViewParent " + var1 + " does not implement interface " + "method onNestedScroll", var7);
         }
      }

      @Override
      public void a(ViewParent var1, View var2, int var3, int var4, int[] var5) {
         try {
            var1.onNestedPreScroll(var2, var3, var4, var5);
         } catch (AbstractMethodError var6) {
            Log.e("ViewParentCompat", "ViewParent " + var1 + " does not implement interface " + "method onNestedPreScroll", var6);
         }
      }

      @Override
      public boolean a(ViewParent var1, View var2, float var3, float var4) {
         boolean var5;
         try {
            var5 = var1.onNestedPreFling(var2, var3, var4);
         } catch (AbstractMethodError var6) {
            Log.e("ViewParentCompat", "ViewParent " + var1 + " does not implement interface " + "method onNestedPreFling", var6);
            var5 = false;
         }

         return var5;
      }

      @Override
      public boolean a(ViewParent var1, View var2, float var3, float var4, boolean var5) {
         try {
            var5 = var1.onNestedFling(var2, var3, var4, var5);
         } catch (AbstractMethodError var6) {
            Log.e("ViewParentCompat", "ViewParent " + var1 + " does not implement interface " + "method onNestedFling", var6);
            var5 = false;
         }

         return var5;
      }

      @Override
      public boolean a(ViewParent var1, View var2, View var3, int var4) {
         boolean var5;
         try {
            var5 = var1.onStartNestedScroll(var2, var3, var4);
         } catch (AbstractMethodError var6) {
            Log.e("ViewParentCompat", "ViewParent " + var1 + " does not implement interface " + "method onStartNestedScroll", var6);
            var5 = false;
         }

         return var5;
      }

      @Override
      public void b(ViewParent var1, View var2, View var3, int var4) {
         try {
            var1.onNestedScrollAccepted(var2, var3, var4);
         } catch (AbstractMethodError var5) {
            Log.e("ViewParentCompat", "ViewParent " + var1 + " does not implement interface " + "method onNestedScrollAccepted", var5);
         }
      }
   }

   static class ViewParentCompatBaseImpl {
      public void a(ViewParent var1, View var2) {
         if (var1 instanceof NestedScrollingParent) {
            ((NestedScrollingParent)var1).onStopNestedScroll(var2);
         }
      }

      public void a(ViewParent var1, View var2, int var3, int var4, int var5, int var6) {
         if (var1 instanceof NestedScrollingParent) {
            ((NestedScrollingParent)var1).onNestedScroll(var2, var3, var4, var5, var6);
         }
      }

      public void a(ViewParent var1, View var2, int var3, int var4, int[] var5) {
         if (var1 instanceof NestedScrollingParent) {
            ((NestedScrollingParent)var1).onNestedPreScroll(var2, var3, var4, var5);
         }
      }

      public boolean a(ViewParent var1, View var2, float var3, float var4) {
         boolean var5;
         if (var1 instanceof NestedScrollingParent) {
            var5 = ((NestedScrollingParent)var1).onNestedPreFling(var2, var3, var4);
         } else {
            var5 = false;
         }

         return var5;
      }

      public boolean a(ViewParent var1, View var2, float var3, float var4, boolean var5) {
         if (var1 instanceof NestedScrollingParent) {
            var5 = ((NestedScrollingParent)var1).onNestedFling(var2, var3, var4, var5);
         } else {
            var5 = false;
         }

         return var5;
      }

      public boolean a(ViewParent var1, View var2, View var3, int var4) {
         boolean var5;
         if (var1 instanceof NestedScrollingParent) {
            var5 = ((NestedScrollingParent)var1).onStartNestedScroll(var2, var3, var4);
         } else {
            var5 = false;
         }

         return var5;
      }

      public void b(ViewParent var1, View var2, View var3, int var4) {
         if (var1 instanceof NestedScrollingParent) {
            ((NestedScrollingParent)var1).onNestedScrollAccepted(var2, var3, var4);
         }
      }
   }
}
