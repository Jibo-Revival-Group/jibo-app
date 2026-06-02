package com.google.firebase.perf.network;

import com.google.android.gms.internal.zzevv;
import com.google.android.gms.internal.zzewn;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class zzb extends OutputStream {

    /* JADX INFO: renamed from: a */
    private OutputStream f8761a;

    /* JADX INFO: renamed from: b */
    private long f8762b = -1;

    /* JADX INFO: renamed from: c */
    private zzevv f8763c;

    /* JADX INFO: renamed from: d */
    private final zzewn f8764d;

    public zzb(OutputStream outputStream, zzevv zzevvVar, zzewn zzewnVar) {
        this.f8761a = outputStream;
        this.f8763c = zzevvVar;
        this.f8764d = zzewnVar;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f8762b != -1) {
            this.f8763c.m8531a(this.f8762b);
        }
        this.f8763c.m8540d(this.f8764d.m8602c());
        try {
            this.f8761a.close();
        } catch (IOException e) {
            this.f8763c.m8543f(this.f8764d.m8602c());
            zzh.m9330a(this.f8763c);
            throw e;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        try {
            this.f8761a.flush();
        } catch (IOException e) {
            this.f8763c.m8543f(this.f8764d.m8602c());
            zzh.m9330a(this.f8763c);
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        try {
            this.f8761a.write(i);
            this.f8762b++;
            this.f8763c.m8531a(this.f8762b);
        } catch (IOException e) {
            this.f8763c.m8543f(this.f8764d.m8602c());
            zzh.m9330a(this.f8763c);
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        try {
            this.f8761a.write(bArr);
            this.f8762b += (long) bArr.length;
            this.f8763c.m8531a(this.f8762b);
        } catch (IOException e) {
            this.f8763c.m8543f(this.f8764d.m8602c());
            zzh.m9330a(this.f8763c);
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.f8761a.write(bArr, i, i2);
            this.f8762b += (long) i2;
            this.f8763c.m8531a(this.f8762b);
        } catch (IOException e) {
            this.f8763c.m8543f(this.f8764d.m8602c());
            zzh.m9330a(this.f8763c);
            throw e;
        }
    }
}
