package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public abstract class Visibility extends Transition {
   private static final String[] g = new String[]{"android:visibility:visibility", "android:visibility:parent"};
   private int h = 3;

   public Visibility() {
   }

   public Visibility(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var4 = var1.obtainStyledAttributes(var2, Styleable.e);
      int var3 = TypedArrayUtils.a(var4, (XmlResourceParser)var2, "transitionVisibilityMode", 0, 0);
      var4.recycle();
      if (var3 != 0) {
         this.b(var3);
      }
   }

   private Visibility.VisibilityInfo b(TransitionValues var1, TransitionValues var2) {
      Visibility.VisibilityInfo var3 = new Visibility.VisibilityInfo();
      var3.a = false;
      var3.b = false;
      if (var1 != null && var1.a.containsKey("android:visibility:visibility")) {
         var3.c = (Integer)var1.a.get("android:visibility:visibility");
         var3.e = (ViewGroup)var1.a.get("android:visibility:parent");
      } else {
         var3.c = -1;
         var3.e = null;
      }

      if (var2 != null && var2.a.containsKey("android:visibility:visibility")) {
         var3.d = (Integer)var2.a.get("android:visibility:visibility");
         var3.f = (ViewGroup)var2.a.get("android:visibility:parent");
      } else {
         var3.d = -1;
         var3.f = null;
      }

      if (var1 != null && var2 != null) {
         if (var3.c != var3.d || var3.e != var3.f) {
            if (var3.c != var3.d) {
               if (var3.c == 0) {
                  var3.b = false;
                  var3.a = true;
               } else if (var3.d == 0) {
                  var3.b = true;
                  var3.a = true;
               }
            } else if (var3.f == null) {
               var3.b = false;
               var3.a = true;
            } else if (var3.e == null) {
               var3.b = true;
               var3.a = true;
            }
         }
      } else if (var1 == null && var3.d == 0) {
         var3.b = true;
         var3.a = true;
      } else if (var2 == null && var3.c == 0) {
         var3.b = false;
         var3.a = true;
      }

      return var3;
   }

   private void d(TransitionValues var1) {
      int var2 = var1.b.getVisibility();
      var1.a.put("android:visibility:visibility", var2);
      var1.a.put("android:visibility:parent", var1.b.getParent());
      int[] var3 = new int[2];
      var1.b.getLocationOnScreen(var3);
      var1.a.put("android:visibility:screenLocation", var3);
   }

   public Animator a(ViewGroup var1, TransitionValues var2, int var3, TransitionValues var4, int var5) {
      Animator var7;
      if ((this.h & 1) == 1 && var4 != null) {
         if (var2 == null) {
            View var6 = (View)var4.b.getParent();
            if (this.b(this.b(var6, false), this.a(var6, false)).a) {
               Object var8 = null;
               return (Animator)var8;
            }
         }

         var7 = this.a(var1, var4.b, var2, var4);
      } else {
         var7 = null;
      }

      return var7;
   }

   @Override
   public Animator a(ViewGroup var1, TransitionValues var2, TransitionValues var3) {
      Visibility.VisibilityInfo var4 = this.b(var2, var3);
      Animator var5;
      if (var4.a && (var4.e != null || var4.f != null)) {
         if (var4.b) {
            var5 = this.a(var1, var2, var4.c, var3, var4.d);
         } else {
            var5 = this.b(var1, var2, var4.c, var3, var4.d);
         }
      } else {
         var5 = null;
      }

      return var5;
   }

   public Animator a(ViewGroup var1, View var2, TransitionValues var3, TransitionValues var4) {
      return null;
   }

   @Override
   public void a(TransitionValues var1) {
      this.d(var1);
   }

   @Override
   public boolean a(TransitionValues var1, TransitionValues var2) {
      boolean var4 = false;
      boolean var6;
      if (var1 == null && var2 == null) {
         var6 = var4;
      } else {
         if (var1 != null && var2 != null) {
            var6 = var4;
            if (var2.a.containsKey("android:visibility:visibility") != var1.a.containsKey("android:visibility:visibility")) {
               return var6;
            }
         }

         Visibility.VisibilityInfo var5 = this.b(var1, var2);
         var6 = var4;
         if (var5.a) {
            if (var5.c != 0) {
               var6 = var4;
               if (var5.d != 0) {
                  return var6;
               }
            }

            var6 = true;
         }
      }

      return var6;
   }

   @Override
   public String[] a() {
      return g;
   }

   public Animator b(ViewGroup var1, TransitionValues var2, int var3, TransitionValues var4, int var5) {
      Object var8 = null;
      Animator var7;
      if ((this.h & 2) != 2) {
         var7 = (Animator)var8;
      } else {
         View var21;
         if (var2 != null) {
            var21 = var2.b;
         } else {
            var21 = null;
         }

         View var6;
         if (var4 != null) {
            var6 = var4.b;
         } else {
            var6 = null;
         }

         if (var6 != null && var6.getParent() != null) {
            if (var5 == 4) {
               var21 = null;
            } else if (var21 == var6) {
               var21 = null;
            } else {
               var6 = null;
            }
         } else if (var6 != null) {
            Object var9 = null;
            var21 = var6;
            var6 = (View)var9;
         } else {
            label82: {
               if (var21 != null) {
                  if (var21.getParent() == null) {
                     var6 = null;
                     break label82;
                  }

                  if (var21.getParent() instanceof View) {
                     var6 = (View)var21.getParent();
                     if (!this.b(this.a(var6, true), this.b(var6, true)).a) {
                        var6 = TransitionUtils.a(var1, var21, var6);
                     } else {
                        label66: {
                           if (var6.getParent() == null) {
                              var3 = var6.getId();
                              if (var3 != -1 && var1.findViewById(var3) != null && this.e) {
                                 var6 = var21;
                                 break label66;
                              }
                           }

                           var6 = null;
                        }
                     }

                     var21 = var6;
                     var6 = null;
                     break label82;
                  }
               }

               var6 = null;
               var21 = null;
            }
         }

         if (var21 != null && var2 != null) {
            int[] var18 = (int[])var2.a.get("android:visibility:screenLocation");
            var3 = var18[0];
            var5 = var18[1];
            int[] var19 = new int[2];
            var1.getLocationOnScreen(var19);
            var21.offsetLeftAndRight(var3 - var19[0] - var21.getLeft());
            var21.offsetTopAndBottom(var5 - var19[1] - var21.getTop());
            ViewGroupOverlayImpl var20 = ViewGroupUtils.a(var1);
            var20.a(var21);
            Animator var11 = this.b(var1, var21, var2, var4);
            if (var11 == null) {
               var20.b(var21);
               var7 = var11;
            } else {
               var11.addListener(new AnimatorListenerAdapter(this, var20, var21) {
                  final ViewGroupOverlayImpl a;
                  final View b;
                  final Visibility c;

                  {
                     this.c = var1;
                     this.a = var2x;
                     this.b = var3x;
                  }

                  public void onAnimationEnd(Animator var1) {
                     this.a.b(this.b);
                  }
               });
               var7 = var11;
            }
         } else {
            var7 = (Animator)var8;
            if (var6 != null) {
               var3 = var6.getVisibility();
               ViewUtils.a(var6, 0);
               var7 = this.b(var1, var6, var2, var4);
               if (var7 != null) {
                  Visibility.DisappearListener var10 = new Visibility.DisappearListener(var6, var5, true);
                  var7.addListener(var10);
                  AnimatorUtils.a(var7, var10);
                  this.a(var10);
               } else {
                  ViewUtils.a(var6, var3);
               }
            }
         }
      }

      return var7;
   }

   public Animator b(ViewGroup var1, View var2, TransitionValues var3, TransitionValues var4) {
      return null;
   }

   public void b(int var1) {
      if ((var1 & -4) != 0) {
         throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
      }

      this.h = var1;
   }

   @Override
   public void b(TransitionValues var1) {
      this.d(var1);
   }

   public int p() {
      return this.h;
   }

   private static class DisappearListener
      extends AnimatorListenerAdapter
      implements AnimatorUtilsApi14.AnimatorPauseListenerCompat,
      Transition.TransitionListener {
      boolean a = false;
      private final View b;
      private final int c;
      private final ViewGroup d;
      private final boolean e;
      private boolean f;

      DisappearListener(View var1, int var2, boolean var3) {
         this.b = var1;
         this.c = var2;
         this.d = (ViewGroup)var1.getParent();
         this.e = var3;
         this.a(true);
      }

      private void a() {
         if (!this.a) {
            ViewUtils.a(this.b, this.c);
            if (this.d != null) {
               this.d.invalidate();
            }
         }

         this.a(false);
      }

      private void a(boolean var1) {
         if (this.e && this.f != var1 && this.d != null) {
            this.f = var1;
            ViewGroupUtils.a(this.d, var1);
         }
      }

      @Override
      public void a(Transition var1) {
         this.a();
         var1.b(this);
      }

      @Override
      public void b(Transition var1) {
         this.a(false);
      }

      @Override
      public void c(Transition var1) {
         this.a(true);
      }

      @Override
      public void d(Transition var1) {
      }

      public void onAnimationCancel(Animator var1) {
         this.a = true;
      }

      public void onAnimationEnd(Animator var1) {
         this.a();
      }

      @Override
      public void onAnimationPause(Animator var1) {
         if (!this.a) {
            ViewUtils.a(this.b, this.c);
         }
      }

      public void onAnimationRepeat(Animator var1) {
      }

      @Override
      public void onAnimationResume(Animator var1) {
         if (!this.a) {
            ViewUtils.a(this.b, 0);
         }
      }

      public void onAnimationStart(Animator var1) {
      }
   }

   private static class VisibilityInfo {
      boolean a;
      boolean b;
      int c;
      int d;
      ViewGroup e;
      ViewGroup f;

      private VisibilityInfo() {
      }
   }
}
