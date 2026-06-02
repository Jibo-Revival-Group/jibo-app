package com.mixpanel.android.java_websocket.handshake;

/* JADX INFO: loaded from: classes.dex */
public class HandshakeImpl1Server extends HandshakedataImpl1 implements ServerHandshakeBuilder {

    /* JADX INFO: renamed from: a */
    private short f11788a;

    /* JADX INFO: renamed from: b */
    private String f11789b;

    @Override // com.mixpanel.android.java_websocket.handshake.ServerHandshake
    /* JADX INFO: renamed from: a */
    public String mo11636a() {
        return this.f11789b;
    }

    @Override // com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder
    /* JADX INFO: renamed from: a */
    public void mo11637a(String str) {
        this.f11789b = str;
    }

    @Override // com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder
    /* JADX INFO: renamed from: a */
    public void mo11638a(short s) {
        this.f11788a = s;
    }
}
