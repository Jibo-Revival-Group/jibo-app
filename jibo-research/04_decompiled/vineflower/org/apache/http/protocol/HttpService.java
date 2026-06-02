package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.HttpServerConnection;
import org.apache.http.HttpVersion;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.ProtocolException;
import org.apache.http.UnsupportedHttpVersionException;
import org.apache.http.annotation.Immutable;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;

@Immutable
public class HttpService {
   private volatile ConnectionReuseStrategy connStrategy;
   private volatile HttpExpectationVerifier expectationVerifier;
   private volatile HttpRequestHandlerMapper handlerMapper;
   private volatile HttpParams params = null;
   private volatile HttpProcessor processor = null;
   private volatile HttpResponseFactory responseFactory;

   @Deprecated
   public HttpService(HttpProcessor var1, ConnectionReuseStrategy var2, HttpResponseFactory var3) {
      this.handlerMapper = null;
      this.connStrategy = null;
      this.responseFactory = null;
      this.expectationVerifier = null;
      this.setHttpProcessor(var1);
      this.setConnReuseStrategy(var2);
      this.setResponseFactory(var3);
   }

   public HttpService(HttpProcessor var1, ConnectionReuseStrategy var2, HttpResponseFactory var3, HttpRequestHandlerMapper var4) {
      this(var1, var2, var3, var4, null);
   }

   public HttpService(HttpProcessor var1, ConnectionReuseStrategy var2, HttpResponseFactory var3, HttpRequestHandlerMapper var4, HttpExpectationVerifier var5) {
      this.handlerMapper = null;
      this.connStrategy = null;
      this.responseFactory = null;
      this.expectationVerifier = null;
      this.processor = Args.notNull(var1, "HTTP processor");
      if (var2 == null) {
         var2 = DefaultConnectionReuseStrategy.INSTANCE;
      }

      this.connStrategy = var2;
      if (var3 == null) {
         var3 = DefaultHttpResponseFactory.INSTANCE;
      }

      this.responseFactory = var3;
      this.handlerMapper = var4;
      this.expectationVerifier = var5;
   }

   @Deprecated
   public HttpService(HttpProcessor var1, ConnectionReuseStrategy var2, HttpResponseFactory var3, HttpRequestHandlerResolver var4, HttpParams var5) {
      this(var1, var2, var3, new HttpService.HttpRequestHandlerResolverAdapter(var4), null);
      this.params = var5;
   }

   @Deprecated
   public HttpService(
      HttpProcessor var1,
      ConnectionReuseStrategy var2,
      HttpResponseFactory var3,
      HttpRequestHandlerResolver var4,
      HttpExpectationVerifier var5,
      HttpParams var6
   ) {
      this(var1, var2, var3, new HttpService.HttpRequestHandlerResolverAdapter(var4), var5);
      this.params = var6;
   }

   public HttpService(HttpProcessor var1, HttpRequestHandlerMapper var2) {
      this(var1, null, null, var2, null);
   }

   private boolean canResponseHaveBody(HttpRequest var1, HttpResponse var2) {
      boolean var5 = false;
      boolean var4;
      if (var1 != null && "HEAD".equalsIgnoreCase(var1.getRequestLine().getMethod())) {
         var4 = var5;
      } else {
         int var3 = var2.getStatusLine().getStatusCode();
         var4 = var5;
         if (var3 >= 200) {
            var4 = var5;
            if (var3 != 204) {
               var4 = var5;
               if (var3 != 304) {
                  var4 = var5;
                  if (var3 != 205) {
                     var4 = true;
                  }
               }
            }
         }
      }

      return var4;
   }

   protected void doService(HttpRequest var1, HttpResponse var2, HttpContext var3) throws HttpException, IOException {
      HttpRequestHandler var4 = null;
      if (this.handlerMapper != null) {
         var4 = this.handlerMapper.lookup(var1);
      }

      if (var4 != null) {
         var4.handle(var1, var2, var3);
      } else {
         var2.setStatusCode(501);
      }
   }

   @Deprecated
   public HttpParams getParams() {
      return this.params;
   }

   protected void handleException(HttpException var1, HttpResponse var2) {
      if (var1 instanceof MethodNotSupportedException) {
         var2.setStatusCode(501);
      } else if (var1 instanceof UnsupportedHttpVersionException) {
         var2.setStatusCode(505);
      } else if (var1 instanceof ProtocolException) {
         var2.setStatusCode(400);
      } else {
         var2.setStatusCode(500);
      }

      String var4 = var1.getMessage();
      String var3 = var4;
      if (var4 == null) {
         var3 = var1.toString();
      }

      ByteArrayEntity var5 = new ByteArrayEntity(EncodingUtils.getAsciiBytes(var3));
      var5.setContentType("text/plain; charset=US-ASCII");
      var2.setEntity(var5);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public void handleRequest(HttpServerConnection var1, HttpContext var2) throws IOException, HttpException {
      HttpResponse var5 = null;
      var2.setAttribute("http.connection", var1);

      HttpRequest var3;
      label100: {
         HttpException var4;
         label104: {
            try {
               var3 = var1.receiveRequestHeader();
            } catch (HttpException var16) {
               var4 = var16;
               var3 = null;
               break label104;
            }

            HttpResponse var17 = var5;

            label105: {
               label112: {
                  HttpResponse var6;
                  HttpExpectationVerifier var7;
                  try {
                     if (!(var3 instanceof HttpEntityEnclosingRequest)) {
                        break label105;
                     }

                     if (!((HttpEntityEnclosingRequest)var3).expectContinue()) {
                        break label112;
                     }

                     var6 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 100, var2);
                     var7 = this.expectationVerifier;
                  } catch (HttpException var15) {
                     var4 = var15;
                     break label104;
                  }

                  var17 = var6;
                  label83:
                  if (var7 != null) {
                     try {
                        this.expectationVerifier.verify(var3, var6, var2);
                     } catch (HttpException var14) {
                        HttpException var19 = var14;

                        try {
                           var17 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, var2);
                           this.handleException(var19, var17);
                           break label83;
                        } catch (HttpException var12) {
                           var4 = var12;
                           break label104;
                        }
                     }

                     var17 = var6;
                  }

                  label77:
                  try {
                     if (var17.getStatusLine().getStatusCode() < 200) {
                        var1.sendResponseHeader(var17);
                        var1.flush();
                        var1.receiveRequestEntity((HttpEntityEnclosingRequest)var3);
                        break label77;
                     }
                     break label105;
                  } catch (HttpException var13) {
                     var4 = var13;
                     break label104;
                  }

                  var17 = var5;
                  break label105;
               }

               try {
                  var1.receiveRequestEntity((HttpEntityEnclosingRequest)var3);
               } catch (HttpException var11) {
                  var4 = var11;
                  break label104;
               }

               var17 = var5;
            }

            try {
               var2.setAttribute("http.request", var3);
            } catch (HttpException var10) {
               var4 = var10;
               break label104;
            }

            var5 = var17;
            if (var17 == null) {
               try {
                  var5 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 200, var2);
                  this.processor.process(var3, var2);
                  this.doService(var3, var5, var2);
               } catch (HttpException var9) {
                  var4 = var9;
                  break label104;
               }
            }

            try {
               if (var3 instanceof HttpEntityEnclosingRequest) {
                  EntityUtils.consume(((HttpEntityEnclosingRequest)var3).getEntity());
               }
               break label100;
            } catch (HttpException var8) {
               var4 = var8;
            }
         }

         var5 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, var2);
         this.handleException(var4, var5);
      }

      var2.setAttribute("http.response", var5);
      this.processor.process(var5, var2);
      var1.sendResponseHeader(var5);
      if (this.canResponseHaveBody(var3, var5)) {
         var1.sendResponseEntity(var5);
      }

      var1.flush();
      if (!this.connStrategy.keepAlive(var5, var2)) {
         var1.close();
      }
   }

   @Deprecated
   public void setConnReuseStrategy(ConnectionReuseStrategy var1) {
      Args.notNull(var1, "Connection reuse strategy");
      this.connStrategy = var1;
   }

   @Deprecated
   public void setExpectationVerifier(HttpExpectationVerifier var1) {
      this.expectationVerifier = var1;
   }

   @Deprecated
   public void setHandlerResolver(HttpRequestHandlerResolver var1) {
      this.handlerMapper = new HttpService.HttpRequestHandlerResolverAdapter(var1);
   }

   @Deprecated
   public void setHttpProcessor(HttpProcessor var1) {
      Args.notNull(var1, "HTTP processor");
      this.processor = var1;
   }

   @Deprecated
   public void setParams(HttpParams var1) {
      this.params = var1;
   }

   @Deprecated
   public void setResponseFactory(HttpResponseFactory var1) {
      Args.notNull(var1, "Response factory");
      this.responseFactory = var1;
   }

   @Deprecated
   private static class HttpRequestHandlerResolverAdapter implements HttpRequestHandlerMapper {
      private final HttpRequestHandlerResolver resolver;

      public HttpRequestHandlerResolverAdapter(HttpRequestHandlerResolver var1) {
         this.resolver = var1;
      }

      @Override
      public HttpRequestHandler lookup(HttpRequest var1) {
         return this.resolver.lookup(var1.getRequestLine().getUri());
      }
   }
}
