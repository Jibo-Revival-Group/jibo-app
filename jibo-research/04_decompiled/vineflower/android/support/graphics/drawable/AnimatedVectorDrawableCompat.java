package android.support.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable2Compat {
   final Callback a;
   private AnimatedVectorDrawableCompat.AnimatedVectorDrawableCompatState c;
   private Context d;
   private android.animation.ArgbEvaluator e = null;
   private AnimatorListener f = null;
   private ArrayList<Object> g = null;

   AnimatedVectorDrawableCompat() {
      this(null, null, null);
   }

   private AnimatedVectorDrawableCompat(Context var1) {
      this(var1, null, null);
   }

   private AnimatedVectorDrawableCompat(Context var1, AnimatedVectorDrawableCompat.AnimatedVectorDrawableCompatState var2, Resources var3) {
      this.a = new Callback(this) {
         final AnimatedVectorDrawableCompat a;

         {
            this.a = var1;
         }

         public void invalidateDrawable(Drawable var1) {
            this.a.invalidateSelf();
         }

         public void scheduleDrawable(Drawable var1, Runnable var2x, long var3x) {
            this.a.scheduleSelf(var2x, var3x);
         }

         public void unscheduleDrawable(Drawable var1, Runnable var2x) {
            this.a.unscheduleSelf(var2x);
         }
      };
      this.d = var1;
      if (var2 != null) {
         this.c = var2;
      } else {
         this.c = new AnimatedVectorDrawableCompat.AnimatedVectorDrawableCompatState(var1, var2, this.a, var3);
      }
   }

   public static AnimatedVectorDrawableCompat a(Context var0, Resources var1, XmlPullParser var2, AttributeSet var3, Theme var4) throws XmlPullParserException, IOException {
      AnimatedVectorDrawableCompat var5 = new AnimatedVectorDrawableCompat(var0);
      var5.inflate(var1, var2, var3, var4);
      return var5;
   }

   private void a(Animator var1) {
      if (var1 instanceof AnimatorSet) {
         ArrayList var3 = ((AnimatorSet)var1).getChildAnimations();
         if (var3 != null) {
            for (int var2 = 0; var2 < var3.size(); var2++) {
               this.a((Animator)var3.get(var2));
            }
         }
      }

      if (var1 instanceof ObjectAnimator) {
         ObjectAnimator var5 = (ObjectAnimator)var1;
         String var4 = var5.getPropertyName();
         if ("fillColor".equals(var4) || "strokeColor".equals(var4)) {
            if (this.e == null) {
               this.e = new android.animation.ArgbEvaluator();
            }

            var5.setEvaluator(this.e);
         }
      }
   }

   private void a(String var1, Animator var2) {
      var2.setTarget(this.c.b.a(var1));
      if (VERSION.SDK_INT < 21) {
         this.a(var2);
      }

      if (this.c.e == null) {
         this.c.e = new ArrayList<>();
         this.c.d = new ArrayMap<>();
      }

      this.c.e.add(var2);
      this.c.d.put(var2, var1);
   }

   @Override
   public void applyTheme(Theme var1) {
      if (this.b != null) {
         DrawableCompat.a(this.b, var1);
      }
   }

   public boolean canApplyTheme() {
      boolean var1;
      if (this.b != null) {
         var1 = DrawableCompat.d(this.b);
      } else {
         var1 = false;
      }

      return var1;
   }

   public void draw(Canvas var1) {
      if (this.b != null) {
         this.b.draw(var1);
      } else {
         this.c.b.draw(var1);
         if (this.c.c.isStarted()) {
            this.invalidateSelf();
         }
      }
   }

   public int getAlpha() {
      int var1;
      if (this.b != null) {
         var1 = DrawableCompat.c(this.b);
      } else {
         var1 = this.c.b.getAlpha();
      }

      return var1;
   }

   public int getChangingConfigurations() {
      int var1;
      if (this.b != null) {
         var1 = this.b.getChangingConfigurations();
      } else {
         var1 = super.getChangingConfigurations() | this.c.a;
      }

      return var1;
   }

   public ConstantState getConstantState() {
      AnimatedVectorDrawableCompat.AnimatedVectorDrawableDelegateState var1;
      if (this.b != null && VERSION.SDK_INT >= 24) {
         var1 = new AnimatedVectorDrawableCompat.AnimatedVectorDrawableDelegateState(this.b.getConstantState());
      } else {
         var1 = null;
      }

      return var1;
   }

   public int getIntrinsicHeight() {
      int var1;
      if (this.b != null) {
         var1 = this.b.getIntrinsicHeight();
      } else {
         var1 = this.c.b.getIntrinsicHeight();
      }

      return var1;
   }

   public int getIntrinsicWidth() {
      int var1;
      if (this.b != null) {
         var1 = this.b.getIntrinsicWidth();
      } else {
         var1 = this.c.b.getIntrinsicWidth();
      }

      return var1;
   }

   public int getOpacity() {
      int var1;
      if (this.b != null) {
         var1 = this.b.getOpacity();
      } else {
         var1 = this.c.b.getOpacity();
      }

      return var1;
   }

   public void inflate(Resources var1, XmlPullParser var2, AttributeSet var3) throws XmlPullParserException, IOException {
      this.inflate(var1, var2, var3, null);
   }

   public void inflate(Resources var1, XmlPullParser var2, AttributeSet var3, Theme var4) throws XmlPullParserException, IOException {
      if (this.b != null) {
         DrawableCompat.a(this.b, var1, var2, var3, var4);
      } else {
         int var5 = var2.getEventType();

         for (int var6 = var2.getDepth(); var5 != 1 && (var2.getDepth() >= var6 + 1 || var5 != 3); var5 = var2.next()) {
            if (var5 == 2) {
               String var7 = var2.getName();
               if ("animated-vector".equals(var7)) {
                  TypedArray var8 = TypedArrayUtils.a(var1, var4, var3, AndroidResources.e);
                  var5 = var8.getResourceId(0, 0);
                  if (var5 != 0) {
                     VectorDrawableCompat var11 = VectorDrawableCompat.a(var1, var5, var4);
                     var11.a(false);
                     var11.setCallback(this.a);
                     if (this.c.b != null) {
                        this.c.b.setCallback(null);
                     }

                     this.c.b = var11;
                  }

                  var8.recycle();
               } else if ("target".equals(var7)) {
                  TypedArray var12 = var1.obtainAttributes(var3, AndroidResources.f);
                  String var13 = var12.getString(0);
                  var5 = var12.getResourceId(1, 0);
                  if (var5 != 0) {
                     if (this.d == null) {
                        var12.recycle();
                        throw new IllegalStateException("Context can't be null when inflating animators");
                     }

                     this.a(var13, AnimatorInflaterCompat.a(this.d, var5));
                  }

                  var12.recycle();
               }
            }
         }

         this.c.a();
      }
   }

   public boolean isAutoMirrored() {
      boolean var1;
      if (this.b != null) {
         var1 = DrawableCompat.b(this.b);
      } else {
         var1 = this.c.b.isAutoMirrored();
      }

      return var1;
   }

   public boolean isRunning() {
      boolean var1;
      if (this.b != null) {
         var1 = ((AnimatedVectorDrawable)this.b).isRunning();
      } else {
         var1 = this.c.c.isRunning();
      }

      return var1;
   }

   public boolean isStateful() {
      boolean var1;
      if (this.b != null) {
         var1 = this.b.isStateful();
      } else {
         var1 = this.c.b.isStateful();
      }

      return var1;
   }

   public Drawable mutate() {
      if (this.b != null) {
         this.b.mutate();
      }

      return this;
   }

   @Override
   protected void onBoundsChange(Rect var1) {
      if (this.b != null) {
         this.b.setBounds(var1);
      } else {
         this.c.b.setBounds(var1);
      }
   }

   @Override
   protected boolean onLevelChange(int var1) {
      boolean var2;
      if (this.b != null) {
         var2 = this.b.setLevel(var1);
      } else {
         var2 = this.c.b.setLevel(var1);
      }

      return var2;
   }

   protected boolean onStateChange(int[] var1) {
      boolean var2;
      if (this.b != null) {
         var2 = this.b.setState(var1);
      } else {
         var2 = this.c.b.setState(var1);
      }

      return var2;
   }

   public void setAlpha(int var1) {
      if (this.b != null) {
         this.b.setAlpha(var1);
      } else {
         this.c.b.setAlpha(var1);
      }
   }

   public void setAutoMirrored(boolean var1) {
      if (this.b != null) {
         DrawableCompat.a(this.b, var1);
      } else {
         this.c.b.setAutoMirrored(var1);
      }
   }

   public void setColorFilter(ColorFilter var1) {
      if (this.b != null) {
         this.b.setColorFilter(var1);
      } else {
         this.c.b.setColorFilter(var1);
      }
   }

   @Override
   public void setTint(int var1) {
      if (this.b != null) {
         DrawableCompat.a(this.b, var1);
      } else {
         this.c.b.setTint(var1);
      }
   }

   @Override
   public void setTintList(ColorStateList var1) {
      if (this.b != null) {
         DrawableCompat.a(this.b, var1);
      } else {
         this.c.b.setTintList(var1);
      }
   }

   @Override
   public void setTintMode(Mode var1) {
      if (this.b != null) {
         DrawableCompat.a(this.b, var1);
      } else {
         this.c.b.setTintMode(var1);
      }
   }

   public boolean setVisible(boolean var1, boolean var2) {
      if (this.b != null) {
         var1 = this.b.setVisible(var1, var2);
      } else {
         this.c.b.setVisible(var1, var2);
         var1 = super.setVisible(var1, var2);
      }

      return var1;
   }

   public void start() {
      if (this.b != null) {
         ((AnimatedVectorDrawable)this.b).start();
      } else if (!this.c.c.isStarted()) {
         this.c.c.start();
         this.invalidateSelf();
      }
   }

   public void stop() {
      if (this.b != null) {
         ((AnimatedVectorDrawable)this.b).stop();
      } else {
         this.c.c.end();
      }
   }

   private static class AnimatedVectorDrawableCompatState extends ConstantState {
      int a;
      VectorDrawableCompat b;
      AnimatorSet c;
      ArrayMap<Animator, String> d;
      private ArrayList<Animator> e;

      public AnimatedVectorDrawableCompatState(Context var1, AnimatedVectorDrawableCompat.AnimatedVectorDrawableCompatState var2, Callback var3, Resources var4) {
         int var5 = 0;
         super();
         if (var2 != null) {
            this.a = var2.a;
            if (var2.b != null) {
               ConstantState var7 = var2.b.getConstantState();
               if (var4 != null) {
                  this.b = (VectorDrawableCompat)var7.newDrawable(var4);
               } else {
                  this.b = (VectorDrawableCompat)var7.newDrawable();
               }

               this.b = (VectorDrawableCompat)this.b.mutate();
               this.b.setCallback(var3);
               this.b.setBounds(var2.b.getBounds());
               this.b.a(false);
            }

            if (var2.e != null) {
               int var6 = var2.e.size();
               this.e = new ArrayList<>(var6);

               for (this.d = new ArrayMap<>(var6); var5 < var6; var5++) {
                  Animator var9 = var2.e.get(var5);
                  Animator var8 = var9.clone();
                  String var10 = var2.d.get(var9);
                  var8.setTarget(this.b.a(var10));
                  this.e.add(var8);
                  this.d.put(var8, var10);
               }

               this.a();
            }
         }
      }

      public void a() {
         if (this.c == null) {
            this.c = new AnimatorSet();
         }

         this.c.playTogether(this.e);
      }

      public int getChangingConfigurations() {
         return this.a;
      }

      public Drawable newDrawable() {
         throw new IllegalStateException("No constant state support for SDK < 24.");
      }

      public Drawable newDrawable(Resources var1) {
         throw new IllegalStateException("No constant state support for SDK < 24.");
      }
   }

   private static class AnimatedVectorDrawableDelegateState extends ConstantState {
      private final ConstantState a;

      public AnimatedVectorDrawableDelegateState(ConstantState var1) {
         this.a = var1;
      }

      public boolean canApplyTheme() {
         return this.a.canApplyTheme();
      }

      public int getChangingConfigurations() {
         return this.a.getChangingConfigurations();
      }

      public Drawable newDrawable() {
         AnimatedVectorDrawableCompat var1 = new AnimatedVectorDrawableCompat();
         var1.b = this.a.newDrawable();
         var1.b.setCallback(var1.a);
         return var1;
      }

      public Drawable newDrawable(Resources var1) {
         AnimatedVectorDrawableCompat var2 = new AnimatedVectorDrawableCompat();
         var2.b = this.a.newDrawable(var1);
         var2.b.setCallback(var2.a);
         return var2;
      }

      public Drawable newDrawable(Resources var1, Theme var2) {
         AnimatedVectorDrawableCompat var3 = new AnimatedVectorDrawableCompat();
         var3.b = this.a.newDrawable(var1, var2);
         var3.b.setCallback(var3.a);
         return var3;
      }
   }
}
