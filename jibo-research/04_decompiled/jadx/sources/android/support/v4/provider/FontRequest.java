package android.support.v4.provider;

import android.support.v4.util.Preconditions;
import android.util.Base64;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class FontRequest {

    /* JADX INFO: renamed from: a */
    private final String f2118a;

    /* JADX INFO: renamed from: b */
    private final String f2119b;

    /* JADX INFO: renamed from: c */
    private final String f2120c;

    /* JADX INFO: renamed from: d */
    private final List<List<byte[]>> f2121d;

    /* JADX INFO: renamed from: e */
    private final int f2122e = 0;

    /* JADX INFO: renamed from: f */
    private final String f2123f;

    public FontRequest(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f2118a = (String) Preconditions.m2441a(str);
        this.f2119b = (String) Preconditions.m2441a(str2);
        this.f2120c = (String) Preconditions.m2441a(str3);
        this.f2121d = (List) Preconditions.m2441a(list);
        this.f2123f = this.f2118a + "-" + this.f2119b + "-" + this.f2120c;
    }

    /* JADX INFO: renamed from: a */
    public String m2326a() {
        return this.f2118a;
    }

    /* JADX INFO: renamed from: b */
    public String m2327b() {
        return this.f2119b;
    }

    /* JADX INFO: renamed from: c */
    public String m2328c() {
        return this.f2120c;
    }

    /* JADX INFO: renamed from: d */
    public List<List<byte[]>> m2329d() {
        return this.f2121d;
    }

    /* JADX INFO: renamed from: e */
    public int m2330e() {
        return this.f2122e;
    }

    /* JADX INFO: renamed from: f */
    public String m2331f() {
        return this.f2123f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f2118a + ", mProviderPackage: " + this.f2119b + ", mQuery: " + this.f2120c + ", mCertificates:");
        for (int i = 0; i < this.f2121d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.f2121d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f2122e);
        return sb.toString();
    }
}
