package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.TimingInfo;

final class RequestHandler2Adaptor extends RequestHandler2 {
   private final RequestHandler old;

   RequestHandler2Adaptor(RequestHandler var1) {
      if (var1 == null) {
         throw new IllegalArgumentException();
      }

      this.old = var1;
   }

   @Override
   public void afterError(Request<?> var1, Response<?> var2, Exception var3) {
      this.old.afterError(var1, var3);
   }

   @Override
   public void afterResponse(Request<?> var1, Response<?> var2) {
      Object var4 = null;
      AWSRequestMetrics var3;
      if (var1 == null) {
         var3 = null;
      } else {
         var3 = var1.getAWSRequestMetrics();
      }

      Object var5;
      if (var2 == null) {
         var5 = null;
      } else {
         var5 = var2.getAwsResponse();
      }

      TimingInfo var6;
      if (var3 == null) {
         var6 = (TimingInfo)var4;
      } else {
         var6 = var3.getTimingInfo();
      }

      this.old.afterResponse(var1, var5, var6);
   }

   @Override
   public void beforeRequest(Request<?> var1) {
      this.old.beforeRequest(var1);
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (!(var1 instanceof RequestHandler2Adaptor)) {
         var2 = false;
      } else {
         var1 = var1;
         var2 = this.old.equals(var1.old);
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return this.old.hashCode();
   }
}
