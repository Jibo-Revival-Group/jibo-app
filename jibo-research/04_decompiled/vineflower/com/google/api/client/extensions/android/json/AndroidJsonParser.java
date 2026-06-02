package com.google.api.client.extensions.android.json;

import android.annotation.TargetApi;
import android.util.JsonReader;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
@Beta
class AndroidJsonParser extends JsonParser {
   private List<String> currentNameStack = new ArrayList<>();
   private String currentText;
   private JsonToken currentToken;
   private final AndroidJsonFactory factory;
   private final JsonReader reader;

   AndroidJsonParser(AndroidJsonFactory var1, JsonReader var2) {
      this.factory = var1;
      this.reader = var2;
      var2.setLenient(true);
   }

   private void checkNumber() {
      boolean var1;
      if (this.currentToken != JsonToken.VALUE_NUMBER_INT && this.currentToken != JsonToken.VALUE_NUMBER_FLOAT) {
         var1 = false;
      } else {
         var1 = true;
      }

      Preconditions.checkArgument(var1);
   }

   @Override
   public void close() throws IOException {
      this.reader.close();
   }

   @Override
   public BigInteger getBigIntegerValue() {
      this.checkNumber();
      return new BigInteger(this.currentText);
   }

   @Override
   public byte getByteValue() {
      this.checkNumber();
      return Byte.valueOf(this.currentText);
   }

   @Override
   public String getCurrentName() {
      String var1;
      if (this.currentNameStack.isEmpty()) {
         var1 = null;
      } else {
         var1 = this.currentNameStack.get(this.currentNameStack.size() - 1);
      }

      return var1;
   }

   @Override
   public JsonToken getCurrentToken() {
      return this.currentToken;
   }

   @Override
   public BigDecimal getDecimalValue() {
      this.checkNumber();
      return new BigDecimal(this.currentText);
   }

   @Override
   public double getDoubleValue() {
      this.checkNumber();
      return Double.valueOf(this.currentText);
   }

   @Override
   public JsonFactory getFactory() {
      return this.factory;
   }

   @Override
   public float getFloatValue() {
      this.checkNumber();
      return Float.valueOf(this.currentText);
   }

   @Override
   public int getIntValue() {
      this.checkNumber();
      return Integer.valueOf(this.currentText);
   }

   @Override
   public long getLongValue() {
      this.checkNumber();
      return Long.valueOf(this.currentText);
   }

   @Override
   public short getShortValue() {
      this.checkNumber();
      return Short.valueOf(this.currentText);
   }

   @Override
   public String getText() {
      return this.currentText;
   }

   @Override
   public JsonToken nextToken() throws IOException {
      if (this.currentToken != null) {
         switch (<unrepresentable>.$SwitchMap$com$google$api$client$json$JsonToken[this.currentToken.ordinal()]) {
            case 1:
               this.reader.beginArray();
               this.currentNameStack.add(null);
               break;
            case 2:
               this.reader.beginObject();
               this.currentNameStack.add(null);
         }
      }

      android.util.JsonToken var1;
      try {
         var1 = this.reader.peek();
      } catch (EOFException var2) {
         var1 = android.util.JsonToken.END_DOCUMENT;
      }

      switch (<unrepresentable>.$SwitchMap$android$util$JsonToken[var1.ordinal()]) {
         case 1:
            this.currentText = "[";
            this.currentToken = JsonToken.START_ARRAY;
            break;
         case 2:
            this.currentText = "]";
            this.currentToken = JsonToken.END_ARRAY;
            this.currentNameStack.remove(this.currentNameStack.size() - 1);
            this.reader.endArray();
            break;
         case 3:
            this.currentText = "{";
            this.currentToken = JsonToken.START_OBJECT;
            break;
         case 4:
            this.currentText = "}";
            this.currentToken = JsonToken.END_OBJECT;
            this.currentNameStack.remove(this.currentNameStack.size() - 1);
            this.reader.endObject();
            break;
         case 5:
            if (this.reader.nextBoolean()) {
               this.currentText = "true";
               this.currentToken = JsonToken.VALUE_TRUE;
            } else {
               this.currentText = "false";
               this.currentToken = JsonToken.VALUE_FALSE;
            }
            break;
         case 6:
            this.currentText = "null";
            this.currentToken = JsonToken.VALUE_NULL;
            this.reader.nextNull();
            break;
         case 7:
            this.currentText = this.reader.nextString();
            this.currentToken = JsonToken.VALUE_STRING;
            break;
         case 8:
            this.currentText = this.reader.nextString();
            JsonToken var3;
            if (this.currentText.indexOf(46) == -1) {
               var3 = JsonToken.VALUE_NUMBER_INT;
            } else {
               var3 = JsonToken.VALUE_NUMBER_FLOAT;
            }

            this.currentToken = var3;
            break;
         case 9:
            this.currentText = this.reader.nextName();
            this.currentToken = JsonToken.FIELD_NAME;
            this.currentNameStack.set(this.currentNameStack.size() - 1, this.currentText);
            break;
         default:
            this.currentText = null;
            this.currentToken = null;
      }

      return this.currentToken;
   }

   @Override
   public JsonParser skipChildren() throws IOException {
      if (this.currentToken != null) {
         switch (<unrepresentable>.$SwitchMap$com$google$api$client$json$JsonToken[this.currentToken.ordinal()]) {
            case 1:
               this.reader.skipValue();
               this.currentText = "]";
               this.currentToken = JsonToken.END_ARRAY;
               break;
            case 2:
               this.reader.skipValue();
               this.currentText = "}";
               this.currentToken = JsonToken.END_OBJECT;
         }
      }

      return this;
   }
}
