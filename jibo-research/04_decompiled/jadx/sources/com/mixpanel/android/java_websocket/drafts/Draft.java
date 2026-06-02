package com.mixpanel.android.java_websocket.drafts;

import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.exceptions.IncompleteHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.framing.FramedataImpl1;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeImpl1Client;
import com.mixpanel.android.java_websocket.handshake.HandshakeImpl1Server;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import com.mixpanel.android.java_websocket.util.Charsetfunctions;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpHeaders;

/* JADX INFO: loaded from: classes.dex */
public abstract class Draft {

    /* JADX INFO: renamed from: a */
    public static int f11759a = 1000;

    /* JADX INFO: renamed from: b */
    public static int f11760b = 64;

    /* JADX INFO: renamed from: c */
    public static final byte[] f11761c = Charsetfunctions.m11657a("<policy-file-request/>\u0000");

    /* JADX INFO: renamed from: d */
    protected WebSocket.Role f11762d = null;

    /* JADX INFO: renamed from: e */
    protected Framedata.Opcode f11763e = null;

    public enum CloseHandshakeType {
        NONE,
        ONEWAY,
        TWOWAY
    }

    public enum HandshakeState {
        MATCHED,
        NOT_MATCHED
    }

    /* JADX INFO: renamed from: a */
    public abstract HandshakeState mo11590a(ClientHandshake clientHandshake) throws InvalidHandshakeException;

    /* JADX INFO: renamed from: a */
    public abstract HandshakeState mo11591a(ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidHandshakeException;

    /* JADX INFO: renamed from: a */
    public abstract ClientHandshakeBuilder mo11592a(ClientHandshakeBuilder clientHandshakeBuilder) throws InvalidHandshakeException;

    /* JADX INFO: renamed from: a */
    public abstract HandshakeBuilder mo11593a(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException;

    /* JADX INFO: renamed from: a */
    public abstract ByteBuffer mo11594a(Framedata framedata);

    /* JADX INFO: renamed from: a */
    public abstract void mo11598a();

    /* JADX INFO: renamed from: b */
    public abstract CloseHandshakeType mo11601b();

    /* JADX INFO: renamed from: c */
    public abstract Draft mo11602c();

    /* JADX INFO: renamed from: c */
    public abstract List<Framedata> mo11603c(ByteBuffer byteBuffer) throws InvalidDataException;

    /* JADX INFO: renamed from: a */
    public static ByteBuffer m11587a(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b = 48;
        while (byteBuffer.hasRemaining()) {
            byte b2 = byteBuffer.get();
            byteBufferAllocate.put(b2);
            if (b == 13 && b2 == 10) {
                byteBufferAllocate.limit(byteBufferAllocate.position() - 2);
                byteBufferAllocate.position(0);
                return byteBufferAllocate;
            }
            b = b2;
        }
        byteBuffer.position(byteBuffer.position() - byteBufferAllocate.position());
        return null;
    }

    /* JADX INFO: renamed from: b */
    public static String m11588b(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferM11587a = m11587a(byteBuffer);
        if (byteBufferM11587a == null) {
            return null;
        }
        return Charsetfunctions.m11656a(byteBufferM11587a.array(), 0, byteBufferM11587a.limit());
    }

    /* JADX INFO: renamed from: a */
    public static HandshakeBuilder m11586a(ByteBuffer byteBuffer, WebSocket.Role role) throws InvalidHandshakeException, IncompleteHandshakeException {
        HandshakeBuilder handshakeBuilder;
        String strM11588b = m11588b(byteBuffer);
        if (strM11588b == null) {
            throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
        }
        String[] strArrSplit = strM11588b.split(" ", 3);
        if (strArrSplit.length != 3) {
            throw new InvalidHandshakeException();
        }
        if (role == WebSocket.Role.CLIENT) {
            HandshakeImpl1Server handshakeImpl1Server = new HandshakeImpl1Server();
            HandshakeImpl1Server handshakeImpl1Server2 = handshakeImpl1Server;
            handshakeImpl1Server2.mo11638a(Short.parseShort(strArrSplit[1]));
            handshakeImpl1Server2.mo11637a(strArrSplit[2]);
            handshakeBuilder = handshakeImpl1Server;
        } else {
            HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
            handshakeImpl1Client.mo11633a(strArrSplit[1]);
            handshakeBuilder = handshakeImpl1Client;
        }
        String strM11588b2 = m11588b(byteBuffer);
        while (strM11588b2 != null && strM11588b2.length() > 0) {
            String[] strArrSplit2 = strM11588b2.split(":", 2);
            if (strArrSplit2.length != 2) {
                throw new InvalidHandshakeException("not an http header");
            }
            handshakeBuilder.mo11634a(strArrSplit2[0], strArrSplit2[1].replaceFirst("^ +", ""));
            strM11588b2 = m11588b(byteBuffer);
        }
        if (strM11588b2 == null) {
            throw new IncompleteHandshakeException();
        }
        return handshakeBuilder;
    }

    /* JADX INFO: renamed from: a */
    protected boolean m11600a(Handshakedata handshakedata) {
        return handshakedata.mo11639b(HttpHeaders.UPGRADE).equalsIgnoreCase("websocket") && handshakedata.mo11639b("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    /* JADX INFO: renamed from: a */
    public List<Framedata> m11595a(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        if (opcode != Framedata.Opcode.BINARY && opcode != Framedata.Opcode.TEXT && opcode != Framedata.Opcode.TEXT) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        if (this.f11763e != null) {
            this.f11763e = Framedata.Opcode.CONTINUOUS;
        } else {
            this.f11763e = opcode;
        }
        FramedataImpl1 framedataImpl1 = new FramedataImpl1(this.f11763e);
        try {
            framedataImpl1.mo11625a(byteBuffer);
            framedataImpl1.mo11628a(z);
            if (z) {
                this.f11763e = null;
            } else {
                this.f11763e = opcode;
            }
            return Collections.singletonList(framedataImpl1);
        } catch (InvalidDataException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    public List<ByteBuffer> m11596a(Handshakedata handshakedata, WebSocket.Role role) {
        return m11597a(handshakedata, role, true);
    }

    /* JADX INFO: renamed from: a */
    public List<ByteBuffer> m11597a(Handshakedata handshakedata, WebSocket.Role role, boolean z) {
        StringBuilder sb = new StringBuilder(100);
        if (handshakedata instanceof ClientHandshake) {
            sb.append("GET ");
            sb.append(((ClientHandshake) handshakedata).mo11632a());
            sb.append(" HTTP/1.1");
        } else if (handshakedata instanceof ServerHandshake) {
            sb.append("HTTP/1.1 101 " + ((ServerHandshake) handshakedata).mo11636a());
        } else {
            throw new RuntimeException("unknow role");
        }
        sb.append("\r\n");
        Iterator<String> itMo11640b = handshakedata.mo11640b();
        while (itMo11640b.hasNext()) {
            String next = itMo11640b.next();
            String strMo11639b = handshakedata.mo11639b(next);
            sb.append(next);
            sb.append(": ");
            sb.append(strMo11639b);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] bArrM11658b = Charsetfunctions.m11658b(sb.toString());
        byte[] bArrMo11642c = z ? handshakedata.mo11642c() : null;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((bArrMo11642c == null ? 0 : bArrMo11642c.length) + bArrM11658b.length);
        byteBufferAllocate.put(bArrM11658b);
        if (bArrMo11642c != null) {
            byteBufferAllocate.put(bArrMo11642c);
        }
        byteBufferAllocate.flip();
        return Collections.singletonList(byteBufferAllocate);
    }

    /* JADX INFO: renamed from: d */
    public Handshakedata mo11604d(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        return m11586a(byteBuffer, this.f11762d);
    }

    /* JADX INFO: renamed from: a */
    public int m11589a(int i) throws InvalidDataException {
        if (i < 0) {
            throw new InvalidDataException(1002, "Negative count");
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    public void m11599a(WebSocket.Role role) {
        this.f11762d = role;
    }
}
