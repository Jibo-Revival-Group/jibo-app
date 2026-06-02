package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Credential extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<Credential> CREATOR = new zza();

    /* JADX INFO: renamed from: a */
    private final String f5909a;

    /* JADX INFO: renamed from: b */
    private final String f5910b;

    /* JADX INFO: renamed from: c */
    private final Uri f5911c;

    /* JADX INFO: renamed from: d */
    private final List<IdToken> f5912d;

    /* JADX INFO: renamed from: e */
    private final String f5913e;

    /* JADX INFO: renamed from: f */
    private final String f5914f;

    /* JADX INFO: renamed from: g */
    private final String f5915g;

    /* JADX INFO: renamed from: h */
    private final String f5916h;

    /* JADX INFO: renamed from: i */
    private final String f5917i;

    /* JADX INFO: renamed from: j */
    private final String f5918j;

    /* JADX WARN: Removed duplicated region for block: B:29:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    Credential(java.lang.String r6, java.lang.String r7, android.net.Uri r8, java.util.List<com.google.android.gms.auth.api.credentials.IdToken> r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15) {
        /*
            r5 = this;
            r1 = 0
            r5.<init>()
            java.lang.String r0 = "credential identifier cannot be null"
            java.lang.Object r0 = com.google.android.gms.common.internal.zzbq.m7374a(r6, r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = r0.trim()
            java.lang.String r0 = "credential identifier cannot be empty"
            com.google.android.gms.common.internal.zzbq.m7376a(r2, r0)
            if (r10 == 0) goto L25
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 == 0) goto L25
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Password must not be empty if set"
            r0.<init>(r1)
            throw r0
        L25:
            if (r11 == 0) goto L80
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto L7e
            android.net.Uri r0 = android.net.Uri.parse(r11)
            boolean r3 = r0.isAbsolute()
            if (r3 == 0) goto L51
            boolean r3 = r0.isHierarchical()
            if (r3 == 0) goto L51
            java.lang.String r3 = r0.getScheme()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L51
            java.lang.String r3 = r0.getAuthority()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L64
        L51:
            r0 = r1
        L52:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L80
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Account type must be a valid Http/Https URI"
            r0.<init>(r1)
            throw r0
        L64:
            java.lang.String r3 = "http"
            java.lang.String r4 = r0.getScheme()
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 != 0) goto L7c
            java.lang.String r3 = "https"
            java.lang.String r0 = r0.getScheme()
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 == 0) goto L7e
        L7c:
            r0 = 1
            goto L52
        L7e:
            r0 = r1
            goto L52
        L80:
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto L94
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L94
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Password and AccountType are mutually exclusive"
            r0.<init>(r1)
            throw r0
        L94:
            if (r7 == 0) goto La1
            java.lang.String r0 = r7.trim()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto La1
            r7 = 0
        La1:
            r5.f5910b = r7
            r5.f5911c = r8
            if (r9 != 0) goto Lbc
            java.util.List r0 = java.util.Collections.emptyList()
        Lab:
            r5.f5912d = r0
            r5.f5909a = r2
            r5.f5913e = r10
            r5.f5914f = r11
            r5.f5915g = r12
            r5.f5916h = r13
            r5.f5917i = r14
            r5.f5918j = r15
            return
        Lbc:
            java.util.List r0 = java.util.Collections.unmodifiableList(r9)
            goto Lab
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.credentials.Credential.<init>(java.lang.String, java.lang.String, android.net.Uri, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: renamed from: a */
    public String m6682a() {
        return this.f5909a;
    }

    /* JADX INFO: renamed from: b */
    public String m6683b() {
        return this.f5910b;
    }

    /* JADX INFO: renamed from: c */
    public Uri m6684c() {
        return this.f5911c;
    }

    /* JADX INFO: renamed from: d */
    public List<IdToken> m6685d() {
        return this.f5912d;
    }

    /* JADX INFO: renamed from: e */
    public String m6686e() {
        return this.f5913e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.f5909a, credential.f5909a) && TextUtils.equals(this.f5910b, credential.f5910b) && zzbg.m7371a(this.f5911c, credential.f5911c) && TextUtils.equals(this.f5913e, credential.f5913e) && TextUtils.equals(this.f5914f, credential.f5914f) && TextUtils.equals(this.f5915g, credential.f5915g);
    }

    /* JADX INFO: renamed from: f */
    public String m6687f() {
        return this.f5915g;
    }

    /* JADX INFO: renamed from: g */
    public String m6688g() {
        return this.f5914f;
    }

    /* JADX INFO: renamed from: h */
    public String m6689h() {
        return this.f5917i;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5909a, this.f5910b, this.f5911c, this.f5913e, this.f5914f, this.f5915g});
    }

    /* JADX INFO: renamed from: i */
    public String m6690i() {
        return this.f5918j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 1, m6682a(), false);
        zzbfp.m7748a(parcel, 2, m6683b(), false);
        zzbfp.m7743a(parcel, 3, (Parcelable) m6684c(), i, false);
        zzbfp.m7762c(parcel, 4, m6685d(), false);
        zzbfp.m7748a(parcel, 5, m6686e(), false);
        zzbfp.m7748a(parcel, 6, m6688g(), false);
        zzbfp.m7748a(parcel, 7, m6687f(), false);
        zzbfp.m7748a(parcel, 8, this.f5916h, false);
        zzbfp.m7748a(parcel, 9, m6689h(), false);
        zzbfp.m7748a(parcel, 10, m6690i(), false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
