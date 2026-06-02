package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;

@Beta
@GwtCompatible
public abstract class Converter<A, B> implements Function<A, B> {
   private final boolean handleNullAutomatically;
   private transient Converter<B, A> reverse;

   protected Converter() {
      this(true);
   }

   Converter(boolean var1) {
      this.handleNullAutomatically = var1;
   }

   public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> var0, Function<? super B, ? extends A> var1) {
      return new Converter.FunctionBasedConverter<>(var0, var1);
   }

   public static <T> Converter<T, T> identity() {
      return Converter.IdentityConverter.INSTANCE;
   }

   public <C> Converter<A, C> andThen(Converter<B, C> var1) {
      return new Converter.ConverterComposition<>(this, Preconditions.checkNotNull(var1));
   }

   @Deprecated
   @Override
   public final B apply(A var1) {
      return this.convert((A)var1);
   }

   public final B convert(A var1) {
      return this.correctedDoForward((A)var1);
   }

   public Iterable<B> convertAll(Iterable<? extends A> var1) {
      Preconditions.checkNotNull(var1, "fromIterable");
      return new Iterable<B>(this, var1) {
         final Converter this$0;
         final Iterable val$fromIterable;

         {
            this.this$0 = var1;
            this.val$fromIterable = var2;
         }

         @Override
         public Iterator<B> iterator() {
            return new Iterator<B>(this) {
               private final Iterator<? extends A> fromIterator;
               final <unrepresentable> this$1;

               {
                  this.this$1 = var1;
                  this.fromIterator = this.this$1.val$fromIterable.iterator();
               }

               @Override
               public boolean hasNext() {
                  return this.fromIterator.hasNext();
               }

               @Override
               public B next() {
                  return (B)this.this$1.this$0.convert((A)this.fromIterator.next());
               }

               @Override
               public void remove() {
                  this.fromIterator.remove();
               }
            };
         }
      };
   }

   A correctedDoBackward(B var1) {
      if (this.handleNullAutomatically) {
         if (var1 == null) {
            var1 = null;
         } else {
            var1 = Preconditions.checkNotNull(this.doBackward((B)var1));
         }
      } else {
         var1 = this.doBackward((B)var1);
      }

      return (A)var1;
   }

   B correctedDoForward(A var1) {
      if (this.handleNullAutomatically) {
         if (var1 == null) {
            var1 = null;
         } else {
            var1 = Preconditions.checkNotNull(this.doForward((A)var1));
         }
      } else {
         var1 = this.doForward((A)var1);
      }

      return (B)var1;
   }

   protected abstract A doBackward(B var1);

   protected abstract B doForward(A var1);

   @Override
   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public Converter<B, A> reverse() {
      Converter var2 = this.reverse;
      Converter var1 = var2;
      if (var2 == null) {
         var1 = new Converter.ReverseConverter<>(this);
         this.reverse = var1;
      }

      return var1;
   }

   private static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
      private static final long serialVersionUID = 0L;
      final Converter<A, B> first;
      final Converter<B, C> second;

      ConverterComposition(Converter<A, B> var1, Converter<B, C> var2) {
         this.first = var1;
         this.second = var2;
      }

      @Override
      A correctedDoBackward(C var1) {
         return this.first.correctedDoBackward(this.second.correctedDoBackward((C)var1));
      }

      @Override
      C correctedDoForward(A var1) {
         return this.second.correctedDoForward(this.first.correctedDoForward((A)var1));
      }

      @Override
      protected A doBackward(C var1) {
         throw new AssertionError();
      }

      @Override
      protected C doForward(A var1) {
         throw new AssertionError();
      }

      @Override
      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2 = var3;
         if (var1 instanceof Converter.ConverterComposition) {
            var1 = var1;
            var2 = var3;
            if (this.first.equals(var1.first)) {
               var2 = var3;
               if (this.second.equals(var1.second)) {
                  var2 = true;
               }
            }
         }

         return var2;
      }

      @Override
      public int hashCode() {
         return this.first.hashCode() * 31 + this.second.hashCode();
      }

      @Override
      public String toString() {
         return this.first + ".andThen(" + this.second + ")";
      }
   }

   private static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
      private final Function<? super B, ? extends A> backwardFunction;
      private final Function<? super A, ? extends B> forwardFunction;

      private FunctionBasedConverter(Function<? super A, ? extends B> var1, Function<? super B, ? extends A> var2) {
         this.forwardFunction = Preconditions.checkNotNull(var1);
         this.backwardFunction = Preconditions.checkNotNull(var2);
      }

      @Override
      protected A doBackward(B var1) {
         return (A)this.backwardFunction.apply((B)var1);
      }

      @Override
      protected B doForward(A var1) {
         return (B)this.forwardFunction.apply((A)var1);
      }

      @Override
      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2 = var3;
         if (var1 instanceof Converter.FunctionBasedConverter) {
            var1 = var1;
            var2 = var3;
            if (this.forwardFunction.equals(var1.forwardFunction)) {
               var2 = var3;
               if (this.backwardFunction.equals(var1.backwardFunction)) {
                  var2 = true;
               }
            }
         }

         return var2;
      }

      @Override
      public int hashCode() {
         return this.forwardFunction.hashCode() * 31 + this.backwardFunction.hashCode();
      }

      @Override
      public String toString() {
         return "Converter.from(" + this.forwardFunction + ", " + this.backwardFunction + ")";
      }
   }

   private static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
      static final Converter.IdentityConverter INSTANCE = new Converter.IdentityConverter();
      private static final long serialVersionUID = 0L;

      private Object readResolve() {
         return INSTANCE;
      }

      @Override
      public <S> Converter<T, S> andThen(Converter<T, S> var1) {
         return Preconditions.checkNotNull(var1, "otherConverter");
      }

      @Override
      protected T doBackward(T var1) {
         return (T)var1;
      }

      @Override
      protected T doForward(T var1) {
         return (T)var1;
      }

      public Converter.IdentityConverter<T> reverse() {
         return this;
      }

      @Override
      public String toString() {
         return "Converter.identity()";
      }
   }

   private static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
      private static final long serialVersionUID = 0L;
      final Converter<A, B> original;

      ReverseConverter(Converter<A, B> var1) {
         this.original = var1;
      }

      @Override
      B correctedDoBackward(A var1) {
         return this.original.correctedDoForward((A)var1);
      }

      @Override
      A correctedDoForward(B var1) {
         return this.original.correctedDoBackward((B)var1);
      }

      @Override
      protected B doBackward(A var1) {
         throw new AssertionError();
      }

      @Override
      protected A doForward(B var1) {
         throw new AssertionError();
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2;
         if (var1 instanceof Converter.ReverseConverter) {
            var1 = var1;
            var2 = this.original.equals(var1.original);
         } else {
            var2 = false;
         }

         return var2;
      }

      @Override
      public int hashCode() {
         return ~this.original.hashCode();
      }

      @Override
      public Converter<A, B> reverse() {
         return this.original;
      }

      @Override
      public String toString() {
         return this.original + ".reverse()";
      }
   }
}
