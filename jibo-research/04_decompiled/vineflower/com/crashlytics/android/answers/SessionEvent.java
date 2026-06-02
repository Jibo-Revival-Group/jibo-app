package com.crashlytics.android.answers;

import android.app.Activity;
import java.util.Collections;
import java.util.Map;

final class SessionEvent {
   public final SessionEventMetadata a;
   public final long b;
   public final SessionEvent.Type c;
   public final Map<String, String> d;
   public final String e;
   public final Map<String, Object> f;
   public final String g;
   public final Map<String, Object> h;
   private String i;

   private SessionEvent(
      SessionEventMetadata var1,
      long var2,
      SessionEvent.Type var4,
      Map<String, String> var5,
      String var6,
      Map<String, Object> var7,
      String var8,
      Map<String, Object> var9
   ) {
      this.a = var1;
      this.b = var2;
      this.c = var4;
      this.d = var5;
      this.e = var6;
      this.f = var7;
      this.g = var8;
      this.h = var9;
   }

   public static SessionEvent.Builder a(long var0) {
      return new SessionEvent.Builder(SessionEvent.Type.INSTALL).a(Collections.singletonMap("installedAt", String.valueOf(var0)));
   }

   public static SessionEvent.Builder a(SessionEvent.Type var0, Activity var1) {
      Map var2 = Collections.singletonMap("activity", var1.getClass().getName());
      return new SessionEvent.Builder(var0).a(var2);
   }

   public static SessionEvent.Builder a(String var0) {
      Map var1 = Collections.singletonMap("sessionId", var0);
      return new SessionEvent.Builder(SessionEvent.Type.CRASH).a(var1);
   }

   public static SessionEvent.Builder a(String var0, String var1) {
      return a(var0).b(Collections.singletonMap("exceptionName", var1));
   }

   @Override
   public String toString() {
      if (this.i == null) {
         this.i = "["
            + this.getClass().getSimpleName()
            + ": "
            + "timestamp="
            + this.b
            + ", type="
            + this.c
            + ", details="
            + this.d
            + ", customType="
            + this.e
            + ", customAttributes="
            + this.f
            + ", predefinedType="
            + this.g
            + ", predefinedAttributes="
            + this.h
            + ", metadata=["
            + this.a
            + "]]";
      }

      return this.i;
   }

   static class Builder {
      final SessionEvent.Type a;
      final long b;
      Map<String, String> c;
      String d;
      Map<String, Object> e;
      String f;
      Map<String, Object> g;

      public Builder(SessionEvent.Type var1) {
         this.a = var1;
         this.b = System.currentTimeMillis();
         this.c = null;
         this.d = null;
         this.e = null;
         this.f = null;
         this.g = null;
      }

      public SessionEvent.Builder a(Map<String, String> var1) {
         this.c = var1;
         return this;
      }

      public SessionEvent a(SessionEventMetadata var1) {
         return new SessionEvent(var1, this.b, this.a, this.c, this.d, this.e, this.f, this.g);
      }

      public SessionEvent.Builder b(Map<String, Object> var1) {
         this.e = var1;
         return this;
      }
   }

   enum Type {
      CRASH,
      CUSTOM,
      INSTALL,
      PAUSE,
      PREDEFINED,
      RESUME,
      START,
      STOP;

      private static final SessionEvent.Type[] $VALUES = new SessionEvent.Type[]{
         SessionEvent.Type.START,
         SessionEvent.Type.RESUME,
         SessionEvent.Type.PAUSE,
         SessionEvent.Type.STOP,
         SessionEvent.Type.CRASH,
         SessionEvent.Type.INSTALL,
         SessionEvent.Type.CUSTOM,
         SessionEvent.Type.PREDEFINED
      };
   }
}
