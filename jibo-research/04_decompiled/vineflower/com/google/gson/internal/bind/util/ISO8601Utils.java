package com.google.gson.internal.bind.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ISO8601Utils {
   private static final TimeZone a = TimeZone.getTimeZone("UTC");

   private static int a(String var0, int var1) {
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

   private static int a(String var0, int var1, int var2) throws NumberFormatException {
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

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static Date a(String var0, ParsePosition var1) throws ParseException {
      IllegalArgumentException var14;
      label366: {
         int var4;
         try {
            var4 = var1.getIndex();
         } catch (IndexOutOfBoundsException var66) {
            var14 = var66;
            break label366;
         } catch (NumberFormatException var67) {
            var14 = var67;
            break label366;
         } catch (IllegalArgumentException var68) {
            var14 = var68;
            break label366;
         }

         int var3 = var4 + 4;

         int var9;
         label349: {
            try {
               var9 = a(var0, var4, var3);
               if (!a(var0, var3, '-')) {
                  break label349;
               }
            } catch (IndexOutOfBoundsException var87) {
               var14 = var87;
               break label366;
            } catch (NumberFormatException var88) {
               var14 = var88;
               break label366;
            } catch (IllegalArgumentException var89) {
               var14 = var89;
               break label366;
            }

            var3++;
         }

         var4 = var3 + 2;

         int var10;
         label343: {
            label342: {
               try {
                  var10 = a(var0, var3, var4);
                  if (a(var0, var4, '-')) {
                     break label342;
                  }
               } catch (IndexOutOfBoundsException var84) {
                  var14 = var84;
                  break label366;
               } catch (NumberFormatException var85) {
                  var14 = var85;
                  break label366;
               } catch (IllegalArgumentException var86) {
                  var14 = var86;
                  break label366;
               }

               var3 = var4;
               break label343;
            }

            var3 = var4 + 1;
         }

         var4 = var3 + 2;

         int var11;
         boolean var13;
         try {
            var11 = a(var0, var3, var4);
            var13 = a(var0, var4, 'T');
         } catch (IndexOutOfBoundsException var63) {
            var14 = var63;
            break label366;
         } catch (NumberFormatException var64) {
            var14 = var64;
            break label366;
         } catch (IllegalArgumentException var65) {
            var14 = var65;
            break label366;
         }

         if (!var13) {
            try {
               if (var0.length() <= var4) {
                  GregorianCalendar var120 = new GregorianCalendar(var9, var10 - 1, var11);
                  var1.setIndex(var4);
                  return var120.getTime();
               }
            } catch (IndexOutOfBoundsException var60) {
               var14 = var60;
               break label366;
            } catch (NumberFormatException var61) {
               var14 = var61;
               break label366;
            } catch (IllegalArgumentException var62) {
               var14 = var62;
               break label366;
            }
         }

         int var104;
         int var105;
         int var108;
         label335:
         if (var13) {
            var3 = ++var4 + 2;

            label332: {
               try {
                  var105 = a(var0, var4, var3);
                  if (!a(var0, var3, ':')) {
                     break label332;
                  }
               } catch (IndexOutOfBoundsException var81) {
                  var14 = var81;
                  break label366;
               } catch (NumberFormatException var82) {
                  var14 = var82;
                  break label366;
               } catch (IllegalArgumentException var83) {
                  var14 = var83;
                  break label366;
               }

               var3++;
            }

            var108 = var3 + 2;

            try {
               var104 = a(var0, var3, var108);
            } catch (IndexOutOfBoundsException var57) {
               var14 = var57;
               break label366;
            } catch (NumberFormatException var58) {
               var14 = var58;
               break label366;
            } catch (IllegalArgumentException var59) {
               var14 = var59;
               break label366;
            }

            var4 = var108;

            label326: {
               try {
                  if (!a(var0, var108, ':')) {
                     break label326;
                  }
               } catch (IndexOutOfBoundsException var78) {
                  var14 = var78;
                  break label366;
               } catch (NumberFormatException var79) {
                  var14 = var79;
                  break label366;
               } catch (IllegalArgumentException var80) {
                  var14 = var80;
                  break label366;
               }

               var4 = var108 + 1;
            }

            label321: {
               try {
                  if (var0.length() <= var4) {
                     break label321;
                  }

                  var95 = var0.charAt(var4);
               } catch (IndexOutOfBoundsException var75) {
                  var14 = var75;
                  break label366;
               } catch (NumberFormatException var76) {
                  var14 = var76;
                  break label366;
               } catch (IllegalArgumentException var77) {
                  var14 = var77;
                  break label366;
               }

               if (var95 != 'Z' && var95 != '+' && var95 != '-') {
                  int var8 = var4 + 2;

                  try {
                     var4 = a(var0, var4, var8);
                  } catch (IndexOutOfBoundsException var54) {
                     var14 = var54;
                     break label366;
                  } catch (NumberFormatException var55) {
                     var14 = var55;
                     break label366;
                  } catch (IllegalArgumentException var56) {
                     var14 = var56;
                     break label366;
                  }

                  var3 = var4;
                  if (var4 > 59) {
                     var3 = var4;
                     if (var4 < 63) {
                        var3 = 59;
                     }
                  }

                  label359: {
                     try {
                        if (!a(var0, var8, '.')) {
                           break label359;
                        }
                     } catch (IndexOutOfBoundsException var72) {
                        var14 = var72;
                        break label366;
                     } catch (NumberFormatException var73) {
                        var14 = var73;
                        break label366;
                     } catch (IllegalArgumentException var74) {
                        var14 = var74;
                        break label366;
                     }

                     int var12 = var8 + 1;

                     try {
                        var8 = a(var0, var12 + 1);
                        var108 = Math.min(var8, var12 + 3);
                        var4 = a(var0, var12, var108);
                     } catch (IndexOutOfBoundsException var51) {
                        var14 = var51;
                        break label366;
                     } catch (NumberFormatException var52) {
                        var14 = var52;
                        break label366;
                     } catch (IllegalArgumentException var53) {
                        var14 = var53;
                        break label366;
                     }

                     switch (var108 - var12) {
                        case 1:
                           var4 *= 100;
                           break;
                        case 2:
                           var4 *= 10;
                     }

                     var108 = var105;
                     var105 = var104;
                     var104 = var3;
                     var3 = var4;
                     var4 = var8;
                     break label335;
                  }

                  var108 = var105;
                  var105 = var3;
                  var4 = var8;
                  var8 = var104;
                  var3 = 0;
                  var104 = var105;
                  var105 = var8;
                  break label335;
               }
            }

            var108 = var104;
            int var112 = var105;
            var3 = 0;
            var104 = 0;
            var105 = var108;
            var108 = var112;
         } else {
            var3 = 0;
            var104 = 0;
            var105 = 0;
            var108 = 0;
         }

         try {
            if (var0.length() <= var4) {
               var14 = new IllegalArgumentException("No time zone indicator");
               throw var14;
            }
         } catch (IndexOutOfBoundsException var69) {
            var14 = var69;
            break label366;
         } catch (NumberFormatException var70) {
            var14 = var70;
            break label366;
         } catch (IllegalArgumentException var71) {
            var14 = var71;
            break label366;
         }

         char var2;
         try {
            var2 = var0.charAt(var4);
         } catch (IndexOutOfBoundsException var48) {
            var14 = var48;
            break label366;
         } catch (NumberFormatException var49) {
            var14 = var49;
            break label366;
         } catch (IllegalArgumentException var50) {
            var14 = var50;
            break label366;
         }

         TimeZone var114;
         if (var2 == 'Z') {
            try {
               var114 = a;
            } catch (IndexOutOfBoundsException var36) {
               var14 = var36;
               break label366;
            } catch (NumberFormatException var37) {
               var14 = var37;
               break label366;
            } catch (IllegalArgumentException var38) {
               var14 = var38;
               break label366;
            }

            var4++;
         } else {
            label360: {
               if (var2 != '+' && var2 != '-') {
                  try {
                     StringBuilder var118 = new StringBuilder();
                     IndexOutOfBoundsException var126 = new IndexOutOfBoundsException(
                        var118.append("Invalid time zone indicator '").append(var2).append("'").toString()
                     );
                     throw var126;
                  } catch (IndexOutOfBoundsException var18) {
                     var14 = var18;
                     break label366;
                  } catch (NumberFormatException var19) {
                     var14 = var19;
                     break label366;
                  } catch (IllegalArgumentException var20) {
                     var14 = var20;
                     break label366;
                  }
               }

               label361: {
                  try {
                     var115 = var0.substring(var4);
                     if (var115.length() >= 5) {
                        break label361;
                     }
                  } catch (IndexOutOfBoundsException var45) {
                     var14 = var45;
                     break label366;
                  } catch (NumberFormatException var46) {
                     var14 = var46;
                     break label366;
                  } catch (IllegalArgumentException var47) {
                     var14 = var47;
                     break label366;
                  }

                  try {
                     StringBuilder var15 = new StringBuilder();
                     var115 = var15.append(var115).append("00").toString();
                  } catch (IndexOutOfBoundsException var33) {
                     var14 = var33;
                     break label366;
                  } catch (NumberFormatException var34) {
                     var14 = var34;
                     break label366;
                  } catch (IllegalArgumentException var35) {
                     var14 = var35;
                     break label366;
                  }
               }

               int var113;
               label362: {
                  try {
                     var113 = var4 + var115.length();
                     if ("+0000".equals(var115) || "+00:00".equals(var115)) {
                        break label362;
                     }
                  } catch (IndexOutOfBoundsException var42) {
                     var14 = var42;
                     break label366;
                  } catch (NumberFormatException var43) {
                     var14 = var43;
                     break label366;
                  } catch (IllegalArgumentException var44) {
                     var14 = var44;
                     break label366;
                  }

                  String var16;
                  String var17;
                  TimeZone var123;
                  try {
                     StringBuilder var122 = new StringBuilder();
                     var16 = var122.append("GMT").append(var115).toString();
                     var123 = TimeZone.getTimeZone(var16);
                     var17 = var123.getID();
                  } catch (IndexOutOfBoundsException var27) {
                     var14 = var27;
                     break label366;
                  } catch (NumberFormatException var28) {
                     var14 = var28;
                     break label366;
                  } catch (IllegalArgumentException var29) {
                     var14 = var29;
                     break label366;
                  }

                  var114 = var123;
                  var4 = var113;

                  try {
                     if (var17.equals(var16)) {
                        break label360;
                     }
                  } catch (IndexOutOfBoundsException var39) {
                     var14 = var39;
                     break label366;
                  } catch (NumberFormatException var40) {
                     var14 = var40;
                     break label366;
                  } catch (IllegalArgumentException var41) {
                     var14 = var41;
                     break label366;
                  }

                  var114 = var123;
                  var4 = var113;

                  try {
                     if (!var17.replace(":", "").equals(var16)) {
                        StringBuilder var116 = new StringBuilder();
                        IndexOutOfBoundsException var128 = new IndexOutOfBoundsException(
                           var116.append("Mismatching time zone indicator: ").append(var16).append(" given, resolves to ").append(var123.getID()).toString()
                        );
                        throw var128;
                     }
                     break label360;
                  } catch (IndexOutOfBoundsException var24) {
                     var14 = var24;
                     break label366;
                  } catch (NumberFormatException var25) {
                     var14 = var25;
                     break label366;
                  } catch (IllegalArgumentException var26) {
                     var14 = var26;
                     break label366;
                  }
               }

               try {
                  var114 = a;
               } catch (IndexOutOfBoundsException var30) {
                  var14 = var30;
                  break label366;
               } catch (NumberFormatException var31) {
                  var14 = var31;
                  break label366;
               } catch (IllegalArgumentException var32) {
                  var14 = var32;
                  break label366;
               }

               var4 = var113;
            }
         }

         try {
            GregorianCalendar var124 = new GregorianCalendar(var114);
            var124.setLenient(false);
            var124.set(1, var9);
            var124.set(2, var10 - 1);
            var124.set(5, var11);
            var124.set(11, var108);
            var124.set(12, var105);
            var124.set(13, var104);
            var124.set(14, var3);
            var1.setIndex(var4);
            var117 = var124.getTime();
         } catch (IndexOutOfBoundsException var21) {
            var14 = var21;
            break label366;
         } catch (NumberFormatException var22) {
            var14 = var22;
            break label366;
         } catch (IllegalArgumentException var23) {
            var14 = var23;
            break label366;
         }

         return var117;
      }

      if (var0 == null) {
         var0 = null;
      } else {
         var0 = '"' + var0 + "'";
      }

      String var125;
      label237: {
         String var127 = var14.getMessage();
         if (var127 != null) {
            var125 = var127;
            if (!var127.isEmpty()) {
               break label237;
            }
         }

         var125 = "(" + var14.getClass().getName() + ")";
      }

      ParseException var92 = new ParseException("Failed to parse date [" + var0 + "]: " + var125, var1.getIndex());
      var92.initCause(var14);
      throw var92;
   }

   private static boolean a(String var0, int var1, char var2) {
      boolean var3;
      if (var1 < var0.length() && var0.charAt(var1) == var2) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }
}
