package android.support.constraint.solver.widgets;

import java.util.ArrayList;

public class Snapshot {
   private int a;
   private int b;
   private int c;
   private int d;
   private ArrayList<Snapshot.Connection> e = new ArrayList<>();

   public Snapshot(ConstraintWidget var1) {
      this.a = var1.f();
      this.b = var1.g();
      this.c = var1.h();
      this.d = var1.l();
      ArrayList var4 = var1.y();
      int var3 = var4.size();

      for (int var2 = 0; var2 < var3; var2++) {
         ConstraintAnchor var5 = (ConstraintAnchor)var4.get(var2);
         this.e.add(new Snapshot.Connection(var5));
      }
   }

   public void a(ConstraintWidget var1) {
      this.a = var1.f();
      this.b = var1.g();
      this.c = var1.h();
      this.d = var1.l();
      int var3 = this.e.size();

      for (int var2 = 0; var2 < var3; var2++) {
         this.e.get(var2).a(var1);
      }
   }

   public void b(ConstraintWidget var1) {
      var1.b(this.a);
      var1.c(this.b);
      var1.d(this.c);
      var1.e(this.d);
      int var3 = this.e.size();

      for (int var2 = 0; var2 < var3; var2++) {
         this.e.get(var2).b(var1);
      }
   }

   static class Connection {
      private ConstraintAnchor a;
      private ConstraintAnchor b;
      private int c;
      private ConstraintAnchor.Strength d;
      private int e;

      public Connection(ConstraintAnchor var1) {
         this.a = var1;
         this.b = var1.f();
         this.c = var1.d();
         this.d = var1.e();
         this.e = var1.h();
      }

      public void a(ConstraintWidget var1) {
         this.a = var1.a(this.a.c());
         if (this.a != null) {
            this.b = this.a.f();
            this.c = this.a.d();
            this.d = this.a.e();
            this.e = this.a.h();
         } else {
            this.b = null;
            this.c = 0;
            this.d = ConstraintAnchor.Strength.STRONG;
            this.e = 0;
         }
      }

      public void b(ConstraintWidget var1) {
         var1.a(this.a.c()).a(this.b, this.c, this.d, this.e);
      }
   }
}
