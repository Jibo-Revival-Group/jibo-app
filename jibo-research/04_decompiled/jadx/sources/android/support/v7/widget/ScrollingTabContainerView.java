package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: l */
    private static final Interpolator f4195l = new DecelerateInterpolator();

    /* JADX INFO: renamed from: a */
    Runnable f4196a;

    /* JADX INFO: renamed from: b */
    LinearLayoutCompat f4197b;

    /* JADX INFO: renamed from: c */
    int f4198c;

    /* JADX INFO: renamed from: d */
    int f4199d;

    /* JADX INFO: renamed from: e */
    protected ViewPropertyAnimator f4200e;

    /* JADX INFO: renamed from: f */
    protected final VisibilityAnimListener f4201f;

    /* JADX INFO: renamed from: g */
    private TabClickListener f4202g;

    /* JADX INFO: renamed from: h */
    private Spinner f4203h;

    /* JADX INFO: renamed from: i */
    private boolean f4204i;

    /* JADX INFO: renamed from: j */
    private int f4205j;

    /* JADX INFO: renamed from: k */
    private int f4206k;

    public ScrollingTabContainerView(Context context) {
        super(context);
        this.f4201f = new VisibilityAnimListener();
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy actionBarPolicyM3462a = ActionBarPolicy.m3462a(context);
        setContentHeight(actionBarPolicyM3462a.m3467e());
        this.f4199d = actionBarPolicyM3462a.m3469g();
        this.f4197b = m4721e();
        addView(this.f4197b, new ViewGroup.LayoutParams(-2, -1));
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f4197b.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.f4198c = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.f4198c = View.MeasureSpec.getSize(i) / 2;
            }
            this.f4198c = Math.min(this.f4198c, this.f4199d);
        } else {
            this.f4198c = -1;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f4205j, 1073741824);
        if (!z && this.f4204i) {
            this.f4197b.measure(0, iMakeMeasureSpec);
            if (this.f4197b.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                m4719c();
            } else {
                m4720d();
            }
        } else {
            m4720d();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z && measuredWidth != measuredWidth2) {
            setTabSelected(this.f4206k);
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m4718b() {
        return this.f4203h != null && this.f4203h.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.f4204i = z;
    }

    /* JADX INFO: renamed from: c */
    private void m4719c() {
        if (!m4718b()) {
            if (this.f4203h == null) {
                this.f4203h = m4722f();
            }
            removeView(this.f4197b);
            addView(this.f4203h, new ViewGroup.LayoutParams(-2, -1));
            if (this.f4203h.getAdapter() == null) {
                this.f4203h.setAdapter((SpinnerAdapter) new TabAdapter());
            }
            if (this.f4196a != null) {
                removeCallbacks(this.f4196a);
                this.f4196a = null;
            }
            this.f4203h.setSelection(this.f4206k);
        }
    }

    /* JADX INFO: renamed from: d */
    private boolean m4720d() {
        if (m4718b()) {
            removeView(this.f4203h);
            addView(this.f4197b, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.f4203h.getSelectedItemPosition());
        }
        return false;
    }

    public void setTabSelected(int i) {
        this.f4206k = i;
        int childCount = this.f4197b.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f4197b.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                m4725a(i);
            }
            i2++;
        }
        if (this.f4203h != null && i >= 0) {
            this.f4203h.setSelection(i);
        }
    }

    public void setContentHeight(int i) {
        this.f4205j = i;
        requestLayout();
    }

    /* JADX INFO: renamed from: e */
    private LinearLayoutCompat m4721e() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    /* JADX INFO: renamed from: f */
    private Spinner m4722f() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionBarPolicy actionBarPolicyM3462a = ActionBarPolicy.m3462a(getContext());
        setContentHeight(actionBarPolicyM3462a.m3467e());
        this.f4199d = actionBarPolicyM3462a.m3469g();
    }

    /* JADX INFO: renamed from: a */
    public void m4725a(int i) {
        final View childAt = this.f4197b.getChildAt(i);
        if (this.f4196a != null) {
            removeCallbacks(this.f4196a);
        }
        this.f4196a = new Runnable() { // from class: android.support.v7.widget.ScrollingTabContainerView.1
            @Override // java.lang.Runnable
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                ScrollingTabContainerView.this.f4196a = null;
            }
        };
        post(this.f4196a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4196a != null) {
            post(this.f4196a);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f4196a != null) {
            removeCallbacks(this.f4196a);
        }
    }

    /* JADX INFO: renamed from: a */
    TabView m4723a(ActionBar.Tab tab, boolean z) {
        TabView tabView = new TabView(getContext(), tab, z);
        if (z) {
            tabView.setBackgroundDrawable(null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.f4205j));
        } else {
            tabView.setFocusable(true);
            if (this.f4202g == null) {
                this.f4202g = new TabClickListener();
            }
            tabView.setOnClickListener(this.f4202g);
        }
        return tabView;
    }

    /* JADX INFO: renamed from: b */
    public void m4728b(ActionBar.Tab tab, boolean z) {
        TabView tabViewM4723a = m4723a(tab, false);
        this.f4197b.addView(tabViewM4723a, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        if (this.f4203h != null) {
            ((TabAdapter) this.f4203h.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            tabViewM4723a.setSelected(true);
        }
        if (this.f4204i) {
            requestLayout();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m4726a(ActionBar.Tab tab, int i, boolean z) {
        TabView tabViewM4723a = m4723a(tab, false);
        this.f4197b.addView(tabViewM4723a, i, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        if (this.f4203h != null) {
            ((TabAdapter) this.f4203h.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            tabViewM4723a.setSelected(true);
        }
        if (this.f4204i) {
            requestLayout();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m4727b(int i) {
        this.f4197b.removeViewAt(i);
        if (this.f4203h != null) {
            ((TabAdapter) this.f4203h.getAdapter()).notifyDataSetChanged();
        }
        if (this.f4204i) {
            requestLayout();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m4724a() {
        this.f4197b.removeAllViews();
        if (this.f4203h != null) {
            ((TabAdapter) this.f4203h.getAdapter()).notifyDataSetChanged();
        }
        if (this.f4204i) {
            requestLayout();
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((TabView) view).m4731b().mo3179e();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    private class TabView extends LinearLayout {

        /* JADX INFO: renamed from: b */
        private final int[] f4212b;

        /* JADX INFO: renamed from: c */
        private ActionBar.Tab f4213c;

        /* JADX INFO: renamed from: d */
        private TextView f4214d;

        /* JADX INFO: renamed from: e */
        private ImageView f4215e;

        /* JADX INFO: renamed from: f */
        private View f4216f;

        public TabView(Context context, ActionBar.Tab tab, boolean z) {
            super(context, null, R.attr.actionBarTabStyle);
            this.f4212b = new int[]{android.R.attr.background};
            this.f4213c = tab;
            TintTypedArray tintTypedArrayM4955a = TintTypedArray.m4955a(context, null, this.f4212b, R.attr.actionBarTabStyle, 0);
            if (tintTypedArrayM4955a.m4973g(0)) {
                setBackgroundDrawable(tintTypedArrayM4955a.m4959a(0));
            }
            tintTypedArrayM4955a.m4960a();
            if (z) {
                setGravity(8388627);
            }
            m4729a();
        }

        /* JADX INFO: renamed from: a */
        public void m4730a(ActionBar.Tab tab) {
            this.f4213c = tab;
            m4729a();
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (ScrollingTabContainerView.this.f4198c > 0 && getMeasuredWidth() > ScrollingTabContainerView.this.f4198c) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(ScrollingTabContainerView.this.f4198c, 1073741824), i2);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m4729a() {
            ActionBar.Tab tab = this.f4213c;
            View viewMo3178d = tab.mo3178d();
            if (viewMo3178d != null) {
                ViewParent parent = viewMo3178d.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewMo3178d);
                    }
                    addView(viewMo3178d);
                }
                this.f4216f = viewMo3178d;
                if (this.f4214d != null) {
                    this.f4214d.setVisibility(8);
                }
                if (this.f4215e != null) {
                    this.f4215e.setVisibility(8);
                    this.f4215e.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (this.f4216f != null) {
                removeView(this.f4216f);
                this.f4216f = null;
            }
            Drawable drawableMo3176b = tab.mo3176b();
            CharSequence charSequenceMo3177c = tab.mo3177c();
            if (drawableMo3176b != null) {
                if (this.f4215e == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f4215e = appCompatImageView;
                }
                this.f4215e.setImageDrawable(drawableMo3176b);
                this.f4215e.setVisibility(0);
            } else if (this.f4215e != null) {
                this.f4215e.setVisibility(8);
                this.f4215e.setImageDrawable(null);
            }
            boolean z = !TextUtils.isEmpty(charSequenceMo3177c);
            if (z) {
                if (this.f4214d == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f4214d = appCompatTextView;
                }
                this.f4214d.setText(charSequenceMo3177c);
                this.f4214d.setVisibility(0);
            } else if (this.f4214d != null) {
                this.f4214d.setVisibility(8);
                this.f4214d.setText((CharSequence) null);
            }
            if (this.f4215e != null) {
                this.f4215e.setContentDescription(tab.mo3180f());
            }
            TooltipCompat.m4985a(this, z ? null : tab.mo3180f());
        }

        /* JADX INFO: renamed from: b */
        public ActionBar.Tab m4731b() {
            return this.f4213c;
        }
    }

    private class TabAdapter extends BaseAdapter {
        TabAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScrollingTabContainerView.this.f4197b.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((TabView) ScrollingTabContainerView.this.f4197b.getChildAt(i)).m4731b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.m4723a((ActionBar.Tab) getItem(i), true);
            }
            ((TabView) view).m4730a((ActionBar.Tab) getItem(i));
            return view;
        }
    }

    private class TabClickListener implements View.OnClickListener {
        TabClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((TabView) view).m4731b().mo3179e();
            int childCount = ScrollingTabContainerView.this.f4197b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ScrollingTabContainerView.this.f4197b.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    protected class VisibilityAnimListener extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b */
        private boolean f4218b = false;

        /* JADX INFO: renamed from: c */
        private int f4219c;

        protected VisibilityAnimListener() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f4218b = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f4218b) {
                ScrollingTabContainerView.this.f4200e = null;
                ScrollingTabContainerView.this.setVisibility(this.f4219c);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f4218b = true;
        }
    }
}
