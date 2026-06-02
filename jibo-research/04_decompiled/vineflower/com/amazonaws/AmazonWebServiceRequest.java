package com.amazonaws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.metrics.RequestMetricCollector;

public abstract class AmazonWebServiceRequest {
   private transient AWSCredentials credentials;
   private final transient RequestClientOptions requestClientOptions = new RequestClientOptions();
   @Deprecated
   private transient RequestMetricCollector requestMetricCollector;

   public RequestClientOptions getRequestClientOptions() {
      return this.requestClientOptions;
   }

   public AWSCredentials getRequestCredentials() {
      return this.credentials;
   }

   @Deprecated
   public RequestMetricCollector getRequestMetricCollector() {
      return this.requestMetricCollector;
   }

   public void setRequestCredentials(AWSCredentials var1) {
      this.credentials = var1;
   }

   @Deprecated
   public void setRequestMetricCollector(RequestMetricCollector var1) {
      this.requestMetricCollector = var1;
   }

   @Deprecated
   public <T extends AmazonWebServiceRequest> T withRequestMetricCollector(RequestMetricCollector var1) {
      this.setRequestMetricCollector(var1);
      return (T)this;
   }
}
