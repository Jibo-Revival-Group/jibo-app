package com.google.firebase.messaging;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.zzfjr;
import com.google.android.gms.internal.zzfkt;
import com.google.android.gms.internal.zzfku;
import com.google.android.gms.measurement.AppMeasurement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzc {
    /* JADX INFO: renamed from: a */
    private static Bundle m9221a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        return bundle;
    }

    /* JADX INFO: renamed from: a */
    private static zzfku m9222a(byte[] bArr) {
        try {
            return zzfku.m8730a(bArr);
        } catch (zzfjr e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static AppMeasurement m9223a(Context context) {
        try {
            return AppMeasurement.getInstance(context);
        } catch (NoClassDefFoundError e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static Object m9224a(zzfku zzfkuVar, String str, zzb zzbVar) {
        Object objNewInstance;
        Exception e;
        try {
            Class<?> cls = Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
            Bundle bundleM9221a = m9221a(zzfkuVar.f8024a, zzfkuVar.f8025b);
            objNewInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            try {
                cls.getField("mOrigin").set(objNewInstance, str);
                cls.getField("mCreationTimestamp").set(objNewInstance, Long.valueOf(zzfkuVar.f8026c));
                cls.getField("mName").set(objNewInstance, zzfkuVar.f8024a);
                cls.getField("mValue").set(objNewInstance, zzfkuVar.f8025b);
                cls.getField("mTriggerEventName").set(objNewInstance, TextUtils.isEmpty(zzfkuVar.f8027d) ? null : zzfkuVar.f8027d);
                cls.getField("mTimedOutEventName").set(objNewInstance, !TextUtils.isEmpty(zzfkuVar.f8033j) ? zzfkuVar.f8033j : zzbVar.m9218b());
                cls.getField("mTimedOutEventParams").set(objNewInstance, bundleM9221a);
                cls.getField("mTriggerTimeout").set(objNewInstance, Long.valueOf(zzfkuVar.f8028e));
                cls.getField("mTriggeredEventName").set(objNewInstance, !TextUtils.isEmpty(zzfkuVar.f8031h) ? zzfkuVar.f8031h : zzbVar.m9217a());
                cls.getField("mTriggeredEventParams").set(objNewInstance, bundleM9221a);
                cls.getField("mTimeToLive").set(objNewInstance, Long.valueOf(zzfkuVar.f8029f));
                cls.getField("mExpiredEventName").set(objNewInstance, !TextUtils.isEmpty(zzfkuVar.f8034k) ? zzfkuVar.f8034k : zzbVar.m9219c());
                cls.getField("mExpiredEventParams").set(objNewInstance, bundleM9221a);
            } catch (Exception e2) {
                e = e2;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            }
        } catch (Exception e3) {
            objNewInstance = null;
            e = e3;
        }
        return objNewInstance;
    }

    /* JADX INFO: renamed from: a */
    private static String m9225a(zzfku zzfkuVar, zzb zzbVar) {
        return (zzfkuVar == null || TextUtils.isEmpty(zzfkuVar.f8032i)) ? zzbVar.m9220d() : zzfkuVar.f8032i;
    }

    /* JADX INFO: renamed from: a */
    private static String m9226a(Object obj) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        return (String) Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mName").get(obj);
    }

    /* JADX INFO: renamed from: a */
    private static List<Object> m9227a(AppMeasurement appMeasurement, String str) {
        List<Object> list;
        ArrayList arrayList = new ArrayList();
        try {
            Method declaredMethod = AppMeasurement.class.getDeclaredMethod("getConditionalUserProperties", String.class, String.class);
            declaredMethod.setAccessible(true);
            list = (List) declaredMethod.invoke(appMeasurement, str, "");
        } catch (Exception e) {
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            list = arrayList;
        }
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(str).length() + 55).append("Number of currently set _Es for origin: ").append(str).append(" is ").append(list.size()).toString());
        }
        return list;
    }

    /* JADX INFO: renamed from: a */
    private static void m9228a(Context context, String str, String str2, String str3, String str4) {
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            String strValueOf = String.valueOf(str);
            Log.v("FirebaseAbtUtil", strValueOf.length() != 0 ? "_CE(experimentId) called by ".concat(strValueOf) : new String("_CE(experimentId) called by "));
        }
        if (m9233b(context)) {
            AppMeasurement appMeasurementM9223a = m9223a(context);
            try {
                Method declaredMethod = AppMeasurement.class.getDeclaredMethod("clearConditionalUserProperty", String.class, String.class, Bundle.class);
                declaredMethod.setAccessible(true);
                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                    Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(str2).length() + 17 + String.valueOf(str3).length()).append("Clearing _E: [").append(str2).append(", ").append(str3).append("]").toString());
                }
                declaredMethod.invoke(appMeasurementM9223a, str2, str4, m9221a(str2, str3));
            } catch (Exception e) {
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m9229a(Context context, String str, byte[] bArr, zzb zzbVar, int i) {
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            String strValueOf = String.valueOf(str);
            Log.v("FirebaseAbtUtil", strValueOf.length() != 0 ? "_SE called by ".concat(strValueOf) : new String("_SE called by "));
        }
        if (m9233b(context)) {
            AppMeasurement appMeasurementM9223a = m9223a(context);
            zzfku zzfkuVarM9222a = m9222a(bArr);
            if (zzfkuVarM9222a == null) {
                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                    Log.v("FirebaseAbtUtil", "_SE failed; either _P was not set, or we couldn't deserialize the _P.");
                    return;
                }
                return;
            }
            try {
                Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
                boolean z = false;
                for (Object obj : m9227a(appMeasurementM9223a, str)) {
                    String strM9226a = m9226a(obj);
                    String strM9232b = m9232b(obj);
                    long jLongValue = ((Long) Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mCreationTimestamp").get(obj)).longValue();
                    if (zzfkuVarM9222a.f8024a.equals(strM9226a) && zzfkuVarM9222a.f8025b.equals(strM9232b)) {
                        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                            Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(strM9226a).length() + 23 + String.valueOf(strM9232b).length()).append("_E is already set. [").append(strM9226a).append(", ").append(strM9232b).append("]").toString());
                        }
                        z = true;
                    } else {
                        boolean z2 = false;
                        zzfkt[] zzfktVarArr = zzfkuVarM9222a.f8036m;
                        int length = zzfktVarArr.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            }
                            if (zzfktVarArr[i2].f8023a.equals(strM9226a)) {
                                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                                    Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(strM9226a).length() + 33 + String.valueOf(strM9232b).length()).append("_E is found in the _OE list. [").append(strM9226a).append(", ").append(strM9232b).append("]").toString());
                                }
                                z2 = true;
                            } else {
                                i2++;
                            }
                        }
                        if (!z2) {
                            if (zzfkuVarM9222a.f8026c > jLongValue) {
                                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                                    Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(strM9226a).length() + 115 + String.valueOf(strM9232b).length()).append("Clearing _E as it was not in the _OE list, andits start time is older than the start time of the _E to be set. [").append(strM9226a).append(", ").append(strM9232b).append("]").toString());
                                }
                                m9228a(context, str, strM9226a, strM9232b, m9225a(zzfkuVarM9222a, zzbVar));
                            } else if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                                Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(strM9226a).length() + 109 + String.valueOf(strM9232b).length()).append("_E was not found in the _OE list, but not clearing it as it has a new start time than the _E to be set.  [").append(strM9226a).append(", ").append(strM9232b).append("]").toString());
                            }
                        }
                    }
                }
                if (!z) {
                    m9230a(appMeasurementM9223a, context, str, zzfkuVarM9222a, zzbVar, 1);
                } else if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                    String str2 = zzfkuVarM9222a.f8024a;
                    String str3 = zzfkuVarM9222a.f8025b;
                    Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(str2).length() + 44 + String.valueOf(str3).length()).append("_E is already set. Not setting it again [").append(str2).append(", ").append(str3).append("]").toString());
                }
            } catch (Exception e) {
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m9230a(AppMeasurement appMeasurement, Context context, String str, zzfku zzfkuVar, zzb zzbVar, int i) {
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            String str2 = zzfkuVar.f8024a;
            String str3 = zzfkuVar.f8025b;
            Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(str2).length() + 7 + String.valueOf(str3).length()).append("_SEI: ").append(str2).append(" ").append(str3).toString());
        }
        try {
            Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
            List<Object> listM9227a = m9227a(appMeasurement, str);
            if (m9227a(appMeasurement, str).size() >= m9231b(appMeasurement, str)) {
                if ((zzfkuVar.f8035l != 0 ? zzfkuVar.f8035l : 1) != 1) {
                    if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                        String str4 = zzfkuVar.f8024a;
                        String str5 = zzfkuVar.f8025b;
                        Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(str4).length() + 44 + String.valueOf(str5).length()).append("_E won't be set due to overflow policy. [").append(str4).append(", ").append(str5).append("]").toString());
                        return;
                    }
                    return;
                }
                Object obj = listM9227a.get(0);
                String strM9226a = m9226a(obj);
                String strM9232b = m9232b(obj);
                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                    Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(strM9226a).length() + 38).append("Clearing _E due to overflow policy: [").append(strM9226a).append("]").toString());
                }
                m9228a(context, str, strM9226a, strM9232b, m9225a(zzfkuVar, zzbVar));
            }
            for (Object obj2 : listM9227a) {
                String strM9226a2 = m9226a(obj2);
                String strM9232b2 = m9232b(obj2);
                if (strM9226a2.equals(zzfkuVar.f8024a) && !strM9232b2.equals(zzfkuVar.f8025b) && Log.isLoggable("FirebaseAbtUtil", 2)) {
                    Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(strM9226a2).length() + 77 + String.valueOf(strM9232b2).length()).append("Clearing _E, as only one _V of the same _E can be set atany given time: [").append(strM9226a2).append(", ").append(strM9232b2).append("].").toString());
                    m9228a(context, str, strM9226a2, strM9232b2, m9225a(zzfkuVar, zzbVar));
                }
            }
            Object objM9224a = m9224a(zzfkuVar, str, zzbVar);
            if (objM9224a == null) {
                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                    String str6 = zzfkuVar.f8024a;
                    String str7 = zzfkuVar.f8025b;
                    Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(str6).length() + 42 + String.valueOf(str7).length()).append("Could not create _CUP for: [").append(str6).append(", ").append(str7).append("]. Skipping.").toString());
                    return;
                }
                return;
            }
            try {
                Method declaredMethod = AppMeasurement.class.getDeclaredMethod("setConditionalUserProperty", Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty"));
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(appMeasurement, objM9224a);
            } catch (Exception e) {
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            }
        } catch (Exception e2) {
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e2);
        }
    }

    /* JADX INFO: renamed from: b */
    private static int m9231b(AppMeasurement appMeasurement, String str) {
        try {
            Method declaredMethod = AppMeasurement.class.getDeclaredMethod("getMaxUserProperties", String.class);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(appMeasurement, str)).intValue();
        } catch (Exception e) {
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return 20;
        }
    }

    /* JADX INFO: renamed from: b */
    private static String m9232b(Object obj) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        return (String) Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mValue").get(obj);
    }

    /* JADX INFO: renamed from: b */
    private static boolean m9233b(Context context) {
        if (m9223a(context) == null) {
            if (!Log.isLoggable("FirebaseAbtUtil", 2)) {
                return false;
            }
            Log.v("FirebaseAbtUtil", "Firebase Analytics not available");
            return false;
        }
        try {
            Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
            return true;
        } catch (ClassNotFoundException e) {
            if (!Log.isLoggable("FirebaseAbtUtil", 2)) {
                return false;
            }
            Log.v("FirebaseAbtUtil", "Firebase Analytics library is missing support for abt. Please update to a more recent version.");
            return false;
        }
    }
}
