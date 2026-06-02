package android.support.v7.app;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.view.ActionMode;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import java.lang.Thread;

/* JADX INFO: loaded from: classes.dex */
abstract class AppCompatDelegateImplBase extends AppCompatDelegate {

    /* JADX INFO: renamed from: m */
    private static boolean f2923m;

    /* JADX INFO: renamed from: n */
    private static final boolean f2924n;

    /* JADX INFO: renamed from: o */
    private static final int[] f2925o;

    /* JADX INFO: renamed from: a */
    final Context f2926a;

    /* JADX INFO: renamed from: b */
    final Window f2927b;

    /* JADX INFO: renamed from: c */
    final Window.Callback f2928c;

    /* JADX INFO: renamed from: d */
    final Window.Callback f2929d;

    /* JADX INFO: renamed from: e */
    final AppCompatCallback f2930e;

    /* JADX INFO: renamed from: f */
    ActionBar f2931f;

    /* JADX INFO: renamed from: g */
    MenuInflater f2932g;

    /* JADX INFO: renamed from: h */
    boolean f2933h;

    /* JADX INFO: renamed from: i */
    boolean f2934i;

    /* JADX INFO: renamed from: j */
    boolean f2935j;

    /* JADX INFO: renamed from: k */
    boolean f2936k;

    /* JADX INFO: renamed from: l */
    boolean f2937l;

    /* JADX INFO: renamed from: p */
    private CharSequence f2938p;

    /* JADX INFO: renamed from: q */
    private boolean f2939q;

    /* JADX INFO: renamed from: r */
    private boolean f2940r;

    /* JADX INFO: renamed from: a */
    abstract void mo3267a(int i, Menu menu);

    /* JADX INFO: renamed from: a */
    abstract boolean mo3268a(int i, KeyEvent keyEvent);

    /* JADX INFO: renamed from: a */
    abstract boolean mo3269a(KeyEvent keyEvent);

    /* JADX INFO: renamed from: b */
    abstract ActionMode mo3270b(ActionMode.Callback callback);

    /* JADX INFO: renamed from: b */
    abstract void mo3271b(CharSequence charSequence);

    /* JADX INFO: renamed from: b */
    abstract boolean mo3272b(int i, Menu menu);

    /* JADX INFO: renamed from: m */
    abstract void mo3273m();

    static {
        f2924n = Build.VERSION.SDK_INT < 21;
        if (f2924n && !f2923m) {
            final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: android.support.v7.app.AppCompatDelegateImplBase.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    if (m3280a(th)) {
                        Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }

                /* JADX INFO: renamed from: a */
                private boolean m3280a(Throwable th) {
                    String message;
                    if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                        return false;
                    }
                    return message.contains("drawable") || message.contains("Drawable");
                }
            });
            f2923m = true;
        }
        f2925o = new int[]{R.attr.windowBackground};
    }

    AppCompatDelegateImplBase(Context context, Window window, AppCompatCallback appCompatCallback) {
        this.f2926a = context;
        this.f2927b = window;
        this.f2930e = appCompatCallback;
        this.f2928c = this.f2927b.getCallback();
        if (this.f2928c instanceof AppCompatWindowCallbackBase) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f2929d = mo3266a(this.f2928c);
        this.f2927b.setCallback(this.f2929d);
        TintTypedArray tintTypedArrayM4954a = TintTypedArray.m4954a(context, (AttributeSet) null, f2925o);
        Drawable drawableM4963b = tintTypedArrayM4954a.m4963b(0);
        if (drawableM4963b != null) {
            this.f2927b.setBackgroundDrawable(drawableM4963b);
        }
        tintTypedArrayM4954a.m4960a();
    }

    /* JADX INFO: renamed from: a */
    Window.Callback mo3266a(Window.Callback callback) {
        return new AppCompatWindowCallbackBase(callback);
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: a */
    public ActionBar mo3243a() {
        mo3273m();
        return this.f2931f;
    }

    /* JADX INFO: renamed from: n */
    final ActionBar m3274n() {
        return this.f2931f;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: b */
    public MenuInflater mo3252b() {
        if (this.f2932g == null) {
            mo3273m();
            this.f2932g = new SupportMenuInflater(this.f2931f != null ? this.f2931f.getThemedContext() : this.f2926a);
        }
        return this.f2932g;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: h */
    public final ActionBarDrawerToggle.Delegate mo3263h() {
        return new ActionBarDrawableToggleImpl();
    }

    /* JADX INFO: renamed from: o */
    final Context m3275o() {
        Context themedContext = null;
        ActionBar actionBarMo3243a = mo3243a();
        if (actionBarMo3243a != null) {
            themedContext = actionBarMo3243a.getThemedContext();
        }
        if (themedContext == null) {
            return this.f2926a;
        }
        return themedContext;
    }

    private class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
        ActionBarDrawableToggleImpl() {
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        /* JADX INFO: renamed from: a */
        public void mo3186a(int i) {
            ActionBar actionBarMo3243a = AppCompatDelegateImplBase.this.mo3243a();
            if (actionBarMo3243a != null) {
                actionBarMo3243a.setHomeActionContentDescription(i);
            }
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: c */
    public void mo3256c() {
        this.f2939q = true;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: d */
    public void mo3259d() {
        this.f2939q = false;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: g */
    public void mo3262g() {
        this.f2940r = true;
    }

    /* JADX INFO: renamed from: p */
    public boolean mo3276p() {
        return false;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: j */
    public boolean mo3265j() {
        return false;
    }

    /* JADX INFO: renamed from: q */
    final boolean m3277q() {
        return this.f2940r;
    }

    /* JADX INFO: renamed from: r */
    final Window.Callback m3278r() {
        return this.f2927b.getCallback();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: a */
    public final void mo3251a(CharSequence charSequence) {
        this.f2938p = charSequence;
        mo3271b(charSequence);
    }

    @Override // android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: c */
    public void mo3257c(Bundle bundle) {
    }

    /* JADX INFO: renamed from: s */
    final CharSequence m3279s() {
        return this.f2928c instanceof Activity ? ((Activity) this.f2928c).getTitle() : this.f2938p;
    }

    class AppCompatWindowCallbackBase extends WindowCallbackWrapper {
        AppCompatWindowCallbackBase(Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImplBase.this.mo3269a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImplBase.this.mo3268a(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.m3604c(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.m3604c(false);
                return zOnPreparePanel;
            }
            return zOnPreparePanel;
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImplBase.this.mo3272b(i, menu);
            return true;
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImplBase.this.mo3267a(i, menu);
        }
    }
}
