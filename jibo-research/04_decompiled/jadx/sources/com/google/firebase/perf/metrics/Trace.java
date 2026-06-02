package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Keep;
import android.util.Log;
import com.google.android.gms.internal.zzevw;
import com.google.android.gms.internal.zzevx;
import com.google.android.gms.internal.zzevz;
import com.google.android.gms.internal.zzewg;
import com.google.android.gms.internal.zzewk;
import com.google.android.gms.internal.zzewl;
import com.google.android.gms.internal.zzewm;
import com.google.android.gms.internal.zzewn;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class Trace extends zzevx implements Parcelable {

    /* JADX INFO: renamed from: b */
    private final Trace f8742b;

    /* JADX INFO: renamed from: c */
    private final String f8743c;

    /* JADX INFO: renamed from: d */
    private final List<Trace> f8744d;

    /* JADX INFO: renamed from: e */
    private final Map<String, zza> f8745e;

    /* JADX INFO: renamed from: f */
    private final zzewk f8746f;

    /* JADX INFO: renamed from: g */
    private final zzevz f8747g;

    /* JADX INFO: renamed from: h */
    private final Map<String, String> f8748h;

    /* JADX INFO: renamed from: i */
    private zzewn f8749i;

    /* JADX INFO: renamed from: j */
    private zzewn f8750j;

    /* JADX INFO: renamed from: a */
    private static final Map<String, Trace> f8740a = new ConcurrentHashMap();

    @Keep
    public static final Parcelable.Creator<Trace> CREATOR = new zzc();

    /* JADX INFO: renamed from: k */
    private static Parcelable.Creator<Trace> f8741k = new zzd();

    private Trace(Parcel parcel, boolean z) {
        super(z ? null : zzevw.m8544a());
        this.f8742b = (Trace) parcel.readParcelable(Trace.class.getClassLoader());
        this.f8743c = parcel.readString();
        this.f8744d = new ArrayList();
        parcel.readList(this.f8744d, Trace.class.getClassLoader());
        this.f8745e = new ConcurrentHashMap();
        this.f8748h = new ConcurrentHashMap();
        parcel.readMap(this.f8745e, zza.class.getClassLoader());
        this.f8749i = (zzewn) parcel.readParcelable(zzewn.class.getClassLoader());
        this.f8750j = (zzewn) parcel.readParcelable(zzewn.class.getClassLoader());
        if (z) {
            this.f8747g = null;
            this.f8746f = null;
        } else {
            this.f8747g = zzevz.m8561a();
            this.f8746f = new zzewk();
        }
    }

    /* synthetic */ Trace(Parcel parcel, boolean z, zzc zzcVar) {
        this(parcel, z);
    }

    /* JADX INFO: renamed from: i */
    private final boolean m9252i() {
        return this.f8750j != null;
    }

    /* JADX INFO: renamed from: j */
    private final boolean m9253j() {
        return this.f8749i != null;
    }

    /* JADX INFO: renamed from: a */
    final String m9254a() {
        return this.f8743c;
    }

    /* JADX INFO: renamed from: b */
    final Map<String, zza> m9255b() {
        return this.f8745e;
    }

    /* JADX INFO: renamed from: c */
    final zzewn m9256c() {
        return this.f8749i;
    }

    /* JADX INFO: renamed from: d */
    final zzewn m9257d() {
        return this.f8750j;
    }

    @Override // android.os.Parcelable
    @Keep
    public int describeContents() {
        return 0;
    }

    protected void finalize() throws Throwable {
        try {
            if (m9253j() && !m9252i()) {
                Log.w("FirebasePerformance", String.format("Trace '%s' is started but not stopped when it is destructed!", this.f8743c));
                m8556c(1);
            }
        } finally {
            super.finalize();
        }
    }

    @Keep
    public String getAttribute(String str) {
        return this.f8748h.get(str);
    }

    @Keep
    public Map<String, String> getAttributes() {
        return new HashMap(this.f8748h);
    }

    /* JADX INFO: renamed from: h */
    final List<Trace> m9258h() {
        return this.f8744d;
    }

    @Keep
    public void incrementCounter(String str) {
        incrementCounter(str, 1L);
    }

    @Keep
    public void incrementCounter(String str, long j) {
        String str2;
        if (str == null) {
            str2 = "Counter name must not be null";
        } else if (str.length() <= 100) {
            if (!str.startsWith("_")) {
                str2 = null;
                break;
            }
            for (zzewl zzewlVar : zzewl.values()) {
                if (zzewlVar.toString().equals(str)) {
                    str2 = null;
                    break;
                }
            }
            str2 = "Counter name must not start with '_'";
        } else {
            str2 = String.format(Locale.US, "Counter name must not exceed %d characters", 100);
        }
        if (str2 != null) {
            Log.e("FirebasePerformance", String.format("Cannot increment counter %s. Counter name is invalid.(%s)", str, str2));
            return;
        }
        if (!m9253j()) {
            Log.w("FirebasePerformance", String.format("Cannot increment counter '%s' for trace '%s' because it's not started", str, this.f8743c));
            return;
        }
        if (m9252i()) {
            Log.w("FirebasePerformance", String.format("Cannot increment counter '%s' for trace '%s' because it's been stopped", str, this.f8743c));
            return;
        }
        String strTrim = str.trim();
        zza zzaVar = this.f8745e.get(strTrim);
        if (zzaVar == null) {
            zzaVar = new zza(strTrim);
            this.f8745e.put(strTrim, zzaVar);
        }
        zzaVar.m9260a(j);
    }

    @Keep
    public void putAttribute(String str, String str2) {
        boolean z;
        try {
            str = str.trim();
            str2 = str2.trim();
        } catch (Exception e) {
            Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", str, str2, e.getMessage()));
            z = false;
        }
        if (m9252i()) {
            throw new IllegalArgumentException(String.format(Locale.US, "Trace %s has been stopped", this.f8743c));
        }
        if (!this.f8748h.containsKey(str) && this.f8748h.size() >= 5) {
            throw new IllegalArgumentException(String.format(Locale.US, "Exceeds max limit of number of attributes - %d", 5));
        }
        String strM8589a = zzewg.m8589a(new AbstractMap.SimpleEntry(str, str2));
        if (strM8589a != null) {
            throw new IllegalArgumentException(strM8589a);
        }
        z = true;
        if (z) {
            this.f8748h.put(str, str2);
        }
    }

    @Keep
    public void removeAttribute(String str) {
        if (m9252i()) {
            Log.e("FirebasePerformance", "Can't remove a attribute from a Trace that's stopped.");
        } else {
            this.f8748h.remove(str);
        }
    }

    @Keep
    public void start() {
        String str;
        String str2 = this.f8743c;
        if (str2 == null) {
            str = "Trace name must not be null";
        } else if (str2.length() <= 100) {
            if (!str2.startsWith("_")) {
                str = null;
                break;
            }
            for (zzewm zzewmVar : zzewm.values()) {
                if (zzewmVar.toString().equals(str2)) {
                    str = null;
                    break;
                }
            }
            str = "Trace name must not start with '_'";
        } else {
            str = String.format(Locale.US, "Trace name must not exceed %d characters", 100);
        }
        if (str != null) {
            Log.e("FirebasePerformance", String.format("Cannot start trace %s. Trace name is invalid.(%s)", this.f8743c, str));
        } else if (this.f8749i != null) {
            Log.e("FirebasePerformance", String.format("Trace '%s' has already started, should not start again!", this.f8743c));
        } else {
            this.f8749i = new zzewn();
            m8557e();
        }
    }

    @Keep
    public void stop() {
        if (!m9253j()) {
            Log.e("FirebasePerformance", String.format("Trace '%s' has not been started so unable to stop!", this.f8743c));
            return;
        }
        if (m9252i()) {
            Log.e("FirebasePerformance", String.format("Trace '%s' has already stopped, should not stop again!", this.f8743c));
            return;
        }
        m8558f();
        this.f8750j = new zzewn();
        if (this.f8742b == null) {
            zzewn zzewnVar = this.f8750j;
            if (!this.f8744d.isEmpty()) {
                Trace trace = this.f8744d.get(this.f8744d.size() - 1);
                if (trace.f8750j == null) {
                    trace.f8750j = zzewnVar;
                }
            }
            if (this.f8743c.isEmpty()) {
                Log.e("FirebasePerformance", "Trace name is empty, no log is sent to server");
            } else if (this.f8747g != null) {
                this.f8747g.m8571a(new zze(this).m9261a(), m8559g());
            }
        }
    }

    @Override // android.os.Parcelable
    @Keep
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f8742b, 0);
        parcel.writeString(this.f8743c);
        parcel.writeList(this.f8744d);
        parcel.writeMap(this.f8745e);
        parcel.writeParcelable(this.f8749i, 0);
        parcel.writeParcelable(this.f8750j, 0);
    }
}
