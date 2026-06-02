package com.fasterxml.jackson.core;

public enum JsonToken {
   END_ARRAY("]", 4),
   END_OBJECT("}", 2),
   FIELD_NAME(null, 5),
   NOT_AVAILABLE(null, -1),
   START_ARRAY("[", 3),
   START_OBJECT("{", 1),
   VALUE_EMBEDDED_OBJECT(null, 12),
   VALUE_FALSE("false", 10),
   VALUE_NULL("null", 11),
   VALUE_NUMBER_FLOAT(null, 8),
   VALUE_NUMBER_INT(null, 7),
   VALUE_STRING(null, 6),
   VALUE_TRUE("true", 9);

   private static final JsonToken[] $VALUES = new JsonToken[]{
      JsonToken.NOT_AVAILABLE,
      JsonToken.START_OBJECT,
      JsonToken.END_OBJECT,
      JsonToken.START_ARRAY,
      JsonToken.END_ARRAY,
      JsonToken.FIELD_NAME,
      JsonToken.VALUE_EMBEDDED_OBJECT,
      JsonToken.VALUE_STRING,
      JsonToken.VALUE_NUMBER_INT,
      JsonToken.VALUE_NUMBER_FLOAT,
      JsonToken.VALUE_TRUE,
      JsonToken.VALUE_FALSE,
      JsonToken.VALUE_NULL
   };
   final int _id;
   final boolean _isBoolean;
   final boolean _isNumber;
   final boolean _isScalar;
   final boolean _isStructEnd;
   final boolean _isStructStart;
   final String _serialized;
   final byte[] _serializedBytes;
   final char[] _serializedChars;

   JsonToken(String var3, int var4) {
      boolean var7 = true;
      super(var1, var2);
      if (var3 == null) {
         this._serialized = null;
         this._serializedChars = null;
         this._serializedBytes = null;
      } else {
         this._serialized = var3;
         this._serializedChars = var3.toCharArray();
         int var5 = this._serializedChars.length;
         this._serializedBytes = new byte[var5];

         for (int var8 = 0; var8 < var5; var8++) {
            this._serializedBytes[var8] = (byte)this._serializedChars[var8];
         }
      }

      this._id = var4;
      boolean var6;
      if (var4 != 10 && var4 != 9) {
         var6 = false;
      } else {
         var6 = true;
      }

      this._isBoolean = var6;
      if (var4 != 7 && var4 != 8) {
         var6 = false;
      } else {
         var6 = true;
      }

      this._isNumber = var6;
      if (var4 != 1 && var4 != 3) {
         var6 = false;
      } else {
         var6 = true;
      }

      this._isStructStart = var6;
      if (var4 != 2 && var4 != 4) {
         var6 = false;
      } else {
         var6 = true;
      }

      this._isStructEnd = var6;
      if (!this._isStructStart && !this._isStructEnd && var4 != 5 && var4 != -1) {
         var6 = var7;
      } else {
         var6 = false;
      }

      this._isScalar = var6;
   }

   public final byte[] asByteArray() {
      return this._serializedBytes;
   }

   public final char[] asCharArray() {
      return this._serializedChars;
   }

   public final String asString() {
      return this._serialized;
   }

   public final int id() {
      return this._id;
   }

   public final boolean isBoolean() {
      return this._isBoolean;
   }

   public final boolean isNumeric() {
      return this._isNumber;
   }

   public final boolean isScalarValue() {
      return this._isScalar;
   }

   public final boolean isStructEnd() {
      return this._isStructEnd;
   }

   public final boolean isStructStart() {
      return this._isStructStart;
   }
}
