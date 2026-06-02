package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzbq;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class zzb<T> implements Iterator<T> {
   protected final DataBuffer<T> a;
   protected int b;

   public zzb(DataBuffer<T> var1) {
      this.a = zzbq.a(var1);
      this.b = -1;
   }

   @Override
   public boolean hasNext() {
      boolean var1;
      if (this.b < this.a.b() - 1) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public T next() {
      if (!this.hasNext()) {
         int var3 = this.b;
         throw new NoSuchElementException(new StringBuilder(46).append("Cannot advance the iterator beyond ").append(var3).toString());
      } else {
         DataBuffer var2 = this.a;
         int var1 = this.b + 1;
         this.b = var1;
         return (T)var2.a(var1);
      }
   }

   @Override
   public void remove() {
      throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
   }
}
