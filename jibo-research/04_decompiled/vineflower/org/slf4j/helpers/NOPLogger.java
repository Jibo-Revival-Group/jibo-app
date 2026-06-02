package org.slf4j.helpers;

public class NOPLogger extends MarkerIgnoringBase {
   public static final NOPLogger a = new NOPLogger();

   protected NOPLogger() {
   }

   @Override
   public String a() {
      return "NOP";
   }

   @Override
   public final void a(String var1) {
   }

   @Override
   public final void a(String var1, Object var2) {
   }

   @Override
   public final void a(String var1, Object var2, Object var3) {
   }

   @Override
   public final void a(String var1, Throwable var2) {
   }

   @Override
   public final void a(String var1, Object... var2) {
   }

   @Override
   public final void b(String var1) {
   }
}
