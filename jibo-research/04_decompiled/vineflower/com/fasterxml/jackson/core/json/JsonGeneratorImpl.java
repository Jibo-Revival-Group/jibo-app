package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

public abstract class JsonGeneratorImpl extends GeneratorBase {
   protected static final int[] n = CharTypes.f();
   protected final IOContext o;
   protected int[] p = n;
   protected int q;
   protected CharacterEscapes r;
   protected SerializableString s = DefaultPrettyPrinter.a;

   public JsonGeneratorImpl(IOContext var1, int var2, ObjectCodec var3) {
      super(var2, var3);
      this.o = var1;
      if (this.a(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
         this.a(127);
      }
   }

   @Override
   public JsonGenerator a(int var1) {
      int var2 = var1;
      if (var1 < 0) {
         var2 = 0;
      }

      this.q = var2;
      return this;
   }

   @Override
   public JsonGenerator a(SerializableString var1) {
      this.s = var1;
      return this;
   }

   @Override
   public JsonGenerator a(CharacterEscapes var1) {
      this.r = var1;
      if (var1 == null) {
         this.p = n;
      } else {
         this.p = var1.a();
      }

      return this;
   }
}
