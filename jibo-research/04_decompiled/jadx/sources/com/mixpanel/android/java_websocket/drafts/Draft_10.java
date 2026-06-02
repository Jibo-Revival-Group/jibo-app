package com.mixpanel.android.java_websocket.drafts;

import android.annotation.SuppressLint;
import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.LimitExedeedException;
import com.mixpanel.android.java_websocket.framing.CloseFrameBuilder;
import com.mixpanel.android.java_websocket.framing.FrameBuilder;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.framing.FramedataImpl1;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import com.mixpanel.android.java_websocket.util.Base64;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.apache.http.HttpHeaders;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"Assert", "UseValueOf"})
public class Draft_10 extends Draft {

    /* JADX INFO: renamed from: f */
    static final /* synthetic */ boolean f11764f;

    /* JADX INFO: renamed from: g */
    private ByteBuffer f11765g;

    /* JADX INFO: renamed from: h */
    private Framedata f11766h = null;

    /* JADX INFO: renamed from: i */
    private final Random f11767i = new Random();

    static {
        f11764f = !Draft_10.class.desiredAssertionStatus();
    }

    private class IncompleteException extends Throwable {

        /* JADX INFO: renamed from: b */
        private int f11769b;

        public IncompleteException(int i) {
            this.f11769b = i;
        }

        /* JADX INFO: renamed from: a */
        public int m11611a() {
            return this.f11769b;
        }
    }

    /* JADX INFO: renamed from: b */
    public static int m11609b(Handshakedata handshakedata) {
        String strMo11639b = handshakedata.mo11639b("Sec-WebSocket-Version");
        if (strMo11639b.length() <= 0) {
            return -1;
        }
        try {
            return new Integer(strMo11639b.trim()).intValue();
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: a */
    public Draft.HandshakeState mo11591a(ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidHandshakeException {
        if (!clientHandshake.mo11641c("Sec-WebSocket-Key") || !serverHandshake.mo11641c("Sec-WebSocket-Accept")) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        if (m11607a(clientHandshake.mo11639b("Sec-WebSocket-Key")).equals(serverHandshake.mo11639b("Sec-WebSocket-Accept"))) {
            return Draft.HandshakeState.MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: a */
    public Draft.HandshakeState mo11590a(ClientHandshake clientHandshake) throws InvalidHandshakeException {
        int iM11609b = m11609b(clientHandshake);
        if (iM11609b == 7 || iM11609b == 8) {
            return m11600a((Handshakedata) clientHandshake) ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: a */
    public ByteBuffer mo11594a(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer byteBufferMo11626c = framedata.mo11626c();
        boolean z = this.f11762d == WebSocket.Role.CLIENT;
        if (byteBufferMo11626c.remaining() <= 125) {
            i = 1;
        } else {
            i = byteBufferMo11626c.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + byteBufferMo11626c.remaining());
        byteBufferAllocate.put((byte) (((byte) (framedata.mo11629d() ? -128 : 0)) | m11605a(framedata.mo11631f())));
        byte[] bArrM11608a = m11608a(byteBufferMo11626c.remaining(), i);
        if (!f11764f && bArrM11608a.length != i) {
            throw new AssertionError();
        }
        if (i == 1) {
            byteBufferAllocate.put((byte) (bArrM11608a[0] | (z ? (byte) -128 : (byte) 0)));
        } else if (i == 2) {
            byteBufferAllocate.put((byte) ((z ? (byte) -128 : (byte) 0) | 126));
            byteBufferAllocate.put(bArrM11608a);
        } else if (i == 8) {
            byteBufferAllocate.put((byte) ((z ? (byte) -128 : (byte) 0) | 127));
            byteBufferAllocate.put(bArrM11608a);
        } else {
            throw new RuntimeException("Size representation not supported/specified");
        }
        if (z) {
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
            byteBufferAllocate2.putInt(this.f11767i.nextInt());
            byteBufferAllocate.put(byteBufferAllocate2.array());
            while (byteBufferMo11626c.hasRemaining()) {
                byteBufferAllocate.put((byte) (byteBufferMo11626c.get() ^ byteBufferAllocate2.get(i2 % 4)));
                i2++;
            }
        } else {
            byteBufferAllocate.put(byteBufferMo11626c);
        }
        if (!f11764f && byteBufferAllocate.remaining() != 0) {
            throw new AssertionError(byteBufferAllocate.remaining());
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    /* JADX INFO: renamed from: a */
    private byte m11605a(Framedata.Opcode opcode) {
        if (opcode == Framedata.Opcode.CONTINUOUS) {
            return (byte) 0;
        }
        if (opcode == Framedata.Opcode.TEXT) {
            return (byte) 1;
        }
        if (opcode == Framedata.Opcode.BINARY) {
            return (byte) 2;
        }
        if (opcode == Framedata.Opcode.CLOSING) {
            return (byte) 8;
        }
        if (opcode == Framedata.Opcode.PING) {
            return (byte) 9;
        }
        if (opcode == Framedata.Opcode.PONG) {
            return (byte) 10;
        }
        throw new RuntimeException("Don't know how to handle " + opcode.toString());
    }

    /* JADX INFO: renamed from: a */
    private String m11607a(String str) {
        try {
            return Base64.m11644a(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: a */
    public ClientHandshakeBuilder mo11592a(ClientHandshakeBuilder clientHandshakeBuilder) {
        clientHandshakeBuilder.mo11634a(HttpHeaders.UPGRADE, "websocket");
        clientHandshakeBuilder.mo11634a("Connection", HttpHeaders.UPGRADE);
        clientHandshakeBuilder.mo11634a("Sec-WebSocket-Version", "8");
        byte[] bArr = new byte[16];
        this.f11767i.nextBytes(bArr);
        clientHandshakeBuilder.mo11634a("Sec-WebSocket-Key", Base64.m11644a(bArr));
        return clientHandshakeBuilder;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: a */
    public HandshakeBuilder mo11593a(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException {
        serverHandshakeBuilder.mo11634a(HttpHeaders.UPGRADE, "websocket");
        serverHandshakeBuilder.mo11634a("Connection", clientHandshake.mo11639b("Connection"));
        serverHandshakeBuilder.mo11637a("Switching Protocols");
        String strB = clientHandshake.mo11639b("Sec-WebSocket-Key");
        if (strB == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        serverHandshakeBuilder.mo11634a("Sec-WebSocket-Accept", m11607a(strB));
        return serverHandshakeBuilder;
    }

    /* JADX INFO: renamed from: a */
    private byte[] m11608a(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) (j >>> (i2 - (i3 * 8)));
        }
        return bArr;
    }

    /* JADX INFO: renamed from: a */
    private Framedata.Opcode m11606a(byte b) throws InvalidFrameException {
        switch (b) {
            case 0:
                return Framedata.Opcode.CONTINUOUS;
            case 1:
                return Framedata.Opcode.TEXT;
            case 2:
                return Framedata.Opcode.BINARY;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            default:
                throw new InvalidFrameException("unknow optcode " + ((int) b));
            case 8:
                return Framedata.Opcode.CLOSING;
            case 9:
                return Framedata.Opcode.PING;
            case 10:
                return Framedata.Opcode.PONG;
        }
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: c */
    public List<Framedata> mo11603c(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList = new LinkedList();
        if (this.f11765g != null) {
            try {
                byteBuffer.mark();
                int iRemaining = byteBuffer.remaining();
                int iRemaining2 = this.f11765g.remaining();
                if (iRemaining2 > iRemaining) {
                    this.f11765g.put(byteBuffer.array(), byteBuffer.position(), iRemaining);
                    byteBuffer.position(iRemaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.f11765g.put(byteBuffer.array(), byteBuffer.position(), iRemaining2);
                byteBuffer.position(byteBuffer.position() + iRemaining2);
                linkedList.add(m11610e((ByteBuffer) this.f11765g.duplicate().position(0)));
                this.f11765g = null;
            } catch (IncompleteException e) {
                this.f11765g.limit();
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(m11589a(e.m11611a()));
                if (!f11764f && byteBufferAllocate.limit() <= this.f11765g.limit()) {
                    throw new AssertionError();
                }
                this.f11765g.rewind();
                byteBufferAllocate.put(this.f11765g);
                this.f11765g = byteBufferAllocate;
                return mo11603c(byteBuffer);
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(m11610e(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.f11765g = ByteBuffer.allocate(m11589a(e2.m11611a()));
                this.f11765g.put(byteBuffer);
            }
        }
        return linkedList;
    }

    /* JADX INFO: renamed from: e */
    public Framedata m11610e(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
        FrameBuilder framedataImpl1;
        int i = 2;
        int iRemaining = byteBuffer.remaining();
        if (iRemaining < 2) {
            throw new IncompleteException(2);
        }
        byte b = byteBuffer.get();
        boolean z = (b >> 8) != 0;
        byte b2 = (byte) ((b & 127) >> 4);
        if (b2 != 0) {
            throw new InvalidFrameException("bad rsv " + ((int) b2));
        }
        byte b3 = byteBuffer.get();
        boolean z2 = (b3 & (-128)) != 0;
        int iIntValue = (byte) (b3 & 127);
        Framedata.Opcode opcodeM11606a = m11606a((byte) (b & 15));
        if (!z && (opcodeM11606a == Framedata.Opcode.PING || opcodeM11606a == Framedata.Opcode.PONG || opcodeM11606a == Framedata.Opcode.CLOSING)) {
            throw new InvalidFrameException("control frames may no be fragmented");
        }
        if (iIntValue < 0 || iIntValue > 125) {
            if (opcodeM11606a == Framedata.Opcode.PING || opcodeM11606a == Framedata.Opcode.PONG || opcodeM11606a == Framedata.Opcode.CLOSING) {
                throw new InvalidFrameException("more than 125 octets");
            }
            if (iIntValue == 126) {
                if (iRemaining < 4) {
                    throw new IncompleteException(4);
                }
                iIntValue = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                i = 4;
            } else {
                if (iRemaining < 10) {
                    throw new IncompleteException(10);
                }
                byte[] bArr = new byte[8];
                for (int i2 = 0; i2 < 8; i2++) {
                    bArr[i2] = byteBuffer.get();
                }
                long jLongValue = new BigInteger(bArr).longValue();
                if (jLongValue <= 2147483647L) {
                    i = 10;
                    iIntValue = (int) jLongValue;
                } else {
                    throw new LimitExedeedException("Payloadsize is to big...");
                }
            }
        }
        int i3 = (z2 ? 4 : 0) + i + iIntValue;
        if (iRemaining < i3) {
            throw new IncompleteException(i3);
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(m11589a(iIntValue));
        if (z2) {
            byte[] bArr2 = new byte[4];
            byteBuffer.get(bArr2);
            for (int i4 = 0; i4 < iIntValue; i4++) {
                byteBufferAllocate.put((byte) (byteBuffer.get() ^ bArr2[i4 % 4]));
            }
        } else {
            byteBufferAllocate.put(byteBuffer.array(), byteBuffer.position(), byteBufferAllocate.limit());
            byteBuffer.position(byteBuffer.position() + byteBufferAllocate.limit());
        }
        if (opcodeM11606a == Framedata.Opcode.CLOSING) {
            framedataImpl1 = new CloseFrameBuilder();
        } else {
            framedataImpl1 = new FramedataImpl1();
            framedataImpl1.mo11628a(z);
            framedataImpl1.mo11627a(opcodeM11606a);
        }
        byteBufferAllocate.flip();
        framedataImpl1.mo11625a(byteBufferAllocate);
        return framedataImpl1;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: a */
    public void mo11598a() {
        this.f11765g = null;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: c */
    public Draft mo11602c() {
        return new Draft_10();
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: b */
    public Draft.CloseHandshakeType mo11601b() {
        return Draft.CloseHandshakeType.TWOWAY;
    }
}
