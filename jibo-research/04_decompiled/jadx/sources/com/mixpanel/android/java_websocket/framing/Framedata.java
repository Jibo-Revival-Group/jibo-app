package com.mixpanel.android.java_websocket.framing;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface Framedata {

    public enum Opcode {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    /* JADX INFO: renamed from: c */
    ByteBuffer mo11626c();

    /* JADX INFO: renamed from: d */
    boolean mo11629d();

    /* JADX INFO: renamed from: e */
    boolean mo11630e();

    /* JADX INFO: renamed from: f */
    Opcode mo11631f();
}
