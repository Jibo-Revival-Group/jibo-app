package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;

public class JsonWriteContext extends JsonStreamContext {
   protected final JsonWriteContext c;
   protected DupDetector d;
   protected JsonWriteContext e = null;
   protected String f;
   protected Object g;
   protected boolean h;

   protected JsonWriteContext(int var1, JsonWriteContext var2, DupDetector var3) {
      this.a = var1;
      this.c = var2;
      this.d = var3;
      this.b = -1;
   }

   public static JsonWriteContext a(DupDetector var0) {
      return new JsonWriteContext(0, null, var0);
   }

   private final void a(DupDetector var1, String var2) throws JsonProcessingException {
      if (var1.a(var2)) {
         throw new JsonGenerationException("Duplicate field '" + var2 + "'");
      }
   }

   public int a(String var1) throws JsonProcessingException {
      byte var2 = 1;
      if (this.h) {
         var2 = 4;
      } else {
         this.h = true;
         this.f = var1;
         if (this.d != null) {
            this.a(this.d, var1);
         }

         if (this.b < 0) {
            var2 = 0;
         }
      }

      return var2;
   }

   protected JsonWriteContext a(int var1) {
      this.a = var1;
      this.b = -1;
      this.f = null;
      this.h = false;
      this.g = null;
      if (this.d != null) {
         this.d.b();
      }

      return this;
   }

   protected void a(StringBuilder var1) {
      if (this.a == 2) {
         var1.append('{');
         if (this.f != null) {
            var1.append('"');
            var1.append(this.f);
            var1.append('"');
         } else {
            var1.append('?');
         }

         var1.append('}');
      } else if (this.a == 1) {
         var1.append('[');
         var1.append(this.f());
         var1.append(']');
      } else {
         var1.append("/");
      }
   }

   public JsonWriteContext g() {
      JsonWriteContext var1 = this.e;
      if (var1 == null) {
         DupDetector var2;
         if (this.d == null) {
            var2 = null;
         } else {
            var2 = this.d.a();
         }

         var1 = new JsonWriteContext(1, this, var2);
         this.e = var1;
      } else {
         var1 = var1.a(1);
      }

      return var1;
   }

   public JsonWriteContext h() {
      JsonWriteContext var1 = this.e;
      if (var1 == null) {
         DupDetector var2;
         if (this.d == null) {
            var2 = null;
         } else {
            var2 = this.d.a();
         }

         var1 = new JsonWriteContext(2, this, var2);
         this.e = var1;
      } else {
         var1 = var1.a(2);
      }

      return var1;
   }

   public final JsonWriteContext i() {
      return this.c;
   }

   public int j() {
      byte var1 = 0;
      if (this.a == 2) {
         if (!this.h) {
            var1 = 5;
         } else {
            this.h = false;
            this.b++;
            var1 = 2;
         }
      } else if (this.a == 1) {
         int var2 = this.b++;
         if (var2 >= 0) {
            var1 = 1;
         }
      } else {
         this.b++;
         if (this.b != 0) {
            var1 = 3;
         }
      }

      return var1;
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder(64);
      this.a(var1);
      return var1.toString();
   }
}
