package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public final class Cache implements Closeable, Flushable {
   final InternalCache a = new InternalCache(this) {
      final Cache a;

      {
         this.a = var1;
      }

      @Override
      public Response a(Request var1) throws IOException {
         return this.a.a(var1);
      }

      @Override
      public CacheRequest a(Response var1) throws IOException {
         return this.a.a(var1);
      }

      @Override
      public void a() {
         this.a.a();
      }

      @Override
      public void a(Response var1, Response var2) {
         this.a.a(var1, var2);
      }

      @Override
      public void a(CacheStrategy var1) {
         this.a.a(var1);
      }

      @Override
      public void b(Request var1) throws IOException {
         this.a.b(var1);
      }
   };
   final DiskLruCache b;
   int c;
   int d;
   private int e;
   private int f;
   private int g;

   public Cache(File var1, long var2) {
      this(var1, var2, FileSystem.a);
   }

   Cache(File var1, long var2, FileSystem var4) {
      this.b = DiskLruCache.a(var4, var1, 201105, 2, var2);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   static int a(BufferedSource var0) throws IOException {
      long var1;
      try {
         var1 = var0.n();
         var8 = var0.r();
      } catch (NumberFormatException var6) {
         throw new IOException(var6.getMessage());
      }

      if (var1 >= 0L && var1 <= 2147483647L) {
         try {
            if (var8.isEmpty()) {
               return (int)var1;
            }
         } catch (NumberFormatException var7) {
            throw new IOException(var7.getMessage());
         }
      }

      try {
         StringBuilder var3 = new StringBuilder();
         IOException var4 = new IOException(var3.append("expected an int but was \"").append(var1).append(var8).append("\"").toString());
         throw var4;
      } catch (NumberFormatException var5) {
         throw new IOException(var5.getMessage());
      }
   }

   public static String a(HttpUrl var0) {
      return ByteString.a(var0.toString()).c().f();
   }

   private void a(DiskLruCache.Editor var1) {
      if (var1 != null) {
         try {
            var1.c();
         } catch (IOException var2) {
         }
      }
   }

   Response a(Request var1) {
      Object var2 = null;
      String var3 = a(var1.a());

      try {
         var8 = this.b.a(var3);
      } catch (IOException var6) {
         return (Response)var2;
      }

      Response var7;
      if (var8 == null) {
         var7 = (Response)var2;
      } else {
         Cache.Entry var4;
         try {
            var4 = new Cache.Entry(var8.a(0));
         } catch (IOException var5) {
            Util.a(var8);
            Object var10 = var2;
            return (Response)var10;
         }

         Response var9 = var4.a(var8);
         if (!var4.a(var1, var9)) {
            Util.a(var9.h());
            var7 = (Response)var2;
         } else {
            var7 = var9;
         }
      }

      return var7;
   }

   CacheRequest a(Response var1) {
      Object var3 = null;
      String var4 = var1.a().b();
      Object var2;
      if (HttpMethod.a(var1.a().b())) {
         try {
            this.b(var1.a());
         } catch (IOException var7) {
            return (CacheRequest)var3;
         }

         var2 = (CacheRequest)var3;
      } else {
         var2 = (CacheRequest)var3;
         if (var4.equals("GET")) {
            var2 = (CacheRequest)var3;
            if (!HttpHeaders.b(var1)) {
               Cache.Entry var9 = new Cache.Entry(var1);

               label41: {
                  try {
                     var8 = this.b.b(a(var1.a().a()));
                  } catch (IOException var6) {
                     var8 = null;
                     break label41;
                  }

                  var2 = var3;
                  if (var8 == null) {
                     return (CacheRequest)var2;
                  }

                  try {
                     var9.a(var8);
                     var2 = new Cache.CacheRequestImpl(this, var8);
                     return var2;
                  } catch (IOException var5) {
                  }
               }

               this.a(var8);
               var2 = (CacheRequest)var3;
            }
         }
      }

      return var2;
   }

   void a() {
      synchronized (this) {
         this.f++;
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   void a(Response var1, Response var2) {
      Cache.Entry var3 = new Cache.Entry(var2);
      DiskLruCache.Snapshot var10 = ((Cache.CacheResponseBody)var1.h()).a;
      DiskLruCache.Editor var7 = null;

      try {
         var11 = var10.a();
      } catch (IOException var6) {
         this.a(var7);
         return;
      }

      if (var11 != null) {
         var7 = var11;

         try {
            var3.a(var11);
         } catch (IOException var5) {
            this.a(var7);
            return;
         }

         var7 = var11;

         try {
            var11.b();
         } catch (IOException var4) {
            this.a(var7);
         }
      }
   }

   void a(CacheStrategy var1) {
      synchronized (this) {
         this.g++;
         if (var1.a != null) {
            this.e++;
         } else if (var1.b != null) {
            this.f++;
         }
      }
   }

   void b(Request var1) throws IOException {
      this.b.c(a(var1.a()));
   }

   @Override
   public void close() throws IOException {
      this.b.close();
   }

   @Override
   public void flush() throws IOException {
      this.b.flush();
   }

// $VF: Couldn't be decompiled
// Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
// java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.modules.decompiler.stats.Statement.getVarDefinitions()" because "stat" is null
//   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarDefinitionHelper.iterateClashingNames(VarDefinitionHelper.java:1592)
//   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarDefinitionHelper.iterateClashingExprent(VarDefinitionHelper.java:1891)
//   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarDefinitionHelper.iterateClashingExprent(VarDefinitionHelper.java:2029)
//   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarDefinitionHelper.iterateClashingNames(VarDefinitionHelper.java:1619)
//   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarDefinitionHelper.iterateClashingNames(VarDefinitionHelper.java:1739)
//   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarDefinitionHelper.remapClashingNames(VarDefinitionHelper.java:1584)
//   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarProcessor.rerunClashing(VarProcessor.java:99)
//   at org.jetbrains.java.decompiler.main.ClassWriter.invokeProcessors(ClassWriter.java:145)
//   at org.jetbrains.java.decompiler.main.ClassWriter.writeClass(ClassWriter.java:379)
//   at org.jetbrains.java.decompiler.main.ClassWriter.writeClass(ClassWriter.java:520)
//   at org.jetbrains.java.decompiler.main.ClassesProcessor.writeClass(ClassesProcessor.java:521)
//   at org.jetbrains.java.decompiler.main.Fernflower.getClassContent(Fernflower.java:200)
//   at org.jetbrains.java.decompiler.struct.ContextUnit.lambda$save$3(ContextUnit.java:221)

   private static class CacheResponseBody extends ResponseBody {
      final DiskLruCache.Snapshot a;
      private final BufferedSource b;
      private final String c;
      private final String d;

      CacheResponseBody(DiskLruCache.Snapshot var1, String var2, String var3) {
         this.a = var1;
         this.c = var2;
         this.d = var3;
         this.b = Okio.a(new ForwardingSource(this, var1.a(1), var1) {
            final DiskLruCache.Snapshot a;
            final Cache.CacheResponseBody b;

            {
               this.b = var1;
               this.a = var3x;
            }

            @Override
            public void close() throws IOException {
               this.a.close();
               super.close();
            }
         });
      }

      @Override
      public MediaType a() {
         MediaType var1;
         if (this.c != null) {
            var1 = MediaType.a(this.c);
         } else {
            var1 = null;
         }

         return var1;
      }

      @Override
      public long b() {
         long var3 = -1L;
         long var1 = var3;

         try {
            if (this.d != null) {
               var1 = Long.parseLong(this.d);
            }
         } catch (NumberFormatException var6) {
            var1 = var3;
         }

         return var1;
      }

      @Override
      public BufferedSource c() {
         return this.b;
      }
   }

   private static final class Entry {
      private static final String a = Platform.b().c() + "-Sent-Millis";
      private static final String b = Platform.b().c() + "-Received-Millis";
      private final String c;
      private final Headers d;
      private final String e;
      private final Protocol f;
      private final int g;
      private final String h;
      private final Headers i;
      private final Handshake j;
      private final long k;
      private final long l;

      Entry(Response var1) {
         this.c = var1.a().a().toString();
         this.d = HttpHeaders.c(var1);
         this.e = var1.a().b();
         this.f = var1.b();
         this.g = var1.c();
         this.h = var1.e();
         this.i = var1.g();
         this.j = var1.f();
         this.k = var1.l();
         this.l = var1.m();
      }

      Entry(Source param1) throws IOException {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
         //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
         //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
         //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
         //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
         //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
         //
         // Bytecode:
         // 000: lconst_0
         // 001: lstore 7
         // 003: bipush 0
         // 004: istore 3
         // 005: aload 0
         // 006: invokespecial java/lang/Object.<init> ()V
         // 009: aload 1
         // 00a: invokestatic okio/Okio.a (Lokio/Source;)Lokio/BufferedSource;
         // 00d: astore 9
         // 00f: aload 0
         // 010: aload 9
         // 012: invokeinterface okio/BufferedSource.r ()Ljava/lang/String; 1
         // 017: putfield okhttp3/Cache$Entry.c Ljava/lang/String;
         // 01a: aload 0
         // 01b: aload 9
         // 01d: invokeinterface okio/BufferedSource.r ()Ljava/lang/String; 1
         // 022: putfield okhttp3/Cache$Entry.e Ljava/lang/String;
         // 025: new okhttp3/Headers$Builder
         // 028: astore 10
         // 02a: aload 10
         // 02c: invokespecial okhttp3/Headers$Builder.<init> ()V
         // 02f: aload 9
         // 031: invokestatic okhttp3/Cache.a (Lokio/BufferedSource;)I
         // 034: istore 4
         // 036: bipush 0
         // 037: istore 2
         // 038: iload 2
         // 039: iload 4
         // 03b: if_icmpge 051
         // 03e: aload 10
         // 040: aload 9
         // 042: invokeinterface okio/BufferedSource.r ()Ljava/lang/String; 1
         // 047: invokevirtual okhttp3/Headers$Builder.a (Ljava/lang/String;)Lokhttp3/Headers$Builder;
         // 04a: pop
         // 04b: iinc 2 1
         // 04e: goto 038
         // 051: aload 0
         // 052: aload 10
         // 054: invokevirtual okhttp3/Headers$Builder.a ()Lokhttp3/Headers;
         // 057: putfield okhttp3/Cache$Entry.d Lokhttp3/Headers;
         // 05a: aload 9
         // 05c: invokeinterface okio/BufferedSource.r ()Ljava/lang/String; 1
         // 061: invokestatic okhttp3/internal/http/StatusLine.a (Ljava/lang/String;)Lokhttp3/internal/http/StatusLine;
         // 064: astore 10
         // 066: aload 0
         // 067: aload 10
         // 069: getfield okhttp3/internal/http/StatusLine.a Lokhttp3/Protocol;
         // 06c: putfield okhttp3/Cache$Entry.f Lokhttp3/Protocol;
         // 06f: aload 0
         // 070: aload 10
         // 072: getfield okhttp3/internal/http/StatusLine.b I
         // 075: putfield okhttp3/Cache$Entry.g I
         // 078: aload 0
         // 079: aload 10
         // 07b: getfield okhttp3/internal/http/StatusLine.c Ljava/lang/String;
         // 07e: putfield okhttp3/Cache$Entry.h Ljava/lang/String;
         // 081: new okhttp3/Headers$Builder
         // 084: astore 10
         // 086: aload 10
         // 088: invokespecial okhttp3/Headers$Builder.<init> ()V
         // 08b: aload 9
         // 08d: invokestatic okhttp3/Cache.a (Lokio/BufferedSource;)I
         // 090: istore 4
         // 092: iload 3
         // 093: istore 2
         // 094: iload 2
         // 095: iload 4
         // 097: if_icmpge 0ad
         // 09a: aload 10
         // 09c: aload 9
         // 09e: invokeinterface okio/BufferedSource.r ()Ljava/lang/String; 1
         // 0a3: invokevirtual okhttp3/Headers$Builder.a (Ljava/lang/String;)Lokhttp3/Headers$Builder;
         // 0a6: pop
         // 0a7: iinc 2 1
         // 0aa: goto 094
         // 0ad: aload 10
         // 0af: getstatic okhttp3/Cache$Entry.a Ljava/lang/String;
         // 0b2: invokevirtual okhttp3/Headers$Builder.c (Ljava/lang/String;)Ljava/lang/String;
         // 0b5: astore 12
         // 0b7: aload 10
         // 0b9: getstatic okhttp3/Cache$Entry.b Ljava/lang/String;
         // 0bc: invokevirtual okhttp3/Headers$Builder.c (Ljava/lang/String;)Ljava/lang/String;
         // 0bf: astore 11
         // 0c1: aload 10
         // 0c3: getstatic okhttp3/Cache$Entry.a Ljava/lang/String;
         // 0c6: invokevirtual okhttp3/Headers$Builder.b (Ljava/lang/String;)Lokhttp3/Headers$Builder;
         // 0c9: pop
         // 0ca: aload 10
         // 0cc: getstatic okhttp3/Cache$Entry.b Ljava/lang/String;
         // 0cf: invokevirtual okhttp3/Headers$Builder.b (Ljava/lang/String;)Lokhttp3/Headers$Builder;
         // 0d2: pop
         // 0d3: aload 12
         // 0d5: ifnull 152
         // 0d8: aload 12
         // 0da: invokestatic java/lang/Long.parseLong (Ljava/lang/String;)J
         // 0dd: lstore 5
         // 0df: aload 0
         // 0e0: lload 5
         // 0e2: putfield okhttp3/Cache$Entry.k J
         // 0e5: lload 7
         // 0e7: lstore 5
         // 0e9: aload 11
         // 0eb: ifnull 0f5
         // 0ee: aload 11
         // 0f0: invokestatic java/lang/Long.parseLong (Ljava/lang/String;)J
         // 0f3: lstore 5
         // 0f5: aload 0
         // 0f6: lload 5
         // 0f8: putfield okhttp3/Cache$Entry.l J
         // 0fb: aload 0
         // 0fc: aload 10
         // 0fe: invokevirtual okhttp3/Headers$Builder.a ()Lokhttp3/Headers;
         // 101: putfield okhttp3/Cache$Entry.i Lokhttp3/Headers;
         // 104: aload 0
         // 105: invokespecial okhttp3/Cache$Entry.a ()Z
         // 108: ifeq 1a8
         // 10b: aload 9
         // 10d: invokeinterface okio/BufferedSource.r ()Ljava/lang/String; 1
         // 112: astore 10
         // 114: aload 10
         // 116: invokevirtual java/lang/String.length ()I
         // 119: ifle 158
         // 11c: new java/io/IOException
         // 11f: astore 11
         // 121: new java/lang/StringBuilder
         // 124: astore 9
         // 126: aload 9
         // 128: invokespecial java/lang/StringBuilder.<init> ()V
         // 12b: aload 11
         // 12d: aload 9
         // 12f: ldc "expected \"\" but was \""
         // 131: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 134: aload 10
         // 136: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 139: ldc "\""
         // 13b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 13e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
         // 141: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
         // 144: aload 11
         // 146: athrow
         // 147: astore 9
         // 149: aload 1
         // 14a: invokeinterface okio/Source.close ()V 1
         // 14f: aload 9
         // 151: athrow
         // 152: lconst_0
         // 153: lstore 5
         // 155: goto 0df
         // 158: aload 9
         // 15a: invokeinterface okio/BufferedSource.r ()Ljava/lang/String; 1
         // 15f: invokestatic okhttp3/CipherSuite.a (Ljava/lang/String;)Lokhttp3/CipherSuite;
         // 162: astore 10
         // 164: aload 0
         // 165: aload 9
         // 167: invokespecial okhttp3/Cache$Entry.a (Lokio/BufferedSource;)Ljava/util/List;
         // 16a: astore 11
         // 16c: aload 0
         // 16d: aload 9
         // 16f: invokespecial okhttp3/Cache$Entry.a (Lokio/BufferedSource;)Ljava/util/List;
         // 172: astore 12
         // 174: aload 9
         // 176: invokeinterface okio/BufferedSource.f ()Z 1
         // 17b: ifne 1a0
         // 17e: aload 9
         // 180: invokeinterface okio/BufferedSource.r ()Ljava/lang/String; 1
         // 185: invokestatic okhttp3/TlsVersion.forJavaName (Ljava/lang/String;)Lokhttp3/TlsVersion;
         // 188: astore 9
         // 18a: aload 0
         // 18b: aload 9
         // 18d: aload 10
         // 18f: aload 11
         // 191: aload 12
         // 193: invokestatic okhttp3/Handshake.a (Lokhttp3/TlsVersion;Lokhttp3/CipherSuite;Ljava/util/List;Ljava/util/List;)Lokhttp3/Handshake;
         // 196: putfield okhttp3/Cache$Entry.j Lokhttp3/Handshake;
         // 199: aload 1
         // 19a: invokeinterface okio/Source.close ()V 1
         // 19f: return
         // 1a0: getstatic okhttp3/TlsVersion.SSL_3_0 Lokhttp3/TlsVersion;
         // 1a3: astore 9
         // 1a5: goto 18a
         // 1a8: aload 0
         // 1a9: aconst_null
         // 1aa: putfield okhttp3/Cache$Entry.j Lokhttp3/Handshake;
         // 1ad: goto 199
         // try (6 -> 24): 140 null
         // try (29 -> 34): 140 null
         // try (36 -> 63): 140 null
         // try (68 -> 73): 140 null
         // try (75 -> 91): 140 null
         // try (93 -> 96): 140 null
         // try (96 -> 99): 140 null
         // try (103 -> 106): 140 null
         // try (106 -> 140): 140 null
         // try (148 -> 167): 140 null
         // try (167 -> 174): 140 null
         // try (177 -> 179): 140 null
         // try (180 -> 183): 140 null
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      private List<Certificate> a(BufferedSource var1) throws IOException {
         int var3 = Cache.a(var1);
         List var4;
         if (var3 == -1) {
            var4 = Collections.emptyList();
         } else {
            ArrayList var5;
            CertificateFactory var6;
            try {
               var6 = CertificateFactory.getInstance("X.509");
               var5 = new ArrayList(var3);
            } catch (CertificateException var9) {
               throw new IOException(var9.getMessage());
            }

            int var2 = 0;

            while (true) {
               var4 = var5;
               if (var2 >= var3) {
                  break;
               }

               try {
                  String var10 = var1.r();
                  Buffer var7 = new Buffer();
                  var7.a(ByteString.b(var10));
                  var5.add(var6.generateCertificate(var7.g()));
               } catch (CertificateException var8) {
                  throw new IOException(var8.getMessage());
               }

               var2++;
            }
         }

         return var4;
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      private void a(BufferedSink var1, List<Certificate> var2) throws IOException {
         int var4;
         try {
            var1.m(var2.size()).k(10);
            var4 = var2.size();
         } catch (CertificateEncodingException var6) {
            throw new IOException(var6.getMessage());
         }

         for (int var3 = 0; var3 < var4; var3++) {
            try {
               var1.b(ByteString.a(((Certificate)var2.get(var3)).getEncoded()).b()).k(10);
            } catch (CertificateEncodingException var5) {
               throw new IOException(var5.getMessage());
            }
         }
      }

      private boolean a() {
         return this.c.startsWith("https://");
      }

      public Response a(DiskLruCache.Snapshot var1) {
         String var2 = this.i.a("Content-Type");
         String var3 = this.i.a("Content-Length");
         Request var4 = new Request.Builder().a(this.c).a(this.e, (RequestBody)null).a(this.d).c();
         return new Response.Builder()
            .a(var4)
            .a(this.f)
            .a(this.g)
            .a(this.h)
            .a(this.i)
            .a(new Cache.CacheResponseBody(var1, var2, var3))
            .a(this.j)
            .a(this.k)
            .b(this.l)
            .a();
      }

      public void a(DiskLruCache.Editor var1) throws IOException {
         byte var3 = 0;
         BufferedSink var5 = Okio.a(var1.a(0));
         var5.b(this.c).k(10);
         var5.b(this.e).k(10);
         var5.m(this.d.a()).k(10);
         int var4 = this.d.a();

         for (int var2 = 0; var2 < var4; var2++) {
            var5.b(this.d.a(var2)).b(": ").b(this.d.b(var2)).k(10);
         }

         var5.b(new StatusLine(this.f, this.g, this.h).toString()).k(10);
         var5.m(this.i.a() + 2).k(10);
         var4 = this.i.a();

         for (int var6 = var3; var6 < var4; var6++) {
            var5.b(this.i.a(var6)).b(": ").b(this.i.b(var6)).k(10);
         }

         var5.b(a).b(": ").m(this.k).k(10);
         var5.b(b).b(": ").m(this.l).k(10);
         if (this.a()) {
            var5.k(10);
            var5.b(this.j.b().a()).k(10);
            this.a(var5, this.j.c());
            this.a(var5, this.j.d());
            var5.b(this.j.a().javaName()).k(10);
         }

         var5.close();
      }

      public boolean a(Request var1, Response var2) {
         boolean var3;
         if (this.c.equals(var1.a().toString()) && this.e.equals(var1.b()) && HttpHeaders.a(var2, this.d, var1)) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }
   }
}
