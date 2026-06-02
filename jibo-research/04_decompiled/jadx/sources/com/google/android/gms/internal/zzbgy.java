package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zza;
import com.google.android.gms.common.util.zzb;
import com.google.android.gms.common.util.zzo;
import com.google.android.gms.common.util.zzp;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class zzbgy extends zzbgq {
    public static final Parcelable.Creator<zzbgy> CREATOR = new zzbgz();

    /* JADX INFO: renamed from: a */
    private final int f6970a;

    /* JADX INFO: renamed from: b */
    private final Parcel f6971b;

    /* JADX INFO: renamed from: c */
    private final int f6972c = 2;

    /* JADX INFO: renamed from: d */
    private final zzbgt f6973d;

    /* JADX INFO: renamed from: e */
    private final String f6974e;

    /* JADX INFO: renamed from: f */
    private int f6975f;

    /* JADX INFO: renamed from: g */
    private int f6976g;

    zzbgy(int i, Parcel parcel, zzbgt zzbgtVar) {
        this.f6970a = i;
        this.f6971b = (Parcel) zzbq.m7373a(parcel);
        this.f6973d = zzbgtVar;
        if (this.f6973d == null) {
            this.f6974e = null;
        } else {
            this.f6974e = this.f6973d.m7799a();
        }
        this.f6975f = 2;
    }

    /* JADX INFO: renamed from: a */
    private static HashMap<String, String> m7802a(Bundle bundle) {
        HashMap<String, String> map = new HashMap<>();
        for (String str : bundle.keySet()) {
            map.put(str, bundle.getString(str));
        }
        return map;
    }

    /* JADX INFO: renamed from: a */
    private static void m7803a(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"").append(zzo.m7508a(obj.toString())).append("\"");
                return;
            case 8:
                sb.append("\"").append(zzb.m7493a((byte[]) obj)).append("\"");
                return;
            case 9:
                sb.append("\"").append(zzb.m7494b((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                zzp.m7509a(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException(new StringBuilder(26).append("Unknown type = ").append(i).toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private final void m7804a(StringBuilder sb, zzbgo<?, ?> zzbgoVar, Parcel parcel, int i) {
        double[] dArrCreateDoubleArray = null;
        BigInteger[] bigIntegerArr = null;
        int i2 = 0;
        if (!zzbgoVar.f6952d) {
            switch (zzbgoVar.f6951c) {
                case 0:
                    sb.append(zzbfn.m7712f(parcel, i));
                    return;
                case 1:
                    sb.append(zzbfn.m7716j(parcel, i));
                    return;
                case 2:
                    sb.append(zzbfn.m7714h(parcel, i));
                    return;
                case 3:
                    sb.append(zzbfn.m7717k(parcel, i));
                    return;
                case 4:
                    sb.append(zzbfn.m7719m(parcel, i));
                    return;
                case 5:
                    sb.append(zzbfn.m7721o(parcel, i));
                    return;
                case 6:
                    sb.append(zzbfn.m7709c(parcel, i));
                    return;
                case 7:
                    sb.append("\"").append(zzo.m7508a(zzbfn.m7722p(parcel, i))).append("\"");
                    return;
                case 8:
                    sb.append("\"").append(zzb.m7493a(zzbfn.m7725s(parcel, i))).append("\"");
                    return;
                case 9:
                    sb.append("\"").append(zzb.m7494b(zzbfn.m7725s(parcel, i)));
                    sb.append("\"");
                    return;
                case 10:
                    Bundle bundleM7724r = zzbfn.m7724r(parcel, i);
                    Set<String> setKeySet = bundleM7724r.keySet();
                    setKeySet.size();
                    sb.append("{");
                    Object[] objArr = true;
                    for (String str : setKeySet) {
                        if (objArr == false) {
                            sb.append(",");
                        }
                        sb.append("\"").append(str).append("\"");
                        sb.append(":");
                        sb.append("\"").append(zzo.m7508a(bundleM7724r.getString(str))).append("\"");
                        objArr = false;
                    }
                    sb.append("}");
                    return;
                case 11:
                    Parcel parcelM7697C = zzbfn.m7697C(parcel, i);
                    parcelM7697C.setDataPosition(0);
                    m7806a(sb, zzbgoVar.m7797c(), parcelM7697C);
                    return;
                default:
                    throw new IllegalStateException("Unknown field type out");
            }
        }
        sb.append("[");
        switch (zzbgoVar.f6951c) {
            case 0:
                int[] iArrM7728v = zzbfn.m7728v(parcel, i);
                int length = iArrM7728v.length;
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(",");
                    }
                    sb.append(Integer.toString(iArrM7728v[i2]));
                    i2++;
                }
                break;
            case 1:
                int iM7701a = zzbfn.m7701a(parcel, i);
                int iDataPosition = parcel.dataPosition();
                if (iM7701a != 0) {
                    int i3 = parcel.readInt();
                    bigIntegerArr = new BigInteger[i3];
                    while (i2 < i3) {
                        bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
                        i2++;
                    }
                    parcel.setDataPosition(iM7701a + iDataPosition);
                }
                zza.m7489a(sb, bigIntegerArr);
                break;
            case 2:
                zza.m7488a(sb, zzbfn.m7729w(parcel, i));
                break;
            case 3:
                zza.m7487a(sb, zzbfn.m7730x(parcel, i));
                break;
            case 4:
                int iM7701a2 = zzbfn.m7701a(parcel, i);
                int iDataPosition2 = parcel.dataPosition();
                if (iM7701a2 != 0) {
                    dArrCreateDoubleArray = parcel.createDoubleArray();
                    parcel.setDataPosition(iM7701a2 + iDataPosition2);
                }
                zza.m7486a(sb, dArrCreateDoubleArray);
                break;
            case 5:
                zza.m7489a(sb, zzbfn.m7731y(parcel, i));
                break;
            case 6:
                zza.m7491a(sb, zzbfn.m7727u(parcel, i));
                break;
            case 7:
                zza.m7490a(sb, zzbfn.m7732z(parcel, i));
                break;
            case 8:
            case 9:
            case 10:
                throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
            case 11:
                Parcel[] parcelArrM7698D = zzbfn.m7698D(parcel, i);
                int length2 = parcelArrM7698D.length;
                for (int i4 = 0; i4 < length2; i4++) {
                    if (i4 > 0) {
                        sb.append(",");
                    }
                    parcelArrM7698D[i4].setDataPosition(0);
                    m7806a(sb, zzbgoVar.m7797c(), parcelArrM7698D[i4]);
                }
                break;
            default:
                throw new IllegalStateException("Unknown field type out.");
        }
        sb.append("]");
    }

    /* JADX INFO: renamed from: a */
    private final void m7805a(StringBuilder sb, zzbgo<?, ?> zzbgoVar, Object obj) {
        if (!zzbgoVar.f6950b) {
            m7803a(sb, zzbgoVar.f6949a, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            m7803a(sb, zzbgoVar.f6949a, arrayList.get(i));
        }
        sb.append("]");
    }

    /* JADX INFO: renamed from: a */
    private final void m7806a(StringBuilder sb, Map<String, zzbgo<?, ?>> map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry<String, zzbgo<?, ?>> entry : map.entrySet()) {
            sparseArray.put(entry.getValue().f6954f, entry);
        }
        sb.append('{');
        int iM7700a = zzbfn.m7700a(parcel);
        boolean z = false;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            Map.Entry entry2 = (Map.Entry) sparseArray.get(65535 & i);
            if (entry2 != null) {
                if (z) {
                    sb.append(",");
                }
                String str = (String) entry2.getKey();
                zzbgo<?, ?> zzbgoVar = (zzbgo) entry2.getValue();
                sb.append("\"").append(str).append("\":");
                if (zzbgoVar.m7796b()) {
                    switch (zzbgoVar.f6951c) {
                        case 0:
                            m7805a(sb, zzbgoVar, m7780a(zzbgoVar, Integer.valueOf(zzbfn.m7712f(parcel, i))));
                            break;
                        case 1:
                            m7805a(sb, zzbgoVar, m7780a(zzbgoVar, zzbfn.m7716j(parcel, i)));
                            break;
                        case 2:
                            m7805a(sb, zzbgoVar, m7780a(zzbgoVar, Long.valueOf(zzbfn.m7714h(parcel, i))));
                            break;
                        case 3:
                            m7805a(sb, zzbgoVar, m7780a(zzbgoVar, Float.valueOf(zzbfn.m7717k(parcel, i))));
                            break;
                        case 4:
                            m7805a(sb, zzbgoVar, m7780a(zzbgoVar, Double.valueOf(zzbfn.m7719m(parcel, i))));
                            break;
                        case 5:
                            m7805a(sb, zzbgoVar, m7780a(zzbgoVar, zzbfn.m7721o(parcel, i)));
                            break;
                        case 6:
                            m7805a(sb, zzbgoVar, m7780a(zzbgoVar, Boolean.valueOf(zzbfn.m7709c(parcel, i))));
                            break;
                        case 7:
                            m7805a(sb, zzbgoVar, m7780a(zzbgoVar, zzbfn.m7722p(parcel, i)));
                            break;
                        case 8:
                        case 9:
                            m7805a(sb, zzbgoVar, m7780a(zzbgoVar, zzbfn.m7725s(parcel, i)));
                            break;
                        case 10:
                            m7805a(sb, zzbgoVar, m7780a(zzbgoVar, m7802a(zzbfn.m7724r(parcel, i))));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException(new StringBuilder(36).append("Unknown field out type = ").append(zzbgoVar.f6951c).toString());
                    }
                } else {
                    m7804a(sb, zzbgoVar, parcel, i);
                }
                z = true;
            }
        }
        if (parcel.dataPosition() != iM7700a) {
            throw new zzbfo(new StringBuilder(37).append("Overread allowed size end=").append(iM7700a).toString(), parcel);
        }
        sb.append('}');
    }

    /* JADX INFO: renamed from: b */
    private Parcel m7807b() {
        switch (this.f6975f) {
            case 0:
                this.f6976g = zzbfp.m7733a(this.f6971b);
            case 1:
                zzbfp.m7734a(this.f6971b, this.f6976g);
                this.f6975f = 2;
                break;
        }
        return this.f6971b;
    }

    @Override // com.google.android.gms.internal.zzbgq, com.google.android.gms.internal.zzbgn
    /* JADX INFO: renamed from: a */
    public final Object mo7783a(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.internal.zzbgn
    /* JADX INFO: renamed from: a */
    public final Map<String, zzbgo<?, ?>> mo6679a() {
        if (this.f6973d == null) {
            return null;
        }
        return this.f6973d.m7800a(this.f6974e);
    }

    @Override // com.google.android.gms.internal.zzbgq, com.google.android.gms.internal.zzbgn
    /* JADX INFO: renamed from: b */
    public final boolean mo7784b(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.internal.zzbgn
    public String toString() {
        zzbq.m7374a(this.f6973d, "Cannot convert to JSON on client side.");
        Parcel parcelM7807b = m7807b();
        parcelM7807b.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        m7806a(sb, this.f6973d.m7800a(this.f6974e), parcelM7807b);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbgt zzbgtVar;
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6970a);
        zzbfp.m7742a(parcel, 2, m7807b(), false);
        switch (this.f6972c) {
            case 0:
                zzbgtVar = null;
                break;
            case 1:
                zzbgtVar = this.f6973d;
                break;
            case 2:
                zzbgtVar = this.f6973d;
                break;
            default:
                throw new IllegalStateException(new StringBuilder(34).append("Invalid creation type: ").append(this.f6972c).toString());
        }
        zzbfp.m7743a(parcel, 3, (Parcelable) zzbgtVar, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
