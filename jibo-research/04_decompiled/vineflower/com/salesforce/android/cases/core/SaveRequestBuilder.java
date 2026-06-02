package com.salesforce.android.cases.core;

public abstract class SaveRequestBuilder<T extends SaveRequestBuilder<T>> {
   private boolean a;
   private boolean b;

   public T a(boolean var1) {
      this.a = var1;
      return this.c();
   }

   public boolean a() {
      return this.a;
   }

   public T b(boolean var1) {
      this.b = var1;
      return this.c();
   }

   public boolean b() {
      return this.b;
   }

   protected abstract T c();
}
