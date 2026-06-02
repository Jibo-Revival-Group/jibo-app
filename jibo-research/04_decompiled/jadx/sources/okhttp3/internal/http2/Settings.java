package okhttp3.internal.http2;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class Settings {

    /* JADX INFO: renamed from: a */
    private int f15575a;

    /* JADX INFO: renamed from: b */
    private final int[] f15576b = new int[10];

    /* JADX INFO: renamed from: a */
    void m16159a() {
        this.f15575a = 0;
        Arrays.fill(this.f15576b, 0);
    }

    /* JADX INFO: renamed from: a */
    Settings m16158a(int i, int i2) {
        if (i < this.f15576b.length) {
            this.f15575a = (1 << i) | this.f15575a;
            this.f15576b[i] = i2;
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    boolean m16161a(int i) {
        return ((1 << i) & this.f15575a) != 0;
    }

    /* JADX INFO: renamed from: b */
    int m16163b(int i) {
        return this.f15576b[i];
    }

    /* JADX INFO: renamed from: b */
    int m16162b() {
        return Integer.bitCount(this.f15575a);
    }

    /* JADX INFO: renamed from: c */
    int m16164c() {
        if ((2 & this.f15575a) != 0) {
            return this.f15576b[1];
        }
        return -1;
    }

    /* JADX INFO: renamed from: c */
    int m16165c(int i) {
        return (16 & this.f15575a) != 0 ? this.f15576b[4] : i;
    }

    /* JADX INFO: renamed from: d */
    int m16167d(int i) {
        return (32 & this.f15575a) != 0 ? this.f15576b[5] : i;
    }

    /* JADX INFO: renamed from: d */
    int m16166d() {
        if ((128 & this.f15575a) != 0) {
            return this.f15576b[7];
        }
        return 65535;
    }

    /* JADX INFO: renamed from: a */
    void m16160a(Settings settings) {
        for (int i = 0; i < 10; i++) {
            if (settings.m16161a(i)) {
                m16158a(i, settings.m16163b(i));
            }
        }
    }
}
