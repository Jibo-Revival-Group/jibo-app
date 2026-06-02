package org.joda.time.chrono;

import org.joda.time.Chronology;

abstract class BasicGJChronology extends BasicChronology {
   private static final int[] a = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
   private static final int[] b = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
   private static final long[] c = new long[12];
   private static final long[] d = new long[12];

   static {
      long var3 = 0L;
      int var0 = 0;
      long var1 = 0L;

      while (var0 < 11) {
         var1 += a[var0] * 86400000L;
         c[var0 + 1] = var1;
         var3 += b[var0] * 86400000L;
         d[var0 + 1] = var3;
         var0++;
      }
   }

   BasicGJChronology(Chronology var1, Object var2, int var3) {
      super(var1, var2, var3);
   }

   @Override
   int a(long var1, int var3) {
      byte var4 = 1;
      int var5 = (int)(var1 - this.d(var3) >> 10);
      byte var6;
      if (this.e(var3)) {
         if (var5 < 15356250) {
            if (var5 < 7678125) {
               if (var5 < 2615625) {
                  var6 = var4;
               } else if (var5 < 5062500) {
                  var6 = 2;
               } else {
                  var6 = 3;
               }
            } else if (var5 < 10209375) {
               var6 = 4;
            } else if (var5 < 12825000) {
               var6 = 5;
            } else {
               var6 = 6;
            }
         } else if (var5 < 23118750) {
            if (var5 < 17971875) {
               var6 = 7;
            } else if (var5 < 20587500) {
               var6 = 8;
            } else {
               var6 = 9;
            }
         } else if (var5 < 25734375) {
            var6 = 10;
         } else if (var5 < 28265625) {
            var6 = 11;
         } else {
            var6 = 12;
         }
      } else if (var5 < 15271875) {
         if (var5 < 7593750) {
            var6 = var4;
            if (var5 >= 2615625) {
               if (var5 < 4978125) {
                  var6 = 2;
               } else {
                  var6 = 3;
               }
            }
         } else if (var5 < 10125000) {
            var6 = 4;
         } else if (var5 < 12740625) {
            var6 = 5;
         } else {
            var6 = 6;
         }
      } else if (var5 < 23034375) {
         if (var5 < 17887500) {
            var6 = 7;
         } else if (var5 < 20503125) {
            var6 = 8;
         } else {
            var6 = 9;
         }
      } else if (var5 < 25650000) {
         var6 = 10;
      } else if (var5 < 28181250) {
         var6 = 11;
      } else {
         var6 = 12;
      }

      return var6;
   }

   @Override
   int b(int var1, int var2) {
      if (this.e(var1)) {
         var1 = b[var2 - 1];
      } else {
         var1 = a[var2 - 1];
      }

      return var1;
   }

   @Override
   long c(int var1, int var2) {
      long var3;
      if (this.e(var1)) {
         var3 = d[var2 - 1];
      } else {
         var3 = c[var2 - 1];
      }

      return var3;
   }

   @Override
   int e(long var1, int var3) {
      int var4 = 28;
      if (var3 > 28 || var3 < 1) {
         var4 = this.i(var1);
      }

      return var4;
   }

   @Override
   long f(long var1, int var3) {
      int var7 = this.a(var1);
      int var5 = this.c(var1, var7);
      int var6 = this.h(var1);
      int var4 = var5;
      if (var5 > 59) {
         if (this.e(var7)) {
            var4 = var5;
            if (!this.e(var3)) {
               var4 = var5 - 1;
            }
         } else {
            var4 = var5;
            if (this.e(var3)) {
               var4 = var5 + 1;
            }
         }
      }

      return this.a(var3, 1, var4) + var6;
   }

   @Override
   boolean j(long var1) {
      boolean var3;
      if (this.u().a(var1) == 29 && this.C().b(var1)) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }
}
