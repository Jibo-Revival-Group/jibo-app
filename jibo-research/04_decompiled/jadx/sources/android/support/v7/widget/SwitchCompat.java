package android.support.v7.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.text.AllCapsTransformationMethod;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import com.yalantis.ucrop.view.CropImageView;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* JADX INFO: renamed from: A */
    private int f4375A;

    /* JADX INFO: renamed from: B */
    private int f4376B;

    /* JADX INFO: renamed from: C */
    private int f4377C;

    /* JADX INFO: renamed from: D */
    private int f4378D;

    /* JADX INFO: renamed from: E */
    private int f4379E;

    /* JADX INFO: renamed from: F */
    private int f4380F;

    /* JADX INFO: renamed from: G */
    private int f4381G;

    /* JADX INFO: renamed from: H */
    private final TextPaint f4382H;

    /* JADX INFO: renamed from: I */
    private ColorStateList f4383I;

    /* JADX INFO: renamed from: J */
    private Layout f4384J;

    /* JADX INFO: renamed from: K */
    private Layout f4385K;

    /* JADX INFO: renamed from: L */
    private TransformationMethod f4386L;

    /* JADX INFO: renamed from: M */
    private final Rect f4387M;

    /* JADX INFO: renamed from: a */
    ObjectAnimator f4388a;

    /* JADX INFO: renamed from: c */
    private Drawable f4389c;

    /* JADX INFO: renamed from: d */
    private ColorStateList f4390d;

    /* JADX INFO: renamed from: e */
    private PorterDuff.Mode f4391e;

    /* JADX INFO: renamed from: f */
    private boolean f4392f;

    /* JADX INFO: renamed from: g */
    private boolean f4393g;

    /* JADX INFO: renamed from: h */
    private Drawable f4394h;

    /* JADX INFO: renamed from: i */
    private ColorStateList f4395i;

    /* JADX INFO: renamed from: j */
    private PorterDuff.Mode f4396j;

    /* JADX INFO: renamed from: k */
    private boolean f4397k;

    /* JADX INFO: renamed from: l */
    private boolean f4398l;

    /* JADX INFO: renamed from: m */
    private int f4399m;

    /* JADX INFO: renamed from: n */
    private int f4400n;

    /* JADX INFO: renamed from: o */
    private int f4401o;

    /* JADX INFO: renamed from: p */
    private boolean f4402p;

    /* JADX INFO: renamed from: q */
    private CharSequence f4403q;

    /* JADX INFO: renamed from: r */
    private CharSequence f4404r;

    /* JADX INFO: renamed from: s */
    private boolean f4405s;

    /* JADX INFO: renamed from: t */
    private int f4406t;

    /* JADX INFO: renamed from: u */
    private int f4407u;

    /* JADX INFO: renamed from: v */
    private float f4408v;

    /* JADX INFO: renamed from: w */
    private float f4409w;

    /* JADX INFO: renamed from: x */
    private VelocityTracker f4410x;

    /* JADX INFO: renamed from: y */
    private int f4411y;

    /* JADX INFO: renamed from: z */
    private float f4412z;

    /* JADX INFO: renamed from: b */
    private static final Property<SwitchCompat, Float> f4374b = new Property<SwitchCompat, Float>(Float.class, "thumbPos") { // from class: android.support.v7.widget.SwitchCompat.1
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f4412z);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f) {
            switchCompat.setThumbPosition(f.floatValue());
        }
    };

    /* JADX INFO: renamed from: N */
    private static final int[] f4373N = {R.attr.state_checked};

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.appcompat.R.attr.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4390d = null;
        this.f4391e = null;
        this.f4392f = false;
        this.f4393g = false;
        this.f4395i = null;
        this.f4396j = null;
        this.f4397k = false;
        this.f4398l = false;
        this.f4410x = VelocityTracker.obtain();
        this.f4387M = new Rect();
        this.f4382H = new TextPaint(1);
        Resources resources = getResources();
        this.f4382H.density = resources.getDisplayMetrics().density;
        TintTypedArray tintTypedArrayM4955a = TintTypedArray.m4955a(context, attributeSet, android.support.v7.appcompat.R.styleable.SwitchCompat, i, 0);
        this.f4389c = tintTypedArrayM4955a.m4959a(android.support.v7.appcompat.R.styleable.SwitchCompat_android_thumb);
        if (this.f4389c != null) {
            this.f4389c.setCallback(this);
        }
        this.f4394h = tintTypedArrayM4955a.m4959a(android.support.v7.appcompat.R.styleable.SwitchCompat_track);
        if (this.f4394h != null) {
            this.f4394h.setCallback(this);
        }
        this.f4403q = tintTypedArrayM4955a.m4965c(android.support.v7.appcompat.R.styleable.SwitchCompat_android_textOn);
        this.f4404r = tintTypedArrayM4955a.m4965c(android.support.v7.appcompat.R.styleable.SwitchCompat_android_textOff);
        this.f4405s = tintTypedArrayM4955a.m4961a(android.support.v7.appcompat.R.styleable.SwitchCompat_showText, true);
        this.f4399m = tintTypedArrayM4955a.m4968e(android.support.v7.appcompat.R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.f4400n = tintTypedArrayM4955a.m4968e(android.support.v7.appcompat.R.styleable.SwitchCompat_switchMinWidth, 0);
        this.f4401o = tintTypedArrayM4955a.m4968e(android.support.v7.appcompat.R.styleable.SwitchCompat_switchPadding, 0);
        this.f4402p = tintTypedArrayM4955a.m4961a(android.support.v7.appcompat.R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList colorStateListM4969e = tintTypedArrayM4955a.m4969e(android.support.v7.appcompat.R.styleable.SwitchCompat_thumbTint);
        if (colorStateListM4969e != null) {
            this.f4390d = colorStateListM4969e;
            this.f4392f = true;
        }
        PorterDuff.Mode modeM4114a = DrawableUtils.m4114a(tintTypedArrayM4955a.m4957a(android.support.v7.appcompat.R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.f4391e != modeM4114a) {
            this.f4391e = modeM4114a;
            this.f4393g = true;
        }
        if (this.f4392f || this.f4393g) {
            m4936b();
        }
        ColorStateList colorStateListM4969e2 = tintTypedArrayM4955a.m4969e(android.support.v7.appcompat.R.styleable.SwitchCompat_trackTint);
        if (colorStateListM4969e2 != null) {
            this.f4395i = colorStateListM4969e2;
            this.f4397k = true;
        }
        PorterDuff.Mode modeM4114a2 = DrawableUtils.m4114a(tintTypedArrayM4955a.m4957a(android.support.v7.appcompat.R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.f4396j != modeM4114a2) {
            this.f4396j = modeM4114a2;
            this.f4398l = true;
        }
        if (this.f4397k || this.f4398l) {
            m4931a();
        }
        int iM4972g = tintTypedArrayM4955a.m4972g(android.support.v7.appcompat.R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (iM4972g != 0) {
            m4939a(context, iM4972g);
        }
        tintTypedArrayM4955a.m4960a();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f4407u = viewConfiguration.getScaledTouchSlop();
        this.f4411y = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    /* JADX INFO: renamed from: a */
    public void m4939a(Context context, int i) {
        TintTypedArray tintTypedArrayM4953a = TintTypedArray.m4953a(context, i, android.support.v7.appcompat.R.styleable.TextAppearance);
        ColorStateList colorStateListM4969e = tintTypedArrayM4953a.m4969e(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor);
        if (colorStateListM4969e != null) {
            this.f4383I = colorStateListM4969e;
        } else {
            this.f4383I = getTextColors();
        }
        int iM4968e = tintTypedArrayM4953a.m4968e(android.support.v7.appcompat.R.styleable.TextAppearance_android_textSize, 0);
        if (iM4968e != 0 && iM4968e != this.f4382H.getTextSize()) {
            this.f4382H.setTextSize(iM4968e);
            requestLayout();
        }
        m4932a(tintTypedArrayM4953a.m4957a(android.support.v7.appcompat.R.styleable.TextAppearance_android_typeface, -1), tintTypedArrayM4953a.m4957a(android.support.v7.appcompat.R.styleable.TextAppearance_android_textStyle, -1));
        if (tintTypedArrayM4953a.m4961a(android.support.v7.appcompat.R.styleable.TextAppearance_textAllCaps, false)) {
            this.f4386L = new AllCapsTransformationMethod(getContext());
        } else {
            this.f4386L = null;
        }
        tintTypedArrayM4953a.m4960a();
    }

    /* JADX INFO: renamed from: a */
    private void m4932a(int i, int i2) {
        Typeface typeface = null;
        switch (i) {
            case 1:
                typeface = Typeface.SANS_SERIF;
                break;
            case 2:
                typeface = Typeface.SERIF;
                break;
            case 3:
                typeface = Typeface.MONOSPACE;
                break;
        }
        m4940a(typeface, i2);
    }

    /* JADX INFO: renamed from: a */
    public void m4940a(Typeface typeface, int i) {
        Typeface typefaceCreate;
        if (i > 0) {
            if (typeface == null) {
                typefaceCreate = Typeface.defaultFromStyle(i);
            } else {
                typefaceCreate = Typeface.create(typeface, i);
            }
            setSwitchTypeface(typefaceCreate);
            int style = ((typefaceCreate != null ? typefaceCreate.getStyle() : 0) ^ (-1)) & i;
            this.f4382H.setFakeBoldText((style & 1) != 0);
            this.f4382H.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.f4382H.setFakeBoldText(false);
        this.f4382H.setTextSkewX(CropImageView.DEFAULT_ASPECT_RATIO);
        setSwitchTypeface(typeface);
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.f4382H.getTypeface() != null && !this.f4382H.getTypeface().equals(typeface)) || (this.f4382H.getTypeface() == null && typeface != null)) {
            this.f4382H.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchPadding(int i) {
        this.f4401o = i;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.f4401o;
    }

    public void setSwitchMinWidth(int i) {
        this.f4400n = i;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.f4400n;
    }

    public void setThumbTextPadding(int i) {
        this.f4399m = i;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.f4399m;
    }

    public void setTrackDrawable(Drawable drawable) {
        if (this.f4394h != null) {
            this.f4394h.setCallback(null);
        }
        this.f4394h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(AppCompatResources.m3426b(getContext(), i));
    }

    public Drawable getTrackDrawable() {
        return this.f4394h;
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f4395i = colorStateList;
        this.f4397k = true;
        m4931a();
    }

    public ColorStateList getTrackTintList() {
        return this.f4395i;
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f4396j = mode;
        this.f4398l = true;
        m4931a();
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f4396j;
    }

    /* JADX INFO: renamed from: a */
    private void m4931a() {
        if (this.f4394h != null) {
            if (this.f4397k || this.f4398l) {
                this.f4394h = this.f4394h.mutate();
                if (this.f4397k) {
                    DrawableCompat.m1989a(this.f4394h, this.f4395i);
                }
                if (this.f4398l) {
                    DrawableCompat.m1992a(this.f4394h, this.f4396j);
                }
                if (this.f4394h.isStateful()) {
                    this.f4394h.setState(getDrawableState());
                }
            }
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        if (this.f4389c != null) {
            this.f4389c.setCallback(null);
        }
        this.f4389c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(AppCompatResources.m3426b(getContext(), i));
    }

    public Drawable getThumbDrawable() {
        return this.f4389c;
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f4390d = colorStateList;
        this.f4392f = true;
        m4936b();
    }

    public ColorStateList getThumbTintList() {
        return this.f4390d;
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f4391e = mode;
        this.f4393g = true;
        m4936b();
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f4391e;
    }

    /* JADX INFO: renamed from: b */
    private void m4936b() {
        if (this.f4389c != null) {
            if (this.f4392f || this.f4393g) {
                this.f4389c = this.f4389c.mutate();
                if (this.f4392f) {
                    DrawableCompat.m1989a(this.f4389c, this.f4390d);
                }
                if (this.f4393g) {
                    DrawableCompat.m1992a(this.f4389c, this.f4391e);
                }
                if (this.f4389c.isStateful()) {
                    this.f4389c.setState(getDrawableState());
                }
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.f4402p = z;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.f4402p;
    }

    public CharSequence getTextOn() {
        return this.f4403q;
    }

    public void setTextOn(CharSequence charSequence) {
        this.f4403q = charSequence;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.f4404r;
    }

    public void setTextOff(CharSequence charSequence) {
        this.f4404r = charSequence;
        requestLayout();
    }

    public void setShowText(boolean z) {
        if (this.f4405s != z) {
            this.f4405s = z;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.f4405s;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int intrinsicHeight;
        int intrinsicWidth;
        int intrinsicHeight2 = 0;
        if (this.f4405s) {
            if (this.f4384J == null) {
                this.f4384J = m4930a(this.f4403q);
            }
            if (this.f4385K == null) {
                this.f4385K = m4930a(this.f4404r);
            }
        }
        Rect rect = this.f4387M;
        if (this.f4389c != null) {
            this.f4389c.getPadding(rect);
            intrinsicWidth = (this.f4389c.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f4389c.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
            intrinsicWidth = 0;
        }
        this.f4377C = Math.max(this.f4405s ? Math.max(this.f4384J.getWidth(), this.f4385K.getWidth()) + (this.f4399m * 2) : 0, intrinsicWidth);
        if (this.f4394h != null) {
            this.f4394h.getPadding(rect);
            intrinsicHeight2 = this.f4394h.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        if (this.f4389c != null) {
            Rect rectM4115a = DrawableUtils.m4115a(this.f4389c);
            iMax = Math.max(iMax, rectM4115a.left);
            iMax2 = Math.max(iMax2, rectM4115a.right);
        }
        int iMax3 = Math.max(this.f4400n, iMax2 + iMax + (this.f4377C * 2));
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.f4375A = iMax3;
        this.f4376B = iMax4;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f4403q : this.f4404r;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX INFO: renamed from: a */
    private Layout m4930a(CharSequence charSequence) {
        CharSequence transformation = this.f4386L != null ? this.f4386L.getTransformation(charSequence, this) : charSequence;
        return new StaticLayout(transformation, this.f4382H, transformation != null ? (int) Math.ceil(Layout.getDesiredWidth(transformation, this.f4382H)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, true);
    }

    /* JADX INFO: renamed from: a */
    private boolean m4935a(float f, float f2) {
        if (this.f4389c == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f4389c.getPadding(this.f4387M);
        int i = this.f4379E - this.f4407u;
        int i2 = (thumbOffset + this.f4378D) - this.f4407u;
        return f > ((float) i2) && f < ((float) ((((this.f4377C + i2) + this.f4387M.left) + this.f4387M.right) + this.f4407u)) && f2 > ((float) i) && f2 < ((float) (this.f4381G + this.f4407u));
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        this.f4410x.addMovement(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (isEnabled() && m4935a(x, y)) {
                    this.f4406t = 1;
                    this.f4408v = x;
                    this.f4409w = y;
                }
                break;
            case 1:
            case 3:
                if (this.f4406t == 2) {
                    m4937b(motionEvent);
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                this.f4406t = 0;
                this.f4410x.clear();
                break;
                break;
            case 2:
                switch (this.f4406t) {
                    case 1:
                        float x2 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        if (Math.abs(x2 - this.f4408v) > this.f4407u || Math.abs(y2 - this.f4409w) > this.f4407u) {
                            this.f4406t = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.f4408v = x2;
                            this.f4409w = y2;
                            return true;
                        }
                        break;
                    case 2:
                        float x3 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f2 = x3 - this.f4408v;
                        if (thumbScrollRange != 0) {
                            f = f2 / thumbScrollRange;
                        } else {
                            f = f2 > CropImageView.DEFAULT_ASPECT_RATIO ? 1.0f : -1.0f;
                        }
                        if (ViewUtils.m5031a(this)) {
                            f = -f;
                        }
                        float fM4928a = m4928a(f + this.f4412z, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                        if (fM4928a != this.f4412z) {
                            this.f4408v = x3;
                            setThumbPosition(fM4928a);
                        }
                        return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: renamed from: a */
    private void m4933a(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    /* JADX INFO: renamed from: b */
    private void m4937b(MotionEvent motionEvent) {
        boolean targetCheckedState = true;
        this.f4406t = 0;
        boolean z = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z) {
            this.f4410x.computeCurrentVelocity(1000);
            float xVelocity = this.f4410x.getXVelocity();
            if (Math.abs(xVelocity) > this.f4411y) {
                if (ViewUtils.m5031a(this)) {
                    if (xVelocity >= CropImageView.DEFAULT_ASPECT_RATIO) {
                        targetCheckedState = false;
                    }
                } else if (xVelocity <= CropImageView.DEFAULT_ASPECT_RATIO) {
                    targetCheckedState = false;
                }
            } else {
                targetCheckedState = getTargetCheckedState();
            }
        } else {
            targetCheckedState = zIsChecked;
        }
        if (targetCheckedState != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(targetCheckedState);
        m4933a(motionEvent);
    }

    /* JADX INFO: renamed from: a */
    private void m4934a(boolean z) {
        this.f4388a = ObjectAnimator.ofFloat(this, f4374b, z ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO);
        this.f4388a.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
            this.f4388a.setAutoCancel(true);
        }
        this.f4388a.start();
    }

    /* JADX INFO: renamed from: c */
    private void m4938c() {
        if (this.f4388a != null) {
            this.f4388a.cancel();
        }
    }

    private boolean getTargetCheckedState() {
        return this.f4412z > 0.5f;
    }

    void setThumbPosition(float f) {
        this.f4412z = f;
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean zIsChecked = isChecked();
        if (getWindowToken() != null && ViewCompat.m2621y(this)) {
            m4934a(zIsChecked);
        } else {
            m4938c();
            setThumbPosition(zIsChecked ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iMax;
        int i5;
        int i6;
        int height;
        int paddingTop;
        int iMax2 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f4389c != null) {
            Rect rect = this.f4387M;
            if (this.f4394h != null) {
                this.f4394h.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectM4115a = DrawableUtils.m4115a(this.f4389c);
            iMax = Math.max(0, rectM4115a.left - rect.left);
            iMax2 = Math.max(0, rectM4115a.right - rect.right);
        } else {
            iMax = 0;
        }
        if (ViewUtils.m5031a(this)) {
            int paddingLeft = getPaddingLeft() + iMax;
            i6 = ((this.f4375A + paddingLeft) - iMax) - iMax2;
            i5 = paddingLeft;
        } else {
            int width = (getWidth() - getPaddingRight()) - iMax2;
            i5 = iMax2 + iMax + (width - this.f4375A);
            i6 = width;
        }
        switch (getGravity() & 112) {
            case 16:
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.f4376B / 2);
                height = this.f4376B + paddingTop;
                break;
            case 80:
                height = getHeight() - getPaddingBottom();
                paddingTop = height - this.f4376B;
                break;
            default:
                paddingTop = getPaddingTop();
                height = this.f4376B + paddingTop;
                break;
        }
        this.f4378D = i5;
        this.f4379E = paddingTop;
        this.f4381G = height;
        this.f4380F = i6;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect rectM4115a;
        int i;
        int i2;
        int i3;
        Rect rect = this.f4387M;
        int i4 = this.f4378D;
        int i5 = this.f4379E;
        int i6 = this.f4380F;
        int i7 = this.f4381G;
        int thumbOffset = i4 + getThumbOffset();
        if (this.f4389c != null) {
            rectM4115a = DrawableUtils.m4115a(this.f4389c);
        } else {
            rectM4115a = DrawableUtils.f3837a;
        }
        if (this.f4394h != null) {
            this.f4394h.getPadding(rect);
            int i8 = rect.left + thumbOffset;
            if (rectM4115a != null) {
                if (rectM4115a.left > rect.left) {
                    i4 += rectM4115a.left - rect.left;
                }
                i3 = rectM4115a.top > rect.top ? (rectM4115a.top - rect.top) + i5 : i5;
                if (rectM4115a.right > rect.right) {
                    i6 -= rectM4115a.right - rect.right;
                }
                i2 = rectM4115a.bottom > rect.bottom ? i7 - (rectM4115a.bottom - rect.bottom) : i7;
            } else {
                i2 = i7;
                i3 = i5;
            }
            this.f4394h.setBounds(i4, i3, i6, i2);
            i = i8;
        } else {
            i = thumbOffset;
        }
        if (this.f4389c != null) {
            this.f4389c.getPadding(rect);
            int i9 = i - rect.left;
            int i10 = i + this.f4377C + rect.right;
            this.f4389c.setBounds(i9, i5, i10, i7);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.m1988a(background, i9, i5, i10, i7);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.f4387M;
        Drawable drawable = this.f4394h;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.f4379E;
        int i2 = this.f4381G;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.f4389c;
        if (drawable != null) {
            if (this.f4402p && drawable2 != null) {
                Rect rectM4115a = DrawableUtils.m4115a(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectM4115a.left;
                rect.right -= rectM4115a.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            } else {
                drawable.draw(canvas);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.f4384J : this.f4385K;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            if (this.f4383I != null) {
                this.f4382H.setColor(this.f4383I.getColorForState(drawableState, 0));
            }
            this.f4382H.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.right + bounds.left;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i3 + i4) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!ViewUtils.m5031a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f4375A;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft + this.f4401o;
        }
        return compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.m5031a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f4375A;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingRight + this.f4401o;
        }
        return compoundPaddingRight;
    }

    private int getThumbOffset() {
        float f;
        if (ViewUtils.m5031a(this)) {
            f = 1.0f - this.f4412z;
        } else {
            f = this.f4412z;
        }
        return (int) ((f * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rectM4115a;
        if (this.f4394h != null) {
            Rect rect = this.f4387M;
            this.f4394h.getPadding(rect);
            if (this.f4389c != null) {
                rectM4115a = DrawableUtils.m4115a(this.f4389c);
            } else {
                rectM4115a = DrawableUtils.f3837a;
            }
            return ((((this.f4375A - this.f4377C) - rect.left) - rect.right) - rectM4115a.left) - rectM4115a.right;
        }
        return 0;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, f4373N);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        boolean state = false;
        Drawable drawable = this.f4389c;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f4394h;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.f4389c != null) {
            DrawableCompat.m1986a(this.f4389c, f, f2);
        }
        if (this.f4394h != null) {
            DrawableCompat.m1986a(this.f4394h, f, f2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4389c || drawable == this.f4394h;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f4389c != null) {
            this.f4389c.jumpToCurrentState();
        }
        if (this.f4394h != null) {
            this.f4394h.jumpToCurrentState();
        }
        if (this.f4388a != null && this.f4388a.isStarted()) {
            this.f4388a.end();
            this.f4388a = null;
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        CharSequence charSequence = isChecked() ? this.f4403q : this.f4404r;
        if (!TextUtils.isEmpty(charSequence)) {
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text).append(TokenParser.f15715SP).append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    /* JADX INFO: renamed from: a */
    private static float m4928a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }
}
