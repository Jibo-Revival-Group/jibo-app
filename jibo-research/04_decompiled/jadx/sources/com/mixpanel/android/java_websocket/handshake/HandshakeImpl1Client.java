package com.mixpanel.android.java_websocket.handshake;

/* JADX INFO: loaded from: classes.dex */
public class HandshakeImpl1Client extends HandshakedataImpl1 implements ClientHandshakeBuilder {

    /* JADX INFO: renamed from: a */
    private String f11787a = "*";

    @Override // com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder
    /* JADX INFO: renamed from: a */
    public void mo11633a(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.f11787a = str;
    }

    @Override // com.mixpanel.android.java_websocket.handshake.ClientHandshake
    /* JADX INFO: renamed from: a */
    public String mo11632a() {
        return this.f11787a;
    }
}
