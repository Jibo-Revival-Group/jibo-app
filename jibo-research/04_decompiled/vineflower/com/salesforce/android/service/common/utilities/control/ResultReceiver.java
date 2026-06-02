package com.salesforce.android.service.common.utilities.control;

public interface ResultReceiver<T> {
   ResultReceiver<T> b();

   ResultReceiver<T> b(T var1);

   ResultReceiver<T> b(Throwable var1);
}
