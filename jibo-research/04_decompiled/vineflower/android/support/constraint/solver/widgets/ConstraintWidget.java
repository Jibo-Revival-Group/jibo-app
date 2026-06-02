package android.support.constraint.solver.widgets;

import android.support.constraint.solver.ArrayRow;
import android.support.constraint.solver.Cache;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import java.util.ArrayList;

public class ConstraintWidget {
   public static float D = 0.5F;
   int A;
   protected int B;
   protected int C;
   float E;
   float F;
   ConstraintWidget.DimensionBehaviour G;
   ConstraintWidget.DimensionBehaviour H;
   int I;
   int J;
   int K;
   int L;
   boolean M;
   boolean N;
   boolean O;
   boolean P;
   boolean Q;
   boolean R;
   int S;
   int T;
   boolean U;
   boolean V;
   float W;
   float X;
   ConstraintWidget Y;
   ConstraintWidget Z;
   public int a = -1;
   private int aa;
   private int ab;
   private int ac;
   private int ad;
   private int ae;
   private int af;
   private int ag;
   private int ah;
   private int ai;
   private int aj;
   private Object ak;
   private int al;
   private int am;
   private String an;
   private String ao;
   public int b = -1;
   int c = 0;
   int d = 0;
   int e = 0;
   int f = 0;
   int g = 0;
   int h = 0;
   ConstraintAnchor i = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
   ConstraintAnchor j = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
   ConstraintAnchor k = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
   ConstraintAnchor l = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
   ConstraintAnchor m = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
   ConstraintAnchor n = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
   ConstraintAnchor o = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
   ConstraintAnchor p = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
   protected ArrayList<ConstraintAnchor> q = new ArrayList<>();
   ConstraintWidget r = null;
   int s = 0;
   int t = 0;
   protected float u = 0.0F;
   protected int v = -1;
   protected int w;
   protected int x;
   protected int y;
   protected int z;

   public ConstraintWidget() {
      this.aa = 0;
      this.ab = 0;
      this.ac = 0;
      this.ad = 0;
      this.w = 0;
      this.x = 0;
      this.ae = 0;
      this.af = 0;
      this.ag = 0;
      this.ah = 0;
      this.y = 0;
      this.z = 0;
      this.A = 0;
      this.E = D;
      this.F = D;
      this.G = ConstraintWidget.DimensionBehaviour.FIXED;
      this.H = ConstraintWidget.DimensionBehaviour.FIXED;
      this.al = 0;
      this.am = 0;
      this.an = null;
      this.ao = null;
      this.S = 0;
      this.T = 0;
      this.W = 0.0F;
      this.X = 0.0F;
      this.Y = null;
      this.Z = null;
      this.D();
   }

   private void D() {
      this.q.add(this.i);
      this.q.add(this.j);
      this.q.add(this.k);
      this.q.add(this.l);
      this.q.add(this.n);
      this.q.add(this.o);
      this.q.add(this.m);
   }

   private void a(
      LinearSystem var1,
      boolean var2,
      boolean var3,
      ConstraintAnchor var4,
      ConstraintAnchor var5,
      int var6,
      int var7,
      int var8,
      int var9,
      float var10,
      boolean var11,
      boolean var12,
      int var13,
      int var14,
      int var15
   ) {
      SolverVariable var21 = var1.a(var4);
      SolverVariable var19 = var1.a(var5);
      SolverVariable var20 = var1.a(var4.f());
      SolverVariable var18 = var1.a(var5.f());
      int var17 = var4.d();
      int var16 = var5.d();
      if (this.am == 8) {
         var8 = 0;
         var3 = true;
      }

      if (var20 == null && var18 == null) {
         var1.a(var1.b().b(var21, var6));
         if (!var11) {
            if (var2) {
               var1.a(LinearSystem.a(var1, var19, var21, var9, true));
            } else if (var3) {
               var1.a(LinearSystem.a(var1, var19, var21, var8, false));
            } else {
               var1.a(var1.b().b(var19, var7));
            }
         }
      } else if (var20 != null && var18 == null) {
         var1.a(var1.b().a(var21, var20, var17));
         if (var2) {
            var1.a(LinearSystem.a(var1, var19, var21, var9, true));
         } else if (!var11) {
            if (var3) {
               var1.a(var1.b().a(var19, var21, var8));
            } else {
               var1.a(var1.b().b(var19, var7));
            }
         }
      } else if (var20 == null && var18 != null) {
         var1.a(var1.b().a(var19, var18, var16 * -1));
         if (var2) {
            var1.a(LinearSystem.a(var1, var19, var21, var9, true));
         } else if (!var11) {
            if (var3) {
               var1.a(var1.b().a(var19, var21, var8));
            } else {
               var1.a(var1.b().b(var21, var6));
            }
         }
      } else if (var3) {
         if (var2) {
            var1.a(LinearSystem.a(var1, var19, var21, var9, true));
         } else {
            var1.a(var1.b().a(var19, var21, var8));
         }

         if (var4.e() != var5.e()) {
            if (var4.e() == ConstraintAnchor.Strength.STRONG) {
               var1.a(var1.b().a(var21, var20, var17));
               SolverVariable var26 = var1.c();
               ArrayRow var24 = var1.b();
               var24.b(var19, var18, var26, var16 * -1);
               var1.a(var24);
            } else {
               SolverVariable var27 = var1.c();
               ArrayRow var25 = var1.b();
               var25.a(var21, var20, var27, var17);
               var1.a(var25);
               var1.a(var1.b().a(var19, var18, var16 * -1));
            }
         } else if (var20 == var18) {
            var1.a(LinearSystem.a(var1, var21, var20, 0, 0.5F, var18, var19, 0, true));
         } else if (!var12) {
            if (var4.g() != ConstraintAnchor.ConnectionType.STRICT) {
               var2 = true;
            } else {
               var2 = false;
            }

            var1.a(LinearSystem.b(var1, var21, var20, var17, var2));
            if (var5.g() != ConstraintAnchor.ConnectionType.STRICT) {
               var2 = true;
            } else {
               var2 = false;
            }

            var1.a(LinearSystem.c(var1, var19, var18, var16 * -1, var2));
            var1.a(LinearSystem.a(var1, var21, var20, var17, var10, var18, var19, var16, false));
         }
      } else if (var11) {
         var1.a(var21, var20, var17, 3);
         var1.b(var19, var18, var16 * -1, 3);
         var1.a(LinearSystem.a(var1, var21, var20, var17, var10, var18, var19, var16, true));
      } else if (!var12) {
         if (var13 == 1) {
            var6 = var8;
            if (var14 > var8) {
               var6 = var14;
            }

            label97: {
               if (var15 > 0) {
                  if (var15 < var6) {
                     break label97;
                  }

                  var1.b(var19, var21, var15, 3);
               }

               var15 = var6;
            }

            var1.c(var19, var21, var15, 3);
            var1.a(var21, var20, var17, 2);
            var1.b(var19, var18, -var16, 2);
            var1.a(var21, var20, var17, var10, var18, var19, var16, 4);
         } else if (var14 == 0 && var15 == 0) {
            var1.a(var1.b().a(var21, var20, var17));
            var1.a(var1.b().a(var19, var18, var16 * -1));
         } else {
            if (var15 > 0) {
               var1.b(var19, var21, var15, 3);
            }

            var1.a(var21, var20, var17, 2);
            var1.b(var19, var18, -var16, 2);
            var1.a(var21, var20, var17, var10, var18, var19, var16, 4);
         }
      }
   }

   public void A() {
      ConstraintWidget var3 = this.c();
      if (var3 == null || !(var3 instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer)this.c()).G()) {
         int var2 = this.q.size();

         for (int var1 = 0; var1 < var2; var1++) {
            this.q.get(var1).i();
         }
      }
   }

   public ConstraintWidget.DimensionBehaviour B() {
      return this.G;
   }

   public ConstraintWidget.DimensionBehaviour C() {
      return this.H;
   }

   public ConstraintAnchor a(ConstraintAnchor.Type var1) {
      ConstraintAnchor var2;
      switch (<unrepresentable>.a[var1.ordinal()]) {
         case 1:
            var2 = this.i;
            break;
         case 2:
            var2 = this.j;
            break;
         case 3:
            var2 = this.k;
            break;
         case 4:
            var2 = this.l;
            break;
         case 5:
            var2 = this.m;
            break;
         case 6:
            var2 = this.n;
            break;
         case 7:
            var2 = this.o;
            break;
         case 8:
            var2 = this.p;
            break;
         default:
            var2 = null;
      }

      return var2;
   }

   public void a() {
      this.i.i();
      this.j.i();
      this.k.i();
      this.l.i();
      this.m.i();
      this.n.i();
      this.o.i();
      this.p.i();
      this.r = null;
      this.s = 0;
      this.t = 0;
      this.u = 0.0F;
      this.v = -1;
      this.w = 0;
      this.x = 0;
      this.ae = 0;
      this.af = 0;
      this.ag = 0;
      this.ah = 0;
      this.y = 0;
      this.z = 0;
      this.A = 0;
      this.B = 0;
      this.C = 0;
      this.ai = 0;
      this.aj = 0;
      this.E = D;
      this.F = D;
      this.G = ConstraintWidget.DimensionBehaviour.FIXED;
      this.H = ConstraintWidget.DimensionBehaviour.FIXED;
      this.ak = null;
      this.al = 0;
      this.am = 0;
      this.an = null;
      this.ao = null;
      this.Q = false;
      this.R = false;
      this.S = 0;
      this.T = 0;
      this.U = false;
      this.V = false;
      this.W = 0.0F;
      this.X = 0.0F;
      this.a = -1;
      this.b = -1;
   }

   public void a(float var1) {
      this.E = var1;
   }

   public void a(int var1) {
      this.am = var1;
   }

   public void a(int var1, int var2) {
      this.w = var1;
      this.x = var2;
   }

   public void a(int var1, int var2, int var3) {
      this.c = var1;
      this.e = var2;
      this.f = var3;
   }

   public void a(int var1, int var2, int var3, int var4) {
      int var5 = var3 - var1;
      var3 = var4 - var2;
      this.w = var1;
      this.x = var2;
      if (this.am == 8) {
         this.s = 0;
         this.t = 0;
      } else {
         var1 = var5;
         if (this.G == ConstraintWidget.DimensionBehaviour.FIXED) {
            var1 = var5;
            if (var5 < this.s) {
               var1 = this.s;
            }
         }

         var2 = var3;
         if (this.H == ConstraintWidget.DimensionBehaviour.FIXED) {
            var2 = var3;
            if (var3 < this.t) {
               var2 = this.t;
            }
         }

         this.s = var1;
         this.t = var2;
         if (this.t < this.C) {
            this.t = this.C;
         }

         if (this.s < this.B) {
            this.s = this.B;
         }
      }
   }

   public void a(Cache var1) {
      this.i.a(var1);
      this.j.a(var1);
      this.k.a(var1);
      this.l.a(var1);
      this.m.a(var1);
      this.p.a(var1);
      this.n.a(var1);
      this.o.a(var1);
   }

   public void a(LinearSystem var1, int var2) {
      SolverVariable var16;
      if (var2 != Integer.MAX_VALUE && this.i.g != var2) {
         var16 = null;
      } else {
         var16 = var1.a(this.i);
      }

      SolverVariable var17;
      if (var2 != Integer.MAX_VALUE && this.k.g != var2) {
         var17 = null;
      } else {
         var17 = var1.a(this.k);
      }

      SolverVariable var18;
      if (var2 != Integer.MAX_VALUE && this.j.g != var2) {
         var18 = null;
      } else {
         var18 = var1.a(this.j);
      }

      SolverVariable var19;
      if (var2 != Integer.MAX_VALUE && this.l.g != var2) {
         var19 = null;
      } else {
         var19 = var1.a(this.l);
      }

      SolverVariable var20;
      if (var2 != Integer.MAX_VALUE && this.m.g != var2) {
         var20 = null;
      } else {
         var20 = var1.a(this.m);
      }

      boolean var12;
      boolean var13;
      label385:
      if (this.r != null) {
         boolean var10;
         if ((this.i.c == null || this.i.c.c != this.i) && (this.k.c == null || this.k.c.c != this.k)) {
            var10 = false;
         } else {
            ((ConstraintWidgetContainer)this.r).a(this, 0);
            var10 = true;
         }

         boolean var11;
         if ((this.j.c == null || this.j.c.c != this.j) && (this.l.c == null || this.l.c.c != this.l)) {
            var11 = false;
         } else {
            ((ConstraintWidgetContainer)this.r).a(this, 1);
            var11 = true;
         }

         if (this.r.B() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && !var10) {
            if (this.i.c == null || this.i.c.a != this.r) {
               SolverVariable var22 = var1.a(this.r.i);
               ArrayRow var21 = var1.b();
               var21.a(var16, var22, var1.c(), 0);
               var1.a(var21);
            } else if (this.i.c != null && this.i.c.a == this.r) {
               this.i.a(ConstraintAnchor.ConnectionType.STRICT);
            }

            if (this.k.c == null || this.k.c.a != this.r) {
               SolverVariable var56 = var1.a(this.r.k);
               ArrayRow var63 = var1.b();
               var63.a(var56, var17, var1.c(), 0);
               var1.a(var63);
            } else if (this.k.c != null && this.k.c.a == this.r) {
               this.k.a(ConstraintAnchor.ConnectionType.STRICT);
            }
         }

         if (this.r.C() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && !var11) {
            if (this.j.c == null || this.j.c.a != this.r) {
               SolverVariable var64 = var1.a(this.r.j);
               ArrayRow var57 = var1.b();
               var57.a(var18, var64, var1.c(), 0);
               var1.a(var57);
            } else if (this.j.c != null && this.j.c.a == this.r) {
               this.j.a(ConstraintAnchor.ConnectionType.STRICT);
            }

            if (this.l.c == null || this.l.c.a != this.r) {
               SolverVariable var65 = var1.a(this.r.l);
               ArrayRow var58 = var1.b();
               var58.a(var65, var19, var1.c(), 0);
               var1.a(var58);
               var12 = var11;
               var13 = var10;
               break label385;
            }

            if (this.l.c != null && this.l.c.a == this.r) {
               this.l.a(ConstraintAnchor.ConnectionType.STRICT);
            }
         }

         var13 = var10;
         var12 = var11;
      } else {
         var12 = false;
         var13 = false;
      }

      int var5 = this.s;
      int var4 = var5;
      if (var5 < this.B) {
         var4 = this.B;
      }

      int var6 = this.t;
      var5 = var6;
      if (var6 < this.C) {
         var5 = this.C;
      }

      boolean var40;
      if (this.G != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
         var40 = true;
      } else {
         var40 = false;
      }

      boolean var42;
      if (this.H != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
         var42 = true;
      } else {
         var42 = false;
      }

      if (!var40 && this.i != null && this.k != null && (this.i.c == null || this.k.c == null)) {
         var40 = true;
      }

      if (!var42
         && this.j != null
         && this.l != null
         && (this.j.c == null || this.l.c == null)
         && (this.A == 0 || this.m != null && (this.j.c == null || this.m.c == null))) {
         var42 = true;
      }

      float var3;
      int var33;
      label303: {
         int var8 = 0;
         int var9 = this.v;
         var3 = this.u;
         var33 = var9;
         int var29 = var8;
         if (this.u > 0.0F) {
            var33 = var9;
            var29 = var8;
            if (this.am != 8) {
               if (this.G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                  var8 = (boolean)1;
                  if (var40 && !var42) {
                     var6 = 0;
                     var33 = 1;
                     var8 = var4;
                     boolean var48 = var40;
                     var40 = var42;
                     var4 = var5;
                     var5 = var8;
                     var42 = var48;
                     break label303;
                  }

                  var33 = var9;
                  var29 = var8;
                  if (!var40) {
                     var33 = var9;
                     var29 = var8;
                     if (var42) {
                        var33 = 1;
                        var29 = var8;
                        if (this.v == -1) {
                           var3 = 1.0F / var3;
                           byte var38 = 1;
                           var33 = 1;
                           boolean var47 = var42;
                           var29 = var5;
                           var42 = var40;
                           var5 = var4;
                           var4 = var29;
                           var6 = var38;
                           var40 = var47;
                           break label303;
                        }
                     }
                  }
               } else {
                  if (this.G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                     var8 = (int)(this.t * var3);
                     var6 = 0;
                     var33 = 0;
                     var40 = var42;
                     var4 = var5;
                     var42 = true;
                     var5 = var8;
                     break label303;
                  }

                  var33 = var9;
                  var29 = var8;
                  if (this.H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                     if (this.v == -1) {
                        var3 = 1.0F / var3;
                     }

                     var8 = (int)(this.s * var3);
                     var6 = 1;
                     var33 = 0;
                     boolean var14 = true;
                     var42 = var40;
                     var5 = var4;
                     var4 = var8;
                     var40 = var14;
                     break label303;
                  }
               }
            }
         }

         boolean var37 = (boolean)var29;
         boolean var46 = var42;
         var29 = var5;
         var42 = var40;
         var5 = var4;
         var4 = var29;
         var6 = var33;
         var33 = var37;
         var40 = var46;
      }

      boolean var49;
      if (!var33 || var6 != 0 && var6 != -1) {
         var49 = false;
      } else {
         var49 = true;
      }

      boolean var15;
      if (this.G == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && this instanceof ConstraintWidgetContainer) {
         var15 = true;
      } else {
         var15 = false;
      }

      if (this.a != 2 && (var2 == Integer.MAX_VALUE || this.i.g == var2 && this.k.g == var2)) {
         if (var49 && this.i.c != null && this.k.c != null) {
            SolverVariable var24 = var1.a(this.i);
            SolverVariable var59 = var1.a(this.k);
            SolverVariable var66 = var1.a(this.i.f());
            SolverVariable var23 = var1.a(this.k.f());
            var1.a(var24, var66, this.i.d(), 3);
            var1.b(var59, var23, this.k.d() * -1, 3);
            if (!var13) {
               var1.a(var24, var66, this.i.d(), this.E, var23, var59, this.k.d(), 4);
            }
         } else {
            this.a(var1, var15, var42, this.i, this.k, this.w, this.w + var5, var5, this.B, this.E, var49, var13, this.c, this.e, this.f);
         }
      }

      if (this.b != 2) {
         if (this.H == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && this instanceof ConstraintWidgetContainer) {
            var42 = true;
         } else {
            var42 = false;
         }

         if (!var33 || var6 != 1 && var6 != -1) {
            var13 = false;
         } else {
            var13 = true;
         }

         if (this.A <= 0) {
            if (var2 == Integer.MAX_VALUE || this.j.g == var2 && this.l.g == var2) {
               if (var13 && this.j.c != null && this.l.c != null) {
                  SolverVariable var62 = var1.a(this.j);
                  SolverVariable var68 = var1.a(this.l);
                  var20 = var1.a(this.j.f());
                  SolverVariable var70 = var1.a(this.l.f());
                  var1.a(var62, var20, this.j.d(), 3);
                  var1.b(var68, var70, this.l.d() * -1, 3);
                  if (!var12) {
                     var1.a(var62, var20, this.j.d(), this.F, var70, var68, this.l.d(), 4);
                  }
               } else {
                  this.a(var1, var42, var40, this.j, this.l, this.x, this.x + var4, var4, this.C, this.F, var13, var12, this.d, this.g, this.h);
               }
            }
         } else {
            ConstraintAnchor var60 = this.l;
            if (var2 == Integer.MAX_VALUE || this.l.g == var2 && this.m.g == var2) {
               var1.c(var20, var18, this.w(), 5);
            }

            ConstraintAnchor var52;
            if (this.m.c != null) {
               var5 = this.A;
               var52 = this.m;
            } else {
               var5 = var4;
               var52 = var60;
            }

            if (var2 == Integer.MAX_VALUE || this.j.g == var2 && var52.g == var2) {
               if (var13 && this.j.c != null && this.l.c != null) {
                  SolverVariable var69 = var1.a(this.j);
                  var20 = var1.a(this.l);
                  SolverVariable var67 = var1.a(this.j.f());
                  SolverVariable var61 = var1.a(this.l.f());
                  var1.a(var69, var67, this.j.d(), 3);
                  var1.b(var20, var61, this.l.d() * -1, 3);
                  if (!var12) {
                     var1.a(var69, var67, this.j.d(), this.F, var61, var20, this.l.d(), 4);
                  }
               } else {
                  this.a(var1, var42, var40, this.j, var52, this.x, this.x + var5, var5, this.C, this.F, var13, var12, this.d, this.g, this.h);
                  var1.c(var19, var18, var4, 5);
               }
            }
         }

         if (var33) {
            ArrayRow var55 = var1.b();
            if (var2 == Integer.MAX_VALUE || this.i.g == var2 && this.k.g == var2) {
               if (var6 == 0) {
                  var1.a(var55.a(var17, var16, var19, var18, var3));
               } else if (var6 == 1) {
                  var1.a(var55.a(var19, var18, var17, var16, var3));
               } else {
                  if (this.e > 0) {
                     var1.a(var17, var16, this.e, 3);
                  }

                  if (this.g > 0) {
                     var1.a(var19, var18, this.g, 3);
                  }

                  var55.a(var17, var16, var19, var18, var3);
                  var17 = var1.d();
                  var16 = var1.d();
                  var17.c = 4;
                  var16.c = 4;
                  var55.a(var17, var16);
                  var1.a(var55);
               }
            }
         }
      }
   }

   public void a(ConstraintAnchor.Type var1, ConstraintWidget var2, ConstraintAnchor.Type var3, int var4, int var5) {
      this.a(var1).a(var2.a(var3), var4, var5, ConstraintAnchor.Strength.STRONG, 0, true);
   }

   public void a(ConstraintWidget.DimensionBehaviour var1) {
      this.G = var1;
      if (this.G == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
         this.d(this.ai);
      }
   }

   public void a(ConstraintWidget var1) {
      this.r = var1;
   }

   public void a(Object var1) {
      this.ak = var1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public void a(String var1) {
      int var6 = 0;
      byte var8 = 0;
      if (var1 != null && var1.length() != 0) {
         byte var7 = -1;
         int var9 = var1.length();
         int var10 = var1.indexOf(44);
         int var5 = var6;
         byte var4 = var7;
         if (var10 > 0) {
            var5 = var6;
            var4 = var7;
            if (var10 < var9 - 1) {
               String var11 = var1.substring(0, var10);
               if (var11.equalsIgnoreCase("W")) {
                  var4 = var8;
               } else if (var11.equalsIgnoreCase("H")) {
                  var4 = 1;
               } else {
                  var4 = -1;
               }

               var5 = var10 + 1;
            }
         }

         float var2;
         label76: {
            var6 = var1.indexOf(58);
            if (var6 >= 0 && var6 < var9 - 1) {
               String var21 = var1.substring(var5, var6);
               var1 = var1.substring(var6 + 1);
               if (var21.length() > 0 && var1.length() > 0) {
                  float var3;
                  try {
                     var2 = Float.parseFloat(var21);
                     var3 = Float.parseFloat(var1);
                  } catch (NumberFormatException var15) {
                     var2 = 0.0F;
                     break label76;
                  }

                  if (var2 > 0.0F && var3 > 0.0F) {
                     if (var4 == 1) {
                        try {
                           var2 = Math.abs(var3 / var2);
                        } catch (NumberFormatException var14) {
                           var2 = 0.0F;
                        }
                     } else {
                        var2 /= var3;

                        try {
                           var2 = Math.abs(var2);
                        } catch (NumberFormatException var13) {
                           var2 = 0.0F;
                        }
                     }
                     break label76;
                  }
               }
            } else {
               var1 = var1.substring(var5);
               if (var1.length() > 0) {
                  try {
                     var2 = Float.parseFloat(var1);
                  } catch (NumberFormatException var12) {
                     var2 = 0.0F;
                  }
                  break label76;
               }
            }

            var2 = 0.0F;
         }

         if (var2 > 0.0F) {
            this.u = var2;
            this.v = var4;
         }
      } else {
         this.u = 0.0F;
      }
   }

   public void b(float var1) {
      this.F = var1;
   }

   public void b(int var1) {
      this.w = var1;
   }

   public void b(int var1, int var2) {
      this.y = var1;
      this.z = var2;
   }

   public void b(int var1, int var2, int var3) {
      this.d = var1;
      this.g = var2;
      this.h = var3;
   }

   public void b(LinearSystem var1, int var2) {
      if (var2 == Integer.MAX_VALUE) {
         this.a(var1.b(this.i), var1.b(this.j), var1.b(this.k), var1.b(this.l));
      } else if (var2 == -2) {
         this.a(this.aa, this.ab, this.ac, this.ad);
      } else {
         if (this.i.g == var2) {
            this.aa = var1.b(this.i);
         }

         if (this.j.g == var2) {
            this.ab = var1.b(this.j);
         }

         if (this.k.g == var2) {
            this.ac = var1.b(this.k);
         }

         if (this.l.g == var2) {
            this.ad = var1.b(this.l);
         }
      }
   }

   public void b(ConstraintWidget.DimensionBehaviour var1) {
      this.H = var1;
      if (this.H == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
         this.e(this.aj);
      }
   }

   public boolean b() {
      boolean var1;
      if (this.r == null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public ConstraintWidget c() {
      return this.r;
   }

   public void c(float var1) {
      this.W = var1;
   }

   public void c(int var1) {
      this.x = var1;
   }

   public void c(int var1, int var2) {
      this.w = var1;
      this.s = var2 - var1;
      if (this.s < this.B) {
         this.s = this.B;
      }
   }

   public int d() {
      return this.am;
   }

   public void d(float var1) {
      this.X = var1;
   }

   public void d(int var1) {
      this.s = var1;
      if (this.s < this.B) {
         this.s = this.B;
      }
   }

   public void d(int var1, int var2) {
      this.x = var1;
      this.t = var2 - var1;
      if (this.t < this.C) {
         this.t = this.C;
      }
   }

   public String e() {
      return this.an;
   }

   public void e(int var1) {
      this.t = var1;
      if (this.t < this.C) {
         this.t = this.C;
      }
   }

   public int f() {
      return this.w;
   }

   public void f(int var1) {
      if (var1 < 0) {
         this.B = 0;
      } else {
         this.B = var1;
      }
   }

   public int g() {
      return this.x;
   }

   public void g(int var1) {
      if (var1 < 0) {
         this.C = 0;
      } else {
         this.C = var1;
      }
   }

   public int h() {
      int var1;
      if (this.am == 8) {
         var1 = 0;
      } else {
         var1 = this.s;
      }

      return var1;
   }

   public void h(int var1) {
      this.ai = var1;
   }

   public int i() {
      int var1 = this.s;
      int var2 = var1;
      if (this.G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
         if (this.c == 1) {
            var1 = Math.max(this.e, var1);
         } else if (this.e > 0) {
            var1 = this.e;
            this.s = var1;
         } else {
            var1 = 0;
         }

         var2 = var1;
         if (this.f > 0) {
            var2 = var1;
            if (this.f < var1) {
               var2 = this.f;
            }
         }
      }

      return var2;
   }

   public void i(int var1) {
      this.aj = var1;
   }

   public int j() {
      int var1 = this.t;
      int var2 = var1;
      if (this.H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
         if (this.d == 1) {
            var1 = Math.max(this.g, var1);
         } else if (this.g > 0) {
            var1 = this.g;
            this.t = var1;
         } else {
            var1 = 0;
         }

         var2 = var1;
         if (this.h > 0) {
            var2 = var1;
            if (this.h < var1) {
               var2 = this.h;
            }
         }
      }

      return var2;
   }

   public void j(int var1) {
      this.A = var1;
   }

   public int k() {
      return this.ai;
   }

   public void k(int var1) {
      this.S = var1;
   }

   public int l() {
      int var1;
      if (this.am == 8) {
         var1 = 0;
      } else {
         var1 = this.t;
      }

      return var1;
   }

   public void l(int var1) {
      this.T = var1;
   }

   public int m() {
      return this.aj;
   }

   public int n() {
      return this.ae + this.y;
   }

   public int o() {
      return this.af + this.z;
   }

   public int p() {
      return this.o() + this.ah;
   }

   public int q() {
      return this.n() + this.ag;
   }

   protected int r() {
      return this.w + this.y;
   }

   protected int s() {
      return this.x + this.z;
   }

   public int t() {
      return this.f() + this.s;
   }

   @Override
   public String toString() {
      StringBuilder var2 = new StringBuilder();
      String var1;
      if (this.ao != null) {
         var1 = "type: " + this.ao + " ";
      } else {
         var1 = "";
      }

      var2 = var2.append(var1);
      if (this.an != null) {
         var1 = "id: " + this.an + " ";
      } else {
         var1 = "";
      }

      return var2.append(var1)
         .append("(")
         .append(this.w)
         .append(", ")
         .append(this.x)
         .append(") - (")
         .append(this.s)
         .append(" x ")
         .append(this.t)
         .append(")")
         .append(" wrap: (")
         .append(this.ai)
         .append(" x ")
         .append(this.aj)
         .append(")")
         .toString();
   }

   public int u() {
      return this.g() + this.t;
   }

   public boolean v() {
      boolean var1;
      if (this.A > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public int w() {
      return this.A;
   }

   public Object x() {
      return this.ak;
   }

   public ArrayList<ConstraintAnchor> y() {
      return this.q;
   }

   public void z() {
      int var3 = this.w;
      int var6 = this.x;
      int var2 = this.w;
      int var1 = this.s;
      int var4 = this.x;
      int var5 = this.t;
      this.ae = var3;
      this.af = var6;
      this.ag = var2 + var1 - var3;
      this.ah = var4 + var5 - var6;
   }

   public enum DimensionBehaviour {
      FIXED,
      MATCH_CONSTRAINT,
      MATCH_PARENT,
      WRAP_CONTENT;

      private static final ConstraintWidget.DimensionBehaviour[] $VALUES = new ConstraintWidget.DimensionBehaviour[]{
         ConstraintWidget.DimensionBehaviour.FIXED,
         ConstraintWidget.DimensionBehaviour.WRAP_CONTENT,
         ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT,
         ConstraintWidget.DimensionBehaviour.MATCH_PARENT
      };
   }
}
