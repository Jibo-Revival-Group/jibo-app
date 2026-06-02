package com.fasterxml.jackson.core;

public enum JsonEncoding {
   UTF16_BE("UTF-16BE", true, 16),
   UTF16_LE("UTF-16LE", false, 16),
   UTF32_BE("UTF-32BE", true, 32),
   UTF32_LE("UTF-32LE", false, 32),
   UTF8("UTF-8", false, 8);

   private static final JsonEncoding[] $VALUES = new JsonEncoding[]{
      JsonEncoding.UTF8, JsonEncoding.UTF16_BE, JsonEncoding.UTF16_LE, JsonEncoding.UTF32_BE, JsonEncoding.UTF32_LE
   };
   protected final boolean _bigEndian;
   protected final int _bits;
   protected final String _javaName;

   JsonEncoding(String var3, boolean var4, int var5) {
      this._javaName = var3;
      this._bigEndian = var4;
      this._bits = var5;
   }

   public int bits() {
      return this._bits;
   }

   public String getJavaName() {
      return this._javaName;
   }

   public boolean isBigEndian() {
      return this._bigEndian;
   }
}
