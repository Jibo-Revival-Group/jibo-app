package org.apache.http.protocol;

import org.apache.http.HttpConnection;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
public class HttpCoreContext implements HttpContext {
   public static final String HTTP_CONNECTION = "http.connection";
   public static final String HTTP_REQUEST = "http.request";
   public static final String HTTP_REQ_SENT = "http.request_sent";
   public static final String HTTP_RESPONSE = "http.response";
   public static final String HTTP_TARGET_HOST = "http.target_host";
   private final HttpContext context;

   public HttpCoreContext() {
      this.context = new BasicHttpContext();
   }

   public HttpCoreContext(HttpContext var1) {
      this.context = var1;
   }

   public static HttpCoreContext adapt(HttpContext var0) {
      Args.notNull(var0, "HTTP context");
      if (var0 instanceof HttpCoreContext) {
         var0 = var0;
      } else {
         var0 = new HttpCoreContext(var0);
      }

      return var0;
   }

   public static HttpCoreContext create() {
      return new HttpCoreContext(new BasicHttpContext());
   }

   @Override
   public Object getAttribute(String var1) {
      return this.context.getAttribute(var1);
   }

   public <T> T getAttribute(String var1, Class<T> var2) {
      Args.notNull(var2, "Attribute class");
      Object var3 = this.getAttribute(var1);
      if (var3 == null) {
         var3 = null;
      } else {
         var3 = var2.cast(var3);
      }

      return (T)var3;
   }

   public HttpConnection getConnection() {
      return this.getAttribute("http.connection", HttpConnection.class);
   }

   public <T extends HttpConnection> T getConnection(Class<T> var1) {
      return this.getAttribute("http.connection", var1);
   }

   public HttpRequest getRequest() {
      return this.getAttribute("http.request", HttpRequest.class);
   }

   public HttpResponse getResponse() {
      return this.getAttribute("http.response", HttpResponse.class);
   }

   public HttpHost getTargetHost() {
      return this.getAttribute("http.target_host", HttpHost.class);
   }

   public boolean isRequestSent() {
      Boolean var2 = this.getAttribute("http.request_sent", Boolean.class);
      boolean var1;
      if (var2 != null && var2) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public Object removeAttribute(String var1) {
      return this.context.removeAttribute(var1);
   }

   @Override
   public void setAttribute(String var1, Object var2) {
      this.context.setAttribute(var1, var2);
   }

   public void setTargetHost(HttpHost var1) {
      this.setAttribute("http.target_host", var1);
   }
}
