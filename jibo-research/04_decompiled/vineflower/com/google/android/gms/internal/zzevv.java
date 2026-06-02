package com.google.android.gms.internal;

import android.util.Log;

public final class zzevv extends zzevx {
   private zzevz a;
   private boolean b = false;
   private long c = -1L;
   private boolean d = false;
   private String e;
   private Integer f;
   private Long g;
   private Long h;
   private Integer i;
   private Integer j;
   private String k;
   private Long l;
   private Long m;
   private Long n;
   private Long o;
   private zzeww[] p;

   private zzevv(zzevz var1) {
      this(var1, zzevw.a());
   }

   private zzevv(zzevz var1, zzevw var2) {
      super(var2);
      this.a = var1;
      this.e();
   }

   public static zzevv a(zzevz var0) {
      return new zzevv(var0);
   }

   public final zzevv a(int var1) {
      this.j = var1;
      return this;
   }

   public final zzevv a(long var1) {
      this.g = var1;
      return this;
   }

   public final zzevv a(String var1) {
      if (var1 != null) {
         this.e = zzewq.a(zzewq.a(var1), 2000);
      }

      return this;
   }

   public final Integer a() {
      return this.j;
   }

   public final zzevv b() {
      this.i = 1;
      return this;
   }

   public final zzevv b(long var1) {
      this.h = var1;
      return this;
   }

   public final zzevv b(String var1) {
      if (var1 != null) {
         switch (var1.toUpperCase()) {
            case "GET":
               this.f = 1;
               break;
            case "PUT":
               this.f = 2;
               break;
            case "POST":
               this.f = 3;
               break;
            case "DELETE":
               this.f = 4;
               break;
            case "HEAD":
               this.f = 5;
               break;
            case "PATCH":
               this.f = 6;
               break;
            case "OPTIONS":
               this.f = 7;
               break;
            case "TRACE":
               this.f = 8;
               break;
            case "CONNECT":
               this.f = 9;
               break;
            default:
               this.f = 0;
         }
      }

      return this;
   }

   public final long c() {
      return this.c;
   }

   public final zzevv c(long var1) {
      this.l = var1;
      return this;
   }

   public final zzevv c(String var1) {
      if (var1 != null) {
         this.k = var1;
      }

      return this;
   }

   public final zzevv d(long var1) {
      this.m = var1;
      return this;
   }

   public final zzewv d() {
      this.f();
      zzewv var1 = new zzewv();
      var1.a = this.e;
      var1.b = this.f;
      var1.c = this.g;
      var1.d = this.h;
      var1.e = this.i;
      var1.f = this.j;
      var1.g = this.k;
      var1.h = this.l;
      var1.i = this.m;
      var1.j = this.n;
      var1.k = this.o;
      var1.l = this.p;
      if (!this.b) {
         if (this.a != null) {
            this.a.a(var1, this.g());
         }

         this.b = true;
      } else if (this.d) {
         Log.i("FirebasePerformance", "This metric has already been queued for transmission.  Please create a new HttpMetric for each request/response");
      }

      return var1;
   }

   public final zzevv e(long var1) {
      this.c = var1;
      this.n = var1;
      return this;
   }

   public final zzevv f(long var1) {
      this.o = var1;
      return this;
   }
}
