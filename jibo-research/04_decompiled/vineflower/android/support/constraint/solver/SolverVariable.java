package android.support.constraint.solver;

import java.util.Arrays;

public class SolverVariable {
   private static int i = 1;
   public int a = -1;
   int b = -1;
   public int c = 0;
   public float d;
   float[] e = new float[6];
   SolverVariable.Type f;
   ArrayRow[] g = new ArrayRow[8];
   int h = 0;
   private String j;

   public SolverVariable(SolverVariable.Type var1) {
      this.f = var1;
   }

   void a() {
      for (int var1 = 0; var1 < 6; var1++) {
         this.e[var1] = 0.0F;
      }
   }

   void a(ArrayRow var1) {
      int var2 = 0;

      while (true) {
         if (var2 >= this.h) {
            if (this.h >= this.g.length) {
               this.g = Arrays.copyOf(this.g, this.g.length * 2);
            }

            this.g[this.h] = var1;
            this.h++;
            break;
         }

         if (this.g[var2] == var1) {
            break;
         }

         var2++;
      }
   }

   public void a(SolverVariable.Type var1) {
      this.f = var1;
   }

   String b() {
      String var2 = this + "[";

      for (int var1 = 0; var1 < this.e.length; var1++) {
         var2 = var2 + this.e[var1];
         if (var1 < this.e.length - 1) {
            var2 = var2 + ", ";
         } else {
            var2 = var2 + "] ";
         }
      }

      return var2;
   }

   void b(ArrayRow var1) {
      int var3 = 0;

      for (int var2 = 0; var2 < this.h; var2++) {
         if (this.g[var2] == var1) {
            while (var3 < this.h - var2 - 1) {
               this.g[var2 + var3] = this.g[var2 + var3 + 1];
               var3++;
            }

            this.h--;
            break;
         }
      }
   }

   public void c() {
      this.j = null;
      this.f = SolverVariable.Type.UNKNOWN;
      this.c = 0;
      this.a = -1;
      this.b = -1;
      this.d = 0.0F;
      this.h = 0;
   }

   @Override
   public String toString() {
      return "" + this.j;
   }

   public enum Type {
      CONSTANT,
      ERROR,
      SLACK,
      UNKNOWN,
      UNRESTRICTED;

      private static final SolverVariable.Type[] $VALUES = new SolverVariable.Type[]{
         SolverVariable.Type.UNRESTRICTED, SolverVariable.Type.CONSTANT, SolverVariable.Type.SLACK, SolverVariable.Type.ERROR, SolverVariable.Type.UNKNOWN
      };
   }
}
