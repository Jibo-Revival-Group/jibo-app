package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a */
    Drawable f460a;

    /* JADX INFO: renamed from: b */
    Rect f461b;

    /* JADX INFO: renamed from: c */
    private Rect f462c;

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f462c = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrimInsetsFrameLayout, i, R.style.Widget_Design_ScrimInsetsFrameLayout);
        this.f460a = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(true);
        ViewCompat.m2584a(this, new OnApplyWindowInsetsListener() { // from class: android.support.design.internal.ScrimInsetsFrameLayout.1
            @Override // android.support.v4.view.OnApplyWindowInsetsListener
            /* JADX INFO: renamed from: a */
            public WindowInsetsCompat mo399a(View view, WindowInsetsCompat windowInsetsCompat) {
                if (ScrimInsetsFrameLayout.this.f461b == null) {
                    ScrimInsetsFrameLayout.this.f461b = new Rect();
                }
                ScrimInsetsFrameLayout.this.f461b.set(windowInsetsCompat.m2768a(), windowInsetsCompat.m2770b(), windowInsetsCompat.m2771c(), windowInsetsCompat.m2772d());
                ScrimInsetsFrameLayout.this.mo398a(windowInsetsCompat);
                ScrimInsetsFrameLayout.this.setWillNotDraw(!windowInsetsCompat.m2773e() || ScrimInsetsFrameLayout.this.f460a == null);
                ViewCompat.m2597c(ScrimInsetsFrameLayout.this);
                return windowInsetsCompat.m2775g();
            }
        });
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f461b != null && this.f460a != null) {
            int iSave = canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            this.f462c.set(0, 0, width, this.f461b.top);
            this.f460a.setBounds(this.f462c);
            this.f460a.draw(canvas);
            this.f462c.set(0, height - this.f461b.bottom, width, height);
            this.f460a.setBounds(this.f462c);
            this.f460a.draw(canvas);
            this.f462c.set(0, this.f461b.top, this.f461b.left, height - this.f461b.bottom);
            this.f460a.setBounds(this.f462c);
            this.f460a.draw(canvas);
            this.f462c.set(width - this.f461b.right, this.f461b.top, width, height - this.f461b.bottom);
            this.f460a.setBounds(this.f462c);
            this.f460a.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f460a != null) {
            this.f460a.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f460a != null) {
            this.f460a.setCallback(null);
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo398a(WindowInsetsCompat windowInsetsCompat) {
    }
}
