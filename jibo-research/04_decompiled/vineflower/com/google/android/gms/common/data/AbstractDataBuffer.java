package com.google.android.gms.common.data;

import java.util.Iterator;

public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {
   protected final DataHolder a;

   protected AbstractDataBuffer(DataHolder var1) {
      this.a = var1;
   }

   @Override
   public int b() {
      int var1;
      if (this.a == null) {
         var1 = 0;
      } else {
         var1 = this.a.a;
      }

      return var1;
   }

   @Override
   public void c_() {
      if (this.a != null) {
         this.a.close();
      }
   }

   @Override
   public Iterator<T> iterator() {
      return new zzb<>(this);
   }
}
