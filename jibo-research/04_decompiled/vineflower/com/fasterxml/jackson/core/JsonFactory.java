package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.InputDecorator;
import com.fasterxml.jackson.core.io.OutputDecorator;
import com.fasterxml.jackson.core.io.UTF8Writer;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.Writer;
import java.lang.ref.SoftReference;

public class JsonFactory implements Serializable {
   protected static final int a = JsonFactory.Feature.collectDefaults();
   protected static final int b = JsonParser.Feature.collectDefaults();
   protected static final int c = JsonGenerator.Feature.collectDefaults();
   protected static final ThreadLocal<SoftReference<BufferRecycler>> d = new ThreadLocal<>();
   private static final SerializableString p = DefaultPrettyPrinter.a;
   protected final transient CharsToNameCanonicalizer e = CharsToNameCanonicalizer.a();
   protected final transient ByteQuadsCanonicalizer f = ByteQuadsCanonicalizer.a();
   @Deprecated
   protected final transient BytesToNameCanonicalizer g = BytesToNameCanonicalizer.a();
   protected ObjectCodec h;
   protected int i = a;
   protected int j = b;
   protected int k = c;
   protected CharacterEscapes l;
   protected InputDecorator m;
   protected OutputDecorator n;
   protected SerializableString o = p;

   public JsonFactory() {
      this(null);
   }

   protected JsonFactory(JsonFactory var1, ObjectCodec var2) {
      this.h = null;
      this.i = var1.i;
      this.j = var1.j;
      this.k = var1.k;
      this.l = var1.l;
      this.m = var1.m;
      this.n = var1.n;
      this.o = var1.o;
   }

   public JsonFactory(ObjectCodec var1) {
      this.h = var1;
   }

   public JsonFactory a(JsonGenerator.Feature var1) {
      this.k = this.k | var1.getMask();
      return this;
   }

   public final JsonFactory a(JsonGenerator.Feature var1, boolean var2) {
      JsonFactory var3;
      if (var2) {
         var3 = this.a(var1);
      } else {
         var3 = this.b(var1);
      }

      return var3;
   }

   public JsonGenerator a(OutputStream var1, JsonEncoding var2) throws IOException {
      IOContext var3 = this.a(var1, false);
      var3.a(var2);
      JsonGenerator var4;
      if (var2 == JsonEncoding.UTF8) {
         var4 = this.a(this.b(var1, var3), var3);
      } else {
         var4 = this.a(this.b(this.a(var1, var2, var3), var3), var3);
      }

      return var4;
   }

   protected JsonGenerator a(OutputStream var1, IOContext var2) throws IOException {
      UTF8JsonGenerator var3 = new UTF8JsonGenerator(var2, this.k, this.h, var1);
      if (this.l != null) {
         var3.a(this.l);
      }

      SerializableString var4 = this.o;
      if (var4 != p) {
         var3.a(var4);
      }

      return var3;
   }

   public JsonGenerator a(Writer var1) throws IOException {
      IOContext var2 = this.a(var1, false);
      return this.a(this.b(var1, var2), var2);
   }

   protected JsonGenerator a(Writer var1, IOContext var2) throws IOException {
      WriterBasedJsonGenerator var3 = new WriterBasedJsonGenerator(var2, this.k, this.h, var1);
      if (this.l != null) {
         var3.a(this.l);
      }

      SerializableString var4 = this.o;
      if (var4 != p) {
         var3.a(var4);
      }

      return var3;
   }

   public JsonParser a(InputStream var1) throws IOException, JsonParseException {
      IOContext var2 = this.a(var1, false);
      return this.a(this.b(var1, var2), var2);
   }

   protected JsonParser a(InputStream var1, IOContext var2) throws IOException {
      return new ByteSourceJsonBootstrapper(var2, var1).a(this.j, this.h, this.f, this.e, this.i);
   }

   public JsonParser a(Reader var1) throws IOException, JsonParseException {
      IOContext var2 = this.a(var1, false);
      return this.a(this.b(var1, var2), var2);
   }

   protected JsonParser a(Reader var1, IOContext var2) throws IOException {
      return new ReaderBasedJsonParser(var2, this.j, var1, this.h, this.e.b(this.i));
   }

   public JsonParser a(String var1) throws IOException, JsonParseException {
      int var2 = var1.length();
      JsonParser var5;
      if (this.m == null && var2 <= 32768 && this.a()) {
         IOContext var3 = this.a(var1, true);
         char[] var4 = var3.a(var2);
         var1.getChars(0, var2, var4, 0);
         var5 = this.a(var4, 0, var2, var3, true);
      } else {
         var5 = this.a(new StringReader(var1));
      }

      return var5;
   }

   protected JsonParser a(char[] var1, int var2, int var3, IOContext var4, boolean var5) throws IOException {
      return new ReaderBasedJsonParser(var4, this.j, null, this.h, this.e.b(this.i), var1, var2, var2 + var3, var5);
   }

   protected IOContext a(Object var1, boolean var2) {
      return new IOContext(this.b(), var1, var2);
   }

   protected Writer a(OutputStream var1, JsonEncoding var2, IOContext var3) throws IOException {
      Writer var4;
      if (var2 == JsonEncoding.UTF8) {
         var4 = new UTF8Writer(var3, var1);
      } else {
         var4 = new OutputStreamWriter(var1, var2.getJavaName());
      }

      return var4;
   }

   public boolean a() {
      return true;
   }

   public final boolean a(JsonFactory.Feature var1) {
      boolean var2;
      if ((this.i & var1.getMask()) != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public JsonFactory b(JsonGenerator.Feature var1) {
      this.k = this.k & ~var1.getMask();
      return this;
   }

   @Deprecated
   public JsonGenerator b(OutputStream var1, JsonEncoding var2) throws IOException {
      return this.a(var1, var2);
   }

   @Deprecated
   public JsonGenerator b(Writer var1) throws IOException {
      return this.a(var1);
   }

   @Deprecated
   public JsonParser b(InputStream var1) throws IOException, JsonParseException {
      return this.a(var1);
   }

   @Deprecated
   public JsonParser b(Reader var1) throws IOException, JsonParseException {
      return this.a(var1);
   }

   @Deprecated
   public JsonParser b(String var1) throws IOException, JsonParseException {
      return this.a(var1);
   }

   public BufferRecycler b() {
      BufferRecycler var2;
      if (this.a(JsonFactory.Feature.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING)) {
         SoftReference var1 = d.get();
         BufferRecycler var3;
         if (var1 == null) {
            var3 = null;
         } else {
            var3 = (BufferRecycler)var1.get();
         }

         var2 = var3;
         if (var3 == null) {
            var2 = new BufferRecycler();
            d.set(new SoftReference<>(var2));
         }
      } else {
         var2 = new BufferRecycler();
      }

      return var2;
   }

   protected final InputStream b(InputStream var1, IOContext var2) throws IOException {
      InputStream var3 = var1;
      if (this.m != null) {
         InputStream var4 = this.m.a(var2, var1);
         var3 = var1;
         if (var4 != null) {
            var3 = var4;
         }
      }

      return var3;
   }

   protected final OutputStream b(OutputStream var1, IOContext var2) throws IOException {
      OutputStream var3 = var1;
      if (this.n != null) {
         OutputStream var4 = this.n.a(var2, var1);
         var3 = var1;
         if (var4 != null) {
            var3 = var4;
         }
      }

      return var3;
   }

   protected final Reader b(Reader var1, IOContext var2) throws IOException {
      Reader var3 = var1;
      if (this.m != null) {
         Reader var4 = this.m.a(var2, var1);
         var3 = var1;
         if (var4 != null) {
            var3 = var4;
         }
      }

      return var3;
   }

   protected final Writer b(Writer var1, IOContext var2) throws IOException {
      Writer var3 = var1;
      if (this.n != null) {
         Writer var4 = this.n.a(var2, var1);
         var3 = var1;
         if (var4 != null) {
            var3 = var4;
         }
      }

      return var3;
   }

   protected Object readResolve() {
      return new JsonFactory(this, this.h);
   }

   public enum Feature {
      CANONICALIZE_FIELD_NAMES(true),
      FAIL_ON_SYMBOL_HASH_OVERFLOW(true),
      INTERN_FIELD_NAMES(true),
      USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING(true);

      private static final JsonFactory.Feature[] $VALUES = new JsonFactory.Feature[]{
         JsonFactory.Feature.INTERN_FIELD_NAMES,
         JsonFactory.Feature.CANONICALIZE_FIELD_NAMES,
         JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW,
         JsonFactory.Feature.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING
      };
      private final boolean _defaultState;

      Feature(boolean var3) {
         this._defaultState = var3;
      }

      public static int collectDefaults() {
         int var2 = 0;
         JsonFactory.Feature[] var4 = values();
         int var3 = var4.length;
         int var0 = 0;

         while (var0 < var3) {
            JsonFactory.Feature var5 = var4[var0];
            int var1 = var2;
            if (var5.enabledByDefault()) {
               var1 = var2 | var5.getMask();
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
         if ((this.getMask() & var1) != 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      public int getMask() {
         return 1 << this.ordinal();
      }
   }
}
