package com.segment.analytics;

import com.segment.analytics.integrations.BasePayload;
import java.util.List;

class RealMiddlewareChain implements Middleware.Chain {
   private final Analytics analytics;
   private int index;
   private final List<Middleware> middlewares;
   private final BasePayload payload;

   RealMiddlewareChain(int var1, BasePayload var2, List<Middleware> var3, Analytics var4) {
      this.index = var1;
      this.payload = var2;
      this.middlewares = var3;
      this.analytics = var4;
   }

   @Override
   public BasePayload payload() {
      return this.payload;
   }

   @Override
   public void proceed(BasePayload var1) {
      if (this.index < this.middlewares.size()) {
         RealMiddlewareChain var2 = new RealMiddlewareChain(this.index + 1, var1, this.middlewares, this.analytics);
         this.middlewares.get(this.index).intercept(var2);
      } else {
         this.analytics.run(var1);
      }
   }
}
