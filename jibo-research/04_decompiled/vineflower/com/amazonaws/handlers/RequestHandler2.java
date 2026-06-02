package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.Response;

public abstract class RequestHandler2 {
   public static RequestHandler2 adapt(RequestHandler var0) {
      return new RequestHandler2Adaptor(var0);
   }

   public abstract void afterError(Request<?> var1, Response<?> var2, Exception var3);

   public abstract void afterResponse(Request<?> var1, Response<?> var2);

   public abstract void beforeRequest(Request<?> var1);
}
