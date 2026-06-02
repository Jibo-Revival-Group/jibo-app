package android.support.v7.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.PorterDuff.Mode;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.text.AllCapsTransformationMethod;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.Layout.Alignment;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;

public class SwitchCompat extends CompoundButton {
   private static final int[] N = new int[]{16842912};
   private static final Property<SwitchCompat, Float> b = new Property<SwitchCompat, Float>(Float.class, "thumbPos") {
      public Float a(SwitchCompat var1) {
         return var1.z;
      }

      public void a(SwitchCompat var1, Float var2) {
         var1.setThumbPosition(var2);
      }
   };
   private int A;
   private int B;
   private int C;
   private int D;
   private int E;
   private int F;
   private int G;
   private final TextPaint H;
   private ColorStateList I;
   private Layout J;
   private Layout K;
   private TransformationMethod L;
   private final Rect M;
   ObjectAnimator a;
   private Drawable c;
   private ColorStateList d = null;
   private Mode e = null;
   private boolean f = false;
   private boolean g = false;
   private Drawable h;
   private ColorStateList i = null;
   private Mode j = null;
   private boolean k = false;
   private boolean l = false;
   private int m;
   private int n;
   private int o;
   private boolean p;
   private CharSequence q;
   private CharSequence r;
   private boolean s;
   private int t;
   private int u;
   private float v;
   private float w;
   private VelocityTracker x = VelocityTracker.obtain();
   private int y;
   private float z;

   public SwitchCompat(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.switchStyle);
   }

   public SwitchCompat(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.M = new Rect();
      this.H = new TextPaint(1);
      Resources var4 = this.getResources();
      this.H.density = var4.getDisplayMetrics().density;
      TintTypedArray var6 = TintTypedArray.a(var1, var2, R.styleable.SwitchCompat, var3, 0);
      this.c = var6.a(R.styleable.SwitchCompat_android_thumb);
      if (this.c != null) {
         this.c.setCallback(this);
      }

      this.h = var6.a(R.styleable.SwitchCompat_track);
      if (this.h != null) {
         this.h.setCallback(this);
      }

      this.q = var6.c(R.styleable.SwitchCompat_android_textOn);
      this.r = var6.c(R.styleable.SwitchCompat_android_textOff);
      this.s = var6.a(R.styleable.SwitchCompat_showText, true);
      this.m = var6.e(R.styleable.SwitchCompat_thumbTextPadding, 0);
      this.n = var6.e(R.styleable.SwitchCompat_switchMinWidth, 0);
      this.o = var6.e(R.styleable.SwitchCompat_switchPadding, 0);
      this.p = var6.a(R.styleable.SwitchCompat_splitTrack, false);
      ColorStateList var8 = var6.e(R.styleable.SwitchCompat_thumbTint);
      if (var8 != null) {
         this.d = var8;
         this.f = true;
      }

      Mode var9 = DrawableUtils.a(var6.a(R.styleable.SwitchCompat_thumbTintMode, -1), null);
      if (this.e != var9) {
         this.e = var9;
         this.g = true;
      }

      if (this.f || this.g) {
         this.b();
      }

      ColorStateList var10 = var6.e(R.styleable.SwitchCompat_trackTint);
      if (var10 != null) {
         this.i = var10;
         this.k = true;
      }

      Mode var11 = DrawableUtils.a(var6.a(R.styleable.SwitchCompat_trackTintMode, -1), null);
      if (this.j != var11) {
         this.j = var11;
         this.l = true;
      }

      if (this.k || this.l) {
         this.a();
      }

      var3 = var6.g(R.styleable.SwitchCompat_switchTextAppearance, 0);
      if (var3 != 0) {
         this.a(var1, var3);
      }

      var6.a();
      ViewConfiguration var5 = ViewConfiguration.get(var1);
      this.u = var5.getScaledTouchSlop();
      this.y = var5.getScaledMinimumFlingVelocity();
      this.refreshDrawableState();
      this.setChecked(this.isChecked());
   }

   private static float a(float var0, float var1, float var2) {
      if (!(var0 < var1)) {
         if (var0 > var2) {
            var1 = var2;
         } else {
            var1 = var0;
         }
      }

      return var1;
   }

   private Layout a(CharSequence var1) {
      if (this.L != null) {
         var1 = this.L.getTransformation(var1, this);
      }

      TextPaint var3 = this.H;
      int var2;
      if (var1 != null) {
         var2 = (int)Math.ceil(Layout.getDesiredWidth(var1, this.H));
      } else {
         var2 = 0;
      }

      return new StaticLayout(var1, var3, var2, Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
   }

   private void a() {
      if (this.h != null && (this.k || this.l)) {
         this.h = this.h.mutate();
         if (this.k) {
            DrawableCompat.a(this.h, this.i);
         }

         if (this.l) {
            DrawableCompat.a(this.h, this.j);
         }

         if (this.h.isStateful()) {
            this.h.setState(this.getDrawableState());
         }
      }
   }

   private void a(int var1, int var2) {
      Typeface var3 = null;
      switch (var1) {
         case 1:
            var3 = Typeface.SANS_SERIF;
            break;
         case 2:
            var3 = Typeface.SERIF;
            break;
         case 3:
            var3 = Typeface.MONOSPACE;
      }

      this.a(var3, var2);
   }

   private void a(MotionEvent var1) {
      var1 = MotionEvent.obtain(var1);
      var1.setAction(3);
      super.onTouchEvent(var1);
      var1.recycle();
   }

   private void a(boolean var1) {
      float var2;
      if (var1) {
         var2 = 1.0F;
      } else {
         var2 = 0.0F;
      }

      this.a = ObjectAnimator.ofFloat(this, b, new float[]{var2});
      this.a.setDuration(250L);
      if (VERSION.SDK_INT >= 18) {
         this.a.setAutoCancel(true);
      }

      this.a.start();
   }

   private boolean a(float var1, float var2) {
      boolean var13 = false;
      boolean var12;
      if (this.c == null) {
         var12 = var13;
      } else {
         int var5 = this.getThumbOffset();
         this.c.getPadding(this.M);
         int var4 = this.E;
         int var3 = this.u;
         int var8 = var5 + this.D - this.u;
         int var9 = this.C;
         var5 = this.M.left;
         int var6 = this.M.right;
         int var10 = this.u;
         int var7 = this.G;
         int var11 = this.u;
         var12 = var13;
         if (var1 > var8) {
            var12 = var13;
            if (var1 < var9 + var8 + var5 + var6 + var10) {
               var12 = var13;
               if (var2 > var4 - var3) {
                  var12 = var13;
                  if (var2 < var7 + var11) {
                     var12 = true;
                  }
               }
            }
         }
      }

      return var12;
   }

   private void b() {
      if (this.c != null && (this.f || this.g)) {
         this.c = this.c.mutate();
         if (this.f) {
            DrawableCompat.a(this.c, this.d);
         }

         if (this.g) {
            DrawableCompat.a(this.c, this.e);
         }

         if (this.c.isStateful()) {
            this.c.setState(this.getDrawableState());
         }
      }
   }

   private void b(MotionEvent var1) {
      boolean var4 = true;
      this.t = 0;
      boolean var3;
      if (var1.getAction() == 1 && this.isEnabled()) {
         var3 = true;
      } else {
         var3 = false;
      }

      boolean var5 = this.isChecked();
      if (var3) {
         this.x.computeCurrentVelocity(1000);
         float var2 = this.x.getXVelocity();
         if (Math.abs(var2) > this.y) {
            if (ViewUtils.a(this)) {
               if (!(var2 < 0.0F)) {
                  var4 = false;
               }
            } else if (!(var2 > 0.0F)) {
               var4 = false;
            }
         } else {
            var4 = this.getTargetCheckedState();
         }
      } else {
         var4 = var5;
      }

      if (var4 != var5) {
         this.playSoundEffect(0);
      }

      this.setChecked(var4);
      this.a(var1);
   }

   private void c() {
      if (this.a != null) {
         this.a.cancel();
      }
   }

   private boolean getTargetCheckedState() {
      boolean var1;
      if (this.z > 0.5F) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private int getThumbOffset() {
      float var1;
      if (ViewUtils.a(this)) {
         var1 = 1.0F - this.z;
      } else {
         var1 = this.z;
      }

      return (int)(var1 * this.getThumbScrollRange() + 0.5F);
   }

   private int getThumbScrollRange() {
      int var1;
      if (this.h != null) {
         Rect var3 = this.M;
         this.h.getPadding(var3);
         Rect var2;
         if (this.c != null) {
            var2 = DrawableUtils.a(this.c);
         } else {
            var2 = DrawableUtils.a;
         }

         var1 = this.A - this.C - var3.left - var3.right - var2.left - var2.right;
      } else {
         var1 = 0;
      }

      return var1;
   }

   public void a(Context var1, int var2) {
      TintTypedArray var4 = TintTypedArray.a(var1, var2, R.styleable.TextAppearance);
      ColorStateList var3 = var4.e(R.styleable.TextAppearance_android_textColor);
      if (var3 != null) {
         this.I = var3;
      } else {
         this.I = this.getTextColors();
      }

      var2 = var4.e(R.styleable.TextAppearance_android_textSize, 0);
      if (var2 != 0 && var2 != this.H.getTextSize()) {
         this.H.setTextSize(var2);
         this.requestLayout();
      }

      this.a(var4.a(R.styleable.TextAppearance_android_typeface, -1), var4.a(R.styleable.TextAppearance_android_textStyle, -1));
      if (var4.a(R.styleable.TextAppearance_textAllCaps, false)) {
         this.L = new AllCapsTransformationMethod(this.getContext());
      } else {
         this.L = null;
      }

      var4.a();
   }

   public void a(Typeface var1, int var2) {
      boolean var5 = false;
      if (var2 > 0) {
         if (var1 == null) {
            var1 = Typeface.defaultFromStyle(var2);
         } else {
            var1 = Typeface.create(var1, var2);
         }

         this.setSwitchTypeface(var1);
         int var4;
         if (var1 != null) {
            var4 = var1.getStyle();
         } else {
            var4 = 0;
         }

         var2 = ~var4 & var2;
         TextPaint var7 = this.H;
         if ((var2 & 1) != 0) {
            var5 = true;
         }

         var7.setFakeBoldText(var5);
         TextPaint var8 = this.H;
         float var3;
         if ((var2 & 2) != 0) {
            var3 = -0.25F;
         } else {
            var3 = 0.0F;
         }

         var8.setTextSkewX(var3);
      } else {
         this.H.setFakeBoldText(false);
         this.H.setTextSkewX(0.0F);
         this.setSwitchTypeface(var1);
      }
   }

   public void draw(Canvas var1) {
      Rect var12 = this.M;
      int var3 = this.D;
      int var7 = this.E;
      int var8 = this.F;
      int var6 = this.G;
      int var9 = var3 + this.getThumbOffset();
      Rect var11;
      if (this.c != null) {
         var11 = DrawableUtils.a(this.c);
      } else {
         var11 = DrawableUtils.a;
      }

      int var13;
      if (this.h != null) {
         this.h.getPadding(var12);
         int var10 = var12.left;
         int var4;
         int var5;
         if (var11 != null) {
            var13 = var3;
            if (var11.left > var12.left) {
               var13 = var3 + (var11.left - var12.left);
            }

            if (var11.top > var12.top) {
               var3 = var11.top - var12.top + var7;
            } else {
               var3 = var7;
            }

            var5 = var8;
            if (var11.right > var12.right) {
               var5 = var8 - (var11.right - var12.right);
            }

            if (var11.bottom > var12.bottom) {
               var4 = var6 - (var11.bottom - var12.bottom);
            } else {
               var4 = var6;
            }
         } else {
            var4 = var6;
            var5 = var7;
            var13 = var3;
            var3 = var5;
            var5 = var8;
         }

         this.h.setBounds(var13, var3, var5, var4);
         var13 = var10 + var9;
      } else {
         var13 = var9;
      }

      if (this.c != null) {
         this.c.getPadding(var12);
         var3 = var13 - var12.left;
         var13 = var13 + this.C + var12.right;
         this.c.setBounds(var3, var7, var13, var6);
         Drawable var18 = this.getBackground();
         if (var18 != null) {
            DrawableCompat.a(var18, var3, var7, var13, var6);
         }
      }

      super.draw(var1);
   }

   public void drawableHotspotChanged(float var1, float var2) {
      if (VERSION.SDK_INT >= 21) {
         super.drawableHotspotChanged(var1, var2);
      }

      if (this.c != null) {
         DrawableCompat.a(this.c, var1, var2);
      }

      if (this.h != null) {
         DrawableCompat.a(this.h, var1, var2);
      }
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      int[] var3 = this.getDrawableState();
      boolean var2 = false;
      Drawable var4 = this.c;
      boolean var1 = var2;
      if (var4 != null) {
         var1 = var2;
         if (var4.isStateful()) {
            var1 = false | var4.setState(var3);
         }
      }

      var4 = this.h;
      var2 = var1;
      if (var4 != null) {
         var2 = var1;
         if (var4.isStateful()) {
            var2 = var1 | var4.setState(var3);
         }
      }

      if (var2) {
         this.invalidate();
      }
   }

   public int getCompoundPaddingLeft() {
      int var1;
      if (!ViewUtils.a(this)) {
         var1 = super.getCompoundPaddingLeft();
      } else {
         int var2 = super.getCompoundPaddingLeft() + this.A;
         var1 = var2;
         if (!TextUtils.isEmpty(this.getText())) {
            var1 = var2 + this.o;
         }
      }

      return var1;
   }

   public int getCompoundPaddingRight() {
      int var1;
      if (ViewUtils.a(this)) {
         var1 = super.getCompoundPaddingRight();
      } else {
         int var2 = super.getCompoundPaddingRight() + this.A;
         var1 = var2;
         if (!TextUtils.isEmpty(this.getText())) {
            var1 = var2 + this.o;
         }
      }

      return var1;
   }

   public boolean getShowText() {
      return this.s;
   }

   public boolean getSplitTrack() {
      return this.p;
   }

   public int getSwitchMinWidth() {
      return this.n;
   }

   public int getSwitchPadding() {
      return this.o;
   }

   public CharSequence getTextOff() {
      return this.r;
   }

   public CharSequence getTextOn() {
      return this.q;
   }

   public Drawable getThumbDrawable() {
      return this.c;
   }

   public int getThumbTextPadding() {
      return this.m;
   }

   public ColorStateList getThumbTintList() {
      return this.d;
   }

   public Mode getThumbTintMode() {
      return this.e;
   }

   public Drawable getTrackDrawable() {
      return this.h;
   }

   public ColorStateList getTrackTintList() {
      return this.i;
   }

   public Mode getTrackTintMode() {
      return this.j;
   }

   public void jumpDrawablesToCurrentState() {
      super.jumpDrawablesToCurrentState();
      if (this.c != null) {
         this.c.jumpToCurrentState();
      }

      if (this.h != null) {
         this.h.jumpToCurrentState();
      }

      if (this.a != null && this.a.isStarted()) {
         this.a.end();
         this.a = null;
      }
   }

   protected int[] onCreateDrawableState(int var1) {
      int[] var2 = super.onCreateDrawableState(var1 + 1);
      if (this.isChecked()) {
         mergeDrawableStates(var2, N);
      }

      return var2;
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      Rect var9 = this.M;
      Drawable var12 = this.h;
      if (var12 != null) {
         var12.getPadding(var9);
      } else {
         var9.setEmpty();
      }

      int var7 = this.E;
      int var5 = this.G;
      int var4 = var9.top;
      int var6 = var9.bottom;
      Drawable var10 = this.c;
      if (var12 != null) {
         if (this.p && var10 != null) {
            Rect var11 = DrawableUtils.a(var10);
            var10.copyBounds(var9);
            var9.left = var9.left + var11.left;
            var9.right = var9.right - var11.right;
            int var2 = var1.save();
            var1.clipRect(var9, Op.DIFFERENCE);
            var12.draw(var1);
            var1.restoreToCount(var2);
         } else {
            var12.draw(var1);
         }
      }

      int var3 = var1.save();
      if (var10 != null) {
         var10.draw(var1);
      }

      Layout var18;
      if (this.getTargetCheckedState()) {
         var18 = this.J;
      } else {
         var18 = this.K;
      }

      if (var18 != null) {
         int[] var20 = this.getDrawableState();
         if (this.I != null) {
            this.H.setColor(this.I.getColorForState(var20, 0));
         }

         this.H.drawableState = var20;
         int var14;
         if (var10 != null) {
            Rect var19 = var10.getBounds();
            var14 = var19.left;
            var14 = var19.right + var14;
         } else {
            var14 = this.getWidth();
         }

         int var8 = var14 / 2;
         var14 = var18.getWidth() / 2;
         var5 = (var7 + var4 + (var5 - var6)) / 2;
         var4 = var18.getHeight() / 2;
         var1.translate(var8 - var14, var5 - var4);
         var18.draw(var1);
      }

      var1.restoreToCount(var3);
   }

   public void onInitializeAccessibilityEvent(AccessibilityEvent var1) {
      super.onInitializeAccessibilityEvent(var1);
      var1.setClassName("android.widget.Switch");
   }

   public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo var1) {
      super.onInitializeAccessibilityNodeInfo(var1);
      var1.setClassName("android.widget.Switch");
      CharSequence var2;
      if (this.isChecked()) {
         var2 = this.q;
      } else {
         var2 = this.r;
      }

      if (!TextUtils.isEmpty(var2)) {
         CharSequence var3 = var1.getText();
         if (TextUtils.isEmpty(var3)) {
            var1.setText(var2);
         } else {
            StringBuilder var4 = new StringBuilder();
            var4.append(var3).append(' ').append(var2);
            var1.setText(var4);
         }
      }
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      byte var6 = 0;
      super.onLayout(var1, var2, var3, var4, var5);
      if (this.c != null) {
         Rect var8 = this.M;
         if (this.h != null) {
            this.h.getPadding(var8);
         } else {
            var8.setEmpty();
         }

         Rect var7 = DrawableUtils.a(this.c);
         var3 = Math.max(0, var7.left - var8.left);
         var2 = Math.max(0, var7.right - var8.right);
      } else {
         var3 = 0;
         var2 = var6;
      }

      if (ViewUtils.a(this)) {
         var4 = this.getPaddingLeft() + var3;
         var5 = this.A + var4 - var3 - var2;
      } else {
         var5 = this.getWidth() - this.getPaddingRight() - var2;
         var4 = var2 + var3 + (var5 - this.A);
      }

      switch (this.getGravity() & 112) {
         case 16:
            var3 = (this.getPaddingTop() + this.getHeight() - this.getPaddingBottom()) / 2 - this.B / 2;
            var2 = this.B + var3;
            break;
         case 80:
            var2 = this.getHeight() - this.getPaddingBottom();
            var3 = var2 - this.B;
            break;
         default:
            var3 = this.getPaddingTop();
            var2 = this.B + var3;
      }

      this.D = var4;
      this.E = var3;
      this.G = var2;
      this.F = var5;
   }

   public void onMeasure(int var1, int var2) {
      int var6 = 0;
      if (this.s) {
         if (this.J == null) {
            this.J = this.a(this.q);
         }

         if (this.K == null) {
            this.K = this.a(this.r);
         }
      }

      Rect var9 = this.M;
      int var3;
      int var4;
      if (this.c != null) {
         this.c.getPadding(var9);
         var4 = this.c.getIntrinsicWidth() - var9.left - var9.right;
         var3 = this.c.getIntrinsicHeight();
      } else {
         var3 = 0;
         var4 = 0;
      }

      int var5;
      if (this.s) {
         var5 = Math.max(this.J.getWidth(), this.K.getWidth()) + this.m * 2;
      } else {
         var5 = 0;
      }

      this.C = Math.max(var5, var4);
      if (this.h != null) {
         this.h.getPadding(var9);
         var4 = this.h.getIntrinsicHeight();
      } else {
         var9.setEmpty();
         var4 = var6;
      }

      int var8 = var9.left;
      int var7 = var9.right;
      var6 = var7;
      var5 = var8;
      if (this.c != null) {
         var9 = DrawableUtils.a(this.c);
         var5 = Math.max(var8, var9.left);
         var6 = Math.max(var7, var9.right);
      }

      var5 = Math.max(this.n, var6 + var5 + this.C * 2);
      var3 = Math.max(var4, var3);
      this.A = var5;
      this.B = var3;
      super.onMeasure(var1, var2);
      if (this.getMeasuredHeight() < var3) {
         this.setMeasuredDimension(this.getMeasuredWidthAndState(), var3);
      }
   }

   public void onPopulateAccessibilityEvent(AccessibilityEvent var1) {
      super.onPopulateAccessibilityEvent(var1);
      CharSequence var2;
      if (this.isChecked()) {
         var2 = this.q;
      } else {
         var2 = this.r;
      }

      if (var2 != null) {
         var1.getText().add(var2);
      }
   }

   public boolean onTouchEvent(MotionEvent var1) {
      this.x.addMovement(var1);
      switch (var1.getActionMasked()) {
         case 0:
            float var10 = var1.getX();
            float var12 = var1.getY();
            if (this.isEnabled() && this.a(var10, var12)) {
               this.t = 1;
               this.v = var10;
               this.w = var12;
            }
            break;
         case 1:
         case 3:
            if (this.t == 2) {
               this.b(var1);
               super.onTouchEvent(var1);
               return true;
            }

            this.t = 0;
            this.x.clear();
            break;
         case 2:
            switch (this.t) {
               case 0:
               default:
                  break;
               case 1:
                  float var11 = var1.getX();
                  float var9 = var1.getY();
                  if (!(Math.abs(var11 - this.v) > this.u) && !(Math.abs(var9 - this.w) > this.u)) {
                     break;
                  }

                  this.t = 2;
                  this.getParent().requestDisallowInterceptTouchEvent(true);
                  this.v = var11;
                  this.w = var9;
                  return true;
               case 2:
                  float var4 = var1.getX();
                  int var5 = this.getThumbScrollRange();
                  float var2 = var4 - this.v;
                  if (var5 != 0) {
                     var2 /= var5;
                  } else if (var2 > 0.0F) {
                     var2 = 1.0F;
                  } else {
                     var2 = -1.0F;
                  }

                  float var3 = var2;
                  if (ViewUtils.a(this)) {
                     var3 = -var2;
                  }

                  var2 = a(var3 + this.z, 0.0F, 1.0F);
                  if (var2 != this.z) {
                     this.v = var4;
                     this.setThumbPosition(var2);
                  }

                  return true;
            }
      }

      return super.onTouchEvent(var1);
   }

   public void setChecked(boolean var1) {
      super.setChecked(var1);
      var1 = this.isChecked();
      if (this.getWindowToken() != null && ViewCompat.y(this)) {
         this.a(var1);
      } else {
         this.c();
         float var2;
         if (var1) {
            var2 = 1.0F;
         } else {
            var2 = 0.0F;
         }

         this.setThumbPosition(var2);
      }
   }

   public void setShowText(boolean var1) {
      if (this.s != var1) {
         this.s = var1;
         this.requestLayout();
      }
   }

   public void setSplitTrack(boolean var1) {
      this.p = var1;
      this.invalidate();
   }

   public void setSwitchMinWidth(int var1) {
      this.n = var1;
      this.requestLayout();
   }

   public void setSwitchPadding(int var1) {
      this.o = var1;
      this.requestLayout();
   }

   public void setSwitchTypeface(Typeface var1) {
      if (this.H.getTypeface() != null && !this.H.getTypeface().equals(var1) || this.H.getTypeface() == null && var1 != null) {
         this.H.setTypeface(var1);
         this.requestLayout();
         this.invalidate();
      }
   }

   public void setTextOff(CharSequence var1) {
      this.r = var1;
      this.requestLayout();
   }

   public void setTextOn(CharSequence var1) {
      this.q = var1;
      this.requestLayout();
   }

   public void setThumbDrawable(Drawable var1) {
      if (this.c != null) {
         this.c.setCallback(null);
      }

      this.c = var1;
      if (var1 != null) {
         var1.setCallback(this);
      }

      this.requestLayout();
   }

   void setThumbPosition(float var1) {
      this.z = var1;
      this.invalidate();
   }

   public void setThumbResource(int var1) {
      this.setThumbDrawable(AppCompatResources.b(this.getContext(), var1));
   }

   public void setThumbTextPadding(int var1) {
      this.m = var1;
      this.requestLayout();
   }

   public void setThumbTintList(ColorStateList var1) {
      this.d = var1;
      this.f = true;
      this.b();
   }

   public void setThumbTintMode(Mode var1) {
      this.e = var1;
      this.g = true;
      this.b();
   }

   public void setTrackDrawable(Drawable var1) {
      if (this.h != null) {
         this.h.setCallback(null);
      }

      this.h = var1;
      if (var1 != null) {
         var1.setCallback(this);
      }

      this.requestLayout();
   }

   public void setTrackResource(int var1) {
      this.setTrackDrawable(AppCompatResources.b(this.getContext(), var1));
   }

   public void setTrackTintList(ColorStateList var1) {
      this.i = var1;
      this.k = true;
      this.a();
   }

   public void setTrackTintMode(Mode var1) {
      this.j = var1;
      this.l = true;
      this.a();
   }

   public void toggle() {
      boolean var1;
      if (!this.isChecked()) {
         var1 = true;
      } else {
         var1 = false;
      }

      this.setChecked(var1);
   }

   protected boolean verifyDrawable(Drawable var1) {
      boolean var2;
      if (!super.verifyDrawable(var1) && var1 != this.c && var1 != this.h) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }
}
