package com.mixpanel.android.java_websocket.framing;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;

/* JADX INFO: loaded from: classes.dex */
public interface CloseFrame extends Framedata {
    /* JADX INFO: renamed from: a */
    int mo11620a() throws InvalidFrameException;

    /* JADX INFO: renamed from: b */
    String mo11621b() throws InvalidDataException;
}
