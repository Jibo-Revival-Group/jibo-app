package com.mixpanel.android.java_websocket.exceptions;

public class InvalidFrameException extends InvalidDataException {
   public InvalidFrameException() {
      super(1002);
   }

   public InvalidFrameException(String var1) {
      super(1002, var1);
   }

   public InvalidFrameException(Throwable var1) {
      super(1002, var1);
   }
}
