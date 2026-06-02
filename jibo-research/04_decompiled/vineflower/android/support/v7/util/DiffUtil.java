package android.support.v7.util;

import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DiffUtil {
   private static final Comparator<DiffUtil.Snake> a = new Comparator<DiffUtil.Snake>() {
      public int a(DiffUtil.Snake var1, DiffUtil.Snake var2) {
         int var4 = var1.a - var2.a;
         int var3 = var4;
         if (var4 == 0) {
            var3 = var1.b - var2.b;
         }

         return var3;
      }
   };

   public static DiffUtil.DiffResult a(DiffUtil.Callback var0) {
      return a(var0, true);
   }

   public static DiffUtil.DiffResult a(DiffUtil.Callback var0, boolean var1) {
      int var2 = var0.a();
      int var3 = var0.b();
      ArrayList var11 = new ArrayList();
      ArrayList var10 = new ArrayList();
      var10.add(new DiffUtil.Range(0, var2, 0, var3));
      var2 = var2 + var3 + Math.abs(var2 - var3);
      int[] var6 = new int[var2 * 2];
      int[] var9 = new int[var2 * 2];
      ArrayList var8 = new ArrayList();

      while (!var10.isEmpty()) {
         DiffUtil.Range var7 = (DiffUtil.Range)var10.remove(var10.size() - 1);
         DiffUtil.Snake var5 = a(var0, var7.a, var7.b, var7.c, var7.d, var6, var9, var2);
         if (var5 != null) {
            if (var5.c > 0) {
               var11.add(var5);
            }

            var5.a = var5.a + var7.a;
            var5.b = var5.b + var7.c;
            DiffUtil.Range var4;
            if (var8.isEmpty()) {
               var4 = new DiffUtil.Range();
            } else {
               var4 = (DiffUtil.Range)var8.remove(var8.size() - 1);
            }

            var4.a = var7.a;
            var4.c = var7.c;
            if (var5.e) {
               var4.b = var5.a;
               var4.d = var5.b;
            } else if (var5.d) {
               var4.b = var5.a - 1;
               var4.d = var5.b;
            } else {
               var4.b = var5.a;
               var4.d = var5.b - 1;
            }

            var10.add(var4);
            if (var5.e) {
               if (var5.d) {
                  var7.a = var5.a + var5.c + 1;
                  var7.c = var5.b + var5.c;
               } else {
                  var7.a = var5.a + var5.c;
                  var7.c = var5.b + var5.c + 1;
               }
            } else {
               var7.a = var5.a + var5.c;
               var7.c = var5.b + var5.c;
            }

            var10.add(var7);
         } else {
            var8.add(var7);
         }
      }

      Collections.sort(var11, a);
      return new DiffUtil.DiffResult(var0, var11, var6, var9, var1);
   }

   private static DiffUtil.Snake a(DiffUtil.Callback var0, int var1, int var2, int var3, int var4, int[] var5, int[] var6, int var7) {
      int var12 = var2 - var1;
      int var11 = var4 - var3;
      if (var2 - var1 >= 1 && var4 - var3 >= 1) {
         int var14 = var12 - var11;
         int var13 = (var12 + var11 + 1) / 2;
         Arrays.fill(var5, var7 - var13 - 1, var7 + var13 + 1, 0);
         Arrays.fill(var6, var7 - var13 - 1 + var14, var7 + var13 + 1 + var14, var12);
         boolean var22;
         if (var14 % 2 != 0) {
            var22 = true;
         } else {
            var22 = false;
         }

         for (int var8 = 0; var8 <= var13; var8++) {
            for (int var9 = -var8; var9 <= var8; var9 += 2) {
               boolean var16;
               if (var9 != -var8 && (var9 == var8 || var5[var7 + var9 - 1] >= var5[var7 + var9 + 1])) {
                  var2 = var5[var7 + var9 - 1] + 1;
                  var16 = true;
               } else {
                  var2 = var5[var7 + var9 + 1];
                  var16 = false;
               }

               int var10 = var2;

               for (int var19 = var2 - var9; var10 < var12 && var19 < var11 && var0.a(var1 + var10, var3 + var19); var19++) {
                  var10++;
               }

               var5[var7 + var9] = var10;
               if (var22 && var9 >= var14 - var8 + 1 && var9 <= var14 + var8 - 1 && var5[var7 + var9] >= var6[var7 + var9]) {
                  DiffUtil.Snake var27 = new DiffUtil.Snake();
                  var27.a = var6[var7 + var9];
                  var27.b = var27.a - var9;
                  var27.c = var5[var7 + var9] - var6[var7 + var9];
                  var27.d = var16;
                  var27.e = false;
                  return var27;
               }
            }

            for (int var23 = -var8; var23 <= var8; var23 += 2) {
               int var15 = var23 + var14;
               boolean var25;
               if (var15 != var8 + var14 && (var15 == -var8 + var14 || var6[var7 + var15 - 1] >= var6[var7 + var15 + 1])) {
                  var2 = var6[var7 + var15 + 1] - 1;
                  var25 = true;
               } else {
                  var2 = var6[var7 + var15 - 1];
                  var25 = false;
               }

               int var24 = var2;

               for (int var21 = var2 - var15; var24 > 0 && var21 > 0 && var0.a(var1 + var24 - 1, var3 + var21 - 1); var21--) {
                  var24--;
               }

               var6[var7 + var15] = var24;
               if (!var22 && var23 + var14 >= -var8 && var23 + var14 <= var8 && var5[var7 + var15] >= var6[var7 + var15]) {
                  DiffUtil.Snake var26 = new DiffUtil.Snake();
                  var26.a = var6[var7 + var15];
                  var26.b = var26.a - var15;
                  var26.c = var5[var7 + var15] - var6[var7 + var15];
                  var26.d = var25;
                  var26.e = true;
                  return var26;
               }
            }
         }

         throw new IllegalStateException(
            "DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation."
         );
      } else {
         return null;
      }
   }

   public abstract static class Callback {
      public abstract int a();

      public abstract boolean a(int var1, int var2);

      public abstract int b();

      public abstract boolean b(int var1, int var2);

      public Object c(int var1, int var2) {
         return null;
      }
   }

   public static class DiffResult {
      private final List<DiffUtil.Snake> a;
      private final int[] b;
      private final int[] c;
      private final DiffUtil.Callback d;
      private final int e;
      private final int f;
      private final boolean g;

      DiffResult(DiffUtil.Callback var1, List<DiffUtil.Snake> var2, int[] var3, int[] var4, boolean var5) {
         this.a = var2;
         this.b = var3;
         this.c = var4;
         Arrays.fill(this.b, 0);
         Arrays.fill(this.c, 0);
         this.d = var1;
         this.e = var1.a();
         this.f = var1.b();
         this.g = var5;
         this.a();
         this.b();
      }

      private static DiffUtil.PostponedUpdate a(List<DiffUtil.PostponedUpdate> var0, int var1, boolean var2) {
         for (int var3 = var0.size() - 1; var3 >= 0; var3--) {
            DiffUtil.PostponedUpdate var6 = (DiffUtil.PostponedUpdate)var0.get(var3);
            if (var6.a == var1 && var6.c == var2) {
               var0.remove(var3);
               var1 = var3;

               while (true) {
                  DiffUtil.PostponedUpdate var5 = var6;
                  if (var1 >= var0.size()) {
                     return var5;
                  }

                  var5 = (DiffUtil.PostponedUpdate)var0.get(var1);
                  int var4 = var5.b;
                  byte var8;
                  if (var2) {
                     var8 = 1;
                  } else {
                     var8 = -1;
                  }

                  var5.b = var8 + var4;
                  var1++;
               }
            }
         }

         return null;
      }

      private void a() {
         DiffUtil.Snake var1;
         if (this.a.isEmpty()) {
            var1 = null;
         } else {
            var1 = this.a.get(0);
         }

         if (var1 == null || var1.a != 0 || var1.b != 0) {
            var1 = new DiffUtil.Snake();
            var1.a = 0;
            var1.b = 0;
            var1.d = false;
            var1.c = 0;
            var1.e = false;
            this.a.add(0, var1);
         }
      }

      private void a(int var1, int var2, int var3) {
         if (this.b[var1 - 1] == 0) {
            this.a(var1, var2, var3, false);
         }
      }

      private void a(List<DiffUtil.PostponedUpdate> var1, ListUpdateCallback var2, int var3, int var4, int var5) {
         if (!this.g) {
            var2.a(var3, var4);
         } else {
            var4--;

            for (; var4 >= 0; var4--) {
               int var6 = this.c[var5 + var4] & 31;
               switch (var6) {
                  case 0:
                     var2.a(var3, 1);

                     for (DiffUtil.PostponedUpdate var8 : var1) {
                        var8.b++;
                     }
                     break;
                  case 4:
                  case 8:
                     int var7 = this.c[var5 + var4] >> 5;
                     var2.c(a(var1, var7, true).b, var3);
                     if (var6 == 4) {
                        var2.a(var3, 1, this.d.c(var7, var5 + var4));
                     }
                     break;
                  case 16:
                     var1.add(new DiffUtil.PostponedUpdate(var5 + var4, var3, false));
                     break;
                  default:
                     throw new IllegalStateException("unknown flag for pos " + (var4 + var5) + " " + Long.toBinaryString(var6));
               }
            }
         }
      }

      private boolean a(int var1, int var2, int var3, boolean var4) {
         byte var7 = 8;
         int var5;
         int var6;
         if (var4) {
            int var8 = var2 - 1;
            var6 = var2 - 1;
            var5 = var1;
            var2 = var8;
         } else {
            var6 = var1 - 1;
            var5 = var1 - 1;
         }

         while (var3 >= 0) {
            DiffUtil.Snake var12 = this.a.get(var3);
            int var11 = var12.a;
            int var18 = var12.c;
            int var9 = var12.b;
            int var10 = var12.c;
            if (var4) {
               for (int var14 = var5 - 1; var14 >= var11 + var18; var14--) {
                  if (this.d.a(var14, var6)) {
                     byte var13;
                     if (this.d.b(var14, var6)) {
                        var13 = 8;
                     } else {
                        var13 = 4;
                     }

                     this.c[var6] = var14 << 5 | 16;
                     this.b[var14] = var13 | var6 << 5;
                     return true;
                  }
               }
            } else {
               var2--;

               while (var2 >= var9 + var10) {
                  if (this.d.a(var6, var2)) {
                     byte var16;
                     if (this.d.b(var6, var2)) {
                        var16 = var7;
                     } else {
                        var16 = 4;
                     }

                     this.b[var1 - 1] = var2 << 5 | 16;
                     this.c[var2] = var1 - 1 << 5 | var16;
                     return true;
                  }

                  var2--;
               }
            }

            var5 = var12.a;
            var2 = var12.b;
            var3--;
         }

         return false;
      }

      private void b() {
         int var2 = this.e;
         int var1 = this.f;

         for (int var3 = this.a.size() - 1; var3 >= 0; var3--) {
            DiffUtil.Snake var9 = this.a.get(var3);
            int var8 = var9.a;
            int var7 = var9.c;
            int var5 = var9.b;
            int var6 = var9.c;
            if (this.g) {
               while (true) {
                  int var4 = var1;
                  if (var2 <= var8 + var7) {
                     while (var4 > var5 + var6) {
                        this.b(var2, var4, var3);
                        var4--;
                     }
                     break;
                  }

                  this.a(var2, var1, var3);
                  var2--;
               }
            }

            for (int var10 = 0; var10 < var9.c; var10++) {
               int var12 = var9.a + var10;
               var5 = var9.b + var10;
               byte var11;
               if (this.d.b(var12, var5)) {
                  var11 = 1;
               } else {
                  var11 = 2;
               }

               this.b[var12] = var5 << 5 | var11;
               this.c[var5] = var11 | var12 << 5;
            }

            var2 = var9.a;
            var1 = var9.b;
         }
      }

      private void b(int var1, int var2, int var3) {
         if (this.c[var2 - 1] == 0) {
            this.a(var1, var2, var3, true);
         }
      }

      private void b(List<DiffUtil.PostponedUpdate> var1, ListUpdateCallback var2, int var3, int var4, int var5) {
         if (!this.g) {
            var2.b(var3, var4);
         } else {
            var4--;

            for (; var4 >= 0; var4--) {
               int var6 = this.b[var5 + var4] & 31;
               switch (var6) {
                  case 0:
                     var2.b(var3 + var4, 1);

                     for (DiffUtil.PostponedUpdate var9 : var1) {
                        var9.b--;
                     }
                     break;
                  case 4:
                  case 8:
                     int var7 = this.b[var5 + var4] >> 5;
                     DiffUtil.PostponedUpdate var8 = a(var1, var7, false);
                     var2.c(var3 + var4, var8.b - 1);
                     if (var6 == 4) {
                        var2.a(var8.b - 1, 1, this.d.c(var5 + var4, var7));
                     }
                     break;
                  case 16:
                     var1.add(new DiffUtil.PostponedUpdate(var5 + var4, var3 + var4, true));
                     break;
                  default:
                     throw new IllegalStateException("unknown flag for pos " + (var4 + var5) + " " + Long.toBinaryString(var6));
               }
            }
         }
      }

      public void a(ListUpdateCallback var1) {
         if (var1 instanceof BatchingListUpdateCallback) {
            var1 = var1;
         } else {
            var1 = new BatchingListUpdateCallback(var1);
         }

         ArrayList var8 = new ArrayList();
         int var3 = this.e;
         int var4 = this.f;

         for (int var2 = this.a.size() - 1; var2 >= 0; var2--) {
            DiffUtil.Snake var9 = this.a.get(var2);
            int var5 = var9.c;
            int var6 = var9.a + var5;
            int var7 = var9.b + var5;
            if (var6 < var3) {
               this.b(var8, var1, var6, var3 - var6, var6);
            }

            if (var7 < var4) {
               this.a(var8, var1, var6, var4 - var7, var7);
            }

            for (int var11 = var5 - 1; var11 >= 0; var11--) {
               if ((this.b[var9.a + var11] & 31) == 2) {
                  var1.a(var9.a + var11, 1, this.d.c(var9.a + var11, var9.b + var11));
               }
            }

            var3 = var9.a;
            var4 = var9.b;
         }

         var1.a();
      }

      public void a(RecyclerView.Adapter var1) {
         this.a(new AdapterListUpdateCallback(var1));
      }
   }

   private static class PostponedUpdate {
      int a;
      int b;
      boolean c;

      public PostponedUpdate(int var1, int var2, boolean var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }
   }

   static class Range {
      int a;
      int b;
      int c;
      int d;

      public Range() {
      }

      public Range(int var1, int var2, int var3, int var4) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
      }
   }

   static class Snake {
      int a;
      int b;
      int c;
      boolean d;
      boolean e;
   }
}
