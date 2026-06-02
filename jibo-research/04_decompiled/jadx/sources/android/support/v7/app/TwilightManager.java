package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
class TwilightManager {

    /* JADX INFO: renamed from: a */
    private static TwilightManager f3048a;

    /* JADX INFO: renamed from: b */
    private final Context f3049b;

    /* JADX INFO: renamed from: c */
    private final LocationManager f3050c;

    /* JADX INFO: renamed from: d */
    private final TwilightState f3051d = new TwilightState();

    /* JADX INFO: renamed from: a */
    static TwilightManager m3375a(Context context) {
        if (f3048a == null) {
            Context applicationContext = context.getApplicationContext();
            f3048a = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService(SkillsJsonParser.TYPE_LOCATION));
        }
        return f3048a;
    }

    TwilightManager(Context context, LocationManager locationManager) {
        this.f3049b = context;
        this.f3050c = locationManager;
    }

    /* JADX INFO: renamed from: a */
    boolean m3379a() {
        TwilightState twilightState = this.f3051d;
        if (m3378c()) {
            return twilightState.f3052a;
        }
        Location locationM3377b = m3377b();
        if (locationM3377b != null) {
            m3376a(locationM3377b);
            return twilightState.f3052a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    @SuppressLint({"MissingPermission"})
    /* JADX INFO: renamed from: b */
    private Location m3377b() {
        Location locationM3374a = PermissionChecker.m1896a(this.f3049b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? m3374a("network") : null;
        Location locationM3374a2 = PermissionChecker.m1896a(this.f3049b, "android.permission.ACCESS_FINE_LOCATION") == 0 ? m3374a("gps") : null;
        if (locationM3374a2 != null && locationM3374a != null) {
            return locationM3374a2.getTime() > locationM3374a.getTime() ? locationM3374a2 : locationM3374a;
        }
        if (locationM3374a2 == null) {
            locationM3374a2 = locationM3374a;
        }
        return locationM3374a2;
    }

    /* JADX INFO: renamed from: a */
    private Location m3374a(String str) {
        try {
            if (this.f3050c.isProviderEnabled(str)) {
                return this.f3050c.getLastKnownLocation(str);
            }
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    private boolean m3378c() {
        return this.f3051d.f3057f > System.currentTimeMillis();
    }

    /* JADX INFO: renamed from: a */
    private void m3376a(Location location) {
        long j;
        long j2;
        TwilightState twilightState = this.f3051d;
        long jCurrentTimeMillis = System.currentTimeMillis();
        TwilightCalculator twilightCalculatorM3372a = TwilightCalculator.m3372a();
        twilightCalculatorM3372a.m3373a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j3 = twilightCalculatorM3372a.f3045a;
        twilightCalculatorM3372a.m3373a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = twilightCalculatorM3372a.f3047c == 1;
        long j4 = twilightCalculatorM3372a.f3046b;
        long j5 = twilightCalculatorM3372a.f3045a;
        twilightCalculatorM3372a.m3373a(86400000 + jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        long j6 = twilightCalculatorM3372a.f3046b;
        if (j4 == -1 || j5 == -1) {
            j = 43200000 + jCurrentTimeMillis;
        } else {
            if (jCurrentTimeMillis > j5) {
                j2 = 0 + j6;
            } else if (jCurrentTimeMillis > j4) {
                j2 = 0 + j5;
            } else {
                j2 = 0 + j4;
            }
            j = j2 + 60000;
        }
        twilightState.f3052a = z;
        twilightState.f3053b = j3;
        twilightState.f3054c = j4;
        twilightState.f3055d = j5;
        twilightState.f3056e = j6;
        twilightState.f3057f = j;
    }

    private static class TwilightState {

        /* JADX INFO: renamed from: a */
        boolean f3052a;

        /* JADX INFO: renamed from: b */
        long f3053b;

        /* JADX INFO: renamed from: c */
        long f3054c;

        /* JADX INFO: renamed from: d */
        long f3055d;

        /* JADX INFO: renamed from: e */
        long f3056e;

        /* JADX INFO: renamed from: f */
        long f3057f;

        TwilightState() {
        }
    }
}
