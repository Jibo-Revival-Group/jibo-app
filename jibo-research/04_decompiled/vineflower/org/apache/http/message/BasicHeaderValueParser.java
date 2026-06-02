package org.apache.http.message;

import java.util.ArrayList;
import java.util.BitSet;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Immutable
public class BasicHeaderValueParser implements HeaderValueParser {
   @Deprecated
   public static final BasicHeaderValueParser DEFAULT = new BasicHeaderValueParser();
   private static final char ELEM_DELIMITER = ',';
   public static final BasicHeaderValueParser INSTANCE = new BasicHeaderValueParser();
   private static final char PARAM_DELIMITER = ';';
   private static final BitSet TOKEN_DELIMS = TokenParser.INIT_BITSET(61, 59, 44);
   private static final BitSet VALUE_DELIMS = TokenParser.INIT_BITSET(59, 44);
   private final TokenParser tokenParser = TokenParser.INSTANCE;

   public static HeaderElement[] parseElements(String var0, HeaderValueParser var1) throws ParseException {
      Args.notNull(var0, "Value");
      CharArrayBuffer var2 = new CharArrayBuffer(var0.length());
      var2.append(var0);
      ParserCursor var3 = new ParserCursor(0, var0.length());
      if (var1 == null) {
         var1 = INSTANCE;
      }

      return var1.parseElements(var2, var3);
   }

   public static HeaderElement parseHeaderElement(String var0, HeaderValueParser var1) throws ParseException {
      Args.notNull(var0, "Value");
      CharArrayBuffer var2 = new CharArrayBuffer(var0.length());
      var2.append(var0);
      ParserCursor var3 = new ParserCursor(0, var0.length());
      if (var1 == null) {
         var1 = INSTANCE;
      }

      return var1.parseHeaderElement(var2, var3);
   }

   public static NameValuePair parseNameValuePair(String var0, HeaderValueParser var1) throws ParseException {
      Args.notNull(var0, "Value");
      CharArrayBuffer var2 = new CharArrayBuffer(var0.length());
      var2.append(var0);
      ParserCursor var3 = new ParserCursor(0, var0.length());
      if (var1 == null) {
         var1 = INSTANCE;
      }

      return var1.parseNameValuePair(var2, var3);
   }

   public static NameValuePair[] parseParameters(String var0, HeaderValueParser var1) throws ParseException {
      Args.notNull(var0, "Value");
      CharArrayBuffer var2 = new CharArrayBuffer(var0.length());
      var2.append(var0);
      ParserCursor var3 = new ParserCursor(0, var0.length());
      if (var1 == null) {
         var1 = INSTANCE;
      }

      return var1.parseParameters(var2, var3);
   }

   protected HeaderElement createHeaderElement(String var1, String var2, NameValuePair[] var3) {
      return new BasicHeaderElement(var1, var2, var3);
   }

   protected NameValuePair createNameValuePair(String var1, String var2) {
      return new BasicNameValuePair(var1, var2);
   }

   @Override
   public HeaderElement[] parseElements(CharArrayBuffer var1, ParserCursor var2) {
      Args.notNull(var1, "Char array buffer");
      Args.notNull(var2, "Parser cursor");
      ArrayList var3 = new ArrayList();

      while (!var2.atEnd()) {
         HeaderElement var4 = this.parseHeaderElement(var1, var2);
         if (var4.getName().length() != 0 || var4.getValue() != null) {
            var3.add(var4);
         }
      }

      return var3.toArray(new HeaderElement[var3.size()]);
   }

   @Override
   public HeaderElement parseHeaderElement(CharArrayBuffer var1, ParserCursor var2) {
      Args.notNull(var1, "Char array buffer");
      Args.notNull(var2, "Parser cursor");
      NameValuePair var5 = this.parseNameValuePair(var1, var2);
      Object var4 = null;
      NameValuePair[] var3 = (NameValuePair[])var4;
      if (!var2.atEnd()) {
         var3 = (NameValuePair[])var4;
         if (var1.charAt(var2.getPos() - 1) != ',') {
            var3 = this.parseParameters(var1, var2);
         }
      }

      return this.createHeaderElement(var5.getName(), var5.getValue(), var3);
   }

   @Override
   public NameValuePair parseNameValuePair(CharArrayBuffer var1, ParserCursor var2) {
      Args.notNull(var1, "Char array buffer");
      Args.notNull(var2, "Parser cursor");
      String var4 = this.tokenParser.parseToken(var1, var2, TOKEN_DELIMS);
      NameValuePair var5;
      if (var2.atEnd()) {
         var5 = new BasicNameValuePair(var4, null);
      } else {
         char var3 = var1.charAt(var2.getPos());
         var2.updatePos(var2.getPos() + 1);
         if (var3 != '=') {
            var5 = this.createNameValuePair(var4, null);
         } else {
            String var6 = this.tokenParser.parseValue(var1, var2, VALUE_DELIMS);
            if (!var2.atEnd()) {
               var2.updatePos(var2.getPos() + 1);
            }

            var5 = this.createNameValuePair(var4, var6);
         }
      }

      return var5;
   }

   @Deprecated
   public NameValuePair parseNameValuePair(CharArrayBuffer var1, ParserCursor var2, char[] var3) {
      Args.notNull(var1, "Char array buffer");
      Args.notNull(var2, "Parser cursor");
      BitSet var6 = new BitSet();
      if (var3 != null) {
         int var5 = var3.length;

         for (int var4 = 0; var4 < var5; var4++) {
            var6.set(var3[var4]);
         }
      }

      var6.set(61);
      String var9 = this.tokenParser.parseToken(var1, var2, var6);
      NameValuePair var7;
      if (var2.atEnd()) {
         var7 = new BasicNameValuePair(var9, null);
      } else {
         char var10 = var1.charAt(var2.getPos());
         var2.updatePos(var2.getPos() + 1);
         if (var10 != '=') {
            var7 = this.createNameValuePair(var9, null);
         } else {
            var6.clear(61);
            String var8 = this.tokenParser.parseValue(var1, var2, var6);
            if (!var2.atEnd()) {
               var2.updatePos(var2.getPos() + 1);
            }

            var7 = this.createNameValuePair(var9, var8);
         }
      }

      return var7;
   }

   @Override
   public NameValuePair[] parseParameters(CharArrayBuffer var1, ParserCursor var2) {
      Args.notNull(var1, "Char array buffer");
      Args.notNull(var2, "Parser cursor");
      this.tokenParser.skipWhiteSpace(var1, var2);
      ArrayList var3 = new ArrayList();

      while (!var2.atEnd()) {
         var3.add(this.parseNameValuePair(var1, var2));
         if (var1.charAt(var2.getPos() - 1) == ',') {
            break;
         }
      }

      return var3.toArray(new NameValuePair[var3.size()]);
   }
}
