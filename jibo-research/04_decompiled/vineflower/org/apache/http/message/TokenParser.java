package org.apache.http.message;

import java.util.BitSet;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.CharArrayBuffer;

@Immutable
public class TokenParser {
   public static final char CR = '\r';
   public static final char DQUOTE = '"';
   public static final char ESCAPE = '\\';
   public static final char HT = '\t';
   public static final TokenParser INSTANCE = new TokenParser();
   public static final char LF = '\n';
   public static final char SP = ' ';

   public static BitSet INIT_BITSET(int... var0) {
      BitSet var3 = new BitSet();
      int var2 = var0.length;

      for (int var1 = 0; var1 < var2; var1++) {
         var3.set(var0[var1]);
      }

      return var3;
   }

   public static boolean isWhitespace(char var0) {
      boolean var1;
      if (var0 != ' ' && var0 != '\t' && var0 != '\r' && var0 != '\n') {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public void copyContent(CharArrayBuffer var1, ParserCursor var2, BitSet var3, StringBuilder var4) {
      int var6 = var2.getPos();
      int var7 = var2.getPos();

      for (int var8 = var2.getUpperBound(); var7 < var8; var7++) {
         char var5 = var1.charAt(var7);
         if (var3 != null && var3.get(var5) || isWhitespace(var5)) {
            break;
         }

         var6++;
         var4.append(var5);
      }

      var2.updatePos(var6);
   }

   public void copyQuotedContent(CharArrayBuffer var1, ParserCursor var2, StringBuilder var3) {
      if (!var2.atEnd()) {
         int var5 = var2.getPos();
         int var6 = var2.getPos();
         int var9 = var2.getUpperBound();
         if (var1.charAt(var5) == '"') {
            var5++;
            int var7 = var6 + 1;
            boolean var8 = false;

            while (var7 < var9) {
               char var4 = var1.charAt(var7);
               boolean var11;
               if (var8) {
                  if (var4 != '"' && var4 != '\\') {
                     var3.append('\\');
                  }

                  var3.append(var4);
                  var11 = false;
               } else {
                  if (var4 == '"') {
                     var5++;
                     break;
                  }

                  if (var4 == '\\') {
                     var11 = true;
                  } else {
                     var11 = var8;
                     if (var4 != '\r') {
                        var11 = var8;
                        if (var4 != '\n') {
                           var3.append(var4);
                           var11 = var8;
                        }
                     }
                  }
               }

               var7++;
               var5++;
               var8 = var11;
            }

            var2.updatePos(var5);
         }
      }
   }

   public void copyUnquotedContent(CharArrayBuffer var1, ParserCursor var2, BitSet var3, StringBuilder var4) {
      int var6 = var2.getPos();
      int var7 = var2.getPos();

      for (int var8 = var2.getUpperBound(); var7 < var8; var7++) {
         char var5 = var1.charAt(var7);
         if (var3 != null && var3.get(var5) || isWhitespace(var5) || var5 == '"') {
            break;
         }

         var6++;
         var4.append(var5);
      }

      var2.updatePos(var6);
   }

   public String parseToken(CharArrayBuffer var1, ParserCursor var2, BitSet var3) {
      StringBuilder var6 = new StringBuilder();
      boolean var5 = false;

      while (!var2.atEnd()) {
         char var4 = var1.charAt(var2.getPos());
         if (var3 != null && var3.get(var4)) {
            break;
         }

         if (isWhitespace(var4)) {
            this.skipWhiteSpace(var1, var2);
            var5 = true;
         } else {
            if (var5 && var6.length() > 0) {
               var6.append(' ');
            }

            this.copyContent(var1, var2, var3, var6);
            var5 = false;
         }
      }

      return var6.toString();
   }

   public String parseValue(CharArrayBuffer var1, ParserCursor var2, BitSet var3) {
      StringBuilder var6 = new StringBuilder();
      boolean var5 = false;

      while (!var2.atEnd()) {
         char var4 = var1.charAt(var2.getPos());
         if (var3 != null && var3.get(var4)) {
            break;
         }

         if (isWhitespace(var4)) {
            this.skipWhiteSpace(var1, var2);
            var5 = true;
         } else if (var4 == '"') {
            if (var5 && var6.length() > 0) {
               var6.append(' ');
            }

            this.copyQuotedContent(var1, var2, var6);
            var5 = false;
         } else {
            if (var5 && var6.length() > 0) {
               var6.append(' ');
            }

            this.copyUnquotedContent(var1, var2, var3, var6);
            var5 = false;
         }
      }

      return var6.toString();
   }

   public void skipWhiteSpace(CharArrayBuffer var1, ParserCursor var2) {
      int var3 = var2.getPos();
      int var4 = var2.getPos();

      for (int var5 = var2.getUpperBound(); var4 < var5 && isWhitespace(var1.charAt(var4)); var4++) {
         var3++;
      }

      var2.updatePos(var3);
   }
}
