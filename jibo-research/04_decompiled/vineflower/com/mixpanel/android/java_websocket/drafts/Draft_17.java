package com.mixpanel.android.java_websocket.drafts;

import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;

public class Draft_17 extends Draft_10 {
   @Override
   public Draft.HandshakeState a(ClientHandshake var1) throws InvalidHandshakeException {
      Draft.HandshakeState var2;
      if (b(var1) == 13) {
         var2 = Draft.HandshakeState.MATCHED;
      } else {
         var2 = Draft.HandshakeState.NOT_MATCHED;
      }

      return var2;
   }

   @Override
   public ClientHandshakeBuilder a(ClientHandshakeBuilder var1) {
      super.a(var1);
      var1.a("Sec-WebSocket-Version", "13");
      return var1;
   }

   @Override
   public Draft c() {
      return new Draft_17();
   }
}
