package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import android.support.constraint.solver.SolverVariable;
import java.util.HashSet;

public class ConstraintAnchor {
   final ConstraintWidget a;
   final ConstraintAnchor.Type b;
   ConstraintAnchor c;
   public int d = 0;
   int e = -1;
   SolverVariable f;
   int g;
   private ConstraintAnchor.Strength h = ConstraintAnchor.Strength.NONE;
   private ConstraintAnchor.ConnectionType i = ConstraintAnchor.ConnectionType.RELAXED;
   private int j = 0;

   public ConstraintAnchor(ConstraintWidget var1, ConstraintAnchor.Type var2) {
      this.g = Integer.MAX_VALUE;
      this.a = var1;
      this.b = var2;
   }

   private String a(HashSet<ConstraintAnchor> var1) {
      String var4;
      if (var1.add(this)) {
         StringBuilder var2 = new StringBuilder().append(this.a.e()).append(":").append(this.b.toString());
         String var3;
         if (this.c != null) {
            var3 = " connected to " + this.c.a(var1);
         } else {
            var3 = "";
         }

         var4 = var2.append(var3).toString();
      } else {
         var4 = "<-";
      }

      return var4;
   }

   public SolverVariable a() {
      return this.f;
   }

   public void a(Cache var1) {
      if (this.f == null) {
         this.f = new SolverVariable(SolverVariable.Type.UNRESTRICTED);
      } else {
         this.f.c();
      }
   }

   public void a(ConstraintAnchor.ConnectionType var1) {
      this.i = var1;
   }

   public boolean a(ConstraintAnchor var1) {
      boolean var2 = true;
      boolean var4 = false;
      if (var1 == null) {
         var2 = var4;
      } else {
         ConstraintAnchor.Type var5 = var1.c();
         if (var5 == this.b) {
            var2 = var4;
            if (this.b != ConstraintAnchor.Type.CENTER) {
               if (this.b == ConstraintAnchor.Type.BASELINE) {
                  var2 = var4;
                  if (!var1.b().v()) {
                     return var2;
                  }

                  var2 = var4;
                  if (!this.b().v()) {
                     return var2;
                  }
               }

               var2 = true;
            }
         } else {
            switch (<unrepresentable>.a[this.b.ordinal()]) {
               case 1:
                  if (var5 == ConstraintAnchor.Type.BASELINE || var5 == ConstraintAnchor.Type.CENTER_X || var5 == ConstraintAnchor.Type.CENTER_Y) {
                     var2 = false;
                  }
                  break;
               case 2:
               case 3:
                  boolean var6;
                  if (var5 != ConstraintAnchor.Type.LEFT && var5 != ConstraintAnchor.Type.RIGHT) {
                     var6 = false;
                  } else {
                     var6 = true;
                  }

                  var2 = var6;
                  if (var1.b() instanceof Guideline) {
                     if (!var6) {
                        var2 = var4;
                        if (var5 != ConstraintAnchor.Type.CENTER_X) {
                           break;
                        }
                     }

                     var2 = true;
                  }
                  break;
               case 4:
               case 5:
                  boolean var3;
                  if (var5 != ConstraintAnchor.Type.TOP && var5 != ConstraintAnchor.Type.BOTTOM) {
                     var3 = false;
                  } else {
                     var3 = true;
                  }

                  var2 = var3;
                  if (var1.b() instanceof Guideline) {
                     if (!var3) {
                        var2 = var4;
                        if (var5 != ConstraintAnchor.Type.CENTER_Y) {
                           break;
                        }
                     }

                     var2 = true;
                  }
                  break;
               default:
                  var2 = var4;
            }
         }
      }

      return var2;
   }

   public boolean a(ConstraintAnchor var1, int var2, int var3, ConstraintAnchor.Strength var4, int var5, boolean var6) {
      boolean var7 = true;
      if (var1 == null) {
         this.c = null;
         this.d = 0;
         this.e = -1;
         this.h = ConstraintAnchor.Strength.NONE;
         this.j = 2;
         var6 = var7;
      } else if (!var6 && !this.a(var1)) {
         var6 = false;
      } else {
         this.c = var1;
         if (var2 > 0) {
            this.d = var2;
         } else {
            this.d = 0;
         }

         this.e = var3;
         this.h = var4;
         this.j = var5;
         var6 = var7;
      }

      return var6;
   }

   public boolean a(ConstraintAnchor var1, int var2, ConstraintAnchor.Strength var3, int var4) {
      return this.a(var1, var2, -1, var3, var4, false);
   }

   public ConstraintWidget b() {
      return this.a;
   }

   public ConstraintAnchor.Type c() {
      return this.b;
   }

   public int d() {
      int var1;
      if (this.a.d() == 8) {
         var1 = 0;
      } else if (this.e > -1 && this.c != null && this.c.a.d() == 8) {
         var1 = this.e;
      } else {
         var1 = this.d;
      }

      return var1;
   }

   public ConstraintAnchor.Strength e() {
      return this.h;
   }

   public ConstraintAnchor f() {
      return this.c;
   }

   public ConstraintAnchor.ConnectionType g() {
      return this.i;
   }

   public int h() {
      return this.j;
   }

   public void i() {
      this.c = null;
      this.d = 0;
      this.e = -1;
      this.h = ConstraintAnchor.Strength.STRONG;
      this.j = 0;
      this.i = ConstraintAnchor.ConnectionType.RELAXED;
   }

   public boolean j() {
      boolean var1;
      if (this.c != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public String toString() {
      HashSet var1 = new HashSet();
      StringBuilder var2 = new StringBuilder().append(this.a.e()).append(":").append(this.b.toString());
      String var3;
      if (this.c != null) {
         var3 = " connected to " + this.c.a(var1);
      } else {
         var3 = "";
      }

      return var2.append(var3).toString();
   }

   public enum ConnectionType {
      RELAXED,
      STRICT;

      private static final ConstraintAnchor.ConnectionType[] $VALUES = new ConstraintAnchor.ConnectionType[]{
         ConstraintAnchor.ConnectionType.RELAXED, ConstraintAnchor.ConnectionType.STRICT
      };
   }

   public enum Strength {
      NONE,
      STRONG,
      WEAK;

      private static final ConstraintAnchor.Strength[] $VALUES = new ConstraintAnchor.Strength[]{
         ConstraintAnchor.Strength.NONE, ConstraintAnchor.Strength.STRONG, ConstraintAnchor.Strength.WEAK
      };
   }

   public enum Type {
      BASELINE,
      BOTTOM,
      CENTER,
      CENTER_X,
      CENTER_Y,
      LEFT,
      NONE,
      RIGHT,
      TOP;

      private static final ConstraintAnchor.Type[] $VALUES = new ConstraintAnchor.Type[]{
         ConstraintAnchor.Type.NONE,
         ConstraintAnchor.Type.LEFT,
         ConstraintAnchor.Type.TOP,
         ConstraintAnchor.Type.RIGHT,
         ConstraintAnchor.Type.BOTTOM,
         ConstraintAnchor.Type.BASELINE,
         ConstraintAnchor.Type.CENTER,
         ConstraintAnchor.Type.CENTER_X,
         ConstraintAnchor.Type.CENTER_Y
      };
   }
}
