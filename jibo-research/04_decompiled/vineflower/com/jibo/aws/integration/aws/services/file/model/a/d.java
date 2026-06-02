package com.jibo.aws.integration.aws.services.file.model.a;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.jibo.aws.integration.aws.services.file.model.UploadFileRequest;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

public class d {
   public Request<UploadFileRequest> a(UploadFileRequest var1) {
      if (var1 == null) {
         throw new AmazonClientException("Invalid argument passed to marshall(...)");
      }

      DefaultRequest var2 = new DefaultRequest(var1, "voicetraining");
      var2.setHttpMethod(HttpMethodName.POST);
      var2.setResourcePath("");
      var2.addHeader("Content-Type", "multipart/form-data;boundary=veWbX8w3UcqtKDWIlUqj2DvRQzayEePJqxnkRE");
      var2.addHeader("Accept", "application/json");
      var2.addHeader("X-Amz-Target", "$TARGET$." + var1.getClass().getSimpleName().replace("Request", ""));

      try {
         MultipartEntityBuilder var3 = MultipartEntityBuilder.create();
         var3.setBoundary("veWbX8w3UcqtKDWIlUqj2DvRQzayEePJqxnkRE");
         var3.addTextBody("key", var1.getKey());
         var3.addBinaryBody("body", var1.getBody());
         HttpEntity var5 = var3.build();
         var2.addHeader("Content-Length", Long.toString(var5.getContentLength()));
         var2.setContent(var5.getContent());
         return var2;
      } catch (Throwable var4) {
         throw new AmazonClientException("Unable to marshall request to JSON: " + var4.getMessage(), var4);
      }
   }
}
