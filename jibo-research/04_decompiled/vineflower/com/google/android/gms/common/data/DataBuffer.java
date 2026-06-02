package com.google.android.gms.common.data;

import com.google.android.gms.common.api.Releasable;

public interface DataBuffer<T> extends Releasable, Iterable<T> {
   T a(int var1);

   int b();
}
