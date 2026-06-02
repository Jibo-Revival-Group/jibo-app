package com.mixpanel.android.java_websocket.client;

import android.annotation.SuppressLint;
import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.WebSocketAdapter;
import com.mixpanel.android.java_websocket.WebSocketImpl;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.framing.Framedata;
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
import java.util.Map.Entry;
import java.util.concurrent.CountDownLatch;

@SuppressLint("Assert")
public abstract class WebSocketClient extends WebSocketAdapter implements WebSocket, Runnable {
   static final boolean b;
   protected URI a = null;
   private WebSocketImpl c = null;
   private Socket d = null;
   private InputStream e;
   private OutputStream f;
   private Proxy g = Proxy.NO_PROXY;
   private Thread h;
   private Draft i;
   private Map<String, String> j;
   private CountDownLatch k = new CountDownLatch(1);
   private CountDownLatch l = new CountDownLatch(1);
   private int m = 0;

   static {
      boolean var0;
      if (!WebSocketClient.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      b = var0;
   }

   public WebSocketClient(URI var1, Draft var2, Map<String, String> var3, int var4) {
      if (var1 == null) {
         throw new IllegalArgumentException();
      }

      if (var2 == null) {
         throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
      }

      this.a = var1;
      this.i = var2;
      this.j = var3;
      this.m = var4;
      this.c = new WebSocketImpl(this, var2);
   }

   private int h() {
      int var2 = this.a.getPort();
      int var1 = var2;
      if (var2 == -1) {
         String var3 = this.a.getScheme();
         if (var3.equals("wss")) {
            var1 = 443;
         } else {
            if (!var3.equals("ws")) {
               throw new RuntimeException("unkonow scheme" + var3);
            }

            var1 = 80;
         }
      }

      return var1;
   }

   private void i() throws InvalidHandshakeException {
      String var2;
      String var4;
      label31: {
         String var3 = this.a.getPath();
         var4 = this.a.getQuery();
         if (var3 != null) {
            var2 = var3;
            if (var3.length() != 0) {
               break label31;
            }
         }

         var2 = "/";
      }

      String var7 = var2;
      if (var4 != null) {
         var7 = var2 + "?" + var4;
      }

      int var1 = this.h();
      StringBuilder var9 = new StringBuilder().append(this.a.getHost());
      if (var1 != 80) {
         var2 = ":" + var1;
      } else {
         var2 = "";
      }

      var4 = var9.append(var2).toString();
      HandshakeImpl1Client var6 = new HandshakeImpl1Client();
      var6.a(var7);
      var6.a("Host", var4);
      if (this.j != null) {
         for (Entry var8 : this.j.entrySet()) {
            var6.a((String)var8.getKey(), (String)var8.getValue());
         }
      }

      this.c.a(var6);
   }

   @Override
   public InetSocketAddress a() {
      return this.c.a();
   }

   public void a(int var1, String var2) {
   }

   public void a(int var1, String var2, boolean var3) {
   }

   @Override
   public void a(WebSocket var1, int var2, String var3) {
      this.a(var2, var3);
   }

   @Override
   public final void a(WebSocket var1, int var2, String var3, boolean var4) {
      this.k.countDown();
      this.l.countDown();
      if (this.h != null) {
         this.h.interrupt();
      }

      try {
         if (this.d != null) {
            this.d.close();
         }
      } catch (IOException var5) {
         this.a(this, var5);
      }

      this.b(var2, var3, var4);
   }

   @Override
   public void a(WebSocket var1, Framedata var2) {
      this.b(var2);
   }

   @Override
   public final void a(WebSocket var1, Handshakedata var2) {
      this.k.countDown();
      this.a((ServerHandshake)var2);
   }

   @Override
   public final void a(WebSocket var1, Exception var2) {
      this.a(var2);
   }

   @Override
   public final void a(WebSocket var1, String var2) {
      this.a(var2);
   }

   @Override
   public final void a(WebSocket var1, ByteBuffer var2) {
      this.a(var2);
   }

   public void a(Framedata.Opcode var1, ByteBuffer var2, boolean var3) {
      this.c.a(var1, var2, var3);
   }

   @Override
   public void a(Framedata var1) {
      this.c.a(var1);
   }

   public abstract void a(ServerHandshake var1);

   public abstract void a(Exception var1);

   public abstract void a(String var1);

   public void a(Socket var1) {
      if (this.d != null) {
         throw new IllegalStateException("socket has already been set");
      }

      this.d = var1;
   }

   public void a(ByteBuffer var1) {
   }

   public void b() {
      if (this.h != null) {
         throw new IllegalStateException("WebSocketClient objects are not reuseable");
      }

      this.h = new Thread(this);
      this.h.start();
   }

   public abstract void b(int var1, String var2, boolean var3);

   @Override
   public final void b(WebSocket var1) {
   }

   @Override
   public void b(WebSocket var1, int var2, String var3, boolean var4) {
      this.a(var2, var3, var4);
   }

   public void b(Framedata var1) {
   }

   @Override
   public InetSocketAddress c(WebSocket var1) {
      InetSocketAddress var2;
      if (this.d != null) {
         var2 = (InetSocketAddress)this.d.getLocalSocketAddress();
      } else {
         var2 = null;
      }

      return var2;
   }

   public boolean c() throws InterruptedException {
      this.b();
      this.k.await();
      return this.c.c();
   }

   public boolean d() {
      return this.c.c();
   }

   public boolean e() {
      return this.c.e();
   }

   public boolean f() {
      return this.c.f();
   }

   public boolean g() {
      return this.c.d();
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public void run() {
      label78: {
         try {
            if (this.d == null) {
               Socket var14 = new Socket(this.g);
               this.d = var14;
               break label78;
            }
         } catch (Exception var13) {
            this.a(this.c, var13);
            this.c.b(-1, var13.getMessage());
            return;
         }

         try {
            if (this.d.isClosed()) {
               IOException var2 = new IOException();
               throw var2;
            }
         } catch (Exception var12) {
            this.a(this.c, var12);
            this.c.b(-1, var12.getMessage());
            return;
         }
      }

      try {
         if (!this.d.isBound()) {
            Socket var15 = this.d;
            InetSocketAddress var3 = new InetSocketAddress(this.a.getHost(), this.h());
            var15.connect(var3, this.m);
         }
      } catch (Exception var11) {
         this.a(this.c, var11);
         this.c.b(-1, var11.getMessage());
         return;
      }

      try {
         this.e = this.d.getInputStream();
         this.f = this.d.getOutputStream();
         this.i();
      } catch (Exception var10) {
         this.a(this.c, var10);
         this.c.b(-1, var10.getMessage());
         return;
      }

      this.h = new Thread(new WebSocketClient.WebsocketWriteThread(this));
      this.h.start();
      byte[] var16 = new byte[WebSocketImpl.a];

      label59: {
         while (true) {
            int var1;
            try {
               if (this.f()) {
                  break;
               }

               var1 = this.e.read(var16);
            } catch (IOException var8) {
               this.c.b();
               break label59;
            } catch (RuntimeException var9) {
               this.a(var9);
               this.c.b(1006, var9.getMessage());
               break label59;
            }

            if (var1 == -1) {
               break;
            }

            try {
               this.c.a(ByteBuffer.wrap(var16, 0, var1));
            } catch (IOException var6) {
               this.c.b();
               break label59;
            } catch (RuntimeException var7) {
               this.a(var7);
               this.c.b(1006, var7.getMessage());
               break label59;
            }
         }

         try {
            this.c.b();
         } catch (IOException var4) {
            this.c.b();
         } catch (RuntimeException var5) {
            this.a(var5);
            this.c.b(1006, var5.getMessage());
         }
      }

      if (!b && !this.d.isClosed()) {
         throw new AssertionError();
      }
   }

   private class WebsocketWriteThread implements Runnable {
      final WebSocketClient a;

      private WebsocketWriteThread(WebSocketClient var1) {
         this.a = var1;
      }

      @Override
      public void run() {
         Thread.currentThread().setName("WebsocketWriteThread");

         while (true) {
            try {
               if (Thread.interrupted()) {
                  break;
               }

               ByteBuffer var1 = this.a.c.f.take();
               this.a.f.write(var1.array(), 0, var1.limit());
               this.a.f.flush();
            } catch (IOException var2) {
               this.a.c.b();
               break;
            } catch (InterruptedException var3) {
               break;
            }
         }
      }
   }
}
