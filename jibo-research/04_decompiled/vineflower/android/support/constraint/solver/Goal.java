package android.support.constraint.solver;

import java.util.ArrayList;

public class Goal {
   ArrayList<SolverVariable> a = new ArrayList<>();

   private void b(LinearSystem var1) {
      this.a.clear();

      for (int var2 = 1; var2 < var1.b; var2++) {
         SolverVariable var4 = var1.c.c[var2];

         for (int var3 = 0; var3 < 6; var3++) {
            var4.e[var3] = 0.0F;
         }

         var4.e[var4.c] = 1.0F;
         if (var4.f == SolverVariable.Type.ERROR) {
            this.a.add(var4);
         }
      }
   }

   SolverVariable a() {
      int var6 = this.a.size();
      int var5 = 0;
      int var3 = 0;
      SolverVariable var7 = null;

      while (var5 < var6) {
         SolverVariable var9 = this.a.get(var5);

         for (int var2 = 5; var2 >= 0; var2--) {
            float var1 = var9.e[var2];
            int var4 = var3;
            SolverVariable var8 = var7;
            if (var7 == null) {
               var4 = var3;
               var8 = var7;
               if (var1 < 0.0F) {
                  var4 = var3;
                  var8 = var7;
                  if (var2 >= var3) {
                     var4 = var2;
                     var8 = var9;
                  }
               }
            }

            var3 = var4;
            var7 = var8;
            if (var1 > 0.0F) {
               var3 = var4;
               var7 = var8;
               if (var2 > var4) {
                  var3 = var2;
                  var7 = null;
               }
            }
         }

         var5++;
      }

      return var7;
   }

   void a(LinearSystem var1) {
      this.b(var1);
      int var6 = this.a.size();

      for (int var3 = 0; var3 < var6; var3++) {
         SolverVariable var9 = this.a.get(var3);
         if (var9.b != -1) {
            ArrayLinkedVariables var11 = var1.a(var9.b).d;
            int var7 = var11.a;

            for (int var4 = 0; var4 < var7; var4++) {
               SolverVariable var8 = var11.a(var4);
               if (var8 != null) {
                  float var2 = var11.b(var4);

                  for (int var5 = 0; var5 < 6; var5++) {
                     float[] var10 = var8.e;
                     var10[var5] += var9.e[var5] * var2;
                  }

                  if (!this.a.contains(var8)) {
                     this.a.add(var8);
                  }
               }
            }

            var9.a();
         }
      }
   }

   @Override
   public String toString() {
      int var2 = this.a.size();
      String var3 = "Goal: ";

      for (int var1 = 0; var1 < var2; var1++) {
         SolverVariable var4 = this.a.get(var1);
         var3 = var3 + var4.b();
      }

      return var3;
   }
}
