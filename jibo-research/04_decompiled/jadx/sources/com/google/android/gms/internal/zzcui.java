package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build;
import android.os.UserManager;
import android.support.v4.content.PermissionChecker;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzcui<T> {

    /* JADX INFO: renamed from: b */
    private static final Object f7746b = new Object();

    /* JADX INFO: renamed from: c */
    private static Context f7747c = null;

    /* JADX INFO: renamed from: d */
    private static boolean f7748d = false;

    /* JADX INFO: renamed from: e */
    private static Boolean f7749e = null;

    /* JADX INFO: renamed from: a */
    final String f7750a;

    /* JADX INFO: renamed from: f */
    private final zzcup f7751f;

    /* JADX INFO: renamed from: g */
    private final String f7752g;

    /* JADX INFO: renamed from: h */
    private final T f7753h;

    /* JADX INFO: renamed from: i */
    private T f7754i;

    private zzcui(zzcup zzcupVar, String str, T t) {
        this.f7754i = null;
        if (zzcupVar.f7760a == null && zzcupVar.f7761b == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        if (zzcupVar.f7760a != null && zzcupVar.f7761b != null) {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
        this.f7751f = zzcupVar;
        String strValueOf = String.valueOf(zzcupVar.f7762c);
        String strValueOf2 = String.valueOf(str);
        this.f7752g = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
        String strValueOf3 = String.valueOf(zzcupVar.f7763d);
        String strValueOf4 = String.valueOf(str);
        this.f7750a = strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3);
        this.f7753h = t;
    }

    /* synthetic */ zzcui(zzcup zzcupVar, String str, Object obj, zzcum zzcumVar) {
        this(zzcupVar, str, obj);
    }

    /* JADX INFO: renamed from: a */
    private static <V> V m8472a(zzcuo<V> zzcuoVar) {
        try {
            return zzcuoVar.mo8484a();
        } catch (SecurityException e) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzcuoVar.mo8484a();
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m8473a(Context context) {
        Context applicationContext;
        if (f7747c == null) {
            synchronized (f7746b) {
                if ((Build.VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) && (applicationContext = context.getApplicationContext()) != null) {
                    context = applicationContext;
                }
                if (f7747c != context) {
                    f7749e = null;
                }
                f7747c = context;
            }
            f7748d = false;
        }
    }

    /* JADX INFO: renamed from: a */
    static boolean m8474a(final String str, boolean z) {
        final boolean z2 = false;
        if (m8479e()) {
            return ((Boolean) m8472a(new zzcuo(str, z2) { // from class: com.google.android.gms.internal.zzcul

                /* JADX INFO: renamed from: a */
                private final String f7758a;

                /* JADX INFO: renamed from: b */
                private final boolean f7759b = false;

                {
                    this.f7758a = str;
                }

                @Override // com.google.android.gms.internal.zzcuo
                /* JADX INFO: renamed from: a */
                public final Object mo8484a() {
                    return Boolean.valueOf(zzdmf.m8521a(zzcui.f7747c.getContentResolver(), this.f7758a, this.f7759b));
                }
            })).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static zzcui<String> m8475b(zzcup zzcupVar, String str, String str2) {
        return new zzcun(zzcupVar, str, str2);
    }

    @TargetApi(24)
    /* JADX INFO: renamed from: c */
    private final T m8477c() {
        if (!m8474a("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
            if (this.f7751f.f7761b != null) {
                final zzctv zzctvVarM8461a = zzctv.m8461a(f7747c.getContentResolver(), this.f7751f.f7761b);
                String str = (String) m8472a(new zzcuo(this, zzctvVarM8461a) { // from class: com.google.android.gms.internal.zzcuj

                    /* JADX INFO: renamed from: a */
                    private final zzcui f7755a;

                    /* JADX INFO: renamed from: b */
                    private final zzctv f7756b;

                    {
                        this.f7755a = this;
                        this.f7756b = zzctvVarM8461a;
                    }

                    @Override // com.google.android.gms.internal.zzcuo
                    /* JADX INFO: renamed from: a */
                    public final Object mo8484a() {
                        return this.f7756b.m8463a().get(this.f7755a.f7750a);
                    }
                });
                if (str != null) {
                    return mo8482a(str);
                }
            } else if (this.f7751f.f7760a != null) {
                if (Build.VERSION.SDK_INT >= 24 && !f7747c.isDeviceProtectedStorage() && !((UserManager) f7747c.getSystemService(UserManager.class)).isUserUnlocked()) {
                    return null;
                }
                SharedPreferences sharedPreferences = f7747c.getSharedPreferences(this.f7751f.f7760a, 0);
                if (sharedPreferences.contains(this.f7750a)) {
                    return mo8481a(sharedPreferences);
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    private final T m8478d() {
        String str;
        if (this.f7751f.f7764e || !m8479e() || (str = (String) m8472a(new zzcuo(this) { // from class: com.google.android.gms.internal.zzcuk

            /* JADX INFO: renamed from: a */
            private final zzcui f7757a;

            {
                this.f7757a = this;
            }

            @Override // com.google.android.gms.internal.zzcuo
            /* JADX INFO: renamed from: a */
            public final Object mo8484a() {
                return this.f7757a.m8483b();
            }
        })) == null) {
            return null;
        }
        return mo8482a(str);
    }

    /* JADX INFO: renamed from: e */
    private static boolean m8479e() {
        if (f7749e == null) {
            if (f7747c == null) {
                return false;
            }
            f7749e = Boolean.valueOf(PermissionChecker.m1898b(f7747c, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
        }
        return f7749e.booleanValue();
    }

    /* JADX INFO: renamed from: a */
    public final T m8480a() {
        if (f7747c == null) {
            throw new IllegalStateException("Must call PhenotypeFlag.init() first");
        }
        if (this.f7751f.f7765f) {
            T tM8478d = m8478d();
            if (tM8478d != null) {
                return tM8478d;
            }
            T tM8477c = m8477c();
            if (tM8477c != null) {
                return tM8477c;
            }
        } else {
            T tM8477c2 = m8477c();
            if (tM8477c2 != null) {
                return tM8477c2;
            }
            T tM8478d2 = m8478d();
            if (tM8478d2 != null) {
                return tM8478d2;
            }
        }
        return this.f7753h;
    }

    /* JADX INFO: renamed from: a */
    public abstract T mo8481a(SharedPreferences sharedPreferences);

    /* JADX INFO: renamed from: a */
    public abstract T mo8482a(String str);

    /* JADX INFO: renamed from: b */
    final /* synthetic */ String m8483b() {
        return zzdmf.m8515a(f7747c.getContentResolver(), this.f7752g, (String) null);
    }
}
