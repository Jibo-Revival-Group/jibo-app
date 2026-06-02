package com.amazonaws;

import com.amazonaws.internal.config.HttpClientConfig;
import com.amazonaws.internal.config.InternalConfig;

enum ServiceNameFactory {
   private static final ServiceNameFactory[] $VALUES = new ServiceNameFactory[0];

   static String getServiceName(String var0) {
      HttpClientConfig var1 = InternalConfig.Factory.getInternalConfig().getHttpClientConfig(var0);
      if (var1 == null) {
         var0 = null;
      } else {
         var0 = var1.getServiceName();
      }

      return var0;
   }
}
