package com.mixpanel.android.java_websocket;

import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface WebSocketListener {
    /* JADX INFO: renamed from: a */
    ServerHandshakeBuilder mo11527a(WebSocket webSocket, Draft draft, ClientHandshake clientHandshake) throws InvalidDataException;

    /* JADX INFO: renamed from: a */
    String mo11528a(WebSocket webSocket) throws InvalidDataException;

    /* JADX INFO: renamed from: a */
    void mo11557a(WebSocket webSocket, int i, String str);

    /* JADX INFO: renamed from: a */
    void mo11558a(WebSocket webSocket, int i, String str, boolean z);

    /* JADX INFO: renamed from: a */
    void mo11529a(WebSocket webSocket, Framedata framedata);

    /* JADX INFO: renamed from: a */
    void mo11530a(WebSocket webSocket, ClientHandshake clientHandshake) throws InvalidDataException;

    /* JADX INFO: renamed from: a */
    void mo11531a(WebSocket webSocket, ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidDataException;

    /* JADX INFO: renamed from: a */
    void mo11559a(WebSocket webSocket, Handshakedata handshakedata);

    /* JADX INFO: renamed from: a */
    void mo11560a(WebSocket webSocket, Exception exc);

    /* JADX INFO: renamed from: a */
    void mo11561a(WebSocket webSocket, String str);

    /* JADX INFO: renamed from: a */
    void mo11562a(WebSocket webSocket, ByteBuffer byteBuffer);

    /* JADX INFO: renamed from: b */
    void mo11563b(WebSocket webSocket);

    /* JADX INFO: renamed from: b */
    void mo11564b(WebSocket webSocket, int i, String str, boolean z);

    /* JADX INFO: renamed from: b */
    void mo11532b(WebSocket webSocket, Framedata framedata);

    /* JADX INFO: renamed from: c */
    InetSocketAddress mo11565c(WebSocket webSocket);

    /* JADX INFO: renamed from: c */
    void mo11533c(WebSocket webSocket, Framedata framedata);
}
