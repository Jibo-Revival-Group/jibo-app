package com.google.zxing.common;

import com.google.zxing.FormatException;
import java.util.HashMap;
import java.util.Map;

public enum CharacterSetECI {
   ASCII(new int[]{27, 170}, "US-ASCII"),
   Big5(28),
   Cp1250(21, "windows-1250"),
   Cp1251(22, "windows-1251"),
   Cp1252(23, "windows-1252"),
   Cp1256(24, "windows-1256"),
   Cp437(new int[]{0, 2}),
   EUC_KR(30, "EUC-KR"),
   GB18030(29, "GB2312", "EUC_CN", "GBK"),
   ISO8859_1(new int[]{1, 3}, "ISO-8859-1"),
   ISO8859_10(12, "ISO-8859-10"),
   ISO8859_11(13, "ISO-8859-11"),
   ISO8859_13(15, "ISO-8859-13"),
   ISO8859_14(16, "ISO-8859-14"),
   ISO8859_15(17, "ISO-8859-15"),
   ISO8859_16(18, "ISO-8859-16"),
   ISO8859_2(4, "ISO-8859-2"),
   ISO8859_3(5, "ISO-8859-3"),
   ISO8859_4(6, "ISO-8859-4"),
   ISO8859_5(7, "ISO-8859-5"),
   ISO8859_6(8, "ISO-8859-6"),
   ISO8859_7(9, "ISO-8859-7"),
   ISO8859_8(10, "ISO-8859-8"),
   ISO8859_9(11, "ISO-8859-9"),
   SJIS(20, "Shift_JIS"),
   UTF8(26, "UTF-8"),
   UnicodeBigUnmarked(25, "UTF-16BE", "UnicodeBig");

   private static final CharacterSetECI[] $VALUES = new CharacterSetECI[]{
      CharacterSetECI.Cp437,
      CharacterSetECI.ISO8859_1,
      CharacterSetECI.ISO8859_2,
      CharacterSetECI.ISO8859_3,
      CharacterSetECI.ISO8859_4,
      CharacterSetECI.ISO8859_5,
      CharacterSetECI.ISO8859_6,
      CharacterSetECI.ISO8859_7,
      CharacterSetECI.ISO8859_8,
      CharacterSetECI.ISO8859_9,
      CharacterSetECI.ISO8859_10,
      CharacterSetECI.ISO8859_11,
      CharacterSetECI.ISO8859_13,
      CharacterSetECI.ISO8859_14,
      CharacterSetECI.ISO8859_15,
      CharacterSetECI.ISO8859_16,
      CharacterSetECI.SJIS,
      CharacterSetECI.Cp1250,
      CharacterSetECI.Cp1251,
      CharacterSetECI.Cp1252,
      CharacterSetECI.Cp1256,
      CharacterSetECI.UnicodeBigUnmarked,
      CharacterSetECI.UTF8,
      CharacterSetECI.ASCII,
      CharacterSetECI.Big5,
      CharacterSetECI.GB18030,
      CharacterSetECI.EUC_KR
   };
   private static final Map<String, CharacterSetECI> NAME_TO_ECI = new HashMap<>();
   private static final Map<Integer, CharacterSetECI> VALUE_TO_ECI = new HashMap<>();
   private final String[] otherEncodingNames;
   private final int[] values;

   static {
      for (CharacterSetECI var5 : values()) {
         for (int var4 : var5.values) {
            VALUE_TO_ECI.put(var4, var5);
         }

         NAME_TO_ECI.put(var5.name(), var5);

         for (String var8 : var5.otherEncodingNames) {
            NAME_TO_ECI.put(var8, var5);
         }
      }
   }

   CharacterSetECI(int var3) {
      this(new int[]{var3});
   }

   CharacterSetECI(int var3, String... var4) {
      this.values = new int[]{var3};
      this.otherEncodingNames = var4;
   }

   CharacterSetECI(int[] var3, String... var4) {
      this.values = var3;
      this.otherEncodingNames = var4;
   }

   public static CharacterSetECI getCharacterSetECIByName(String var0) {
      return NAME_TO_ECI.get(var0);
   }

   public static CharacterSetECI getCharacterSetECIByValue(int var0) throws FormatException {
      if (var0 >= 0 && var0 < 900) {
         return VALUE_TO_ECI.get(var0);
      } else {
         throw FormatException.a();
      }
   }

   public int getValue() {
      return this.values[0];
   }
}
