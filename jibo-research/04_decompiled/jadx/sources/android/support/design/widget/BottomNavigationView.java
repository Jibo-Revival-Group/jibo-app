package android.support.design.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.internal.BottomNavigationPresenter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationView extends FrameLayout {

    /* JADX INFO: renamed from: a */
    private static final int[] f531a = {R.attr.state_checked};

    /* JADX INFO: renamed from: b */
    private static final int[] f532b = {-16842910};

    /* JADX INFO: renamed from: c */
    private final MenuBuilder f533c;

    /* JADX INFO: renamed from: d */
    private final BottomNavigationMenuView f534d;

    /* JADX INFO: renamed from: e */
    private final BottomNavigationPresenter f535e;

    /* JADX INFO: renamed from: f */
    private MenuInflater f536f;

    /* JADX INFO: renamed from: g */
    private OnNavigationItemSelectedListener f537g;

    /* JADX INFO: renamed from: h */
    private OnNavigationItemReselectedListener f538h;

    public interface OnNavigationItemReselectedListener {
        /* JADX INFO: renamed from: a */
        void m519a(MenuItem menuItem);
    }

    public interface OnNavigationItemSelectedListener {
        /* JADX INFO: renamed from: a */
        boolean m520a(MenuItem menuItem);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f535e = new BottomNavigationPresenter();
        ThemeUtils.m940a(context);
        this.f533c = new BottomNavigationMenu(context);
        this.f534d = new BottomNavigationMenuView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f534d.setLayoutParams(layoutParams);
        this.f535e.m348a(this.f534d);
        this.f535e.m345a(1);
        this.f534d.setPresenter(this.f535e);
        this.f533c.m3589a(this.f535e);
        this.f535e.mo346a(getContext(), this.f533c);
        TintTypedArray tintTypedArrayM4955a = TintTypedArray.m4955a(context, attributeSet, android.support.design.R.styleable.BottomNavigationView, i, android.support.design.R.style.Widget_Design_BottomNavigationView);
        if (tintTypedArrayM4955a.m4973g(android.support.design.R.styleable.BottomNavigationView_itemIconTint)) {
            this.f534d.setIconTintList(tintTypedArrayM4955a.m4969e(android.support.design.R.styleable.BottomNavigationView_itemIconTint));
        } else {
            this.f534d.setIconTintList(m514b(R.attr.textColorSecondary));
        }
        if (tintTypedArrayM4955a.m4973g(android.support.design.R.styleable.BottomNavigationView_itemTextColor)) {
            this.f534d.setItemTextColor(tintTypedArrayM4955a.m4969e(android.support.design.R.styleable.BottomNavigationView_itemTextColor));
        } else {
            this.f534d.setItemTextColor(m514b(R.attr.textColorSecondary));
        }
        if (tintTypedArrayM4955a.m4973g(android.support.design.R.styleable.BottomNavigationView_elevation)) {
            ViewCompat.m2574a(this, tintTypedArrayM4955a.m4968e(android.support.design.R.styleable.BottomNavigationView_elevation, 0));
        }
        this.f534d.setItemBackgroundRes(tintTypedArrayM4955a.m4972g(android.support.design.R.styleable.BottomNavigationView_itemBackground, 0));
        if (tintTypedArrayM4955a.m4973g(android.support.design.R.styleable.BottomNavigationView_menu)) {
            m516a(tintTypedArrayM4955a.m4972g(android.support.design.R.styleable.BottomNavigationView_menu, 0));
        }
        tintTypedArrayM4955a.m4960a();
        addView(this.f534d, layoutParams);
        if (Build.VERSION.SDK_INT < 21) {
            m513a(context);
        }
        this.f533c.mo3587a(new MenuBuilder.Callback() { // from class: android.support.design.widget.BottomNavigationView.1
            @Override // android.support.v7.view.menu.MenuBuilder.Callback
            /* JADX INFO: renamed from: a */
            public boolean mo518a(MenuBuilder menuBuilder, MenuItem menuItem) {
                if (BottomNavigationView.this.f538h == null || menuItem.getItemId() != BottomNavigationView.this.getSelectedItemId()) {
                    return (BottomNavigationView.this.f537g == null || BottomNavigationView.this.f537g.m520a(menuItem)) ? false : true;
                }
                BottomNavigationView.this.f538h.m519a(menuItem);
                return true;
            }

            @Override // android.support.v7.view.menu.MenuBuilder.Callback
            /* JADX INFO: renamed from: a */
            public void mo517a(MenuBuilder menuBuilder) {
            }
        });
    }

    public void setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.f537g = onNavigationItemSelectedListener;
    }

    public void setOnNavigationItemReselectedListener(OnNavigationItemReselectedListener onNavigationItemReselectedListener) {
        this.f538h = onNavigationItemReselectedListener;
    }

    public Menu getMenu() {
        return this.f533c;
    }

    /* JADX INFO: renamed from: a */
    public void m516a(int i) {
        this.f535e.m356b(true);
        getMenuInflater().inflate(i, this.f533c);
        this.f535e.m356b(false);
        this.f535e.mo351a(true);
    }

    public int getMaxItemCount() {
        return 5;
    }

    public ColorStateList getItemIconTintList() {
        return this.f534d.getIconTintList();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f534d.setIconTintList(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.f534d.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f534d.setItemTextColor(colorStateList);
    }

    public int getItemBackgroundResource() {
        return this.f534d.getItemBackgroundRes();
    }

    public void setItemBackgroundResource(int i) {
        this.f534d.setItemBackgroundRes(i);
    }

    public int getSelectedItemId() {
        return this.f534d.getSelectedItemId();
    }

    public void setSelectedItemId(int i) {
        MenuItem menuItemFindItem = this.f533c.findItem(i);
        if (menuItemFindItem != null && !this.f533c.m3595a(menuItemFindItem, this.f535e, 0)) {
            menuItemFindItem.setChecked(true);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m513a(Context context) {
        View view = new View(context);
        view.setBackgroundColor(ContextCompat.m1840c(context, android.support.design.R.color.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(android.support.design.R.dimen.design_bottom_navigation_shadow_height)));
        addView(view);
    }

    private MenuInflater getMenuInflater() {
        if (this.f536f == null) {
            this.f536f = new SupportMenuInflater(getContext());
        }
        return this.f536f;
    }

    /* JADX INFO: renamed from: b */
    private ColorStateList m514b(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListM3423a = AppCompatResources.m3423a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateListM3423a.getDefaultColor();
        return new ColorStateList(new int[][]{f532b, f531a, EMPTY_STATE_SET}, new int[]{colorStateListM3423a.getColorForState(f532b, defaultColor), i2, defaultColor});
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f540a = new Bundle();
        this.f533c.m3586a(savedState.f540a);
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.m2474a());
        this.f533c.m3597b(savedState.f540a);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.design.widget.BottomNavigationView.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX INFO: renamed from: a */
        Bundle f540a;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            m521a(parcel, classLoader);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f540a);
        }

        /* JADX INFO: renamed from: a */
        private void m521a(Parcel parcel, ClassLoader classLoader) {
            this.f540a = parcel.readBundle(classLoader);
        }
    }
}
