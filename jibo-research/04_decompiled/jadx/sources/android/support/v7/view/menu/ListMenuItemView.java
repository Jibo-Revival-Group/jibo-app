package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView {

    /* JADX INFO: renamed from: a */
    private MenuItemImpl f3315a;

    /* JADX INFO: renamed from: b */
    private ImageView f3316b;

    /* JADX INFO: renamed from: c */
    private RadioButton f3317c;

    /* JADX INFO: renamed from: d */
    private TextView f3318d;

    /* JADX INFO: renamed from: e */
    private CheckBox f3319e;

    /* JADX INFO: renamed from: f */
    private TextView f3320f;

    /* JADX INFO: renamed from: g */
    private ImageView f3321g;

    /* JADX INFO: renamed from: h */
    private Drawable f3322h;

    /* JADX INFO: renamed from: i */
    private int f3323i;

    /* JADX INFO: renamed from: j */
    private Context f3324j;

    /* JADX INFO: renamed from: k */
    private boolean f3325k;

    /* JADX INFO: renamed from: l */
    private Drawable f3326l;

    /* JADX INFO: renamed from: m */
    private int f3327m;

    /* JADX INFO: renamed from: n */
    private LayoutInflater f3328n;

    /* JADX INFO: renamed from: o */
    private boolean f3329o;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        TintTypedArray tintTypedArrayM4955a = TintTypedArray.m4955a(getContext(), attributeSet, R.styleable.MenuView, i, 0);
        this.f3322h = tintTypedArrayM4955a.m4959a(R.styleable.MenuView_android_itemBackground);
        this.f3323i = tintTypedArrayM4955a.m4972g(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.f3325k = tintTypedArrayM4955a.m4961a(R.styleable.MenuView_preserveIconSpacing, false);
        this.f3324j = context;
        this.f3326l = tintTypedArrayM4955a.m4959a(R.styleable.MenuView_subMenuArrow);
        tintTypedArrayM4955a.m4960a();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.m2582a(this, this.f3322h);
        this.f3318d = (TextView) findViewById(R.id.title);
        if (this.f3323i != -1) {
            this.f3318d.setTextAppearance(this.f3324j, this.f3323i);
        }
        this.f3320f = (TextView) findViewById(R.id.shortcut);
        this.f3321g = (ImageView) findViewById(R.id.submenuarrow);
        if (this.f3321g != null) {
            this.f3321g.setImageDrawable(this.f3326l);
        }
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    /* JADX INFO: renamed from: a */
    public void mo336a(MenuItemImpl menuItemImpl, int i) {
        this.f3315a = menuItemImpl;
        this.f3327m = i;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setTitle(menuItemImpl.m3631a((MenuView.ItemView) this));
        setCheckable(menuItemImpl.isCheckable());
        m3558a(menuItemImpl.m3644f(), menuItemImpl.m3640d());
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        setSubMenuArrowVisible(menuItemImpl.hasSubMenu());
        setContentDescription(menuItemImpl.getContentDescription());
    }

    public void setForceShowIcon(boolean z) {
        this.f3329o = z;
        this.f3325k = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f3318d.setText(charSequence);
            if (this.f3318d.getVisibility() != 0) {
                this.f3318d.setVisibility(0);
                return;
            }
            return;
        }
        if (this.f3318d.getVisibility() != 8) {
            this.f3318d.setVisibility(8);
        }
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.f3315a;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.f3317c != null || this.f3319e != null) {
            if (this.f3315a.m3645g()) {
                if (this.f3317c == null) {
                    m3556c();
                }
                compoundButton = this.f3317c;
                compoundButton2 = this.f3319e;
            } else {
                if (this.f3319e == null) {
                    m3557d();
                }
                compoundButton = this.f3319e;
                compoundButton2 = this.f3317c;
            }
            if (z) {
                compoundButton.setChecked(this.f3315a.isChecked());
                int i = z ? 0 : 8;
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f3319e != null) {
                this.f3319e.setVisibility(8);
            }
            if (this.f3317c != null) {
                this.f3317c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f3315a.m3645g()) {
            if (this.f3317c == null) {
                m3556c();
            }
            compoundButton = this.f3317c;
        } else {
            if (this.f3319e == null) {
                m3557d();
            }
            compoundButton = this.f3319e;
        }
        compoundButton.setChecked(z);
    }

    private void setSubMenuArrowVisible(boolean z) {
        if (this.f3321g != null) {
            this.f3321g.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3558a(boolean z, char c) {
        int i = (z && this.f3315a.m3644f()) ? 0 : 8;
        if (i == 0) {
            this.f3320f.setText(this.f3315a.m3642e());
        }
        if (this.f3320f.getVisibility() != i) {
            this.f3320f.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f3315a.m3647i() || this.f3329o;
        if (z || this.f3325k) {
            if (this.f3316b != null || drawable != null || this.f3325k) {
                if (this.f3316b == null) {
                    m3555b();
                }
                if (drawable != null || this.f3325k) {
                    ImageView imageView = this.f3316b;
                    if (!z) {
                        drawable = null;
                    }
                    imageView.setImageDrawable(drawable);
                    if (this.f3316b.getVisibility() != 0) {
                        this.f3316b.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.f3316b.setVisibility(8);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f3316b != null && this.f3325k) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f3316b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    /* JADX INFO: renamed from: b */
    private void m3555b() {
        this.f3316b = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
        addView(this.f3316b, 0);
    }

    /* JADX INFO: renamed from: c */
    private void m3556c() {
        this.f3317c = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        addView(this.f3317c);
    }

    /* JADX INFO: renamed from: d */
    private void m3557d() {
        this.f3319e = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        addView(this.f3319e);
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    /* JADX INFO: renamed from: a */
    public boolean mo337a() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.f3328n == null) {
            this.f3328n = LayoutInflater.from(getContext());
        }
        return this.f3328n;
    }
}
