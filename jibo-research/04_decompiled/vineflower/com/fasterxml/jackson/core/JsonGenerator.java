package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.util.VersionUtil;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class JsonGenerator implements Closeable, Flushable {
   protected PrettyPrinter a;

   protected JsonGenerator() {
   }

   public JsonGenerator a(int var1) {
      return this;
   }

   public JsonGenerator a(PrettyPrinter var1) {
      this.a = var1;
      return this;
   }

   public JsonGenerator a(SerializableString var1) {
      throw new UnsupportedOperationException();
   }

   public JsonGenerator a(CharacterEscapes var1) {
      return this;
   }

   public PrettyPrinter a() {
      return this.a;
   }

   public abstract void a(char var1) throws IOException;

   public abstract void a(double var1) throws IOException;

   public abstract void a(float var1) throws IOException;

   public abstract void a(long var1) throws IOException;

   public abstract void a(String var1) throws IOException;

   public abstract void a(BigDecimal var1) throws IOException;

   public abstract void a(BigInteger var1) throws IOException;

   public abstract void a(boolean var1) throws IOException;

   public abstract void a(char[] var1, int var2, int var3) throws IOException;

   public abstract JsonGenerator b();

   public abstract void b(int var1) throws IOException;

   public void b(SerializableString var1) throws IOException {
      this.c(var1.a());
   }

   public abstract void b(String var1) throws IOException;

   public abstract void c() throws IOException;

   public abstract void c(String var1) throws IOException;

   @Override
   public abstract void close() throws IOException;

   public abstract void d() throws IOException;

   public abstract void d(String var1) throws IOException;

   public abstract void e() throws IOException;

   protected void e(String var1) throws JsonGenerationException {
      throw new JsonGenerationException(var1);
   }

   public abstract void f() throws IOException;

   @Override
   public abstract void flush() throws IOException;

   public abstract void g() throws IOException;

   protected final void h() {
      VersionUtil.a();
   }

   public enum Feature {
      AUTO_CLOSE_JSON_CONTENT(true),
      AUTO_CLOSE_TARGET(true),
      ESCAPE_NON_ASCII(false),
      FLUSH_PASSED_TO_STREAM(true),
      IGNORE_UNKNOWN(false),
      QUOTE_FIELD_NAMES(true),
      QUOTE_NON_NUMERIC_NUMBERS(true),
      STRICT_DUPLICATE_DETECTION(false),
      WRITE_BIGDECIMAL_AS_PLAIN(false),
      WRITE_NUMBERS_AS_STRINGS(false);

      private static final JsonGenerator.Feature[] $VALUES = new JsonGenerator.Feature[]{
         JsonGenerator.Feature.AUTO_CLOSE_TARGET,
         JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT,
         JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM,
         JsonGenerator.Feature.QUOTE_FIELD_NAMES,
         JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS,
         JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS,
         JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN,
         JsonGenerator.Feature.ESCAPE_NON_ASCII,
         JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION,
         JsonGenerator.Feature.IGNORE_UNKNOWN
      };
      private final boolean _defaultState;
      private final int _mask;

      Feature(boolean var3) {
         this._defaultState = var3;
         this._mask = 1 << this.ordinal();
      }

      public static int collectDefaults() {
         int var2 = 0;
         JsonGenerator.Feature[] var5 = values();
         int var3 = var5.length;
         int var0 = 0;

         while (var0 < var3) {
            JsonGenerator.Feature var4 = var5[var0];
            int var1 = var2;
            if (var4.enabledByDefault()) {
               var1 = var2 | var4.getMask();
            }

            var0++;
            var2 = var1;
         }

         return var2;
      }

      public boolean enabledByDefault() {
         return this._defaultState;
      }

      public boolean enabledIn(int var1) {
         boolean var2;
         if ((this._mask & var1) != 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      public int getMask() {
         return this._mask;
      }
   }
}
