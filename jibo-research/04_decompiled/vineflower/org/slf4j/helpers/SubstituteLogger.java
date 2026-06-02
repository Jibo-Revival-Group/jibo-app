package org.slf4j.helpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.event.EventRecodingLogger;
import org.slf4j.event.LoggingEvent;
import org.slf4j.event.SubstituteLoggingEvent;

public class SubstituteLogger implements Logger {
   private final String a;
   private volatile Logger b;
   private Boolean c;
   private Method d;
   private EventRecodingLogger e;
   private Queue<SubstituteLoggingEvent> f;
   private final boolean g;

   public SubstituteLogger(String var1, Queue<SubstituteLoggingEvent> var2, boolean var3) {
      this.a = var1;
      this.f = var2;
      this.g = var3;
   }

   private Logger f() {
      if (this.e == null) {
         this.e = new EventRecodingLogger(this, this.f);
      }

      return this.e;
   }

   public String a() {
      return this.a;
   }

   @Override
   public void a(String var1) {
      this.b().a(var1);
   }

   @Override
   public void a(String var1, Object var2) {
      this.b().a(var1, var2);
   }

   @Override
   public void a(String var1, Object var2, Object var3) {
      this.b().a(var1, var2, var3);
   }

   @Override
   public void a(String var1, Throwable var2) {
      this.b().a(var1, var2);
   }

   @Override
   public void a(String var1, Object... var2) {
      this.b().a(var1, var2);
   }

   public void a(Logger var1) {
      this.b = var1;
   }

   public void a(LoggingEvent var1) {
      if (this.c()) {
         try {
            this.d.invoke(this.b, var1);
         } catch (IllegalAccessException var2) {
         } catch (IllegalArgumentException var3) {
         } catch (InvocationTargetException var4) {
         }
      }
   }

   Logger b() {
      Logger var1;
      if (this.b != null) {
         var1 = this.b;
      } else if (this.g) {
         var1 = NOPLogger.a;
      } else {
         var1 = this.f();
      }

      return var1;
   }

   @Override
   public void b(String var1) {
      this.b().b(var1);
   }

   public boolean c() {
      boolean var1;
      if (this.c != null) {
         var1 = this.c;
      } else {
         try {
            this.d = this.b.getClass().getMethod("log", LoggingEvent.class);
            this.c = Boolean.TRUE;
         } catch (NoSuchMethodException var3) {
            this.c = Boolean.FALSE;
         }

         var1 = this.c;
      }

      return var1;
   }

   public boolean d() {
      boolean var1;
      if (this.b == null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean e() {
      return this.b instanceof NOPLogger;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 != null && this.getClass() == var1.getClass()) {
            var1 = var1;
            if (!this.a.equals(var1.a)) {
               var2 = false;
            }
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return this.a.hashCode();
   }
}
