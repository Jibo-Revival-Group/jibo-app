package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.api.client.googleapis.media.MediaHttpUploader;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a */
    Drawable f3472a;

    /* JADX INFO: renamed from: b */
    Drawable f3473b;

    /* JADX INFO: renamed from: c */
    Drawable f3474c;

    /* JADX INFO: renamed from: d */
    boolean f3475d;

    /* JADX INFO: renamed from: e */
    boolean f3476e;

    /* JADX INFO: renamed from: f */
    private boolean f3477f;

    /* JADX INFO: renamed from: g */
    private View f3478g;

    /* JADX INFO: renamed from: h */
    private View f3479h;

    /* JADX INFO: renamed from: i */
    private View f3480i;

    /* JADX INFO: renamed from: j */
    private int f3481j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewCompat.m2582a(this, Build.VERSION.SDK_INT >= 21 ? new ActionBarBackgroundDrawableV21(this) : new ActionBarBackgroundDrawable(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.f3472a = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.f3473b = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.f3481j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        if (getId() == R.id.split_action_bar) {
            this.f3475d = true;
            this.f3474c = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(this.f3475d ? this.f3474c == null : this.f3472a == null && this.f3473b == null);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f3479h = findViewById(R.id.action_bar);
        this.f3480i = findViewById(R.id.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.f3472a != null) {
            this.f3472a.setCallback(null);
            unscheduleDrawable(this.f3472a);
        }
        this.f3472a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f3479h != null) {
                this.f3472a.setBounds(this.f3479h.getLeft(), this.f3479h.getTop(), this.f3479h.getRight(), this.f3479h.getBottom());
            }
        }
        if (this.f3475d) {
            if (this.f3474c != null) {
                z = false;
            }
        } else if (this.f3472a != null || this.f3473b != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.f3473b != null) {
            this.f3473b.setCallback(null);
            unscheduleDrawable(this.f3473b);
        }
        this.f3473b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f3476e && this.f3473b != null) {
                this.f3473b.setBounds(this.f3478g.getLeft(), this.f3478g.getTop(), this.f3478g.getRight(), this.f3478g.getBottom());
            }
        }
        if (this.f3475d) {
            if (this.f3474c != null) {
                z = false;
            }
        } else if (this.f3472a != null || this.f3473b != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.f3474c != null) {
            this.f3474c.setCallback(null);
            unscheduleDrawable(this.f3474c);
        }
        this.f3474c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f3475d && this.f3474c != null) {
                this.f3474c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.f3475d) {
            if (this.f3474c != null) {
                z = false;
            }
        } else if (this.f3472a != null || this.f3473b != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f3472a != null) {
            this.f3472a.setVisible(z, false);
        }
        if (this.f3473b != null) {
            this.f3473b.setVisible(z, false);
        }
        if (this.f3474c != null) {
            this.f3474c.setVisible(z, false);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f3472a && !this.f3475d) || (drawable == this.f3473b && this.f3476e) || ((drawable == this.f3474c && this.f3475d) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3472a != null && this.f3472a.isStateful()) {
            this.f3472a.setState(getDrawableState());
        }
        if (this.f3473b != null && this.f3473b.isStateful()) {
            this.f3473b.setState(getDrawableState());
        }
        if (this.f3474c != null && this.f3474c.isStateful()) {
            this.f3474c.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f3472a != null) {
            this.f3472a.jumpToCurrentState();
        }
        if (this.f3473b != null) {
            this.f3473b.jumpToCurrentState();
        }
        if (this.f3474c != null) {
            this.f3474c.jumpToCurrentState();
        }
    }

    public void setTransitioning(boolean z) {
        this.f3477f = z;
        setDescendantFocusability(z ? 393216 : MediaHttpUploader.MINIMUM_CHUNK_SIZE);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f3477f || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.f3478g != null) {
            removeView(this.f3478g);
        }
        this.f3478g = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.f3478g;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3692a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* JADX INFO: renamed from: b */
    private int m3693b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + view.getMeasuredHeight() + layoutParams.topMargin;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int iM3693b;
        if (this.f3479h == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.f3481j >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(this.f3481j, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f3479h != null) {
            int mode = View.MeasureSpec.getMode(i2);
            if (this.f3478g != null && this.f3478g.getVisibility() != 8 && mode != 1073741824) {
                if (!m3692a(this.f3479h)) {
                    iM3693b = m3693b(this.f3479h);
                } else if (!m3692a(this.f3480i)) {
                    iM3693b = m3693b(this.f3480i);
                } else {
                    iM3693b = 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(iM3693b + m3693b(this.f3478g), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3 = true;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f3478g;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (this.f3475d) {
            if (this.f3474c != null) {
                this.f3474c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z3 = false;
            }
        } else {
            if (this.f3472a != null) {
                if (this.f3479h.getVisibility() == 0) {
                    this.f3472a.setBounds(this.f3479h.getLeft(), this.f3479h.getTop(), this.f3479h.getRight(), this.f3479h.getBottom());
                } else if (this.f3480i != null && this.f3480i.getVisibility() == 0) {
                    this.f3472a.setBounds(this.f3480i.getLeft(), this.f3480i.getTop(), this.f3480i.getRight(), this.f3480i.getBottom());
                } else {
                    this.f3472a.setBounds(0, 0, 0, 0);
                }
                z2 = true;
            } else {
                z2 = false;
            }
            this.f3476e = z4;
            if (!z4 || this.f3473b == null) {
                z3 = z2;
            } else {
                this.f3473b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z3) {
            invalidate();
        }
    }
}
