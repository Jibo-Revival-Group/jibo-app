package com.salesforce.android.service.common.utilities.functional;

import java.lang.ref.WeakReference;

public class OptionalReference<T> extends WeakReference<T> {
   public OptionalReference(T var1) {
      super((T)var1);
   }

   public void a(Consumer<? super T> var1) {
      Object var2 = this.get();
      if (var2 != null) {
         var1.a(var2);
      }
   }

   public boolean a(T var1) {
      boolean var2;
      if (var1 == this.get()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public void b(T var1) {
      if (this.a((T)var1)) {
         this.clear();
      }
   }

   public boolean b() {
      boolean var1;
      if (this.get() != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public T get() {
      return super.get();
   }
}
