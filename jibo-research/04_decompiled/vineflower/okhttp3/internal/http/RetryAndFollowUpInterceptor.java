package okhttp3.internal.http;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.Proxy.Type;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;

public final class RetryAndFollowUpInterceptor implements Interceptor {
   private final OkHttpClient a;
   private final boolean b;
   private StreamAllocation c;
   private Object d;
   private volatile boolean e;

   public RetryAndFollowUpInterceptor(OkHttpClient var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   private Address a(HttpUrl var1) {
      CertificatePinner var4 = null;
      SSLSocketFactory var2;
      HostnameVerifier var3;
      if (var1.d()) {
         var2 = this.a.j();
         var3 = this.a.k();
         var4 = this.a.l();
      } else {
         var3 = null;
         var2 = null;
      }

      return new Address(var1.g(), var1.h(), this.a.h(), this.a.i(), var2, var3, var4, this.a.n(), this.a.d(), this.a.t(), this.a.u(), this.a.e());
   }

   private Request a(Response var1) throws IOException {
      Proxy var5 = null;
      Request.Builder var6 = null;
      if (var1 == null) {
         throw new IllegalStateException();
      }

      RealConnection var4 = this.c.b();
      Route var9;
      if (var4 != null) {
         var9 = var4.a();
      } else {
         var9 = null;
      }

      int var2 = var1.c();
      String var7 = var1.a().b();
      Request var10;
      switch (var2) {
         case 307:
         case 308:
            if (!var7.equals("GET")) {
               var10 = var6;
               if (!var7.equals("HEAD")) {
                  break;
               }
            }
         case 300:
         case 301:
         case 302:
         case 303:
            var10 = var6;
            if (this.a.q()) {
               String var8 = var1.a("Location");
               var10 = var6;
               if (var8 != null) {
                  HttpUrl var14 = var1.a().a().c(var8);
                  var10 = var6;
                  if (var14 != null) {
                     if (!var14.c().equals(var1.a().a().c())) {
                        Object var15 = var6;
                        if (!this.a.p()) {
                           return (Request)var15;
                        }
                     }

                     var6 = var1.a().e();
                     if (HttpMethod.c(var7)) {
                        boolean var3 = HttpMethod.d(var7);
                        if (HttpMethod.e(var7)) {
                           var6.a("GET", (RequestBody)null);
                        } else {
                           RequestBody var11 = var5;
                           if (var3) {
                              var11 = var1.a().d();
                           }

                           var6.a(var7, var11);
                        }

                        if (!var3) {
                           var6.b("Transfer-Encoding");
                           var6.b("Content-Length");
                           var6.b("Content-Type");
                        }
                     }

                     if (!this.a(var1, var14)) {
                        var6.b("Authorization");
                     }

                     var10 = var6.a(var14).c();
                  }
               }
            }
            break;
         case 401:
            var10 = this.a.m().authenticate(var9, var1);
            break;
         case 407:
            if (var9 != null) {
               var5 = var9.b();
            } else {
               var5 = this.a.d();
            }

            if (var5.type() != Type.HTTP) {
               throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }

            var10 = this.a.n().authenticate(var9, var1);
            break;
         case 408:
            var10 = var6;
            if (!(var1.a().d() instanceof UnrepeatableRequestBody)) {
               var10 = var1.a();
            }
            break;
         default:
            var10 = var6;
      }

      return var10;
   }

   private boolean a(IOException var1, boolean var2) {
      boolean var4 = true;
      boolean var3 = false;
      if (var1 instanceof ProtocolException) {
         var2 = var3;
      } else if (var1 instanceof InterruptedIOException) {
         if (var1 instanceof SocketTimeoutException && !var2) {
            var2 = var4;
         } else {
            var2 = false;
         }
      } else {
         if (var1 instanceof SSLHandshakeException) {
            var2 = var3;
            if (var1.getCause() instanceof CertificateException) {
               return var2;
            }
         }

         var2 = var3;
         if (!(var1 instanceof SSLPeerUnverifiedException)) {
            var2 = true;
         }
      }

      return var2;
   }

   private boolean a(IOException var1, boolean var2, Request var3) {
      boolean var5 = false;
      this.c.a(var1);
      boolean var4;
      if (!this.a.r()) {
         var4 = var5;
      } else {
         if (var2) {
            var4 = var5;
            if (var3.d() instanceof UnrepeatableRequestBody) {
               return var4;
            }
         }

         var4 = var5;
         if (this.a(var1, var2)) {
            var4 = var5;
            if (this.c.f()) {
               var4 = true;
            }
         }
      }

      return var4;
   }

   private boolean a(Response var1, HttpUrl var2) {
      HttpUrl var4 = var1.a().a();
      boolean var3;
      if (var4.g().equals(var2.g()) && var4.h() == var2.h() && var4.c().equals(var2.c())) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   @Override
   public Response a(Interceptor.Chain param1) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 000: aload 1
      // 001: invokeinterface okhttp3/Interceptor$Chain.a ()Lokhttp3/Request; 1
      // 006: astore 4
      // 008: aload 0
      // 009: new okhttp3/internal/connection/StreamAllocation
      // 00c: dup
      // 00d: aload 0
      // 00e: getfield okhttp3/internal/http/RetryAndFollowUpInterceptor.a Lokhttp3/OkHttpClient;
      // 011: invokevirtual okhttp3/OkHttpClient.o ()Lokhttp3/ConnectionPool;
      // 014: aload 0
      // 015: aload 4
      // 017: invokevirtual okhttp3/Request.a ()Lokhttp3/HttpUrl;
      // 01a: invokespecial okhttp3/internal/http/RetryAndFollowUpInterceptor.a (Lokhttp3/HttpUrl;)Lokhttp3/Address;
      // 01d: aload 0
      // 01e: getfield okhttp3/internal/http/RetryAndFollowUpInterceptor.d Ljava/lang/Object;
      // 021: invokespecial okhttp3/internal/connection/StreamAllocation.<init> (Lokhttp3/ConnectionPool;Lokhttp3/Address;Ljava/lang/Object;)V
      // 024: putfield okhttp3/internal/http/RetryAndFollowUpInterceptor.c Lokhttp3/internal/connection/StreamAllocation;
      // 027: aconst_null
      // 028: astore 5
      // 02a: bipush 0
      // 02b: istore 2
      // 02c: aload 0
      // 02d: getfield okhttp3/internal/http/RetryAndFollowUpInterceptor.e Z
      // 030: ifeq 045
      // 033: aload 0
      // 034: getfield okhttp3/internal/http/RetryAndFollowUpInterceptor.c Lokhttp3/internal/connection/StreamAllocation;
      // 037: invokevirtual okhttp3/internal/connection/StreamAllocation.c ()V
      // 03a: new java/io/IOException
      // 03d: dup
      // 03e: ldc_w "Canceled"
      // 041: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 044: athrow
      // 045: aload 1
      // 046: checkcast okhttp3/internal/http/RealInterceptorChain
      // 049: aload 4
      // 04b: aload 0
      // 04c: getfield okhttp3/internal/http/RetryAndFollowUpInterceptor.c Lokhttp3/internal/connection/StreamAllocation;
      // 04f: aconst_null
      // 050: aconst_null
      // 051: invokevirtual okhttp3/internal/http/RealInterceptorChain.a (Lokhttp3/Request;Lokhttp3/internal/connection/StreamAllocation;Lokhttp3/internal/http/HttpCodec;Lokhttp3/internal/connection/RealConnection;)Lokhttp3/Response;
      // 054: astore 6
      // 056: aload 6
      // 058: astore 4
      // 05a: aload 5
      // 05c: ifnull 078
      // 05f: aload 6
      // 061: invokevirtual okhttp3/Response.i ()Lokhttp3/Response$Builder;
      // 064: aload 5
      // 066: invokevirtual okhttp3/Response.i ()Lokhttp3/Response$Builder;
      // 069: aconst_null
      // 06a: invokevirtual okhttp3/Response$Builder.a (Lokhttp3/ResponseBody;)Lokhttp3/Response$Builder;
      // 06d: invokevirtual okhttp3/Response$Builder.a ()Lokhttp3/Response;
      // 070: invokevirtual okhttp3/Response$Builder.c (Lokhttp3/Response;)Lokhttp3/Response$Builder;
      // 073: invokevirtual okhttp3/Response$Builder.a ()Lokhttp3/Response;
      // 076: astore 4
      // 078: aload 0
      // 079: aload 4
      // 07b: invokespecial okhttp3/internal/http/RetryAndFollowUpInterceptor.a (Lokhttp3/Response;)Lokhttp3/Request;
      // 07e: astore 6
      // 080: aload 6
      // 082: ifnonnull 0df
      // 085: aload 0
      // 086: getfield okhttp3/internal/http/RetryAndFollowUpInterceptor.b Z
      // 089: ifne 093
      // 08c: aload 0
      // 08d: getfield okhttp3/internal/http/RetryAndFollowUpInterceptor.c Lokhttp3/internal/connection/StreamAllocation;
      // 090: invokevirtual okhttp3/internal/connection/StreamAllocation.c ()V
      // 093: aload 4
      // 095: areturn
      // 096: astore 6
      // 098: aload 0
      // 099: aload 6
      // 09b: invokevirtual okhttp3/internal/connection/RouteException.a ()Ljava/io/IOException;
      // 09e: bipush 0
      // 09f: aload 4
      // 0a1: invokespecial okhttp3/internal/http/RetryAndFollowUpInterceptor.a (Ljava/io/IOException;ZLokhttp3/Request;)Z
      // 0a4: ifne 02c
      // 0a7: aload 6
      // 0a9: invokevirtual okhttp3/internal/connection/RouteException.a ()Ljava/io/IOException;
      // 0ac: athrow
      // 0ad: astore 1
      // 0ae: aload 0
      // 0af: getfield okhttp3/internal/http/RetryAndFollowUpInterceptor.c Lokhttp3/internal/connection/StreamAllocation;
      // 0b2: aconst_null
      // 0b3: invokevirtual okhttp3/internal/connection/StreamAllocation.a (Ljava/io/IOException;)V
      // 0b6: aload 0
      // 0b7: getfield okhttp3/internal/http/RetryAndFollowUpInterceptor.c Lokhttp3/internal/connection/StreamAllocation;
      // 0ba: invokevirtual okhttp3/internal/connection/StreamAllocation.c ()V
      // 0bd: aload 1
      // 0be: athrow
      // 0bf: astore 6
      // 0c1: aload 6
      // 0c3: instanceof okhttp3/internal/http2/ConnectionShutdownException
      // 0c6: ifne 0da
      // 0c9: bipush 1
      // 0ca: istore 3
      // 0cb: aload 0
      // 0cc: aload 6
      // 0ce: iload 3
      // 0cf: aload 4
      // 0d1: invokespecial okhttp3/internal/http/RetryAndFollowUpInterceptor.a (Ljava/io/IOException;ZLokhttp3/Request;)Z
      // 0d4: ifne 02c
      // 0d7: aload 6
      // 0d9: athrow
      // 0da: bipush 0
      // 0db: istore 3
      // 0dc: goto 0cb
      // 0df: aload 4
      // 0e1: invokevirtual okhttp3/Response.h ()Lokhttp3/ResponseBody;
      // 0e4: invokestatic okhttp3/internal/Util.a (Ljava/io/Closeable;)V
      // 0e7: iinc 2 1
      // 0ea: iload 2
      // 0eb: bipush 20
      // 0ed: if_icmple 113
      // 0f0: aload 0
      // 0f1: getfield okhttp3/internal/http/RetryAndFollowUpInterceptor.c Lokhttp3/internal/connection/StreamAllocation;
      // 0f4: invokevirtual okhttp3/internal/connection/StreamAllocation.c ()V
      // 0f7: new java/net/ProtocolException
      // 0fa: dup
      // 0fb: new java/lang/StringBuilder
      // 0fe: dup
      // 0ff: invokespecial java/lang/StringBuilder.<init> ()V
      // 102: ldc_w "Too many follow-up requests: "
      // 105: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 108: iload 2
      // 109: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 10c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 10f: invokespecial java/net/ProtocolException.<init> (Ljava/lang/String;)V
      // 112: athrow
      // 113: aload 6
      // 115: invokevirtual okhttp3/Request.d ()Lokhttp3/RequestBody;
      // 118: instanceof okhttp3/internal/http/UnrepeatableRequestBody
      // 11b: ifeq 135
      // 11e: aload 0
      // 11f: getfield okhttp3/internal/http/RetryAndFollowUpInterceptor.c Lokhttp3/internal/connection/StreamAllocation;
      // 122: invokevirtual okhttp3/internal/connection/StreamAllocation.c ()V
      // 125: new java/net/HttpRetryException
      // 128: dup
      // 129: ldc_w "Cannot retry streamed HTTP body"
      // 12c: aload 4
      // 12e: invokevirtual okhttp3/Response.c ()I
      // 131: invokespecial java/net/HttpRetryException.<init> (Ljava/lang/String;I)V
      // 134: athrow
      // 135: aload 0
      // 136: aload 4
      // 138: aload 6
      // 13a: invokevirtual okhttp3/Request.a ()Lokhttp3/HttpUrl;
      // 13d: invokespecial okhttp3/internal/http/RetryAndFollowUpInterceptor.a (Lokhttp3/Response;Lokhttp3/HttpUrl;)Z
      // 140: ifne 174
      // 143: aload 0
      // 144: getfield okhttp3/internal/http/RetryAndFollowUpInterceptor.c Lokhttp3/internal/connection/StreamAllocation;
      // 147: invokevirtual okhttp3/internal/connection/StreamAllocation.c ()V
      // 14a: aload 0
      // 14b: new okhttp3/internal/connection/StreamAllocation
      // 14e: dup
      // 14f: aload 0
      // 150: getfield okhttp3/internal/http/RetryAndFollowUpInterceptor.a Lokhttp3/OkHttpClient;
      // 153: invokevirtual okhttp3/OkHttpClient.o ()Lokhttp3/ConnectionPool;
      // 156: aload 0
      // 157: aload 6
      // 159: invokevirtual okhttp3/Request.a ()Lokhttp3/HttpUrl;
      // 15c: invokespecial okhttp3/internal/http/RetryAndFollowUpInterceptor.a (Lokhttp3/HttpUrl;)Lokhttp3/Address;
      // 15f: aload 0
      // 160: getfield okhttp3/internal/http/RetryAndFollowUpInterceptor.d Ljava/lang/Object;
      // 163: invokespecial okhttp3/internal/connection/StreamAllocation.<init> (Lokhttp3/ConnectionPool;Lokhttp3/Address;Ljava/lang/Object;)V
      // 166: putfield okhttp3/internal/http/RetryAndFollowUpInterceptor.c Lokhttp3/internal/connection/StreamAllocation;
      // 169: aload 4
      // 16b: astore 5
      // 16d: aload 6
      // 16f: astore 4
      // 171: goto 02c
      // 174: aload 0
      // 175: getfield okhttp3/internal/http/RetryAndFollowUpInterceptor.c Lokhttp3/internal/connection/StreamAllocation;
      // 178: invokevirtual okhttp3/internal/connection/StreamAllocation.a ()Lokhttp3/internal/http/HttpCodec;
      // 17b: ifnull 169
      // 17e: new java/lang/IllegalStateException
      // 181: dup
      // 182: new java/lang/StringBuilder
      // 185: dup
      // 186: invokespecial java/lang/StringBuilder.<init> ()V
      // 189: ldc_w "Closing the body of "
      // 18c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 18f: aload 4
      // 191: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 194: ldc_w " didn't close its backing stream. Bad interceptor?"
      // 197: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 19a: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 19d: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 1a0: athrow
      // try (32 -> 41): 69 okhttp3/internal/connection/RouteException
      // try (32 -> 41): 90 java/io/IOException
      // try (32 -> 41): 80 null
      // try (70 -> 80): 80 null
      // try (91 -> 94): 80 null
      // try (96 -> 104): 80 null
   }

   public void a() {
      this.e = true;
      StreamAllocation var1 = this.c;
      if (var1 != null) {
         var1.e();
      }
   }

   public void a(Object var1) {
      this.d = var1;
   }

   public boolean b() {
      return this.e;
   }
}
