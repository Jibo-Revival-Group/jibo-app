package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.appcompat.R;
import android.view.LayoutInflater;

/* JADX INFO: loaded from: classes.dex */
public class ContextThemeWrapper extends ContextWrapper {

    /* JADX INFO: renamed from: a */
    private int f3159a;

    /* JADX INFO: renamed from: b */
    private Resources.Theme f3160b;

    /* JADX INFO: renamed from: c */
    private LayoutInflater f3161c;

    /* JADX INFO: renamed from: d */
    private Configuration f3162d;

    /* JADX INFO: renamed from: e */
    private Resources f3163e;

    public ContextThemeWrapper() {
        super(null);
    }

    public ContextThemeWrapper(Context context, int i) {
        super(context);
        this.f3159a = i;
    }

    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        this.f3160b = theme;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return m3475b();
    }

    /* JADX INFO: renamed from: b */
    private Resources m3475b() {
        if (this.f3163e == null) {
            if (this.f3162d == null) {
                this.f3163e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.f3163e = createConfigurationContext(this.f3162d).getResources();
            }
        }
        return this.f3163e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f3159a != i) {
            this.f3159a = i;
            m3476c();
        }
    }

    /* JADX INFO: renamed from: a */
    public int m3477a() {
        return this.f3159a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        if (this.f3160b != null) {
            return this.f3160b;
        }
        if (this.f3159a == 0) {
            this.f3159a = R.style.Theme_AppCompat_Light;
        }
        m3476c();
        return this.f3160b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f3161c == null) {
            this.f3161c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f3161c;
    }

    /* JADX INFO: renamed from: a */
    protected void m3478a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    /* JADX INFO: renamed from: c */
    private void m3476c() {
        boolean z = this.f3160b == null;
        if (z) {
            this.f3160b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f3160b.setTo(theme);
            }
        }
        m3478a(this.f3160b, this.f3159a, z);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }
}
