package android.support.v7.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.NavUtils;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.view.StandaloneActionMode;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.FitWindowsViewGroup;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.VectorEnabledTintResources;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ViewUtils;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.yalantis.ucrop.view.CropImageView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
class AppCompatDelegateImplV9 extends AppCompatDelegateImplBase implements MenuBuilder.Callback, LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: t */
    private static final boolean f2958t;

    /* JADX INFO: renamed from: A */
    private View f2959A;

    /* JADX INFO: renamed from: B */
    private boolean f2960B;

    /* JADX INFO: renamed from: C */
    private boolean f2961C;

    /* JADX INFO: renamed from: D */
    private boolean f2962D;

    /* JADX INFO: renamed from: E */
    private PanelFeatureState[] f2963E;

    /* JADX INFO: renamed from: F */
    private PanelFeatureState f2964F;

    /* JADX INFO: renamed from: G */
    private boolean f2965G;

    /* JADX INFO: renamed from: H */
    private final Runnable f2966H;

    /* JADX INFO: renamed from: I */
    private boolean f2967I;

    /* JADX INFO: renamed from: J */
    private Rect f2968J;

    /* JADX INFO: renamed from: K */
    private Rect f2969K;

    /* JADX INFO: renamed from: L */
    private AppCompatViewInflater f2970L;

    /* JADX INFO: renamed from: m */
    ActionMode f2971m;

    /* JADX INFO: renamed from: n */
    ActionBarContextView f2972n;

    /* JADX INFO: renamed from: o */
    PopupWindow f2973o;

    /* JADX INFO: renamed from: p */
    Runnable f2974p;

    /* JADX INFO: renamed from: q */
    ViewPropertyAnimatorCompat f2975q;

    /* JADX INFO: renamed from: r */
    boolean f2976r;

    /* JADX INFO: renamed from: s */
    int f2977s;

    /* JADX INFO: renamed from: u */
    private DecorContentParent f2978u;

    /* JADX INFO: renamed from: v */
    private ActionMenuPresenterCallback f2979v;

    /* JADX INFO: renamed from: w */
    private PanelMenuPresenterCallback f2980w;

    /* JADX INFO: renamed from: x */
    private boolean f2981x;

    /* JADX INFO: renamed from: y */
    private ViewGroup f2982y;

    /* JADX INFO: renamed from: z */
    private TextView f2983z;

    static {
        f2958t = Build.VERSION.SDK_INT < 21;
    }

    AppCompatDelegateImplV9(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        this.f2975q = null;
        this.f2966H = new Runnable() { // from class: android.support.v7.app.AppCompatDelegateImplV9.1
            @Override // java.lang.Runnable
            public void run() {
                if ((AppCompatDelegateImplV9.this.f2977s & 1) != 0) {
                    AppCompatDelegateImplV9.this.m3318f(0);
                }
                if ((AppCompatDelegateImplV9.this.f2977s & 4096) != 0) {
                    AppCompatDelegateImplV9.this.m3318f(108);
                }
                AppCompatDelegateImplV9.this.f2976r = false;
                AppCompatDelegateImplV9.this.f2977s = 0;
            }
        };
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: a */
    public void mo3247a(Bundle bundle) {
        if ((this.f2928c instanceof Activity) && NavUtils.m1714b((Activity) this.f2928c) != null) {
            ActionBar actionBarN = m3274n();
            if (actionBarN == null) {
                this.f2967I = true;
            } else {
                actionBarN.setDefaultDisplayHomeAsUpEnabled(true);
            }
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: b */
    public void mo3254b(Bundle bundle) {
        m3305x();
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    /* JADX INFO: renamed from: m */
    public void mo3273m() {
        m3305x();
        if (this.f2933h && this.f2931f == null) {
            if (this.f2928c instanceof Activity) {
                this.f2931f = new WindowDecorActionBar((Activity) this.f2928c, this.f2934i);
            } else if (this.f2928c instanceof Dialog) {
                this.f2931f = new WindowDecorActionBar((Dialog) this.f2928c);
            }
            if (this.f2931f != null) {
                this.f2931f.setDefaultDisplayHomeAsUpEnabled(this.f2967I);
            }
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: a */
    public void mo3248a(Toolbar toolbar) {
        if (this.f2928c instanceof Activity) {
            ActionBar actionBarA = mo3243a();
            if (actionBarA instanceof WindowDecorActionBar) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f2932g = null;
            if (actionBarA != null) {
                actionBarA.onDestroy();
            }
            if (toolbar != null) {
                ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, ((Activity) this.f2928c).getTitle(), this.f2929d);
                this.f2931f = toolbarActionBar;
                this.f2927b.setCallback(toolbarActionBar.getWrappedWindowCallback());
            } else {
                this.f2931f = null;
                this.f2927b.setCallback(this.f2929d);
            }
            mo3261f();
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: a */
    public <T extends View> T mo3245a(int i) {
        m3305x();
        return (T) this.f2927b.findViewById(i);
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: a */
    public void mo3246a(Configuration configuration) {
        ActionBar actionBarA;
        if (this.f2933h && this.f2981x && (actionBarA = mo3243a()) != null) {
            actionBarA.onConfigurationChanged(configuration);
        }
        AppCompatDrawableManager.m3862a().m3884a(this.f2926a);
        mo3265j();
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: d */
    public void mo3259d() {
        ActionBar actionBarA = mo3243a();
        if (actionBarA != null) {
            actionBarA.setShowHideAnimationEnabled(false);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: e */
    public void mo3260e() {
        ActionBar actionBarA = mo3243a();
        if (actionBarA != null) {
            actionBarA.setShowHideAnimationEnabled(true);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: a */
    public void mo3249a(View view) {
        m3305x();
        ViewGroup viewGroup = (ViewGroup) this.f2982y.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f2928c.onContentChanged();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: b */
    public void mo3253b(int i) {
        m3305x();
        ViewGroup viewGroup = (ViewGroup) this.f2982y.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f2926a).inflate(i, viewGroup);
        this.f2928c.onContentChanged();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: a */
    public void mo3250a(View view, ViewGroup.LayoutParams layoutParams) {
        m3305x();
        ViewGroup viewGroup = (ViewGroup) this.f2982y.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f2928c.onContentChanged();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: b */
    public void mo3255b(View view, ViewGroup.LayoutParams layoutParams) {
        m3305x();
        ((ViewGroup) this.f2982y.findViewById(R.id.content)).addView(view, layoutParams);
        this.f2928c.onContentChanged();
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: g */
    public void mo3262g() {
        if (this.f2976r) {
            this.f2927b.getDecorView().removeCallbacks(this.f2966H);
        }
        super.mo3262g();
        if (this.f2931f != null) {
            this.f2931f.onDestroy();
        }
    }

    /* JADX INFO: renamed from: x */
    private void m3305x() {
        if (!this.f2981x) {
            this.f2982y = m3306y();
            CharSequence charSequenceS = m3279s();
            if (!TextUtils.isEmpty(charSequenceS)) {
                mo3271b(charSequenceS);
            }
            m3307z();
            m3312a(this.f2982y);
            this.f2981x = true;
            PanelFeatureState panelFeatureStateM3308a = m3308a(0, false);
            if (m3277q()) {
                return;
            }
            if (panelFeatureStateM3308a == null || panelFeatureStateM3308a.f3005j == null) {
                m3301d(108);
            }
        }
    }

    /* JADX INFO: renamed from: y */
    private ViewGroup m3306y() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        Context contextThemeWrapper;
        TypedArray typedArrayObtainStyledAttributes = this.f2926a.obtainStyledAttributes(android.support.v7.appcompat.R.styleable.AppCompatTheme);
        if (!typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowNoTitle, false)) {
            mo3258c(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowActionBar, false)) {
            mo3258c(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            mo3258c(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            mo3258c(10);
        }
        this.f2936k = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        this.f2927b.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f2926a);
        if (!this.f2937l) {
            if (this.f2936k) {
                ViewGroup viewGroup3 = (ViewGroup) layoutInflaterFrom.inflate(android.support.v7.appcompat.R.layout.abc_dialog_title_material, (ViewGroup) null);
                this.f2934i = false;
                this.f2933h = false;
                viewGroup2 = viewGroup3;
            } else if (this.f2933h) {
                TypedValue typedValue = new TypedValue();
                this.f2926a.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    contextThemeWrapper = new ContextThemeWrapper(this.f2926a, typedValue.resourceId);
                } else {
                    contextThemeWrapper = this.f2926a;
                }
                ViewGroup viewGroup4 = (ViewGroup) LayoutInflater.from(contextThemeWrapper).inflate(android.support.v7.appcompat.R.layout.abc_screen_toolbar, (ViewGroup) null);
                this.f2978u = (DecorContentParent) viewGroup4.findViewById(android.support.v7.appcompat.R.id.decor_content_parent);
                this.f2978u.setWindowCallback(m3278r());
                if (this.f2934i) {
                    this.f2978u.mo3708a(109);
                }
                if (this.f2960B) {
                    this.f2978u.mo3708a(2);
                }
                if (this.f2961C) {
                    this.f2978u.mo3708a(5);
                }
                viewGroup2 = viewGroup4;
            } else {
                viewGroup2 = null;
            }
        } else {
            if (this.f2935j) {
                viewGroup = (ViewGroup) layoutInflaterFrom.inflate(android.support.v7.appcompat.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
            } else {
                viewGroup = (ViewGroup) layoutInflaterFrom.inflate(android.support.v7.appcompat.R.layout.abc_screen_simple, (ViewGroup) null);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                ViewCompat.m2584a(viewGroup, new OnApplyWindowInsetsListener() { // from class: android.support.v7.app.AppCompatDelegateImplV9.2
                    @Override // android.support.v4.view.OnApplyWindowInsetsListener
                    /* JADX INFO: renamed from: a */
                    public WindowInsetsCompat mo399a(View view, WindowInsetsCompat windowInsetsCompat) {
                        int iM2770b = windowInsetsCompat.m2770b();
                        int iM3319g = AppCompatDelegateImplV9.this.m3319g(iM2770b);
                        if (iM2770b != iM3319g) {
                            windowInsetsCompat = windowInsetsCompat.m2769a(windowInsetsCompat.m2768a(), iM3319g, windowInsetsCompat.m2771c(), windowInsetsCompat.m2772d());
                        }
                        return ViewCompat.m2573a(view, windowInsetsCompat);
                    }
                });
                viewGroup2 = viewGroup;
            } else {
                ((FitWindowsViewGroup) viewGroup).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener() { // from class: android.support.v7.app.AppCompatDelegateImplV9.3
                    @Override // android.support.v7.widget.FitWindowsViewGroup.OnFitSystemWindowsListener
                    /* JADX INFO: renamed from: a */
                    public void mo3324a(Rect rect) {
                        rect.top = AppCompatDelegateImplV9.this.m3319g(rect.top);
                    }
                });
                viewGroup2 = viewGroup;
            }
        }
        if (viewGroup2 == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f2933h + ", windowActionBarOverlay: " + this.f2934i + ", android:windowIsFloating: " + this.f2936k + ", windowActionModeOverlay: " + this.f2935j + ", windowNoTitle: " + this.f2937l + " }");
        }
        if (this.f2978u == null) {
            this.f2983z = (TextView) viewGroup2.findViewById(android.support.v7.appcompat.R.id.title);
        }
        ViewUtils.m5032b(viewGroup2);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup2.findViewById(android.support.v7.appcompat.R.id.action_bar_activity_content);
        ViewGroup viewGroup5 = (ViewGroup) this.f2927b.findViewById(R.id.content);
        if (viewGroup5 != null) {
            while (viewGroup5.getChildCount() > 0) {
                View childAt = viewGroup5.getChildAt(0);
                viewGroup5.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup5.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup5 instanceof FrameLayout) {
                ((FrameLayout) viewGroup5).setForeground(null);
            }
        }
        this.f2927b.setContentView(viewGroup2);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener() { // from class: android.support.v7.app.AppCompatDelegateImplV9.4
            @Override // android.support.v7.widget.ContentFrameLayout.OnAttachListener
            /* JADX INFO: renamed from: a */
            public void mo3325a() {
            }

            @Override // android.support.v7.widget.ContentFrameLayout.OnAttachListener
            /* JADX INFO: renamed from: b */
            public void mo3326b() {
                AppCompatDelegateImplV9.this.m3323w();
            }
        });
        return viewGroup2;
    }

    /* JADX INFO: renamed from: a */
    void m3312a(ViewGroup viewGroup) {
    }

    /* JADX INFO: renamed from: z */
    private void m3307z() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f2982y.findViewById(R.id.content);
        View decorView = this.f2927b.getDecorView();
        contentFrameLayout.m4044a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f2926a.obtainStyledAttributes(android.support.v7.appcompat.R.styleable.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            typedArrayObtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            typedArrayObtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            typedArrayObtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            typedArrayObtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: c */
    public boolean mo3258c(int i) {
        int iM3304h = m3304h(i);
        if (this.f2937l && iM3304h == 108) {
            return false;
        }
        if (this.f2933h && iM3304h == 1) {
            this.f2933h = false;
        }
        switch (iM3304h) {
            case 1:
                m3292A();
                this.f2937l = true;
                return true;
            case 2:
                m3292A();
                this.f2960B = true;
                return true;
            case 5:
                m3292A();
                this.f2961C = true;
                return true;
            case 10:
                m3292A();
                this.f2935j = true;
                return true;
            case 108:
                m3292A();
                this.f2933h = true;
                return true;
            case 109:
                m3292A();
                this.f2934i = true;
                return true;
            default:
                return this.f2927b.requestFeature(iM3304h);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    /* JADX INFO: renamed from: b */
    void mo3271b(CharSequence charSequence) {
        if (this.f2978u != null) {
            this.f2978u.setWindowTitle(charSequence);
        } else if (m3274n() != null) {
            m3274n().setWindowTitle(charSequence);
        } else if (this.f2983z != null) {
            this.f2983z.setText(charSequence);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    /* JADX INFO: renamed from: a */
    void mo3267a(int i, Menu menu) {
        if (i == 108) {
            ActionBar actionBarA = mo3243a();
            if (actionBarA != null) {
                actionBarA.dispatchMenuVisibilityChanged(false);
                return;
            }
            return;
        }
        if (i == 0) {
            PanelFeatureState panelFeatureStateM3308a = m3308a(i, true);
            if (panelFeatureStateM3308a.f3010o) {
                m3311a(panelFeatureStateM3308a, false);
            }
        }
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    /* JADX INFO: renamed from: b */
    boolean mo3272b(int i, Menu menu) {
        if (i != 108) {
            return false;
        }
        ActionBar actionBarA = mo3243a();
        if (actionBarA == null) {
            return true;
        }
        actionBarA.dispatchMenuVisibilityChanged(true);
        return true;
    }

    @Override // android.support.v7.view.menu.MenuBuilder.Callback
    /* JADX INFO: renamed from: a */
    public boolean mo518a(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState panelFeatureStateM3309a;
        Window.Callback callbackR = m3278r();
        if (callbackR == null || m3277q() || (panelFeatureStateM3309a = m3309a((Menu) menuBuilder.mo3623p())) == null) {
            return false;
        }
        return callbackR.onMenuItemSelected(panelFeatureStateM3309a.f2996a, menuItem);
    }

    @Override // android.support.v7.view.menu.MenuBuilder.Callback
    /* JADX INFO: renamed from: a */
    public void mo517a(MenuBuilder menuBuilder) {
        m3294a(menuBuilder, true);
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: a */
    public ActionMode mo3244a(ActionMode.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f2971m != null) {
            this.f2971m.mo3409c();
        }
        ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9 = new ActionModeCallbackWrapperV9(callback);
        ActionBar actionBarA = mo3243a();
        if (actionBarA != null) {
            this.f2971m = actionBarA.startActionMode(actionModeCallbackWrapperV9);
            if (this.f2971m != null && this.f2930e != null) {
                this.f2930e.onSupportActionModeStarted(this.f2971m);
            }
        }
        if (this.f2971m == null) {
            this.f2971m = mo3270b(actionModeCallbackWrapperV9);
        }
        return this.f2971m;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: f */
    public void mo3261f() {
        ActionBar actionBarA = mo3243a();
        if (actionBarA == null || !actionBarA.invalidateOptionsMenu()) {
            m3301d(0);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    /* JADX INFO: renamed from: b */
    ActionMode mo3270b(ActionMode.Callback callback) {
        ActionMode actionModeOnWindowStartingSupportActionMode;
        Context contextThemeWrapper;
        m3321u();
        if (this.f2971m != null) {
            this.f2971m.mo3409c();
        }
        if (!(callback instanceof ActionModeCallbackWrapperV9)) {
            callback = new ActionModeCallbackWrapperV9(callback);
        }
        if (this.f2930e == null || m3277q()) {
            actionModeOnWindowStartingSupportActionMode = null;
        } else {
            try {
                actionModeOnWindowStartingSupportActionMode = this.f2930e.onWindowStartingSupportActionMode(callback);
            } catch (AbstractMethodError e) {
                actionModeOnWindowStartingSupportActionMode = null;
            }
        }
        if (actionModeOnWindowStartingSupportActionMode != null) {
            this.f2971m = actionModeOnWindowStartingSupportActionMode;
        } else {
            if (this.f2972n == null) {
                if (this.f2936k) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f2926a.getTheme();
                    theme.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f2926a.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        contextThemeWrapper = new ContextThemeWrapper(this.f2926a, 0);
                        contextThemeWrapper.getTheme().setTo(themeNewTheme);
                    } else {
                        contextThemeWrapper = this.f2926a;
                    }
                    this.f2972n = new ActionBarContextView(contextThemeWrapper);
                    this.f2973o = new PopupWindow(contextThemeWrapper, (AttributeSet) null, android.support.v7.appcompat.R.attr.actionModePopupWindowStyle);
                    PopupWindowCompat.m3060a(this.f2973o, 2);
                    this.f2973o.setContentView(this.f2972n);
                    this.f2973o.setWidth(-1);
                    contextThemeWrapper.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.actionBarSize, typedValue, true);
                    this.f2972n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, contextThemeWrapper.getResources().getDisplayMetrics()));
                    this.f2973o.setHeight(-2);
                    this.f2974p = new Runnable() { // from class: android.support.v7.app.AppCompatDelegateImplV9.5
                        @Override // java.lang.Runnable
                        public void run() {
                            AppCompatDelegateImplV9.this.f2973o.showAtLocation(AppCompatDelegateImplV9.this.f2972n, 55, 0, 0);
                            AppCompatDelegateImplV9.this.m3321u();
                            if (AppCompatDelegateImplV9.this.m3320t()) {
                                AppCompatDelegateImplV9.this.f2972n.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
                                AppCompatDelegateImplV9.this.f2975q = ViewCompat.m2608l(AppCompatDelegateImplV9.this.f2972n).m2753a(1.0f);
                                AppCompatDelegateImplV9.this.f2975q.m2755a(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.AppCompatDelegateImplV9.5.1
                                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                                    /* JADX INFO: renamed from: a */
                                    public void mo2762a(View view) {
                                        AppCompatDelegateImplV9.this.f2972n.setVisibility(0);
                                    }

                                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                                    /* JADX INFO: renamed from: b */
                                    public void mo2763b(View view) {
                                        AppCompatDelegateImplV9.this.f2972n.setAlpha(1.0f);
                                        AppCompatDelegateImplV9.this.f2975q.m2755a((ViewPropertyAnimatorListener) null);
                                        AppCompatDelegateImplV9.this.f2975q = null;
                                    }
                                });
                                return;
                            }
                            AppCompatDelegateImplV9.this.f2972n.setAlpha(1.0f);
                            AppCompatDelegateImplV9.this.f2972n.setVisibility(0);
                        }
                    };
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f2982y.findViewById(android.support.v7.appcompat.R.id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m3275o()));
                        this.f2972n = (ActionBarContextView) viewStubCompat.m5028a();
                    }
                }
            }
            if (this.f2972n != null) {
                m3321u();
                this.f2972n.m3697c();
                StandaloneActionMode standaloneActionMode = new StandaloneActionMode(this.f2972n.getContext(), this.f2972n, callback, this.f2973o == null);
                if (callback.mo3330a(standaloneActionMode, standaloneActionMode.mo3406b())) {
                    standaloneActionMode.mo3410d();
                    this.f2972n.m3695a(standaloneActionMode);
                    this.f2971m = standaloneActionMode;
                    if (m3320t()) {
                        this.f2972n.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
                        this.f2975q = ViewCompat.m2608l(this.f2972n).m2753a(1.0f);
                        this.f2975q.m2755a(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.AppCompatDelegateImplV9.6
                            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                            /* JADX INFO: renamed from: a */
                            public void mo2762a(View view) {
                                AppCompatDelegateImplV9.this.f2972n.setVisibility(0);
                                AppCompatDelegateImplV9.this.f2972n.sendAccessibilityEvent(32);
                                if (AppCompatDelegateImplV9.this.f2972n.getParent() instanceof View) {
                                    ViewCompat.m2613q((View) AppCompatDelegateImplV9.this.f2972n.getParent());
                                }
                            }

                            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                            /* JADX INFO: renamed from: b */
                            public void mo2763b(View view) {
                                AppCompatDelegateImplV9.this.f2972n.setAlpha(1.0f);
                                AppCompatDelegateImplV9.this.f2975q.m2755a((ViewPropertyAnimatorListener) null);
                                AppCompatDelegateImplV9.this.f2975q = null;
                            }
                        });
                    } else {
                        this.f2972n.setAlpha(1.0f);
                        this.f2972n.setVisibility(0);
                        this.f2972n.sendAccessibilityEvent(32);
                        if (this.f2972n.getParent() instanceof View) {
                            ViewCompat.m2613q((View) this.f2972n.getParent());
                        }
                    }
                    if (this.f2973o != null) {
                        this.f2927b.getDecorView().post(this.f2974p);
                    }
                } else {
                    this.f2971m = null;
                }
            }
        }
        if (this.f2971m != null && this.f2930e != null) {
            this.f2930e.onSupportActionModeStarted(this.f2971m);
        }
        return this.f2971m;
    }

    /* JADX INFO: renamed from: t */
    final boolean m3320t() {
        return this.f2981x && this.f2982y != null && ViewCompat.m2621y(this.f2982y);
    }

    /* JADX INFO: renamed from: u */
    void m3321u() {
        if (this.f2975q != null) {
            this.f2975q.m2760b();
        }
    }

    /* JADX INFO: renamed from: v */
    boolean m3322v() {
        if (this.f2971m != null) {
            this.f2971m.mo3409c();
            return true;
        }
        ActionBar actionBarA = mo3243a();
        return actionBarA != null && actionBarA.collapseActionView();
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    /* JADX INFO: renamed from: a */
    boolean mo3268a(int i, KeyEvent keyEvent) {
        ActionBar actionBarA = mo3243a();
        if (actionBarA != null && actionBarA.onKeyShortcut(i, keyEvent)) {
            return true;
        }
        if (this.f2964F != null && m3296a(this.f2964F, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f2964F == null) {
                return true;
            }
            this.f2964F.f3009n = true;
            return true;
        }
        if (this.f2964F == null) {
            PanelFeatureState panelFeatureStateM3308a = m3308a(0, true);
            m3299b(panelFeatureStateM3308a, keyEvent);
            boolean zM3296a = m3296a(panelFeatureStateM3308a, keyEvent.getKeyCode(), keyEvent, 1);
            panelFeatureStateM3308a.f3008m = false;
            if (zM3296a) {
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    /* JADX INFO: renamed from: a */
    boolean mo3269a(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && this.f2928c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? m3316c(keyCode, keyEvent) : m3315b(keyCode, keyEvent);
    }

    /* JADX INFO: renamed from: b */
    boolean m3315b(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                boolean z = this.f2965G;
                this.f2965G = false;
                PanelFeatureState panelFeatureStateM3308a = m3308a(0, false);
                if (panelFeatureStateM3308a != null && panelFeatureStateM3308a.f3010o) {
                    if (z) {
                        return true;
                    }
                    m3311a(panelFeatureStateM3308a, true);
                    return true;
                }
                if (m3322v()) {
                    return true;
                }
                break;
            case 82:
                m3303e(0, keyEvent);
                return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    boolean m3316c(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                this.f2965G = (keyEvent.getFlags() & 128) != 0;
                break;
            case 82:
                m3302d(0, keyEvent);
                return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: b */
    public View m3313b(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean zM3297a;
        if (this.f2970L == null) {
            String string = this.f2926a.obtainStyledAttributes(android.support.v7.appcompat.R.styleable.AppCompatTheme).getString(android.support.v7.appcompat.R.styleable.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                this.f2970L = new AppCompatViewInflater();
            } else {
                try {
                    this.f2970L = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f2970L = new AppCompatViewInflater();
                }
            }
        }
        if (f2958t) {
            if (attributeSet instanceof XmlPullParser) {
                zM3297a = ((XmlPullParser) attributeSet).getDepth() > 1;
            } else {
                zM3297a = m3297a((ViewParent) view);
            }
            z = zM3297a;
        } else {
            z = false;
        }
        return this.f2970L.m3352a(view, str, context, attributeSet, z, f2958t, true, VectorEnabledTintResources.m4999a());
    }

    /* JADX INFO: renamed from: a */
    private boolean m3297a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f2927b.getDecorView();
        for (ViewParent parent = viewParent; parent != null; parent = parent.getParent()) {
            if (parent == decorView || !(parent instanceof View) || ViewCompat.m2570B((View) parent)) {
                return false;
            }
        }
        return true;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: i */
    public void mo3264i() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f2926a);
        if (layoutInflaterFrom.getFactory() == null) {
            LayoutInflaterCompat.m2511b(layoutInflaterFrom, this);
        } else if (!(layoutInflaterFrom.getFactory2() instanceof AppCompatDelegateImplV9)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewMo3285a = mo3285a(view, str, context, attributeSet);
        return viewMo3285a != null ? viewMo3285a : m3313b(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    View mo3285a(View view, String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView;
        if (!(this.f2928c instanceof LayoutInflater.Factory) || (viewOnCreateView = ((LayoutInflater.Factory) this.f2928c).onCreateView(str, context, attributeSet)) == null) {
            return null;
        }
        return viewOnCreateView;
    }

    /* JADX INFO: renamed from: a */
    private void m3293a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        ViewGroup.LayoutParams layoutParams;
        int i = -1;
        if (!panelFeatureState.f3010o && !m3277q()) {
            if (panelFeatureState.f2996a == 0) {
                if ((this.f2926a.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback callbackR = m3278r();
            if (callbackR != null && !callbackR.onMenuOpened(panelFeatureState.f2996a, panelFeatureState.f3005j)) {
                m3311a(panelFeatureState, true);
                return;
            }
            WindowManager windowManager = (WindowManager) this.f2926a.getSystemService("window");
            if (windowManager != null && m3299b(panelFeatureState, keyEvent)) {
                if (panelFeatureState.f3002g == null || panelFeatureState.f3012q) {
                    if (panelFeatureState.f3002g == null) {
                        if (!m3295a(panelFeatureState) || panelFeatureState.f3002g == null) {
                            return;
                        }
                    } else if (panelFeatureState.f3012q && panelFeatureState.f3002g.getChildCount() > 0) {
                        panelFeatureState.f3002g.removeAllViews();
                    }
                    if (m3300c(panelFeatureState) && panelFeatureState.m3337a()) {
                        ViewGroup.LayoutParams layoutParams2 = panelFeatureState.f3003h.getLayoutParams();
                        ViewGroup.LayoutParams layoutParams3 = layoutParams2 == null ? new ViewGroup.LayoutParams(-2, -2) : layoutParams2;
                        panelFeatureState.f3002g.setBackgroundResource(panelFeatureState.f2997b);
                        ViewParent parent = panelFeatureState.f3003h.getParent();
                        if (parent != null && (parent instanceof ViewGroup)) {
                            ((ViewGroup) parent).removeView(panelFeatureState.f3003h);
                        }
                        panelFeatureState.f3002g.addView(panelFeatureState.f3003h, layoutParams3);
                        if (!panelFeatureState.f3003h.hasFocus()) {
                            panelFeatureState.f3003h.requestFocus();
                        }
                        i = -2;
                    } else {
                        return;
                    }
                } else if (panelFeatureState.f3004i == null || (layoutParams = panelFeatureState.f3004i.getLayoutParams()) == null || layoutParams.width != -1) {
                    i = -2;
                }
                panelFeatureState.f3009n = false;
                WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i, -2, panelFeatureState.f2999d, panelFeatureState.f3000e, 1002, 8519680, -3);
                layoutParams4.gravity = panelFeatureState.f2998c;
                layoutParams4.windowAnimations = panelFeatureState.f3001f;
                windowManager.addView(panelFeatureState.f3002g, layoutParams4);
                panelFeatureState.f3010o = true;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3295a(PanelFeatureState panelFeatureState) {
        panelFeatureState.m3335a(m3275o());
        panelFeatureState.f3002g = new ListMenuDecorView(panelFeatureState.f3007l);
        panelFeatureState.f2998c = 81;
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m3294a(MenuBuilder menuBuilder, boolean z) {
        if (this.f2978u != null && this.f2978u.mo3715f() && (!ViewConfiguration.get(this.f2926a).hasPermanentMenuKey() || this.f2978u.mo3717h())) {
            Window.Callback callbackR = m3278r();
            if (!this.f2978u.mo3716g() || !z) {
                if (callbackR != null && !m3277q()) {
                    if (this.f2976r && (this.f2977s & 1) != 0) {
                        this.f2927b.getDecorView().removeCallbacks(this.f2966H);
                        this.f2966H.run();
                    }
                    PanelFeatureState panelFeatureStateM3308a = m3308a(0, true);
                    if (panelFeatureStateM3308a.f3005j != null && !panelFeatureStateM3308a.f3013r && callbackR.onPreparePanel(0, panelFeatureStateM3308a.f3004i, panelFeatureStateM3308a.f3005j)) {
                        callbackR.onMenuOpened(108, panelFeatureStateM3308a.f3005j);
                        this.f2978u.mo3718i();
                        return;
                    }
                    return;
                }
                return;
            }
            this.f2978u.mo3719j();
            if (!m3277q()) {
                callbackR.onPanelClosed(108, m3308a(0, true).f3005j);
                return;
            }
            return;
        }
        PanelFeatureState panelFeatureStateM3308a2 = m3308a(0, true);
        panelFeatureStateM3308a2.f3012q = true;
        m3311a(panelFeatureStateM3308a2, false);
        m3293a(panelFeatureStateM3308a2, (KeyEvent) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m3298b(android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState r7) {
        /*
            r6 = this;
            r5 = 1
            android.content.Context r1 = r6.f2926a
            int r0 = r7.f2996a
            if (r0 == 0) goto Ld
            int r0 = r7.f2996a
            r2 = 108(0x6c, float:1.51E-43)
            if (r0 != r2) goto L71
        Ld:
            android.support.v7.widget.DecorContentParent r0 = r6.f2978u
            if (r0 == 0) goto L71
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            android.content.res.Resources$Theme r3 = r1.getTheme()
            int r0 = android.support.v7.appcompat.R.attr.actionBarTheme
            r3.resolveAttribute(r0, r2, r5)
            r0 = 0
            int r4 = r2.resourceId
            if (r4 == 0) goto L6b
            android.content.res.Resources r0 = r1.getResources()
            android.content.res.Resources$Theme r0 = r0.newTheme()
            r0.setTo(r3)
            int r4 = r2.resourceId
            r0.applyStyle(r4, r5)
            int r4 = android.support.v7.appcompat.R.attr.actionBarWidgetTheme
            r0.resolveAttribute(r4, r2, r5)
        L39:
            int r4 = r2.resourceId
            if (r4 == 0) goto L4f
            if (r0 != 0) goto L4a
            android.content.res.Resources r0 = r1.getResources()
            android.content.res.Resources$Theme r0 = r0.newTheme()
            r0.setTo(r3)
        L4a:
            int r2 = r2.resourceId
            r0.applyStyle(r2, r5)
        L4f:
            r2 = r0
            if (r2 == 0) goto L71
            android.support.v7.view.ContextThemeWrapper r0 = new android.support.v7.view.ContextThemeWrapper
            r3 = 0
            r0.<init>(r1, r3)
            android.content.res.Resources$Theme r1 = r0.getTheme()
            r1.setTo(r2)
        L5f:
            android.support.v7.view.menu.MenuBuilder r1 = new android.support.v7.view.menu.MenuBuilder
            r1.<init>(r0)
            r1.mo3587a(r6)
            r7.m3336a(r1)
            return r5
        L6b:
            int r4 = android.support.v7.appcompat.R.attr.actionBarWidgetTheme
            r3.resolveAttribute(r4, r2, r5)
            goto L39
        L71:
            r0 = r1
            goto L5f
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV9.m3298b(android.support.v7.app.AppCompatDelegateImplV9$PanelFeatureState):boolean");
    }

    /* JADX INFO: renamed from: c */
    private boolean m3300c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.f3004i != null) {
            panelFeatureState.f3003h = panelFeatureState.f3004i;
            return true;
        }
        if (panelFeatureState.f3005j == null) {
            return false;
        }
        if (this.f2980w == null) {
            this.f2980w = new PanelMenuPresenterCallback();
        }
        panelFeatureState.f3003h = (View) panelFeatureState.m3334a(this.f2980w);
        return panelFeatureState.f3003h != null;
    }

    /* JADX INFO: renamed from: b */
    private boolean m3299b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (m3277q()) {
            return false;
        }
        if (panelFeatureState.f3008m) {
            return true;
        }
        if (this.f2964F != null && this.f2964F != panelFeatureState) {
            m3311a(this.f2964F, false);
        }
        Window.Callback callbackR = m3278r();
        if (callbackR != null) {
            panelFeatureState.f3004i = callbackR.onCreatePanelView(panelFeatureState.f2996a);
        }
        boolean z = panelFeatureState.f2996a == 0 || panelFeatureState.f2996a == 108;
        if (z && this.f2978u != null) {
            this.f2978u.mo3720k();
        }
        if (panelFeatureState.f3004i == null && (!z || !(m3274n() instanceof ToolbarActionBar))) {
            if (panelFeatureState.f3005j == null || panelFeatureState.f3013r) {
                if (panelFeatureState.f3005j == null && (!m3298b(panelFeatureState) || panelFeatureState.f3005j == null)) {
                    return false;
                }
                if (z && this.f2978u != null) {
                    if (this.f2979v == null) {
                        this.f2979v = new ActionMenuPresenterCallback();
                    }
                    this.f2978u.mo3709a(panelFeatureState.f3005j, this.f2979v);
                }
                panelFeatureState.f3005j.m3614g();
                if (!callbackR.onCreatePanelMenu(panelFeatureState.f2996a, panelFeatureState.f3005j)) {
                    panelFeatureState.m3336a((MenuBuilder) null);
                    if (!z || this.f2978u == null) {
                        return false;
                    }
                    this.f2978u.mo3709a(null, this.f2979v);
                    return false;
                }
                panelFeatureState.f3013r = false;
            }
            panelFeatureState.f3005j.m3614g();
            if (panelFeatureState.f3014s != null) {
                panelFeatureState.f3005j.m3609d(panelFeatureState.f3014s);
                panelFeatureState.f3014s = null;
            }
            if (!callbackR.onPreparePanel(0, panelFeatureState.f3004i, panelFeatureState.f3005j)) {
                if (z && this.f2978u != null) {
                    this.f2978u.mo3709a(null, this.f2979v);
                }
                panelFeatureState.f3005j.m3615h();
                return false;
            }
            panelFeatureState.f3011p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.f3005j.setQwertyMode(panelFeatureState.f3011p);
            panelFeatureState.f3005j.m3615h();
        }
        panelFeatureState.f3008m = true;
        panelFeatureState.f3009n = false;
        this.f2964F = panelFeatureState;
        return true;
    }

    /* JADX INFO: renamed from: b */
    void m3314b(MenuBuilder menuBuilder) {
        if (!this.f2962D) {
            this.f2962D = true;
            this.f2978u.mo3721l();
            Window.Callback callbackR = m3278r();
            if (callbackR != null && !m3277q()) {
                callbackR.onPanelClosed(108, menuBuilder);
            }
            this.f2962D = false;
        }
    }

    /* JADX INFO: renamed from: e */
    void m3317e(int i) {
        m3311a(m3308a(i, true), true);
    }

    /* JADX INFO: renamed from: a */
    void m3311a(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.f2996a == 0 && this.f2978u != null && this.f2978u.mo3716g()) {
            m3314b(panelFeatureState.f3005j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f2926a.getSystemService("window");
        if (windowManager != null && panelFeatureState.f3010o && panelFeatureState.f3002g != null) {
            windowManager.removeView(panelFeatureState.f3002g);
            if (z) {
                m3310a(panelFeatureState.f2996a, panelFeatureState, (Menu) null);
            }
        }
        panelFeatureState.f3008m = false;
        panelFeatureState.f3009n = false;
        panelFeatureState.f3010o = false;
        panelFeatureState.f3003h = null;
        panelFeatureState.f3012q = true;
        if (this.f2964F == panelFeatureState) {
            this.f2964F = null;
        }
    }

    /* JADX INFO: renamed from: d */
    private boolean m3302d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            PanelFeatureState panelFeatureStateM3308a = m3308a(i, true);
            if (!panelFeatureStateM3308a.f3010o) {
                return m3299b(panelFeatureStateM3308a, keyEvent);
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0085  */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m3303e(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            r2 = 1
            r1 = 0
            android.support.v7.view.ActionMode r0 = r4.f2971m
            if (r0 == 0) goto L8
            r0 = r1
        L7:
            return r0
        L8:
            android.support.v7.app.AppCompatDelegateImplV9$PanelFeatureState r3 = r4.m3308a(r5, r2)
            if (r5 != 0) goto L5a
            android.support.v7.widget.DecorContentParent r0 = r4.f2978u
            if (r0 == 0) goto L5a
            android.support.v7.widget.DecorContentParent r0 = r4.f2978u
            boolean r0 = r0.mo3715f()
            if (r0 == 0) goto L5a
            android.content.Context r0 = r4.f2926a
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            boolean r0 = r0.hasPermanentMenuKey()
            if (r0 != 0) goto L5a
            android.support.v7.widget.DecorContentParent r0 = r4.f2978u
            boolean r0 = r0.mo3716g()
            if (r0 != 0) goto L53
            boolean r0 = r4.m3277q()
            if (r0 != 0) goto L85
            boolean r0 = r4.m3299b(r3, r6)
            if (r0 == 0) goto L85
            android.support.v7.widget.DecorContentParent r0 = r4.f2978u
            boolean r2 = r0.mo3718i()
        L40:
            if (r2 == 0) goto L51
            android.content.Context r0 = r4.f2926a
            java.lang.String r3 = "audio"
            java.lang.Object r0 = r0.getSystemService(r3)
            android.media.AudioManager r0 = (android.media.AudioManager) r0
            if (r0 == 0) goto L7d
            r0.playSoundEffect(r1)
        L51:
            r0 = r2
            goto L7
        L53:
            android.support.v7.widget.DecorContentParent r0 = r4.f2978u
            boolean r2 = r0.mo3719j()
            goto L40
        L5a:
            boolean r0 = r3.f3010o
            if (r0 != 0) goto L62
            boolean r0 = r3.f3009n
            if (r0 == 0) goto L69
        L62:
            boolean r0 = r3.f3010o
            r4.m3311a(r3, r2)
            r2 = r0
            goto L40
        L69:
            boolean r0 = r3.f3008m
            if (r0 == 0) goto L85
            boolean r0 = r3.f3013r
            if (r0 == 0) goto L87
            r3.f3008m = r1
            boolean r0 = r4.m3299b(r3, r6)
        L77:
            if (r0 == 0) goto L85
            r4.m3293a(r3, r6)
            goto L40
        L7d:
            java.lang.String r0 = "AppCompatDelegate"
            java.lang.String r1 = "Couldn't get audio manager"
            android.util.Log.w(r0, r1)
            goto L51
        L85:
            r2 = r1
            goto L40
        L87:
            r0 = r2
            goto L77
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV9.m3303e(int, android.view.KeyEvent):boolean");
    }

    /* JADX INFO: renamed from: a */
    void m3310a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.f2963E.length) {
                panelFeatureState = this.f2963E[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f3005j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f3010o) && !m3277q()) {
            this.f2928c.onPanelClosed(i, menu);
        }
    }

    /* JADX INFO: renamed from: a */
    PanelFeatureState m3309a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.f2963E;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.f3005j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    protected PanelFeatureState m3308a(int i, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.f2963E;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.f2963E = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i);
        panelFeatureStateArr[i] = panelFeatureState2;
        return panelFeatureState2;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3296a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        boolean zPerformShortcut = false;
        if (!keyEvent.isSystem()) {
            if ((panelFeatureState.f3008m || m3299b(panelFeatureState, keyEvent)) && panelFeatureState.f3005j != null) {
                zPerformShortcut = panelFeatureState.f3005j.performShortcut(i, keyEvent, i2);
            }
            if (zPerformShortcut && (i2 & 1) == 0 && this.f2978u == null) {
                m3311a(panelFeatureState, true);
            }
        }
        return zPerformShortcut;
    }

    /* JADX INFO: renamed from: d */
    private void m3301d(int i) {
        this.f2977s |= 1 << i;
        if (!this.f2976r) {
            ViewCompat.m2586a(this.f2927b.getDecorView(), this.f2966H);
            this.f2976r = true;
        }
    }

    /* JADX INFO: renamed from: f */
    void m3318f(int i) {
        PanelFeatureState panelFeatureStateM3308a;
        PanelFeatureState panelFeatureStateM3308a2 = m3308a(i, true);
        if (panelFeatureStateM3308a2.f3005j != null) {
            Bundle bundle = new Bundle();
            panelFeatureStateM3308a2.f3005j.m3603c(bundle);
            if (bundle.size() > 0) {
                panelFeatureStateM3308a2.f3014s = bundle;
            }
            panelFeatureStateM3308a2.f3005j.m3614g();
            panelFeatureStateM3308a2.f3005j.clear();
        }
        panelFeatureStateM3308a2.f3013r = true;
        panelFeatureStateM3308a2.f3012q = true;
        if ((i == 108 || i == 0) && this.f2978u != null && (panelFeatureStateM3308a = m3308a(0, false)) != null) {
            panelFeatureStateM3308a.f3008m = false;
            m3299b(panelFeatureStateM3308a, (KeyEvent) null);
        }
    }

    /* JADX INFO: renamed from: g */
    int m3319g(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.f2972n == null || !(this.f2972n.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2972n.getLayoutParams();
            if (this.f2972n.isShown()) {
                if (this.f2968J == null) {
                    this.f2968J = new Rect();
                    this.f2969K = new Rect();
                }
                Rect rect = this.f2968J;
                Rect rect2 = this.f2969K;
                rect.set(0, i, 0, 0);
                ViewUtils.m5030a(this.f2982y, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f2959A == null) {
                        this.f2959A = new View(this.f2926a);
                        this.f2959A.setBackgroundColor(this.f2926a.getResources().getColor(android.support.v7.appcompat.R.color.abc_input_method_navigation_guard));
                        this.f2982y.addView(this.f2959A, -1, new ViewGroup.LayoutParams(-1, i));
                        z3 = true;
                    } else {
                        ViewGroup.LayoutParams layoutParams = this.f2959A.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f2959A.setLayoutParams(layoutParams);
                        }
                        z3 = true;
                    }
                } else {
                    z3 = false;
                }
                z = this.f2959A != null;
                if (!this.f2935j && z) {
                    i = 0;
                }
                boolean z4 = z3;
                z2 = z;
                z = z4;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = false;
            } else {
                z = false;
                z2 = false;
            }
            if (z) {
                this.f2972n.setLayoutParams(marginLayoutParams);
            }
            z = z2;
        }
        if (this.f2959A != null) {
            this.f2959A.setVisibility(z ? 0 : 8);
        }
        return i;
    }

    /* JADX INFO: renamed from: A */
    private void m3292A() {
        if (this.f2981x) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* JADX INFO: renamed from: h */
    private int m3304h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
        return i;
    }

    /* JADX INFO: renamed from: w */
    void m3323w() {
        if (this.f2978u != null) {
            this.f2978u.mo3721l();
        }
        if (this.f2973o != null) {
            this.f2927b.getDecorView().removeCallbacks(this.f2974p);
            if (this.f2973o.isShowing()) {
                try {
                    this.f2973o.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.f2973o = null;
        }
        m3321u();
        PanelFeatureState panelFeatureStateM3308a = m3308a(0, false);
        if (panelFeatureStateM3308a != null && panelFeatureStateM3308a.f3005j != null) {
            panelFeatureStateM3308a.f3005j.close();
        }
    }

    class ActionModeCallbackWrapperV9 implements ActionMode.Callback {

        /* JADX INFO: renamed from: b */
        private ActionMode.Callback f2993b;

        public ActionModeCallbackWrapperV9(ActionMode.Callback callback) {
            this.f2993b = callback;
        }

        @Override // android.support.v7.view.ActionMode.Callback
        /* JADX INFO: renamed from: a */
        public boolean mo3330a(ActionMode actionMode, Menu menu) {
            return this.f2993b.mo3330a(actionMode, menu);
        }

        @Override // android.support.v7.view.ActionMode.Callback
        /* JADX INFO: renamed from: b */
        public boolean mo3332b(ActionMode actionMode, Menu menu) {
            return this.f2993b.mo3332b(actionMode, menu);
        }

        @Override // android.support.v7.view.ActionMode.Callback
        /* JADX INFO: renamed from: a */
        public boolean mo3331a(ActionMode actionMode, MenuItem menuItem) {
            return this.f2993b.mo3331a(actionMode, menuItem);
        }

        @Override // android.support.v7.view.ActionMode.Callback
        /* JADX INFO: renamed from: a */
        public void mo3329a(ActionMode actionMode) {
            this.f2993b.mo3329a(actionMode);
            if (AppCompatDelegateImplV9.this.f2973o != null) {
                AppCompatDelegateImplV9.this.f2927b.getDecorView().removeCallbacks(AppCompatDelegateImplV9.this.f2974p);
            }
            if (AppCompatDelegateImplV9.this.f2972n != null) {
                AppCompatDelegateImplV9.this.m3321u();
                AppCompatDelegateImplV9.this.f2975q = ViewCompat.m2608l(AppCompatDelegateImplV9.this.f2972n).m2753a(CropImageView.DEFAULT_ASPECT_RATIO);
                AppCompatDelegateImplV9.this.f2975q.m2755a(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.AppCompatDelegateImplV9.ActionModeCallbackWrapperV9.1
                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                    /* JADX INFO: renamed from: b */
                    public void mo2763b(View view) {
                        AppCompatDelegateImplV9.this.f2972n.setVisibility(8);
                        if (AppCompatDelegateImplV9.this.f2973o != null) {
                            AppCompatDelegateImplV9.this.f2973o.dismiss();
                        } else if (AppCompatDelegateImplV9.this.f2972n.getParent() instanceof View) {
                            ViewCompat.m2613q((View) AppCompatDelegateImplV9.this.f2972n.getParent());
                        }
                        AppCompatDelegateImplV9.this.f2972n.removeAllViews();
                        AppCompatDelegateImplV9.this.f2975q.m2755a((ViewPropertyAnimatorListener) null);
                        AppCompatDelegateImplV9.this.f2975q = null;
                    }
                });
            }
            if (AppCompatDelegateImplV9.this.f2930e != null) {
                AppCompatDelegateImplV9.this.f2930e.onSupportActionModeFinished(AppCompatDelegateImplV9.this.f2971m);
            }
            AppCompatDelegateImplV9.this.f2971m = null;
        }
    }

    private final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        PanelMenuPresenterCallback() {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        /* JADX INFO: renamed from: a */
        public void mo3327a(MenuBuilder menuBuilder, boolean z) {
            MenuBuilder menuBuilderMo3623p = menuBuilder.mo3623p();
            boolean z2 = menuBuilderMo3623p != menuBuilder;
            AppCompatDelegateImplV9 appCompatDelegateImplV9 = AppCompatDelegateImplV9.this;
            if (z2) {
                menuBuilder = menuBuilderMo3623p;
            }
            PanelFeatureState panelFeatureStateM3309a = appCompatDelegateImplV9.m3309a((Menu) menuBuilder);
            if (panelFeatureStateM3309a != null) {
                if (z2) {
                    AppCompatDelegateImplV9.this.m3310a(panelFeatureStateM3309a.f2996a, panelFeatureStateM3309a, menuBuilderMo3623p);
                    AppCompatDelegateImplV9.this.m3311a(panelFeatureStateM3309a, true);
                } else {
                    AppCompatDelegateImplV9.this.m3311a(panelFeatureStateM3309a, z);
                }
            }
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        /* JADX INFO: renamed from: a */
        public boolean mo3328a(MenuBuilder menuBuilder) {
            Window.Callback callbackR;
            if (menuBuilder == null && AppCompatDelegateImplV9.this.f2933h && (callbackR = AppCompatDelegateImplV9.this.m3278r()) != null && !AppCompatDelegateImplV9.this.m3277q()) {
                callbackR.onMenuOpened(108, menuBuilder);
                return true;
            }
            return true;
        }
    }

    private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        /* JADX INFO: renamed from: a */
        public boolean mo3328a(MenuBuilder menuBuilder) {
            Window.Callback callbackR = AppCompatDelegateImplV9.this.m3278r();
            if (callbackR != null) {
                callbackR.onMenuOpened(108, menuBuilder);
                return true;
            }
            return true;
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        /* JADX INFO: renamed from: a */
        public void mo3327a(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImplV9.this.m3314b(menuBuilder);
        }
    }

    protected static final class PanelFeatureState {

        /* JADX INFO: renamed from: a */
        int f2996a;

        /* JADX INFO: renamed from: b */
        int f2997b;

        /* JADX INFO: renamed from: c */
        int f2998c;

        /* JADX INFO: renamed from: d */
        int f2999d;

        /* JADX INFO: renamed from: e */
        int f3000e;

        /* JADX INFO: renamed from: f */
        int f3001f;

        /* JADX INFO: renamed from: g */
        ViewGroup f3002g;

        /* JADX INFO: renamed from: h */
        View f3003h;

        /* JADX INFO: renamed from: i */
        View f3004i;

        /* JADX INFO: renamed from: j */
        MenuBuilder f3005j;

        /* JADX INFO: renamed from: k */
        ListMenuPresenter f3006k;

        /* JADX INFO: renamed from: l */
        Context f3007l;

        /* JADX INFO: renamed from: m */
        boolean f3008m;

        /* JADX INFO: renamed from: n */
        boolean f3009n;

        /* JADX INFO: renamed from: o */
        boolean f3010o;

        /* JADX INFO: renamed from: p */
        public boolean f3011p;

        /* JADX INFO: renamed from: q */
        boolean f3012q = false;

        /* JADX INFO: renamed from: r */
        boolean f3013r;

        /* JADX INFO: renamed from: s */
        Bundle f3014s;

        PanelFeatureState(int i) {
            this.f2996a = i;
        }

        /* JADX INFO: renamed from: a */
        public boolean m3337a() {
            if (this.f3003h == null) {
                return false;
            }
            return this.f3004i != null || this.f3006k.m3562d().getCount() > 0;
        }

        /* JADX INFO: renamed from: a */
        void m3335a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            themeNewTheme.resolveAttribute(android.support.v7.appcompat.R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            } else {
                themeNewTheme.applyStyle(android.support.v7.appcompat.R.style.Theme_AppCompat_CompactMenu, true);
            }
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(themeNewTheme);
            this.f3007l = contextThemeWrapper;
            TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(android.support.v7.appcompat.R.styleable.AppCompatTheme);
            this.f2997b = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AppCompatTheme_panelBackground, 0);
            this.f3001f = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        /* JADX INFO: renamed from: a */
        void m3336a(MenuBuilder menuBuilder) {
            if (menuBuilder != this.f3005j) {
                if (this.f3005j != null) {
                    this.f3005j.m3599b(this.f3006k);
                }
                this.f3005j = menuBuilder;
                if (menuBuilder == null || this.f3006k == null) {
                    return;
                }
                menuBuilder.m3589a(this.f3006k);
            }
        }

        /* JADX INFO: renamed from: a */
        MenuView m3334a(MenuPresenter.Callback callback) {
            if (this.f3005j == null) {
                return null;
            }
            if (this.f3006k == null) {
                this.f3006k = new ListMenuPresenter(this.f3007l, android.support.v7.appcompat.R.layout.abc_list_menu_item_layout);
                this.f3006k.mo350a(callback);
                this.f3005j.m3589a(this.f3006k);
            }
            return this.f3006k.m3559a(this.f3002g);
        }

        private static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState.SavedState.1
                @Override // android.os.Parcelable.ClassLoaderCreator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.m3338a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.m3338a(parcel, null);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };

            /* JADX INFO: renamed from: a */
            int f3015a;

            /* JADX INFO: renamed from: b */
            boolean f3016b;

            /* JADX INFO: renamed from: c */
            Bundle f3017c;

            SavedState() {
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f3015a);
                parcel.writeInt(this.f3016b ? 1 : 0);
                if (this.f3016b) {
                    parcel.writeBundle(this.f3017c);
                }
            }

            /* JADX INFO: renamed from: a */
            static SavedState m3338a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f3015a = parcel.readInt();
                savedState.f3016b = parcel.readInt() == 1;
                if (savedState.f3016b) {
                    savedState.f3017c = parcel.readBundle(classLoader);
                }
                return savedState;
            }
        }
    }

    private class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImplV9.this.mo3269a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !m3333a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImplV9.this.m3317e(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(AppCompatResources.m3426b(getContext(), i));
        }

        /* JADX INFO: renamed from: a */
        private boolean m3333a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }
    }
}
