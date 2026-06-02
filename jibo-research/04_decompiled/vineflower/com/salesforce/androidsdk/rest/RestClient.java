package com.salesforce.androidsdk.rest;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.auth.HttpAccess;
import com.salesforce.androidsdk.auth.OAuth2;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestClient {
   private static Map<String, RestClient.OAuthRefreshInterceptor> a = new HashMap<>();
   private static Map<String, OkHttpClient.Builder> b = new HashMap<>();
   private static Map<String, OkHttpClient> c = new HashMap<>();
   private RestClient.ClientInfo d;
   private HttpAccess e;
   private RestClient.AuthTokenProvider f;
   private RestClient.OAuthRefreshInterceptor g;
   private OkHttpClient.Builder h;
   private OkHttpClient i;

   public RestClient(RestClient.ClientInfo var1, String var2, HttpAccess var3, RestClient.AuthTokenProvider var4) {
      this.d = var1;
      this.e = var3;
      this.f = var4;
      this.a(var2);
      this.f();
      this.a((OkHttpClient)null);
   }

   private static String a(String var0, String var1) {
      if (var0 != null && var1 != null) {
         var0 = var0 + "-" + var1;
      } else {
         var0 = "unauthenticated";
      }

      return var0;
   }

   public static void a(UserAccount param0) {
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
      // 00: aconst_null
      // 01: astore 2
      // 02: ldc com/salesforce/androidsdk/rest/RestClient
      // 04: monitorenter
      // 05: aload 0
      // 06: ifnull 4d
      // 09: aload 0
      // 0a: invokevirtual com/salesforce/androidsdk/accounts/UserAccount.f ()Ljava/lang/String;
      // 0d: astore 1
      // 0e: aload 0
      // 0f: ifnull 17
      // 12: aload 0
      // 13: invokevirtual com/salesforce/androidsdk/accounts/UserAccount.g ()Ljava/lang/String;
      // 16: astore 2
      // 17: aload 1
      // 18: aload 2
      // 19: invokestatic com/salesforce/androidsdk/rest/RestClient.a (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 1c: astore 0
      // 1d: getstatic com/salesforce/androidsdk/rest/RestClient.a Ljava/util/Map;
      // 20: aload 0
      // 21: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 26: pop
      // 27: getstatic com/salesforce/androidsdk/rest/RestClient.b Ljava/util/Map;
      // 2a: aload 0
      // 2b: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 30: pop
      // 31: getstatic com/salesforce/androidsdk/rest/RestClient.c Ljava/util/Map;
      // 34: aload 0
      // 35: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 3a: checkcast okhttp3/OkHttpClient
      // 3d: astore 0
      // 3e: aload 0
      // 3f: ifnull 49
      // 42: aload 0
      // 43: invokevirtual okhttp3/OkHttpClient.s ()Lokhttp3/Dispatcher;
      // 46: invokevirtual okhttp3/Dispatcher.b ()V
      // 49: ldc com/salesforce/androidsdk/rest/RestClient
      // 4b: monitorexit
      // 4c: return
      // 4d: aconst_null
      // 4e: astore 1
      // 4f: goto 0e
      // 52: astore 0
      // 53: ldc com/salesforce/androidsdk/rest/RestClient
      // 55: monitorexit
      // 56: aload 0
      // 57: athrow
      // try (6 -> 9): 42 null
      // try (11 -> 14): 42 null
      // try (14 -> 31): 42 null
      // try (33 -> 36): 42 null
   }

   private void a(String param1) {
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
      // 01: monitorenter
      // 02: aload 0
      // 03: invokespecial com/salesforce/androidsdk/rest/RestClient.e ()Ljava/lang/String;
      // 06: astore 4
      // 08: getstatic com/salesforce/androidsdk/rest/RestClient.a Ljava/util/Map;
      // 0b: aload 4
      // 0d: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 12: checkcast com/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor
      // 15: astore 3
      // 16: aload 3
      // 17: astore 2
      // 18: aload 3
      // 19: ifnonnull 39
      // 1c: new com/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor
      // 1f: astore 2
      // 20: aload 2
      // 21: aload 0
      // 22: getfield com/salesforce/androidsdk/rest/RestClient.d Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;
      // 25: aload 1
      // 26: aload 0
      // 27: getfield com/salesforce/androidsdk/rest/RestClient.f Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;
      // 2a: invokespecial com/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor.<init> (Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;Ljava/lang/String;Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;)V
      // 2d: getstatic com/salesforce/androidsdk/rest/RestClient.a Ljava/util/Map;
      // 30: aload 4
      // 32: aload 2
      // 33: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 38: pop
      // 39: aload 0
      // 3a: aload 2
      // 3b: putfield com/salesforce/androidsdk/rest/RestClient.g Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;
      // 3e: aload 0
      // 3f: monitorexit
      // 40: return
      // 41: astore 1
      // 42: aload 0
      // 43: monitorexit
      // 44: aload 1
      // 45: athrow
      // try (2 -> 10): 34 null
      // try (14 -> 28): 34 null
      // try (28 -> 31): 34 null
   }

   private String e() {
      return a(this.d.h, this.d.g);
   }

   private void f() {
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
      // 01: monitorenter
      // 02: aload 0
      // 03: invokespecial com/salesforce/androidsdk/rest/RestClient.e ()Ljava/lang/String;
      // 06: astore 1
      // 07: getstatic com/salesforce/androidsdk/rest/RestClient.b Ljava/util/Map;
      // 0a: aload 1
      // 0b: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 10: checkcast okhttp3/OkHttpClient$Builder
      // 13: astore 2
      // 14: aload 2
      // 15: astore 1
      // 16: aload 2
      // 17: ifnonnull 37
      // 1a: aload 0
      // 1b: getfield com/salesforce/androidsdk/rest/RestClient.e Lcom/salesforce/androidsdk/auth/HttpAccess;
      // 1e: invokevirtual com/salesforce/androidsdk/auth/HttpAccess.a ()Lokhttp3/OkHttpClient$Builder;
      // 21: aload 0
      // 22: invokevirtual com/salesforce/androidsdk/rest/RestClient.b ()Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;
      // 25: invokevirtual okhttp3/OkHttpClient$Builder.a (Lokhttp3/Interceptor;)Lokhttp3/OkHttpClient$Builder;
      // 28: astore 1
      // 29: getstatic com/salesforce/androidsdk/rest/RestClient.b Ljava/util/Map;
      // 2c: aload 0
      // 2d: invokespecial com/salesforce/androidsdk/rest/RestClient.e ()Ljava/lang/String;
      // 30: aload 1
      // 31: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 36: pop
      // 37: aload 0
      // 38: aload 1
      // 39: putfield com/salesforce/androidsdk/rest/RestClient.h Lokhttp3/OkHttpClient$Builder;
      // 3c: aload 0
      // 3d: monitorexit
      // 3e: return
      // 3f: astore 1
      // 40: aload 0
      // 41: monitorexit
      // 42: aload 1
      // 43: athrow
      // try (2 -> 10): 33 null
      // try (14 -> 27): 33 null
      // try (27 -> 30): 33 null
   }

   public String a() {
      synchronized (this) {
         return this.g.a();
      }
   }

   public Request a(RestRequest var1) {
      Request.Builder var2 = new Request.Builder().a(HttpUrl.a(this.g.c.a(var1.b()))).a(var1.a().toString(), var1.c());
      Map var4 = var1.e();
      if (var4 != null) {
         for (Entry var5 : var4.entrySet()) {
            var2.b((String)var5.getKey(), (String)var5.getValue());
         }
      }

      return var2.c();
   }

   public void a(OkHttpClient param1) {
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
      // 01: monitorenter
      // 02: aload 0
      // 03: invokespecial com/salesforce/androidsdk/rest/RestClient.e ()Ljava/lang/String;
      // 06: astore 3
      // 07: aload 1
      // 08: ifnull 16
      // 0b: getstatic com/salesforce/androidsdk/rest/RestClient.c Ljava/util/Map;
      // 0e: aload 3
      // 0f: aload 1
      // 10: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 15: pop
      // 16: getstatic com/salesforce/androidsdk/rest/RestClient.c Ljava/util/Map;
      // 19: aload 3
      // 1a: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 1f: checkcast okhttp3/OkHttpClient
      // 22: astore 2
      // 23: aload 2
      // 24: astore 1
      // 25: aload 2
      // 26: ifnonnull 3c
      // 29: aload 0
      // 2a: invokevirtual com/salesforce/androidsdk/rest/RestClient.c ()Lokhttp3/OkHttpClient$Builder;
      // 2d: invokevirtual okhttp3/OkHttpClient$Builder.a ()Lokhttp3/OkHttpClient;
      // 30: astore 1
      // 31: getstatic com/salesforce/androidsdk/rest/RestClient.c Ljava/util/Map;
      // 34: aload 3
      // 35: aload 1
      // 36: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 3b: pop
      // 3c: aload 0
      // 3d: aload 1
      // 3e: putfield com/salesforce/androidsdk/rest/RestClient.i Lokhttp3/OkHttpClient;
      // 41: aload 0
      // 42: monitorexit
      // 43: return
      // 44: astore 1
      // 45: aload 0
      // 46: monitorexit
      // 47: aload 1
      // 48: athrow
      // try (2 -> 5): 36 null
      // try (7 -> 12): 36 null
      // try (12 -> 17): 36 null
      // try (21 -> 30): 36 null
      // try (30 -> 33): 36 null
   }

   public RestClient.OAuthRefreshInterceptor b() {
      return this.g;
   }

   public RestResponse b(RestRequest var1) throws IOException {
      Request var2 = this.a(var1);
      return new RestResponse(FirebasePerfOkHttpClient.execute(this.i.a(var2)));
   }

   public OkHttpClient.Builder c() {
      return this.h;
   }

   public OkHttpClient d() {
      return this.i;
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("RestClient: {\n").append(this.g.c.toString()).append("   timeSinceLastRefresh: ").append(this.g.b()).append("\n").append("}\n");
      return var1.toString();
   }

   public interface AuthTokenProvider {
      String a();

      long b();

      String c();
   }

   public static class ClientInfo {
      public final String a;
      public final URI b;
      public final URI c;
      public final URI d;
      public final String e;
      public final String f;
      public final String g;
      public final String h;
      public final String i;
      public final String j;
      public final String k;
      public final String l;
      public final String m;
      public final String n;
      public final String o;
      public final String p;
      public final Map<String, String> q;

      public ClientInfo(
         String var1,
         URI var2,
         URI var3,
         URI var4,
         String var5,
         String var6,
         String var7,
         String var8,
         String var9,
         String var10,
         String var11,
         String var12,
         String var13,
         String var14,
         String var15,
         String var16,
         Map<String, String> var17
      ) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
         this.f = var6;
         this.g = var7;
         this.h = var8;
         this.i = var9;
         this.j = var10;
         this.k = var11;
         this.l = var12;
         this.m = var13;
         this.n = var14;
         this.o = var15;
         this.p = var16;
         this.q = var17;
      }

      public URI a() {
         URI var1;
         if (this.j != null && !"".equals(this.j.trim())) {
            try {
               var1 = new URI(this.j);
            } catch (URISyntaxException var2) {
               SalesforceSDKLogger.a("RestClient", "Exception thrown while parsing URL: " + this.j, var2);
               var1 = null;
            }
         } else {
            var1 = this.b;
         }

         return var1;
      }

      public URI a(String var1) {
         String var2 = var1;
         if (!var1.matches("[hH][tT][tT][pP][sS]?://.*")) {
            StringBuilder var3 = new StringBuilder();
            if (this.j != null && !"".equals(this.j.trim())) {
               var3.append(this.j);
            } else {
               var3.append(this.b.toString());
            }

            if (!var3.toString().endsWith("/")) {
               var3.append("/");
            }

            var2 = var1;
            if (var1.startsWith("/")) {
               var2 = var1.substring(1);
            }

            var3.append(var2);
            var2 = var3.toString();
         }

         try {
            var5 = new URI(var2);
         } catch (URISyntaxException var4) {
            SalesforceSDKLogger.a("RestClient", "Exception thrown while parsing URL: " + var2, var4);
            var5 = null;
         }

         return var5;
      }

      @Override
      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append("  ClientInfo: {\n")
            .append("     loginUrl: ")
            .append(this.c.toString())
            .append("\n")
            .append("     identityUrl: ")
            .append(this.d.toString())
            .append("\n")
            .append("     instanceUrl: ")
            .append(this.b.toString())
            .append("\n")
            .append("     accountName: ")
            .append(this.e)
            .append("\n")
            .append("     username: ")
            .append(this.f)
            .append("\n")
            .append("     userId: ")
            .append(this.g)
            .append("\n")
            .append("     orgId: ")
            .append(this.h)
            .append("\n")
            .append("     communityId: ")
            .append(this.i)
            .append("\n")
            .append("     communityUrl: ")
            .append(this.j)
            .append("\n")
            .append("     firstName: ")
            .append(this.k)
            .append("\n")
            .append("     lastName: ")
            .append(this.l)
            .append("\n")
            .append("     displayName: ")
            .append(this.m)
            .append("\n")
            .append("     email: ")
            .append(this.n)
            .append("\n")
            .append("     photoUrl: ")
            .append(this.o)
            .append("\n")
            .append("     thumbnailUrl: ")
            .append(this.p)
            .append("\n")
            .append("     additionalOauthValues: ")
            .append(this.q)
            .append("\n")
            .append("  }\n");
         return var1.toString();
      }
   }

   public static class OAuthRefreshInterceptor implements Interceptor {
      private final RestClient.AuthTokenProvider a;
      private String b;
      private RestClient.ClientInfo c;

      public OAuthRefreshInterceptor(RestClient.ClientInfo var1, String var2, RestClient.AuthTokenProvider var3) {
         this.c = var1;
         this.b = var2;
         this.a = var3;
      }

      private Request a(Request var1) {
         Request.Builder var2 = var1.e();
         this.a(var2);
         return var2.c();
      }

      private Request a(Request var1, String var2) {
         HttpUrl.Builder var3 = var1.a().p();
         var3.d(var2);
         Request.Builder var4 = var1.e();
         var4.a(var3.c());
         return var4.c();
      }

      private void a(String var1) {
         synchronized (this) {
            this.b = var1;
         }
      }

      private void a(Request.Builder var1) {
         if (this.b != null) {
            OAuth2.a(var1, this.b);
         }
      }

      private void c() throws IOException {
         if (this.a != null) {
            String var1 = this.a.a();
            if (var1 == null || this.a.c() == null) {
               throw new RestClient.RefreshTokenRevokedException("Could not refresh token");
            }

            this.a(var1);
            var1 = this.a.c();
            if (!this.c.b.toString().equalsIgnoreCase(var1)) {
               try {
                  String var2 = this.c.a;
                  URI var4 = new URI(var1);
                  RestClient.ClientInfo var3 = new RestClient.ClientInfo(
                     var2,
                     var4,
                     this.c.c,
                     this.c.d,
                     this.c.e,
                     this.c.f,
                     this.c.g,
                     this.c.h,
                     this.c.i,
                     this.c.j,
                     this.c.k,
                     this.c.l,
                     this.c.m,
                     this.c.n,
                     this.c.o,
                     this.c.p,
                     this.c.q
                  );
                  this.c = var3;
               } catch (URISyntaxException var5) {
                  SalesforceSDKLogger.b("RestClient", "Invalid server URL", var5);
               }
            }
         }
      }

      public String a() {
         synchronized (this) {
            return this.b;
         }
      }

      @Override
      public Response a(Interceptor.Chain var1) throws IOException {
         Request var5 = this.a(var1.a());
         Response var4 = var1.a(var5);
         int var2 = var4.c();
         if (var2 != 401) {
            Response var3 = var4;
            if (var2 != 403) {
               return var3;
            }
         }

         this.c();
         Response var9 = var4;
         if (this.a() != null) {
            Request var7 = this.a(var5);
            HttpUrl var8 = HttpUrl.a(this.c.a());
            Request var6 = var7;
            if (var8 != null) {
               var6 = var7;
               if (var8.g() != null) {
                  var6 = var7;
                  if (!var8.g().equals(var7.a().g())) {
                     var6 = this.a(var7, var8.g());
                  }
               }
            }

            var9 = var1.a(var6);
         }

         return var9;
      }

      public long b() {
         long var3 = -1L;
         long var1;
         if (this.a != null) {
            var1 = this.a.b();
         } else {
            var1 = -1L;
         }

         if (var1 < 0L) {
            var1 = var3;
         } else {
            var1 = System.currentTimeMillis() - var1;
         }

         return var1;
      }
   }

   public static class RefreshTokenRevokedException extends IOException {
      RefreshTokenRevokedException(String var1) {
         super(var1);
      }
   }

   public static class UnauthenticatedClientInfo extends RestClient.ClientInfo {
      public UnauthenticatedClientInfo() {
         super(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
      }

      @Override
      public URI a(String var1) {
         URI var2;
         try {
            var2 = new URI(var1);
         } catch (URISyntaxException var3) {
            SalesforceSDKLogger.a("RestClient", "Exception thrown while parsing URL: " + var1, var3);
            return null;
         }

         return var2;
      }

      @Override
      public String toString() {
         return this.getClass().getSimpleName();
      }
   }
}
