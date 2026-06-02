package com.amazonaws;

import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.AWSRequestMetrics;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultRequest<T> implements Request<T> {
   private InputStream content;
   private URI endpoint;
   private Map<String, String> headers;
   private HttpMethodName httpMethod;
   private AWSRequestMetrics metrics;
   private final AmazonWebServiceRequest originalRequest;
   private Map<String, String> parameters = new LinkedHashMap<>();
   private String resourcePath;
   private String serviceName;
   private int timeOffset;

   public DefaultRequest(AmazonWebServiceRequest var1, String var2) {
      this.headers = new HashMap<>();
      this.httpMethod = HttpMethodName.POST;
      this.serviceName = var2;
      this.originalRequest = var1;
   }

   @Override
   public void addHeader(String var1, String var2) {
      this.headers.put(var1, var2);
   }

   @Override
   public void addParameter(String var1, String var2) {
      this.parameters.put(var1, var2);
   }

   @Deprecated
   @Override
   public AWSRequestMetrics getAWSRequestMetrics() {
      return this.metrics;
   }

   @Override
   public InputStream getContent() {
      return this.content;
   }

   @Override
   public URI getEndpoint() {
      return this.endpoint;
   }

   @Override
   public Map<String, String> getHeaders() {
      return this.headers;
   }

   @Override
   public HttpMethodName getHttpMethod() {
      return this.httpMethod;
   }

   @Override
   public AmazonWebServiceRequest getOriginalRequest() {
      return this.originalRequest;
   }

   @Override
   public Map<String, String> getParameters() {
      return this.parameters;
   }

   @Override
   public String getResourcePath() {
      return this.resourcePath;
   }

   @Override
   public String getServiceName() {
      return this.serviceName;
   }

   @Override
   public int getTimeOffset() {
      return this.timeOffset;
   }

   @Deprecated
   @Override
   public void setAWSRequestMetrics(AWSRequestMetrics var1) {
      if (this.metrics == null) {
         this.metrics = var1;
      } else {
         throw new IllegalStateException("AWSRequestMetrics has already been set on this request");
      }
   }

   @Override
   public void setContent(InputStream var1) {
      this.content = var1;
   }

   @Override
   public void setEndpoint(URI var1) {
      this.endpoint = var1;
   }

   @Override
   public void setHeaders(Map<String, String> var1) {
      this.headers.clear();
      this.headers.putAll(var1);
   }

   @Override
   public void setHttpMethod(HttpMethodName var1) {
      this.httpMethod = var1;
   }

   @Override
   public void setParameters(Map<String, String> var1) {
      this.parameters.clear();
      this.parameters.putAll(var1);
   }

   @Override
   public void setResourcePath(String var1) {
      this.resourcePath = var1;
   }

   @Override
   public void setServiceName(String var1) {
      this.serviceName = var1;
   }

   @Override
   public void setTimeOffset(int var1) {
      this.timeOffset = var1;
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.getHttpMethod()).append(" ");
      var1.append(this.getEndpoint()).append(" ");
      String var2 = this.getResourcePath();
      if (var2 == null) {
         var1.append("/");
      } else {
         if (!var2.startsWith("/")) {
            var1.append("/");
         }

         var1.append(var2);
      }

      var1.append(" ");
      if (!this.getParameters().isEmpty()) {
         var1.append("Parameters: (");

         for (String var5 : this.getParameters().keySet()) {
            String var4 = this.getParameters().get(var5);
            var1.append(var5).append(": ").append(var4).append(", ");
         }

         var1.append(") ");
      }

      if (!this.getHeaders().isEmpty()) {
         var1.append("Headers: (");

         for (String var6 : this.getHeaders().keySet()) {
            String var8 = this.getHeaders().get(var6);
            var1.append(var6).append(": ").append(var8).append(", ");
         }

         var1.append(") ");
      }

      return var1.toString();
   }
}
