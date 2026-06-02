package com.bumptech.glide.request;

public class ThumbnailRequestCoordinator implements Request, RequestCoordinator {
   private Request a;
   private Request b;
   private RequestCoordinator c;

   public ThumbnailRequestCoordinator() {
      this(null);
   }

   public ThumbnailRequestCoordinator(RequestCoordinator var1) {
      this.c = var1;
   }

   private boolean j() {
      boolean var1;
      if (this.c != null && !this.c.a(this)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   private boolean k() {
      boolean var1;
      if (this.c != null && !this.c.b(this)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   private boolean l() {
      boolean var1;
      if (this.c != null && this.c.c()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public void a() {
      this.a.a();
      this.b.a();
   }

   public void a(Request var1, Request var2) {
      this.a = var1;
      this.b = var2;
   }

   @Override
   public boolean a(Request var1) {
      boolean var2;
      if (!this.j() || !var1.equals(this.a) && this.a.h()) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public void b() {
      if (!this.b.f()) {
         this.b.b();
      }

      if (!this.a.f()) {
         this.a.b();
      }
   }

   @Override
   public boolean b(Request var1) {
      boolean var2;
      if (this.k() && var1.equals(this.a) && !this.c()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public void c(Request var1) {
      if (!var1.equals(this.b)) {
         if (this.c != null) {
            this.c.c(this);
         }

         if (!this.b.g()) {
            this.b.d();
         }
      }
   }

   @Override
   public boolean c() {
      boolean var1;
      if (!this.l() && !this.h()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   @Override
   public void d() {
      this.b.d();
      this.a.d();
   }

   @Override
   public void e() {
      this.a.e();
      this.b.e();
   }

   @Override
   public boolean f() {
      return this.a.f();
   }

   @Override
   public boolean g() {
      boolean var1;
      if (!this.a.g() && !this.b.g()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   @Override
   public boolean h() {
      boolean var1;
      if (!this.a.h() && !this.b.h()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   @Override
   public boolean i() {
      return this.a.i();
   }
}
