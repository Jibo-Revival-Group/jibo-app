package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.R;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.Space;
import android.support.v4.widget.TextViewCompat;
import android.support.v4.widget.ViewGroupUtils;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.WithHint;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.View.OnClickListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class TextInputLayout extends LinearLayout implements WithHint {
   private boolean A;
   private Drawable B;
   private Drawable C;
   private ColorStateList D;
   private boolean E;
   private Mode F;
   private boolean G;
   private ColorStateList H;
   private ColorStateList I;
   private boolean J;
   private boolean K;
   private ValueAnimator L;
   private boolean M;
   private boolean N;
   private boolean O;
   EditText a;
   TextView b;
   boolean c;
   final CollapsingTextHelper d;
   private final FrameLayout e;
   private CharSequence f;
   private boolean g;
   private CharSequence h;
   private Paint i;
   private final Rect j = new Rect();
   private LinearLayout k;
   private int l;
   private Typeface m;
   private boolean n;
   private int o;
   private boolean p;
   private CharSequence q;
   private TextView r;
   private int s;
   private int t;
   private int u;
   private boolean v;
   private boolean w;
   private Drawable x;
   private CharSequence y;
   private CheckableImageButton z;

   public TextInputLayout(Context var1) {
      this(var1, null);
   }

   public TextInputLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public TextInputLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2);
      this.d = new CollapsingTextHelper(this);
      ThemeUtils.a(var1);
      this.setOrientation(1);
      this.setWillNotDraw(false);
      this.setAddStatesFromChildren(true);
      this.e = new FrameLayout(var1);
      this.e.setAddStatesFromChildren(true);
      this.addView(this.e);
      this.d.a(AnimationUtils.b);
      this.d.b(new AccelerateInterpolator());
      this.d.b(8388659);
      TintTypedArray var7 = TintTypedArray.a(var1, var2, R.styleable.TextInputLayout, var3, R.style.Widget_Design_TextInputLayout);
      this.g = var7.a(R.styleable.TextInputLayout_hintEnabled, true);
      this.setHint(var7.c(R.styleable.TextInputLayout_android_hint));
      this.K = var7.a(R.styleable.TextInputLayout_hintAnimationEnabled, true);
      if (var7.g(R.styleable.TextInputLayout_android_textColorHint)) {
         ColorStateList var6 = var7.e(R.styleable.TextInputLayout_android_textColorHint);
         this.I = var6;
         this.H = var6;
      }

      if (var7.g(R.styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
         this.setHintTextAppearance(var7.g(R.styleable.TextInputLayout_hintTextAppearance, 0));
      }

      this.o = var7.g(R.styleable.TextInputLayout_errorTextAppearance, 0);
      boolean var4 = var7.a(R.styleable.TextInputLayout_errorEnabled, false);
      boolean var5 = var7.a(R.styleable.TextInputLayout_counterEnabled, false);
      this.setCounterMaxLength(var7.a(R.styleable.TextInputLayout_counterMaxLength, -1));
      this.t = var7.g(R.styleable.TextInputLayout_counterTextAppearance, 0);
      this.u = var7.g(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
      this.w = var7.a(R.styleable.TextInputLayout_passwordToggleEnabled, false);
      this.x = var7.a(R.styleable.TextInputLayout_passwordToggleDrawable);
      this.y = var7.c(R.styleable.TextInputLayout_passwordToggleContentDescription);
      if (var7.g(R.styleable.TextInputLayout_passwordToggleTint)) {
         this.E = true;
         this.D = var7.e(R.styleable.TextInputLayout_passwordToggleTint);
      }

      if (var7.g(R.styleable.TextInputLayout_passwordToggleTintMode)) {
         this.G = true;
         this.F = ViewUtils.a(var7.a(R.styleable.TextInputLayout_passwordToggleTintMode, -1), null);
      }

      var7.a();
      this.setErrorEnabled(var4);
      this.setCounterEnabled(var5);
      this.h();
      if (ViewCompat.d(this) == 0) {
         ViewCompat.a(this, 1);
      }

      ViewCompat.a(this, new TextInputLayout.TextInputAccessibilityDelegate(this));
   }

   private void a() {
      LayoutParams var2 = (LayoutParams)this.e.getLayoutParams();
      int var1;
      if (this.g) {
         if (this.i == null) {
            this.i = new Paint();
         }

         this.i.setTypeface(this.d.d());
         this.i.setTextSize(this.d.h());
         var1 = (int)(-this.i.ascent());
      } else {
         var1 = 0;
      }

      if (var1 != var2.topMargin) {
         var2.topMargin = var1;
         this.e.requestLayout();
      }
   }

   private static void a(ViewGroup var0, boolean var1) {
      int var3 = var0.getChildCount();

      for (int var2 = 0; var2 < var3; var2++) {
         View var4 = var0.getChildAt(var2);
         var4.setEnabled(var1);
         if (var4 instanceof ViewGroup) {
            a((ViewGroup)var4, var1);
         }
      }
   }

   private void a(TextView var1) {
      if (this.k != null) {
         this.k.removeView(var1);
         int var2 = this.l - 1;
         this.l = var2;
         if (var2 == 0) {
            this.k.setVisibility(8);
         }
      }
   }

   private void a(TextView var1, int var2) {
      if (this.k == null) {
         this.k = new LinearLayout(this.getContext());
         this.k.setOrientation(0);
         this.addView(this.k, -1, -2);
         Space var4 = new Space(this.getContext());
         LayoutParams var3 = new LayoutParams(0, 0, 1.0F);
         this.k.addView(var4, var3);
         if (this.a != null) {
            this.b();
         }
      }

      this.k.setVisibility(0);
      this.k.addView(var1, var2);
      this.l++;
   }

   private void a(CharSequence var1, boolean var2) {
      boolean var3 = true;
      this.q = var1;
      if (!this.n) {
         if (TextUtils.isEmpty(var1)) {
            return;
         }

         this.setErrorEnabled(true);
      }

      if (TextUtils.isEmpty(var1)) {
         var3 = false;
      }

      this.p = var3;
      this.b.animate().cancel();
      if (this.p) {
         this.b.setText(var1);
         this.b.setVisibility(0);
         if (var2) {
            if (this.b.getAlpha() == 1.0F) {
               this.b.setAlpha(0.0F);
            }

            this.b.animate().alpha(1.0F).setDuration(200L).setInterpolator(AnimationUtils.d).setListener(new AnimatorListenerAdapter(this) {
               final TextInputLayout a;

               {
                  this.a = var1;
               }

               public void onAnimationStart(Animator var1) {
                  this.a.b.setVisibility(0);
               }
            }).start();
         } else {
            this.b.setAlpha(1.0F);
         }
      } else if (this.b.getVisibility() == 0) {
         if (var2) {
            this.b.animate().alpha(0.0F).setDuration(200L).setInterpolator(AnimationUtils.c).setListener(new AnimatorListenerAdapter(this, var1) {
               final CharSequence a;
               final TextInputLayout b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               public void onAnimationEnd(Animator var1) {
                  this.b.b.setText(this.a);
                  this.b.b.setVisibility(4);
               }
            }).start();
         } else {
            this.b.setText(var1);
            this.b.setVisibility(4);
         }
      }

      this.c();
      this.a(var2);
   }

   private static boolean a(int[] var0, int var1) {
      boolean var5 = false;
      int var3 = var0.length;
      int var2 = 0;

      boolean var4;
      while (true) {
         var4 = var5;
         if (var2 >= var3) {
            break;
         }

         if (var0[var2] == var1) {
            var4 = true;
            break;
         }

         var2++;
      }

      return var4;
   }

   private void b() {
      ViewCompat.b(this.k, ViewCompat.g(this.a), 0, ViewCompat.h(this.a), this.a.getPaddingBottom());
   }

   private void b(boolean var1) {
      if (this.w) {
         int var2 = this.a.getSelectionEnd();
         if (this.f()) {
            this.a.setTransformationMethod(null);
            this.A = true;
         } else {
            this.a.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.A = false;
         }

         this.z.setChecked(this.A);
         if (var1) {
            this.z.jumpDrawablesToCurrentState();
         }

         this.a.setSelection(var2);
      }
   }

   private void c() {
      if (this.a != null) {
         Drawable var2 = this.a.getBackground();
         if (var2 != null) {
            this.d();
            Drawable var1 = var2;
            if (android.support.v7.widget.DrawableUtils.c(var2)) {
               var1 = var2.mutate();
            }

            if (this.p && this.b != null) {
               var1.setColorFilter(AppCompatDrawableManager.a(this.b.getCurrentTextColor(), Mode.SRC_IN));
            } else if (this.v && this.r != null) {
               var1.setColorFilter(AppCompatDrawableManager.a(this.r.getCurrentTextColor(), Mode.SRC_IN));
            } else {
               DrawableCompat.f(var1);
               this.a.refreshDrawableState();
            }
         }
      }
   }

   private void c(boolean var1) {
      if (this.L != null && this.L.isRunning()) {
         this.L.cancel();
      }

      if (var1 && this.K) {
         this.a(1.0F);
      } else {
         this.d.b(1.0F);
      }

      this.J = false;
   }

   private void d() {
      int var1 = VERSION.SDK_INT;
      if (var1 == 21 || var1 == 22) {
         Drawable var2 = this.a.getBackground();
         if (var2 != null && !this.M) {
            Drawable var3 = var2.getConstantState().newDrawable();
            if (var2 instanceof DrawableContainer) {
               this.M = DrawableUtils.a((DrawableContainer)var2, var3.getConstantState());
            }

            if (!this.M) {
               ViewCompat.a(this.a, var3);
               this.M = true;
            }
         }
      }
   }

   private void d(boolean var1) {
      if (this.L != null && this.L.isRunning()) {
         this.L.cancel();
      }

      if (var1 && this.K) {
         this.a(0.0F);
      } else {
         this.d.b(0.0F);
      }

      this.J = true;
   }

   private void e() {
      if (this.a != null) {
         if (this.g()) {
            if (this.z == null) {
               this.z = (CheckableImageButton)LayoutInflater.from(this.getContext()).inflate(R.layout.design_text_input_password_icon, this.e, false);
               this.z.setImageDrawable(this.x);
               this.z.setContentDescription(this.y);
               this.e.addView(this.z);
               this.z.setOnClickListener(new OnClickListener(this) {
                  final TextInputLayout a;

                  {
                     this.a = var1;
                  }

                  public void onClick(View var1) {
                     this.a.b(false);
                  }
               });
            }

            if (this.a != null && ViewCompat.k(this.a) <= 0) {
               this.a.setMinimumHeight(ViewCompat.k(this.z));
            }

            this.z.setVisibility(0);
            this.z.setChecked(this.A);
            if (this.B == null) {
               this.B = new ColorDrawable();
            }

            this.B.setBounds(0, 0, this.z.getMeasuredWidth(), 1);
            Drawable[] var1 = TextViewCompat.b(this.a);
            if (var1[2] != this.B) {
               this.C = var1[2];
            }

            TextViewCompat.a(this.a, var1[0], var1[1], this.B, var1[3]);
            this.z.setPadding(this.a.getPaddingLeft(), this.a.getPaddingTop(), this.a.getPaddingRight(), this.a.getPaddingBottom());
         } else {
            if (this.z != null && this.z.getVisibility() == 0) {
               this.z.setVisibility(8);
            }

            if (this.B != null) {
               Drawable[] var2 = TextViewCompat.b(this.a);
               if (var2[2] == this.B) {
                  TextViewCompat.a(this.a, var2[0], var2[1], this.C, var2[3]);
                  this.B = null;
               }
            }
         }
      }
   }

   private boolean f() {
      boolean var1;
      if (this.a != null && this.a.getTransformationMethod() instanceof PasswordTransformationMethod) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private boolean g() {
      boolean var1;
      if (!this.w || !this.f() && !this.A) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   private void h() {
      if (this.x != null && (this.E || this.G)) {
         this.x = DrawableCompat.g(this.x).mutate();
         if (this.E) {
            DrawableCompat.a(this.x, this.D);
         }

         if (this.G) {
            DrawableCompat.a(this.x, this.F);
         }

         if (this.z != null && this.z.getDrawable() != this.x) {
            this.z.setImageDrawable(this.x);
         }
      }
   }

   private void setEditText(EditText var1) {
      if (this.a != null) {
         throw new IllegalArgumentException("We already have an EditText, can only have one");
      }

      if (!(var1 instanceof TextInputEditText)) {
         Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
      }

      this.a = var1;
      if (!this.f()) {
         this.d.c(this.a.getTypeface());
      }

      this.d.a(this.a.getTextSize());
      int var2 = this.a.getGravity();
      this.d.b(var2 & -113 | 48);
      this.d.a(var2);
      this.a.addTextChangedListener(new TextWatcher(this) {
         final TextInputLayout a;

         {
            this.a = var1;
         }

         public void afterTextChanged(Editable var1) {
            TextInputLayout var3 = this.a;
            boolean var2x;
            if (!this.a.O) {
               var2x = true;
            } else {
               var2x = false;
            }

            var3.a(var2x);
            if (this.a.c) {
               this.a.a(var1.length());
            }
         }

         public void beforeTextChanged(CharSequence var1, int var2x, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2x, int var3, int var4) {
         }
      });
      if (this.H == null) {
         this.H = this.a.getHintTextColors();
      }

      if (this.g && TextUtils.isEmpty(this.h)) {
         this.f = this.a.getHint();
         this.setHint(this.f);
         this.a.setHint(null);
      }

      if (this.r != null) {
         this.a(this.a.getText().length());
      }

      if (this.k != null) {
         this.b();
      }

      this.e();
      this.a(false, true);
   }

   private void setHintInternal(CharSequence var1) {
      this.h = var1;
      this.d.a(var1);
   }

   void a(float var1) {
      if (this.d.g() != var1) {
         if (this.L == null) {
            this.L = new ValueAnimator();
            this.L.setInterpolator(AnimationUtils.a);
            this.L.setDuration(200L);
            this.L.addUpdateListener(new AnimatorUpdateListener(this) {
               final TextInputLayout a;

               {
                  this.a = var1;
               }

               public void onAnimationUpdate(ValueAnimator var1) {
                  this.a.d.b((Float)var1.getAnimatedValue());
               }
            });
         }

         this.L.setFloatValues(new float[]{this.d.g(), var1});
         this.L.start();
      }
   }

   void a(int var1) {
      boolean var4 = this.v;
      if (this.s == -1) {
         this.r.setText(String.valueOf(var1));
         this.v = false;
      } else {
         boolean var3;
         if (var1 > this.s) {
            var3 = true;
         } else {
            var3 = false;
         }

         this.v = var3;
         if (var4 != this.v) {
            TextView var5 = this.r;
            int var2;
            if (this.v) {
               var2 = this.u;
            } else {
               var2 = this.t;
            }

            TextViewCompat.a(var5, var2);
         }

         this.r.setText(this.getContext().getString(R.string.character_counter_pattern, new Object[]{var1, this.s}));
      }

      if (this.a != null && var4 != this.v) {
         this.a(false);
         this.c();
      }
   }

   void a(boolean var1) {
      this.a(var1, false);
   }

   void a(boolean var1, boolean var2) {
      boolean var4 = true;
      boolean var5 = this.isEnabled();
      boolean var3;
      if (this.a != null && !TextUtils.isEmpty(this.a.getText())) {
         var3 = true;
      } else {
         var3 = false;
      }

      boolean var6 = a(this.getDrawableState(), 16842908);
      if (TextUtils.isEmpty(this.getError())) {
         var4 = false;
      }

      if (this.H != null) {
         this.d.b(this.H);
      }

      if (var5 && this.v && this.r != null) {
         this.d.a(this.r.getTextColors());
      } else if (var5 && var6 && this.I != null) {
         this.d.a(this.I);
      } else if (this.H != null) {
         this.d.a(this.H);
      }

      if (var3 || this.isEnabled() && (var6 || var4)) {
         if (var2 || this.J) {
            this.c(var1);
         }
      } else if (var2 || !this.J) {
         this.d(var1);
      }
   }

   public void addView(View var1, int var2, android.view.ViewGroup.LayoutParams var3) {
      if (var1 instanceof EditText) {
         android.widget.FrameLayout.LayoutParams var4 = new android.widget.FrameLayout.LayoutParams(var3);
         var4.gravity = var4.gravity & -113 | 16;
         this.e.addView(var1, var4);
         this.e.setLayoutParams(var3);
         this.a();
         this.setEditText((EditText)var1);
      } else {
         super.addView(var1, var2, var3);
      }
   }

   public void dispatchProvideAutofillStructure(ViewStructure var1, int var2) {
      if (this.f != null && this.a != null) {
         CharSequence var3 = this.a.getHint();
         this.a.setHint(this.f);

         try {
            super.dispatchProvideAutofillStructure(var1, var2);
         } finally {
            this.a.setHint(var3);
         }
      } else {
         super.dispatchProvideAutofillStructure(var1, var2);
      }
   }

   protected void dispatchRestoreInstanceState(SparseArray<Parcelable> var1) {
      this.O = true;
      super.dispatchRestoreInstanceState(var1);
      this.O = false;
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      if (this.g) {
         this.d.a(var1);
      }
   }

   protected void drawableStateChanged() {
      boolean var2 = true;
      if (!this.N) {
         this.N = true;
         super.drawableStateChanged();
         int[] var3 = this.getDrawableState();
         if (!ViewCompat.y(this) || !this.isEnabled()) {
            var2 = false;
         }

         this.a(var2);
         this.c();
         boolean var1;
         if (this.d != null) {
            var1 = this.d.a(var3) | false;
         } else {
            var1 = false;
         }

         if (var1) {
            this.invalidate();
         }

         this.N = false;
      }
   }

   public int getCounterMaxLength() {
      return this.s;
   }

   public EditText getEditText() {
      return this.a;
   }

   public CharSequence getError() {
      CharSequence var1;
      if (this.n) {
         var1 = this.q;
      } else {
         var1 = null;
      }

      return var1;
   }

   @Override
   public CharSequence getHint() {
      CharSequence var1;
      if (this.g) {
         var1 = this.h;
      } else {
         var1 = null;
      }

      return var1;
   }

   public CharSequence getPasswordVisibilityToggleContentDescription() {
      return this.y;
   }

   public Drawable getPasswordVisibilityToggleDrawable() {
      return this.x;
   }

   public Typeface getTypeface() {
      return this.m;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      if (this.g && this.a != null) {
         Rect var6 = this.j;
         ViewGroupUtils.b(this, this.a, var6);
         var2 = var6.left + this.a.getCompoundPaddingLeft();
         var4 = var6.right - this.a.getCompoundPaddingRight();
         this.d.a(var2, var6.top + this.a.getCompoundPaddingTop(), var4, var6.bottom - this.a.getCompoundPaddingBottom());
         this.d.b(var2, this.getPaddingTop(), var4, var5 - var3 - this.getPaddingBottom());
         this.d.i();
      }
   }

   protected void onMeasure(int var1, int var2) {
      this.e();
      super.onMeasure(var1, var2);
   }

   protected void onRestoreInstanceState(Parcelable var1) {
      if (!(var1 instanceof TextInputLayout.SavedState)) {
         super.onRestoreInstanceState(var1);
      } else {
         var1 = var1;
         super.onRestoreInstanceState(var1.a());
         this.setError(var1.a);
         if (var1.b) {
            this.b(true);
         }

         this.requestLayout();
      }
   }

   public Parcelable onSaveInstanceState() {
      TextInputLayout.SavedState var1 = new TextInputLayout.SavedState(super.onSaveInstanceState());
      if (this.p) {
         var1.a = this.getError();
      }

      var1.b = this.A;
      return var1;
   }

   public void setCounterEnabled(boolean var1) {
      if (this.c != var1) {
         if (var1) {
            this.r = new AppCompatTextView(this.getContext());
            this.r.setId(R.id.textinput_counter);
            if (this.m != null) {
               this.r.setTypeface(this.m);
            }

            this.r.setMaxLines(1);

            try {
               TextViewCompat.a(this.r, this.t);
            } catch (Exception var3) {
               TextViewCompat.a(this.r, android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Caption);
               this.r.setTextColor(ContextCompat.c(this.getContext(), android.support.v7.appcompat.R.color.error_color_material));
            }

            this.a(this.r, -1);
            if (this.a == null) {
               this.a(0);
            } else {
               this.a(this.a.getText().length());
            }
         } else {
            this.a(this.r);
            this.r = null;
         }

         this.c = var1;
      }
   }

   public void setCounterMaxLength(int var1) {
      if (this.s != var1) {
         if (var1 > 0) {
            this.s = var1;
         } else {
            this.s = -1;
         }

         if (this.c) {
            if (this.a == null) {
               var1 = 0;
            } else {
               var1 = this.a.getText().length();
            }

            this.a(var1);
         }
      }
   }

   public void setEnabled(boolean var1) {
      a((ViewGroup)this, var1);
      super.setEnabled(var1);
   }

   public void setError(CharSequence var1) {
      boolean var2;
      if (!ViewCompat.y(this) || !this.isEnabled() || this.b != null && TextUtils.equals(this.b.getText(), var1)) {
         var2 = false;
      } else {
         var2 = true;
      }

      this.a(var1, var2);
   }

   public void setErrorEnabled(boolean var1) {
      if (this.n != var1) {
         if (this.b != null) {
            this.b.animate().cancel();
         }

         if (var1) {
            this.b = new AppCompatTextView(this.getContext());
            this.b.setId(R.id.textinput_error);
            if (this.m != null) {
               this.b.setTypeface(this.m);
            }

            int var2;
            label36: {
               label35: {
                  try {
                     TextViewCompat.a(this.b, this.o);
                     if (VERSION.SDK_INT < 23) {
                        break label35;
                     }

                     var2 = this.b.getTextColors().getDefaultColor();
                  } catch (Exception var4) {
                     var2 = 1;
                     break label36;
                  }

                  if (var2 == -65281) {
                     var2 = 1;
                     break label36;
                  }
               }

               var2 = 0;
            }

            if (var2) {
               TextViewCompat.a(this.b, android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Caption);
               this.b.setTextColor(ContextCompat.c(this.getContext(), android.support.v7.appcompat.R.color.error_color_material));
            }

            this.b.setVisibility(4);
            ViewCompat.b(this.b, 1);
            this.a(this.b, 0);
         } else {
            this.p = false;
            this.c();
            this.a(this.b);
            this.b = null;
         }

         this.n = var1;
      }
   }

   public void setErrorTextAppearance(int var1) {
      this.o = var1;
      if (this.b != null) {
         TextViewCompat.a(this.b, var1);
      }
   }

   public void setHint(CharSequence var1) {
      if (this.g) {
         this.setHintInternal(var1);
         this.sendAccessibilityEvent(2048);
      }
   }

   public void setHintAnimationEnabled(boolean var1) {
      this.K = var1;
   }

   public void setHintEnabled(boolean var1) {
      if (var1 != this.g) {
         this.g = var1;
         CharSequence var2 = this.a.getHint();
         if (!this.g) {
            if (!TextUtils.isEmpty(this.h) && TextUtils.isEmpty(var2)) {
               this.a.setHint(this.h);
            }

            this.setHintInternal(null);
         } else if (!TextUtils.isEmpty(var2)) {
            if (TextUtils.isEmpty(this.h)) {
               this.setHint(var2);
            }

            this.a.setHint(null);
         }

         if (this.a != null) {
            this.a();
         }
      }
   }

   public void setHintTextAppearance(int var1) {
      this.d.c(var1);
      this.I = this.d.k();
      if (this.a != null) {
         this.a(false);
         this.a();
      }
   }

   public void setPasswordVisibilityToggleContentDescription(int var1) {
      CharSequence var2;
      if (var1 != 0) {
         var2 = this.getResources().getText(var1);
      } else {
         var2 = null;
      }

      this.setPasswordVisibilityToggleContentDescription(var2);
   }

   public void setPasswordVisibilityToggleContentDescription(CharSequence var1) {
      this.y = var1;
      if (this.z != null) {
         this.z.setContentDescription(var1);
      }
   }

   public void setPasswordVisibilityToggleDrawable(int var1) {
      Drawable var2;
      if (var1 != 0) {
         var2 = AppCompatResources.b(this.getContext(), var1);
      } else {
         var2 = null;
      }

      this.setPasswordVisibilityToggleDrawable(var2);
   }

   public void setPasswordVisibilityToggleDrawable(Drawable var1) {
      this.x = var1;
      if (this.z != null) {
         this.z.setImageDrawable(var1);
      }
   }

   public void setPasswordVisibilityToggleEnabled(boolean var1) {
      if (this.w != var1) {
         this.w = var1;
         if (!var1 && this.A && this.a != null) {
            this.a.setTransformationMethod(PasswordTransformationMethod.getInstance());
         }

         this.A = false;
         this.e();
      }
   }

   public void setPasswordVisibilityToggleTintList(ColorStateList var1) {
      this.D = var1;
      this.E = true;
      this.h();
   }

   public void setPasswordVisibilityToggleTintMode(Mode var1) {
      this.F = var1;
      this.G = true;
      this.h();
   }

   public void setTypeface(Typeface var1) {
      if (this.m != null && !this.m.equals(var1) || this.m == null && var1 != null) {
         this.m = var1;
         this.d.c(var1);
         if (this.r != null) {
            this.r.setTypeface(var1);
         }

         if (this.b != null) {
            this.b.setTypeface(var1);
         }
      }
   }

   static class SavedState extends AbsSavedState {
      public static final Creator<TextInputLayout.SavedState> CREATOR = new ClassLoaderCreator<TextInputLayout.SavedState>() {
         public TextInputLayout.SavedState a(Parcel var1) {
            return new TextInputLayout.SavedState(var1, null);
         }

         public TextInputLayout.SavedState a(Parcel var1, ClassLoader var2) {
            return new TextInputLayout.SavedState(var1, var2);
         }

         public TextInputLayout.SavedState[] a(int var1) {
            return new TextInputLayout.SavedState[var1];
         }
      };
      CharSequence a;
      boolean b;

      SavedState(Parcel var1, ClassLoader var2) {
         super(var1, var2);
         this.a = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
         boolean var3;
         if (var1.readInt() == 1) {
            var3 = true;
         } else {
            var3 = false;
         }

         this.b = var3;
      }

      SavedState(Parcelable var1) {
         super(var1);
      }

      @Override
      public String toString() {
         return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.a + "}";
      }

      @Override
      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         TextUtils.writeToParcel(this.a, var1, var2);
         byte var3;
         if (this.b) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         var1.writeInt(var3);
      }
   }

   private class TextInputAccessibilityDelegate extends AccessibilityDelegateCompat {
      final TextInputLayout a;

      TextInputAccessibilityDelegate(TextInputLayout var1) {
         this.a = var1;
      }

      @Override
      public void a(View var1, AccessibilityNodeInfoCompat var2) {
         super.a(var1, var2);
         var2.b(TextInputLayout.class.getSimpleName());
         CharSequence var3 = this.a.d.j();
         if (!TextUtils.isEmpty(var3)) {
            var2.c(var3);
         }

         if (this.a.a != null) {
            var2.d(this.a.a);
         }

         CharSequence var4;
         if (this.a.b != null) {
            var4 = this.a.b.getText();
         } else {
            var4 = null;
         }

         if (!TextUtils.isEmpty(var4)) {
            var2.l(true);
            var2.e(var4);
         }
      }

      @Override
      public void a(View var1, AccessibilityEvent var2) {
         super.a(var1, var2);
         var2.setClassName(TextInputLayout.class.getSimpleName());
      }

      @Override
      public void b(View var1, AccessibilityEvent var2) {
         super.b(var1, var2);
         CharSequence var3 = this.a.d.j();
         if (!TextUtils.isEmpty(var3)) {
            var2.getText().add(var3);
         }
      }
   }
}
