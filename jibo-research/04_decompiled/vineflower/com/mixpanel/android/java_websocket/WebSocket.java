package com.mixpanel.android.java_websocket;

import com.mixpanel.android.java_websocket.framing.Framedata;
import java.net.InetSocketAddress;

public interface WebSocket {
   InetSocketAddress a();

   void a(Framedata var1);

   enum READYSTATE {
      CLOSED,
      CLOSING,
      CONNECTING,
      NOT_YET_CONNECTED,
      OPEN;

      private static final WebSocket.READYSTATE[] $VALUES = new WebSocket.READYSTATE[]{
         WebSocket.READYSTATE.NOT_YET_CONNECTED,
         WebSocket.READYSTATE.CONNECTING,
         WebSocket.READYSTATE.OPEN,
         WebSocket.READYSTATE.CLOSING,
         WebSocket.READYSTATE.CLOSED
      };
   }

   enum Role {
      CLIENT,
      SERVER;

      private static final WebSocket.Role[] $VALUES = new WebSocket.Role[]{WebSocket.Role.CLIENT, WebSocket.Role.SERVER};
   }
}
