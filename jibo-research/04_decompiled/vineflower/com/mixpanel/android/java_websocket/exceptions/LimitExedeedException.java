package com.mixpanel.android.java_websocket.exceptions;

public class LimitExedeedException extends InvalidDataException {
   public LimitExedeedException() {
      super(1009);
   }

   public LimitExedeedException(String var1) {
      super(1009, var1);
   }
}
