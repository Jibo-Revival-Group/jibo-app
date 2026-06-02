package com.amazonaws;

import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.AWSRequestMetrics;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;

public interface Request<T> {
   void addHeader(String var1, String var2);

   void addParameter(String var1, String var2);

   AWSRequestMetrics getAWSRequestMetrics();

   InputStream getContent();

   URI getEndpoint();

   Map<String, String> getHeaders();

   HttpMethodName getHttpMethod();

   AmazonWebServiceRequest getOriginalRequest();

   Map<String, String> getParameters();

   String getResourcePath();

   String getServiceName();

   int getTimeOffset();

   void setAWSRequestMetrics(AWSRequestMetrics var1);

   void setContent(InputStream var1);

   void setEndpoint(URI var1);

   void setHeaders(Map<String, String> var1);

   void setHttpMethod(HttpMethodName var1);

   void setParameters(Map<String, String> var1);

   void setResourcePath(String var1);

   void setServiceName(String var1);

   void setTimeOffset(int var1);
}
