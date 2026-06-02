package com.fasterxml.jackson.core.sym;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class BytesToNameCanonicalizer {

    /* JADX INFO: renamed from: a */
    protected final BytesToNameCanonicalizer f5622a = null;

    /* JADX INFO: renamed from: b */
    protected final AtomicReference<TableInfo> f5623b;

    /* JADX INFO: renamed from: c */
    protected boolean f5624c;

    /* JADX INFO: renamed from: d */
    protected final boolean f5625d;

    /* JADX INFO: renamed from: e */
    private final int f5626e;

    private static final class Bucket {
    }

    private BytesToNameCanonicalizer(int i, boolean z, int i2, boolean z2) {
        int i3 = 16;
        this.f5626e = i2;
        this.f5624c = z;
        this.f5625d = z2;
        if (i < 16) {
            i = 16;
        } else if (((i - 1) & i) != 0) {
            while (i3 < i) {
                i3 += i3;
            }
            i = i3;
        }
        this.f5623b = new AtomicReference<>(m6425b(i));
    }

    /* JADX INFO: renamed from: b */
    private TableInfo m6425b(int i) {
        return new TableInfo(0, i - 1, new int[i], new Name[i], null, 0, 0, 0);
    }

    /* JADX INFO: renamed from: a */
    public static BytesToNameCanonicalizer m6423a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return m6424a((((int) (jCurrentTimeMillis >>> 32)) + ((int) jCurrentTimeMillis)) | 1);
    }

    /* JADX INFO: renamed from: a */
    protected static BytesToNameCanonicalizer m6424a(int i) {
        return new BytesToNameCanonicalizer(64, true, i, true);
    }

    private static final class TableInfo {

        /* JADX INFO: renamed from: a */
        public final int f5627a;

        /* JADX INFO: renamed from: b */
        public final int f5628b;

        /* JADX INFO: renamed from: c */
        public final int[] f5629c;

        /* JADX INFO: renamed from: d */
        public final Name[] f5630d;

        /* JADX INFO: renamed from: e */
        public final Bucket[] f5631e;

        /* JADX INFO: renamed from: f */
        public final int f5632f;

        /* JADX INFO: renamed from: g */
        public final int f5633g;

        /* JADX INFO: renamed from: h */
        public final int f5634h;

        public TableInfo(int i, int i2, int[] iArr, Name[] nameArr, Bucket[] bucketArr, int i3, int i4, int i5) {
            this.f5627a = i;
            this.f5628b = i2;
            this.f5629c = iArr;
            this.f5630d = nameArr;
            this.f5631e = bucketArr;
            this.f5632f = i3;
            this.f5633g = i4;
            this.f5634h = i5;
        }
    }
}
