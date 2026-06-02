package org.apache.http.impl;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import org.apache.http.config.ConnectionConfig;

public final class ConnSupport {
   public static CharsetDecoder createDecoder(ConnectionConfig var0) {
      CharsetDecoder var4;
      if (var0 == null) {
         var4 = null;
      } else {
         Charset var3 = var0.getCharset();
         CodingErrorAction var2 = var0.getMalformedInputAction();
         CodingErrorAction var1 = var0.getUnmappableInputAction();
         if (var3 != null) {
            CharsetDecoder var8 = var3.newDecoder();
            CodingErrorAction var5;
            if (var2 != null) {
               var5 = var2;
            } else {
               var5 = CodingErrorAction.REPORT;
            }

            CharsetDecoder var7 = var8.onMalformedInput(var5);
            CodingErrorAction var6;
            if (var1 != null) {
               var6 = var1;
            } else {
               var6 = CodingErrorAction.REPORT;
            }

            var4 = var7.onUnmappableCharacter(var6);
         } else {
            var4 = null;
         }
      }

      return var4;
   }

   public static CharsetEncoder createEncoder(ConnectionConfig var0) {
      CharsetEncoder var1 = null;
      if (var0 != null) {
         Charset var3 = var0.getCharset();
         if (var3 != null) {
            CodingErrorAction var2 = var0.getMalformedInputAction();
            CodingErrorAction var6 = var0.getUnmappableInputAction();
            CharsetEncoder var8 = var3.newEncoder();
            CodingErrorAction var4;
            if (var2 != null) {
               var4 = var2;
            } else {
               var4 = CodingErrorAction.REPORT;
            }

            CharsetEncoder var7 = var8.onMalformedInput(var4);
            CodingErrorAction var5;
            if (var6 != null) {
               var5 = var6;
            } else {
               var5 = CodingErrorAction.REPORT;
            }

            var1 = var7.onUnmappableCharacter(var5);
         }
      }

      return var1;
   }
}
