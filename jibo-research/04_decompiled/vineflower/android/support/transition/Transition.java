package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public abstract class Transition implements Cloneable {
   private static final int[] g = new int[]{2, 1, 3, 4};
   private static final PathMotion h = new PathMotion() {
      @Override
      public Path a(float var1, float var2, float var3, float var4) {
         Path var5 = new Path();
         var5.moveTo(var1, var2);
         var5.lineTo(var3, var4);
         return var5;
      }
   };
   private static ThreadLocal<ArrayMap<Animator, Transition.AnimationInfo>> z = new ThreadLocal<>();
   private ViewGroup A;
   private ArrayList<Animator> B;
   private int C;
   private boolean D;
   private boolean E;
   private ArrayList<Transition.TransitionListener> F;
   private ArrayList<Animator> G;
   private Transition.EpicenterCallback H;
   private ArrayMap<String, String> I;
   private PathMotion J;
   long a;
   ArrayList<Integer> b;
   ArrayList<View> c;
   TransitionSet d;
   boolean e;
   TransitionPropagation f;
   private String i = this.getClass().getName();
   private long j = -1L;
   private TimeInterpolator k;
   private ArrayList<String> l;
   private ArrayList<Class> m;
   private ArrayList<Integer> n;
   private ArrayList<View> o;
   private ArrayList<Class> p;
   private ArrayList<String> q;
   private ArrayList<Integer> r;
   private ArrayList<View> s;
   private ArrayList<Class> t;
   private TransitionValuesMaps u;
   private TransitionValuesMaps v;
   private int[] w;
   private ArrayList<TransitionValues> x;
   private ArrayList<TransitionValues> y;

   public Transition() {
      this.a = -1L;
      this.k = null;
      this.b = new ArrayList<>();
      this.c = new ArrayList<>();
      this.l = null;
      this.m = null;
      this.n = null;
      this.o = null;
      this.p = null;
      this.q = null;
      this.r = null;
      this.s = null;
      this.t = null;
      this.u = new TransitionValuesMaps();
      this.v = new TransitionValuesMaps();
      this.d = null;
      this.w = g;
      this.A = null;
      this.e = false;
      this.B = new ArrayList<>();
      this.C = 0;
      this.D = false;
      this.E = false;
      this.F = null;
      this.G = new ArrayList<>();
      this.J = h;
   }

   public Transition(Context var1, AttributeSet var2) {
      this.a = -1L;
      this.k = null;
      this.b = new ArrayList<>();
      this.c = new ArrayList<>();
      this.l = null;
      this.m = null;
      this.n = null;
      this.o = null;
      this.p = null;
      this.q = null;
      this.r = null;
      this.s = null;
      this.t = null;
      this.u = new TransitionValuesMaps();
      this.v = new TransitionValuesMaps();
      this.d = null;
      this.w = g;
      this.A = null;
      this.e = false;
      this.B = new ArrayList<>();
      this.C = 0;
      this.D = false;
      this.E = false;
      this.F = null;
      this.G = new ArrayList<>();
      this.J = h;
      TypedArray var6 = var1.obtainStyledAttributes(var2, Styleable.c);
      XmlResourceParser var8 = (XmlResourceParser)var2;
      long var4 = TypedArrayUtils.a(var6, var8, "duration", 1, -1);
      if (var4 >= 0L) {
         this.a(var4);
      }

      var4 = TypedArrayUtils.a(var6, var8, "startDelay", 2, -1);
      if (var4 > 0L) {
         this.b(var4);
      }

      int var3 = TypedArrayUtils.c(var6, var8, "interpolator", 0, 0);
      if (var3 > 0) {
         this.a(AnimationUtils.loadInterpolator(var1, var3));
      }

      String var7 = TypedArrayUtils.a(var6, var8, "matchOrder", 3);
      if (var7 != null) {
         this.a(b(var7));
      }

      var6.recycle();
   }

   private void a(Animator var1, ArrayMap<Animator, Transition.AnimationInfo> var2) {
      if (var1 != null) {
         var1.addListener(new AnimatorListenerAdapter(this, var2) {
            final ArrayMap a;
            final Transition b;

            {
               this.b = var1;
               this.a = var2x;
            }

            public void onAnimationEnd(Animator var1) {
               this.a.remove(var1);
               this.b.B.remove(var1);
            }

            public void onAnimationStart(Animator var1) {
               this.b.B.add(var1);
            }
         });
         this.a(var1);
      }
   }

   private void a(TransitionValuesMaps var1, TransitionValuesMaps var2) {
      ArrayMap var5 = new ArrayMap(var1.a);
      ArrayMap var4 = new ArrayMap(var2.a);

      for (int var3 = 0; var3 < this.w.length; var3++) {
         switch (this.w[var3]) {
            case 1:
               this.a(var5, var4);
               break;
            case 2:
               this.a(var5, var4, var1.d, var2.d);
               break;
            case 3:
               this.a(var5, var4, var1.b, var2.b);
               break;
            case 4:
               this.a(var5, var4, var1.c, var2.c);
         }
      }

      this.b(var5, var4);
   }

   private static void a(TransitionValuesMaps var0, View var1, TransitionValues var2) {
      var0.a.put(var1, var2);
      int var3 = var1.getId();
      if (var3 >= 0) {
         if (var0.b.indexOfKey(var3) >= 0) {
            var0.b.put(var3, null);
         } else {
            var0.b.put(var3, var1);
         }
      }

      String var7 = ViewCompat.o(var1);
      if (var7 != null) {
         if (var0.d.containsKey(var7)) {
            var0.d.put(var7, null);
         } else {
            var0.d.put(var7, var1);
         }
      }

      if (var1.getParent() instanceof ListView) {
         ListView var8 = (ListView)var1.getParent();
         if (var8.getAdapter().hasStableIds()) {
            long var4 = var8.getItemIdAtPosition(var8.getPositionForView(var1));
            if (var0.c.c(var4) >= 0) {
               var1 = var0.c.a(var4);
               if (var1 != null) {
                  ViewCompat.a(var1, false);
                  var0.c.b(var4, null);
               }
            } else {
               ViewCompat.a(var1, true);
               var0.c.b(var4, var1);
            }
         }
      }
   }

   private void a(ArrayMap<View, TransitionValues> var1, ArrayMap<View, TransitionValues> var2) {
      for (int var3 = var1.size() - 1; var3 >= 0; var3--) {
         View var4 = (View)var1.b(var3);
         if (var4 != null && this.b(var4)) {
            TransitionValues var5 = (TransitionValues)var2.remove(var4);
            if (var5 != null && var5.b != null && this.b(var5.b)) {
               TransitionValues var6 = (TransitionValues)var1.d(var3);
               this.x.add(var6);
               this.y.add(var5);
            }
         }
      }
   }

   private void a(ArrayMap<View, TransitionValues> var1, ArrayMap<View, TransitionValues> var2, ArrayMap<String, View> var3, ArrayMap<String, View> var4) {
      int var6 = var3.size();

      for (int var5 = 0; var5 < var6; var5++) {
         View var9 = (View)var3.c(var5);
         if (var9 != null && this.b(var9)) {
            View var7 = (View)var4.get(var3.b(var5));
            if (var7 != null && this.b(var7)) {
               TransitionValues var10 = (TransitionValues)var1.get(var9);
               TransitionValues var8 = (TransitionValues)var2.get(var7);
               if (var10 != null && var8 != null) {
                  this.x.add(var10);
                  this.y.add(var8);
                  var1.remove(var9);
                  var2.remove(var7);
               }
            }
         }
      }
   }

   private void a(ArrayMap<View, TransitionValues> var1, ArrayMap<View, TransitionValues> var2, LongSparseArray<View> var3, LongSparseArray<View> var4) {
      int var6 = var3.b();

      for (int var5 = 0; var5 < var6; var5++) {
         View var8 = (View)var3.c(var5);
         if (var8 != null && this.b(var8)) {
            View var7 = (View)var4.a(var3.b(var5));
            if (var7 != null && this.b(var7)) {
               TransitionValues var10 = (TransitionValues)var1.get(var8);
               TransitionValues var9 = (TransitionValues)var2.get(var7);
               if (var10 != null && var9 != null) {
                  this.x.add(var10);
                  this.y.add(var9);
                  var1.remove(var8);
                  var2.remove(var7);
               }
            }
         }
      }
   }

   private void a(ArrayMap<View, TransitionValues> var1, ArrayMap<View, TransitionValues> var2, SparseArray<View> var3, SparseArray<View> var4) {
      int var6 = var3.size();

      for (int var5 = 0; var5 < var6; var5++) {
         View var10 = (View)var3.valueAt(var5);
         if (var10 != null && this.b(var10)) {
            View var7 = (View)var4.get(var3.keyAt(var5));
            if (var7 != null && this.b(var7)) {
               TransitionValues var8 = (TransitionValues)var1.get(var10);
               TransitionValues var9 = (TransitionValues)var2.get(var7);
               if (var8 != null && var9 != null) {
                  this.x.add(var8);
                  this.y.add(var9);
                  var1.remove(var10);
                  var2.remove(var7);
               }
            }
         }
      }
   }

   private static boolean a(int var0) {
      boolean var1 = true;
      if (var0 < 1 || var0 > 4) {
         var1 = false;
      }

      return var1;
   }

   private static boolean a(TransitionValues var0, TransitionValues var1, String var2) {
      boolean var4 = true;
      Object var5 = var0.a.get(var2);
      Object var6 = var1.a.get(var2);
      boolean var3;
      if (var5 == null && var6 == null) {
         var3 = false;
      } else {
         var3 = var4;
         if (var5 != null) {
            var3 = var4;
            if (var6 != null) {
               var3 = var4;
               if (var5.equals(var6)) {
                  var3 = false;
               }
            }
         }
      }

      return var3;
   }

   private static boolean a(int[] var0, int var1) {
      boolean var5 = false;
      int var3 = var0[var1];
      int var2 = 0;

      boolean var4;
      while (true) {
         var4 = var5;
         if (var2 >= var1) {
            break;
         }

         if (var0[var2] == var3) {
            var4 = true;
            break;
         }

         var2++;
      }

      return var4;
   }

   private void b(ArrayMap<View, TransitionValues> var1, ArrayMap<View, TransitionValues> var2) {
      byte var5 = 0;
      int var4 = 0;

      while (true) {
         int var3 = var5;
         if (var4 >= var1.size()) {
            for (; var3 < var2.size(); var3++) {
               TransitionValues var7 = (TransitionValues)var2.c(var3);
               if (this.b(var7.b)) {
                  this.y.add(var7);
                  this.x.add(null);
               }
            }

            return;
         }

         TransitionValues var6 = (TransitionValues)var1.c(var4);
         if (this.b(var6.b)) {
            this.x.add(var6);
            this.y.add(null);
         }

         var4++;
      }
   }

   private static int[] b(String var0) {
      StringTokenizer var3 = new StringTokenizer(var0, ",");
      int[] var4 = new int[var3.countTokens()];

      for (int var1 = 0; var3.hasMoreTokens(); var1++) {
         String var2 = var3.nextToken().trim();
         if ("id".equalsIgnoreCase(var2)) {
            var4[var1] = 3;
         } else if ("instance".equalsIgnoreCase(var2)) {
            var4[var1] = 1;
         } else if ("name".equalsIgnoreCase(var2)) {
            var4[var1] = 2;
         } else if ("itemId".equalsIgnoreCase(var2)) {
            var4[var1] = 4;
         } else {
            if (!var2.isEmpty()) {
               throw new InflateException("Unknown match type in matchOrder: '" + var2 + "'");
            }

            int[] var5 = new int[var4.length - 1];
            System.arraycopy(var4, 0, var5, 0, var1);
            var1--;
            var4 = var5;
         }
      }

      return var4;
   }

   private void c(View var1, boolean var2) {
      if (var1 != null) {
         int var5 = var1.getId();
         if ((this.n == null || !this.n.contains(var5)) && (this.o == null || !this.o.contains(var1))) {
            if (this.p != null) {
               int var4 = this.p.size();

               for (int var3 = 0; var3 < var4; var3++) {
                  if (this.p.get(var3).isInstance(var1)) {
                     return;
                  }
               }
            }

            if (var1.getParent() instanceof ViewGroup) {
               TransitionValues var6 = new TransitionValues();
               var6.b = var1;
               if (var2) {
                  this.a(var6);
               } else {
                  this.b(var6);
               }

               var6.c.add(this);
               this.c(var6);
               if (var2) {
                  a(this.u, var1, var6);
               } else {
                  a(this.v, var1, var6);
               }
            }

            if (var1 instanceof ViewGroup && (this.r == null || !this.r.contains(var5)) && (this.s == null || !this.s.contains(var1))) {
               if (this.t != null) {
                  int var10 = this.t.size();

                  for (int var8 = 0; var8 < var10; var8++) {
                     if (this.t.get(var8).isInstance(var1)) {
                        return;
                     }
                  }
               }

               ViewGroup var7 = (ViewGroup)var1;

               for (int var9 = 0; var9 < var7.getChildCount(); var9++) {
                  this.c(var7.getChildAt(var9), var2);
               }
            }
         }
      }
   }

   private static ArrayMap<Animator, Transition.AnimationInfo> p() {
      ArrayMap var1 = z.get();
      ArrayMap var0 = var1;
      if (var1 == null) {
         var0 = new ArrayMap();
         z.set(var0);
      }

      return var0;
   }

   public Animator a(ViewGroup var1, TransitionValues var2, TransitionValues var3) {
      return null;
   }

   public Transition a(long var1) {
      this.a = var1;
      return this;
   }

   public Transition a(TimeInterpolator var1) {
      this.k = var1;
      return this;
   }

   public Transition a(Transition.TransitionListener var1) {
      if (this.F == null) {
         this.F = new ArrayList<>();
      }

      this.F.add(var1);
      return this;
   }

   public TransitionValues a(View var1, boolean var2) {
      TransitionValues var4;
      if (this.d != null) {
         var4 = this.d.a(var1, var2);
      } else {
         TransitionValuesMaps var3;
         if (var2) {
            var3 = this.u;
         } else {
            var3 = this.v;
         }

         var4 = var3.a.get(var1);
      }

      return var4;
   }

   String a(String var1) {
      byte var3 = 0;
      String var4 = var1 + this.getClass().getSimpleName() + "@" + Integer.toHexString(this.hashCode()) + ": ";
      var1 = var4;
      if (this.a != -1L) {
         var1 = var4 + "dur(" + this.a + ") ";
      }

      var4 = var1;
      if (this.j != -1L) {
         var4 = var1 + "dly(" + this.j + ") ";
      }

      var1 = var4;
      if (this.k != null) {
         var1 = var4 + "interp(" + this.k + ") ";
      }

      if (this.b.size() <= 0) {
         var4 = var1;
         if (this.c.size() <= 0) {
            return var4;
         }
      }

      var1 = var1 + "tgts(";
      if (this.b.size() > 0) {
         int var2 = 0;

         while (true) {
            var4 = var1;
            if (var2 >= this.b.size()) {
               break;
            }

            var4 = var1;
            if (var2 > 0) {
               var4 = var1 + ", ";
            }

            var1 = var4 + this.b.get(var2);
            var2++;
         }
      } else {
         var4 = var1;
      }

      String var5 = var4;
      if (this.c.size() > 0) {
         var1 = var4;
         int var10 = var3;

         while (true) {
            var5 = var1;
            if (var10 >= this.c.size()) {
               break;
            }

            var4 = var1;
            if (var10 > 0) {
               var4 = var1 + ", ";
            }

            var1 = var4 + this.c.get(var10);
            var10++;
         }
      }

      return var5 + ")";
   }

   protected void a(Animator var1) {
      if (var1 == null) {
         this.k();
      } else {
         if (this.b() >= 0L) {
            var1.setDuration(this.b());
         }

         if (this.c() >= 0L) {
            var1.setStartDelay(this.c());
         }

         if (this.d() != null) {
            var1.setInterpolator(this.d());
         }

         var1.addListener(new AnimatorListenerAdapter(this) {
            final Transition a;

            {
               this.a = var1;
            }

            public void onAnimationEnd(Animator var1) {
               this.a.k();
               var1.removeListener(this);
            }
         });
         var1.start();
      }
   }

   public void a(Transition.EpicenterCallback var1) {
      this.H = var1;
   }

   public void a(TransitionPropagation var1) {
      this.f = var1;
   }

   public abstract void a(TransitionValues var1);

   void a(ViewGroup var1) {
      this.x = new ArrayList<>();
      this.y = new ArrayList<>();
      this.a(this.u, this.v);
      ArrayMap var8 = p();
      int var2 = var8.size();
      WindowIdImpl var4 = ViewUtils.b(var1);
      var2--;

      for (; var2 >= 0; var2--) {
         Animator var5 = (Animator)var8.b(var2);
         if (var5 != null) {
            Transition.AnimationInfo var7 = (Transition.AnimationInfo)var8.get(var5);
            if (var7 != null && var7.a != null && var4.equals(var7.d)) {
               TransitionValues var6 = var7.c;
               View var10 = var7.a;
               TransitionValues var9 = this.a(var10, true);
               TransitionValues var12 = this.b(var10, true);
               boolean var3;
               if ((var9 != null || var12 != null) && var7.e.a(var6, var12)) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               if (var3) {
                  if (!var5.isRunning() && !var5.isStarted()) {
                     var8.remove(var5);
                  } else {
                     var5.cancel();
                  }
               }
            }
         }
      }

      this.a(var1, this.u, this.v, this.x, this.y);
      this.e();
   }

   protected void a(ViewGroup var1, TransitionValuesMaps var2, TransitionValuesMaps var3, ArrayList<TransitionValues> var4, ArrayList<TransitionValues> var5) {
      ArrayMap var20 = p();
      long var10 = Long.MAX_VALUE;
      SparseIntArray var19 = new SparseIntArray();
      int var8 = var4.size();
      int var6 = 0;

      while (var6 < var8) {
         TransitionValues var15 = (TransitionValues)var4.get(var6);
         TransitionValues var16 = (TransitionValues)var5.get(var6);
         if (var15 != null && !var15.c.contains(this)) {
            var15 = null;
         }

         if (var16 != null && !var16.c.contains(this)) {
            var16 = null;
         }

         long var12;
         if (var15 == null && var16 == null) {
            var12 = var10;
         } else {
            boolean var7;
            if (var15 != null && var16 != null && !this.a(var15, var16)) {
               var7 = 0;
            } else {
               var7 = 1;
            }

            var12 = var10;
            if (var7) {
               Animator var23 = this.a(var1, var15, var16);
               var12 = var10;
               if (var23 != null) {
                  Object var17 = null;
                  View var31;
                  TransitionValues var37;
                  if (var16 != null) {
                     View var18 = var16.b;
                     String[] var21 = this.a();
                     Animator var14;
                     TransitionValues var24;
                     if (var18 != null && var21 != null && var21.length > 0) {
                        TransitionValues var30 = new TransitionValues();
                        var30.b = var18;
                        var17 = var3.a.get(var18);
                        if (var17 != null) {
                           for (int var26 = 0; var26 < var21.length; var26++) {
                              var30.a.put(var21[var26], ((TransitionValues)var17).a.get(var21[var26]));
                           }
                        }

                        int var9 = var20.size();
                        var7 = 0;

                        while (true) {
                           if (var7 >= var9) {
                              var17 = var30;
                              var14 = var23;
                              var24 = (TransitionValues)var17;
                              break;
                           }

                           var17 = (Transition.AnimationInfo)var20.get((Animator)var20.b(var7));
                           if (((Transition.AnimationInfo)var17).c != null
                              && ((Transition.AnimationInfo)var17).a == var18
                              && ((Transition.AnimationInfo)var17).b.equals(this.o())
                              && ((Transition.AnimationInfo)var17).c.equals(var30)) {
                              var17 = null;
                              var24 = var30;
                              var14 = (Animator)var17;
                              break;
                           }

                           var7++;
                        }
                     } else {
                        var14 = var23;
                        var24 = (TransitionValues)var17;
                     }

                     var17 = var14;
                     var31 = var18;
                     var37 = var24;
                  } else {
                     var31 = var15.b;
                     var37 = null;
                     var17 = var23;
                  }

                  var12 = var10;
                  if (var17 != null) {
                     var12 = var10;
                     if (this.f != null) {
                        var12 = this.f.a(var1, this, var15, var16);
                        var19.put(this.G.size(), (int)var12);
                        var12 = Math.min(var12, var10);
                     }

                     var20.put(var17, new Transition.AnimationInfo(var31, this.o(), this, ViewUtils.b(var1), var37));
                     this.G.add((Animator)var17);
                  }
               }
            }
         }

         var6++;
         var10 = var12;
      }

      if (var10 != 0L) {
         for (int var25 = 0; var25 < var19.size(); var25++) {
            int var28 = var19.keyAt(var25);
            Animator var22 = this.G.get(var28);
            var22.setStartDelay(var19.valueAt(var25) - var10 + var22.getStartDelay());
         }
      }
   }

   void a(ViewGroup var1, boolean var2) {
      byte var5 = 0;
      this.b(var2);
      if ((this.b.size() > 0 || this.c.size() > 0) && (this.l == null || this.l.isEmpty()) && (this.m == null || this.m.isEmpty())) {
         for (int var3 = 0; var3 < this.b.size(); var3++) {
            View var7 = var1.findViewById(this.b.get(var3));
            if (var7 != null) {
               TransitionValues var8 = new TransitionValues();
               var8.b = var7;
               if (var2) {
                  this.a(var8);
               } else {
                  this.b(var8);
               }

               var8.c.add(this);
               this.c(var8);
               if (var2) {
                  a(this.u, var7, var8);
               } else {
                  a(this.v, var7, var8);
               }
            }
         }

         for (int var11 = 0; var11 < this.c.size(); var11++) {
            View var13 = this.c.get(var11);
            TransitionValues var9 = new TransitionValues();
            var9.b = var13;
            if (var2) {
               this.a(var9);
            } else {
               this.b(var9);
            }

            var9.c.add(this);
            this.c(var9);
            if (var2) {
               a(this.u, var13, var9);
            } else {
               a(this.v, var13, var9);
            }
         }
      } else {
         this.c(var1, var2);
      }

      if (!var2 && this.I != null) {
         int var6 = this.I.size();
         ArrayList var10 = new ArrayList(var6);
         int var4 = 0;

         while (true) {
            int var12 = var5;
            if (var4 >= var6) {
               for (; var12 < var6; var12++) {
                  View var15 = (View)var10.get(var12);
                  if (var15 != null) {
                     String var16 = this.I.c(var12);
                     this.u.d.put(var16, var15);
                  }
               }
               break;
            }

            String var14 = this.I.b(var4);
            var10.add(this.u.d.remove(var14));
            var4++;
         }
      }
   }

   public void a(int... var1) {
      if (var1 != null && var1.length != 0) {
         for (int var2 = 0; var2 < var1.length; var2++) {
            if (!a(var1[var2])) {
               throw new IllegalArgumentException("matches contains invalid value");
            }

            if (a(var1, var2)) {
               throw new IllegalArgumentException("matches contains a duplicate value");
            }
         }

         this.w = (int[])var1.clone();
      } else {
         this.w = g;
      }
   }

   public boolean a(TransitionValues var1, TransitionValues var2) {
      boolean var6 = false;
      boolean var5 = var6;
      if (var1 != null) {
         var5 = var6;
         if (var2 != null) {
            String[] var7 = this.a();
            if (var7 != null) {
               int var4 = var7.length;
               int var3 = 0;

               while (true) {
                  if (var3 >= var4) {
                     var5 = false;
                     break;
                  }

                  if (a(var1, var2, var7[var3])) {
                     var5 = true;
                     break;
                  }

                  var3++;
               }
            } else {
               Iterator var8 = var1.a.keySet().iterator();

               while (true) {
                  var5 = var6;
                  if (!var8.hasNext()) {
                     break;
                  }

                  if (a(var1, var2, (String)var8.next())) {
                     var5 = true;
                     break;
                  }
               }
            }
         }
      }

      return var5;
   }

   public String[] a() {
      return null;
   }

   public long b() {
      return this.a;
   }

   public Transition b(long var1) {
      this.j = var1;
      return this;
   }

   public Transition b(Transition.TransitionListener var1) {
      if (this.F != null) {
         this.F.remove(var1);
         if (this.F.size() == 0) {
            this.F = null;
         }
      }

      return this;
   }

   TransitionValues b(View var1, boolean var2) {
      Object var7 = null;
      TransitionValues var5;
      if (this.d != null) {
         var5 = this.d.b(var1, var2);
      } else {
         ArrayList var6;
         if (var2) {
            var6 = this.x;
         } else {
            var6 = this.y;
         }

         var5 = (TransitionValues)var7;
         if (var6 != null) {
            int var4 = var6.size();
            int var3 = 0;

            while (true) {
               if (var3 >= var4) {
                  var3 = -1;
                  break;
               }

               TransitionValues var8 = (TransitionValues)var6.get(var3);
               var5 = (TransitionValues)var7;
               if (var8 == null) {
                  return var5;
               }

               if (var8.b == var1) {
                  break;
               }

               var3++;
            }

            TransitionValues var10;
            if (var3 >= 0) {
               ArrayList var9;
               if (var2) {
                  var9 = this.y;
               } else {
                  var9 = this.x;
               }

               var10 = (TransitionValues)var9.get(var3);
            } else {
               var10 = null;
            }

            var5 = var10;
         }
      }

      return var5;
   }

   public abstract void b(TransitionValues var1);

   void b(boolean var1) {
      if (var1) {
         this.u.a.clear();
         this.u.b.clear();
         this.u.c.c();
      } else {
         this.v.a.clear();
         this.v.b.clear();
         this.v.c.c();
      }
   }

   boolean b(View var1) {
      boolean var6 = false;
      int var4 = var1.getId();
      boolean var9;
      if (this.n != null && this.n.contains(var4)) {
         var9 = var6;
      } else {
         if (this.o != null) {
            var9 = var6;
            if (this.o.contains(var1)) {
               return var9;
            }
         }

         if (this.p != null) {
            int var3 = this.p.size();

            for (int var2 = 0; var2 < var3; var2++) {
               var9 = var6;
               if (this.p.get(var2).isInstance(var1)) {
                  return var9;
               }
            }
         }

         if (this.q != null && ViewCompat.o(var1) != null) {
            var9 = var6;
            if (this.q.contains(ViewCompat.o(var1))) {
               return var9;
            }
         }

         if (this.b.size() != 0 || this.c.size() != 0 || this.m != null && !this.m.isEmpty() || this.l != null && !this.l.isEmpty()) {
            if (this.b.contains(var4) || this.c.contains(var1)) {
               var9 = true;
            } else if (this.l != null && this.l.contains(ViewCompat.o(var1))) {
               var9 = true;
            } else {
               var9 = var6;
               if (this.m != null) {
                  int var7 = 0;

                  while (true) {
                     var9 = var6;
                     if (var7 >= this.m.size()) {
                        break;
                     }

                     if (this.m.get(var7).isInstance(var1)) {
                        var9 = true;
                        break;
                     }

                     var7++;
                  }
               }
            }
         } else {
            var9 = true;
         }
      }

      return var9;
   }

   public long c() {
      return this.j;
   }

   public Transition c(View var1) {
      this.c.add(var1);
      return this;
   }

   void c(TransitionValues var1) {
      boolean var3 = false;
      if (this.f != null && !var1.a.isEmpty()) {
         String[] var4 = this.f.a();
         if (var4 != null) {
            int var2 = 0;

            while (true) {
               if (var2 >= var4.length) {
                  var5 = true;
                  break;
               }

               if (!var1.a.containsKey(var4[var2])) {
                  var5 = var3;
                  break;
               }

               var2++;
            }

            if (!var5) {
               this.f.a(var1);
            }
         }
      }
   }

   public TimeInterpolator d() {
      return this.k;
   }

   public Transition d(View var1) {
      this.c.remove(var1);
      return this;
   }

   protected void e() {
      this.j();
      ArrayMap var1 = p();

      for (Animator var3 : this.G) {
         if (var1.containsKey(var3)) {
            this.j();
            this.a(var3, var1);
         }
      }

      this.G.clear();
      this.k();
   }

   public void e(View var1) {
      if (!this.E) {
         ArrayMap var4 = p();
         int var2 = var4.size();
         WindowIdImpl var6 = ViewUtils.b(var1);
         var2--;

         for (; var2 >= 0; var2--) {
            Transition.AnimationInfo var5 = (Transition.AnimationInfo)var4.c(var2);
            if (var5.a != null && var6.equals(var5.d)) {
               AnimatorUtils.a((Animator)var4.b(var2));
            }
         }

         if (this.F != null && this.F.size() > 0) {
            ArrayList var7 = (ArrayList)this.F.clone();
            int var3 = var7.size();

            for (int var9 = 0; var9 < var3; var9++) {
               ((Transition.TransitionListener)var7.get(var9)).b(this);
            }
         }

         this.D = true;
      }
   }

   public List<Integer> f() {
      return this.b;
   }

   public void f(View var1) {
      if (this.D) {
         if (!this.E) {
            ArrayMap var4 = p();
            int var2 = var4.size();
            WindowIdImpl var6 = ViewUtils.b(var1);
            var2--;

            for (; var2 >= 0; var2--) {
               Transition.AnimationInfo var5 = (Transition.AnimationInfo)var4.c(var2);
               if (var5.a != null && var6.equals(var5.d)) {
                  AnimatorUtils.b((Animator)var4.b(var2));
               }
            }

            if (this.F != null && this.F.size() > 0) {
               ArrayList var7 = (ArrayList)this.F.clone();
               int var3 = var7.size();

               for (int var9 = 0; var9 < var3; var9++) {
                  ((Transition.TransitionListener)var7.get(var9)).c(this);
               }
            }
         }

         this.D = false;
      }
   }

   public List<View> g() {
      return this.c;
   }

   public List<String> h() {
      return this.l;
   }

   public List<Class> i() {
      return this.m;
   }

   protected void j() {
      if (this.C == 0) {
         if (this.F != null && this.F.size() > 0) {
            ArrayList var3 = (ArrayList)this.F.clone();
            int var2 = var3.size();

            for (int var1 = 0; var1 < var2; var1++) {
               ((Transition.TransitionListener)var3.get(var1)).d(this);
            }
         }

         this.E = false;
      }

      this.C++;
   }

   protected void k() {
      this.C--;
      if (this.C == 0) {
         if (this.F != null && this.F.size() > 0) {
            ArrayList var3 = (ArrayList)this.F.clone();
            int var2 = var3.size();

            for (int var1 = 0; var1 < var2; var1++) {
               ((Transition.TransitionListener)var3.get(var1)).a(this);
            }
         }

         for (int var4 = 0; var4 < this.u.c.b(); var4++) {
            View var6 = this.u.c.c(var4);
            if (var6 != null) {
               ViewCompat.a(var6, false);
            }
         }

         for (int var5 = 0; var5 < this.v.c.b(); var5++) {
            View var7 = this.v.c.c(var5);
            if (var7 != null) {
               ViewCompat.a(var7, false);
            }
         }

         this.E = true;
      }
   }

   public PathMotion l() {
      return this.J;
   }

   public Rect m() {
      Rect var1;
      if (this.H == null) {
         var1 = null;
      } else {
         var1 = this.H.a(this);
      }

      return var1;
   }

   public Transition n() {
      Transition var1;
      try {
         var1 = (Transition)super.clone();
         ArrayList var2 = new ArrayList();
         var1.G = var2;
         TransitionValuesMaps var4 = new TransitionValuesMaps();
         var1.u = var4;
         TransitionValuesMaps var5 = new TransitionValuesMaps();
         var1.v = var5;
         var1.x = null;
         var1.y = null;
      } catch (CloneNotSupportedException var3) {
         var1 = null;
      }

      return var1;
   }

   public String o() {
      return this.i;
   }

   @Override
   public String toString() {
      return this.a("");
   }

   private static class AnimationInfo {
      View a;
      String b;
      TransitionValues c;
      WindowIdImpl d;
      Transition e;

      AnimationInfo(View var1, String var2, Transition var3, WindowIdImpl var4, TransitionValues var5) {
         this.a = var1;
         this.b = var2;
         this.c = var5;
         this.d = var4;
         this.e = var3;
      }
   }

   public abstract static class EpicenterCallback {
      public abstract Rect a(Transition var1);
   }

   public interface TransitionListener {
      void a(Transition var1);

      void b(Transition var1);

      void c(Transition var1);

      void d(Transition var1);
   }
}
