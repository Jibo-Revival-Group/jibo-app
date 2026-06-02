package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

public final class Streams {
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static JsonElement a(JsonReader var0) throws JsonParseException {
      boolean var1 = true;

      try {
         var0.f();
      } catch (EOFException var6) {
         if (var1) {
            return JsonNull.a;
         }

         throw new JsonSyntaxException(var6);
      } catch (MalformedJsonException var7) {
         throw new JsonSyntaxException(var7);
      } catch (IOException var8) {
         throw new JsonIOException(var8);
      } catch (NumberFormatException var9) {
         throw new JsonSyntaxException(var9);
      }

      var1 = false;

      try {
         return TypeAdapters.X.read(var0);
      } catch (EOFException var2) {
         if (!var1) {
            throw new JsonSyntaxException(var2);
         } else {
            return JsonNull.a;
         }
      } catch (MalformedJsonException var3) {
         throw new JsonSyntaxException(var3);
      } catch (IOException var4) {
         throw new JsonIOException(var4);
      } catch (NumberFormatException var5) {
         throw new JsonSyntaxException(var5);
      }
   }

   public static Writer a(Appendable var0) {
      if (var0 instanceof Writer) {
         var0 = var0;
      } else {
         var0 = new Streams.AppendableWriter(var0);
      }

      return var0;
   }

   public static void a(JsonElement var0, JsonWriter var1) throws IOException {
      TypeAdapters.X.write(var1, var0);
   }

   private static final class AppendableWriter extends Writer {
      private final Appendable a;
      private final Streams.AppendableWriter.CurrentWrite b = new Streams.AppendableWriter.CurrentWrite();

      AppendableWriter(Appendable var1) {
         this.a = var1;
      }

      @Override
      public void close() {
      }

      @Override
      public void flush() {
      }

      @Override
      public void write(int var1) throws IOException {
         this.a.append((char)var1);
      }

      @Override
      public void write(char[] var1, int var2, int var3) throws IOException {
         this.b.a = var1;
         this.a.append(this.b, var2, var2 + var3);
      }

      static class CurrentWrite implements CharSequence {
         char[] a;

         @Override
         public char charAt(int var1) {
            return this.a[var1];
         }

         @Override
         public int length() {
            return this.a.length;
         }

         @Override
         public CharSequence subSequence(int var1, int var2) {
            return new String(this.a, var1, var2 - var1);
         }
      }
   }
}
