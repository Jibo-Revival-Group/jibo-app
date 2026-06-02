package com.mixpanel.android.viewcrawler;

import com.facebook.share.internal.ShareConstants;
import com.mixpanel.android.java_websocket.client.WebSocketClient;
import com.mixpanel.android.java_websocket.drafts.Draft_17;
import com.mixpanel.android.java_websocket.exceptions.NotSendableException;
import com.mixpanel.android.java_websocket.exceptions.WebsocketNotConnectedException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.util.MPLog;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class EditorConnection {

    /* JADX INFO: renamed from: d */
    private static final ByteBuffer f12123d = ByteBuffer.allocate(0);

    /* JADX INFO: renamed from: a */
    private final Editor f12124a;

    /* JADX INFO: renamed from: b */
    private final EditorClient f12125b;

    /* JADX INFO: renamed from: c */
    private final URI f12126c;

    public interface Editor {
        /* JADX INFO: renamed from: a */
        void mo12074a();

        /* JADX INFO: renamed from: a */
        void mo12075a(JSONObject jSONObject);

        /* JADX INFO: renamed from: b */
        void mo12076b();

        /* JADX INFO: renamed from: b */
        void mo12077b(JSONObject jSONObject);

        /* JADX INFO: renamed from: c */
        void mo12078c(JSONObject jSONObject);

        /* JADX INFO: renamed from: d */
        void mo12079d(JSONObject jSONObject);

        /* JADX INFO: renamed from: e */
        void mo12080e(JSONObject jSONObject);
    }

    public class EditorConnectionException extends IOException {
        public EditorConnectionException(Throwable th) {
            super(th.getMessage());
        }
    }

    public EditorConnection(URI uri, Editor editor, Socket socket) throws EditorConnectionException {
        this.f12124a = editor;
        this.f12126c = uri;
        try {
            this.f12125b = new EditorClient(uri, 5000, socket);
            this.f12125b.m11581c();
        } catch (InterruptedException e) {
            throw new EditorConnectionException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m12071a() {
        return (this.f12125b.m11584f() || this.f12125b.m11585g() || this.f12125b.m11583e()) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    public boolean m12072b() {
        return this.f12125b.m11582d();
    }

    /* JADX INFO: renamed from: c */
    public BufferedOutputStream m12073c() {
        return new BufferedOutputStream(new WebSocketOutputStream());
    }

    private class EditorClient extends WebSocketClient {
        public EditorClient(URI uri, int i, Socket socket) throws InterruptedException {
            super(uri, new Draft_17(), null, i);
            m11576a(socket);
        }

        @Override // com.mixpanel.android.java_websocket.client.WebSocketClient
        /* JADX INFO: renamed from: a */
        public void mo11573a(ServerHandshake serverHandshake) {
            MPLog.m12021a("MixpanelAPI.EditorCnctn", "Websocket connected");
        }

        @Override // com.mixpanel.android.java_websocket.client.WebSocketClient
        /* JADX INFO: renamed from: a */
        public void mo11575a(String str) {
            MPLog.m12021a("MixpanelAPI.EditorCnctn", "Received message from editor:\n" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString(ShareConstants.MEDIA_TYPE);
                if (string.equals("device_info_request")) {
                    EditorConnection.this.f12124a.mo12074a();
                } else if (string.equals("snapshot_request")) {
                    EditorConnection.this.f12124a.mo12075a(jSONObject);
                } else if (string.equals("change_request")) {
                    EditorConnection.this.f12124a.mo12077b(jSONObject);
                } else if (string.equals("event_binding_request")) {
                    EditorConnection.this.f12124a.mo12079d(jSONObject);
                } else if (string.equals("clear_request")) {
                    EditorConnection.this.f12124a.mo12078c(jSONObject);
                } else if (string.equals("tweak_request")) {
                    EditorConnection.this.f12124a.mo12080e(jSONObject);
                }
            } catch (JSONException e) {
                MPLog.m12031e("MixpanelAPI.EditorCnctn", "Bad JSON received:" + str, e);
            }
        }

        @Override // com.mixpanel.android.java_websocket.client.WebSocketClient
        /* JADX INFO: renamed from: b */
        public void mo11579b(int i, String str, boolean z) {
            MPLog.m12021a("MixpanelAPI.EditorCnctn", "WebSocket closed. Code: " + i + ", reason: " + str + "\nURI: " + EditorConnection.this.f12126c);
            EditorConnection.this.f12124a.mo12076b();
        }

        @Override // com.mixpanel.android.java_websocket.client.WebSocketClient
        /* JADX INFO: renamed from: a */
        public void mo11574a(Exception exc) {
            if (exc != null && exc.getMessage() != null) {
                MPLog.m12030e("MixpanelAPI.EditorCnctn", "Websocket Error: " + exc.getMessage());
            } else {
                MPLog.m12030e("MixpanelAPI.EditorCnctn", "Unknown websocket error occurred");
            }
        }
    }

    private class WebSocketOutputStream extends OutputStream {
        private WebSocketOutputStream() {
        }

        @Override // java.io.OutputStream
        public void write(int i) throws EditorConnectionException {
            write(new byte[]{(byte) i}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws EditorConnectionException {
            write(bArr, 0, bArr.length);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws EditorConnectionException {
            try {
                EditorConnection.this.f12125b.m11572a(Framedata.Opcode.TEXT, ByteBuffer.wrap(bArr, i, i2), false);
            } catch (NotSendableException e) {
                throw EditorConnection.this.new EditorConnectionException(e);
            } catch (WebsocketNotConnectedException e2) {
                throw EditorConnection.this.new EditorConnectionException(e2);
            }
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws EditorConnectionException {
            try {
                EditorConnection.this.f12125b.m11572a(Framedata.Opcode.TEXT, EditorConnection.f12123d, true);
            } catch (NotSendableException e) {
                throw EditorConnection.this.new EditorConnectionException(e);
            } catch (WebsocketNotConnectedException e2) {
                throw EditorConnection.this.new EditorConnectionException(e2);
            }
        }
    }
}
