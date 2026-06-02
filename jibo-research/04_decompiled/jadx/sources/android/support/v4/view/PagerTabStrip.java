package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {

    /* JADX INFO: renamed from: g */
    private int f2299g;

    /* JADX INFO: renamed from: h */
    private int f2300h;

    /* JADX INFO: renamed from: i */
    private int f2301i;

    /* JADX INFO: renamed from: j */
    private int f2302j;

    /* JADX INFO: renamed from: k */
    private int f2303k;

    /* JADX INFO: renamed from: l */
    private int f2304l;

    /* JADX INFO: renamed from: m */
    private final Paint f2305m;

    /* JADX INFO: renamed from: n */
    private final Rect f2306n;

    /* JADX INFO: renamed from: o */
    private int f2307o;

    /* JADX INFO: renamed from: p */
    private boolean f2308p;

    /* JADX INFO: renamed from: q */
    private boolean f2309q;

    /* JADX INFO: renamed from: r */
    private int f2310r;

    /* JADX INFO: renamed from: s */
    private boolean f2311s;

    /* JADX INFO: renamed from: t */
    private float f2312t;

    /* JADX INFO: renamed from: u */
    private float f2313u;

    /* JADX INFO: renamed from: v */
    private int f2314v;

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2305m = new Paint();
        this.f2306n = new Rect();
        this.f2307o = 255;
        this.f2308p = false;
        this.f2309q = false;
        this.f2299g = this.f2324f;
        this.f2305m.setColor(this.f2299g);
        float f = context.getResources().getDisplayMetrics().density;
        this.f2300h = (int) ((3.0f * f) + 0.5f);
        this.f2301i = (int) ((6.0f * f) + 0.5f);
        this.f2302j = (int) (64.0f * f);
        this.f2304l = (int) ((16.0f * f) + 0.5f);
        this.f2310r = (int) ((1.0f * f) + 0.5f);
        this.f2303k = (int) ((f * 32.0f) + 0.5f);
        this.f2314v = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f2320b.setFocusable(true);
        this.f2320b.setOnClickListener(new View.OnClickListener() { // from class: android.support.v4.view.PagerTabStrip.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PagerTabStrip.this.f2319a.setCurrentItem(PagerTabStrip.this.f2319a.getCurrentItem() - 1);
            }
        });
        this.f2322d.setFocusable(true);
        this.f2322d.setOnClickListener(new View.OnClickListener() { // from class: android.support.v4.view.PagerTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PagerTabStrip.this.f2319a.setCurrentItem(PagerTabStrip.this.f2319a.getCurrentItem() + 1);
            }
        });
        if (getBackground() == null) {
            this.f2308p = true;
        }
    }

    public void setTabIndicatorColor(int i) {
        this.f2299g = i;
        this.f2305m.setColor(this.f2299g);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i) {
        setTabIndicatorColor(ContextCompat.m1840c(getContext(), i));
    }

    public int getTabIndicatorColor() {
        return this.f2299g;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.f2301i) {
            i4 = this.f2301i;
        }
        super.setPadding(i, i2, i3, i4);
    }

    @Override // android.support.v4.view.PagerTitleStrip
    public void setTextSpacing(int i) {
        if (i < this.f2302j) {
            i = this.f2302j;
        }
        super.setTextSpacing(i);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.f2309q) {
            this.f2308p = drawable == null;
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (!this.f2309q) {
            this.f2308p = ((-16777216) & i) == 0;
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (!this.f2309q) {
            this.f2308p = i == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.f2308p = z;
        this.f2309q = true;
        invalidate();
    }

    public boolean getDrawFullUnderline() {
        return this.f2308p;
    }

    @Override // android.support.v4.view.PagerTitleStrip
    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f2303k);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.f2311s) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.f2312t = x;
                this.f2313u = y;
                this.f2311s = false;
                break;
            case 1:
                if (x < this.f2321c.getLeft() - this.f2304l) {
                    this.f2319a.setCurrentItem(this.f2319a.getCurrentItem() - 1);
                } else if (x > this.f2321c.getRight() + this.f2304l) {
                    this.f2319a.setCurrentItem(this.f2319a.getCurrentItem() + 1);
                }
                break;
            case 2:
                if (Math.abs(x - this.f2312t) > this.f2314v || Math.abs(y - this.f2313u) > this.f2314v) {
                    this.f2311s = true;
                }
                break;
        }
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f2321c.getLeft() - this.f2304l;
        int right = this.f2321c.getRight() + this.f2304l;
        int i = height - this.f2300h;
        this.f2305m.setColor((this.f2307o << 24) | (this.f2299g & 16777215));
        canvas.drawRect(left, i, right, height, this.f2305m);
        if (this.f2308p) {
            this.f2305m.setColor((-16777216) | (this.f2299g & 16777215));
            canvas.drawRect(getPaddingLeft(), height - this.f2310r, getWidth() - getPaddingRight(), height, this.f2305m);
        }
    }

    @Override // android.support.v4.view.PagerTitleStrip
    /* JADX INFO: renamed from: a */
    void mo2563a(int i, float f, boolean z) {
        Rect rect = this.f2306n;
        int height = getHeight();
        int left = this.f2321c.getLeft() - this.f2304l;
        int right = this.f2321c.getRight() + this.f2304l;
        int i2 = height - this.f2300h;
        rect.set(left, i2, right, height);
        super.mo2563a(i, f, z);
        this.f2307o = (int) (Math.abs(f - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f2321c.getLeft() - this.f2304l, i2, this.f2321c.getRight() + this.f2304l, height);
        invalidate(rect);
    }
}
