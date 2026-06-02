package org.apache.http.concurrent;

public interface FutureCallback<T> {
   void cancelled();

   void completed(T var1);

   void failed(Exception var1);
}
