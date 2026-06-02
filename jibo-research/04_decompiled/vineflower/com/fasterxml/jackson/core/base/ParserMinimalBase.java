package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.VersionUtil;
import java.io.IOException;

public abstract class ParserMinimalBase extends JsonParser {
   protected JsonToken K;

   protected ParserMinimalBase(int var1) {
      super(var1);
   }

   protected static final String d(int var0) {
      char var1 = (char)var0;
      String var2;
      if (Character.isISOControl(var1)) {
         var2 = "(CTRL-CHAR, code " + var0 + ")";
      } else if (var0 > 255) {
         var2 = "'" + var1 + "' (code " + var0 + " / 0x" + Integer.toHexString(var0) + ")";
      } else {
         var2 = "'" + var1 + "' (code " + var0 + ")";
      }

      return var2;
   }

   protected void E() throws JsonParseException {
      this.c(" in " + this.K);
   }

   protected void F() throws JsonParseException {
      this.c(" in a value");
   }

   protected final void G() {
      VersionUtil.a();
   }

   protected char a(char var1) throws JsonProcessingException {
      if (!this.a(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER) && (var1 != '\'' || !this.a(JsonParser.Feature.ALLOW_SINGLE_QUOTES))) {
         this.d("Unrecognized character escape " + d(var1));
      }

      return var1;
   }

   @Override
   public abstract JsonToken a() throws IOException;

   protected final void a(String var1, Throwable var2) throws JsonParseException {
      throw this.b(var1, var2);
   }

   protected final JsonParseException b(String var1, Throwable var2) {
      return new JsonParseException(var1, this.e(), var2);
   }

   @Override
   public JsonParser b() throws IOException {
      if (this.K == JsonToken.START_OBJECT || this.K == JsonToken.START_ARRAY) {
         int var1 = 1;

         while (true) {
            JsonToken var3 = this.a();
            if (var3 == null) {
               this.t();
               break;
            }

            if (var3.isStructStart()) {
               var1++;
            } else if (var3.isStructEnd()) {
               int var2 = var1 - 1;
               var1 = var2;
               if (var2 == 0) {
                  break;
               }
            }
         }
      }

      return this;
   }

   protected void b(int var1) throws JsonParseException {
      this.b(var1, "Expected space separating root-level values");
   }

   protected void b(int var1, String var2) throws JsonParseException {
      if (var1 < 0) {
         this.E();
      }

      String var4 = "Unexpected character (" + d(var1) + ")";
      String var3 = var4;
      if (var2 != null) {
         var3 = var4 + ": " + var2;
      }

      this.d(var3);
   }

   @Override
   public JsonToken c() {
      return this.K;
   }

   protected void c(int var1) throws JsonParseException {
      char var2 = (char)var1;
      this.d("Illegal character (" + d(var2) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
   }

   protected void c(int var1, String var2) throws JsonParseException {
      if (!this.a(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS) || var1 > 32) {
         char var3 = (char)var1;
         this.d("Illegal unquoted character (" + d(var3) + "): has to be escaped using backslash to be included in " + var2);
      }
   }

   protected void c(String var1) throws JsonParseException {
      this.d("Unexpected end-of-input" + var1);
   }

   protected final void d(String var1) throws JsonParseException {
      throw this.a(var1);
   }

   @Override
   public abstract String f() throws IOException;

   protected abstract void t() throws JsonParseException;
}
