package android.support.v7.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v7.appcompat.R;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarPolicy {

    /* JADX INFO: renamed from: a */
    private Context f3156a;

    /* JADX INFO: renamed from: a */
    public static ActionBarPolicy m3462a(Context context) {
        return new ActionBarPolicy(context);
    }

    private ActionBarPolicy(Context context) {
        this.f3156a = context;
    }

    /* JADX INFO: renamed from: a */
    public int m3463a() {
        Configuration configuration = this.f3156a.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600 || ((i > 960 && i2 > 720) || (i > 720 && i2 > 960))) {
            return 5;
        }
        if (i >= 500 || ((i > 640 && i2 > 480) || (i > 480 && i2 > 640))) {
            return 4;
        }
        if (i >= 360) {
            return 3;
        }
        return 2;
    }

    /* JADX INFO: renamed from: b */
    public boolean m3464b() {
        return Build.VERSION.SDK_INT >= 19 || !ViewConfiguration.get(this.f3156a).hasPermanentMenuKey();
    }

    /* JADX INFO: renamed from: c */
    public int m3465c() {
        return this.f3156a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    /* JADX INFO: renamed from: d */
    public boolean m3466d() {
        return this.f3156a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
    }

    /* JADX INFO: renamed from: e */
    public int m3467e() {
        TypedArray typedArrayObtainStyledAttributes = this.f3156a.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0);
        Resources resources = this.f3156a.getResources();
        if (!m3466d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
        }
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    /* JADX INFO: renamed from: f */
    public boolean m3468f() {
        return this.f3156a.getApplicationInfo().targetSdkVersion < 14;
    }

    /* JADX INFO: renamed from: g */
    public int m3469g() {
        return this.f3156a.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }
}
