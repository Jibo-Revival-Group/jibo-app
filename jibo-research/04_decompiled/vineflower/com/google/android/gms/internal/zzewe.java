package com.google.android.gms.internal;

import android.util.Log;
import java.net.URI;

final class zzewe extends zzewg {
   private final zzewv a;

   zzewe(zzewv var1) {
      this.a = var1;
   }

   private static URI a(String var0) {
      Object var3;
      if (var0 == null) {
         var3 = null;
      } else {
         try {
            var3 = URI.create(var0);
            return var3;
         } catch (IllegalArgumentException var1) {
            var4 = var1;
         } catch (IllegalStateException var2) {
            var4 = var2;
         }

         Log.w("FirebasePerformance", "getResultUrl throws exception", var4);
         var3 = null;
      }

      return var3;
   }

   private static boolean a(long var0) {
      boolean var2;
      if (var0 >= 0L) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private static boolean b(long var0) {
      boolean var2;
      if (var0 >= 0L) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private static boolean b(String var0) {
      boolean var1;
      if (var0 == null) {
         var1 = true;
      } else {
         var1 = var0.trim().isEmpty();
      }

      return var1;
   }

   private static boolean c(String var0) {
      boolean var4 = false;
      boolean var3;
      if (var0.length() > 128) {
         var3 = var4;
      } else {
         int var1 = 0;

         while (true) {
            if (var1 >= var0.length()) {
               var3 = true;
               break;
            }

            char var2 = var0.charAt(var1);
            var3 = var4;
            if (var2 <= 31) {
               break;
            }

            var3 = var4;
            if (var2 > 127) {
               break;
            }

            var1++;
         }
      }

      return var3;
   }

   @Override
   public final boolean a() {
      boolean var2;
      if (b(this.a.a)) {
         String var3 = String.valueOf(this.a.a);
         if (var3.length() != 0) {
            var3 = "URL is missing:".concat(var3);
         } else {
            var3 = new String("URL is missing:");
         }

         Log.i("FirebasePerformance", var3);
         var2 = false;
      } else {
         URI var12 = a(this.a.a);
         if (var12 == null) {
            Log.i("FirebasePerformance", "URL cannot be parsed");
            var2 = false;
         } else {
            String var4 = var12.getHost();
            boolean var1;
            if (var4 != null && !b(var4) && var4.length() <= 255) {
               var1 = 1;
            } else {
               var1 = 0;
            }

            if (!var1) {
               Log.i("FirebasePerformance", "URL host is null or invalid");
               var2 = false;
            } else {
               var4 = var12.getScheme();
               if (var4 == null || !"http".equalsIgnoreCase(var4) && !"https".equalsIgnoreCase(var4)) {
                  var1 = (boolean)0;
               } else {
                  var1 = (boolean)1;
               }

               if (!var1) {
                  Log.i("FirebasePerformance", "URL scheme is null or invalid");
                  var2 = false;
               } else {
                  if (var12.getUserInfo() == null) {
                     var1 = (boolean)1;
                  } else {
                     var1 = (boolean)0;
                  }

                  if (!var1) {
                     Log.i("FirebasePerformance", "URL user info is null");
                     var2 = false;
                  } else {
                     var1 = var12.getPort();
                     boolean var8;
                     if (var1 != -1 && var1 <= 0) {
                        var8 = false;
                     } else {
                        var8 = true;
                     }

                     if (!var8) {
                        Log.i("FirebasePerformance", "URL port is less than or equal to 0");
                        var2 = false;
                     } else {
                        Integer var13 = this.a.b;
                        if (var13 != null && var13 != 0) {
                           var8 = true;
                        } else {
                           var8 = false;
                        }

                        if (!var8) {
                           String var14 = String.valueOf(this.a.b);
                           Log.i(
                              "FirebasePerformance",
                              new StringBuilder(String.valueOf(var14).length() + 32).append("HTTP Method is null or invalid: ").append(var14).toString()
                           );
                           var2 = false;
                        } else {
                           if (this.a.f != null) {
                              if (this.a.f > 0) {
                                 var8 = true;
                              } else {
                                 var8 = false;
                              }

                              if (!var8) {
                                 String var23 = String.valueOf(this.a.f);
                                 Log.i(
                                    "FirebasePerformance",
                                    new StringBuilder(String.valueOf(var23).length() + 38)
                                       .append("HTTP ResponseCode is a negative value:")
                                       .append(var23)
                                       .toString()
                                 );
                                 var2 = false;
                                 return var2;
                              }
                           }

                           if (this.a.c != null && !b(this.a.c)) {
                              String var22 = String.valueOf(this.a.c);
                              Log.i(
                                 "FirebasePerformance",
                                 new StringBuilder(String.valueOf(var22).length() + 36).append("Request Payload is a negative value:").append(var22).toString()
                              );
                              var2 = false;
                           } else if (this.a.d != null && !b(this.a.d)) {
                              String var21 = String.valueOf(this.a.d);
                              Log.i(
                                 "FirebasePerformance",
                                 new StringBuilder(String.valueOf(var21).length() + 37)
                                    .append("Response Payload is a negative value:")
                                    .append(var21)
                                    .toString()
                              );
                              var2 = false;
                           } else if (this.a.h == null || this.a.h <= 0L) {
                              String var20 = String.valueOf(this.a.h);
                              Log.i(
                                 "FirebasePerformance",
                                 new StringBuilder(String.valueOf(var20).length() + 64)
                                    .append("Start time of the request is null, or zero, or a negative value:")
                                    .append(var20)
                                    .toString()
                              );
                              var2 = false;
                           } else if (this.a.i != null && !a(this.a.i)) {
                              String var19 = String.valueOf(this.a.i);
                              Log.i(
                                 "FirebasePerformance",
                                 new StringBuilder(String.valueOf(var19).length() + 49)
                                    .append("Time to complete the request is a negative value:")
                                    .append(var19)
                                    .toString()
                              );
                              var2 = false;
                           } else if (this.a.j != null && !a(this.a.j)) {
                              String var18 = String.valueOf(this.a.j);
                              Log.i(
                                 "FirebasePerformance",
                                 new StringBuilder(String.valueOf(var18).length() + 92)
                                    .append("Time from the start of the request to the start of the response is null or a negative value:")
                                    .append(var18)
                                    .toString()
                              );
                              var2 = false;
                           } else if (this.a.k == null || this.a.k <= 0L) {
                              String var17 = String.valueOf(this.a.k);
                              Log.i(
                                 "FirebasePerformance",
                                 new StringBuilder(String.valueOf(var17).length() + 88)
                                    .append("Time from the start of the request to the end of the response is null, negative or zero:")
                                    .append(var17)
                                    .toString()
                              );
                              var2 = false;
                           } else if (this.a.f == null) {
                              Log.i("FirebasePerformance", "Did not receive a HTTP Response Code");
                              var2 = false;
                           } else {
                              if (this.a.g != null && !c(this.a.g)) {
                                 String var15 = String.valueOf(this.a.g);
                                 String var16;
                                 if (var15.length() != 0) {
                                    var16 = "The content type of the response is not a valid content-type:".concat(var15);
                                 } else {
                                    var16 = new String("The content type of the response is not a valid content-type:");
                                 }

                                 Log.i("FirebasePerformance", var16);
                                 this.a.g = null;
                              }

                              var2 = true;
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
}
