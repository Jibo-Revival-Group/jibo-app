package android.support.customtabs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v4.content.ContextCompat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class CustomTabsIntent {

    /* JADX INFO: renamed from: a */
    public final Intent f363a;

    /* JADX INFO: renamed from: b */
    public final Bundle f364b;

    /* JADX INFO: renamed from: a */
    public void m316a(Context context, Uri uri) {
        this.f363a.setData(uri);
        ContextCompat.m1833a(context, this.f363a, this.f364b);
    }

    private CustomTabsIntent(Intent intent, Bundle bundle) {
        this.f363a = intent;
        this.f364b = bundle;
    }

    public static final class Builder {

        /* JADX INFO: renamed from: a */
        private final Intent f365a;

        /* JADX INFO: renamed from: b */
        private ArrayList<Bundle> f366b;

        /* JADX INFO: renamed from: c */
        private Bundle f367c;

        /* JADX INFO: renamed from: d */
        private ArrayList<Bundle> f368d;

        /* JADX INFO: renamed from: e */
        private boolean f369e;

        public Builder() {
            this(null);
        }

        public Builder(CustomTabsSession customTabsSession) {
            this.f365a = new Intent("android.intent.action.VIEW");
            this.f366b = null;
            this.f367c = null;
            this.f368d = null;
            this.f369e = true;
            if (customTabsSession != null) {
                this.f365a.setPackage(customTabsSession.m331b().getPackageName());
            }
            Bundle bundle = new Bundle();
            BundleCompat.m1397a(bundle, "android.support.customtabs.extra.SESSION", customTabsSession != null ? customTabsSession.m330a() : null);
            this.f365a.putExtras(bundle);
        }

        /* JADX INFO: renamed from: a */
        public CustomTabsIntent m317a() {
            if (this.f366b != null) {
                this.f365a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", this.f366b);
            }
            if (this.f368d != null) {
                this.f365a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", this.f368d);
            }
            this.f365a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f369e);
            return new CustomTabsIntent(this.f365a, this.f367c);
        }
    }
}
