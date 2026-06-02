package com.mixpanel.android.java_websocket.drafts;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.LimitExedeedException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.framing.FramedataImpl1;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Draft_75 extends Draft {
   protected boolean f = false;
   protected List<Framedata> g = new LinkedList<>();
   protected ByteBuffer h;
   private final Random i = new Random();

   @Override
   public Draft.HandshakeState a(ClientHandshake var1) {
      Draft.HandshakeState var2;
      if (var1.c("Origin") && this.a(var1)) {
         var2 = Draft.HandshakeState.MATCHED;
      } else {
         var2 = Draft.HandshakeState.NOT_MATCHED;
      }

      return var2;
   }

   @Override
   public Draft.HandshakeState a(ClientHandshake var1, ServerHandshake var2) {
      Draft.HandshakeState var3;
      if (var1.b("WebSocket-Origin").equals(var2.b("Origin")) && this.a(var2)) {
         var3 = Draft.HandshakeState.MATCHED;
      } else {
         var3 = Draft.HandshakeState.NOT_MATCHED;
      }

      return var3;
   }

   @Override
   public ClientHandshakeBuilder a(ClientHandshakeBuilder var1) throws InvalidHandshakeException {
      var1.a("Upgrade", "WebSocket");
      var1.a("Connection", "Upgrade");
      if (!var1.c("Origin")) {
         var1.a("Origin", "random" + this.i.nextInt());
      }

      return var1;
   }

   @Override
   public HandshakeBuilder a(ClientHandshake var1, ServerHandshakeBuilder var2) throws InvalidHandshakeException {
      var2.a("Web Socket Protocol Handshake");
      var2.a("Upgrade", "WebSocket");
      var2.a("Connection", var1.b("Connection"));
      var2.a("WebSocket-Origin", var1.b("Origin"));
      var2.a("WebSocket-Location", "ws://" + var1.b("Host") + var1.a());
      return var2;
   }

   @Override
   public ByteBuffer a(Framedata var1) {
      if (var1.f() != Framedata.Opcode.TEXT) {
         throw new RuntimeException("only text frames supported");
      }

      ByteBuffer var3 = var1.c();
      ByteBuffer var2 = ByteBuffer.allocate(var3.remaining() + 2);
      var2.put((byte)0);
      ((Buffer)var3).mark();
      var2.put(var3);
      ((Buffer)var3).reset();
      var2.put((byte)-1);
      ((Buffer)var2).flip();
      return var2;
   }

   @Override
   public void a() {
      this.f = false;
      this.h = null;
   }

   @Override
   public Draft.CloseHandshakeType b() {
      return Draft.CloseHandshakeType.NONE;
   }

   @Override
   public Draft c() {
      return new Draft_75();
   }

   @Override
   public List<Framedata> c(ByteBuffer var1) throws InvalidDataException {
      List var2 = this.e(var1);
      if (var2 == null) {
         throw new InvalidDataException(1002);
      } else {
         return var2;
      }
   }

   public ByteBuffer d() {
      return ByteBuffer.allocate(b);
   }

   protected List<Framedata> e(ByteBuffer var1) throws InvalidDataException {
      Object var4 = null;

      List var3;
      while (true) {
         if (!var1.hasRemaining()) {
            var3 = this.g;
            this.g = new LinkedList<>();
            break;
         }

         byte var2 = var1.get();
         if (var2 == 0) {
            if (this.f) {
               throw new InvalidFrameException("unexpected START_OF_FRAME");
            }

            this.f = true;
         } else if (var2 == -1) {
            if (!this.f) {
               throw new InvalidFrameException("unexpected END_OF_FRAME");
            }

            if (this.h != null) {
               ((Buffer)this.h).flip();
               FramedataImpl1 var5 = new FramedataImpl1();
               var5.a(this.h);
               var5.a(true);
               var5.a(Framedata.Opcode.TEXT);
               this.g.add(var5);
               this.h = null;
               ((Buffer)var1).mark();
            }

            this.f = false;
         } else {
            var3 = (List)var4;
            if (!this.f) {
               break;
            }

            if (this.h == null) {
               this.h = this.d();
            } else if (!this.h.hasRemaining()) {
               this.h = this.f(this.h);
            }

            this.h.put(var2);
         }
      }

      return var3;
   }

   public ByteBuffer f(ByteBuffer var1) throws LimitExedeedException, InvalidDataException {
      ((Buffer)var1).flip();
      ByteBuffer var2 = ByteBuffer.allocate(this.a(var1.capacity() * 2));
      var2.put(var1);
      return var2;
   }
}
