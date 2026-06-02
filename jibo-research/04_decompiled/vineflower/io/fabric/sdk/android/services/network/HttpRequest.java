package io.fabric.sdk.android.services.network;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.Proxy.Type;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;

public class HttpRequest {
   private static final String[] b = new String[0];
   private static HttpRequest.ConnectionFactory c = HttpRequest.ConnectionFactory.a;
   public final URL a;
   private HttpURLConnection d = null;
   private final String e;
   private HttpRequest.RequestOutputStream f;
   private boolean g;
   private boolean h = true;
   private boolean i = false;
   private int j = 8192;
   private String k;
   private int l;

   public HttpRequest(CharSequence var1, String var2) throws HttpRequest.HttpRequestException {
      try {
         URL var3 = new URL(var1.toString());
         this.a = var3;
      } catch (MalformedURLException var4) {
         throw new HttpRequest.HttpRequestException(var4);
      }

      this.e = var2;
   }

   public static HttpRequest a(CharSequence var0, Map<?, ?> var1, boolean var2) {
      String var4 = a(var0, var1);
      var0 = var4;
      if (var2) {
         var0 = a((CharSequence)var4);
      }

      return b(var0);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static String a(CharSequence var0) throws HttpRequest.HttpRequestException {
      URL var3;
      try {
         var3 = new URL(var0.toString());
      } catch (IOException var6) {
         throw new HttpRequest.HttpRequestException(var6);
      }

      String var2 = var3.getHost();
      int var1 = var3.getPort();
      var0 = var2;
      if (var1 != -1) {
         var0 = var2 + ':' + Integer.toString(var1);
      }

      try {
         URI var13 = new URI(var3.getProtocol(), var0, var3.getPath(), var3.getQuery(), null);
         var2 = var13.toASCIIString();
         var1 = var2.indexOf(63);
      } catch (URISyntaxException var5) {
         IOException var8 = new IOException("Parsing URI failed");
         var8.initCause(var5);
         throw new HttpRequest.HttpRequestException(var8);
      }

      var0 = var2;
      if (var1 > 0) {
         var0 = var2;

         try {
            if (var1 + 1 < var2.length()) {
               StringBuilder var11 = new StringBuilder();
               var0 = var11.append(var2.substring(0, var1 + 1)).append(var2.substring(var1 + 1).replace("+", "%2B")).toString();
            }
         } catch (URISyntaxException var4) {
            IOException var10 = new IOException("Parsing URI failed");
            var10.initCause(var4);
            throw new HttpRequest.HttpRequestException(var10);
         }
      }

      return var0;
   }

   public static String a(CharSequence var0, Map<?, ?> var1) {
      String var2 = var0.toString();
      var0 = var2;
      if (var1 != null) {
         if (var1.isEmpty()) {
            var0 = var2;
         } else {
            StringBuilder var4 = new StringBuilder(var2);
            a(var2, var4);
            b(var2, var4);
            Iterator var5 = var1.entrySet().iterator();
            Entry var6 = (Entry)var5.next();
            var4.append(var6.getKey().toString());
            var4.append('=');
            Object var7 = var6.getValue();
            if (var7 != null) {
               var4.append(var7);
            }

            while (var5.hasNext()) {
               var4.append('&');
               var7 = (Entry)var5.next();
               var4.append(var7.getKey().toString());
               var4.append('=');
               var7 = var7.getValue();
               if (var7 != null) {
                  var4.append(var7);
               }
            }

            var0 = var4.toString();
         }
      }

      return var0;
   }

   private static StringBuilder a(String var0, StringBuilder var1) {
      if (var0.indexOf(58) + 2 == var0.lastIndexOf(47)) {
         var1.append('/');
      }

      return var1;
   }

   public static HttpRequest b(CharSequence var0) throws HttpRequest.HttpRequestException {
      return new HttpRequest(var0, "GET");
   }

   public static HttpRequest b(CharSequence var0, Map<?, ?> var1, boolean var2) {
      String var4 = a(var0, var1);
      var0 = var4;
      if (var2) {
         var0 = a((CharSequence)var4);
      }

      return c(var0);
   }

   private static StringBuilder b(String var0, StringBuilder var1) {
      int var3 = var0.indexOf(63);
      int var2 = var1.length() - 1;
      if (var3 == -1) {
         var1.append('?');
      } else if (var3 < var2 && var0.charAt(var2) != '&') {
         var1.append('&');
      }

      return var1;
   }

   public static HttpRequest c(CharSequence var0) throws HttpRequest.HttpRequestException {
      return new HttpRequest(var0, "POST");
   }

   public static HttpRequest d(CharSequence var0) throws HttpRequest.HttpRequestException {
      return new HttpRequest(var0, "PUT");
   }

   public static HttpRequest e(CharSequence var0) throws HttpRequest.HttpRequestException {
      return new HttpRequest(var0, "DELETE");
   }

   private static String f(String var0) {
      if (var0 == null || var0.length() <= 0) {
         var0 = "UTF-8";
      }

      return var0;
   }

   private Proxy q() {
      return new Proxy(Type.HTTP, new InetSocketAddress(this.k, this.l));
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private HttpURLConnection r() {
      HttpURLConnection var1;
      label27: {
         try {
            if (this.k != null) {
               var1 = c.a(this.a, this.q());
               break label27;
            }
         } catch (IOException var4) {
            throw new HttpRequest.HttpRequestException(var4);
         }

         try {
            var1 = c.a(this.a);
         } catch (IOException var3) {
            throw new HttpRequest.HttpRequestException(var3);
         }
      }

      try {
         var1.setRequestMethod(this.e);
         return var1;
      } catch (IOException var2) {
         throw new HttpRequest.HttpRequestException(var2);
      }
   }

   public int a(String var1, int var2) throws HttpRequest.HttpRequestException {
      this.l();
      return this.a().getHeaderFieldInt(var1, var2);
   }

   public HttpRequest a(int var1) {
      this.a().setConnectTimeout(var1);
      return this;
   }

   protected HttpRequest a(InputStream var1, OutputStream var2) throws IOException {
      return (new HttpRequest.CloseOperation<HttpRequest>(this, var1, this.h, var1, var2) {
         final InputStream a;
         final OutputStream b;
         final HttpRequest c;

         {
            this.c = var1;
            this.a = var4;
            this.b = var5;
         }

         public HttpRequest a() throws IOException {
            byte[] var2x = new byte[this.c.j];

            while (true) {
               int var1x = this.a.read(var2x);
               if (var1x == -1) {
                  return this.c;
               }

               this.b.write(var2x, 0, var1x);
            }
         }
      }).call();
   }

   public HttpRequest a(String var1, Number var2) throws HttpRequest.HttpRequestException {
      return this.a(var1, null, var2);
   }

   public HttpRequest a(String var1, String var2) {
      this.a().setRequestProperty(var1, var2);
      return this;
   }

   public HttpRequest a(String var1, String var2, Number var3) throws HttpRequest.HttpRequestException {
      String var4;
      if (var3 != null) {
         var4 = var3.toString();
      } else {
         var4 = null;
      }

      return this.b(var1, var2, var4);
   }

   protected HttpRequest a(String var1, String var2, String var3) throws IOException {
      StringBuilder var4 = new StringBuilder();
      var4.append("form-data; name=\"").append(var1);
      if (var2 != null) {
         var4.append("\"; filename=\"").append(var2);
      }

      var4.append('"');
      this.f("Content-Disposition", var4.toString());
      if (var3 != null) {
         this.f("Content-Type", var3);
      }

      return this.f((CharSequence)"\r\n");
   }

   public HttpRequest a(String param1, String param2, String param3, File param4) throws HttpRequest.HttpRequestException {
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
      // 00: new java/io/BufferedInputStream
      // 03: astore 5
      // 05: new java/io/FileInputStream
      // 08: astore 6
      // 0a: aload 6
      // 0c: aload 4
      // 0e: invokespecial java/io/FileInputStream.<init> (Ljava/io/File;)V
      // 11: aload 5
      // 13: aload 6
      // 15: invokespecial java/io/BufferedInputStream.<init> (Ljava/io/InputStream;)V
      // 18: aload 5
      // 1a: astore 4
      // 1c: aload 0
      // 1d: aload 1
      // 1e: aload 2
      // 1f: aload 3
      // 20: aload 5
      // 22: invokevirtual io/fabric/sdk/android/services/network/HttpRequest.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)Lio/fabric/sdk/android/services/network/HttpRequest;
      // 25: astore 1
      // 26: aload 5
      // 28: ifnull 30
      // 2b: aload 5
      // 2d: invokevirtual java/io/InputStream.close ()V
      // 30: aload 1
      // 31: areturn
      // 32: astore 2
      // 33: aconst_null
      // 34: astore 1
      // 35: aload 1
      // 36: astore 4
      // 38: new io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
      // 3b: astore 3
      // 3c: aload 1
      // 3d: astore 4
      // 3f: aload 3
      // 40: aload 2
      // 41: invokespecial io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException.<init> (Ljava/io/IOException;)V
      // 44: aload 1
      // 45: astore 4
      // 47: aload 3
      // 48: athrow
      // 49: astore 1
      // 4a: aload 4
      // 4c: ifnull 54
      // 4f: aload 4
      // 51: invokevirtual java/io/InputStream.close ()V
      // 54: aload 1
      // 55: athrow
      // 56: astore 2
      // 57: goto 30
      // 5a: astore 2
      // 5b: goto 54
      // 5e: astore 1
      // 5f: aconst_null
      // 60: astore 4
      // 62: goto 4a
      // 65: astore 2
      // 66: aload 5
      // 68: astore 1
      // 69: goto 35
      // try (0 -> 10): 25 java/io/IOException
      // try (0 -> 10): 52 null
      // try (12 -> 19): 56 java/io/IOException
      // try (12 -> 19): 41 null
      // try (21 -> 23): 48 java/io/IOException
      // try (30 -> 32): 41 null
      // try (34 -> 37): 41 null
      // try (39 -> 41): 41 null
      // try (44 -> 46): 50 java/io/IOException
   }

   public HttpRequest a(String var1, String var2, String var3, InputStream var4) throws HttpRequest.HttpRequestException {
      try {
         this.n();
         this.a(var1, var2, var3);
         this.a(var4, this.f);
         return this;
      } catch (IOException var5) {
         throw new HttpRequest.HttpRequestException(var5);
      }
   }

   public HttpRequest a(String var1, String var2, String var3, String var4) throws HttpRequest.HttpRequestException {
      try {
         this.n();
         this.a(var1, var2, var3);
         this.f.a(var4);
         return this;
      } catch (IOException var5) {
         throw new HttpRequest.HttpRequestException(var5);
      }
   }

   public HttpRequest a(Entry<String, String> var1) {
      return this.a((String)var1.getKey(), (String)var1.getValue());
   }

   public HttpRequest a(boolean var1) {
      this.a().setUseCaches(var1);
      return this;
   }

   public String a(String var1) throws HttpRequest.HttpRequestException {
      ByteArrayOutputStream var2 = this.d();

      try {
         this.a(this.f(), var2);
         return var2.toString(f(var1));
      } catch (IOException var3) {
         throw new HttpRequest.HttpRequestException(var3);
      }
   }

   public HttpURLConnection a() {
      if (this.d == null) {
         this.d = this.r();
      }

      return this.d;
   }

   public int b() throws HttpRequest.HttpRequestException {
      try {
         this.k();
         return this.a().getResponseCode();
      } catch (IOException var3) {
         throw new HttpRequest.HttpRequestException(var3);
      }
   }

   public HttpRequest b(String var1, String var2, String var3) throws HttpRequest.HttpRequestException {
      return this.a(var1, var2, null, var3);
   }

   public String b(String var1) throws HttpRequest.HttpRequestException {
      this.l();
      return this.a().getHeaderField(var1);
   }

   public String b(String var1, String var2) {
      return this.c(this.b(var1), var2);
   }

   public int c(String var1) throws HttpRequest.HttpRequestException {
      return this.a(var1, -1);
   }

   protected String c(String var1, String var2) {
      if (var1 != null && var1.length() != 0) {
         int var5 = var1.length();
         int var3 = var1.indexOf(59) + 1;
         if (var3 != 0 && var3 != var5) {
            int var4 = var1.indexOf(59, var3);
            if (var4 == -1) {
               var4 = var5;
            }

            while (true) {
               if (var3 >= var4) {
                  var1 = null;
                  break;
               }

               int var6 = var1.indexOf(61, var3);
               if (var6 != -1 && var6 < var4 && var2.equals(var1.substring(var3, var6).trim())) {
                  String var7 = var1.substring(var6 + 1, var4).trim();
                  var3 = var7.length();
                  if (var3 != 0) {
                     var1 = var7;
                     if (var3 > 2) {
                        var1 = var7;
                        if ('"' == var7.charAt(0)) {
                           var1 = var7;
                           if ('"' == var7.charAt(var3 - 1)) {
                              var1 = var7.substring(1, var3 - 1);
                           }
                        }
                     }
                     break;
                  }
               }

               var6 = var1.indexOf(59, ++var4);
               var3 = var6;
               if (var6 == -1) {
                  var3 = var5;
               }

               var6 = var3;
               var3 = var4;
               var4 = var6;
            }
         } else {
            var1 = null;
         }
      } else {
         var1 = null;
      }

      return var1;
   }

   public boolean c() throws HttpRequest.HttpRequestException {
      boolean var1;
      if (200 == this.b()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public HttpRequest d(String var1) {
      return this.d(var1, null);
   }

   public HttpRequest d(String var1, String var2) {
      HttpRequest var3;
      if (var2 != null && var2.length() > 0) {
         var3 = this.a("Content-Type", var1 + "; charset=" + var2);
      } else {
         var3 = this.a("Content-Type", var1);
      }

      return var3;
   }

   protected ByteArrayOutputStream d() {
      int var1 = this.j();
      ByteArrayOutputStream var2;
      if (var1 > 0) {
         var2 = new ByteArrayOutputStream(var1);
      } else {
         var2 = new ByteArrayOutputStream();
      }

      return var2;
   }

   public HttpRequest e(String var1, String var2) {
      return this.b(var1, null, var2);
   }

   public String e() throws HttpRequest.HttpRequestException {
      return this.a(this.h());
   }

   public HttpRequest f(CharSequence var1) throws HttpRequest.HttpRequestException {
      try {
         this.m();
         this.f.a(var1.toString());
         return this;
      } catch (IOException var2) {
         throw new HttpRequest.HttpRequestException(var2);
      }
   }

   public HttpRequest f(String var1, String var2) throws HttpRequest.HttpRequestException {
      return this.f((CharSequence)var1).f((CharSequence)": ").f((CharSequence)var2).f((CharSequence)"\r\n");
   }

   public BufferedInputStream f() throws HttpRequest.HttpRequestException {
      return new BufferedInputStream(this.g(), this.j);
   }

   public InputStream g() throws HttpRequest.HttpRequestException {
      InputStream var1;
      if (this.b() < 400) {
         try {
            var1 = this.a().getInputStream();
         } catch (IOException var5) {
            throw new HttpRequest.HttpRequestException(var5);
         }
      } else {
         InputStream var2 = this.a().getErrorStream();
         var1 = var2;
         if (var2 == null) {
            try {
               var1 = this.a().getInputStream();
            } catch (IOException var4) {
               throw new HttpRequest.HttpRequestException(var4);
            }
         }
      }

      InputStream var6 = var1;
      if (this.i) {
         if (!"gzip".equals(this.i())) {
            var6 = var1;
         } else {
            try {
               var6 = new GZIPInputStream(var1);
            } catch (IOException var3) {
               throw new HttpRequest.HttpRequestException(var3);
            }
         }
      }

      return var6;
   }

   public String h() {
      return this.b("Content-Type", "charset");
   }

   public String i() {
      return this.b("Content-Encoding");
   }

   public int j() {
      return this.c("Content-Length");
   }

   protected HttpRequest k() throws IOException {
      if (this.f != null) {
         if (this.g) {
            this.f.a("\r\n--00content0boundary00--\r\n");
         }

         if (this.h) {
            try {
               this.f.close();
            } catch (IOException var2) {
            }
         } else {
            this.f.close();
         }

         this.f = null;
      }

      return this;
   }

   protected HttpRequest l() throws HttpRequest.HttpRequestException {
      try {
         return this.k();
      } catch (IOException var2) {
         throw new HttpRequest.HttpRequestException(var2);
      }
   }

   protected HttpRequest m() throws IOException {
      if (this.f == null) {
         this.a().setDoOutput(true);
         String var1 = this.c(this.a().getRequestProperty("Content-Type"), "charset");
         this.f = new HttpRequest.RequestOutputStream(this.a().getOutputStream(), var1, this.j);
      }

      return this;
   }

   protected HttpRequest n() throws IOException {
      if (!this.g) {
         this.g = true;
         this.d("multipart/form-data; boundary=00content0boundary00").m();
         this.f.a("--00content0boundary00\r\n");
      } else {
         this.f.a("\r\n--00content0boundary00\r\n");
      }

      return this;
   }

   public URL o() {
      return this.a().getURL();
   }

   public String p() {
      return this.a().getRequestMethod();
   }

   @Override
   public String toString() {
      return this.p() + ' ' + this.o();
   }

   protected abstract static class CloseOperation<V> extends HttpRequest.Operation<V> {
      private final Closeable a;
      private final boolean b;

      protected CloseOperation(Closeable var1, boolean var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      protected void c() throws IOException {
         if (this.a instanceof Flushable) {
            ((Flushable)this.a).flush();
         }

         if (this.b) {
            try {
               this.a.close();
            } catch (IOException var2) {
            }
         } else {
            this.a.close();
         }
      }
   }

   public interface ConnectionFactory {
      HttpRequest.ConnectionFactory a = new HttpRequest.ConnectionFactory() {
         @Override
         public HttpURLConnection a(URL var1) throws IOException {
            return (HttpURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(var1.openConnection()));
         }

         @Override
         public HttpURLConnection a(URL var1, Proxy var2) throws IOException {
            return (HttpURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(var1.openConnection(var2)));
         }
      };

      HttpURLConnection a(URL var1) throws IOException;

      HttpURLConnection a(URL var1, Proxy var2) throws IOException;
   }

   public static class HttpRequestException extends RuntimeException {
      protected HttpRequestException(IOException var1) {
         super(var1);
      }

      public IOException a() {
         return (IOException)super.getCause();
      }
   }

   protected abstract static class Operation<V> implements Callable<V> {
      protected abstract V b() throws HttpRequest.HttpRequestException, IOException;

      protected abstract void c() throws IOException;

      @Override
      public V call() throws HttpRequest.HttpRequestException {
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
         // 00: bipush 1
         // 01: istore 1
         // 02: aload 0
         // 03: invokevirtual io/fabric/sdk/android/services/network/HttpRequest$Operation.b ()Ljava/lang/Object;
         // 06: astore 2
         // 07: aload 0
         // 08: invokevirtual io/fabric/sdk/android/services/network/HttpRequest$Operation.c ()V
         // 0b: aload 2
         // 0c: areturn
         // 0d: astore 2
         // 0e: new io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
         // 11: dup
         // 12: aload 2
         // 13: invokespecial io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException.<init> (Ljava/io/IOException;)V
         // 16: athrow
         // 17: astore 2
         // 18: aload 2
         // 19: athrow
         // 1a: astore 2
         // 1b: aload 0
         // 1c: invokevirtual io/fabric/sdk/android/services/network/HttpRequest$Operation.c ()V
         // 1f: aload 2
         // 20: athrow
         // 21: astore 2
         // 22: new io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
         // 25: astore 3
         // 26: aload 3
         // 27: aload 2
         // 28: invokespecial io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException.<init> (Ljava/io/IOException;)V
         // 2b: aload 3
         // 2c: athrow
         // 2d: astore 3
         // 2e: iload 1
         // 2f: ifne 1f
         // 32: new io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
         // 35: dup
         // 36: aload 3
         // 37: invokespecial io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException.<init> (Ljava/io/IOException;)V
         // 3a: athrow
         // 3b: astore 2
         // 3c: bipush 0
         // 3d: istore 1
         // 3e: goto 1b
         // try (2 -> 5): 15 io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
         // try (2 -> 5): 23 java/io/IOException
         // try (2 -> 5): 39 null
         // try (5 -> 7): 9 java/io/IOException
         // try (16 -> 18): 18 null
         // try (19 -> 21): 31 java/io/IOException
         // try (24 -> 31): 18 null
      }
   }

   public static class RequestOutputStream extends BufferedOutputStream {
      private final CharsetEncoder a;

      public RequestOutputStream(OutputStream var1, String var2, int var3) {
         super(var1, var3);
         this.a = Charset.forName(HttpRequest.f(var2)).newEncoder();
      }

      public HttpRequest.RequestOutputStream a(String var1) throws IOException {
         ByteBuffer var2 = this.a.encode(CharBuffer.wrap(var1));
         super.write(var2.array(), 0, var2.limit());
         return this;
      }
   }
}
