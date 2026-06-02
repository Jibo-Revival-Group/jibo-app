package com.mixpanel.android.java_websocket.exceptions;

public class InvalidHandshakeException extends InvalidDataException {
   public InvalidHandshakeException() {
      super(1002);
   }

   public InvalidHandshakeException(String var1) {
      super(1002, var1);
   }
}
