package com.amazonaws;

public class AmazonServiceException extends AmazonClientException {
   private static final long serialVersionUID = 1L;
   private String errorCode;
   private String errorMessage;
   private AmazonServiceException.ErrorType errorType = AmazonServiceException.ErrorType.Unknown;
   private String requestId;
   private String serviceName;
   private int statusCode;

   public AmazonServiceException(String var1) {
      super(null);
      this.errorMessage = var1;
   }

   public AmazonServiceException(String var1, Exception var2) {
      super(null, var2);
      this.errorMessage = var1;
   }

   public String getErrorCode() {
      return this.errorCode;
   }

   public String getErrorMessage() {
      return this.errorMessage;
   }

   public AmazonServiceException.ErrorType getErrorType() {
      return this.errorType;
   }

   @Override
   public String getMessage() {
      return this.getErrorMessage()
         + " (Service: "
         + this.getServiceName()
         + "; Status Code: "
         + this.getStatusCode()
         + "; Error Code: "
         + this.getErrorCode()
         + "; Request ID: "
         + this.getRequestId()
         + ")";
   }

   public String getRequestId() {
      return this.requestId;
   }

   public String getServiceName() {
      return this.serviceName;
   }

   public int getStatusCode() {
      return this.statusCode;
   }

   public void setErrorCode(String var1) {
      this.errorCode = var1;
   }

   public void setErrorType(AmazonServiceException.ErrorType var1) {
      this.errorType = var1;
   }

   public void setRequestId(String var1) {
      this.requestId = var1;
   }

   public void setServiceName(String var1) {
      this.serviceName = var1;
   }

   public void setStatusCode(int var1) {
      this.statusCode = var1;
   }

   public enum ErrorType {
      Client,
      Service,
      Unknown;

      private static final AmazonServiceException.ErrorType[] $VALUES = new AmazonServiceException.ErrorType[]{
         AmazonServiceException.ErrorType.Client, AmazonServiceException.ErrorType.Service, AmazonServiceException.ErrorType.Unknown
      };
   }
}
