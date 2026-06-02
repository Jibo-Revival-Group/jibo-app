package com.mixpanel.android.java_websocket;

import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.framing.FramedataImpl1;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.HandshakeImpl1Server;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import java.net.InetSocketAddress;

/* JADX INFO: loaded from: classes.dex */
public abstract class WebSocketAdapter implements WebSocketListener {
    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    /* JADX INFO: renamed from: a */
    public ServerHandshakeBuilder mo11527a(WebSocket webSocket, Draft draft, ClientHandshake clientHandshake) throws InvalidDataException {
        return new HandshakeImpl1Server();
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    /* JADX INFO: renamed from: a */
    public void mo11531a(WebSocket webSocket, ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidDataException {
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    /* JADX INFO: renamed from: a */
    public void mo11530a(WebSocket webSocket, ClientHandshake clientHandshake) throws InvalidDataException {
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    /* JADX INFO: renamed from: a */
    public void mo11529a(WebSocket webSocket, Framedata framedata) {
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    /* JADX INFO: renamed from: b */
    public void mo11532b(WebSocket webSocket, Framedata framedata) {
        FramedataImpl1 framedataImpl1 = new FramedataImpl1(framedata);
        framedataImpl1.mo11627a(Framedata.Opcode.PONG);
        webSocket.mo11526a(framedataImpl1);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    /* JADX INFO: renamed from: c */
    public void mo11533c(WebSocket webSocket, Framedata framedata) {
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    /* JADX INFO: renamed from: a */
    public String mo11528a(WebSocket webSocket) throws InvalidDataException {
        InetSocketAddress inetSocketAddressMo11525a = webSocket.mo11525a();
        if (inetSocketAddressMo11525a == null) {
            throw new InvalidHandshakeException("socket not bound");
        }
        StringBuffer stringBuffer = new StringBuffer(90);
        stringBuffer.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
        stringBuffer.append(inetSocketAddressMo11525a.getPort());
        stringBuffer.append("\" /></cross-domain-policy>\u0000");
        return stringBuffer.toString();
    }
}
