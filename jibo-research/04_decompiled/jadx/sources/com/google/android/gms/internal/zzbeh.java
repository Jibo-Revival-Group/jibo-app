package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzbeh extends zzbfm {
    public static final Parcelable.Creator<zzbeh> CREATOR = new zzbei();

    /* JADX INFO: renamed from: a */
    public zzbew f6893a;

    /* JADX INFO: renamed from: b */
    public byte[] f6894b;

    /* JADX INFO: renamed from: c */
    public final zzfkq f6895c;

    /* JADX INFO: renamed from: d */
    public final zzbec f6896d;

    /* JADX INFO: renamed from: e */
    public final zzbec f6897e;

    /* JADX INFO: renamed from: f */
    private int[] f6898f;

    /* JADX INFO: renamed from: g */
    private String[] f6899g;

    /* JADX INFO: renamed from: h */
    private int[] f6900h;

    /* JADX INFO: renamed from: i */
    private byte[][] f6901i;

    /* JADX INFO: renamed from: j */
    private zzctx[] f6902j;

    /* JADX INFO: renamed from: k */
    private boolean f6903k;

    public zzbeh(zzbew zzbewVar, zzfkq zzfkqVar, zzbec zzbecVar, zzbec zzbecVar2, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr, zzctx[] zzctxVarArr, boolean z) {
        this.f6893a = zzbewVar;
        this.f6895c = zzfkqVar;
        this.f6896d = zzbecVar;
        this.f6897e = null;
        this.f6898f = iArr;
        this.f6899g = null;
        this.f6900h = iArr2;
        this.f6901i = null;
        this.f6902j = null;
        this.f6903k = z;
    }

    zzbeh(zzbew zzbewVar, byte[] bArr, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr2, boolean z, zzctx[] zzctxVarArr) {
        this.f6893a = zzbewVar;
        this.f6894b = bArr;
        this.f6898f = iArr;
        this.f6899g = strArr;
        this.f6895c = null;
        this.f6896d = null;
        this.f6897e = null;
        this.f6900h = iArr2;
        this.f6901i = bArr2;
        this.f6902j = zzctxVarArr;
        this.f6903k = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbeh)) {
            return false;
        }
        zzbeh zzbehVar = (zzbeh) obj;
        return zzbg.m7371a(this.f6893a, zzbehVar.f6893a) && Arrays.equals(this.f6894b, zzbehVar.f6894b) && Arrays.equals(this.f6898f, zzbehVar.f6898f) && Arrays.equals(this.f6899g, zzbehVar.f6899g) && zzbg.m7371a(this.f6895c, zzbehVar.f6895c) && zzbg.m7371a(this.f6896d, zzbehVar.f6896d) && zzbg.m7371a(this.f6897e, zzbehVar.f6897e) && Arrays.equals(this.f6900h, zzbehVar.f6900h) && Arrays.deepEquals(this.f6901i, zzbehVar.f6901i) && Arrays.equals(this.f6902j, zzbehVar.f6902j) && this.f6903k == zzbehVar.f6903k;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6893a, this.f6894b, this.f6898f, this.f6899g, this.f6895c, this.f6896d, this.f6897e, this.f6900h, this.f6901i, this.f6902j, Boolean.valueOf(this.f6903k)});
    }

    public final String toString() {
        return "LogEventParcelable[" + this.f6893a + ", LogEventBytes: " + (this.f6894b == null ? null : new String(this.f6894b)) + ", TestCodes: " + Arrays.toString(this.f6898f) + ", MendelPackages: " + Arrays.toString(this.f6899g) + ", LogEvent: " + this.f6895c + ", ExtensionProducer: " + this.f6896d + ", VeProducer: " + this.f6897e + ", ExperimentIDs: " + Arrays.toString(this.f6900h) + ", ExperimentTokens: " + Arrays.toString(this.f6901i) + ", ExperimentTokensParcelables: " + Arrays.toString(this.f6902j) + ", AddPhenotypeExperimentTokens: " + this.f6903k + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7743a(parcel, 2, (Parcelable) this.f6893a, i, false);
        zzbfp.m7752a(parcel, 3, this.f6894b, false);
        zzbfp.m7753a(parcel, 4, this.f6898f, false);
        zzbfp.m7755a(parcel, 5, this.f6899g, false);
        zzbfp.m7753a(parcel, 6, this.f6900h, false);
        zzbfp.m7756a(parcel, 7, this.f6901i, false);
        zzbfp.m7751a(parcel, 8, this.f6903k);
        zzbfp.m7754a(parcel, 9, (Parcelable[]) this.f6902j, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
