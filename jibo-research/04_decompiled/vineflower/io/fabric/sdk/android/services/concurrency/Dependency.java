package io.fabric.sdk.android.services.concurrency;

import java.util.Collection;

public interface Dependency<T> {
   Collection<T> c();

   void c(T var1);

   boolean d();
}
