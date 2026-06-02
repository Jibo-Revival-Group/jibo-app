package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.Proxy.Type;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.Address;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http1.Http1Codec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Codec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public final class RealConnection extends Http2Connection.Listener implements Connection {
   public boolean a;
   public int b;
   public int c = 1;
   public final List<Reference<StreamAllocation>> d = new ArrayList<>();
   public long e = Long.MAX_VALUE;
   private final ConnectionPool g;
   private final Route h;
   private Socket i;
   private Socket j;
   private Handshake k;
   private Protocol l;
   private Http2Connection m;
   private BufferedSource n;
   private BufferedSink o;

   public RealConnection(ConnectionPool var1, Route var2) {
      this.g = var1;
      this.h = var2;
   }

   private Request a(int var1, int var2, Request var3, HttpUrl var4) throws IOException {
      String var9 = "CONNECT " + Util.a(var4, true) + " HTTP/1.1";

      while (true) {
         Http1Codec var12 = new Http1Codec(null, null, this.n, this.o);
         this.n.a().a(var1, TimeUnit.MILLISECONDS);
         this.o.a().a(var2, TimeUnit.MILLISECONDS);
         var12.a(var3.c(), var9);
         var12.b();
         Response var10 = var12.a(false).a(var3).a();
         long var7 = HttpHeaders.a(var10);
         long var5 = var7;
         if (var7 == -1L) {
            var5 = 0L;
         }

         Source var11 = var12.b(var5);
         Util.b(var11, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
         var11.close();
         Request var13;
         switch (var10.c()) {
            case 200:
               if (!this.n.c().f() || !this.o.c().f()) {
                  throw new IOException("TLS tunnel buffered too many bytes!");
               }

               var13 = null;
               break;
            case 407:
               var13 = this.h.a().d().authenticate(this.h, var10);
               if (var13 == null) {
                  throw new IOException("Failed to authenticate with proxy");
               }

               var3 = var13;
               if (!"close".equalsIgnoreCase(var10.a("Connection"))) {
                  continue;
               }
               break;
            default:
               throw new IOException("Unexpected response code for CONNECT: " + var10.c());
         }

         return var13;
      }
   }

   private void a(int var1, int var2) throws IOException {
      Proxy var3 = this.h.b();
      Address var4 = this.h.a();
      Socket var7;
      if (var3.type() != Type.DIRECT && var3.type() != Type.HTTP) {
         var7 = new Socket(var3);
      } else {
         var7 = var4.c().createSocket();
      }

      this.i = var7;
      this.i.setSoTimeout(var2);

      try {
         Platform.b().a(this.i, this.h.c(), var1);
      } catch (ConnectException var5) {
         ConnectException var8 = new ConnectException("Failed to connect to " + this.h.c());
         var8.initCause(var5);
         throw var8;
      }

      try {
         this.n = Okio.a(Okio.b(this.i));
         this.o = Okio.a(Okio.a(this.i));
      } catch (NullPointerException var6) {
         if ("throw with null exception".equals(var6.getMessage())) {
            throw new IOException(var6);
         }
      }
   }

   private void a(int var1, int var2, int var3) throws IOException {
      Request var5 = this.g();
      HttpUrl var6 = var5.a();

      for (int var4 = 0; ++var4 <= 21; this.n = null) {
         this.a(var1, var2);
         var5 = this.a(var2, var3, var5, var6);
         if (var5 == null) {
            return;
         }

         Util.a(this.i);
         this.i = null;
         this.o = null;
      }

      throw new ProtocolException("Too many tunnel connections attempted: " + 21);
   }

   private void a(ConnectionSpecSelector var1) throws IOException {
      if (this.h.a().i() == null) {
         this.l = Protocol.HTTP_1_1;
         this.j = this.i;
      } else {
         this.b(var1);
         if (this.l == Protocol.HTTP_2) {
            this.j.setSoTimeout(0);
            this.m = new Http2Connection.Builder(true).a(this.j, this.h.a().a().g(), this.n, this.o).a(this).a();
            this.m.c();
         }
      }
   }

   private void b(ConnectionSpecSelector param1) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 2
      // 002: aconst_null
      // 003: astore 5
      // 005: aconst_null
      // 006: astore 4
      // 008: aload 0
      // 009: getfield okhttp3/internal/connection/RealConnection.h Lokhttp3/Route;
      // 00c: invokevirtual okhttp3/Route.a ()Lokhttp3/Address;
      // 00f: astore 6
      // 011: aload 6
      // 013: invokevirtual okhttp3/Address.i ()Ljavax/net/ssl/SSLSocketFactory;
      // 016: astore 3
      // 017: aload 3
      // 018: aload 0
      // 019: getfield okhttp3/internal/connection/RealConnection.i Ljava/net/Socket;
      // 01c: aload 6
      // 01e: invokevirtual okhttp3/Address.a ()Lokhttp3/HttpUrl;
      // 021: invokevirtual okhttp3/HttpUrl.g ()Ljava/lang/String;
      // 024: aload 6
      // 026: invokevirtual okhttp3/Address.a ()Lokhttp3/HttpUrl;
      // 029: invokevirtual okhttp3/HttpUrl.h ()I
      // 02c: bipush 1
      // 02d: invokevirtual javax/net/ssl/SSLSocketFactory.createSocket (Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
      // 030: checkcast javax/net/ssl/SSLSocket
      // 033: astore 3
      // 034: aload 1
      // 035: aload 3
      // 036: invokevirtual okhttp3/internal/connection/ConnectionSpecSelector.a (Ljavax/net/ssl/SSLSocket;)Lokhttp3/ConnectionSpec;
      // 039: astore 4
      // 03b: aload 4
      // 03d: invokevirtual okhttp3/ConnectionSpec.d ()Z
      // 040: ifeq 057
      // 043: invokestatic okhttp3/internal/platform/Platform.b ()Lokhttp3/internal/platform/Platform;
      // 046: aload 3
      // 047: aload 6
      // 049: invokevirtual okhttp3/Address.a ()Lokhttp3/HttpUrl;
      // 04c: invokevirtual okhttp3/HttpUrl.g ()Ljava/lang/String;
      // 04f: aload 6
      // 051: invokevirtual okhttp3/Address.e ()Ljava/util/List;
      // 054: invokevirtual okhttp3/internal/platform/Platform.a (Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V
      // 057: aload 3
      // 058: invokevirtual javax/net/ssl/SSLSocket.startHandshake ()V
      // 05b: aload 3
      // 05c: invokevirtual javax/net/ssl/SSLSocket.getSession ()Ljavax/net/ssl/SSLSession;
      // 05f: invokestatic okhttp3/Handshake.a (Ljavax/net/ssl/SSLSession;)Lokhttp3/Handshake;
      // 062: astore 2
      // 063: aload 6
      // 065: invokevirtual okhttp3/Address.j ()Ljavax/net/ssl/HostnameVerifier;
      // 068: aload 6
      // 06a: invokevirtual okhttp3/Address.a ()Lokhttp3/HttpUrl;
      // 06d: invokevirtual okhttp3/HttpUrl.g ()Ljava/lang/String;
      // 070: aload 3
      // 071: invokevirtual javax/net/ssl/SSLSocket.getSession ()Ljavax/net/ssl/SSLSession;
      // 074: invokeinterface javax/net/ssl/HostnameVerifier.verify (Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z 3
      // 079: ifne 114
      // 07c: aload 2
      // 07d: invokevirtual okhttp3/Handshake.c ()Ljava/util/List;
      // 080: bipush 0
      // 081: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 086: checkcast java/security/cert/X509Certificate
      // 089: astore 2
      // 08a: new javax/net/ssl/SSLPeerUnverifiedException
      // 08d: astore 4
      // 08f: new java/lang/StringBuilder
      // 092: astore 1
      // 093: aload 1
      // 094: invokespecial java/lang/StringBuilder.<init> ()V
      // 097: aload 4
      // 099: aload 1
      // 09a: ldc_w "Hostname "
      // 09d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a0: aload 6
      // 0a2: invokevirtual okhttp3/Address.a ()Lokhttp3/HttpUrl;
      // 0a5: invokevirtual okhttp3/HttpUrl.g ()Ljava/lang/String;
      // 0a8: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0ab: ldc_w " not verified:\n    certificate: "
      // 0ae: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0b1: aload 2
      // 0b2: invokestatic okhttp3/CertificatePinner.a (Ljava/security/cert/Certificate;)Ljava/lang/String;
      // 0b5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0b8: ldc_w "\n    DN: "
      // 0bb: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0be: aload 2
      // 0bf: invokevirtual java/security/cert/X509Certificate.getSubjectDN ()Ljava/security/Principal;
      // 0c2: invokeinterface java/security/Principal.getName ()Ljava/lang/String; 1
      // 0c7: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0ca: ldc_w "\n    subjectAltNames: "
      // 0cd: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0d0: aload 2
      // 0d1: invokestatic okhttp3/internal/tls/OkHostnameVerifier.a (Ljava/security/cert/X509Certificate;)Ljava/util/List;
      // 0d4: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 0d7: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0da: invokespecial javax/net/ssl/SSLPeerUnverifiedException.<init> (Ljava/lang/String;)V
      // 0dd: aload 4
      // 0df: athrow
      // 0e0: astore 2
      // 0e1: aload 3
      // 0e2: astore 1
      // 0e3: aload 2
      // 0e4: astore 3
      // 0e5: aload 1
      // 0e6: astore 2
      // 0e7: aload 3
      // 0e8: invokestatic okhttp3/internal/Util.a (Ljava/lang/AssertionError;)Z
      // 0eb: ifeq 182
      // 0ee: aload 1
      // 0ef: astore 2
      // 0f0: new java/io/IOException
      // 0f3: astore 4
      // 0f5: aload 1
      // 0f6: astore 2
      // 0f7: aload 4
      // 0f9: aload 3
      // 0fa: invokespecial java/io/IOException.<init> (Ljava/lang/Throwable;)V
      // 0fd: aload 1
      // 0fe: astore 2
      // 0ff: aload 4
      // 101: athrow
      // 102: astore 1
      // 103: aload 2
      // 104: ifnull 10e
      // 107: invokestatic okhttp3/internal/platform/Platform.b ()Lokhttp3/internal/platform/Platform;
      // 10a: aload 2
      // 10b: invokevirtual okhttp3/internal/platform/Platform.b (Ljavax/net/ssl/SSLSocket;)V
      // 10e: aload 2
      // 10f: invokestatic okhttp3/internal/Util.a (Ljava/net/Socket;)V
      // 112: aload 1
      // 113: athrow
      // 114: aload 6
      // 116: invokevirtual okhttp3/Address.k ()Lokhttp3/CertificatePinner;
      // 119: aload 6
      // 11b: invokevirtual okhttp3/Address.a ()Lokhttp3/HttpUrl;
      // 11e: invokevirtual okhttp3/HttpUrl.g ()Ljava/lang/String;
      // 121: aload 2
      // 122: invokevirtual okhttp3/Handshake.c ()Ljava/util/List;
      // 125: invokevirtual okhttp3/CertificatePinner.a (Ljava/lang/String;Ljava/util/List;)V
      // 128: aload 5
      // 12a: astore 1
      // 12b: aload 4
      // 12d: invokevirtual okhttp3/ConnectionSpec.d ()Z
      // 130: ifeq 13b
      // 133: invokestatic okhttp3/internal/platform/Platform.b ()Lokhttp3/internal/platform/Platform;
      // 136: aload 3
      // 137: invokevirtual okhttp3/internal/platform/Platform.a (Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
      // 13a: astore 1
      // 13b: aload 0
      // 13c: aload 3
      // 13d: putfield okhttp3/internal/connection/RealConnection.j Ljava/net/Socket;
      // 140: aload 0
      // 141: aload 0
      // 142: getfield okhttp3/internal/connection/RealConnection.j Ljava/net/Socket;
      // 145: invokestatic okio/Okio.b (Ljava/net/Socket;)Lokio/Source;
      // 148: invokestatic okio/Okio.a (Lokio/Source;)Lokio/BufferedSource;
      // 14b: putfield okhttp3/internal/connection/RealConnection.n Lokio/BufferedSource;
      // 14e: aload 0
      // 14f: aload 0
      // 150: getfield okhttp3/internal/connection/RealConnection.j Ljava/net/Socket;
      // 153: invokestatic okio/Okio.a (Ljava/net/Socket;)Lokio/Sink;
      // 156: invokestatic okio/Okio.a (Lokio/Sink;)Lokio/BufferedSink;
      // 159: putfield okhttp3/internal/connection/RealConnection.o Lokio/BufferedSink;
      // 15c: aload 0
      // 15d: aload 2
      // 15e: putfield okhttp3/internal/connection/RealConnection.k Lokhttp3/Handshake;
      // 161: aload 1
      // 162: ifnull 17b
      // 165: aload 1
      // 166: invokestatic okhttp3/Protocol.get (Ljava/lang/String;)Lokhttp3/Protocol;
      // 169: astore 1
      // 16a: aload 0
      // 16b: aload 1
      // 16c: putfield okhttp3/internal/connection/RealConnection.l Lokhttp3/Protocol;
      // 16f: aload 3
      // 170: ifnull 17a
      // 173: invokestatic okhttp3/internal/platform/Platform.b ()Lokhttp3/internal/platform/Platform;
      // 176: aload 3
      // 177: invokevirtual okhttp3/internal/platform/Platform.b (Ljavax/net/ssl/SSLSocket;)V
      // 17a: return
      // 17b: getstatic okhttp3/Protocol.HTTP_1_1 Lokhttp3/Protocol;
      // 17e: astore 1
      // 17f: goto 16a
      // 182: aload 1
      // 183: astore 2
      // 184: aload 3
      // 185: athrow
      // 186: astore 1
      // 187: aload 3
      // 188: astore 2
      // 189: goto 103
      // 18c: astore 3
      // 18d: aload 4
      // 18f: astore 1
      // 190: goto 0e5
      // try (13 -> 26): 189 java/lang/AssertionError
      // try (13 -> 26): 119 null
      // try (26 -> 41): 96 java/lang/AssertionError
      // try (26 -> 41): 185 null
      // try (41 -> 96): 96 java/lang/AssertionError
      // try (41 -> 96): 185 null
      // try (103 -> 106): 119 null
      // try (108 -> 110): 119 null
      // try (112 -> 115): 119 null
      // try (117 -> 119): 119 null
      // try (129 -> 137): 96 java/lang/AssertionError
      // try (129 -> 137): 185 null
      // try (139 -> 146): 96 java/lang/AssertionError
      // try (139 -> 146): 185 null
      // try (146 -> 164): 96 java/lang/AssertionError
      // try (146 -> 164): 185 null
      // try (166 -> 169): 96 java/lang/AssertionError
      // try (166 -> 169): 185 null
      // try (169 -> 172): 96 java/lang/AssertionError
      // try (169 -> 172): 185 null
      // try (178 -> 180): 96 java/lang/AssertionError
      // try (178 -> 180): 185 null
      // try (183 -> 185): 119 null
   }

   private Request g() {
      return new Request.Builder()
         .a(this.h.a().a())
         .a("Host", Util.a(this.h.a().a(), true))
         .a("Proxy-Connection", "Keep-Alive")
         .a("User-Agent", Version.a())
         .c();
   }

   @Override
   public Route a() {
      return this.h;
   }

   public HttpCodec a(OkHttpClient var1, StreamAllocation var2) throws SocketException {
      HttpCodec var3;
      if (this.m != null) {
         var3 = new Http2Codec(var1, var2, this.m);
      } else {
         this.j.setSoTimeout(var1.b());
         this.n.a().a(var1.b(), TimeUnit.MILLISECONDS);
         this.o.a().a(var1.c(), TimeUnit.MILLISECONDS);
         var3 = new Http1Codec(var1, var2, this.n, this.o);
      }

      return var3;
   }

   public void a(int param1, int param2, int param3, boolean param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: aload 0
      // 001: getfield okhttp3/internal/connection/RealConnection.l Lokhttp3/Protocol;
      // 004: ifnull 012
      // 007: new java/lang/IllegalStateException
      // 00a: dup
      // 00b: ldc_w "already connected"
      // 00e: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 011: athrow
      // 012: aload 0
      // 013: getfield okhttp3/internal/connection/RealConnection.h Lokhttp3/Route;
      // 016: invokevirtual okhttp3/Route.a ()Lokhttp3/Address;
      // 019: invokevirtual okhttp3/Address.f ()Ljava/util/List;
      // 01c: astore 5
      // 01e: new okhttp3/internal/connection/ConnectionSpecSelector
      // 021: dup
      // 022: aload 5
      // 024: invokespecial okhttp3/internal/connection/ConnectionSpecSelector.<init> (Ljava/util/List;)V
      // 027: astore 7
      // 029: aload 0
      // 02a: getfield okhttp3/internal/connection/RealConnection.h Lokhttp3/Route;
      // 02d: invokevirtual okhttp3/Route.a ()Lokhttp3/Address;
      // 030: invokevirtual okhttp3/Address.i ()Ljavax/net/ssl/SSLSocketFactory;
      // 033: ifnonnull 099
      // 036: aload 5
      // 038: getstatic okhttp3/ConnectionSpec.c Lokhttp3/ConnectionSpec;
      // 03b: invokeinterface java/util/List.contains (Ljava/lang/Object;)Z 2
      // 040: ifne 055
      // 043: new okhttp3/internal/connection/RouteException
      // 046: dup
      // 047: new java/net/UnknownServiceException
      // 04a: dup
      // 04b: ldc_w "CLEARTEXT communication not enabled for client"
      // 04e: invokespecial java/net/UnknownServiceException.<init> (Ljava/lang/String;)V
      // 051: invokespecial okhttp3/internal/connection/RouteException.<init> (Ljava/io/IOException;)V
      // 054: athrow
      // 055: aload 0
      // 056: getfield okhttp3/internal/connection/RealConnection.h Lokhttp3/Route;
      // 059: invokevirtual okhttp3/Route.a ()Lokhttp3/Address;
      // 05c: invokevirtual okhttp3/Address.a ()Lokhttp3/HttpUrl;
      // 05f: invokevirtual okhttp3/HttpUrl.g ()Ljava/lang/String;
      // 062: astore 5
      // 064: invokestatic okhttp3/internal/platform/Platform.b ()Lokhttp3/internal/platform/Platform;
      // 067: aload 5
      // 069: invokevirtual okhttp3/internal/platform/Platform.b (Ljava/lang/String;)Z
      // 06c: ifne 099
      // 06f: new okhttp3/internal/connection/RouteException
      // 072: dup
      // 073: new java/net/UnknownServiceException
      // 076: dup
      // 077: new java/lang/StringBuilder
      // 07a: dup
      // 07b: invokespecial java/lang/StringBuilder.<init> ()V
      // 07e: ldc_w "CLEARTEXT communication to "
      // 081: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 084: aload 5
      // 086: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 089: ldc_w " not permitted by network security policy"
      // 08c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 08f: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 092: invokespecial java/net/UnknownServiceException.<init> (Ljava/lang/String;)V
      // 095: invokespecial okhttp3/internal/connection/RouteException.<init> (Ljava/io/IOException;)V
      // 098: athrow
      // 099: aconst_null
      // 09a: astore 6
      // 09c: aload 0
      // 09d: getfield okhttp3/internal/connection/RealConnection.h Lokhttp3/Route;
      // 0a0: invokevirtual okhttp3/Route.d ()Z
      // 0a3: ifeq 0d2
      // 0a6: aload 0
      // 0a7: iload 1
      // 0a8: iload 2
      // 0a9: iload 3
      // 0aa: invokespecial okhttp3/internal/connection/RealConnection.a (III)V
      // 0ad: aload 0
      // 0ae: aload 7
      // 0b0: invokespecial okhttp3/internal/connection/RealConnection.a (Lokhttp3/internal/connection/ConnectionSpecSelector;)V
      // 0b3: aload 0
      // 0b4: getfield okhttp3/internal/connection/RealConnection.m Lokhttp3/internal/http2/Http2Connection;
      // 0b7: ifnull 0d1
      // 0ba: aload 0
      // 0bb: getfield okhttp3/internal/connection/RealConnection.g Lokhttp3/ConnectionPool;
      // 0be: astore 5
      // 0c0: aload 5
      // 0c2: monitorenter
      // 0c3: aload 0
      // 0c4: aload 0
      // 0c5: getfield okhttp3/internal/connection/RealConnection.m Lokhttp3/internal/http2/Http2Connection;
      // 0c8: invokevirtual okhttp3/internal/http2/Http2Connection.a ()I
      // 0cb: putfield okhttp3/internal/connection/RealConnection.c I
      // 0ce: aload 5
      // 0d0: monitorexit
      // 0d1: return
      // 0d2: aload 0
      // 0d3: iload 1
      // 0d4: iload 2
      // 0d5: invokespecial okhttp3/internal/connection/RealConnection.a (II)V
      // 0d8: goto 0ad
      // 0db: astore 8
      // 0dd: aload 0
      // 0de: getfield okhttp3/internal/connection/RealConnection.j Ljava/net/Socket;
      // 0e1: invokestatic okhttp3/internal/Util.a (Ljava/net/Socket;)V
      // 0e4: aload 0
      // 0e5: getfield okhttp3/internal/connection/RealConnection.i Ljava/net/Socket;
      // 0e8: invokestatic okhttp3/internal/Util.a (Ljava/net/Socket;)V
      // 0eb: aload 0
      // 0ec: aconst_null
      // 0ed: putfield okhttp3/internal/connection/RealConnection.j Ljava/net/Socket;
      // 0f0: aload 0
      // 0f1: aconst_null
      // 0f2: putfield okhttp3/internal/connection/RealConnection.i Ljava/net/Socket;
      // 0f5: aload 0
      // 0f6: aconst_null
      // 0f7: putfield okhttp3/internal/connection/RealConnection.n Lokio/BufferedSource;
      // 0fa: aload 0
      // 0fb: aconst_null
      // 0fc: putfield okhttp3/internal/connection/RealConnection.o Lokio/BufferedSink;
      // 0ff: aload 0
      // 100: aconst_null
      // 101: putfield okhttp3/internal/connection/RealConnection.k Lokhttp3/Handshake;
      // 104: aload 0
      // 105: aconst_null
      // 106: putfield okhttp3/internal/connection/RealConnection.l Lokhttp3/Protocol;
      // 109: aload 0
      // 10a: aconst_null
      // 10b: putfield okhttp3/internal/connection/RealConnection.m Lokhttp3/internal/http2/Http2Connection;
      // 10e: aload 6
      // 110: ifnonnull 134
      // 113: new okhttp3/internal/connection/RouteException
      // 116: dup
      // 117: aload 8
      // 119: invokespecial okhttp3/internal/connection/RouteException.<init> (Ljava/io/IOException;)V
      // 11c: astore 5
      // 11e: iload 4
      // 120: ifeq 131
      // 123: aload 5
      // 125: astore 6
      // 127: aload 7
      // 129: aload 8
      // 12b: invokevirtual okhttp3/internal/connection/ConnectionSpecSelector.a (Ljava/io/IOException;)Z
      // 12e: ifne 09c
      // 131: aload 5
      // 133: athrow
      // 134: aload 6
      // 136: aload 8
      // 138: invokevirtual okhttp3/internal/connection/RouteException.a (Ljava/io/IOException;)V
      // 13b: aload 6
      // 13d: astore 5
      // 13f: goto 11e
      // 142: astore 6
      // 144: aload 5
      // 146: monitorexit
      // 147: aload 6
      // 149: athrow
      // try (64 -> 73): 97 java/io/IOException
      // try (73 -> 76): 97 java/io/IOException
      // try (84 -> 91): 148 null
      // try (92 -> 96): 97 java/io/IOException
      // try (149 -> 151): 148 null
   }

   @Override
   public void a(Http2Connection param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield okhttp3/internal/connection/RealConnection.g Lokhttp3/ConnectionPool;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: aload 1
      // 09: invokevirtual okhttp3/internal/http2/Http2Connection.a ()I
      // 0c: putfield okhttp3/internal/connection/RealConnection.c I
      // 0f: aload 2
      // 10: monitorexit
      // 11: return
      // 12: astore 1
      // 13: aload 2
      // 14: monitorexit
      // 15: aload 1
      // 16: athrow
      // try (5 -> 11): 12 null
      // try (13 -> 15): 12 null
   }

   @Override
   public void a(Http2Stream var1) throws IOException {
      var1.a(ErrorCode.REFUSED_STREAM);
   }

   public boolean a(Address var1, Route var2) {
      boolean var4 = false;
      boolean var3 = var4;
      if (this.d.size() < this.c) {
         if (this.a) {
            var3 = var4;
         } else {
            var3 = var4;
            if (Internal.a.a(this.h.a(), var1)) {
               if (var1.a().g().equals(this.a().a().a().g())) {
                  var3 = true;
               } else {
                  var3 = var4;
                  if (this.m != null) {
                     var3 = var4;
                     if (var2 != null) {
                        var3 = var4;
                        if (var2.b().type() == Type.DIRECT) {
                           var3 = var4;
                           if (this.h.b().type() == Type.DIRECT) {
                              var3 = var4;
                              if (this.h.c().equals(var2.c())) {
                                 var3 = var4;
                                 if (var2.a().j() == OkHostnameVerifier.a) {
                                    var3 = var4;
                                    if (this.a(var1.a())) {
                                       try {
                                          var1.k().a(var1.a().g(), this.e().c());
                                       } catch (SSLPeerUnverifiedException var5) {
                                          var3 = var4;
                                          return var3;
                                       }

                                       var3 = true;
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var3;
   }

   public boolean a(HttpUrl var1) {
      boolean var2 = false;
      if (var1.h() == this.h.a().a().h()) {
         if (!var1.g().equals(this.h.a().a().g())) {
            if (this.k != null && OkHostnameVerifier.a.a(var1.g(), (X509Certificate)this.k.c().get(0))) {
               var2 = true;
            } else {
               var2 = false;
            }
         } else {
            var2 = true;
         }
      }

      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public boolean a(boolean var1) {
      boolean var4 = true;
      boolean var3;
      if (this.j.isClosed() || this.j.isInputShutdown() || this.j.isOutputShutdown()) {
         var3 = false;
      } else if (this.m != null) {
         var3 = var4;
         if (this.m.d()) {
            var3 = false;
         }
      } else {
         var3 = var4;
         if (var1) {
            int var2;
            try {
               var2 = this.j.getSoTimeout();
            } catch (SocketTimeoutException var23) {
               var3 = var4;
               return var3;
            } catch (IOException var24) {
               var3 = false;
               return var3;
            }

            boolean var15 = false /* VF: Semaphore variable */;

            try {
               var15 = true;
               this.j.setSoTimeout(1);
               var1 = this.n.f();
               var15 = false;
            } finally {
               if (var15) {
                  try {
                     this.j.setSoTimeout(var2);
                  } catch (SocketTimeoutException var16) {
                     var3 = var4;
                     return var3;
                  } catch (IOException var17) {
                     var3 = false;
                     return var3;
                  }
               }
            }

            if (var1) {
               try {
                  this.j.setSoTimeout(var2);
               } catch (SocketTimeoutException var20) {
                  var3 = var4;
                  return var3;
               } catch (IOException var21) {
                  var3 = false;
                  return var3;
               }

               var3 = false;
            } else {
               try {
                  this.j.setSoTimeout(var2);
               } catch (SocketTimeoutException var18) {
                  var3 = var4;
                  return var3;
               } catch (IOException var19) {
                  var3 = false;
                  return var3;
               }

               var3 = var4;
            }
         }
      }

      return var3;
   }

   @Override
   public Protocol b() {
      return this.l;
   }

   public void c() {
      Util.a(this.i);
   }

   public Socket d() {
      return this.j;
   }

   public Handshake e() {
      return this.k;
   }

   public boolean f() {
      boolean var1;
      if (this.m != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public String toString() {
      StringBuilder var2 = new StringBuilder()
         .append("Connection{")
         .append(this.h.a().a().g())
         .append(":")
         .append(this.h.a().a().h())
         .append(", proxy=")
         .append(this.h.b())
         .append(" hostAddress=")
         .append(this.h.c())
         .append(" cipherSuite=");
      Object var1;
      if (this.k != null) {
         var1 = this.k.b();
      } else {
         var1 = "none";
      }

      return var2.append(var1).append(" protocol=").append(this.l).append('}').toString();
   }
}
