package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Lists;
import com.google.api.client.util.Objects;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Credential implements HttpExecuteInterceptor, HttpRequestInitializer, HttpUnsuccessfulResponseHandler {
   static final Logger LOGGER = Logger.getLogger(Credential.class.getName());
   private String accessToken;
   private final HttpExecuteInterceptor clientAuthentication;
   private final Clock clock;
   private Long expirationTimeMilliseconds;
   private final JsonFactory jsonFactory;
   private final Lock lock = new ReentrantLock();
   private final Credential.AccessMethod method;
   private final Collection<CredentialRefreshListener> refreshListeners;
   private String refreshToken;
   private final HttpRequestInitializer requestInitializer;
   private final String tokenServerEncodedUrl;
   private final HttpTransport transport;

   public Credential(Credential.AccessMethod var1) {
      this(new Credential.Builder(var1));
   }

   protected Credential(Credential.Builder var1) {
      this.method = Preconditions.checkNotNull(var1.method);
      this.transport = var1.transport;
      this.jsonFactory = var1.jsonFactory;
      String var2;
      if (var1.tokenServerUrl == null) {
         var2 = null;
      } else {
         var2 = var1.tokenServerUrl.build();
      }

      this.tokenServerEncodedUrl = var2;
      this.clientAuthentication = var1.clientAuthentication;
      this.requestInitializer = var1.requestInitializer;
      this.refreshListeners = Collections.unmodifiableCollection(var1.refreshListeners);
      this.clock = Preconditions.checkNotNull(var1.clock);
   }

   protected TokenResponse executeRefreshToken() throws IOException {
      TokenResponse var1;
      if (this.refreshToken == null) {
         var1 = null;
      } else {
         var1 = new RefreshTokenRequest(this.transport, this.jsonFactory, new GenericUrl(this.tokenServerEncodedUrl), this.refreshToken)
            .setClientAuthentication(this.clientAuthentication)
            .setRequestInitializer(this.requestInitializer)
            .execute();
      }

      return var1;
   }

   public final String getAccessToken() {
      this.lock.lock();

      try {
         return this.accessToken;
      } finally {
         this.lock.unlock();
      }
   }

   public final HttpExecuteInterceptor getClientAuthentication() {
      return this.clientAuthentication;
   }

   public final Clock getClock() {
      return this.clock;
   }

   public final Long getExpirationTimeMilliseconds() {
      this.lock.lock();

      try {
         return this.expirationTimeMilliseconds;
      } finally {
         this.lock.unlock();
      }
   }

   public final Long getExpiresInSeconds() {
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
      // 00: aload 0
      // 01: getfield com/google/api/client/auth/oauth2/Credential.lock Ljava/util/concurrent/locks/Lock;
      // 04: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 09: aload 0
      // 0a: getfield com/google/api/client/auth/oauth2/Credential.expirationTimeMilliseconds Ljava/lang/Long;
      // 0d: astore 3
      // 0e: aload 3
      // 0f: ifnonnull 1f
      // 12: aconst_null
      // 13: astore 3
      // 14: aload 0
      // 15: getfield com/google/api/client/auth/oauth2/Credential.lock Ljava/util/concurrent/locks/Lock;
      // 18: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 1d: aload 3
      // 1e: areturn
      // 1f: aload 0
      // 20: getfield com/google/api/client/auth/oauth2/Credential.expirationTimeMilliseconds Ljava/lang/Long;
      // 23: invokevirtual java/lang/Long.longValue ()J
      // 26: aload 0
      // 27: getfield com/google/api/client/auth/oauth2/Credential.clock Lcom/google/api/client/util/Clock;
      // 2a: invokeinterface com/google/api/client/util/Clock.currentTimeMillis ()J 1
      // 2f: lsub
      // 30: ldc2_w 1000
      // 33: ldiv
      // 34: lstore 1
      // 35: lload 1
      // 36: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 39: astore 3
      // 3a: aload 0
      // 3b: getfield com/google/api/client/auth/oauth2/Credential.lock Ljava/util/concurrent/locks/Lock;
      // 3e: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 43: goto 1d
      // 46: astore 3
      // 47: aload 0
      // 48: getfield com/google/api/client/auth/oauth2/Credential.lock Ljava/util/concurrent/locks/Lock;
      // 4b: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 50: aload 3
      // 51: athrow
      // try (3 -> 6): 32 null
      // try (15 -> 25): 32 null
   }

   public final JsonFactory getJsonFactory() {
      return this.jsonFactory;
   }

   public final Credential.AccessMethod getMethod() {
      return this.method;
   }

   public final Collection<CredentialRefreshListener> getRefreshListeners() {
      return this.refreshListeners;
   }

   public final String getRefreshToken() {
      this.lock.lock();

      try {
         return this.refreshToken;
      } finally {
         this.lock.unlock();
      }
   }

   public final HttpRequestInitializer getRequestInitializer() {
      return this.requestInitializer;
   }

   public final String getTokenServerEncodedUrl() {
      return this.tokenServerEncodedUrl;
   }

   public final HttpTransport getTransport() {
      return this.transport;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   public boolean handleResponse(HttpRequest var1, HttpResponse var2, boolean var3) {
      boolean var4;
      boolean var5;
      label108: {
         var5 = true;
         List var6 = var2.getHeaders().getAuthenticateAsList();
         if (var6 != null) {
            for (String var20 : var6) {
               if (var20.startsWith("Bearer ")) {
                  var3 = BearerToken.INVALID_TOKEN_ERROR.matcher(var20).find();
                  var4 = true;
                  break label108;
               }
            }
         }

         var4 = false;
         var3 = false;
      }

      if (!var4) {
         if (var2.getStatusCode() == 401) {
            var3 = true;
         } else {
            var3 = false;
         }
      }

      if (var3) {
         try {
            this.lock.lock();
         } catch (IOException var16) {
            LOGGER.log(Level.SEVERE, "unable to refresh token", var16);
            return false;
         }

         var3 = var5;
         boolean var12 = false /* VF: Semaphore variable */;

         label90: {
            try {
               var12 = true;
               if (!Objects.equal(this.accessToken, this.method.getAccessTokenFromRequest(var1))) {
                  var12 = false;
                  break label90;
               }

               var3 = this.refreshToken();
               var12 = false;
            } finally {
               if (var12) {
                  try {
                     this.lock.unlock();
                  } catch (IOException var13) {
                     LOGGER.log(Level.SEVERE, "unable to refresh token", var13);
                     return false;
                  }
               }
            }

            if (var3) {
               var3 = var5;
            } else {
               var3 = false;
            }
         }

         try {
            this.lock.unlock();
            return var3;
         } catch (IOException var14) {
            LOGGER.log(Level.SEVERE, "unable to refresh token", var14);
         }
      }

      return false;
   }

   @Override
   public void initialize(HttpRequest var1) throws IOException {
      var1.setInterceptor(this);
      var1.setUnsuccessfulResponseHandler(this);
   }

   @Override
   public void intercept(HttpRequest param1) throws IOException {
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
      // 01: getfield com/google/api/client/auth/oauth2/Credential.lock Ljava/util/concurrent/locks/Lock;
      // 04: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 09: aload 0
      // 0a: invokevirtual com/google/api/client/auth/oauth2/Credential.getExpiresInSeconds ()Ljava/lang/Long;
      // 0d: astore 2
      // 0e: aload 0
      // 0f: getfield com/google/api/client/auth/oauth2/Credential.accessToken Ljava/lang/String;
      // 12: ifnull 24
      // 15: aload 2
      // 16: ifnull 3c
      // 19: aload 2
      // 1a: invokevirtual java/lang/Long.longValue ()J
      // 1d: ldc2_w 60
      // 20: lcmp
      // 21: ifgt 3c
      // 24: aload 0
      // 25: invokevirtual com/google/api/client/auth/oauth2/Credential.refreshToken ()Z
      // 28: pop
      // 29: aload 0
      // 2a: getfield com/google/api/client/auth/oauth2/Credential.accessToken Ljava/lang/String;
      // 2d: astore 2
      // 2e: aload 2
      // 2f: ifnonnull 3c
      // 32: aload 0
      // 33: getfield com/google/api/client/auth/oauth2/Credential.lock Ljava/util/concurrent/locks/Lock;
      // 36: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 3b: return
      // 3c: aload 0
      // 3d: getfield com/google/api/client/auth/oauth2/Credential.method Lcom/google/api/client/auth/oauth2/Credential$AccessMethod;
      // 40: aload 1
      // 41: aload 0
      // 42: getfield com/google/api/client/auth/oauth2/Credential.accessToken Ljava/lang/String;
      // 45: invokeinterface com/google/api/client/auth/oauth2/Credential$AccessMethod.intercept (Lcom/google/api/client/http/HttpRequest;Ljava/lang/String;)V 3
      // 4a: aload 0
      // 4b: getfield com/google/api/client/auth/oauth2/Credential.lock Ljava/util/concurrent/locks/Lock;
      // 4e: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 53: goto 3b
      // 56: astore 1
      // 57: aload 0
      // 58: getfield com/google/api/client/auth/oauth2/Credential.lock Ljava/util/concurrent/locks/Lock;
      // 5b: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 60: aload 1
      // 61: athrow
      // try (3 -> 9): 38 null
      // try (11 -> 16): 38 null
      // try (16 -> 22): 38 null
      // try (28 -> 34): 38 null
   }

   public final boolean refreshToken() throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: bipush 1
      // 01: istore 1
      // 02: aload 0
      // 03: getfield com/google/api/client/auth/oauth2/Credential.lock Ljava/util/concurrent/locks/Lock;
      // 06: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 0b: aload 0
      // 0c: invokevirtual com/google/api/client/auth/oauth2/Credential.executeRefreshToken ()Lcom/google/api/client/auth/oauth2/TokenResponse;
      // 0f: astore 3
      // 10: aload 3
      // 11: ifnull bf
      // 14: aload 0
      // 15: aload 3
      // 16: invokevirtual com/google/api/client/auth/oauth2/Credential.setFromTokenResponse (Lcom/google/api/client/auth/oauth2/TokenResponse;)Lcom/google/api/client/auth/oauth2/Credential;
      // 19: pop
      // 1a: aload 0
      // 1b: getfield com/google/api/client/auth/oauth2/Credential.refreshListeners Ljava/util/Collection;
      // 1e: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 23: astore 4
      // 25: aload 4
      // 27: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 2c: ifeq a7
      // 2f: aload 4
      // 31: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 36: checkcast com/google/api/client/auth/oauth2/CredentialRefreshListener
      // 39: aload 0
      // 3a: aload 3
      // 3b: invokeinterface com/google/api/client/auth/oauth2/CredentialRefreshListener.onTokenResponse (Lcom/google/api/client/auth/oauth2/Credential;Lcom/google/api/client/auth/oauth2/TokenResponse;)V 3
      // 40: goto 25
      // 43: astore 3
      // 44: sipush 400
      // 47: aload 3
      // 48: invokevirtual com/google/api/client/auth/oauth2/TokenResponseException.getStatusCode ()I
      // 4b: if_icmpgt b4
      // 4e: aload 3
      // 4f: invokevirtual com/google/api/client/auth/oauth2/TokenResponseException.getStatusCode ()I
      // 52: sipush 500
      // 55: if_icmpge b4
      // 58: aload 3
      // 59: invokevirtual com/google/api/client/auth/oauth2/TokenResponseException.getDetails ()Lcom/google/api/client/auth/oauth2/TokenErrorResponse;
      // 5c: ifnull 6f
      // 5f: iload 1
      // 60: ifeq 6f
      // 63: aload 0
      // 64: aconst_null
      // 65: invokevirtual com/google/api/client/auth/oauth2/Credential.setAccessToken (Ljava/lang/String;)Lcom/google/api/client/auth/oauth2/Credential;
      // 68: pop
      // 69: aload 0
      // 6a: aconst_null
      // 6b: invokevirtual com/google/api/client/auth/oauth2/Credential.setExpiresInSeconds (Ljava/lang/Long;)Lcom/google/api/client/auth/oauth2/Credential;
      // 6e: pop
      // 6f: aload 0
      // 70: getfield com/google/api/client/auth/oauth2/Credential.refreshListeners Ljava/util/Collection;
      // 73: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 78: astore 4
      // 7a: aload 4
      // 7c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 81: ifeq b9
      // 84: aload 4
      // 86: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 8b: checkcast com/google/api/client/auth/oauth2/CredentialRefreshListener
      // 8e: aload 0
      // 8f: aload 3
      // 90: invokevirtual com/google/api/client/auth/oauth2/TokenResponseException.getDetails ()Lcom/google/api/client/auth/oauth2/TokenErrorResponse;
      // 93: invokeinterface com/google/api/client/auth/oauth2/CredentialRefreshListener.onTokenErrorResponse (Lcom/google/api/client/auth/oauth2/Credential;Lcom/google/api/client/auth/oauth2/TokenErrorResponse;)V 3
      // 98: goto 7a
      // 9b: astore 3
      // 9c: aload 0
      // 9d: getfield com/google/api/client/auth/oauth2/Credential.lock Ljava/util/concurrent/locks/Lock;
      // a0: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // a5: aload 3
      // a6: athrow
      // a7: aload 0
      // a8: getfield com/google/api/client/auth/oauth2/Credential.lock Ljava/util/concurrent/locks/Lock;
      // ab: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // b0: bipush 1
      // b1: istore 2
      // b2: iload 2
      // b3: ireturn
      // b4: bipush 0
      // b5: istore 1
      // b6: goto 58
      // b9: iload 1
      // ba: ifeq bf
      // bd: aload 3
      // be: athrow
      // bf: aload 0
      // c0: getfield com/google/api/client/auth/oauth2/Credential.lock Ljava/util/concurrent/locks/Lock;
      // c3: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // c8: bipush 0
      // c9: istore 2
      // ca: goto b2
      // try (5 -> 8): 28 com/google/api/client/auth/oauth2/TokenResponseException
      // try (5 -> 8): 65 null
      // try (10 -> 18): 28 com/google/api/client/auth/oauth2/TokenResponseException
      // try (10 -> 18): 65 null
      // try (18 -> 27): 28 com/google/api/client/auth/oauth2/TokenResponseException
      // try (18 -> 27): 65 null
      // try (29 -> 37): 65 null
      // try (37 -> 40): 65 null
      // try (42 -> 50): 65 null
      // try (50 -> 54): 65 null
      // try (54 -> 64): 65 null
      // try (83 -> 85): 65 null
   }

   public Credential setAccessToken(String var1) {
      this.lock.lock();

      try {
         this.accessToken = var1;
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public Credential setExpirationTimeMilliseconds(Long var1) {
      this.lock.lock();

      try {
         this.expirationTimeMilliseconds = var1;
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public Credential setExpiresInSeconds(Long var1) {
      if (var1 == null) {
         var1 = null;
      } else {
         var1 = this.clock.currentTimeMillis() + var1 * 1000L;
      }

      return this.setExpirationTimeMilliseconds(var1);
   }

   public Credential setFromTokenResponse(TokenResponse var1) {
      this.setAccessToken(var1.getAccessToken());
      if (var1.getRefreshToken() != null) {
         this.setRefreshToken(var1.getRefreshToken());
      }

      this.setExpiresInSeconds(var1.getExpiresInSeconds());
      return this;
   }

   public Credential setRefreshToken(String param1) {
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
      // 01: getfield com/google/api/client/auth/oauth2/Credential.lock Ljava/util/concurrent/locks/Lock;
      // 04: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 09: aload 1
      // 0a: ifnull 32
      // 0d: aload 0
      // 0e: getfield com/google/api/client/auth/oauth2/Credential.jsonFactory Lcom/google/api/client/json/JsonFactory;
      // 11: ifnull 42
      // 14: aload 0
      // 15: getfield com/google/api/client/auth/oauth2/Credential.transport Lcom/google/api/client/http/HttpTransport;
      // 18: ifnull 42
      // 1b: aload 0
      // 1c: getfield com/google/api/client/auth/oauth2/Credential.clientAuthentication Lcom/google/api/client/http/HttpExecuteInterceptor;
      // 1f: ifnull 42
      // 22: aload 0
      // 23: getfield com/google/api/client/auth/oauth2/Credential.tokenServerEncodedUrl Ljava/lang/String;
      // 26: ifnull 42
      // 29: bipush 1
      // 2a: istore 2
      // 2b: iload 2
      // 2c: ldc_w "Please use the Builder and call setJsonFactory, setTransport, setClientAuthentication and setTokenServerUrl/setTokenServerEncodedUrl"
      // 2f: invokestatic com/google/api/client/util/Preconditions.checkArgument (ZLjava/lang/Object;)V
      // 32: aload 0
      // 33: aload 1
      // 34: putfield com/google/api/client/auth/oauth2/Credential.refreshToken Ljava/lang/String;
      // 37: aload 0
      // 38: getfield com/google/api/client/auth/oauth2/Credential.lock Ljava/util/concurrent/locks/Lock;
      // 3b: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 40: aload 0
      // 41: areturn
      // 42: bipush 0
      // 43: istore 2
      // 44: goto 2b
      // 47: astore 1
      // 48: aload 0
      // 49: getfield com/google/api/client/auth/oauth2/Credential.lock Ljava/util/concurrent/locks/Lock;
      // 4c: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 51: aload 1
      // 52: athrow
      // try (5 -> 17): 33 null
      // try (19 -> 22): 33 null
      // try (22 -> 25): 33 null
   }

   public interface AccessMethod {
      String getAccessTokenFromRequest(HttpRequest var1);

      void intercept(HttpRequest var1, String var2) throws IOException;
   }

   public static class Builder {
      HttpExecuteInterceptor clientAuthentication;
      Clock clock = Clock.SYSTEM;
      JsonFactory jsonFactory;
      final Credential.AccessMethod method;
      Collection<CredentialRefreshListener> refreshListeners = Lists.newArrayList();
      HttpRequestInitializer requestInitializer;
      GenericUrl tokenServerUrl;
      HttpTransport transport;

      public Builder(Credential.AccessMethod var1) {
         this.method = Preconditions.checkNotNull(var1);
      }

      public Credential.Builder addRefreshListener(CredentialRefreshListener var1) {
         this.refreshListeners.add(Preconditions.checkNotNull(var1));
         return this;
      }

      public Credential build() {
         return new Credential(this);
      }

      public final HttpExecuteInterceptor getClientAuthentication() {
         return this.clientAuthentication;
      }

      public final Clock getClock() {
         return this.clock;
      }

      public final JsonFactory getJsonFactory() {
         return this.jsonFactory;
      }

      public final Credential.AccessMethod getMethod() {
         return this.method;
      }

      public final Collection<CredentialRefreshListener> getRefreshListeners() {
         return this.refreshListeners;
      }

      public final HttpRequestInitializer getRequestInitializer() {
         return this.requestInitializer;
      }

      public final GenericUrl getTokenServerUrl() {
         return this.tokenServerUrl;
      }

      public final HttpTransport getTransport() {
         return this.transport;
      }

      public Credential.Builder setClientAuthentication(HttpExecuteInterceptor var1) {
         this.clientAuthentication = var1;
         return this;
      }

      public Credential.Builder setClock(Clock var1) {
         this.clock = Preconditions.checkNotNull(var1);
         return this;
      }

      public Credential.Builder setJsonFactory(JsonFactory var1) {
         this.jsonFactory = var1;
         return this;
      }

      public Credential.Builder setRefreshListeners(Collection<CredentialRefreshListener> var1) {
         this.refreshListeners = Preconditions.checkNotNull(var1);
         return this;
      }

      public Credential.Builder setRequestInitializer(HttpRequestInitializer var1) {
         this.requestInitializer = var1;
         return this;
      }

      public Credential.Builder setTokenServerEncodedUrl(String var1) {
         GenericUrl var2;
         if (var1 == null) {
            var2 = null;
         } else {
            var2 = new GenericUrl(var1);
         }

         this.tokenServerUrl = var2;
         return this;
      }

      public Credential.Builder setTokenServerUrl(GenericUrl var1) {
         this.tokenServerUrl = var1;
         return this;
      }

      public Credential.Builder setTransport(HttpTransport var1) {
         this.transport = var1;
         return this;
      }
   }
}
