package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.OfflineMode;
import java.security.GeneralSecurityException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public class MPConfig {

    /* JADX INFO: renamed from: D */
    private static MPConfig f11913D;

    /* JADX INFO: renamed from: A */
    private final String f11916A;

    /* JADX INFO: renamed from: B */
    private SSLSocketFactory f11917B;

    /* JADX INFO: renamed from: C */
    private OfflineMode f11918C;

    /* JADX INFO: renamed from: b */
    private final int f11919b;

    /* JADX INFO: renamed from: c */
    private final int f11920c;

    /* JADX INFO: renamed from: d */
    private final int f11921d;

    /* JADX INFO: renamed from: e */
    private final int f11922e;

    /* JADX INFO: renamed from: f */
    private final boolean f11923f;

    /* JADX INFO: renamed from: g */
    private final boolean f11924g;

    /* JADX INFO: renamed from: h */
    private final boolean f11925h;

    /* JADX INFO: renamed from: i */
    private final boolean f11926i;

    /* JADX INFO: renamed from: j */
    private final boolean f11927j;

    /* JADX INFO: renamed from: k */
    private final String[] f11928k;

    /* JADX INFO: renamed from: l */
    private final String f11929l;

    /* JADX INFO: renamed from: m */
    private final String f11930m;

    /* JADX INFO: renamed from: n */
    private final String f11931n;

    /* JADX INFO: renamed from: o */
    private final boolean f11932o;

    /* JADX INFO: renamed from: p */
    private final String f11933p;

    /* JADX INFO: renamed from: q */
    private final String f11934q;

    /* JADX INFO: renamed from: r */
    private final boolean f11935r;

    /* JADX INFO: renamed from: s */
    private final int f11936s;

    /* JADX INFO: renamed from: t */
    private final boolean f11937t;

    /* JADX INFO: renamed from: u */
    private final int f11938u;

    /* JADX INFO: renamed from: v */
    private final int f11939v;

    /* JADX INFO: renamed from: w */
    private final int f11940w;

    /* JADX INFO: renamed from: x */
    private final boolean f11941x;

    /* JADX INFO: renamed from: y */
    private final int f11942y;

    /* JADX INFO: renamed from: z */
    private final String f11943z;

    /* JADX INFO: renamed from: a */
    public static boolean f11915a = false;

    /* JADX INFO: renamed from: E */
    private static final Object f11914E = new Object();

    /* JADX INFO: renamed from: a */
    public static MPConfig m11762a(Context context) {
        synchronized (f11914E) {
            if (f11913D == null) {
                f11913D = m11763b(context.getApplicationContext());
            }
        }
        return f11913D;
    }

    MPConfig(Bundle bundle, Context context) {
        SSLSocketFactory socketFactory = null;
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            socketFactory = sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            MPLog.m12027c("MixpanelAPI.Conf", "System has no SSL support. Built-in events editor will not be available", e);
        }
        this.f11917B = socketFactory;
        f11915a = bundle.getBoolean("com.mixpanel.android.MPConfig.EnableDebugLogging", false);
        if (f11915a) {
            MPLog.m12020a(2);
        }
        if (bundle.containsKey("com.mixpanel.android.MPConfig.DebugFlushInterval")) {
            MPLog.m12028d("MixpanelAPI.Conf", "We do not support com.mixpanel.android.MPConfig.DebugFlushInterval anymore. There will only be one flush interval. Please, update your AndroidManifest.xml.");
        }
        this.f11919b = bundle.getInt("com.mixpanel.android.MPConfig.BulkUploadLimit", 40);
        this.f11920c = bundle.getInt("com.mixpanel.android.MPConfig.FlushInterval", 60000);
        this.f11921d = bundle.getInt("com.mixpanel.android.MPConfig.DataExpiration", 432000000);
        this.f11922e = bundle.getInt("com.mixpanel.android.MPConfig.MinimumDatabaseLimit", 20971520);
        this.f11934q = bundle.getString("com.mixpanel.android.MPConfig.ResourcePackageName");
        this.f11924g = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableGestureBindingUI", false);
        this.f11925h = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableEmulatorBindingUI", false);
        this.f11926i = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableAppOpenEvent", true);
        this.f11927j = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableViewCrawler", false);
        this.f11935r = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableDecideChecker", false);
        this.f11936s = bundle.getInt("com.mixpanel.android.MPConfig.ImageCacheMaxMemoryFactor", 10);
        this.f11937t = bundle.getBoolean("com.mixpanel.android.MPConfig.IgnoreInvisibleViewsVisualEditor", false);
        this.f11932o = bundle.getBoolean("com.mixpanel.android.MPConfig.AutoShowMixpanelUpdates", true);
        this.f11938u = bundle.getInt("com.mixpanel.android.MPConfig.NotificationDefaults", 0);
        this.f11939v = bundle.getInt("com.mixpanel.android.MPConfig.MinimumSessionDuration", 10000);
        this.f11940w = bundle.getInt("com.mixpanel.android.MPConfig.SessionTimeoutDuration", Integer.MAX_VALUE);
        this.f11941x = bundle.getBoolean("com.mixpanel.android.MPConfig.UseIpAddressForGeolocation", true);
        this.f11923f = bundle.getBoolean("com.mixpanel.android.MPConfig.TestMode", false);
        this.f11942y = bundle.getInt("com.mixpanel.android.MPConfig.NotificationChannelImportance", 3);
        String string = bundle.getString("com.mixpanel.android.MPConfig.NotificationChannelId");
        this.f11943z = string == null ? "mp" : string;
        String string2 = bundle.getString("com.mixpanel.android.MPConfig.NotificationChannelName");
        this.f11916A = string2 == null ? SystemInformation.m11933a(context).m11936c() : string2;
        String string3 = bundle.getString("com.mixpanel.android.MPConfig.EventsEndpoint");
        if (string3 == null) {
            string3 = "https://api.mixpanel.com/track?ip=" + (this.f11941x ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        this.f11929l = string3;
        String string4 = bundle.getString("com.mixpanel.android.MPConfig.PeopleEndpoint");
        this.f11930m = string4 == null ? "https://api.mixpanel.com/engage" : string4;
        String string5 = bundle.getString("com.mixpanel.android.MPConfig.DecideEndpoint");
        this.f11931n = string5 == null ? "https://decide.mixpanel.com/decide" : string5;
        String string6 = bundle.getString("com.mixpanel.android.MPConfig.EditorUrl");
        this.f11933p = string6 == null ? "wss://switchboard.mixpanel.com/connect/" : string6;
        int i = bundle.getInt("com.mixpanel.android.MPConfig.DisableViewCrawlerForProjects", -1);
        if (i != -1) {
            this.f11928k = context.getResources().getStringArray(i);
        } else {
            this.f11928k = new String[0];
        }
        MPLog.m12021a("MixpanelAPI.Conf", "Mixpanel (5.2.1) configured with:\n    AutoShowMixpanelUpdates " + m11778n() + "\n    BulkUploadLimit " + m11765a() + "\n    FlushInterval " + m11766b() + "\n    DataExpiration " + m11767c() + "\n    MinimumDatabaseLimit " + m11768d() + "\n    DisableAppOpenEvent " + m11771g() + "\n    DisableViewCrawler " + m11772h() + "\n    DisableGestureBindingUI " + m11769e() + "\n    DisableEmulatorBindingUI " + m11770f() + "\n    EnableDebugLogging " + f11915a + "\n    TestMode " + m11774j() + "\n    EventsEndpoint " + m11775k() + "\n    PeopleEndpoint " + m11776l() + "\n    DecideEndpoint " + m11777m() + "\n    EditorUrl " + m11779o() + "\n    ImageCacheMaxMemoryFactor " + m11764A() + "\n    DisableDecideChecker " + m11780p() + "\n    IgnoreInvisibleViewsEditor " + m11781q() + "\n    NotificationDefaults " + m11782r() + "\n    MinimumSessionDuration: " + m11783s() + "\n    SessionTimeoutDuration: " + m11784t() + "\n    NotificationChannelId: " + m11785u() + "\n    NotificationChannelName: " + m11786v() + "\n    NotificationChannelImportance: " + m11787w());
    }

    /* JADX INFO: renamed from: a */
    public int m11765a() {
        return this.f11919b;
    }

    /* JADX INFO: renamed from: b */
    public int m11766b() {
        return this.f11920c;
    }

    /* JADX INFO: renamed from: c */
    public int m11767c() {
        return this.f11921d;
    }

    /* JADX INFO: renamed from: d */
    public int m11768d() {
        return this.f11922e;
    }

    /* JADX INFO: renamed from: e */
    public boolean m11769e() {
        return this.f11924g;
    }

    /* JADX INFO: renamed from: f */
    public boolean m11770f() {
        return this.f11925h;
    }

    /* JADX INFO: renamed from: g */
    public boolean m11771g() {
        return this.f11926i;
    }

    /* JADX INFO: renamed from: h */
    public boolean m11772h() {
        return this.f11927j;
    }

    /* JADX INFO: renamed from: i */
    public String[] m11773i() {
        return this.f11928k;
    }

    /* JADX INFO: renamed from: j */
    public boolean m11774j() {
        return this.f11923f;
    }

    /* JADX INFO: renamed from: k */
    public String m11775k() {
        return this.f11929l;
    }

    /* JADX INFO: renamed from: l */
    public String m11776l() {
        return this.f11930m;
    }

    /* JADX INFO: renamed from: m */
    public String m11777m() {
        return this.f11931n;
    }

    /* JADX INFO: renamed from: n */
    public boolean m11778n() {
        return this.f11932o;
    }

    /* JADX INFO: renamed from: o */
    public String m11779o() {
        return this.f11933p;
    }

    /* JADX INFO: renamed from: p */
    public boolean m11780p() {
        return this.f11935r;
    }

    /* JADX INFO: renamed from: q */
    public boolean m11781q() {
        return this.f11937t;
    }

    /* JADX INFO: renamed from: r */
    public int m11782r() {
        return this.f11938u;
    }

    /* JADX INFO: renamed from: s */
    public int m11783s() {
        return this.f11939v;
    }

    /* JADX INFO: renamed from: t */
    public int m11784t() {
        return this.f11940w;
    }

    /* JADX INFO: renamed from: u */
    public String m11785u() {
        return this.f11943z;
    }

    /* JADX INFO: renamed from: v */
    public String m11786v() {
        return this.f11916A;
    }

    /* JADX INFO: renamed from: w */
    public int m11787w() {
        return this.f11942y;
    }

    /* JADX INFO: renamed from: x */
    public String m11788x() {
        return this.f11934q;
    }

    /* JADX INFO: renamed from: y */
    public synchronized SSLSocketFactory m11789y() {
        return this.f11917B;
    }

    /* JADX INFO: renamed from: z */
    public synchronized OfflineMode m11790z() {
        return this.f11918C;
    }

    /* JADX INFO: renamed from: A */
    public int m11764A() {
        return this.f11936s;
    }

    /* JADX INFO: renamed from: b */
    static MPConfig m11763b(Context context) {
        String packageName = context.getPackageName();
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(packageName, 128).metaData;
            if (bundle == null) {
                bundle = new Bundle();
            }
            return new MPConfig(bundle, context);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Can't configure Mixpanel with package name " + packageName, e);
        }
    }
}
