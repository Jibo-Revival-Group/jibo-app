package android.support.constraint.solver;

public class ArrayRow {
   SolverVariable a = null;
   float b = 0.0F;
   boolean c = false;
   final ArrayLinkedVariables d;
   boolean e = false;

   public ArrayRow(Cache var1) {
      this.d = new ArrayLinkedVariables(this, var1);
   }

   public ArrayRow a(
      float var1,
      float var2,
      float var3,
      SolverVariable var4,
      int var5,
      SolverVariable var6,
      int var7,
      SolverVariable var8,
      int var9,
      SolverVariable var10,
      int var11
   ) {
      if (var2 != 0.0F && var1 != var3) {
         var1 = var1 / var2 / (var3 / var2);
         this.b = -var5 - var7 + var9 * var1 + var11 * var1;
         this.d.a(var4, 1.0F);
         this.d.a(var6, -1.0F);
         this.d.a(var10, var1);
         this.d.a(var8, -var1);
      } else {
         this.b = -var5 - var7 + var9 + var11;
         this.d.a(var4, 1.0F);
         this.d.a(var6, -1.0F);
         this.d.a(var10, 1.0F);
         this.d.a(var8, -1.0F);
      }

      return this;
   }

   ArrayRow a(SolverVariable var1, int var2) {
      this.a = var1;
      var1.d = var2;
      this.b = var2;
      this.e = true;
      return this;
   }

   public ArrayRow a(SolverVariable var1, SolverVariable var2) {
      this.d.a(var1, 1.0F);
      this.d.a(var2, -1.0F);
      return this;
   }

   public ArrayRow a(SolverVariable var1, SolverVariable var2, int var3) {
      boolean var4 = false;
      int var5 = 0;
      if (var3 != 0) {
         var4 = (boolean)var5;
         var5 = var3;
         if (var3 < 0) {
            var5 = var3 * -1;
            var4 = true;
         }

         this.b = var5;
      }

      if (!var4) {
         this.d.a(var1, -1.0F);
         this.d.a(var2, 1.0F);
      } else {
         this.d.a(var1, 1.0F);
         this.d.a(var2, -1.0F);
      }

      return this;
   }

   ArrayRow a(SolverVariable var1, SolverVariable var2, int var3, float var4, SolverVariable var5, SolverVariable var6, int var7) {
      if (var2 == var5) {
         this.d.a(var1, 1.0F);
         this.d.a(var6, 1.0F);
         this.d.a(var2, -2.0F);
      } else if (var4 == 0.5F) {
         this.d.a(var1, 1.0F);
         this.d.a(var2, -1.0F);
         this.d.a(var5, -1.0F);
         this.d.a(var6, 1.0F);
         if (var3 > 0 || var7 > 0) {
            this.b = -var3 + var7;
         }
      } else if (var4 <= 0.0F) {
         this.d.a(var1, -1.0F);
         this.d.a(var2, 1.0F);
         this.b = var3;
      } else if (var4 >= 1.0F) {
         this.d.a(var5, -1.0F);
         this.d.a(var6, 1.0F);
         this.b = var7;
      } else {
         this.d.a(var1, (1.0F - var4) * 1.0F);
         this.d.a(var2, (1.0F - var4) * -1.0F);
         this.d.a(var5, -1.0F * var4);
         this.d.a(var6, 1.0F * var4);
         if (var3 > 0 || var7 > 0) {
            this.b = -var3 * (1.0F - var4) + var7 * var4;
         }
      }

      return this;
   }

   ArrayRow a(SolverVariable var1, SolverVariable var2, SolverVariable var3, float var4) {
      this.d.a(var1, -1.0F);
      this.d.a(var2, 1.0F - var4);
      this.d.a(var3, var4);
      return this;
   }

   public ArrayRow a(SolverVariable var1, SolverVariable var2, SolverVariable var3, int var4) {
      boolean var5 = false;
      int var6 = 0;
      if (var4 != 0) {
         var5 = (boolean)var6;
         var6 = var4;
         if (var4 < 0) {
            var6 = var4 * -1;
            var5 = true;
         }

         this.b = var6;
      }

      if (!var5) {
         this.d.a(var1, -1.0F);
         this.d.a(var2, 1.0F);
         this.d.a(var3, 1.0F);
      } else {
         this.d.a(var1, 1.0F);
         this.d.a(var2, -1.0F);
         this.d.a(var3, -1.0F);
      }

      return this;
   }

   public ArrayRow a(SolverVariable var1, SolverVariable var2, SolverVariable var3, SolverVariable var4, float var5) {
      this.d.a(var1, -1.0F);
      this.d.a(var2, 1.0F);
      this.d.a(var3, var5);
      this.d.a(var4, -var5);
      return this;
   }

   void a() {
      this.d.a(this);
   }

   boolean a(ArrayRow var1) {
      this.d.a(this, var1);
      return true;
   }

   boolean a(SolverVariable var1) {
      return this.d.b(var1);
   }

   public ArrayRow b(SolverVariable var1, int var2) {
      if (var2 < 0) {
         this.b = var2 * -1;
         this.d.a(var1, 1.0F);
      } else {
         this.b = var2;
         this.d.a(var1, -1.0F);
      }

      return this;
   }

   public ArrayRow b(SolverVariable var1, SolverVariable var2, SolverVariable var3, int var4) {
      boolean var5 = false;
      int var6 = 0;
      if (var4 != 0) {
         var5 = (boolean)var6;
         var6 = var4;
         if (var4 < 0) {
            var6 = var4 * -1;
            var5 = true;
         }

         this.b = var6;
      }

      if (!var5) {
         this.d.a(var1, -1.0F);
         this.d.a(var2, 1.0F);
         this.d.a(var3, -1.0F);
      } else {
         this.d.a(var1, 1.0F);
         this.d.a(var2, -1.0F);
         this.d.a(var3, 1.0F);
      }

      return this;
   }

   void b(SolverVariable var1) {
      if (this.a != null) {
         this.d.a(this.a, -1.0F);
         this.a = null;
      }

      float var2 = this.d.a(var1) * -1.0F;
      this.a = var1;
      if (var2 != 1.0F) {
         this.b /= var2;
         this.d.a(var2);
      }
   }

   boolean b() {
      boolean var1;
      if (this.a == null || this.a.f != SolverVariable.Type.UNRESTRICTED && this.b < 0.0F) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   ArrayRow c(SolverVariable var1, int var2) {
      this.d.a(var1, var2);
      return this;
   }

   String c() {
      String var5;
      if (this.a == null) {
         var5 = "" + "0";
      } else {
         var5 = "" + this.a;
      }

      var5 = var5 + " = ";
      boolean var2;
      if (this.b != 0.0F) {
         var5 = var5 + this.b;
         var2 = true;
      } else {
         var2 = false;
      }

      int var4 = this.d.a;

      for (int var3 = 0; var3 < var4; var3++) {
         SolverVariable var6 = this.d.a(var3);
         if (var6 != null) {
            float var1 = this.d.b(var3);
            String var8 = var6.toString();
            if (!var2) {
               if (var1 < 0.0F) {
                  var5 = var5 + "- ";
                  var1 *= -1.0F;
               }
            } else if (var1 > 0.0F) {
               var5 = var5 + " + ";
            } else {
               var5 = var5 + " - ";
               var1 *= -1.0F;
            }

            if (var1 == 1.0F) {
               var5 = var5 + var8;
            } else {
               var5 = var5 + var1 + " " + var8;
            }

            var2 = true;
         }
      }

      String var9 = var5;
      if (!var2) {
         var9 = var5 + "0.0";
      }

      return var9;
   }

   public void d() {
      this.a = null;
      this.d.a();
      this.b = 0.0F;
      this.e = false;
   }

   void e() {
      if (this.b < 0.0F) {
         this.b *= -1.0F;
         this.d.b();
      }
   }

   void f() {
      SolverVariable var1 = this.d.c();
      if (var1 != null) {
         this.b(var1);
      }

      if (this.d.a == 0) {
         this.e = true;
      }
   }

   @Override
   public String toString() {
      return this.c();
   }
}
