package org.joda.time.format;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class DateTimeFormat {
   private static final ConcurrentHashMap<String, DateTimeFormatter> a = new ConcurrentHashMap<>();
   private static final AtomicReferenceArray<DateTimeFormatter> b = new AtomicReferenceArray<>(25);

   private static String a(String var0, int[] var1) {
      StringBuilder var7 = new StringBuilder();
      int var3 = var1[0];
      int var6 = var0.length();
      char var2 = var0.charAt(var3);
      int var4;
      if (var2 >= 'A' && var2 <= 'Z' || var2 >= 'a' && var2 <= 'z') {
         var7.append(var2);

         while (true) {
            var4 = var3;
            if (var3 + 1 >= var6) {
               break;
            }

            var4 = var3;
            if (var0.charAt(var3 + 1) != var2) {
               break;
            }

            var7.append(var2);
            var3++;
         }
      } else {
         var7.append('\'');
         boolean var5 = false;

         while (true) {
            var4 = var3;
            if (var3 >= var6) {
               break;
            }

            var2 = var0.charAt(var3);
            boolean var9;
            if (var2 == '\'') {
               if (var3 + 1 < var6 && var0.charAt(var3 + 1) == '\'') {
                  var3++;
                  var7.append(var2);
                  var9 = var5;
               } else if (!var5) {
                  var9 = true;
               } else {
                  var9 = false;
               }
            } else {
               if (!var5 && (var2 >= 'A' && var2 <= 'Z' || var2 >= 'a' && var2 <= 'z')) {
                  var4 = var3 - 1;
                  break;
               }

               var7.append(var2);
               var9 = var5;
            }

            var3++;
            var5 = var9;
         }
      }

      var1[0] = var4;
      return var7.toString();
   }

   public static DateTimeFormatter a(String var0) {
      return c(var0);
   }

   private static void a(DateTimeFormatterBuilder var0, String var1) {
      int var5 = var1.length();
      int[] var10 = new int[1];
      int var2 = 0;

      while (var2 < var5) {
         var10[0] = var2;
         String var11 = a(var1, var10);
         int var6 = var10[0];
         int var4 = var11.length();
         if (var4 == 0) {
            break;
         }

         char var7 = var11.charAt(0);
         label80:
         switch (var7) {
            case '\'':
               var11 = var11.substring(1);
               if (var11.length() == 1) {
                  var0.a(var11.charAt(0));
               } else {
                  var0.a(new String(var11));
               }
               break;
            case 'C':
               var0.g(var4, var4);
               break;
            case 'D':
               var0.i(var4);
               break;
            case 'E':
               if (var4 >= 4) {
                  var0.d();
               } else {
                  var0.e();
               }
               break;
            case 'G':
               var0.h();
               break;
            case 'H':
               var0.c(var4);
               break;
            case 'K':
               var0.e(var4);
               break;
            case 'M':
               if (var4 >= 3) {
                  if (var4 >= 4) {
                     var0.f();
                  } else {
                     var0.g();
                  }
               } else {
                  var0.k(var4);
               }
               break;
            case 'S':
               var0.a(var4, var4);
               break;
            case 'Y':
            case 'x':
            case 'y':
               if (var4 == 2) {
                  boolean var8 = true;
                  boolean var9 = true;
                  if (var6 + 1 < var5) {
                     var10[0]++;
                     var8 = var9;
                     if (b(a(var1, var10))) {
                        var8 = false;
                     }

                     var10[0]--;
                  }

                  switch (var7) {
                     case 'x':
                        var0.b(new DateTime().g() - 30, var8);
                        break label80;
                     default:
                        var0.a(new DateTime().f() - 30, var8);
                  }
               } else {
                  byte var3 = 9;
                  var2 = var3;
                  if (var6 + 1 < var5) {
                     var10[0]++;
                     var2 = var3;
                     if (b(a(var1, var10))) {
                        var2 = var4;
                     }

                     var10[0]--;
                  }

                  switch (var7) {
                     case 'Y':
                        var0.f(var4, var2);
                        break label80;
                     case 'x':
                        var0.d(var4, var2);
                        break label80;
                     case 'y':
                        var0.e(var4, var2);
                  }
               }
               break;
            case 'Z':
               if (var4 == 1) {
                  var0.a(null, "Z", false, 2, 2);
               } else if (var4 == 2) {
                  var0.a(null, "Z", true, 2, 2);
               } else {
                  var0.j();
               }
               break;
            case 'a':
               var0.c();
               break;
            case 'd':
               var0.h(var4);
               break;
            case 'e':
               var0.g(var4);
               break;
            case 'h':
               var0.f(var4);
               break;
            case 'k':
               var0.d(var4);
               break;
            case 'm':
               var0.b(var4);
               break;
            case 's':
               var0.a(var4);
               break;
            case 'w':
               var0.j(var4);
               break;
            case 'z':
               if (var4 >= 4) {
                  var0.i();
               } else {
                  var0.a((Map<String, DateTimeZone>)null);
               }
               break;
            default:
               throw new IllegalArgumentException("Illegal pattern component: " + var11);
         }

         var2 = var6 + 1;
      }
   }

   private static boolean b(String var0) {
      boolean var3 = true;
      int var1 = var0.length();
      if (var1 > 0) {
         boolean var2 = var3;
         switch (var0.charAt(0)) {
            case 'C':
            case 'D':
            case 'F':
            case 'H':
            case 'K':
            case 'S':
            case 'W':
            case 'Y':
            case 'c':
            case 'd':
            case 'e':
            case 'h':
            case 'k':
            case 'm':
            case 's':
            case 'w':
            case 'x':
            case 'y':
               return var2;
            case 'M':
               if (var1 <= 2) {
                  var2 = var3;
                  return var2;
               }
         }
      }

      return false;
   }

   private static DateTimeFormatter c(String var0) {
      if (var0 != null && var0.length() != 0) {
         DateTimeFormatter var2 = a.get(var0);
         DateTimeFormatter var1 = var2;
         if (var2 == null) {
            DateTimeFormatterBuilder var4 = new DateTimeFormatterBuilder();
            a(var4, var0);
            var1 = var4.a();
            if (a.size() < 500) {
               DateTimeFormatter var3 = a.putIfAbsent(var0, var1);
               if (var3 != null) {
                  var1 = var3;
               }
            }
         }

         return var1;
      } else {
         throw new IllegalArgumentException("Invalid pattern specification");
      }
   }
}
