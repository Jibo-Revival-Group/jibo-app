package io.fabric.sdk.android.services.common;

public abstract class Crash {
   private final String a;
   private final String b;

   public Crash(String var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   public String a() {
      return this.a;
   }

   public String b() {
      return this.b;
   }

   public static class FatalException extends Crash {
      public FatalException(String var1, String var2) {
         super(var1, var2);
      }
   }

   public static class LoggedException extends Crash {
      public LoggedException(String var1, String var2) {
         super(var1, var2);
      }
   }
}
