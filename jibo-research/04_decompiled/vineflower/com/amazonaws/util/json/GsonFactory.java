package com.amazonaws.util.json;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.EOFException;
import java.io.Reader;

final class GsonFactory implements AwsJsonFactory {
   private static AwsJsonToken convert(JsonToken var0) {
      AwsJsonToken var1 = null;
      if (var0 != null) {
         switch (<unrepresentable>.$SwitchMap$com$google$gson$stream$JsonToken[var0.ordinal()]) {
            case 1:
               var1 = AwsJsonToken.BEGIN_ARRAY;
               break;
            case 2:
               var1 = AwsJsonToken.END_ARRAY;
               break;
            case 3:
               var1 = AwsJsonToken.BEGIN_OBJECT;
               break;
            case 4:
               var1 = AwsJsonToken.END_OBJECT;
               break;
            case 5:
               var1 = AwsJsonToken.FIELD_NAME;
               break;
            case 6:
               var1 = AwsJsonToken.VALUE_BOOLEAN;
               break;
            case 7:
               var1 = AwsJsonToken.VALUE_NUMBER;
               break;
            case 8:
               var1 = AwsJsonToken.VALUE_NULL;
               break;
            case 9:
               var1 = AwsJsonToken.VALUE_STRING;
            case 10:
               break;
            default:
               var1 = AwsJsonToken.UNKNOWN;
         }
      }

      return var1;
   }

   @Override
   public AwsJsonReader getJsonReader(Reader var1) {
      return new GsonFactory.GsonReader(var1);
   }

   private static final class GsonReader implements AwsJsonReader {
      private Reader in;
      private final JsonReader reader;

      public GsonReader(Reader var1) {
         this.in = var1;
         this.reader = new JsonReader(var1);
      }

      @Override
      public void beginObject() {
         this.reader.c();
      }

      @Override
      public void close() {
         this.reader.close();
      }

      @Override
      public void endObject() {
         this.reader.d();
      }

      @Override
      public Reader getReader() {
         return this.in;
      }

      @Override
      public boolean hasNext() {
         return this.reader.e();
      }

      @Override
      public boolean isContainer() {
         JsonToken var2 = this.reader.f();
         boolean var1;
         if (!JsonToken.BEGIN_ARRAY.equals(var2) && !JsonToken.BEGIN_OBJECT.equals(var2)) {
            var1 = false;
         } else {
            var1 = true;
         }

         return var1;
      }

      @Override
      public String nextName() {
         return this.reader.g();
      }

      @Override
      public String nextString() {
         JsonToken var1 = this.reader.f();
         String var2;
         if (JsonToken.NULL.equals(var1)) {
            this.reader.j();
            var2 = null;
         } else if (JsonToken.BOOLEAN.equals(var1)) {
            if (this.reader.i()) {
               var2 = "true";
            } else {
               var2 = "false";
            }
         } else {
            var2 = this.reader.h();
         }

         return var2;
      }

      @Override
      public AwsJsonToken peek() {
         AwsJsonToken var1;
         try {
            var1 = GsonFactory.convert(this.reader.f());
         } catch (EOFException var2) {
            var1 = null;
         }

         return var1;
      }

      @Override
      public void skipValue() {
         this.reader.n();
      }
   }
}
