package com.google.api.client.util.escape;

public class PercentEscaper extends UnicodeEscaper {
   public static final String SAFECHARS_URLENCODER = "-_.*";
   public static final String SAFEPATHCHARS_URLENCODER = "-_.!~*'()@:$&,;=";
   public static final String SAFEQUERYSTRINGCHARS_URLENCODER = "-_.!~*'()@:$,;/?:";
   public static final String SAFEUSERINFOCHARS_URLENCODER = "-_.!~*'():$&,;=";
   public static final String SAFE_PLUS_RESERVED_CHARS_URLENCODER = "-_.!~*'()@:$&,;=+/?";
   private static final char[] UPPER_HEX_DIGITS = "0123456789ABCDEF".toCharArray();
   private static final char[] URI_ESCAPED_SPACE = new char[]{'+'};
   private final boolean plusForSpace;
   private final boolean[] safeOctets;

   public PercentEscaper(String var1, boolean var2) {
      if (var1.matches(".*[0-9A-Za-z].*")) {
         throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
      }

      if (var2 && var1.contains(" ")) {
         throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
      }

      if (var1.contains("%")) {
         throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
      }

      this.plusForSpace = var2;
      this.safeOctets = createSafeOctets(var1);
   }

   private static boolean[] createSafeOctets(String var0) {
      byte var3 = 0;
      char[] var6 = var0.toCharArray();
      int var4 = var6.length;
      int var2 = 0;
      int var1 = 122;

      while (var2 < var4) {
         var1 = Math.max(var6[var2], var1);
         var2++;
      }

      boolean[] var5 = new boolean[var1 + 1];

      for (int var7 = 48; var7 <= 57; var7++) {
         var5[var7] = true;
      }

      for (int var8 = 65; var8 <= 90; var8++) {
         var5[var8] = true;
      }

      for (int var9 = 97; var9 <= 122; var9++) {
         var5[var9] = true;
      }

      var2 = var6.length;

      for (int var10 = var3; var10 < var2; var10++) {
         var5[var6[var10]] = true;
      }

      return var5;
   }

   @Override
   public String escape(String var1) {
      int var3 = var1.length();
      int var2 = 0;

      String var5;
      while (true) {
         var5 = var1;
         if (var2 >= var3) {
            break;
         }

         char var4 = var1.charAt(var2);
         if (var4 >= this.safeOctets.length || !this.safeOctets[var4]) {
            var5 = this.escapeSlow(var1, var2);
            break;
         }

         var2++;
      }

      return var5;
   }

   @Override
   protected char[] escape(int var1) {
      char[] var2;
      if (var1 < this.safeOctets.length && this.safeOctets[var1]) {
         var2 = null;
      } else if (var1 == 32 && this.plusForSpace) {
         var2 = URI_ESCAPED_SPACE;
      } else if (var1 <= 127) {
         var2 = new char[]{'%', '\u0000', UPPER_HEX_DIGITS[var1 & 15]};
         var2[1] = UPPER_HEX_DIGITS[var1 >>> 4];
      } else if (var1 <= 2047) {
         var2 = new char[]{'%', '\u0000', '\u0000', '%', '\u0000', UPPER_HEX_DIGITS[var1 & 15]};
         var1 >>>= 4;
         var2[4] = UPPER_HEX_DIGITS[var1 & 3 | 8];
         var1 >>>= 2;
         var2[2] = UPPER_HEX_DIGITS[var1 & 15];
         var2[1] = UPPER_HEX_DIGITS[var1 >>> 4 | 12];
      } else if (var1 <= 65535) {
         var2 = new char[9];
         var2[0] = '%';
         var2[1] = 'E';
         var2[3] = '%';
         var2[6] = '%';
         var2[8] = UPPER_HEX_DIGITS[var1 & 15];
         var1 >>>= 4;
         var2[7] = UPPER_HEX_DIGITS[var1 & 3 | 8];
         var1 >>>= 2;
         var2[5] = UPPER_HEX_DIGITS[var1 & 15];
         var1 >>>= 4;
         var2[4] = UPPER_HEX_DIGITS[var1 & 3 | 8];
         var2[2] = UPPER_HEX_DIGITS[var1 >>> 2];
      } else {
         if (var1 > 1114111) {
            throw new IllegalArgumentException(new StringBuilder(43).append("Invalid unicode character value ").append(var1).toString());
         }

         var2 = new char[12];
         var2[0] = '%';
         var2[1] = 'F';
         var2[3] = '%';
         var2[6] = '%';
         var2[9] = '%';
         var2[11] = UPPER_HEX_DIGITS[var1 & 15];
         var1 >>>= 4;
         var2[10] = UPPER_HEX_DIGITS[var1 & 3 | 8];
         var1 >>>= 2;
         var2[8] = UPPER_HEX_DIGITS[var1 & 15];
         var1 >>>= 4;
         var2[7] = UPPER_HEX_DIGITS[var1 & 3 | 8];
         var1 >>>= 2;
         var2[5] = UPPER_HEX_DIGITS[var1 & 15];
         var1 >>>= 4;
         var2[4] = UPPER_HEX_DIGITS[var1 & 3 | 8];
         var2[2] = UPPER_HEX_DIGITS[var1 >>> 2 & 7];
      }

      return var2;
   }

   @Override
   protected int nextEscapeIndex(CharSequence var1, int var2, int var3) {
      while (var2 < var3) {
         char var4 = var1.charAt(var2);
         if (var4 < this.safeOctets.length && this.safeOctets[var4]) {
            var2++;
            continue;
         }
         break;
      }

      return var2;
   }
}
