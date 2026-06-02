package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public class ChangeBounds extends Transition {
   private static final String[] g = new String[]{
      "android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"
   };
   private static final Property<Drawable, PointF> h = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") {
      private Rect a = new Rect();

      public PointF a(Drawable var1) {
         var1.copyBounds(this.a);
         return new PointF(this.a.left, this.a.top);
      }

      public void a(Drawable var1, PointF var2) {
         var1.copyBounds(this.a);
         this.a.offsetTo(Math.round(var2.x), Math.round(var2.y));
         var1.setBounds(this.a);
      }
   };
   private static final Property<ChangeBounds.ViewBounds, PointF> i = new Property<ChangeBounds.ViewBounds, PointF>(PointF.class, "topLeft") {
      public PointF a(ChangeBounds.ViewBounds var1) {
         return null;
      }

      public void a(ChangeBounds.ViewBounds var1, PointF var2) {
         var1.a(var2);
      }
   };
   private static final Property<ChangeBounds.ViewBounds, PointF> j = new Property<ChangeBounds.ViewBounds, PointF>(PointF.class, "bottomRight") {
      public PointF a(ChangeBounds.ViewBounds var1) {
         return null;
      }

      public void a(ChangeBounds.ViewBounds var1, PointF var2) {
         var1.b(var2);
      }
   };
   private static final Property<View, PointF> k = new Property<View, PointF>(PointF.class, "bottomRight") {
      public PointF a(View var1) {
         return null;
      }

      public void a(View var1, PointF var2) {
         ViewUtils.a(var1, var1.getLeft(), var1.getTop(), Math.round(var2.x), Math.round(var2.y));
      }
   };
   private static final Property<View, PointF> l = new Property<View, PointF>(PointF.class, "topLeft") {
      public PointF a(View var1) {
         return null;
      }

      public void a(View var1, PointF var2) {
         ViewUtils.a(var1, Math.round(var2.x), Math.round(var2.y), var1.getRight(), var1.getBottom());
      }
   };
   private static final Property<View, PointF> m = new Property<View, PointF>(PointF.class, "position") {
      public PointF a(View var1) {
         return null;
      }

      public void a(View var1, PointF var2) {
         int var3 = Math.round(var2.x);
         int var4 = Math.round(var2.y);
         ViewUtils.a(var1, var3, var4, var1.getWidth() + var3, var1.getHeight() + var4);
      }
   };
   private static RectEvaluator q = new RectEvaluator();
   private int[] n = new int[2];
   private boolean o = false;
   private boolean p = false;

   public ChangeBounds() {
   }

   public ChangeBounds(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var4 = var1.obtainStyledAttributes(var2, Styleable.d);
      boolean var3 = TypedArrayUtils.a(var4, (XmlResourceParser)var2, "resizeClip", 0, false);
      var4.recycle();
      this.a(var3);
   }

   private boolean a(View var1, View var2) {
      boolean var4 = true;
      boolean var3 = var4;
      if (this.p) {
         TransitionValues var5 = this.b(var1, true);
         if (var5 == null) {
            if (var1 == var2) {
               var3 = var4;
            } else {
               var3 = false;
            }
         } else {
            var3 = var4;
            if (var2 != var5.b) {
               var3 = false;
            }
         }
      }

      return var3;
   }

   private void d(TransitionValues var1) {
      View var2 = var1.b;
      if (ViewCompat.y(var2) || var2.getWidth() != 0 || var2.getHeight() != 0) {
         var1.a.put("android:changeBounds:bounds", new Rect(var2.getLeft(), var2.getTop(), var2.getRight(), var2.getBottom()));
         var1.a.put("android:changeBounds:parent", var1.b.getParent());
         if (this.p) {
            var1.b.getLocationInWindow(this.n);
            var1.a.put("android:changeBounds:windowX", this.n[0]);
            var1.a.put("android:changeBounds:windowY", this.n[1]);
         }

         if (this.o) {
            var1.a.put("android:changeBounds:clip", ViewCompat.A(var2));
         }
      }
   }

   @Override
   public Animator a(ViewGroup var1, TransitionValues var2, TransitionValues var3) {
      Object var32;
      if (var2 != null && var3 != null) {
         Map var20 = var2.a;
         Map var21 = var3.a;
         ViewGroup var48 = (ViewGroup)var20.get("android:changeBounds:parent");
         ViewGroup var22 = (ViewGroup)var21.get("android:changeBounds:parent");
         if (var48 != null && var22 != null) {
            View var52 = var3.b;
            if (this.a(var48, var22)) {
               int var5;
               int var8;
               int var9;
               int var10;
               int var11;
               int var12;
               int var13;
               int var14;
               int var15;
               int var16;
               int var17;
               int var18;
               int var19;
               label140: {
                  Rect var23 = (Rect)var2.a.get("android:changeBounds:bounds");
                  Rect var49 = (Rect)var3.a.get("android:changeBounds:bounds");
                  var18 = var23.left;
                  var15 = var49.left;
                  var16 = var23.top;
                  var13 = var49.top;
                  var8 = var23.right;
                  var10 = var49.right;
                  var19 = var23.bottom;
                  var12 = var49.bottom;
                  var14 = var8 - var18;
                  var11 = var19 - var16;
                  var9 = var10 - var15;
                  var17 = var12 - var13;
                  var33 = (Rect)var2.a.get("android:changeBounds:clip");
                  var50 = (Rect)var3.a.get("android:changeBounds:clip");
                  byte var6 = 0;
                  byte var7 = 0;
                  if (var14 == 0 || var11 == 0) {
                     var5 = var6;
                     if (var9 == 0) {
                        break label140;
                     }

                     var5 = var6;
                     if (var17 == 0) {
                        break label140;
                     }
                  }

                  label104: {
                     if (var18 == var15) {
                        var6 = var7;
                        if (var16 == var13) {
                           break label104;
                        }
                     }

                     var6 = 1;
                  }

                  if (var8 == var10) {
                     var5 = var6;
                     if (var19 == var12) {
                        break label140;
                     }
                  }

                  var5 = var6 + 1;
               }

               int var44;
               label141: {
                  if (var33 == null || var33.equals(var50)) {
                     var44 = var5;
                     if (var33 != null) {
                        break label141;
                     }

                     var44 = var5;
                     if (var50 == null) {
                        break label141;
                     }
                  }

                  var44 = var5 + 1;
               }

               if (var44 > 0) {
                  Object var26;
                  if (!this.o) {
                     ViewUtils.a(var52, var18, var16, var8, var19);
                     if (var44 == 2) {
                        if (var14 == var9 && var11 == var17) {
                           Path var31 = this.l().a(var18, var16, var15, var13);
                           var26 = ObjectAnimatorUtils.a(var52, m, var31);
                        } else {
                           ChangeBounds.ViewBounds var35 = new ChangeBounds.ViewBounds(var52);
                           Path var29 = this.l().a(var18, var16, var15, var13);
                           ObjectAnimator var40 = ObjectAnimatorUtils.a(var35, i, var29);
                           Path var30 = this.l().a(var8, var19, var10, var12);
                           ObjectAnimator var51 = ObjectAnimatorUtils.a(var35, j, var30);
                           var26 = new AnimatorSet();
                           var26.playTogether(new Animator[]{var40, var51});
                           var26.addListener(new AnimatorListenerAdapter(this, var35) {
                              final ChangeBounds.ViewBounds a;
                              final ChangeBounds b;
                              private ChangeBounds.ViewBounds mViewBounds;

                              {
                                 this.b = var1;
                                 this.a = var2x;
                                 this.mViewBounds = this.a;
                              }
                           });
                        }
                     } else if (var18 == var15 && var16 == var13) {
                        Path var28 = this.l().a(var8, var19, var10, var12);
                        var26 = ObjectAnimatorUtils.a(var52, k, var28);
                     } else {
                        Path var27 = this.l().a(var18, var16, var15, var13);
                        var26 = ObjectAnimatorUtils.a(var52, l, var27);
                     }
                  } else {
                     ViewUtils.a(var52, var18, var16, Math.max(var14, var9) + var18, Math.max(var11, var17) + var16);
                     ObjectAnimator var25;
                     if (var18 == var15 && var16 == var13) {
                        var25 = null;
                     } else {
                        Path var24 = this.l().a(var18, var16, var15, var13);
                        var25 = ObjectAnimatorUtils.a(var52, m, var24);
                     }

                     if (var33 == null) {
                        var33 = new Rect(0, 0, var14, var11);
                     }

                     Rect var39;
                     if (var50 == null) {
                        var39 = new Rect(0, 0, var9, var17);
                     } else {
                        var39 = var50;
                     }

                     ObjectAnimator var34;
                     if (!var33.equals(var39)) {
                        ViewCompat.a(var52, var33);
                        var34 = ObjectAnimator.ofObject(var52, "clipBounds", q, new Object[]{var33, var39});
                        var34.addListener(new AnimatorListenerAdapter(this, var52, var50, var15, var13, var10, var12) {
                           final View a;
                           final Rect b;
                           final int c;
                           final int d;
                           final int e;
                           final int f;
                           final ChangeBounds g;
                           private boolean h;

                           {
                              this.g = var1;
                              this.a = var2x;
                              this.b = var3x;
                              this.c = var4;
                              this.d = var5x;
                              this.e = var6;
                              this.f = var7;
                           }

                           public void onAnimationCancel(Animator var1) {
                              this.h = true;
                           }

                           public void onAnimationEnd(Animator var1) {
                              if (!this.h) {
                                 ViewCompat.a(this.a, this.b);
                                 ViewUtils.a(this.a, this.c, this.d, this.e, this.f);
                              }
                           }
                        });
                     } else {
                        var34 = null;
                     }

                     var26 = TransitionUtils.a(var25, var34);
                  }

                  var32 = var26;
                  if (var52.getParent() instanceof ViewGroup) {
                     ViewGroup var36 = (ViewGroup)var52.getParent();
                     ViewGroupUtils.a(var36, true);
                     this.a(new TransitionListenerAdapter(this, var36) {
                        boolean a;
                        final ViewGroup b;
                        final ChangeBounds c;

                        {
                           this.c = var1;
                           this.b = var2x;
                           this.a = false;
                        }

                        @Override
                        public void a(Transition var1) {
                           if (!this.a) {
                              ViewGroupUtils.a(this.b, false);
                           }

                           var1.b(this);
                        }

                        @Override
                        public void b(Transition var1) {
                           ViewGroupUtils.a(this.b, false);
                        }

                        @Override
                        public void c(Transition var1) {
                           ViewGroupUtils.a(this.b, true);
                        }
                     });
                     var32 = var26;
                  }

                  return (Animator)var32;
               }
            } else {
               int var45 = (Integer)var2.a.get("android:changeBounds:windowX");
               int var42 = (Integer)var2.a.get("android:changeBounds:windowY");
               int var47 = (Integer)var3.a.get("android:changeBounds:windowX");
               int var46 = (Integer)var3.a.get("android:changeBounds:windowY");
               if (var45 != var47 || var42 != var46) {
                  var1.getLocationInWindow(this.n);
                  Bitmap var37 = Bitmap.createBitmap(var52.getWidth(), var52.getHeight(), Config.ARGB_8888);
                  var52.draw(new Canvas(var37));
                  BitmapDrawable var41 = new BitmapDrawable(var37);
                  float var4 = ViewUtils.c(var52);
                  ViewUtils.a(var52, 0.0F);
                  ViewUtils.a(var1).a(var41);
                  Path var38 = this.l().a(var45 - this.n[0], var42 - this.n[1], var47 - this.n[0], var46 - this.n[1]);
                  ObjectAnimator var54 = ObjectAnimator.ofPropertyValuesHolder(var41, new PropertyValuesHolder[]{PropertyValuesHolderUtils.a(h, var38)});
                  var54.addListener(new AnimatorListenerAdapter(this, var1, var41, var52, var4) {
                     final ViewGroup a;
                     final BitmapDrawable b;
                     final View c;
                     final float d;
                     final ChangeBounds e;

                     {
                        this.e = var1;
                        this.a = var2x;
                        this.b = var3x;
                        this.c = var4x;
                        this.d = var5;
                     }

                     public void onAnimationEnd(Animator var1) {
                        ViewUtils.a(this.a).b(this.b);
                        ViewUtils.a(this.c, this.d);
                     }
                  });
                  return var54;
               }
            }

            var32 = null;
         } else {
            var32 = null;
         }
      } else {
         var32 = null;
      }

      return (Animator)var32;
   }

   @Override
   public void a(TransitionValues var1) {
      this.d(var1);
   }

   public void a(boolean var1) {
      this.o = var1;
   }

   @Override
   public String[] a() {
      return g;
   }

   @Override
   public void b(TransitionValues var1) {
      this.d(var1);
   }

   private static class ViewBounds {
      private int a;
      private int b;
      private int c;
      private int d;
      private View e;
      private int f;
      private int g;

      ViewBounds(View var1) {
         this.e = var1;
      }

      private void a() {
         ViewUtils.a(this.e, this.a, this.b, this.c, this.d);
         this.f = 0;
         this.g = 0;
      }

      void a(PointF var1) {
         this.a = Math.round(var1.x);
         this.b = Math.round(var1.y);
         this.f++;
         if (this.f == this.g) {
            this.a();
         }
      }

      void b(PointF var1) {
         this.c = Math.round(var1.x);
         this.d = Math.round(var1.y);
         this.g++;
         if (this.f == this.g) {
            this.a();
         }
      }
   }
}
