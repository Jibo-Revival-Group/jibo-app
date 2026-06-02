package com.mixpanel.android.java_websocket.framing;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface FrameBuilder extends Framedata {
    /* JADX INFO: renamed from: a */
    void mo11627a(Framedata.Opcode opcode);

    /* JADX INFO: renamed from: a */
    void mo11625a(ByteBuffer byteBuffer) throws InvalidDataException;

    /* JADX INFO: renamed from: a */
    void mo11628a(boolean z);
}
