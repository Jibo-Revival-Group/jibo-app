package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.ShowableListMenu;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {

    /* JADX INFO: renamed from: a */
    final ActivityChooserViewAdapter f3600a;

    /* JADX INFO: renamed from: b */
    final FrameLayout f3601b;

    /* JADX INFO: renamed from: c */
    final FrameLayout f3602c;

    /* JADX INFO: renamed from: d */
    ActionProvider f3603d;

    /* JADX INFO: renamed from: e */
    final DataSetObserver f3604e;

    /* JADX INFO: renamed from: f */
    PopupWindow.OnDismissListener f3605f;

    /* JADX INFO: renamed from: g */
    boolean f3606g;

    /* JADX INFO: renamed from: h */
    int f3607h;

    /* JADX INFO: renamed from: i */
    private final Callbacks f3608i;

    /* JADX INFO: renamed from: j */
    private final LinearLayoutCompat f3609j;

    /* JADX INFO: renamed from: k */
    private final Drawable f3610k;

    /* JADX INFO: renamed from: l */
    private final ImageView f3611l;

    /* JADX INFO: renamed from: m */
    private final ImageView f3612m;

    /* JADX INFO: renamed from: n */
    private final int f3613n;

    /* JADX INFO: renamed from: o */
    private final ViewTreeObserver.OnGlobalLayoutListener f3614o;

    /* JADX INFO: renamed from: p */
    private ListPopupWindow f3615p;

    /* JADX INFO: renamed from: q */
    private boolean f3616q;

    /* JADX INFO: renamed from: r */
    private int f3617r;

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3604e = new DataSetObserver() { // from class: android.support.v7.widget.ActivityChooserView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.f3600a.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.f3600a.notifyDataSetInvalidated();
            }
        };
        this.f3614o = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.widget.ActivityChooserView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (ActivityChooserView.this.m3785c()) {
                    if (!ActivityChooserView.this.isShown()) {
                        ActivityChooserView.this.getListPopupWindow().mo3547e();
                        return;
                    }
                    ActivityChooserView.this.getListPopupWindow().mo3546d();
                    if (ActivityChooserView.this.f3603d != null) {
                        ActivityChooserView.this.f3603d.m2492a(true);
                    }
                }
            }
        };
        this.f3607h = 4;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActivityChooserView, i, 0);
        this.f3607h = typedArrayObtainStyledAttributes.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, (ViewGroup) this, true);
        this.f3608i = new Callbacks();
        this.f3609j = (LinearLayoutCompat) findViewById(R.id.activity_chooser_view_content);
        this.f3610k = this.f3609j.getBackground();
        this.f3602c = (FrameLayout) findViewById(R.id.default_activity_button);
        this.f3602c.setOnClickListener(this.f3608i);
        this.f3602c.setOnLongClickListener(this.f3608i);
        this.f3612m = (ImageView) this.f3602c.findViewById(R.id.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.expand_activities_button);
        frameLayout.setOnClickListener(this.f3608i);
        frameLayout.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: android.support.v7.widget.ActivityChooserView.3
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                AccessibilityNodeInfoCompat.m2779a(accessibilityNodeInfo).m2823m(true);
            }
        });
        frameLayout.setOnTouchListener(new ForwardingListener(frameLayout) { // from class: android.support.v7.widget.ActivityChooserView.4
            @Override // android.support.v7.widget.ForwardingListener
            /* JADX INFO: renamed from: a */
            public ShowableListMenu mo3511a() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            @Override // android.support.v7.widget.ForwardingListener
            /* JADX INFO: renamed from: b */
            protected boolean mo3512b() {
                ActivityChooserView.this.m3783a();
                return true;
            }

            @Override // android.support.v7.widget.ForwardingListener
            /* JADX INFO: renamed from: c */
            protected boolean mo3741c() {
                ActivityChooserView.this.m3784b();
                return true;
            }
        });
        this.f3601b = frameLayout;
        this.f3611l = (ImageView) frameLayout.findViewById(R.id.image);
        this.f3611l.setImageDrawable(drawable);
        this.f3600a = new ActivityChooserViewAdapter();
        this.f3600a.registerDataSetObserver(new DataSetObserver() { // from class: android.support.v7.widget.ActivityChooserView.5
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.m3786d();
            }
        });
        Resources resources = context.getResources();
        this.f3613n = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }

    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        this.f3600a.m3789a(activityChooserModel);
        if (m3785c()) {
            m3784b();
            m3783a();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f3611l.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f3611l.setContentDescription(getContext().getString(i));
    }

    public void setProvider(ActionProvider actionProvider) {
        this.f3603d = actionProvider;
    }

    /* JADX INFO: renamed from: a */
    public boolean m3783a() {
        if (m3785c() || !this.f3616q) {
            return false;
        }
        this.f3606g = false;
        m3782a(this.f3607h);
        return true;
    }

    /* JADX INFO: renamed from: a */
    void m3782a(int i) {
        if (this.f3600a.m3795e() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f3614o);
        boolean z = this.f3602c.getVisibility() == 0;
        int iM3793c = this.f3600a.m3793c();
        int i2 = z ? 1 : 0;
        if (i != Integer.MAX_VALUE && iM3793c > i2 + i) {
            this.f3600a.m3790a(true);
            this.f3600a.m3788a(i - 1);
        } else {
            this.f3600a.m3790a(false);
            this.f3600a.m3788a(i);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.mo3548f()) {
            if (this.f3606g || !z) {
                this.f3600a.m3791a(true, z);
            } else {
                this.f3600a.m3791a(false, false);
            }
            listPopupWindow.m4377g(Math.min(this.f3600a.m3787a(), this.f3613n));
            listPopupWindow.mo3546d();
            if (this.f3603d != null) {
                this.f3603d.m2492a(true);
            }
            listPopupWindow.mo3549g().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
            listPopupWindow.mo3549g().setSelector(new ColorDrawable(0));
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m3784b() {
        if (m3785c()) {
            getListPopupWindow().mo3547e();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f3614o);
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: renamed from: c */
    public boolean m3785c() {
        return getListPopupWindow().mo3548f();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel activityChooserModelM3795e = this.f3600a.m3795e();
        if (activityChooserModelM3795e != null) {
            activityChooserModelM3795e.registerObserver(this.f3604e);
        }
        this.f3616q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel activityChooserModelM3795e = this.f3600a.m3795e();
        if (activityChooserModelM3795e != null) {
            activityChooserModelM3795e.unregisterObserver(this.f3604e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f3614o);
        }
        if (m3785c()) {
            m3784b();
        }
        this.f3616q = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        LinearLayoutCompat linearLayoutCompat = this.f3609j;
        if (this.f3602c.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(linearLayoutCompat, i, i2);
        setMeasuredDimension(linearLayoutCompat.getMeasuredWidth(), linearLayoutCompat.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f3609j.layout(0, 0, i3 - i, i4 - i2);
        if (!m3785c()) {
            m3784b();
        }
    }

    public ActivityChooserModel getDataModel() {
        return this.f3600a.m3795e();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f3605f = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.f3607h = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f3617r = i;
    }

    ListPopupWindow getListPopupWindow() {
        if (this.f3615p == null) {
            this.f3615p = new ListPopupWindow(getContext());
            this.f3615p.mo3919a(this.f3600a);
            this.f3615p.m4370b(this);
            this.f3615p.m4368a(true);
            this.f3615p.m4366a((AdapterView.OnItemClickListener) this.f3608i);
            this.f3615p.m4367a((PopupWindow.OnDismissListener) this.f3608i);
        }
        return this.f3615p;
    }

    /* JADX INFO: renamed from: d */
    void m3786d() {
        if (this.f3600a.getCount() > 0) {
            this.f3601b.setEnabled(true);
        } else {
            this.f3601b.setEnabled(false);
        }
        int iM3793c = this.f3600a.m3793c();
        int iM3794d = this.f3600a.m3794d();
        if (iM3793c == 1 || (iM3793c > 1 && iM3794d > 0)) {
            this.f3602c.setVisibility(0);
            ResolveInfo resolveInfoM3792b = this.f3600a.m3792b();
            PackageManager packageManager = getContext().getPackageManager();
            this.f3612m.setImageDrawable(resolveInfoM3792b.loadIcon(packageManager));
            if (this.f3617r != 0) {
                this.f3602c.setContentDescription(getContext().getString(this.f3617r, resolveInfoM3792b.loadLabel(packageManager)));
            }
        } else {
            this.f3602c.setVisibility(8);
        }
        if (this.f3602c.getVisibility() == 0) {
            this.f3609j.setBackgroundDrawable(this.f3610k);
        } else {
            this.f3609j.setBackgroundDrawable(null);
        }
    }

    private class Callbacks implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
        Callbacks() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((ActivityChooserViewAdapter) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    ActivityChooserView.this.m3784b();
                    if (ActivityChooserView.this.f3606g) {
                        if (i > 0) {
                            ActivityChooserView.this.f3600a.m3795e().m3777c(i);
                            return;
                        }
                        return;
                    }
                    if (!ActivityChooserView.this.f3600a.m3796f()) {
                        i++;
                    }
                    Intent intentM3774b = ActivityChooserView.this.f3600a.m3795e().m3774b(i);
                    if (intentM3774b != null) {
                        intentM3774b.addFlags(524288);
                        ActivityChooserView.this.getContext().startActivity(intentM3774b);
                        return;
                    }
                    return;
                case 1:
                    ActivityChooserView.this.m3782a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == ActivityChooserView.this.f3602c) {
                ActivityChooserView.this.m3784b();
                Intent intentM3774b = ActivityChooserView.this.f3600a.m3795e().m3774b(ActivityChooserView.this.f3600a.m3795e().m3772a(ActivityChooserView.this.f3600a.m3792b()));
                if (intentM3774b != null) {
                    intentM3774b.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(intentM3774b);
                    return;
                }
                return;
            }
            if (view == ActivityChooserView.this.f3601b) {
                ActivityChooserView.this.f3606g = false;
                ActivityChooserView.this.m3782a(ActivityChooserView.this.f3607h);
                return;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view == ActivityChooserView.this.f3602c) {
                if (ActivityChooserView.this.f3600a.getCount() > 0) {
                    ActivityChooserView.this.f3606g = true;
                    ActivityChooserView.this.m3782a(ActivityChooserView.this.f3607h);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            m3797a();
            if (ActivityChooserView.this.f3603d != null) {
                ActivityChooserView.this.f3603d.m2492a(false);
            }
        }

        /* JADX INFO: renamed from: a */
        private void m3797a() {
            if (ActivityChooserView.this.f3605f != null) {
                ActivityChooserView.this.f3605f.onDismiss();
            }
        }
    }

    private class ActivityChooserViewAdapter extends BaseAdapter {

        /* JADX INFO: renamed from: b */
        private ActivityChooserModel f3624b;

        /* JADX INFO: renamed from: c */
        private int f3625c = 4;

        /* JADX INFO: renamed from: d */
        private boolean f3626d;

        /* JADX INFO: renamed from: e */
        private boolean f3627e;

        /* JADX INFO: renamed from: f */
        private boolean f3628f;

        ActivityChooserViewAdapter() {
        }

        /* JADX INFO: renamed from: a */
        public void m3789a(ActivityChooserModel activityChooserModel) {
            ActivityChooserModel activityChooserModelM3795e = ActivityChooserView.this.f3600a.m3795e();
            if (activityChooserModelM3795e != null && ActivityChooserView.this.isShown()) {
                activityChooserModelM3795e.unregisterObserver(ActivityChooserView.this.f3604e);
            }
            this.f3624b = activityChooserModel;
            if (activityChooserModel != null && ActivityChooserView.this.isShown()) {
                activityChooserModel.registerObserver(ActivityChooserView.this.f3604e);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (this.f3628f && i == getCount() + (-1)) ? 1 : 0;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int iM3771a = this.f3624b.m3771a();
            if (!this.f3626d && this.f3624b.m3775b() != null) {
                iM3771a--;
            }
            int iMin = Math.min(iM3771a, this.f3625c);
            if (this.f3628f) {
                return iMin + 1;
            }
            return iMin;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!this.f3626d && this.f3624b.m3775b() != null) {
                        i++;
                    }
                    return this.f3624b.m3773a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != R.id.list_item) {
                        view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                    ImageView imageView = (ImageView) view.findViewById(R.id.icon);
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(R.id.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.f3626d && i == 0 && this.f3627e) {
                        view.setActivated(true);
                        return view;
                    }
                    view.setActivated(false);
                    return view;
                case 1:
                    if (view == null || view.getId() != 1) {
                        View viewInflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                        viewInflate.setId(1);
                        ((TextView) viewInflate.findViewById(R.id.title)).setText(ActivityChooserView.this.getContext().getString(R.string.abc_activity_chooser_view_see_all));
                        return viewInflate;
                    }
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        /* JADX INFO: renamed from: a */
        public int m3787a() {
            int i = this.f3625c;
            this.f3625c = Integer.MAX_VALUE;
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int iMax = 0;
            for (int i2 = 0; i2 < count; i2++) {
                view = getView(i2, view, null);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                iMax = Math.max(iMax, view.getMeasuredWidth());
            }
            this.f3625c = i;
            return iMax;
        }

        /* JADX INFO: renamed from: a */
        public void m3788a(int i) {
            if (this.f3625c != i) {
                this.f3625c = i;
                notifyDataSetChanged();
            }
        }

        /* JADX INFO: renamed from: b */
        public ResolveInfo m3792b() {
            return this.f3624b.m3775b();
        }

        /* JADX INFO: renamed from: a */
        public void m3790a(boolean z) {
            if (this.f3628f != z) {
                this.f3628f = z;
                notifyDataSetChanged();
            }
        }

        /* JADX INFO: renamed from: c */
        public int m3793c() {
            return this.f3624b.m3771a();
        }

        /* JADX INFO: renamed from: d */
        public int m3794d() {
            return this.f3624b.m3776c();
        }

        /* JADX INFO: renamed from: e */
        public ActivityChooserModel m3795e() {
            return this.f3624b;
        }

        /* JADX INFO: renamed from: a */
        public void m3791a(boolean z, boolean z2) {
            if (this.f3626d != z || this.f3627e != z2) {
                this.f3626d = z;
                this.f3627e = z2;
                notifyDataSetChanged();
            }
        }

        /* JADX INFO: renamed from: f */
        public boolean m3796f() {
            return this.f3626d;
        }
    }

    public static class InnerLayout extends LinearLayout {

        /* JADX INFO: renamed from: a */
        private static final int[] f3630a = {android.R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray tintTypedArrayM4954a = TintTypedArray.m4954a(context, attributeSet, f3630a);
            setBackgroundDrawable(tintTypedArrayM4954a.m4959a(0));
            tintTypedArrayM4954a.m4960a();
        }
    }
}
