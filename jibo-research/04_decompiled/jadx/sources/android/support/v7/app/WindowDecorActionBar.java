package android.support.v7.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.app.ActionBar;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.ActionMode;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {

    /* JADX INFO: renamed from: s */
    static final /* synthetic */ boolean f3058s;

    /* JADX INFO: renamed from: t */
    private static final Interpolator f3059t;

    /* JADX INFO: renamed from: u */
    private static final Interpolator f3060u;

    /* JADX INFO: renamed from: B */
    private boolean f3062B;

    /* JADX INFO: renamed from: C */
    private boolean f3063C;

    /* JADX INFO: renamed from: E */
    private boolean f3065E;

    /* JADX INFO: renamed from: G */
    private boolean f3067G;

    /* JADX INFO: renamed from: I */
    private boolean f3069I;

    /* JADX INFO: renamed from: a */
    Context f3070a;

    /* JADX INFO: renamed from: b */
    ActionBarOverlayLayout f3071b;

    /* JADX INFO: renamed from: c */
    ActionBarContainer f3072c;

    /* JADX INFO: renamed from: d */
    DecorToolbar f3073d;

    /* JADX INFO: renamed from: e */
    ActionBarContextView f3074e;

    /* JADX INFO: renamed from: f */
    View f3075f;

    /* JADX INFO: renamed from: g */
    ScrollingTabContainerView f3076g;

    /* JADX INFO: renamed from: h */
    ActionModeImpl f3077h;

    /* JADX INFO: renamed from: i */
    ActionMode f3078i;

    /* JADX INFO: renamed from: j */
    ActionMode.Callback f3079j;

    /* JADX INFO: renamed from: l */
    boolean f3081l;

    /* JADX INFO: renamed from: m */
    boolean f3082m;

    /* JADX INFO: renamed from: n */
    ViewPropertyAnimatorCompatSet f3083n;

    /* JADX INFO: renamed from: o */
    boolean f3084o;

    /* JADX INFO: renamed from: v */
    private Context f3088v;

    /* JADX INFO: renamed from: w */
    private Activity f3089w;

    /* JADX INFO: renamed from: x */
    private Dialog f3090x;

    /* JADX INFO: renamed from: z */
    private TabImpl f3092z;

    /* JADX INFO: renamed from: y */
    private ArrayList<TabImpl> f3091y = new ArrayList<>();

    /* JADX INFO: renamed from: A */
    private int f3061A = -1;

    /* JADX INFO: renamed from: D */
    private ArrayList<ActionBar.OnMenuVisibilityListener> f3064D = new ArrayList<>();

    /* JADX INFO: renamed from: F */
    private int f3066F = 0;

    /* JADX INFO: renamed from: k */
    boolean f3080k = true;

    /* JADX INFO: renamed from: H */
    private boolean f3068H = true;

    /* JADX INFO: renamed from: p */
    final ViewPropertyAnimatorListener f3085p = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.WindowDecorActionBar.1
        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        /* JADX INFO: renamed from: b */
        public void mo2763b(View view) {
            if (WindowDecorActionBar.this.f3080k && WindowDecorActionBar.this.f3075f != null) {
                WindowDecorActionBar.this.f3075f.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
                WindowDecorActionBar.this.f3072c.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
            }
            WindowDecorActionBar.this.f3072c.setVisibility(8);
            WindowDecorActionBar.this.f3072c.setTransitioning(false);
            WindowDecorActionBar.this.f3083n = null;
            WindowDecorActionBar.this.m3391a();
            if (WindowDecorActionBar.this.f3071b != null) {
                ViewCompat.m2613q(WindowDecorActionBar.this.f3071b);
            }
        }
    };

    /* JADX INFO: renamed from: q */
    final ViewPropertyAnimatorListener f3086q = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.WindowDecorActionBar.2
        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        /* JADX INFO: renamed from: b */
        public void mo2763b(View view) {
            WindowDecorActionBar.this.f3083n = null;
            WindowDecorActionBar.this.f3072c.requestLayout();
        }
    };

    /* JADX INFO: renamed from: r */
    final ViewPropertyAnimatorUpdateListener f3087r = new ViewPropertyAnimatorUpdateListener() { // from class: android.support.v7.app.WindowDecorActionBar.3
        @Override // android.support.v4.view.ViewPropertyAnimatorUpdateListener
        /* JADX INFO: renamed from: a */
        public void mo2765a(View view) {
            ((View) WindowDecorActionBar.this.f3072c.getParent()).invalidate();
        }
    };

    static {
        f3058s = !WindowDecorActionBar.class.desiredAssertionStatus();
        f3059t = new AccelerateInterpolator();
        f3060u = new DecelerateInterpolator();
    }

    public WindowDecorActionBar(Activity activity, boolean z) {
        this.f3089w = activity;
        View decorView = activity.getWindow().getDecorView();
        m3381a(decorView);
        if (!z) {
            this.f3075f = decorView.findViewById(R.id.content);
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        this.f3090x = dialog;
        m3381a(dialog.getWindow().getDecorView());
    }

    /* JADX INFO: renamed from: a */
    private void m3381a(View view) {
        this.f3071b = (ActionBarOverlayLayout) view.findViewById(android.support.v7.appcompat.R.id.decor_content_parent);
        if (this.f3071b != null) {
            this.f3071b.setActionBarVisibilityCallback(this);
        }
        this.f3073d = m3383b(view.findViewById(android.support.v7.appcompat.R.id.action_bar));
        this.f3074e = (ActionBarContextView) view.findViewById(android.support.v7.appcompat.R.id.action_context_bar);
        this.f3072c = (ActionBarContainer) view.findViewById(android.support.v7.appcompat.R.id.action_bar_container);
        if (this.f3073d == null || this.f3074e == null || this.f3072c == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f3070a = this.f3073d.mo4058b();
        boolean z = (this.f3073d.mo4086p() & 4) != 0;
        if (z) {
            this.f3062B = true;
        }
        ActionBarPolicy actionBarPolicyM3462a = ActionBarPolicy.m3462a(this.f3070a);
        setHomeButtonEnabled(actionBarPolicyM3462a.m3468f() || z);
        m3384e(actionBarPolicyM3462a.m3466d());
        TypedArray typedArrayObtainStyledAttributes = this.f3070a.obtainStyledAttributes(null, android.support.v7.appcompat.R.styleable.ActionBar, android.support.v7.appcompat.R.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.ActionBar_hideOnContentScroll, false)) {
            setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            setElevation(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: b */
    private DecorToolbar m3383b(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    @Override // android.support.v7.app.ActionBar
    public void setElevation(float f) {
        ViewCompat.m2574a(this.f3072c, f);
    }

    @Override // android.support.v7.app.ActionBar
    public float getElevation() {
        return ViewCompat.m2609m(this.f3072c);
    }

    @Override // android.support.v7.app.ActionBar
    public void onConfigurationChanged(Configuration configuration) {
        m3384e(ActionBarPolicy.m3462a(this.f3070a).m3466d());
    }

    /* JADX INFO: renamed from: e */
    private void m3384e(boolean z) {
        this.f3065E = z;
        if (!this.f3065E) {
            this.f3073d.mo4051a((ScrollingTabContainerView) null);
            this.f3072c.setTabContainer(this.f3076g);
        } else {
            this.f3072c.setTabContainer(null);
            this.f3073d.mo4051a(this.f3076g);
        }
        boolean z2 = getNavigationMode() == 2;
        if (this.f3076g != null) {
            if (z2) {
                this.f3076g.setVisibility(0);
                if (this.f3071b != null) {
                    ViewCompat.m2613q(this.f3071b);
                }
            } else {
                this.f3076g.setVisibility(8);
            }
        }
        this.f3073d.mo4057a(!this.f3065E && z2);
        this.f3071b.setHasNonEmbeddedTabs(!this.f3065E && z2);
    }

    /* JADX INFO: renamed from: f */
    private void m3385f() {
        if (this.f3076g == null) {
            ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.f3070a);
            if (this.f3065E) {
                scrollingTabContainerView.setVisibility(0);
                this.f3073d.mo4051a(scrollingTabContainerView);
            } else {
                if (getNavigationMode() == 2) {
                    scrollingTabContainerView.setVisibility(0);
                    if (this.f3071b != null) {
                        ViewCompat.m2613q(this.f3071b);
                    }
                } else {
                    scrollingTabContainerView.setVisibility(8);
                }
                this.f3072c.setTabContainer(scrollingTabContainerView);
            }
            this.f3076g = scrollingTabContainerView;
        }
    }

    /* JADX INFO: renamed from: a */
    void m3391a() {
        if (this.f3079j != null) {
            this.f3079j.mo3329a(this.f3078i);
            this.f3078i = null;
            this.f3079j = null;
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    /* JADX INFO: renamed from: a */
    public void mo3392a(int i) {
        this.f3066F = i;
    }

    @Override // android.support.v7.app.ActionBar
    public void setShowHideAnimationEnabled(boolean z) {
        this.f3069I = z;
        if (!z && this.f3083n != null) {
            this.f3083n.m3500c();
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f3064D.add(onMenuVisibilityListener);
    }

    @Override // android.support.v7.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f3064D.remove(onMenuVisibilityListener);
    }

    @Override // android.support.v7.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z != this.f3063C) {
            this.f3063C = z;
            int size = this.f3064D.size();
            for (int i = 0; i < size; i++) {
                this.f3064D.get(i).m3173a(z);
            }
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.f3073d.mo4047a(), false));
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayUseLogoEnabled(boolean z) {
        setDisplayOptions(z ? 1 : 0, 1);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayShowHomeEnabled(boolean z) {
        setDisplayOptions(z ? 2 : 0, 2);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayShowTitleEnabled(boolean z) {
        setDisplayOptions(z ? 8 : 0, 8);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayShowCustomEnabled(boolean z) {
        setDisplayOptions(z ? 16 : 0, 16);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeButtonEnabled(boolean z) {
        this.f3073d.mo4062b(z);
    }

    @Override // android.support.v7.app.ActionBar
    public void setTitle(int i) {
        setTitle(this.f3070a.getString(i));
    }

    @Override // android.support.v7.app.ActionBar
    public void setSubtitle(int i) {
        setSubtitle(this.f3070a.getString(i));
    }

    @Override // android.support.v7.app.ActionBar
    public void setSelectedNavigationItem(int i) {
        switch (this.f3073d.mo4088r()) {
            case 1:
                this.f3073d.mo4072e(i);
                return;
            case 2:
                selectTab(this.f3091y.get(i));
                return;
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void removeAllTabs() {
        m3387g();
    }

    /* JADX INFO: renamed from: g */
    private void m3387g() {
        if (this.f3092z != null) {
            selectTab(null);
        }
        this.f3091y.clear();
        if (this.f3076g != null) {
            this.f3076g.m4724a();
        }
        this.f3061A = -1;
    }

    @Override // android.support.v7.app.ActionBar
    public void setTitle(CharSequence charSequence) {
        this.f3073d.mo4061b(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setWindowTitle(CharSequence charSequence) {
        this.f3073d.mo4056a(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean requestFocus() {
        ViewGroup viewGroupMo4047a = this.f3073d.mo4047a();
        if (viewGroupMo4047a == null || viewGroupMo4047a.hasFocus()) {
            return false;
        }
        viewGroupMo4047a.requestFocus();
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    public void setSubtitle(CharSequence charSequence) {
        this.f3073d.mo4065c(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayOptions(int i) {
        if ((i & 4) != 0) {
            this.f3062B = true;
        }
        this.f3073d.mo4063c(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayOptions(int i, int i2) {
        int iMo4086p = this.f3073d.mo4086p();
        if ((i2 & 4) != 0) {
            this.f3062B = true;
        }
        this.f3073d.mo4063c((iMo4086p & (i2 ^ (-1))) | (i & i2));
    }

    @Override // android.support.v7.app.ActionBar
    public void setBackgroundDrawable(Drawable drawable) {
        this.f3072c.setPrimaryBackground(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable drawable) {
        this.f3072c.setStackedBackground(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.support.v7.app.ActionBar
    public View getCustomView() {
        return this.f3073d.mo4091u();
    }

    @Override // android.support.v7.app.ActionBar
    public CharSequence getTitle() {
        return this.f3073d.mo4071e();
    }

    @Override // android.support.v7.app.ActionBar
    public CharSequence getSubtitle() {
        return this.f3073d.mo4073f();
    }

    @Override // android.support.v7.app.ActionBar
    public int getNavigationMode() {
        return this.f3073d.mo4088r();
    }

    @Override // android.support.v7.app.ActionBar
    public int getDisplayOptions() {
        return this.f3073d.mo4086p();
    }

    @Override // android.support.v7.app.ActionBar
    public ActionMode startActionMode(ActionMode.Callback callback) {
        if (this.f3077h != null) {
            this.f3077h.mo3409c();
        }
        this.f3071b.setHideOnContentScrollEnabled(false);
        this.f3074e.m3697c();
        ActionModeImpl actionModeImpl = new ActionModeImpl(this.f3074e.getContext(), callback);
        if (!actionModeImpl.m3411e()) {
            return null;
        }
        this.f3077h = actionModeImpl;
        actionModeImpl.mo3410d();
        this.f3074e.m3695a(actionModeImpl);
        m3399d(true);
        this.f3074e.sendAccessibilityEvent(32);
        return actionModeImpl;
    }

    /* JADX INFO: renamed from: a */
    private void m3380a(ActionBar.Tab tab, int i) {
        TabImpl tabImpl = (TabImpl) tab;
        if (tabImpl.m3417g() == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        tabImpl.m3416a(i);
        this.f3091y.add(i, tabImpl);
        int size = this.f3091y.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            this.f3091y.get(i2).m3416a(i2);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab) {
        addTab(tab, this.f3091y.isEmpty());
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i) {
        addTab(tab, i, this.f3091y.isEmpty());
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab, boolean z) {
        m3385f();
        this.f3076g.m4728b(tab, z);
        m3380a(tab, this.f3091y.size());
        if (z) {
            selectTab(tab);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        m3385f();
        this.f3076g.m4726a(tab, i, z);
        m3380a(tab, i);
        if (z) {
            selectTab(tab);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public ActionBar.Tab newTab() {
        return new TabImpl();
    }

    @Override // android.support.v7.app.ActionBar
    public void removeTab(ActionBar.Tab tab) {
        removeTabAt(tab.mo3175a());
    }

    @Override // android.support.v7.app.ActionBar
    public void removeTabAt(int i) {
        if (this.f3076g != null) {
            int iMo3175a = this.f3092z != null ? this.f3092z.mo3175a() : this.f3061A;
            this.f3076g.m4727b(i);
            TabImpl tabImplRemove = this.f3091y.remove(i);
            if (tabImplRemove != null) {
                tabImplRemove.m3416a(-1);
            }
            int size = this.f3091y.size();
            for (int i2 = i; i2 < size; i2++) {
                this.f3091y.get(i2).m3416a(i2);
            }
            if (iMo3175a == i) {
                selectTab(this.f3091y.isEmpty() ? null : this.f3091y.get(Math.max(0, i - 1)));
            }
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void selectTab(ActionBar.Tab tab) {
        FragmentTransaction fragmentTransactionMo1377b;
        if (getNavigationMode() != 2) {
            this.f3061A = tab != null ? tab.mo3175a() : -1;
            return;
        }
        if ((this.f3089w instanceof FragmentActivity) && !this.f3073d.mo4047a().isInEditMode()) {
            fragmentTransactionMo1377b = ((FragmentActivity) this.f3089w).getSupportFragmentManager().mo1471a().mo1377b();
        } else {
            fragmentTransactionMo1377b = null;
        }
        if (this.f3092z == tab) {
            if (this.f3092z != null) {
                this.f3092z.m3417g().m3183c(this.f3092z, fragmentTransactionMo1377b);
                this.f3076g.m4725a(tab.mo3175a());
            }
        } else {
            this.f3076g.setTabSelected(tab != null ? tab.mo3175a() : -1);
            if (this.f3092z != null) {
                this.f3092z.m3417g().m3182b(this.f3092z, fragmentTransactionMo1377b);
            }
            this.f3092z = (TabImpl) tab;
            if (this.f3092z != null) {
                this.f3092z.m3417g().m3181a(this.f3092z, fragmentTransactionMo1377b);
            }
        }
        if (fragmentTransactionMo1377b != null && !fragmentTransactionMo1377b.mo1392k()) {
            fragmentTransactionMo1377b.mo1385d();
        }
    }

    @Override // android.support.v7.app.ActionBar
    public ActionBar.Tab getSelectedTab() {
        return this.f3092z;
    }

    @Override // android.support.v7.app.ActionBar
    public int getHeight() {
        return this.f3072c.getHeight();
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    /* JADX INFO: renamed from: a */
    public void mo3393a(boolean z) {
        this.f3080k = z;
    }

    @Override // android.support.v7.app.ActionBar
    public void show() {
        if (this.f3081l) {
            this.f3081l = false;
            m3386f(false);
        }
    }

    /* JADX INFO: renamed from: h */
    private void m3388h() {
        if (!this.f3067G) {
            this.f3067G = true;
            if (this.f3071b != null) {
                this.f3071b.setShowingForActionMode(true);
            }
            m3386f(false);
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    /* JADX INFO: renamed from: b */
    public void mo3394b() {
        if (this.f3082m) {
            this.f3082m = false;
            m3386f(true);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void hide() {
        if (!this.f3081l) {
            this.f3081l = true;
            m3386f(false);
        }
    }

    /* JADX INFO: renamed from: i */
    private void m3389i() {
        if (this.f3067G) {
            this.f3067G = false;
            if (this.f3071b != null) {
                this.f3071b.setShowingForActionMode(false);
            }
            m3386f(false);
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    /* JADX INFO: renamed from: c */
    public void mo3396c() {
        if (!this.f3082m) {
            this.f3082m = true;
            m3386f(true);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void setHideOnContentScrollEnabled(boolean z) {
        if (z && !this.f3071b.m3710a()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f3084o = z;
        this.f3071b.setHideOnContentScrollEnabled(z);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isHideOnContentScrollEnabled() {
        return this.f3071b.m3713d();
    }

    @Override // android.support.v7.app.ActionBar
    public int getHideOffset() {
        return this.f3071b.getActionBarHideOffset();
    }

    @Override // android.support.v7.app.ActionBar
    public void setHideOffset(int i) {
        if (i != 0 && !this.f3071b.m3710a()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
        }
        this.f3071b.setActionBarHideOffset(i);
    }

    /* JADX INFO: renamed from: a */
    static boolean m3382a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    /* JADX INFO: renamed from: f */
    private void m3386f(boolean z) {
        if (m3382a(this.f3081l, this.f3082m, this.f3067G)) {
            if (!this.f3068H) {
                this.f3068H = true;
                m3395b(z);
                return;
            }
            return;
        }
        if (this.f3068H) {
            this.f3068H = false;
            m3397c(z);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3395b(boolean z) {
        if (this.f3083n != null) {
            this.f3083n.m3500c();
        }
        this.f3072c.setVisibility(0);
        if (this.f3066F == 0 && (this.f3069I || z)) {
            this.f3072c.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
            float f = -this.f3072c.getHeight();
            if (z) {
                this.f3072c.getLocationInWindow(new int[]{0, 0});
                f -= r1[1];
            }
            this.f3072c.setTranslationY(f);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatM2758b = ViewCompat.m2608l(this.f3072c).m2758b(CropImageView.DEFAULT_ASPECT_RATIO);
            viewPropertyAnimatorCompatM2758b.m2756a(this.f3087r);
            viewPropertyAnimatorCompatSet.m3494a(viewPropertyAnimatorCompatM2758b);
            if (this.f3080k && this.f3075f != null) {
                this.f3075f.setTranslationY(f);
                viewPropertyAnimatorCompatSet.m3494a(ViewCompat.m2608l(this.f3075f).m2758b(CropImageView.DEFAULT_ASPECT_RATIO));
            }
            viewPropertyAnimatorCompatSet.m3497a(f3060u);
            viewPropertyAnimatorCompatSet.m3493a(250L);
            viewPropertyAnimatorCompatSet.m3496a(this.f3086q);
            this.f3083n = viewPropertyAnimatorCompatSet;
            viewPropertyAnimatorCompatSet.m3498a();
        } else {
            this.f3072c.setAlpha(1.0f);
            this.f3072c.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
            if (this.f3080k && this.f3075f != null) {
                this.f3075f.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
            }
            this.f3086q.mo2763b(null);
        }
        if (this.f3071b != null) {
            ViewCompat.m2613q(this.f3071b);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m3397c(boolean z) {
        if (this.f3083n != null) {
            this.f3083n.m3500c();
        }
        if (this.f3066F == 0 && (this.f3069I || z)) {
            this.f3072c.setAlpha(1.0f);
            this.f3072c.setTransitioning(true);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            float f = -this.f3072c.getHeight();
            if (z) {
                this.f3072c.getLocationInWindow(new int[]{0, 0});
                f -= r2[1];
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatM2758b = ViewCompat.m2608l(this.f3072c).m2758b(f);
            viewPropertyAnimatorCompatM2758b.m2756a(this.f3087r);
            viewPropertyAnimatorCompatSet.m3494a(viewPropertyAnimatorCompatM2758b);
            if (this.f3080k && this.f3075f != null) {
                viewPropertyAnimatorCompatSet.m3494a(ViewCompat.m2608l(this.f3075f).m2758b(f));
            }
            viewPropertyAnimatorCompatSet.m3497a(f3059t);
            viewPropertyAnimatorCompatSet.m3493a(250L);
            viewPropertyAnimatorCompatSet.m3496a(this.f3085p);
            this.f3083n = viewPropertyAnimatorCompatSet;
            viewPropertyAnimatorCompatSet.m3498a();
            return;
        }
        this.f3085p.mo2763b(null);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isShowing() {
        int height = getHeight();
        return this.f3068H && (height == 0 || getHideOffset() < height);
    }

    /* JADX INFO: renamed from: d */
    public void m3399d(boolean z) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatMo4046a;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatMo3689a;
        if (z) {
            m3388h();
        } else {
            m3389i();
        }
        if (m3390j()) {
            if (z) {
                viewPropertyAnimatorCompatMo3689a = this.f3073d.mo4046a(4, 100L);
                viewPropertyAnimatorCompatMo4046a = this.f3074e.mo3689a(0, 200L);
            } else {
                viewPropertyAnimatorCompatMo4046a = this.f3073d.mo4046a(0, 200L);
                viewPropertyAnimatorCompatMo3689a = this.f3074e.mo3689a(8, 100L);
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            viewPropertyAnimatorCompatSet.m3495a(viewPropertyAnimatorCompatMo3689a, viewPropertyAnimatorCompatMo4046a);
            viewPropertyAnimatorCompatSet.m3498a();
            return;
        }
        if (z) {
            this.f3073d.mo4078h(4);
            this.f3074e.setVisibility(0);
        } else {
            this.f3073d.mo4078h(0);
            this.f3074e.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: j */
    private boolean m3390j() {
        return ViewCompat.m2621y(this.f3072c);
    }

    @Override // android.support.v7.app.ActionBar
    public Context getThemedContext() {
        if (this.f3088v == null) {
            TypedValue typedValue = new TypedValue();
            this.f3070a.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f3088v = new ContextThemeWrapper(this.f3070a, i);
            } else {
                this.f3088v = this.f3070a;
            }
        }
        return this.f3088v;
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isTitleTruncated() {
        return this.f3073d != null && this.f3073d.mo4087q();
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeAsUpIndicator(Drawable drawable) {
        this.f3073d.mo4064c(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeAsUpIndicator(int i) {
        this.f3073d.mo4074f(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.f3073d.mo4070d(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeActionContentDescription(int i) {
        this.f3073d.mo4076g(i);
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    /* JADX INFO: renamed from: d */
    public void mo3398d() {
        if (this.f3083n != null) {
            this.f3083n.m3500c();
            this.f3083n = null;
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    /* JADX INFO: renamed from: e */
    public void mo3400e() {
    }

    @Override // android.support.v7.app.ActionBar
    public boolean collapseActionView() {
        if (this.f3073d == null || !this.f3073d.mo4066c()) {
            return false;
        }
        this.f3073d.mo4067d();
        return true;
    }

    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {

        /* JADX INFO: renamed from: b */
        private final Context f3097b;

        /* JADX INFO: renamed from: c */
        private final MenuBuilder f3098c;

        /* JADX INFO: renamed from: d */
        private ActionMode.Callback f3099d;

        /* JADX INFO: renamed from: e */
        private WeakReference<View> f3100e;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.f3097b = context;
            this.f3099d = callback;
            this.f3098c = new MenuBuilder(context).m3580a(1);
            this.f3098c.mo3587a(this);
        }

        @Override // android.support.v7.view.ActionMode
        /* JADX INFO: renamed from: a */
        public MenuInflater mo3401a() {
            return new SupportMenuInflater(this.f3097b);
        }

        @Override // android.support.v7.view.ActionMode
        /* JADX INFO: renamed from: b */
        public Menu mo3406b() {
            return this.f3098c;
        }

        @Override // android.support.v7.view.ActionMode
        /* JADX INFO: renamed from: c */
        public void mo3409c() {
            if (WindowDecorActionBar.this.f3077h == this) {
                if (!WindowDecorActionBar.m3382a(WindowDecorActionBar.this.f3081l, WindowDecorActionBar.this.f3082m, false)) {
                    WindowDecorActionBar.this.f3078i = this;
                    WindowDecorActionBar.this.f3079j = this.f3099d;
                } else {
                    this.f3099d.mo3329a(this);
                }
                this.f3099d = null;
                WindowDecorActionBar.this.m3399d(false);
                WindowDecorActionBar.this.f3074e.m3696b();
                WindowDecorActionBar.this.f3073d.mo4047a().sendAccessibilityEvent(32);
                WindowDecorActionBar.this.f3071b.setHideOnContentScrollEnabled(WindowDecorActionBar.this.f3084o);
                WindowDecorActionBar.this.f3077h = null;
            }
        }

        @Override // android.support.v7.view.ActionMode
        /* JADX INFO: renamed from: d */
        public void mo3410d() {
            if (WindowDecorActionBar.this.f3077h == this) {
                this.f3098c.m3614g();
                try {
                    this.f3099d.mo3332b(this, this.f3098c);
                } finally {
                    this.f3098c.m3615h();
                }
            }
        }

        /* JADX INFO: renamed from: e */
        public boolean m3411e() {
            this.f3098c.m3614g();
            try {
                return this.f3099d.mo3330a(this, this.f3098c);
            } finally {
                this.f3098c.m3615h();
            }
        }

        @Override // android.support.v7.view.ActionMode
        /* JADX INFO: renamed from: a */
        public void mo3403a(View view) {
            WindowDecorActionBar.this.f3074e.setCustomView(view);
            this.f3100e = new WeakReference<>(view);
        }

        @Override // android.support.v7.view.ActionMode
        /* JADX INFO: renamed from: a */
        public void mo3404a(CharSequence charSequence) {
            WindowDecorActionBar.this.f3074e.setSubtitle(charSequence);
        }

        @Override // android.support.v7.view.ActionMode
        /* JADX INFO: renamed from: b */
        public void mo3408b(CharSequence charSequence) {
            WindowDecorActionBar.this.f3074e.setTitle(charSequence);
        }

        @Override // android.support.v7.view.ActionMode
        /* JADX INFO: renamed from: a */
        public void mo3402a(int i) {
            mo3408b(WindowDecorActionBar.this.f3070a.getResources().getString(i));
        }

        @Override // android.support.v7.view.ActionMode
        /* JADX INFO: renamed from: b */
        public void mo3407b(int i) {
            mo3404a((CharSequence) WindowDecorActionBar.this.f3070a.getResources().getString(i));
        }

        @Override // android.support.v7.view.ActionMode
        /* JADX INFO: renamed from: f */
        public CharSequence mo3412f() {
            return WindowDecorActionBar.this.f3074e.getTitle();
        }

        @Override // android.support.v7.view.ActionMode
        /* JADX INFO: renamed from: g */
        public CharSequence mo3413g() {
            return WindowDecorActionBar.this.f3074e.getSubtitle();
        }

        @Override // android.support.v7.view.ActionMode
        /* JADX INFO: renamed from: a */
        public void mo3405a(boolean z) {
            super.mo3405a(z);
            WindowDecorActionBar.this.f3074e.setTitleOptional(z);
        }

        @Override // android.support.v7.view.ActionMode
        /* JADX INFO: renamed from: h */
        public boolean mo3414h() {
            return WindowDecorActionBar.this.f3074e.m3698d();
        }

        @Override // android.support.v7.view.ActionMode
        /* JADX INFO: renamed from: i */
        public View mo3415i() {
            if (this.f3100e != null) {
                return this.f3100e.get();
            }
            return null;
        }

        @Override // android.support.v7.view.menu.MenuBuilder.Callback
        /* JADX INFO: renamed from: a */
        public boolean mo518a(MenuBuilder menuBuilder, MenuItem menuItem) {
            if (this.f3099d != null) {
                return this.f3099d.mo3331a(this, menuItem);
            }
            return false;
        }

        @Override // android.support.v7.view.menu.MenuBuilder.Callback
        /* JADX INFO: renamed from: a */
        public void mo517a(MenuBuilder menuBuilder) {
            if (this.f3099d != null) {
                mo3410d();
                WindowDecorActionBar.this.f3074e.mo3690a();
            }
        }
    }

    public class TabImpl extends ActionBar.Tab {

        /* JADX INFO: renamed from: b */
        private ActionBar.TabListener f3102b;

        /* JADX INFO: renamed from: c */
        private Drawable f3103c;

        /* JADX INFO: renamed from: d */
        private CharSequence f3104d;

        /* JADX INFO: renamed from: e */
        private CharSequence f3105e;

        /* JADX INFO: renamed from: f */
        private int f3106f = -1;

        /* JADX INFO: renamed from: g */
        private View f3107g;

        public TabImpl() {
        }

        /* JADX INFO: renamed from: g */
        public ActionBar.TabListener m3417g() {
            return this.f3102b;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        /* JADX INFO: renamed from: d */
        public View mo3178d() {
            return this.f3107g;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        /* JADX INFO: renamed from: b */
        public Drawable mo3176b() {
            return this.f3103c;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        /* JADX INFO: renamed from: a */
        public int mo3175a() {
            return this.f3106f;
        }

        /* JADX INFO: renamed from: a */
        public void m3416a(int i) {
            this.f3106f = i;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        /* JADX INFO: renamed from: c */
        public CharSequence mo3177c() {
            return this.f3104d;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        /* JADX INFO: renamed from: e */
        public void mo3179e() {
            WindowDecorActionBar.this.selectTab(this);
        }

        @Override // android.support.v7.app.ActionBar.Tab
        /* JADX INFO: renamed from: f */
        public CharSequence mo3180f() {
            return this.f3105e;
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(View view) {
        this.f3073d.mo4053a(view);
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.f3073d.mo4053a(view);
    }

    @Override // android.support.v7.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.f3073d.mo4055a(spinnerAdapter, new NavItemSelectedListener(onNavigationListener));
    }

    @Override // android.support.v7.app.ActionBar
    public int getSelectedNavigationIndex() {
        switch (this.f3073d.mo4088r()) {
            case 2:
                if (this.f3092z != null) {
                }
                break;
        }
        return -1;
    }

    @Override // android.support.v7.app.ActionBar
    public int getNavigationItemCount() {
        switch (this.f3073d.mo4088r()) {
            case 1:
                return this.f3073d.mo4090t();
            case 2:
                return this.f3091y.size();
            default:
                return 0;
        }
    }

    @Override // android.support.v7.app.ActionBar
    public int getTabCount() {
        return this.f3091y.size();
    }

    @Override // android.support.v7.app.ActionBar
    public void setNavigationMode(int i) {
        int iMo4088r = this.f3073d.mo4088r();
        switch (iMo4088r) {
            case 2:
                this.f3061A = getSelectedNavigationIndex();
                selectTab(null);
                this.f3076g.setVisibility(8);
                break;
        }
        if (iMo4088r != i && !this.f3065E && this.f3071b != null) {
            ViewCompat.m2613q(this.f3071b);
        }
        this.f3073d.mo4068d(i);
        switch (i) {
            case 2:
                m3385f();
                this.f3076g.setVisibility(0);
                if (this.f3061A != -1) {
                    setSelectedNavigationItem(this.f3061A);
                    this.f3061A = -1;
                }
                break;
        }
        this.f3073d.mo4057a(i == 2 && !this.f3065E);
        this.f3071b.setHasNonEmbeddedTabs(i == 2 && !this.f3065E);
    }

    @Override // android.support.v7.app.ActionBar
    public ActionBar.Tab getTabAt(int i) {
        return this.f3091y.get(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setIcon(int i) {
        this.f3073d.mo4048a(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setIcon(Drawable drawable) {
        this.f3073d.mo4049a(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setLogo(int i) {
        this.f3073d.mo4059b(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setLogo(Drawable drawable) {
        this.f3073d.mo4060b(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
        if (!this.f3062B) {
            setDisplayHomeAsUpEnabled(z);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        Menu menuMo3406b;
        if (this.f3077h == null || (menuMo3406b = this.f3077h.mo3406b()) == null) {
            return false;
        }
        menuMo3406b.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuMo3406b.performShortcut(i, keyEvent, 0);
    }
}
