package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

abstract class ParameterHandler<T> {
   final ParameterHandler<Iterable<T>> a() {
      return new ParameterHandler<Iterable<T>>(this) {
         final ParameterHandler a;

         {
            this.a = var1;
         }

         void a(RequestBuilder var1, Iterable<T> var2) throws IOException {
            if (var2 != null) {
               for (Object var3 : var2) {
                  this.a.a(var1, var3);
               }
            }
         }
      };
   }

   abstract void a(RequestBuilder var1, T var2) throws IOException;

   final ParameterHandler<Object> b() {
      return new ParameterHandler<Object>(this) {
         final ParameterHandler a;

         {
            this.a = var1;
         }

         @Override
         void a(RequestBuilder var1, Object var2) throws IOException {
            if (var2 != null) {
               int var3 = 0;

               for (int var4 = Array.getLength(var2); var3 < var4; var3++) {
                  this.a.a(var1, Array.get(var2, var3));
               }
            }
         }
      };
   }

   static final class Body<T> extends ParameterHandler<T> {
      private final Converter<T, RequestBody> a;

      Body(Converter<T, RequestBody> var1) {
         this.a = var1;
      }

      @Override
      void a(RequestBuilder var1, T var2) {
         if (var2 == null) {
            throw new IllegalArgumentException("Body parameter value must not be null.");
         }

         RequestBody var3;
         try {
            var3 = this.a.a((T)var2);
         } catch (IOException var4) {
            throw new RuntimeException("Unable to convert " + var2 + " to RequestBody", var4);
         }

         var1.a(var3);
      }
   }

   static final class Field<T> extends ParameterHandler<T> {
      private final String a;
      private final Converter<T, String> b;
      private final boolean c;

      Field(String var1, Converter<T, String> var2, boolean var3) {
         this.a = Utils.a(var1, "name == null");
         this.b = var2;
         this.c = var3;
      }

      @Override
      void a(RequestBuilder var1, T var2) throws IOException {
         if (var2 != null) {
            var2 = this.b.a((T)var2);
            if (var2 != null) {
               var1.c(this.a, var2, this.c);
            }
         }
      }
   }

   static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
      private final Converter<T, String> a;
      private final boolean b;

      FieldMap(Converter<T, String> var1, boolean var2) {
         this.a = var1;
         this.b = var2;
      }

      void a(RequestBuilder var1, Map<String, T> var2) throws IOException {
         if (var2 == null) {
            throw new IllegalArgumentException("Field map was null.");
         }

         for (Entry var4 : var2.entrySet()) {
            String var3 = (String)var4.getKey();
            if (var3 == null) {
               throw new IllegalArgumentException("Field map contained null key.");
            }

            Object var7 = var4.getValue();
            if (var7 == null) {
               throw new IllegalArgumentException("Field map contained null value for key '" + var3 + "'.");
            }

            String var5 = this.a.a((T)var7);
            if (var5 == null) {
               throw new IllegalArgumentException(
                  "Field map value '" + var7 + "' converted to null by " + this.a.getClass().getName() + " for key '" + var3 + "'."
               );
            }

            var1.c(var3, var5, this.b);
         }
      }
   }

   static final class Header<T> extends ParameterHandler<T> {
      private final String a;
      private final Converter<T, String> b;

      Header(String var1, Converter<T, String> var2) {
         this.a = Utils.a(var1, "name == null");
         this.b = var2;
      }

      @Override
      void a(RequestBuilder var1, T var2) throws IOException {
         if (var2 != null) {
            var2 = this.b.a((T)var2);
            if (var2 != null) {
               var1.a(this.a, var2);
            }
         }
      }
   }

   static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
      private final Converter<T, String> a;

      HeaderMap(Converter<T, String> var1) {
         this.a = var1;
      }

      void a(RequestBuilder var1, Map<String, T> var2) throws IOException {
         if (var2 == null) {
            throw new IllegalArgumentException("Header map was null.");
         }

         for (Entry var4 : var2.entrySet()) {
            String var5 = (String)var4.getKey();
            if (var5 == null) {
               throw new IllegalArgumentException("Header map contained null key.");
            }

            Object var6 = var4.getValue();
            if (var6 == null) {
               throw new IllegalArgumentException("Header map contained null value for key '" + var5 + "'.");
            }

            var1.a(var5, this.a.a((T)var6));
         }
      }
   }

   static final class Part<T> extends ParameterHandler<T> {
      private final Headers a;
      private final Converter<T, RequestBody> b;

      Part(Headers var1, Converter<T, RequestBody> var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      void a(RequestBuilder var1, T var2) {
         if (var2 != null) {
            RequestBody var3;
            try {
               var3 = this.b.a((T)var2);
            } catch (IOException var4) {
               throw new RuntimeException("Unable to convert " + var2 + " to RequestBody", var4);
            }

            var1.a(this.a, var3);
         }
      }
   }

   static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
      private final Converter<T, RequestBody> a;
      private final String b;

      PartMap(Converter<T, RequestBody> var1, String var2) {
         this.a = var1;
         this.b = var2;
      }

      void a(RequestBuilder var1, Map<String, T> var2) throws IOException {
         if (var2 == null) {
            throw new IllegalArgumentException("Part map was null.");
         }

         for (Entry var4 : var2.entrySet()) {
            String var3 = (String)var4.getKey();
            if (var3 == null) {
               throw new IllegalArgumentException("Part map contained null key.");
            }

            Object var6 = var4.getValue();
            if (var6 == null) {
               throw new IllegalArgumentException("Part map contained null value for key '" + var3 + "'.");
            }

            var1.a(Headers.a("Content-Disposition", "form-data; name=\"" + var3 + "\"", "Content-Transfer-Encoding", this.b), this.a.a((T)var6));
         }
      }
   }

   static final class Path<T> extends ParameterHandler<T> {
      private final String a;
      private final Converter<T, String> b;
      private final boolean c;

      Path(String var1, Converter<T, String> var2, boolean var3) {
         this.a = Utils.a(var1, "name == null");
         this.b = var2;
         this.c = var3;
      }

      @Override
      void a(RequestBuilder var1, T var2) throws IOException {
         if (var2 == null) {
            throw new IllegalArgumentException("Path parameter \"" + this.a + "\" value must not be null.");
         }

         var1.a(this.a, this.b.a((T)var2), this.c);
      }
   }

   static final class Query<T> extends ParameterHandler<T> {
      private final String a;
      private final Converter<T, String> b;
      private final boolean c;

      Query(String var1, Converter<T, String> var2, boolean var3) {
         this.a = Utils.a(var1, "name == null");
         this.b = var2;
         this.c = var3;
      }

      @Override
      void a(RequestBuilder var1, T var2) throws IOException {
         if (var2 != null) {
            var2 = this.b.a((T)var2);
            if (var2 != null) {
               var1.b(this.a, var2, this.c);
            }
         }
      }
   }

   static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
      private final Converter<T, String> a;
      private final boolean b;

      QueryMap(Converter<T, String> var1, boolean var2) {
         this.a = var1;
         this.b = var2;
      }

      void a(RequestBuilder var1, Map<String, T> var2) throws IOException {
         if (var2 == null) {
            throw new IllegalArgumentException("Query map was null.");
         }

         for (Entry var4 : var2.entrySet()) {
            String var6 = (String)var4.getKey();
            if (var6 == null) {
               throw new IllegalArgumentException("Query map contained null key.");
            }

            Object var7 = var4.getValue();
            if (var7 == null) {
               throw new IllegalArgumentException("Query map contained null value for key '" + var6 + "'.");
            }

            String var5 = this.a.a((T)var7);
            if (var5 == null) {
               throw new IllegalArgumentException(
                  "Query map value '" + var7 + "' converted to null by " + this.a.getClass().getName() + " for key '" + var6 + "'."
               );
            }

            var1.b(var6, var5, this.b);
         }
      }
   }

   static final class QueryName<T> extends ParameterHandler<T> {
      private final Converter<T, String> a;
      private final boolean b;

      QueryName(Converter<T, String> var1, boolean var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      void a(RequestBuilder var1, T var2) throws IOException {
         if (var2 != null) {
            var1.b(this.a.a((T)var2), null, this.b);
         }
      }
   }

   static final class RawPart extends ParameterHandler<MultipartBody.Part> {
      static final ParameterHandler.RawPart a = new ParameterHandler.RawPart();

      private RawPart() {
      }

      void a(RequestBuilder var1, MultipartBody.Part var2) throws IOException {
         if (var2 != null) {
            var1.a(var2);
         }
      }
   }

   static final class RelativeUrl extends ParameterHandler<Object> {
      @Override
      void a(RequestBuilder var1, Object var2) {
         Utils.a(var2, "@Url parameter is null.");
         var1.a(var2);
      }
   }
}
