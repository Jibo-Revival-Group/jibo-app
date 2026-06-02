package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatDelegate;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class VectorEnabledTintResources extends Resources {

    /* JADX INFO: renamed from: a */
    private final WeakReference<Context> f4486a;

    /* JADX INFO: renamed from: a */
    public static boolean m4999a() {
        return AppCompatDelegate.m3242l() && Build.VERSION.SDK_INT <= 20;
    }

    public VectorEnabledTintResources(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f4486a = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Context context = this.f4486a.get();
        return context != null ? AppCompatDrawableManager.m3862a().m3883a(context, this, i) : super.getDrawable(i);
    }

    /* JADX INFO: renamed from: a */
    final Drawable m5000a(int i) {
        return super.getDrawable(i);
    }
}
