package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.io.CharTypes;

public final class JsonReadContext extends JsonStreamContext {
   protected final JsonReadContext c;
   protected DupDetector d;
   protected JsonReadContext e = null;
   protected String f;
   protected Object g;
   protected int h;
   protected int i;

   public JsonReadContext(JsonReadContext var1, DupDetector var2, int var3, int var4, int var5) {
      this.c = var1;
      this.d = var2;
      this.a = var3;
      this.h = var4;
      this.i = var5;
      this.b = -1;
   }

   public static JsonReadContext a(DupDetector var0) {
      return new JsonReadContext(null, var0, 0, 1, 0);
   }

   private void a(DupDetector var1, String var2) throws JsonProcessingException {
      if (var1.a(var2)) {
         throw new JsonParseException("Duplicate field '" + var2 + "'", var1.c());
      }
   }

   public JsonLocation a(Object var1) {
      return new JsonLocation(var1, -1L, this.h, this.i);
   }

   public JsonReadContext a(int var1, int var2) {
      JsonReadContext var3 = this.e;
      if (var3 == null) {
         DupDetector var4;
         if (this.d == null) {
            var4 = null;
         } else {
            var4 = this.d.a();
         }

         var3 = new JsonReadContext(this, var4, 1, var1, var2);
         this.e = var3;
      } else {
         var3.a(1, var1, var2);
      }

      return var3;
   }

   protected void a(int var1, int var2, int var3) {
      this.a = var1;
      this.b = -1;
      this.h = var2;
      this.i = var3;
      this.f = null;
      this.g = null;
      if (this.d != null) {
         this.d.b();
      }
   }

   public void a(String var1) throws JsonProcessingException {
      this.f = var1;
      if (this.d != null) {
         this.a(this.d, var1);
      }
   }

   public JsonReadContext b(int var1, int var2) {
      JsonReadContext var3 = this.e;
      if (var3 == null) {
         DupDetector var4;
         if (this.d == null) {
            var4 = null;
         } else {
            var4 = this.d.a();
         }

         var3 = new JsonReadContext(this, var4, 2, var1, var2);
         this.e = var3;
      } else {
         var3.a(2, var1, var2);
      }

      return var3;
   }

   public String g() {
      return this.f;
   }

   public JsonReadContext h() {
      return this.c;
   }

   public boolean i() {
      int var1 = this.b + 1;
      this.b = var1;
      boolean var2;
      if (this.a != 0 && var1 > 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder(64);
      switch (this.a) {
         case 0:
            var1.append("/");
            break;
         case 1:
            var1.append('[');
            var1.append(this.f());
            var1.append(']');
            break;
         case 2:
            var1.append('{');
            if (this.f != null) {
               var1.append('"');
               CharTypes.a(var1, this.f);
               var1.append('"');
            } else {
               var1.append('?');
            }

            var1.append('}');
      }

      return var1.toString();
   }
}
