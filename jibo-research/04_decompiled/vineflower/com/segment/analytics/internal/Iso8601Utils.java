package com.segment.analytics.internal;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

final class Iso8601Utils {
   static final String GMT_ID = "GMT";
   static final TimeZone TIMEZONE_Z = TimeZone.getTimeZone("GMT");

   private static boolean checkOffset(String var0, int var1, char var2) {
      boolean var3;
      if (var1 < var0.length() && var0.charAt(var1) == var2) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public static String format(Date var0) {
      GregorianCalendar var1 = new GregorianCalendar(TIMEZONE_Z, Locale.US);
      var1.setTime(var0);
      StringBuilder var2 = new StringBuilder("yyyy-MM-ddThh:mm:ss.sssZ".length());
      padInt(var2, var1.get(1), "yyyy".length());
      var2.append('-');
      padInt(var2, var1.get(2) + 1, "MM".length());
      var2.append('-');
      padInt(var2, var1.get(5), "dd".length());
      var2.append('T');
      padInt(var2, var1.get(11), "hh".length());
      var2.append(':');
      padInt(var2, var1.get(12), "mm".length());
      var2.append(':');
      padInt(var2, var1.get(13), "ss".length());
      var2.append('.');
      padInt(var2, var1.get(14), "sss".length());
      var2.append('Z');
      return var2.toString();
   }

   private static int indexOfNonDigit(String var0, int var1) {
      while (true) {
         int var2;
         if (var1 < var0.length()) {
            char var3 = var0.charAt(var1);
            var2 = var1;
            if (var3 >= '0') {
               if (var3 <= '9') {
                  var1++;
                  continue;
               }

               var2 = var1;
            }
         } else {
            var2 = var0.length();
         }

         return var2;
      }
   }

   private static void padInt(StringBuilder var0, int var1, int var2) {
      String var3 = Integer.toString(var1);

      for (int var4 = var2 - var3.length(); var4 > 0; var4--) {
         var0.append('0');
      }

      var0.append(var3);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static Date parse(String var0) {
      byte var2;
      int var10;
      label280: {
         label279: {
            try {
               var10 = parseInt(var0, 0, 4);
               if (checkOffset(var0, 4, '-')) {
                  break label279;
               }
            } catch (IndexOutOfBoundsException var64) {
               throw new RuntimeException("Not an RFC 3339 date: " + var0, var64);
            } catch (IllegalArgumentException var65) {
               throw new RuntimeException("Not an RFC 3339 date: " + var0, var65);
            }

            var2 = 4;
            break label280;
         }

         var2 = 5;
      }

      int var3 = var2 + 2;

      int var11;
      try {
         var11 = parseInt(var0, var2, var3);
      } catch (IndexOutOfBoundsException var50) {
         throw new RuntimeException("Not an RFC 3339 date: " + var0, var50);
      } catch (IllegalArgumentException var51) {
         throw new RuntimeException("Not an RFC 3339 date: " + var0, var51);
      }

      var2 = var3;

      label272: {
         try {
            if (!checkOffset(var0, var3, '-')) {
               break label272;
            }
         } catch (IndexOutOfBoundsException var62) {
            throw new RuntimeException("Not an RFC 3339 date: " + var0, var62);
         } catch (IllegalArgumentException var63) {
            throw new RuntimeException("Not an RFC 3339 date: " + var0, var63);
         }

         var2 = var3 + 1;
      }

      var3 = var2 + 2;

      int var12;
      try {
         var12 = parseInt(var0, var2, var3);
      } catch (IndexOutOfBoundsException var48) {
         throw new RuntimeException("Not an RFC 3339 date: " + var0, var48);
      } catch (IllegalArgumentException var49) {
         throw new RuntimeException("Not an RFC 3339 date: " + var0, var49);
      }

      int var7 = 0;
      int var6 = 0;
      int var5 = 0;

      boolean var13;
      try {
         var13 = checkOffset(var0, var3, 'T');
      } catch (IndexOutOfBoundsException var46) {
         throw new RuntimeException("Not an RFC 3339 date: " + var0, var46);
      } catch (IllegalArgumentException var47) {
         throw new RuntimeException("Not an RFC 3339 date: " + var0, var47);
      }

      if (!var13) {
         try {
            if (var0.length() <= var3) {
               GregorianCalendar var93 = new GregorianCalendar(var10, var11 - 1, var12);
               return var93.getTime();
            }
         } catch (IndexOutOfBoundsException var44) {
            throw new RuntimeException("Not an RFC 3339 date: " + var0, var44);
         } catch (IllegalArgumentException var45) {
            throw new RuntimeException("Not an RFC 3339 date: " + var0, var45);
         }
      }

      int var76;
      label291: {
         int var8;
         var8 = var3;
         label246:
         if (var13) {
            var2 = var3 + 1;
            var76 = var2 + 2;

            try {
               var3 = parseInt(var0, var2, var76);
            } catch (IndexOutOfBoundsException var42) {
               throw new RuntimeException("Not an RFC 3339 date: " + var0, var42);
            } catch (IllegalArgumentException var43) {
               throw new RuntimeException("Not an RFC 3339 date: " + var0, var43);
            }

            var2 = var76;

            label263: {
               try {
                  if (!checkOffset(var0, var76, ':')) {
                     break label263;
                  }
               } catch (IndexOutOfBoundsException var60) {
                  throw new RuntimeException("Not an RFC 3339 date: " + var0, var60);
               } catch (IllegalArgumentException var61) {
                  throw new RuntimeException("Not an RFC 3339 date: " + var0, var61);
               }

               var2 = var76 + 1;
            }

            var5 = var2 + 2;

            try {
               var76 = parseInt(var0, var2, var5);
            } catch (IndexOutOfBoundsException var40) {
               throw new RuntimeException("Not an RFC 3339 date: " + var0, var40);
            } catch (IllegalArgumentException var41) {
               throw new RuntimeException("Not an RFC 3339 date: " + var0, var41);
            }

            var2 = var5;

            label257: {
               try {
                  if (!checkOffset(var0, var5, ':')) {
                     break label257;
                  }
               } catch (IndexOutOfBoundsException var58) {
                  throw new RuntimeException("Not an RFC 3339 date: " + var0, var58);
               } catch (IllegalArgumentException var59) {
                  throw new RuntimeException("Not an RFC 3339 date: " + var0, var59);
               }

               var2 = var5 + 1;
            }

            label252: {
               try {
                  if (var0.length() <= var2) {
                     break label252;
                  }

                  var78 = var0.charAt(var2);
               } catch (IndexOutOfBoundsException var56) {
                  throw new RuntimeException("Not an RFC 3339 date: " + var0, var56);
               } catch (IllegalArgumentException var57) {
                  throw new RuntimeException("Not an RFC 3339 date: " + var0, var57);
               }

               if (var78 != 'Z' && var78 != '+' && var78 != '-') {
                  int var9 = var2 + 2;

                  try {
                     var5 = parseInt(var0, var2, var9);
                  } catch (IndexOutOfBoundsException var38) {
                     throw new RuntimeException("Not an RFC 3339 date: " + var0, var38);
                  } catch (IllegalArgumentException var39) {
                     throw new RuntimeException("Not an RFC 3339 date: " + var0, var39);
                  }

                  var2 = var5;
                  if (var5 > 59) {
                     var2 = var5;
                     if (var5 < 63) {
                        var2 = 59;
                     }
                  }

                  var5 = var2;
                  var6 = var76;
                  var7 = var3;
                  var8 = var9;

                  try {
                     if (!checkOffset(var0, var9, '.')) {
                        break label246;
                     }
                  } catch (IndexOutOfBoundsException var54) {
                     throw new RuntimeException("Not an RFC 3339 date: " + var0, var54);
                  } catch (IllegalArgumentException var55) {
                     throw new RuntimeException("Not an RFC 3339 date: " + var0, var55);
                  }

                  var5 = var9 + 1;

                  try {
                     var7 = indexOfNonDigit(var0, var5 + 1);
                     var6 = Math.min(var7, var5 + 3);
                     var8 = parseInt(var0, var5, var6);
                     var8 = (int)(Math.pow(10.0, 3 - (var6 - var5)) * var8);
                  } catch (IndexOutOfBoundsException var36) {
                     throw new RuntimeException("Not an RFC 3339 date: " + var0, var36);
                  } catch (IllegalArgumentException var37) {
                     throw new RuntimeException("Not an RFC 3339 date: " + var0, var37);
                  }

                  var6 = var3;
                  var5 = var76;
                  var76 = var2;
                  var3 = var8;
                  var2 = var7;
                  break label291;
               }
            }

            var6 = var3;
            var5 = var76;
            var76 = 0;
            var3 = 0;
            break label291;
         }

         var2 = var8;
         var76 = var5;
         var3 = 0;
         var5 = var6;
         var6 = var7;
      }

      try {
         if (var0.length() <= var2) {
            IllegalArgumentException var92 = new IllegalArgumentException("No time zone indicator");
            throw var92;
         }
      } catch (IndexOutOfBoundsException var52) {
         throw new RuntimeException("Not an RFC 3339 date: " + var0, var52);
      } catch (IllegalArgumentException var53) {
         throw new RuntimeException("Not an RFC 3339 date: " + var0, var53);
      }

      char var1;
      try {
         var1 = var0.charAt(var2);
      } catch (IndexOutOfBoundsException var34) {
         throw new RuntimeException("Not an RFC 3339 date: " + var0, var34);
      } catch (IllegalArgumentException var35) {
         throw new RuntimeException("Not an RFC 3339 date: " + var0, var35);
      }

      TimeZone var87;
      if (var1 == 'Z') {
         try {
            var87 = TIMEZONE_Z;
         } catch (IndexOutOfBoundsException var28) {
            throw new RuntimeException("Not an RFC 3339 date: " + var0, var28);
         } catch (IllegalArgumentException var29) {
            throw new RuntimeException("Not an RFC 3339 date: " + var0, var29);
         }
      } else {
         label288: {
            if (var1 != '+' && var1 != '-') {
               try {
                  StringBuilder var91 = new StringBuilder();
                  IndexOutOfBoundsException var97 = new IndexOutOfBoundsException(
                     var91.append("Invalid time zone indicator '").append(var1).append("'").toString()
                  );
                  throw var97;
               } catch (IndexOutOfBoundsException var18) {
                  throw new RuntimeException("Not an RFC 3339 date: " + var0, var18);
               } catch (IllegalArgumentException var19) {
                  throw new RuntimeException("Not an RFC 3339 date: " + var0, var19);
               }
            }

            label289: {
               try {
                  var88 = var0.substring(var2);
                  if ("+0000".equals(var88) || "+00:00".equals(var88)) {
                     break label289;
                  }
               } catch (IndexOutOfBoundsException var32) {
                  throw new RuntimeException("Not an RFC 3339 date: " + var0, var32);
               } catch (IllegalArgumentException var33) {
                  throw new RuntimeException("Not an RFC 3339 date: " + var0, var33);
               }

               String var16;
               String var17;
               TimeZone var95;
               try {
                  StringBuilder var15 = new StringBuilder();
                  var16 = var15.append("GMT").append(var88).toString();
                  var95 = TimeZone.getTimeZone(var16);
                  var17 = var95.getID();
               } catch (IndexOutOfBoundsException var24) {
                  throw new RuntimeException("Not an RFC 3339 date: " + var0, var24);
               } catch (IllegalArgumentException var25) {
                  throw new RuntimeException("Not an RFC 3339 date: " + var0, var25);
               }

               var87 = var95;

               try {
                  if (var17.equals(var16)) {
                     break label288;
                  }
               } catch (IndexOutOfBoundsException var30) {
                  throw new RuntimeException("Not an RFC 3339 date: " + var0, var30);
               } catch (IllegalArgumentException var31) {
                  throw new RuntimeException("Not an RFC 3339 date: " + var0, var31);
               }

               var87 = var95;

               try {
                  if (!var17.replace(":", "").equals(var16)) {
                     StringBuilder var89 = new StringBuilder();
                     IndexOutOfBoundsException var98 = new IndexOutOfBoundsException(
                        var89.append("Mismatching time zone indicator: ").append(var16).append(" given, resolves to ").append(var95.getID()).toString()
                     );
                     throw var98;
                  }
                  break label288;
               } catch (IndexOutOfBoundsException var22) {
                  throw new RuntimeException("Not an RFC 3339 date: " + var0, var22);
               } catch (IllegalArgumentException var23) {
                  throw new RuntimeException("Not an RFC 3339 date: " + var0, var23);
               }
            }

            try {
               var87 = TIMEZONE_Z;
            } catch (IndexOutOfBoundsException var26) {
               throw new RuntimeException("Not an RFC 3339 date: " + var0, var26);
            } catch (IllegalArgumentException var27) {
               throw new RuntimeException("Not an RFC 3339 date: " + var0, var27);
            }
         }
      }

      try {
         GregorianCalendar var96 = new GregorianCalendar(var87);
         var96.setLenient(false);
         var96.set(1, var10);
         var96.set(2, var11 - 1);
         var96.set(5, var12);
         var96.set(11, var6);
         var96.set(12, var5);
         var96.set(13, var76);
         var96.set(14, var3);
         var90 = var96.getTime();
      } catch (IndexOutOfBoundsException var20) {
         throw new RuntimeException("Not an RFC 3339 date: " + var0, var20);
      } catch (IllegalArgumentException var21) {
         throw new RuntimeException("Not an RFC 3339 date: " + var0, var21);
      }

      return var90;
   }

   private static int parseInt(String var0, int var1, int var2) throws NumberFormatException {
      if (var1 >= 0 && var2 <= var0.length() && var1 <= var2) {
         int var4 = 0;
         int var3;
         if (var1 < var2) {
            var3 = var1 + 1;
            var4 = Character.digit(var0.charAt(var1), 10);
            if (var4 < 0) {
               throw new NumberFormatException("Invalid number: " + var0.substring(var1, var2));
            }

            var4 = -var4;
         } else {
            var3 = var1;
         }

         while (var3 < var2) {
            int var5 = Character.digit(var0.charAt(var3), 10);
            if (var5 < 0) {
               throw new NumberFormatException("Invalid number: " + var0.substring(var1, var2));
            }

            var4 = var4 * 10 - var5;
            var3++;
         }

         return -var4;
      } else {
         throw new NumberFormatException(var0);
      }
   }
}
