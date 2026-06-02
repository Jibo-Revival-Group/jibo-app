package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.SerializedString;
import java.io.IOException;
import java.io.Serializable;

public class DefaultPrettyPrinter implements PrettyPrinter, Serializable {
   public static final SerializedString a = new SerializedString(" ");
   protected DefaultPrettyPrinter.Indenter b = DefaultPrettyPrinter.FixedSpaceIndenter.a;
   protected DefaultPrettyPrinter.Indenter c = DefaultIndenter.b;
   protected final SerializableString d;
   protected boolean e = true;
   protected transient int f = 0;

   public DefaultPrettyPrinter() {
      this(a);
   }

   public DefaultPrettyPrinter(SerializableString var1) {
      this.d = var1;
   }

   @Override
   public void a(JsonGenerator var1) throws IOException, JsonGenerationException {
      if (this.d != null) {
         var1.b(this.d);
      }
   }

   @Override
   public void a(JsonGenerator var1, int var2) throws IOException, JsonGenerationException {
      if (!this.c.a()) {
         this.f--;
      }

      if (var2 > 0) {
         this.c.a(var1, this.f);
      } else {
         var1.a(' ');
      }

      var1.a('}');
   }

   @Override
   public void b(JsonGenerator var1) throws IOException, JsonGenerationException {
      var1.a('{');
      if (!this.c.a()) {
         this.f++;
      }
   }

   @Override
   public void b(JsonGenerator var1, int var2) throws IOException {
      if (!this.b.a()) {
         this.f--;
      }

      if (var2 > 0) {
         this.b.a(var1, this.f);
      } else {
         var1.a(' ');
      }

      var1.a(']');
   }

   @Override
   public void c(JsonGenerator var1) throws IOException, JsonGenerationException {
      var1.a(',');
      this.c.a(var1, this.f);
   }

   @Override
   public void d(JsonGenerator var1) throws IOException, JsonGenerationException {
      if (this.e) {
         var1.c(" : ");
      } else {
         var1.a(':');
      }
   }

   @Override
   public void e(JsonGenerator var1) throws IOException, JsonGenerationException {
      if (!this.b.a()) {
         this.f++;
      }

      var1.a('[');
   }

   @Override
   public void f(JsonGenerator var1) throws IOException {
      var1.a(',');
      this.b.a(var1, this.f);
   }

   @Override
   public void g(JsonGenerator var1) throws IOException, JsonGenerationException {
      this.b.a(var1, this.f);
   }

   @Override
   public void h(JsonGenerator var1) throws IOException, JsonGenerationException {
      this.c.a(var1, this.f);
   }

   public static class FixedSpaceIndenter extends DefaultPrettyPrinter.NopIndenter {
      public static final DefaultPrettyPrinter.FixedSpaceIndenter a = new DefaultPrettyPrinter.FixedSpaceIndenter();

      @Override
      public void a(JsonGenerator var1, int var2) throws IOException {
         var1.a(' ');
      }

      @Override
      public boolean a() {
         return true;
      }
   }

   public interface Indenter {
      void a(JsonGenerator var1, int var2) throws IOException;

      boolean a();
   }

   public static class NopIndenter implements DefaultPrettyPrinter.Indenter, Serializable {
      public static final DefaultPrettyPrinter.NopIndenter c = new DefaultPrettyPrinter.NopIndenter();

      @Override
      public void a(JsonGenerator var1, int var2) throws IOException {
      }

      @Override
      public boolean a() {
         return true;
      }
   }
}
