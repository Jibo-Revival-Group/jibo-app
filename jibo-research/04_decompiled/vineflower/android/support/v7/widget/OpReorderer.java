package android.support.v7.widget;

import java.util.List;

class OpReorderer {
   final OpReorderer.Callback a;

   OpReorderer(OpReorderer.Callback var1) {
      this.a = var1;
   }

   private void a(List<AdapterHelper.UpdateOp> var1, int var2, int var3) {
      AdapterHelper.UpdateOp var4 = (AdapterHelper.UpdateOp)var1.get(var2);
      AdapterHelper.UpdateOp var5 = (AdapterHelper.UpdateOp)var1.get(var3);
      switch (var5.a) {
         case 1:
            this.c(var1, var2, var4, var3, var5);
            break;
         case 2:
            this.a(var1, var2, var4, var3, var5);
         case 3:
         default:
            break;
         case 4:
            this.b(var1, var2, var4, var3, var5);
      }
   }

   private int b(List<AdapterHelper.UpdateOp> var1) {
      boolean var3 = false;
      int var2 = var1.size() - 1;

      while (true) {
         if (var2 < 0) {
            var2 = -1;
            break;
         }

         if (((AdapterHelper.UpdateOp)var1.get(var2)).a == 8) {
            if (var3) {
               break;
            }
         } else {
            var3 = true;
         }

         var2--;
      }

      return var2;
   }

   private void c(List<AdapterHelper.UpdateOp> var1, int var2, AdapterHelper.UpdateOp var3, int var4, AdapterHelper.UpdateOp var5) {
      byte var6 = 0;
      if (var3.d < var5.b) {
         var6 = -1;
      }

      int var7 = var6;
      if (var3.b < var5.b) {
         var7 = var6 + 1;
      }

      if (var5.b <= var3.b) {
         var3.b = var3.b + var5.d;
      }

      if (var5.b <= var3.d) {
         var3.d = var3.d + var5.d;
      }

      var5.b += var7;
      var1.set(var2, var5);
      var1.set(var4, var3);
   }

   void a(List<AdapterHelper.UpdateOp> var1) {
      while (true) {
         int var2 = this.b(var1);
         if (var2 == -1) {
            return;
         }

         this.a(var1, var2, var2 + 1);
      }
   }

   void a(List<AdapterHelper.UpdateOp> var1, int var2, AdapterHelper.UpdateOp var3, int var4, AdapterHelper.UpdateOp var5) {
      boolean var7 = false;
      boolean var6;
      if (var3.b < var3.d) {
         if (var5.b == var3.b && var5.d == var3.d - var3.b) {
            var6 = true;
         } else {
            var6 = false;
         }
      } else if (var5.b == var3.d + 1 && var5.d == var3.b - var3.d) {
         var7 = true;
         var6 = true;
      } else {
         var6 = false;
         var7 = true;
      }

      if (var3.d < var5.b) {
         var5.b--;
      } else if (var3.d < var5.b + var5.d) {
         var5.d--;
         var3.a = 2;
         var3.d = 1;
         if (var5.d == 0) {
            var1.remove(var4);
            this.a.a(var5);
         }

         return;
      }

      AdapterHelper.UpdateOp var11;
      if (var3.b <= var5.b) {
         var5.b++;
         var11 = null;
      } else if (var3.b < var5.b + var5.d) {
         int var9 = var5.b;
         int var10 = var5.d;
         int var8 = var3.b;
         var11 = this.a.a(2, var3.b + 1, var9 + var10 - var8, null);
         var5.d = var3.b - var5.b;
      } else {
         var11 = null;
      }

      if (var6) {
         var1.set(var2, var5);
         var1.remove(var4);
         this.a.a(var3);
      } else {
         if (var7) {
            if (var11 != null) {
               if (var3.b > var11.b) {
                  var3.b = var3.b - var11.d;
               }

               if (var3.d > var11.b) {
                  var3.d = var3.d - var11.d;
               }
            }

            if (var3.b > var5.b) {
               var3.b = var3.b - var5.d;
            }

            if (var3.d > var5.b) {
               var3.d = var3.d - var5.d;
            }
         } else {
            if (var11 != null) {
               if (var3.b >= var11.b) {
                  var3.b = var3.b - var11.d;
               }

               if (var3.d >= var11.b) {
                  var3.d = var3.d - var11.d;
               }
            }

            if (var3.b >= var5.b) {
               var3.b = var3.b - var5.d;
            }

            if (var3.d >= var5.b) {
               var3.d = var3.d - var5.d;
            }
         }

         var1.set(var2, var5);
         if (var3.b != var3.d) {
            var1.set(var4, var3);
         } else {
            var1.remove(var4);
         }

         if (var11 != null) {
            var1.add(var2, var11);
         }
      }
   }

   void b(List<AdapterHelper.UpdateOp> var1, int var2, AdapterHelper.UpdateOp var3, int var4, AdapterHelper.UpdateOp var5) {
      AdapterHelper.UpdateOp var8 = null;
      AdapterHelper.UpdateOp var7;
      if (var3.d < var5.b) {
         var5.b--;
         var7 = null;
      } else if (var3.d < var5.b + var5.d) {
         var5.d--;
         var7 = this.a.a(4, var3.b, 1, var5.c);
      } else {
         var7 = null;
      }

      if (var3.b <= var5.b) {
         var5.b++;
      } else if (var3.b < var5.b + var5.d) {
         int var6 = var5.b + var5.d - var3.b;
         var8 = this.a.a(4, var3.b + 1, var6, var5.c);
         var5.d -= var6;
      }

      var1.set(var4, var3);
      if (var5.d > 0) {
         var1.set(var2, var5);
      } else {
         var1.remove(var2);
         this.a.a(var5);
      }

      if (var7 != null) {
         var1.add(var2, var7);
      }

      if (var8 != null) {
         var1.add(var2, var8);
      }
   }

   interface Callback {
      AdapterHelper.UpdateOp a(int var1, int var2, int var3, Object var4);

      void a(AdapterHelper.UpdateOp var1);
   }
}
