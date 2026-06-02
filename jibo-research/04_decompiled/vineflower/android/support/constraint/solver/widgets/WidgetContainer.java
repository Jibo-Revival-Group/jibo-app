package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import java.util.ArrayList;

public class WidgetContainer extends ConstraintWidget {
   protected ArrayList<ConstraintWidget> aj = new ArrayList<>();

   public void F() {
      this.z();
      if (this.aj != null) {
         int var2 = this.aj.size();

         for (int var1 = 0; var1 < var2; var1++) {
            ConstraintWidget var3 = this.aj.get(var1);
            if (var3 instanceof WidgetContainer) {
               ((WidgetContainer)var3).F();
            }
         }
      }
   }

   public ConstraintWidgetContainer H() {
      ConstraintWidget var1 = this.c();
      ConstraintWidgetContainer var2;
      if (this instanceof ConstraintWidgetContainer) {
         var2 = (ConstraintWidgetContainer)this;
      } else {
         var2 = null;
      }

      while (var1 != null) {
         ConstraintWidget var3 = var1.c();
         if (var1 instanceof ConstraintWidgetContainer) {
            var2 = (ConstraintWidgetContainer)var1;
            var1 = var3;
         } else {
            var1 = var3;
         }
      }

      return var2;
   }

   public void I() {
      this.aj.clear();
   }

   @Override
   public void a() {
      this.aj.clear();
      super.a();
   }

   @Override
   public void a(Cache var1) {
      super.a(var1);
      int var3 = this.aj.size();

      for (int var2 = 0; var2 < var3; var2++) {
         this.aj.get(var2).a(var1);
      }
   }

   @Override
   public void b(int var1, int var2) {
      super.b(var1, var2);
      var2 = this.aj.size();

      for (int var3 = 0; var3 < var2; var3++) {
         this.aj.get(var3).b(this.r(), this.s());
      }
   }

   public void b(ConstraintWidget var1) {
      this.aj.add(var1);
      if (var1.c() != null) {
         ((WidgetContainer)var1.c()).c(var1);
      }

      var1.a(this);
   }

   public void c(ConstraintWidget var1) {
      this.aj.remove(var1);
      var1.a((ConstraintWidget)null);
   }

   @Override
   public void z() {
      super.z();
      if (this.aj != null) {
         int var2 = this.aj.size();

         for (int var1 = 0; var1 < var2; var1++) {
            ConstraintWidget var3 = this.aj.get(var1);
            var3.b(this.n(), this.o());
            if (!(var3 instanceof ConstraintWidgetContainer)) {
               var3.z();
            }
         }
      }
   }
}
