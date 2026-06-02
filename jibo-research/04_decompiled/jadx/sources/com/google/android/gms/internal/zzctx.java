package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzctx extends zzbfm {
    public static final Parcelable.Creator<zzctx> CREATOR = new zzcud();

    /* JADX INFO: renamed from: a */
    private static byte[][] f7728a = new byte[0][];

    /* JADX INFO: renamed from: b */
    private static zzctx f7729b = new zzctx("", null, f7728a, f7728a, f7728a, f7728a, null, null);

    /* JADX INFO: renamed from: k */
    private static final zzcuc f7730k = new zzcty();

    /* JADX INFO: renamed from: l */
    private static final zzcuc f7731l = new zzctz();

    /* JADX INFO: renamed from: m */
    private static final zzcuc f7732m = new zzcua();

    /* JADX INFO: renamed from: n */
    private static final zzcuc f7733n = new zzcub();

    /* JADX INFO: renamed from: c */
    private String f7734c;

    /* JADX INFO: renamed from: d */
    private byte[] f7735d;

    /* JADX INFO: renamed from: e */
    private byte[][] f7736e;

    /* JADX INFO: renamed from: f */
    private byte[][] f7737f;

    /* JADX INFO: renamed from: g */
    private byte[][] f7738g;

    /* JADX INFO: renamed from: h */
    private byte[][] f7739h;

    /* JADX INFO: renamed from: i */
    private int[] f7740i;

    /* JADX INFO: renamed from: j */
    private byte[][] f7741j;

    public zzctx(String str, byte[] bArr, byte[][] bArr2, byte[][] bArr3, byte[][] bArr4, byte[][] bArr5, int[] iArr, byte[][] bArr6) {
        this.f7734c = str;
        this.f7735d = bArr;
        this.f7736e = bArr2;
        this.f7737f = bArr3;
        this.f7738g = bArr4;
        this.f7739h = bArr5;
        this.f7740i = iArr;
        this.f7741j = bArr6;
    }

    /* JADX INFO: renamed from: a */
    private static List<Integer> m8465a(int[] iArr) {
        if (iArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    private static List<String> m8466a(byte[][] bArr) {
        if (bArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte[] bArr2 : bArr) {
            arrayList.add(Base64.encodeToString(bArr2, 3));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    private static void m8467a(StringBuilder sb, String str, int[] iArr) {
        sb.append(str);
        sb.append("=");
        if (iArr == null) {
            sb.append("null");
            return;
        }
        sb.append("(");
        int length = iArr.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            int i2 = iArr[i];
            if (!z) {
                sb.append(", ");
            }
            sb.append(i2);
            i++;
            z = false;
        }
        sb.append(")");
    }

    /* JADX INFO: renamed from: a */
    private static void m8468a(StringBuilder sb, String str, byte[][] bArr) {
        sb.append(str);
        sb.append("=");
        if (bArr == null) {
            sb.append("null");
            return;
        }
        sb.append("(");
        int length = bArr.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            byte[] bArr2 = bArr[i];
            if (!z) {
                sb.append(", ");
            }
            sb.append("'");
            sb.append(Base64.encodeToString(bArr2, 3));
            sb.append("'");
            i++;
            z = false;
        }
        sb.append(")");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzctx)) {
            return false;
        }
        zzctx zzctxVar = (zzctx) obj;
        return zzcuh.m8470a(this.f7734c, zzctxVar.f7734c) && Arrays.equals(this.f7735d, zzctxVar.f7735d) && zzcuh.m8470a(m8466a(this.f7736e), m8466a(zzctxVar.f7736e)) && zzcuh.m8470a(m8466a(this.f7737f), m8466a(zzctxVar.f7737f)) && zzcuh.m8470a(m8466a(this.f7738g), m8466a(zzctxVar.f7738g)) && zzcuh.m8470a(m8466a(this.f7739h), m8466a(zzctxVar.f7739h)) && zzcuh.m8470a(m8465a(this.f7740i), m8465a(zzctxVar.f7740i)) && zzcuh.m8470a(m8466a(this.f7741j), m8466a(zzctxVar.f7741j));
    }

    public final String toString() {
        String string;
        StringBuilder sb = new StringBuilder("ExperimentTokens");
        sb.append("(");
        if (this.f7734c == null) {
            string = "null";
        } else {
            String str = this.f7734c;
            string = new StringBuilder(String.valueOf("'").length() + String.valueOf(str).length() + String.valueOf("'").length()).append("'").append(str).append("'").toString();
        }
        sb.append(string);
        sb.append(", ");
        byte[] bArr = this.f7735d;
        sb.append("direct");
        sb.append("=");
        if (bArr == null) {
            sb.append("null");
        } else {
            sb.append("'");
            sb.append(Base64.encodeToString(bArr, 3));
            sb.append("'");
        }
        sb.append(", ");
        m8468a(sb, "GAIA", this.f7736e);
        sb.append(", ");
        m8468a(sb, "PSEUDO", this.f7737f);
        sb.append(", ");
        m8468a(sb, "ALWAYS", this.f7738g);
        sb.append(", ");
        m8468a(sb, "OTHER", this.f7739h);
        sb.append(", ");
        m8467a(sb, "weak", this.f7740i);
        sb.append(", ");
        m8468a(sb, "directs", this.f7741j);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 2, this.f7734c, false);
        zzbfp.m7752a(parcel, 3, this.f7735d, false);
        zzbfp.m7756a(parcel, 4, this.f7736e, false);
        zzbfp.m7756a(parcel, 5, this.f7737f, false);
        zzbfp.m7756a(parcel, 6, this.f7738g, false);
        zzbfp.m7756a(parcel, 7, this.f7739h, false);
        zzbfp.m7753a(parcel, 8, this.f7740i, false);
        zzbfp.m7756a(parcel, 9, this.f7741j, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
