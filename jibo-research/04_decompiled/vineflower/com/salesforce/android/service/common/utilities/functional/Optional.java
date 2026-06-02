package com.salesforce.android.service.common.utilities.functional;

public class Optional<T> {
   private static final Optional a = a((T)null);
   private final T b;

   private Optional(T var1) {
      this.b = (T)var1;
   }

   public static <T> Optional<T> a() {
      return a;
   }

   public static <T> Optional<T> a(T var0) {
      return new Optional<>((T)var0);
   }

   public void a(Consumer<? super T> var1) {
      if (this.b != null) {
         var1.a(this.b);
      }
   }
}
