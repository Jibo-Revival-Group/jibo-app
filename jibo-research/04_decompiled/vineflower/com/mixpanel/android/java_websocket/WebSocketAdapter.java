package com.mixpanel.android.java_websocket;

import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.framing.FramedataImpl1;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.HandshakeImpl1Server;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import java.net.InetSocketAddress;

public abstract class WebSocketAdapter implements WebSocketListener {
   @Override
   public ServerHandshakeBuilder a(WebSocket var1, Draft var2, ClientHandshake var3) throws InvalidDataException {
      return new HandshakeImpl1Server();
   }

   @Override
   public String a(WebSocket var1) throws InvalidDataException {
      InetSocketAddress var2 = var1.a();
      if (var2 == null) {
         throw new InvalidHandshakeException("socket not bound");
      }

      StringBuffer var3 = new StringBuffer(90);
      var3.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
      var3.append(var2.getPort());
      var3.append("\" /></cross-domain-policy>\u0000");
      return var3.toString();
   }

   @Override
   public void a(WebSocket var1, Framedata var2) {
   }

   @Override
   public void a(WebSocket var1, ClientHandshake var2) throws InvalidDataException {
   }

   @Override
   public void a(WebSocket var1, ClientHandshake var2, ServerHandshake var3) throws InvalidDataException {
   }

   @Override
   public void b(WebSocket var1, Framedata var2) {
      var2 = new FramedataImpl1(var2);
      var2.a(Framedata.Opcode.PONG);
      var1.a(var2);
   }

   @Override
   public void c(WebSocket var1, Framedata var2) {
   }
}
