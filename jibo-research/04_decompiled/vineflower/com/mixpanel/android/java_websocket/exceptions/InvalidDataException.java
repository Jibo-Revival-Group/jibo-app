package com.mixpanel.android.java_websocket.exceptions;

public class InvalidDataException extends Exception {
   private int a;

   public InvalidDataException(int var1) {
      this.a = var1;
   }

   public InvalidDataException(int var1, String var2) {
      super(var2);
      this.a = var1;
   }

   public InvalidDataException(int var1, Throwable var2) {
      super(var2);
      this.a = var1;
   }

   public int a() {
      return this.a;
   }
}
