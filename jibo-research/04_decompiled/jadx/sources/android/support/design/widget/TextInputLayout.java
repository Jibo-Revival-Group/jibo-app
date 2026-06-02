package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
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
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout implements WithHint {

    /* JADX INFO: renamed from: A */
    private boolean f919A;

    /* JADX INFO: renamed from: B */
    private Drawable f920B;

    /* JADX INFO: renamed from: C */
    private Drawable f921C;

    /* JADX INFO: renamed from: D */
    private ColorStateList f922D;

    /* JADX INFO: renamed from: E */
    private boolean f923E;

    /* JADX INFO: renamed from: F */
    private PorterDuff.Mode f924F;

    /* JADX INFO: renamed from: G */
    private boolean f925G;

    /* JADX INFO: renamed from: H */
    private ColorStateList f926H;

    /* JADX INFO: renamed from: I */
    private ColorStateList f927I;

    /* JADX INFO: renamed from: J */
    private boolean f928J;

    /* JADX INFO: renamed from: K */
    private boolean f929K;

    /* JADX INFO: renamed from: L */
    private ValueAnimator f930L;

    /* JADX INFO: renamed from: M */
    private boolean f931M;

    /* JADX INFO: renamed from: N */
    private boolean f932N;

    /* JADX INFO: renamed from: O */
    private boolean f933O;

    /* JADX INFO: renamed from: a */
    EditText f934a;

    /* JADX INFO: renamed from: b */
    TextView f935b;

    /* JADX INFO: renamed from: c */
    boolean f936c;

    /* JADX INFO: renamed from: d */
    final CollapsingTextHelper f937d;

    /* JADX INFO: renamed from: e */
    private final FrameLayout f938e;

    /* JADX INFO: renamed from: f */
    private CharSequence f939f;

    /* JADX INFO: renamed from: g */
    private boolean f940g;

    /* JADX INFO: renamed from: h */
    private CharSequence f941h;

    /* JADX INFO: renamed from: i */
    private Paint f942i;

    /* JADX INFO: renamed from: j */
    private final Rect f943j;

    /* JADX INFO: renamed from: k */
    private LinearLayout f944k;

    /* JADX INFO: renamed from: l */
    private int f945l;

    /* JADX INFO: renamed from: m */
    private Typeface f946m;

    /* JADX INFO: renamed from: n */
    private boolean f947n;

    /* JADX INFO: renamed from: o */
    private int f948o;

    /* JADX INFO: renamed from: p */
    private boolean f949p;

    /* JADX INFO: renamed from: q */
    private CharSequence f950q;

    /* JADX INFO: renamed from: r */
    private TextView f951r;

    /* JADX INFO: renamed from: s */
    private int f952s;

    /* JADX INFO: renamed from: t */
    private int f953t;

    /* JADX INFO: renamed from: u */
    private int f954u;

    /* JADX INFO: renamed from: v */
    private boolean f955v;

    /* JADX INFO: renamed from: w */
    private boolean f956w;

    /* JADX INFO: renamed from: x */
    private Drawable f957x;

    /* JADX INFO: renamed from: y */
    private CharSequence f958y;

    /* JADX INFO: renamed from: z */
    private CheckableImageButton f959z;

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f943j = new Rect();
        this.f937d = new CollapsingTextHelper(this);
        ThemeUtils.m940a(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.f938e = new FrameLayout(context);
        this.f938e.setAddStatesFromChildren(true);
        addView(this.f938e);
        this.f937d.m589a(AnimationUtils.f471b);
        this.f937d.m598b(new AccelerateInterpolator());
        this.f937d.m594b(8388659);
        TintTypedArray tintTypedArrayM4955a = TintTypedArray.m4955a(context, attributeSet, R.styleable.TextInputLayout, i, R.style.Widget_Design_TextInputLayout);
        this.f940g = tintTypedArrayM4955a.m4961a(R.styleable.TextInputLayout_hintEnabled, true);
        setHint(tintTypedArrayM4955a.m4965c(R.styleable.TextInputLayout_android_hint));
        this.f929K = tintTypedArrayM4955a.m4961a(R.styleable.TextInputLayout_hintAnimationEnabled, true);
        if (tintTypedArrayM4955a.m4973g(R.styleable.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateListM4969e = tintTypedArrayM4955a.m4969e(R.styleable.TextInputLayout_android_textColorHint);
            this.f927I = colorStateListM4969e;
            this.f926H = colorStateListM4969e;
        }
        if (tintTypedArrayM4955a.m4972g(R.styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(tintTypedArrayM4955a.m4972g(R.styleable.TextInputLayout_hintTextAppearance, 0));
        }
        this.f948o = tintTypedArrayM4955a.m4972g(R.styleable.TextInputLayout_errorTextAppearance, 0);
        boolean zM4961a = tintTypedArrayM4955a.m4961a(R.styleable.TextInputLayout_errorEnabled, false);
        boolean zM4961a2 = tintTypedArrayM4955a.m4961a(R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(tintTypedArrayM4955a.m4957a(R.styleable.TextInputLayout_counterMaxLength, -1));
        this.f953t = tintTypedArrayM4955a.m4972g(R.styleable.TextInputLayout_counterTextAppearance, 0);
        this.f954u = tintTypedArrayM4955a.m4972g(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        this.f956w = tintTypedArrayM4955a.m4961a(R.styleable.TextInputLayout_passwordToggleEnabled, false);
        this.f957x = tintTypedArrayM4955a.m4959a(R.styleable.TextInputLayout_passwordToggleDrawable);
        this.f958y = tintTypedArrayM4955a.m4965c(R.styleable.TextInputLayout_passwordToggleContentDescription);
        if (tintTypedArrayM4955a.m4973g(R.styleable.TextInputLayout_passwordToggleTint)) {
            this.f923E = true;
            this.f922D = tintTypedArrayM4955a.m4969e(R.styleable.TextInputLayout_passwordToggleTint);
        }
        if (tintTypedArrayM4955a.m4973g(R.styleable.TextInputLayout_passwordToggleTintMode)) {
            this.f925G = true;
            this.f924F = ViewUtils.m947a(tintTypedArrayM4955a.m4957a(R.styleable.TextInputLayout_passwordToggleTintMode, -1), null);
        }
        tintTypedArrayM4955a.m4960a();
        setErrorEnabled(zM4961a);
        setCounterEnabled(zM4961a2);
        m931h();
        if (ViewCompat.m2599d(this) == 0) {
            ViewCompat.m2575a((View) this, 1);
        }
        ViewCompat.m2583a(this, new TextInputAccessibilityDelegate());
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
            this.f938e.addView(view, layoutParams2);
            this.f938e.setLayoutParams(layoutParams);
            m914a();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void setTypeface(Typeface typeface) {
        if ((this.f946m != null && !this.f946m.equals(typeface)) || (this.f946m == null && typeface != null)) {
            this.f946m = typeface;
            this.f937d.m601c(typeface);
            if (this.f951r != null) {
                this.f951r.setTypeface(typeface);
            }
            if (this.f935b != null) {
                this.f935b.setTypeface(typeface);
            }
        }
    }

    public Typeface getTypeface() {
        return this.f946m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        if (this.f939f == null || this.f934a == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        CharSequence hint = this.f934a.getHint();
        this.f934a.setHint(this.f939f);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i);
        } finally {
            this.f934a.setHint(hint);
        }
    }

    private void setEditText(EditText editText) {
        if (this.f934a != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (!(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f934a = editText;
        if (!m929f()) {
            this.f937d.m601c(this.f934a.getTypeface());
        }
        this.f937d.m583a(this.f934a.getTextSize());
        int gravity = this.f934a.getGravity();
        this.f937d.m594b((gravity & (-113)) | 48);
        this.f937d.m584a(gravity);
        this.f934a.addTextChangedListener(new TextWatcher() { // from class: android.support.design.widget.TextInputLayout.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                TextInputLayout.this.m934a(!TextInputLayout.this.f933O);
                if (TextInputLayout.this.f936c) {
                    TextInputLayout.this.m933a(editable.length());
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        if (this.f926H == null) {
            this.f926H = this.f934a.getHintTextColors();
        }
        if (this.f940g && TextUtils.isEmpty(this.f941h)) {
            this.f939f = this.f934a.getHint();
            setHint(this.f939f);
            this.f934a.setHint((CharSequence) null);
        }
        if (this.f951r != null) {
            m933a(this.f934a.getText().length());
        }
        if (this.f944k != null) {
            m922b();
        }
        m928e();
        m935a(false, true);
    }

    /* JADX INFO: renamed from: a */
    private void m914a() {
        int i;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f938e.getLayoutParams();
        if (this.f940g) {
            if (this.f942i == null) {
                this.f942i = new Paint();
            }
            this.f942i.setTypeface(this.f937d.m602d());
            this.f942i.setTextSize(this.f937d.m607h());
            i = (int) (-this.f942i.ascent());
        } else {
            i = 0;
        }
        if (i != layoutParams.topMargin) {
            layoutParams.topMargin = i;
            this.f938e.requestLayout();
        }
    }

    /* JADX INFO: renamed from: a */
    void m934a(boolean z) {
        m935a(z, false);
    }

    /* JADX INFO: renamed from: a */
    void m935a(boolean z, boolean z2) {
        boolean zIsEnabled = isEnabled();
        boolean z3 = (this.f934a == null || TextUtils.isEmpty(this.f934a.getText())) ? false : true;
        boolean zM921a = m921a(getDrawableState(), android.R.attr.state_focused);
        boolean z4 = TextUtils.isEmpty(getError()) ? false : true;
        if (this.f926H != null) {
            this.f937d.m596b(this.f926H);
        }
        if (zIsEnabled && this.f955v && this.f951r != null) {
            this.f937d.m586a(this.f951r.getTextColors());
        } else if (zIsEnabled && zM921a && this.f927I != null) {
            this.f937d.m586a(this.f927I);
        } else if (this.f926H != null) {
            this.f937d.m586a(this.f926H);
        }
        if (z3 || (isEnabled() && (zM921a || z4))) {
            if (z2 || this.f928J) {
                m925c(z);
                return;
            }
            return;
        }
        if (z2 || !this.f928J) {
            m927d(z);
        }
    }

    public EditText getEditText() {
        return this.f934a;
    }

    public void setHint(CharSequence charSequence) {
        if (this.f940g) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        this.f941h = charSequence;
        this.f937d.m590a(charSequence);
    }

    @Override // android.support.v7.widget.WithHint
    public CharSequence getHint() {
        if (this.f940g) {
            return this.f941h;
        }
        return null;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.f940g) {
            this.f940g = z;
            CharSequence hint = this.f934a.getHint();
            if (!this.f940g) {
                if (!TextUtils.isEmpty(this.f941h) && TextUtils.isEmpty(hint)) {
                    this.f934a.setHint(this.f941h);
                }
                setHintInternal(null);
            } else if (!TextUtils.isEmpty(hint)) {
                if (TextUtils.isEmpty(this.f941h)) {
                    setHint(hint);
                }
                this.f934a.setHint((CharSequence) null);
            }
            if (this.f934a != null) {
                m914a();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.f937d.m600c(i);
        this.f927I = this.f937d.m610k();
        if (this.f934a != null) {
            m934a(false);
            m914a();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m918a(TextView textView, int i) {
        if (this.f944k == null) {
            this.f944k = new LinearLayout(getContext());
            this.f944k.setOrientation(0);
            addView(this.f944k, -1, -2);
            this.f944k.addView(new Space(getContext()), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f934a != null) {
                m922b();
            }
        }
        this.f944k.setVisibility(0);
        this.f944k.addView(textView, i);
        this.f945l++;
    }

    /* JADX INFO: renamed from: b */
    private void m922b() {
        ViewCompat.m2594b(this.f944k, ViewCompat.m2603g(this.f934a), 0, ViewCompat.m2604h(this.f934a), this.f934a.getPaddingBottom());
    }

    /* JADX INFO: renamed from: a */
    private void m917a(TextView textView) {
        if (this.f944k != null) {
            this.f944k.removeView(textView);
            int i = this.f945l - 1;
            this.f945l = i;
            if (i == 0) {
                this.f944k.setVisibility(8);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setErrorEnabled(boolean r6) {
        /*
            r5 = this;
            r1 = 1
            r2 = 0
            boolean r0 = r5.f947n
            if (r0 == r6) goto L79
            android.widget.TextView r0 = r5.f935b
            if (r0 == 0) goto L13
            android.widget.TextView r0 = r5.f935b
            android.view.ViewPropertyAnimator r0 = r0.animate()
            r0.cancel()
        L13:
            if (r6 == 0) goto L7d
            android.support.v7.widget.AppCompatTextView r0 = new android.support.v7.widget.AppCompatTextView
            android.content.Context r3 = r5.getContext()
            r0.<init>(r3)
            r5.f935b = r0
            android.widget.TextView r0 = r5.f935b
            int r3 = android.support.design.R.id.textinput_error
            r0.setId(r3)
            android.graphics.Typeface r0 = r5.f946m
            if (r0 == 0) goto L32
            android.widget.TextView r0 = r5.f935b
            android.graphics.Typeface r3 = r5.f946m
            r0.setTypeface(r3)
        L32:
            android.widget.TextView r0 = r5.f935b     // Catch: java.lang.Exception -> L7a
            int r3 = r5.f948o     // Catch: java.lang.Exception -> L7a
            android.support.v4.widget.TextViewCompat.m3117a(r0, r3)     // Catch: java.lang.Exception -> L7a
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L7a
            r3 = 23
            if (r0 < r3) goto L8b
            android.widget.TextView r0 = r5.f935b     // Catch: java.lang.Exception -> L7a
            android.content.res.ColorStateList r0 = r0.getTextColors()     // Catch: java.lang.Exception -> L7a
            int r0 = r0.getDefaultColor()     // Catch: java.lang.Exception -> L7a
            r3 = -65281(0xffffffffffff00ff, float:NaN)
            if (r0 != r3) goto L8b
            r0 = r1
        L4f:
            if (r0 == 0) goto L67
            android.widget.TextView r0 = r5.f935b
            int r3 = android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Caption
            android.support.v4.widget.TextViewCompat.m3117a(r0, r3)
            android.widget.TextView r0 = r5.f935b
            android.content.Context r3 = r5.getContext()
            int r4 = android.support.v7.appcompat.R.color.error_color_material
            int r3 = android.support.v4.content.ContextCompat.m1840c(r3, r4)
            r0.setTextColor(r3)
        L67:
            android.widget.TextView r0 = r5.f935b
            r3 = 4
            r0.setVisibility(r3)
            android.widget.TextView r0 = r5.f935b
            android.support.v4.view.ViewCompat.m2593b(r0, r1)
            android.widget.TextView r0 = r5.f935b
            r5.m918a(r0, r2)
        L77:
            r5.f947n = r6
        L79:
            return
        L7a:
            r0 = move-exception
            r0 = r1
            goto L4f
        L7d:
            r5.f949p = r2
            r5.m924c()
            android.widget.TextView r0 = r5.f935b
            r5.m917a(r0)
            r0 = 0
            r5.f935b = r0
            goto L77
        L8b:
            r0 = r2
            goto L4f
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.TextInputLayout.setErrorEnabled(boolean):void");
    }

    public void setErrorTextAppearance(int i) {
        this.f948o = i;
        if (this.f935b != null) {
            TextViewCompat.m3117a(this.f935b, i);
        }
    }

    public void setError(CharSequence charSequence) {
        m919a(charSequence, ViewCompat.m2621y(this) && isEnabled() && (this.f935b == null || !TextUtils.equals(this.f935b.getText(), charSequence)));
    }

    /* JADX INFO: renamed from: a */
    private void m919a(final CharSequence charSequence, boolean z) {
        this.f950q = charSequence;
        if (!this.f947n) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        this.f949p = TextUtils.isEmpty(charSequence) ? false : true;
        this.f935b.animate().cancel();
        if (this.f949p) {
            this.f935b.setText(charSequence);
            this.f935b.setVisibility(0);
            if (z) {
                if (this.f935b.getAlpha() == 1.0f) {
                    this.f935b.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
                }
                this.f935b.animate().alpha(1.0f).setDuration(200L).setInterpolator(AnimationUtils.f473d).setListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.TextInputLayout.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        TextInputLayout.this.f935b.setVisibility(0);
                    }
                }).start();
            } else {
                this.f935b.setAlpha(1.0f);
            }
        } else if (this.f935b.getVisibility() == 0) {
            if (z) {
                this.f935b.animate().alpha(CropImageView.DEFAULT_ASPECT_RATIO).setDuration(200L).setInterpolator(AnimationUtils.f472c).setListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.TextInputLayout.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        TextInputLayout.this.f935b.setText(charSequence);
                        TextInputLayout.this.f935b.setVisibility(4);
                    }
                }).start();
            } else {
                this.f935b.setText(charSequence);
                this.f935b.setVisibility(4);
            }
        }
        m924c();
        m934a(z);
    }

    public void setCounterEnabled(boolean z) {
        if (this.f936c != z) {
            if (z) {
                this.f951r = new AppCompatTextView(getContext());
                this.f951r.setId(R.id.textinput_counter);
                if (this.f946m != null) {
                    this.f951r.setTypeface(this.f946m);
                }
                this.f951r.setMaxLines(1);
                try {
                    TextViewCompat.m3117a(this.f951r, this.f953t);
                } catch (Exception e) {
                    TextViewCompat.m3117a(this.f951r, android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Caption);
                    this.f951r.setTextColor(ContextCompat.m1840c(getContext(), android.support.v7.appcompat.R.color.error_color_material));
                }
                m918a(this.f951r, -1);
                if (this.f934a == null) {
                    m933a(0);
                } else {
                    m933a(this.f934a.getText().length());
                }
            } else {
                m917a(this.f951r);
                this.f951r = null;
            }
            this.f936c = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.f952s != i) {
            if (i > 0) {
                this.f952s = i;
            } else {
                this.f952s = -1;
            }
            if (this.f936c) {
                m933a(this.f934a == null ? 0 : this.f934a.getText().length());
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        m916a((ViewGroup) this, z);
        super.setEnabled(z);
    }

    /* JADX INFO: renamed from: a */
    private static void m916a(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                m916a((ViewGroup) childAt, z);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.f952s;
    }

    /* JADX INFO: renamed from: a */
    void m933a(int i) {
        boolean z = this.f955v;
        if (this.f952s == -1) {
            this.f951r.setText(String.valueOf(i));
            this.f955v = false;
        } else {
            this.f955v = i > this.f952s;
            if (z != this.f955v) {
                TextViewCompat.m3117a(this.f951r, this.f955v ? this.f954u : this.f953t);
            }
            this.f951r.setText(getContext().getString(R.string.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.f952s)));
        }
        if (this.f934a != null && z != this.f955v) {
            m934a(false);
            m924c();
        }
    }

    /* JADX INFO: renamed from: c */
    private void m924c() {
        Drawable background;
        if (this.f934a != null && (background = this.f934a.getBackground()) != null) {
            m926d();
            if (android.support.v7.widget.DrawableUtils.m4117c(background)) {
                background = background.mutate();
            }
            if (this.f949p && this.f935b != null) {
                background.setColorFilter(AppCompatDrawableManager.m3858a(this.f935b.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            } else if (this.f955v && this.f951r != null) {
                background.setColorFilter(AppCompatDrawableManager.m3858a(this.f951r.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            } else {
                DrawableCompat.m1999f(background);
                this.f934a.refreshDrawableState();
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private void m926d() {
        Drawable background;
        int i = Build.VERSION.SDK_INT;
        if ((i == 21 || i == 22) && (background = this.f934a.getBackground()) != null && !this.f931M) {
            Drawable drawableNewDrawable = background.getConstantState().newDrawable();
            if (background instanceof DrawableContainer) {
                this.f931M = DrawableUtils.m712a((DrawableContainer) background, drawableNewDrawable.getConstantState());
            }
            if (!this.f931M) {
                ViewCompat.m2582a(this.f934a, drawableNewDrawable);
                this.f931M = true;
            }
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.design.widget.TextInputLayout.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX INFO: renamed from: a */
        CharSequence f966a;

        /* JADX INFO: renamed from: b */
        boolean f967b;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f966a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f967b = parcel.readInt() == 1;
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f966a, parcel, i);
            parcel.writeInt(this.f967b ? 1 : 0);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f966a) + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f949p) {
            savedState.f966a = getError();
        }
        savedState.f967b = this.f919A;
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.m2474a());
        setError(savedState.f966a);
        if (savedState.f967b) {
            m923b(true);
        }
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.f933O = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f933O = false;
    }

    public CharSequence getError() {
        if (this.f947n) {
            return this.f950q;
        }
        return null;
    }

    public void setHintAnimationEnabled(boolean z) {
        this.f929K = z;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f940g) {
            this.f937d.m587a(canvas);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        m928e();
        super.onMeasure(i, i2);
    }

    /* JADX INFO: renamed from: e */
    private void m928e() {
        if (this.f934a != null) {
            if (m930g()) {
                if (this.f959z == null) {
                    this.f959z = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_password_icon, (ViewGroup) this.f938e, false);
                    this.f959z.setImageDrawable(this.f957x);
                    this.f959z.setContentDescription(this.f958y);
                    this.f938e.addView(this.f959z);
                    this.f959z.setOnClickListener(new View.OnClickListener() { // from class: android.support.design.widget.TextInputLayout.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            TextInputLayout.this.m923b(false);
                        }
                    });
                }
                if (this.f934a != null && ViewCompat.m2607k(this.f934a) <= 0) {
                    this.f934a.setMinimumHeight(ViewCompat.m2607k(this.f959z));
                }
                this.f959z.setVisibility(0);
                this.f959z.setChecked(this.f919A);
                if (this.f920B == null) {
                    this.f920B = new ColorDrawable();
                }
                this.f920B.setBounds(0, 0, this.f959z.getMeasuredWidth(), 1);
                Drawable[] drawableArrM3119b = TextViewCompat.m3119b(this.f934a);
                if (drawableArrM3119b[2] != this.f920B) {
                    this.f921C = drawableArrM3119b[2];
                }
                TextViewCompat.m3118a(this.f934a, drawableArrM3119b[0], drawableArrM3119b[1], this.f920B, drawableArrM3119b[3]);
                this.f959z.setPadding(this.f934a.getPaddingLeft(), this.f934a.getPaddingTop(), this.f934a.getPaddingRight(), this.f934a.getPaddingBottom());
                return;
            }
            if (this.f959z != null && this.f959z.getVisibility() == 0) {
                this.f959z.setVisibility(8);
            }
            if (this.f920B != null) {
                Drawable[] drawableArrM3119b2 = TextViewCompat.m3119b(this.f934a);
                if (drawableArrM3119b2[2] == this.f920B) {
                    TextViewCompat.m3118a(this.f934a, drawableArrM3119b2[0], drawableArrM3119b2[1], this.f921C, drawableArrM3119b2[3]);
                    this.f920B = null;
                }
            }
        }
    }

    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? AppCompatResources.m3426b(getContext(), i) : null);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f957x = drawable;
        if (this.f959z != null) {
            this.f959z.setImageDrawable(drawable);
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f958y = charSequence;
        if (this.f959z != null) {
            this.f959z.setContentDescription(charSequence);
        }
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f957x;
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f958y;
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (this.f956w != z) {
            this.f956w = z;
            if (!z && this.f919A && this.f934a != null) {
                this.f934a.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.f919A = false;
            m928e();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f922D = colorStateList;
        this.f923E = true;
        m931h();
    }

    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f924F = mode;
        this.f925G = true;
        m931h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m923b(boolean z) {
        if (this.f956w) {
            int selectionEnd = this.f934a.getSelectionEnd();
            if (m929f()) {
                this.f934a.setTransformationMethod(null);
                this.f919A = true;
            } else {
                this.f934a.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.f919A = false;
            }
            this.f959z.setChecked(this.f919A);
            if (z) {
                this.f959z.jumpDrawablesToCurrentState();
            }
            this.f934a.setSelection(selectionEnd);
        }
    }

    /* JADX INFO: renamed from: f */
    private boolean m929f() {
        return this.f934a != null && (this.f934a.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    /* JADX INFO: renamed from: g */
    private boolean m930g() {
        return this.f956w && (m929f() || this.f919A);
    }

    /* JADX INFO: renamed from: h */
    private void m931h() {
        if (this.f957x != null) {
            if (this.f923E || this.f925G) {
                this.f957x = DrawableCompat.m2000g(this.f957x).mutate();
                if (this.f923E) {
                    DrawableCompat.m1989a(this.f957x, this.f922D);
                }
                if (this.f925G) {
                    DrawableCompat.m1992a(this.f957x, this.f924F);
                }
                if (this.f959z != null && this.f959z.getDrawable() != this.f957x) {
                    this.f959z.setImageDrawable(this.f957x);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f940g && this.f934a != null) {
            Rect rect = this.f943j;
            ViewGroupUtils.m3172b(this, this.f934a, rect);
            int compoundPaddingLeft = rect.left + this.f934a.getCompoundPaddingLeft();
            int compoundPaddingRight = rect.right - this.f934a.getCompoundPaddingRight();
            this.f937d.m585a(compoundPaddingLeft, rect.top + this.f934a.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.f934a.getCompoundPaddingBottom());
            this.f937d.m595b(compoundPaddingLeft, getPaddingTop(), compoundPaddingRight, (i4 - i2) - getPaddingBottom());
            this.f937d.m608i();
        }
    }

    /* JADX INFO: renamed from: c */
    private void m925c(boolean z) {
        if (this.f930L != null && this.f930L.isRunning()) {
            this.f930L.cancel();
        }
        if (z && this.f929K) {
            m932a(1.0f);
        } else {
            this.f937d.m593b(1.0f);
        }
        this.f928J = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (!this.f932N) {
            this.f932N = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            m934a(ViewCompat.m2621y(this) && isEnabled());
            m924c();
            if (this.f937d != null ? this.f937d.m591a(drawableState) | false : false) {
                invalidate();
            }
            this.f932N = false;
        }
    }

    /* JADX INFO: renamed from: d */
    private void m927d(boolean z) {
        if (this.f930L != null && this.f930L.isRunning()) {
            this.f930L.cancel();
        }
        if (z && this.f929K) {
            m932a(CropImageView.DEFAULT_ASPECT_RATIO);
        } else {
            this.f937d.m593b(CropImageView.DEFAULT_ASPECT_RATIO);
        }
        this.f928J = true;
    }

    /* JADX INFO: renamed from: a */
    void m932a(float f) {
        if (this.f937d.m606g() != f) {
            if (this.f930L == null) {
                this.f930L = new ValueAnimator();
                this.f930L.setInterpolator(AnimationUtils.f470a);
                this.f930L.setDuration(200L);
                this.f930L.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.widget.TextInputLayout.5
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        TextInputLayout.this.f937d.m593b(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.f930L.setFloatValues(this.f937d.m606g(), f);
            this.f930L.start();
        }
    }

    private class TextInputAccessibilityDelegate extends AccessibilityDelegateCompat {
        TextInputAccessibilityDelegate() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        /* JADX INFO: renamed from: a */
        public void mo559a(View view, AccessibilityEvent accessibilityEvent) {
            super.mo559a(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        /* JADX INFO: renamed from: b */
        public void mo939b(View view, AccessibilityEvent accessibilityEvent) {
            super.mo939b(view, accessibilityEvent);
            CharSequence charSequenceM609j = TextInputLayout.this.f937d.m609j();
            if (!TextUtils.isEmpty(charSequenceM609j)) {
                accessibilityEvent.getText().add(charSequenceM609j);
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        /* JADX INFO: renamed from: a */
        public void mo365a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo365a(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.m2793b((CharSequence) TextInputLayout.class.getSimpleName());
            CharSequence charSequenceM609j = TextInputLayout.this.f937d.m609j();
            if (!TextUtils.isEmpty(charSequenceM609j)) {
                accessibilityNodeInfoCompat.m2799c(charSequenceM609j);
            }
            if (TextInputLayout.this.f934a != null) {
                accessibilityNodeInfoCompat.m2802d(TextInputLayout.this.f934a);
            }
            CharSequence text = TextInputLayout.this.f935b != null ? TextInputLayout.this.f935b.getText() : null;
            if (!TextUtils.isEmpty(text)) {
                accessibilityNodeInfoCompat.m2821l(true);
                accessibilityNodeInfoCompat.m2806e(text);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m921a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
