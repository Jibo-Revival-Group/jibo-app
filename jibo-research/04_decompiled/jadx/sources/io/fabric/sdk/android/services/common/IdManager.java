package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class IdManager {

    /* JADX INFO: renamed from: d */
    private static final Pattern f14583d = Pattern.compile("[^\\p{Alnum}]");

    /* JADX INFO: renamed from: e */
    private static final String f14584e = Pattern.quote("/");

    /* JADX INFO: renamed from: a */
    AdvertisingInfoProvider f14585a;

    /* JADX INFO: renamed from: b */
    AdvertisingInfo f14586b;

    /* JADX INFO: renamed from: c */
    boolean f14587c;

    /* JADX INFO: renamed from: f */
    private final ReentrantLock f14588f = new ReentrantLock();

    /* JADX INFO: renamed from: g */
    private final InstallerPackageNameProvider f14589g;

    /* JADX INFO: renamed from: h */
    private final boolean f14590h;

    /* JADX INFO: renamed from: i */
    private final boolean f14591i;

    /* JADX INFO: renamed from: j */
    private final Context f14592j;

    /* JADX INFO: renamed from: k */
    private final String f14593k;

    /* JADX INFO: renamed from: l */
    private final String f14594l;

    /* JADX INFO: renamed from: m */
    private final Collection<Kit> f14595m;

    public enum DeviceIdentifierType {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(101),
        ANDROID_SERIAL(102),
        ANDROID_ADVERTISING_ID(103);

        public final int protobufIndex;

        DeviceIdentifierType(int i) {
            this.protobufIndex = i;
        }
    }

    public IdManager(Context context, String str, String str2, Collection<Kit> collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        if (collection == null) {
            throw new IllegalArgumentException("kits must not be null");
        }
        this.f14592j = context;
        this.f14593k = str;
        this.f14594l = str2;
        this.f14595m = collection;
        this.f14589g = new InstallerPackageNameProvider();
        this.f14585a = new AdvertisingInfoProvider(context);
        this.f14590h = CommonUtils.m15191a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
        if (!this.f14590h) {
            Fabric.m15085h().mo15063a("Fabric", "Device ID collection disabled for " + context.getPackageName());
        }
        this.f14591i = CommonUtils.m15191a(context, "com.crashlytics.CollectUserIdentifiers", true);
        if (!this.f14591i) {
            Fabric.m15085h().mo15063a("Fabric", "User information collection disabled for " + context.getPackageName());
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m15225a() {
        return this.f14591i;
    }

    /* JADX INFO: renamed from: a */
    private String m15222a(String str) {
        if (str == null) {
            return null;
        }
        return f14583d.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    /* JADX INFO: renamed from: b */
    public String m15226b() {
        String str = this.f14594l;
        if (str == null) {
            SharedPreferences sharedPreferencesM15174a = CommonUtils.m15174a(this.f14592j);
            String string = sharedPreferencesM15174a.getString("crashlytics.installation.id", null);
            if (string == null) {
                return m15221a(sharedPreferencesM15174a);
            }
            return string;
        }
        return str;
    }

    /* JADX INFO: renamed from: c */
    public String m15227c() {
        return this.f14593k;
    }

    /* JADX INFO: renamed from: d */
    public String m15228d() {
        return m15229e() + "/" + m15230f();
    }

    /* JADX INFO: renamed from: e */
    public String m15229e() {
        return m15224b(Build.VERSION.RELEASE);
    }

    /* JADX INFO: renamed from: f */
    public String m15230f() {
        return m15224b(Build.VERSION.INCREMENTAL);
    }

    /* JADX INFO: renamed from: g */
    public String m15231g() {
        return String.format(Locale.US, "%s/%s", m15224b(Build.MANUFACTURER), m15224b(Build.MODEL));
    }

    /* JADX INFO: renamed from: b */
    private String m15224b(String str) {
        return str.replaceAll(f14584e, "");
    }

    /* JADX INFO: renamed from: h */
    public String m15232h() {
        if (!this.f14590h) {
            return "";
        }
        String strM15238n = m15238n();
        if (strM15238n == null) {
            SharedPreferences sharedPreferencesM15174a = CommonUtils.m15174a(this.f14592j);
            String string = sharedPreferencesM15174a.getString("crashlytics.installation.id", null);
            if (string == null) {
                return m15221a(sharedPreferencesM15174a);
            }
            return string;
        }
        return strM15238n;
    }

    /* JADX INFO: renamed from: a */
    private String m15221a(SharedPreferences sharedPreferences) {
        this.f14588f.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string == null) {
                string = m15222a(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            return string;
        } finally {
            this.f14588f.unlock();
        }
    }

    /* JADX INFO: renamed from: i */
    public Map<DeviceIdentifierType, String> m15233i() {
        HashMap map = new HashMap();
        for (Object obj : this.f14595m) {
            if (obj instanceof DeviceIdentifierProvider) {
                for (Map.Entry<DeviceIdentifierType, String> entry : ((DeviceIdentifierProvider) obj).mo5697e().entrySet()) {
                    m15223a(map, entry.getKey(), entry.getValue());
                }
            }
        }
        m15223a(map, DeviceIdentifierType.ANDROID_ID, m15238n());
        m15223a(map, DeviceIdentifierType.ANDROID_ADVERTISING_ID, m15237m());
        return Collections.unmodifiableMap(map);
    }

    /* JADX INFO: renamed from: j */
    public String m15234j() {
        return this.f14589g.m15239a(this.f14592j);
    }

    /* JADX INFO: renamed from: k */
    synchronized AdvertisingInfo m15235k() {
        if (!this.f14587c) {
            this.f14586b = this.f14585a.m15152a();
            this.f14587c = true;
        }
        return this.f14586b;
    }

    /* JADX INFO: renamed from: l */
    public Boolean m15236l() {
        AdvertisingInfo advertisingInfoM15235k;
        if (!this.f14590h || (advertisingInfoM15235k = m15235k()) == null) {
            return null;
        }
        return Boolean.valueOf(advertisingInfoM15235k.f14558b);
    }

    /* JADX INFO: renamed from: m */
    public String m15237m() {
        AdvertisingInfo advertisingInfoM15235k;
        if (!this.f14590h || (advertisingInfoM15235k = m15235k()) == null) {
            return null;
        }
        return advertisingInfoM15235k.f14557a;
    }

    /* JADX INFO: renamed from: a */
    private void m15223a(Map<DeviceIdentifierType, String> map, DeviceIdentifierType deviceIdentifierType, String str) {
        if (str != null) {
            map.put(deviceIdentifierType, str);
        }
    }

    /* JADX INFO: renamed from: n */
    public String m15238n() {
        if (!this.f14590h) {
            return null;
        }
        String string = Settings.Secure.getString(this.f14592j.getContentResolver(), "android_id");
        if ("9774d56d682e549c".equals(string)) {
            return null;
        }
        return m15222a(string);
    }
}
