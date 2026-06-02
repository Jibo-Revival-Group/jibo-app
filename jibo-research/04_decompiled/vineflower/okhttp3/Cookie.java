package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

public final class Cookie {
   private static final Pattern a = Pattern.compile("(\\d{2,4})[^\\d]*");
   private static final Pattern b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
   private static final Pattern c = Pattern.compile("(\\d{1,2})[^\\d]*");
   private static final Pattern d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
   private final String e;
   private final String f;
   private final long g;
   private final String h;
   private final String i;
   private final boolean j;
   private final boolean k;
   private final boolean l;
   private final boolean m;

   private Cookie(String var1, String var2, long var3, String var5, String var6, boolean var7, boolean var8, boolean var9, boolean var10) {
      this.e = var1;
      this.f = var2;
      this.g = var3;
      this.h = var5;
      this.i = var6;
      this.j = var7;
      this.k = var8;
      this.m = var9;
      this.l = var10;
   }

   private static int a(String var0, int var1, int var2, boolean var3) {
      while (true) {
         int var4 = var2;
         if (var1 < var2) {
            char var6 = var0.charAt(var1);
            boolean var7;
            if ((var6 >= ' ' || var6 == '\t')
               && var6 < 127
               && (var6 < '0' || var6 > '9')
               && (var6 < 'a' || var6 > 'z')
               && (var6 < 'A' || var6 > 'Z')
               && var6 != ':') {
               var7 = false;
            } else {
               var7 = true;
            }

            boolean var5;
            if (!var3) {
               var5 = true;
            } else {
               var5 = false;
            }

            if (var7 != var5) {
               var1++;
               continue;
            }

            var4 = var1;
         }

         return var4;
      }
   }

   private static long a(String var0) {
      long var3 = Long.MIN_VALUE;

      long var7;
      try {
         var7 = Long.parseLong(var0);
      } catch (NumberFormatException var6) {
         if (var0.matches("-?\\d+")) {
            var7 = var3;
            if (!var0.startsWith("-")) {
               var7 = Long.MAX_VALUE;
            }

            return var7;
         }

         throw var6;
      }

      if (var7 <= 0L) {
         var7 = var3;
      }

      return var7;
   }

   private static long a(String var0, int var1, int var2) {
      int var8 = a(var0, var1, var2, false);
      int var3 = -1;
      int var4 = -1;
      int var7 = -1;
      int var5 = -1;
      int var6 = -1;
      var1 = -1;
      Matcher var16 = d.matcher(var0);

      while (var8 < var2) {
         int var14 = a(var0, var8 + 1, var2, true);
         var16.region(var8, var14);
         int var9;
         int var10;
         int var11;
         int var12;
         int var13;
         if (var3 == -1 && var16.usePattern(d).matches()) {
            var9 = Integer.parseInt(var16.group(1));
            var10 = Integer.parseInt(var16.group(2));
            var13 = Integer.parseInt(var16.group(3));
            var12 = var5;
            var11 = var6;
            var8 = var1;
         } else if (var5 == -1 && var16.usePattern(c).matches()) {
            var12 = Integer.parseInt(var16.group(1));
            var8 = var1;
            var11 = var6;
            var13 = var7;
            var10 = var4;
            var9 = var3;
         } else if (var6 == -1 && var16.usePattern(b).matches()) {
            String var15 = var16.group(1).toLowerCase(Locale.US);
            var11 = b.pattern().indexOf(var15) / 4;
            var8 = var1;
            var12 = var5;
            var13 = var7;
            var10 = var4;
            var9 = var3;
         } else {
            var8 = var1;
            var11 = var6;
            var12 = var5;
            var13 = var7;
            var10 = var4;
            var9 = var3;
            if (var1 == -1) {
               var8 = var1;
               var11 = var6;
               var12 = var5;
               var13 = var7;
               var10 = var4;
               var9 = var3;
               if (var16.usePattern(a).matches()) {
                  var8 = Integer.parseInt(var16.group(1));
                  var11 = var6;
                  var12 = var5;
                  var13 = var7;
                  var10 = var4;
                  var9 = var3;
               }
            }
         }

         var14 = a(var0, var14 + 1, var2, false);
         var1 = var8;
         var6 = var11;
         var5 = var12;
         var7 = var13;
         var4 = var10;
         var3 = var9;
         var8 = var14;
      }

      var2 = var1;
      if (var1 >= 70) {
         var2 = var1;
         if (var1 <= 99) {
            var2 = var1 + 1900;
         }
      }

      var1 = var2;
      if (var2 >= 0) {
         var1 = var2;
         if (var2 <= 69) {
            var1 = var2 + 2000;
         }
      }

      if (var1 < 1601) {
         throw new IllegalArgumentException();
      } else if (var6 == -1) {
         throw new IllegalArgumentException();
      } else if (var5 < 1 || var5 > 31) {
         throw new IllegalArgumentException();
      } else if (var3 < 0 || var3 > 23) {
         throw new IllegalArgumentException();
      } else if (var4 < 0 || var4 > 59) {
         throw new IllegalArgumentException();
      } else if (var7 >= 0 && var7 <= 59) {
         GregorianCalendar var17 = new GregorianCalendar(Util.f);
         var17.setLenient(false);
         var17.set(1, var1);
         var17.set(2, var6 - 1);
         var17.set(5, var5);
         var17.set(11, var3);
         var17.set(12, var4);
         var17.set(13, var7);
         var17.set(14, 0);
         return var17.getTimeInMillis();
      } else {
         throw new IllegalArgumentException();
      }
   }

   public static List<Cookie> a(HttpUrl var0, Headers var1) {
      List var4 = var1.b("Set-Cookie");
      ArrayList var7 = null;
      int var3 = var4.size();

      for (int var2 = 0; var2 < var3; var2++) {
         Cookie var5 = a(var0, (String)var4.get(var2));
         if (var5 != null) {
            if (var7 == null) {
               var7 = new ArrayList();
            }

            var7.add(var5);
         }
      }

      List var6;
      if (var7 != null) {
         var6 = Collections.unmodifiableList(var7);
      } else {
         var6 = Collections.emptyList();
      }

      return var6;
   }

   static Cookie a(long var0, HttpUrl var2, String var3) {
      int var5 = var3.length();
      int var4 = Util.a(var3, 0, var5, ';');
      int var6 = Util.a(var3, 0, var4, '=');
      Cookie var28;
      if (var6 == var4) {
         var28 = null;
      } else {
         String var21 = Util.c(var3, 0, var6);
         if (!var21.isEmpty() && Util.b(var21) == -1) {
            String var22 = Util.c(var3, var6 + 1, var4);
            if (Util.b(var22) != -1) {
               var28 = null;
            } else {
               long var12 = 253402300799999L;
               long var14 = -1L;
               String var18 = null;
               String var19 = null;
               boolean var11 = false;
               boolean var10 = false;
               boolean var9 = true;
               boolean var8 = false;
               var4++;

               while (var4 < var5) {
                  int var7 = Util.a(var3, var4, var5, ';');
                  var6 = Util.a(var3, var4, var7, '=');
                  String var23 = Util.c(var3, var4, var6);
                  String var20;
                  if (var6 < var7) {
                     var20 = Util.c(var3, var6 + 1, var7);
                  } else {
                     var20 = "";
                  }

                  label108:
                  if (var23.equalsIgnoreCase("expires")) {
                     long var37;
                     try {
                        var37 = a(var20, 0, var20.length());
                     } catch (IllegalArgumentException var24) {
                        break label108;
                     }

                     var8 = true;
                     var12 = var37;
                  } else {
                     label106:
                     if (var23.equalsIgnoreCase("max-age")) {
                        long var16;
                        try {
                           var16 = a(var20);
                        } catch (NumberFormatException var25) {
                           break label106;
                        }

                        var14 = var16;
                        var8 = true;
                     } else {
                        label104:
                        if (var23.equalsIgnoreCase("domain")) {
                           try {
                              var20 = b(var20);
                           } catch (IllegalArgumentException var26) {
                              break label104;
                           }

                           var18 = var20;
                           var9 = false;
                        } else if (var23.equalsIgnoreCase("path")) {
                           var19 = var20;
                        } else if (var23.equalsIgnoreCase("secure")) {
                           var11 = true;
                        } else if (var23.equalsIgnoreCase("httponly")) {
                           var10 = true;
                        }
                     }
                  }

                  var4 = var7 + 1;
               }

               if (var14 == Long.MIN_VALUE) {
                  var0 = Long.MIN_VALUE;
               } else {
                  label89:
                  if (var14 != -1L) {
                     if (var14 <= 9223372036854775L) {
                        var12 = var14 * 1000L;
                     } else {
                        var12 = Long.MAX_VALUE;
                     }

                     var12 += var0;
                     if (var12 >= var0) {
                        var0 = var12;
                        if (var12 <= 253402300799999L) {
                           break label89;
                        }
                     }

                     var0 = 253402300799999L;
                  } else {
                     var0 = var12;
                  }
               }

               String var39 = var2.g();
               if (var18 == null) {
                  var3 = var39;
               } else {
                  var3 = var18;
                  if (!a(var39, var18)) {
                     Object var40 = null;
                     return (Cookie)var40;
                  }
               }

               if (var39.length() != var3.length() && PublicSuffixDatabase.a().a(var3) == null) {
                  var28 = null;
               } else {
                  String var30;
                  if (var19 != null && var19.startsWith("/")) {
                     var30 = var19;
                  } else {
                     String var29 = var2.i();
                     var4 = var29.lastIndexOf(47);
                     if (var4 != 0) {
                        var30 = var29.substring(0, var4);
                     } else {
                        var30 = "/";
                     }
                  }

                  var28 = new Cookie(var21, var22, var0, var3, var30, var11, var10, var9, var8);
               }
            }
         } else {
            var28 = null;
         }
      }

      return var28;
   }

   public static Cookie a(HttpUrl var0, String var1) {
      return a(System.currentTimeMillis(), var0, var1);
   }

   private static boolean a(String var0, String var1) {
      boolean var2 = true;
      if (!var0.equals(var1) && (!var0.endsWith(var1) || var0.charAt(var0.length() - var1.length() - 1) != '.' || Util.c(var0))) {
         var2 = false;
      }

      return var2;
   }

   private static String b(String var0) {
      if (var0.endsWith(".")) {
         throw new IllegalArgumentException();
      }

      String var1 = var0;
      if (var0.startsWith(".")) {
         var1 = var0.substring(1);
      }

      var0 = Util.a(var1);
      if (var0 == null) {
         throw new IllegalArgumentException();
      } else {
         return var0;
      }
   }

   public String a() {
      return this.e;
   }

   String a(boolean var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append(this.e);
      var2.append('=');
      var2.append(this.f);
      if (this.l) {
         if (this.g == Long.MIN_VALUE) {
            var2.append("; max-age=0");
         } else {
            var2.append("; expires=").append(HttpDate.a(new Date(this.g)));
         }
      }

      if (!this.m) {
         var2.append("; domain=");
         if (var1) {
            var2.append(".");
         }

         var2.append(this.h);
      }

      var2.append("; path=").append(this.i);
      if (this.j) {
         var2.append("; secure");
      }

      if (this.k) {
         var2.append("; httponly");
      }

      return var2.toString();
   }

   public String b() {
      return this.f;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if (!(var1 instanceof Cookie)) {
         var2 = var3;
      } else {
         var1 = var1;
         var2 = var3;
         if (var1.e.equals(this.e)) {
            var2 = var3;
            if (var1.f.equals(this.f)) {
               var2 = var3;
               if (var1.h.equals(this.h)) {
                  var2 = var3;
                  if (var1.i.equals(this.i)) {
                     var2 = var3;
                     if (var1.g == this.g) {
                        var2 = var3;
                        if (var1.j == this.j) {
                           var2 = var3;
                           if (var1.k == this.k) {
                              var2 = var3;
                              if (var1.l == this.l) {
                                 var2 = var3;
                                 if (var1.m == this.m) {
                                    var2 = true;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      byte var4 = 0;
      int var5 = this.e.hashCode();
      int var9 = this.f.hashCode();
      int var8 = this.h.hashCode();
      int var6 = this.i.hashCode();
      int var7 = (int)(this.g ^ this.g >>> 32);
      byte var1;
      if (this.j) {
         var1 = 0;
      } else {
         var1 = 1;
      }

      byte var2;
      if (this.k) {
         var2 = 0;
      } else {
         var2 = 1;
      }

      byte var3;
      if (this.l) {
         var3 = 0;
      } else {
         var3 = 1;
      }

      if (!this.m) {
         var4 = 1;
      }

      return (var3 + (var2 + (var1 + (((((var5 + 527) * 31 + var9) * 31 + var8) * 31 + var6) * 31 + var7) * 31) * 31) * 31) * 31 + var4;
   }

   @Override
   public String toString() {
      return this.a(false);
   }
}
