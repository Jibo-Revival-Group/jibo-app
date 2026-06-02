package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.ShowableListMenu;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ListPopupWindow implements ShowableListMenu {

    /* JADX INFO: renamed from: a */
    private static Method f4002a;

    /* JADX INFO: renamed from: b */
    private static Method f4003b;

    /* JADX INFO: renamed from: h */
    private static Method f4004h;

    /* JADX INFO: renamed from: A */
    private Drawable f4005A;

    /* JADX INFO: renamed from: B */
    private AdapterView.OnItemClickListener f4006B;

    /* JADX INFO: renamed from: C */
    private AdapterView.OnItemSelectedListener f4007C;

    /* JADX INFO: renamed from: D */
    private final PopupTouchInterceptor f4008D;

    /* JADX INFO: renamed from: E */
    private final PopupScrollListener f4009E;

    /* JADX INFO: renamed from: F */
    private final ListSelectorHider f4010F;

    /* JADX INFO: renamed from: G */
    private Runnable f4011G;

    /* JADX INFO: renamed from: H */
    private final Rect f4012H;

    /* JADX INFO: renamed from: I */
    private Rect f4013I;

    /* JADX INFO: renamed from: J */
    private boolean f4014J;

    /* JADX INFO: renamed from: c */
    DropDownListView f4015c;

    /* JADX INFO: renamed from: d */
    int f4016d;

    /* JADX INFO: renamed from: e */
    final ResizePopupRunnable f4017e;

    /* JADX INFO: renamed from: f */
    final Handler f4018f;

    /* JADX INFO: renamed from: g */
    PopupWindow f4019g;

    /* JADX INFO: renamed from: i */
    private Context f4020i;

    /* JADX INFO: renamed from: j */
    private ListAdapter f4021j;

    /* JADX INFO: renamed from: k */
    private int f4022k;

    /* JADX INFO: renamed from: l */
    private int f4023l;

    /* JADX INFO: renamed from: m */
    private int f4024m;

    /* JADX INFO: renamed from: n */
    private int f4025n;

    /* JADX INFO: renamed from: o */
    private int f4026o;

    /* JADX INFO: renamed from: p */
    private boolean f4027p;

    /* JADX INFO: renamed from: q */
    private boolean f4028q;

    /* JADX INFO: renamed from: r */
    private boolean f4029r;

    /* JADX INFO: renamed from: s */
    private boolean f4030s;

    /* JADX INFO: renamed from: t */
    private int f4031t;

    /* JADX INFO: renamed from: u */
    private boolean f4032u;

    /* JADX INFO: renamed from: v */
    private boolean f4033v;

    /* JADX INFO: renamed from: w */
    private View f4034w;

    /* JADX INFO: renamed from: x */
    private int f4035x;

    /* JADX INFO: renamed from: y */
    private DataSetObserver f4036y;

    /* JADX INFO: renamed from: z */
    private View f4037z;

    static {
        try {
            f4002a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f4003b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            f4004h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
        } catch (NoSuchMethodException e3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f4022k = -2;
        this.f4023l = -2;
        this.f4026o = 1002;
        this.f4028q = true;
        this.f4031t = 0;
        this.f4032u = false;
        this.f4033v = false;
        this.f4016d = Integer.MAX_VALUE;
        this.f4035x = 0;
        this.f4017e = new ResizePopupRunnable();
        this.f4008D = new PopupTouchInterceptor();
        this.f4009E = new PopupScrollListener();
        this.f4010F = new ListSelectorHider();
        this.f4012H = new Rect();
        this.f4020i = context;
        this.f4018f = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i, i2);
        this.f4024m = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f4025n = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f4025n != 0) {
            this.f4027p = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f4019g = new AppCompatPopupWindow(context, attributeSet, i, i2);
        this.f4019g.setInputMethodMode(1);
    }

    /* JADX INFO: renamed from: a */
    public void mo3919a(ListAdapter listAdapter) {
        if (this.f4036y == null) {
            this.f4036y = new PopupDataSetObserver();
        } else if (this.f4021j != null) {
            this.f4021j.unregisterDataSetObserver(this.f4036y);
        }
        this.f4021j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f4036y);
        }
        if (this.f4015c != null) {
            this.f4015c.setAdapter(this.f4021j);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m4363a(int i) {
        this.f4035x = i;
    }

    /* JADX INFO: renamed from: a */
    public void m4368a(boolean z) {
        this.f4014J = z;
        this.f4019g.setFocusable(z);
    }

    /* JADX INFO: renamed from: c */
    public boolean m4373c() {
        return this.f4014J;
    }

    /* JADX INFO: renamed from: h */
    public Drawable m4378h() {
        return this.f4019g.getBackground();
    }

    /* JADX INFO: renamed from: a */
    public void m4365a(Drawable drawable) {
        this.f4019g.setBackgroundDrawable(drawable);
    }

    /* JADX INFO: renamed from: b */
    public void m4369b(int i) {
        this.f4019g.setAnimationStyle(i);
    }

    /* JADX INFO: renamed from: i */
    public View m4380i() {
        return this.f4037z;
    }

    /* JADX INFO: renamed from: b */
    public void m4370b(View view) {
        this.f4037z = view;
    }

    /* JADX INFO: renamed from: j */
    public int m4382j() {
        return this.f4024m;
    }

    /* JADX INFO: renamed from: c */
    public void m4372c(int i) {
        this.f4024m = i;
    }

    /* JADX INFO: renamed from: k */
    public int m4383k() {
        if (this.f4027p) {
            return this.f4025n;
        }
        return 0;
    }

    /* JADX INFO: renamed from: d */
    public void m4374d(int i) {
        this.f4025n = i;
        this.f4027p = true;
    }

    /* JADX INFO: renamed from: a */
    public void m4364a(Rect rect) {
        this.f4013I = rect;
    }

    /* JADX INFO: renamed from: e */
    public void m4375e(int i) {
        this.f4031t = i;
    }

    /* JADX INFO: renamed from: l */
    public int m4384l() {
        return this.f4023l;
    }

    /* JADX INFO: renamed from: f */
    public void m4376f(int i) {
        this.f4023l = i;
    }

    /* JADX INFO: renamed from: g */
    public void m4377g(int i) {
        Drawable background = this.f4019g.getBackground();
        if (background != null) {
            background.getPadding(this.f4012H);
            this.f4023l = this.f4012H.left + this.f4012H.right + i;
        } else {
            m4376f(i);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m4366a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f4006B = onItemClickListener;
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    /* JADX INFO: renamed from: d */
    public void mo3546d() {
        int width;
        int width2;
        int i;
        boolean z = false;
        int iM4360b = m4360b();
        boolean zM4386n = m4386n();
        PopupWindowCompat.m3060a(this.f4019g, this.f4026o);
        if (this.f4019g.isShowing()) {
            if (ViewCompat.m2570B(m4380i())) {
                if (this.f4023l == -1) {
                    width2 = -1;
                } else if (this.f4023l == -2) {
                    width2 = m4380i().getWidth();
                } else {
                    width2 = this.f4023l;
                }
                if (this.f4022k == -1) {
                    if (!zM4386n) {
                        iM4360b = -1;
                    }
                    if (zM4386n) {
                        this.f4019g.setWidth(this.f4023l == -1 ? -1 : 0);
                        this.f4019g.setHeight(0);
                        i = iM4360b;
                    } else {
                        this.f4019g.setWidth(this.f4023l == -1 ? -1 : 0);
                        this.f4019g.setHeight(-1);
                        i = iM4360b;
                    }
                } else {
                    i = this.f4022k == -2 ? iM4360b : this.f4022k;
                }
                PopupWindow popupWindow = this.f4019g;
                if (!this.f4033v && !this.f4032u) {
                    z = true;
                }
                popupWindow.setOutsideTouchable(z);
                PopupWindow popupWindow2 = this.f4019g;
                View viewM4380i = m4380i();
                int i2 = this.f4024m;
                int i3 = this.f4025n;
                if (width2 < 0) {
                    width2 = -1;
                }
                popupWindow2.update(viewM4380i, i2, i3, width2, i >= 0 ? i : -1);
                return;
            }
            return;
        }
        if (this.f4023l == -1) {
            width = -1;
        } else if (this.f4023l == -2) {
            width = m4380i().getWidth();
        } else {
            width = this.f4023l;
        }
        if (this.f4022k == -1) {
            iM4360b = -1;
        } else if (this.f4022k != -2) {
            iM4360b = this.f4022k;
        }
        this.f4019g.setWidth(width);
        this.f4019g.setHeight(iM4360b);
        m4361c(true);
        this.f4019g.setOutsideTouchable((this.f4033v || this.f4032u) ? false : true);
        this.f4019g.setTouchInterceptor(this.f4008D);
        if (this.f4030s) {
            PopupWindowCompat.m3062a(this.f4019g, this.f4029r);
        }
        if (f4004h != null) {
            try {
                f4004h.invoke(this.f4019g, this.f4013I);
            } catch (Exception e) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
            }
        }
        PopupWindowCompat.m3061a(this.f4019g, m4380i(), this.f4024m, this.f4025n, this.f4031t);
        this.f4015c.setSelection(-1);
        if (!this.f4014J || this.f4015c.isInTouchMode()) {
            m4385m();
        }
        if (!this.f4014J) {
            this.f4018f.post(this.f4010F);
        }
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    /* JADX INFO: renamed from: e */
    public void mo3547e() {
        this.f4019g.dismiss();
        m4359a();
        this.f4019g.setContentView(null);
        this.f4015c = null;
        this.f4018f.removeCallbacks(this.f4017e);
    }

    /* JADX INFO: renamed from: a */
    public void m4367a(PopupWindow.OnDismissListener onDismissListener) {
        this.f4019g.setOnDismissListener(onDismissListener);
    }

    /* JADX INFO: renamed from: a */
    private void m4359a() {
        if (this.f4034w != null) {
            ViewParent parent = this.f4034w.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f4034w);
            }
        }
    }

    /* JADX INFO: renamed from: h */
    public void m4379h(int i) {
        this.f4019g.setInputMethodMode(i);
    }

    /* JADX INFO: renamed from: i */
    public void m4381i(int i) {
        DropDownListView dropDownListView = this.f4015c;
        if (mo3548f() && dropDownListView != null) {
            dropDownListView.setListSelectionHidden(false);
            dropDownListView.setSelection(i);
            if (dropDownListView.getChoiceMode() != 0) {
                dropDownListView.setItemChecked(i, true);
            }
        }
    }

    /* JADX INFO: renamed from: m */
    public void m4385m() {
        DropDownListView dropDownListView = this.f4015c;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    /* JADX INFO: renamed from: f */
    public boolean mo3548f() {
        return this.f4019g.isShowing();
    }

    /* JADX INFO: renamed from: n */
    public boolean m4386n() {
        return this.f4019g.getInputMethodMode() == 2;
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    /* JADX INFO: renamed from: g */
    public ListView mo3549g() {
        return this.f4015c;
    }

    /* JADX INFO: renamed from: a */
    DropDownListView mo4362a(Context context, boolean z) {
        return new DropDownListView(context, z);
    }

    /* JADX INFO: renamed from: b */
    private int m4360b() {
        int measuredHeight;
        int i;
        int iMakeMeasureSpec;
        View view;
        int measuredHeight2;
        int i2;
        int i3;
        if (this.f4015c == null) {
            Context context = this.f4020i;
            this.f4011G = new Runnable() { // from class: android.support.v7.widget.ListPopupWindow.2
                @Override // java.lang.Runnable
                public void run() {
                    View viewM4380i = ListPopupWindow.this.m4380i();
                    if (viewM4380i != null && viewM4380i.getWindowToken() != null) {
                        ListPopupWindow.this.mo3546d();
                    }
                }
            };
            this.f4015c = mo4362a(context, !this.f4014J);
            if (this.f4005A != null) {
                this.f4015c.setSelector(this.f4005A);
            }
            this.f4015c.setAdapter(this.f4021j);
            this.f4015c.setOnItemClickListener(this.f4006B);
            this.f4015c.setFocusable(true);
            this.f4015c.setFocusableInTouchMode(true);
            this.f4015c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: android.support.v7.widget.ListPopupWindow.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view2, int i4, long j) {
                    DropDownListView dropDownListView;
                    if (i4 != -1 && (dropDownListView = ListPopupWindow.this.f4015c) != null) {
                        dropDownListView.setListSelectionHidden(false);
                    }
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.f4015c.setOnScrollListener(this.f4009E);
            if (this.f4007C != null) {
                this.f4015c.setOnItemSelectedListener(this.f4007C);
            }
            DropDownListView dropDownListView = this.f4015c;
            View view2 = this.f4034w;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.f4035x) {
                    case 0:
                        linearLayout.addView(view2);
                        linearLayout.addView(dropDownListView, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(dropDownListView, layoutParams);
                        linearLayout.addView(view2);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f4035x);
                        break;
                }
                if (this.f4023l >= 0) {
                    i3 = this.f4023l;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i3 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i3, i2), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight2 = layoutParams2.bottomMargin + view2.getMeasuredHeight() + layoutParams2.topMargin;
                view = linearLayout;
            } else {
                view = dropDownListView;
                measuredHeight2 = 0;
            }
            this.f4019g.setContentView(view);
            measuredHeight = measuredHeight2;
        } else {
            View view3 = this.f4034w;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = layoutParams3.bottomMargin + view3.getMeasuredHeight() + layoutParams3.topMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f4019g.getBackground();
        if (background != null) {
            background.getPadding(this.f4012H);
            int i4 = this.f4012H.top + this.f4012H.bottom;
            if (this.f4027p) {
                i = i4;
            } else {
                this.f4025n = -this.f4012H.top;
                i = i4;
            }
        } else {
            this.f4012H.setEmpty();
            i = 0;
        }
        int iM4358a = m4358a(m4380i(), this.f4025n, this.f4019g.getInputMethodMode() == 2);
        if (this.f4032u || this.f4022k == -1) {
            return iM4358a + i;
        }
        switch (this.f4023l) {
            case -2:
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f4020i.getResources().getDisplayMetrics().widthPixels - (this.f4012H.left + this.f4012H.right), Integer.MIN_VALUE);
                break;
            case -1:
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f4020i.getResources().getDisplayMetrics().widthPixels - (this.f4012H.left + this.f4012H.right), 1073741824);
                break;
            default:
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f4023l, 1073741824);
                break;
        }
        int iMo4129a = this.f4015c.mo4129a(iMakeMeasureSpec, 0, -1, iM4358a - measuredHeight, -1);
        if (iMo4129a > 0) {
            measuredHeight += this.f4015c.getPaddingTop() + this.f4015c.getPaddingBottom() + i;
        }
        return iMo4129a + measuredHeight;
    }

    /* JADX INFO: renamed from: b */
    public void m4371b(boolean z) {
        this.f4030s = true;
        this.f4029r = z;
    }

    private class PopupDataSetObserver extends DataSetObserver {
        PopupDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.mo3548f()) {
                ListPopupWindow.this.mo3546d();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.mo3547e();
        }
    }

    private class ListSelectorHider implements Runnable {
        ListSelectorHider() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.m4385m();
        }
    }

    private class ResizePopupRunnable implements Runnable {
        ResizePopupRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ListPopupWindow.this.f4015c != null && ViewCompat.m2570B(ListPopupWindow.this.f4015c) && ListPopupWindow.this.f4015c.getCount() > ListPopupWindow.this.f4015c.getChildCount() && ListPopupWindow.this.f4015c.getChildCount() <= ListPopupWindow.this.f4016d) {
                ListPopupWindow.this.f4019g.setInputMethodMode(2);
                ListPopupWindow.this.mo3546d();
            }
        }
    }

    private class PopupTouchInterceptor implements View.OnTouchListener {
        PopupTouchInterceptor() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ListPopupWindow.this.f4019g != null && ListPopupWindow.this.f4019g.isShowing() && x >= 0 && x < ListPopupWindow.this.f4019g.getWidth() && y >= 0 && y < ListPopupWindow.this.f4019g.getHeight()) {
                ListPopupWindow.this.f4018f.postDelayed(ListPopupWindow.this.f4017e, 250L);
                return false;
            }
            if (action == 1) {
                ListPopupWindow.this.f4018f.removeCallbacks(ListPopupWindow.this.f4017e);
                return false;
            }
            return false;
        }
    }

    private class PopupScrollListener implements AbsListView.OnScrollListener {
        PopupScrollListener() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !ListPopupWindow.this.m4386n() && ListPopupWindow.this.f4019g.getContentView() != null) {
                ListPopupWindow.this.f4018f.removeCallbacks(ListPopupWindow.this.f4017e);
                ListPopupWindow.this.f4017e.run();
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private void m4361c(boolean z) {
        if (f4002a != null) {
            try {
                f4002a.invoke(this.f4019g, Boolean.valueOf(z));
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private int m4358a(View view, int i, boolean z) {
        if (f4003b != null) {
            try {
                return ((Integer) f4003b.invoke(this.f4019g, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f4019g.getMaxAvailableHeight(view, i);
    }
}
