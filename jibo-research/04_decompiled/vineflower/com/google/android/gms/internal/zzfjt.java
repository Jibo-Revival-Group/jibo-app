package com.google.android.gms.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzfjt {
   public static <T extends zzfjs> String a(T var0) {
      String var5;
      if (var0 == null) {
         var5 = "";
      } else {
         StringBuffer var2 = new StringBuffer();

         try {
            StringBuffer var1 = new StringBuffer();
            a(null, var0, var1, var2);
         } catch (IllegalAccessException var3) {
            String var7 = String.valueOf(var3.getMessage());
            String var9;
            if (var7.length() != 0) {
               var9 = "Error printing proto: ".concat(var7);
            } else {
               var9 = new String("Error printing proto: ");
            }

            return var9;
         } catch (InvocationTargetException var4) {
            String var6 = String.valueOf(var4.getMessage());
            String var8;
            if (var6.length() != 0) {
               var8 = "Error printing proto: ".concat(var6);
            } else {
               var8 = new String("Error printing proto: ");
            }

            return var8;
         }

         var5 = var2.toString();
      }

      return var5;
   }

   private static String a(String var0) {
      StringBuffer var3 = new StringBuffer();

      for (int var2 = 0; var2 < var0.length(); var2++) {
         char var1 = var0.charAt(var2);
         if (var2 == 0) {
            var3.append(Character.toLowerCase(var1));
         } else if (Character.isUpperCase(var1)) {
            var3.append('_').append(Character.toLowerCase(var1));
         } else {
            var3.append(var1);
         }
      }

      return var3.toString();
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static void a(String var0, Object var1, StringBuffer var2, StringBuffer var3) throws IllegalAccessException, InvocationTargetException {
      if (var1 != null) {
         if (var1 instanceof zzfjs) {
            int var7 = var2.length();
            if (var0 != null) {
               var3.append(var2).append(a(var0)).append(" <\n");
               var2.append("  ");
            }

            Class var10 = var1.getClass();

            for (Field var13 : var10.getFields()) {
               int var5 = var13.getModifiers();
               String var9 = var13.getName();
               if (!"cachedSize".equals(var9) && (var5 & 1) == 1 && (var5 & 8) != 8 && !var9.startsWith("_") && !var9.endsWith("_")) {
                  Class var12 = var13.getType();
                  Object var36 = var13.get(var1);
                  if (var12.isArray() && var12.getComponentType() != byte.class) {
                     if (var36 == null) {
                        var5 = 0;
                     } else {
                        var5 = Array.getLength(var36);
                     }

                     for (int var6 = 0; var6 < var5; var6++) {
                        a(var9, Array.get(var36, var6), var2, var3);
                     }
                  } else {
                     a(var9, var36, var2, var3);
                  }
               }
            }

            Method[] var34 = var10.getMethods();
            int var26 = var34.length;

            for (int var24 = 0; var24 < var26; var24++) {
               String var27 = var34[var24].getName();
               if (var27.startsWith("set")) {
                  String var35 = var27.substring(3);

                  label146: {
                     try {
                        var27 = String.valueOf(var35);
                        if (var27.length() != 0) {
                           var27 = "has".concat(var27);
                           break label146;
                        }
                     } catch (NoSuchMethodException var19) {
                        continue;
                     }

                     try {
                        var27 = new String("has");
                     } catch (NoSuchMethodException var17) {
                        continue;
                     }
                  }

                  try {
                     var30 = var10.getMethod(var27);
                  } catch (NoSuchMethodException var16) {
                     continue;
                  }

                  if ((Boolean)var30.invoke(var1)) {
                     label147: {
                        try {
                           var27 = String.valueOf(var35);
                           if (var27.length() != 0) {
                              var27 = "get".concat(var27);
                              break label147;
                           }
                        } catch (NoSuchMethodException var18) {
                           continue;
                        }

                        try {
                           var27 = new String("get");
                        } catch (NoSuchMethodException var15) {
                           continue;
                        }
                     }

                     try {
                        var33 = var10.getMethod(var27);
                     } catch (NoSuchMethodException var14) {
                        continue;
                     }

                     a(var35, var33.invoke(var1), var2, var3);
                  }
               }
            }

            if (var0 != null) {
               var2.setLength(var7);
               var3.append(var2).append(">\n");
            }
         } else {
            var0 = a(var0);
            var3.append(var2).append(var0).append(": ");
            if (var1 instanceof String) {
               String var23 = (String)var1;
               var0 = var23;
               if (!var23.startsWith("http")) {
                  var0 = var23;
                  if (var23.length() > 200) {
                     var0 = String.valueOf(var23.substring(0, 200)).concat("[...]");
                  }
               }

               var0 = b(var0);
               var3.append("\"").append(var0).append("\"");
            } else if (var1 instanceof byte[]) {
               a((byte[])var1, var3);
            } else {
               var3.append(var1);
            }

            var3.append("\n");
         }
      }
   }

   private static void a(byte[] var0, StringBuffer var1) {
      if (var0 == null) {
         var1.append("\"\"");
      } else {
         var1.append('"');

         for (int var2 = 0; var2 < var0.length; var2++) {
            int var3 = var0[var2] & 255;
            if (var3 == 92 || var3 == 34) {
               var1.append('\\').append((char)var3);
            } else if (var3 >= 32 && var3 < 127) {
               var1.append((char)var3);
            } else {
               var1.append(String.format("\\%03o", var3));
            }
         }

         var1.append('"');
      }
   }

   private static String b(String var0) {
      int var3 = var0.length();
      StringBuilder var4 = new StringBuilder(var3);

      for (int var2 = 0; var2 < var3; var2++) {
         char var1 = var0.charAt(var2);
         if (var1 >= ' ' && var1 <= '~' && var1 != '"' && var1 != '\'') {
            var4.append(var1);
         } else {
            var4.append(String.format("\\u%04x", Integer.valueOf(var1)));
         }
      }

      return var4.toString();
   }
}
