package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.Set;

@GwtCompatible
final class Present<T> extends Optional<T> {
   private static final long serialVersionUID = 0L;
   private final T reference;

   Present(T var1) {
      this.reference = (T)var1;
   }

   @Override
   public Set<T> asSet() {
      return Collections.singleton(this.reference);
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (var1 instanceof Present) {
         var1 = var1;
         var2 = this.reference.equals(var1.reference);
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public T get() {
      return this.reference;
   }

   @Override
   public int hashCode() {
      return 1502476572 + this.reference.hashCode();
   }

   @Override
   public boolean isPresent() {
      return true;
   }

   @Override
   public Optional<T> or(Optional<? extends T> var1) {
      Preconditions.checkNotNull(var1);
      return this;
   }

   @Override
   public T or(Supplier<? extends T> var1) {
      Preconditions.checkNotNull(var1);
      return this.reference;
   }

   @Override
   public T or(T var1) {
      Preconditions.checkNotNull(var1, "use Optional.orNull() instead of Optional.or(null)");
      return this.reference;
   }

   @Override
   public T orNull() {
      return this.reference;
   }

   @Override
   public String toString() {
      return "Optional.of(" + this.reference + ")";
   }

   @Override
   public <V> Optional<V> transform(Function<? super T, V> var1) {
      return (Optional<V>)(new Present<>(
         Preconditions.checkNotNull(var1.apply(this.reference), "the Function passed to Optional.transform() must not return null.")
      ));
   }
}
