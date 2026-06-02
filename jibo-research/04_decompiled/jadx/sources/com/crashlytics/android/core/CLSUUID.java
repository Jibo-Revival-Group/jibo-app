package com.crashlytics.android.core;

import android.os.Process;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
class CLSUUID {

    /* JADX INFO: renamed from: a */
    private static final AtomicLong f5146a = new AtomicLong(0);

    /* JADX INFO: renamed from: b */
    private static String f5147b;

    public CLSUUID(IdManager idManager) {
        byte[] bArr = new byte[10];
        m5716a(bArr);
        m5718b(bArr);
        m5720c(bArr);
        String strM15179a = CommonUtils.m15179a(idManager.m15226b());
        String strM15181a = CommonUtils.m15181a(bArr);
        f5147b = String.format(Locale.US, "%s-%s-%s-%s", strM15181a.substring(0, 12), strM15181a.substring(12, 16), strM15181a.subSequence(16, 20), strM15179a.substring(0, 12)).toUpperCase(Locale.US);
    }

    /* JADX INFO: renamed from: a */
    private void m5716a(byte[] bArr) {
        long time = new Date().getTime();
        byte[] bArrM5717a = m5717a(time / 1000);
        bArr[0] = bArrM5717a[0];
        bArr[1] = bArrM5717a[1];
        bArr[2] = bArrM5717a[2];
        bArr[3] = bArrM5717a[3];
        byte[] bArrM5719b = m5719b(time % 1000);
        bArr[4] = bArrM5719b[0];
        bArr[5] = bArrM5719b[1];
    }

    /* JADX INFO: renamed from: b */
    private void m5718b(byte[] bArr) {
        byte[] bArrM5719b = m5719b(f5146a.incrementAndGet());
        bArr[6] = bArrM5719b[0];
        bArr[7] = bArrM5719b[1];
    }

    /* JADX INFO: renamed from: c */
    private void m5720c(byte[] bArr) {
        byte[] bArrM5719b = m5719b(Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = bArrM5719b[0];
        bArr[9] = bArrM5719b[1];
    }

    /* JADX INFO: renamed from: a */
    private static byte[] m5717a(long j) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt((int) j);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.position(0);
        return byteBufferAllocate.array();
    }

    /* JADX INFO: renamed from: b */
    private static byte[] m5719b(long j) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(2);
        byteBufferAllocate.putShort((short) j);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.position(0);
        return byteBufferAllocate.array();
    }

    public String toString() {
        return f5147b;
    }
}
