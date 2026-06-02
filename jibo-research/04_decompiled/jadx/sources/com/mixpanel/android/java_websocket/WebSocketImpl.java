package com.mixpanel.android.java_websocket;

import android.annotation.SuppressLint;
import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.drafts.Draft_10;
import com.mixpanel.android.java_websocket.drafts.Draft_17;
import com.mixpanel.android.java_websocket.drafts.Draft_75;
import com.mixpanel.android.java_websocket.drafts.Draft_76;
import com.mixpanel.android.java_websocket.exceptions.IncompleteHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.WebsocketNotConnectedException;
import com.mixpanel.android.java_websocket.framing.CloseFrame;
import com.mixpanel.android.java_websocket.framing.CloseFrameBuilder;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.util.Charsetfunctions;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"Assert"})
public class WebSocketImpl implements WebSocket {

    /* JADX INFO: renamed from: a */
    public static int f11724a;

    /* JADX INFO: renamed from: b */
    public static boolean f11725b;

    /* JADX INFO: renamed from: c */
    public static final List<Draft> f11726c;

    /* JADX INFO: renamed from: h */
    static final /* synthetic */ boolean f11727h;

    /* JADX INFO: renamed from: d */
    public SelectionKey f11728d;

    /* JADX INFO: renamed from: e */
    public ByteChannel f11729e;

    /* JADX INFO: renamed from: f */
    public final BlockingQueue<ByteBuffer> f11730f;

    /* JADX INFO: renamed from: g */
    public final BlockingQueue<ByteBuffer> f11731g;

    /* JADX INFO: renamed from: k */
    private final WebSocketListener f11734k;

    /* JADX INFO: renamed from: l */
    private List<Draft> f11735l;

    /* JADX INFO: renamed from: m */
    private Draft f11736m;

    /* JADX INFO: renamed from: n */
    private WebSocket.Role f11737n;

    /* JADX INFO: renamed from: i */
    private volatile boolean f11732i = false;

    /* JADX INFO: renamed from: j */
    private WebSocket.READYSTATE f11733j = WebSocket.READYSTATE.NOT_YET_CONNECTED;

    /* JADX INFO: renamed from: o */
    private Framedata.Opcode f11738o = null;

    /* JADX INFO: renamed from: p */
    private ByteBuffer f11739p = ByteBuffer.allocate(0);

    /* JADX INFO: renamed from: q */
    private ClientHandshake f11740q = null;

    /* JADX INFO: renamed from: r */
    private String f11741r = null;

    /* JADX INFO: renamed from: s */
    private Integer f11742s = null;

    /* JADX INFO: renamed from: t */
    private Boolean f11743t = null;

    /* JADX INFO: renamed from: u */
    private String f11744u = null;

    static {
        f11727h = !WebSocketImpl.class.desiredAssertionStatus();
        f11724a = 16384;
        f11725b = false;
        f11726c = new ArrayList(4);
        f11726c.add(new Draft_17());
        f11726c.add(new Draft_10());
        f11726c.add(new Draft_76());
        f11726c.add(new Draft_75());
    }

    public WebSocketImpl(WebSocketListener webSocketListener, Draft draft) {
        this.f11736m = null;
        if (webSocketListener == null || (draft == null && this.f11737n == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.f11730f = new LinkedBlockingQueue();
        this.f11731g = new LinkedBlockingQueue();
        this.f11734k = webSocketListener;
        this.f11737n = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.f11736m = draft.mo11602c();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m11548a(ByteBuffer byteBuffer) {
        if (!f11727h && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        if (f11725b) {
            System.out.println("process(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining())) + "}");
        }
        if (this.f11733j != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            m11539c(byteBuffer);
        } else if (m11537b(byteBuffer)) {
            if (!f11727h && this.f11739p.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                m11539c(byteBuffer);
            } else if (this.f11739p.hasRemaining()) {
                m11539c(this.f11739p);
            }
        }
        if (!f11727h && !m11553d() && !m11554e() && byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01fa  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m11537b(java.nio.ByteBuffer r9) {
        /*
            Method dump skipped, instruction units count: 533
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.java_websocket.WebSocketImpl.m11537b(java.nio.ByteBuffer):boolean");
    }

    /* JADX INFO: renamed from: c */
    private void m11539c(ByteBuffer byteBuffer) {
        String strMo11621b;
        int iMo11620a;
        try {
            for (Framedata framedata : this.f11736m.mo11603c(byteBuffer)) {
                if (f11725b) {
                    System.out.println("matched frame: " + framedata);
                }
                Framedata.Opcode opcodeMo11631f = framedata.mo11631f();
                boolean zMo11629d = framedata.mo11629d();
                if (opcodeMo11631f == Framedata.Opcode.CLOSING) {
                    if (!(framedata instanceof CloseFrame)) {
                        strMo11621b = "";
                        iMo11620a = 1005;
                    } else {
                        CloseFrame closeFrame = (CloseFrame) framedata;
                        iMo11620a = closeFrame.mo11620a();
                        strMo11621b = closeFrame.mo11621b();
                    }
                    if (this.f11733j == WebSocket.READYSTATE.CLOSING) {
                        m11543a(iMo11620a, strMo11621b, true);
                    } else if (this.f11736m.mo11601b() == Draft.CloseHandshakeType.TWOWAY) {
                        m11538c(iMo11620a, strMo11621b, true);
                    } else {
                        m11551b(iMo11620a, strMo11621b, false);
                    }
                } else if (opcodeMo11631f == Framedata.Opcode.PING) {
                    this.f11734k.mo11532b(this, framedata);
                } else if (opcodeMo11631f == Framedata.Opcode.PONG) {
                    this.f11734k.mo11533c(this, framedata);
                } else if (!zMo11629d || opcodeMo11631f == Framedata.Opcode.CONTINUOUS) {
                    if (opcodeMo11631f != Framedata.Opcode.CONTINUOUS) {
                        if (this.f11738o != null) {
                            throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                        }
                        this.f11738o = opcodeMo11631f;
                    } else if (zMo11629d) {
                        if (this.f11738o == null) {
                            throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                        }
                        this.f11738o = null;
                    } else if (this.f11738o == null) {
                        throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                    }
                    try {
                        this.f11734k.mo11529a(this, framedata);
                    } catch (RuntimeException e) {
                        this.f11734k.mo11560a(this, e);
                    }
                } else {
                    if (this.f11738o != null) {
                        throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
                    }
                    if (opcodeMo11631f == Framedata.Opcode.TEXT) {
                        try {
                            this.f11734k.mo11561a(this, Charsetfunctions.m11655a(framedata.mo11626c()));
                        } catch (RuntimeException e2) {
                            this.f11734k.mo11560a(this, e2);
                        }
                    } else if (opcodeMo11631f == Framedata.Opcode.BINARY) {
                        try {
                            this.f11734k.mo11562a(this, framedata.mo11626c());
                        } catch (RuntimeException e3) {
                            this.f11734k.mo11560a(this, e3);
                        }
                    } else {
                        throw new InvalidDataException(1002, "non control or continious frame expected");
                    }
                }
            }
        } catch (InvalidDataException e4) {
            this.f11734k.mo11560a(this, e4);
            m11545a(e4);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m11538c(int i, String str, boolean z) {
        if (this.f11733j != WebSocket.READYSTATE.CLOSING && this.f11733j != WebSocket.READYSTATE.CLOSED) {
            if (this.f11733j == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!f11727h && z) {
                        throw new AssertionError();
                    }
                    this.f11733j = WebSocket.READYSTATE.CLOSING;
                    m11551b(i, str, false);
                    return;
                }
                if (this.f11736m.mo11601b() != Draft.CloseHandshakeType.NONE) {
                    try {
                        if (!z) {
                            try {
                                this.f11734k.mo11557a(this, i, str);
                            } catch (RuntimeException e) {
                                this.f11734k.mo11560a(this, e);
                            }
                        }
                        mo11526a(new CloseFrameBuilder(i, str));
                    } catch (InvalidDataException e2) {
                        this.f11734k.mo11560a(this, e2);
                        m11551b(1006, "generated frame is invalid", false);
                    }
                }
                m11551b(i, str, z);
            } else if (i == -3) {
                if (!f11727h && !z) {
                    throw new AssertionError();
                }
                m11551b(-3, str, true);
            } else {
                m11551b(-1, str, false);
            }
            if (i == 1002) {
                m11551b(i, str, z);
            }
            this.f11733j = WebSocket.READYSTATE.CLOSING;
            this.f11739p = null;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m11542a(int i, String str) {
        m11538c(i, str, false);
    }

    /* JADX INFO: renamed from: a */
    protected synchronized void m11543a(int i, String str, boolean z) {
        if (this.f11733j != WebSocket.READYSTATE.CLOSED) {
            if (this.f11728d != null) {
                this.f11728d.cancel();
            }
            if (this.f11729e != null) {
                try {
                    this.f11729e.close();
                } catch (IOException e) {
                    this.f11734k.mo11560a(this, e);
                }
            }
            try {
                this.f11734k.mo11558a(this, i, str, z);
            } catch (RuntimeException e2) {
                this.f11734k.mo11560a(this, e2);
            }
            if (this.f11736m != null) {
                this.f11736m.mo11598a();
            }
            this.f11740q = null;
            this.f11733j = WebSocket.READYSTATE.CLOSED;
            this.f11730f.clear();
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m11544a(int i, boolean z) {
        m11543a(i, "", z);
    }

    /* JADX INFO: renamed from: b */
    public void m11550b(int i, String str) {
        m11543a(i, str, false);
    }

    /* JADX INFO: renamed from: b */
    protected synchronized void m11551b(int i, String str, boolean z) {
        if (!this.f11732i) {
            this.f11742s = Integer.valueOf(i);
            this.f11741r = str;
            this.f11743t = Boolean.valueOf(z);
            this.f11732i = true;
            this.f11734k.mo11563b(this);
            try {
                this.f11734k.mo11564b(this, i, str, z);
            } catch (RuntimeException e) {
                this.f11734k.mo11560a(this, e);
            }
            if (this.f11736m != null) {
                this.f11736m.mo11598a();
            }
            this.f11740q = null;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m11549b() {
        if (m11556g() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            m11544a(-1, true);
            return;
        }
        if (this.f11732i) {
            m11543a(this.f11742s.intValue(), this.f11741r, this.f11743t.booleanValue());
            return;
        }
        if (this.f11736m.mo11601b() == Draft.CloseHandshakeType.NONE) {
            m11544a(1000, true);
            return;
        }
        if (this.f11736m.mo11601b() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.f11737n == WebSocket.Role.SERVER) {
                m11544a(1006, true);
                return;
            } else {
                m11544a(1000, true);
                return;
            }
        }
        m11544a(1006, true);
    }

    /* JADX INFO: renamed from: a */
    public void m11545a(InvalidDataException invalidDataException) {
        m11538c(invalidDataException.m11619a(), invalidDataException.getMessage(), false);
    }

    /* JADX INFO: renamed from: a */
    private void m11535a(Collection<Framedata> collection) {
        if (!m11552c()) {
            throw new WebsocketNotConnectedException();
        }
        Iterator<Framedata> it = collection.iterator();
        while (it.hasNext()) {
            mo11526a(it.next());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m11546a(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        m11535a(this.f11736m.m11595a(opcode, byteBuffer, z));
    }

    @Override // com.mixpanel.android.java_websocket.WebSocket
    /* JADX INFO: renamed from: a */
    public void mo11526a(Framedata framedata) {
        if (f11725b) {
            System.out.println("send frame: " + framedata);
        }
        m11541e(this.f11736m.mo11594a(framedata));
    }

    /* JADX INFO: renamed from: d */
    private Draft.HandshakeState m11540d(ByteBuffer byteBuffer) throws IncompleteHandshakeException {
        byteBuffer.mark();
        if (byteBuffer.limit() > Draft.f11761c.length) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        if (byteBuffer.limit() < Draft.f11761c.length) {
            throw new IncompleteHandshakeException(Draft.f11761c.length);
        }
        int i = 0;
        while (byteBuffer.hasRemaining()) {
            if (Draft.f11761c[i] == byteBuffer.get()) {
                i++;
            } else {
                byteBuffer.reset();
                return Draft.HandshakeState.NOT_MATCHED;
            }
        }
        return Draft.HandshakeState.MATCHED;
    }

    /* JADX INFO: renamed from: a */
    public void m11547a(ClientHandshakeBuilder clientHandshakeBuilder) throws InvalidHandshakeException {
        if (!f11727h && this.f11733j == WebSocket.READYSTATE.CONNECTING) {
            throw new AssertionError("shall only be called once");
        }
        this.f11740q = this.f11736m.mo11592a(clientHandshakeBuilder);
        this.f11744u = clientHandshakeBuilder.mo11632a();
        if (!f11727h && this.f11744u == null) {
            throw new AssertionError();
        }
        try {
            this.f11734k.mo11530a((WebSocket) this, this.f11740q);
            m11536a(this.f11736m.m11596a(this.f11740q, this.f11737n));
        } catch (InvalidDataException e) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        } catch (RuntimeException e2) {
            this.f11734k.mo11560a(this, e2);
            throw new InvalidHandshakeException("rejected because of" + e2);
        }
    }

    /* JADX INFO: renamed from: e */
    private void m11541e(ByteBuffer byteBuffer) {
        if (f11725b) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + "}");
        }
        this.f11730f.add(byteBuffer);
        this.f11734k.mo11563b(this);
    }

    /* JADX INFO: renamed from: a */
    private void m11536a(List<ByteBuffer> list) {
        Iterator<ByteBuffer> it = list.iterator();
        while (it.hasNext()) {
            m11541e(it.next());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m11534a(Handshakedata handshakedata) {
        if (f11725b) {
            System.out.println("open using draft: " + this.f11736m.getClass().getSimpleName());
        }
        this.f11733j = WebSocket.READYSTATE.OPEN;
        try {
            this.f11734k.mo11559a(this, handshakedata);
        } catch (RuntimeException e) {
            this.f11734k.mo11560a(this, e);
        }
    }

    /* JADX INFO: renamed from: c */
    public boolean m11552c() {
        if (!f11727h && this.f11733j == WebSocket.READYSTATE.OPEN && this.f11732i) {
            throw new AssertionError();
        }
        return this.f11733j == WebSocket.READYSTATE.OPEN;
    }

    /* JADX INFO: renamed from: d */
    public boolean m11553d() {
        return this.f11733j == WebSocket.READYSTATE.CLOSING;
    }

    /* JADX INFO: renamed from: e */
    public boolean m11554e() {
        return this.f11732i;
    }

    /* JADX INFO: renamed from: f */
    public boolean m11555f() {
        return this.f11733j == WebSocket.READYSTATE.CLOSED;
    }

    /* JADX INFO: renamed from: g */
    public WebSocket.READYSTATE m11556g() {
        return this.f11733j;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    @Override // com.mixpanel.android.java_websocket.WebSocket
    /* JADX INFO: renamed from: a */
    public InetSocketAddress mo11525a() {
        return this.f11734k.mo11565c(this);
    }
}
