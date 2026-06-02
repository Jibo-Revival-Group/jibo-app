package org.slf4j.event;

import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

public class SubstituteLoggingEvent implements LoggingEvent {
   Level a;
   Marker b;
   String c;
   SubstituteLogger d;
   String e;
   String f;
   Object[] g;
   long h;
   Throwable i;

   public SubstituteLogger a() {
      return this.d;
   }

   public void a(long var1) {
      this.h = var1;
   }

   public void a(String var1) {
      this.c = var1;
   }

   public void a(Throwable var1) {
      this.i = var1;
   }

   public void a(Marker var1) {
      this.b = var1;
   }

   public void a(Level var1) {
      this.a = var1;
   }

   public void a(SubstituteLogger var1) {
      this.d = var1;
   }

   public void a(Object[] var1) {
      this.g = var1;
   }

   public void b(String var1) {
      this.f = var1;
   }

   public void c(String var1) {
      this.e = var1;
   }
}
