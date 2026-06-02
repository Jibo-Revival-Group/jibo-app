package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class JsonTreeWriter extends JsonWriter {
   private static final Writer a = new Writer() {
      @Override
      public void close() throws IOException {
         throw new AssertionError();
      }

      @Override
      public void flush() throws IOException {
         throw new AssertionError();
      }

      @Override
      public void write(char[] var1, int var2, int var3) {
         throw new AssertionError();
      }
   };
   private static final JsonPrimitive b = new JsonPrimitive("closed");
   private final List<JsonElement> c = new ArrayList<>();
   private String d;
   private JsonElement e = JsonNull.a;

   public JsonTreeWriter() {
      super(a);
   }

   private void a(JsonElement var1) {
      if (this.d != null) {
         if (!var1.k() || this.i()) {
            ((JsonObject)this.j()).a(this.d, var1);
         }

         this.d = null;
      } else if (this.c.isEmpty()) {
         this.e = var1;
      } else {
         JsonElement var2 = this.j();
         if (!(var2 instanceof JsonArray)) {
            throw new IllegalStateException();
         }

         ((JsonArray)var2).a(var1);
      }
   }

   private JsonElement j() {
      return this.c.get(this.c.size() - 1);
   }

   public JsonElement a() {
      if (!this.c.isEmpty()) {
         throw new IllegalStateException("Expected one JSON element but was " + this.c);
      } else {
         return this.e;
      }
   }

   @Override
   public JsonWriter a(long var1) throws IOException {
      this.a(new JsonPrimitive(var1));
      return this;
   }

   @Override
   public JsonWriter a(Boolean var1) throws IOException {
      JsonWriter var2;
      if (var1 == null) {
         var2 = this.f();
      } else {
         this.a(new JsonPrimitive(var1));
         var2 = this;
      }

      return var2;
   }

   @Override
   public JsonWriter a(Number var1) throws IOException {
      JsonWriter var4;
      if (var1 == null) {
         var4 = this.f();
      } else {
         if (!this.g()) {
            double var2 = var1.doubleValue();
            if (Double.isNaN(var2) || Double.isInfinite(var2)) {
               throw new IllegalArgumentException("JSON forbids NaN and infinities: " + var1);
            }
         }

         this.a(new JsonPrimitive(var1));
         var4 = this;
      }

      return var4;
   }

   @Override
   public JsonWriter a(String var1) throws IOException {
      if (this.c.isEmpty() || this.d != null) {
         throw new IllegalStateException();
      } else if (this.j() instanceof JsonObject) {
         this.d = var1;
         return this;
      } else {
         throw new IllegalStateException();
      }
   }

   @Override
   public JsonWriter a(boolean var1) throws IOException {
      this.a(new JsonPrimitive(var1));
      return this;
   }

   @Override
   public JsonWriter b() throws IOException {
      JsonArray var1 = new JsonArray();
      this.a(var1);
      this.c.add(var1);
      return this;
   }

   @Override
   public JsonWriter b(String var1) throws IOException {
      JsonWriter var2;
      if (var1 == null) {
         var2 = this.f();
      } else {
         this.a(new JsonPrimitive(var1));
         var2 = this;
      }

      return var2;
   }

   @Override
   public JsonWriter c() throws IOException {
      if (this.c.isEmpty() || this.d != null) {
         throw new IllegalStateException();
      } else if (this.j() instanceof JsonArray) {
         this.c.remove(this.c.size() - 1);
         return this;
      } else {
         throw new IllegalStateException();
      }
   }

   @Override
   public void close() throws IOException {
      if (!this.c.isEmpty()) {
         throw new IOException("Incomplete document");
      }

      this.c.add(b);
   }

   @Override
   public JsonWriter d() throws IOException {
      JsonObject var1 = new JsonObject();
      this.a(var1);
      this.c.add(var1);
      return this;
   }

   @Override
   public JsonWriter e() throws IOException {
      if (this.c.isEmpty() || this.d != null) {
         throw new IllegalStateException();
      } else if (this.j() instanceof JsonObject) {
         this.c.remove(this.c.size() - 1);
         return this;
      } else {
         throw new IllegalStateException();
      }
   }

   @Override
   public JsonWriter f() throws IOException {
      this.a(JsonNull.a);
      return this;
   }

   @Override
   public void flush() throws IOException {
   }
}
