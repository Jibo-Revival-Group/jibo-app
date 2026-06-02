package com.google.android.gms.internal;

import android.util.Log;
import java.util.AbstractMap.SimpleEntry;

final class zzewf extends zzewg {
   private zzewy a;

   zzewf(zzewy var1) {
      this.a = var1;
   }

   private static boolean a(zzewy var0) {
      boolean var5 = true;
      boolean var1;
      if (var0.d.length > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      boolean var4;
      if (var1) {
         var4 = var5;
      } else {
         zzewy[] var6 = var0.e;
         int var3 = var6.length;

         for (int var7 = 0; var7 < var3; var7++) {
            boolean var2;
            if (var6[var7].d.length > 0) {
               var2 = true;
            } else {
               var2 = false;
            }

            var4 = var5;
            if (var2) {
               return var4;
            }
         }

         var4 = false;
      }

      return var4;
   }

   private final boolean a(zzewy var1, int var2) {
      boolean var6 = true;
      boolean var5;
      if (var1 == null) {
         Log.w("FirebasePerformance", "TraceMetric is null");
         var5 = false;
      } else if (var2 > 1) {
         Log.w("FirebasePerformance", "Exceed MAX_SUBTRACE_DEEP:1");
         var5 = false;
      } else {
         boolean var3;
         label60: {
            String var7 = var1.a;
            if (var7 != null) {
               var7 = var7.trim();
               if (!var7.isEmpty() && var7.length() <= 100) {
                  var3 = 1;
                  break label60;
               }
            }

            var3 = 0;
         }

         if (!var3) {
            String var8 = String.valueOf(var1.a);
            String var9;
            if (var8.length() != 0) {
               var9 = "invalid TraceId:".concat(var8);
            } else {
               var9 = new String("invalid TraceId:");
            }

            Log.w("FirebasePerformance", var9);
            var5 = false;
         } else {
            if (var1 != null && var1.c != null && var1.c > 0L) {
               var3 = (boolean)1;
            } else {
               var3 = (boolean)0;
            }

            if (!var3) {
               String var10 = String.valueOf(var1.c);
               Log.w("FirebasePerformance", new StringBuilder(String.valueOf(var10).length() + 22).append("invalid TraceDuration:").append(var10).toString());
               var5 = false;
            } else if (var1.b == null) {
               Log.w("FirebasePerformance", "clientStartTimeUs is null.");
               var5 = false;
            } else {
               zzewy[] var14 = var1.e;
               int var4 = var14.length;
               var3 = 0;

               while (true) {
                  if (var3 >= var4) {
                     var5 = var6;
                     if (var1.f != null) {
                        var5 = var6;
                        if (!a(var1.f)) {
                           var5 = false;
                        }
                     }
                     break;
                  }

                  if (!this.a(var14[var3], var2 + 1)) {
                     var5 = false;
                     break;
                  }

                  var3++;
               }
            }
         }
      }

      return var5;
   }

   private static boolean a(zzexa[] var0) {
      boolean var3 = false;
      int var2 = var0.length;
      int var1 = 0;

      while (true) {
         if (var1 >= var2) {
            var3 = true;
            break;
         }

         zzexa var4 = var0[var1];
         String var5 = zzewg.a(new SimpleEntry<>(var4.a, var4.b));
         if (var5 != null) {
            Log.w("FirebasePerformance", var5);
            break;
         }

         var1++;
      }

      return var3;
   }

   private final boolean b(zzewy var1, int var2) {
      boolean var7 = true;
      boolean var6;
      if (var1 == null) {
         var6 = false;
      } else if (var2 > 1) {
         Log.w("FirebasePerformance", "Exceed MAX_SUBTRACE_DEEP:1");
         var6 = false;
      } else {
         for (zzewz var8 : var1.d) {
            String var10 = var8.a;
            boolean var3;
            if (var10 == null) {
               var3 = false;
            } else {
               var10 = var10.trim();
               if (var10.isEmpty()) {
                  Log.w("FirebasePerformance", "counterId is empty");
                  var3 = false;
               } else if (var10.length() > 100) {
                  Log.w("FirebasePerformance", "counterId exceeded max length 100");
                  var3 = false;
               } else {
                  var3 = true;
               }
            }

            if (!var3) {
               String var12 = String.valueOf(var8.a);
               String var13;
               if (var12.length() != 0) {
                  var13 = "invalid CounterId:".concat(var12);
               } else {
                  var13 = new String("invalid CounterId:");
               }

               Log.w("FirebasePerformance", var13);
               var6 = false;
               return var6;
            }

            Long var19 = var8.b;
            if (var19 != null && var19 >= 0L) {
               var3 = true;
            } else {
               var3 = false;
            }

            if (!var3) {
               String var11 = String.valueOf(var8.b);
               Log.w("FirebasePerformance", new StringBuilder(String.valueOf(var11).length() + 21).append("invalid CounterValue:").append(var11).toString());
               var6 = false;
               return var6;
            }
         }

         zzewy[] var14 = var1.e;
         int var17 = var14.length;
         int var16 = 0;

         while (true) {
            var6 = var7;
            if (var16 >= var17) {
               break;
            }

            if (!this.b(var14[var16], var2 + 1)) {
               var6 = false;
               break;
            }

            var16++;
         }
      }

      return var6;
   }

   @Override
   public final boolean a() {
      boolean var1;
      if (!this.a(this.a, 0)) {
         String var2 = String.valueOf(this.a.a);
         if (var2.length() != 0) {
            var2 = "Invalid Trace:".concat(var2);
         } else {
            var2 = new String("Invalid Trace:");
         }

         Log.w("FirebasePerformance", var2);
         var1 = false;
      } else if (a(this.a) && !this.b(this.a, 0)) {
         String var4 = String.valueOf(this.a.a);
         if (var4.length() != 0) {
            var4 = "Invalid Counters for Trace:".concat(var4);
         } else {
            var4 = new String("Invalid Counters for Trace:");
         }

         Log.w("FirebasePerformance", var4);
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }
}
