package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

@GwtCompatible(serializable = true)
public abstract class Optional<T> implements Serializable {
   private static final long serialVersionUID = 0L;

   Optional() {
   }

   public static <T> Optional<T> absent() {
      return Absent.withType();
   }

   public static <T> Optional<T> fromNullable(T var0) {
      if (var0 == null) {
         var0 = absent();
      } else {
         var0 = new Present<>(var0);
      }

      return var0;
   }

   public static <T> Optional<T> of(T var0) {
      return new Present<>(Preconditions.checkNotNull((T)var0));
   }

   @Beta
   public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> var0) {
      Preconditions.checkNotNull(var0);
      return new Iterable<T>(var0) {
         final Iterable val$optionals;

         {
            this.val$optionals = var1;
         }

         @Override
         public Iterator<T> iterator() {
            return new AbstractIterator<T>(this) {
               private final Iterator<? extends Optional<? extends T>> iterator;
               final <unrepresentable> this$0;

               {
                  this.this$0 = var1;
                  this.iterator = Preconditions.checkNotNull(this.this$0.val$optionals.iterator());
               }

               @Override
               protected T computeNext() {
                  while (true) {
                     Object var2;
                     if (this.iterator.hasNext()) {
                        var2 = this.iterator.next();
                        if (!var2.isPresent()) {
                           continue;
                        }

                        var2 = (Optional)var2.get();
                     } else {
                        var2 = (Optional)this.endOfData();
                     }

                     return (T)var2;
                  }
               }
            };
         }
      };
   }

   public abstract Set<T> asSet();

   @Override
   public abstract boolean equals(Object var1);

   public abstract T get();

   @Override
   public abstract int hashCode();

   public abstract boolean isPresent();

   public abstract Optional<T> or(Optional<? extends T> var1);

   @Beta
   public abstract T or(Supplier<? extends T> var1);

   public abstract T or(T var1);

   public abstract T orNull();

   @Override
   public abstract String toString();

   public abstract <V> Optional<V> transform(Function<? super T, V> var1);
}
