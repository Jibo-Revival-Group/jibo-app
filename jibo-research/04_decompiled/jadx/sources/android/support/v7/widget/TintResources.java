package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class TintResources extends ResourcesWrapper {

    /* JADX INFO: renamed from: a */
    private final WeakReference<Context> f4431a;

    public TintResources(Context context, Resources resources) {
        super(resources);
        this.f4431a = new WeakReference<>(context);
    }

    @Override // android.support.v7.widget.ResourcesWrapper, android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i);
        Context context = this.f4431a.get();
        if (drawable != null && context != null) {
            AppCompatDrawableManager.m3862a();
            AppCompatDrawableManager.m3868a(context, i, drawable);
        }
        return drawable;
    }
}
