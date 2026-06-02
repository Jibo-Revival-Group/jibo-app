package com.amazonaws.http;

import com.amazonaws.ClientConfiguration;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map.Entry;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class UrlHttpClient implements HttpClient {
   private final ClientConfiguration config;
   private SSLContext sc = null;

   public UrlHttpClient(ClientConfiguration var1) {
      this.config = var1;
   }

   private void disableCertificateValidation(HttpsURLConnection var1) {
      if (this.sc == null) {
         UrlHttpClient.TrustAllManager var2 = new UrlHttpClient.TrustAllManager();

         try {
            this.sc = SSLContext.getInstance("TLS");
            this.sc.init(null, new TrustManager[]{var2}, null);
         } catch (GeneralSecurityException var3) {
            throw new RuntimeException(var3);
         }
      }

      var1.setSSLSocketFactory(this.sc.getSocketFactory());
      var1.setHostnameVerifier(new UrlHttpClient.AllowAllHostnameVerifier());
   }

   private void write(InputStream var1, OutputStream var2) {
      byte[] var4 = new byte[8192];

      while (true) {
         int var3 = var1.read(var4);
         if (var3 == -1) {
            return;
         }

         var2.write(var4, 0, var3);
      }
   }

   HttpURLConnection applyHeadersAndMethod(HttpRequest var1, HttpURLConnection var2) {
      if (var1.getHeaders() != null && !var1.getHeaders().isEmpty()) {
         for (Entry var5 : var1.getHeaders().entrySet()) {
            String var4 = (String)var5.getKey();
            if (!var4.equals("Content-Length") && !var4.equals("Host")) {
               if (var4.equals("Expect")) {
               }

               var2.setRequestProperty(var4, (String)var5.getValue());
            }
         }
      }

      var2.setRequestMethod(var1.getMethod());
      return var2;
   }

   void configureConnection(HttpURLConnection var1) {
      var1.setConnectTimeout(this.config.getConnectionTimeout());
      var1.setReadTimeout(this.config.getSocketTimeout());
      var1.setInstanceFollowRedirects(false);
      var1.setUseCaches(false);
      if (var1 instanceof HttpsURLConnection) {
         var1 = var1;
         if (System.getProperty("com.amazonaws.sdk.disableCertChecking") != null) {
            this.disableCertificateValidation(var1);
         }
      }
   }

   HttpResponse createHttpResponse(HttpRequest var1, HttpURLConnection var2) {
      String var6 = var2.getResponseMessage();
      int var3 = var2.getResponseCode();
      InputStream var5 = var2.getErrorStream();
      InputStream var4 = var5;
      if (var5 == null) {
         var4 = var5;
         if (!var1.getMethod().equals("HEAD")) {
            try {
               var4 = var2.getInputStream();
            } catch (IOException var7) {
               var4 = var5;
            }
         }
      }

      HttpResponse.Builder var8 = HttpResponse.builder().statusCode(var3).statusText(var6).content(var4);

      for (Entry var9 : var2.getHeaderFields().entrySet()) {
         if (var9.getKey() != null) {
            var8.header((String)var9.getKey(), (String)((List)var9.getValue()).get(0));
         }
      }

      return var8.build();
   }

   @Override
   public HttpResponse execute(HttpRequest var1) {
      HttpURLConnection var2 = (HttpURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(var1.getUri().toURL().openConnection()));
      this.configureConnection(var2);
      this.applyHeadersAndMethod(var1, var2);
      this.writeContentToConnection(var1, var2);
      return this.createHttpResponse(var1, var2);
   }

   @Override
   public void shutdown() {
   }

   void writeContentToConnection(HttpRequest param1, HttpURLConnection param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 5
      // 03: aconst_null
      // 04: astore 6
      // 06: aload 6
      // 08: astore 4
      // 0a: aload 5
      // 0c: astore 3
      // 0d: aload 1
      // 0e: invokevirtual com/amazonaws/http/HttpRequest.getContent ()Ljava/io/InputStream;
      // 11: ifnull 4e
      // 14: aload 6
      // 16: astore 4
      // 18: aload 5
      // 1a: astore 3
      // 1b: aload 1
      // 1c: invokevirtual com/amazonaws/http/HttpRequest.getContentLength ()J
      // 1f: lconst_0
      // 20: lcmp
      // 21: iflt 4e
      // 24: aload 5
      // 26: astore 3
      // 27: aload 2
      // 28: bipush 1
      // 29: invokevirtual java/net/HttpURLConnection.setDoOutput (Z)V
      // 2c: aload 5
      // 2e: astore 3
      // 2f: aload 2
      // 30: aload 1
      // 31: invokevirtual com/amazonaws/http/HttpRequest.getContentLength ()J
      // 34: l2i
      // 35: invokevirtual java/net/HttpURLConnection.setFixedLengthStreamingMode (I)V
      // 38: aload 5
      // 3a: astore 3
      // 3b: aload 2
      // 3c: invokevirtual java/net/HttpURLConnection.getOutputStream ()Ljava/io/OutputStream;
      // 3f: astore 4
      // 41: aload 4
      // 43: astore 3
      // 44: aload 0
      // 45: aload 1
      // 46: invokevirtual com/amazonaws/http/HttpRequest.getContent ()Ljava/io/InputStream;
      // 49: aload 4
      // 4b: invokespecial com/amazonaws/http/UrlHttpClient.write (Ljava/io/InputStream;Ljava/io/OutputStream;)V
      // 4e: aload 1
      // 4f: invokevirtual com/amazonaws/http/HttpRequest.getContent ()Ljava/io/InputStream;
      // 52: ifnull 5c
      // 55: aload 1
      // 56: invokevirtual com/amazonaws/http/HttpRequest.getContent ()Ljava/io/InputStream;
      // 59: invokevirtual java/io/InputStream.close ()V
      // 5c: aload 4
      // 5e: ifnull 6b
      // 61: aload 4
      // 63: invokevirtual java/io/OutputStream.flush ()V
      // 66: aload 4
      // 68: invokevirtual java/io/OutputStream.close ()V
      // 6b: return
      // 6c: astore 2
      // 6d: aload 1
      // 6e: invokevirtual com/amazonaws/http/HttpRequest.getContent ()Ljava/io/InputStream;
      // 71: ifnull 7b
      // 74: aload 1
      // 75: invokevirtual com/amazonaws/http/HttpRequest.getContent ()Ljava/io/InputStream;
      // 78: invokevirtual java/io/InputStream.close ()V
      // 7b: aload 3
      // 7c: ifnull 87
      // 7f: aload 3
      // 80: invokevirtual java/io/OutputStream.flush ()V
      // 83: aload 3
      // 84: invokevirtual java/io/OutputStream.close ()V
      // 87: aload 2
      // 88: athrow
      // 89: astore 1
      // 8a: goto 87
      // 8d: astore 1
      // 8e: goto 6b
      // try (8 -> 11): 57 null
      // try (15 -> 20): 57 null
      // try (22 -> 25): 57 null
      // try (27 -> 32): 57 null
      // try (34 -> 37): 57 null
      // try (39 -> 44): 57 null
      // try (44 -> 50): 74 java/io/IOException
      // try (52 -> 56): 74 java/io/IOException
      // try (58 -> 64): 72 java/io/IOException
      // try (66 -> 70): 72 java/io/IOException
   }

   static class AllowAllHostnameVerifier implements HostnameVerifier {
      @Override
      public boolean verify(String var1, SSLSession var2) {
         return true;
      }
   }

   static class TrustAllManager implements X509TrustManager {
      @Override
      public void checkClientTrusted(X509Certificate[] var1, String var2) {
      }

      @Override
      public void checkServerTrusted(X509Certificate[] var1, String var2) {
      }

      @Override
      public X509Certificate[] getAcceptedIssuers() {
         return null;
      }
   }
}
