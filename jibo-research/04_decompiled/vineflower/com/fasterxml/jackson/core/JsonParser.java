package com.fasterxml.jackson.core;

import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class JsonParser implements Closeable {
   protected int a;

   protected JsonParser() {
   }

   protected JsonParser(int var1) {
      this.a = var1;
   }

   protected JsonParseException a(String var1) {
      return new JsonParseException(var1, this.e());
   }

   public abstract JsonToken a() throws IOException, JsonParseException;

   public boolean a(JsonParser.Feature var1) {
      return var1.enabledIn(this.a);
   }

   public abstract JsonParser b() throws IOException, JsonParseException;

   public abstract JsonToken c();

   @Override
   public abstract void close() throws IOException;

   public abstract String d() throws IOException;

   public abstract JsonLocation e();

   public abstract String f() throws IOException;

   public byte g() throws IOException {
      int var1 = this.i();
      if (var1 >= -128 && var1 <= 255) {
         return (byte)var1;
      } else {
         throw this.a("Numeric value (" + this.f() + ") out of range of Java byte");
      }
   }

   public short h() throws IOException {
      int var1 = this.i();
      if (var1 >= -32768 && var1 <= 32767) {
         return (short)var1;
      } else {
         throw this.a("Numeric value (" + this.f() + ") out of range of Java short");
      }
   }

   public abstract int i() throws IOException;

   public abstract long j() throws IOException;

   public abstract BigInteger k() throws IOException;

   public abstract float l() throws IOException;

   public abstract double m() throws IOException;

   public abstract BigDecimal n() throws IOException;

   public enum Feature {
      ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false),
      ALLOW_COMMENTS(false),
      ALLOW_NON_NUMERIC_NUMBERS(false),
      ALLOW_NUMERIC_LEADING_ZEROS(false),
      ALLOW_SINGLE_QUOTES(false),
      ALLOW_UNQUOTED_CONTROL_CHARS(false),
      ALLOW_UNQUOTED_FIELD_NAMES(false),
      ALLOW_YAML_COMMENTS(false),
      AUTO_CLOSE_SOURCE(true),
      IGNORE_UNDEFINED(false),
      STRICT_DUPLICATE_DETECTION(false);

      private static final JsonParser.Feature[] $VALUES = new JsonParser.Feature[]{
         JsonParser.Feature.AUTO_CLOSE_SOURCE,
         JsonParser.Feature.ALLOW_COMMENTS,
         JsonParser.Feature.ALLOW_YAML_COMMENTS,
         JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES,
         JsonParser.Feature.ALLOW_SINGLE_QUOTES,
         JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS,
         JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER,
         JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS,
         JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS,
         JsonParser.Feature.STRICT_DUPLICATE_DETECTION,
         JsonParser.Feature.IGNORE_UNDEFINED
      };
      private final boolean _defaultState;
      private final int _mask = 1 << this.ordinal();

      Feature(boolean var3) {
         this._defaultState = var3;
      }

      public static int collectDefaults() {
         int var1 = 0;
         JsonParser.Feature[] var5 = values();
         int var3 = var5.length;
         int var0 = 0;

         while (var0 < var3) {
            JsonParser.Feature var4 = var5[var0];
            int var2 = var1;
            if (var4.enabledByDefault()) {
               var2 = var1 | var4.getMask();
            }

            var0++;
            var1 = var2;
         }

         return var1;
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
