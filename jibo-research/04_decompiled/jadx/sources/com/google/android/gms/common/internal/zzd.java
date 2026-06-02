package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.api.client.googleapis.extensions.android.accounts.GoogleAccountManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzd<T extends IInterface> {

    /* JADX INFO: renamed from: A */
    private static String[] f6590A = {"service_esmobile", "service_googleme"};

    /* JADX INFO: renamed from: a */
    final Handler f6591a;

    /* JADX INFO: renamed from: b */
    protected zzj f6592b;

    /* JADX INFO: renamed from: c */
    protected AtomicInteger f6593c;

    /* JADX INFO: renamed from: d */
    private int f6594d;

    /* JADX INFO: renamed from: e */
    private long f6595e;

    /* JADX INFO: renamed from: f */
    private long f6596f;

    /* JADX INFO: renamed from: g */
    private int f6597g;

    /* JADX INFO: renamed from: h */
    private long f6598h;

    /* JADX INFO: renamed from: i */
    private zzam f6599i;

    /* JADX INFO: renamed from: j */
    private final Context f6600j;

    /* JADX INFO: renamed from: k */
    private final Looper f6601k;

    /* JADX INFO: renamed from: l */
    private final zzag f6602l;

    /* JADX INFO: renamed from: m */
    private final com.google.android.gms.common.zzf f6603m;

    /* JADX INFO: renamed from: n */
    private final Object f6604n;

    /* JADX INFO: renamed from: o */
    private final Object f6605o;

    /* JADX INFO: renamed from: p */
    private zzay f6606p;

    /* JADX INFO: renamed from: q */
    private T f6607q;

    /* JADX INFO: renamed from: r */
    private final ArrayList<zzi<?>> f6608r;

    /* JADX INFO: renamed from: s */
    private zzl f6609s;

    /* JADX INFO: renamed from: t */
    private int f6610t;

    /* JADX INFO: renamed from: u */
    private final zzf f6611u;

    /* JADX INFO: renamed from: v */
    private final zzg f6612v;

    /* JADX INFO: renamed from: w */
    private final int f6613w;

    /* JADX INFO: renamed from: x */
    private final String f6614x;

    /* JADX INFO: renamed from: y */
    private ConnectionResult f6615y;

    /* JADX INFO: renamed from: z */
    private boolean f6616z;

    protected zzd(Context context, Looper looper, int i, zzf zzfVar, zzg zzgVar, String str) {
        this(context, looper, zzag.m7326a(context), com.google.android.gms.common.zzf.m7530b(), i, (zzf) zzbq.m7373a(zzfVar), (zzg) zzbq.m7373a(zzgVar), null);
    }

    protected zzd(Context context, Looper looper, zzag zzagVar, com.google.android.gms.common.zzf zzfVar, int i, zzf zzfVar2, zzg zzgVar, String str) {
        this.f6604n = new Object();
        this.f6605o = new Object();
        this.f6608r = new ArrayList<>();
        this.f6610t = 1;
        this.f6615y = null;
        this.f6616z = false;
        this.f6593c = new AtomicInteger(0);
        this.f6600j = (Context) zzbq.m7374a(context, "Context must not be null");
        this.f6601k = (Looper) zzbq.m7374a(looper, "Looper must not be null");
        this.f6602l = (zzag) zzbq.m7374a(zzagVar, "Supervisor must not be null");
        this.f6603m = (com.google.android.gms.common.zzf) zzbq.m7374a(zzfVar, "API availability must not be null");
        this.f6591a = new zzh(this, looper);
        this.f6613w = i;
        this.f6611u = zzfVar2;
        this.f6612v = zzgVar;
        this.f6614x = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m7402a(int i, T t) {
        zzbq.m7382b((i == 4) == (t != null));
        synchronized (this.f6604n) {
            this.f6610t = i;
            this.f6607q = t;
            switch (i) {
                case 1:
                    if (this.f6609s != null) {
                        this.f6602l.m7327a(mo6770b_(), m7434q(), 129, this.f6609s, m7412e());
                        this.f6609s = null;
                    }
                    break;
                case 2:
                case 3:
                    if (this.f6609s != null && this.f6599i != null) {
                        String strM7354a = this.f6599i.m7354a();
                        String strM7355b = this.f6599i.m7355b();
                        Log.e("GmsClient", new StringBuilder(String.valueOf(strM7354a).length() + 70 + String.valueOf(strM7355b).length()).append("Calling connect() while still connected, missing disconnect() for ").append(strM7354a).append(" on ").append(strM7355b).toString());
                        this.f6602l.m7327a(this.f6599i.m7354a(), this.f6599i.m7355b(), this.f6599i.m7356c(), this.f6609s, m7412e());
                        this.f6593c.incrementAndGet();
                    }
                    this.f6609s = new zzl(this, this.f6593c.get());
                    this.f6599i = new zzam(m7434q(), mo6770b_(), false, 129);
                    if (!this.f6602l.mo7329a(new zzah(this.f6599i.m7354a(), this.f6599i.m7355b(), this.f6599i.m7356c()), this.f6609s, m7412e())) {
                        String strM7354a2 = this.f6599i.m7354a();
                        String strM7355b2 = this.f6599i.m7355b();
                        Log.e("GmsClient", new StringBuilder(String.valueOf(strM7354a2).length() + 34 + String.valueOf(strM7355b2).length()).append("unable to connect to service: ").append(strM7354a2).append(" on ").append(strM7355b2).toString());
                        m7419a(16, (Bundle) null, this.f6593c.get());
                    }
                    break;
                case 4:
                    m7421a(t);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final boolean m7405a(int i, int i2, T t) {
        boolean z;
        synchronized (this.f6604n) {
            if (this.f6610t != i) {
                z = false;
            } else {
                m7402a(i2, t);
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public final void m7408c(int i) {
        int i2;
        if (m7415n()) {
            i2 = 5;
            this.f6616z = true;
        } else {
            i2 = 4;
        }
        this.f6591a.sendMessage(this.f6591a.obtainMessage(i2, this.f6593c.get(), 16));
    }

    /* JADX INFO: renamed from: e */
    private final String m7412e() {
        return this.f6614x == null ? this.f6600j.getClass().getName() : this.f6614x;
    }

    /* JADX INFO: renamed from: n */
    private final boolean m7415n() {
        boolean z;
        synchronized (this.f6604n) {
            z = this.f6610t == 3;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: x */
    public final boolean m7416x() {
        if (this.f6616z || TextUtils.isEmpty(mo6769b()) || TextUtils.isEmpty(null)) {
            return false;
        }
        try {
            Class.forName(mo6769b());
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public Bundle m7417a() {
        return null;
    }

    /* JADX INFO: renamed from: a */
    protected abstract T mo6768a(IBinder iBinder);

    /* JADX INFO: renamed from: a */
    protected void m7418a(int i) {
        this.f6594d = i;
        this.f6595e = System.currentTimeMillis();
    }

    /* JADX INFO: renamed from: a */
    protected final void m7419a(int i, Bundle bundle, int i2) {
        this.f6591a.sendMessage(this.f6591a.obtainMessage(7, i2, -1, new zzo(this, i, null)));
    }

    /* JADX INFO: renamed from: a */
    protected void m7420a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.f6591a.sendMessage(this.f6591a.obtainMessage(1, i2, -1, new zzn(this, i, iBinder, bundle)));
    }

    /* JADX INFO: renamed from: a */
    protected void m7421a(T t) {
        this.f6596f = System.currentTimeMillis();
    }

    /* JADX INFO: renamed from: a */
    protected void m7422a(ConnectionResult connectionResult) {
        this.f6597g = connectionResult.m6822c();
        this.f6598h = System.currentTimeMillis();
    }

    /* JADX INFO: renamed from: a */
    public final void m7423a(zzan zzanVar, Set<Scope> set) {
        Bundle bundleMo7437t = mo7437t();
        zzz zzzVar = new zzz(this.f6613w);
        zzzVar.f6659a = this.f6600j.getPackageName();
        zzzVar.f6662d = bundleMo7437t;
        if (set != null) {
            zzzVar.f6661c = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (mo6864i()) {
            zzzVar.f6663e = mo7311e_() != null ? mo7311e_() : new Account("<<default account>>", GoogleAccountManager.ACCOUNT_TYPE);
            if (zzanVar != null) {
                zzzVar.f6660b = zzanVar.asBinder();
            }
        } else if (m7440w()) {
            zzzVar.f6663e = mo7311e_();
        }
        zzzVar.f6664f = mo7314p();
        try {
            synchronized (this.f6605o) {
                if (this.f6606p != null) {
                    this.f6606p.mo7363a(new zzk(this, this.f6593c.get()), zzzVar);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            m7428b(1);
        } catch (RemoteException e2) {
            e = e2;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            m7420a(8, (IBinder) null, (Bundle) null, this.f6593c.get());
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            e = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            m7420a(8, (IBinder) null, (Bundle) null, this.f6593c.get());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m7424a(zzj zzjVar) {
        this.f6592b = (zzj) zzbq.m7374a(zzjVar, "Connection progress callbacks cannot be null.");
        m7402a(2, (IInterface) null);
    }

    /* JADX INFO: renamed from: a */
    protected final void m7425a(zzj zzjVar, int i, PendingIntent pendingIntent) {
        this.f6592b = (zzj) zzbq.m7374a(zzjVar, "Connection progress callbacks cannot be null.");
        this.f6591a.sendMessage(this.f6591a.obtainMessage(3, this.f6593c.get(), i, pendingIntent));
    }

    /* JADX INFO: renamed from: a */
    public void m7426a(zzp zzpVar) {
        zzpVar.mo7145a();
    }

    /* JADX INFO: renamed from: a */
    public final void m7427a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        zzay zzayVar;
        synchronized (this.f6604n) {
            i = this.f6610t;
            t = this.f6607q;
        }
        synchronized (this.f6605o) {
            zzayVar = this.f6606p;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("REMOTE_CONNECTING");
                break;
            case 3:
                printWriter.print("LOCAL_CONNECTING");
                break;
            case 4:
                printWriter.print("CONNECTED");
                break;
            case 5:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) mo6769b()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (zzayVar == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(zzayVar.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f6596f > 0) {
            PrintWriter printWriterAppend = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j = this.f6596f;
            String str2 = simpleDateFormat.format(new Date(this.f6596f));
            printWriterAppend.println(new StringBuilder(String.valueOf(str2).length() + 21).append(j).append(" ").append(str2).toString());
        }
        if (this.f6595e > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            switch (this.f6594d) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append((CharSequence) String.valueOf(this.f6594d));
                    break;
            }
            PrintWriter printWriterAppend2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.f6595e;
            String str3 = simpleDateFormat.format(new Date(this.f6595e));
            printWriterAppend2.println(new StringBuilder(String.valueOf(str3).length() + 21).append(j2).append(" ").append(str3).toString());
        }
        if (this.f6598h > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) CommonStatusCodes.m6870a(this.f6597g));
            PrintWriter printWriterAppend3 = printWriter.append(" lastFailedTime=");
            long j3 = this.f6598h;
            String str4 = simpleDateFormat.format(new Date(this.f6598h));
            printWriterAppend3.println(new StringBuilder(String.valueOf(str4).length() + 21).append(j3).append(" ").append(str4).toString());
        }
    }

    /* JADX INFO: renamed from: b */
    protected abstract String mo6769b();

    /* JADX INFO: renamed from: b */
    public final void m7428b(int i) {
        this.f6591a.sendMessage(this.f6591a.obtainMessage(6, this.f6593c.get(), i));
    }

    /* JADX INFO: renamed from: b_ */
    protected abstract String mo6770b_();

    /* JADX INFO: renamed from: c */
    public boolean mo6771c() {
        return false;
    }

    /* JADX INFO: renamed from: d */
    public Intent mo6772d() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    /* JADX INFO: renamed from: e_ */
    public Account mo7311e_() {
        return null;
    }

    /* JADX INFO: renamed from: f */
    public void mo6861f() {
        this.f6593c.incrementAndGet();
        synchronized (this.f6608r) {
            int size = this.f6608r.size();
            for (int i = 0; i < size; i++) {
                this.f6608r.get(i).m7448d();
            }
            this.f6608r.clear();
        }
        synchronized (this.f6605o) {
            this.f6606p = null;
        }
        m7402a(1, (IInterface) null);
    }

    /* JADX INFO: renamed from: g */
    public final boolean m7429g() {
        boolean z;
        synchronized (this.f6604n) {
            z = this.f6610t == 4;
        }
        return z;
    }

    /* JADX INFO: renamed from: h */
    public final boolean m7430h() {
        boolean z;
        synchronized (this.f6604n) {
            z = this.f6610t == 2 || this.f6610t == 3;
        }
        return z;
    }

    /* JADX INFO: renamed from: i */
    public boolean mo6864i() {
        return false;
    }

    /* JADX INFO: renamed from: j */
    public boolean m7431j() {
        return true;
    }

    /* JADX INFO: renamed from: k */
    public final IBinder m7432k() {
        IBinder iBinderAsBinder;
        synchronized (this.f6605o) {
            iBinderAsBinder = this.f6606p == null ? null : this.f6606p.asBinder();
        }
        return iBinderAsBinder;
    }

    /* JADX INFO: renamed from: l */
    public final String m7433l() {
        if (!m7429g() || this.f6599i == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return this.f6599i.m7355b();
    }

    /* JADX INFO: renamed from: o */
    protected Set<Scope> mo7313o() {
        return Collections.EMPTY_SET;
    }

    /* JADX INFO: renamed from: p */
    public com.google.android.gms.common.zzc[] mo7314p() {
        return new com.google.android.gms.common.zzc[0];
    }

    /* JADX INFO: renamed from: q */
    protected String m7434q() {
        return "com.google.android.gms";
    }

    /* JADX INFO: renamed from: r */
    public final void m7435r() {
        int iMo6834a = this.f6603m.mo6834a(this.f6600j);
        if (iMo6834a == 0) {
            m7424a(new zzm(this));
        } else {
            m7402a(1, (IInterface) null);
            m7425a(new zzm(this), iMo6834a, (PendingIntent) null);
        }
    }

    /* JADX INFO: renamed from: s */
    public final Context m7436s() {
        return this.f6600j;
    }

    /* JADX INFO: renamed from: t */
    protected Bundle mo7437t() {
        return new Bundle();
    }

    /* JADX INFO: renamed from: u */
    protected final void m7438u() {
        if (!m7429g()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* JADX INFO: renamed from: v */
    public final T m7439v() throws DeadObjectException {
        T t;
        synchronized (this.f6604n) {
            if (this.f6610t == 5) {
                throw new DeadObjectException();
            }
            m7438u();
            zzbq.m7379a(this.f6607q != null, "Client is connected but service is null");
            t = this.f6607q;
        }
        return t;
    }

    /* JADX INFO: renamed from: w */
    public boolean m7440w() {
        return false;
    }
}
