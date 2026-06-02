package com.mixpanel.android.java_websocket;

import android.annotation.SuppressLint;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.drafts.Draft_10;
import com.mixpanel.android.java_websocket.drafts.Draft_17;
import com.mixpanel.android.java_websocket.drafts.Draft_75;
import com.mixpanel.android.java_websocket.drafts.Draft_76;
import com.mixpanel.android.java_websocket.exceptions.IncompleteHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.WebsocketNotConnectedException;
import com.mixpanel.android.java_websocket.framing.CloseFrameBuilder;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@SuppressLint("Assert")
public class WebSocketImpl implements WebSocket {
   public static int a;
   public static boolean b;
   public static final List<Draft> c;
   static final boolean h;
   public SelectionKey d;
   public ByteChannel e;
   public final BlockingQueue<ByteBuffer> f;
   public final BlockingQueue<ByteBuffer> g;
   private volatile boolean i = false;
   private WebSocket.READYSTATE j = WebSocket.READYSTATE.NOT_YET_CONNECTED;
   private final WebSocketListener k;
   private List<Draft> l;
   private Draft m = null;
   private WebSocket.Role n;
   private Framedata.Opcode o = null;
   private ByteBuffer p = ByteBuffer.allocate(0);
   private ClientHandshake q = null;
   private String r = null;
   private Integer s = null;
   private Boolean t = null;
   private String u = null;

   static {
      boolean var0;
      if (!WebSocketImpl.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      h = var0;
      a = 16384;
      b = false;
      c = new ArrayList<>(4);
      c.add(new Draft_17());
      c.add(new Draft_10());
      c.add(new Draft_76());
      c.add(new Draft_75());
   }

   public WebSocketImpl(WebSocketListener var1, Draft var2) {
      if (var1 != null && (var2 != null || this.n != WebSocket.Role.SERVER)) {
         this.f = new LinkedBlockingQueue<>();
         this.g = new LinkedBlockingQueue<>();
         this.k = var1;
         this.n = WebSocket.Role.CLIENT;
         if (var2 != null) {
            this.m = var2.c();
         }
      } else {
         throw new IllegalArgumentException("parameters must not be null");
      }
   }

   private void a(Handshakedata var1) {
      if (b) {
         System.out.println("open using draft: " + this.m.getClass().getSimpleName());
      }

      this.j = WebSocket.READYSTATE.OPEN;

      try {
         this.k.a(this, var1);
      } catch (RuntimeException var2) {
         this.k.a(this, var2);
      }
   }

   private void a(Collection<Framedata> var1) {
      if (!this.c()) {
         throw new WebsocketNotConnectedException();
      }

      Iterator var2 = var1.iterator();

      while (var2.hasNext()) {
         this.a((Framedata)var2.next());
      }
   }

   private void a(List<ByteBuffer> var1) {
      Iterator var2 = var1.iterator();

      while (var2.hasNext()) {
         this.e((ByteBuffer)var2.next());
      }
   }

   private boolean b(ByteBuffer param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: getfield com/mixpanel/android/java_websocket/WebSocketImpl.p Ljava/nio/ByteBuffer;
      // 004: invokevirtual java/nio/ByteBuffer.capacity ()I
      // 007: ifne 051
      // 00a: aload 1
      // 00b: astore 5
      // 00d: aload 5
      // 00f: invokevirtual java/nio/ByteBuffer.mark ()Ljava/nio/Buffer;
      // 012: pop
      // 013: aload 0
      // 014: getfield com/mixpanel/android/java_websocket/WebSocketImpl.m Lcom/mixpanel/android/java_websocket/drafts/Draft;
      // 017: ifnonnull 0ee
      // 01a: aload 0
      // 01b: aload 5
      // 01d: invokespecial com/mixpanel/android/java_websocket/WebSocketImpl.d (Ljava/nio/ByteBuffer;)Lcom/mixpanel/android/java_websocket/drafts/Draft$HandshakeState;
      // 020: astore 7
      // 022: getstatic com/mixpanel/android/java_websocket/drafts/Draft$HandshakeState.MATCHED Lcom/mixpanel/android/java_websocket/drafts/Draft$HandshakeState;
      // 025: astore 6
      // 027: aload 7
      // 029: aload 6
      // 02b: if_acmpne 0ee
      // 02e: aload 0
      // 02f: aload 0
      // 030: getfield com/mixpanel/android/java_websocket/WebSocketImpl.k Lcom/mixpanel/android/java_websocket/WebSocketListener;
      // 033: aload 0
      // 034: invokeinterface com/mixpanel/android/java_websocket/WebSocketListener.a (Lcom/mixpanel/android/java_websocket/WebSocket;)Ljava/lang/String; 2
      // 039: invokestatic com/mixpanel/android/java_websocket/util/Charsetfunctions.a (Ljava/lang/String;)[B
      // 03c: invokestatic java/nio/ByteBuffer.wrap ([B)Ljava/nio/ByteBuffer;
      // 03f: invokespecial com/mixpanel/android/java_websocket/WebSocketImpl.e (Ljava/nio/ByteBuffer;)V
      // 042: aload 0
      // 043: bipush -3
      // 045: ldc_w ""
      // 048: invokevirtual com/mixpanel/android/java_websocket/WebSocketImpl.a (ILjava/lang/String;)V
      // 04b: bipush 0
      // 04c: istore 4
      // 04e: iload 4
      // 050: ireturn
      // 051: aload 0
      // 052: getfield com/mixpanel/android/java_websocket/WebSocketImpl.p Ljava/nio/ByteBuffer;
      // 055: invokevirtual java/nio/ByteBuffer.remaining ()I
      // 058: aload 1
      // 059: invokevirtual java/nio/ByteBuffer.remaining ()I
      // 05c: if_icmpge 088
      // 05f: aload 0
      // 060: getfield com/mixpanel/android/java_websocket/WebSocketImpl.p Ljava/nio/ByteBuffer;
      // 063: invokevirtual java/nio/ByteBuffer.capacity ()I
      // 066: aload 1
      // 067: invokevirtual java/nio/ByteBuffer.remaining ()I
      // 06a: iadd
      // 06b: invokestatic java/nio/ByteBuffer.allocate (I)Ljava/nio/ByteBuffer;
      // 06e: astore 5
      // 070: aload 0
      // 071: getfield com/mixpanel/android/java_websocket/WebSocketImpl.p Ljava/nio/ByteBuffer;
      // 074: invokevirtual java/nio/ByteBuffer.flip ()Ljava/nio/Buffer;
      // 077: pop
      // 078: aload 5
      // 07a: aload 0
      // 07b: getfield com/mixpanel/android/java_websocket/WebSocketImpl.p Ljava/nio/ByteBuffer;
      // 07e: invokevirtual java/nio/ByteBuffer.put (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
      // 081: pop
      // 082: aload 0
      // 083: aload 5
      // 085: putfield com/mixpanel/android/java_websocket/WebSocketImpl.p Ljava/nio/ByteBuffer;
      // 088: aload 0
      // 089: getfield com/mixpanel/android/java_websocket/WebSocketImpl.p Ljava/nio/ByteBuffer;
      // 08c: aload 1
      // 08d: invokevirtual java/nio/ByteBuffer.put (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
      // 090: pop
      // 091: aload 0
      // 092: getfield com/mixpanel/android/java_websocket/WebSocketImpl.p Ljava/nio/ByteBuffer;
      // 095: invokevirtual java/nio/ByteBuffer.flip ()Ljava/nio/Buffer;
      // 098: pop
      // 099: aload 0
      // 09a: getfield com/mixpanel/android/java_websocket/WebSocketImpl.p Ljava/nio/ByteBuffer;
      // 09d: astore 5
      // 09f: goto 00d
      // 0a2: astore 6
      // 0a4: aload 0
      // 0a5: sipush 1006
      // 0a8: ldc_w "remote peer closed connection before flashpolicy could be transmitted"
      // 0ab: bipush 1
      // 0ac: invokespecial com/mixpanel/android/java_websocket/WebSocketImpl.c (ILjava/lang/String;Z)V
      // 0af: goto 04b
      // 0b2: astore 6
      // 0b4: aload 0
      // 0b5: getfield com/mixpanel/android/java_websocket/WebSocketImpl.p Ljava/nio/ByteBuffer;
      // 0b8: invokevirtual java/nio/ByteBuffer.capacity ()I
      // 0bb: ifne 351
      // 0be: aload 5
      // 0c0: invokevirtual java/nio/ByteBuffer.reset ()Ljava/nio/Buffer;
      // 0c3: pop
      // 0c4: aload 6
      // 0c6: invokevirtual com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException.a ()I
      // 0c9: istore 3
      // 0ca: iload 3
      // 0cb: ifne 332
      // 0ce: aload 5
      // 0d0: invokevirtual java/nio/ByteBuffer.capacity ()I
      // 0d3: bipush 16
      // 0d5: iadd
      // 0d6: istore 2
      // 0d7: aload 0
      // 0d8: iload 2
      // 0d9: invokestatic java/nio/ByteBuffer.allocate (I)Ljava/nio/ByteBuffer;
      // 0dc: putfield com/mixpanel/android/java_websocket/WebSocketImpl.p Ljava/nio/ByteBuffer;
      // 0df: aload 0
      // 0e0: getfield com/mixpanel/android/java_websocket/WebSocketImpl.p Ljava/nio/ByteBuffer;
      // 0e3: aload 1
      // 0e4: invokevirtual java/nio/ByteBuffer.put (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
      // 0e7: pop
      // 0e8: bipush 0
      // 0e9: istore 4
      // 0eb: goto 04e
      // 0ee: aload 0
      // 0ef: getfield com/mixpanel/android/java_websocket/WebSocketImpl.n Lcom/mixpanel/android/java_websocket/WebSocket$Role;
      // 0f2: getstatic com/mixpanel/android/java_websocket/WebSocket$Role.SERVER Lcom/mixpanel/android/java_websocket/WebSocket$Role;
      // 0f5: if_acmpne 24e
      // 0f8: aload 0
      // 0f9: getfield com/mixpanel/android/java_websocket/WebSocketImpl.m Lcom/mixpanel/android/java_websocket/drafts/Draft;
      // 0fc: ifnonnull 1f8
      // 0ff: aload 0
      // 100: getfield com/mixpanel/android/java_websocket/WebSocketImpl.l Ljava/util/List;
      // 103: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 108: astore 6
      // 10a: aload 6
      // 10c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 111: ifeq 1e1
      // 114: aload 6
      // 116: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 11b: checkcast com/mixpanel/android/java_websocket/drafts/Draft
      // 11e: invokevirtual com/mixpanel/android/java_websocket/drafts/Draft.c ()Lcom/mixpanel/android/java_websocket/drafts/Draft;
      // 121: astore 7
      // 123: aload 7
      // 125: aload 0
      // 126: getfield com/mixpanel/android/java_websocket/WebSocketImpl.n Lcom/mixpanel/android/java_websocket/WebSocket$Role;
      // 129: invokevirtual com/mixpanel/android/java_websocket/drafts/Draft.a (Lcom/mixpanel/android/java_websocket/WebSocket$Role;)V
      // 12c: aload 5
      // 12e: invokevirtual java/nio/ByteBuffer.reset ()Ljava/nio/Buffer;
      // 131: pop
      // 132: aload 7
      // 134: aload 5
      // 136: invokevirtual com/mixpanel/android/java_websocket/drafts/Draft.d (Ljava/nio/ByteBuffer;)Lcom/mixpanel/android/java_websocket/handshake/Handshakedata;
      // 139: astore 8
      // 13b: aload 8
      // 13d: instanceof com/mixpanel/android/java_websocket/handshake/ClientHandshake
      // 140: ifne 154
      // 143: aload 0
      // 144: sipush 1002
      // 147: ldc_w "wrong http function"
      // 14a: bipush 0
      // 14b: invokevirtual com/mixpanel/android/java_websocket/WebSocketImpl.b (ILjava/lang/String;Z)V
      // 14e: bipush 0
      // 14f: istore 4
      // 151: goto 04e
      // 154: aload 8
      // 156: checkcast com/mixpanel/android/java_websocket/handshake/ClientHandshake
      // 159: astore 8
      // 15b: aload 7
      // 15d: aload 8
      // 15f: invokevirtual com/mixpanel/android/java_websocket/drafts/Draft.a (Lcom/mixpanel/android/java_websocket/handshake/ClientHandshake;)Lcom/mixpanel/android/java_websocket/drafts/Draft$HandshakeState;
      // 162: getstatic com/mixpanel/android/java_websocket/drafts/Draft$HandshakeState.MATCHED Lcom/mixpanel/android/java_websocket/drafts/Draft$HandshakeState;
      // 165: if_acmpne 10a
      // 168: aload 0
      // 169: aload 8
      // 16b: invokeinterface com/mixpanel/android/java_websocket/handshake/ClientHandshake.a ()Ljava/lang/String; 1
      // 170: putfield com/mixpanel/android/java_websocket/WebSocketImpl.u Ljava/lang/String;
      // 173: aload 0
      // 174: getfield com/mixpanel/android/java_websocket/WebSocketImpl.k Lcom/mixpanel/android/java_websocket/WebSocketListener;
      // 177: aload 0
      // 178: aload 7
      // 17a: aload 8
      // 17c: invokeinterface com/mixpanel/android/java_websocket/WebSocketListener.a (Lcom/mixpanel/android/java_websocket/WebSocket;Lcom/mixpanel/android/java_websocket/drafts/Draft;Lcom/mixpanel/android/java_websocket/handshake/ClientHandshake;)Lcom/mixpanel/android/java_websocket/handshake/ServerHandshakeBuilder; 4
      // 181: astore 9
      // 183: aload 0
      // 184: aload 7
      // 186: aload 7
      // 188: aload 8
      // 18a: aload 9
      // 18c: invokevirtual com/mixpanel/android/java_websocket/drafts/Draft.a (Lcom/mixpanel/android/java_websocket/handshake/ClientHandshake;Lcom/mixpanel/android/java_websocket/handshake/ServerHandshakeBuilder;)Lcom/mixpanel/android/java_websocket/handshake/HandshakeBuilder;
      // 18f: aload 0
      // 190: getfield com/mixpanel/android/java_websocket/WebSocketImpl.n Lcom/mixpanel/android/java_websocket/WebSocket$Role;
      // 193: invokevirtual com/mixpanel/android/java_websocket/drafts/Draft.a (Lcom/mixpanel/android/java_websocket/handshake/Handshakedata;Lcom/mixpanel/android/java_websocket/WebSocket$Role;)Ljava/util/List;
      // 196: invokespecial com/mixpanel/android/java_websocket/WebSocketImpl.a (Ljava/util/List;)V
      // 199: aload 0
      // 19a: aload 7
      // 19c: putfield com/mixpanel/android/java_websocket/WebSocketImpl.m Lcom/mixpanel/android/java_websocket/drafts/Draft;
      // 19f: aload 0
      // 1a0: aload 8
      // 1a2: invokespecial com/mixpanel/android/java_websocket/WebSocketImpl.a (Lcom/mixpanel/android/java_websocket/handshake/Handshakedata;)V
      // 1a5: bipush 1
      // 1a6: istore 4
      // 1a8: goto 04e
      // 1ab: astore 7
      // 1ad: aload 0
      // 1ae: aload 7
      // 1b0: invokevirtual com/mixpanel/android/java_websocket/exceptions/InvalidDataException.a ()I
      // 1b3: aload 7
      // 1b5: invokevirtual com/mixpanel/android/java_websocket/exceptions/InvalidDataException.getMessage ()Ljava/lang/String;
      // 1b8: bipush 0
      // 1b9: invokevirtual com/mixpanel/android/java_websocket/WebSocketImpl.b (ILjava/lang/String;Z)V
      // 1bc: bipush 0
      // 1bd: istore 4
      // 1bf: goto 04e
      // 1c2: astore 7
      // 1c4: aload 0
      // 1c5: getfield com/mixpanel/android/java_websocket/WebSocketImpl.k Lcom/mixpanel/android/java_websocket/WebSocketListener;
      // 1c8: aload 0
      // 1c9: aload 7
      // 1cb: invokeinterface com/mixpanel/android/java_websocket/WebSocketListener.a (Lcom/mixpanel/android/java_websocket/WebSocket;Ljava/lang/Exception;)V 3
      // 1d0: aload 0
      // 1d1: bipush -1
      // 1d2: aload 7
      // 1d4: invokevirtual java/lang/RuntimeException.getMessage ()Ljava/lang/String;
      // 1d7: bipush 0
      // 1d8: invokevirtual com/mixpanel/android/java_websocket/WebSocketImpl.b (ILjava/lang/String;Z)V
      // 1db: bipush 0
      // 1dc: istore 4
      // 1de: goto 04e
      // 1e1: aload 0
      // 1e2: getfield com/mixpanel/android/java_websocket/WebSocketImpl.m Lcom/mixpanel/android/java_websocket/drafts/Draft;
      // 1e5: ifnonnull 1f2
      // 1e8: aload 0
      // 1e9: sipush 1002
      // 1ec: ldc_w "no draft matches"
      // 1ef: invokevirtual com/mixpanel/android/java_websocket/WebSocketImpl.a (ILjava/lang/String;)V
      // 1f2: bipush 0
      // 1f3: istore 4
      // 1f5: goto 04e
      // 1f8: aload 0
      // 1f9: getfield com/mixpanel/android/java_websocket/WebSocketImpl.m Lcom/mixpanel/android/java_websocket/drafts/Draft;
      // 1fc: aload 5
      // 1fe: invokevirtual com/mixpanel/android/java_websocket/drafts/Draft.d (Ljava/nio/ByteBuffer;)Lcom/mixpanel/android/java_websocket/handshake/Handshakedata;
      // 201: astore 6
      // 203: aload 6
      // 205: instanceof com/mixpanel/android/java_websocket/handshake/ClientHandshake
      // 208: ifne 21c
      // 20b: aload 0
      // 20c: sipush 1002
      // 20f: ldc_w "wrong http function"
      // 212: bipush 0
      // 213: invokevirtual com/mixpanel/android/java_websocket/WebSocketImpl.b (ILjava/lang/String;Z)V
      // 216: bipush 0
      // 217: istore 4
      // 219: goto 04e
      // 21c: aload 6
      // 21e: checkcast com/mixpanel/android/java_websocket/handshake/ClientHandshake
      // 221: astore 6
      // 223: aload 0
      // 224: getfield com/mixpanel/android/java_websocket/WebSocketImpl.m Lcom/mixpanel/android/java_websocket/drafts/Draft;
      // 227: aload 6
      // 229: invokevirtual com/mixpanel/android/java_websocket/drafts/Draft.a (Lcom/mixpanel/android/java_websocket/handshake/ClientHandshake;)Lcom/mixpanel/android/java_websocket/drafts/Draft$HandshakeState;
      // 22c: getstatic com/mixpanel/android/java_websocket/drafts/Draft$HandshakeState.MATCHED Lcom/mixpanel/android/java_websocket/drafts/Draft$HandshakeState;
      // 22f: if_acmpne 23e
      // 232: aload 0
      // 233: aload 6
      // 235: invokespecial com/mixpanel/android/java_websocket/WebSocketImpl.a (Lcom/mixpanel/android/java_websocket/handshake/Handshakedata;)V
      // 238: bipush 1
      // 239: istore 4
      // 23b: goto 04e
      // 23e: aload 0
      // 23f: sipush 1002
      // 242: ldc_w "the handshake did finaly not match"
      // 245: invokevirtual com/mixpanel/android/java_websocket/WebSocketImpl.a (ILjava/lang/String;)V
      // 248: bipush 0
      // 249: istore 4
      // 24b: goto 04e
      // 24e: aload 0
      // 24f: getfield com/mixpanel/android/java_websocket/WebSocketImpl.n Lcom/mixpanel/android/java_websocket/WebSocket$Role;
      // 252: getstatic com/mixpanel/android/java_websocket/WebSocket$Role.CLIENT Lcom/mixpanel/android/java_websocket/WebSocket$Role;
      // 255: if_acmpne 0e8
      // 258: aload 0
      // 259: getfield com/mixpanel/android/java_websocket/WebSocketImpl.m Lcom/mixpanel/android/java_websocket/drafts/Draft;
      // 25c: aload 0
      // 25d: getfield com/mixpanel/android/java_websocket/WebSocketImpl.n Lcom/mixpanel/android/java_websocket/WebSocket$Role;
      // 260: invokevirtual com/mixpanel/android/java_websocket/drafts/Draft.a (Lcom/mixpanel/android/java_websocket/WebSocket$Role;)V
      // 263: aload 0
      // 264: getfield com/mixpanel/android/java_websocket/WebSocketImpl.m Lcom/mixpanel/android/java_websocket/drafts/Draft;
      // 267: aload 5
      // 269: invokevirtual com/mixpanel/android/java_websocket/drafts/Draft.d (Ljava/nio/ByteBuffer;)Lcom/mixpanel/android/java_websocket/handshake/Handshakedata;
      // 26c: astore 6
      // 26e: aload 6
      // 270: instanceof com/mixpanel/android/java_websocket/handshake/ServerHandshake
      // 273: ifne 287
      // 276: aload 0
      // 277: sipush 1002
      // 27a: ldc_w "wrong http function"
      // 27d: bipush 0
      // 27e: invokevirtual com/mixpanel/android/java_websocket/WebSocketImpl.b (ILjava/lang/String;Z)V
      // 281: bipush 0
      // 282: istore 4
      // 284: goto 04e
      // 287: aload 6
      // 289: checkcast com/mixpanel/android/java_websocket/handshake/ServerHandshake
      // 28c: astore 8
      // 28e: aload 0
      // 28f: getfield com/mixpanel/android/java_websocket/WebSocketImpl.m Lcom/mixpanel/android/java_websocket/drafts/Draft;
      // 292: aload 0
      // 293: getfield com/mixpanel/android/java_websocket/WebSocketImpl.q Lcom/mixpanel/android/java_websocket/handshake/ClientHandshake;
      // 296: aload 8
      // 298: invokevirtual com/mixpanel/android/java_websocket/drafts/Draft.a (Lcom/mixpanel/android/java_websocket/handshake/ClientHandshake;Lcom/mixpanel/android/java_websocket/handshake/ServerHandshake;)Lcom/mixpanel/android/java_websocket/drafts/Draft$HandshakeState;
      // 29b: astore 7
      // 29d: getstatic com/mixpanel/android/java_websocket/drafts/Draft$HandshakeState.MATCHED Lcom/mixpanel/android/java_websocket/drafts/Draft$HandshakeState;
      // 2a0: astore 6
      // 2a2: aload 7
      // 2a4: aload 6
      // 2a6: if_acmpne 2fb
      // 2a9: aload 0
      // 2aa: getfield com/mixpanel/android/java_websocket/WebSocketImpl.k Lcom/mixpanel/android/java_websocket/WebSocketListener;
      // 2ad: aload 0
      // 2ae: aload 0
      // 2af: getfield com/mixpanel/android/java_websocket/WebSocketImpl.q Lcom/mixpanel/android/java_websocket/handshake/ClientHandshake;
      // 2b2: aload 8
      // 2b4: invokeinterface com/mixpanel/android/java_websocket/WebSocketListener.a (Lcom/mixpanel/android/java_websocket/WebSocket;Lcom/mixpanel/android/java_websocket/handshake/ClientHandshake;Lcom/mixpanel/android/java_websocket/handshake/ServerHandshake;)V 4
      // 2b9: aload 0
      // 2ba: aload 8
      // 2bc: invokespecial com/mixpanel/android/java_websocket/WebSocketImpl.a (Lcom/mixpanel/android/java_websocket/handshake/Handshakedata;)V
      // 2bf: bipush 1
      // 2c0: istore 4
      // 2c2: goto 04e
      // 2c5: astore 6
      // 2c7: aload 0
      // 2c8: aload 6
      // 2ca: invokevirtual com/mixpanel/android/java_websocket/exceptions/InvalidDataException.a ()I
      // 2cd: aload 6
      // 2cf: invokevirtual com/mixpanel/android/java_websocket/exceptions/InvalidDataException.getMessage ()Ljava/lang/String;
      // 2d2: bipush 0
      // 2d3: invokevirtual com/mixpanel/android/java_websocket/WebSocketImpl.b (ILjava/lang/String;Z)V
      // 2d6: bipush 0
      // 2d7: istore 4
      // 2d9: goto 04e
      // 2dc: astore 6
      // 2de: aload 0
      // 2df: getfield com/mixpanel/android/java_websocket/WebSocketImpl.k Lcom/mixpanel/android/java_websocket/WebSocketListener;
      // 2e2: aload 0
      // 2e3: aload 6
      // 2e5: invokeinterface com/mixpanel/android/java_websocket/WebSocketListener.a (Lcom/mixpanel/android/java_websocket/WebSocket;Ljava/lang/Exception;)V 3
      // 2ea: aload 0
      // 2eb: bipush -1
      // 2ec: aload 6
      // 2ee: invokevirtual java/lang/RuntimeException.getMessage ()Ljava/lang/String;
      // 2f1: bipush 0
      // 2f2: invokevirtual com/mixpanel/android/java_websocket/WebSocketImpl.b (ILjava/lang/String;Z)V
      // 2f5: bipush 0
      // 2f6: istore 4
      // 2f8: goto 04e
      // 2fb: new java/lang/StringBuilder
      // 2fe: astore 6
      // 300: aload 6
      // 302: invokespecial java/lang/StringBuilder.<init> ()V
      // 305: aload 0
      // 306: sipush 1002
      // 309: aload 6
      // 30b: ldc_w "draft "
      // 30e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 311: aload 0
      // 312: getfield com/mixpanel/android/java_websocket/WebSocketImpl.m Lcom/mixpanel/android/java_websocket/drafts/Draft;
      // 315: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 318: ldc_w " refuses handshake"
      // 31b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 31e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 321: invokevirtual com/mixpanel/android/java_websocket/WebSocketImpl.a (ILjava/lang/String;)V
      // 324: goto 0e8
      // 327: astore 6
      // 329: aload 0
      // 32a: aload 6
      // 32c: invokevirtual com/mixpanel/android/java_websocket/WebSocketImpl.a (Lcom/mixpanel/android/java_websocket/exceptions/InvalidDataException;)V
      // 32f: goto 0e8
      // 332: iload 3
      // 333: istore 2
      // 334: getstatic com/mixpanel/android/java_websocket/WebSocketImpl.h Z
      // 337: ifne 0d7
      // 33a: iload 3
      // 33b: istore 2
      // 33c: aload 6
      // 33e: invokevirtual com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException.a ()I
      // 341: aload 5
      // 343: invokevirtual java/nio/ByteBuffer.remaining ()I
      // 346: if_icmpge 0d7
      // 349: new java/lang/AssertionError
      // 34c: dup
      // 34d: invokespecial java/lang/AssertionError.<init> ()V
      // 350: athrow
      // 351: aload 0
      // 352: getfield com/mixpanel/android/java_websocket/WebSocketImpl.p Ljava/nio/ByteBuffer;
      // 355: aload 0
      // 356: getfield com/mixpanel/android/java_websocket/WebSocketImpl.p Ljava/nio/ByteBuffer;
      // 359: invokevirtual java/nio/ByteBuffer.limit ()I
      // 35c: invokevirtual java/nio/ByteBuffer.position (I)Ljava/nio/Buffer;
      // 35f: pop
      // 360: aload 0
      // 361: getfield com/mixpanel/android/java_websocket/WebSocketImpl.p Ljava/nio/ByteBuffer;
      // 364: aload 0
      // 365: getfield com/mixpanel/android/java_websocket/WebSocketImpl.p Ljava/nio/ByteBuffer;
      // 368: invokevirtual java/nio/ByteBuffer.capacity ()I
      // 36b: invokevirtual java/nio/ByteBuffer.limit (I)Ljava/nio/Buffer;
      // 36e: pop
      // 36f: goto 0e8
      // 372: astore 7
      // 374: goto 10a
      // try (9 -> 18): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (21 -> 33): 76 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (21 -> 33): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (77 -> 82): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (113 -> 124): 362 com/mixpanel/android/java_websocket/exceptions/InvalidHandshakeException
      // try (113 -> 124): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (124 -> 132): 362 com/mixpanel/android/java_websocket/exceptions/InvalidHandshakeException
      // try (124 -> 132): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (132 -> 151): 397 com/mixpanel/android/java_websocket/exceptions/InvalidHandshakeException
      // try (132 -> 151): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (154 -> 166): 397 com/mixpanel/android/java_websocket/exceptions/InvalidHandshakeException
      // try (154 -> 166): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (166 -> 173): 192 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (166 -> 173): 203 java/lang/RuntimeException
      // try (166 -> 173): 397 com/mixpanel/android/java_websocket/exceptions/InvalidHandshakeException
      // try (166 -> 173): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (173 -> 189): 397 com/mixpanel/android/java_websocket/exceptions/InvalidHandshakeException
      // try (173 -> 189): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (193 -> 200): 397 com/mixpanel/android/java_websocket/exceptions/InvalidHandshakeException
      // try (193 -> 200): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (204 -> 215): 397 com/mixpanel/android/java_websocket/exceptions/InvalidHandshakeException
      // try (204 -> 215): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (218 -> 225): 362 com/mixpanel/android/java_websocket/exceptions/InvalidHandshakeException
      // try (218 -> 225): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (228 -> 241): 362 com/mixpanel/android/java_websocket/exceptions/InvalidHandshakeException
      // try (228 -> 241): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (244 -> 256): 362 com/mixpanel/android/java_websocket/exceptions/InvalidHandshakeException
      // try (244 -> 256): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (259 -> 263): 362 com/mixpanel/android/java_websocket/exceptions/InvalidHandshakeException
      // try (259 -> 263): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (266 -> 288): 362 com/mixpanel/android/java_websocket/exceptions/InvalidHandshakeException
      // try (266 -> 288): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (291 -> 303): 362 com/mixpanel/android/java_websocket/exceptions/InvalidHandshakeException
      // try (291 -> 303): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (306 -> 313): 319 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (306 -> 313): 330 java/lang/RuntimeException
      // try (306 -> 313): 362 com/mixpanel/android/java_websocket/exceptions/InvalidHandshakeException
      // try (306 -> 313): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (313 -> 316): 362 com/mixpanel/android/java_websocket/exceptions/InvalidHandshakeException
      // try (313 -> 316): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (320 -> 327): 362 com/mixpanel/android/java_websocket/exceptions/InvalidHandshakeException
      // try (320 -> 327): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (331 -> 342): 362 com/mixpanel/android/java_websocket/exceptions/InvalidHandshakeException
      // try (331 -> 342): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (345 -> 361): 362 com/mixpanel/android/java_websocket/exceptions/InvalidHandshakeException
      // try (345 -> 361): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
      // try (363 -> 366): 83 com/mixpanel/android/java_websocket/exceptions/IncompleteHandshakeException
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void c(int var1, String var2, boolean var3) {
      if (this.j != WebSocket.READYSTATE.CLOSING && this.j != WebSocket.READYSTATE.CLOSED) {
         if (this.j == WebSocket.READYSTATE.OPEN) {
            if (var1 == 1006) {
               if (!h && var3) {
                  throw new AssertionError();
               }

               this.j = WebSocket.READYSTATE.CLOSING;
               this.b(var1, var2, false);
               return;
            }

            label53:
            if (this.m.b() != Draft.CloseHandshakeType.NONE) {
               label59:
               if (!var3) {
                  RuntimeException var4;
                  try {
                     try {
                        this.k.a(this, var1, var2);
                        break label59;
                     } catch (RuntimeException var7) {
                        var4 = var7;
                     }
                  } catch (InvalidDataException var8) {
                     this.k.a(this, var8);
                     this.b(1006, "generated frame is invalid", false);
                     break label53;
                  }

                  try {
                     this.k.a(this, var4);
                  } catch (InvalidDataException var6) {
                     this.k.a(this, var6);
                     this.b(1006, "generated frame is invalid", false);
                     break label53;
                  }
               }

               try {
                  CloseFrameBuilder var9 = new CloseFrameBuilder(var1, var2);
                  this.a(var9);
               } catch (InvalidDataException var5) {
                  this.k.a(this, var5);
                  this.b(1006, "generated frame is invalid", false);
               }
            }

            this.b(var1, var2, var3);
         } else if (var1 == -3) {
            if (!h && !var3) {
               throw new AssertionError();
            }

            this.b(-3, var2, true);
         } else {
            this.b(-1, var2, false);
         }

         if (var1 == 1002) {
            this.b(var1, var2, var3);
         }

         this.j = WebSocket.READYSTATE.CLOSING;
         this.p = null;
      }
   }

   private void c(ByteBuffer param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: getfield com/mixpanel/android/java_websocket/WebSocketImpl.m Lcom/mixpanel/android/java_websocket/drafts/Draft;
      // 004: aload 1
      // 005: invokevirtual com/mixpanel/android/java_websocket/drafts/Draft.c (Ljava/nio/ByteBuffer;)Ljava/util/List;
      // 008: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 00d: astore 4
      // 00f: aload 4
      // 011: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 016: ifeq 0a3
      // 019: aload 4
      // 01b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 020: checkcast com/mixpanel/android/java_websocket/framing/Framedata
      // 023: astore 1
      // 024: getstatic com/mixpanel/android/java_websocket/WebSocketImpl.b Z
      // 027: ifeq 04d
      // 02a: getstatic java/lang/System.out Ljava/io/PrintStream;
      // 02d: astore 5
      // 02f: new java/lang/StringBuilder
      // 032: astore 6
      // 034: aload 6
      // 036: invokespecial java/lang/StringBuilder.<init> ()V
      // 039: aload 5
      // 03b: aload 6
      // 03d: ldc_w "matched frame: "
      // 040: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 043: aload 1
      // 044: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 047: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 04a: invokevirtual java/io/PrintStream.println (Ljava/lang/String;)V
      // 04d: aload 1
      // 04e: invokeinterface com/mixpanel/android/java_websocket/framing/Framedata.f ()Lcom/mixpanel/android/java_websocket/framing/Framedata$Opcode; 1
      // 053: astore 5
      // 055: aload 1
      // 056: invokeinterface com/mixpanel/android/java_websocket/framing/Framedata.d ()Z 1
      // 05b: istore 3
      // 05c: aload 5
      // 05e: getstatic com/mixpanel/android/java_websocket/framing/Framedata$Opcode.CLOSING Lcom/mixpanel/android/java_websocket/framing/Framedata$Opcode;
      // 061: if_acmpne 0c5
      // 064: aload 1
      // 065: instanceof com/mixpanel/android/java_websocket/framing/CloseFrame
      // 068: ifeq 1ff
      // 06b: aload 1
      // 06c: checkcast com/mixpanel/android/java_websocket/framing/CloseFrame
      // 06f: astore 1
      // 070: aload 1
      // 071: invokeinterface com/mixpanel/android/java_websocket/framing/CloseFrame.a ()I 1
      // 076: istore 2
      // 077: aload 1
      // 078: invokeinterface com/mixpanel/android/java_websocket/framing/CloseFrame.b ()Ljava/lang/String; 1
      // 07d: astore 1
      // 07e: aload 0
      // 07f: getfield com/mixpanel/android/java_websocket/WebSocketImpl.j Lcom/mixpanel/android/java_websocket/WebSocket$READYSTATE;
      // 082: getstatic com/mixpanel/android/java_websocket/WebSocket$READYSTATE.CLOSING Lcom/mixpanel/android/java_websocket/WebSocket$READYSTATE;
      // 085: if_acmpne 0a4
      // 088: aload 0
      // 089: iload 2
      // 08a: aload 1
      // 08b: bipush 1
      // 08c: invokevirtual com/mixpanel/android/java_websocket/WebSocketImpl.a (ILjava/lang/String;Z)V
      // 08f: goto 00f
      // 092: astore 1
      // 093: aload 0
      // 094: getfield com/mixpanel/android/java_websocket/WebSocketImpl.k Lcom/mixpanel/android/java_websocket/WebSocketListener;
      // 097: aload 0
      // 098: aload 1
      // 099: invokeinterface com/mixpanel/android/java_websocket/WebSocketListener.a (Lcom/mixpanel/android/java_websocket/WebSocket;Ljava/lang/Exception;)V 3
      // 09e: aload 0
      // 09f: aload 1
      // 0a0: invokevirtual com/mixpanel/android/java_websocket/WebSocketImpl.a (Lcom/mixpanel/android/java_websocket/exceptions/InvalidDataException;)V
      // 0a3: return
      // 0a4: aload 0
      // 0a5: getfield com/mixpanel/android/java_websocket/WebSocketImpl.m Lcom/mixpanel/android/java_websocket/drafts/Draft;
      // 0a8: invokevirtual com/mixpanel/android/java_websocket/drafts/Draft.b ()Lcom/mixpanel/android/java_websocket/drafts/Draft$CloseHandshakeType;
      // 0ab: getstatic com/mixpanel/android/java_websocket/drafts/Draft$CloseHandshakeType.TWOWAY Lcom/mixpanel/android/java_websocket/drafts/Draft$CloseHandshakeType;
      // 0ae: if_acmpne 0bb
      // 0b1: aload 0
      // 0b2: iload 2
      // 0b3: aload 1
      // 0b4: bipush 1
      // 0b5: invokespecial com/mixpanel/android/java_websocket/WebSocketImpl.c (ILjava/lang/String;Z)V
      // 0b8: goto 00f
      // 0bb: aload 0
      // 0bc: iload 2
      // 0bd: aload 1
      // 0be: bipush 0
      // 0bf: invokevirtual com/mixpanel/android/java_websocket/WebSocketImpl.b (ILjava/lang/String;Z)V
      // 0c2: goto 00f
      // 0c5: aload 5
      // 0c7: getstatic com/mixpanel/android/java_websocket/framing/Framedata$Opcode.PING Lcom/mixpanel/android/java_websocket/framing/Framedata$Opcode;
      // 0ca: if_acmpne 0db
      // 0cd: aload 0
      // 0ce: getfield com/mixpanel/android/java_websocket/WebSocketImpl.k Lcom/mixpanel/android/java_websocket/WebSocketListener;
      // 0d1: aload 0
      // 0d2: aload 1
      // 0d3: invokeinterface com/mixpanel/android/java_websocket/WebSocketListener.b (Lcom/mixpanel/android/java_websocket/WebSocket;Lcom/mixpanel/android/java_websocket/framing/Framedata;)V 3
      // 0d8: goto 00f
      // 0db: aload 5
      // 0dd: getstatic com/mixpanel/android/java_websocket/framing/Framedata$Opcode.PONG Lcom/mixpanel/android/java_websocket/framing/Framedata$Opcode;
      // 0e0: if_acmpne 0f1
      // 0e3: aload 0
      // 0e4: getfield com/mixpanel/android/java_websocket/WebSocketImpl.k Lcom/mixpanel/android/java_websocket/WebSocketListener;
      // 0e7: aload 0
      // 0e8: aload 1
      // 0e9: invokeinterface com/mixpanel/android/java_websocket/WebSocketListener.c (Lcom/mixpanel/android/java_websocket/WebSocket;Lcom/mixpanel/android/java_websocket/framing/Framedata;)V 3
      // 0ee: goto 00f
      // 0f1: iload 3
      // 0f2: ifeq 0fd
      // 0f5: aload 5
      // 0f7: getstatic com/mixpanel/android/java_websocket/framing/Framedata$Opcode.CONTINUOUS Lcom/mixpanel/android/java_websocket/framing/Framedata$Opcode;
      // 0fa: if_acmpne 179
      // 0fd: aload 5
      // 0ff: getstatic com/mixpanel/android/java_websocket/framing/Framedata$Opcode.CONTINUOUS Lcom/mixpanel/android/java_websocket/framing/Framedata$Opcode;
      // 102: if_acmpeq 13f
      // 105: aload 0
      // 106: getfield com/mixpanel/android/java_websocket/WebSocketImpl.o Lcom/mixpanel/android/java_websocket/framing/Framedata$Opcode;
      // 109: ifnull 11c
      // 10c: new com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // 10f: astore 1
      // 110: aload 1
      // 111: sipush 1002
      // 114: ldc_w "Previous continuous frame sequence not completed."
      // 117: invokespecial com/mixpanel/android/java_websocket/exceptions/InvalidDataException.<init> (ILjava/lang/String;)V
      // 11a: aload 1
      // 11b: athrow
      // 11c: aload 0
      // 11d: aload 5
      // 11f: putfield com/mixpanel/android/java_websocket/WebSocketImpl.o Lcom/mixpanel/android/java_websocket/framing/Framedata$Opcode;
      // 122: aload 0
      // 123: getfield com/mixpanel/android/java_websocket/WebSocketImpl.k Lcom/mixpanel/android/java_websocket/WebSocketListener;
      // 126: aload 0
      // 127: aload 1
      // 128: invokeinterface com/mixpanel/android/java_websocket/WebSocketListener.a (Lcom/mixpanel/android/java_websocket/WebSocket;Lcom/mixpanel/android/java_websocket/framing/Framedata;)V 3
      // 12d: goto 00f
      // 130: astore 1
      // 131: aload 0
      // 132: getfield com/mixpanel/android/java_websocket/WebSocketImpl.k Lcom/mixpanel/android/java_websocket/WebSocketListener;
      // 135: aload 0
      // 136: aload 1
      // 137: invokeinterface com/mixpanel/android/java_websocket/WebSocketListener.a (Lcom/mixpanel/android/java_websocket/WebSocket;Ljava/lang/Exception;)V 3
      // 13c: goto 00f
      // 13f: iload 3
      // 140: ifeq 162
      // 143: aload 0
      // 144: getfield com/mixpanel/android/java_websocket/WebSocketImpl.o Lcom/mixpanel/android/java_websocket/framing/Framedata$Opcode;
      // 147: ifnonnull 15a
      // 14a: new com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // 14d: astore 1
      // 14e: aload 1
      // 14f: sipush 1002
      // 152: ldc_w "Continuous frame sequence was not started."
      // 155: invokespecial com/mixpanel/android/java_websocket/exceptions/InvalidDataException.<init> (ILjava/lang/String;)V
      // 158: aload 1
      // 159: athrow
      // 15a: aload 0
      // 15b: aconst_null
      // 15c: putfield com/mixpanel/android/java_websocket/WebSocketImpl.o Lcom/mixpanel/android/java_websocket/framing/Framedata$Opcode;
      // 15f: goto 122
      // 162: aload 0
      // 163: getfield com/mixpanel/android/java_websocket/WebSocketImpl.o Lcom/mixpanel/android/java_websocket/framing/Framedata$Opcode;
      // 166: ifnonnull 122
      // 169: new com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // 16c: astore 1
      // 16d: aload 1
      // 16e: sipush 1002
      // 171: ldc_w "Continuous frame sequence was not started."
      // 174: invokespecial com/mixpanel/android/java_websocket/exceptions/InvalidDataException.<init> (ILjava/lang/String;)V
      // 177: aload 1
      // 178: athrow
      // 179: aload 0
      // 17a: getfield com/mixpanel/android/java_websocket/WebSocketImpl.o Lcom/mixpanel/android/java_websocket/framing/Framedata$Opcode;
      // 17d: ifnull 190
      // 180: new com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // 183: astore 1
      // 184: aload 1
      // 185: sipush 1002
      // 188: ldc_w "Continuous frame sequence not completed."
      // 18b: invokespecial com/mixpanel/android/java_websocket/exceptions/InvalidDataException.<init> (ILjava/lang/String;)V
      // 18e: aload 1
      // 18f: athrow
      // 190: getstatic com/mixpanel/android/java_websocket/framing/Framedata$Opcode.TEXT Lcom/mixpanel/android/java_websocket/framing/Framedata$Opcode;
      // 193: astore 6
      // 195: aload 5
      // 197: aload 6
      // 199: if_acmpne 1c1
      // 19c: aload 0
      // 19d: getfield com/mixpanel/android/java_websocket/WebSocketImpl.k Lcom/mixpanel/android/java_websocket/WebSocketListener;
      // 1a0: aload 0
      // 1a1: aload 1
      // 1a2: invokeinterface com/mixpanel/android/java_websocket/framing/Framedata.c ()Ljava/nio/ByteBuffer; 1
      // 1a7: invokestatic com/mixpanel/android/java_websocket/util/Charsetfunctions.a (Ljava/nio/ByteBuffer;)Ljava/lang/String;
      // 1aa: invokeinterface com/mixpanel/android/java_websocket/WebSocketListener.a (Lcom/mixpanel/android/java_websocket/WebSocket;Ljava/lang/String;)V 3
      // 1af: goto 00f
      // 1b2: astore 1
      // 1b3: aload 0
      // 1b4: getfield com/mixpanel/android/java_websocket/WebSocketImpl.k Lcom/mixpanel/android/java_websocket/WebSocketListener;
      // 1b7: aload 0
      // 1b8: aload 1
      // 1b9: invokeinterface com/mixpanel/android/java_websocket/WebSocketListener.a (Lcom/mixpanel/android/java_websocket/WebSocket;Ljava/lang/Exception;)V 3
      // 1be: goto 00f
      // 1c1: getstatic com/mixpanel/android/java_websocket/framing/Framedata$Opcode.BINARY Lcom/mixpanel/android/java_websocket/framing/Framedata$Opcode;
      // 1c4: astore 6
      // 1c6: aload 5
      // 1c8: aload 6
      // 1ca: if_acmpne 1ef
      // 1cd: aload 0
      // 1ce: getfield com/mixpanel/android/java_websocket/WebSocketImpl.k Lcom/mixpanel/android/java_websocket/WebSocketListener;
      // 1d1: aload 0
      // 1d2: aload 1
      // 1d3: invokeinterface com/mixpanel/android/java_websocket/framing/Framedata.c ()Ljava/nio/ByteBuffer; 1
      // 1d8: invokeinterface com/mixpanel/android/java_websocket/WebSocketListener.a (Lcom/mixpanel/android/java_websocket/WebSocket;Ljava/nio/ByteBuffer;)V 3
      // 1dd: goto 00f
      // 1e0: astore 1
      // 1e1: aload 0
      // 1e2: getfield com/mixpanel/android/java_websocket/WebSocketImpl.k Lcom/mixpanel/android/java_websocket/WebSocketListener;
      // 1e5: aload 0
      // 1e6: aload 1
      // 1e7: invokeinterface com/mixpanel/android/java_websocket/WebSocketListener.a (Lcom/mixpanel/android/java_websocket/WebSocket;Ljava/lang/Exception;)V 3
      // 1ec: goto 00f
      // 1ef: new com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // 1f2: astore 1
      // 1f3: aload 1
      // 1f4: sipush 1002
      // 1f7: ldc_w "non control or continious frame expected"
      // 1fa: invokespecial com/mixpanel/android/java_websocket/exceptions/InvalidDataException.<init> (ILjava/lang/String;)V
      // 1fd: aload 1
      // 1fe: athrow
      // 1ff: ldc_w ""
      // 202: astore 1
      // 203: sipush 1005
      // 206: istore 2
      // 207: goto 07e
      // try (0 -> 6): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (6 -> 29): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (29 -> 50): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (50 -> 59): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (70 -> 80): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (81 -> 86): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (87 -> 95): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (96 -> 104): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (107 -> 110): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (110 -> 124): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (124 -> 127): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (127 -> 132): 133 java/lang/RuntimeException
      // try (127 -> 132): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (134 -> 139): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (142 -> 153): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (153 -> 156): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (157 -> 168): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (168 -> 179): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (179 -> 181): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (184 -> 191): 192 java/lang/RuntimeException
      // try (184 -> 191): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (193 -> 198): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (199 -> 201): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (204 -> 210): 211 java/lang/RuntimeException
      // try (204 -> 210): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (212 -> 217): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
      // try (218 -> 226): 60 com/mixpanel/android/java_websocket/exceptions/InvalidDataException
   }

   private Draft.HandshakeState d(ByteBuffer var1) throws IncompleteHandshakeException {
      ((Buffer)var1).mark();
      Draft.HandshakeState var3;
      if (var1.limit() > Draft.c.length) {
         var3 = Draft.HandshakeState.NOT_MATCHED;
      } else {
         if (var1.limit() < Draft.c.length) {
            throw new IncompleteHandshakeException(Draft.c.length);
         }

         int var2 = 0;

         while (true) {
            if (!var1.hasRemaining()) {
               var3 = Draft.HandshakeState.MATCHED;
               break;
            }

            if (Draft.c[var2] != var1.get()) {
               ((Buffer)var1).reset();
               var3 = Draft.HandshakeState.NOT_MATCHED;
               break;
            }

            var2++;
         }
      }

      return var3;
   }

   private void e(ByteBuffer var1) {
      if (b) {
         PrintStream var3 = System.out;
         StringBuilder var4 = new StringBuilder().append("write(").append(var1.remaining()).append("): {");
         String var2;
         if (var1.remaining() > 1000) {
            var2 = "too big to display";
         } else {
            var2 = new String(var1.array());
         }

         var3.println(var4.append(var2).append("}").toString());
      }

      this.f.add(var1);
      this.k.b(this);
   }

   @Override
   public InetSocketAddress a() {
      return this.k.c(this);
   }

   public void a(int var1, String var2) {
      this.c(var1, var2, false);
   }

   protected void a(int param1, String param2, boolean param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/mixpanel/android/java_websocket/WebSocketImpl.j Lcom/mixpanel/android/java_websocket/WebSocket$READYSTATE;
      // 06: astore 4
      // 08: getstatic com/mixpanel/android/java_websocket/WebSocket$READYSTATE.CLOSED Lcom/mixpanel/android/java_websocket/WebSocket$READYSTATE;
      // 0b: astore 5
      // 0d: aload 4
      // 0f: aload 5
      // 11: if_acmpne 17
      // 14: aload 0
      // 15: monitorexit
      // 16: return
      // 17: aload 0
      // 18: getfield com/mixpanel/android/java_websocket/WebSocketImpl.d Ljava/nio/channels/SelectionKey;
      // 1b: ifnull 25
      // 1e: aload 0
      // 1f: getfield com/mixpanel/android/java_websocket/WebSocketImpl.d Ljava/nio/channels/SelectionKey;
      // 22: invokevirtual java/nio/channels/SelectionKey.cancel ()V
      // 25: aload 0
      // 26: getfield com/mixpanel/android/java_websocket/WebSocketImpl.e Ljava/nio/channels/ByteChannel;
      // 29: astore 4
      // 2b: aload 4
      // 2d: ifnull 39
      // 30: aload 0
      // 31: getfield com/mixpanel/android/java_websocket/WebSocketImpl.e Ljava/nio/channels/ByteChannel;
      // 34: invokeinterface java/nio/channels/ByteChannel.close ()V 1
      // 39: aload 0
      // 3a: getfield com/mixpanel/android/java_websocket/WebSocketImpl.k Lcom/mixpanel/android/java_websocket/WebSocketListener;
      // 3d: aload 0
      // 3e: iload 1
      // 3f: aload 2
      // 40: iload 3
      // 41: invokeinterface com/mixpanel/android/java_websocket/WebSocketListener.a (Lcom/mixpanel/android/java_websocket/WebSocket;ILjava/lang/String;Z)V 5
      // 46: aload 0
      // 47: getfield com/mixpanel/android/java_websocket/WebSocketImpl.m Lcom/mixpanel/android/java_websocket/drafts/Draft;
      // 4a: ifnull 54
      // 4d: aload 0
      // 4e: getfield com/mixpanel/android/java_websocket/WebSocketImpl.m Lcom/mixpanel/android/java_websocket/drafts/Draft;
      // 51: invokevirtual com/mixpanel/android/java_websocket/drafts/Draft.a ()V
      // 54: aload 0
      // 55: aconst_null
      // 56: putfield com/mixpanel/android/java_websocket/WebSocketImpl.q Lcom/mixpanel/android/java_websocket/handshake/ClientHandshake;
      // 59: aload 0
      // 5a: getstatic com/mixpanel/android/java_websocket/WebSocket$READYSTATE.CLOSED Lcom/mixpanel/android/java_websocket/WebSocket$READYSTATE;
      // 5d: putfield com/mixpanel/android/java_websocket/WebSocketImpl.j Lcom/mixpanel/android/java_websocket/WebSocket$READYSTATE;
      // 60: aload 0
      // 61: getfield com/mixpanel/android/java_websocket/WebSocketImpl.f Ljava/util/concurrent/BlockingQueue;
      // 64: invokeinterface java/util/concurrent/BlockingQueue.clear ()V 1
      // 69: goto 14
      // 6c: astore 2
      // 6d: aload 0
      // 6e: monitorexit
      // 6f: aload 2
      // 70: athrow
      // 71: astore 4
      // 73: aload 0
      // 74: getfield com/mixpanel/android/java_websocket/WebSocketImpl.k Lcom/mixpanel/android/java_websocket/WebSocketListener;
      // 77: aload 0
      // 78: aload 4
      // 7a: invokeinterface com/mixpanel/android/java_websocket/WebSocketListener.a (Lcom/mixpanel/android/java_websocket/WebSocket;Ljava/lang/Exception;)V 3
      // 7f: goto 39
      // 82: astore 2
      // 83: aload 0
      // 84: getfield com/mixpanel/android/java_websocket/WebSocketImpl.k Lcom/mixpanel/android/java_websocket/WebSocketListener;
      // 87: aload 0
      // 88: aload 2
      // 89: invokeinterface com/mixpanel/android/java_websocket/WebSocketListener.a (Lcom/mixpanel/android/java_websocket/WebSocket;Ljava/lang/Exception;)V 3
      // 8e: goto 46
      // try (2 -> 7): 50 null
      // try (13 -> 19): 50 null
      // try (19 -> 22): 50 null
      // try (24 -> 27): 55 java/io/IOException
      // try (24 -> 27): 50 null
      // try (27 -> 34): 62 java/lang/RuntimeException
      // try (27 -> 34): 50 null
      // try (34 -> 40): 50 null
      // try (40 -> 49): 50 null
      // try (56 -> 61): 50 null
      // try (63 -> 68): 50 null
   }

   protected void a(int var1, boolean var2) {
      this.a(var1, "", var2);
   }

   public void a(InvalidDataException var1) {
      this.c(var1.a(), var1.getMessage(), false);
   }

   public void a(Framedata.Opcode var1, ByteBuffer var2, boolean var3) {
      this.a((Collection<Framedata>)this.m.a(var1, var2, var3));
   }

   @Override
   public void a(Framedata var1) {
      if (b) {
         System.out.println("send frame: " + var1);
      }

      this.e(this.m.a(var1));
   }

   public void a(ClientHandshakeBuilder var1) throws InvalidHandshakeException {
      if (!h && this.j == WebSocket.READYSTATE.CONNECTING) {
         throw new AssertionError("shall only be called once");
      }

      this.q = this.m.a(var1);
      this.u = var1.a();
      if (!h && this.u == null) {
         throw new AssertionError();
      }

      try {
         this.k.a(this, this.q);
      } catch (InvalidDataException var2) {
         throw new InvalidHandshakeException("Handshake data rejected by client.");
      } catch (RuntimeException var3) {
         this.k.a(this, var3);
         throw new InvalidHandshakeException("rejected because of" + var3);
      }

      this.a(this.m.a(this.q, this.n));
   }

   public void a(ByteBuffer var1) {
      if (!h && !var1.hasRemaining()) {
         throw new AssertionError();
      }

      if (b) {
         PrintStream var3 = System.out;
         StringBuilder var4 = new StringBuilder().append("process(").append(var1.remaining()).append("): {");
         String var2;
         if (var1.remaining() > 1000) {
            var2 = "too big to display";
         } else {
            var2 = new String(var1.array(), var1.position(), var1.remaining());
         }

         var3.println(var4.append(var2).append("}").toString());
      }

      if (this.j != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
         this.c(var1);
      } else if (this.b(var1)) {
         if (!h && this.p.hasRemaining() == var1.hasRemaining() && var1.hasRemaining()) {
            throw new AssertionError();
         }

         if (var1.hasRemaining()) {
            this.c(var1);
         } else if (this.p.hasRemaining()) {
            this.c(this.p);
         }
      }

      if (!h && !this.d() && !this.e() && var1.hasRemaining()) {
         throw new AssertionError();
      }
   }

   public void b() {
      if (this.g() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
         this.a(-1, true);
      } else if (this.i) {
         this.a(this.s, this.r, this.t);
      } else if (this.m.b() == Draft.CloseHandshakeType.NONE) {
         this.a(1000, true);
      } else if (this.m.b() == Draft.CloseHandshakeType.ONEWAY) {
         if (this.n == WebSocket.Role.SERVER) {
            this.a(1006, true);
         } else {
            this.a(1000, true);
         }
      } else {
         this.a(1006, true);
      }
   }

   public void b(int var1, String var2) {
      this.a(var1, var2, false);
   }

   protected void b(int param1, String param2, boolean param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/mixpanel/android/java_websocket/WebSocketImpl.i Z
      // 06: istore 4
      // 08: iload 4
      // 0a: ifeq 10
      // 0d: aload 0
      // 0e: monitorexit
      // 0f: return
      // 10: aload 0
      // 11: iload 1
      // 12: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 15: putfield com/mixpanel/android/java_websocket/WebSocketImpl.s Ljava/lang/Integer;
      // 18: aload 0
      // 19: aload 2
      // 1a: putfield com/mixpanel/android/java_websocket/WebSocketImpl.r Ljava/lang/String;
      // 1d: aload 0
      // 1e: iload 3
      // 1f: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 22: putfield com/mixpanel/android/java_websocket/WebSocketImpl.t Ljava/lang/Boolean;
      // 25: aload 0
      // 26: bipush 1
      // 27: putfield com/mixpanel/android/java_websocket/WebSocketImpl.i Z
      // 2a: aload 0
      // 2b: getfield com/mixpanel/android/java_websocket/WebSocketImpl.k Lcom/mixpanel/android/java_websocket/WebSocketListener;
      // 2e: aload 0
      // 2f: invokeinterface com/mixpanel/android/java_websocket/WebSocketListener.b (Lcom/mixpanel/android/java_websocket/WebSocket;)V 2
      // 34: aload 0
      // 35: getfield com/mixpanel/android/java_websocket/WebSocketImpl.k Lcom/mixpanel/android/java_websocket/WebSocketListener;
      // 38: aload 0
      // 39: iload 1
      // 3a: aload 2
      // 3b: iload 3
      // 3c: invokeinterface com/mixpanel/android/java_websocket/WebSocketListener.b (Lcom/mixpanel/android/java_websocket/WebSocket;ILjava/lang/String;Z)V 5
      // 41: aload 0
      // 42: getfield com/mixpanel/android/java_websocket/WebSocketImpl.m Lcom/mixpanel/android/java_websocket/drafts/Draft;
      // 45: ifnull 4f
      // 48: aload 0
      // 49: getfield com/mixpanel/android/java_websocket/WebSocketImpl.m Lcom/mixpanel/android/java_websocket/drafts/Draft;
      // 4c: invokevirtual com/mixpanel/android/java_websocket/drafts/Draft.a ()V
      // 4f: aload 0
      // 50: aconst_null
      // 51: putfield com/mixpanel/android/java_websocket/WebSocketImpl.q Lcom/mixpanel/android/java_websocket/handshake/ClientHandshake;
      // 54: goto 0d
      // 57: astore 2
      // 58: aload 0
      // 59: monitorexit
      // 5a: aload 2
      // 5b: athrow
      // 5c: astore 2
      // 5d: aload 0
      // 5e: getfield com/mixpanel/android/java_websocket/WebSocketImpl.k Lcom/mixpanel/android/java_websocket/WebSocketListener;
      // 61: aload 0
      // 62: aload 2
      // 63: invokeinterface com/mixpanel/android/java_websocket/WebSocketListener.a (Lcom/mixpanel/android/java_websocket/WebSocket;Ljava/lang/Exception;)V 3
      // 68: goto 41
      // try (2 -> 5): 45 null
      // try (10 -> 28): 45 null
      // try (28 -> 35): 50 java/lang/RuntimeException
      // try (28 -> 35): 45 null
      // try (35 -> 41): 45 null
      // try (41 -> 44): 45 null
      // try (51 -> 56): 45 null
   }

   public boolean c() {
      if (!h && this.j == WebSocket.READYSTATE.OPEN && this.i) {
         throw new AssertionError();
      }

      boolean var1;
      if (this.j == WebSocket.READYSTATE.OPEN) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean d() {
      boolean var1;
      if (this.j == WebSocket.READYSTATE.CLOSING) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean e() {
      return this.i;
   }

   public boolean f() {
      boolean var1;
      if (this.j == WebSocket.READYSTATE.CLOSED) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public WebSocket.READYSTATE g() {
      return this.j;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }

   @Override
   public String toString() {
      return super.toString();
   }
}
