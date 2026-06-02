package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
public class HttpRequestExecutor {
   public static final int DEFAULT_WAIT_FOR_CONTINUE = 3000;
   private final int waitForContinue;

   public HttpRequestExecutor() {
      this(3000);
   }

   public HttpRequestExecutor(int var1) {
      this.waitForContinue = Args.positive(var1, "Wait for continue time");
   }

   private static void closeConnection(HttpClientConnection var0) {
      try {
         var0.close();
      } catch (IOException var1) {
      }
   }

   protected boolean canResponseHaveBody(HttpRequest var1, HttpResponse var2) {
      boolean var5 = false;
      boolean var4;
      if ("HEAD".equalsIgnoreCase(var1.getRequestLine().getMethod())) {
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

   protected HttpResponse doReceiveResponse(HttpRequest var1, HttpClientConnection var2, HttpContext var3) throws HttpException, IOException {
      Args.notNull(var1, "HTTP request");
      Args.notNull(var2, "Client connection");
      Args.notNull(var3, "HTTP context");
      HttpResponse var5 = null;

      for (int var4 = 0; var5 == null || var4 < 200; var4 = var5.getStatusLine().getStatusCode()) {
         var5 = var2.receiveResponseHeader();
         if (this.canResponseHaveBody(var1, var5)) {
            var2.receiveResponseEntity(var5);
         }
      }

      return var5;
   }

   protected HttpResponse doSendRequest(HttpRequest var1, HttpClientConnection var2, HttpContext var3) throws IOException, HttpException {
      Args.notNull(var1, "HTTP request");
      Args.notNull(var2, "Client connection");
      Args.notNull(var3, "HTTP context");
      var3.setAttribute("http.connection", var2);
      var3.setAttribute("http.request_sent", Boolean.FALSE);
      var2.sendRequestHeader(var1);
      HttpResponse var6;
      if (var1 instanceof HttpEntityEnclosingRequest) {
         int var4;
         HttpResponse var8;
         label30: {
            ProtocolVersion var5 = var1.getRequestLine().getProtocolVersion();
            if (((HttpEntityEnclosingRequest)var1).expectContinue() && !var5.lessEquals(HttpVersion.HTTP_1_0)) {
               var2.flush();
               if (var2.isResponseAvailable(this.waitForContinue)) {
                  var8 = var2.receiveResponseHeader();
                  if (this.canResponseHaveBody(var1, var8)) {
                     var2.receiveResponseEntity(var8);
                  }

                  var4 = var8.getStatusLine().getStatusCode();
                  if (var4 < 200) {
                     if (var4 != 100) {
                        throw new ProtocolException("Unexpected response: " + var8.getStatusLine());
                     }

                     var8 = null;
                     var4 = 1;
                  } else {
                     var4 = 0;
                  }
                  break label30;
               }
            }

            var8 = null;
            var4 = 1;
         }

         var6 = var8;
         if (var4) {
            var2.sendRequestEntity((HttpEntityEnclosingRequest)var1);
            var6 = var8;
         }
      } else {
         var6 = null;
      }

      var2.flush();
      var3.setAttribute("http.request_sent", Boolean.TRUE);
      return var6;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public HttpResponse execute(HttpRequest var1, HttpClientConnection var2, HttpContext var3) throws IOException, HttpException {
      Args.notNull(var1, "HTTP request");
      Args.notNull(var2, "Client connection");
      Args.notNull(var3, "HTTP context");

      HttpResponse var5;
      try {
         var5 = this.doSendRequest(var1, var2, var3);
      } catch (IOException var9) {
         closeConnection(var2);
         throw var9;
      } catch (HttpException var10) {
         closeConnection(var2);
         throw var10;
      } catch (RuntimeException var11) {
         closeConnection(var2);
         throw var11;
      }

      HttpResponse var4 = var5;
      if (var5 == null) {
         try {
            var4 = this.doReceiveResponse(var1, var2, var3);
         } catch (IOException var6) {
            closeConnection(var2);
            throw var6;
         } catch (HttpException var7) {
            closeConnection(var2);
            throw var7;
         } catch (RuntimeException var8) {
            closeConnection(var2);
            throw var8;
         }
      }

      return var4;
   }

   public void postProcess(HttpResponse var1, HttpProcessor var2, HttpContext var3) throws HttpException, IOException {
      Args.notNull(var1, "HTTP response");
      Args.notNull(var2, "HTTP processor");
      Args.notNull(var3, "HTTP context");
      var3.setAttribute("http.response", var1);
      var2.process(var1, var3);
   }

   public void preProcess(HttpRequest var1, HttpProcessor var2, HttpContext var3) throws HttpException, IOException {
      Args.notNull(var1, "HTTP request");
      Args.notNull(var2, "HTTP processor");
      Args.notNull(var3, "HTTP context");
      var3.setAttribute("http.request", var1);
      var2.process(var1, var3);
   }
}
