package com.mixpanel.android.java_websocket.handshake;

public class HandshakeImpl1Client extends HandshakedataImpl1 implements ClientHandshakeBuilder {
   private String a = "*";

   @Override
   public String a() {
      return this.a;
   }

   @Override
   public void a(String var1) throws IllegalArgumentException {
      if (var1 == null) {
         throw new IllegalArgumentException("http resource descriptor must not be null");
      }

      this.a = var1;
   }
}
