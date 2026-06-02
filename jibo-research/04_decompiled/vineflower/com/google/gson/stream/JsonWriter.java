package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class JsonWriter implements Closeable, Flushable {
   private static final String[] a = new String[128];
   private static final String[] b;
   private final Writer c;
   private int[] d = new int[32];
   private int e = 0;
   private String f;
   private String g;
   private boolean h;
   private boolean i;
   private String j;
   private boolean k;

   static {
      for (int var0 = 0; var0 <= 31; var0++) {
         a[var0] = String.format("\\u%04x", var0);
      }

      a[34] = "\\\"";
      a[92] = "\\\\";
      a[9] = "\\t";
      a[8] = "\\b";
      a[10] = "\\n";
      a[13] = "\\r";
      a[12] = "\\f";
      b = (String[])a.clone();
      b[60] = "\\u003c";
      b[62] = "\\u003e";
      b[38] = "\\u0026";
      b[61] = "\\u003d";
      b[39] = "\\u0027";
   }

   public JsonWriter(Writer var1) {
      this.a(6);
      this.g = ":";
      this.k = true;
      if (var1 == null) {
         throw new NullPointerException("out == null");
      }

      this.c = var1;
   }

   private int a() {
      if (this.e == 0) {
         throw new IllegalStateException("JsonWriter is closed.");
      } else {
         return this.d[this.e - 1];
      }
   }

   private JsonWriter a(int var1, int var2, String var3) throws IOException {
      int var4 = this.a();
      if (var4 != var2 && var4 != var1) {
         throw new IllegalStateException("Nesting problem.");
      }

      if (this.j != null) {
         throw new IllegalStateException("Dangling name: " + this.j);
      }

      this.e--;
      if (var4 == var2) {
         this.k();
      }

      this.c.write(var3);
      return this;
   }

   private JsonWriter a(int var1, String var2) throws IOException {
      this.m();
      this.a(var1);
      this.c.write(var2);
      return this;
   }

   private void a(int var1) {
      if (this.e == this.d.length) {
         int[] var3 = new int[this.e * 2];
         System.arraycopy(this.d, 0, var3, 0, this.e);
         this.d = var3;
      }

      int[] var4 = this.d;
      int var2 = this.e++;
      var4[var2] = var1;
   }

   private void b(int var1) {
      this.d[this.e - 1] = var1;
   }

   private void d(String var1) throws IOException {
      int var3 = 0;
      String[] var8;
      if (this.i) {
         var8 = b;
      } else {
         var8 = a;
      }

      this.c.write("\"");
      int var5 = var1.length();
      int var2 = 0;

      while (var2 < var5) {
         int var4;
         label44: {
            char var6 = var1.charAt(var2);
            String var7;
            if (var6 < 128) {
               String var9 = var8[var6];
               var7 = var9;
               if (var9 == null) {
                  var4 = var3;
                  break label44;
               }
            } else if (var6 == 8232) {
               var7 = "\\u2028";
            } else {
               var4 = var3;
               if (var6 != 8233) {
                  break label44;
               }

               var7 = "\\u2029";
            }

            if (var3 < var2) {
               this.c.write(var1, var3, var2 - var3);
            }

            this.c.write(var7);
            var4 = var2 + 1;
         }

         var2++;
         var3 = var4;
      }

      if (var3 < var5) {
         this.c.write(var1, var3, var5 - var3);
      }

      this.c.write("\"");
   }

   private void j() throws IOException {
      if (this.j != null) {
         this.l();
         this.d(this.j);
         this.j = null;
      }
   }

   private void k() throws IOException {
      if (this.f != null) {
         this.c.write("\n");
         int var1 = 1;

         for (int var2 = this.e; var1 < var2; var1++) {
            this.c.write(this.f);
         }
      }
   }

   private void l() throws IOException {
      int var1 = this.a();
      if (var1 == 5) {
         this.c.write(44);
      } else if (var1 != 3) {
         throw new IllegalStateException("Nesting problem.");
      }

      this.k();
      this.b(4);
   }

   private void m() throws IOException {
      switch (this.a()) {
         case 1:
            this.b(2);
            this.k();
            break;
         case 2:
            this.c.append(',');
            this.k();
            break;
         case 3:
         case 5:
         default:
            throw new IllegalStateException("Nesting problem.");
         case 4:
            this.c.append(this.g);
            this.b(5);
            break;
         case 7:
            if (!this.h) {
               throw new IllegalStateException("JSON must have only one top-level value.");
            }
         case 6:
            this.b(7);
      }
   }

   public JsonWriter a(long var1) throws IOException {
      this.j();
      this.m();
      this.c.write(Long.toString(var1));
      return this;
   }

   public JsonWriter a(Boolean var1) throws IOException {
      JsonWriter var3;
      if (var1 == null) {
         var3 = this.f();
      } else {
         this.j();
         this.m();
         Writer var2 = this.c;
         String var4;
         if (var1) {
            var4 = "true";
         } else {
            var4 = "false";
         }

         var2.write(var4);
         var3 = this;
      }

      return var3;
   }

   public JsonWriter a(Number var1) throws IOException {
      JsonWriter var3;
      if (var1 == null) {
         var3 = this.f();
      } else {
         this.j();
         String var2 = var1.toString();
         if (!this.h && (var2.equals("-Infinity") || var2.equals("Infinity") || var2.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + var1);
         }

         this.m();
         this.c.append(var2);
         var3 = this;
      }

      return var3;
   }

   public JsonWriter a(String var1) throws IOException {
      if (var1 == null) {
         throw new NullPointerException("name == null");
      }

      if (this.j != null) {
         throw new IllegalStateException();
      }

      if (this.e == 0) {
         throw new IllegalStateException("JsonWriter is closed.");
      }

      this.j = var1;
      return this;
   }

   public JsonWriter a(boolean var1) throws IOException {
      this.j();
      this.m();
      Writer var3 = this.c;
      String var2;
      if (var1) {
         var2 = "true";
      } else {
         var2 = "false";
      }

      var3.write(var2);
      return this;
   }

   public JsonWriter b() throws IOException {
      this.j();
      return this.a(1, "[");
   }

   public JsonWriter b(String var1) throws IOException {
      JsonWriter var2;
      if (var1 == null) {
         var2 = this.f();
      } else {
         this.j();
         this.m();
         this.d(var1);
         var2 = this;
      }

      return var2;
   }

   public final void b(boolean var1) {
      this.h = var1;
   }

   public JsonWriter c() throws IOException {
      return this.a(1, 2, "]");
   }

   public final void c(String var1) {
      if (var1.length() == 0) {
         this.f = null;
         this.g = ":";
      } else {
         this.f = var1;
         this.g = ": ";
      }
   }

   public final void c(boolean var1) {
      this.i = var1;
   }

   @Override
   public void close() throws IOException {
      this.c.close();
      int var1 = this.e;
      if (var1 <= 1 && (var1 != 1 || this.d[var1 - 1] == 7)) {
         this.e = 0;
      } else {
         throw new IOException("Incomplete document");
      }
   }

   public JsonWriter d() throws IOException {
      this.j();
      return this.a(3, "{");
   }

   public final void d(boolean var1) {
      this.k = var1;
   }

   public JsonWriter e() throws IOException {
      return this.a(3, 5, "}");
   }

   public JsonWriter f() throws IOException {
      if (this.j != null) {
         if (!this.k) {
            this.j = null;
            return this;
         }

         this.j();
      }

      this.m();
      this.c.write("null");
      return this;
   }

   @Override
   public void flush() throws IOException {
      if (this.e == 0) {
         throw new IllegalStateException("JsonWriter is closed.");
      }

      this.c.flush();
   }

   public boolean g() {
      return this.h;
   }

   public final boolean h() {
      return this.i;
   }

   public final boolean i() {
      return this.k;
   }
}
