package com.google.api.client.http.apache;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

final class ApacheHttpRequest extends LowLevelHttpRequest {
   private final HttpClient httpClient;
   private final HttpRequestBase request;

   ApacheHttpRequest(HttpClient var1, HttpRequestBase var2) {
      this.httpClient = var1;
      this.request = var2;
   }

   @Override
   public void addHeader(String var1, String var2) {
      this.request.addHeader(var1, var2);
   }

   @Override
   public LowLevelHttpResponse execute() throws IOException {
      if (this.getStreamingContent() != null) {
         Preconditions.checkArgument(
            this.request instanceof HttpEntityEnclosingRequest,
            "Apache HTTP client does not support %s requests with content.",
            this.request.getRequestLine().getMethod()
         );
         ContentEntity var1 = new ContentEntity(this.getContentLength(), this.getStreamingContent());
         var1.setContentEncoding(this.getContentEncoding());
         var1.setContentType(this.getContentType());
         ((HttpEntityEnclosingRequest)this.request).setEntity(var1);
      }

      return new ApacheHttpResponse(this.request, this.httpClient.execute(this.request));
   }

   @Override
   public void setTimeout(int var1, int var2) throws IOException {
      HttpParams var3 = this.request.getParams();
      ConnManagerParams.setTimeout(var3, var1);
      HttpConnectionParams.setConnectionTimeout(var3, var1);
      HttpConnectionParams.setSoTimeout(var3, var2);
   }
}
