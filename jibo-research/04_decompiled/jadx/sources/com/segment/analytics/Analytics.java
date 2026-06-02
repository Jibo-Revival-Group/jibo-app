package com.segment.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.segment.analytics.Client;
import com.segment.analytics.ProjectSettings;
import com.segment.analytics.Traits;
import com.segment.analytics.integrations.AliasPayload;
import com.segment.analytics.integrations.BasePayload;
import com.segment.analytics.integrations.GroupPayload;
import com.segment.analytics.integrations.IdentifyPayload;
import com.segment.analytics.integrations.Integration;
import com.segment.analytics.integrations.Logger;
import com.segment.analytics.integrations.ScreenPayload;
import com.segment.analytics.integrations.TrackPayload;
import com.segment.analytics.internal.Utils;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class Analytics {
    private static final String BUILD_KEY = "build";
    static final String OPT_OUT_PREFERENCE_KEY = "opt-out";
    private static final long SETTINGS_REFRESH_INTERVAL = 86400000;
    private static final long SETTINGS_RETRY_INTERVAL = 60000;
    private static final String TRACKED_ATTRIBUTION_KEY = "tracked_attribution";
    private static final String VERSION_KEY = "version";
    static final String WRITE_KEY_RESOURCE_IDENTIFIER = "analytics_write_key";
    final Application.ActivityLifecycleCallbacks activityLifecycleCallback;
    private final CountDownLatch advertisingIdLatch;
    final AnalyticsContext analyticsContext;
    private final ExecutorService analyticsExecutor;
    private final Application application;
    final Map<String, Boolean> bundledIntegrations = new ConcurrentHashMap();
    final Cartographer cartographer;
    final Client client;
    final Crypto crypto;
    final Options defaultOptions;
    private List<Integration.Factory> factories;
    final long flushIntervalInMillis;
    final int flushQueueSize;
    private Map<String, Integration<?>> integrations;
    private final Logger logger;
    private final List<Middleware> middlewares;
    final ExecutorService networkExecutor;
    private final BooleanPreference optOut;
    ProjectSettings projectSettings;
    private final ProjectSettings.Cache projectSettingsCache;
    volatile boolean shutdown;
    final Stats stats;
    final String tag;
    final Traits.Cache traitsCache;
    final String writeKey;
    static final Handler HANDLER = new Handler(Looper.getMainLooper()) { // from class: com.segment.analytics.Analytics.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new AssertionError("Unknown handler message received: " + message.what);
        }
    };
    static final List<String> INSTANCES = new ArrayList(1);
    static volatile Analytics singleton = null;
    static final Properties EMPTY_PROPERTIES = new Properties();

    public interface Callback<T> {
        void onReady(T t);
    }

    public static Analytics with(Context context) {
        if (singleton == null) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            synchronized (Analytics.class) {
                if (singleton == null) {
                    Builder builder = new Builder(context, Utils.getResourceString(context, WRITE_KEY_RESOURCE_IDENTIFIER));
                    try {
                        if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) != 0) {
                            builder.logLevel(LogLevel.INFO);
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                    }
                    singleton = builder.build();
                }
            }
        }
        return singleton;
    }

    public static void setSingletonInstance(Analytics analytics) {
        synchronized (Analytics.class) {
            if (singleton != null) {
                throw new IllegalStateException("Singleton instance already exists.");
            }
            singleton = analytics;
        }
    }

    Analytics(Application application, ExecutorService executorService, Stats stats, Traits.Cache cache, AnalyticsContext analyticsContext, Options options, Logger logger, String str, List<Integration.Factory> list, Client client, Cartographer cartographer, ProjectSettings.Cache cache2, String str2, int i, long j, final ExecutorService executorService2, final boolean z, CountDownLatch countDownLatch, final boolean z2, final boolean z3, BooleanPreference booleanPreference, Crypto crypto, List<Middleware> list2) {
        this.application = application;
        this.networkExecutor = executorService;
        this.stats = stats;
        this.traitsCache = cache;
        this.analyticsContext = analyticsContext;
        this.defaultOptions = options;
        this.logger = logger;
        this.tag = str;
        this.client = client;
        this.cartographer = cartographer;
        this.projectSettingsCache = cache2;
        this.writeKey = str2;
        this.flushQueueSize = i;
        this.flushIntervalInMillis = j;
        this.advertisingIdLatch = countDownLatch;
        this.optOut = booleanPreference;
        this.factories = list;
        this.analyticsExecutor = executorService2;
        this.crypto = crypto;
        this.middlewares = list2;
        namespaceSharedPreferences();
        executorService2.submit(new Runnable() { // from class: com.segment.analytics.Analytics.2
            @Override // java.lang.Runnable
            public void run() {
                Analytics.this.projectSettings = Analytics.this.getSettings();
                if (Utils.isNullOrEmpty(Analytics.this.projectSettings)) {
                    Analytics.this.projectSettings = ProjectSettings.create(new ValueMap().putValue("integrations", new ValueMap().putValue("Segment.io", new ValueMap().putValue("apiKey", Analytics.this.writeKey))));
                }
                Analytics.HANDLER.post(new Runnable() { // from class: com.segment.analytics.Analytics.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Analytics.this.performInitializeIntegrations(Analytics.this.projectSettings);
                    }
                });
            }
        });
        logger.debug("Created analytics client for project with tag:%s.", str);
        this.activityLifecycleCallback = new Application.ActivityLifecycleCallbacks() { // from class: com.segment.analytics.Analytics.3
            final AtomicBoolean trackedApplicationLifecycleEvents = new AtomicBoolean(false);

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (!this.trackedApplicationLifecycleEvents.getAndSet(true) && z) {
                    Analytics.this.trackApplicationLifecycleEvents();
                    if (z3) {
                        executorService2.submit(new Runnable() { // from class: com.segment.analytics.Analytics.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Analytics.this.trackAttributionInformation();
                            }
                        });
                    }
                }
                Analytics.this.runOnMainThread(IntegrationOperation.onActivityCreated(activity, bundle));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (z2) {
                    Analytics.this.recordScreenViews(activity);
                }
                Analytics.this.runOnMainThread(IntegrationOperation.onActivityStarted(activity));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                Analytics.this.runOnMainThread(IntegrationOperation.onActivityResumed(activity));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                Analytics.this.runOnMainThread(IntegrationOperation.onActivityPaused(activity));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                Analytics.this.runOnMainThread(IntegrationOperation.onActivityStopped(activity));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                Analytics.this.runOnMainThread(IntegrationOperation.onActivitySaveInstanceState(activity, bundle));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Analytics.this.runOnMainThread(IntegrationOperation.onActivityDestroyed(activity));
            }
        };
        application.registerActivityLifecycleCallbacks(this.activityLifecycleCallback);
    }

    void trackAttributionInformation() {
        BooleanPreference booleanPreference = new BooleanPreference(Utils.getSegmentSharedPreferences(this.application, this.tag), TRACKED_ATTRIBUTION_KEY, false);
        if (!booleanPreference.get()) {
            waitForAdvertisingId();
            Client.Connection connectionAttribution = null;
            try {
                connectionAttribution = this.client.attribution();
                this.cartographer.toJson(this.analyticsContext, new BufferedWriter(new OutputStreamWriter(connectionAttribution.f14466os)));
                track("Install Attributed", new Properties(this.cartographer.fromJson(Utils.buffer(Utils.getInputStream(connectionAttribution.connection)))));
                booleanPreference.set(true);
            } catch (IOException e) {
                this.logger.error(e, "Unable to track attribution information. Retrying on next launch.", new Object[0]);
            } finally {
                Utils.closeQuietly(connectionAttribution);
            }
        }
    }

    void trackApplicationLifecycleEvents() {
        PackageInfo packageInfo = getPackageInfo(this.application);
        String str = packageInfo.versionName;
        int i = packageInfo.versionCode;
        SharedPreferences segmentSharedPreferences = Utils.getSegmentSharedPreferences(this.application, this.tag);
        String string = segmentSharedPreferences.getString("version", null);
        int i2 = segmentSharedPreferences.getInt(BUILD_KEY, -1);
        if (i2 == -1) {
            track("Application Installed", new Properties().putValue("version", (Object) str).putValue(BUILD_KEY, (Object) Integer.valueOf(i)));
        } else if (i != i2) {
            track("Application Updated", new Properties().putValue("version", (Object) str).putValue(BUILD_KEY, (Object) Integer.valueOf(i)).putValue("previous_version", (Object) string).putValue("previous_build", (Object) Integer.valueOf(i2)));
        }
        track("Application Opened", new Properties().putValue("version", (Object) str).putValue(BUILD_KEY, (Object) Integer.valueOf(i)));
        SharedPreferences.Editor editorEdit = segmentSharedPreferences.edit();
        editorEdit.putString("version", str);
        editorEdit.putInt(BUILD_KEY, i);
        editorEdit.apply();
    }

    static PackageInfo getPackageInfo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            throw new AssertionError("Package not found: " + context.getPackageName());
        }
    }

    void recordScreenViews(Activity activity) {
        PackageManager packageManager = activity.getPackageManager();
        try {
            screen((String) null, packageManager.getActivityInfo(activity.getComponentName(), 128).loadLabel(packageManager).toString());
        } catch (PackageManager.NameNotFoundException e) {
            throw new AssertionError("Activity Not Found: " + e.toString());
        }
    }

    void runOnMainThread(final IntegrationOperation integrationOperation) {
        if (!this.shutdown) {
            this.analyticsExecutor.submit(new Runnable() { // from class: com.segment.analytics.Analytics.4
                @Override // java.lang.Runnable
                public void run() {
                    Analytics.HANDLER.post(new Runnable() { // from class: com.segment.analytics.Analytics.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Analytics.this.performRun(integrationOperation);
                        }
                    });
                }
            });
        }
    }

    public void identify(String str) {
        identify(str, null, null);
    }

    public void identify(Traits traits) {
        identify(null, traits, null);
    }

    public void identify(String str, Traits traits, final Options options) {
        assertNotShutdown();
        if (Utils.isNullOrEmpty(str) && Utils.isNullOrEmpty(traits)) {
            throw new IllegalArgumentException("Either userId or some traits must be provided.");
        }
        Traits traits2 = this.traitsCache.get();
        if (!Utils.isNullOrEmpty(str)) {
            traits2.putUserId(str);
        }
        if (!Utils.isNullOrEmpty(traits)) {
            traits2.putAll(traits);
        }
        this.traitsCache.set(traits2);
        this.analyticsContext.setTraits(traits2);
        this.analyticsExecutor.submit(new Runnable() { // from class: com.segment.analytics.Analytics.5
            @Override // java.lang.Runnable
            public void run() {
                Options options2;
                if (options == null) {
                    options2 = Analytics.this.defaultOptions;
                } else {
                    options2 = options;
                }
                Analytics.this.fillAndEnqueue(new IdentifyPayload.Builder().traits(Analytics.this.traitsCache.get()), options2);
            }
        });
    }

    public void group(String str) {
        group(str, null, null);
    }

    public void group(String str, Traits traits) {
        group(str, traits, null);
    }

    public void group(final String str, final Traits traits, final Options options) {
        assertNotShutdown();
        if (Utils.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("groupId must not be null or empty.");
        }
        this.analyticsExecutor.submit(new Runnable() { // from class: com.segment.analytics.Analytics.6
            @Override // java.lang.Runnable
            public void run() {
                Traits traits2;
                Options options2;
                if (traits == null) {
                    traits2 = new Traits();
                } else {
                    traits2 = traits;
                }
                if (options == null) {
                    options2 = Analytics.this.defaultOptions;
                } else {
                    options2 = options;
                }
                Analytics.this.fillAndEnqueue(new GroupPayload.Builder().groupId(str).traits(traits2), options2);
            }
        });
    }

    public void track(String str) {
        track(str, null, null);
    }

    public void track(String str, Properties properties) {
        track(str, properties, null);
    }

    public void track(final String str, final Properties properties, final Options options) {
        assertNotShutdown();
        if (Utils.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("event must not be null or empty.");
        }
        this.analyticsExecutor.submit(new Runnable() { // from class: com.segment.analytics.Analytics.7
            @Override // java.lang.Runnable
            public void run() {
                Options options2;
                Properties properties2;
                if (options == null) {
                    options2 = Analytics.this.defaultOptions;
                } else {
                    options2 = options;
                }
                if (properties == null) {
                    properties2 = Analytics.EMPTY_PROPERTIES;
                } else {
                    properties2 = properties;
                }
                Analytics.this.fillAndEnqueue(new TrackPayload.Builder().event(str).properties(properties2), options2);
            }
        });
    }

    public void screen(String str, String str2) {
        screen(str, str2, null, null);
    }

    public void screen(String str, String str2, Properties properties) {
        screen(str, str2, properties, null);
    }

    public void screen(String str) {
        screen(null, str, null, null);
    }

    public void screen(String str, Properties properties) {
        screen(null, str, properties, null);
    }

    public void screen(final String str, final String str2, final Properties properties, final Options options) {
        assertNotShutdown();
        if (Utils.isNullOrEmpty(str) && Utils.isNullOrEmpty(str2)) {
            throw new IllegalArgumentException("either category or name must be provided.");
        }
        this.analyticsExecutor.submit(new Runnable() { // from class: com.segment.analytics.Analytics.8
            @Override // java.lang.Runnable
            public void run() {
                Options options2;
                Properties properties2;
                if (options == null) {
                    options2 = Analytics.this.defaultOptions;
                } else {
                    options2 = options;
                }
                if (properties == null) {
                    properties2 = Analytics.EMPTY_PROPERTIES;
                } else {
                    properties2 = properties;
                }
                Analytics.this.fillAndEnqueue(new ScreenPayload.Builder().name(str2).category(str).properties(properties2), options2);
            }
        });
    }

    public void alias(String str) {
        alias(str, null);
    }

    public void alias(final String str, final Options options) {
        assertNotShutdown();
        if (Utils.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("newId must not be null or empty.");
        }
        this.analyticsExecutor.submit(new Runnable() { // from class: com.segment.analytics.Analytics.9
            @Override // java.lang.Runnable
            public void run() {
                Options options2;
                if (options == null) {
                    options2 = Analytics.this.defaultOptions;
                } else {
                    options2 = options;
                }
                Analytics.this.fillAndEnqueue(new AliasPayload.Builder().userId(str).previousId(Analytics.this.analyticsContext.traits().currentId()), options2);
            }
        });
    }

    private void waitForAdvertisingId() {
        try {
            this.advertisingIdLatch.await(15L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            this.logger.error(e, "Thread interrupted while waiting for advertising ID.", new Object[0]);
        }
        if (this.advertisingIdLatch.getCount() == 1) {
            this.logger.debug("Advertising ID may not be collected because the API did not respond within 15 seconds.", new Object[0]);
        }
    }

    void fillAndEnqueue(BasePayload.Builder<?, ?> builder, Options options) {
        waitForAdvertisingId();
        AnalyticsContext analyticsContextUnmodifiableCopy = this.analyticsContext.unmodifiableCopy();
        builder.context(analyticsContextUnmodifiableCopy);
        builder.anonymousId(analyticsContextUnmodifiableCopy.traits().anonymousId());
        builder.integrations(options.integrations());
        String strUserId = analyticsContextUnmodifiableCopy.traits().userId();
        if (!Utils.isNullOrEmpty(strUserId)) {
            builder.userId(strUserId);
        }
        enqueue(builder.build());
    }

    void enqueue(BasePayload basePayload) {
        if (!this.optOut.get()) {
            this.logger.verbose("Created payload %s.", basePayload);
            new RealMiddlewareChain(0, basePayload, this.middlewares, this).proceed(basePayload);
        }
    }

    void run(BasePayload basePayload) {
        final IntegrationOperation integrationOperationScreen;
        this.logger.verbose("Running payload %s.", basePayload);
        switch (basePayload.type()) {
            case identify:
                integrationOperationScreen = IntegrationOperation.identify((IdentifyPayload) basePayload);
                break;
            case alias:
                integrationOperationScreen = IntegrationOperation.alias((AliasPayload) basePayload);
                break;
            case group:
                integrationOperationScreen = IntegrationOperation.group((GroupPayload) basePayload);
                break;
            case track:
                integrationOperationScreen = IntegrationOperation.track((TrackPayload) basePayload);
                break;
            case screen:
                integrationOperationScreen = IntegrationOperation.screen((ScreenPayload) basePayload);
                break;
            default:
                throw new AssertionError("unknown type " + basePayload.type());
        }
        HANDLER.post(new Runnable() { // from class: com.segment.analytics.Analytics.10
            @Override // java.lang.Runnable
            public void run() {
                Analytics.this.performRun(integrationOperationScreen);
            }
        });
    }

    public void flush() {
        if (this.shutdown) {
            throw new IllegalStateException("Cannot enqueue messages after client is shutdown.");
        }
        runOnMainThread(IntegrationOperation.FLUSH);
    }

    public AnalyticsContext getAnalyticsContext() {
        return this.analyticsContext;
    }

    public StatsSnapshot getSnapshot() {
        return this.stats.createSnapshot();
    }

    public Application getApplication() {
        return this.application;
    }

    @Deprecated
    public LogLevel getLogLevel() {
        return this.logger.logLevel;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public Logger logger(String str) {
        return this.logger.subLog(str);
    }

    @Deprecated
    public void logout() {
        reset();
    }

    public void reset() {
        Utils.getSegmentSharedPreferences(this.application, this.tag).edit().clear().apply();
        this.traitsCache.delete();
        this.traitsCache.set(Traits.create());
        this.analyticsContext.setTraits(this.traitsCache.get());
        runOnMainThread(IntegrationOperation.RESET);
    }

    public void optOut(boolean z) {
        this.optOut.set(z);
    }

    public <T> void onIntegrationReady(final String str, final Callback<T> callback) {
        if (Utils.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("key cannot be null or empty.");
        }
        this.analyticsExecutor.submit(new Runnable() { // from class: com.segment.analytics.Analytics.11
            @Override // java.lang.Runnable
            public void run() {
                Analytics.HANDLER.post(new Runnable() { // from class: com.segment.analytics.Analytics.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Analytics.this.performCallback(str, callback);
                    }
                });
            }
        });
    }

    public void onIntegrationReady(BundledIntegration bundledIntegration, Callback callback) {
        if (bundledIntegration == null) {
            throw new IllegalArgumentException("integration cannot be null");
        }
        onIntegrationReady(bundledIntegration.key, callback);
    }

    public enum BundledIntegration {
        AMPLITUDE("Amplitude"),
        APPS_FLYER("AppsFlyer"),
        APPTIMIZE("Apptimize"),
        BUGSNAG("Bugsnag"),
        COUNTLY("Countly"),
        CRITTERCISM("Crittercism"),
        FLURRY("Flurry"),
        GOOGLE_ANALYTICS("Google Analytics"),
        KAHUNA("Kahuna"),
        LEANPLUM("Leanplum"),
        LOCALYTICS("Localytics"),
        MIXPANEL("Mixpanel"),
        QUANTCAST("Quantcast"),
        TAPLYTICS("Taplytics"),
        TAPSTREAM("Tapstream"),
        UXCAM("UXCam");

        final String key;

        BundledIntegration(String str) {
            this.key = str;
        }
    }

    public void shutdown() {
        if (this == singleton) {
            throw new UnsupportedOperationException("Default singleton instance cannot be shutdown.");
        }
        if (!this.shutdown) {
            this.application.unregisterActivityLifecycleCallbacks(this.activityLifecycleCallback);
            this.analyticsExecutor.shutdown();
            if (this.networkExecutor instanceof Utils.AnalyticsNetworkExecutorService) {
                this.networkExecutor.shutdown();
            }
            this.stats.shutdown();
            this.shutdown = true;
            synchronized (INSTANCES) {
                INSTANCES.remove(this.tag);
            }
        }
    }

    private void assertNotShutdown() {
        if (this.shutdown) {
            throw new IllegalStateException("Cannot enqueue messages after client is shutdown.");
        }
    }

    public enum LogLevel {
        NONE,
        INFO,
        DEBUG,
        BASIC,
        VERBOSE;

        public boolean log() {
            return this != NONE;
        }
    }

    public static class Builder {
        private final Application application;
        private ConnectionFactory connectionFactory;
        private Crypto crypto;
        private Options defaultOptions;
        private ExecutorService executor;
        private LogLevel logLevel;
        private List<Middleware> middlewares;
        private ExecutorService networkExecutor;
        private String tag;
        private String writeKey;
        private boolean collectDeviceID = true;
        private int flushQueueSize = 20;
        private long flushIntervalInMillis = 30000;
        private final List<Integration.Factory> factories = new ArrayList();
        private boolean trackApplicationLifecycleEvents = false;
        private boolean recordScreenViews = false;
        private boolean trackAttributionInformation = false;

        public Builder(Context context, String str) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            if (!Utils.hasPermission(context, "android.permission.INTERNET")) {
                throw new IllegalArgumentException("INTERNET permission is required.");
            }
            this.application = (Application) context.getApplicationContext();
            if (this.application == null) {
                throw new IllegalArgumentException("Application context must not be null.");
            }
            if (Utils.isNullOrEmpty(str)) {
                throw new IllegalArgumentException("writeKey must not be null or empty.");
            }
            this.writeKey = str;
        }

        public Builder flushQueueSize(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("flushQueueSize must be greater than or equal to zero.");
            }
            if (i > 250) {
                throw new IllegalArgumentException("flushQueueSize must be less than or equal to 250.");
            }
            this.flushQueueSize = i;
            return this;
        }

        public Builder flushInterval(long j, TimeUnit timeUnit) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("timeUnit must not be null.");
            }
            if (j <= 0) {
                throw new IllegalArgumentException("flushInterval must be greater than zero.");
            }
            this.flushIntervalInMillis = timeUnit.toMillis(j);
            return this;
        }

        public Builder collectDeviceId(boolean z) {
            this.collectDeviceID = z;
            return this;
        }

        public Builder defaultOptions(Options options) {
            if (options == null) {
                throw new IllegalArgumentException("defaultOptions must not be null.");
            }
            this.defaultOptions = new Options();
            for (Map.Entry<String, Object> entry : options.integrations().entrySet()) {
                if (entry.getValue() instanceof Boolean) {
                    this.defaultOptions.setIntegration(entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
                } else {
                    this.defaultOptions.setIntegration(entry.getKey(), true);
                }
            }
            return this;
        }

        public Builder tag(String str) {
            if (Utils.isNullOrEmpty(str)) {
                throw new IllegalArgumentException("tag must not be null or empty.");
            }
            this.tag = str;
            return this;
        }

        public Builder logLevel(LogLevel logLevel) {
            if (logLevel == null) {
                throw new IllegalArgumentException("LogLevel must not be null.");
            }
            this.logLevel = logLevel;
            return this;
        }

        @Deprecated
        public Builder disableBundledIntegrations() {
            return this;
        }

        public Builder networkExecutor(ExecutorService executorService) {
            if (executorService == null) {
                throw new IllegalArgumentException("Executor service must not be null.");
            }
            this.networkExecutor = executorService;
            return this;
        }

        public Builder connectionFactory(ConnectionFactory connectionFactory) {
            if (connectionFactory == null) {
                throw new IllegalArgumentException("ConnectionFactory must not be null.");
            }
            this.connectionFactory = connectionFactory;
            return this;
        }

        public Builder crypto(Crypto crypto) {
            if (crypto == null) {
                throw new IllegalArgumentException("Crypto must not be null.");
            }
            this.crypto = crypto;
            return this;
        }

        public Builder use(Integration.Factory factory) {
            if (factory == null) {
                throw new IllegalArgumentException("Factory must not be null.");
            }
            this.factories.add(factory);
            return this;
        }

        public Builder trackApplicationLifecycleEvents() {
            this.trackApplicationLifecycleEvents = true;
            return this;
        }

        public Builder recordScreenViews() {
            this.recordScreenViews = true;
            return this;
        }

        public Builder trackAttributionInformation() {
            this.trackAttributionInformation = true;
            return this;
        }

        public Builder middleware(Middleware middleware) {
            Utils.assertNotNull(middleware, "middleware");
            if (this.middlewares == null) {
                this.middlewares = new ArrayList();
            }
            if (this.middlewares.contains(middleware)) {
                throw new IllegalStateException("Middleware is already registered.");
            }
            this.middlewares.add(middleware);
            return this;
        }

        Builder executor(ExecutorService executorService) {
            this.executor = (ExecutorService) Utils.assertNotNull(executorService, "executor");
            return this;
        }

        public Analytics build() {
            if (Utils.isNullOrEmpty(this.tag)) {
                this.tag = this.writeKey;
            }
            synchronized (Analytics.INSTANCES) {
                if (Analytics.INSTANCES.contains(this.tag)) {
                    throw new IllegalStateException("Duplicate analytics client created with tag: " + this.tag + ". If you want to use multiple Analytics clients, use a different writeKey or set a tag via the builder during construction.");
                }
                Analytics.INSTANCES.add(this.tag);
            }
            if (this.defaultOptions == null) {
                this.defaultOptions = new Options();
            }
            if (this.logLevel == null) {
                this.logLevel = LogLevel.NONE;
            }
            if (this.networkExecutor == null) {
                this.networkExecutor = new Utils.AnalyticsNetworkExecutorService();
            }
            if (this.connectionFactory == null) {
                this.connectionFactory = new ConnectionFactory();
            }
            if (this.crypto == null) {
                this.crypto = Crypto.none();
            }
            Stats stats = new Stats();
            Cartographer cartographer = Cartographer.INSTANCE;
            Client client = new Client(this.writeKey, this.connectionFactory);
            ProjectSettings.Cache cache = new ProjectSettings.Cache(this.application, cartographer, this.tag);
            BooleanPreference booleanPreference = new BooleanPreference(Utils.getSegmentSharedPreferences(this.application, this.tag), Analytics.OPT_OUT_PREFERENCE_KEY, false);
            Traits.Cache cache2 = new Traits.Cache(this.application, cartographer, this.tag);
            if (!cache2.isSet() || cache2.get() == null) {
                cache2.set(Traits.create());
            }
            Logger loggerWith = Logger.with(this.logLevel);
            AnalyticsContext analyticsContextCreate = AnalyticsContext.create(this.application, cache2.get(), this.collectDeviceID);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            analyticsContextCreate.attachAdvertisingId(this.application, countDownLatch, loggerWith);
            ArrayList arrayList = new ArrayList(this.factories.size() + 1);
            arrayList.add(SegmentIntegration.FACTORY);
            arrayList.addAll(this.factories);
            List listImmutableCopyOf = Utils.immutableCopyOf(this.middlewares);
            ExecutorService executorServiceNewSingleThreadExecutor = this.executor;
            if (executorServiceNewSingleThreadExecutor == null) {
                executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
            }
            return new Analytics(this.application, this.networkExecutor, stats, cache2, analyticsContextCreate, this.defaultOptions, loggerWith, this.tag, Collections.unmodifiableList(arrayList), client, cartographer, cache, this.writeKey, this.flushQueueSize, this.flushIntervalInMillis, executorServiceNewSingleThreadExecutor, this.trackApplicationLifecycleEvents, countDownLatch, this.recordScreenViews, this.trackAttributionInformation, booleanPreference, this.crypto, listImmutableCopyOf);
        }
    }

    private ProjectSettings downloadSettings() {
        try {
            ProjectSettings projectSettings = (ProjectSettings) this.networkExecutor.submit(new Callable<ProjectSettings>() { // from class: com.segment.analytics.Analytics.12
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public ProjectSettings call() throws Exception {
                    Client.Connection connectionFetchSettings = null;
                    try {
                        connectionFetchSettings = Analytics.this.client.fetchSettings();
                        return ProjectSettings.create(Analytics.this.cartographer.fromJson(Utils.buffer(connectionFetchSettings.f14465is)));
                    } finally {
                        Utils.closeQuietly(connectionFetchSettings);
                    }
                }
            }).get();
            this.projectSettingsCache.set(projectSettings);
            return projectSettings;
        } catch (InterruptedException e) {
            this.logger.error(e, "Thread interrupted while fetching settings.", new Object[0]);
            return null;
        } catch (ExecutionException e2) {
            this.logger.error(e2, "Unable to fetch settings. Retrying in %s ms.", Long.valueOf(SETTINGS_RETRY_INTERVAL));
            return null;
        }
    }

    ProjectSettings getSettings() {
        ProjectSettings projectSettings = this.projectSettingsCache.get();
        if (Utils.isNullOrEmpty(projectSettings)) {
            return downloadSettings();
        }
        if (projectSettings.timestamp() + SETTINGS_REFRESH_INTERVAL <= System.currentTimeMillis()) {
            ProjectSettings projectSettingsDownloadSettings = downloadSettings();
            return !Utils.isNullOrEmpty(projectSettingsDownloadSettings) ? projectSettingsDownloadSettings : projectSettings;
        }
        return projectSettings;
    }

    void performInitializeIntegrations(ProjectSettings projectSettings) {
        ValueMap valueMapIntegrations = projectSettings.integrations();
        this.integrations = new LinkedHashMap(this.factories.size());
        for (int i = 0; i < this.factories.size(); i++) {
            Integration.Factory factory = this.factories.get(i);
            String strKey = factory.key();
            ValueMap valueMap = valueMapIntegrations.getValueMap(strKey);
            if (Utils.isNullOrEmpty(valueMap)) {
                this.logger.debug("Integration %s is not enabled.", strKey);
            } else {
                Integration<?> integrationCreate = factory.create(valueMap, this);
                if (integrationCreate == null) {
                    this.logger.info("Factory %s couldn't create integration.", factory);
                } else {
                    this.integrations.put(strKey, integrationCreate);
                    this.bundledIntegrations.put(strKey, false);
                }
            }
        }
        this.factories = null;
    }

    void performRun(IntegrationOperation integrationOperation) {
        for (Map.Entry<String, Integration<?>> entry : this.integrations.entrySet()) {
            String key = entry.getKey();
            long jNanoTime = System.nanoTime();
            integrationOperation.run(key, entry.getValue(), this.projectSettings);
            long jNanoTime2 = System.nanoTime();
            this.stats.dispatchIntegrationOperation(key, TimeUnit.NANOSECONDS.toMillis(jNanoTime2 - jNanoTime));
            this.logger.debug("Ran %s on integration %s in %d ns.", integrationOperation, key, Long.valueOf(jNanoTime2 - jNanoTime));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T> void performCallback(String str, Callback<T> callback) {
        for (Map.Entry<String, Integration<?>> entry : this.integrations.entrySet()) {
            if (str.equals(entry.getKey())) {
                callback.onReady(entry.getValue().getUnderlyingInstance());
                return;
            }
        }
    }

    private void namespaceSharedPreferences() {
        SharedPreferences segmentSharedPreferences = Utils.getSegmentSharedPreferences(this.application, this.tag);
        BooleanPreference booleanPreference = new BooleanPreference(segmentSharedPreferences, "namespaceSharedPreferences", true);
        if (booleanPreference.get()) {
            Utils.copySharedPreferences(this.application.getSharedPreferences("analytics-android", 0), segmentSharedPreferences);
            booleanPreference.set(false);
        }
    }
}
