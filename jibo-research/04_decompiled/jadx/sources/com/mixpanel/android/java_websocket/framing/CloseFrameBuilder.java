package com.mixpanel.android.java_websocket.framing;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.util.Charsetfunctions;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class CloseFrameBuilder extends FramedataImpl1 implements CloseFrame {

    /* JADX INFO: renamed from: a */
    static final ByteBuffer f11779a = ByteBuffer.allocate(0);

    /* JADX INFO: renamed from: f */
    private int f11780f;

    /* JADX INFO: renamed from: g */
    private String f11781g;

    public CloseFrameBuilder() {
        super(Framedata.Opcode.CLOSING);
        mo11628a(true);
    }

    public CloseFrameBuilder(int i) throws InvalidDataException {
        super(Framedata.Opcode.CLOSING);
        mo11628a(true);
        m11622a(i, "");
    }

    public CloseFrameBuilder(int i, String str) throws InvalidDataException {
        super(Framedata.Opcode.CLOSING);
        mo11628a(true);
        m11622a(i, str);
    }

    /* JADX INFO: renamed from: a */
    private void m11622a(int i, String str) throws InvalidDataException {
        String str2 = str == null ? "" : str;
        if (i == 1015) {
            str2 = "";
            i = 1005;
        }
        if (i == 1005) {
            if (str2.length() > 0) {
                throw new InvalidDataException(1002, "A close frame must have a closecode if it has a reason");
            }
            return;
        }
        byte[] bArrM11657a = Charsetfunctions.m11657a(str2);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt(i);
        byteBufferAllocate.position(2);
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(bArrM11657a.length + 2);
        byteBufferAllocate2.put(byteBufferAllocate);
        byteBufferAllocate2.put(bArrM11657a);
        byteBufferAllocate2.rewind();
        mo11625a(byteBufferAllocate2);
    }

    /* JADX INFO: renamed from: g */
    private void m11623g() throws InvalidFrameException {
        this.f11780f = 1005;
        ByteBuffer byteBufferMo11626c = super.mo11626c();
        byteBufferMo11626c.mark();
        if (byteBufferMo11626c.remaining() >= 2) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            byteBufferAllocate.position(2);
            byteBufferAllocate.putShort(byteBufferMo11626c.getShort());
            byteBufferAllocate.position(0);
            this.f11780f = byteBufferAllocate.getInt();
            if (this.f11780f == 1006 || this.f11780f == 1015 || this.f11780f == 1005 || this.f11780f > 4999 || this.f11780f < 1000 || this.f11780f == 1004) {
                throw new InvalidFrameException("closecode must not be sent over the wire: " + this.f11780f);
            }
        }
        byteBufferMo11626c.reset();
    }

    @Override // com.mixpanel.android.java_websocket.framing.CloseFrame
    /* JADX INFO: renamed from: a */
    public int mo11620a() {
        return this.f11780f;
    }

    /* JADX INFO: renamed from: h */
    private void m11624h() throws InvalidDataException {
        if (this.f11780f == 1005) {
            this.f11781g = Charsetfunctions.m11655a(super.mo11626c());
            return;
        }
        ByteBuffer byteBufferMo11626c = super.mo11626c();
        int iPosition = byteBufferMo11626c.position();
        try {
            try {
                byteBufferMo11626c.position(byteBufferMo11626c.position() + 2);
                this.f11781g = Charsetfunctions.m11655a(byteBufferMo11626c);
            } catch (IllegalArgumentException e) {
                throw new InvalidFrameException(e);
            }
        } finally {
            byteBufferMo11626c.position(iPosition);
        }
    }

    @Override // com.mixpanel.android.java_websocket.framing.CloseFrame
    /* JADX INFO: renamed from: b */
    public String mo11621b() {
        return this.f11781g;
    }

    @Override // com.mixpanel.android.java_websocket.framing.FramedataImpl1
    public String toString() {
        return super.toString() + "code: " + this.f11780f;
    }

    @Override // com.mixpanel.android.java_websocket.framing.FramedataImpl1, com.mixpanel.android.java_websocket.framing.FrameBuilder
    /* JADX INFO: renamed from: a */
    public void mo11625a(ByteBuffer byteBuffer) throws InvalidDataException {
        super.mo11625a(byteBuffer);
        m11623g();
        m11624h();
    }

    @Override // com.mixpanel.android.java_websocket.framing.FramedataImpl1, com.mixpanel.android.java_websocket.framing.Framedata
    /* JADX INFO: renamed from: c */
    public ByteBuffer mo11626c() {
        return this.f11780f == 1005 ? f11779a : super.mo11626c();
    }
}
