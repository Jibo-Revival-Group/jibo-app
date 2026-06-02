package com.google.android.gms.internal;

import java.util.Iterator;

final class zzcgy implements Iterator<String> {
   private Iterator<String> a;
   private zzcgx b;

   zzcgy(zzcgx var1) {
      this.b = var1;
      super();
      this.a = zzcgx.a(this.b).keySet().iterator();
   }

   @Override
   public final boolean hasNext() {
      return this.a.hasNext();
   }

   @Override
   public final void remove() {
      throw new UnsupportedOperationException("Remove not supported");
   }
}
