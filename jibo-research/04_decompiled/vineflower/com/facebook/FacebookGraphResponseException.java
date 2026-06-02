package com.facebook;

public class FacebookGraphResponseException extends FacebookException {
   private final GraphResponse graphResponse;

   public FacebookGraphResponseException(GraphResponse var1, String var2) {
      super(var2);
      this.graphResponse = var1;
   }

   public final GraphResponse getGraphResponse() {
      return this.graphResponse;
   }

   @Override
   public final String toString() {
      FacebookRequestError var1;
      if (this.graphResponse != null) {
         var1 = this.graphResponse.getError();
      } else {
         var1 = null;
      }

      StringBuilder var2 = new StringBuilder().append("{FacebookGraphResponseException: ");
      String var3 = this.getMessage();
      if (var3 != null) {
         var2.append(var3);
         var2.append(" ");
      }

      if (var1 != null) {
         var2.append("httpResponseCode: ")
            .append(var1.getRequestStatusCode())
            .append(", facebookErrorCode: ")
            .append(var1.getErrorCode())
            .append(", facebookErrorType: ")
            .append(var1.getErrorType())
            .append(", message: ")
            .append(var1.getErrorMessage())
            .append("}");
      }

      return var2.toString();
   }
}
