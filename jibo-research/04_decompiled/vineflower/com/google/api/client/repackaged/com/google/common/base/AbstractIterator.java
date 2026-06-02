package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.util.Iterator;
import java.util.NoSuchElementException;

@GwtCompatible
abstract class AbstractIterator<T> implements Iterator<T> {
   private T next;
   private AbstractIterator.State state = AbstractIterator.State.NOT_READY;

   protected AbstractIterator() {
   }

   private boolean tryToComputeNext() {
      this.state = AbstractIterator.State.FAILED;
      this.next = this.computeNext();
      boolean var1;
      if (this.state != AbstractIterator.State.DONE) {
         this.state = AbstractIterator.State.READY;
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   protected abstract T computeNext();

   protected final T endOfData() {
      this.state = AbstractIterator.State.DONE;
      return null;
   }

   @Override
   public final boolean hasNext() {
      boolean var2 = false;
      boolean var1;
      if (this.state != AbstractIterator.State.FAILED) {
         var1 = true;
      } else {
         var1 = false;
      }

      Preconditions.checkState(var1);
      var1 = var2;
      switch (<unrepresentable>.$SwitchMap$com$google$common$base$AbstractIterator$State[this.state.ordinal()]) {
         case 1:
            break;
         case 2:
            var1 = true;
            break;
         default:
            var1 = this.tryToComputeNext();
      }

      return var1;
   }

   @Override
   public final T next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      }

      this.state = AbstractIterator.State.NOT_READY;
      Object var1 = this.next;
      this.next = null;
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
