package android.support.design.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.internal.NavigationMenu;
import android.support.design.internal.NavigationMenuPresenter;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class NavigationView extends ScrimInsetsFrameLayout {

    /* JADX INFO: renamed from: d */
    private static final int[] f785d = {R.attr.state_checked};

    /* JADX INFO: renamed from: e */
    private static final int[] f786e = {-16842910};

    /* JADX INFO: renamed from: c */
    OnNavigationItemSelectedListener f787c;

    /* JADX INFO: renamed from: f */
    private final NavigationMenu f788f;

    /* JADX INFO: renamed from: g */
    private final NavigationMenuPresenter f789g;

    /* JADX INFO: renamed from: h */
    private int f790h;

    /* JADX INFO: renamed from: i */
    private MenuInflater f791i;

    public interface OnNavigationItemSelectedListener {
        /* JADX INFO: renamed from: a */
        boolean m788a(MenuItem menuItem);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateListM785c;
        int iM4972g;
        boolean z;
        super(context, attributeSet, i);
        this.f789g = new NavigationMenuPresenter();
        ThemeUtils.m940a(context);
        this.f788f = new NavigationMenu(context);
        TintTypedArray tintTypedArrayM4955a = TintTypedArray.m4955a(context, attributeSet, android.support.design.R.styleable.NavigationView, i, android.support.design.R.style.Widget_Design_NavigationView);
        ViewCompat.m2582a(this, tintTypedArrayM4955a.m4959a(android.support.design.R.styleable.NavigationView_android_background));
        if (tintTypedArrayM4955a.m4973g(android.support.design.R.styleable.NavigationView_elevation)) {
            ViewCompat.m2574a(this, tintTypedArrayM4955a.m4968e(android.support.design.R.styleable.NavigationView_elevation, 0));
        }
        ViewCompat.m2595b(this, tintTypedArrayM4955a.m4961a(android.support.design.R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.f790h = tintTypedArrayM4955a.m4968e(android.support.design.R.styleable.NavigationView_android_maxWidth, 0);
        if (tintTypedArrayM4955a.m4973g(android.support.design.R.styleable.NavigationView_itemIconTint)) {
            colorStateListM785c = tintTypedArrayM4955a.m4969e(android.support.design.R.styleable.NavigationView_itemIconTint);
        } else {
            colorStateListM785c = m785c(R.attr.textColorSecondary);
        }
        if (tintTypedArrayM4955a.m4973g(android.support.design.R.styleable.NavigationView_itemTextAppearance)) {
            iM4972g = tintTypedArrayM4955a.m4972g(android.support.design.R.styleable.NavigationView_itemTextAppearance, 0);
            z = true;
        } else {
            iM4972g = 0;
            z = false;
        }
        ColorStateList colorStateListM4969e = tintTypedArrayM4955a.m4973g(android.support.design.R.styleable.NavigationView_itemTextColor) ? tintTypedArrayM4955a.m4969e(android.support.design.R.styleable.NavigationView_itemTextColor) : null;
        if (!z && colorStateListM4969e == null) {
            colorStateListM4969e = m785c(R.attr.textColorPrimary);
        }
        Drawable drawableM4959a = tintTypedArrayM4955a.m4959a(android.support.design.R.styleable.NavigationView_itemBackground);
        this.f788f.mo3587a(new MenuBuilder.Callback() { // from class: android.support.design.widget.NavigationView.1
            @Override // android.support.v7.view.menu.MenuBuilder.Callback
            /* JADX INFO: renamed from: a */
            public boolean mo518a(MenuBuilder menuBuilder, MenuItem menuItem) {
                return NavigationView.this.f787c != null && NavigationView.this.f787c.m788a(menuItem);
            }

            @Override // android.support.v7.view.menu.MenuBuilder.Callback
            /* JADX INFO: renamed from: a */
            public void mo517a(MenuBuilder menuBuilder) {
            }
        });
        this.f789g.m367a(1);
        this.f789g.mo346a(context, this.f788f);
        this.f789g.m368a(colorStateListM785c);
        if (z) {
            this.f789g.m376c(iM4972g);
        }
        this.f789g.m374b(colorStateListM4969e);
        this.f789g.m369a(drawableM4959a);
        this.f788f.m3589a(this.f789g);
        addView((View) this.f789g.m366a((ViewGroup) this));
        if (tintTypedArrayM4955a.m4973g(android.support.design.R.styleable.NavigationView_menu)) {
            m786a(tintTypedArrayM4955a.m4972g(android.support.design.R.styleable.NavigationView_menu, 0));
        }
        if (tintTypedArrayM4955a.m4973g(android.support.design.R.styleable.NavigationView_headerLayout)) {
            m787b(tintTypedArrayM4955a.m4972g(android.support.design.R.styleable.NavigationView_headerLayout, 0));
        }
        tintTypedArrayM4955a.m4960a();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f793a = new Bundle();
        this.f788f.m3586a(savedState.f793a);
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
        this.f788f.m3597b(savedState.f793a);
    }

    public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.f787c = onNavigationItemSelectedListener;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        switch (View.MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), this.f790h), 1073741824);
                break;
            case 0:
                i = View.MeasureSpec.makeMeasureSpec(this.f790h, 1073741824);
                break;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.support.design.internal.ScrimInsetsFrameLayout
    /* JADX INFO: renamed from: a */
    protected void mo398a(WindowInsetsCompat windowInsetsCompat) {
        this.f789g.m370a(windowInsetsCompat);
    }

    /* JADX INFO: renamed from: a */
    public void m786a(int i) {
        this.f789g.m375b(true);
        getMenuInflater().inflate(i, this.f788f);
        this.f789g.m375b(false);
        this.f789g.mo351a(false);
    }

    public Menu getMenu() {
        return this.f788f;
    }

    /* JADX INFO: renamed from: b */
    public View m787b(int i) {
        return this.f789g.m373b(i);
    }

    public int getHeaderCount() {
        return this.f789g.m377d();
    }

    public ColorStateList getItemIconTintList() {
        return this.f789g.m378e();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f789g.m368a(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.f789g.m379f();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f789g.m374b(colorStateList);
    }

    public Drawable getItemBackground() {
        return this.f789g.m380g();
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(ContextCompat.m1832a(getContext(), i));
    }

    public void setItemBackground(Drawable drawable) {
        this.f789g.m369a(drawable);
    }

    public void setCheckedItem(int i) {
        MenuItem menuItemFindItem = this.f788f.findItem(i);
        if (menuItemFindItem != null) {
            this.f789g.m371a((MenuItemImpl) menuItemFindItem);
        }
    }

    public void setItemTextAppearance(int i) {
        this.f789g.m376c(i);
    }

    private MenuInflater getMenuInflater() {
        if (this.f791i == null) {
            this.f791i = new SupportMenuInflater(getContext());
        }
        return this.f791i;
    }

    /* JADX INFO: renamed from: c */
    private ColorStateList m785c(int i) {
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
        return new ColorStateList(new int[][]{f786e, f785d, EMPTY_STATE_SET}, new int[]{colorStateListM3423a.getColorForState(f786e, defaultColor), i2, defaultColor});
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.design.widget.NavigationView.SavedState.1
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
        public Bundle f793a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f793a = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f793a);
        }
    }
}
