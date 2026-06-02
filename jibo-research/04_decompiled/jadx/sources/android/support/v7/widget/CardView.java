package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* JADX INFO: renamed from: e */
    private static final int[] f3759e = {R.attr.colorBackground};

    /* JADX INFO: renamed from: f */
    private static final CardViewImpl f3760f;

    /* JADX INFO: renamed from: a */
    int f3761a;

    /* JADX INFO: renamed from: b */
    int f3762b;

    /* JADX INFO: renamed from: c */
    final Rect f3763c;

    /* JADX INFO: renamed from: d */
    final Rect f3764d;

    /* JADX INFO: renamed from: g */
    private boolean f3765g;

    /* JADX INFO: renamed from: h */
    private boolean f3766h;

    /* JADX INFO: renamed from: i */
    private final CardViewDelegate f3767i;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f3760f = new CardViewApi21Impl();
        } else if (Build.VERSION.SDK_INT >= 17) {
            f3760f = new CardViewApi17Impl();
        } else {
            f3760f = new CardViewBaseImpl();
        }
        f3760f.mo3984a();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.cardview.R.attr.cardViewStyle);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        int color;
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i);
        this.f3763c = new Rect();
        this.f3764d = new Rect();
        this.f3767i = new CardViewDelegate() { // from class: android.support.v7.widget.CardView.1

            /* JADX INFO: renamed from: b */
            private Drawable f3769b;

            @Override // android.support.v7.widget.CardViewDelegate
            /* JADX INFO: renamed from: a */
            public void mo3979a(Drawable drawable) {
                this.f3769b = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            @Override // android.support.v7.widget.CardViewDelegate
            /* JADX INFO: renamed from: a */
            public boolean mo3980a() {
                return CardView.this.getUseCompatPadding();
            }

            @Override // android.support.v7.widget.CardViewDelegate
            /* JADX INFO: renamed from: b */
            public boolean mo3981b() {
                return CardView.this.getPreventCornerOverlap();
            }

            @Override // android.support.v7.widget.CardViewDelegate
            /* JADX INFO: renamed from: a */
            public void mo3978a(int i2, int i3, int i4, int i5) {
                CardView.this.f3764d.set(i2, i3, i4, i5);
                CardView.super.setPadding(CardView.this.f3763c.left + i2, CardView.this.f3763c.top + i3, CardView.this.f3763c.right + i4, CardView.this.f3763c.bottom + i5);
            }

            @Override // android.support.v7.widget.CardViewDelegate
            /* JADX INFO: renamed from: a */
            public void mo3977a(int i2, int i3) {
                if (i2 > CardView.this.f3761a) {
                    CardView.super.setMinimumWidth(i2);
                }
                if (i3 > CardView.this.f3762b) {
                    CardView.super.setMinimumHeight(i3);
                }
            }

            @Override // android.support.v7.widget.CardViewDelegate
            /* JADX INFO: renamed from: c */
            public Drawable mo3982c() {
                return this.f3769b;
            }

            @Override // android.support.v7.widget.CardViewDelegate
            /* JADX INFO: renamed from: d */
            public View mo3983d() {
                return CardView.this;
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.cardview.R.styleable.CardView, i, android.support.v7.cardview.R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.cardview.R.styleable.CardView_cardBackgroundColor)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(android.support.v7.cardview.R.styleable.CardView_cardBackgroundColor);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f3759e);
            int color2 = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(android.support.v7.cardview.R.color.cardview_light_background);
            } else {
                color = getResources().getColor(android.support.v7.cardview.R.color.cardview_dark_background);
            }
            colorStateListValueOf = ColorStateList.valueOf(color);
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(android.support.v7.cardview.R.styleable.CardView_cardCornerRadius, CropImageView.DEFAULT_ASPECT_RATIO);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(android.support.v7.cardview.R.styleable.CardView_cardElevation, CropImageView.DEFAULT_ASPECT_RATIO);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(android.support.v7.cardview.R.styleable.CardView_cardMaxElevation, CropImageView.DEFAULT_ASPECT_RATIO);
        this.f3765g = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.cardview.R.styleable.CardView_cardUseCompatPadding, false);
        this.f3766h = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.cardview.R.styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_contentPadding, 0);
        this.f3763c.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        this.f3763c.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_contentPaddingTop, dimensionPixelSize);
        this.f3763c.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_contentPaddingRight, dimensionPixelSize);
        this.f3763c.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f3761a = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_android_minWidth, 0);
        this.f3762b = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_android_minHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
        f3760f.mo3989a(this.f3767i, context, colorStateListValueOf, dimension, dimension2, dimension3);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public boolean getUseCompatPadding() {
        return this.f3765g;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f3765g != z) {
            this.f3765g = z;
            f3760f.mo3998g(this.f3767i);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (!(f3760f instanceof CardViewApi21Impl)) {
            int mode = View.MeasureSpec.getMode(i);
            switch (mode) {
                case Integer.MIN_VALUE:
                case 1073741824:
                    i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f3760f.mo3991b(this.f3767i)), View.MeasureSpec.getSize(i)), mode);
                    break;
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            switch (mode2) {
                case Integer.MIN_VALUE:
                case 1073741824:
                    i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f3760f.mo3993c(this.f3767i)), View.MeasureSpec.getSize(i2)), mode2);
                    break;
            }
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        this.f3761a = i;
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.f3762b = i;
        super.setMinimumHeight(i);
    }

    public void setCardBackgroundColor(int i) {
        f3760f.mo3990a(this.f3767i, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f3760f.mo3990a(this.f3767i, colorStateList);
    }

    public ColorStateList getCardBackgroundColor() {
        return f3760f.mo4000i(this.f3767i);
    }

    public int getContentPaddingLeft() {
        return this.f3763c.left;
    }

    public int getContentPaddingRight() {
        return this.f3763c.right;
    }

    public int getContentPaddingTop() {
        return this.f3763c.top;
    }

    public int getContentPaddingBottom() {
        return this.f3763c.bottom;
    }

    public void setRadius(float f) {
        f3760f.mo3988a(this.f3767i, f);
    }

    public float getRadius() {
        return f3760f.mo3995d(this.f3767i);
    }

    public void setCardElevation(float f) {
        f3760f.mo3994c(this.f3767i, f);
    }

    public float getCardElevation() {
        return f3760f.mo3996e(this.f3767i);
    }

    public void setMaxCardElevation(float f) {
        f3760f.mo3992b(this.f3767i, f);
    }

    public float getMaxCardElevation() {
        return f3760f.mo3987a(this.f3767i);
    }

    public boolean getPreventCornerOverlap() {
        return this.f3766h;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f3766h) {
            this.f3766h = z;
            f3760f.mo3999h(this.f3767i);
        }
    }
}
