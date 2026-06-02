package com.google.api.client.googleapis.auth.clientlogin;

import com.google.api.client.http.HttpResponseException;
import com.google.api.client.util.Beta;

@Beta
public class ClientLoginResponseException extends HttpResponseException {
   private static final long serialVersionUID = 4974317674023010928L;
   private final transient ClientLogin.ErrorInfo details;

   ClientLoginResponseException(HttpResponseException.Builder var1, ClientLogin.ErrorInfo var2) {
      super(var1);
      this.details = var2;
   }

   public final ClientLogin.ErrorInfo getDetails() {
      return this.details;
   }
}
