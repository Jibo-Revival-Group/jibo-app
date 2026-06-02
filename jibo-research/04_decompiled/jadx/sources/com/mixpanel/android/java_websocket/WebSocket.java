package com.mixpanel.android.java_websocket;

import com.mixpanel.android.java_websocket.framing.Framedata;
import java.net.InetSocketAddress;

/* JADX INFO: loaded from: classes.dex */
public interface WebSocket {

    public enum READYSTATE {
        NOT_YET_CONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED
    }

    public enum Role {
        CLIENT,
        SERVER
    }

    /* JADX INFO: renamed from: a */
    InetSocketAddress mo11525a();

    /* JADX INFO: renamed from: a */
    void mo11526a(Framedata framedata);
}
