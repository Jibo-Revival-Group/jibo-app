package com.salesforce.androidsdk.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.analytics.manager.AnalyticsManager;
import com.salesforce.androidsdk.analytics.model.DeviceAppAttributes;
import com.salesforce.androidsdk.analytics.store.EventStoreManager;
import com.salesforce.androidsdk.analytics.transform.AILTNTransform;
import com.salesforce.androidsdk.analytics.transform.Transform;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.config.AdminSettingsManager;
import com.salesforce.androidsdk.config.BootConfig;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceAnalyticsManager {

    /* JADX INFO: renamed from: a */
    private static Map<String, SalesforceAnalyticsManager> f14000a;

    /* JADX INFO: renamed from: b */
    private static boolean f14001b;

    /* JADX INFO: renamed from: c */
    private static ScheduledFuture f14002c;

    /* JADX INFO: renamed from: d */
    private static int f14003d = 8;

    /* JADX INFO: renamed from: e */
    private AnalyticsManager f14004e;

    /* JADX INFO: renamed from: f */
    private EventStoreManager f14005f;

    /* JADX INFO: renamed from: g */
    private UserAccount f14006g;

    /* JADX INFO: renamed from: h */
    private boolean f14007h;

    /* JADX INFO: renamed from: i */
    private Map<Class<? extends Transform>, Class<? extends AnalyticsPublisher>> f14008i;

    /* JADX INFO: renamed from: a */
    public static synchronized SalesforceAnalyticsManager m14292a(UserAccount userAccount) {
        return m14293a(userAccount, (String) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0016 A[Catch: all -> 0x006a, TRY_ENTER, TryCatch #0 {, blocks: (B:5:0x0006, B:9:0x0016, B:12:0x0023, B:14:0x0029, B:15:0x003b, B:17:0x003f, B:19:0x0052, B:20:0x005c, B:22:0x0060, B:27:0x006d), top: B:29:0x0006 }] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager m14293a(com.salesforce.androidsdk.accounts.UserAccount r4, java.lang.String r5) {
        /*
            r0 = 0
            java.lang.Class<com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager> r2 = com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager.class
            monitor-enter(r2)
            if (r4 != 0) goto L12
            com.salesforce.androidsdk.app.SalesforceSDKManager r1 = com.salesforce.androidsdk.app.SalesforceSDKManager.m14403a()     // Catch: java.lang.Throwable -> L6a
            com.salesforce.androidsdk.accounts.UserAccountManager r1 = r1.m14450o()     // Catch: java.lang.Throwable -> L6a
            com.salesforce.androidsdk.accounts.UserAccount r4 = r1.m14275b()     // Catch: java.lang.Throwable -> L6a
        L12:
            if (r4 != 0) goto L16
        L14:
            monitor-exit(r2)
            return r0
        L16:
            java.lang.String r1 = r4.m14247g()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r3 = "000000000000000AAA"
            boolean r3 = r3.equals(r5)     // Catch: java.lang.Throwable -> L6a
            if (r3 == 0) goto L23
            r5 = r0
        L23:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L6a
            if (r0 != 0) goto L3b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a
            r0.<init>()     // Catch: java.lang.Throwable -> L6a
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L6a
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L6a
            r1 = r0
        L3b:
            java.util.Map<java.lang.String, com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager> r0 = com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager.f14000a     // Catch: java.lang.Throwable -> L6a
            if (r0 != 0) goto L6d
            java.util.HashMap r0 = new java.util.HashMap     // Catch: java.lang.Throwable -> L6a
            r0.<init>()     // Catch: java.lang.Throwable -> L6a
            com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager.f14000a = r0     // Catch: java.lang.Throwable -> L6a
            com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager r0 = new com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager     // Catch: java.lang.Throwable -> L6a
            r0.<init>(r4, r5)     // Catch: java.lang.Throwable -> L6a
            java.util.Map<java.lang.String, com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager> r3 = com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager.f14000a     // Catch: java.lang.Throwable -> L6a
            r3.put(r1, r0)     // Catch: java.lang.Throwable -> L6a
        L50:
            if (r0 != 0) goto L5c
            com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager r0 = new com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager     // Catch: java.lang.Throwable -> L6a
            r0.<init>(r4, r5)     // Catch: java.lang.Throwable -> L6a
            java.util.Map<java.lang.String, com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager> r3 = com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager.f14000a     // Catch: java.lang.Throwable -> L6a
            r3.put(r1, r0)     // Catch: java.lang.Throwable -> L6a
        L5c:
            boolean r1 = com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager.f14001b     // Catch: java.lang.Throwable -> L6a
            if (r1 != 0) goto L14
            java.util.concurrent.ScheduledFuture r1 = m14301g()     // Catch: java.lang.Throwable -> L6a
            com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager.f14002c = r1     // Catch: java.lang.Throwable -> L6a
            r1 = 1
            com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager.f14001b = r1     // Catch: java.lang.Throwable -> L6a
            goto L14
        L6a:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L6d:
            java.util.Map<java.lang.String, com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager> r0 = com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager.f14000a     // Catch: java.lang.Throwable -> L6a
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L6a
            com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager r0 = (com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager) r0     // Catch: java.lang.Throwable -> L6a
            goto L50
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager.m14293a(com.salesforce.androidsdk.accounts.UserAccount, java.lang.String):com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager");
    }

    /* JADX INFO: renamed from: b */
    public static synchronized void m14295b(UserAccount userAccount) {
        m14296b(userAccount, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013 A[Catch: all -> 0x0055, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x0013, B:10:0x0020, B:12:0x0026, B:13:0x0038, B:15:0x003c, B:17:0x0046, B:18:0x004e), top: B:25:0x0005 }] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void m14296b(com.salesforce.androidsdk.accounts.UserAccount r4, java.lang.String r5) {
        /*
            java.lang.Class<com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager> r2 = com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager.class
            monitor-enter(r2)
            if (r4 != 0) goto L11
            com.salesforce.androidsdk.app.SalesforceSDKManager r0 = com.salesforce.androidsdk.app.SalesforceSDKManager.m14403a()     // Catch: java.lang.Throwable -> L55
            com.salesforce.androidsdk.accounts.UserAccountManager r0 = r0.m14450o()     // Catch: java.lang.Throwable -> L55
            com.salesforce.androidsdk.accounts.UserAccount r4 = r0.m14275b()     // Catch: java.lang.Throwable -> L55
        L11:
            if (r4 == 0) goto L53
            java.lang.String r0 = r4.m14247g()     // Catch: java.lang.Throwable -> L55
            java.lang.String r1 = "000000000000000AAA"
            boolean r1 = r1.equals(r5)     // Catch: java.lang.Throwable -> L55
            if (r1 == 0) goto L20
            r5 = 0
        L20:
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L55
            if (r1 != 0) goto L58
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L55
            r1.<init>()     // Catch: java.lang.Throwable -> L55
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch: java.lang.Throwable -> L55
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch: java.lang.Throwable -> L55
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L55
            r1 = r0
        L38:
            java.util.Map<java.lang.String, com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager> r0 = com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager.f14000a     // Catch: java.lang.Throwable -> L55
            if (r0 == 0) goto L53
            java.util.Map<java.lang.String, com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager> r0 = com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager.f14000a     // Catch: java.lang.Throwable -> L55
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L55
            com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager r0 = (com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager) r0     // Catch: java.lang.Throwable -> L55
            if (r0 == 0) goto L4e
            com.salesforce.androidsdk.analytics.manager.AnalyticsManager r3 = r0.f14004e     // Catch: java.lang.Throwable -> L55
            r3.m14328a()     // Catch: java.lang.Throwable -> L55
            r0.m14300f()     // Catch: java.lang.Throwable -> L55
        L4e:
            java.util.Map<java.lang.String, com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager> r0 = com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager.f14000a     // Catch: java.lang.Throwable -> L55
            r0.remove(r1)     // Catch: java.lang.Throwable -> L55
        L53:
            monitor-exit(r2)
            return
        L55:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L58:
            r1 = r0
            goto L38
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager.m14296b(com.salesforce.androidsdk.accounts.UserAccount, java.lang.String):void");
    }

    /* JADX INFO: renamed from: a */
    public static synchronized void m14294a(String str, String str2) {
        Set<String> setKeySet;
        SalesforceSDKManager salesforceSDKManagerM14403a = SalesforceSDKManager.m14403a();
        String strM14434c = salesforceSDKManagerM14403a.m14434c(str);
        String strM14434c2 = salesforceSDKManagerM14403a.m14434c(str2);
        if (f14000a != null && (setKeySet = f14000a.keySet()) != null) {
            Iterator<String> it = setKeySet.iterator();
            while (it.hasNext()) {
                SalesforceAnalyticsManager salesforceAnalyticsManager = f14000a.get(it.next());
                if (salesforceAnalyticsManager != null) {
                    salesforceAnalyticsManager.f14004e.m14330a(strM14434c, strM14434c2);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public AnalyticsManager m14302a() {
        return this.f14004e;
    }

    /* JADX INFO: renamed from: a */
    public void m14304a(boolean z) {
        if (z) {
            SalesforceSDKManager.m14403a().m14439e("AI");
        } else {
            SalesforceSDKManager.m14403a().m14441f("AI");
        }
        m14297b(z);
        this.f14005f.m14385a(z);
    }

    /* JADX INFO: renamed from: b */
    public void m14305b() {
        String strA = new AdminSettingsManager().m14496a("ailtn_enabled", this.f14006g);
        if (!TextUtils.isEmpty(strA)) {
            if (!Boolean.parseBoolean(strA)) {
                m14304a(false);
            } else {
                m14304a(true);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public synchronized void m14306c() {
        m14303a(this.f14005f.m14381a());
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008f  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void m14303a(java.util.List<com.salesforce.androidsdk.analytics.model.InstrumentationEvent> r11) throws java.lang.IllegalAccessException, java.lang.InstantiationException {
        /*
            r10 = this;
            r3 = 0
            monitor-enter(r10)
            if (r11 == 0) goto La
            int r0 = r11.size()     // Catch: java.lang.Throwable -> L57
            if (r0 != 0) goto Lc
        La:
            monitor-exit(r10)
            return
        Lc:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L57
            r5.<init>()     // Catch: java.lang.Throwable -> L57
            r2 = 1
            java.util.Map<java.lang.Class<? extends com.salesforce.androidsdk.analytics.transform.Transform>, java.lang.Class<? extends com.salesforce.androidsdk.analytics.AnalyticsPublisher>> r0 = r10.f14008i     // Catch: java.lang.Throwable -> L57
            java.util.Set r0 = r0.keySet()     // Catch: java.lang.Throwable -> L57
            java.util.Iterator r6 = r0.iterator()     // Catch: java.lang.Throwable -> L57
        L1c:
            boolean r0 = r6.hasNext()     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L86
            java.lang.Object r0 = r6.next()     // Catch: java.lang.Throwable -> L57
            java.lang.Class r0 = (java.lang.Class) r0     // Catch: java.lang.Throwable -> L57
            java.lang.Object r1 = r0.newInstance()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            com.salesforce.androidsdk.analytics.transform.Transform r1 = (com.salesforce.androidsdk.analytics.transform.Transform) r1     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            r4 = r1
        L2f:
            if (r4 == 0) goto L8f
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L57
            r7.<init>()     // Catch: java.lang.Throwable -> L57
            java.util.Iterator r8 = r11.iterator()     // Catch: java.lang.Throwable -> L57
        L3a:
            boolean r1 = r8.hasNext()     // Catch: java.lang.Throwable -> L57
            if (r1 == 0) goto L64
            java.lang.Object r1 = r8.next()     // Catch: java.lang.Throwable -> L57
            com.salesforce.androidsdk.analytics.model.InstrumentationEvent r1 = (com.salesforce.androidsdk.analytics.model.InstrumentationEvent) r1     // Catch: java.lang.Throwable -> L57
            java.lang.String r9 = r1.m14335a()     // Catch: java.lang.Throwable -> L57
            r5.add(r9)     // Catch: java.lang.Throwable -> L57
            org.json.JSONObject r1 = r4.mo14392a(r1)     // Catch: java.lang.Throwable -> L57
            if (r1 == 0) goto L3a
            r7.put(r1)     // Catch: java.lang.Throwable -> L57
            goto L3a
        L57:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        L5a:
            r1 = move-exception
            java.lang.String r4 = "AnalyticsManager"
            java.lang.String r7 = "Exception thrown while instantiating class"
            com.salesforce.androidsdk.util.SalesforceSDKLogger.m15016a(r4, r7, r1)     // Catch: java.lang.Throwable -> L57
            r4 = r3
            goto L2f
        L64:
            java.util.Map<java.lang.Class<? extends com.salesforce.androidsdk.analytics.transform.Transform>, java.lang.Class<? extends com.salesforce.androidsdk.analytics.AnalyticsPublisher>> r1 = r10.f14008i     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L7c
            java.lang.Object r0 = r1.get(r0)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L7c
            java.lang.Class r0 = (java.lang.Class) r0     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L7c
            java.lang.Object r0 = r0.newInstance()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L7c
            com.salesforce.androidsdk.analytics.AnalyticsPublisher r0 = (com.salesforce.androidsdk.analytics.AnalyticsPublisher) r0     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L7c
        L72:
            if (r0 == 0) goto L8f
            boolean r0 = r0.mo14281a(r7)     // Catch: java.lang.Throwable -> L57
            if (r2 == 0) goto L8f
        L7a:
            r2 = r0
            goto L1c
        L7c:
            r0 = move-exception
            java.lang.String r1 = "AnalyticsManager"
            java.lang.String r4 = "Exception thrown while instantiating class"
            com.salesforce.androidsdk.util.SalesforceSDKLogger.m15016a(r1, r4, r0)     // Catch: java.lang.Throwable -> L57
            r0 = r3
            goto L72
        L86:
            if (r2 == 0) goto La
            com.salesforce.androidsdk.analytics.store.EventStoreManager r0 = r10.f14005f     // Catch: java.lang.Throwable -> L57
            r0.m14388b(r5)     // Catch: java.lang.Throwable -> L57
            goto La
        L8f:
            r0 = r2
            goto L7a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager.m14303a(java.util.List):void");
    }

    private SalesforceAnalyticsManager(UserAccount userAccount, String str) {
        this.f14006g = userAccount;
        DeviceAppAttributes deviceAppAttributesM14298d = m14298d();
        SalesforceSDKManager salesforceSDKManagerM14403a = SalesforceSDKManager.m14403a();
        this.f14004e = new AnalyticsManager(userAccount.m14262v(), salesforceSDKManagerM14403a.m14446k(), salesforceSDKManagerM14403a.m14434c(salesforceSDKManagerM14403a.m14455t()), deviceAppAttributesM14298d);
        this.f14005f = this.f14004e.m14333d();
        this.f14008i = new HashMap();
        this.f14008i.put(AILTNTransform.class, AILTNPublisher.class);
        m14299e();
        m14304a(this.f14007h);
    }

    /* JADX INFO: renamed from: d */
    private DeviceAppAttributes m14298d() {
        SalesforceSDKManager salesforceSDKManagerM14403a = SalesforceSDKManager.m14403a();
        Context contextM14446k = salesforceSDKManagerM14403a.m14446k();
        String str = "";
        String strM14416c = "";
        try {
            str = contextM14446k.getPackageManager().getPackageInfo(contextM14446k.getPackageName(), 0).versionName;
            strM14416c = SalesforceSDKManager.m14416c();
        } catch (PackageManager.NameNotFoundException e) {
            SalesforceSDKLogger.m15018b("AnalyticsManager", "Could not read package info", e);
        } catch (Resources.NotFoundException e2) {
            SalesforceSDKLogger.m15018b("AnalyticsManager", "Could not read package info", e2);
        }
        return new DeviceAppAttributes(str, strM14416c, Build.VERSION.RELEASE, "android", salesforceSDKManagerM14403a.m14461z(), "5.3.0", Build.MODEL, salesforceSDKManagerM14403a.m14442g(), BootConfig.m14502a(contextM14446k).m14508a());
    }

    /* JADX INFO: renamed from: b */
    private synchronized void m14297b(boolean z) {
        SharedPreferences.Editor editorEdit = SalesforceSDKManager.m14403a().m14446k().getSharedPreferences("ailtn_policy" + this.f14006g.m14261u(), 0).edit();
        editorEdit.putBoolean("ailtn_enabled", z);
        editorEdit.commit();
        this.f14007h = z;
    }

    /* JADX INFO: renamed from: e */
    private void m14299e() {
        SharedPreferences sharedPreferences = SalesforceSDKManager.m14403a().m14446k().getSharedPreferences("ailtn_policy" + this.f14006g.m14261u(), 0);
        if (!sharedPreferences.contains("ailtn_enabled")) {
            m14297b(true);
        }
        this.f14007h = sharedPreferences.getBoolean("ailtn_enabled", true);
    }

    /* JADX INFO: renamed from: f */
    private void m14300f() {
        SharedPreferences.Editor editorEdit = SalesforceSDKManager.m14403a().m14446k().getSharedPreferences("ailtn_policy" + this.f14006g.m14261u(), 0).edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: g */
    private static ScheduledFuture m14301g() {
        return Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Runnable() { // from class: com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager.1
            @Override // java.lang.Runnable
            public void run() {
                AnalyticsPublisherService.m14287a(SalesforceSDKManager.m14403a().m14446k());
            }
        }, 0L, f14003d, TimeUnit.HOURS);
    }
}
