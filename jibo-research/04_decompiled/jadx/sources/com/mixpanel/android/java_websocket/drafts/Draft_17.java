package com.mixpanel.android.java_websocket.drafts;

import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;

/* JADX INFO: loaded from: classes.dex */
public class Draft_17 extends Draft_10 {
    @Override // com.mixpanel.android.java_websocket.drafts.Draft_10, com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: a */
    public Draft.HandshakeState mo11590a(ClientHandshake clientHandshake) throws InvalidHandshakeException {
        return m11609b(clientHandshake) == 13 ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_10, com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: a */
    public ClientHandshakeBuilder mo11592a(ClientHandshakeBuilder clientHandshakeBuilder) {
        super.mo11592a(clientHandshakeBuilder);
        clientHandshakeBuilder.mo11634a("Sec-WebSocket-Version", "13");
        return clientHandshakeBuilder;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_10, com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: c */
    public Draft mo11602c() {
        return new Draft_17();
    }
}
