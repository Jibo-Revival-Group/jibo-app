package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.support.v4.util.ArraySet;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater.Factory2;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.Animation.AnimationListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class FragmentManagerImpl extends FragmentManager implements Factory2 {
   static final Interpolator E = new DecelerateInterpolator(2.5F);
   static final Interpolator F = new DecelerateInterpolator(1.5F);
   static final Interpolator G = new AccelerateInterpolator(2.5F);
   static final Interpolator H = new AccelerateInterpolator(1.5F);
   static boolean a = false;
   static Field q = null;
   SparseArray<Parcelable> A;
   ArrayList<FragmentManagerImpl.StartEnterTransitionListener> B;
   FragmentManagerNonConfig C;
   Runnable D;
   private final CopyOnWriteArrayList<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> I;
   ArrayList<FragmentManagerImpl.OpGenerator> b;
   boolean c;
   int d = 0;
   final ArrayList<Fragment> e = new ArrayList<>();
   SparseArray<Fragment> f;
   ArrayList<BackStackRecord> g;
   ArrayList<Fragment> h;
   ArrayList<BackStackRecord> i;
   ArrayList<Integer> j;
   ArrayList<FragmentManager.OnBackStackChangedListener> k;
   int l;
   FragmentHostCallback m;
   FragmentContainer n;
   Fragment o;
   Fragment p;
   boolean r;
   boolean s;
   boolean t;
   String u;
   boolean v;
   ArrayList<BackStackRecord> w;
   ArrayList<Boolean> x;
   ArrayList<Fragment> y;
   Bundle z;

   FragmentManagerImpl() {
      this.I = new CopyOnWriteArrayList<>();
      this.l = 0;
      this.z = null;
      this.A = null;
      this.D = new Runnable(this) {
         final FragmentManagerImpl a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.i();
         }
      };
   }

   private void B() {
      if (this.s) {
         throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
      }

      if (this.u != null) {
         throw new IllegalStateException("Can not perform this action inside of " + this.u);
      }
   }

   private void C() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: bipush 1
      // 01: istore 2
      // 02: aload 0
      // 03: monitorenter
      // 04: aload 0
      // 05: getfield android/support/v4/app/FragmentManagerImpl.B Ljava/util/ArrayList;
      // 08: ifnull 51
      // 0b: aload 0
      // 0c: getfield android/support/v4/app/FragmentManagerImpl.B Ljava/util/ArrayList;
      // 0f: invokevirtual java/util/ArrayList.isEmpty ()Z
      // 12: ifne 51
      // 15: bipush 1
      // 16: istore 1
      // 17: aload 0
      // 18: getfield android/support/v4/app/FragmentManagerImpl.b Ljava/util/ArrayList;
      // 1b: ifnull 56
      // 1e: aload 0
      // 1f: getfield android/support/v4/app/FragmentManagerImpl.b Ljava/util/ArrayList;
      // 22: invokevirtual java/util/ArrayList.size ()I
      // 25: bipush 1
      // 26: if_icmpne 56
      // 29: iload 1
      // 2a: ifne 31
      // 2d: iload 2
      // 2e: ifeq 4e
      // 31: aload 0
      // 32: getfield android/support/v4/app/FragmentManagerImpl.m Landroid/support/v4/app/FragmentHostCallback;
      // 35: invokevirtual android/support/v4/app/FragmentHostCallback.j ()Landroid/os/Handler;
      // 38: aload 0
      // 39: getfield android/support/v4/app/FragmentManagerImpl.D Ljava/lang/Runnable;
      // 3c: invokevirtual android/os/Handler.removeCallbacks (Ljava/lang/Runnable;)V
      // 3f: aload 0
      // 40: getfield android/support/v4/app/FragmentManagerImpl.m Landroid/support/v4/app/FragmentHostCallback;
      // 43: invokevirtual android/support/v4/app/FragmentHostCallback.j ()Landroid/os/Handler;
      // 46: aload 0
      // 47: getfield android/support/v4/app/FragmentManagerImpl.D Ljava/lang/Runnable;
      // 4a: invokevirtual android/os/Handler.post (Ljava/lang/Runnable;)Z
      // 4d: pop
      // 4e: aload 0
      // 4f: monitorexit
      // 50: return
      // 51: bipush 0
      // 52: istore 1
      // 53: goto 17
      // 56: bipush 0
      // 57: istore 2
      // 58: goto 29
      // 5b: astore 3
      // 5c: aload 0
      // 5d: monitorexit
      // 5e: aload 3
      // 5f: athrow
      // try (4 -> 11): 47 null
      // try (13 -> 21): 47 null
      // try (25 -> 38): 47 null
      // try (38 -> 40): 47 null
      // try (48 -> 50): 47 null
   }

   private void D() {
      this.c = false;
      this.x.clear();
      this.w.clear();
   }

   private void E() {
      if (this.B != null) {
         while (!this.B.isEmpty()) {
            this.B.remove(0).d();
         }
      }
   }

   private void F() {
      int var1;
      if (this.f == null) {
         var1 = 0;
      } else {
         var1 = this.f.size();
      }

      for (int var2 = 0; var2 < var1; var2++) {
         Fragment var4 = (Fragment)this.f.valueAt(var2);
         if (var4 != null) {
            if (var4.getAnimatingAway() != null) {
               int var3 = var4.getStateAfterAnimating();
               View var6 = var4.getAnimatingAway();
               Animation var5 = var6.getAnimation();
               if (var5 != null) {
                  var5.cancel();
                  var6.clearAnimation();
               }

               var4.setAnimatingAway(null);
               this.a(var4, var3, 0, 0, false);
            } else if (var4.getAnimator() != null) {
               var4.getAnimator().end();
            }
         }
      }
   }

   private void G() {
      if (this.f != null) {
         for (int var1 = this.f.size() - 1; var1 >= 0; var1--) {
            if (this.f.valueAt(var1) == null) {
               this.f.delete(this.f.keyAt(var1));
            }
         }
      }
   }

   private int a(ArrayList<BackStackRecord> var1, ArrayList<Boolean> var2, int var3, int var4, ArraySet<Fragment> var5) {
      int var7 = var4 - 1;
      int var6 = var4;

      while (var7 >= var3) {
         BackStackRecord var10 = (BackStackRecord)var1.get(var7);
         boolean var9 = (Boolean)var2.get(var7);
         boolean var8;
         if (var10.i() && !var10.a(var1, var7 + 1, var4)) {
            var8 = true;
         } else {
            var8 = false;
         }

         if (var8) {
            if (this.B == null) {
               this.B = new ArrayList<>();
            }

            FragmentManagerImpl.StartEnterTransitionListener var11 = new FragmentManagerImpl.StartEnterTransitionListener(var10, var9);
            this.B.add(var11);
            var10.a(var11);
            if (var9) {
               var10.h();
            } else {
               var10.b(false);
            }

            if (var7 != --var6) {
               var1.remove(var7);
               var1.add(var6, var10);
            }

            this.b(var5);
         }

         var7--;
      }

      return var6;
   }

   static FragmentManagerImpl.AnimationOrAnimator a(Context var0, float var1, float var2) {
      AlphaAnimation var3 = new AlphaAnimation(var1, var2);
      var3.setInterpolator(F);
      var3.setDuration(220L);
      return new FragmentManagerImpl.AnimationOrAnimator(var3);
   }

   static FragmentManagerImpl.AnimationOrAnimator a(Context var0, float var1, float var2, float var3, float var4) {
      AnimationSet var6 = new AnimationSet(false);
      ScaleAnimation var5 = new ScaleAnimation(var1, var2, var1, var2, 1, 0.5F, 1, 0.5F);
      var5.setInterpolator(E);
      var5.setDuration(220L);
      var6.addAnimation(var5);
      AlphaAnimation var7 = new AlphaAnimation(var3, var4);
      var7.setInterpolator(F);
      var7.setDuration(220L);
      var6.addAnimation(var7);
      return new FragmentManagerImpl.AnimationOrAnimator(var6);
   }

   private static AnimationListener a(Animation var0) {
      try {
         if (q == null) {
            q = Animation.class.getDeclaredField("mListener");
            q.setAccessible(true);
         }

         var3 = (AnimationListener)q.get(var0);
      } catch (NoSuchFieldException var1) {
         Log.e("FragmentManager", "No field with the name mListener is found in Animation class", var1);
         var3 = null;
      } catch (IllegalAccessException var2) {
         Log.e("FragmentManager", "Cannot access Animation's mListener field", var2);
         var3 = null;
      }

      return var3;
   }

   private void a(BackStackRecord var1, boolean var2, boolean var3, boolean var4) {
      if (var2) {
         var1.b(var4);
      } else {
         var1.h();
      }

      ArrayList var7 = new ArrayList(1);
      ArrayList var8 = new ArrayList(1);
      var7.add(var1);
      var8.add(var2);
      if (var3) {
         FragmentTransition.a(this, var7, var8, 0, 1, true);
      }

      if (var4) {
         this.a(this.l, true);
      }

      if (this.f != null) {
         int var6 = this.f.size();

         for (int var5 = 0; var5 < var6; var5++) {
            Fragment var9 = (Fragment)this.f.valueAt(var5);
            if (var9 != null && var9.mView != null && var9.mIsNewlyAdded && var1.b(var9.mContainerId)) {
               if (var9.mPostponedAlpha > 0.0F) {
                  var9.mView.setAlpha(var9.mPostponedAlpha);
               }

               if (var4) {
                  var9.mPostponedAlpha = 0.0F;
               } else {
                  var9.mPostponedAlpha = -1.0F;
                  var9.mIsNewlyAdded = false;
               }
            }
         }
      }
   }

   private void a(Fragment var1, FragmentManagerImpl.AnimationOrAnimator var2, int var3) {
      View var5 = var1.mView;
      ViewGroup var4 = var1.mContainer;
      var4.startViewTransition(var5);
      var1.setStateAfterAnimating(var3);
      if (var2.a != null) {
         FragmentManagerImpl.EndViewTransitionAnimator var6 = new FragmentManagerImpl.EndViewTransitionAnimator(var2.a, var4, var5);
         var1.setAnimatingAway(var1.mView);
         var6.setAnimationListener(new FragmentManagerImpl.AnimationListenerWrapper(this, a(var6), var4, var1) {
            final ViewGroup a;
            final Fragment b;
            final FragmentManagerImpl c;

            {
               this.c = var1;
               this.a = var3x;
               this.b = var4x;
            }

            @Override
            public void onAnimationEnd(Animation var1) {
               super.onAnimationEnd(var1);
               this.a.post(new Runnable(this) {
                  final <unrepresentable> a;

                  {
                     this.a = var1;
                  }

                  @Override
                  public void run() {
                     if (this.a.b.getAnimatingAway() != null) {
                        this.a.b.setAnimatingAway(null);
                        this.a.c.a(this.a.b, this.a.b.getStateAfterAnimating(), 0, 0, false);
                     }
                  }
               });
            }
         });
         b(var5, var2);
         var1.mView.startAnimation(var6);
      } else {
         Animator var7 = var2.b;
         var1.setAnimator(var2.b);
         var7.addListener(new AnimatorListenerAdapter(this, var4, var5, var1) {
            final ViewGroup a;
            final View b;
            final Fragment c;
            final FragmentManagerImpl d;

            {
               this.d = var1;
               this.a = var2x;
               this.b = var3x;
               this.c = var4x;
            }

            public void onAnimationEnd(Animator var1) {
               this.a.endViewTransition(this.b);
               var1 = this.c.getAnimator();
               this.c.setAnimator(null);
               if (var1 != null && this.a.indexOfChild(this.b) < 0) {
                  this.d.a(this.c, this.c.getStateAfterAnimating(), 0, 0, false);
               }
            }
         });
         var7.setTarget(var1.mView);
         b(var1.mView, var2);
         var7.start();
      }
   }

   private static void a(FragmentManagerNonConfig var0) {
      if (var0 != null) {
         List var1 = var0.a();
         if (var1 != null) {
            Iterator var4 = var1.iterator();

            while (var4.hasNext()) {
               ((Fragment)var4.next()).mRetaining = true;
            }
         }

         List var2 = var0.b();
         if (var2 != null) {
            Iterator var3 = var2.iterator();

            while (var3.hasNext()) {
               a((FragmentManagerNonConfig)var3.next());
            }
         }
      }
   }

   private void a(ArraySet<Fragment> var1) {
      int var3 = var1.size();

      for (int var2 = 0; var2 < var3; var2++) {
         Fragment var5 = (Fragment)var1.b(var2);
         if (!var5.mAdded) {
            View var4 = var5.getView();
            var5.mPostponedAlpha = var4.getAlpha();
            var4.setAlpha(0.0F);
         }
      }
   }

   private void a(RuntimeException var1) {
      Log.e("FragmentManager", var1.getMessage());
      Log.e("FragmentManager", "Activity state:");
      PrintWriter var2 = new PrintWriter(new LogWriter("FragmentManager"));
      if (this.m != null) {
         try {
            this.m.a("  ", null, var2, new String[0]);
         } catch (Exception var4) {
            Log.e("FragmentManager", "Failed dumping state", var4);
         }
      } else {
         try {
            this.a("  ", null, var2, new String[0]);
         } catch (Exception var3) {
            Log.e("FragmentManager", "Failed dumping state", var3);
         }
      }

      throw var1;
   }

   private void a(ArrayList<BackStackRecord> var1, ArrayList<Boolean> var2) {
      int var3;
      if (this.B == null) {
         var3 = 0;
      } else {
         var3 = this.B.size();
      }

      for (int var4 = 0; var4 < var3; var4++) {
         FragmentManagerImpl.StartEnterTransitionListener var7 = this.B.get(var4);
         if (var1 != null && !var7.a) {
            int var5 = var1.indexOf(var7.b);
            if (var5 != -1 && (Boolean)var2.get(var5)) {
               var7.e();
               continue;
            }
         }

         int var6;
         int var9;
         label56: {
            if (!var7.c()) {
               var6 = var4;
               var9 = var3;
               if (var1 == null) {
                  break label56;
               }

               var6 = var4;
               var9 = var3;
               if (!var7.b.a(var1, 0, var1.size())) {
                  break label56;
               }
            }

            this.B.remove(var4);
            var6 = var4 - 1;
            var9 = var3 - 1;
            if (var1 != null && !var7.a) {
               var3 = var1.indexOf(var7.b);
               if (var3 != -1 && (Boolean)var2.get(var3)) {
                  var7.e();
                  var4 = var6;
                  var3 = var9;
                  continue;
               }
            }

            var7.d();
         }

         var4 = var6;
         var3 = var9;
      }
   }

   private void a(ArrayList<BackStackRecord> var1, ArrayList<Boolean> var2, int var3, int var4) {
      boolean var8 = ((BackStackRecord)var1.get(var3)).t;
      if (this.y == null) {
         this.y = new ArrayList<>();
      } else {
         this.y.clear();
      }

      this.y.addAll(this.e);
      Fragment var9 = this.z();
      int var6 = var3;
      boolean var5 = false;

      while (var6 < var4) {
         BackStackRecord var10 = (BackStackRecord)var1.get(var6);
         if (!(Boolean)var2.get(var6)) {
            var9 = var10.a(this.y, var9);
         } else {
            var9 = var10.b(this.y, var9);
         }

         if (!var5 && !var10.i) {
            var5 = false;
         } else {
            var5 = true;
         }

         var6++;
      }

      this.y.clear();
      if (!var8) {
         FragmentTransition.a(this, var1, var2, var3, var4, false);
      }

      b(var1, var2, var3, var4);
      if (var8) {
         ArraySet var12 = new ArraySet();
         this.b(var12);
         var6 = this.a(var1, var2, var3, var4, var12);
         this.a(var12);
      } else {
         var6 = var4;
      }

      int var7 = var3;
      if (var6 != var3) {
         var7 = var3;
         if (var8) {
            FragmentTransition.a(this, var1, var2, var3, var6, true);
            this.a(this.l, true);
            var7 = var3;
         }
      }

      while (var7 < var4) {
         BackStackRecord var13 = (BackStackRecord)var1.get(var7);
         if ((Boolean)var2.get(var7) && var13.m >= 0) {
            this.d(var13.m);
            var13.m = -1;
         }

         var13.c();
         var7++;
      }

      if (var5) {
         this.k();
      }
   }

   static boolean a(Animator var0) {
      boolean var3 = false;
      boolean var2;
      if (var0 == null) {
         var2 = var3;
      } else if (var0 instanceof ValueAnimator) {
         PropertyValuesHolder[] var4 = ((ValueAnimator)var0).getValues();
         int var1 = 0;

         while (true) {
            var2 = var3;
            if (var1 >= var4.length) {
               break;
            }

            if ("alpha".equals(var4[var1].getPropertyName())) {
               var2 = true;
               break;
            }

            var1++;
         }
      } else {
         var2 = var3;
         if (var0 instanceof AnimatorSet) {
            ArrayList var5 = ((AnimatorSet)var0).getChildAnimations();
            int var6 = 0;

            while (true) {
               var2 = var3;
               if (var6 >= var5.size()) {
                  break;
               }

               if (a((Animator)var5.get(var6))) {
                  var2 = true;
                  break;
               }

               var6++;
            }
         }
      }

      return var2;
   }

   static boolean a(FragmentManagerImpl.AnimationOrAnimator var0) {
      boolean var3 = false;
      boolean var2;
      if (var0.a instanceof AlphaAnimation) {
         var2 = true;
      } else if (var0.a instanceof AnimationSet) {
         List var4 = ((AnimationSet)var0.a).getAnimations();
         int var1 = 0;

         while (true) {
            var2 = var3;
            if (var1 >= var4.size()) {
               break;
            }

            if (var4.get(var1) instanceof AlphaAnimation) {
               var2 = true;
               break;
            }

            var1++;
         }
      } else {
         var2 = a(var0.b);
      }

      return var2;
   }

   static boolean a(View var0, FragmentManagerImpl.AnimationOrAnimator var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if (var0 != null) {
         if (var1 == null) {
            var2 = var3;
         } else {
            var2 = var3;
            if (VERSION.SDK_INT >= 19) {
               var2 = var3;
               if (var0.getLayerType() == 0) {
                  var2 = var3;
                  if (ViewCompat.s(var0)) {
                     var2 = var3;
                     if (a(var1)) {
                        var2 = true;
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   private boolean a(String var1, int var2, int var3) {
      this.i();
      this.c(true);
      if (this.p != null && var2 < 0 && var1 == null) {
         FragmentManager var5 = this.p.peekChildFragmentManager();
         if (var5 != null && var5.d()) {
            boolean var8 = true;
            return var8;
         }
      }

      boolean var4 = this.a(this.w, this.x, var1, var2, var3);
      if (var4) {
         this.c = true;

         try {
            this.b(this.w, this.x);
         } finally {
            this.D();
         }
      }

      this.j();
      this.G();
      return var4;
   }

   public static int b(int var0, boolean var1) {
      byte var2 = -1;
      byte var3;
      switch (var0) {
         case 4097:
            if (var1) {
               var3 = 1;
            } else {
               var3 = 2;
            }
            break;
         case 4099:
            if (var1) {
               var3 = 5;
            } else {
               var3 = 6;
            }
            break;
         case 8194:
            if (var1) {
               var3 = 3;
            } else {
               var3 = 4;
            }
            break;
         default:
            var3 = var2;
      }

      return var3;
   }

   private void b(ArraySet<Fragment> var1) {
      if (this.l >= 1) {
         int var4 = Math.min(this.l, 4);
         int var3 = this.e.size();

         for (int var2 = 0; var2 < var3; var2++) {
            Fragment var5 = this.e.get(var2);
            if (var5.mState < var4) {
               this.a(var5, var4, var5.getNextAnim(), var5.getNextTransition(), false);
               if (var5.mView != null && !var5.mHidden && var5.mIsNewlyAdded) {
                  var1.add(var5);
               }
            }
         }
      }
   }

   private static void b(View var0, FragmentManagerImpl.AnimationOrAnimator var1) {
      if (var0 != null && var1 != null && a(var0, var1)) {
         if (var1.b != null) {
            var1.b.addListener(new FragmentManagerImpl.AnimatorOnHWLayerIfNeededListener(var0));
         } else {
            AnimationListener var2 = a(var1.a);
            var0.setLayerType(2, null);
            var1.a.setAnimationListener(new FragmentManagerImpl.AnimateOnHWLayerIfNeededListener(var0, var2));
         }
      }
   }

   private void b(ArrayList<BackStackRecord> var1, ArrayList<Boolean> var2) {
      int var3 = 0;
      if (var1 != null && !var1.isEmpty()) {
         if (var2 == null || var1.size() != var2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
         }

         this.a(var1, var2);
         int var6 = var1.size();
         int var4 = 0;

         while (var3 < var6) {
            if (!((BackStackRecord)var1.get(var3)).t) {
               if (var4 != var3) {
                  this.a(var1, var2, var4, var3);
               }

               int var5 = var3 + 1;
               var4 = var5;
               if ((Boolean)var2.get(var3)) {
                  while (true) {
                     var4 = var5;
                     if (var5 >= var6) {
                        break;
                     }

                     var4 = var5;
                     if (!(Boolean)var2.get(var5)) {
                        break;
                     }

                     var4 = var5;
                     if (((BackStackRecord)var1.get(var5)).t) {
                        break;
                     }

                     var5++;
                  }
               }

               this.a(var1, var2, var3, var4);
               var3 = var4;
               var5 = var4 - 1;
               var4 = var3;
               var3 = var5;
            }

            var3++;
         }

         if (var4 != var6) {
            this.a(var1, var2, var4, var6);
         }
      }
   }

   private static void b(ArrayList<BackStackRecord> var0, ArrayList<Boolean> var1, int var2, int var3) {
      while (var2 < var3) {
         BackStackRecord var5 = (BackStackRecord)var0.get(var2);
         if ((Boolean)var1.get(var2)) {
            var5.a(-1);
            boolean var4;
            if (var2 == var3 - 1) {
               var4 = true;
            } else {
               var4 = false;
            }

            var5.b(var4);
         } else {
            var5.a(1);
            var5.h();
         }

         var2++;
      }
   }

   private void c(boolean var1) {
      if (this.c) {
         throw new IllegalStateException("FragmentManager is already executing transactions");
      }

      if (this.m == null) {
         throw new IllegalStateException("Fragment host has been destroyed");
      }

      if (Looper.myLooper() != this.m.j().getLooper()) {
         throw new IllegalStateException("Must be called from main thread of fragment host");
      }

      if (!var1) {
         this.B();
      }

      if (this.w == null) {
         this.w = new ArrayList<>();
         this.x = new ArrayList<>();
      }

      this.c = true;

      try {
         this.a((ArrayList<BackStackRecord>)null, (ArrayList<Boolean>)null);
      } finally {
         this.c = false;
      }
   }

   private boolean c(ArrayList<BackStackRecord> param1, ArrayList<Boolean> param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 5
      // 03: aload 0
      // 04: monitorenter
      // 05: aload 0
      // 06: getfield android/support/v4/app/FragmentManagerImpl.b Ljava/util/ArrayList;
      // 09: ifnull 16
      // 0c: aload 0
      // 0d: getfield android/support/v4/app/FragmentManagerImpl.b Ljava/util/ArrayList;
      // 10: invokevirtual java/util/ArrayList.size ()I
      // 13: ifne 1b
      // 16: aload 0
      // 17: monitorexit
      // 18: iload 5
      // 1a: ireturn
      // 1b: aload 0
      // 1c: getfield android/support/v4/app/FragmentManagerImpl.b Ljava/util/ArrayList;
      // 1f: invokevirtual java/util/ArrayList.size ()I
      // 22: istore 4
      // 24: bipush 0
      // 25: istore 3
      // 26: bipush 0
      // 27: istore 5
      // 29: iload 3
      // 2a: iload 4
      // 2c: if_icmpge 4c
      // 2f: iload 5
      // 31: aload 0
      // 32: getfield android/support/v4/app/FragmentManagerImpl.b Ljava/util/ArrayList;
      // 35: iload 3
      // 36: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 39: checkcast android/support/v4/app/FragmentManagerImpl$OpGenerator
      // 3c: aload 1
      // 3d: aload 2
      // 3e: invokeinterface android/support/v4/app/FragmentManagerImpl$OpGenerator.a (Ljava/util/ArrayList;Ljava/util/ArrayList;)Z 3
      // 43: ior
      // 44: istore 5
      // 46: iinc 3 1
      // 49: goto 29
      // 4c: aload 0
      // 4d: getfield android/support/v4/app/FragmentManagerImpl.b Ljava/util/ArrayList;
      // 50: invokevirtual java/util/ArrayList.clear ()V
      // 53: aload 0
      // 54: getfield android/support/v4/app/FragmentManagerImpl.m Landroid/support/v4/app/FragmentHostCallback;
      // 57: invokevirtual android/support/v4/app/FragmentHostCallback.j ()Landroid/os/Handler;
      // 5a: aload 0
      // 5b: getfield android/support/v4/app/FragmentManagerImpl.D Ljava/lang/Runnable;
      // 5e: invokevirtual android/os/Handler.removeCallbacks (Ljava/lang/Runnable;)V
      // 61: aload 0
      // 62: monitorexit
      // 63: goto 18
      // 66: astore 1
      // 67: aload 0
      // 68: monitorexit
      // 69: aload 1
      // 6a: athrow
      // try (4 -> 11): 51 null
      // try (11 -> 13): 51 null
      // try (15 -> 19): 51 null
      // try (26 -> 37): 51 null
      // try (39 -> 50): 51 null
      // try (52 -> 54): 51 null
   }

   public static int e(int var0) {
      byte var1 = 0;
      short var2;
      switch (var0) {
         case 4097:
            var2 = 8194;
            break;
         case 4099:
            var2 = 4099;
            break;
         case 8194:
            var2 = 4097;
            break;
         default:
            var2 = var1;
      }

      return var2;
   }

   private void f(int var1) {
      try {
         this.c = true;
         this.a(var1, false);
      } finally {
         this.c = false;
      }

      this.i();
   }

   private Fragment q(Fragment var1) {
      ViewGroup var4 = var1.mContainer;
      View var3 = var1.mView;
      if (var4 != null && var3 != null) {
         int var2 = this.e.indexOf(var1) - 1;

         while (true) {
            if (var2 < 0) {
               var1 = null;
               break;
            }

            Fragment var6 = this.e.get(var2);
            if (var6.mContainer == var4) {
               var1 = var6;
               if (var6.mView != null) {
                  break;
               }
            }

            var2--;
         }
      } else {
         var1 = null;
      }

      return var1;
   }

   Factory2 A() {
      return this;
   }

   public int a(BackStackRecord param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield android/support/v4/app/FragmentManagerImpl.j Ljava/util/ArrayList;
      // 06: ifnull 13
      // 09: aload 0
      // 0a: getfield android/support/v4/app/FragmentManagerImpl.j Ljava/util/ArrayList;
      // 0d: invokevirtual java/util/ArrayList.size ()I
      // 10: ifgt 69
      // 13: aload 0
      // 14: getfield android/support/v4/app/FragmentManagerImpl.i Ljava/util/ArrayList;
      // 17: ifnonnull 27
      // 1a: new java/util/ArrayList
      // 1d: astore 3
      // 1e: aload 3
      // 1f: invokespecial java/util/ArrayList.<init> ()V
      // 22: aload 0
      // 23: aload 3
      // 24: putfield android/support/v4/app/FragmentManagerImpl.i Ljava/util/ArrayList;
      // 27: aload 0
      // 28: getfield android/support/v4/app/FragmentManagerImpl.i Ljava/util/ArrayList;
      // 2b: invokevirtual java/util/ArrayList.size ()I
      // 2e: istore 2
      // 2f: getstatic android/support/v4/app/FragmentManagerImpl.a Z
      // 32: ifeq 5c
      // 35: new java/lang/StringBuilder
      // 38: astore 3
      // 39: aload 3
      // 3a: invokespecial java/lang/StringBuilder.<init> ()V
      // 3d: ldc_w "FragmentManager"
      // 40: aload 3
      // 41: ldc_w "Setting back stack index "
      // 44: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 47: iload 2
      // 48: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 4b: ldc_w " to "
      // 4e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 51: aload 1
      // 52: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 55: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 58: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 5b: pop
      // 5c: aload 0
      // 5d: getfield android/support/v4/app/FragmentManagerImpl.i Ljava/util/ArrayList;
      // 60: aload 1
      // 61: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 64: pop
      // 65: aload 0
      // 66: monitorexit
      // 67: iload 2
      // 68: ireturn
      // 69: aload 0
      // 6a: getfield android/support/v4/app/FragmentManagerImpl.j Ljava/util/ArrayList;
      // 6d: aload 0
      // 6e: getfield android/support/v4/app/FragmentManagerImpl.j Ljava/util/ArrayList;
      // 71: invokevirtual java/util/ArrayList.size ()I
      // 74: bipush 1
      // 75: isub
      // 76: invokevirtual java/util/ArrayList.remove (I)Ljava/lang/Object;
      // 79: checkcast java/lang/Integer
      // 7c: invokevirtual java/lang/Integer.intValue ()I
      // 7f: istore 2
      // 80: getstatic android/support/v4/app/FragmentManagerImpl.a Z
      // 83: ifeq ad
      // 86: new java/lang/StringBuilder
      // 89: astore 3
      // 8a: aload 3
      // 8b: invokespecial java/lang/StringBuilder.<init> ()V
      // 8e: ldc_w "FragmentManager"
      // 91: aload 3
      // 92: ldc_w "Adding back stack index "
      // 95: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 98: iload 2
      // 99: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 9c: ldc_w " with "
      // 9f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // a2: aload 1
      // a3: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // a6: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // a9: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // ac: pop
      // ad: aload 0
      // ae: getfield android/support/v4/app/FragmentManagerImpl.i Ljava/util/ArrayList;
      // b1: iload 2
      // b2: aload 1
      // b3: invokevirtual java/util/ArrayList.set (ILjava/lang/Object;)Ljava/lang/Object;
      // b6: pop
      // b7: aload 0
      // b8: monitorexit
      // b9: goto 67
      // bc: astore 1
      // bd: aload 0
      // be: monitorexit
      // bf: aload 1
      // c0: athrow
      // try (2 -> 9): 90 null
      // try (9 -> 19): 90 null
      // try (19 -> 42): 90 null
      // try (42 -> 49): 90 null
      // try (51 -> 81): 90 null
      // try (81 -> 89): 90 null
      // try (91 -> 93): 90 null
   }

   @Override
   public Fragment.SavedState a(Fragment var1) {
      Object var3 = null;
      if (var1.mIndex < 0) {
         this.a(new IllegalStateException("Fragment " + var1 + " is not currently in the FragmentManager"));
      }

      Fragment.SavedState var2 = (Fragment.SavedState)var3;
      if (var1.mState > 0) {
         Bundle var4 = this.o(var1);
         var2 = (Fragment.SavedState)var3;
         if (var4 != null) {
            var2 = new Fragment.SavedState(var4);
         }
      }

      return var2;
   }

   @Override
   public Fragment a(int var1) {
      int var2 = this.e.size() - 1;

      Fragment var3;
      while (true) {
         if (var2 < 0) {
            if (this.f != null) {
               for (int var5 = this.f.size() - 1; var5 >= 0; var5--) {
                  Fragment var4 = (Fragment)this.f.valueAt(var5);
                  if (var4 != null) {
                     var3 = var4;
                     if (var4.mFragmentId == var1) {
                        return var3;
                     }
                  }
               }
            }

            var3 = null;
            break;
         }

         var3 = this.e.get(var2);
         if (var3 != null && var3.mFragmentId == var1) {
            break;
         }

         var2--;
      }

      return var3;
   }

   @Override
   public Fragment a(Bundle var1, String var2) {
      int var3 = var1.getInt(var2, -1);
      Fragment var5;
      if (var3 == -1) {
         var5 = null;
      } else {
         Fragment var4 = (Fragment)this.f.get(var3);
         var5 = var4;
         if (var4 == null) {
            this.a(new IllegalStateException("Fragment no longer exists for key " + var2 + ": index " + var3));
            var5 = var4;
         }
      }

      return var5;
   }

   @Override
   public Fragment a(String var1) {
      if (var1 != null) {
         for (int var2 = this.e.size() - 1; var2 >= 0; var2--) {
            Fragment var6 = this.e.get(var2);
            if (var6 != null && var1.equals(var6.mTag)) {
               return var6;
            }
         }
      }

      if (this.f != null && var1 != null) {
         for (int var5 = this.f.size() - 1; var5 >= 0; var5--) {
            Fragment var4 = (Fragment)this.f.valueAt(var5);
            if (var4 != null) {
               Fragment var3 = var4;
               if (var1.equals(var4.mTag)) {
                  return var3;
               }
            }
         }
      }

      return null;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   FragmentManagerImpl.AnimationOrAnimator a(Fragment var1, int var2, boolean var3, int var4) {
      int var6 = var1.getNextAnim();
      Animation var8 = var1.onCreateAnimation(var2, var3, var6);
      FragmentManagerImpl.AnimationOrAnimator var23;
      if (var8 != null) {
         var23 = new FragmentManagerImpl.AnimationOrAnimator(var8);
      } else {
         Animator var15 = var1.onCreateAnimator(var2, var3, var6);
         if (var15 != null) {
            var23 = new FragmentManagerImpl.AnimationOrAnimator(var15);
         } else {
            if (var6 != 0) {
               boolean var5;
               boolean var7;
               var7 = "anim".equals(this.m.i().getResources().getResourceTypeName(var6));
               label86:
               if (var7) {
                  try {
                     var8 = AnimationUtils.loadAnimation(this.m.i(), var6);
                  } catch (NotFoundException var13) {
                     throw var13;
                  } catch (RuntimeException var14) {
                     var5 = false;
                     break label86;
                  }

                  if (var8 != null) {
                     try {
                        return new FragmentManagerImpl.AnimationOrAnimator(var8);
                     } catch (NotFoundException var9) {
                        throw var9;
                     } catch (RuntimeException var10) {
                        var5 = false;
                     }
                  } else {
                     var5 = true;
                  }
               } else {
                  var5 = false;
               }

               label81:
               if (!var5) {
                  label96: {
                     try {
                        var22 = AnimatorInflater.loadAnimator(this.m.i(), var6);
                     } catch (RuntimeException var12) {
                        if (var7) {
                           throw var12;
                        }
                        break label96;
                     }

                     if (var22 == null) {
                        break label81;
                     }

                     try {
                        return new FragmentManagerImpl.AnimationOrAnimator(var22);
                     } catch (RuntimeException var11) {
                        if (var7) {
                           throw var11;
                        }
                     }
                  }

                  Animation var18 = AnimationUtils.loadAnimation(this.m.i(), var6);
                  if (var18 != null) {
                     return new FragmentManagerImpl.AnimationOrAnimator(var18);
                  }
               }
            }

            if (var2 == 0) {
               return null;
            }

            var2 = b(var2, var3);
            if (var2 < 0) {
               var23 = null;
            } else {
               switch (var2) {
                  case 1:
                     return a(this.m.i(), 1.125F, 1.0F, 0.0F, 1.0F);
                  case 2:
                     return a(this.m.i(), 1.0F, 0.975F, 1.0F, 0.0F);
                  case 3:
                     return a(this.m.i(), 0.975F, 1.0F, 0.0F, 1.0F);
                  case 4:
                     return a(this.m.i(), 1.0F, 1.075F, 1.0F, 0.0F);
                  case 5:
                     return a(this.m.i(), 0.0F, 1.0F);
                  case 6:
                     return a(this.m.i(), 1.0F, 0.0F);
                  default:
                     var2 = var4;
                     if (var4 == 0) {
                        var2 = var4;
                        if (this.m.e()) {
                           var2 = this.m.f();
                        }
                     }

                     if (var2 == 0) {
                        var23 = null;
                     } else {
                        var23 = null;
                     }
               }
            }
         }
      }

      return var23;
   }

   @Override
   public FragmentTransaction a() {
      return new BackStackRecord(this);
   }

   @Override
   public void a(int var1, int var2) {
      if (var1 < 0) {
         throw new IllegalArgumentException("Bad id: " + var1);
      }

      this.a(new FragmentManagerImpl.PopBackStackState(this, null, var1, var2), false);
   }

   public void a(int param1, BackStackRecord param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 000: aload 0
      // 001: monitorenter
      // 002: aload 0
      // 003: getfield android/support/v4/app/FragmentManagerImpl.i Ljava/util/ArrayList;
      // 006: ifnonnull 019
      // 009: new java/util/ArrayList
      // 00c: astore 5
      // 00e: aload 5
      // 010: invokespecial java/util/ArrayList.<init> ()V
      // 013: aload 0
      // 014: aload 5
      // 016: putfield android/support/v4/app/FragmentManagerImpl.i Ljava/util/ArrayList;
      // 019: aload 0
      // 01a: getfield android/support/v4/app/FragmentManagerImpl.i Ljava/util/ArrayList;
      // 01d: invokevirtual java/util/ArrayList.size ()I
      // 020: istore 4
      // 022: iload 4
      // 024: istore 3
      // 025: iload 1
      // 026: iload 4
      // 028: if_icmpge 068
      // 02b: getstatic android/support/v4/app/FragmentManagerImpl.a Z
      // 02e: ifeq 05b
      // 031: new java/lang/StringBuilder
      // 034: astore 5
      // 036: aload 5
      // 038: invokespecial java/lang/StringBuilder.<init> ()V
      // 03b: ldc_w "FragmentManager"
      // 03e: aload 5
      // 040: ldc_w "Setting back stack index "
      // 043: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 046: iload 1
      // 047: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 04a: ldc_w " to "
      // 04d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 050: aload 2
      // 051: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 054: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 057: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 05a: pop
      // 05b: aload 0
      // 05c: getfield android/support/v4/app/FragmentManagerImpl.i Ljava/util/ArrayList;
      // 05f: iload 1
      // 060: aload 2
      // 061: invokevirtual java/util/ArrayList.set (ILjava/lang/Object;)Ljava/lang/Object;
      // 064: pop
      // 065: aload 0
      // 066: monitorexit
      // 067: return
      // 068: iload 3
      // 069: iload 1
      // 06a: if_icmpge 0c5
      // 06d: aload 0
      // 06e: getfield android/support/v4/app/FragmentManagerImpl.i Ljava/util/ArrayList;
      // 071: aconst_null
      // 072: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 075: pop
      // 076: aload 0
      // 077: getfield android/support/v4/app/FragmentManagerImpl.j Ljava/util/ArrayList;
      // 07a: ifnonnull 08d
      // 07d: new java/util/ArrayList
      // 080: astore 5
      // 082: aload 5
      // 084: invokespecial java/util/ArrayList.<init> ()V
      // 087: aload 0
      // 088: aload 5
      // 08a: putfield android/support/v4/app/FragmentManagerImpl.j Ljava/util/ArrayList;
      // 08d: getstatic android/support/v4/app/FragmentManagerImpl.a Z
      // 090: ifeq 0b3
      // 093: new java/lang/StringBuilder
      // 096: astore 5
      // 098: aload 5
      // 09a: invokespecial java/lang/StringBuilder.<init> ()V
      // 09d: ldc_w "FragmentManager"
      // 0a0: aload 5
      // 0a2: ldc_w "Adding available back stack index "
      // 0a5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a8: iload 3
      // 0a9: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 0ac: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0af: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 0b2: pop
      // 0b3: aload 0
      // 0b4: getfield android/support/v4/app/FragmentManagerImpl.j Ljava/util/ArrayList;
      // 0b7: iload 3
      // 0b8: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 0bb: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 0be: pop
      // 0bf: iinc 3 1
      // 0c2: goto 068
      // 0c5: getstatic android/support/v4/app/FragmentManagerImpl.a Z
      // 0c8: ifeq 0f5
      // 0cb: new java/lang/StringBuilder
      // 0ce: astore 5
      // 0d0: aload 5
      // 0d2: invokespecial java/lang/StringBuilder.<init> ()V
      // 0d5: ldc_w "FragmentManager"
      // 0d8: aload 5
      // 0da: ldc_w "Adding back stack index "
      // 0dd: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e0: iload 1
      // 0e1: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 0e4: ldc_w " with "
      // 0e7: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0ea: aload 2
      // 0eb: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 0ee: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0f1: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 0f4: pop
      // 0f5: aload 0
      // 0f6: getfield android/support/v4/app/FragmentManagerImpl.i Ljava/util/ArrayList;
      // 0f9: aload 2
      // 0fa: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 0fd: pop
      // 0fe: goto 065
      // 101: astore 2
      // 102: aload 0
      // 103: monitorexit
      // 104: aload 2
      // 105: athrow
      // try (2 -> 12): 115 null
      // try (12 -> 16): 115 null
      // try (21 -> 40): 115 null
      // try (40 -> 46): 115 null
      // try (46 -> 48): 115 null
      // try (52 -> 67): 115 null
      // try (67 -> 82): 115 null
      // try (82 -> 88): 115 null
      // try (90 -> 109): 115 null
      // try (109 -> 114): 115 null
      // try (116 -> 118): 115 null
   }

   void a(int var1, boolean var2) {
      if (this.m == null && var1 != 0) {
         throw new IllegalStateException("No activity");
      }

      if (var2 || var1 != this.l) {
         this.l = var1;
         if (this.f != null) {
            int var4 = this.e.size();
            int var3 = 0;
            boolean var6 = false;

            while (var3 < var4) {
               Fragment var5 = this.e.get(var3);
               this.f(var5);
               if (var5.mLoaderManager != null) {
                  var6 |= var5.mLoaderManager.a();
               }

               var3++;
            }

            var4 = this.f.size();

            for (int var7 = 0; var7 < var4; var7++) {
               Fragment var9 = (Fragment)this.f.valueAt(var7);
               if (var9 != null && (var9.mRemoving || var9.mDetached) && !var9.mIsNewlyAdded) {
                  this.f(var9);
                  if (var9.mLoaderManager != null) {
                     var6 |= var9.mLoaderManager.a();
                  }
               }
            }

            if (!var6) {
               this.h();
            }

            if (this.r && this.m != null && this.l == 5) {
               this.m.d();
               this.r = false;
            }
         }
      }
   }

   public void a(Configuration var1) {
      for (int var2 = 0; var2 < this.e.size(); var2++) {
         Fragment var3 = this.e.get(var2);
         if (var3 != null) {
            var3.performConfigurationChanged(var1);
         }
      }
   }

   @Override
   public void a(Bundle var1, String var2, Fragment var3) {
      if (var3.mIndex < 0) {
         this.a(new IllegalStateException("Fragment " + var3 + " is not currently in the FragmentManager"));
      }

      var1.putInt(var2, var3.mIndex);
   }

   void a(Parcelable param1, FragmentManagerNonConfig param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 000: aload 1
      // 001: ifnonnull 005
      // 004: return
      // 005: aload 1
      // 006: checkcast android/support/v4/app/FragmentManagerState
      // 009: astore 9
      // 00b: aload 9
      // 00d: getfield android/support/v4/app/FragmentManagerState.a [Landroid/support/v4/app/FragmentState;
      // 010: ifnull 004
      // 013: aload 2
      // 014: ifnull 404
      // 017: aload 2
      // 018: invokevirtual android/support/v4/app/FragmentManagerNonConfig.a ()Ljava/util/List;
      // 01b: astore 8
      // 01d: aload 2
      // 01e: invokevirtual android/support/v4/app/FragmentManagerNonConfig.b ()Ljava/util/List;
      // 021: astore 6
      // 023: aload 2
      // 024: invokevirtual android/support/v4/app/FragmentManagerNonConfig.c ()Ljava/util/List;
      // 027: astore 1
      // 028: aload 8
      // 02a: ifnull 095
      // 02d: aload 8
      // 02f: invokeinterface java/util/List.size ()I 1
      // 034: istore 3
      // 035: bipush 0
      // 036: istore 4
      // 038: iload 4
      // 03a: iload 3
      // 03b: if_icmpge 131
      // 03e: aload 8
      // 040: iload 4
      // 042: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 047: checkcast android/support/v4/app/Fragment
      // 04a: astore 10
      // 04c: getstatic android/support/v4/app/FragmentManagerImpl.a Z
      // 04f: ifeq 06e
      // 052: ldc_w "FragmentManager"
      // 055: new java/lang/StringBuilder
      // 058: dup
      // 059: invokespecial java/lang/StringBuilder.<init> ()V
      // 05c: ldc_w "restoreAllState: re-attaching retained "
      // 05f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 062: aload 10
      // 064: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 067: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 06a: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 06d: pop
      // 06e: bipush 0
      // 06f: istore 5
      // 071: iload 5
      // 073: aload 9
      // 075: getfield android/support/v4/app/FragmentManagerState.a [Landroid/support/v4/app/FragmentState;
      // 078: arraylength
      // 079: if_icmpge 09a
      // 07c: aload 9
      // 07e: getfield android/support/v4/app/FragmentManagerState.a [Landroid/support/v4/app/FragmentState;
      // 081: iload 5
      // 083: aaload
      // 084: getfield android/support/v4/app/FragmentState.b I
      // 087: aload 10
      // 089: getfield android/support/v4/app/Fragment.mIndex I
      // 08c: if_icmpeq 09a
      // 08f: iinc 5 1
      // 092: goto 071
      // 095: bipush 0
      // 096: istore 3
      // 097: goto 035
      // 09a: iload 5
      // 09c: aload 9
      // 09e: getfield android/support/v4/app/FragmentManagerState.a [Landroid/support/v4/app/FragmentState;
      // 0a1: arraylength
      // 0a2: if_icmpne 0c8
      // 0a5: aload 0
      // 0a6: new java/lang/IllegalStateException
      // 0a9: dup
      // 0aa: new java/lang/StringBuilder
      // 0ad: dup
      // 0ae: invokespecial java/lang/StringBuilder.<init> ()V
      // 0b1: ldc_w "Could not find active fragment with index "
      // 0b4: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0b7: aload 10
      // 0b9: getfield android/support/v4/app/Fragment.mIndex I
      // 0bc: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 0bf: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0c2: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 0c5: invokespecial android/support/v4/app/FragmentManagerImpl.a (Ljava/lang/RuntimeException;)V
      // 0c8: aload 9
      // 0ca: getfield android/support/v4/app/FragmentManagerState.a [Landroid/support/v4/app/FragmentState;
      // 0cd: iload 5
      // 0cf: aaload
      // 0d0: astore 7
      // 0d2: aload 7
      // 0d4: aload 10
      // 0d6: putfield android/support/v4/app/FragmentState.l Landroid/support/v4/app/Fragment;
      // 0d9: aload 10
      // 0db: aconst_null
      // 0dc: putfield android/support/v4/app/Fragment.mSavedViewState Landroid/util/SparseArray;
      // 0df: aload 10
      // 0e1: bipush 0
      // 0e2: putfield android/support/v4/app/Fragment.mBackStackNesting I
      // 0e5: aload 10
      // 0e7: bipush 0
      // 0e8: putfield android/support/v4/app/Fragment.mInLayout Z
      // 0eb: aload 10
      // 0ed: bipush 0
      // 0ee: putfield android/support/v4/app/Fragment.mAdded Z
      // 0f1: aload 10
      // 0f3: aconst_null
      // 0f4: putfield android/support/v4/app/Fragment.mTarget Landroid/support/v4/app/Fragment;
      // 0f7: aload 7
      // 0f9: getfield android/support/v4/app/FragmentState.k Landroid/os/Bundle;
      // 0fc: ifnull 12b
      // 0ff: aload 7
      // 101: getfield android/support/v4/app/FragmentState.k Landroid/os/Bundle;
      // 104: aload 0
      // 105: getfield android/support/v4/app/FragmentManagerImpl.m Landroid/support/v4/app/FragmentHostCallback;
      // 108: invokevirtual android/support/v4/app/FragmentHostCallback.i ()Landroid/content/Context;
      // 10b: invokevirtual android/content/Context.getClassLoader ()Ljava/lang/ClassLoader;
      // 10e: invokevirtual android/os/Bundle.setClassLoader (Ljava/lang/ClassLoader;)V
      // 111: aload 10
      // 113: aload 7
      // 115: getfield android/support/v4/app/FragmentState.k Landroid/os/Bundle;
      // 118: ldc_w "android:view_state"
      // 11b: invokevirtual android/os/Bundle.getSparseParcelableArray (Ljava/lang/String;)Landroid/util/SparseArray;
      // 11e: putfield android/support/v4/app/Fragment.mSavedViewState Landroid/util/SparseArray;
      // 121: aload 10
      // 123: aload 7
      // 125: getfield android/support/v4/app/FragmentState.k Landroid/os/Bundle;
      // 128: putfield android/support/v4/app/Fragment.mSavedFragmentState Landroid/os/Bundle;
      // 12b: iinc 4 1
      // 12e: goto 038
      // 131: aload 0
      // 132: new android/util/SparseArray
      // 135: dup
      // 136: aload 9
      // 138: getfield android/support/v4/app/FragmentManagerState.a [Landroid/support/v4/app/FragmentState;
      // 13b: arraylength
      // 13c: invokespecial android/util/SparseArray.<init> (I)V
      // 13f: putfield android/support/v4/app/FragmentManagerImpl.f Landroid/util/SparseArray;
      // 142: bipush 0
      // 143: istore 3
      // 144: iload 3
      // 145: aload 9
      // 147: getfield android/support/v4/app/FragmentManagerState.a [Landroid/support/v4/app/FragmentState;
      // 14a: arraylength
      // 14b: if_icmpge 1f0
      // 14e: aload 9
      // 150: getfield android/support/v4/app/FragmentManagerState.a [Landroid/support/v4/app/FragmentState;
      // 153: iload 3
      // 154: aaload
      // 155: astore 10
      // 157: aload 10
      // 159: ifnull 1ea
      // 15c: aload 6
      // 15e: ifnull 3fe
      // 161: iload 3
      // 162: aload 6
      // 164: invokeinterface java/util/List.size ()I 1
      // 169: if_icmpge 3fe
      // 16c: aload 6
      // 16e: iload 3
      // 16f: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 174: checkcast android/support/v4/app/FragmentManagerNonConfig
      // 177: astore 7
      // 179: aload 1
      // 17a: ifnull 3f8
      // 17d: iload 3
      // 17e: aload 1
      // 17f: invokeinterface java/util/List.size ()I 1
      // 184: if_icmpge 3f8
      // 187: aload 1
      // 188: iload 3
      // 189: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 18e: checkcast android/arch/lifecycle/ViewModelStore
      // 191: astore 8
      // 193: aload 10
      // 195: aload 0
      // 196: getfield android/support/v4/app/FragmentManagerImpl.m Landroid/support/v4/app/FragmentHostCallback;
      // 199: aload 0
      // 19a: getfield android/support/v4/app/FragmentManagerImpl.n Landroid/support/v4/app/FragmentContainer;
      // 19d: aload 0
      // 19e: getfield android/support/v4/app/FragmentManagerImpl.o Landroid/support/v4/app/Fragment;
      // 1a1: aload 7
      // 1a3: aload 8
      // 1a5: invokevirtual android/support/v4/app/FragmentState.a (Landroid/support/v4/app/FragmentHostCallback;Landroid/support/v4/app/FragmentContainer;Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManagerNonConfig;Landroid/arch/lifecycle/ViewModelStore;)Landroid/support/v4/app/Fragment;
      // 1a8: astore 7
      // 1aa: getstatic android/support/v4/app/FragmentManagerImpl.a Z
      // 1ad: ifeq 1d6
      // 1b0: ldc_w "FragmentManager"
      // 1b3: new java/lang/StringBuilder
      // 1b6: dup
      // 1b7: invokespecial java/lang/StringBuilder.<init> ()V
      // 1ba: ldc_w "restoreAllState: active #"
      // 1bd: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1c0: iload 3
      // 1c1: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 1c4: ldc_w ": "
      // 1c7: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1ca: aload 7
      // 1cc: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 1cf: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1d2: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 1d5: pop
      // 1d6: aload 0
      // 1d7: getfield android/support/v4/app/FragmentManagerImpl.f Landroid/util/SparseArray;
      // 1da: aload 7
      // 1dc: getfield android/support/v4/app/Fragment.mIndex I
      // 1df: aload 7
      // 1e1: invokevirtual android/util/SparseArray.put (ILjava/lang/Object;)V
      // 1e4: aload 10
      // 1e6: aconst_null
      // 1e7: putfield android/support/v4/app/FragmentState.l Landroid/support/v4/app/Fragment;
      // 1ea: iinc 3 1
      // 1ed: goto 144
      // 1f0: aload 2
      // 1f1: ifnull 26c
      // 1f4: aload 2
      // 1f5: invokevirtual android/support/v4/app/FragmentManagerNonConfig.a ()Ljava/util/List;
      // 1f8: astore 2
      // 1f9: aload 2
      // 1fa: ifnull 267
      // 1fd: aload 2
      // 1fe: invokeinterface java/util/List.size ()I 1
      // 203: istore 3
      // 204: bipush 0
      // 205: istore 4
      // 207: iload 4
      // 209: iload 3
      // 20a: if_icmpge 26c
      // 20d: aload 2
      // 20e: iload 4
      // 210: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 215: checkcast android/support/v4/app/Fragment
      // 218: astore 1
      // 219: aload 1
      // 21a: getfield android/support/v4/app/Fragment.mTargetIndex I
      // 21d: iflt 261
      // 220: aload 1
      // 221: aload 0
      // 222: getfield android/support/v4/app/FragmentManagerImpl.f Landroid/util/SparseArray;
      // 225: aload 1
      // 226: getfield android/support/v4/app/Fragment.mTargetIndex I
      // 229: invokevirtual android/util/SparseArray.get (I)Ljava/lang/Object;
      // 22c: checkcast android/support/v4/app/Fragment
      // 22f: putfield android/support/v4/app/Fragment.mTarget Landroid/support/v4/app/Fragment;
      // 232: aload 1
      // 233: getfield android/support/v4/app/Fragment.mTarget Landroid/support/v4/app/Fragment;
      // 236: ifnonnull 261
      // 239: ldc_w "FragmentManager"
      // 23c: new java/lang/StringBuilder
      // 23f: dup
      // 240: invokespecial java/lang/StringBuilder.<init> ()V
      // 243: ldc_w "Re-attaching retained fragment "
      // 246: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 249: aload 1
      // 24a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 24d: ldc_w " target no longer exists: "
      // 250: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 253: aload 1
      // 254: getfield android/support/v4/app/Fragment.mTargetIndex I
      // 257: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 25a: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 25d: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 260: pop
      // 261: iinc 4 1
      // 264: goto 207
      // 267: bipush 0
      // 268: istore 3
      // 269: goto 204
      // 26c: aload 0
      // 26d: getfield android/support/v4/app/FragmentManagerImpl.e Ljava/util/ArrayList;
      // 270: invokevirtual java/util/ArrayList.clear ()V
      // 273: aload 9
      // 275: getfield android/support/v4/app/FragmentManagerState.b [I
      // 278: ifnull 325
      // 27b: bipush 0
      // 27c: istore 3
      // 27d: iload 3
      // 27e: aload 9
      // 280: getfield android/support/v4/app/FragmentManagerState.b [I
      // 283: arraylength
      // 284: if_icmpge 325
      // 287: aload 0
      // 288: getfield android/support/v4/app/FragmentManagerImpl.f Landroid/util/SparseArray;
      // 28b: aload 9
      // 28d: getfield android/support/v4/app/FragmentManagerState.b [I
      // 290: iload 3
      // 291: iaload
      // 292: invokevirtual android/util/SparseArray.get (I)Ljava/lang/Object;
      // 295: checkcast android/support/v4/app/Fragment
      // 298: astore 2
      // 299: aload 2
      // 29a: ifnonnull 2c2
      // 29d: aload 0
      // 29e: new java/lang/IllegalStateException
      // 2a1: dup
      // 2a2: new java/lang/StringBuilder
      // 2a5: dup
      // 2a6: invokespecial java/lang/StringBuilder.<init> ()V
      // 2a9: ldc_w "No instantiated fragment for index #"
      // 2ac: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2af: aload 9
      // 2b1: getfield android/support/v4/app/FragmentManagerState.b [I
      // 2b4: iload 3
      // 2b5: iaload
      // 2b6: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 2b9: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 2bc: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 2bf: invokespecial android/support/v4/app/FragmentManagerImpl.a (Ljava/lang/RuntimeException;)V
      // 2c2: aload 2
      // 2c3: bipush 1
      // 2c4: putfield android/support/v4/app/Fragment.mAdded Z
      // 2c7: getstatic android/support/v4/app/FragmentManagerImpl.a Z
      // 2ca: ifeq 2f2
      // 2cd: ldc_w "FragmentManager"
      // 2d0: new java/lang/StringBuilder
      // 2d3: dup
      // 2d4: invokespecial java/lang/StringBuilder.<init> ()V
      // 2d7: ldc_w "restoreAllState: added #"
      // 2da: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2dd: iload 3
      // 2de: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 2e1: ldc_w ": "
      // 2e4: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2e7: aload 2
      // 2e8: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 2eb: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 2ee: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 2f1: pop
      // 2f2: aload 0
      // 2f3: getfield android/support/v4/app/FragmentManagerImpl.e Ljava/util/ArrayList;
      // 2f6: aload 2
      // 2f7: invokevirtual java/util/ArrayList.contains (Ljava/lang/Object;)Z
      // 2fa: ifeq 308
      // 2fd: new java/lang/IllegalStateException
      // 300: dup
      // 301: ldc_w "Already added!"
      // 304: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 307: athrow
      // 308: aload 0
      // 309: getfield android/support/v4/app/FragmentManagerImpl.e Ljava/util/ArrayList;
      // 30c: astore 1
      // 30d: aload 1
      // 30e: monitorenter
      // 30f: aload 0
      // 310: getfield android/support/v4/app/FragmentManagerImpl.e Ljava/util/ArrayList;
      // 313: aload 2
      // 314: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 317: pop
      // 318: aload 1
      // 319: monitorexit
      // 31a: iinc 3 1
      // 31d: goto 27d
      // 320: astore 2
      // 321: aload 1
      // 322: monitorexit
      // 323: aload 2
      // 324: athrow
      // 325: aload 9
      // 327: getfield android/support/v4/app/FragmentManagerState.c [Landroid/support/v4/app/BackStackState;
      // 32a: ifnull 3cc
      // 32d: aload 0
      // 32e: new java/util/ArrayList
      // 331: dup
      // 332: aload 9
      // 334: getfield android/support/v4/app/FragmentManagerState.c [Landroid/support/v4/app/BackStackState;
      // 337: arraylength
      // 338: invokespecial java/util/ArrayList.<init> (I)V
      // 33b: putfield android/support/v4/app/FragmentManagerImpl.g Ljava/util/ArrayList;
      // 33e: bipush 0
      // 33f: istore 3
      // 340: iload 3
      // 341: aload 9
      // 343: getfield android/support/v4/app/FragmentManagerState.c [Landroid/support/v4/app/BackStackState;
      // 346: arraylength
      // 347: if_icmpge 3d1
      // 34a: aload 9
      // 34c: getfield android/support/v4/app/FragmentManagerState.c [Landroid/support/v4/app/BackStackState;
      // 34f: iload 3
      // 350: aaload
      // 351: aload 0
      // 352: invokevirtual android/support/v4/app/BackStackState.a (Landroid/support/v4/app/FragmentManagerImpl;)Landroid/support/v4/app/BackStackRecord;
      // 355: astore 2
      // 356: getstatic android/support/v4/app/FragmentManagerImpl.a Z
      // 359: ifeq 3ad
      // 35c: ldc_w "FragmentManager"
      // 35f: new java/lang/StringBuilder
      // 362: dup
      // 363: invokespecial java/lang/StringBuilder.<init> ()V
      // 366: ldc_w "restoreAllState: back stack #"
      // 369: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 36c: iload 3
      // 36d: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 370: ldc_w " (index "
      // 373: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 376: aload 2
      // 377: getfield android/support/v4/app/BackStackRecord.m I
      // 37a: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 37d: ldc_w "): "
      // 380: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 383: aload 2
      // 384: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 387: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 38a: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 38d: pop
      // 38e: new java/io/PrintWriter
      // 391: dup
      // 392: new android/support/v4/util/LogWriter
      // 395: dup
      // 396: ldc_w "FragmentManager"
      // 399: invokespecial android/support/v4/util/LogWriter.<init> (Ljava/lang/String;)V
      // 39c: invokespecial java/io/PrintWriter.<init> (Ljava/io/Writer;)V
      // 39f: astore 1
      // 3a0: aload 2
      // 3a1: ldc_w "  "
      // 3a4: aload 1
      // 3a5: bipush 0
      // 3a6: invokevirtual android/support/v4/app/BackStackRecord.a (Ljava/lang/String;Ljava/io/PrintWriter;Z)V
      // 3a9: aload 1
      // 3aa: invokevirtual java/io/PrintWriter.close ()V
      // 3ad: aload 0
      // 3ae: getfield android/support/v4/app/FragmentManagerImpl.g Ljava/util/ArrayList;
      // 3b1: aload 2
      // 3b2: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 3b5: pop
      // 3b6: aload 2
      // 3b7: getfield android/support/v4/app/BackStackRecord.m I
      // 3ba: iflt 3c6
      // 3bd: aload 0
      // 3be: aload 2
      // 3bf: getfield android/support/v4/app/BackStackRecord.m I
      // 3c2: aload 2
      // 3c3: invokevirtual android/support/v4/app/FragmentManagerImpl.a (ILandroid/support/v4/app/BackStackRecord;)V
      // 3c6: iinc 3 1
      // 3c9: goto 340
      // 3cc: aload 0
      // 3cd: aconst_null
      // 3ce: putfield android/support/v4/app/FragmentManagerImpl.g Ljava/util/ArrayList;
      // 3d1: aload 9
      // 3d3: getfield android/support/v4/app/FragmentManagerState.d I
      // 3d6: iflt 3ec
      // 3d9: aload 0
      // 3da: aload 0
      // 3db: getfield android/support/v4/app/FragmentManagerImpl.f Landroid/util/SparseArray;
      // 3de: aload 9
      // 3e0: getfield android/support/v4/app/FragmentManagerState.d I
      // 3e3: invokevirtual android/util/SparseArray.get (I)Ljava/lang/Object;
      // 3e6: checkcast android/support/v4/app/Fragment
      // 3e9: putfield android/support/v4/app/FragmentManagerImpl.p Landroid/support/v4/app/Fragment;
      // 3ec: aload 0
      // 3ed: aload 9
      // 3ef: getfield android/support/v4/app/FragmentManagerState.e I
      // 3f2: putfield android/support/v4/app/FragmentManagerImpl.d I
      // 3f5: goto 004
      // 3f8: aconst_null
      // 3f9: astore 8
      // 3fb: goto 193
      // 3fe: aconst_null
      // 3ff: astore 7
      // 401: goto 179
      // 404: aconst_null
      // 405: astore 1
      // 406: aconst_null
      // 407: astore 6
      // 409: goto 131
      // try (345 -> 352): 354 null
      // try (355 -> 357): 354 null
   }

   void a(Fragment var1, int var2, int var3, int var4, boolean var5) {
      int var7;
      boolean var8;
      label291: {
         var8 = true;
         if (var1.mAdded) {
            var7 = var2;
            if (!var1.mDetached) {
               break label291;
            }
         }

         var7 = var2;
         if (var2 > 1) {
            var7 = 1;
         }
      }

      int var6 = var7;
      if (var1.mRemoving) {
         var6 = var7;
         if (var7 > var1.mState) {
            if (var1.mState == 0 && var1.isInBackStack()) {
               var6 = 1;
            } else {
               var6 = var1.mState;
            }
         }
      }

      var2 = var6;
      if (var1.mDeferStart) {
         var2 = var6;
         if (var1.mState < 4) {
            var2 = var6;
            if (var6 > 3) {
               var2 = 3;
            }
         }
      }

      label277:
      if (var1.mState <= var2) {
         if (var1.mFromLayout && !var1.mInLayout) {
            return;
         }

         if (var1.getAnimatingAway() != null || var1.getAnimator() != null) {
            var1.setAnimatingAway(null);
            var1.setAnimator(null);
            this.a(var1, var1.getStateAfterAnimating(), 0, 0, true);
         }

         label268: {
            var4 = var2;
            var6 = var2;
            var7 = var2;
            var3 = var2;
            switch (var1.mState) {
               case 0:
                  var4 = var2;
                  if (var2 > 0) {
                     if (a) {
                        Log.v("FragmentManager", "moveto CREATED: " + var1);
                     }

                     var4 = var2;
                     if (var1.mSavedFragmentState != null) {
                        var1.mSavedFragmentState.setClassLoader(this.m.i().getClassLoader());
                        var1.mSavedViewState = var1.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                        var1.mTarget = this.a(var1.mSavedFragmentState, "android:target_state");
                        if (var1.mTarget != null) {
                           var1.mTargetRequestCode = var1.mSavedFragmentState.getInt("android:target_req_state", 0);
                        }

                        var1.mUserVisibleHint = var1.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
                        var4 = var2;
                        if (!var1.mUserVisibleHint) {
                           var1.mDeferStart = true;
                           var4 = var2;
                           if (var2 > 3) {
                              var4 = 3;
                           }
                        }
                     }

                     var1.mHost = this.m;
                     var1.mParentFragment = this.o;
                     FragmentManagerImpl var9;
                     if (this.o != null) {
                        var9 = this.o.mChildFragmentManager;
                     } else {
                        var9 = this.m.k();
                     }

                     var1.mFragmentManager = var9;
                     if (var1.mTarget != null) {
                        if (this.f.get(var1.mTarget.mIndex) != var1.mTarget) {
                           throw new IllegalStateException(
                              "Fragment " + var1 + " declared target fragment " + var1.mTarget + " that does not belong to this FragmentManager!"
                           );
                        }

                        if (var1.mTarget.mState < 1) {
                           this.a(var1.mTarget, 1, 0, 0, true);
                        }
                     }

                     this.a(var1, this.m.i(), false);
                     var1.mCalled = false;
                     var1.onAttach(this.m.i());
                     if (!var1.mCalled) {
                        throw new SuperNotCalledException("Fragment " + var1 + " did not call through to super.onAttach()");
                     }

                     if (var1.mParentFragment == null) {
                        this.m.b(var1);
                     } else {
                        var1.mParentFragment.onAttachFragment(var1);
                     }

                     this.b(var1, this.m.i(), false);
                     if (!var1.mIsCreated) {
                        this.a(var1, var1.mSavedFragmentState, false);
                        var1.performCreate(var1.mSavedFragmentState);
                        this.b(var1, var1.mSavedFragmentState, false);
                     } else {
                        var1.restoreChildFragmentState(var1.mSavedFragmentState);
                        var1.mState = 1;
                     }

                     var1.mRetaining = false;
                  }
               case 1:
                  this.d(var1);
                  var6 = var4;
                  if (var4 > 1) {
                     if (a) {
                        Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + var1);
                     }

                     if (!var1.mFromLayout) {
                        ViewGroup var19;
                        if (var1.mContainerId != 0) {
                           if (var1.mContainerId == -1) {
                              this.a(new IllegalArgumentException("Cannot create fragment " + var1 + " for a container view with no id"));
                           }

                           ViewGroup var10 = (ViewGroup)this.n.a(var1.mContainerId);
                           var19 = var10;
                           if (var10 == null) {
                              var19 = var10;
                              if (!var1.mRestored) {
                                 try {
                                    var20 = var1.getResources().getResourceName(var1.mContainerId);
                                 } catch (NotFoundException var11) {
                                    var20 = "unknown";
                                 }

                                 this.a(
                                    new IllegalArgumentException(
                                       "No view found for id 0x" + Integer.toHexString(var1.mContainerId) + " (" + var20 + ") for fragment " + var1
                                    )
                                 );
                                 var19 = var10;
                              }
                           }
                        } else {
                           var19 = null;
                        }

                        var1.mContainer = var19;
                        var1.mView = var1.performCreateView(var1.performGetLayoutInflater(var1.mSavedFragmentState), var19, var1.mSavedFragmentState);
                        if (var1.mView == null) {
                           var1.mInnerView = null;
                        } else {
                           var1.mInnerView = var1.mView;
                           var1.mView.setSaveFromParentEnabled(false);
                           if (var19 != null) {
                              var19.addView(var1.mView);
                           }

                           if (var1.mHidden) {
                              var1.mView.setVisibility(8);
                           }

                           var1.onViewCreated(var1.mView, var1.mSavedFragmentState);
                           this.a(var1, var1.mView, var1.mSavedFragmentState, false);
                           if (var1.mView.getVisibility() == 0 && var1.mContainer != null) {
                              var5 = var8;
                           } else {
                              var5 = false;
                           }

                           var1.mIsNewlyAdded = var5;
                        }
                     }

                     var1.performActivityCreated(var1.mSavedFragmentState);
                     this.c(var1, var1.mSavedFragmentState, false);
                     if (var1.mView != null) {
                        var1.restoreViewState(var1.mSavedFragmentState);
                     }

                     var1.mSavedFragmentState = null;
                     var6 = var4;
                  }
               case 2:
                  var7 = var6;
                  if (var6 > 2) {
                     var1.mState = 3;
                     var7 = var6;
                  }
               case 3:
                  break;
               case 4:
                  break label268;
               default:
                  var6 = var2;
                  break label277;
            }

            var3 = var7;
            if (var7 > 3) {
               if (a) {
                  Log.v("FragmentManager", "moveto STARTED: " + var1);
               }

               var1.performStart();
               this.b(var1, false);
               var3 = var7;
            }
         }

         var6 = var3;
         if (var3 > 4) {
            if (a) {
               Log.v("FragmentManager", "moveto RESUMED: " + var1);
            }

            var1.performResume();
            this.c(var1, false);
            var1.mSavedFragmentState = null;
            var1.mSavedViewState = null;
            var6 = var3;
         }
      } else {
         var6 = var2;
         if (var1.mState > var2) {
            switch (var1.mState) {
               case 5:
                  if (var2 < 5) {
                     if (a) {
                        Log.v("FragmentManager", "movefrom RESUMED: " + var1);
                     }

                     var1.performPause();
                     this.d(var1, false);
                  }
               case 4:
                  if (var2 < 4) {
                     if (a) {
                        Log.v("FragmentManager", "movefrom STARTED: " + var1);
                     }

                     var1.performStop();
                     this.e(var1, false);
                  }
               case 3:
                  if (var2 < 3) {
                     if (a) {
                        Log.v("FragmentManager", "movefrom STOPPED: " + var1);
                     }

                     var1.performReallyStop();
                  }
               case 2:
                  if (var2 < 2) {
                     if (a) {
                        Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + var1);
                     }

                     if (var1.mView != null && this.m.a(var1) && var1.mSavedViewState == null) {
                        this.n(var1);
                     }

                     var1.performDestroyView();
                     this.f(var1, false);
                     if (var1.mView != null && var1.mContainer != null) {
                        var1.mContainer.endViewTransition(var1.mView);
                        var1.mView.clearAnimation();
                        FragmentManagerImpl.AnimationOrAnimator var21;
                        if (this.l > 0 && !this.t && var1.mView.getVisibility() == 0 && var1.mPostponedAlpha >= 0.0F) {
                           var21 = this.a(var1, var3, false, var4);
                        } else {
                           var21 = null;
                        }

                        var1.mPostponedAlpha = 0.0F;
                        if (var21 != null) {
                           this.a(var1, var21, var2);
                        }

                        var1.mContainer.removeView(var1.mView);
                     }

                     var1.mContainer = null;
                     var1.mView = null;
                     var1.mInnerView = null;
                     var1.mInLayout = false;
                  }
               case 1:
                  var6 = var2;
                  if (var2 < 1) {
                     if (this.t) {
                        if (var1.getAnimatingAway() != null) {
                           View var22 = var1.getAnimatingAway();
                           var1.setAnimatingAway(null);
                           var22.clearAnimation();
                        } else if (var1.getAnimator() != null) {
                           Animator var23 = var1.getAnimator();
                           var1.setAnimator(null);
                           var23.cancel();
                        }
                     }

                     if (var1.getAnimatingAway() == null && var1.getAnimator() == null) {
                        if (a) {
                           Log.v("FragmentManager", "movefrom CREATED: " + var1);
                        }

                        if (!var1.mRetaining) {
                           var1.performDestroy();
                           this.g(var1, false);
                        } else {
                           var1.mState = 0;
                        }

                        var1.performDetach();
                        this.h(var1, false);
                        var6 = var2;
                        if (!var5) {
                           if (!var1.mRetaining) {
                              this.h(var1);
                              var6 = var2;
                           } else {
                              var1.mHost = null;
                              var1.mParentFragment = null;
                              var1.mFragmentManager = null;
                              var6 = var2;
                           }
                        }
                     } else {
                        var1.setStateAfterAnimating(var2);
                        var6 = 1;
                     }
                  }
                  break;
               default:
                  var6 = var2;
            }
         }
      }

      if (var1.mState != var6) {
         Log.w("FragmentManager", "moveToState: Fragment state for " + var1 + " not updated inline; " + "expected state " + var6 + " found " + var1.mState);
         var1.mState = var6;
      }
   }

   void a(Fragment var1, Context var2, boolean var3) {
      if (this.o != null) {
         FragmentManager var4 = this.o.getFragmentManager();
         if (var4 instanceof FragmentManagerImpl) {
            ((FragmentManagerImpl)var4).a(var1, var2, true);
         }
      }

      for (Pair var5 : this.I) {
         if (!var3 || (Boolean)var5.b) {
            ((FragmentManager.FragmentLifecycleCallbacks)var5.a).a(this, var1, var2);
         }
      }
   }

   void a(Fragment var1, Bundle var2, boolean var3) {
      if (this.o != null) {
         FragmentManager var4 = this.o.getFragmentManager();
         if (var4 instanceof FragmentManagerImpl) {
            ((FragmentManagerImpl)var4).a(var1, var2, true);
         }
      }

      for (Pair var5 : this.I) {
         if (!var3 || (Boolean)var5.b) {
            ((FragmentManager.FragmentLifecycleCallbacks)var5.a).a(this, var1, var2);
         }
      }
   }

   void a(Fragment var1, View var2, Bundle var3, boolean var4) {
      if (this.o != null) {
         FragmentManager var5 = this.o.getFragmentManager();
         if (var5 instanceof FragmentManagerImpl) {
            ((FragmentManagerImpl)var5).a(var1, var2, var3, true);
         }
      }

      for (Pair var6 : this.I) {
         if (!var4 || (Boolean)var6.b) {
            ((FragmentManager.FragmentLifecycleCallbacks)var6.a).a(this, var1, var2, var3);
         }
      }
   }

   public void a(Fragment param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic android/support/v4/app/FragmentManagerImpl.a Z
      // 03: ifeq 21
      // 06: ldc_w "FragmentManager"
      // 09: new java/lang/StringBuilder
      // 0c: dup
      // 0d: invokespecial java/lang/StringBuilder.<init> ()V
      // 10: ldc_w "add: "
      // 13: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 16: aload 1
      // 17: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 1a: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1d: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 20: pop
      // 21: aload 0
      // 22: aload 1
      // 23: invokevirtual android/support/v4/app/FragmentManagerImpl.g (Landroid/support/v4/app/Fragment;)V
      // 26: aload 1
      // 27: getfield android/support/v4/app/Fragment.mDetached Z
      // 2a: ifne 98
      // 2d: aload 0
      // 2e: getfield android/support/v4/app/FragmentManagerImpl.e Ljava/util/ArrayList;
      // 31: aload 1
      // 32: invokevirtual java/util/ArrayList.contains (Ljava/lang/Object;)Z
      // 35: ifeq 54
      // 38: new java/lang/IllegalStateException
      // 3b: dup
      // 3c: new java/lang/StringBuilder
      // 3f: dup
      // 40: invokespecial java/lang/StringBuilder.<init> ()V
      // 43: ldc_w "Fragment already added: "
      // 46: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 49: aload 1
      // 4a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 4d: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 50: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 53: athrow
      // 54: aload 0
      // 55: getfield android/support/v4/app/FragmentManagerImpl.e Ljava/util/ArrayList;
      // 58: astore 3
      // 59: aload 3
      // 5a: monitorenter
      // 5b: aload 0
      // 5c: getfield android/support/v4/app/FragmentManagerImpl.e Ljava/util/ArrayList;
      // 5f: aload 1
      // 60: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 63: pop
      // 64: aload 3
      // 65: monitorexit
      // 66: aload 1
      // 67: bipush 1
      // 68: putfield android/support/v4/app/Fragment.mAdded Z
      // 6b: aload 1
      // 6c: bipush 0
      // 6d: putfield android/support/v4/app/Fragment.mRemoving Z
      // 70: aload 1
      // 71: getfield android/support/v4/app/Fragment.mView Landroid/view/View;
      // 74: ifnonnull 7c
      // 77: aload 1
      // 78: bipush 0
      // 79: putfield android/support/v4/app/Fragment.mHiddenChanged Z
      // 7c: aload 1
      // 7d: getfield android/support/v4/app/Fragment.mHasMenu Z
      // 80: ifeq 8f
      // 83: aload 1
      // 84: getfield android/support/v4/app/Fragment.mMenuVisible Z
      // 87: ifeq 8f
      // 8a: aload 0
      // 8b: bipush 1
      // 8c: putfield android/support/v4/app/FragmentManagerImpl.r Z
      // 8f: iload 2
      // 90: ifeq 98
      // 93: aload 0
      // 94: aload 1
      // 95: invokevirtual android/support/v4/app/FragmentManagerImpl.c (Landroid/support/v4/app/Fragment;)V
      // 98: return
      // 99: astore 1
      // 9a: aload 3
      // 9b: monitorexit
      // 9c: aload 1
      // 9d: athrow
      // try (41 -> 48): 75 null
      // try (76 -> 78): 75 null
   }

   public void a(FragmentHostCallback var1, FragmentContainer var2, Fragment var3) {
      if (this.m != null) {
         throw new IllegalStateException("Already attached");
      }

      this.m = var1;
      this.n = var2;
      this.o = var3;
   }

   public void a(FragmentManagerImpl.OpGenerator param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: iload 2
      // 01: ifne 08
      // 04: aload 0
      // 05: invokespecial android/support/v4/app/FragmentManagerImpl.B ()V
      // 08: aload 0
      // 09: monitorenter
      // 0a: aload 0
      // 0b: getfield android/support/v4/app/FragmentManagerImpl.t Z
      // 0e: ifne 18
      // 11: aload 0
      // 12: getfield android/support/v4/app/FragmentManagerImpl.m Landroid/support/v4/app/FragmentHostCallback;
      // 15: ifnonnull 31
      // 18: iload 2
      // 19: ifeq 1f
      // 1c: aload 0
      // 1d: monitorexit
      // 1e: return
      // 1f: new java/lang/IllegalStateException
      // 22: astore 1
      // 23: aload 1
      // 24: ldc_w "Activity has been destroyed"
      // 27: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 2a: aload 1
      // 2b: athrow
      // 2c: astore 1
      // 2d: aload 0
      // 2e: monitorexit
      // 2f: aload 1
      // 30: athrow
      // 31: aload 0
      // 32: getfield android/support/v4/app/FragmentManagerImpl.b Ljava/util/ArrayList;
      // 35: ifnonnull 45
      // 38: new java/util/ArrayList
      // 3b: astore 3
      // 3c: aload 3
      // 3d: invokespecial java/util/ArrayList.<init> ()V
      // 40: aload 0
      // 41: aload 3
      // 42: putfield android/support/v4/app/FragmentManagerImpl.b Ljava/util/ArrayList;
      // 45: aload 0
      // 46: getfield android/support/v4/app/FragmentManagerImpl.b Ljava/util/ArrayList;
      // 49: aload 1
      // 4a: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 4d: pop
      // 4e: aload 0
      // 4f: invokespecial android/support/v4/app/FragmentManagerImpl.C ()V
      // 52: aload 0
      // 53: monitorexit
      // 54: goto 1e
      // try (6 -> 12): 24 null
      // try (14 -> 16): 24 null
      // try (17 -> 24): 24 null
      // try (25 -> 27): 24 null
      // try (29 -> 39): 24 null
      // try (39 -> 48): 24 null
   }

   @Override
   public void a(String param1, FileDescriptor param2, PrintWriter param3, String[] param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 000: bipush 0
      // 001: istore 6
      // 003: new java/lang/StringBuilder
      // 006: dup
      // 007: invokespecial java/lang/StringBuilder.<init> ()V
      // 00a: aload 1
      // 00b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 00e: ldc_w "    "
      // 011: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 014: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 017: astore 8
      // 019: aload 0
      // 01a: getfield android/support/v4/app/FragmentManagerImpl.f Landroid/util/SparseArray;
      // 01d: ifnull 099
      // 020: aload 0
      // 021: getfield android/support/v4/app/FragmentManagerImpl.f Landroid/util/SparseArray;
      // 024: invokevirtual android/util/SparseArray.size ()I
      // 027: istore 7
      // 029: iload 7
      // 02b: ifle 099
      // 02e: aload 3
      // 02f: aload 1
      // 030: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 033: aload 3
      // 034: ldc_w "Active Fragments in "
      // 037: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 03a: aload 3
      // 03b: aload 0
      // 03c: invokestatic java/lang/System.identityHashCode (Ljava/lang/Object;)I
      // 03f: invokestatic java/lang/Integer.toHexString (I)Ljava/lang/String;
      // 042: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 045: aload 3
      // 046: ldc_w ":"
      // 049: invokevirtual java/io/PrintWriter.println (Ljava/lang/String;)V
      // 04c: bipush 0
      // 04d: istore 5
      // 04f: iload 5
      // 051: iload 7
      // 053: if_icmpge 099
      // 056: aload 0
      // 057: getfield android/support/v4/app/FragmentManagerImpl.f Landroid/util/SparseArray;
      // 05a: iload 5
      // 05c: invokevirtual android/util/SparseArray.valueAt (I)Ljava/lang/Object;
      // 05f: checkcast android/support/v4/app/Fragment
      // 062: astore 9
      // 064: aload 3
      // 065: aload 1
      // 066: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 069: aload 3
      // 06a: ldc_w "  #"
      // 06d: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 070: aload 3
      // 071: iload 5
      // 073: invokevirtual java/io/PrintWriter.print (I)V
      // 076: aload 3
      // 077: ldc_w ": "
      // 07a: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 07d: aload 3
      // 07e: aload 9
      // 080: invokevirtual java/io/PrintWriter.println (Ljava/lang/Object;)V
      // 083: aload 9
      // 085: ifnull 093
      // 088: aload 9
      // 08a: aload 8
      // 08c: aload 2
      // 08d: aload 3
      // 08e: aload 4
      // 090: invokevirtual android/support/v4/app/Fragment.dump (Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
      // 093: iinc 5 1
      // 096: goto 04f
      // 099: aload 0
      // 09a: getfield android/support/v4/app/FragmentManagerImpl.e Ljava/util/ArrayList;
      // 09d: invokevirtual java/util/ArrayList.size ()I
      // 0a0: istore 7
      // 0a2: iload 7
      // 0a4: ifle 0f3
      // 0a7: aload 3
      // 0a8: aload 1
      // 0a9: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 0ac: aload 3
      // 0ad: ldc_w "Added Fragments:"
      // 0b0: invokevirtual java/io/PrintWriter.println (Ljava/lang/String;)V
      // 0b3: bipush 0
      // 0b4: istore 5
      // 0b6: iload 5
      // 0b8: iload 7
      // 0ba: if_icmpge 0f3
      // 0bd: aload 0
      // 0be: getfield android/support/v4/app/FragmentManagerImpl.e Ljava/util/ArrayList;
      // 0c1: iload 5
      // 0c3: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 0c6: checkcast android/support/v4/app/Fragment
      // 0c9: astore 9
      // 0cb: aload 3
      // 0cc: aload 1
      // 0cd: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 0d0: aload 3
      // 0d1: ldc_w "  #"
      // 0d4: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 0d7: aload 3
      // 0d8: iload 5
      // 0da: invokevirtual java/io/PrintWriter.print (I)V
      // 0dd: aload 3
      // 0de: ldc_w ": "
      // 0e1: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 0e4: aload 3
      // 0e5: aload 9
      // 0e7: invokevirtual android/support/v4/app/Fragment.toString ()Ljava/lang/String;
      // 0ea: invokevirtual java/io/PrintWriter.println (Ljava/lang/String;)V
      // 0ed: iinc 5 1
      // 0f0: goto 0b6
      // 0f3: aload 0
      // 0f4: getfield android/support/v4/app/FragmentManagerImpl.h Ljava/util/ArrayList;
      // 0f7: ifnull 154
      // 0fa: aload 0
      // 0fb: getfield android/support/v4/app/FragmentManagerImpl.h Ljava/util/ArrayList;
      // 0fe: invokevirtual java/util/ArrayList.size ()I
      // 101: istore 7
      // 103: iload 7
      // 105: ifle 154
      // 108: aload 3
      // 109: aload 1
      // 10a: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 10d: aload 3
      // 10e: ldc_w "Fragments Created Menus:"
      // 111: invokevirtual java/io/PrintWriter.println (Ljava/lang/String;)V
      // 114: bipush 0
      // 115: istore 5
      // 117: iload 5
      // 119: iload 7
      // 11b: if_icmpge 154
      // 11e: aload 0
      // 11f: getfield android/support/v4/app/FragmentManagerImpl.h Ljava/util/ArrayList;
      // 122: iload 5
      // 124: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 127: checkcast android/support/v4/app/Fragment
      // 12a: astore 9
      // 12c: aload 3
      // 12d: aload 1
      // 12e: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 131: aload 3
      // 132: ldc_w "  #"
      // 135: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 138: aload 3
      // 139: iload 5
      // 13b: invokevirtual java/io/PrintWriter.print (I)V
      // 13e: aload 3
      // 13f: ldc_w ": "
      // 142: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 145: aload 3
      // 146: aload 9
      // 148: invokevirtual android/support/v4/app/Fragment.toString ()Ljava/lang/String;
      // 14b: invokevirtual java/io/PrintWriter.println (Ljava/lang/String;)V
      // 14e: iinc 5 1
      // 151: goto 117
      // 154: aload 0
      // 155: getfield android/support/v4/app/FragmentManagerImpl.g Ljava/util/ArrayList;
      // 158: ifnull 1c0
      // 15b: aload 0
      // 15c: getfield android/support/v4/app/FragmentManagerImpl.g Ljava/util/ArrayList;
      // 15f: invokevirtual java/util/ArrayList.size ()I
      // 162: istore 7
      // 164: iload 7
      // 166: ifle 1c0
      // 169: aload 3
      // 16a: aload 1
      // 16b: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 16e: aload 3
      // 16f: ldc_w "Back Stack:"
      // 172: invokevirtual java/io/PrintWriter.println (Ljava/lang/String;)V
      // 175: bipush 0
      // 176: istore 5
      // 178: iload 5
      // 17a: iload 7
      // 17c: if_icmpge 1c0
      // 17f: aload 0
      // 180: getfield android/support/v4/app/FragmentManagerImpl.g Ljava/util/ArrayList;
      // 183: iload 5
      // 185: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 188: checkcast android/support/v4/app/BackStackRecord
      // 18b: astore 9
      // 18d: aload 3
      // 18e: aload 1
      // 18f: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 192: aload 3
      // 193: ldc_w "  #"
      // 196: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 199: aload 3
      // 19a: iload 5
      // 19c: invokevirtual java/io/PrintWriter.print (I)V
      // 19f: aload 3
      // 1a0: ldc_w ": "
      // 1a3: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 1a6: aload 3
      // 1a7: aload 9
      // 1a9: invokevirtual android/support/v4/app/BackStackRecord.toString ()Ljava/lang/String;
      // 1ac: invokevirtual java/io/PrintWriter.println (Ljava/lang/String;)V
      // 1af: aload 9
      // 1b1: aload 8
      // 1b3: aload 2
      // 1b4: aload 3
      // 1b5: aload 4
      // 1b7: invokevirtual android/support/v4/app/BackStackRecord.a (Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
      // 1ba: iinc 5 1
      // 1bd: goto 178
      // 1c0: aload 0
      // 1c1: monitorenter
      // 1c2: aload 0
      // 1c3: getfield android/support/v4/app/FragmentManagerImpl.i Ljava/util/ArrayList;
      // 1c6: ifnull 21e
      // 1c9: aload 0
      // 1ca: getfield android/support/v4/app/FragmentManagerImpl.i Ljava/util/ArrayList;
      // 1cd: invokevirtual java/util/ArrayList.size ()I
      // 1d0: istore 7
      // 1d2: iload 7
      // 1d4: ifle 21e
      // 1d7: aload 3
      // 1d8: aload 1
      // 1d9: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 1dc: aload 3
      // 1dd: ldc_w "Back Stack Indices:"
      // 1e0: invokevirtual java/io/PrintWriter.println (Ljava/lang/String;)V
      // 1e3: bipush 0
      // 1e4: istore 5
      // 1e6: iload 5
      // 1e8: iload 7
      // 1ea: if_icmpge 21e
      // 1ed: aload 0
      // 1ee: getfield android/support/v4/app/FragmentManagerImpl.i Ljava/util/ArrayList;
      // 1f1: iload 5
      // 1f3: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 1f6: checkcast android/support/v4/app/BackStackRecord
      // 1f9: astore 2
      // 1fa: aload 3
      // 1fb: aload 1
      // 1fc: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 1ff: aload 3
      // 200: ldc_w "  #"
      // 203: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 206: aload 3
      // 207: iload 5
      // 209: invokevirtual java/io/PrintWriter.print (I)V
      // 20c: aload 3
      // 20d: ldc_w ": "
      // 210: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 213: aload 3
      // 214: aload 2
      // 215: invokevirtual java/io/PrintWriter.println (Ljava/lang/Object;)V
      // 218: iinc 5 1
      // 21b: goto 1e6
      // 21e: aload 0
      // 21f: getfield android/support/v4/app/FragmentManagerImpl.j Ljava/util/ArrayList;
      // 222: ifnull 249
      // 225: aload 0
      // 226: getfield android/support/v4/app/FragmentManagerImpl.j Ljava/util/ArrayList;
      // 229: invokevirtual java/util/ArrayList.size ()I
      // 22c: ifle 249
      // 22f: aload 3
      // 230: aload 1
      // 231: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 234: aload 3
      // 235: ldc_w "mAvailBackStackIndices: "
      // 238: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 23b: aload 3
      // 23c: aload 0
      // 23d: getfield android/support/v4/app/FragmentManagerImpl.j Ljava/util/ArrayList;
      // 240: invokevirtual java/util/ArrayList.toArray ()[Ljava/lang/Object;
      // 243: invokestatic java/util/Arrays.toString ([Ljava/lang/Object;)Ljava/lang/String;
      // 246: invokevirtual java/io/PrintWriter.println (Ljava/lang/String;)V
      // 249: aload 0
      // 24a: monitorexit
      // 24b: aload 0
      // 24c: getfield android/support/v4/app/FragmentManagerImpl.b Ljava/util/ArrayList;
      // 24f: ifnull 2ad
      // 252: aload 0
      // 253: getfield android/support/v4/app/FragmentManagerImpl.b Ljava/util/ArrayList;
      // 256: invokevirtual java/util/ArrayList.size ()I
      // 259: istore 7
      // 25b: iload 7
      // 25d: ifle 2ad
      // 260: aload 3
      // 261: aload 1
      // 262: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 265: aload 3
      // 266: ldc_w "Pending Actions:"
      // 269: invokevirtual java/io/PrintWriter.println (Ljava/lang/String;)V
      // 26c: iload 6
      // 26e: istore 5
      // 270: iload 5
      // 272: iload 7
      // 274: if_icmpge 2ad
      // 277: aload 0
      // 278: getfield android/support/v4/app/FragmentManagerImpl.b Ljava/util/ArrayList;
      // 27b: iload 5
      // 27d: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 280: checkcast android/support/v4/app/FragmentManagerImpl$OpGenerator
      // 283: astore 2
      // 284: aload 3
      // 285: aload 1
      // 286: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 289: aload 3
      // 28a: ldc_w "  #"
      // 28d: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 290: aload 3
      // 291: iload 5
      // 293: invokevirtual java/io/PrintWriter.print (I)V
      // 296: aload 3
      // 297: ldc_w ": "
      // 29a: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 29d: aload 3
      // 29e: aload 2
      // 29f: invokevirtual java/io/PrintWriter.println (Ljava/lang/Object;)V
      // 2a2: iinc 5 1
      // 2a5: goto 270
      // 2a8: astore 1
      // 2a9: aload 0
      // 2aa: monitorexit
      // 2ab: aload 1
      // 2ac: athrow
      // 2ad: aload 3
      // 2ae: aload 1
      // 2af: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 2b2: aload 3
      // 2b3: ldc_w "FragmentManager misc state:"
      // 2b6: invokevirtual java/io/PrintWriter.println (Ljava/lang/String;)V
      // 2b9: aload 3
      // 2ba: aload 1
      // 2bb: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 2be: aload 3
      // 2bf: ldc_w "  mHost="
      // 2c2: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 2c5: aload 3
      // 2c6: aload 0
      // 2c7: getfield android/support/v4/app/FragmentManagerImpl.m Landroid/support/v4/app/FragmentHostCallback;
      // 2ca: invokevirtual java/io/PrintWriter.println (Ljava/lang/Object;)V
      // 2cd: aload 3
      // 2ce: aload 1
      // 2cf: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 2d2: aload 3
      // 2d3: ldc_w "  mContainer="
      // 2d6: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 2d9: aload 3
      // 2da: aload 0
      // 2db: getfield android/support/v4/app/FragmentManagerImpl.n Landroid/support/v4/app/FragmentContainer;
      // 2de: invokevirtual java/io/PrintWriter.println (Ljava/lang/Object;)V
      // 2e1: aload 0
      // 2e2: getfield android/support/v4/app/FragmentManagerImpl.o Landroid/support/v4/app/Fragment;
      // 2e5: ifnull 2fc
      // 2e8: aload 3
      // 2e9: aload 1
      // 2ea: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 2ed: aload 3
      // 2ee: ldc_w "  mParent="
      // 2f1: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 2f4: aload 3
      // 2f5: aload 0
      // 2f6: getfield android/support/v4/app/FragmentManagerImpl.o Landroid/support/v4/app/Fragment;
      // 2f9: invokevirtual java/io/PrintWriter.println (Ljava/lang/Object;)V
      // 2fc: aload 3
      // 2fd: aload 1
      // 2fe: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 301: aload 3
      // 302: ldc_w "  mCurState="
      // 305: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 308: aload 3
      // 309: aload 0
      // 30a: getfield android/support/v4/app/FragmentManagerImpl.l I
      // 30d: invokevirtual java/io/PrintWriter.print (I)V
      // 310: aload 3
      // 311: ldc_w " mStateSaved="
      // 314: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 317: aload 3
      // 318: aload 0
      // 319: getfield android/support/v4/app/FragmentManagerImpl.s Z
      // 31c: invokevirtual java/io/PrintWriter.print (Z)V
      // 31f: aload 3
      // 320: ldc_w " mDestroyed="
      // 323: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 326: aload 3
      // 327: aload 0
      // 328: getfield android/support/v4/app/FragmentManagerImpl.t Z
      // 32b: invokevirtual java/io/PrintWriter.println (Z)V
      // 32e: aload 0
      // 32f: getfield android/support/v4/app/FragmentManagerImpl.r Z
      // 332: ifeq 349
      // 335: aload 3
      // 336: aload 1
      // 337: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 33a: aload 3
      // 33b: ldc_w "  mNeedMenuInvalidate="
      // 33e: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 341: aload 3
      // 342: aload 0
      // 343: getfield android/support/v4/app/FragmentManagerImpl.r Z
      // 346: invokevirtual java/io/PrintWriter.println (Z)V
      // 349: aload 0
      // 34a: getfield android/support/v4/app/FragmentManagerImpl.u Ljava/lang/String;
      // 34d: ifnull 364
      // 350: aload 3
      // 351: aload 1
      // 352: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 355: aload 3
      // 356: ldc_w "  mNoTransactionsBecause="
      // 359: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 35c: aload 3
      // 35d: aload 0
      // 35e: getfield android/support/v4/app/FragmentManagerImpl.u Ljava/lang/String;
      // 361: invokevirtual java/io/PrintWriter.println (Ljava/lang/String;)V
      // 364: return
      // try (207 -> 214): 314 null
      // try (216 -> 222): 314 null
      // try (227 -> 248): 314 null
      // try (250 -> 269): 314 null
      // try (269 -> 271): 314 null
      // try (315 -> 317): 314 null
   }

   public void a(boolean var1) {
      for (int var2 = this.e.size() - 1; var2 >= 0; var2--) {
         Fragment var3 = this.e.get(var2);
         if (var3 != null) {
            var3.performMultiWindowModeChanged(var1);
         }
      }
   }

   public boolean a(Menu var1) {
      boolean var3 = false;
      if (this.l >= 1) {
         int var2 = 0;
         var3 = false;

         while (var2 < this.e.size()) {
            Fragment var5 = this.e.get(var2);
            boolean var4 = var3;
            if (var5 != null) {
               var4 = var3;
               if (var5.performPrepareOptionsMenu(var1)) {
                  var4 = true;
               }
            }

            var2++;
            var3 = var4;
         }
      }

      return var3;
   }

   public boolean a(Menu var1, MenuInflater var2) {
      byte var4 = 0;
      boolean var5 = false;
      if (this.l >= 1) {
         ArrayList var6 = null;
         int var3 = 0;
         var5 = false;

         while (var3 < this.e.size()) {
            Fragment var8 = this.e.get(var3);
            if (var8 != null && var8.performCreateOptionsMenu(var1, var2)) {
               ArrayList var7 = var6;
               if (var6 == null) {
                  var7 = new ArrayList();
               }

               var7.add(var8);
               var5 = true;
               var6 = var7;
            }

            var3++;
         }

         if (this.h != null) {
            for (int var10 = var4; var10 < this.h.size(); var10++) {
               Fragment var9 = this.h.get(var10);
               if (var6 == null || !var6.contains(var9)) {
                  var9.onDestroyOptionsMenu();
               }
            }
         }

         this.h = var6;
      }

      return var5;
   }

   public boolean a(MenuItem var1) {
      boolean var4 = false;
      boolean var3;
      if (this.l < 1) {
         var3 = var4;
      } else {
         int var2 = 0;

         while (true) {
            var3 = var4;
            if (var2 >= this.e.size()) {
               break;
            }

            Fragment var5 = this.e.get(var2);
            if (var5 != null && var5.performOptionsItemSelected(var1)) {
               var3 = true;
               break;
            }

            var2++;
         }
      }

      return var3;
   }

   @Override
   public boolean a(String var1, int var2) {
      this.B();
      return this.a(var1, -1, var2);
   }

   boolean a(ArrayList<BackStackRecord> var1, ArrayList<Boolean> var2, String var3, int var4, int var5) {
      boolean var8;
      if (this.g == null) {
         var8 = false;
      } else {
         if (var3 == null && var4 < 0 && (var5 & 1) == 0) {
            var4 = this.g.size() - 1;
            if (var4 < 0) {
               var8 = false;
               return var8;
            }

            var1.add(this.g.remove(var4));
            var2.add(true);
         } else {
            int var6 = -1;
            if (var3 != null || var4 >= 0) {
               int var7;
               for (var7 = this.g.size() - 1; var7 >= 0; var7--) {
                  BackStackRecord var9 = this.g.get(var7);
                  if (var3 != null && var3.equals(var9.j()) || var4 >= 0 && var4 == var9.m) {
                     break;
                  }
               }

               if (var7 < 0) {
                  var8 = false;
                  return var8;
               }

               var6 = var7;
               if ((var5 & 1) != 0) {
                  var5 = var7 - 1;

                  while (true) {
                     var6 = var5;
                     if (var5 < 0) {
                        break;
                     }

                     BackStackRecord var13 = this.g.get(var5);
                     if (var3 == null || !var3.equals(var13.j())) {
                        var6 = var5;
                        if (var4 < 0) {
                           break;
                        }

                        var6 = var5;
                        if (var4 != var13.m) {
                           break;
                        }
                     }

                     var5--;
                  }
               }
            }

            if (var6 == this.g.size() - 1) {
               var8 = false;
               return var8;
            }

            for (int var10 = this.g.size() - 1; var10 > var6; var10--) {
               var1.add(this.g.remove(var10));
               var2.add(true);
            }
         }

         var8 = true;
      }

      return var8;
   }

   public Fragment b(String var1) {
      if (this.f != null && var1 != null) {
         for (int var2 = this.f.size() - 1; var2 >= 0; var2--) {
            Fragment var3 = (Fragment)this.f.valueAt(var2);
            if (var3 != null) {
               var3 = var3.findFragmentByWho(var1);
               if (var3 != null) {
                  return var3;
               }
            }
         }
      }

      return null;
   }

   @Override
   public FragmentManager.BackStackEntry b(int var1) {
      return this.g.get(var1);
   }

   void b(BackStackRecord var1) {
      if (this.g == null) {
         this.g = new ArrayList<>();
      }

      this.g.add(var1);
   }

   public void b(Fragment var1) {
      if (var1.mDeferStart) {
         if (this.c) {
            this.v = true;
         } else {
            var1.mDeferStart = false;
            this.a(var1, this.l, 0, 0, false);
         }
      }
   }

   void b(Fragment var1, Context var2, boolean var3) {
      if (this.o != null) {
         FragmentManager var4 = this.o.getFragmentManager();
         if (var4 instanceof FragmentManagerImpl) {
            ((FragmentManagerImpl)var4).b(var1, var2, true);
         }
      }

      for (Pair var5 : this.I) {
         if (!var3 || (Boolean)var5.b) {
            ((FragmentManager.FragmentLifecycleCallbacks)var5.a).b(this, var1, var2);
         }
      }
   }

   void b(Fragment var1, Bundle var2, boolean var3) {
      if (this.o != null) {
         FragmentManager var4 = this.o.getFragmentManager();
         if (var4 instanceof FragmentManagerImpl) {
            ((FragmentManagerImpl)var4).b(var1, var2, true);
         }
      }

      for (Pair var5 : this.I) {
         if (!var3 || (Boolean)var5.b) {
            ((FragmentManager.FragmentLifecycleCallbacks)var5.a).b(this, var1, var2);
         }
      }
   }

   void b(Fragment var1, boolean var2) {
      if (this.o != null) {
         FragmentManager var3 = this.o.getFragmentManager();
         if (var3 instanceof FragmentManagerImpl) {
            ((FragmentManagerImpl)var3).b(var1, true);
         }
      }

      for (Pair var4 : this.I) {
         if (!var2 || (Boolean)var4.b) {
            ((FragmentManager.FragmentLifecycleCallbacks)var4.a).a(this, var1);
         }
      }
   }

   public void b(FragmentManagerImpl.OpGenerator var1, boolean var2) {
      if (!var2 || this.m != null && !this.t) {
         this.c(var2);
         if (var1.a(this.w, this.x)) {
            this.c = true;

            try {
               this.b(this.w, this.x);
            } finally {
               this.D();
            }
         }

         this.j();
         this.G();
      }
   }

   public void b(Menu var1) {
      if (this.l >= 1) {
         for (int var2 = 0; var2 < this.e.size(); var2++) {
            Fragment var3 = this.e.get(var2);
            if (var3 != null) {
               var3.performOptionsMenuClosed(var1);
            }
         }
      }
   }

   public void b(boolean var1) {
      for (int var2 = this.e.size() - 1; var2 >= 0; var2--) {
         Fragment var3 = this.e.get(var2);
         if (var3 != null) {
            var3.performPictureInPictureModeChanged(var1);
         }
      }
   }

   @Override
   public boolean b() {
      boolean var1 = this.i();
      this.E();
      return var1;
   }

   @Override
   public boolean b(int var1, int var2) {
      this.B();
      this.i();
      if (var1 < 0) {
         throw new IllegalArgumentException("Bad id: " + var1);
      } else {
         return this.a(null, var1, var2);
      }
   }

   public boolean b(MenuItem var1) {
      boolean var4 = false;
      boolean var3;
      if (this.l < 1) {
         var3 = var4;
      } else {
         int var2 = 0;

         while (true) {
            var3 = var4;
            if (var2 >= this.e.size()) {
               break;
            }

            Fragment var5 = this.e.get(var2);
            if (var5 != null && var5.performContextItemSelected(var1)) {
               var3 = true;
               break;
            }

            var2++;
         }
      }

      return var3;
   }

   @Override
   public void c() {
      this.a(new FragmentManagerImpl.PopBackStackState(this, null, -1, 0), false);
   }

   void c(Fragment var1) {
      this.a(var1, this.l, 0, 0, false);
   }

   void c(Fragment var1, Bundle var2, boolean var3) {
      if (this.o != null) {
         FragmentManager var4 = this.o.getFragmentManager();
         if (var4 instanceof FragmentManagerImpl) {
            ((FragmentManagerImpl)var4).c(var1, var2, true);
         }
      }

      for (Pair var6 : this.I) {
         if (!var3 || (Boolean)var6.b) {
            ((FragmentManager.FragmentLifecycleCallbacks)var6.a).c(this, var1, var2);
         }
      }
   }

   void c(Fragment var1, boolean var2) {
      if (this.o != null) {
         FragmentManager var3 = this.o.getFragmentManager();
         if (var3 instanceof FragmentManagerImpl) {
            ((FragmentManagerImpl)var3).c(var1, true);
         }
      }

      for (Pair var4 : this.I) {
         if (!var2 || (Boolean)var4.b) {
            ((FragmentManager.FragmentLifecycleCallbacks)var4.a).b(this, var1);
         }
      }
   }

   boolean c(int var1) {
      boolean var2;
      if (this.l >= var1) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public void d(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield android/support/v4/app/FragmentManagerImpl.i Ljava/util/ArrayList;
      // 06: iload 1
      // 07: aconst_null
      // 08: invokevirtual java/util/ArrayList.set (ILjava/lang/Object;)Ljava/lang/Object;
      // 0b: pop
      // 0c: aload 0
      // 0d: getfield android/support/v4/app/FragmentManagerImpl.j Ljava/util/ArrayList;
      // 10: ifnonnull 20
      // 13: new java/util/ArrayList
      // 16: astore 2
      // 17: aload 2
      // 18: invokespecial java/util/ArrayList.<init> ()V
      // 1b: aload 0
      // 1c: aload 2
      // 1d: putfield android/support/v4/app/FragmentManagerImpl.j Ljava/util/ArrayList;
      // 20: getstatic android/support/v4/app/FragmentManagerImpl.a Z
      // 23: ifeq 43
      // 26: new java/lang/StringBuilder
      // 29: astore 2
      // 2a: aload 2
      // 2b: invokespecial java/lang/StringBuilder.<init> ()V
      // 2e: ldc_w "FragmentManager"
      // 31: aload 2
      // 32: ldc_w "Freeing back stack index "
      // 35: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 38: iload 1
      // 39: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 3c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 3f: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 42: pop
      // 43: aload 0
      // 44: getfield android/support/v4/app/FragmentManagerImpl.j Ljava/util/ArrayList;
      // 47: iload 1
      // 48: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 4b: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 4e: pop
      // 4f: aload 0
      // 50: monitorexit
      // 51: return
      // 52: astore 2
      // 53: aload 0
      // 54: monitorexit
      // 55: aload 2
      // 56: athrow
      // try (2 -> 18): 42 null
      // try (18 -> 33): 42 null
      // try (33 -> 41): 42 null
      // try (43 -> 45): 42 null
   }

   void d(Fragment var1) {
      if (var1.mFromLayout && !var1.mPerformedCreateView) {
         var1.mView = var1.performCreateView(var1.performGetLayoutInflater(var1.mSavedFragmentState), null, var1.mSavedFragmentState);
         if (var1.mView != null) {
            var1.mInnerView = var1.mView;
            var1.mView.setSaveFromParentEnabled(false);
            if (var1.mHidden) {
               var1.mView.setVisibility(8);
            }

            var1.onViewCreated(var1.mView, var1.mSavedFragmentState);
            this.a(var1, var1.mView, var1.mSavedFragmentState, false);
         } else {
            var1.mInnerView = null;
         }
      }
   }

   void d(Fragment var1, Bundle var2, boolean var3) {
      if (this.o != null) {
         FragmentManager var4 = this.o.getFragmentManager();
         if (var4 instanceof FragmentManagerImpl) {
            ((FragmentManagerImpl)var4).d(var1, var2, true);
         }
      }

      for (Pair var6 : this.I) {
         if (!var3 || (Boolean)var6.b) {
            ((FragmentManager.FragmentLifecycleCallbacks)var6.a).d(this, var1, var2);
         }
      }
   }

   void d(Fragment var1, boolean var2) {
      if (this.o != null) {
         FragmentManager var3 = this.o.getFragmentManager();
         if (var3 instanceof FragmentManagerImpl) {
            ((FragmentManagerImpl)var3).d(var1, true);
         }
      }

      for (Pair var4 : this.I) {
         if (!var2 || (Boolean)var4.b) {
            ((FragmentManager.FragmentLifecycleCallbacks)var4.a).c(this, var1);
         }
      }
   }

   @Override
   public boolean d() {
      this.B();
      return this.a(null, -1, 0);
   }

   @Override
   public int e() {
      int var1;
      if (this.g != null) {
         var1 = this.g.size();
      } else {
         var1 = 0;
      }

      return var1;
   }

   void e(Fragment var1) {
      if (var1.mView != null) {
         int var2 = var1.getNextTransition();
         boolean var3;
         if (!var1.mHidden) {
            var3 = true;
         } else {
            var3 = false;
         }

         FragmentManagerImpl.AnimationOrAnimator var6 = this.a(var1, var2, var3, var1.getNextTransitionStyle());
         if (var6 != null && var6.b != null) {
            var6.b.setTarget(var1.mView);
            if (var1.mHidden) {
               if (var1.isHideReplaced()) {
                  var1.setHideReplaced(false);
               } else {
                  ViewGroup var5 = var1.mContainer;
                  View var4 = var1.mView;
                  var5.startViewTransition(var4);
                  var6.b.addListener(new AnimatorListenerAdapter(this, var5, var4, var1) {
                     final ViewGroup a;
                     final View b;
                     final Fragment c;
                     final FragmentManagerImpl d;

                     {
                        this.d = var1;
                        this.a = var2x;
                        this.b = var3x;
                        this.c = var4x;
                     }

                     public void onAnimationEnd(Animator var1) {
                        this.a.endViewTransition(this.b);
                        var1.removeListener(this);
                        if (this.c.mView != null) {
                           this.c.mView.setVisibility(8);
                        }
                     }
                  });
               }
            } else {
               var1.mView.setVisibility(0);
            }

            b(var1.mView, var6);
            var6.b.start();
         } else {
            if (var6 != null) {
               b(var1.mView, var6);
               var1.mView.startAnimation(var6.a);
               var6.a.start();
            }

            byte var7;
            if (var1.mHidden && !var1.isHideReplaced()) {
               var7 = 8;
            } else {
               var7 = 0;
            }

            var1.mView.setVisibility(var7);
            if (var1.isHideReplaced()) {
               var1.setHideReplaced(false);
            }
         }
      }

      if (var1.mAdded && var1.mHasMenu && var1.mMenuVisible) {
         this.r = true;
      }

      var1.mHiddenChanged = false;
      var1.onHiddenChanged(var1.mHidden);
   }

   void e(Fragment var1, boolean var2) {
      if (this.o != null) {
         FragmentManager var3 = this.o.getFragmentManager();
         if (var3 instanceof FragmentManagerImpl) {
            ((FragmentManagerImpl)var3).e(var1, true);
         }
      }

      for (Pair var5 : this.I) {
         if (!var2 || (Boolean)var5.b) {
            ((FragmentManager.FragmentLifecycleCallbacks)var5.a).d(this, var1);
         }
      }
   }

   @Override
   public List<Fragment> f() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield android/support/v4/app/FragmentManagerImpl.e Ljava/util/ArrayList;
      // 04: invokevirtual java/util/ArrayList.isEmpty ()Z
      // 07: ifeq 10
      // 0a: getstatic java/util/Collections.EMPTY_LIST Ljava/util/List;
      // 0d: astore 1
      // 0e: aload 1
      // 0f: areturn
      // 10: aload 0
      // 11: getfield android/support/v4/app/FragmentManagerImpl.e Ljava/util/ArrayList;
      // 14: astore 2
      // 15: aload 2
      // 16: monitorenter
      // 17: aload 0
      // 18: getfield android/support/v4/app/FragmentManagerImpl.e Ljava/util/ArrayList;
      // 1b: invokevirtual java/util/ArrayList.clone ()Ljava/lang/Object;
      // 1e: checkcast java/util/List
      // 21: astore 1
      // 22: aload 2
      // 23: monitorexit
      // 24: goto 0e
      // 27: astore 1
      // 28: aload 2
      // 29: monitorexit
      // 2a: aload 1
      // 2b: athrow
      // try (13 -> 20): 21 null
      // try (22 -> 24): 21 null
   }

   void f(Fragment var1) {
      if (var1 != null) {
         int var3 = this.l;
         int var2 = var3;
         if (var1.mRemoving) {
            if (var1.isInBackStack()) {
               var2 = Math.min(var3, 1);
            } else {
               var2 = Math.min(var3, 0);
            }
         }

         this.a(var1, var2, var1.getNextTransition(), var1.getNextTransitionStyle(), false);
         if (var1.mView != null) {
            Fragment var4 = this.q(var1);
            if (var4 != null) {
               View var8 = var4.mView;
               ViewGroup var5 = var1.mContainer;
               var3 = var5.indexOfChild(var8);
               var2 = var5.indexOfChild(var1.mView);
               if (var2 < var3) {
                  var5.removeViewAt(var2);
                  var5.addView(var1.mView, var3);
               }
            }

            if (var1.mIsNewlyAdded && var1.mContainer != null) {
               if (var1.mPostponedAlpha > 0.0F) {
                  var1.mView.setAlpha(var1.mPostponedAlpha);
               }

               var1.mPostponedAlpha = 0.0F;
               var1.mIsNewlyAdded = false;
               FragmentManagerImpl.AnimationOrAnimator var9 = this.a(var1, var1.getNextTransition(), true, var1.getNextTransitionStyle());
               if (var9 != null) {
                  b(var1.mView, var9);
                  if (var9.a != null) {
                     var1.mView.startAnimation(var9.a);
                  } else {
                     var9.b.setTarget(var1.mView);
                     var9.b.start();
                  }
               }
            }
         }

         if (var1.mHiddenChanged) {
            this.e(var1);
         }
      }
   }

   void f(Fragment var1, boolean var2) {
      if (this.o != null) {
         FragmentManager var3 = this.o.getFragmentManager();
         if (var3 instanceof FragmentManagerImpl) {
            ((FragmentManagerImpl)var3).f(var1, true);
         }
      }

      for (Pair var4 : this.I) {
         if (!var2 || (Boolean)var4.b) {
            ((FragmentManager.FragmentLifecycleCallbacks)var4.a).e(this, var1);
         }
      }
   }

   void g(Fragment var1) {
      if (var1.mIndex < 0) {
         int var2 = this.d++;
         var1.setIndex(var2, this.o);
         if (this.f == null) {
            this.f = new SparseArray();
         }

         this.f.put(var1.mIndex, var1);
         if (a) {
            Log.v("FragmentManager", "Allocated fragment index " + var1);
         }
      }
   }

   void g(Fragment var1, boolean var2) {
      if (this.o != null) {
         FragmentManager var3 = this.o.getFragmentManager();
         if (var3 instanceof FragmentManagerImpl) {
            ((FragmentManagerImpl)var3).g(var1, true);
         }
      }

      for (Pair var5 : this.I) {
         if (!var2 || (Boolean)var5.b) {
            ((FragmentManager.FragmentLifecycleCallbacks)var5.a).f(this, var1);
         }
      }
   }

   @Override
   public boolean g() {
      return this.s;
   }

   void h() {
      if (this.f != null) {
         for (int var1 = 0; var1 < this.f.size(); var1++) {
            Fragment var2 = (Fragment)this.f.valueAt(var1);
            if (var2 != null) {
               this.b(var2);
            }
         }
      }
   }

   void h(Fragment var1) {
      if (var1.mIndex >= 0) {
         if (a) {
            Log.v("FragmentManager", "Freeing fragment index " + var1);
         }

         this.f.put(var1.mIndex, null);
         var1.initState();
      }
   }

   void h(Fragment var1, boolean var2) {
      if (this.o != null) {
         FragmentManager var3 = this.o.getFragmentManager();
         if (var3 instanceof FragmentManagerImpl) {
            ((FragmentManagerImpl)var3).h(var1, true);
         }
      }

      for (Pair var5 : this.I) {
         if (!var2 || (Boolean)var5.b) {
            ((FragmentManager.FragmentLifecycleCallbacks)var5.a).g(this, var1);
         }
      }
   }

   public void i(Fragment param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic android/support/v4/app/FragmentManagerImpl.a Z
      // 03: ifeq 2e
      // 06: ldc_w "FragmentManager"
      // 09: new java/lang/StringBuilder
      // 0c: dup
      // 0d: invokespecial java/lang/StringBuilder.<init> ()V
      // 10: ldc_w "remove: "
      // 13: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 16: aload 1
      // 17: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 1a: ldc_w " nesting="
      // 1d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 20: aload 1
      // 21: getfield android/support/v4/app/Fragment.mBackStackNesting I
      // 24: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 27: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 2a: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 2d: pop
      // 2e: aload 1
      // 2f: invokevirtual android/support/v4/app/Fragment.isInBackStack ()Z
      // 32: ifne 72
      // 35: bipush 1
      // 36: istore 2
      // 37: aload 1
      // 38: getfield android/support/v4/app/Fragment.mDetached Z
      // 3b: ifeq 42
      // 3e: iload 2
      // 3f: ifeq 71
      // 42: aload 0
      // 43: getfield android/support/v4/app/FragmentManagerImpl.e Ljava/util/ArrayList;
      // 46: astore 3
      // 47: aload 3
      // 48: monitorenter
      // 49: aload 0
      // 4a: getfield android/support/v4/app/FragmentManagerImpl.e Ljava/util/ArrayList;
      // 4d: aload 1
      // 4e: invokevirtual java/util/ArrayList.remove (Ljava/lang/Object;)Z
      // 51: pop
      // 52: aload 3
      // 53: monitorexit
      // 54: aload 1
      // 55: getfield android/support/v4/app/Fragment.mHasMenu Z
      // 58: ifeq 67
      // 5b: aload 1
      // 5c: getfield android/support/v4/app/Fragment.mMenuVisible Z
      // 5f: ifeq 67
      // 62: aload 0
      // 63: bipush 1
      // 64: putfield android/support/v4/app/FragmentManagerImpl.r Z
      // 67: aload 1
      // 68: bipush 0
      // 69: putfield android/support/v4/app/Fragment.mAdded Z
      // 6c: aload 1
      // 6d: bipush 1
      // 6e: putfield android/support/v4/app/Fragment.mRemoving Z
      // 71: return
      // 72: bipush 0
      // 73: istore 2
      // 74: goto 37
      // 77: astore 1
      // 78: aload 3
      // 79: monitorexit
      // 7a: aload 1
      // 7b: athrow
      // try (33 -> 40): 59 null
      // try (60 -> 62): 59 null
   }

   public boolean i() {
      this.c(true);

      boolean var1;
      for (var1 = false; this.c(this.w, this.x); var1 = true) {
         this.c = true;

         try {
            this.b(this.w, this.x);
         } finally {
            this.D();
         }
      }

      this.j();
      this.G();
      return var1;
   }

   void j() {
      if (this.v) {
         int var1 = 0;
         boolean var3 = false;

         while (var1 < this.f.size()) {
            Fragment var4 = (Fragment)this.f.valueAt(var1);
            boolean var2 = var3;
            if (var4 != null) {
               var2 = var3;
               if (var4.mLoaderManager != null) {
                  var2 = var3 | var4.mLoaderManager.a();
               }
            }

            var1++;
            var3 = var2;
         }

         if (!var3) {
            this.v = false;
            this.h();
         }
      }
   }

   public void j(Fragment var1) {
      boolean var2 = true;
      if (a) {
         Log.v("FragmentManager", "hide: " + var1);
      }

      if (!var1.mHidden) {
         var1.mHidden = true;
         if (var1.mHiddenChanged) {
            var2 = false;
         }

         var1.mHiddenChanged = var2;
      }
   }

   void k() {
      if (this.k != null) {
         for (int var1 = 0; var1 < this.k.size(); var1++) {
            this.k.get(var1).a();
         }
      }
   }

   public void k(Fragment var1) {
      boolean var2 = false;
      if (a) {
         Log.v("FragmentManager", "show: " + var1);
      }

      if (var1.mHidden) {
         var1.mHidden = false;
         if (!var1.mHiddenChanged) {
            var2 = true;
         }

         var1.mHiddenChanged = var2;
      }
   }

   FragmentManagerNonConfig l() {
      a(this.C);
      return this.C;
   }

   public void l(Fragment param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic android/support/v4/app/FragmentManagerImpl.a Z
      // 03: ifeq 21
      // 06: ldc_w "FragmentManager"
      // 09: new java/lang/StringBuilder
      // 0c: dup
      // 0d: invokespecial java/lang/StringBuilder.<init> ()V
      // 10: ldc_w "detach: "
      // 13: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 16: aload 1
      // 17: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 1a: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1d: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 20: pop
      // 21: aload 1
      // 22: getfield android/support/v4/app/Fragment.mDetached Z
      // 25: ifne 7f
      // 28: aload 1
      // 29: bipush 1
      // 2a: putfield android/support/v4/app/Fragment.mDetached Z
      // 2d: aload 1
      // 2e: getfield android/support/v4/app/Fragment.mAdded Z
      // 31: ifeq 7f
      // 34: getstatic android/support/v4/app/FragmentManagerImpl.a Z
      // 37: ifeq 55
      // 3a: ldc_w "FragmentManager"
      // 3d: new java/lang/StringBuilder
      // 40: dup
      // 41: invokespecial java/lang/StringBuilder.<init> ()V
      // 44: ldc_w "remove from detach: "
      // 47: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 4a: aload 1
      // 4b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 4e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 51: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 54: pop
      // 55: aload 0
      // 56: getfield android/support/v4/app/FragmentManagerImpl.e Ljava/util/ArrayList;
      // 59: astore 2
      // 5a: aload 2
      // 5b: monitorenter
      // 5c: aload 0
      // 5d: getfield android/support/v4/app/FragmentManagerImpl.e Ljava/util/ArrayList;
      // 60: aload 1
      // 61: invokevirtual java/util/ArrayList.remove (Ljava/lang/Object;)Z
      // 64: pop
      // 65: aload 2
      // 66: monitorexit
      // 67: aload 1
      // 68: getfield android/support/v4/app/Fragment.mHasMenu Z
      // 6b: ifeq 7a
      // 6e: aload 1
      // 6f: getfield android/support/v4/app/Fragment.mMenuVisible Z
      // 72: ifeq 7a
      // 75: aload 0
      // 76: bipush 1
      // 77: putfield android/support/v4/app/FragmentManagerImpl.r Z
      // 7a: aload 1
      // 7b: bipush 0
      // 7c: putfield android/support/v4/app/Fragment.mAdded Z
      // 7f: return
      // 80: astore 1
      // 81: aload 2
      // 82: monitorexit
      // 83: aload 1
      // 84: athrow
      // try (40 -> 47): 60 null
      // try (61 -> 63): 60 null
   }

   void m() {
      ArrayList var6;
      ArrayList var7;
      ArrayList var8;
      if (this.f != null) {
         int var1 = 0;
         ArrayList var4 = null;
         ArrayList var5 = null;
         ArrayList var3 = null;

         while (true) {
            var8 = var4;
            var7 = var5;
            var6 = var3;
            if (var1 >= this.f.size()) {
               break;
            }

            Fragment var10 = (Fragment)this.f.valueAt(var1);
            var7 = var4;
            var8 = var5;
            ArrayList var9 = var3;
            if (var10 != null) {
               var6 = var3;
               if (var10.mRetainInstance) {
                  var7 = var3;
                  if (var3 == null) {
                     var7 = new ArrayList();
                  }

                  var7.add(var10);
                  int var2;
                  if (var10.mTarget != null) {
                     var2 = var10.mTarget.mIndex;
                  } else {
                     var2 = -1;
                  }

                  var10.mTargetIndex = var2;
                  var6 = var7;
                  if (a) {
                     Log.v("FragmentManager", "retainNonConfig: keeping retained " + var10);
                     var6 = var7;
                  }
               }

               FragmentManagerNonConfig var20;
               if (var10.mChildFragmentManager != null) {
                  var10.mChildFragmentManager.m();
                  var20 = var10.mChildFragmentManager.C;
               } else {
                  var20 = var10.mChildNonConfig;
               }

               var3 = var5;
               if (var5 == null) {
                  var3 = var5;
                  if (var20 != null) {
                     var5 = new ArrayList(this.f.size());
                     int var11 = 0;

                     while (true) {
                        var3 = var5;
                        if (var11 >= var1) {
                           break;
                        }

                        var5.add(null);
                        var11++;
                     }
                  }
               }

               if (var3 != null) {
                  var3.add(var20);
               }

               var5 = var4;
               if (var4 == null) {
                  var5 = var4;
                  if (var10.mViewModelStore != null) {
                     var4 = new ArrayList(this.f.size());
                     int var12 = 0;

                     while (true) {
                        var5 = var4;
                        if (var12 >= var1) {
                           break;
                        }

                        var4.add(null);
                        var12++;
                     }
                  }
               }

               var7 = var5;
               var8 = var3;
               var9 = var6;
               if (var5 != null) {
                  var5.add(var10.mViewModelStore);
                  var9 = var6;
                  var8 = var3;
                  var7 = var5;
               }
            }

            var1++;
            var3 = var9;
            var5 = var8;
            var4 = var7;
         }
      } else {
         var8 = null;
         var7 = null;
         var6 = null;
      }

      if (var6 == null && var7 == null && var8 == null) {
         this.C = null;
      } else {
         this.C = new FragmentManagerNonConfig(var6, var7, var8);
      }
   }

   public void m(Fragment param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic android/support/v4/app/FragmentManagerImpl.a Z
      // 03: ifeq 21
      // 06: ldc_w "FragmentManager"
      // 09: new java/lang/StringBuilder
      // 0c: dup
      // 0d: invokespecial java/lang/StringBuilder.<init> ()V
      // 10: ldc_w "attach: "
      // 13: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 16: aload 1
      // 17: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 1a: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1d: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 20: pop
      // 21: aload 1
      // 22: getfield android/support/v4/app/Fragment.mDetached Z
      // 25: ifeq a6
      // 28: aload 1
      // 29: bipush 0
      // 2a: putfield android/support/v4/app/Fragment.mDetached Z
      // 2d: aload 1
      // 2e: getfield android/support/v4/app/Fragment.mAdded Z
      // 31: ifne a6
      // 34: aload 0
      // 35: getfield android/support/v4/app/FragmentManagerImpl.e Ljava/util/ArrayList;
      // 38: aload 1
      // 39: invokevirtual java/util/ArrayList.contains (Ljava/lang/Object;)Z
      // 3c: ifeq 5b
      // 3f: new java/lang/IllegalStateException
      // 42: dup
      // 43: new java/lang/StringBuilder
      // 46: dup
      // 47: invokespecial java/lang/StringBuilder.<init> ()V
      // 4a: ldc_w "Fragment already added: "
      // 4d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 50: aload 1
      // 51: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 54: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 57: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 5a: athrow
      // 5b: getstatic android/support/v4/app/FragmentManagerImpl.a Z
      // 5e: ifeq 7c
      // 61: ldc_w "FragmentManager"
      // 64: new java/lang/StringBuilder
      // 67: dup
      // 68: invokespecial java/lang/StringBuilder.<init> ()V
      // 6b: ldc_w "add from attach: "
      // 6e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 71: aload 1
      // 72: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 75: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 78: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 7b: pop
      // 7c: aload 0
      // 7d: getfield android/support/v4/app/FragmentManagerImpl.e Ljava/util/ArrayList;
      // 80: astore 2
      // 81: aload 2
      // 82: monitorenter
      // 83: aload 0
      // 84: getfield android/support/v4/app/FragmentManagerImpl.e Ljava/util/ArrayList;
      // 87: aload 1
      // 88: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 8b: pop
      // 8c: aload 2
      // 8d: monitorexit
      // 8e: aload 1
      // 8f: bipush 1
      // 90: putfield android/support/v4/app/Fragment.mAdded Z
      // 93: aload 1
      // 94: getfield android/support/v4/app/Fragment.mHasMenu Z
      // 97: ifeq a6
      // 9a: aload 1
      // 9b: getfield android/support/v4/app/Fragment.mMenuVisible Z
      // 9e: ifeq a6
      // a1: aload 0
      // a2: bipush 1
      // a3: putfield android/support/v4/app/FragmentManagerImpl.r Z
      // a6: return
      // a7: astore 1
      // a8: aload 2
      // a9: monitorexit
      // aa: aload 1
      // ab: athrow
      // try (57 -> 64): 77 null
      // try (78 -> 80): 77 null
   }

   Parcelable n() {
      FragmentManagerState var6 = null;
      Object var5 = null;
      this.E();
      this.F();
      this.i();
      this.s = true;
      this.C = null;
      FragmentManagerState var4 = (FragmentManagerState)var5;
      if (this.f != null) {
         if (this.f.size() <= 0) {
            var4 = (FragmentManagerState)var5;
         } else {
            int var3 = this.f.size();
            FragmentState[] var7 = new FragmentState[var3];
            int var2 = 0;
            int var1 = 0;

            while (var2 < var3) {
               Fragment var13 = (Fragment)this.f.valueAt(var2);
               if (var13 != null) {
                  if (var13.mIndex < 0) {
                     this.a(new IllegalStateException("Failure saving state: active " + var13 + " has cleared index: " + var13.mIndex));
                  }

                  FragmentState var8 = new FragmentState(var13);
                  var7[var2] = var8;
                  if (var13.mState > 0 && var8.k == null) {
                     var8.k = this.o(var13);
                     if (var13.mTarget != null) {
                        if (var13.mTarget.mIndex < 0) {
                           this.a(new IllegalStateException("Failure saving state: " + var13 + " has target not in fragment manager: " + var13.mTarget));
                        }

                        if (var8.k == null) {
                           var8.k = new Bundle();
                        }

                        this.a(var8.k, "android:target_state", var13.mTarget);
                        if (var13.mTargetRequestCode != 0) {
                           var8.k.putInt("android:target_req_state", var13.mTargetRequestCode);
                        }
                     }
                  } else {
                     var8.k = var13.mSavedFragmentState;
                  }

                  if (a) {
                     Log.v("FragmentManager", "Saved state of " + var13 + ": " + var8.k);
                  }

                  var1 = 1;
               }

               var2++;
            }

            if (!var1) {
               var4 = (FragmentManagerState)var5;
               if (a) {
                  Log.v("FragmentManager", "saveAllState: no fragments!");
                  var4 = (FragmentManagerState)var5;
               }
            } else {
               var2 = this.e.size();
               int[] var14;
               if (var2 > 0) {
                  var5 = new int[var2];
                  var1 = 0;

                  while (true) {
                     var14 = (int[])var5;
                     if (var1 >= var2) {
                        break;
                     }

                     ((Object[])var5)[var1] = this.e.get(var1).mIndex;
                     if (((Object[])var5)[var1] < 0) {
                        this.a(new IllegalStateException("Failure saving state: active " + this.e.get(var1) + " has cleared index: " + ((Object[])var5)[var1]));
                     }

                     if (a) {
                        Log.v("FragmentManager", "saveAllState: adding fragment #" + var1 + ": " + this.e.get(var1));
                     }

                     var1++;
                  }
               } else {
                  var14 = null;
               }

               var5 = var6;
               if (this.g != null) {
                  var2 = this.g.size();
                  var5 = var6;
                  if (var2 > 0) {
                     var6 = new BackStackState[var2];
                     var1 = 0;

                     while (true) {
                        var5 = var6;
                        if (var1 >= var2) {
                           break;
                        }

                        ((Object[])var6)[var1] = new BackStackState(this.g.get(var1));
                        if (a) {
                           Log.v("FragmentManager", "saveAllState: adding back stack #" + var1 + ": " + this.g.get(var1));
                        }

                        var1++;
                     }
                  }
               }

               var6 = new FragmentManagerState();
               var6.a = var7;
               var6.b = var14;
               var6.c = (BackStackState[])var5;
               if (this.p != null) {
                  var6.d = this.p.mIndex;
               }

               var6.e = this.d;
               this.m();
               var4 = var6;
            }
         }
      }

      return var4;
   }

   void n(Fragment var1) {
      if (var1.mInnerView != null) {
         if (this.A == null) {
            this.A = new SparseArray();
         } else {
            this.A.clear();
         }

         var1.mInnerView.saveHierarchyState(this.A);
         if (this.A.size() > 0) {
            var1.mSavedViewState = this.A;
            this.A = null;
         }
      }
   }

   Bundle o(Fragment var1) {
      if (this.z == null) {
         this.z = new Bundle();
      }

      var1.performSaveInstanceState(this.z);
      this.d(var1, this.z, false);
      Bundle var3;
      if (!this.z.isEmpty()) {
         var3 = this.z;
         this.z = null;
      } else {
         var3 = null;
      }

      if (var1.mView != null) {
         this.n(var1);
      }

      Bundle var2 = var3;
      if (var1.mSavedViewState != null) {
         var2 = var3;
         if (var3 == null) {
            var2 = new Bundle();
         }

         var2.putSparseParcelableArray("android:view_state", var1.mSavedViewState);
      }

      var3 = var2;
      if (!var1.mUserVisibleHint) {
         var3 = var2;
         if (var2 == null) {
            var3 = new Bundle();
         }

         var3.putBoolean("android:user_visible_hint", var1.mUserVisibleHint);
      }

      return var3;
   }

   public void o() {
      this.C = null;
      this.s = false;
      int var2 = this.e.size();

      for (int var1 = 0; var1 < var2; var1++) {
         Fragment var3 = this.e.get(var1);
         if (var3 != null) {
            var3.noteStateNotSaved();
         }
      }
   }

   public View onCreateView(View var1, String var2, Context var3, AttributeSet var4) {
      if (!"fragment".equals(var2)) {
         var1 = null;
      } else {
         String var8 = var4.getAttributeValue(null, "class");
         TypedArray var12 = var3.obtainStyledAttributes(var4, FragmentManagerImpl.FragmentTag.a);
         if (var8 == null) {
            var8 = var12.getString(0);
         }

         int var7 = var12.getResourceId(1, -1);
         String var9 = var12.getString(2);
         var12.recycle();
         if (!Fragment.isSupportFragmentClass(this.m.i(), var8)) {
            var1 = null;
         } else {
            int var5;
            if (var1 != null) {
               var5 = var1.getId();
            } else {
               var5 = 0;
            }

            if (var5 == -1 && var7 == -1 && var9 == null) {
               throw new IllegalArgumentException(
                  var4.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + var8
               );
            }

            Fragment var13;
            if (var7 != -1) {
               var13 = this.a(var7);
            } else {
               var13 = null;
            }

            Fragment var11 = var13;
            if (var13 == null) {
               var11 = var13;
               if (var9 != null) {
                  var11 = this.a(var9);
               }
            }

            Fragment var14 = var11;
            if (var11 == null) {
               var14 = var11;
               if (var5 != -1) {
                  var14 = this.a(var5);
               }
            }

            if (a) {
               Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(var7) + " fname=" + var8 + " existing=" + var14);
            }

            if (var14 == null) {
               var14 = this.n.a(var3, var8, null);
               var14.mFromLayout = true;
               int var6;
               if (var7 != 0) {
                  var6 = var7;
               } else {
                  var6 = var5;
               }

               var14.mFragmentId = var6;
               var14.mContainerId = var5;
               var14.mTag = var9;
               var14.mInLayout = true;
               var14.mFragmentManager = this;
               var14.mHost = this.m;
               var14.onInflate(this.m.i(), var4, var14.mSavedFragmentState);
               this.a(var14, true);
            } else {
               if (var14.mInLayout) {
                  throw new IllegalArgumentException(
                     var4.getPositionDescription()
                        + ": Duplicate id 0x"
                        + Integer.toHexString(var7)
                        + ", tag "
                        + var9
                        + ", or parent id 0x"
                        + Integer.toHexString(var5)
                        + " with another fragment for "
                        + var8
                  );
               }

               var14.mInLayout = true;
               var14.mHost = this.m;
               if (!var14.mRetaining) {
                  var14.onInflate(this.m.i(), var4, var14.mSavedFragmentState);
               }
            }

            if (this.l < 1 && var14.mFromLayout) {
               this.a(var14, 1, 0, 0, false);
            } else {
               this.c(var14);
            }

            if (var14.mView == null) {
               throw new IllegalStateException("Fragment " + var8 + " did not create a view.");
            }

            if (var7 != 0) {
               var14.mView.setId(var7);
            }

            if (var14.mView.getTag() == null) {
               var14.mView.setTag(var9);
            }

            var1 = var14.mView;
         }
      }

      return var1;
   }

   public View onCreateView(String var1, Context var2, AttributeSet var3) {
      return this.onCreateView(null, var1, var2, var3);
   }

   public void p() {
      this.s = false;
      this.f(1);
   }

   public void p(Fragment var1) {
      if (var1 == null || this.f.get(var1.mIndex) == var1 && (var1.mHost == null || var1.getFragmentManager() == this)) {
         this.p = var1;
      } else {
         throw new IllegalArgumentException("Fragment " + var1 + " is not an active fragment of FragmentManager " + this);
      }
   }

   public void q() {
      this.s = false;
      this.f(2);
   }

   public void r() {
      this.s = false;
      this.f(4);
   }

   public void s() {
      this.s = false;
      this.f(5);
   }

   public void t() {
      this.f(4);
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder(128);
      var1.append("FragmentManager{");
      var1.append(Integer.toHexString(System.identityHashCode(this)));
      var1.append(" in ");
      if (this.o != null) {
         DebugUtils.a(this.o, var1);
      } else {
         DebugUtils.a(this.m, var1);
      }

      var1.append("}}");
      return var1.toString();
   }

   public void u() {
      this.s = true;
      this.f(3);
   }

   public void v() {
      this.f(2);
   }

   public void w() {
      this.f(1);
   }

   public void x() {
      this.t = true;
      this.i();
      this.f(0);
      this.m = null;
      this.n = null;
      this.o = null;
   }

   public void y() {
      for (int var1 = 0; var1 < this.e.size(); var1++) {
         Fragment var2 = this.e.get(var1);
         if (var2 != null) {
            var2.performLowMemory();
         }
      }
   }

   public Fragment z() {
      return this.p;
   }

   private static class AnimateOnHWLayerIfNeededListener extends FragmentManagerImpl.AnimationListenerWrapper {
      View a;

      AnimateOnHWLayerIfNeededListener(View var1, AnimationListener var2) {
         super(var2);
         this.a = var1;
      }

      @Override
      public void onAnimationEnd(Animation var1) {
         if (!ViewCompat.B(this.a) && VERSION.SDK_INT < 24) {
            this.a.setLayerType(0, null);
         } else {
            this.a.post(new Runnable(this) {
               final FragmentManagerImpl.AnimateOnHWLayerIfNeededListener a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  this.a.a.setLayerType(0, null);
               }
            });
         }

         super.onAnimationEnd(var1);
      }
   }

   private static class AnimationListenerWrapper implements AnimationListener {
      private final AnimationListener a;

      private AnimationListenerWrapper(AnimationListener var1) {
         this.a = var1;
      }

      public void onAnimationEnd(Animation var1) {
         if (this.a != null) {
            this.a.onAnimationEnd(var1);
         }
      }

      public void onAnimationRepeat(Animation var1) {
         if (this.a != null) {
            this.a.onAnimationRepeat(var1);
         }
      }

      public void onAnimationStart(Animation var1) {
         if (this.a != null) {
            this.a.onAnimationStart(var1);
         }
      }
   }

   private static class AnimationOrAnimator {
      public final Animation a;
      public final Animator b;

      private AnimationOrAnimator(Animator var1) {
         this.a = null;
         this.b = var1;
         if (var1 == null) {
            throw new IllegalStateException("Animator cannot be null");
         }
      }

      private AnimationOrAnimator(Animation var1) {
         this.a = var1;
         this.b = null;
         if (var1 == null) {
            throw new IllegalStateException("Animation cannot be null");
         }
      }
   }

   private static class AnimatorOnHWLayerIfNeededListener extends AnimatorListenerAdapter {
      View a;

      AnimatorOnHWLayerIfNeededListener(View var1) {
         this.a = var1;
      }

      public void onAnimationEnd(Animator var1) {
         this.a.setLayerType(0, null);
         var1.removeListener(this);
      }

      public void onAnimationStart(Animator var1) {
         this.a.setLayerType(2, null);
      }
   }

   private static class EndViewTransitionAnimator extends AnimationSet implements Runnable {
      private final ViewGroup a;
      private final View b;
      private boolean c;
      private boolean d;

      EndViewTransitionAnimator(Animation var1, ViewGroup var2, View var3) {
         super(false);
         this.a = var2;
         this.b = var3;
         this.addAnimation(var1);
      }

      public boolean getTransformation(long var1, Transformation var3) {
         boolean var5 = true;
         boolean var4;
         if (this.c) {
            if (!this.d) {
               var4 = var5;
            } else {
               var4 = false;
            }
         } else {
            var4 = var5;
            if (!super.getTransformation(var1, var3)) {
               this.c = true;
               this.a.post(this);
               var4 = var5;
            }
         }

         return var4;
      }

      public boolean getTransformation(long var1, Transformation var3, float var4) {
         boolean var6 = true;
         boolean var5;
         if (this.c) {
            if (!this.d) {
               var5 = var6;
            } else {
               var5 = false;
            }
         } else {
            var5 = var6;
            if (!super.getTransformation(var1, var3, var4)) {
               this.c = true;
               this.a.post(this);
               var5 = var6;
            }
         }

         return var5;
      }

      @Override
      public void run() {
         this.a.endViewTransition(this.b);
         this.d = true;
      }
   }

   static class FragmentTag {
      public static final int[] a = new int[]{16842755, 16842960, 16842961};
   }

   interface OpGenerator {
      boolean a(ArrayList<BackStackRecord> var1, ArrayList<Boolean> var2);
   }

   private class PopBackStackState implements FragmentManagerImpl.OpGenerator {
      final String a;
      final int b;
      final int c;
      final FragmentManagerImpl d;

      PopBackStackState(FragmentManagerImpl var1, String var2, int var3, int var4) {
         this.d = var1;
         this.a = var2;
         this.b = var3;
         this.c = var4;
      }

      @Override
      public boolean a(ArrayList<BackStackRecord> var1, ArrayList<Boolean> var2) {
         if (this.d.p != null && this.b < 0 && this.a == null) {
            FragmentManager var4 = this.d.p.peekChildFragmentManager();
            if (var4 != null && var4.d()) {
               return false;
            }
         }

         return this.d.a(var1, var2, this.a, this.b, this.c);
      }
   }

   static class StartEnterTransitionListener implements Fragment.OnStartEnterTransitionListener {
      private final boolean a;
      private final BackStackRecord b;
      private int c;

      StartEnterTransitionListener(BackStackRecord var1, boolean var2) {
         this.a = var2;
         this.b = var1;
      }

      @Override
      public void a() {
         this.c--;
         if (this.c == 0) {
            this.b.a.C();
         }
      }

      @Override
      public void b() {
         this.c++;
      }

      public boolean c() {
         boolean var1;
         if (this.c == 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public void d() {
         boolean var4 = false;
         boolean var1;
         if (this.c > 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         FragmentManagerImpl var6 = this.b.a;
         int var3 = var6.e.size();

         for (int var2 = 0; var2 < var3; var2++) {
            Fragment var7 = var6.e.get(var2);
            var7.setOnStartEnterTransitionListener(null);
            if (var1 && var7.isPostponed()) {
               var7.startPostponedEnterTransition();
            }
         }

         FragmentManagerImpl var9 = this.b.a;
         BackStackRecord var8 = this.b;
         boolean var5 = this.a;
         if (!var1) {
            var4 = true;
         }

         var9.a(var8, var5, var4, true);
      }

      public void e() {
         this.b.a.a(this.b, this.a, false, false);
      }
   }
}
