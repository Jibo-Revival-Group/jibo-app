package com.google.firebase.perf.network;

import com.google.android.gms.internal.zzevv;
import com.google.android.gms.internal.zzewn;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class zza extends InputStream {

    /* JADX INFO: renamed from: a */
    private final InputStream f8755a;

    /* JADX INFO: renamed from: b */
    private final zzevv f8756b;

    /* JADX INFO: renamed from: c */
    private final zzewn f8757c;

    /* JADX INFO: renamed from: e */
    private long f8759e;

    /* JADX INFO: renamed from: d */
    private long f8758d = -1;

    /* JADX INFO: renamed from: f */
    private long f8760f = -1;

    public zza(InputStream inputStream, zzevv zzevvVar, zzewn zzewnVar) {
        this.f8757c = zzewnVar;
        this.f8755a = inputStream;
        this.f8756b = zzevvVar;
        this.f8759e = this.f8756b.m8537c();
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        try {
            return this.f8755a.available();
        } catch (IOException e) {
            this.f8756b.m8543f(this.f8757c.m8602c());
            zzh.m9330a(this.f8756b);
            throw e;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        long jM8602c = this.f8757c.m8602c();
        if (this.f8760f == -1) {
            this.f8760f = jM8602c;
        }
        try {
            this.f8755a.close();
            if (this.f8758d != -1) {
                this.f8756b.m8535b(this.f8758d);
            }
            if (this.f8759e != -1) {
                this.f8756b.m8542e(this.f8759e);
            }
            this.f8756b.m8543f(this.f8760f);
            this.f8756b.m8541d();
        } catch (IOException e) {
            this.f8756b.m8543f(this.f8757c.m8602c());
            zzh.m9330a(this.f8756b);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.f8755a.mark(i);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f8755a.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        try {
            int i = this.f8755a.read();
            long jM8602c = this.f8757c.m8602c();
            if (this.f8759e == -1) {
                this.f8759e = jM8602c;
            }
            if (i == -1 && this.f8760f == -1) {
                this.f8760f = jM8602c;
                this.f8756b.m8543f(this.f8760f);
                this.f8756b.m8541d();
            } else {
                this.f8758d++;
                this.f8756b.m8535b(this.f8758d);
            }
            return i;
        } catch (IOException e) {
            this.f8756b.m8543f(this.f8757c.m8602c());
            zzh.m9330a(this.f8756b);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        try {
            int i = this.f8755a.read(bArr);
            long jM8602c = this.f8757c.m8602c();
            if (this.f8759e == -1) {
                this.f8759e = jM8602c;
            }
            if (i == -1 && this.f8760f == -1) {
                this.f8760f = jM8602c;
                this.f8756b.m8543f(this.f8760f);
                this.f8756b.m8541d();
            } else {
                this.f8758d += (long) i;
                this.f8756b.m8535b(this.f8758d);
            }
            return i;
        } catch (IOException e) {
            this.f8756b.m8543f(this.f8757c.m8602c());
            zzh.m9330a(this.f8756b);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            int i3 = this.f8755a.read(bArr, i, i2);
            long jM8602c = this.f8757c.m8602c();
            if (this.f8759e == -1) {
                this.f8759e = jM8602c;
            }
            if (i3 == -1 && this.f8760f == -1) {
                this.f8760f = jM8602c;
                this.f8756b.m8543f(this.f8760f);
                this.f8756b.m8541d();
            } else {
                this.f8758d += (long) i3;
                this.f8756b.m8535b(this.f8758d);
            }
            return i3;
        } catch (IOException e) {
            this.f8756b.m8543f(this.f8757c.m8602c());
            zzh.m9330a(this.f8756b);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final void reset() throws IOException {
        try {
            this.f8755a.reset();
        } catch (IOException e) {
            this.f8756b.m8543f(this.f8757c.m8602c());
            zzh.m9330a(this.f8756b);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final long skip(long j) throws IOException {
        try {
            long jSkip = this.f8755a.skip(j);
            long jM8602c = this.f8757c.m8602c();
            if (this.f8759e == -1) {
                this.f8759e = jM8602c;
            }
            if (jSkip == -1 && this.f8760f == -1) {
                this.f8760f = jM8602c;
                this.f8756b.m8543f(this.f8760f);
            } else {
                this.f8758d += jSkip;
                this.f8756b.m8535b(this.f8758d);
            }
            return jSkip;
        } catch (IOException e) {
            this.f8756b.m8543f(this.f8757c.m8602c());
            zzh.m9330a(this.f8756b);
            throw e;
        }
    }
}
