package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.Set;

@GwtCompatible
final class Absent<T> extends Optional<T> {
   static final Absent<Object> INSTANCE = new Absent<>();
   private static final long serialVersionUID = 0L;

   private Absent() {
   }

   private Object readResolve() {
      return INSTANCE;
   }

   static <T> Optional<T> withType() {
      return (Optional<T>)INSTANCE;
   }

   @Override
   public Set<T> asSet() {
      return Collections.emptySet();
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (var1 == this) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public T get() {
      throw new IllegalStateException("Optional.get() cannot be called on an absent value");
   }

   @Override
   public int hashCode() {
      return 1502476572;
   }

   @Override
   public boolean isPresent() {
      return false;
   }

   @Override
   public Optional<T> or(Optional<? extends T> var1) {
      return Preconditions.checkNotNull(var1);
   }

   @Override
   public T or(Supplier<? extends T> var1) {
      return Preconditions.checkNotNull((T)var1.get(), "use Optional.orNull() instead of a Supplier that returns null");
   }

   @Override
   public T or(T var1) {
      return Preconditions.checkNotNull((T)var1, "use Optional.orNull() instead of Optional.or(null)");
   }

   @Override
   public T orNull() {
      return null;
   }

   @Override
   public String toString() {
      return "Optional.absent()";
   }

   @Override
   public <V> Optional<V> transform(Function<? super T, V> var1) {
      Preconditions.checkNotNull(var1);
      return Optional.absent();
   }
}
