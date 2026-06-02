package com.google.api.client.testing.http;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

@Beta
public class MockHttpTransport extends HttpTransport {
   private MockLowLevelHttpRequest lowLevelHttpRequest;
   private MockLowLevelHttpResponse lowLevelHttpResponse;
   private Set<String> supportedMethods;

   public MockHttpTransport() {
   }

   protected MockHttpTransport(MockHttpTransport.Builder var1) {
      this.supportedMethods = var1.supportedMethods;
      this.lowLevelHttpRequest = var1.lowLevelHttpRequest;
      this.lowLevelHttpResponse = var1.lowLevelHttpResponse;
   }

   @Deprecated
   public static MockHttpTransport.Builder builder() {
      return new MockHttpTransport.Builder();
   }

   @Override
   public LowLevelHttpRequest buildRequest(String var1, String var2) throws IOException {
      Preconditions.checkArgument(this.supportsMethod(var1), "HTTP method %s not supported", var1);
      MockLowLevelHttpRequest var3;
      if (this.lowLevelHttpRequest != null) {
         var3 = this.lowLevelHttpRequest;
      } else {
         MockLowLevelHttpRequest var4 = new MockLowLevelHttpRequest(var2);
         var3 = var4;
         if (this.lowLevelHttpResponse != null) {
            var4.setResponse(this.lowLevelHttpResponse);
            var3 = var4;
         }
      }

      return var3;
   }

   public final MockLowLevelHttpRequest getLowLevelHttpRequest() {
      return this.lowLevelHttpRequest;
   }

   public final Set<String> getSupportedMethods() {
      Set var1;
      if (this.supportedMethods == null) {
         var1 = null;
      } else {
         var1 = Collections.unmodifiableSet(this.supportedMethods);
      }

      return var1;
   }

   @Override
   public boolean supportsMethod(String var1) throws IOException {
      boolean var2;
      if (this.supportedMethods != null && !this.supportedMethods.contains(var1)) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Beta
   public static class Builder {
      MockLowLevelHttpRequest lowLevelHttpRequest;
      MockLowLevelHttpResponse lowLevelHttpResponse;
      Set<String> supportedMethods;

      public MockHttpTransport build() {
         return new MockHttpTransport(this);
      }

      public final MockLowLevelHttpRequest getLowLevelHttpRequest() {
         return this.lowLevelHttpRequest;
      }

      MockLowLevelHttpResponse getLowLevelHttpResponse() {
         return this.lowLevelHttpResponse;
      }

      public final Set<String> getSupportedMethods() {
         return this.supportedMethods;
      }

      public final MockHttpTransport.Builder setLowLevelHttpRequest(MockLowLevelHttpRequest var1) {
         boolean var2;
         if (this.lowLevelHttpResponse == null) {
            var2 = true;
         } else {
            var2 = false;
         }

         Preconditions.checkState(var2, "Cannnot set a low level HTTP request when a low level HTTP response has been set.");
         this.lowLevelHttpRequest = var1;
         return this;
      }

      public final MockHttpTransport.Builder setLowLevelHttpResponse(MockLowLevelHttpResponse var1) {
         boolean var2;
         if (this.lowLevelHttpRequest == null) {
            var2 = true;
         } else {
            var2 = false;
         }

         Preconditions.checkState(var2, "Cannot set a low level HTTP response when a low level HTTP request has been set.");
         this.lowLevelHttpResponse = var1;
         return this;
      }

      public final MockHttpTransport.Builder setSupportedMethods(Set<String> var1) {
         this.supportedMethods = var1;
         return this;
      }
   }
}
