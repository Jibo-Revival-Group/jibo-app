package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class FragmentTransition {
   private static final int[] a = new int[]{0, 3, 0, 1, 5, 4, 7, 6, 9, 8};
   private static final FragmentTransitionImpl b;
   private static final FragmentTransitionImpl c;

   static {
      FragmentTransitionCompat21 var0;
      if (VERSION.SDK_INT >= 21) {
         var0 = new FragmentTransitionCompat21();
      } else {
         var0 = null;
      }

      b = var0;
      c = a();
   }

   private static FragmentTransition.FragmentContainerTransition a(
      FragmentTransition.FragmentContainerTransition var0, SparseArray<FragmentTransition.FragmentContainerTransition> var1, int var2
   ) {
      FragmentTransition.FragmentContainerTransition var3 = var0;
      if (var0 == null) {
         var3 = new FragmentTransition.FragmentContainerTransition();
         var1.put(var2, var3);
      }

      return var3;
   }

   private static FragmentTransitionImpl a() {
      FragmentTransitionImpl var0;
      try {
         var0 = (FragmentTransitionImpl)Class.forName("android.support.transition.FragmentTransitionSupport").getDeclaredConstructor().newInstance();
      } catch (Exception var1) {
         var0 = null;
      }

      return var0;
   }

   private static FragmentTransitionImpl a(Fragment var0, Fragment var1) {
      Object var2 = null;
      ArrayList var3 = new ArrayList();
      if (var0 != null) {
         Object var4 = var0.getExitTransition();
         if (var4 != null) {
            var3.add(var4);
         }

         var4 = var0.getReturnTransition();
         if (var4 != null) {
            var3.add(var4);
         }

         Object var5 = var0.getSharedElementReturnTransition();
         if (var5 != null) {
            var3.add(var5);
         }
      }

      if (var1 != null) {
         Object var6 = var1.getEnterTransition();
         if (var6 != null) {
            var3.add(var6);
         }

         var6 = var1.getReenterTransition();
         if (var6 != null) {
            var3.add(var6);
         }

         var6 = var1.getSharedElementEnterTransition();
         if (var6 != null) {
            var3.add(var6);
         }
      }

      FragmentTransitionImpl var11;
      if (var3.isEmpty()) {
         var11 = (FragmentTransitionImpl)var2;
      } else if (b != null && a(b, var3)) {
         var11 = b;
      } else if (c != null && a(c, var3)) {
         var11 = c;
      } else {
         if (b == null) {
            Object var9 = var2;
            if (c == null) {
               return (FragmentTransitionImpl)var9;
            }
         }

         throw new IllegalArgumentException("Invalid Transition types");
      }

      return var11;
   }

   private static ArrayMap<String, String> a(int var0, ArrayList<BackStackRecord> var1, ArrayList<Boolean> var2, int var3, int var4) {
      ArrayMap var10 = new ArrayMap();
      var4--;

      for (; var4 >= var3; var4--) {
         BackStackRecord var11 = (BackStackRecord)var1.get(var4);
         if (var11.b(var0)) {
            boolean var7 = (Boolean)var2.get(var4);
            if (var11.r != null) {
               int var6 = var11.r.size();
               ArrayList var8;
               ArrayList var9;
               if (var7) {
                  var8 = var11.r;
                  var9 = var11.s;
               } else {
                  var9 = var11.r;
                  var8 = var11.s;
               }

               for (int var5 = 0; var5 < var6; var5++) {
                  String var12 = (String)var9.get(var5);
                  String var13 = (String)var8.get(var5);
                  String var15 = (String)var10.remove(var13);
                  if (var15 != null) {
                     var10.put(var12, var15);
                  } else {
                     var10.put(var12, var13);
                  }
               }
            }
         }
      }

      return var10;
   }

   private static Object a(FragmentTransitionImpl var0, Fragment var1, Fragment var2, boolean var3) {
      Object var4;
      if (var1 != null && var2 != null) {
         Object var5;
         if (var3) {
            var5 = var2.getSharedElementReturnTransition();
         } else {
            var5 = var1.getSharedElementEnterTransition();
         }

         var4 = var0.c(var0.b(var5));
      } else {
         var4 = null;
      }

      return var4;
   }

   private static Object a(FragmentTransitionImpl var0, Fragment var1, boolean var2) {
      Object var3;
      if (var1 == null) {
         var3 = null;
      } else {
         Object var4;
         if (var2) {
            var4 = var1.getReenterTransition();
         } else {
            var4 = var1.getEnterTransition();
         }

         var3 = var0.b(var4);
      }

      return var3;
   }

   private static Object a(
      FragmentTransitionImpl var0,
      ViewGroup var1,
      View var2,
      ArrayMap<String, String> var3,
      FragmentTransition.FragmentContainerTransition var4,
      ArrayList<View> var5,
      ArrayList<View> var6,
      Object var7,
      Object var8
   ) {
      Fragment var12 = var4.a;
      Fragment var11 = var4.d;
      if (var12 != null) {
         var12.getView().setVisibility(0);
      }

      Object var16;
      if (var12 != null && var11 != null) {
         boolean var9 = var4.b;
         Object var10;
         if (var3.isEmpty()) {
            var10 = null;
         } else {
            var10 = a(var0, var12, var11, var9);
         }

         ArrayMap var14 = b(var0, var3, var10, var4);
         ArrayMap var13 = c(var0, var3, var10, var4);
         if (var3.isEmpty()) {
            var10 = null;
            if (var14 != null) {
               var14.clear();
            }

            var16 = var10;
            if (var13 != null) {
               var13.clear();
               var16 = var10;
            }
         } else {
            a(var5, var14, var3.keySet());
            a(var6, var13, var3.values());
            var16 = var10;
         }

         if (var7 == null && var8 == null && var16 == null) {
            var16 = null;
         } else {
            b(var12, var11, var9, var14, true);
            Rect var17;
            if (var16 != null) {
               var6.add(var2);
               var0.a(var16, var2, var5);
               a(var0, var16, var8, var14, var4.e, var4.f);
               Rect var18 = new Rect();
               View var19 = b(var13, var4, var7, var9);
               var2 = var19;
               var17 = var18;
               if (var19 != null) {
                  var0.a(var7, var18);
                  var17 = var18;
                  var2 = var19;
               }
            } else {
               var17 = null;
               var2 = null;
            }

            OneShotPreDrawListener.a(var1, new Runnable(var12, var11, var9, var13, var2, var0, var17) {
               final Fragment a;
               final Fragment b;
               final boolean c;
               final ArrayMap d;
               final View e;
               final FragmentTransitionImpl f;
               final Rect g;

               {
                  this.a = var1;
                  this.b = var2x;
                  this.c = var3x;
                  this.d = var4x;
                  this.e = var5x;
                  this.f = var6x;
                  this.g = var7x;
               }

               @Override
               public void run() {
                  FragmentTransition.b(this.a, this.b, this.c, this.d, false);
                  if (this.e != null) {
                     this.f.a(this.e, this.g);
                  }
               }
            });
         }
      } else {
         var16 = null;
      }

      return var16;
   }

   private static Object a(FragmentTransitionImpl var0, Object var1, Object var2, Object var3, Fragment var4, boolean var5) {
      boolean var7 = true;
      boolean var6 = var7;
      if (var1 != null) {
         var6 = var7;
         if (var2 != null) {
            var6 = var7;
            if (var4 != null) {
               if (var5) {
                  var6 = var4.getAllowReturnTransitionOverlap();
               } else {
                  var6 = var4.getAllowEnterTransitionOverlap();
               }
            }
         }
      }

      Object var8;
      if (var6) {
         var8 = var0.a(var2, var1, var3);
      } else {
         var8 = var0.b(var2, var1, var3);
      }

      return var8;
   }

   private static String a(ArrayMap<String, String> var0, String var1) {
      int var3 = var0.size();
      int var2 = 0;

      while (true) {
         if (var2 >= var3) {
            var4 = null;
            break;
         }

         if (var1.equals(var0.c(var2))) {
            var4 = (String)var0.b(var2);
            break;
         }

         var2++;
      }

      return var4;
   }

   private static void a(
      BackStackRecord var0, BackStackRecord.Op var1, SparseArray<FragmentTransition.FragmentContainerTransition> var2, boolean var3, boolean var4
   ) {
      Fragment var11 = var1.b;
      if (var11 != null) {
         int var9 = var11.mContainerId;
         if (var9 != 0) {
            int var5;
            if (var3) {
               var5 = a[var1.a];
            } else {
               var5 = var1.a;
            }

            boolean var6;
            boolean var7;
            boolean var10;
            boolean var14;
            switch (var5) {
               case 1:
               case 7:
                  if (var4) {
                     var10 = var11.mIsNewlyAdded;
                  } else if (!var11.mAdded && !var11.mHidden) {
                     var10 = true;
                  } else {
                     var10 = false;
                  }

                  var14 = true;
                  var6 = false;
                  var7 = false;
                  break;
               case 2:
               default:
                  var14 = false;
                  var6 = false;
                  var7 = false;
                  var10 = false;
                  break;
               case 3:
               case 6:
                  if (var4) {
                     if (!var11.mAdded && var11.mView != null && var11.mView.getVisibility() == 0 && var11.mPostponedAlpha >= 0.0F) {
                        var14 = true;
                     } else {
                        var14 = false;
                     }
                  } else if (var11.mAdded && !var11.mHidden) {
                     var14 = true;
                  } else {
                     var14 = false;
                  }

                  boolean var17 = false;
                  var6 = var14;
                  var7 = true;
                  var10 = false;
                  var14 = var17;
                  break;
               case 4:
                  if (var4) {
                     if (var11.mHiddenChanged && var11.mAdded && var11.mHidden) {
                        var14 = true;
                     } else {
                        var14 = false;
                     }
                  } else if (var11.mAdded && !var11.mHidden) {
                     var14 = true;
                  } else {
                     var14 = false;
                  }

                  boolean var8 = false;
                  var6 = var14;
                  var7 = true;
                  var10 = false;
                  var14 = var8;
                  break;
               case 5:
                  if (var4) {
                     if (var11.mHiddenChanged && !var11.mHidden && var11.mAdded) {
                        var10 = true;
                     } else {
                        var10 = false;
                     }
                  } else {
                     var10 = var11.mHidden;
                  }

                  var14 = true;
                  var6 = false;
                  var7 = false;
            }

            FragmentTransition.FragmentContainerTransition var13 = (FragmentTransition.FragmentContainerTransition)var2.get(var9);
            if (var10) {
               var13 = a(var13, var2, var9);
               var13.a = var11;
               var13.b = var3;
               var13.c = var0;
            }

            if (!var4 && var14) {
               if (var13 != null && var13.d == var11) {
                  var13.d = null;
               }

               FragmentManagerImpl var12 = var0.a;
               if (var11.mState < 1 && var12.l >= 1 && !var0.t) {
                  var12.g(var11);
                  var12.a(var11, 1, 0, 0, false);
               }
            }

            if (var6 && (var13 == null || var13.d == null)) {
               var13 = a(var13, var2, var9);
               var13.d = var11;
               var13.e = var3;
               var13.f = var0;
            }

            if (!var4 && var7 && var13 != null && var13.a == var11) {
               var13.a = null;
            }
         }
      }
   }

   public static void a(BackStackRecord var0, SparseArray<FragmentTransition.FragmentContainerTransition> var1, boolean var2) {
      int var4 = var0.b.size();

      for (int var3 = 0; var3 < var4; var3++) {
         a(var0, var0.b.get(var3), var1, false, var2);
      }
   }

   private static void a(FragmentManagerImpl var0, int var1, FragmentTransition.FragmentContainerTransition var2, View var3, ArrayMap<String, String> var4) {
      ViewGroup var7 = null;
      if (var0.n.a()) {
         var7 = (ViewGroup)var0.n.a(var1);
      }

      if (var7 != null) {
         Fragment var14 = var2.a;
         Fragment var13 = var2.d;
         FragmentTransitionImpl var10 = a(var13, var14);
         if (var10 != null) {
            boolean var5 = var2.b;
            boolean var6 = var2.e;
            ArrayList var15 = new ArrayList();
            ArrayList var8 = new ArrayList();
            Object var9 = a(var10, var14, var5);
            Object var11 = b(var10, var13, var6);
            Object var12 = a(var10, var7, var3, var4, var2, var8, var15, var9, var11);
            if (var9 != null || var12 != null || var11 != null) {
               ArrayList var16 = b(var10, var11, var13, var8, var3);
               ArrayList var17 = b(var10, var9, var14, var15, var3);
               b(var17, 4);
               Object var19 = a(var10, var9, var11, var12, var14, var5);
               if (var19 != null) {
                  a(var10, var11, var13, var16);
                  ArrayList var18 = var10.a(var15);
                  var10.a(var19, var9, var17, var11, var16, var12, var15);
                  var10.a(var7, var19);
                  var10.a(var7, var8, var15, var18, var4);
                  b(var17, 0);
                  var10.a(var12, var8, var15);
               }
            }
         }
      }
   }

   static void a(FragmentManagerImpl var0, ArrayList<BackStackRecord> var1, ArrayList<Boolean> var2, int var3, int var4, boolean var5) {
      if (var0.l >= 1) {
         SparseArray var9 = new SparseArray();

         for (int var6 = var3; var6 < var4; var6++) {
            BackStackRecord var10 = (BackStackRecord)var1.get(var6);
            if ((Boolean)var2.get(var6)) {
               b(var10, var9, var5);
            } else {
               a(var10, var9, var5);
            }
         }

         if (var9.size() != 0) {
            View var14 = new View(var0.m.i());
            int var7 = var9.size();

            for (int var13 = 0; var13 < var7; var13++) {
               int var8 = var9.keyAt(var13);
               ArrayMap var12 = a(var8, var1, var2, var3, var4);
               FragmentTransition.FragmentContainerTransition var11 = (FragmentTransition.FragmentContainerTransition)var9.valueAt(var13);
               if (var5) {
                  a(var0, var8, var11, var14, var12);
               } else {
                  b(var0, var8, var11, var14, var12);
               }
            }
         }
      }
   }

   private static void a(
      FragmentTransitionImpl var0,
      ViewGroup var1,
      Fragment var2,
      View var3,
      ArrayList<View> var4,
      Object var5,
      ArrayList<View> var6,
      Object var7,
      ArrayList<View> var8
   ) {
      OneShotPreDrawListener.a(var1, new Runnable(var5, var0, var3, var2, var4, var6, var8, var7) {
         final Object a;
         final FragmentTransitionImpl b;
         final View c;
         final Fragment d;
         final ArrayList e;
         final ArrayList f;
         final ArrayList g;
         final Object h;

         {
            this.a = var1;
            this.b = var2x;
            this.c = var3x;
            this.d = var4x;
            this.e = var5x;
            this.f = var6x;
            this.g = var7x;
            this.h = var8x;
         }

         @Override
         public void run() {
            if (this.a != null) {
               this.b.c(this.a, this.c);
               ArrayList var1x = FragmentTransition.b(this.b, this.a, this.d, this.e, this.c);
               this.f.addAll(var1x);
            }

            if (this.g != null) {
               if (this.h != null) {
                  ArrayList var2x = new ArrayList();
                  var2x.add(this.c);
                  this.b.b(this.h, this.g, var2x);
               }

               this.g.clear();
               this.g.add(this.c);
            }
         }
      });
   }

   private static void a(FragmentTransitionImpl var0, Object var1, Fragment var2, ArrayList<View> var3) {
      if (var2 != null && var1 != null && var2.mAdded && var2.mHidden && var2.mHiddenChanged) {
         var2.setHideReplaced(true);
         var0.b(var1, var2.getView(), var3);
         OneShotPreDrawListener.a(var2.mContainer, new Runnable(var3) {
            final ArrayList a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               FragmentTransition.b(this.a, 4);
            }
         });
      }
   }

   private static void a(FragmentTransitionImpl var0, Object var1, Object var2, ArrayMap<String, View> var3, boolean var4, BackStackRecord var5) {
      if (var5.r != null && !var5.r.isEmpty()) {
         String var7;
         if (var4) {
            var7 = var5.s.get(0);
         } else {
            var7 = var5.r.get(0);
         }

         View var6 = (View)var3.get(var7);
         var0.a(var1, var6);
         if (var2 != null) {
            var0.a(var2, var6);
         }
      }
   }

   private static void a(ArrayMap<String, String> var0, ArrayMap<String, View> var1) {
      for (int var2 = var0.size() - 1; var2 >= 0; var2--) {
         if (!var1.containsKey((String)var0.c(var2))) {
            var0.d(var2);
         }
      }
   }

   private static void a(ArrayList<View> var0, ArrayMap<String, View> var1, Collection<String> var2) {
      for (int var3 = var1.size() - 1; var3 >= 0; var3--) {
         View var4 = (View)var1.c(var3);
         if (var2.contains(ViewCompat.o(var4))) {
            var0.add(var4);
         }
      }
   }

   private static boolean a(FragmentTransitionImpl var0, List<Object> var1) {
      boolean var4 = false;
      int var3 = var1.size();
      int var2 = 0;

      while (true) {
         if (var2 >= var3) {
            var4 = true;
            break;
         }

         if (!var0.a(var1.get(var2))) {
            break;
         }

         var2++;
      }

      return var4;
   }

   private static ArrayMap<String, View> b(
      FragmentTransitionImpl var0, ArrayMap<String, String> var1, Object var2, FragmentTransition.FragmentContainerTransition var3
   ) {
      ArrayMap var6;
      if (!var1.isEmpty() && var2 != null) {
         var2 = var3.d;
         ArrayMap var5 = new ArrayMap();
         var0.a(var5, var2.getView());
         BackStackRecord var7 = var3.f;
         ArrayList var8;
         SharedElementCallback var10;
         if (var3.e) {
            var10 = var2.getEnterTransitionCallback();
            var8 = var7.s;
         } else {
            var10 = var2.getExitTransitionCallback();
            var8 = var7.r;
         }

         var5.a(var8);
         if (var10 != null) {
            var10.a(var8, var5);

            for (int var4 = var8.size() - 1; var4 >= 0; var4--) {
               String var12 = (String)var8.get(var4);
               View var11 = (View)var5.get(var12);
               if (var11 == null) {
                  var1.remove(var12);
               } else if (!var12.equals(ViewCompat.o(var11))) {
                  String var13 = (String)var1.remove(var12);
                  var1.put(ViewCompat.o(var11), var13);
               }
            }
         } else {
            var1.a(var5.keySet());
         }

         var6 = var5;
      } else {
         var1.clear();
         var6 = null;
      }

      return var6;
   }

   private static View b(ArrayMap<String, View> var0, FragmentTransition.FragmentContainerTransition var1, Object var2, boolean var3) {
      BackStackRecord var5 = var1.c;
      View var4;
      if (var2 != null && var0 != null && var5.r != null && !var5.r.isEmpty()) {
         String var6;
         if (var3) {
            var6 = var5.r.get(0);
         } else {
            var6 = var5.s.get(0);
         }

         var4 = (View)var0.get(var6);
      } else {
         var4 = null;
      }

      return var4;
   }

   private static Object b(FragmentTransitionImpl var0, Fragment var1, boolean var2) {
      Object var3;
      if (var1 == null) {
         var3 = null;
      } else {
         Object var4;
         if (var2) {
            var4 = var1.getReturnTransition();
         } else {
            var4 = var1.getExitTransition();
         }

         var3 = var0.b(var4);
      }

      return var3;
   }

   private static Object b(
      FragmentTransitionImpl var0,
      ViewGroup var1,
      View var2,
      ArrayMap<String, String> var3,
      FragmentTransition.FragmentContainerTransition var4,
      ArrayList<View> var5,
      ArrayList<View> var6,
      Object var7,
      Object var8
   ) {
      Fragment var13 = var4.a;
      Fragment var12 = var4.d;
      Object var10;
      if (var13 != null && var12 != null) {
         boolean var9 = var4.b;
         if (var3.isEmpty()) {
            var10 = null;
         } else {
            var10 = a(var0, var13, var12, var9);
         }

         ArrayMap var14 = b(var0, var3, var10, var4);
         if (var3.isEmpty()) {
            var10 = null;
         } else {
            var5.addAll(var14.values());
         }

         if (var7 == null && var8 == null && var10 == null) {
            var10 = null;
         } else {
            b(var13, var12, var9, var14, true);
            if (var10 != null) {
               Rect var11 = new Rect();
               var0.a(var10, var2, var5);
               a(var0, var10, var8, var14, var4.e, var4.f);
               var8 = var11;
               if (var7 != null) {
                  var0.a(var7, var11);
                  var8 = var11;
               }
            } else {
               var8 = null;
            }

            OneShotPreDrawListener.a(var1, new Runnable(var0, var3, var10, var4, var6, var2, var13, var12, var9, var5, var7, var8) {
               final FragmentTransitionImpl a;
               final ArrayMap b;
               final Object c;
               final FragmentTransition.FragmentContainerTransition d;
               final ArrayList e;
               final View f;
               final Fragment g;
               final Fragment h;
               final boolean i;
               final ArrayList j;
               final Object k;
               final Rect l;

               {
                  this.a = var1;
                  this.b = var2x;
                  this.c = var3x;
                  this.d = var4x;
                  this.e = var5x;
                  this.f = var6x;
                  this.g = var7x;
                  this.h = var8x;
                  this.i = var9x;
                  this.j = var10x;
                  this.k = var11;
                  this.l = var12x;
               }

               @Override
               public void run() {
                  ArrayMap var1x = FragmentTransition.c(this.a, this.b, this.c, this.d);
                  if (var1x != null) {
                     this.e.addAll(var1x.values());
                     this.e.add(this.f);
                  }

                  FragmentTransition.b(this.g, this.h, this.i, var1x, false);
                  if (this.c != null) {
                     this.a.a(this.c, this.j, this.e);
                     View var2x = FragmentTransition.b(var1x, this.d, this.k, this.i);
                     if (var2x != null) {
                        this.a.a(var2x, this.l);
                     }
                  }
               }
            });
         }
      } else {
         var10 = null;
      }

      return var10;
   }

   private static ArrayList<View> b(FragmentTransitionImpl var0, Object var1, Fragment var2, ArrayList<View> var3, View var4) {
      ArrayList var5 = null;
      if (var1 != null) {
         ArrayList var6 = new ArrayList();
         View var7 = var2.getView();
         if (var7 != null) {
            var0.a(var6, var7);
         }

         if (var3 != null) {
            var6.removeAll(var3);
         }

         var5 = var6;
         if (!var6.isEmpty()) {
            var6.add(var4);
            var0.a(var1, var6);
            var5 = var6;
         }
      }

      return var5;
   }

   public static void b(BackStackRecord var0, SparseArray<FragmentTransition.FragmentContainerTransition> var1, boolean var2) {
      if (var0.a.n.a()) {
         for (int var3 = var0.b.size() - 1; var3 >= 0; var3--) {
            a(var0, var0.b.get(var3), var1, true, var2);
         }
      }
   }

   private static void b(Fragment var0, Fragment var1, boolean var2, ArrayMap<String, View> var3, boolean var4) {
      int var6 = 0;
      SharedElementCallback var8;
      if (var2) {
         var8 = var1.getEnterTransitionCallback();
      } else {
         var8 = var0.getEnterTransitionCallback();
      }

      if (var8 != null) {
         ArrayList var9 = new ArrayList();
         ArrayList var7 = new ArrayList();
         int var5;
         if (var3 == null) {
            var5 = 0;
         } else {
            var5 = var3.size();
         }

         while (var6 < var5) {
            var7.add(var3.b(var6));
            var9.add(var3.c(var6));
            var6++;
         }

         if (var4) {
            var8.a(var7, var9, null);
         } else {
            var8.b(var7, var9, null);
         }
      }
   }

   private static void b(FragmentManagerImpl var0, int var1, FragmentTransition.FragmentContainerTransition var2, View var3, ArrayMap<String, String> var4) {
      ViewGroup var7 = null;
      if (var0.n.a()) {
         var7 = (ViewGroup)var0.n.a(var1);
      }

      if (var7 != null) {
         Fragment var9 = var2.a;
         Fragment var13 = var2.d;
         FragmentTransitionImpl var8 = a(var13, var9);
         if (var8 != null) {
            boolean var6 = var2.b;
            boolean var5 = var2.e;
            Object var12 = a(var8, var9, var6);
            Object var15 = b(var8, var13, var5);
            ArrayList var14 = new ArrayList();
            ArrayList var10 = new ArrayList();
            Object var11 = b(var8, var7, var3, var4, var2, var14, var10, var12, var15);
            if (var12 != null || var11 != null || var15 != null) {
               ArrayList var17 = b(var8, var15, var13, var14, var3);
               if (var17 == null || var17.isEmpty()) {
                  var15 = null;
               }

               var8.b(var12, var3);
               Object var16 = a(var8, var12, var15, var11, var9, var2.b);
               if (var16 != null) {
                  var14 = new ArrayList();
                  var8.a(var16, var12, var14, var15, var17, var11, var10);
                  a(var8, var7, var9, var3, var10, var12, var14, var15, var17);
                  var8.a(var7, var10, var4);
                  var8.a(var7, var16);
                  var8.a(var7, var10, var4);
               }
            }
         }
      }
   }

   private static void b(ArrayList<View> var0, int var1) {
      if (var0 != null) {
         for (int var2 = var0.size() - 1; var2 >= 0; var2--) {
            ((View)var0.get(var2)).setVisibility(var1);
         }
      }
   }

   private static ArrayMap<String, View> c(
      FragmentTransitionImpl var0, ArrayMap<String, String> var1, Object var2, FragmentTransition.FragmentContainerTransition var3
   ) {
      Fragment var6 = var3.a;
      View var7 = var6.getView();
      ArrayMap var8;
      if (!var1.isEmpty() && var2 != null && var7 != null) {
         ArrayMap var5 = new ArrayMap();
         var0.a(var5, var7);
         BackStackRecord var9 = var3.c;
         ArrayList var10;
         if (var3.b) {
            var2 = var6.getExitTransitionCallback();
            var10 = var9.r;
         } else {
            var2 = var6.getEnterTransitionCallback();
            var10 = var9.s;
         }

         if (var10 != null) {
            var5.a(var10);
            var5.a(var1.values());
         }

         if (var2 != null) {
            var2.a(var10, var5);

            for (int var4 = var10.size() - 1; var4 >= 0; var4--) {
               String var14 = (String)var10.get(var4);
               View var12 = (View)var5.get(var14);
               if (var12 == null) {
                  String var13 = a(var1, var14);
                  if (var13 != null) {
                     var1.remove(var13);
                  }
               } else if (!var14.equals(ViewCompat.o(var12))) {
                  String var15 = a(var1, var14);
                  if (var15 != null) {
                     var1.put(var15, ViewCompat.o(var12));
                  }
               }
            }
         } else {
            a(var1, var5);
         }

         var8 = var5;
      } else {
         var1.clear();
         var8 = null;
      }

      return var8;
   }

   static class FragmentContainerTransition {
      public Fragment a;
      public boolean b;
      public BackStackRecord c;
      public Fragment d;
      public boolean e;
      public BackStackRecord f;
   }
}
