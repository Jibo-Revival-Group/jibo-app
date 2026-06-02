package com.crashlytics.android.core;

import android.content.Context;
import android.util.Log;
import com.crashlytics.android.core.internal.CrashEventDataProvider;
import com.crashlytics.android.core.internal.models.SessionEventData;
import com.yalantis.ucrop.util.FileUtils;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.ExecutorUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.PriorityCallable;
import io.fabric.sdk.android.services.concurrency.Task;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@DependsOn(m15297a = {CrashEventDataProvider.class})
public class CrashlyticsCore extends Kit<Void> {

    /* JADX INFO: renamed from: a */
    private final long f5224a;

    /* JADX INFO: renamed from: b */
    private final ConcurrentHashMap<String, String> f5225b;

    /* JADX INFO: renamed from: c */
    private CrashlyticsFileMarker f5226c;

    /* JADX INFO: renamed from: d */
    private CrashlyticsFileMarker f5227d;

    /* JADX INFO: renamed from: k */
    private CrashlyticsListener f5228k;

    /* JADX INFO: renamed from: l */
    private CrashlyticsController f5229l;

    /* JADX INFO: renamed from: m */
    private String f5230m;

    /* JADX INFO: renamed from: n */
    private String f5231n;

    /* JADX INFO: renamed from: o */
    private String f5232o;

    /* JADX INFO: renamed from: p */
    private float f5233p;

    /* JADX INFO: renamed from: q */
    private boolean f5234q;

    /* JADX INFO: renamed from: r */
    private final PinningInfoProvider f5235r;

    /* JADX INFO: renamed from: s */
    private HttpRequestFactory f5236s;

    /* JADX INFO: renamed from: t */
    private CrashlyticsBackgroundWorker f5237t;

    /* JADX INFO: renamed from: u */
    private CrashEventDataProvider f5238u;

    public CrashlyticsCore() {
        this(1.0f, null, null, false);
    }

    CrashlyticsCore(float f, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z) {
        this(f, crashlyticsListener, pinningInfoProvider, z, ExecutorUtils.m15216a("Crashlytics Exception Handler"));
    }

    CrashlyticsCore(float f, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z, ExecutorService executorService) {
        this.f5230m = null;
        this.f5231n = null;
        this.f5232o = null;
        this.f5233p = f;
        this.f5228k = crashlyticsListener == null ? new NoOpListener() : crashlyticsListener;
        this.f5235r = pinningInfoProvider;
        this.f5234q = z;
        this.f5237t = new CrashlyticsBackgroundWorker(executorService);
        this.f5225b = new ConcurrentHashMap<>();
        this.f5224a = System.currentTimeMillis();
    }

    @Override // io.fabric.sdk.android.Kit
    /* JADX INFO: renamed from: a_ */
    protected boolean mo5607a_() {
        return m5870a(super.m15121r());
    }

    /* JADX INFO: renamed from: a */
    boolean m5870a(Context context) {
        String strM15165a;
        if (!this.f5234q && (strM15165a = new ApiKey().m15165a(context)) != null) {
            String strM15210m = CommonUtils.m15210m(context);
            if (!m5865a(strM15210m, CommonUtils.m15191a(context, "com.crashlytics.RequireBuildId", true))) {
                throw new UnmetDependencyException("This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.");
            }
            try {
                Fabric.m15085h().mo15068c("CrashlyticsCore", "Initializing Crashlytics " + mo5600a());
                FileStoreImpl fileStoreImpl = new FileStoreImpl(this);
                this.f5227d = new CrashlyticsFileMarker("crash_marker", fileStoreImpl);
                this.f5226c = new CrashlyticsFileMarker("initialization_marker", fileStoreImpl);
                PreferenceManager preferenceManagerM5954a = PreferenceManager.m5954a(new PreferenceStoreImpl(m15121r(), "com.crashlytics.android.core.CrashlyticsCore"), this);
                CrashlyticsPinningInfoProvider crashlyticsPinningInfoProvider = this.f5235r != null ? new CrashlyticsPinningInfoProvider(this.f5235r) : null;
                this.f5236s = new DefaultHttpRequestFactory(Fabric.m15085h());
                this.f5236s.mo15346a(crashlyticsPinningInfoProvider);
                IdManager idManagerQ = m15120q();
                AppData appDataM5710a = AppData.m5710a(context, idManagerQ, strM15165a, strM15210m);
                ManifestUnityVersionProvider manifestUnityVersionProvider = new ManifestUnityVersionProvider(context, appDataM5710a.f5140d);
                Fabric.m15085h().mo15063a("CrashlyticsCore", "Installer package name is: " + appDataM5710a.f5139c);
                this.f5229l = new CrashlyticsController(this, this.f5237t, this.f5236s, idManagerQ, preferenceManagerM5954a, fileStoreImpl, appDataM5710a, manifestUnityVersionProvider);
                boolean zM5878m = m5878m();
                m5868x();
                this.f5229l.m5836a(Thread.getDefaultUncaughtExceptionHandler());
                if (zM5878m && CommonUtils.m15211n(context)) {
                    Fabric.m15085h().mo15063a("CrashlyticsCore", "Crashlytics did not finish previous background initialization. Initializing synchronously.");
                    m5867w();
                    return false;
                }
                Fabric.m15085h().mo15063a("CrashlyticsCore", "Exception handling initialization successful");
                return true;
            } catch (Exception e) {
                Fabric.m15085h().mo15073e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", e);
                this.f5229l = null;
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.Kit
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Void mo5604f() {
        m5876k();
        SessionEventData sessionEventDataM5879n = m5879n();
        if (sessionEventDataM5879n != null) {
            this.f5229l.m5835a(sessionEventDataM5879n);
        }
        this.f5229l.m5844d();
        try {
            SettingsData settingsDataM15458b = Settings.m15455a().m15458b();
            if (settingsDataM15458b == null) {
                Fabric.m15085h().mo15070d("CrashlyticsCore", "Received null settings, skipping report submission!");
            } else if (settingsDataM15458b.f14790d.f14762c) {
                if (!this.f5229l.m5839a(settingsDataM15458b.f14788b)) {
                    Fabric.m15085h().mo15063a("CrashlyticsCore", "Could not finalize previous sessions.");
                }
                this.f5229l.m5833a(this.f5233p, settingsDataM15458b);
            } else {
                Fabric.m15085h().mo15063a("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
            }
        } catch (Exception e) {
            Fabric.m15085h().mo15073e("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", e);
        } finally {
            m5877l();
        }
        return null;
    }

    @Override // io.fabric.sdk.android.Kit
    /* JADX INFO: renamed from: b */
    public String mo5601b() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    @Override // io.fabric.sdk.android.Kit
    /* JADX INFO: renamed from: a */
    public String mo5600a() {
        return "2.3.17.dev";
    }

    /* JADX INFO: renamed from: e */
    public static CrashlyticsCore m5866e() {
        return (CrashlyticsCore) Fabric.m15076a(CrashlyticsCore.class);
    }

    /* JADX INFO: renamed from: a */
    public void m5869a(Throwable th) {
        if (!this.f5234q && m5864a("prior to logging exceptions.")) {
            if (th == null) {
                Fabric.m15085h().mo15061a(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
            } else {
                this.f5229l.m5841b(Thread.currentThread(), th);
            }
        }
    }

    /* JADX INFO: renamed from: g */
    Map<String, String> m5872g() {
        return Collections.unmodifiableMap(this.f5225b);
    }

    /* JADX INFO: renamed from: h */
    String m5873h() {
        if (m15120q().m15225a()) {
            return this.f5230m;
        }
        return null;
    }

    /* JADX INFO: renamed from: i */
    String m5874i() {
        if (m15120q().m15225a()) {
            return this.f5231n;
        }
        return null;
    }

    /* JADX INFO: renamed from: j */
    String m5875j() {
        if (m15120q().m15225a()) {
            return this.f5232o;
        }
        return null;
    }

    /* JADX INFO: renamed from: w */
    private void m5867w() {
        PriorityCallable<Void> priorityCallable = new PriorityCallable<Void>() { // from class: com.crashlytics.android.core.CrashlyticsCore.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() throws Exception {
                return CrashlyticsCore.this.mo5604f();
            }

            @Override // io.fabric.sdk.android.services.concurrency.PriorityTask, io.fabric.sdk.android.services.concurrency.PriorityProvider
            /* JADX INFO: renamed from: b */
            public Priority mo5882b() {
                return Priority.IMMEDIATE;
            }
        };
        Iterator<Task> it = m15125v().iterator();
        while (it.hasNext()) {
            priorityCallable.mo15285c(it.next());
        }
        Future futureSubmit = m15122s().m15097f().submit(priorityCallable);
        Fabric.m15085h().mo15063a("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            futureSubmit.get(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Fabric.m15085h().mo15073e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", e);
        } catch (ExecutionException e2) {
            Fabric.m15085h().mo15073e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", e2);
        } catch (TimeoutException e3) {
            Fabric.m15085h().mo15073e("CrashlyticsCore", "Crashlytics timed out during initialization.", e3);
        }
    }

    /* JADX INFO: renamed from: k */
    void m5876k() {
        this.f5237t.m5779a(new Callable<Void>() { // from class: com.crashlytics.android.core.CrashlyticsCore.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() throws Exception {
                CrashlyticsCore.this.f5226c.m5889a();
                Fabric.m15085h().mo15063a("CrashlyticsCore", "Initialization marker file created.");
                return null;
            }
        });
    }

    /* JADX INFO: renamed from: l */
    void m5877l() {
        this.f5237t.m5781b(new Callable<Boolean>() { // from class: com.crashlytics.android.core.CrashlyticsCore.3
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                try {
                    boolean zM5891c = CrashlyticsCore.this.f5226c.m5891c();
                    Fabric.m15085h().mo15063a("CrashlyticsCore", "Initialization marker file removed: " + zM5891c);
                    return Boolean.valueOf(zM5891c);
                } catch (Exception e) {
                    Fabric.m15085h().mo15073e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", e);
                    return false;
                }
            }
        });
    }

    /* JADX INFO: renamed from: m */
    boolean m5878m() {
        return ((Boolean) this.f5237t.m5779a(new Callable<Boolean>() { // from class: com.crashlytics.android.core.CrashlyticsCore.4
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(CrashlyticsCore.this.f5226c.m5890b());
            }
        })).booleanValue();
    }

    /* JADX INFO: renamed from: n */
    SessionEventData m5879n() {
        if (this.f5238u == null) {
            return null;
        }
        return this.f5238u.m6004a();
    }

    /* JADX INFO: renamed from: x */
    private void m5868x() {
        if (Boolean.TRUE.equals((Boolean) this.f5237t.m5779a(new CrashMarkerCheck(this.f5227d)))) {
            try {
                this.f5228k.mo5887a();
            } catch (Exception e) {
                Fabric.m15085h().mo15073e("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
            }
        }
    }

    /* JADX INFO: renamed from: o */
    void m5880o() {
        this.f5227d.m5889a();
    }

    /* JADX INFO: renamed from: a */
    private static boolean m5864a(String str) {
        CrashlyticsCore crashlyticsCoreM5866e = m5866e();
        if (crashlyticsCoreM5866e != null && crashlyticsCoreM5866e.f5229l != null) {
            return true;
        }
        Fabric.m15085h().mo15073e("CrashlyticsCore", "Crashlytics must be initialized by calling Fabric.with(Context) " + str, null);
        return false;
    }

    private static final class CrashMarkerCheck implements Callable<Boolean> {

        /* JADX INFO: renamed from: a */
        private final CrashlyticsFileMarker f5243a;

        public CrashMarkerCheck(CrashlyticsFileMarker crashlyticsFileMarker) {
            this.f5243a = crashlyticsFileMarker;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            if (!this.f5243a.m5890b()) {
                return Boolean.FALSE;
            }
            Fabric.m15085h().mo15063a("CrashlyticsCore", "Found previous crash marker.");
            this.f5243a.m5891c();
            return Boolean.TRUE;
        }
    }

    private static final class NoOpListener implements CrashlyticsListener {
        private NoOpListener() {
        }

        @Override // com.crashlytics.android.core.CrashlyticsListener
        /* JADX INFO: renamed from: a */
        public void mo5887a() {
        }
    }

    /* JADX INFO: renamed from: a */
    static boolean m5865a(String str, boolean z) {
        if (!z) {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "Configured not to require a build ID.");
            return true;
        }
        if (!CommonUtils.m15200c(str)) {
            return true;
        }
        Log.e("CrashlyticsCore", FileUtils.HIDDEN_PREFIX);
        Log.e("CrashlyticsCore", ".     |  | ");
        Log.e("CrashlyticsCore", ".     |  |");
        Log.e("CrashlyticsCore", ".     |  |");
        Log.e("CrashlyticsCore", ".   \\ |  | /");
        Log.e("CrashlyticsCore", ".    \\    /");
        Log.e("CrashlyticsCore", ".     \\  /");
        Log.e("CrashlyticsCore", ".      \\/");
        Log.e("CrashlyticsCore", FileUtils.HIDDEN_PREFIX);
        Log.e("CrashlyticsCore", "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.");
        Log.e("CrashlyticsCore", FileUtils.HIDDEN_PREFIX);
        Log.e("CrashlyticsCore", ".      /\\");
        Log.e("CrashlyticsCore", ".     /  \\");
        Log.e("CrashlyticsCore", ".    /    \\");
        Log.e("CrashlyticsCore", ".   / |  | \\");
        Log.e("CrashlyticsCore", ".     |  |");
        Log.e("CrashlyticsCore", ".     |  |");
        Log.e("CrashlyticsCore", ".     |  |");
        Log.e("CrashlyticsCore", FileUtils.HIDDEN_PREFIX);
        return false;
    }
}
