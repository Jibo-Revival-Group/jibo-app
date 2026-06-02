package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class TintContextWrapper extends ContextWrapper {

    /* JADX INFO: renamed from: a */
    private static final Object f4423a = new Object();

    /* JADX INFO: renamed from: b */
    private static ArrayList<WeakReference<TintContextWrapper>> f4424b;

    /* JADX INFO: renamed from: c */
    private final Resources f4425c;

    /* JADX INFO: renamed from: d */
    private final Resources.Theme f4426d;

    /* JADX INFO: renamed from: a */
    public static Context m4950a(Context context) {
        if (m4951b(context)) {
            synchronized (f4423a) {
                if (f4424b == null) {
                    f4424b = new ArrayList<>();
                } else {
                    for (int size = f4424b.size() - 1; size >= 0; size--) {
                        WeakReference<TintContextWrapper> weakReference = f4424b.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f4424b.remove(size);
                        }
                    }
                    for (int size2 = f4424b.size() - 1; size2 >= 0; size2--) {
                        WeakReference<TintContextWrapper> weakReference2 = f4424b.get(size2);
                        TintContextWrapper tintContextWrapper = weakReference2 != null ? weakReference2.get() : null;
                        if (tintContextWrapper != null && tintContextWrapper.getBaseContext() == context) {
                            return tintContextWrapper;
                        }
                    }
                }
                TintContextWrapper tintContextWrapper2 = new TintContextWrapper(context);
                f4424b.add(new WeakReference<>(tintContextWrapper2));
                return tintContextWrapper2;
            }
        }
        return context;
    }

    /* JADX INFO: renamed from: b */
    private static boolean m4951b(Context context) {
        if ((context instanceof TintContextWrapper) || (context.getResources() instanceof TintResources) || (context.getResources() instanceof VectorEnabledTintResources)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || VectorEnabledTintResources.m4999a();
    }

    private TintContextWrapper(Context context) {
        super(context);
        if (VectorEnabledTintResources.m4999a()) {
            this.f4425c = new VectorEnabledTintResources(this, context.getResources());
            this.f4426d = this.f4425c.newTheme();
            this.f4426d.setTo(context.getTheme());
        } else {
            this.f4425c = new TintResources(this, context.getResources());
            this.f4426d = null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        return this.f4426d == null ? super.getTheme() : this.f4426d;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f4426d == null) {
            super.setTheme(i);
        } else {
            this.f4426d.applyStyle(i, true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f4425c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f4425c.getAssets();
    }
}
