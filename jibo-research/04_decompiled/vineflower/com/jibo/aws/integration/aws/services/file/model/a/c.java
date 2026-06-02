package com.jibo.aws.integration.aws.services.file.model.a;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.jibo.aws.integration.aws.services.file.model.KeyRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

public class c {
   public Request<KeyRequest> a(KeyRequest var1) {
      if (var1 == null) {
         throw new AmazonClientException("Invalid argument passed to marshall(...)");
      }

      DefaultRequest var2 = new DefaultRequest(var1, "voicetraining");
      var2.setHttpMethod(HttpMethodName.POST);
      var2.setResourcePath("");
      var2.addHeader("Content-Type", "multipart/form-data;boundary=veWbX8w3UcqtKDWIlUqj2DvRQzayEePJqxnkRE");
      var2.addHeader("Accept", "application/json");
      var2.addHeader("X-Amz-Target", var1.getServicePrefix() + var1.getClass().getSimpleName().replace("Request", ""));

      try {
         MultipartEntityBuilder var3 = MultipartEntityBuilder.create();
         var3.setBoundary("veWbX8w3UcqtKDWIlUqj2DvRQzayEePJqxnkRE");
         var3.addTextBody("key", var1.getKey());
         HttpEntity var5 = var3.build();
         var2.addHeader("Content-Length", Long.toString(var5.getContentLength()));
         ByteArrayOutputStream var7 = new ByteArrayOutputStream((int)var5.getContentLength());
         var5.writeTo(var7);
         byte[] var8 = var7.toByteArray();
         ByteArrayInputStream var6 = new ByteArrayInputStream(var8);
         var2.setContent(var6);
         return var2;
      } catch (Throwable var4) {
         throw new AmazonClientException("Unable to marshall request to JSON: " + var4.getMessage(), var4);
      }
   }
}
