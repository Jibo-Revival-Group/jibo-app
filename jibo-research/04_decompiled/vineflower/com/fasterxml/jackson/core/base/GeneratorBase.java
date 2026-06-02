package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.json.DupDetector;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import java.io.IOException;

public abstract class GeneratorBase extends JsonGenerator {
   protected static final int b = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS.getMask()
      | JsonGenerator.Feature.ESCAPE_NON_ASCII.getMask()
      | JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION.getMask();
   protected final String c = "write a binary value";
   protected final String d = "write a boolean value";
   protected final String e = "write a null";
   protected final String f = "write a number";
   protected final String g = "write a raw (unencoded) value";
   protected final String h = "write a string";
   protected ObjectCodec i;
   protected int j;
   protected boolean k;
   protected JsonWriteContext l;
   protected boolean m;

   protected GeneratorBase(int var1, ObjectCodec var2) {
      this.j = var1;
      this.i = var2;
      DupDetector var3;
      if (JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(var1)) {
         var3 = DupDetector.a(this);
      } else {
         var3 = null;
      }

      this.l = JsonWriteContext.a(var3);
      this.k = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS.enabledIn(var1);
   }

   protected final int a(int var1, int var2) throws IOException {
      if (var2 < 56320 || var2 > 57343) {
         this.e("Incomplete surrogate pair: first char 0x" + Integer.toHexString(var1) + ", second 0x" + Integer.toHexString(var2));
      }

      return 65536 + (var1 - 55296 << 10) + (var2 - 56320);
   }

   public final boolean a(JsonGenerator.Feature var1) {
      boolean var2;
      if ((this.j & var1.getMask()) != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public JsonGenerator b() {
      JsonGenerator var1;
      if (this.a() != null) {
         var1 = this;
      } else {
         var1 = this.a(this.k());
      }

      return var1;
   }

   @Override
   public void close() throws IOException {
      this.m = true;
   }

   protected abstract void f(String var1) throws IOException;

   public final JsonWriteContext i() {
      return this.l;
   }

   protected abstract void j();

   protected PrettyPrinter k() {
      return new DefaultPrettyPrinter();
   }
}
