package android.support.design.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.TooltipCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationItemView extends FrameLayout implements MenuView.ItemView {

    /* JADX INFO: renamed from: a */
    private static final int[] f383a = {R.attr.state_checked};

    /* JADX INFO: renamed from: b */
    private final int f384b;

    /* JADX INFO: renamed from: c */
    private final int f385c;

    /* JADX INFO: renamed from: d */
    private final float f386d;

    /* JADX INFO: renamed from: e */
    private final float f387e;

    /* JADX INFO: renamed from: f */
    private boolean f388f;

    /* JADX INFO: renamed from: g */
    private ImageView f389g;

    /* JADX INFO: renamed from: h */
    private final TextView f390h;

    /* JADX INFO: renamed from: i */
    private final TextView f391i;

    /* JADX INFO: renamed from: j */
    private int f392j;

    /* JADX INFO: renamed from: k */
    private MenuItemImpl f393k;

    /* JADX INFO: renamed from: l */
    private ColorStateList f394l;

    public BottomNavigationItemView(Context context) {
        this(context, null);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f392j = -1;
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(android.support.design.R.dimen.design_bottom_navigation_text_size);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(android.support.design.R.dimen.design_bottom_navigation_active_text_size);
        this.f384b = resources.getDimensionPixelSize(android.support.design.R.dimen.design_bottom_navigation_margin);
        this.f385c = dimensionPixelSize - dimensionPixelSize2;
        this.f386d = (dimensionPixelSize2 * 1.0f) / dimensionPixelSize;
        this.f387e = (dimensionPixelSize * 1.0f) / dimensionPixelSize2;
        LayoutInflater.from(context).inflate(android.support.design.R.layout.design_bottom_navigation_item, (ViewGroup) this, true);
        setBackgroundResource(android.support.design.R.drawable.design_bottom_navigation_item_background);
        this.f389g = (ImageView) findViewById(android.support.design.R.id.icon);
        this.f390h = (TextView) findViewById(android.support.design.R.id.smallLabel);
        this.f391i = (TextView) findViewById(android.support.design.R.id.largeLabel);
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    /* JADX INFO: renamed from: a */
    public void mo336a(MenuItemImpl menuItemImpl, int i) {
        this.f393k = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        setContentDescription(menuItemImpl.getContentDescription());
        TooltipCompat.m4985a(this, menuItemImpl.getTooltipText());
    }

    public void setItemPosition(int i) {
        this.f392j = i;
    }

    public int getItemPosition() {
        return this.f392j;
    }

    public void setShiftingMode(boolean z) {
        this.f388f = z;
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.f393k;
    }

    public void setTitle(CharSequence charSequence) {
        this.f390h.setText(charSequence);
        this.f391i.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        this.f391i.setPivotX(this.f391i.getWidth() / 2);
        this.f391i.setPivotY(this.f391i.getBaseline());
        this.f390h.setPivotX(this.f390h.getWidth() / 2);
        this.f390h.setPivotY(this.f390h.getBaseline());
        if (this.f388f) {
            if (z) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f389g.getLayoutParams();
                layoutParams.gravity = 49;
                layoutParams.topMargin = this.f384b;
                this.f389g.setLayoutParams(layoutParams);
                this.f391i.setVisibility(0);
                this.f391i.setScaleX(1.0f);
                this.f391i.setScaleY(1.0f);
            } else {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f389g.getLayoutParams();
                layoutParams2.gravity = 17;
                layoutParams2.topMargin = this.f384b;
                this.f389g.setLayoutParams(layoutParams2);
                this.f391i.setVisibility(4);
                this.f391i.setScaleX(0.5f);
                this.f391i.setScaleY(0.5f);
            }
            this.f390h.setVisibility(4);
        } else if (z) {
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f389g.getLayoutParams();
            layoutParams3.gravity = 49;
            layoutParams3.topMargin = this.f384b + this.f385c;
            this.f389g.setLayoutParams(layoutParams3);
            this.f391i.setVisibility(0);
            this.f390h.setVisibility(4);
            this.f391i.setScaleX(1.0f);
            this.f391i.setScaleY(1.0f);
            this.f390h.setScaleX(this.f386d);
            this.f390h.setScaleY(this.f386d);
        } else {
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.f389g.getLayoutParams();
            layoutParams4.gravity = 49;
            layoutParams4.topMargin = this.f384b;
            this.f389g.setLayoutParams(layoutParams4);
            this.f391i.setVisibility(4);
            this.f390h.setVisibility(0);
            this.f391i.setScaleX(this.f387e);
            this.f391i.setScaleY(this.f387e);
            this.f390h.setScaleX(1.0f);
            this.f390h.setScaleY(1.0f);
        }
        refreshDrawableState();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f390h.setEnabled(z);
        this.f391i.setEnabled(z);
        this.f389g.setEnabled(z);
        if (z) {
            ViewCompat.m2585a(this, PointerIconCompat.m2567a(getContext(), 1002));
        } else {
            ViewCompat.m2585a(this, (PointerIconCompat) null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f393k != null && this.f393k.isCheckable() && this.f393k.isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, f383a);
        }
        return iArrOnCreateDrawableState;
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.m2000g(drawable).mutate();
            DrawableCompat.m1989a(drawable, this.f394l);
        }
        this.f389g.setImageDrawable(drawable);
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    /* JADX INFO: renamed from: a */
    public boolean mo337a() {
        return false;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f394l = colorStateList;
        if (this.f393k != null) {
            setIcon(this.f393k.getIcon());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f390h.setTextColor(colorStateList);
        this.f391i.setTextColor(colorStateList);
    }

    public void setItemBackground(int i) {
        ViewCompat.m2582a(this, i == 0 ? null : ContextCompat.m1832a(getContext(), i));
    }
}
