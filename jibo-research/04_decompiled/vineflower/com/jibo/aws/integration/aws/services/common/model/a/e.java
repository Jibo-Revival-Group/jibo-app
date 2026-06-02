package com.jibo.aws.integration.aws.services.common.model.a;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.StringInputStream;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;

public class e {
   public Request<JiboRequestAbstract> a(JiboRequestAbstract var1) {
      if (var1 == null) {
         throw new AmazonClientException("Invalid argument passed to marshall(...)");
      }

      DefaultRequest var2 = new DefaultRequest(var1, var1.getServiceAbbr());
      var2.setHttpMethod(HttpMethodName.POST);
      var2.setResourcePath("");
      var2.addHeader("Content-Type", "application/json");
      var2.addHeader("Accept", "application/json");
      var2.addHeader("X-Amz-Target", var1.getServicePrefix() + var1.getServiceMethodName());

      try {
         String var3 = this.b(var1);
         byte[] var6 = var3.getBytes("UTF-8");
         StringInputStream var4 = new StringInputStream(var3);
         var2.setContent(var4);
         var2.addHeader("Content-Length", Integer.toString(var6.length));
         return var2;
      } catch (Throwable var5) {
         throw new AmazonClientException("Unable to marshall request to JSON: " + var5.getMessage(), var5);
      }
   }

   protected String b(JiboRequestAbstract var1) {
      return new Gson().b(var1).toString().replace("\\\\", "\\");
   }
}
