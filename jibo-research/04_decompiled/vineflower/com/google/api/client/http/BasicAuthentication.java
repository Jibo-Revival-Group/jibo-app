package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import java.io.IOException;

public final class BasicAuthentication implements HttpExecuteInterceptor, HttpRequestInitializer {
   private final String password;
   private final String username;

   public BasicAuthentication(String var1, String var2) {
      this.username = Preconditions.checkNotNull(var1);
      this.password = Preconditions.checkNotNull(var2);
   }

   public String getPassword() {
      return this.password;
   }

   public String getUsername() {
      return this.username;
   }

   @Override
   public void initialize(HttpRequest var1) throws IOException {
      var1.setInterceptor(this);
   }

   @Override
   public void intercept(HttpRequest var1) throws IOException {
      var1.getHeaders().setBasicAuthentication(this.username, this.password);
   }
}
