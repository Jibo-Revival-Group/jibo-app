package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.api.internal.zzk;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzs;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseApp {

    /* JADX INFO: renamed from: h */
    private final Context f8601h;

    /* JADX INFO: renamed from: i */
    private final String f8602i;

    /* JADX INFO: renamed from: j */
    private final FirebaseOptions f8603j;

    /* JADX INFO: renamed from: k */
    private final AtomicBoolean f8604k = new AtomicBoolean(false);

    /* JADX INFO: renamed from: l */
    private final AtomicBoolean f8605l = new AtomicBoolean();

    /* JADX INFO: renamed from: m */
    private final List<Object> f8606m = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: n */
    private final List<zza> f8607n = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: o */
    private final List<Object> f8608o = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: p */
    private zzb f8609p = new com.google.firebase.internal.zza();

    /* JADX INFO: renamed from: b */
    private static final List<String> f8595b = Arrays.asList("com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId");

    /* JADX INFO: renamed from: c */
    private static final List<String> f8596c = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");

    /* JADX INFO: renamed from: d */
    private static final List<String> f8597d = Arrays.asList("com.google.android.gms.measurement.AppMeasurement");

    /* JADX INFO: renamed from: e */
    private static final List<String> f8598e = Arrays.asList(new String[0]);

    /* JADX INFO: renamed from: f */
    private static final Set<String> f8599f = Collections.emptySet();

    /* JADX INFO: renamed from: g */
    private static final Object f8600g = new Object();

    /* JADX INFO: renamed from: a */
    static final Map<String, FirebaseApp> f8594a = new ArrayMap();

    public interface zza {
        /* JADX INFO: renamed from: a */
        void m9088a(boolean z);
    }

    public interface zzb {
    }

    @TargetApi(24)
    static class zzc extends BroadcastReceiver {

        /* JADX INFO: renamed from: a */
        private static AtomicReference<zzc> f8610a = new AtomicReference<>();

        /* JADX INFO: renamed from: b */
        private final Context f8611b;

        private zzc(Context context) {
            this.f8611b = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: b */
        public static void m9090b(Context context) {
            if (f8610a.get() == null) {
                zzc zzcVar = new zzc(context);
                if (f8610a.compareAndSet(null, zzcVar)) {
                    context.registerReceiver(zzcVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.f8600g) {
                Iterator<FirebaseApp> it = FirebaseApp.f8594a.values().iterator();
                while (it.hasNext()) {
                    it.next().m9083h();
                }
            }
            this.f8611b.unregisterReceiver(this);
        }
    }

    private FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        this.f8601h = (Context) zzbq.m7373a(context);
        this.f8602i = zzbq.m7375a(str);
        this.f8603j = (FirebaseOptions) zzbq.m7373a(firebaseOptions);
    }

    /* JADX INFO: renamed from: a */
    public static FirebaseApp m9073a(Context context) {
        FirebaseApp firebaseAppM9074a;
        synchronized (f8600g) {
            if (f8594a.containsKey("[DEFAULT]")) {
                firebaseAppM9074a = m9080d();
            } else {
                FirebaseOptions firebaseOptionsM9091a = FirebaseOptions.m9091a(context);
                firebaseAppM9074a = firebaseOptionsM9091a == null ? null : m9074a(context, firebaseOptionsM9091a);
            }
        }
        return firebaseAppM9074a;
    }

    /* JADX INFO: renamed from: a */
    public static FirebaseApp m9074a(Context context, FirebaseOptions firebaseOptions) {
        return m9075a(context, firebaseOptions, "[DEFAULT]");
    }

    /* JADX INFO: renamed from: a */
    public static FirebaseApp m9075a(Context context, FirebaseOptions firebaseOptions, String str) {
        FirebaseApp firebaseApp;
        com.google.firebase.internal.zzb.m9191a(context);
        if (context.getApplicationContext() instanceof Application) {
            zzk.m7219a((Application) context.getApplicationContext());
            zzk.m7218a().m7221a(new com.google.firebase.zza());
        }
        String strTrim = str.trim();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f8600g) {
            zzbq.m7379a(!f8594a.containsKey(strTrim), new StringBuilder(String.valueOf(strTrim).length() + 33).append("FirebaseApp name ").append(strTrim).append(" already exists!").toString());
            zzbq.m7374a(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, strTrim, firebaseOptions);
            f8594a.put(strTrim, firebaseApp);
        }
        com.google.firebase.internal.zzb.m9192a(firebaseApp);
        firebaseApp.m9077a((Class<FirebaseApp>) FirebaseApp.class, firebaseApp, f8595b);
        if (firebaseApp.m9087e()) {
            firebaseApp.m9077a((Class<FirebaseApp>) FirebaseApp.class, firebaseApp, f8596c);
            firebaseApp.m9077a((Class<Context>) Context.class, firebaseApp.m9084a(), f8597d);
        }
        return firebaseApp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private final <T> void m9077a(Class<T> cls, T t, Iterable<String> iterable) {
        boolean zM1839b = ContextCompat.m1839b(this.f8601h);
        if (zM1839b) {
            zzc.m9090b(this.f8601h);
        }
        for (String str : iterable) {
            if (zM1839b) {
                try {
                } catch (ClassNotFoundException e) {
                    if (f8599f.contains(str)) {
                        throw new IllegalStateException(String.valueOf(str).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                    }
                    Log.d("FirebaseApp", String.valueOf(str).concat(" is not linked. Skipping initialization."));
                } catch (IllegalAccessException e2) {
                    String strValueOf = String.valueOf(str);
                    Log.wtf("FirebaseApp", strValueOf.length() != 0 ? "Failed to initialize ".concat(strValueOf) : new String("Failed to initialize "), e2);
                } catch (NoSuchMethodException e3) {
                    throw new IllegalStateException(String.valueOf(str).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
                } catch (InvocationTargetException e4) {
                    Log.wtf("FirebaseApp", "Firebase API initialization failure.", e4);
                }
                if (f8598e.contains(str)) {
                }
            }
            Method method = Class.forName(str).getMethod("getInstance", cls);
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                method.invoke(null, t);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m9078a(boolean z) {
        synchronized (f8600g) {
            ArrayList arrayList = new ArrayList(f8594a.values());
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                FirebaseApp firebaseApp = (FirebaseApp) obj;
                if (firebaseApp.f8604k.get()) {
                    firebaseApp.m9079b(z);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private final void m9079b(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator<zza> it = this.f8607n.iterator();
        while (it.hasNext()) {
            it.next().m9088a(z);
        }
    }

    /* JADX INFO: renamed from: d */
    public static FirebaseApp m9080d() {
        FirebaseApp firebaseApp;
        synchronized (f8600g) {
            firebaseApp = f8594a.get("[DEFAULT]");
            if (firebaseApp == null) {
                String strM7518a = zzs.m7518a();
                throw new IllegalStateException(new StringBuilder(String.valueOf(strM7518a).length() + 116).append("Default FirebaseApp is not initialized in this process ").append(strM7518a).append(". Make sure to call FirebaseApp.initializeApp(Context) first.").toString());
            }
        }
        return firebaseApp;
    }

    /* JADX INFO: renamed from: g */
    private final void m9082g() {
        zzbq.m7379a(!this.f8605l.get(), "FirebaseApp was deleted");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h */
    public final void m9083h() {
        m9077a((Class<FirebaseApp>) FirebaseApp.class, this, f8595b);
        if (m9087e()) {
            m9077a((Class<FirebaseApp>) FirebaseApp.class, this, f8596c);
            m9077a((Class<Context>) Context.class, this.f8601h, f8597d);
        }
    }

    /* JADX INFO: renamed from: a */
    public Context m9084a() {
        m9082g();
        return this.f8601h;
    }

    /* JADX INFO: renamed from: b */
    public String m9085b() {
        m9082g();
        return this.f8602i;
    }

    /* JADX INFO: renamed from: c */
    public FirebaseOptions m9086c() {
        m9082g();
        return this.f8603j;
    }

    /* JADX INFO: renamed from: e */
    public final boolean m9087e() {
        return "[DEFAULT]".equals(m9085b());
    }

    public boolean equals(Object obj) {
        if (obj instanceof FirebaseApp) {
            return this.f8602i.equals(((FirebaseApp) obj).m9085b());
        }
        return false;
    }

    public int hashCode() {
        return this.f8602i.hashCode();
    }

    public String toString() {
        return zzbg.m7370a(this).m7372a("name", this.f8602i).m7372a("options", this.f8603j).toString();
    }
}
