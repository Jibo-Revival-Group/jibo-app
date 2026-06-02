package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.menu.ActionMenuItem;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class ToolbarWidgetWrapper implements DecorToolbar {

    /* JADX INFO: renamed from: a */
    Toolbar f4444a;

    /* JADX INFO: renamed from: b */
    CharSequence f4445b;

    /* JADX INFO: renamed from: c */
    Window.Callback f4446c;

    /* JADX INFO: renamed from: d */
    boolean f4447d;

    /* JADX INFO: renamed from: e */
    private int f4448e;

    /* JADX INFO: renamed from: f */
    private View f4449f;

    /* JADX INFO: renamed from: g */
    private Spinner f4450g;

    /* JADX INFO: renamed from: h */
    private View f4451h;

    /* JADX INFO: renamed from: i */
    private Drawable f4452i;

    /* JADX INFO: renamed from: j */
    private Drawable f4453j;

    /* JADX INFO: renamed from: k */
    private Drawable f4454k;

    /* JADX INFO: renamed from: l */
    private boolean f4455l;

    /* JADX INFO: renamed from: m */
    private CharSequence f4456m;

    /* JADX INFO: renamed from: n */
    private CharSequence f4457n;

    /* JADX INFO: renamed from: o */
    private ActionMenuPresenter f4458o;

    /* JADX INFO: renamed from: p */
    private int f4459p;

    /* JADX INFO: renamed from: q */
    private int f4460q;

    /* JADX INFO: renamed from: r */
    private Drawable f4461r;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i, int i2) {
        this.f4459p = 0;
        this.f4460q = 0;
        this.f4444a = toolbar;
        this.f4445b = toolbar.getTitle();
        this.f4456m = toolbar.getSubtitle();
        this.f4455l = this.f4445b != null;
        this.f4454k = toolbar.getNavigationIcon();
        TintTypedArray tintTypedArrayM4955a = TintTypedArray.m4955a(toolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.f4461r = tintTypedArrayM4955a.m4959a(R.styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence charSequenceM4965c = tintTypedArrayM4955a.m4965c(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceM4965c)) {
                mo4061b(charSequenceM4965c);
            }
            CharSequence charSequenceM4965c2 = tintTypedArrayM4955a.m4965c(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceM4965c2)) {
                mo4065c(charSequenceM4965c2);
            }
            Drawable drawableM4959a = tintTypedArrayM4955a.m4959a(R.styleable.ActionBar_logo);
            if (drawableM4959a != null) {
                mo4060b(drawableM4959a);
            }
            Drawable drawableM4959a2 = tintTypedArrayM4955a.m4959a(R.styleable.ActionBar_icon);
            if (drawableM4959a2 != null) {
                mo4049a(drawableM4959a2);
            }
            if (this.f4454k == null && this.f4461r != null) {
                mo4064c(this.f4461r);
            }
            mo4063c(tintTypedArrayM4955a.m4957a(R.styleable.ActionBar_displayOptions, 0));
            int iM4972g = tintTypedArrayM4955a.m4972g(R.styleable.ActionBar_customNavigationLayout, 0);
            if (iM4972g != 0) {
                mo4053a(LayoutInflater.from(this.f4444a.getContext()).inflate(iM4972g, (ViewGroup) this.f4444a, false));
                mo4063c(this.f4448e | 16);
            }
            int iM4970f = tintTypedArrayM4955a.m4970f(R.styleable.ActionBar_height, 0);
            if (iM4970f > 0) {
                ViewGroup.LayoutParams layoutParams = this.f4444a.getLayoutParams();
                layoutParams.height = iM4970f;
                this.f4444a.setLayoutParams(layoutParams);
            }
            int iM4966d = tintTypedArrayM4955a.m4966d(R.styleable.ActionBar_contentInsetStart, -1);
            int iM4966d2 = tintTypedArrayM4955a.m4966d(R.styleable.ActionBar_contentInsetEnd, -1);
            if (iM4966d >= 0 || iM4966d2 >= 0) {
                this.f4444a.setContentInsetsRelative(Math.max(iM4966d, 0), Math.max(iM4966d2, 0));
            }
            int iM4972g2 = tintTypedArrayM4955a.m4972g(R.styleable.ActionBar_titleTextStyle, 0);
            if (iM4972g2 != 0) {
                this.f4444a.setTitleTextAppearance(this.f4444a.getContext(), iM4972g2);
            }
            int iM4972g3 = tintTypedArrayM4955a.m4972g(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (iM4972g3 != 0) {
                this.f4444a.setSubtitleTextAppearance(this.f4444a.getContext(), iM4972g3);
            }
            int iM4972g4 = tintTypedArrayM4955a.m4972g(R.styleable.ActionBar_popupTheme, 0);
            if (iM4972g4 != 0) {
                this.f4444a.setPopupTheme(iM4972g4);
            }
        } else {
            this.f4448e = m4982y();
        }
        tintTypedArrayM4955a.m4960a();
        m4984i(i);
        this.f4457n = this.f4444a.getNavigationContentDescription();
        this.f4444a.setNavigationOnClickListener(new View.OnClickListener() { // from class: android.support.v7.widget.ToolbarWidgetWrapper.1

            /* JADX INFO: renamed from: a */
            final ActionMenuItem f4462a;

            {
                this.f4462a = new ActionMenuItem(ToolbarWidgetWrapper.this.f4444a.getContext(), 0, android.R.id.home, 0, 0, ToolbarWidgetWrapper.this.f4445b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ToolbarWidgetWrapper.this.f4446c != null && ToolbarWidgetWrapper.this.f4447d) {
                    ToolbarWidgetWrapper.this.f4446c.onMenuItemSelected(0, this.f4462a);
                }
            }
        });
    }

    /* JADX INFO: renamed from: i */
    public void m4984i(int i) {
        if (i != this.f4460q) {
            this.f4460q = i;
            if (TextUtils.isEmpty(this.f4444a.getNavigationContentDescription())) {
                mo4076g(this.f4460q);
            }
        }
    }

    /* JADX INFO: renamed from: y */
    private int m4982y() {
        if (this.f4444a.getNavigationIcon() == null) {
            return 11;
        }
        this.f4461r = this.f4444a.getNavigationIcon();
        return 15;
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: a */
    public ViewGroup mo4047a() {
        return this.f4444a;
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: b */
    public Context mo4058b() {
        return this.f4444a.getContext();
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: c */
    public boolean mo4066c() {
        return this.f4444a.hasExpandedActionView();
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: d */
    public void mo4067d() {
        this.f4444a.collapseActionView();
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: a */
    public void mo4054a(Window.Callback callback) {
        this.f4446c = callback;
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: a */
    public void mo4056a(CharSequence charSequence) {
        if (!this.f4455l) {
            m4981e(charSequence);
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: e */
    public CharSequence mo4071e() {
        return this.f4444a.getTitle();
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: b */
    public void mo4061b(CharSequence charSequence) {
        this.f4455l = true;
        m4981e(charSequence);
    }

    /* JADX INFO: renamed from: e */
    private void m4981e(CharSequence charSequence) {
        this.f4445b = charSequence;
        if ((this.f4448e & 8) != 0) {
            this.f4444a.setTitle(charSequence);
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: f */
    public CharSequence mo4073f() {
        return this.f4444a.getSubtitle();
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: c */
    public void mo4065c(CharSequence charSequence) {
        this.f4456m = charSequence;
        if ((this.f4448e & 8) != 0) {
            this.f4444a.setSubtitle(charSequence);
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: g */
    public void mo4075g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: h */
    public void mo4077h() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: a */
    public void mo4048a(int i) {
        mo4049a(i != 0 ? AppCompatResources.m3426b(mo4058b(), i) : null);
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: a */
    public void mo4049a(Drawable drawable) {
        this.f4452i = drawable;
        m4983z();
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: b */
    public void mo4059b(int i) {
        mo4060b(i != 0 ? AppCompatResources.m3426b(mo4058b(), i) : null);
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: b */
    public void mo4060b(Drawable drawable) {
        this.f4453j = drawable;
        m4983z();
    }

    /* JADX INFO: renamed from: z */
    private void m4983z() {
        Drawable drawable = null;
        if ((this.f4448e & 2) != 0) {
            drawable = ((this.f4448e & 1) == 0 || this.f4453j == null) ? this.f4452i : this.f4453j;
        }
        this.f4444a.setLogo(drawable);
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: i */
    public boolean mo4079i() {
        return this.f4444a.canShowOverflowMenu();
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: j */
    public boolean mo4080j() {
        return this.f4444a.isOverflowMenuShowing();
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: k */
    public boolean mo4081k() {
        return this.f4444a.isOverflowMenuShowPending();
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: l */
    public boolean mo4082l() {
        return this.f4444a.showOverflowMenu();
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: m */
    public boolean mo4083m() {
        return this.f4444a.hideOverflowMenu();
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: n */
    public void mo4084n() {
        this.f4447d = true;
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: a */
    public void mo4052a(Menu menu, MenuPresenter.Callback callback) {
        if (this.f4458o == null) {
            this.f4458o = new ActionMenuPresenter(this.f4444a.getContext());
            this.f4458o.m3516a(R.id.action_menu_presenter);
        }
        this.f4458o.mo350a(callback);
        this.f4444a.setMenu((MenuBuilder) menu, this.f4458o);
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: o */
    public void mo4085o() {
        this.f4444a.dismissPopupMenus();
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: p */
    public int mo4086p() {
        return this.f4448e;
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: c */
    public void mo4063c(int i) {
        int i2 = this.f4448e ^ i;
        this.f4448e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m4980C();
                }
                m4979B();
            }
            if ((i2 & 3) != 0) {
                m4983z();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f4444a.setTitle(this.f4445b);
                    this.f4444a.setSubtitle(this.f4456m);
                } else {
                    this.f4444a.setTitle((CharSequence) null);
                    this.f4444a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) != 0 && this.f4451h != null) {
                if ((i & 16) != 0) {
                    this.f4444a.addView(this.f4451h);
                } else {
                    this.f4444a.removeView(this.f4451h);
                }
            }
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: a */
    public void mo4051a(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.f4449f != null && this.f4449f.getParent() == this.f4444a) {
            this.f4444a.removeView(this.f4449f);
        }
        this.f4449f = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.f4459p == 2) {
            this.f4444a.addView(this.f4449f, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f4449f.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.f2796a = 8388691;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: q */
    public boolean mo4087q() {
        return this.f4444a.isTitleTruncated();
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: a */
    public void mo4057a(boolean z) {
        this.f4444a.setCollapsible(z);
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: b */
    public void mo4062b(boolean z) {
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: r */
    public int mo4088r() {
        return this.f4459p;
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: d */
    public void mo4068d(int i) {
        int i2 = this.f4459p;
        if (i != i2) {
            switch (i2) {
                case 1:
                    if (this.f4450g != null && this.f4450g.getParent() == this.f4444a) {
                        this.f4444a.removeView(this.f4450g);
                    }
                    break;
                case 2:
                    if (this.f4449f != null && this.f4449f.getParent() == this.f4444a) {
                        this.f4444a.removeView(this.f4449f);
                    }
                    break;
            }
            this.f4459p = i;
            switch (i) {
                case 0:
                    return;
                case 1:
                    m4978A();
                    this.f4444a.addView(this.f4450g, 0);
                    return;
                case 2:
                    if (this.f4449f != null) {
                        this.f4444a.addView(this.f4449f, 0);
                        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f4449f.getLayoutParams();
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                        layoutParams.f2796a = 8388691;
                        return;
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Invalid navigation mode " + i);
            }
        }
    }

    /* JADX INFO: renamed from: A */
    private void m4978A() {
        if (this.f4450g == null) {
            this.f4450g = new AppCompatSpinner(mo4058b(), null, R.attr.actionDropDownStyle);
            this.f4450g.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: a */
    public void mo4055a(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        m4978A();
        this.f4450g.setAdapter(spinnerAdapter);
        this.f4450g.setOnItemSelectedListener(onItemSelectedListener);
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: e */
    public void mo4072e(int i) {
        if (this.f4450g == null) {
            throw new IllegalStateException("Can't set dropdown selected position without an adapter");
        }
        this.f4450g.setSelection(i);
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: s */
    public int mo4089s() {
        if (this.f4450g != null) {
            return this.f4450g.getSelectedItemPosition();
        }
        return 0;
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: t */
    public int mo4090t() {
        if (this.f4450g != null) {
            return this.f4450g.getCount();
        }
        return 0;
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: a */
    public void mo4053a(View view) {
        if (this.f4451h != null && (this.f4448e & 16) != 0) {
            this.f4444a.removeView(this.f4451h);
        }
        this.f4451h = view;
        if (view != null && (this.f4448e & 16) != 0) {
            this.f4444a.addView(this.f4451h);
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: u */
    public View mo4091u() {
        return this.f4451h;
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: a */
    public ViewPropertyAnimatorCompat mo4046a(final int i, long j) {
        return ViewCompat.m2608l(this.f4444a).m2753a(i == 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO).m2754a(j).m2755a(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.widget.ToolbarWidgetWrapper.2

            /* JADX INFO: renamed from: c */
            private boolean f4466c = false;

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            /* JADX INFO: renamed from: a */
            public void mo2762a(View view) {
                ToolbarWidgetWrapper.this.f4444a.setVisibility(0);
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            /* JADX INFO: renamed from: b */
            public void mo2763b(View view) {
                if (!this.f4466c) {
                    ToolbarWidgetWrapper.this.f4444a.setVisibility(i);
                }
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            /* JADX INFO: renamed from: c */
            public void mo2764c(View view) {
                this.f4466c = true;
            }
        });
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: c */
    public void mo4064c(Drawable drawable) {
        this.f4454k = drawable;
        m4979B();
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: f */
    public void mo4074f(int i) {
        mo4064c(i != 0 ? AppCompatResources.m3426b(mo4058b(), i) : null);
    }

    /* JADX INFO: renamed from: B */
    private void m4979B() {
        if ((this.f4448e & 4) != 0) {
            this.f4444a.setNavigationIcon(this.f4454k != null ? this.f4454k : this.f4461r);
        } else {
            this.f4444a.setNavigationIcon((Drawable) null);
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: d */
    public void mo4070d(CharSequence charSequence) {
        this.f4457n = charSequence;
        m4980C();
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: g */
    public void mo4076g(int i) {
        mo4070d(i == 0 ? null : mo4058b().getString(i));
    }

    /* JADX INFO: renamed from: C */
    private void m4980C() {
        if ((this.f4448e & 4) != 0) {
            if (TextUtils.isEmpty(this.f4457n)) {
                this.f4444a.setNavigationContentDescription(this.f4460q);
            } else {
                this.f4444a.setNavigationContentDescription(this.f4457n);
            }
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: d */
    public void mo4069d(Drawable drawable) {
        ViewCompat.m2582a(this.f4444a, drawable);
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: v */
    public int mo4092v() {
        return this.f4444a.getHeight();
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: h */
    public void mo4078h(int i) {
        this.f4444a.setVisibility(i);
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: w */
    public int mo4093w() {
        return this.f4444a.getVisibility();
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: a */
    public void mo4050a(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f4444a.setMenuCallbacks(callback, callback2);
    }

    @Override // android.support.v7.widget.DecorToolbar
    /* JADX INFO: renamed from: x */
    public Menu mo4094x() {
        return this.f4444a.getMenu();
    }
}
