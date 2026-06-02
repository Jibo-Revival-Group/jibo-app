package okhttp3.internal.http2;

import okhttp3.internal.Util;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class Header {

    /* JADX INFO: renamed from: a */
    public static final ByteString f15409a = ByteString.m16317a(":");

    /* JADX INFO: renamed from: b */
    public static final ByteString f15410b = ByteString.m16317a(":status");

    /* JADX INFO: renamed from: c */
    public static final ByteString f15411c = ByteString.m16317a(":method");

    /* JADX INFO: renamed from: d */
    public static final ByteString f15412d = ByteString.m16317a(":path");

    /* JADX INFO: renamed from: e */
    public static final ByteString f15413e = ByteString.m16317a(":scheme");

    /* JADX INFO: renamed from: f */
    public static final ByteString f15414f = ByteString.m16317a(":authority");

    /* JADX INFO: renamed from: g */
    public final ByteString f15415g;

    /* JADX INFO: renamed from: h */
    public final ByteString f15416h;

    /* JADX INFO: renamed from: i */
    final int f15417i;

    public Header(String str, String str2) {
        this(ByteString.m16317a(str), ByteString.m16317a(str2));
    }

    public Header(ByteString byteString, String str) {
        this(byteString, ByteString.m16317a(str));
    }

    public Header(ByteString byteString, ByteString byteString2) {
        this.f15415g = byteString;
        this.f15416h = byteString2;
        this.f15417i = byteString.mo16336h() + 32 + byteString2.mo16336h();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return this.f15415g.equals(header.f15415g) && this.f15416h.equals(header.f15416h);
    }

    public int hashCode() {
        return ((this.f15415g.hashCode() + 527) * 31) + this.f15416h.hashCode();
    }

    public String toString() {
        return Util.m15836a("%s: %s", this.f15415g.mo16323a(), this.f15416h.mo16323a());
    }
}
