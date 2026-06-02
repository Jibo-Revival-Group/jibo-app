package com.mixpanel.android.java_websocket.exceptions;

public class IncompleteHandshakeException extends RuntimeException {
   private int a;

   public IncompleteHandshakeException() {
      this.a = 0;
   }

   public IncompleteHandshakeException(int var1) {
      this.a = var1;
   }

   public int a() {
      return this.a;
   }
}
