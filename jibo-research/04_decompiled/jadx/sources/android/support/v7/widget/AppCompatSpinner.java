package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.view.ViewCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements TintableBackgroundView {

    /* JADX INFO: renamed from: a */
    private static final int[] f3707a = {R.attr.spinnerMode};

    /* JADX INFO: renamed from: b */
    private final AppCompatBackgroundHelper f3708b;

    /* JADX INFO: renamed from: c */
    private final Context f3709c;

    /* JADX INFO: renamed from: d */
    private ForwardingListener f3710d;

    /* JADX INFO: renamed from: e */
    private SpinnerAdapter f3711e;

    /* JADX INFO: renamed from: f */
    private final boolean f3712f;

    /* JADX INFO: renamed from: g */
    private DropdownPopup f3713g;

    /* JADX INFO: renamed from: h */
    private int f3714h;

    /* JADX INFO: renamed from: i */
    private final Rect f3715i;

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.appcompat.R.attr.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AppCompatSpinner(android.content.Context r9, android.util.AttributeSet r10, int r11, int r12, android.content.res.Resources.Theme r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        if (this.f3713g != null) {
            return this.f3709c;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.f3713g != null) {
            this.f3713g.m4365a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(AppCompatResources.m3426b(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        if (this.f3713g != null) {
            return this.f3713g.m4378h();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        if (this.f3713g != null) {
            this.f3713g.m4374d(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        if (this.f3713g != null) {
            return this.f3713g.m4383k();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        if (this.f3713g != null) {
            this.f3713g.m4372c(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        if (this.f3713g != null) {
            return this.f3713g.m4382j();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.f3713g != null) {
            this.f3714h = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f3713g != null) {
            return this.f3714h;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f3712f) {
            this.f3711e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f3713g != null) {
            this.f3713g.mo3919a(new DropDownAdapter(spinnerAdapter, (this.f3709c == null ? getContext() : this.f3709c).getTheme()));
        }
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f3713g != null && this.f3713g.mo3548f()) {
            this.f3713g.mo3547e();
        }
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f3710d == null || !this.f3710d.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f3713g != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m3916a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        if (this.f3713g == null) {
            return super.performClick();
        }
        if (!this.f3713g.mo3548f()) {
            this.f3713g.mo3546d();
        }
        return true;
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        if (this.f3713g != null) {
            this.f3713g.m3920a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        return this.f3713g != null ? this.f3713g.m3918a() : super.getPrompt();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f3708b != null) {
            this.f3708b.m3840a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f3708b != null) {
            this.f3708b.m3843a(drawable);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f3708b != null) {
            this.f3708b.m3841a(colorStateList);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f3708b != null) {
            return this.f3708b.m3839a();
        }
        return null;
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f3708b != null) {
            this.f3708b.m3842a(mode);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f3708b != null) {
            return this.f3708b.m3845b();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3708b != null) {
            this.f3708b.m3847c();
        }
    }

    /* JADX INFO: renamed from: a */
    int m3916a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        View view;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        int iMax2 = Math.max(0, iMax - (15 - (iMin - iMax)));
        View view2 = null;
        int iMax3 = 0;
        int i = 0;
        while (iMax2 < iMin) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax2);
            if (itemViewType != i) {
                view = null;
            } else {
                itemViewType = i;
                view = view2;
            }
            view2 = spinnerAdapter.getView(iMax2, view, this);
            if (view2.getLayoutParams() == null) {
                view2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view2.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax3 = Math.max(iMax3, view2.getMeasuredWidth());
            iMax2++;
            i = itemViewType;
        }
        if (drawable == null) {
            return iMax3;
        }
        drawable.getPadding(this.f3715i);
        return this.f3715i.left + this.f3715i.right + iMax3;
    }

    private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {

        /* JADX INFO: renamed from: a */
        private SpinnerAdapter f3718a;

        /* JADX INFO: renamed from: b */
        private ListAdapter f3719b;

        public DropDownAdapter(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f3718a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f3719b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof android.widget.ThemedSpinnerAdapter)) {
                    android.widget.ThemedSpinnerAdapter themedSpinnerAdapter = (android.widget.ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    ThemedSpinnerAdapter themedSpinnerAdapter2 = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter2.m4948a() == null) {
                        themedSpinnerAdapter2.m4949a(theme);
                    }
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f3718a == null) {
                return 0;
            }
            return this.f3718a.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.f3718a == null) {
                return null;
            }
            return this.f3718a.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            if (this.f3718a == null) {
                return -1L;
            }
            return this.f3718a.getItemId(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.f3718a == null) {
                return null;
            }
            return this.f3718a.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            return this.f3718a != null && this.f3718a.hasStableIds();
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f3718a != null) {
                this.f3718a.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f3718a != null) {
                this.f3718a.unregisterDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f3719b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f3719b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    private class DropdownPopup extends ListPopupWindow {

        /* JADX INFO: renamed from: a */
        ListAdapter f3720a;

        /* JADX INFO: renamed from: h */
        private CharSequence f3722h;

        /* JADX INFO: renamed from: i */
        private final Rect f3723i;

        public DropdownPopup(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f3723i = new Rect();
            m4370b(AppCompatSpinner.this);
            m4368a(true);
            m4363a(0);
            m4366a(new AdapterView.OnItemClickListener() { // from class: android.support.v7.widget.AppCompatSpinner.DropdownPopup.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    AppCompatSpinner.this.setSelection(i2);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        AppCompatSpinner.this.performItemClick(view, i2, DropdownPopup.this.f3720a.getItemId(i2));
                    }
                    DropdownPopup.this.mo3547e();
                }
            });
        }

        @Override // android.support.v7.widget.ListPopupWindow
        /* JADX INFO: renamed from: a */
        public void mo3919a(ListAdapter listAdapter) {
            super.mo3919a(listAdapter);
            this.f3720a = listAdapter;
        }

        /* JADX INFO: renamed from: a */
        public CharSequence m3918a() {
            return this.f3722h;
        }

        /* JADX INFO: renamed from: a */
        public void m3920a(CharSequence charSequence) {
            this.f3722h = charSequence;
        }

        /* JADX INFO: renamed from: b */
        void m3922b() {
            int i;
            int iL;
            Drawable drawableH = m4378h();
            if (drawableH != null) {
                drawableH.getPadding(AppCompatSpinner.this.f3715i);
                i = ViewUtils.m5031a(AppCompatSpinner.this) ? AppCompatSpinner.this.f3715i.right : -AppCompatSpinner.this.f3715i.left;
            } else {
                Rect rect = AppCompatSpinner.this.f3715i;
                AppCompatSpinner.this.f3715i.right = 0;
                rect.left = 0;
                i = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            if (AppCompatSpinner.this.f3714h != -2) {
                if (AppCompatSpinner.this.f3714h != -1) {
                    m4377g(AppCompatSpinner.this.f3714h);
                } else {
                    m4377g((width - paddingLeft) - paddingRight);
                }
            } else {
                int iM3916a = AppCompatSpinner.this.m3916a((SpinnerAdapter) this.f3720a, m4378h());
                int i2 = (AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.f3715i.left) - AppCompatSpinner.this.f3715i.right;
                if (iM3916a <= i2) {
                    i2 = iM3916a;
                }
                m4377g(Math.max(i2, (width - paddingLeft) - paddingRight));
            }
            if (ViewUtils.m5031a(AppCompatSpinner.this)) {
                iL = ((width - paddingRight) - m4384l()) + i;
            } else {
                iL = i + paddingLeft;
            }
            m4372c(iL);
        }

        @Override // android.support.v7.widget.ListPopupWindow, android.support.v7.view.menu.ShowableListMenu
        /* JADX INFO: renamed from: d */
        public void mo3546d() {
            ViewTreeObserver viewTreeObserver;
            boolean zF = mo3548f();
            m3922b();
            m4379h(2);
            super.mo3546d();
            mo3549g().setChoiceMode(1);
            m4381i(AppCompatSpinner.this.getSelectedItemPosition());
            if (!zF && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.widget.AppCompatSpinner.DropdownPopup.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (!DropdownPopup.this.m3921a(AppCompatSpinner.this)) {
                            DropdownPopup.this.mo3547e();
                        } else {
                            DropdownPopup.this.m3922b();
                            DropdownPopup.super.mo3546d();
                        }
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
                m4367a(new PopupWindow.OnDismissListener() { // from class: android.support.v7.widget.AppCompatSpinner.DropdownPopup.3
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        ViewTreeObserver viewTreeObserver2 = AppCompatSpinner.this.getViewTreeObserver();
                        if (viewTreeObserver2 != null) {
                            viewTreeObserver2.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                        }
                    }
                });
            }
        }

        /* JADX INFO: renamed from: a */
        boolean m3921a(View view) {
            return ViewCompat.m2570B(view) && view.getGlobalVisibleRect(this.f3723i);
        }
    }
}
