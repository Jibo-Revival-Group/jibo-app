package android.support.constraint.solver;

import java.util.Arrays;

public class ArrayLinkedVariables {
   int a = 0;
   private final ArrayRow b;
   private final Cache c;
   private int d = 8;
   private SolverVariable e = null;
   private int[] f = new int[this.d];
   private int[] g = new int[this.d];
   private float[] h = new float[this.d];
   private int i = -1;
   private int j = -1;
   private boolean k = false;

   ArrayLinkedVariables(ArrayRow var1, Cache var2) {
      this.b = var1;
      this.c = var2;
   }

   public final float a(SolverVariable var1) {
      float var3 = 0.0F;
      if (this.e == var1) {
         this.e = null;
      }

      float var2;
      if (this.i == -1) {
         var2 = var3;
      } else {
         int var4 = this.i;
         int var5 = 0;
         int var6 = -1;

         while (true) {
            var2 = var3;
            if (var4 == -1) {
               break;
            }

            var2 = var3;
            if (var5 >= this.a) {
               break;
            }

            int var7 = this.f[var4];
            if (var7 == var1.a) {
               if (var4 == this.i) {
                  this.i = this.g[var4];
               } else {
                  this.g[var6] = this.g[var4];
               }

               this.c.c[var7].b(this.b);
               this.a--;
               this.f[var4] = -1;
               if (this.k) {
                  this.j = var4;
               }

               var2 = this.h[var4];
               break;
            }

            var7 = this.g[var4];
            var5++;
            var6 = var4;
            var4 = var7;
         }
      }

      return var2;
   }

   final SolverVariable a(int var1) {
      int var3 = this.i;
      int var2 = 0;

      SolverVariable var4;
      while (true) {
         if (var3 == -1 || var2 >= this.a) {
            var4 = null;
            break;
         }

         if (var2 == var1) {
            var4 = this.c.c[this.f[var3]];
            break;
         }

         var3 = this.g[var3];
         var2++;
      }

      return var4;
   }

   public final void a() {
      this.i = -1;
      this.j = -1;
      this.k = false;
      this.a = 0;
   }

   void a(float var1) {
      int var2 = this.i;

      for (int var3 = 0; var2 != -1 && var3 < this.a; var3++) {
         float[] var4 = this.h;
         var4[var2] /= var1;
         var2 = this.g[var2];
      }
   }

   void a(ArrayRow var1) {
      int var3 = this.i;

      for (int var2 = 0; var3 != -1 && var2 < this.a; var2++) {
         this.c.c[this.f[var3]].a(var1);
         var3 = this.g[var3];
      }
   }

   void a(ArrayRow var1, ArrayRow var2) {
      int var5 = this.i;
      int var4 = 0;

      while (var5 != -1 && var4 < this.a) {
         if (this.f[var5] != var2.a.a) {
            var5 = this.g[var5];
            var4++;
         } else {
            float var3 = this.h[var5];
            this.a(var2.a);
            ArrayLinkedVariables var6 = var2.d;
            var5 = var6.i;

            for (int var7 = 0; var5 != -1 && var7 < var6.a; var7++) {
               this.b(this.c.c[var6.f[var5]], var6.h[var5] * var3);
               var5 = var6.g[var5];
            }

            var1.b = var1.b + var2.b * var3;
            var2.a.b(var1);
            var5 = this.i;
            var4 = 0;
         }
      }
   }

   void a(ArrayRow var1, ArrayRow[] var2) {
      int var5 = this.i;
      int var4 = 0;

      while (var5 != -1 && var4 < this.a) {
         SolverVariable var6 = this.c.c[this.f[var5]];
         if (var6.b == -1) {
            var5 = this.g[var5];
            var4++;
         } else {
            float var3 = this.h[var5];
            this.a(var6);
            ArrayRow var10 = var2[var6.b];
            if (!var10.e) {
               ArrayLinkedVariables var7 = var10.d;
               var5 = var7.i;

               for (int var8 = 0; var5 != -1 && var8 < var7.a; var8++) {
                  this.b(this.c.c[var7.f[var5]], var7.h[var5] * var3);
                  var5 = var7.g[var5];
               }
            }

            var1.b = var1.b + var10.b * var3;
            var10.a.b(var1);
            var5 = this.i;
            var4 = 0;
         }
      }
   }

   public final void a(SolverVariable var1, float var2) {
      if (var2 == 0.0F) {
         this.a(var1);
      } else if (this.i == -1) {
         this.i = 0;
         this.h[this.i] = var2;
         this.f[this.i] = var1.a;
         this.g[this.i] = -1;
         this.a++;
         if (!this.k) {
            this.j++;
         }
      } else {
         int var3 = this.i;
         int var4 = 0;
         int var6 = -1;

         while (var3 != -1 && var4 < this.a) {
            if (this.f[var3] == var1.a) {
               this.h[var3] = var2;
               return;
            }

            if (this.f[var3] < var1.a) {
               var6 = var3;
            }

            var3 = this.g[var3];
            var4++;
         }

         var3 = this.j + 1;
         if (this.k) {
            if (this.f[this.j] == -1) {
               var3 = this.j;
            } else {
               var3 = this.f.length;
            }
         }

         var4 = var3;
         if (var3 >= this.f.length) {
            var4 = var3;
            if (this.a < this.f.length) {
               int var5 = 0;

               while (true) {
                  var4 = var3;
                  if (var5 >= this.f.length) {
                     break;
                  }

                  if (this.f[var5] == -1) {
                     var4 = var5;
                     break;
                  }

                  var5++;
               }
            }
         }

         var3 = var4;
         if (var4 >= this.f.length) {
            var3 = this.f.length;
            this.d *= 2;
            this.k = false;
            this.j = var3 - 1;
            this.h = Arrays.copyOf(this.h, this.d);
            this.f = Arrays.copyOf(this.f, this.d);
            this.g = Arrays.copyOf(this.g, this.d);
         }

         this.f[var3] = var1.a;
         this.h[var3] = var2;
         if (var6 != -1) {
            this.g[var3] = this.g[var6];
            this.g[var6] = var3;
         } else {
            this.g[var3] = this.i;
            this.i = var3;
         }

         this.a++;
         if (!this.k) {
            this.j++;
         }

         if (this.a >= this.f.length) {
            this.k = true;
         }
      }
   }

   final float b(int var1) {
      int var4 = this.i;
      int var3 = 0;

      float var2;
      while (true) {
         if (var4 == -1 || var3 >= this.a) {
            var2 = 0.0F;
            break;
         }

         if (var3 == var1) {
            var2 = this.h[var4];
            break;
         }

         var4 = this.g[var4];
         var3++;
      }

      return var2;
   }

   void b() {
      int var1 = this.i;

      for (int var2 = 0; var1 != -1 && var2 < this.a; var2++) {
         float[] var3 = this.h;
         var3[var1] *= -1.0F;
         var1 = this.g[var1];
      }
   }

   public final void b(SolverVariable var1, float var2) {
      if (var2 != 0.0F) {
         if (this.i == -1) {
            this.i = 0;
            this.h[this.i] = var2;
            this.f[this.i] = var1.a;
            this.g[this.i] = -1;
            this.a++;
            if (!this.k) {
               this.j++;
            }
         } else {
            int var3 = this.i;
            int var4 = 0;
            int var6 = -1;

            while (var3 != -1 && var4 < this.a) {
               int var5 = this.f[var3];
               if (var5 == var1.a) {
                  float[] var7 = this.h;
                  var7[var3] += var2;
                  if (this.h[var3] == 0.0F) {
                     if (var3 == this.i) {
                        this.i = this.g[var3];
                     } else {
                        this.g[var6] = this.g[var3];
                     }

                     this.c.c[var5].b(this.b);
                     if (this.k) {
                        this.j = var3;
                     }

                     this.a--;
                  }

                  return;
               }

               if (this.f[var3] < var1.a) {
                  var6 = var3;
               }

               var3 = this.g[var3];
               var4++;
            }

            var3 = this.j + 1;
            if (this.k) {
               if (this.f[this.j] == -1) {
                  var3 = this.j;
               } else {
                  var3 = this.f.length;
               }
            }

            var4 = var3;
            if (var3 >= this.f.length) {
               var4 = var3;
               if (this.a < this.f.length) {
                  int var11 = 0;

                  while (true) {
                     var4 = var3;
                     if (var11 >= this.f.length) {
                        break;
                     }

                     if (this.f[var11] == -1) {
                        var4 = var11;
                        break;
                     }

                     var11++;
                  }
               }
            }

            var3 = var4;
            if (var4 >= this.f.length) {
               var3 = this.f.length;
               this.d *= 2;
               this.k = false;
               this.j = var3 - 1;
               this.h = Arrays.copyOf(this.h, this.d);
               this.f = Arrays.copyOf(this.f, this.d);
               this.g = Arrays.copyOf(this.g, this.d);
            }

            this.f[var3] = var1.a;
            this.h[var3] = var2;
            if (var6 != -1) {
               this.g[var3] = this.g[var6];
               this.g[var6] = var3;
            } else {
               this.g[var3] = this.i;
               this.i = var3;
            }

            this.a++;
            if (!this.k) {
               this.j++;
            }

            if (this.j >= this.f.length) {
               this.k = true;
               this.j = this.f.length - 1;
            }
         }
      }
   }

   final boolean b(SolverVariable var1) {
      boolean var5 = false;
      boolean var4;
      if (this.i == -1) {
         var4 = var5;
      } else {
         int var3 = this.i;
         int var2 = 0;

         while (true) {
            var4 = var5;
            if (var3 == -1) {
               break;
            }

            var4 = var5;
            if (var2 >= this.a) {
               break;
            }

            if (this.f[var3] == var1.a) {
               var4 = true;
               break;
            }

            var3 = this.g[var3];
            var2++;
         }
      }

      return var4;
   }

   public final float c(SolverVariable var1) {
      int var4 = this.i;
      int var3 = 0;

      float var2;
      while (true) {
         if (var4 == -1 || var3 >= this.a) {
            var2 = 0.0F;
            break;
         }

         if (this.f[var4] == var1.a) {
            var2 = this.h[var4];
            break;
         }

         var4 = this.g[var4];
         var3++;
      }

      return var2;
   }

   SolverVariable c() {
      SolverVariable var5 = null;
      int var3 = this.i;
      int var2 = 0;
      SolverVariable var4 = null;

      SolverVariable var6;
      while (true) {
         if (var3 == -1 || var2 >= this.a) {
            if (var4 != null) {
               var6 = var4;
            } else {
               var6 = var5;
            }
            break;
         }

         float var1 = this.h[var3];
         if (var1 < 0.0F) {
            if (var1 > -0.001F) {
               this.h[var3] = 0.0F;
               var1 = 0.0F;
            }
         } else if (var1 < 0.001F) {
            this.h[var3] = 0.0F;
            var1 = 0.0F;
         }

         if (var1 != 0.0F) {
            var6 = this.c.c[this.f[var3]];
            if (var6.f == SolverVariable.Type.UNRESTRICTED) {
               if (var1 < 0.0F) {
                  break;
               }

               if (var4 == null) {
                  var4 = var6;
               }
            } else if (var1 < 0.0F && (var5 == null || var6.c < var5.c)) {
               var5 = var6;
            }
         }

         var3 = this.g[var3];
         var2++;
      }

      return var6;
   }

   @Override
   public String toString() {
      String var3 = "";
      int var1 = this.i;

      for (int var2 = 0; var1 != -1 && var2 < this.a; var2++) {
         var3 = var3 + " -> ";
         Object var5 = var3 + this.h[var1] + " : ";
         var3 = var5 + this.c.c[this.f[var1]];
         var1 = this.g[var1];
      }

      return var3;
   }
}
