package org.slf4j.event;

import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

public class EventRecodingLogger implements Logger {
   String a;
   SubstituteLogger b;
   Queue<SubstituteLoggingEvent> c;

   public EventRecodingLogger(SubstituteLogger var1, Queue<SubstituteLoggingEvent> var2) {
      this.b = var1;
      this.a = var1.a();
      this.c = var2;
   }

   private void a(Level var1, String var2, Object[] var3, Throwable var4) {
      this.a(var1, null, var2, var3, var4);
   }

   private void a(Level var1, Marker var2, String var3, Object[] var4, Throwable var5) {
      SubstituteLoggingEvent var6 = new SubstituteLoggingEvent();
      var6.a(System.currentTimeMillis());
      var6.a(var1);
      var6.a(this.b);
      var6.a(this.a);
      var6.a(var2);
      var6.b(var3);
      var6.a(var4);
      var6.a(var5);
      var6.c(Thread.currentThread().getName());
      this.c.add(var6);
   }

   @Override
   public void a(String var1) {
      this.a(Level.TRACE, var1, null, null);
   }

   @Override
   public void a(String var1, Object var2) {
      this.a(Level.INFO, var1, new Object[]{var2}, null);
   }

   @Override
   public void a(String var1, Object var2, Object var3) {
      this.a(Level.WARN, var1, new Object[]{var2, var3}, null);
   }

   @Override
   public void a(String var1, Throwable var2) {
      this.a(Level.INFO, var1, null, var2);
   }

   @Override
   public void a(String var1, Object... var2) {
      this.a(Level.ERROR, var1, var2, null);
   }

   @Override
   public void b(String var1) {
      this.a(Level.INFO, var1, null, null);
   }
}
