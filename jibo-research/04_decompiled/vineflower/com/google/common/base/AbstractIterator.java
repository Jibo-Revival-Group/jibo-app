package com.google.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class AbstractIterator<T> implements Iterator<T> {
   private AbstractIterator.State a = AbstractIterator.State.NOT_READY;
   private T b;

   protected AbstractIterator() {
   }

   private boolean c() {
      this.a = AbstractIterator.State.FAILED;
      this.b = this.a();
      boolean var1;
      if (this.a != AbstractIterator.State.DONE) {
         this.a = AbstractIterator.State.READY;
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   protected abstract T a();

   protected final T b() {
      this.a = AbstractIterator.State.DONE;
      return null;
   }

   @Override
   public final boolean hasNext() {
      boolean var2 = true;
      boolean var1;
      if (this.a != AbstractIterator.State.FAILED) {
         var1 = true;
      } else {
         var1 = false;
      }

      Preconditions.b(var1);
      var1 = var2;
      switch (<unrepresentable>.a[this.a.ordinal()]) {
         case 1:
            break;
         case 2:
            var1 = false;
            break;
         default:
            var1 = this.c();
      }

      return var1;
   }

   @Override
   public final T next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      }

      this.a = AbstractIterator.State.NOT_READY;
      Object var1 = this.b;
      this.b = null;
      return (T)var1;
   }

   @Override
   public final void remove() {
      throw new UnsupportedOperationException();
   }

   private enum State {
      DONE,
      FAILED,
      NOT_READY,
      READY;

      private static final AbstractIterator.State[] $VALUES = new AbstractIterator.State[]{
         AbstractIterator.State.READY, AbstractIterator.State.NOT_READY, AbstractIterator.State.DONE, AbstractIterator.State.FAILED
      };
   }
}
