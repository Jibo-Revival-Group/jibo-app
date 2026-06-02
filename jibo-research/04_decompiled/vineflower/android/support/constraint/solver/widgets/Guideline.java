package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import java.util.ArrayList;

public class Guideline extends ConstraintWidget {
   protected float aa = -1.0F;
   protected int ab = -1;
   protected int ac = -1;
   private ConstraintAnchor ad = this.j;
   private int ae = 0;
   private boolean af = false;
   private int ag = 0;
   private Rectangle ah = new Rectangle();
   private int ai = 8;

   public Guideline() {
      this.q.clear();
      this.q.add(this.ad);
   }

   public int D() {
      return this.ae;
   }

   public float E() {
      return this.aa;
   }

   public int F() {
      return this.ab;
   }

   public int G() {
      return this.ac;
   }

   @Override
   public ConstraintAnchor a(ConstraintAnchor.Type var1) {
      switch (<unrepresentable>.a[var1.ordinal()]) {
         case 1:
         case 2:
            if (this.ae == 1) {
               return this.ad;
            }
            break;
         case 3:
         case 4:
            if (this.ae == 0) {
               return this.ad;
            }
      }

      return null;
   }

   @Override
   public void a(LinearSystem var1, int var2) {
      ConstraintWidgetContainer var5 = (ConstraintWidgetContainer)this.c();
      if (var5 != null) {
         ConstraintAnchor var3 = var5.a(ConstraintAnchor.Type.LEFT);
         ConstraintAnchor var4 = var5.a(ConstraintAnchor.Type.RIGHT);
         if (this.ae == 0) {
            var3 = var5.a(ConstraintAnchor.Type.TOP);
            var4 = var5.a(ConstraintAnchor.Type.BOTTOM);
         }

         if (this.ab != -1) {
            var1.a(LinearSystem.a(var1, var1.a(this.ad), var1.a(var3), this.ab, false));
         } else if (this.ac != -1) {
            var1.a(LinearSystem.a(var1, var1.a(this.ad), var1.a(var4), -this.ac, false));
         } else if (this.aa != -1.0F) {
            var1.a(LinearSystem.a(var1, var1.a(this.ad), var1.a(var3), var1.a(var4), this.aa, this.af));
         }
      }
   }

   @Override
   public void b(LinearSystem var1, int var2) {
      if (this.c() != null) {
         var2 = var1.b(this.ad);
         if (this.ae == 1) {
            this.b(var2);
            this.c(0);
            this.e(this.c().l());
            this.d(0);
         } else {
            this.b(0);
            this.c(var2);
            this.d(this.c().h());
            this.e(0);
         }
      }
   }

   public void e(float var1) {
      if (var1 > -1.0F) {
         this.aa = var1;
         this.ab = -1;
         this.ac = -1;
      }
   }

   public void m(int var1) {
      if (this.ae != var1) {
         this.ae = var1;
         this.q.clear();
         if (this.ae == 1) {
            this.ad = this.i;
         } else {
            this.ad = this.j;
         }

         this.q.add(this.ad);
      }
   }

   public void n(int var1) {
      if (var1 > -1) {
         this.aa = -1.0F;
         this.ab = var1;
         this.ac = -1;
      }
   }

   public void o(int var1) {
      if (var1 > -1) {
         this.aa = -1.0F;
         this.ab = -1;
         this.ac = var1;
      }
   }

   @Override
   public ArrayList<ConstraintAnchor> y() {
      return this.q;
   }
}
