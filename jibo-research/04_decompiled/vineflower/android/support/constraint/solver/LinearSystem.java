package android.support.constraint.solver;

import android.support.constraint.solver.widgets.ConstraintAnchor;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem {
   private static int d = 1000;
   int a = 0;
   int b;
   final Cache c;
   private HashMap<String, SolverVariable> e = null;
   private Goal f = new Goal();
   private int g = 32;
   private int h = this.g;
   private ArrayRow[] i = null;
   private boolean[] j = new boolean[this.g];
   private int k;
   private int l;
   private SolverVariable[] m;
   private int n;
   private ArrayRow[] o;

   public LinearSystem() {
      this.b = 1;
      this.k = 0;
      this.l = this.g;
      this.m = new SolverVariable[d];
      this.n = 0;
      this.o = new ArrayRow[this.g];
      this.i = new ArrayRow[this.g];
      this.h();
      this.c = new Cache();
   }

   public static ArrayRow a(
      LinearSystem var0, SolverVariable var1, SolverVariable var2, int var3, float var4, SolverVariable var5, SolverVariable var6, int var7, boolean var8
   ) {
      ArrayRow var9 = var0.b();
      var9.a(var1, var2, var3, var4, var5, var6, var7);
      if (var8) {
         var1 = var0.d();
         SolverVariable var10 = var0.d();
         var1.c = 4;
         var10.c = 4;
         var9.a(var1, var10);
      }

      return var9;
   }

   public static ArrayRow a(LinearSystem var0, SolverVariable var1, SolverVariable var2, int var3, boolean var4) {
      ArrayRow var5 = var0.b();
      var5.a(var1, var2, var3);
      if (var4) {
         var0.a(var5, 1);
      }

      return var5;
   }

   public static ArrayRow a(LinearSystem var0, SolverVariable var1, SolverVariable var2, SolverVariable var3, float var4, boolean var5) {
      ArrayRow var6 = var0.b();
      if (var5) {
         var0.b(var6);
      }

      return var6.a(var1, var2, var3, var4);
   }

   private SolverVariable a(SolverVariable.Type var1) {
      SolverVariable var3 = this.c.b.a();
      SolverVariable var4;
      if (var3 == null) {
         var4 = new SolverVariable(var1);
      } else {
         var3.c();
         var3.a(var1);
         var4 = var3;
      }

      if (this.n >= d) {
         d *= 2;
         this.m = Arrays.copyOf(this.m, d);
      }

      SolverVariable[] var5 = this.m;
      int var2 = this.n++;
      var5[var2] = var4;
      return var4;
   }

   private void a(ArrayRow var1, int var2) {
      var1.c(this.d(), var2);
   }

   private int b(Goal var1) {
      for (int var5 = 0; var5 < this.b; var5++) {
         this.j[var5] = false;
      }

      int var15 = 0;
      int var8 = 0;

      for (boolean var6 = false; !var6; var8++) {
         SolverVariable var11;
         label51: {
            var11 = var1.a();
            int var7 = var15;
            if (var11 != null) {
               if (this.j[var11.a]) {
                  var11 = null;
                  break label51;
               }

               this.j[var11.a] = true;
               var7 = ++var15;
               if (var15 >= this.b) {
                  var6 = true;
                  break label51;
               }
            }

            var15 = var7;
         }

         if (var11 == null) {
            var6 = true;
         } else {
            int var9 = -1;
            float var2 = Float.MAX_VALUE;
            int var16 = 0;

            while (var16 < this.k) {
               ArrayRow var12 = this.i[var16];
               float var3;
               int var10;
               if (var12.a.f == SolverVariable.Type.UNRESTRICTED) {
                  var3 = var2;
                  var10 = var9;
               } else {
                  var10 = var9;
                  var3 = var2;
                  if (var12.a(var11)) {
                     float var4 = var12.d.c(var11);
                     var10 = var9;
                     var3 = var2;
                     if (var4 < 0.0F) {
                        var4 = -var12.b / var4;
                        var10 = var9;
                        var3 = var2;
                        if (var4 < var2) {
                           var10 = var16;
                           var3 = var4;
                        }
                     }
                  }
               }

               var16++;
               var9 = var10;
               var2 = var3;
            }

            if (var9 <= -1) {
               var6 = true;
            } else {
               ArrayRow var18 = this.i[var9];
               var18.a.b = -1;
               var18.b(var11);
               var18.a.b = var9;

               for (int var17 = 0; var17 < this.k; var17++) {
                  this.i[var17].a(var18);
               }

               var1.a(this);

               try {
                  this.c(var1);
               } catch (Exception var13) {
                  var13.printStackTrace();
               }
            }
         }
      }

      return var8;
   }

   public static ArrayRow b(LinearSystem var0, SolverVariable var1, SolverVariable var2, int var3, boolean var4) {
      SolverVariable var5 = var0.c();
      ArrayRow var6 = var0.b();
      var6.a(var1, var2, var5, var3);
      if (var4) {
         var0.a(var6, (int)(var6.d.c(var5) * -1.0F));
      }

      return var6;
   }

   private void b(ArrayRow var1) {
      var1.a(this.d(), this.d());
   }

   private int c(Goal var1) throws Exception {
      int var5 = 0;

      while (true) {
         if (var5 >= this.k) {
            var17 = false;
            break;
         }

         if (this.i[var5].a.f != SolverVariable.Type.UNRESTRICTED && this.i[var5].b < 0.0F) {
            var17 = true;
            break;
         }

         var5++;
      }

      if (var17) {
         boolean var9 = false;
         int var8 = 0;

         while (true) {
            var5 = var8;
            if (var9) {
               break;
            }

            float var2 = Float.MAX_VALUE;
            var5 = 0;
            int var7 = -1;
            int var6 = -1;
            int var10 = 0;

            while (var10 < this.k) {
               ArrayRow var15 = this.i[var10];
               float var3;
               int var11;
               int var12;
               int var13;
               if (var15.a.f == SolverVariable.Type.UNRESTRICTED) {
                  var3 = var2;
                  var13 = var5;
                  var12 = var7;
                  var11 = var6;
               } else {
                  var11 = var6;
                  var12 = var7;
                  var13 = var5;
                  var3 = var2;
                  if (var15.b < 0.0F) {
                     for (int var23 = 1; var23 < this.b; var23++) {
                        SolverVariable var14 = this.c.c[var23];
                        float var4 = var15.d.c(var14);
                        if (!(var4 <= 0.0F)) {
                           for (int var24 = 0; var24 < 6; var24++) {
                              var3 = var14.e[var24] / var4;
                              if (var3 < var2 && var24 == var5 || var24 > var5) {
                                 var6 = var23;
                                 var7 = var10;
                                 var5 = var24;
                                 var2 = var3;
                              }
                           }
                        }
                     }

                     var11 = var6;
                     var12 = var7;
                     var13 = var5;
                     var3 = var2;
                  }
               }

               var10++;
               var6 = var11;
               var7 = var12;
               var5 = var13;
               var2 = var3;
            }

            boolean var21;
            if (var7 == -1) {
               var21 = true;
            } else {
               ArrayRow var25 = this.i[var7];
               var25.a.b = -1;
               var25.b(this.c.c[var6]);
               var25.a.b = var7;

               for (int var20 = 0; var20 < this.k; var20++) {
                  this.i[var20].a(var25);
               }

               var1.a(this);
               var21 = var9;
            }

            var8++;
            var9 = var21;
         }
      } else {
         var5 = 0;
      }

      int var22 = 0;

      while (var22 < this.k && (this.i[var22].a.f == SolverVariable.Type.UNRESTRICTED || !(this.i[var22].b < 0.0F))) {
         var22++;
      }

      return var5;
   }

   public static ArrayRow c(LinearSystem var0, SolverVariable var1, SolverVariable var2, int var3, boolean var4) {
      SolverVariable var5 = var0.c();
      ArrayRow var6 = var0.b();
      var6.b(var1, var2, var5, var3);
      if (var4) {
         var0.a(var6, (int)(var6.d.c(var5) * -1.0F));
      }

      return var6;
   }

   private void c(ArrayRow var1) {
      if (this.k > 0) {
         var1.d.a(var1, this.i);
         if (var1.d.a == 0) {
            var1.e = true;
         }
      }
   }

   private void g() {
      this.g *= 2;
      this.i = Arrays.copyOf(this.i, this.g);
      this.c.c = Arrays.copyOf(this.c.c, this.g);
      this.j = new boolean[this.g];
      this.h = this.g;
      this.l = this.g;
      this.f.a.clear();
   }

   private void h() {
      for (int var1 = 0; var1 < this.i.length; var1++) {
         ArrayRow var2 = this.i[var1];
         if (var2 != null) {
            this.c.a.a(var2);
         }

         this.i[var1] = null;
      }
   }

   private void i() {
      for (int var1 = 0; var1 < this.k; var1++) {
         ArrayRow var2 = this.i[var1];
         var2.a.d = var2.b;
      }
   }

   ArrayRow a(int var1) {
      return this.i[var1];
   }

   public SolverVariable a(Object var1) {
      SolverVariable var3 = null;
      if (var1 != null) {
         if (this.b + 1 >= this.h) {
            this.g();
         }

         if (var1 instanceof ConstraintAnchor) {
            var3 = ((ConstraintAnchor)var1).a();
            SolverVariable var2 = var3;
            if (var3 == null) {
               ((ConstraintAnchor)var1).a(this.c);
               var2 = ((ConstraintAnchor)var1).a();
            }

            if (var2.a != -1 && var2.a <= this.a) {
               var3 = var2;
               if (this.c.c[var2.a] != null) {
                  return var3;
               }
            }

            if (var2.a != -1) {
               var2.c();
            }

            this.a++;
            this.b++;
            var2.a = this.a;
            var2.f = SolverVariable.Type.UNRESTRICTED;
            this.c.c[this.a] = var2;
            var3 = var2;
         }
      }

      return var3;
   }

   public void a() {
      for (int var1 = 0; var1 < this.c.c.length; var1++) {
         SolverVariable var2 = this.c.c[var1];
         if (var2 != null) {
            var2.c();
         }
      }

      this.c.b.a(this.m, this.n);
      this.n = 0;
      Arrays.fill(this.c.c, null);
      if (this.e != null) {
         this.e.clear();
      }

      this.a = 0;
      this.f.a.clear();
      this.b = 1;

      for (int var3 = 0; var3 < this.k; var3++) {
         this.i[var3].c = false;
      }

      this.h();
      this.k = 0;
   }

   public void a(ArrayRow var1) {
      byte var4 = 0;
      if (var1 != null) {
         if (this.k + 1 >= this.l || this.b + 1 >= this.h) {
            this.g();
         }

         if (!var1.e) {
            this.c(var1);
            var1.e();
            var1.f();
            if (!var1.b()) {
               return;
            }
         }

         if (this.i[this.k] != null) {
            this.c.a.a(this.i[this.k]);
         }

         if (!var1.e) {
            var1.a();
         }

         this.i[this.k] = var1;
         var1.a.b = this.k++;
         int var5 = var1.a.h;
         if (var5 > 0) {
            while (this.o.length < var5) {
               this.o = new ArrayRow[this.o.length * 2];
            }

            ArrayRow[] var6 = this.o;
            int var2 = 0;

            while (true) {
               int var3 = var4;
               if (var2 >= var5) {
                  for (; var3 < var5; var3++) {
                     ArrayRow var7 = var6[var3];
                     if (var7 != var1) {
                        var7.d.a(var7, var1);
                        var7.a();
                     }
                  }
                  break;
               }

               var6[var2] = var1.a.g[var2];
               var2++;
            }
         }
      }
   }

   void a(Goal var1) throws Exception {
      var1.a(this);
      this.c(var1);
      this.b(var1);
      this.i();
   }

   public void a(SolverVariable var1, int var2) {
      int var3 = var1.b;
      if (var1.b != -1) {
         ArrayRow var4 = this.i[var3];
         if (var4.e) {
            var4.b = var2;
         } else {
            var4 = this.b();
            var4.b(var1, var2);
            this.a(var4);
         }
      } else {
         ArrayRow var6 = this.b();
         var6.a(var1, var2);
         this.a(var6);
      }
   }

   public void a(SolverVariable var1, SolverVariable var2, int var3, float var4, SolverVariable var5, SolverVariable var6, int var7, int var8) {
      ArrayRow var9 = this.b();
      var9.a(var1, var2, var3, var4, var5, var6, var7);
      var1 = this.d();
      var2 = this.d();
      var1.c = var8;
      var2.c = var8;
      var9.a(var1, var2);
      this.a(var9);
   }

   public void a(SolverVariable var1, SolverVariable var2, int var3, int var4) {
      ArrayRow var5 = this.b();
      SolverVariable var6 = this.c();
      var6.c = var4;
      var5.a(var1, var2, var6, var3);
      this.a(var5);
   }

   public int b(Object var1) {
      SolverVariable var3 = ((ConstraintAnchor)var1).a();
      int var2;
      if (var3 != null) {
         var2 = (int)(var3.d + 0.5F);
      } else {
         var2 = 0;
      }

      return var2;
   }

   public ArrayRow b() {
      ArrayRow var1 = this.c.a.a();
      if (var1 == null) {
         var1 = new ArrayRow(this.c);
      } else {
         var1.d();
      }

      return var1;
   }

   public void b(SolverVariable var1, SolverVariable var2, int var3, int var4) {
      ArrayRow var5 = this.b();
      SolverVariable var6 = this.c();
      var6.c = var4;
      var5.b(var1, var2, var6, var3);
      this.a(var5);
   }

   public ArrayRow c(SolverVariable var1, SolverVariable var2, int var3, int var4) {
      ArrayRow var5 = this.b();
      var5.a(var1, var2, var3);
      var2 = this.d();
      var1 = this.d();
      var2.c = var4;
      var1.c = var4;
      var5.a(var2, var1);
      this.a(var5);
      return var5;
   }

   public SolverVariable c() {
      if (this.b + 1 >= this.h) {
         this.g();
      }

      SolverVariable var1 = this.a(SolverVariable.Type.SLACK);
      this.a++;
      this.b++;
      var1.a = this.a;
      this.c.c[this.a] = var1;
      return var1;
   }

   public SolverVariable d() {
      if (this.b + 1 >= this.h) {
         this.g();
      }

      SolverVariable var1 = this.a(SolverVariable.Type.ERROR);
      this.a++;
      this.b++;
      var1.a = this.a;
      this.c.c[this.a] = var1;
      return var1;
   }

   public void e() throws Exception {
      this.a(this.f);
   }

   public Cache f() {
      return this.c;
   }
}
