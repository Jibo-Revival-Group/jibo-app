package com.google.android.gms.common;

import java.util.Arrays;

final class zzi extends zzh {
   private final byte[] a;

   zzi(byte[] var1) {
      super(Arrays.copyOfRange(var1, 0, 25));
      this.a = var1;
   }

   @Override
   final byte[] c() {
      return this.a;
   }
}
