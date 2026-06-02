package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppCompatDelegate {

    /* JADX INFO: renamed from: a */
    private static int f2921a = -1;

    /* JADX INFO: renamed from: b */
    private static boolean f2922b = false;

    /* JADX INFO: renamed from: a */
    public abstract ActionBar mo3243a();

    /* JADX INFO: renamed from: a */
    public abstract ActionMode mo3244a(ActionMode.Callback callback);

    /* JADX INFO: renamed from: a */
    public abstract <T extends View> T mo3245a(int i);

    /* JADX INFO: renamed from: a */
    public abstract void mo3246a(Configuration configuration);

    /* JADX INFO: renamed from: a */
    public abstract void mo3247a(Bundle bundle);

    /* JADX INFO: renamed from: a */
    public abstract void mo3248a(Toolbar toolbar);

    /* JADX INFO: renamed from: a */
    public abstract void mo3249a(View view);

    /* JADX INFO: renamed from: a */
    public abstract void mo3250a(View view, ViewGroup.LayoutParams layoutParams);

    /* JADX INFO: renamed from: a */
    public abstract void mo3251a(CharSequence charSequence);

    /* JADX INFO: renamed from: b */
    public abstract MenuInflater mo3252b();

    /* JADX INFO: renamed from: b */
    public abstract void mo3253b(int i);

    /* JADX INFO: renamed from: b */
    public abstract void mo3254b(Bundle bundle);

    /* JADX INFO: renamed from: b */
    public abstract void mo3255b(View view, ViewGroup.LayoutParams layoutParams);

    /* JADX INFO: renamed from: c */
    public abstract void mo3256c();

    /* JADX INFO: renamed from: c */
    public abstract void mo3257c(Bundle bundle);

    /* JADX INFO: renamed from: c */
    public abstract boolean mo3258c(int i);

    /* JADX INFO: renamed from: d */
    public abstract void mo3259d();

    /* JADX INFO: renamed from: e */
    public abstract void mo3260e();

    /* JADX INFO: renamed from: f */
    public abstract void mo3261f();

    /* JADX INFO: renamed from: g */
    public abstract void mo3262g();

    /* JADX INFO: renamed from: h */
    public abstract ActionBarDrawerToggle.Delegate mo3263h();

    /* JADX INFO: renamed from: i */
    public abstract void mo3264i();

    /* JADX INFO: renamed from: j */
    public abstract boolean mo3265j();

    /* JADX INFO: renamed from: a */
    public static AppCompatDelegate m3238a(Activity activity, AppCompatCallback appCompatCallback) {
        return m3240a(activity, activity.getWindow(), appCompatCallback);
    }

    /* JADX INFO: renamed from: a */
    public static AppCompatDelegate m3239a(Dialog dialog, AppCompatCallback appCompatCallback) {
        return m3240a(dialog.getContext(), dialog.getWindow(), appCompatCallback);
    }

    /* JADX INFO: renamed from: a */
    private static AppCompatDelegate m3240a(Context context, Window window, AppCompatCallback appCompatCallback) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new AppCompatDelegateImplN(context, window, appCompatCallback);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return new AppCompatDelegateImplV23(context, window, appCompatCallback);
        }
        return new AppCompatDelegateImplV14(context, window, appCompatCallback);
    }

    AppCompatDelegate() {
    }

    /* JADX INFO: renamed from: k */
    public static int m3241k() {
        return f2921a;
    }

    /* JADX INFO: renamed from: l */
    public static boolean m3242l() {
        return f2922b;
    }
}
