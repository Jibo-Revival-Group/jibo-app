package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class JsonParser {
   public JsonElement a(JsonReader var1) throws JsonIOException, JsonSyntaxException {
      boolean var2 = var1.q();
      var1.a(true);

      try {
         return Streams.a(var1);
      } catch (StackOverflowError var9) {
         StringBuilder var12 = new StringBuilder();
         JsonParseException var13 = new JsonParseException(var12.append("Failed parsing JSON source: ").append(var1).append(" to Json").toString(), var9);
         throw var13;
      } catch (OutOfMemoryError var10) {
         StringBuilder var3 = new StringBuilder();
         JsonParseException var5 = new JsonParseException(var3.append("Failed parsing JSON source: ").append(var1).append(" to Json").toString(), var10);
         throw var5;
      } finally {
         var1.a(var2);
      }
   }

   public JsonElement a(Reader var1) throws JsonIOException, JsonSyntaxException {
      try {
         JsonReader var2 = new JsonReader(var1);
         JsonElement var6 = this.a(var2);
         if (!var6.k() && var2.f() != JsonToken.END_DOCUMENT) {
            JsonSyntaxException var7 = new JsonSyntaxException("Did not consume the entire document.");
            throw var7;
         } else {
            return var6;
         }
      } catch (MalformedJsonException var3) {
         throw new JsonSyntaxException(var3);
      } catch (IOException var4) {
         throw new JsonIOException(var4);
      } catch (NumberFormatException var5) {
         throw new JsonSyntaxException(var5);
      }
   }

   public JsonElement a(String var1) throws JsonSyntaxException {
      return this.a(new StringReader(var1));
   }
}
