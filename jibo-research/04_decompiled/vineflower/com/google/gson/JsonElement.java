package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;

public abstract class JsonElement {
   public Number b() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public String c() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public double d() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public long e() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public int f() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public boolean g() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public boolean h() {
      return this instanceof JsonArray;
   }

   public boolean i() {
      return this instanceof JsonObject;
   }

   public boolean j() {
      return this instanceof JsonPrimitive;
   }

   public boolean k() {
      return this instanceof JsonNull;
   }

   public JsonObject l() {
      if (this.i()) {
         return (JsonObject)this;
      } else {
         throw new IllegalStateException("Not a JSON Object: " + this);
      }
   }

   public JsonArray m() {
      if (this.h()) {
         return (JsonArray)this;
      } else {
         throw new IllegalStateException("Not a JSON Array: " + this);
      }
   }

   public JsonPrimitive n() {
      if (this.j()) {
         return (JsonPrimitive)this;
      } else {
         throw new IllegalStateException("Not a JSON Primitive: " + this);
      }
   }

   Boolean o() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   @Override
   public String toString() {
      try {
         StringWriter var1 = new StringWriter();
         JsonWriter var2 = new JsonWriter(var1);
         var2.b(true);
         Streams.a(this, var2);
         return var1.toString();
      } catch (IOException var3) {
         throw new AssertionError(var3);
      }
   }
}
