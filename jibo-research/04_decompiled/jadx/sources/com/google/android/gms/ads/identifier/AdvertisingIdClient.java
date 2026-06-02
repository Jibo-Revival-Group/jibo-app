package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzfo;
import com.google.android.gms.internal.zzfp;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class AdvertisingIdClient {
    private final Context mContext;
    private com.google.android.gms.common.zza zzamu;
    private zzfo zzamv;
    private boolean zzamw;
    private Object zzamx;
    private zza zzamy;
    private boolean zzamz;
    private long zzana;

    public static final class Info {
        private final String zzang;
        private final boolean zzanh;

        public Info(String str, boolean z) {
            this.zzang = str;
            this.zzanh = z;
        }

        public final String getId() {
            return this.zzang;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.zzanh;
        }

        public final String toString() {
            String str = this.zzang;
            return new StringBuilder(String.valueOf(str).length() + 7).append("{").append(str).append("}").append(this.zzanh).toString();
        }
    }

    static class zza extends Thread {

        /* JADX INFO: renamed from: a */
        CountDownLatch f5830a = new CountDownLatch(1);

        /* JADX INFO: renamed from: b */
        boolean f5831b = false;

        /* JADX INFO: renamed from: c */
        private WeakReference<AdvertisingIdClient> f5832c;

        /* JADX INFO: renamed from: d */
        private long f5833d;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            this.f5832c = new WeakReference<>(advertisingIdClient);
            this.f5833d = j;
            start();
        }

        /* JADX INFO: renamed from: a */
        private final void m6664a() {
            AdvertisingIdClient advertisingIdClient = this.f5832c.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.f5831b = true;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                if (this.f5830a.await(this.f5833d, TimeUnit.MILLISECONDS)) {
                    return;
                }
                m6664a();
            } catch (InterruptedException e) {
                m6664a();
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000L, false, false);
    }

    public AdvertisingIdClient(Context context, long j, boolean z, boolean z2) {
        this.zzamx = new Object();
        zzbq.m7373a(context);
        if (z) {
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext != null ? applicationContext : context;
        } else {
            this.mContext = context;
        }
        this.zzamw = false;
        this.zzana = j;
        this.zzamz = z2;
    }

    public static Info getAdvertisingIdInfo(Context context) throws GooglePlayServicesRepairableException, IllegalStateException, GooglePlayServicesNotAvailableException, IOException {
        zzb zzbVar = new zzb(context);
        boolean zM6667a = zzbVar.m6667a("gads:ad_id_app_context:enabled", false);
        float fM6665a = zzbVar.m6665a("gads:ad_id_app_context:ping_ratio", CropImageView.DEFAULT_ASPECT_RATIO);
        String strM6666a = zzbVar.m6666a("gads:ad_id_use_shared_preference:experiment_id", "");
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, zM6667a, zzbVar.m6667a("gads:ad_id_use_persistent_service:enabled", false));
        try {
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                advertisingIdClient.start(false);
                Info info = advertisingIdClient.getInfo();
                advertisingIdClient.zza(info, zM6667a, fM6665a, SystemClock.elapsedRealtime() - jElapsedRealtime, strM6666a, null);
                return info;
            } finally {
            }
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static boolean getIsAdIdFakeForDebugLogging(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException, IOException {
        zzb zzbVar = new zzb(context);
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, zzbVar.m6667a("gads:ad_id_app_context:enabled", false), zzbVar.m6667a("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
        try {
            advertisingIdClient.start(false);
            return advertisingIdClient.getIsAdIdFakeForDebugLogging();
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    private final void start(boolean z) throws GooglePlayServicesRepairableException, IllegalStateException, GooglePlayServicesNotAvailableException, IOException {
        zzbq.m7385c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzamw) {
                finish();
            }
            this.zzamu = zzc(this.mContext, this.zzamz);
            this.zzamv = zza(this.mContext, this.zzamu);
            this.zzamw = true;
            if (z) {
                zzbo();
            }
        }
    }

    private static zzfo zza(Context context, com.google.android.gms.common.zza zzaVar) throws IOException {
        try {
            return zzfp.m8734a(zzaVar.m7527a(10000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    private final boolean zza(Info info, boolean z, float f, long j, String str, Throwable th) {
        if (Math.random() > f) {
            return false;
        }
        HashMap map = new HashMap();
        map.put("app_context", z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (info != null) {
            map.put("limit_ad_tracking", info.isLimitAdTrackingEnabled() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        if (info != null && info.getId() != null) {
            map.put("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            map.put("error", th.getClass().getName());
        }
        if (str != null && !str.isEmpty()) {
            map.put("experiment_id", str);
        }
        map.put("tag", "AdvertisingIdClient");
        map.put("time_spent", Long.toString(j));
        new com.google.android.gms.ads.identifier.zza(this, map).start();
        return true;
    }

    private final void zzbo() {
        synchronized (this.zzamx) {
            if (this.zzamy != null) {
                this.zzamy.f5830a.countDown();
                try {
                    this.zzamy.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzana > 0) {
                this.zzamy = new zza(this, this.zzana);
            }
        }
    }

    private static com.google.android.gms.common.zza zzc(Context context, boolean z) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException, IOException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            switch (zzf.m7530b().mo6834a(context)) {
                case 0:
                case 2:
                    String str = z ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
                    com.google.android.gms.common.zza zzaVar = new com.google.android.gms.common.zza();
                    Intent intent = new Intent(str);
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (com.google.android.gms.common.stats.zza.m7483a().m7484a(context, intent, zzaVar, 1)) {
                            return zzaVar;
                        }
                        throw new IOException("Connection failure");
                    } catch (Throwable th) {
                        throw new IOException(th);
                    }
                case 1:
                default:
                    throw new IOException("Google Play services not available");
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    protected void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    public void finish() {
        zzbq.m7385c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.mContext == null || this.zzamu == null) {
                return;
            }
            try {
                if (this.zzamw) {
                    com.google.android.gms.common.stats.zza.m7483a();
                    this.mContext.unbindService(this.zzamu);
                }
            } catch (Throwable th) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
            }
            this.zzamw = false;
            this.zzamv = null;
            this.zzamu = null;
        }
    }

    public Info getInfo() throws IOException {
        Info info;
        zzbq.m7385c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzamw) {
                zzbq.m7373a(this.zzamu);
                zzbq.m7373a(this.zzamv);
                info = new Info(this.zzamv.mo8731a(), this.zzamv.mo8732a(true));
            } else {
                synchronized (this.zzamx) {
                    if (this.zzamy == null || !this.zzamy.f5831b) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    start(false);
                    if (!this.zzamw) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                    zzbq.m7373a(this.zzamu);
                    zzbq.m7373a(this.zzamv);
                    try {
                        info = new Info(this.zzamv.mo8731a(), this.zzamv.mo8732a(true));
                    } catch (RemoteException e) {
                        Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                        throw new IOException("Remote exception");
                    }
                } catch (Exception e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
        }
        zzbo();
        return info;
    }

    public boolean getIsAdIdFakeForDebugLogging() throws IOException {
        boolean zMo8733b;
        zzbq.m7385c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzamw) {
                zzbq.m7373a(this.zzamu);
                zzbq.m7373a(this.zzamv);
                zMo8733b = this.zzamv.mo8733b();
            } else {
                synchronized (this.zzamx) {
                    if (this.zzamy == null || !this.zzamy.f5831b) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    start(false);
                    if (!this.zzamw) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                    zzbq.m7373a(this.zzamu);
                    zzbq.m7373a(this.zzamv);
                    try {
                        zMo8733b = this.zzamv.mo8733b();
                    } catch (RemoteException e) {
                        Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                        throw new IOException("Remote exception");
                    }
                } catch (Exception e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
        }
        zzbo();
        return zMo8733b;
    }

    public void start() throws GooglePlayServicesRepairableException, IllegalStateException, GooglePlayServicesNotAvailableException, IOException {
        start(true);
    }
}
