package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.mixpanel.android.util.MPLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class SystemInformation {

    /* JADX INFO: renamed from: h */
    private static SystemInformation f12020h;

    /* JADX INFO: renamed from: i */
    private static final Object f12021i = new Object();

    /* JADX INFO: renamed from: a */
    private final Context f12022a;

    /* JADX INFO: renamed from: b */
    private final Boolean f12023b;

    /* JADX INFO: renamed from: c */
    private final Boolean f12024c;

    /* JADX INFO: renamed from: d */
    private final DisplayMetrics f12025d;

    /* JADX INFO: renamed from: e */
    private final String f12026e;

    /* JADX INFO: renamed from: f */
    private final Integer f12027f;

    /* JADX INFO: renamed from: g */
    private final String f12028g;

    /* JADX INFO: renamed from: a */
    static SystemInformation m11933a(Context context) {
        synchronized (f12021i) {
            if (f12020h == null) {
                f12020h = new SystemInformation(context.getApplicationContext());
            }
        }
        return f12020h;
    }

    private SystemInformation(Context context) throws NoSuchMethodException {
        String str;
        String str2;
        Integer numValueOf;
        String string;
        Method method;
        Boolean bool;
        Boolean bool2 = null;
        this.f12022a = context;
        PackageManager packageManager = this.f12022a.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(this.f12022a.getPackageName(), 0);
            str2 = packageInfo.versionName;
            try {
                numValueOf = Integer.valueOf(packageInfo.versionCode);
            } catch (PackageManager.NameNotFoundException e) {
                str = str2;
                MPLog.m12028d("MixpanelAPI.SysInfo", "System information constructed with a context that apparently doesn't exist.");
                str2 = str;
                numValueOf = null;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            str = null;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.labelRes;
        this.f12026e = str2;
        this.f12027f = numValueOf;
        if (i == 0) {
            string = applicationInfo.nonLocalizedLabel == null ? "Misc" : applicationInfo.nonLocalizedLabel.toString();
        } else {
            string = context.getString(i);
        }
        this.f12028g = string;
        try {
            method = packageManager.getClass().getMethod("hasSystemFeature", String.class);
        } catch (NoSuchMethodException e3) {
            method = null;
        }
        if (method != null) {
            try {
                bool = (Boolean) method.invoke(packageManager, "android.hardware.nfc");
                try {
                    bool2 = (Boolean) method.invoke(packageManager, "android.hardware.telephony");
                } catch (IllegalAccessException e4) {
                    MPLog.m12028d("MixpanelAPI.SysInfo", "System version appeared to support PackageManager.hasSystemFeature, but we were unable to call it.");
                } catch (InvocationTargetException e5) {
                    MPLog.m12028d("MixpanelAPI.SysInfo", "System version appeared to support PackageManager.hasSystemFeature, but we were unable to call it.");
                }
            } catch (IllegalAccessException e6) {
                bool = null;
            } catch (InvocationTargetException e7) {
                bool = null;
            }
        } else {
            bool = null;
        }
        this.f12023b = bool;
        this.f12024c = bool2;
        this.f12025d = new DisplayMetrics();
        ((WindowManager) this.f12022a.getSystemService("window")).getDefaultDisplay().getMetrics(this.f12025d);
    }

    /* JADX INFO: renamed from: a */
    public String m11934a() {
        return this.f12026e;
    }

    /* JADX INFO: renamed from: b */
    public Integer m11935b() {
        return this.f12027f;
    }

    /* JADX INFO: renamed from: c */
    public String m11936c() {
        return this.f12028g;
    }

    /* JADX INFO: renamed from: d */
    public boolean m11937d() {
        return this.f12023b.booleanValue();
    }

    /* JADX INFO: renamed from: e */
    public boolean m11938e() {
        return this.f12024c.booleanValue();
    }

    /* JADX INFO: renamed from: f */
    public DisplayMetrics m11939f() {
        return this.f12025d;
    }

    /* JADX INFO: renamed from: g */
    public String m11940g() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f12022a.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getNetworkOperatorName();
    }

    /* JADX INFO: renamed from: h */
    public Boolean m11941h() {
        if (this.f12022a.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return null;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f12022a.getSystemService("connectivity")).getActiveNetworkInfo();
        return Boolean.valueOf(activeNetworkInfo != null && activeNetworkInfo.getType() == 1 && activeNetworkInfo.isConnected());
    }

    @SuppressLint({"MissingPermission"})
    /* JADX INFO: renamed from: i */
    public Boolean m11942i() {
        BluetoothAdapter defaultAdapter;
        try {
            if (this.f12022a.getPackageManager().checkPermission("android.permission.BLUETOOTH", this.f12022a.getPackageName()) != 0 || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null) {
                return null;
            }
            return Boolean.valueOf(defaultAdapter.isEnabled());
        } catch (NoClassDefFoundError e) {
            return null;
        } catch (SecurityException e2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: j */
    public String m11943j() {
        if (Build.VERSION.SDK_INT >= 18 && this.f12022a.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return "ble";
        }
        if (!this.f12022a.getPackageManager().hasSystemFeature("android.hardware.bluetooth")) {
            return "none";
        }
        return "classic";
    }
}
