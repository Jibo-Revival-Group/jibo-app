package com.bumptech.glide.util;

import android.util.Log;
import com.facebook.internal.NativeProtocol;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public final class ByteArrayPool {

    /* JADX INFO: renamed from: b */
    private static final ByteArrayPool f4998b = new ByteArrayPool();

    /* JADX INFO: renamed from: a */
    private final Queue<byte[]> f4999a = Util.m5591a(0);

    /* JADX INFO: renamed from: a */
    public static ByteArrayPool m5571a() {
        return f4998b;
    }

    private ByteArrayPool() {
    }

    /* JADX INFO: renamed from: b */
    public byte[] m5573b() {
        byte[] bArrPoll;
        synchronized (this.f4999a) {
            bArrPoll = this.f4999a.poll();
        }
        if (bArrPoll == null) {
            bArrPoll = new byte[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST];
            if (Log.isLoggable("ByteArrayPool", 3)) {
                Log.d("ByteArrayPool", "Created temp bytes");
            }
        }
        return bArrPoll;
    }

    /* JADX INFO: renamed from: a */
    public boolean m5572a(byte[] bArr) {
        boolean z = false;
        if (bArr.length == 65536) {
            synchronized (this.f4999a) {
                if (this.f4999a.size() < 32) {
                    z = true;
                    this.f4999a.offer(bArr);
                }
            }
        }
        return z;
    }
}
