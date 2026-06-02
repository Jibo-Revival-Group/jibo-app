package com.facebook;

public class FacebookDialogException extends FacebookException {
   static final long serialVersionUID = 1L;
   private int errorCode;
   private String failingUrl;

   public FacebookDialogException(String var1, int var2, String var3) {
      super(var1);
      this.errorCode = var2;
      this.failingUrl = var3;
   }

   public int getErrorCode() {
      return this.errorCode;
   }

   public String getFailingUrl() {
      return this.failingUrl;
   }

   @Override
   public final String toString() {
      return "{FacebookDialogException: " + "errorCode: " + this.getErrorCode() + ", message: " + this.getMessage() + ", url: " + this.getFailingUrl() + "}";
   }
}
