package com.amazonaws.util;

public enum Base64 {
   private static final Base64[] $VALUES = new Base64[0];
   private static final Base64Codec codec = new Base64Codec();

   public static String encodeAsString(byte... var0) {
      String var1;
      if (var0 == null) {
         var1 = null;
      } else if (var0.length == 0) {
         var1 = "";
      } else {
         var1 = CodecUtils.toStringDirect(codec.encode(var0));
      }

      return var1;
   }
}
