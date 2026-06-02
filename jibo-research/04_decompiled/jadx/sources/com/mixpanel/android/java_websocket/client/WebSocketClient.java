package com.mixpanel.android.java_websocket.client;

import android.annotation.SuppressLint;
import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.WebSocketAdapter;
import com.mixpanel.android.java_websocket.WebSocketImpl;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeImpl1Client;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"Assert"})
public abstract class WebSocketClient extends WebSocketAdapter implements WebSocket, Runnable {

    /* JADX INFO: renamed from: b */
    static final /* synthetic */ boolean f11745b;

    /* JADX INFO: renamed from: a */
    protected URI f11746a;

    /* JADX INFO: renamed from: c */
    private WebSocketImpl f11747c;

    /* JADX INFO: renamed from: e */
    private InputStream f11749e;

    /* JADX INFO: renamed from: f */
    private OutputStream f11750f;

    /* JADX INFO: renamed from: h */
    private Thread f11752h;

    /* JADX INFO: renamed from: i */
    private Draft f11753i;

    /* JADX INFO: renamed from: j */
    private Map<String, String> f11754j;

    /* JADX INFO: renamed from: m */
    private int f11757m;

    /* JADX INFO: renamed from: d */
    private Socket f11748d = null;

    /* JADX INFO: renamed from: g */
    private Proxy f11751g = Proxy.NO_PROXY;

    /* JADX INFO: renamed from: k */
    private CountDownLatch f11755k = new CountDownLatch(1);

    /* JADX INFO: renamed from: l */
    private CountDownLatch f11756l = new CountDownLatch(1);

    /* JADX INFO: renamed from: a */
    public abstract void mo11573a(ServerHandshake serverHandshake);

    /* JADX INFO: renamed from: a */
    public abstract void mo11574a(Exception exc);

    /* JADX INFO: renamed from: a */
    public abstract void mo11575a(String str);

    /* JADX INFO: renamed from: b */
    public abstract void mo11579b(int i, String str, boolean z);

    static {
        f11745b = !WebSocketClient.class.desiredAssertionStatus();
    }

    public WebSocketClient(URI uri, Draft draft, Map<String, String> map, int i) {
        this.f11746a = null;
        this.f11747c = null;
        this.f11757m = 0;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        if (draft == null) {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        }
        this.f11746a = uri;
        this.f11753i = draft;
        this.f11754j = map;
        this.f11757m = i;
        this.f11747c = new WebSocketImpl(this, draft);
    }

    /* JADX INFO: renamed from: b */
    public void m11578b() {
        if (this.f11752h != null) {
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
        }
        this.f11752h = new Thread(this);
        this.f11752h.start();
    }

    /* JADX INFO: renamed from: c */
    public boolean m11581c() throws InterruptedException {
        m11578b();
        this.f11755k.await();
        return this.f11747c.m11552c();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        try {
            if (this.f11748d == null) {
                this.f11748d = new Socket(this.f11751g);
            } else if (this.f11748d.isClosed()) {
                throw new IOException();
            }
            if (!this.f11748d.isBound()) {
                this.f11748d.connect(new InetSocketAddress(this.f11746a.getHost(), m11568h()), this.f11757m);
            }
            this.f11749e = this.f11748d.getInputStream();
            this.f11750f = this.f11748d.getOutputStream();
            m11569i();
            this.f11752h = new Thread(new WebsocketWriteThread());
            this.f11752h.start();
            byte[] bArr = new byte[WebSocketImpl.f11724a];
            while (!m11584f() && (i = this.f11749e.read(bArr)) != -1) {
                try {
                    this.f11747c.m11548a(ByteBuffer.wrap(bArr, 0, i));
                } catch (IOException e) {
                    this.f11747c.m11549b();
                } catch (RuntimeException e2) {
                    mo11574a(e2);
                    this.f11747c.m11550b(1006, e2.getMessage());
                }
            }
            this.f11747c.m11549b();
            if (!f11745b && !this.f11748d.isClosed()) {
                throw new AssertionError();
            }
        } catch (Exception e3) {
            mo11560a(this.f11747c, e3);
            this.f11747c.m11550b(-1, e3.getMessage());
        }
    }

    /* JADX INFO: renamed from: h */
    private int m11568h() {
        int port = this.f11746a.getPort();
        if (port == -1) {
            String scheme = this.f11746a.getScheme();
            if (scheme.equals("wss")) {
                return 443;
            }
            if (scheme.equals("ws")) {
                return 80;
            }
            throw new RuntimeException("unkonow scheme" + scheme);
        }
        return port;
    }

    /* JADX INFO: renamed from: i */
    private void m11569i() throws InvalidHandshakeException {
        String path = this.f11746a.getPath();
        String query = this.f11746a.getQuery();
        if (path == null || path.length() == 0) {
            path = "/";
        }
        if (query != null) {
            path = path + "?" + query;
        }
        int iM11568h = m11568h();
        String str = this.f11746a.getHost() + (iM11568h != 80 ? ":" + iM11568h : "");
        HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
        handshakeImpl1Client.mo11633a(path);
        handshakeImpl1Client.mo11634a("Host", str);
        if (this.f11754j != null) {
            for (Map.Entry<String, String> entry : this.f11754j.entrySet()) {
                handshakeImpl1Client.mo11634a(entry.getKey(), entry.getValue());
            }
        }
        this.f11747c.m11547a((ClientHandshakeBuilder) handshakeImpl1Client);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    /* JADX INFO: renamed from: a */
    public final void mo11561a(WebSocket webSocket, String str) {
        mo11575a(str);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    /* JADX INFO: renamed from: a */
    public final void mo11562a(WebSocket webSocket, ByteBuffer byteBuffer) {
        m11577a(byteBuffer);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketAdapter, com.mixpanel.android.java_websocket.WebSocketListener
    /* JADX INFO: renamed from: a */
    public void mo11529a(WebSocket webSocket, Framedata framedata) {
        m11580b(framedata);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    /* JADX INFO: renamed from: a */
    public final void mo11559a(WebSocket webSocket, Handshakedata handshakedata) {
        this.f11755k.countDown();
        mo11573a((ServerHandshake) handshakedata);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    /* JADX INFO: renamed from: a */
    public final void mo11558a(WebSocket webSocket, int i, String str, boolean z) {
        this.f11755k.countDown();
        this.f11756l.countDown();
        if (this.f11752h != null) {
            this.f11752h.interrupt();
        }
        try {
            if (this.f11748d != null) {
                this.f11748d.close();
            }
        } catch (IOException e) {
            mo11560a(this, e);
        }
        mo11579b(i, str, z);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    /* JADX INFO: renamed from: a */
    public final void mo11560a(WebSocket webSocket, Exception exc) {
        mo11574a(exc);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    /* JADX INFO: renamed from: b */
    public final void mo11563b(WebSocket webSocket) {
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    /* JADX INFO: renamed from: a */
    public void mo11557a(WebSocket webSocket, int i, String str) {
        m11570a(i, str);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    /* JADX INFO: renamed from: b */
    public void mo11564b(WebSocket webSocket, int i, String str, boolean z) {
        m11571a(i, str, z);
    }

    /* JADX INFO: renamed from: a */
    public void m11570a(int i, String str) {
    }

    /* JADX INFO: renamed from: a */
    public void m11571a(int i, String str, boolean z) {
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    /* JADX INFO: renamed from: c */
    public InetSocketAddress mo11565c(WebSocket webSocket) {
        if (this.f11748d != null) {
            return (InetSocketAddress) this.f11748d.getLocalSocketAddress();
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m11577a(ByteBuffer byteBuffer) {
    }

    /* JADX INFO: renamed from: b */
    public void m11580b(Framedata framedata) {
    }

    private class WebsocketWriteThread implements Runnable {
        private WebsocketWriteThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebsocketWriteThread");
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer byteBufferTake = WebSocketClient.this.f11747c.f11730f.take();
                    WebSocketClient.this.f11750f.write(byteBufferTake.array(), 0, byteBufferTake.limit());
                    WebSocketClient.this.f11750f.flush();
                } catch (IOException e) {
                    WebSocketClient.this.f11747c.m11549b();
                    return;
                } catch (InterruptedException e2) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m11576a(Socket socket) {
        if (this.f11748d != null) {
            throw new IllegalStateException("socket has already been set");
        }
        this.f11748d = socket;
    }

    /* JADX INFO: renamed from: a */
    public void m11572a(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        this.f11747c.m11546a(opcode, byteBuffer, z);
    }

    /* JADX INFO: renamed from: d */
    public boolean m11582d() {
        return this.f11747c.m11552c();
    }

    /* JADX INFO: renamed from: e */
    public boolean m11583e() {
        return this.f11747c.m11554e();
    }

    /* JADX INFO: renamed from: f */
    public boolean m11584f() {
        return this.f11747c.m11555f();
    }

    /* JADX INFO: renamed from: g */
    public boolean m11585g() {
        return this.f11747c.m11553d();
    }

    @Override // com.mixpanel.android.java_websocket.WebSocket
    /* JADX INFO: renamed from: a */
    public void mo11526a(Framedata framedata) {
        this.f11747c.mo11526a(framedata);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocket
    /* JADX INFO: renamed from: a */
    public InetSocketAddress mo11525a() {
        return this.f11747c.mo11525a();
    }
}
