package com.segment.analytics;

import com.segment.analytics.integrations.BasePayload;

public interface Middleware {
   void intercept(Middleware.Chain var1);

   interface Chain {
      BasePayload payload();

      void proceed(BasePayload var1);
   }
}
