package com.mixpanel.android.java_websocket.drafts;

import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.framing.FramedataImpl1;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.apache.http.HttpHeaders;

/* JADX INFO: loaded from: classes.dex */
public class Draft_75 extends Draft {

    /* JADX INFO: renamed from: h */
    protected ByteBuffer f11772h;

    /* JADX INFO: renamed from: f */
    protected boolean f11770f = false;

    /* JADX INFO: renamed from: g */
    protected List<Framedata> f11771g = new LinkedList();

    /* JADX INFO: renamed from: i */
    private final Random f11773i = new Random();

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: a */
    public Draft.HandshakeState mo11591a(ClientHandshake clientHandshake, ServerHandshake serverHandshake) {
        return (clientHandshake.mo11639b("WebSocket-Origin").equals(serverHandshake.mo11639b("Origin")) && m11600a(serverHandshake)) ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: a */
    public Draft.HandshakeState mo11590a(ClientHandshake clientHandshake) {
        return (clientHandshake.mo11641c("Origin") && m11600a((Handshakedata) clientHandshake)) ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: a */
    public ByteBuffer mo11594a(Framedata framedata) {
        if (framedata.mo11631f() != Framedata.Opcode.TEXT) {
            throw new RuntimeException("only text frames supported");
        }
        ByteBuffer byteBufferMo11626c = framedata.mo11626c();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBufferMo11626c.remaining() + 2);
        byteBufferAllocate.put((byte) 0);
        byteBufferMo11626c.mark();
        byteBufferAllocate.put(byteBufferMo11626c);
        byteBufferMo11626c.reset();
        byteBufferAllocate.put((byte) -1);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: a */
    public ClientHandshakeBuilder mo11592a(ClientHandshakeBuilder clientHandshakeBuilder) throws InvalidHandshakeException {
        clientHandshakeBuilder.mo11634a(HttpHeaders.UPGRADE, "WebSocket");
        clientHandshakeBuilder.mo11634a("Connection", HttpHeaders.UPGRADE);
        if (!clientHandshakeBuilder.mo11641c("Origin")) {
            clientHandshakeBuilder.mo11634a("Origin", "random" + this.f11773i.nextInt());
        }
        return clientHandshakeBuilder;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: a */
    public HandshakeBuilder mo11593a(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException {
        serverHandshakeBuilder.mo11637a("Web Socket Protocol Handshake");
        serverHandshakeBuilder.mo11634a(HttpHeaders.UPGRADE, "WebSocket");
        serverHandshakeBuilder.mo11634a("Connection", clientHandshake.mo11639b("Connection"));
        serverHandshakeBuilder.mo11634a("WebSocket-Origin", clientHandshake.mo11639b("Origin"));
        serverHandshakeBuilder.mo11634a("WebSocket-Location", "ws://" + clientHandshake.mo11639b("Host") + clientHandshake.mo11632a());
        return serverHandshakeBuilder;
    }

    /* JADX INFO: renamed from: e */
    protected List<Framedata> m11613e(ByteBuffer byteBuffer) throws InvalidDataException {
        while (byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get();
            if (b == 0) {
                if (this.f11770f) {
                    throw new InvalidFrameException("unexpected START_OF_FRAME");
                }
                this.f11770f = true;
            } else if (b == -1) {
                if (!this.f11770f) {
                    throw new InvalidFrameException("unexpected END_OF_FRAME");
                }
                if (this.f11772h != null) {
                    this.f11772h.flip();
                    FramedataImpl1 framedataImpl1 = new FramedataImpl1();
                    framedataImpl1.mo11625a(this.f11772h);
                    framedataImpl1.mo11628a(true);
                    framedataImpl1.mo11627a(Framedata.Opcode.TEXT);
                    this.f11771g.add(framedataImpl1);
                    this.f11772h = null;
                    byteBuffer.mark();
                }
                this.f11770f = false;
            } else {
                if (!this.f11770f) {
                    return null;
                }
                if (this.f11772h == null) {
                    this.f11772h = m11612d();
                } else if (!this.f11772h.hasRemaining()) {
                    this.f11772h = m11614f(this.f11772h);
                }
                this.f11772h.put(b);
            }
        }
        List<Framedata> list = this.f11771g;
        this.f11771g = new LinkedList();
        return list;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: c */
    public List<Framedata> mo11603c(ByteBuffer byteBuffer) throws InvalidDataException {
        List<Framedata> listM11613e = m11613e(byteBuffer);
        if (listM11613e == null) {
            throw new InvalidDataException(1002);
        }
        return listM11613e;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: a */
    public void mo11598a() {
        this.f11770f = false;
        this.f11772h = null;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: b */
    public Draft.CloseHandshakeType mo11601b() {
        return Draft.CloseHandshakeType.NONE;
    }

    /* JADX INFO: renamed from: d */
    public ByteBuffer m11612d() {
        return ByteBuffer.allocate(f11760b);
    }

    /* JADX INFO: renamed from: f */
    public ByteBuffer m11614f(ByteBuffer byteBuffer) throws InvalidDataException {
        byteBuffer.flip();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(m11589a(byteBuffer.capacity() * 2));
        byteBufferAllocate.put(byteBuffer);
        return byteBufferAllocate;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: c */
    public Draft mo11602c() {
        return new Draft_75();
    }
}
