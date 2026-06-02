package com.amazonaws;

public enum Protocol {
   HTTP("http"),
   HTTPS("https");

   private static final Protocol[] $VALUES = new Protocol[]{Protocol.HTTP, Protocol.HTTPS};
   private final String protocol;

   Protocol(String var3) {
      this.protocol = var3;
   }

   @Override
   public String toString() {
      return this.protocol;
   }
}
