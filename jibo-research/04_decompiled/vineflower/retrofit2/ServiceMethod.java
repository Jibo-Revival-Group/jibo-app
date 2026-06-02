package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Url;

final class ServiceMethod<R, T> {
   static final Pattern a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
   static final Pattern b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
   final okhttp3.Call.Factory c;
   final CallAdapter<R, T> d;
   private final HttpUrl e;
   private final Converter<ResponseBody, R> f;
   private final String g;
   private final String h;
   private final Headers i;
   private final MediaType j;
   private final boolean k;
   private final boolean l;
   private final boolean m;
   private final ParameterHandler<?>[] n;

   ServiceMethod(ServiceMethod.Builder<R, T> var1) {
      this.c = var1.a.a();
      this.d = (CallAdapter<R, T>)var1.w;
      this.e = var1.a.b();
      this.f = (Converter<ResponseBody, R>)var1.v;
      this.g = var1.m;
      this.h = var1.q;
      this.i = var1.r;
      this.j = var1.s;
      this.k = var1.n;
      this.l = var1.o;
      this.m = var1.p;
      this.n = var1.u;
   }

   static Class<?> a(Class<?> var0) {
      Class<Boolean> var1;
      if (boolean.class == var0) {
         var1 = Boolean.class;
      } else if (byte.class == var0) {
         var1 = Byte.class;
      } else if (char.class == var0) {
         var1 = Character.class;
      } else if (double.class == var0) {
         var1 = Double.class;
      } else if (float.class == var0) {
         var1 = Float.class;
      } else if (int.class == var0) {
         var1 = Integer.class;
      } else if (long.class == var0) {
         var1 = Long.class;
      } else {
         var1 = var0;
         if (short.class == var0) {
            var1 = Short.class;
         }
      }

      return var1;
   }

   static Set<String> a(String var0) {
      Matcher var2 = a.matcher(var0);
      LinkedHashSet var1 = new LinkedHashSet();

      while (var2.find()) {
         var1.add(var2.group(1));
      }

      return var1;
   }

   R a(ResponseBody var1) throws IOException {
      return this.f.a(var1);
   }

   Request a(Object... var1) throws IOException {
      int var3 = 0;
      RequestBuilder var5 = new RequestBuilder(this.g, this.e, this.h, this.i, this.j, this.k, this.l, this.m);
      ParameterHandler[] var4 = this.n;
      int var2;
      if (var1 != null) {
         var2 = var1.length;
      } else {
         var2 = 0;
      }

      if (var2 != var4.length) {
         throw new IllegalArgumentException("Argument count (" + var2 + ") doesn't match expected count (" + var4.length + ")");
      }

      while (var3 < var2) {
         var4[var3].a(var5, var1[var3]);
         var3++;
      }

      return var5.a();
   }

   static final class Builder<T, R> {
      final Retrofit a;
      final Method b;
      final Annotation[] c;
      final Annotation[][] d;
      final Type[] e;
      Type f;
      boolean g;
      boolean h;
      boolean i;
      boolean j;
      boolean k;
      boolean l;
      String m;
      boolean n;
      boolean o;
      boolean p;
      String q;
      Headers r;
      MediaType s;
      Set<String> t;
      ParameterHandler<?>[] u;
      Converter<ResponseBody, T> v;
      CallAdapter<T, R> w;

      Builder(Retrofit var1, Method var2) {
         this.a = var1;
         this.b = var2;
         this.c = var2.getAnnotations();
         this.e = var2.getGenericParameterTypes();
         this.d = var2.getParameterAnnotations();
      }

      private RuntimeException a(int var1, String var2, Object... var3) {
         return this.a(var2 + " (parameter #" + (var1 + 1) + ")", var3);
      }

      private RuntimeException a(String var1, Object... var2) {
         return this.a(null, var1, var2);
      }

      private RuntimeException a(Throwable var1, int var2, String var3, Object... var4) {
         return this.a(var1, var3 + " (parameter #" + (var2 + 1) + ")", var4);
      }

      private RuntimeException a(Throwable var1, String var2, Object... var3) {
         var2 = String.format(var2, var3);
         return new IllegalArgumentException(var2 + "\n    for method " + this.b.getDeclaringClass().getSimpleName() + "." + this.b.getName(), var1);
      }

      private Headers a(String[] var1) {
         Headers.Builder var5 = new Headers.Builder();

         for (String var7 : var1) {
            int var4 = var7.indexOf(58);
            if (var4 == -1 || var4 == 0 || var4 == var7.length() - 1) {
               throw this.a("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", var7);
            }

            String var6 = var7.substring(0, var4);
            var7 = var7.substring(var4 + 1).trim();
            if ("Content-Type".equalsIgnoreCase(var6)) {
               MediaType var8 = MediaType.a(var7);
               if (var8 == null) {
                  throw this.a("Malformed content type: %s", var7);
               }

               this.s = var8;
            } else {
               var5.a(var6, var7);
            }
         }

         return var5.a();
      }

      private ParameterHandler<?> a(int var1, Type var2, Annotation[] var3) {
         ParameterHandler var6 = null;
         int var5 = var3.length;

         for (int var4 = 0; var4 < var5; var4++) {
            ParameterHandler var7 = this.a(var1, var2, var3, var3[var4]);
            if (var7 != null) {
               if (var6 != null) {
                  throw this.a(var1, "Multiple Retrofit annotations found, only one allowed.");
               }

               var6 = var7;
            }
         }

         if (var6 == null) {
            throw this.a(var1, "No Retrofit annotation found.");
         } else {
            return var6;
         }
      }

      private ParameterHandler<?> a(int var1, Type var2, Annotation[] var3, Annotation var4) {
         ParameterHandler var9;
         if (var4 instanceof Url) {
            if (this.l) {
               throw this.a(var1, "Multiple @Url method annotations found.");
            }

            if (this.j) {
               throw this.a(var1, "@Path parameters may not be used with @Url.");
            }

            if (this.k) {
               throw this.a(var1, "A @Url parameter must not come after a @Query");
            }

            if (this.q != null) {
               throw this.a(var1, "@Url cannot be used with @%s URL", this.m);
            }

            this.l = true;
            if (var2 != HttpUrl.class
               && var2 != String.class
               && var2 != URI.class
               && (!(var2 instanceof Class) || !"android.net.Uri".equals(((Class)var2).getName()))) {
               throw this.a(var1, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.");
            }

            var9 = new ParameterHandler.RelativeUrl();
         } else if (var4 instanceof Path) {
            if (this.k) {
               throw this.a(var1, "A @Path parameter must not come after a @Query.");
            }

            if (this.l) {
               throw this.a(var1, "@Path parameters may not be used with @Url.");
            }

            if (this.q == null) {
               throw this.a(var1, "@Path can only be used with relative url on @%s", this.m);
            }

            this.j = true;
            Path var56 = (Path)var4;
            String var41 = var56.a();
            this.a(var1, var41);
            var9 = new ParameterHandler.Path(var41, this.a.c(var2, var3), var56.b());
         } else if (var4 instanceof Query) {
            Query var54 = (Query)var4;
            String var40 = var54.a();
            boolean var43 = var54.b();
            Class var55 = Utils.a(var2);
            this.k = true;
            if (Iterable.class.isAssignableFrom(var55)) {
               if (!(var2 instanceof ParameterizedType)) {
                  throw this.a(var1, var55.getSimpleName() + " must include generic type (e.g., " + var55.getSimpleName() + "<String>)");
               }

               var2 = Utils.a(0, (ParameterizedType)var2);
               var9 = new ParameterHandler.Query(var40, this.a.c(var2, var3), var43).a();
            } else if (var55.isArray()) {
               Class var32 = ServiceMethod.a(var55.getComponentType());
               var9 = new ParameterHandler.Query(var40, this.a.c(var32, var3), var43).b();
            } else {
               var9 = new ParameterHandler.Query(var40, this.a.c(var2, var3), var43);
            }
         } else if (var4 instanceof QueryName) {
            boolean var42 = ((QueryName)var4).a();
            Class var39 = Utils.a(var2);
            this.k = true;
            if (Iterable.class.isAssignableFrom(var39)) {
               if (!(var2 instanceof ParameterizedType)) {
                  throw this.a(var1, var39.getSimpleName() + " must include generic type (e.g., " + var39.getSimpleName() + "<String>)");
               }

               var2 = Utils.a(0, (ParameterizedType)var2);
               var9 = new ParameterHandler.QueryName(this.a.c(var2, var3), var42).a();
            } else if (var39.isArray()) {
               Class var30 = ServiceMethod.a(var39.getComponentType());
               var9 = new ParameterHandler.QueryName(this.a.c(var30, var3), var42).b();
            } else {
               var9 = new ParameterHandler.QueryName(this.a.c(var2, var3), var42);
            }
         } else if (var4 instanceof QueryMap) {
            Class var52 = Utils.a(var2);
            if (!Map.class.isAssignableFrom(var52)) {
               throw this.a(var1, "@QueryMap parameter type must be Map.");
            }

            var2 = Utils.b(var2, var52, Map.class);
            if (!(var2 instanceof ParameterizedType)) {
               throw this.a(var1, "Map must include generic types (e.g., Map<String, String>)");
            }

            ParameterizedType var53 = (ParameterizedType)var2;
            var2 = Utils.a(0, var53);
            if (String.class != var2) {
               throw this.a(var1, "@QueryMap keys must be of type String: " + var2);
            }

            var2 = Utils.a(1, var53);
            var9 = new ParameterHandler.QueryMap(this.a.c(var2, var3), ((QueryMap)var4).a());
         } else if (var4 instanceof Header) {
            String var38 = ((Header)var4).a();
            Class var51 = Utils.a(var2);
            if (Iterable.class.isAssignableFrom(var51)) {
               if (!(var2 instanceof ParameterizedType)) {
                  throw this.a(var1, var51.getSimpleName() + " must include generic type (e.g., " + var51.getSimpleName() + "<String>)");
               }

               var2 = Utils.a(0, (ParameterizedType)var2);
               var9 = new ParameterHandler.Header(var38, this.a.c(var2, var3)).a();
            } else if (var51.isArray()) {
               Class var25 = ServiceMethod.a(var51.getComponentType());
               var9 = new ParameterHandler.Header(var38, this.a.c(var25, var3)).b();
            } else {
               var9 = new ParameterHandler.Header(var38, this.a.c(var2, var3));
            }
         } else if (var4 instanceof HeaderMap) {
            Class var36 = Utils.a(var2);
            if (!Map.class.isAssignableFrom(var36)) {
               throw this.a(var1, "@HeaderMap parameter type must be Map.");
            }

            var2 = Utils.b(var2, var36, Map.class);
            if (!(var2 instanceof ParameterizedType)) {
               throw this.a(var1, "Map must include generic types (e.g., Map<String, String>)");
            }

            ParameterizedType var22 = (ParameterizedType)var2;
            Type var37 = Utils.a(0, var22);
            if (String.class != var37) {
               throw this.a(var1, "@HeaderMap keys must be of type String: " + var37);
            }

            Type var23 = Utils.a(1, var22);
            var9 = new ParameterHandler.HeaderMap(this.a.c(var23, var3));
         } else if (var4 instanceof Field) {
            if (!this.o) {
               throw this.a(var1, "@Field parameters can only be used with form encoding.");
            }

            Field var49 = (Field)var4;
            String var35 = var49.a();
            boolean var5 = var49.b();
            this.g = true;
            Class var50 = Utils.a(var2);
            if (Iterable.class.isAssignableFrom(var50)) {
               if (!(var2 instanceof ParameterizedType)) {
                  throw this.a(var1, var50.getSimpleName() + " must include generic type (e.g., " + var50.getSimpleName() + "<String>)");
               }

               var2 = Utils.a(0, (ParameterizedType)var2);
               var9 = new ParameterHandler.Field(var35, this.a.c(var2, var3), var5).a();
            } else if (var50.isArray()) {
               Class var20 = ServiceMethod.a(var50.getComponentType());
               var9 = new ParameterHandler.Field(var35, this.a.c(var20, var3), var5).b();
            } else {
               var9 = new ParameterHandler.Field(var35, this.a.c(var2, var3), var5);
            }
         } else if (var4 instanceof FieldMap) {
            if (!this.o) {
               throw this.a(var1, "@FieldMap parameters can only be used with form encoding.");
            }

            Class var47 = Utils.a(var2);
            if (!Map.class.isAssignableFrom(var47)) {
               throw this.a(var1, "@FieldMap parameter type must be Map.");
            }

            var2 = Utils.b(var2, var47, Map.class);
            if (!(var2 instanceof ParameterizedType)) {
               throw this.a(var1, "Map must include generic types (e.g., Map<String, String>)");
            }

            ParameterizedType var48 = (ParameterizedType)var2;
            var2 = Utils.a(0, var48);
            if (String.class != var2) {
               throw this.a(var1, "@FieldMap keys must be of type String: " + var2);
            }

            var2 = Utils.a(1, var48);
            Converter var18 = this.a.c(var2, var3);
            this.g = true;
            var9 = new ParameterHandler.FieldMap(var18, ((FieldMap)var4).a());
         } else if (var4 instanceof Part) {
            if (!this.p) {
               throw this.a(var1, "@Part parameters can only be used with multipart encoding.");
            }

            Part var45 = (Part)var4;
            this.h = true;
            String var7 = var45.a();
            Class var34 = Utils.a(var2);
            if (var7.isEmpty()) {
               if (Iterable.class.isAssignableFrom(var34)) {
                  if (!(var2 instanceof ParameterizedType)) {
                     throw this.a(var1, var34.getSimpleName() + " must include generic type (e.g., " + var34.getSimpleName() + "<String>)");
                  }

                  if (!MultipartBody.Part.class.isAssignableFrom(Utils.a(Utils.a(0, (ParameterizedType)var2)))) {
                     throw this.a(var1, "@Part annotation must supply a name or use MultipartBody.Part parameter type.");
                  }

                  var9 = ParameterHandler.RawPart.a.a();
               } else if (var34.isArray()) {
                  if (!MultipartBody.Part.class.isAssignableFrom(var34.getComponentType())) {
                     throw this.a(var1, "@Part annotation must supply a name or use MultipartBody.Part parameter type.");
                  }

                  var9 = ParameterHandler.RawPart.a.b();
               } else {
                  if (!MultipartBody.Part.class.isAssignableFrom(var34)) {
                     throw this.a(var1, "@Part annotation must supply a name or use MultipartBody.Part parameter type.");
                  }

                  var9 = ParameterHandler.RawPart.a;
               }
            } else {
               Headers var46 = Headers.a("Content-Disposition", "form-data; name=\"" + var7 + "\"", "Content-Transfer-Encoding", var45.b());
               if (Iterable.class.isAssignableFrom(var34)) {
                  if (!(var2 instanceof ParameterizedType)) {
                     throw this.a(var1, var34.getSimpleName() + " must include generic type (e.g., " + var34.getSimpleName() + "<String>)");
                  }

                  var2 = Utils.a(0, (ParameterizedType)var2);
                  if (MultipartBody.Part.class.isAssignableFrom(Utils.a(var2))) {
                     throw this.a(var1, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.");
                  }

                  var9 = new ParameterHandler.Part(var46, this.a.a(var2, var3, this.c)).a();
               } else if (var34.isArray()) {
                  Class var14 = ServiceMethod.a(var34.getComponentType());
                  if (MultipartBody.Part.class.isAssignableFrom(var14)) {
                     throw this.a(var1, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.");
                  }

                  var9 = new ParameterHandler.Part(var46, this.a.a(var14, var3, this.c)).b();
               } else {
                  if (MultipartBody.Part.class.isAssignableFrom(var34)) {
                     throw this.a(var1, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.");
                  }

                  var9 = new ParameterHandler.Part(var46, this.a.a(var2, var3, this.c));
               }
            }
         } else if (var4 instanceof PartMap) {
            if (!this.p) {
               throw this.a(var1, "@PartMap parameters can only be used with multipart encoding.");
            }

            this.h = true;
            Class var6 = Utils.a(var2);
            if (!Map.class.isAssignableFrom(var6)) {
               throw this.a(var1, "@PartMap parameter type must be Map.");
            }

            var2 = Utils.b(var2, var6, Map.class);
            if (!(var2 instanceof ParameterizedType)) {
               throw this.a(var1, "Map must include generic types (e.g., Map<String, String>)");
            }

            ParameterizedType var44 = (ParameterizedType)var2;
            var2 = Utils.a(0, var44);
            if (String.class != var2) {
               throw this.a(var1, "@PartMap keys must be of type String: " + var2);
            }

            var2 = Utils.a(1, var44);
            if (MultipartBody.Part.class.isAssignableFrom(Utils.a(var2))) {
               throw this.a(var1, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.");
            }

            var9 = new ParameterHandler.PartMap(this.a.a(var2, var3, this.c), ((PartMap)var4).a());
         } else if (var4 instanceof Body) {
            if (this.o || this.p) {
               throw this.a(var1, "@Body parameters cannot be used with form or multi-part encoding.");
            }

            if (this.i) {
               throw this.a(var1, "Multiple @Body method annotations found.");
            }

            try {
               var33 = this.a.a(var2, var3, this.c);
            } catch (RuntimeException var8) {
               throw this.a(var8, var1, "Unable to create @Body converter for %s", var2);
            }

            this.i = true;
            var9 = new ParameterHandler.Body(var33);
         } else {
            var9 = null;
         }

         return var9;
      }

      private void a(int var1, String var2) {
         if (!ServiceMethod.b.matcher(var2).matches()) {
            throw this.a(var1, "@Path parameter name must match %s. Found: %s", ServiceMethod.a.pattern(), var2);
         }

         if (!this.t.contains(var2)) {
            throw this.a(var1, "URL \"%s\" does not contain \"{%s}\".", this.q, var2);
         }
      }

      private void a(String var1, String var2, boolean var3) {
         if (this.m != null) {
            throw this.a("Only one HTTP method is allowed. Found: %s and %s.", this.m, var1);
         }

         this.m = var1;
         this.n = var3;
         if (!var2.isEmpty()) {
            int var4 = var2.indexOf(63);
            if (var4 != -1 && var4 < var2.length() - 1) {
               var1 = var2.substring(var4 + 1);
               if (ServiceMethod.a.matcher(var1).find()) {
                  throw this.a("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", var1);
               }
            }

            this.q = var2;
            this.t = ServiceMethod.a(var2);
         }
      }

      private void a(Annotation var1) {
         if (var1 instanceof DELETE) {
            this.a("DELETE", ((DELETE)var1).a(), false);
         } else if (var1 instanceof GET) {
            this.a("GET", ((GET)var1).a(), false);
         } else if (var1 instanceof HEAD) {
            this.a("HEAD", ((HEAD)var1).a(), false);
            if (!Void.class.equals(this.f)) {
               throw this.a("HEAD method must use Void as response type.");
            }
         } else if (var1 instanceof PATCH) {
            this.a("PATCH", ((PATCH)var1).a(), true);
         } else if (var1 instanceof POST) {
            this.a("POST", ((POST)var1).a(), true);
         } else if (var1 instanceof PUT) {
            this.a("PUT", ((PUT)var1).a(), true);
         } else if (var1 instanceof OPTIONS) {
            this.a("OPTIONS", ((OPTIONS)var1).a(), false);
         } else if (var1 instanceof HTTP) {
            HTTP var2 = (HTTP)var1;
            this.a(var2.a(), var2.b(), var2.c());
         } else if (var1 instanceof retrofit2.http.Headers) {
            String[] var3 = ((retrofit2.http.Headers)var1).a();
            if (var3.length == 0) {
               throw this.a("@Headers annotation is empty.");
            }

            this.r = this.a(var3);
         } else if (var1 instanceof Multipart) {
            if (this.o) {
               throw this.a("Only one encoding annotation is allowed.");
            }

            this.p = true;
         } else if (var1 instanceof FormUrlEncoded) {
            if (this.p) {
               throw this.a("Only one encoding annotation is allowed.");
            }

            this.o = true;
         }
      }

      private CallAdapter<T, R> b() {
         Type var1 = this.b.getGenericReturnType();
         if (Utils.d(var1)) {
            throw this.a("Method return type must not include a type variable or wildcard: %s", var1);
         }

         if (var1 == void.class) {
            throw this.a("Service methods cannot return void.");
         }

         Annotation[] var2 = this.b.getAnnotations();

         try {
            return (CallAdapter<T, R>)this.a.a(var1, var2);
         } catch (RuntimeException var3) {
            throw this.a(var3, "Unable to create call adapter for %s", var1);
         }
      }

      private Converter<ResponseBody, T> c() {
         Annotation[] var1 = this.b.getAnnotations();

         try {
            return this.a.b(this.f, var1);
         } catch (RuntimeException var2) {
            throw this.a(var2, "Unable to create converter for %s", this.f);
         }
      }

      public ServiceMethod a() {
         this.w = this.b();
         this.f = this.w.a();
         if (this.f != Response.class && this.f != okhttp3.Response.class) {
            this.v = this.c();
            Annotation[] var3 = this.c;
            int var2 = var3.length;

            for (int var1 = 0; var1 < var2; var1++) {
               this.a(var3[var1]);
            }

            if (this.m == null) {
               throw this.a("HTTP method annotation is required (e.g., @GET, @POST, etc.).");
            }

            if (!this.n) {
               if (this.p) {
                  throw this.a("Multipart can only be specified on HTTP methods with request body (e.g., @POST).");
               }

               if (this.o) {
                  throw this.a("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).");
               }
            }

            var2 = this.d.length;
            this.u = new ParameterHandler[var2];

            for (int var5 = 0; var5 < var2; var5++) {
               Type var7 = this.e[var5];
               if (Utils.d(var7)) {
                  throw this.a(var5, "Parameter type must not include a type variable or wildcard: %s", var7);
               }

               Annotation[] var4 = this.d[var5];
               if (var4 == null) {
                  throw this.a(var5, "No Retrofit annotation found.");
               }

               this.u[var5] = this.a(var5, var7, var4);
            }

            if (this.q == null && !this.l) {
               throw this.a("Missing either @%s URL or @Url parameter.", this.m);
            } else if (!this.o && !this.p && !this.n && this.i) {
               throw this.a("Non-body HTTP method cannot contain @Body.");
            } else if (this.o && !this.g) {
               throw this.a("Form-encoded method must contain at least one @Field.");
            } else if (this.p && !this.h) {
               throw this.a("Multipart method must contain at least one @Part.");
            } else {
               return new ServiceMethod<>(this);
            }
         } else {
            throw this.a("'" + Utils.a(this.f).getName() + "' is not a valid response body type. Did you mean ResponseBody?");
         }
      }
   }
}
