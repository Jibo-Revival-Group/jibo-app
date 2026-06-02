package com.jibo.aws.integration.aws.services.binary.model.a;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;
import com.jibo.aws.integration.aws.services.common.model.a.e;
import java.io.FileInputStream;

public class c extends e {
   @Override
   public Request<JiboRequestAbstract> a(JiboRequestAbstract var1) {
      if (var1 == null) {
         throw new AmazonClientException("Invalid argument passed to marshall(...)");
      }

      CreateBinaryRequest var2 = (CreateBinaryRequest)var1;
      DefaultRequest var3 = new DefaultRequest(var1, var1.getServiceAbbr());
      var3.setHttpMethod(HttpMethodName.POST);
      var3.setResourcePath("");
      var3.addHeader("Content-Type", com.jibo.aws.integration.aws.services.binary.a.a.a().a(var2.getBody()));
      var3.addHeader("Content-Encoding", "aws-chunked");
      var3.addHeader("Proxy-Connection", "keep-alive");
      var3.addHeader("Connection", "keep-alive");
      var3.addHeader("Pragma", "no-cache");
      var3.addHeader("Cache-Control", "no-cache");
      var3.addHeader("Transfer-Encoding", "Chunked");
      var3.addHeader("Accept", "application/json");
      var3.addHeader("x-amz-content-sha256", "required");
      this.a(var3, var2);
      var3.addHeader("X-Amz-Target", var1.getServicePrefix() + var1.getServiceMethodName());
      if (var2.getMeta() != null && !var2.getMeta().isEmpty()) {
         for (String var4 : var2.getMeta().keySet()) {
            var3.addHeader("x-meta" + var4, var2.getMeta().get(var4));
         }
      }

      try {
         var3.addHeader("Content-Length", Long.toString(var2.getBody().length()));
         var3.addHeader("x-amz-decoded-content-length", Long.toString(var2.getBody().length()));
         FileInputStream var7 = new FileInputStream(var2.getBody());
         var3.setContent(var7);
         return var3;
      } catch (Throwable var5) {
         throw new AmazonClientException("Unable to marshall request to JSON: " + var5.getMessage(), var5);
      }
   }

   protected void a(Request<JiboRequestAbstract> var1, CreateBinaryRequest var2) {
      var1.addHeader("x-path", var2.getPath());
   }
}
