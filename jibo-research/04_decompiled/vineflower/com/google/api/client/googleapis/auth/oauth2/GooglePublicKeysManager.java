package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Beta
public class GooglePublicKeysManager {
   private static final Pattern MAX_AGE_PATTERN = Pattern.compile("\\s*max-age\\s*=\\s*(\\d+)\\s*");
   private static final long REFRESH_SKEW_MILLIS = 300000L;
   private final Clock clock;
   private long expirationTimeMilliseconds;
   private final JsonFactory jsonFactory;
   private final Lock lock = new ReentrantLock();
   private final String publicCertsEncodedUrl;
   private List<PublicKey> publicKeys;
   private final HttpTransport transport;

   protected GooglePublicKeysManager(GooglePublicKeysManager.Builder var1) {
      this.transport = var1.transport;
      this.jsonFactory = var1.jsonFactory;
      this.clock = var1.clock;
      this.publicCertsEncodedUrl = var1.publicCertsEncodedUrl;
   }

   public GooglePublicKeysManager(HttpTransport var1, JsonFactory var2) {
      this(new GooglePublicKeysManager.Builder(var1, var2));
   }

   long getCacheTimeInSec(HttpHeaders var1) {
      long var4;
      label25: {
         if (var1.getCacheControl() != null) {
            for (String var9 : var1.getCacheControl().split(",")) {
               Matcher var10 = MAX_AGE_PATTERN.matcher(var9);
               if (var10.matches()) {
                  var4 = Long.valueOf(var10.group(1));
                  break label25;
               }
            }
         }

         var4 = 0L;
      }

      long var6 = var4;
      if (var1.getAge() != null) {
         var6 = var4 - var1.getAge();
      }

      return Math.max(0L, var6);
   }

   public final Clock getClock() {
      return this.clock;
   }

   public final long getExpirationTimeMilliseconds() {
      return this.expirationTimeMilliseconds;
   }

   public final JsonFactory getJsonFactory() {
      return this.jsonFactory;
   }

   public final String getPublicCertsEncodedUrl() {
      return this.publicCertsEncodedUrl;
   }

   public final List<PublicKey> getPublicKeys() throws GeneralSecurityException, IOException {
      this.lock.lock();

      try {
         if (this.publicKeys == null || this.clock.currentTimeMillis() + 300000L > this.expirationTimeMilliseconds) {
            this.refresh();
         }

         return this.publicKeys;
      } finally {
         this.lock.unlock();
      }
   }

   public final HttpTransport getTransport() {
      return this.transport;
   }

   public GooglePublicKeysManager refresh() throws GeneralSecurityException, IOException {
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
      // 00: aload 0
      // 01: getfield com/google/api/client/googleapis/auth/oauth2/GooglePublicKeysManager.lock Ljava/util/concurrent/locks/Lock;
      // 04: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 09: new java/util/ArrayList
      // 0c: astore 2
      // 0d: aload 2
      // 0e: invokespecial java/util/ArrayList.<init> ()V
      // 11: aload 0
      // 12: aload 2
      // 13: putfield com/google/api/client/googleapis/auth/oauth2/GooglePublicKeysManager.publicKeys Ljava/util/List;
      // 16: invokestatic com/google/api/client/util/SecurityUtils.getX509CertificateFactory ()Ljava/security/cert/CertificateFactory;
      // 19: astore 4
      // 1b: aload 0
      // 1c: getfield com/google/api/client/googleapis/auth/oauth2/GooglePublicKeysManager.transport Lcom/google/api/client/http/HttpTransport;
      // 1f: invokevirtual com/google/api/client/http/HttpTransport.createRequestFactory ()Lcom/google/api/client/http/HttpRequestFactory;
      // 22: astore 2
      // 23: new com/google/api/client/http/GenericUrl
      // 26: astore 3
      // 27: aload 3
      // 28: aload 0
      // 29: getfield com/google/api/client/googleapis/auth/oauth2/GooglePublicKeysManager.publicCertsEncodedUrl Ljava/lang/String;
      // 2c: invokespecial com/google/api/client/http/GenericUrl.<init> (Ljava/lang/String;)V
      // 2f: aload 2
      // 30: aload 3
      // 31: invokevirtual com/google/api/client/http/HttpRequestFactory.buildGetRequest (Lcom/google/api/client/http/GenericUrl;)Lcom/google/api/client/http/HttpRequest;
      // 34: invokevirtual com/google/api/client/http/HttpRequest.execute ()Lcom/google/api/client/http/HttpResponse;
      // 37: astore 2
      // 38: aload 0
      // 39: aload 0
      // 3a: getfield com/google/api/client/googleapis/auth/oauth2/GooglePublicKeysManager.clock Lcom/google/api/client/util/Clock;
      // 3d: invokeinterface com/google/api/client/util/Clock.currentTimeMillis ()J 1
      // 42: aload 0
      // 43: aload 2
      // 44: invokevirtual com/google/api/client/http/HttpResponse.getHeaders ()Lcom/google/api/client/http/HttpHeaders;
      // 47: invokevirtual com/google/api/client/googleapis/auth/oauth2/GooglePublicKeysManager.getCacheTimeInSec (Lcom/google/api/client/http/HttpHeaders;)J
      // 4a: ldc2_w 1000
      // 4d: lmul
      // 4e: ladd
      // 4f: putfield com/google/api/client/googleapis/auth/oauth2/GooglePublicKeysManager.expirationTimeMilliseconds J
      // 52: aload 0
      // 53: getfield com/google/api/client/googleapis/auth/oauth2/GooglePublicKeysManager.jsonFactory Lcom/google/api/client/json/JsonFactory;
      // 56: aload 2
      // 57: invokevirtual com/google/api/client/http/HttpResponse.getContent ()Ljava/io/InputStream;
      // 5a: invokevirtual com/google/api/client/json/JsonFactory.createJsonParser (Ljava/io/InputStream;)Lcom/google/api/client/json/JsonParser;
      // 5d: astore 5
      // 5f: aload 5
      // 61: invokevirtual com/google/api/client/json/JsonParser.getCurrentToken ()Lcom/google/api/client/json/JsonToken;
      // 64: astore 3
      // 65: aload 3
      // 66: astore 2
      // 67: aload 3
      // 68: ifnonnull 71
      // 6b: aload 5
      // 6d: invokevirtual com/google/api/client/json/JsonParser.nextToken ()Lcom/google/api/client/json/JsonToken;
      // 70: astore 2
      // 71: aload 2
      // 72: getstatic com/google/api/client/json/JsonToken.START_OBJECT Lcom/google/api/client/json/JsonToken;
      // 75: if_acmpne d0
      // 78: bipush 1
      // 79: istore 1
      // 7a: iload 1
      // 7b: invokestatic com/google/api/client/util/Preconditions.checkArgument (Z)V
      // 7e: aload 5
      // 80: invokevirtual com/google/api/client/json/JsonParser.nextToken ()Lcom/google/api/client/json/JsonToken;
      // 83: getstatic com/google/api/client/json/JsonToken.END_OBJECT Lcom/google/api/client/json/JsonToken;
      // 86: if_acmpeq d5
      // 89: aload 5
      // 8b: invokevirtual com/google/api/client/json/JsonParser.nextToken ()Lcom/google/api/client/json/JsonToken;
      // 8e: pop
      // 8f: aload 5
      // 91: invokevirtual com/google/api/client/json/JsonParser.getText ()Ljava/lang/String;
      // 94: astore 3
      // 95: new java/io/ByteArrayInputStream
      // 98: astore 2
      // 99: aload 2
      // 9a: aload 3
      // 9b: invokestatic com/google/api/client/util/StringUtils.getBytesUtf8 (Ljava/lang/String;)[B
      // 9e: invokespecial java/io/ByteArrayInputStream.<init> ([B)V
      // a1: aload 4
      // a3: aload 2
      // a4: invokevirtual java/security/cert/CertificateFactory.generateCertificate (Ljava/io/InputStream;)Ljava/security/cert/Certificate;
      // a7: checkcast java/security/cert/X509Certificate
      // aa: astore 2
      // ab: aload 0
      // ac: getfield com/google/api/client/googleapis/auth/oauth2/GooglePublicKeysManager.publicKeys Ljava/util/List;
      // af: aload 2
      // b0: invokevirtual java/security/cert/X509Certificate.getPublicKey ()Ljava/security/PublicKey;
      // b3: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // b8: pop
      // b9: goto 7e
      // bc: astore 2
      // bd: aload 5
      // bf: invokevirtual com/google/api/client/json/JsonParser.close ()V
      // c2: aload 2
      // c3: athrow
      // c4: astore 2
      // c5: aload 0
      // c6: getfield com/google/api/client/googleapis/auth/oauth2/GooglePublicKeysManager.lock Ljava/util/concurrent/locks/Lock;
      // c9: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // ce: aload 2
      // cf: athrow
      // d0: bipush 0
      // d1: istore 1
      // d2: goto 7a
      // d5: aload 0
      // d6: aload 0
      // d7: getfield com/google/api/client/googleapis/auth/oauth2/GooglePublicKeysManager.publicKeys Ljava/util/List;
      // da: invokestatic java/util/Collections.unmodifiableList (Ljava/util/List;)Ljava/util/List;
      // dd: putfield com/google/api/client/googleapis/auth/oauth2/GooglePublicKeysManager.publicKeys Ljava/util/List;
      // e0: aload 5
      // e2: invokevirtual com/google/api/client/json/JsonParser.close ()V
      // e5: aload 0
      // e6: getfield com/google/api/client/googleapis/auth/oauth2/GooglePublicKeysManager.lock Ljava/util/concurrent/locks/Lock;
      // e9: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // ee: aload 0
      // ef: areturn
      // try (3 -> 48): 95 null
      // try (52 -> 55): 95 null
      // try (55 -> 58): 95 null
      // try (60 -> 62): 95 null
      // try (62 -> 89): 90 null
      // try (91 -> 95): 95 null
      // try (104 -> 109): 90 null
      // try (109 -> 111): 95 null
   }

   @Beta
   public static class Builder {
      Clock clock = Clock.SYSTEM;
      final JsonFactory jsonFactory;
      String publicCertsEncodedUrl = "https://www.googleapis.com/oauth2/v1/certs";
      final HttpTransport transport;

      public Builder(HttpTransport var1, JsonFactory var2) {
         this.transport = Preconditions.checkNotNull(var1);
         this.jsonFactory = Preconditions.checkNotNull(var2);
      }

      public GooglePublicKeysManager build() {
         return new GooglePublicKeysManager(this);
      }

      public final Clock getClock() {
         return this.clock;
      }

      public final JsonFactory getJsonFactory() {
         return this.jsonFactory;
      }

      public final String getPublicCertsEncodedUrl() {
         return this.publicCertsEncodedUrl;
      }

      public final HttpTransport getTransport() {
         return this.transport;
      }

      public GooglePublicKeysManager.Builder setClock(Clock var1) {
         this.clock = Preconditions.checkNotNull(var1);
         return this;
      }

      public GooglePublicKeysManager.Builder setPublicCertsEncodedUrl(String var1) {
         this.publicCertsEncodedUrl = Preconditions.checkNotNull(var1);
         return this;
      }
   }
}
