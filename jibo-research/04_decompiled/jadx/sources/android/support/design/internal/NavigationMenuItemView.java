package android.support.design.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.TooltipCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {

    /* JADX INFO: renamed from: d */
    private static final int[] f424d = {R.attr.state_checked};

    /* JADX INFO: renamed from: c */
    boolean f425c;

    /* JADX INFO: renamed from: e */
    private final int f426e;

    /* JADX INFO: renamed from: f */
    private boolean f427f;

    /* JADX INFO: renamed from: g */
    private final CheckedTextView f428g;

    /* JADX INFO: renamed from: h */
    private FrameLayout f429h;

    /* JADX INFO: renamed from: i */
    private MenuItemImpl f430i;

    /* JADX INFO: renamed from: j */
    private ColorStateList f431j;

    /* JADX INFO: renamed from: k */
    private boolean f432k;

    /* JADX INFO: renamed from: l */
    private Drawable f433l;

    /* JADX INFO: renamed from: m */
    private final AccessibilityDelegateCompat f434m;

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f434m = new AccessibilityDelegateCompat() { // from class: android.support.design.internal.NavigationMenuItemView.1
            @Override // android.support.v4.view.AccessibilityDelegateCompat
            /* JADX INFO: renamed from: a */
            public void mo365a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.mo365a(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.m2787a(NavigationMenuItemView.this.f425c);
            }
        };
        setOrientation(0);
        LayoutInflater.from(context).inflate(android.support.design.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        this.f426e = context.getResources().getDimensionPixelSize(android.support.design.R.dimen.design_navigation_icon_size);
        this.f428g = (CheckedTextView) findViewById(android.support.design.R.id.design_menu_item_text);
        this.f428g.setDuplicateParentStateEnabled(true);
        ViewCompat.m2583a(this.f428g, this.f434m);
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    /* JADX INFO: renamed from: a */
    public void mo336a(MenuItemImpl menuItemImpl, int i) {
        this.f430i = menuItemImpl;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            ViewCompat.m2582a(this, m363e());
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setActionView(menuItemImpl.getActionView());
        setContentDescription(menuItemImpl.getContentDescription());
        TooltipCompat.m4985a(this, menuItemImpl.getTooltipText());
        m362d();
    }

    /* JADX INFO: renamed from: c */
    private boolean m361c() {
        return this.f430i.getTitle() == null && this.f430i.getIcon() == null && this.f430i.getActionView() != null;
    }

    /* JADX INFO: renamed from: d */
    private void m362d() {
        if (m361c()) {
            this.f428g.setVisibility(8);
            if (this.f429h != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) this.f429h.getLayoutParams();
                layoutParams.width = -1;
                this.f429h.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.f428g.setVisibility(0);
        if (this.f429h != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) this.f429h.getLayoutParams();
            layoutParams2.width = -2;
            this.f429h.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m364b() {
        if (this.f429h != null) {
            this.f429h.removeAllViews();
        }
        this.f428g.setCompoundDrawables(null, null, null, null);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f429h == null) {
                this.f429h = (FrameLayout) ((ViewStub) findViewById(android.support.design.R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.f429h.removeAllViews();
            this.f429h.addView(view);
        }
    }

    /* JADX INFO: renamed from: e */
    private StateListDrawable m363e() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f424d, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.f430i;
    }

    public void setTitle(CharSequence charSequence) {
        this.f428g.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.f425c != z) {
            this.f425c = z;
            this.f434m.m2480a(this.f428g, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f428g.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f432k) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.m2000g(drawable).mutate();
                DrawableCompat.m1989a(drawable, this.f431j);
            }
            drawable.setBounds(0, 0, this.f426e, this.f426e);
        } else if (this.f427f) {
            if (this.f433l == null) {
                this.f433l = ResourcesCompat.m1919a(getResources(), android.support.design.R.drawable.navigation_empty_icon, getContext().getTheme());
                if (this.f433l != null) {
                    this.f433l.setBounds(0, 0, this.f426e, this.f426e);
                }
            }
            drawable = this.f433l;
        }
        TextViewCompat.m3118a(this.f428g, drawable, null, null, null);
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    /* JADX INFO: renamed from: a */
    public boolean mo337a() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f430i != null && this.f430i.isCheckable() && this.f430i.isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, f424d);
        }
        return iArrOnCreateDrawableState;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.f431j = colorStateList;
        this.f432k = this.f431j != null;
        if (this.f430i != null) {
            setIcon(this.f430i.getIcon());
        }
    }

    public void setTextAppearance(int i) {
        TextViewCompat.m3117a(this.f428g, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f428g.setTextColor(colorStateList);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.f427f = z;
    }
}
