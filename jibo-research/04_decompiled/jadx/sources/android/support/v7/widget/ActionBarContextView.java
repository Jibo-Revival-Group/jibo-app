package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionMode;
import android.support.v7.view.menu.MenuBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends AbsActionBarView {

    /* JADX INFO: renamed from: g */
    private CharSequence f3482g;

    /* JADX INFO: renamed from: h */
    private CharSequence f3483h;

    /* JADX INFO: renamed from: i */
    private View f3484i;

    /* JADX INFO: renamed from: j */
    private View f3485j;

    /* JADX INFO: renamed from: k */
    private LinearLayout f3486k;

    /* JADX INFO: renamed from: l */
    private TextView f3487l;

    /* JADX INFO: renamed from: m */
    private TextView f3488m;

    /* JADX INFO: renamed from: n */
    private int f3489n;

    /* JADX INFO: renamed from: o */
    private int f3490o;

    /* JADX INFO: renamed from: p */
    private boolean f3491p;

    /* JADX INFO: renamed from: q */
    private int f3492q;

    @Override // android.support.v7.widget.AbsActionBarView
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat mo3689a(int i, long j) {
        return super.mo3689a(i, j);
    }

    @Override // android.support.v7.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // android.support.v7.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    @Override // android.support.v7.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.support.v7.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.support.v7.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintTypedArray tintTypedArrayM4955a = TintTypedArray.m4955a(context, attributeSet, R.styleable.ActionMode, i, 0);
        ViewCompat.m2582a(this, tintTypedArrayM4955a.m4959a(R.styleable.ActionMode_background));
        this.f3489n = tintTypedArrayM4955a.m4972g(R.styleable.ActionMode_titleTextStyle, 0);
        this.f3490o = tintTypedArrayM4955a.m4972g(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.f3464e = tintTypedArrayM4955a.m4970f(R.styleable.ActionMode_height, 0);
        this.f3492q = tintTypedArrayM4955a.m4972g(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        tintTypedArrayM4955a.m4960a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f3463d != null) {
            this.f3463d.m3736g();
            this.f3463d.m3738i();
        }
    }

    @Override // android.support.v7.widget.AbsActionBarView
    public void setContentHeight(int i) {
        this.f3464e = i;
    }

    public void setCustomView(View view) {
        if (this.f3485j != null) {
            removeView(this.f3485j);
        }
        this.f3485j = view;
        if (view != null && this.f3486k != null) {
            removeView(this.f3486k);
            this.f3486k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.f3482g = charSequence;
        m3694e();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f3483h = charSequence;
        m3694e();
    }

    public CharSequence getTitle() {
        return this.f3482g;
    }

    public CharSequence getSubtitle() {
        return this.f3483h;
    }

    /* JADX INFO: renamed from: e */
    private void m3694e() {
        if (this.f3486k == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            this.f3486k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f3487l = (TextView) this.f3486k.findViewById(R.id.action_bar_title);
            this.f3488m = (TextView) this.f3486k.findViewById(R.id.action_bar_subtitle);
            if (this.f3489n != 0) {
                this.f3487l.setTextAppearance(getContext(), this.f3489n);
            }
            if (this.f3490o != 0) {
                this.f3488m.setTextAppearance(getContext(), this.f3490o);
            }
        }
        this.f3487l.setText(this.f3482g);
        this.f3488m.setText(this.f3483h);
        boolean z = !TextUtils.isEmpty(this.f3482g);
        boolean z2 = TextUtils.isEmpty(this.f3483h) ? false : true;
        this.f3488m.setVisibility(z2 ? 0 : 8);
        this.f3486k.setVisibility((z || z2) ? 0 : 8);
        if (this.f3486k.getParent() == null) {
            addView(this.f3486k);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3695a(final ActionMode actionMode) {
        if (this.f3484i == null) {
            this.f3484i = LayoutInflater.from(getContext()).inflate(this.f3492q, (ViewGroup) this, false);
            addView(this.f3484i);
        } else if (this.f3484i.getParent() == null) {
            addView(this.f3484i);
        }
        this.f3484i.findViewById(R.id.action_mode_close_button).setOnClickListener(new View.OnClickListener() { // from class: android.support.v7.widget.ActionBarContextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                actionMode.mo3409c();
            }
        });
        MenuBuilder menuBuilder = (MenuBuilder) actionMode.mo3406b();
        if (this.f3463d != null) {
            this.f3463d.m3737h();
        }
        this.f3463d = new ActionMenuPresenter(getContext());
        this.f3463d.m3732c(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuBuilder.m3590a(this.f3463d, this.f3461b);
        this.f3462c = (ActionMenuView) this.f3463d.mo3514a(this);
        ViewCompat.m2582a(this.f3462c, (Drawable) null);
        addView(this.f3462c, layoutParams);
    }

    /* JADX INFO: renamed from: b */
    public void m3696b() {
        if (this.f3484i == null) {
            m3697c();
        }
    }

    /* JADX INFO: renamed from: c */
    public void m3697c() {
        removeAllViews();
        this.f3485j = null;
        this.f3462c = null;
    }

    @Override // android.support.v7.widget.AbsActionBarView
    /* JADX INFO: renamed from: a */
    public boolean mo3690a() {
        if (this.f3463d != null) {
            return this.f3463d.m3735f();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.f3464e > 0 ? this.f3464e : View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i4 = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
        if (this.f3484i != null) {
            int iA = m3687a(this.f3484i, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f3484i.getLayoutParams();
            paddingLeft = iA - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
        }
        if (this.f3462c != null && this.f3462c.getParent() == this) {
            paddingLeft = m3687a(this.f3462c, paddingLeft, iMakeMeasureSpec, 0);
        }
        if (this.f3486k != null && this.f3485j == null) {
            if (this.f3491p) {
                this.f3486k.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f3486k.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.f3486k.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = m3687a(this.f3486k, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        if (this.f3485j != null) {
            ViewGroup.LayoutParams layoutParams = this.f3485j.getLayoutParams();
            int i5 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (layoutParams.width >= 0) {
                paddingLeft = Math.min(layoutParams.width, paddingLeft);
            }
            this.f3485j.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i5), View.MeasureSpec.makeMeasureSpec(layoutParams.height >= 0 ? Math.min(layoutParams.height, i4) : i4, layoutParams.height == -2 ? Integer.MIN_VALUE : 1073741824));
        }
        if (this.f3464e <= 0) {
            int childCount = getChildCount();
            int i6 = 0;
            while (i3 < childCount) {
                int measuredHeight = getChildAt(i3).getMeasuredHeight() + paddingTop;
                if (measuredHeight <= i6) {
                    measuredHeight = i6;
                }
                i3++;
                i6 = measuredHeight;
            }
            setMeasuredDimension(size, i6);
            return;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iA;
        boolean zM5031a = ViewUtils.m5031a(this);
        int paddingRight = zM5031a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f3484i == null || this.f3484i.getVisibility() == 8) {
            iA = paddingRight;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f3484i.getLayoutParams();
            int i5 = zM5031a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = zM5031a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iA2 = m3684a(paddingRight, i5, zM5031a);
            iA = m3684a(m3688a(this.f3484i, iA2, paddingTop, paddingTop2, zM5031a) + iA2, i6, zM5031a);
        }
        if (this.f3486k != null && this.f3485j == null && this.f3486k.getVisibility() != 8) {
            iA += m3688a(this.f3486k, iA, paddingTop, paddingTop2, zM5031a);
        }
        if (this.f3485j != null) {
            int iA3 = m3688a(this.f3485j, iA, paddingTop, paddingTop2, zM5031a) + iA;
        }
        int paddingLeft = zM5031a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.f3462c != null) {
            int iA4 = m3688a(this.f3462c, paddingLeft, paddingTop, paddingTop2, !zM5031a) + paddingLeft;
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f3482g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f3491p) {
            requestLayout();
        }
        this.f3491p = z;
    }

    /* JADX INFO: renamed from: d */
    public boolean m3698d() {
        return this.f3491p;
    }
}
