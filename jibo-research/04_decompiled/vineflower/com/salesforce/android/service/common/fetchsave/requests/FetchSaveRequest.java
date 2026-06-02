package com.salesforce.android.service.common.fetchsave.requests;

public abstract class FetchSaveRequest {
   private final boolean a;
   private final boolean b;
   private final boolean c;

   protected FetchSaveRequest(FetchSaveRequest.FetchSaveRequestBuilder var1) {
      this.a = var1.d();
      this.b = var1.f_();
      this.c = var1.f();
   }

   public boolean l() {
      return this.a;
   }

   public boolean m() {
      return this.b;
   }

   public boolean n() {
      return this.c;
   }

   public abstract static class FetchSaveRequestBuilder<T extends FetchSaveRequest.FetchSaveRequestBuilder<T>> {
      private boolean a = true;
      private boolean b = false;
      private boolean c = true;

      protected abstract T c();

      public T c(boolean var1) {
         this.c = var1;
         return this.c();
      }

      public T d(boolean var1) {
         this.a = var1;
         return this.c();
      }

      public boolean d() {
         return this.c;
      }

      public T e(boolean var1) {
         this.b = var1;
         return this.c();
      }

      public boolean f() {
         return this.b;
      }

      public boolean f_() {
         return this.a;
      }
   }
}
