package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;

public class Optimizer {
   static void a(ConstraintWidgetContainer var0, LinearSystem var1, int var2, ConstraintWidget var3) {
      int var12 = 0;
      int var9 = 0;
      float var5 = 0.0F;
      ConstraintWidget var15 = null;
      ConstraintWidget var14 = var3;

      while (var14 != null) {
         boolean var10;
         if (var14.d() == 8) {
            var10 = 1;
         } else {
            var10 = 0;
         }

         if (!var10) {
            int var11 = var9 + 1;
            if (var14.G != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
               int var13 = var14.h();
               if (var14.i.c != null) {
                  var9 = var14.i.d();
               } else {
                  var9 = 0;
               }

               if (var14.k.c != null) {
                  var10 = var14.k.d();
               } else {
                  var10 = 0;
               }

               var12 = var10 + var12 + var13 + var9;
               var9 = var11;
            } else {
               var5 += var14.W;
               var9 = var11;
            }
         }

         ConstraintWidget var16;
         if (var14.k.c != null) {
            var16 = var14.k.c.a;
         } else {
            var16 = null;
         }

         var15 = var16;
         label115:
         if (var16 != null) {
            if (var16.i.c != null) {
               var15 = var16;
               if (var16.i.c == null) {
                  break label115;
               }

               var15 = var16;
               if (var16.i.c.a == var14) {
                  break label115;
               }
            }

            var15 = null;
         }

         var16 = var15;
         var15 = var14;
         var14 = var16;
      }

      int var24 = 0;
      if (var15 != null) {
         int var26;
         if (var15.k.c != null) {
            var26 = var15.k.c.a.f();
         } else {
            var26 = 0;
         }

         var24 = var26;
         if (var15.k.c != null) {
            var24 = var26;
            if (var15.k.c.a == var0) {
               var24 = var0.t();
            }
         }
      }

      float var8 = (float)(var24 - 0) - var12;
      float var4 = var8 / (var9 + 1);
      float var6;
      if (var2 == 0) {
         var6 = var4;
         var15 = var3;
      } else {
         var6 = var8 / var2;
         var4 = 0.0F;
         var15 = var3;
      }

      while (var15 != null) {
         if (var15.i.c != null) {
            var9 = var15.i.d();
         } else {
            var9 = 0;
         }

         if (var15.k.c != null) {
            var24 = var15.k.d();
         } else {
            var24 = 0;
         }

         if (var15.d() != 8) {
            var4 += var9;
            var1.a(var15.i.f, (int)(0.5F + var4));
            if (var15.G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
               if (var5 == 0.0F) {
                  var4 = var6 - var9 - var24 + var4;
               } else {
                  var4 = var15.W * var8 / var5 - var9 - var24 + var4;
               }
            } else {
               var4 = var15.h() + var4;
            }

            var1.a(var15.k.f, (int)(0.5F + var4));
            float var7 = var4;
            if (var2 == 0) {
               var7 = var4 + var6;
            }

            var4 = var7 + var24;
         } else {
            float var20 = var4 - var6 / 2.0F;
            var1.a(var15.i.f, (int)(0.5F + var20));
            var1.a(var15.k.f, (int)(var20 + 0.5F));
         }

         if (var15.k.c != null) {
            var14 = var15.k.c.a;
         } else {
            var14 = null;
         }

         var3 = var14;
         if (var14 != null) {
            var3 = var14;
            if (var14.i.c != null) {
               var3 = var14;
               if (var14.i.c.a != var15) {
                  var3 = null;
               }
            }
         }

         var14 = var3;
         if (var3 == var0) {
            var14 = null;
         }

         var15 = var14;
      }
   }

   static void a(ConstraintWidgetContainer var0, LinearSystem var1, ConstraintWidget var2) {
      if (var0.G != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && var2.G == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
         var2.i.f = var1.a(var2.i);
         var2.k.f = var1.a(var2.k);
         int var3 = var2.i.d;
         int var4 = var0.h() - var2.k.d;
         var1.a(var2.i.f, var3);
         var1.a(var2.k.f, var4);
         var2.c(var3, var4);
         var2.a = 2;
      }

      if (var0.H != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && var2.H == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
         var2.j.f = var1.a(var2.j);
         var2.l.f = var1.a(var2.l);
         int var6 = var2.j.d;
         int var5 = var0.l() - var2.l.d;
         var1.a(var2.j.f, var6);
         var1.a(var2.l.f, var5);
         if (var2.A > 0 || var2.d() == 8) {
            var2.m.f = var1.a(var2.m);
            var1.a(var2.m.f, var2.A + var6);
         }

         var2.d(var6, var5);
         var2.b = 2;
      }
   }

   static void b(ConstraintWidgetContainer var0, LinearSystem var1, int var2, ConstraintWidget var3) {
      int var12 = 0;
      int var9 = 0;
      float var5 = 0.0F;
      ConstraintWidget var16 = null;
      ConstraintWidget var14 = var3;

      while (var14 != null) {
         boolean var10;
         if (var14.d() == 8) {
            var10 = 1;
         } else {
            var10 = 0;
         }

         if (!var10) {
            int var11 = var9 + 1;
            if (var14.H != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
               int var13 = var14.l();
               if (var14.j.c != null) {
                  var9 = var14.j.d();
               } else {
                  var9 = 0;
               }

               if (var14.l.c != null) {
                  var10 = var14.l.d();
               } else {
                  var10 = 0;
               }

               var12 = var10 + var12 + var13 + var9;
               var9 = var11;
            } else {
               var5 += var14.X;
               var9 = var11;
            }
         }

         if (var14.l.c != null) {
            var16 = var14.l.c.a;
         } else {
            var16 = null;
         }

         ConstraintWidget var15;
         var15 = var16;
         label115:
         if (var16 != null) {
            if (var16.j.c != null) {
               var15 = var16;
               if (var16.j.c == null) {
                  break label115;
               }

               var15 = var16;
               if (var16.j.c.a == var14) {
                  break label115;
               }
            }

            var15 = null;
         }

         var16 = var14;
         var14 = var15;
      }

      int var26 = 0;
      if (var16 != null) {
         int var24;
         if (var16.l.c != null) {
            var24 = var16.l.c.a.f();
         } else {
            var24 = 0;
         }

         var26 = var24;
         if (var16.l.c != null) {
            var26 = var24;
            if (var16.l.c.a == var0) {
               var26 = var0.u();
            }
         }
      }

      float var8 = (float)(var26 - 0) - var12;
      float var4 = var8 / (var9 + 1);
      float var6;
      ConstraintWidget var29;
      if (var2 == 0) {
         var6 = var4;
         var29 = var3;
      } else {
         var6 = var8 / var2;
         var4 = 0.0F;
         var29 = var3;
      }

      while (var29 != null) {
         if (var29.j.c != null) {
            var9 = var29.j.d();
         } else {
            var9 = 0;
         }

         int var25;
         if (var29.l.c != null) {
            var25 = var29.l.d();
         } else {
            var25 = 0;
         }

         if (var29.d() != 8) {
            var4 += var9;
            var1.a(var29.j.f, (int)(0.5F + var4));
            if (var29.H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
               if (var5 == 0.0F) {
                  var4 = var6 - var9 - var25 + var4;
               } else {
                  var4 = var29.X * var8 / var5 - var9 - var25 + var4;
               }
            } else {
               var4 = var29.l() + var4;
            }

            var1.a(var29.l.f, (int)(0.5F + var4));
            float var7 = var4;
            if (var2 == 0) {
               var7 = var4 + var6;
            }

            var4 = var7 + var25;
         } else {
            float var20 = var4 - var6 / 2.0F;
            var1.a(var29.j.f, (int)(0.5F + var20));
            var1.a(var29.l.f, (int)(var20 + 0.5F));
         }

         if (var29.l.c != null) {
            var14 = var29.l.c.a;
         } else {
            var14 = null;
         }

         var3 = var14;
         if (var14 != null) {
            var3 = var14;
            if (var14.j.c != null) {
               var3 = var14;
               if (var14.j.c.a != var29) {
                  var3 = null;
               }
            }
         }

         var14 = var3;
         if (var3 == var0) {
            var14 = null;
         }

         var29 = var14;
      }
   }

   static void b(ConstraintWidgetContainer var0, LinearSystem var1, ConstraintWidget var2) {
      if (var2.G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
         var2.a = 1;
      } else if (var0.G != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && var2.G == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
         var2.i.f = var1.a(var2.i);
         var2.k.f = var1.a(var2.k);
         int var26 = var2.i.d;
         int var19 = var0.h() - var2.k.d;
         var1.a(var2.i.f, var26);
         var1.a(var2.k.f, var19);
         var2.c(var26, var19);
         var2.a = 2;
      } else if (var2.i.c != null && var2.k.c != null) {
         if (var2.i.c.a == var0 && var2.k.c.a == var0) {
            int var25 = var2.i.d();
            int var6 = var2.k.d();
            int var17;
            if (var0.G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
               var17 = var0.h() - var6;
            } else {
               var17 = var2.h();
               var25 += (int)((var0.h() - var25 - var6 - var17) * var2.E + 0.5F);
               var17 = var2.h() + var25;
            }

            var2.i.f = var1.a(var2.i);
            var2.k.f = var1.a(var2.k);
            var1.a(var2.i.f, var25);
            var1.a(var2.k.f, var17);
            var2.a = 2;
            var2.c(var25, var17);
         } else {
            var2.a = 1;
         }
      } else if (var2.i.c != null && var2.i.c.a == var0) {
         int var24 = var2.i.d();
         int var16 = var2.h() + var24;
         var2.i.f = var1.a(var2.i);
         var2.k.f = var1.a(var2.k);
         var1.a(var2.i.f, var24);
         var1.a(var2.k.f, var16);
         var2.a = 2;
         var2.c(var24, var16);
      } else if (var2.k.c != null && var2.k.c.a == var0) {
         var2.i.f = var1.a(var2.i);
         var2.k.f = var1.a(var2.k);
         int var23 = var0.h() - var2.k.d();
         int var15 = var23 - var2.h();
         var1.a(var2.i.f, var15);
         var1.a(var2.k.f, var23);
         var2.a = 2;
         var2.c(var15, var23);
      } else if (var2.i.c != null && var2.i.c.a.a == 2) {
         SolverVariable var9 = var2.i.c.f;
         var2.i.f = var1.a(var2.i);
         var2.k.f = var1.a(var2.k);
         int var22 = (int)(var9.d + var2.i.d() + 0.5F);
         int var14 = var2.h() + var22;
         var1.a(var2.i.f, var22);
         var1.a(var2.k.f, var14);
         var2.a = 2;
         var2.c(var22, var14);
      } else if (var2.k.c != null && var2.k.c.a.a == 2) {
         SolverVariable var8 = var2.k.c.f;
         var2.i.f = var1.a(var2.i);
         var2.k.f = var1.a(var2.k);
         int var21 = (int)(var8.d - var2.k.d() + 0.5F);
         int var13 = var21 - var2.h();
         var1.a(var2.i.f, var13);
         var1.a(var2.k.f, var21);
         var2.a = 2;
         var2.c(var13, var21);
      } else {
         boolean var4;
         if (var2.i.c != null) {
            var4 = 1;
         } else {
            var4 = 0;
         }

         boolean var5;
         if (var2.k.c != null) {
            var5 = 1;
         } else {
            var5 = 0;
         }

         if (!var4 && !var5) {
            if (var2 instanceof Guideline) {
               Guideline var7 = (Guideline)var2;
               if (var7.D() == 1) {
                  var2.i.f = var1.a(var2.i);
                  var2.k.f = var1.a(var2.k);
                  float var3;
                  if (var7.F() != -1) {
                     var3 = var7.F();
                  } else if (var7.G() != -1) {
                     var3 = var0.h() - var7.G();
                  } else {
                     var3 = var0.h();
                     var3 = var7.E() * var3;
                  }

                  var4 = (int)(var3 + 0.5F);
                  var1.a(var2.i.f, var4);
                  var1.a(var2.k.f, var4);
                  var2.a = 2;
                  var2.b = 2;
                  var2.c(var4, var4);
                  var2.d(0, var0.l());
               }
            } else {
               var2.i.f = var1.a(var2.i);
               var2.k.f = var1.a(var2.k);
               var5 = var2.f();
               var4 = var2.h();
               var1.a(var2.i.f, var5);
               var1.a(var2.k.f, var4 + var5);
               var2.a = 2;
            }
         }
      }
   }

   static void c(ConstraintWidgetContainer var0, LinearSystem var1, ConstraintWidget var2) {
      int var6 = 1;
      if (var2.H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
         var2.b = 1;
      } else if (var0.H != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && var2.H == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
         var2.j.f = var1.a(var2.j);
         var2.l.f = var1.a(var2.l);
         int var23 = var2.j.d;
         int var31 = var0.l() - var2.l.d;
         var1.a(var2.j.f, var23);
         var1.a(var2.l.f, var31);
         if (var2.A > 0 || var2.d() == 8) {
            var2.m.f = var1.a(var2.m);
            var1.a(var2.m.f, var2.A + var23);
         }

         var2.d(var23, var31);
         var2.b = 2;
      } else if (var2.j.c != null && var2.l.c != null) {
         if (var2.j.c.a == var0 && var2.l.c.a == var0) {
            int var30 = var2.j.d();
            int var7 = var2.l.d();
            int var21;
            if (var0.H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
               var21 = var2.l() + var30;
            } else {
               var21 = var2.l();
               var6 = var0.l();
               float var13 = var30;
               var30 = (int)((var6 - var30 - var7 - var21) * var2.F + var13 + 0.5F);
               var21 = var2.l() + var30;
            }

            var2.j.f = var1.a(var2.j);
            var2.l.f = var1.a(var2.l);
            var1.a(var2.j.f, var30);
            var1.a(var2.l.f, var21);
            if (var2.A > 0 || var2.d() == 8) {
               var2.m.f = var1.a(var2.m);
               var1.a(var2.m.f, var2.A + var30);
            }

            var2.b = 2;
            var2.d(var30, var21);
         } else {
            var2.b = 1;
         }
      } else if (var2.j.c != null && var2.j.c.a == var0) {
         int var29 = var2.j.d();
         int var20 = var2.l() + var29;
         var2.j.f = var1.a(var2.j);
         var2.l.f = var1.a(var2.l);
         var1.a(var2.j.f, var29);
         var1.a(var2.l.f, var20);
         if (var2.A > 0 || var2.d() == 8) {
            var2.m.f = var1.a(var2.m);
            var1.a(var2.m.f, var2.A + var29);
         }

         var2.b = 2;
         var2.d(var29, var20);
      } else if (var2.l.c != null && var2.l.c.a == var0) {
         var2.j.f = var1.a(var2.j);
         var2.l.f = var1.a(var2.l);
         int var19 = var0.l() - var2.l.d();
         int var28 = var19 - var2.l();
         var1.a(var2.j.f, var28);
         var1.a(var2.l.f, var19);
         if (var2.A > 0 || var2.d() == 8) {
            var2.m.f = var1.a(var2.m);
            var1.a(var2.m.f, var2.A + var28);
         }

         var2.b = 2;
         var2.d(var28, var19);
      } else if (var2.j.c != null && var2.j.c.a.b == 2) {
         SolverVariable var11 = var2.j.c.f;
         var2.j.f = var1.a(var2.j);
         var2.l.f = var1.a(var2.l);
         int var27 = (int)(var11.d + var2.j.d() + 0.5F);
         int var18 = var2.l() + var27;
         var1.a(var2.j.f, var27);
         var1.a(var2.l.f, var18);
         if (var2.A > 0 || var2.d() == 8) {
            var2.m.f = var1.a(var2.m);
            var1.a(var2.m.f, var2.A + var27);
         }

         var2.b = 2;
         var2.d(var27, var18);
      } else if (var2.l.c != null && var2.l.c.a.b == 2) {
         SolverVariable var10 = var2.l.c.f;
         var2.j.f = var1.a(var2.j);
         var2.l.f = var1.a(var2.l);
         int var17 = (int)(var10.d - var2.l.d() + 0.5F);
         int var26 = var17 - var2.l();
         var1.a(var2.j.f, var26);
         var1.a(var2.l.f, var17);
         if (var2.A > 0 || var2.d() == 8) {
            var2.m.f = var1.a(var2.m);
            var1.a(var2.m.f, var2.A + var26);
         }

         var2.b = 2;
         var2.d(var26, var17);
      } else if (var2.m.c != null && var2.m.c.a.b == 2) {
         SolverVariable var9 = var2.m.c.f;
         var2.j.f = var1.a(var2.j);
         var2.l.f = var1.a(var2.l);
         int var16 = (int)(var9.d - var2.A + 0.5F);
         int var25 = var2.l() + var16;
         var1.a(var2.j.f, var16);
         var1.a(var2.l.f, var25);
         var2.m.f = var1.a(var2.m);
         var1.a(var2.m.f, var2.A + var16);
         var2.b = 2;
         var2.d(var16, var25);
      } else {
         boolean var4;
         if (var2.m.c != null) {
            var4 = 1;
         } else {
            var4 = 0;
         }

         boolean var5;
         if (var2.j.c != null) {
            var5 = 1;
         } else {
            var5 = 0;
         }

         if (var2.l.c == null) {
            var6 = 0;
         }

         if (!var4 && !var5 && !var6) {
            if (var2 instanceof Guideline) {
               Guideline var8 = (Guideline)var2;
               if (var8.D() == 0) {
                  var2.j.f = var1.a(var2.j);
                  var2.l.f = var1.a(var2.l);
                  float var3;
                  if (var8.F() != -1) {
                     var3 = var8.F();
                  } else if (var8.G() != -1) {
                     var3 = var0.l() - var8.G();
                  } else {
                     var3 = var0.l();
                     var3 = var8.E() * var3;
                  }

                  var4 = (int)(var3 + 0.5F);
                  var1.a(var2.j.f, var4);
                  var1.a(var2.l.f, var4);
                  var2.b = 2;
                  var2.a = 2;
                  var2.d(var4, var4);
                  var2.c(0, var0.h());
               }
            } else {
               var2.j.f = var1.a(var2.j);
               var2.l.f = var1.a(var2.l);
               var5 = var2.g();
               var4 = var2.l();
               var1.a(var2.j.f, var5);
               var1.a(var2.l.f, var4 + var5);
               if (var2.A > 0 || var2.d() == 8) {
                  var2.m.f = var1.a(var2.m);
                  var1.a(var2.m.f, var5 + var2.A);
               }

               var2.b = 2;
            }
         }
      }
   }
}
