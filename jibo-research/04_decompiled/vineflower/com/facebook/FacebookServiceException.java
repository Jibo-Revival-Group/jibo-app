package com.facebook;

public class FacebookServiceException extends FacebookException {
   private static final long serialVersionUID = 1L;
   private final FacebookRequestError error;

   public FacebookServiceException(FacebookRequestError var1, String var2) {
      super(var2);
      this.error = var1;
   }

   public final FacebookRequestError getRequestError() {
      return this.error;
   }

   @Override
   public final String toString() {
      return "{FacebookServiceException: "
         + "httpResponseCode: "
         + this.error.getRequestStatusCode()
         + ", facebookErrorCode: "
         + this.error.getErrorCode()
         + ", facebookErrorType: "
         + this.error.getErrorType()
         + ", message: "
         + this.error.getErrorMessage()
         + "}";
   }
}
