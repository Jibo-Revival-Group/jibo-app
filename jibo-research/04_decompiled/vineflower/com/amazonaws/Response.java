package com.amazonaws;

import com.amazonaws.http.HttpResponse;

public final class Response<T> {
   private final HttpResponse httpResponse;
   private final T response;

   public Response(T var1, HttpResponse var2) {
      this.response = (T)var1;
      this.httpResponse = var2;
   }

   public T getAwsResponse() {
      return this.response;
   }
}
