package com.mixpanel.android.java_websocket.drafts;

import android.annotation.SuppressLint;
import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.IncompleteHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.framing.CloseFrameBuilder;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.apache.http.HttpHeaders;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UseValueOf"})
public class Draft_76 extends Draft_75 {

    /* JADX INFO: renamed from: j */
    private static final byte[] f11774j = {-1, 0};

    /* JADX INFO: renamed from: i */
    private boolean f11775i = false;

    /* JADX INFO: renamed from: k */
    private final Random f11776k = new Random();

    /* JADX INFO: renamed from: a */
    public static byte[] m11616a(String str, String str2, byte[] bArr) throws InvalidHandshakeException {
        byte[] bArrM11615a = m11615a(str);
        byte[] bArrM11615a2 = m11615a(str2);
        try {
            return MessageDigest.getInstance("MD5").digest(new byte[]{bArrM11615a[0], bArrM11615a[1], bArrM11615a[2], bArrM11615a[3], bArrM11615a2[0], bArrM11615a2[1], bArrM11615a2[2], bArrM11615a2[3], bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]});
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: e */
    private static String m11617e() {
        Random random = new Random();
        long jNextInt = random.nextInt(12) + 1;
        String string = Long.toString(((long) (random.nextInt(Math.abs(new Long(4294967295L / jNextInt).intValue())) + 1)) * jNextInt);
        int iNextInt = random.nextInt(12) + 1;
        for (int i = 0; i < iNextInt; i++) {
            int iAbs = Math.abs(random.nextInt(string.length()));
            char cNextInt = (char) (random.nextInt(95) + 33);
            if (cNextInt >= '0' && cNextInt <= '9') {
                cNextInt = (char) (cNextInt - 15);
            }
            string = new StringBuilder(string).insert(iAbs, cNextInt).toString();
        }
        String string2 = string;
        for (int i2 = 0; i2 < jNextInt; i2++) {
            string2 = new StringBuilder(string2).insert(Math.abs(random.nextInt(string2.length() - 1) + 1), " ").toString();
        }
        return string2;
    }

    /* JADX INFO: renamed from: a */
    private static byte[] m11615a(String str) throws InvalidHandshakeException {
        try {
            long j = Long.parseLong(str.replaceAll("[^0-9]", ""));
            long length = str.split(" ").length - 1;
            if (length == 0) {
                throw new InvalidHandshakeException("invalid Sec-WebSocket-Key (/key2/)");
            }
            long jLongValue = new Long(j / length).longValue();
            return new byte[]{(byte) (jLongValue >> 24), (byte) ((jLongValue << 8) >> 24), (byte) ((jLongValue << 16) >> 24), (byte) ((jLongValue << 24) >> 24)};
        } catch (NumberFormatException e) {
            throw new InvalidHandshakeException("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
        }
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: a */
    public Draft.HandshakeState mo11591a(ClientHandshake clientHandshake, ServerHandshake serverHandshake) {
        if (this.f11775i) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        try {
            if (!serverHandshake.mo11639b("Sec-WebSocket-Origin").equals(clientHandshake.mo11639b("Origin")) || !m11600a(serverHandshake)) {
                return Draft.HandshakeState.NOT_MATCHED;
            }
            byte[] bArrC = serverHandshake.mo11642c();
            if (bArrC == null || bArrC.length == 0) {
                throw new IncompleteHandshakeException();
            }
            if (Arrays.equals(bArrC, m11616a(clientHandshake.mo11639b("Sec-WebSocket-Key1"), clientHandshake.mo11639b("Sec-WebSocket-Key2"), clientHandshake.mo11642c()))) {
                return Draft.HandshakeState.MATCHED;
            }
            return Draft.HandshakeState.NOT_MATCHED;
        } catch (InvalidHandshakeException e) {
            throw new RuntimeException("bad handshakerequest", e);
        }
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: a */
    public Draft.HandshakeState mo11590a(ClientHandshake clientHandshake) {
        return (clientHandshake.mo11639b(HttpHeaders.UPGRADE).equals("WebSocket") && clientHandshake.mo11639b("Connection").contains(HttpHeaders.UPGRADE) && clientHandshake.mo11639b("Sec-WebSocket-Key1").length() > 0 && !clientHandshake.mo11639b("Sec-WebSocket-Key2").isEmpty() && clientHandshake.mo11641c("Origin")) ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: a */
    public ClientHandshakeBuilder mo11592a(ClientHandshakeBuilder clientHandshakeBuilder) {
        clientHandshakeBuilder.mo11634a(HttpHeaders.UPGRADE, "WebSocket");
        clientHandshakeBuilder.mo11634a("Connection", HttpHeaders.UPGRADE);
        clientHandshakeBuilder.mo11634a("Sec-WebSocket-Key1", m11617e());
        clientHandshakeBuilder.mo11634a("Sec-WebSocket-Key2", m11617e());
        if (!clientHandshakeBuilder.mo11641c("Origin")) {
            clientHandshakeBuilder.mo11634a("Origin", "random" + this.f11776k.nextInt());
        }
        byte[] bArr = new byte[8];
        this.f11776k.nextBytes(bArr);
        clientHandshakeBuilder.mo11635a(bArr);
        return clientHandshakeBuilder;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: a */
    public HandshakeBuilder mo11593a(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException {
        serverHandshakeBuilder.mo11637a("WebSocket Protocol Handshake");
        serverHandshakeBuilder.mo11634a(HttpHeaders.UPGRADE, "WebSocket");
        serverHandshakeBuilder.mo11634a("Connection", clientHandshake.mo11639b("Connection"));
        serverHandshakeBuilder.mo11634a("Sec-WebSocket-Origin", clientHandshake.mo11639b("Origin"));
        serverHandshakeBuilder.mo11634a("Sec-WebSocket-Location", "ws://" + clientHandshake.mo11639b("Host") + clientHandshake.mo11632a());
        String strB = clientHandshake.mo11639b("Sec-WebSocket-Key1");
        String strB2 = clientHandshake.mo11639b("Sec-WebSocket-Key2");
        byte[] bArrC = clientHandshake.mo11642c();
        if (strB == null || strB2 == null || bArrC == null || bArrC.length != 8) {
            throw new InvalidHandshakeException("Bad keys");
        }
        serverHandshakeBuilder.mo11635a(m11616a(strB, strB2, bArrC));
        return serverHandshakeBuilder;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: d */
    public Handshakedata mo11604d(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        HandshakeBuilder handshakeBuilderA = m11586a(byteBuffer, this.f11762d);
        if ((handshakeBuilderA.mo11641c("Sec-WebSocket-Key1") || this.f11762d == WebSocket.Role.CLIENT) && !handshakeBuilderA.mo11641c("Sec-WebSocket-Version")) {
            byte[] bArr = new byte[this.f11762d == WebSocket.Role.SERVER ? 8 : 16];
            try {
                byteBuffer.get(bArr);
                handshakeBuilderA.mo11635a(bArr);
            } catch (BufferUnderflowException e) {
                throw new IncompleteHandshakeException(byteBuffer.capacity() + 16);
            }
        }
        return handshakeBuilderA;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: c */
    public List<Framedata> mo11603c(ByteBuffer byteBuffer) throws InvalidDataException {
        byteBuffer.mark();
        List<Framedata> listM11613e = super.m11613e(byteBuffer);
        if (listM11613e == null) {
            byteBuffer.reset();
            listM11613e = this.f11771g;
            this.f11770f = true;
            if (this.f11772h == null) {
                this.f11772h = ByteBuffer.allocate(2);
                if (byteBuffer.remaining() > this.f11772h.remaining()) {
                    throw new InvalidFrameException();
                }
                this.f11772h.put(byteBuffer);
                if (!this.f11772h.hasRemaining()) {
                    if (Arrays.equals(this.f11772h.array(), f11774j)) {
                        listM11613e.add(new CloseFrameBuilder(1000));
                    } else {
                        throw new InvalidFrameException();
                    }
                } else {
                    this.f11771g = new LinkedList();
                }
            } else {
                throw new InvalidFrameException();
            }
        }
        return listM11613e;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: a */
    public ByteBuffer mo11594a(Framedata framedata) {
        return framedata.mo11631f() == Framedata.Opcode.CLOSING ? ByteBuffer.wrap(f11774j) : super.mo11594a(framedata);
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: b */
    public Draft.CloseHandshakeType mo11601b() {
        return Draft.CloseHandshakeType.ONEWAY;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    /* JADX INFO: renamed from: c */
    public Draft mo11602c() {
        return new Draft_76();
    }
}
