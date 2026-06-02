package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public final class DataHolder extends zzbfm implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new zzf();

    /* JADX INFO: renamed from: k */
    private static final zza f6466k = new zze(new String[0], null);

    /* JADX INFO: renamed from: a */
    int f6467a;

    /* JADX INFO: renamed from: b */
    private int f6468b;

    /* JADX INFO: renamed from: c */
    private final String[] f6469c;

    /* JADX INFO: renamed from: d */
    private Bundle f6470d;

    /* JADX INFO: renamed from: e */
    private final CursorWindow[] f6471e;

    /* JADX INFO: renamed from: f */
    private final int f6472f;

    /* JADX INFO: renamed from: g */
    private final Bundle f6473g;

    /* JADX INFO: renamed from: h */
    private int[] f6474h;

    /* JADX INFO: renamed from: i */
    private boolean f6475i;

    /* JADX INFO: renamed from: j */
    private boolean f6476j;

    public static class zza {

        /* JADX INFO: renamed from: a */
        private final String[] f6477a;

        /* JADX INFO: renamed from: b */
        private final ArrayList<HashMap<String, Object>> f6478b;

        /* JADX INFO: renamed from: c */
        private final String f6479c;

        /* JADX INFO: renamed from: d */
        private final HashMap<Object, Integer> f6480d;

        /* JADX INFO: renamed from: e */
        private boolean f6481e;

        /* JADX INFO: renamed from: f */
        private String f6482f;

        private zza(String[] strArr, String str) {
            this.f6477a = (String[]) zzbq.m7373a(strArr);
            this.f6478b = new ArrayList<>();
            this.f6479c = str;
            this.f6480d = new HashMap<>();
            this.f6481e = false;
            this.f6482f = null;
        }

        /* synthetic */ zza(String[] strArr, String str, zze zzeVar) {
            this(strArr, null);
        }
    }

    public static class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.f6475i = false;
        this.f6476j = true;
        this.f6468b = i;
        this.f6469c = strArr;
        this.f6471e = cursorWindowArr;
        this.f6472f = i2;
        this.f6473g = bundle;
    }

    private DataHolder(zza zzaVar, int i, Bundle bundle) {
        this(zzaVar.f6477a, m7267a(zzaVar, -1), i, null);
    }

    private DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.f6475i = false;
        this.f6476j = true;
        this.f6468b = 1;
        this.f6469c = (String[]) zzbq.m7373a(strArr);
        this.f6471e = (CursorWindow[]) zzbq.m7373a(cursorWindowArr);
        this.f6472f = i;
        this.f6473g = bundle;
        m7271a();
    }

    /* JADX INFO: renamed from: a */
    private final void m7266a(String str, int i) {
        if (this.f6470d == null || !this.f6470d.containsKey(str)) {
            String strValueOf = String.valueOf(str);
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "No such column: ".concat(strValueOf) : new String("No such column: "));
        }
        if (m7277d()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i < 0 || i >= this.f6467a) {
            throw new CursorIndexOutOfBoundsException(i, this.f6467a);
        }
    }

    /* JADX INFO: renamed from: a */
    private static CursorWindow[] m7267a(zza zzaVar, int i) {
        int i2;
        boolean z;
        CursorWindow cursorWindow;
        if (zzaVar.f6477a.length == 0) {
            return new CursorWindow[0];
        }
        ArrayList arrayList = zzaVar.f6478b;
        int size = arrayList.size();
        CursorWindow cursorWindow2 = new CursorWindow(false);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(cursorWindow2);
        cursorWindow2.setNumColumns(zzaVar.f6477a.length);
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            try {
                if (!cursorWindow2.allocRow()) {
                    Log.d("DataHolder", new StringBuilder(72).append("Allocating additional cursor window for large data set (row ").append(i3).append(")").toString());
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i3);
                    cursorWindow2.setNumColumns(zzaVar.f6477a.length);
                    arrayList2.add(cursorWindow2);
                    if (!cursorWindow2.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList2.remove(cursorWindow2);
                        return (CursorWindow[]) arrayList2.toArray(new CursorWindow[arrayList2.size()]);
                    }
                }
                Map map = (Map) arrayList.get(i3);
                boolean zPutDouble = true;
                for (int i4 = 0; i4 < zzaVar.f6477a.length && zPutDouble; i4++) {
                    String str = zzaVar.f6477a[i4];
                    Object obj = map.get(str);
                    if (obj == null) {
                        zPutDouble = cursorWindow2.putNull(i3, i4);
                    } else if (obj instanceof String) {
                        zPutDouble = cursorWindow2.putString((String) obj, i3, i4);
                    } else if (obj instanceof Long) {
                        zPutDouble = cursorWindow2.putLong(((Long) obj).longValue(), i3, i4);
                    } else if (obj instanceof Integer) {
                        zPutDouble = cursorWindow2.putLong(((Integer) obj).intValue(), i3, i4);
                    } else if (obj instanceof Boolean) {
                        zPutDouble = cursorWindow2.putLong(((Boolean) obj).booleanValue() ? 1L : 0L, i3, i4);
                    } else if (obj instanceof byte[]) {
                        zPutDouble = cursorWindow2.putBlob((byte[]) obj, i3, i4);
                    } else if (obj instanceof Double) {
                        zPutDouble = cursorWindow2.putDouble(((Double) obj).doubleValue(), i3, i4);
                    } else {
                        if (!(obj instanceof Float)) {
                            String strValueOf = String.valueOf(obj);
                            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(strValueOf).length()).append("Unsupported object for column ").append(str).append(": ").append(strValueOf).toString());
                        }
                        zPutDouble = cursorWindow2.putDouble(((Float) obj).floatValue(), i3, i4);
                    }
                }
                if (zPutDouble) {
                    i2 = i3;
                    z = false;
                    cursorWindow = cursorWindow2;
                } else {
                    if (z2) {
                        throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                    }
                    Log.d("DataHolder", new StringBuilder(74).append("Couldn't populate window data for row ").append(i3).append(" - allocating new window.").toString());
                    cursorWindow2.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setStartPosition(i3);
                    cursorWindow3.setNumColumns(zzaVar.f6477a.length);
                    arrayList2.add(cursorWindow3);
                    i2 = i3 - 1;
                    cursorWindow = cursorWindow3;
                    z = true;
                }
                z2 = z;
                cursorWindow2 = cursorWindow;
                i3 = i2 + 1;
            } catch (RuntimeException e) {
                int size2 = arrayList2.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    ((CursorWindow) arrayList2.get(i5)).close();
                }
                throw e;
            }
        }
        return (CursorWindow[]) arrayList2.toArray(new CursorWindow[arrayList2.size()]);
    }

    /* JADX INFO: renamed from: b */
    public static DataHolder m7268b(int i) {
        return new DataHolder(f6466k, i, null);
    }

    /* JADX INFO: renamed from: a */
    public final int m7269a(int i) {
        int i2 = 0;
        zzbq.m7378a(i >= 0 && i < this.f6467a);
        while (true) {
            if (i2 >= this.f6474h.length) {
                break;
            }
            if (i < this.f6474h[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.f6474h.length ? i2 - 1 : i2;
    }

    /* JADX INFO: renamed from: a */
    public final int m7270a(String str, int i, int i2) {
        m7266a(str, i);
        return this.f6471e[i2].getInt(i, this.f6470d.getInt(str));
    }

    /* JADX INFO: renamed from: a */
    public final void m7271a() {
        this.f6470d = new Bundle();
        for (int i = 0; i < this.f6469c.length; i++) {
            this.f6470d.putInt(this.f6469c[i], i);
        }
        this.f6474h = new int[this.f6471e.length];
        int numRows = 0;
        for (int i2 = 0; i2 < this.f6471e.length; i2++) {
            this.f6474h[i2] = numRows;
            numRows += this.f6471e[i2].getNumRows() - (numRows - this.f6471e[i2].getStartPosition());
        }
        this.f6467a = numRows;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m7272a(String str) {
        return this.f6470d.containsKey(str);
    }

    /* JADX INFO: renamed from: b */
    public final int m7273b() {
        return this.f6472f;
    }

    /* JADX INFO: renamed from: b */
    public final String m7274b(String str, int i, int i2) {
        m7266a(str, i);
        return this.f6471e[i2].getString(i, this.f6470d.getInt(str));
    }

    /* JADX INFO: renamed from: c */
    public final float m7275c(String str, int i, int i2) {
        m7266a(str, i);
        return this.f6471e[i2].getFloat(i, this.f6470d.getInt(str));
    }

    /* JADX INFO: renamed from: c */
    public final Bundle m7276c() {
        return this.f6473g;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            if (!this.f6475i) {
                this.f6475i = true;
                for (int i = 0; i < this.f6471e.length; i++) {
                    this.f6471e[i].close();
                }
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final boolean m7277d() {
        boolean z;
        synchronized (this) {
            z = this.f6475i;
        }
        return z;
    }

    /* JADX INFO: renamed from: d */
    public final byte[] m7278d(String str, int i, int i2) {
        m7266a(str, i);
        return this.f6471e[i2].getBlob(i, this.f6470d.getInt(str));
    }

    /* JADX INFO: renamed from: e */
    public final boolean m7279e(String str, int i, int i2) {
        m7266a(str, i);
        return this.f6471e[i2].isNull(i, this.f6470d.getInt(str));
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.f6476j && this.f6471e.length > 0 && !m7277d()) {
                close();
                String string = toString();
                Log.e("DataBuffer", new StringBuilder(String.valueOf(string).length() + 178).append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ").append(string).append(")").toString());
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7755a(parcel, 1, this.f6469c, false);
        zzbfp.m7754a(parcel, 2, (Parcelable[]) this.f6471e, i, false);
        zzbfp.m7738a(parcel, 3, this.f6472f);
        zzbfp.m7740a(parcel, 4, this.f6473g, false);
        zzbfp.m7738a(parcel, 1000, this.f6468b);
        zzbfp.m7734a(parcel, iM7733a);
        if ((i & 1) != 0) {
            close();
        }
    }
}
