package com.google.api.client.util.escape;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class CharEscapers {
   private static final Escaper URI_ESCAPER = new PercentEscaper("-_.*", true);
   private static final Escaper URI_PATH_ESCAPER = new PercentEscaper("-_.!~*'()@:$&,;=", false);
   private static final Escaper URI_QUERY_STRING_ESCAPER = new PercentEscaper("-_.!~*'()@:$,;/?:", false);
   private static final Escaper URI_RESERVED_ESCAPER = new PercentEscaper("-_.!~*'()@:$&,;=+/?", false);
   private static final Escaper URI_USERINFO_ESCAPER = new PercentEscaper("-_.!~*'():$&,;=", false);

   private CharEscapers() {
   }

   public static String decodeUri(String var0) {
      try {
         return URLDecoder.decode(var0, "UTF-8");
      } catch (UnsupportedEncodingException var1) {
         throw new RuntimeException(var1);
      }
   }

   public static String escapeUri(String var0) {
      return URI_ESCAPER.escape(var0);
   }

   public static String escapeUriPath(String var0) {
      return URI_PATH_ESCAPER.escape(var0);
   }

   public static String escapeUriPathWithoutReserved(String var0) {
      return URI_RESERVED_ESCAPER.escape(var0);
   }

   public static String escapeUriQuery(String var0) {
      return URI_QUERY_STRING_ESCAPER.escape(var0);
   }

   public static String escapeUriUserInfo(String var0) {
      return URI_USERINFO_ESCAPER.escape(var0);
   }
}
