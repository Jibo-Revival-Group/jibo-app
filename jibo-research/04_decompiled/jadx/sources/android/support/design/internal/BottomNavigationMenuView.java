package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.design.R;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionManager;
import android.support.transition.TransitionSet;
import android.support.v4.util.Pools;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationMenuView extends ViewGroup implements MenuView {

    /* JADX INFO: renamed from: a */
    private final TransitionSet f395a;

    /* JADX INFO: renamed from: b */
    private final int f396b;

    /* JADX INFO: renamed from: c */
    private final int f397c;

    /* JADX INFO: renamed from: d */
    private final int f398d;

    /* JADX INFO: renamed from: e */
    private final int f399e;

    /* JADX INFO: renamed from: f */
    private final View.OnClickListener f400f;

    /* JADX INFO: renamed from: g */
    private final Pools.Pool<BottomNavigationItemView> f401g;

    /* JADX INFO: renamed from: h */
    private boolean f402h;

    /* JADX INFO: renamed from: i */
    private BottomNavigationItemView[] f403i;

    /* JADX INFO: renamed from: j */
    private int f404j;

    /* JADX INFO: renamed from: k */
    private int f405k;

    /* JADX INFO: renamed from: l */
    private ColorStateList f406l;

    /* JADX INFO: renamed from: m */
    private ColorStateList f407m;

    /* JADX INFO: renamed from: n */
    private int f408n;

    /* JADX INFO: renamed from: o */
    private int[] f409o;

    /* JADX INFO: renamed from: p */
    private BottomNavigationPresenter f410p;

    /* JADX INFO: renamed from: q */
    private MenuBuilder f411q;

    public BottomNavigationMenuView(Context context) {
        this(context, null);
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f401g = new Pools.SynchronizedPool(5);
        this.f402h = true;
        this.f404j = 0;
        this.f405k = 0;
        Resources resources = getResources();
        this.f396b = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.f397c = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.f398d = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.f399e = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
        this.f395a = new AutoTransition();
        this.f395a.m1262a(0);
        this.f395a.mo1212a(115L);
        this.f395a.mo1213a(new FastOutSlowInInterpolator());
        this.f395a.m1266b(new TextScale());
        this.f400f = new View.OnClickListener() { // from class: android.support.design.internal.BottomNavigationMenuView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MenuItemImpl itemData = ((BottomNavigationItemView) view).getItemData();
                if (!BottomNavigationMenuView.this.f411q.m3595a(itemData, BottomNavigationMenuView.this.f410p, 0)) {
                    itemData.setChecked(true);
                }
            }
        };
        this.f409o = new int[5];
    }

    @Override // android.support.v7.view.menu.MenuView
    /* JADX INFO: renamed from: a */
    public void mo343a(MenuBuilder menuBuilder) {
        this.f411q = menuBuilder;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int size = View.MeasureSpec.getSize(i);
        int childCount = getChildCount();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f399e, 1073741824);
        if (this.f402h) {
            int i4 = childCount - 1;
            int iMin = Math.min(size - (this.f397c * i4), this.f398d);
            int iMin2 = Math.min((size - iMin) / i4, this.f396b);
            int i5 = (size - iMin) - (i4 * iMin2);
            int i6 = 0;
            while (i6 < childCount) {
                this.f409o[i6] = i6 == this.f405k ? iMin : iMin2;
                if (i5 > 0) {
                    int[] iArr = this.f409o;
                    iArr[i6] = iArr[i6] + 1;
                    i3 = i5 - 1;
                } else {
                    i3 = i5;
                }
                i6++;
                i5 = i3;
            }
        } else {
            int iMin3 = Math.min(size / (childCount == 0 ? 1 : childCount), this.f398d);
            int i7 = size - (iMin3 * childCount);
            for (int i8 = 0; i8 < childCount; i8++) {
                this.f409o[i8] = iMin3;
                if (i7 > 0) {
                    int[] iArr2 = this.f409o;
                    iArr2[i8] = iArr2[i8] + 1;
                    i7--;
                }
            }
        }
        int measuredWidth = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f409o[i9], 1073741824), iMakeMeasureSpec);
                childAt.getLayoutParams().width = childAt.getMeasuredWidth();
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(measuredWidth, View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), 0), View.resolveSizeAndState(this.f399e, iMakeMeasureSpec, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int measuredWidth = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.m2601e(this) == 1) {
                    childAt.layout((i5 - measuredWidth) - childAt.getMeasuredWidth(), 0, i5 - measuredWidth, i6);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i6);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f406l = colorStateList;
        if (this.f403i != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.f403i) {
                bottomNavigationItemView.setIconTintList(colorStateList);
            }
        }
    }

    public ColorStateList getIconTintList() {
        return this.f406l;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f407m = colorStateList;
        if (this.f403i != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.f403i) {
                bottomNavigationItemView.setTextColor(colorStateList);
            }
        }
    }

    public ColorStateList getItemTextColor() {
        return this.f407m;
    }

    public void setItemBackgroundRes(int i) {
        this.f408n = i;
        if (this.f403i != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.f403i) {
                bottomNavigationItemView.setItemBackground(i);
            }
        }
    }

    public int getItemBackgroundRes() {
        return this.f408n;
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.f410p = bottomNavigationPresenter;
    }

    /* JADX INFO: renamed from: a */
    public void m341a() {
        removeAllViews();
        if (this.f403i != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.f403i) {
                this.f401g.mo2439a(bottomNavigationItemView);
            }
        }
        if (this.f411q.size() == 0) {
            this.f404j = 0;
            this.f405k = 0;
            this.f403i = null;
            return;
        }
        this.f403i = new BottomNavigationItemView[this.f411q.size()];
        this.f402h = this.f411q.size() > 3;
        for (int i = 0; i < this.f411q.size(); i++) {
            this.f410p.m356b(true);
            this.f411q.getItem(i).setCheckable(true);
            this.f410p.m356b(false);
            BottomNavigationItemView newItem = getNewItem();
            this.f403i[i] = newItem;
            newItem.setIconTintList(this.f406l);
            newItem.setTextColor(this.f407m);
            newItem.setItemBackground(this.f408n);
            newItem.setShiftingMode(this.f402h);
            newItem.mo336a((MenuItemImpl) this.f411q.getItem(i), 0);
            newItem.setItemPosition(i);
            newItem.setOnClickListener(this.f400f);
            addView(newItem);
        }
        this.f405k = Math.min(this.f411q.size() - 1, this.f405k);
        this.f411q.getItem(this.f405k).setChecked(true);
    }

    /* JADX INFO: renamed from: b */
    public void m344b() {
        int size = this.f411q.size();
        if (size != this.f403i.length) {
            m341a();
            return;
        }
        int i = this.f404j;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.f411q.getItem(i2);
            if (item.isChecked()) {
                this.f404j = item.getItemId();
                this.f405k = i2;
            }
        }
        if (i != this.f404j) {
            TransitionManager.m1250a(this, this.f395a);
        }
        for (int i3 = 0; i3 < size; i3++) {
            this.f410p.m356b(true);
            this.f403i[i3].mo336a((MenuItemImpl) this.f411q.getItem(i3), 0);
            this.f410p.m356b(false);
        }
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView bottomNavigationItemViewMo2438a = this.f401g.mo2438a();
        if (bottomNavigationItemViewMo2438a == null) {
            return new BottomNavigationItemView(getContext());
        }
        return bottomNavigationItemViewMo2438a;
    }

    public int getSelectedItemId() {
        return this.f404j;
    }

    /* JADX INFO: renamed from: a */
    void m342a(int i) {
        int size = this.f411q.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.f411q.getItem(i2);
            if (i == item.getItemId()) {
                this.f404j = i;
                this.f405k = i2;
                item.setChecked(true);
                return;
            }
        }
    }
}
