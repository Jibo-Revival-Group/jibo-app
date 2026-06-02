package com.mixpanel.android.java_websocket.util;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

public class Charsetfunctions {
   public static CodingErrorAction a = CodingErrorAction.REPORT;

   public static String a(ByteBuffer var0) throws InvalidDataException {
      CharsetDecoder var1 = Charset.forName("UTF8").newDecoder();
      var1.onMalformedInput(a);
      var1.onUnmappableCharacter(a);

      try {
         ((Buffer)var0).mark();
         String var3 = var1.decode(var0).toString();
         ((Buffer)var0).reset();
         return var3;
      } catch (CharacterCodingException var2) {
         throw new InvalidDataException(1007, var2);
      }
   }

   public static String a(byte[] var0, int var1, int var2) {
      try {
         return new String(var0, var1, var2, "ASCII");
      } catch (UnsupportedEncodingException var3) {
         throw new RuntimeException(var3);
      }
   }

   public static byte[] a(String var0) {
      try {
         return var0.getBytes("UTF8");
      } catch (UnsupportedEncodingException var1) {
         throw new RuntimeException(var1);
      }
   }

   public static byte[] b(String var0) {
      try {
         return var0.getBytes("ASCII");
      } catch (UnsupportedEncodingException var1) {
         throw new RuntimeException(var1);
      }
   }
}
