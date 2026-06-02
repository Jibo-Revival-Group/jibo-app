package com.amazonaws.http;

public interface HttpResponseHandler<T> {
   T handle(HttpResponse var1);

   boolean needsConnectionLeftOpen();
}
