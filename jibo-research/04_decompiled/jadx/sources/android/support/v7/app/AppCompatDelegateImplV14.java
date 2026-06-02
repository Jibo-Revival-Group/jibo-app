package android.support.v7.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegateImplBase;
import android.support.v7.view.SupportActionModeWrapper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
class AppCompatDelegateImplV14 extends AppCompatDelegateImplV9 {

    /* JADX INFO: renamed from: t */
    private int f2945t;

    /* JADX INFO: renamed from: u */
    private boolean f2946u;

    /* JADX INFO: renamed from: v */
    private boolean f2947v;

    /* JADX INFO: renamed from: w */
    private AutoNightModeManager f2948w;

    AppCompatDelegateImplV14(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        this.f2945t = -100;
        this.f2947v = true;
    }

    @Override // android.support.v7.app.AppCompatDelegateImplV9, android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: a */
    public void mo3247a(Bundle bundle) {
        super.mo3247a(bundle);
        if (bundle != null && this.f2945t == -100) {
            this.f2945t = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegateImplV9
    /* JADX INFO: renamed from: a */
    View mo3285a(View view, String str, Context context, AttributeSet attributeSet) {
        return null;
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    /* JADX INFO: renamed from: a */
    Window.Callback mo3266a(Window.Callback callback) {
        return new AppCompatWindowCallbackV14(callback);
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    /* JADX INFO: renamed from: p */
    public boolean mo3276p() {
        return this.f2947v;
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: j */
    public boolean mo3265j() {
        boolean zM3281h = false;
        int iM3282x = m3282x();
        int iMo3286d = mo3286d(iM3282x);
        if (iMo3286d != -1) {
            zM3281h = m3281h(iMo3286d);
        }
        if (iM3282x == 0) {
            m3283y();
            this.f2948w.m3290c();
        }
        this.f2946u = true;
        return zM3281h;
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: c */
    public void mo3256c() {
        super.mo3256c();
        mo3265j();
    }

    @Override // android.support.v7.app.AppCompatDelegateImplV9, android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: d */
    public void mo3259d() {
        super.mo3259d();
        if (this.f2948w != null) {
            this.f2948w.m3291d();
        }
    }

    /* JADX INFO: renamed from: d */
    int mo3286d(int i) {
        switch (i) {
            case -100:
                return -1;
            case 0:
                m3283y();
                return this.f2948w.m3288a();
            default:
                return i;
        }
    }

    /* JADX INFO: renamed from: x */
    private int m3282x() {
        return this.f2945t != -100 ? this.f2945t : m3241k();
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: c */
    public void mo3257c(Bundle bundle) {
        super.mo3257c(bundle);
        if (this.f2945t != -100) {
            bundle.putInt("appcompat:local_night_mode", this.f2945t);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegateImplV9, android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    /* JADX INFO: renamed from: g */
    public void mo3262g() {
        super.mo3262g();
        if (this.f2948w != null) {
            this.f2948w.m3291d();
        }
    }

    /* JADX INFO: renamed from: h */
    private boolean m3281h(int i) {
        Resources resources = this.f2926a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 != i3) {
            if (m3284z()) {
                ((Activity) this.f2926a).recreate();
            } else {
                Configuration configuration2 = new Configuration(configuration);
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
                resources.updateConfiguration(configuration2, displayMetrics);
                if (Build.VERSION.SDK_INT < 26) {
                    ResourcesFlusher.m3366a(resources);
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: y */
    private void m3283y() {
        if (this.f2948w == null) {
            this.f2948w = new AutoNightModeManager(TwilightManager.m3375a(this.f2926a));
        }
    }

    /* JADX INFO: renamed from: z */
    private boolean m3284z() {
        if (!this.f2946u || !(this.f2926a instanceof Activity)) {
            return false;
        }
        try {
            return (this.f2926a.getPackageManager().getActivityInfo(new ComponentName(this.f2926a, this.f2926a.getClass()), 0).configChanges & 512) == 0;
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
            return true;
        }
    }

    class AppCompatWindowCallbackV14 extends AppCompatDelegateImplBase.AppCompatWindowCallbackBase {
        AppCompatWindowCallbackV14(Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return AppCompatDelegateImplV14.this.mo3276p() ? m3287a(callback) : super.onWindowStartingActionMode(callback);
        }

        /* JADX INFO: renamed from: a */
        final ActionMode m3287a(ActionMode.Callback callback) {
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImplV14.this.f2926a, callback);
            android.support.v7.view.ActionMode actionModeA = AppCompatDelegateImplV14.this.mo3244a(callbackWrapper);
            if (actionModeA != null) {
                return callbackWrapper.m3480b(actionModeA);
            }
            return null;
        }
    }

    final class AutoNightModeManager {

        /* JADX INFO: renamed from: b */
        private TwilightManager f2951b;

        /* JADX INFO: renamed from: c */
        private boolean f2952c;

        /* JADX INFO: renamed from: d */
        private BroadcastReceiver f2953d;

        /* JADX INFO: renamed from: e */
        private IntentFilter f2954e;

        AutoNightModeManager(TwilightManager twilightManager) {
            this.f2951b = twilightManager;
            this.f2952c = twilightManager.m3379a();
        }

        /* JADX INFO: renamed from: a */
        final int m3288a() {
            this.f2952c = this.f2951b.m3379a();
            return this.f2952c ? 2 : 1;
        }

        /* JADX INFO: renamed from: b */
        final void m3289b() {
            boolean zM3379a = this.f2951b.m3379a();
            if (zM3379a != this.f2952c) {
                this.f2952c = zM3379a;
                AppCompatDelegateImplV14.this.mo3265j();
            }
        }

        /* JADX INFO: renamed from: c */
        final void m3290c() {
            m3291d();
            if (this.f2953d == null) {
                this.f2953d = new BroadcastReceiver() { // from class: android.support.v7.app.AppCompatDelegateImplV14.AutoNightModeManager.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        AutoNightModeManager.this.m3289b();
                    }
                };
            }
            if (this.f2954e == null) {
                this.f2954e = new IntentFilter();
                this.f2954e.addAction("android.intent.action.TIME_SET");
                this.f2954e.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.f2954e.addAction("android.intent.action.TIME_TICK");
            }
            AppCompatDelegateImplV14.this.f2926a.registerReceiver(this.f2953d, this.f2954e);
        }

        /* JADX INFO: renamed from: d */
        final void m3291d() {
            if (this.f2953d != null) {
                AppCompatDelegateImplV14.this.f2926a.unregisterReceiver(this.f2953d);
                this.f2953d = null;
            }
        }
    }
}
