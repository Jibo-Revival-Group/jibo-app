package com.google.api.client.googleapis.services.json;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.CommonGoogleClientRequestInitializer;
import java.io.IOException;

public class CommonGoogleJsonClientRequestInitializer extends CommonGoogleClientRequestInitializer {
   public CommonGoogleJsonClientRequestInitializer() {
   }

   public CommonGoogleJsonClientRequestInitializer(String var1) {
      super(var1);
   }

   public CommonGoogleJsonClientRequestInitializer(String var1, String var2) {
      super(var1, var2);
   }

   @Override
   public final void initialize(AbstractGoogleClientRequest<?> var1) throws IOException {
      super.initialize(var1);
      this.initializeJsonRequest((AbstractGoogleJsonClientRequest<?>)var1);
   }

   protected void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> var1) throws IOException {
   }
}
