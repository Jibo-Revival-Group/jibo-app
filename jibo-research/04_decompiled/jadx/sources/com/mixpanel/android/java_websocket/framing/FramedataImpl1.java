package com.mixpanel.android.java_websocket.framing;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.util.Charsetfunctions;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class FramedataImpl1 implements FrameBuilder {

    /* JADX INFO: renamed from: b */
    protected static byte[] f11782b = new byte[0];

    /* JADX INFO: renamed from: a */
    private ByteBuffer f11783a;

    /* JADX INFO: renamed from: c */
    protected boolean f11784c;

    /* JADX INFO: renamed from: d */
    protected Framedata.Opcode f11785d;

    /* JADX INFO: renamed from: e */
    protected boolean f11786e;

    public FramedataImpl1() {
    }

    public FramedataImpl1(Framedata.Opcode opcode) {
        this.f11785d = opcode;
        this.f11783a = ByteBuffer.wrap(f11782b);
    }

    public FramedataImpl1(Framedata framedata) {
        this.f11784c = framedata.mo11629d();
        this.f11785d = framedata.mo11631f();
        this.f11783a = framedata.mo11626c();
        this.f11786e = framedata.mo11630e();
    }

    @Override // com.mixpanel.android.java_websocket.framing.Framedata
    /* JADX INFO: renamed from: d */
    public boolean mo11629d() {
        return this.f11784c;
    }

    @Override // com.mixpanel.android.java_websocket.framing.Framedata
    /* JADX INFO: renamed from: f */
    public Framedata.Opcode mo11631f() {
        return this.f11785d;
    }

    @Override // com.mixpanel.android.java_websocket.framing.Framedata
    /* JADX INFO: renamed from: e */
    public boolean mo11630e() {
        return this.f11786e;
    }

    @Override // com.mixpanel.android.java_websocket.framing.Framedata
    /* JADX INFO: renamed from: c */
    public ByteBuffer mo11626c() {
        return this.f11783a;
    }

    @Override // com.mixpanel.android.java_websocket.framing.FrameBuilder
    /* JADX INFO: renamed from: a */
    public void mo11628a(boolean z) {
        this.f11784c = z;
    }

    @Override // com.mixpanel.android.java_websocket.framing.FrameBuilder
    /* JADX INFO: renamed from: a */
    public void mo11627a(Framedata.Opcode opcode) {
        this.f11785d = opcode;
    }

    @Override // com.mixpanel.android.java_websocket.framing.FrameBuilder
    /* JADX INFO: renamed from: a */
    public void mo11625a(ByteBuffer byteBuffer) throws InvalidDataException {
        this.f11783a = byteBuffer;
    }

    public String toString() {
        return "Framedata{ optcode:" + mo11631f() + ", fin:" + mo11629d() + ", payloadlength:[pos:" + this.f11783a.position() + ", len:" + this.f11783a.remaining() + "], payload:" + Arrays.toString(Charsetfunctions.m11657a(new String(this.f11783a.array()))) + "}";
    }
}
