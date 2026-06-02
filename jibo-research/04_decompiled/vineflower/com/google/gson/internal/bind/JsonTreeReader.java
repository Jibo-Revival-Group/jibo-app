package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;

public final class JsonTreeReader extends JsonReader {
   private static final Reader b = new Reader() {
      @Override
      public void close() throws IOException {
         throw new AssertionError();
      }

      @Override
      public int read(char[] var1, int var2, int var3) throws IOException {
         throw new AssertionError();
      }
   };
   private static final Object c = new Object();
   private Object[] d = new Object[32];
   private int e = 0;
   private String[] f = new String[32];
   private int[] g = new int[32];

   public JsonTreeReader(JsonElement var1) {
      super(b);
      this.a(var1);
   }

   private void a(JsonToken var1) throws IOException {
      if (this.f() != var1) {
         throw new IllegalStateException("Expected " + var1 + " but was " + this.f() + this.v());
      }
   }

   private void a(Object var1) {
      if (this.e == this.d.length) {
         Object[] var3 = new Object[this.e * 2];
         int[] var5 = new int[this.e * 2];
         String[] var4 = new String[this.e * 2];
         System.arraycopy(this.d, 0, var3, 0, this.e);
         System.arraycopy(this.g, 0, var5, 0, this.e);
         System.arraycopy(this.f, 0, var4, 0, this.e);
         this.d = var3;
         this.g = var5;
         this.f = var4;
      }

      Object[] var6 = this.d;
      int var2 = this.e++;
      var6[var2] = var1;
   }

   private Object t() {
      return this.d[this.e - 1];
   }

   private Object u() {
      Object var2 = this.d;
      int var1 = this.e - 1;
      this.e = var1;
      var2 = ((Object[])var2)[var1];
      this.d[this.e] = null;
      return var2;
   }

   private String v() {
      return " at path " + this.p();
   }

   @Override
   public void a() throws IOException {
      this.a(JsonToken.BEGIN_ARRAY);
      this.a(((JsonArray)this.t()).iterator());
      this.g[this.e - 1] = 0;
   }

   @Override
   public void b() throws IOException {
      this.a(JsonToken.END_ARRAY);
      this.u();
      this.u();
      if (this.e > 0) {
         int[] var2 = this.g;
         int var1 = this.e - 1;
         var2[var1]++;
      }
   }

   @Override
   public void c() throws IOException {
      this.a(JsonToken.BEGIN_OBJECT);
      this.a(((JsonObject)this.t()).a().iterator());
   }

   @Override
   public void close() throws IOException {
      this.d = new Object[]{c};
      this.e = 1;
   }

   @Override
   public void d() throws IOException {
      this.a(JsonToken.END_OBJECT);
      this.u();
      this.u();
      if (this.e > 0) {
         int[] var2 = this.g;
         int var1 = this.e - 1;
         var2[var1]++;
      }
   }

   @Override
   public boolean e() throws IOException {
      JsonToken var2 = this.f();
      boolean var1;
      if (var2 != JsonToken.END_OBJECT && var2 != JsonToken.END_ARRAY) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public JsonToken f() throws IOException {
      JsonToken var2;
      if (this.e == 0) {
         var2 = JsonToken.END_DOCUMENT;
      } else {
         Object var3 = this.t();
         if (var3 instanceof Iterator) {
            boolean var1 = this.d[this.e - 2] instanceof JsonObject;
            Iterator var4 = (Iterator)var3;
            if (var4.hasNext()) {
               if (var1) {
                  var2 = JsonToken.NAME;
               } else {
                  this.a(var4.next());
                  var2 = this.f();
               }
            } else if (var1) {
               var2 = JsonToken.END_OBJECT;
            } else {
               var2 = JsonToken.END_ARRAY;
            }
         } else if (var3 instanceof JsonObject) {
            var2 = JsonToken.BEGIN_OBJECT;
         } else if (var3 instanceof JsonArray) {
            var2 = JsonToken.BEGIN_ARRAY;
         } else if (var3 instanceof JsonPrimitive) {
            JsonPrimitive var5 = (JsonPrimitive)var3;
            if (var5.q()) {
               var2 = JsonToken.STRING;
            } else if (var5.a()) {
               var2 = JsonToken.BOOLEAN;
            } else {
               if (!var5.p()) {
                  throw new AssertionError();
               }

               var2 = JsonToken.NUMBER;
            }
         } else {
            if (!(var3 instanceof JsonNull)) {
               if (var3 == c) {
                  throw new IllegalStateException("JsonReader is closed");
               }

               throw new AssertionError();
            }

            var2 = JsonToken.NULL;
         }
      }

      return var2;
   }

   @Override
   public String g() throws IOException {
      this.a(JsonToken.NAME);
      Entry var1 = (Entry)((Iterator)this.t()).next();
      String var2 = (String)var1.getKey();
      this.f[this.e - 1] = var2;
      this.a(var1.getValue());
      return var2;
   }

   @Override
   public String h() throws IOException {
      JsonToken var2 = this.f();
      if (var2 != JsonToken.STRING && var2 != JsonToken.NUMBER) {
         throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + var2 + this.v());
      }

      String var4 = ((JsonPrimitive)this.u()).c();
      if (this.e > 0) {
         int[] var3 = this.g;
         int var1 = this.e - 1;
         var3[var1]++;
      }

      return var4;
   }

   @Override
   public boolean i() throws IOException {
      this.a(JsonToken.BOOLEAN);
      boolean var2 = ((JsonPrimitive)this.u()).g();
      if (this.e > 0) {
         int[] var3 = this.g;
         int var1 = this.e - 1;
         var3[var1]++;
      }

      return var2;
   }

   @Override
   public void j() throws IOException {
      this.a(JsonToken.NULL);
      this.u();
      if (this.e > 0) {
         int[] var2 = this.g;
         int var1 = this.e - 1;
         var2[var1]++;
      }
   }

   @Override
   public double k() throws IOException {
      JsonToken var4 = this.f();
      if (var4 != JsonToken.NUMBER && var4 != JsonToken.STRING) {
         throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + var4 + this.v());
      }

      double var1 = ((JsonPrimitive)this.t()).d();
      if (this.q() || !Double.isNaN(var1) && !Double.isInfinite(var1)) {
         this.u();
         if (this.e > 0) {
            int[] var5 = this.g;
            int var3 = this.e - 1;
            var5[var3]++;
         }

         return var1;
      } else {
         throw new NumberFormatException("JSON forbids NaN and infinities: " + var1);
      }
   }

   @Override
   public long l() throws IOException {
      JsonToken var4 = this.f();
      if (var4 != JsonToken.NUMBER && var4 != JsonToken.STRING) {
         throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + var4 + this.v());
      }

      long var2 = ((JsonPrimitive)this.t()).e();
      this.u();
      if (this.e > 0) {
         int[] var5 = this.g;
         int var1 = this.e - 1;
         var5[var1]++;
      }

      return var2;
   }

   @Override
   public int m() throws IOException {
      JsonToken var3 = this.f();
      if (var3 != JsonToken.NUMBER && var3 != JsonToken.STRING) {
         throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + var3 + this.v());
      }

      int var1 = ((JsonPrimitive)this.t()).f();
      this.u();
      if (this.e > 0) {
         int[] var4 = this.g;
         int var2 = this.e - 1;
         var4[var2]++;
      }

      return var1;
   }

   @Override
   public void n() throws IOException {
      if (this.f() == JsonToken.NAME) {
         this.g();
         this.f[this.e - 2] = "null";
      } else {
         this.u();
         if (this.e > 0) {
            this.f[this.e - 1] = "null";
         }
      }

      if (this.e > 0) {
         int[] var2 = this.g;
         int var1 = this.e - 1;
         var2[var1]++;
      }
   }

   public void o() throws IOException {
      this.a(JsonToken.NAME);
      Entry var1 = (Entry)((Iterator)this.t()).next();
      this.a(var1.getValue());
      this.a(new JsonPrimitive((String)var1.getKey()));
   }

   @Override
   public String p() {
      StringBuilder var3 = new StringBuilder().append('$');
      int var2 = 0;

      while (var2 < this.e) {
         int var1;
         if (this.d[var2] instanceof JsonArray) {
            Object[] var4 = this.d;
            var1 = ++var2;
            if (var4[var2] instanceof Iterator) {
               var3.append('[').append(this.g[var2]).append(']');
               var1 = var2;
            }
         } else {
            var1 = var2;
            if (this.d[var2] instanceof JsonObject) {
               Object[] var7 = this.d;
               var1 = ++var2;
               if (var7[var2] instanceof Iterator) {
                  var3.append('.');
                  var1 = var2;
                  if (this.f[var2] != null) {
                     var3.append(this.f[var2]);
                     var1 = var2;
                  }
               }
            }
         }

         var2 = var1 + 1;
      }

      return var3.toString();
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName();
   }
}
