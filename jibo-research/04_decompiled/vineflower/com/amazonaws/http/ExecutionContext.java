package com.amazonaws.http;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.Signer;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSRequestMetricsFullSupport;
import java.net.URI;
import java.util.List;

public class ExecutionContext {
   private final AmazonWebServiceClient awsClient;
   private final AWSRequestMetrics awsRequestMetrics;
   private String contextUserAgent;
   private AWSCredentials credentials;
   private final List<RequestHandler2> requestHandler2s;

   public ExecutionContext() {
      this(null, false, null);
   }

   public ExecutionContext(List<RequestHandler2> var1, boolean var2, AmazonWebServiceClient var3) {
      this.requestHandler2s = var1;
      AWSRequestMetrics var4;
      if (var2) {
         var4 = new AWSRequestMetricsFullSupport();
      } else {
         var4 = new AWSRequestMetrics();
      }

      this.awsRequestMetrics = var4;
      this.awsClient = var3;
   }

   @Deprecated
   public AWSRequestMetrics getAwsRequestMetrics() {
      return this.awsRequestMetrics;
   }

   public String getContextUserAgent() {
      return this.contextUserAgent;
   }

   public AWSCredentials getCredentials() {
      return this.credentials;
   }

   public List<RequestHandler2> getRequestHandler2s() {
      return this.requestHandler2s;
   }

   public Signer getSignerByURI(URI var1) {
      Signer var2;
      if (this.awsClient == null) {
         var2 = null;
      } else {
         var2 = this.awsClient.getSignerByURI(var1);
      }

      return var2;
   }

   public void setCredentials(AWSCredentials var1) {
      this.credentials = var1;
   }
}
