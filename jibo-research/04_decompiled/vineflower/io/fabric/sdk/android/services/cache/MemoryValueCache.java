package io.fabric.sdk.android.services.cache;

import android.content.Context;

public class MemoryValueCache<T> extends AbstractValueCache<T> {
   private T a;

   public MemoryValueCache() {
      this(null);
   }

   public MemoryValueCache(ValueCache<T> var1) {
      super(var1);
   }

   @Override
   protected T a(Context var1) {
      return this.a;
   }

   @Override
   protected void a(Context var1, T var2) {
      this.a = (T)var2;
   }
}
