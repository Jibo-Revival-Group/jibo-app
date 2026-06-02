package com.google.android.gms.internal;

abstract class zzcjl extends zzcjk {
   private boolean a;

   zzcjl(zzcim var1) {
      super(var1);
      this.p.a(this);
   }

   final boolean P() {
      boolean var1;
      if (this.a) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   protected final void Q() {
      if (!this.P()) {
         throw new IllegalStateException("Not initialized");
      }
   }

   public final void R() {
      if (this.a) {
         throw new IllegalStateException("Can't initialize twice");
      }

      if (!this.w()) {
         this.p.F();
         this.a = true;
      }
   }

   public final void S() {
      if (this.a) {
         throw new IllegalStateException("Can't initialize twice");
      }

      this.d_();
      this.p.F();
      this.a = true;
   }

   protected void d_() {
   }

   protected abstract boolean w();
}
