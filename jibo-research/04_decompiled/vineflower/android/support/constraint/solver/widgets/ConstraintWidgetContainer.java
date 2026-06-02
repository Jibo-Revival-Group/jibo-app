package android.support.constraint.solver.widgets;

import android.support.constraint.solver.ArrayRow;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import java.util.ArrayList;
import java.util.Arrays;

public class ConstraintWidgetContainer extends WidgetContainer {
   static boolean ac = true;
   protected LinearSystem aa = new LinearSystem();
   protected LinearSystem ab = null;
   int ad;
   int ae;
   int af;
   int ag;
   int ah;
   int ai;
   private Snapshot ak;
   private int al = 0;
   private int am = 0;
   private ConstraintWidget[] an = new ConstraintWidget[4];
   private ConstraintWidget[] ao = new ConstraintWidget[4];
   private ConstraintWidget[] ap = new ConstraintWidget[4];
   private int aq = 2;
   private boolean[] ar = new boolean[3];
   private ConstraintWidget[] as = new ConstraintWidget[4];
   private boolean at = false;
   private boolean au = false;

   private void J() {
      this.al = 0;
      this.am = 0;
   }

   private int a(LinearSystem var1, ConstraintWidget[] var2, ConstraintWidget var3, int var4, boolean[] var5) {
      var5[0] = true;
      var5[1] = false;
      var2[0] = null;
      var2[2] = null;
      var2[1] = null;
      var2[3] = null;
      int var6;
      if (var4 == 0) {
         boolean var7;
         if (var3.i.c != null && var3.i.c.a != this) {
            var7 = false;
         } else {
            var7 = true;
         }

         var3.Y = null;
         ConstraintWidget var11 = null;
         if (var3.d() != 8) {
            var11 = var3;
         }

         ConstraintWidget var12 = null;
         var6 = 0;
         ConstraintWidget var10 = var3;
         ConstraintWidget var9 = var11;

         ConstraintWidget var13;
         ConstraintWidget var14;
         label162: {
            while (var10.k.c != null) {
               var10.Y = null;
               if (var10.d() != 8) {
                  if (var9 == null) {
                     var9 = var10;
                  }

                  if (var11 != null && var11 != var10) {
                     var11.Y = var10;
                  }

                  var11 = var10;
               } else {
                  var1.c(var10.i.f, var10.i.c.f, 0, 5);
                  var1.c(var10.k.f, var10.i.f, 0, 5);
               }

               var4 = var6;
               if (var10.d() != 8) {
                  var4 = var6;
                  if (var10.G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                     if (var10.H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        var5[0] = false;
                     }

                     var4 = var6;
                     if (var10.u <= 0.0F) {
                        var5[0] = false;
                        if (var6 + 1 >= this.an.length) {
                           this.an = Arrays.copyOf(this.an, this.an.length * 2);
                        }

                        this.an[var6] = var10;
                        var4 = var6 + 1;
                     }
                  }
               }

               if (var10.k.c.a.i.c == null) {
                  var6 = var4;
                  var14 = var9;
                  var13 = var11;
                  break label162;
               }

               var13 = var11;
               var14 = var9;
               var6 = var4;
               if (var10.k.c.a.i.c.a != var10) {
                  break label162;
               }

               var13 = var11;
               var14 = var9;
               var6 = var4;
               if (var10.k.c.a == var10) {
                  break label162;
               }

               var10 = var10.k.c.a;
               var12 = var10;
               var6 = var4;
            }

            var13 = var11;
            var14 = var9;
         }

         boolean var8 = var7;
         if (var10.k.c != null) {
            var8 = var7;
            if (var10.k.c.a != this) {
               var8 = false;
            }
         }

         if (var3.i.c == null || var12.k.c == null) {
            var5[1] = true;
         }

         var3.U = var8;
         var12.Y = null;
         var2[0] = var3;
         var2[2] = var14;
         var2[1] = var12;
         var2[3] = var13;
      } else {
         boolean var17;
         if (var3.j.c != null && var3.j.c.a != this) {
            var17 = false;
         } else {
            var17 = true;
         }

         var3.Z = null;
         ConstraintWidget var21 = null;
         if (var3.d() != 8) {
            var21 = var3;
         }

         ConstraintWidget var22 = null;
         var6 = 0;
         ConstraintWidget var20 = var3;
         ConstraintWidget var19 = var21;

         ConstraintWidget var23;
         ConstraintWidget var24;
         label136: {
            while (var20.l.c != null) {
               var20.Z = null;
               if (var20.d() != 8) {
                  if (var19 == null) {
                     var19 = var20;
                  }

                  if (var21 != null && var21 != var20) {
                     var21.Z = var20;
                  }

                  var21 = var20;
               } else {
                  var1.c(var20.j.f, var20.j.c.f, 0, 5);
                  var1.c(var20.l.f, var20.j.f, 0, 5);
               }

               var4 = var6;
               if (var20.d() != 8) {
                  var4 = var6;
                  if (var20.H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                     if (var20.G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        var5[0] = false;
                     }

                     var4 = var6;
                     if (var20.u <= 0.0F) {
                        var5[0] = false;
                        if (var6 + 1 >= this.an.length) {
                           this.an = Arrays.copyOf(this.an, this.an.length * 2);
                        }

                        this.an[var6] = var20;
                        var4 = var6 + 1;
                     }
                  }
               }

               if (var20.l.c.a.j.c == null) {
                  var6 = var4;
                  var24 = var19;
                  var23 = var21;
                  break label136;
               }

               var23 = var21;
               var24 = var19;
               var6 = var4;
               if (var20.l.c.a.j.c.a != var20) {
                  break label136;
               }

               var23 = var21;
               var24 = var19;
               var6 = var4;
               if (var20.l.c.a == var20) {
                  break label136;
               }

               var20 = var20.l.c.a;
               var22 = var20;
               var6 = var4;
            }

            var23 = var21;
            var24 = var19;
         }

         boolean var18 = var17;
         if (var20.l.c != null) {
            var18 = var17;
            if (var20.l.c.a != this) {
               var18 = false;
            }
         }

         if (var3.j.c == null || var22.l.c == null) {
            var5[1] = true;
         }

         var3.V = var18;
         var22.Z = null;
         var2[0] = var3;
         var2[2] = var24;
         var2[1] = var22;
         var2[3] = var23;
      }

      return var6;
   }

   private boolean a(LinearSystem var1) {
      boolean var11 = true;
      int var10 = this.aj.size();

      for (int var2 = 0; var2 < var10; var2++) {
         ConstraintWidget var12 = this.aj.get(var2);
         var12.a = -1;
         var12.b = -1;
         if (var12.G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || var12.H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            var12.a = 1;
            var12.b = 1;
         }
      }

      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var3 = 0;

      while (!var3) {
         int var8 = 0;
         int var14 = 0;
         int var4 = 0;

         while (var8 < var10) {
            ConstraintWidget var19 = this.aj.get(var8);
            if (var19.a == -1) {
               if (this.G == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                  var19.a = 1;
               } else {
                  Optimizer.b(this, var1, var19);
               }
            }

            if (var19.b == -1) {
               if (this.H == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                  var19.b = 1;
               } else {
                  Optimizer.c(this, var1, var19);
               }
            }

            int var9 = var4;
            if (var19.b == -1) {
               var9 = var4 + 1;
            }

            if (var19.a == -1) {
               var14++;
            }

            var8++;
            var4 = var9;
         }

         if (var4 == 0 && var14 == 0) {
            var3 = 1;
         } else if (var7 == var4 && var6 == var14) {
            var3 = 1;
         }

         var5++;
         var7 = var4;
         var6 = var14;
      }

      var3 = 0;
      int var15 = 0;
      var5 = 0;

      while (var3 < var10) {
         int var17;
         label77: {
            var13 = this.aj.get(var3);
            if (var13.a != 1) {
               var17 = var5;
               if (var13.a != -1) {
                  break label77;
               }
            }

            var17 = var5 + 1;
         }

         if (var13.b == 1 || var13.b == -1) {
            var15++;
         }

         var3++;
         var5 = var17;
      }

      if (var5 != 0 || var15 != 0) {
         var11 = false;
      }

      return var11;
   }

   private void b(LinearSystem var1) {
      for (int var4 = 0; var4 < this.al; var4++) {
         ConstraintWidget var16 = this.ap[var4];
         int var7 = this.a(var1, this.as, this.ap[var4], 0, this.ar);
         ConstraintWidget var10 = this.as[2];
         if (var10 != null) {
            if (this.ar[1]) {
               int var26 = var16.n();

               while (var10 != null) {
                  var1.a(var10.i.f, var26);
                  ConstraintWidget var55 = var10.Y;
                  var26 += var10.i.d() + var10.h() + var10.k.d();
                  var10 = var55;
               }
            } else {
               boolean var5;
               if (var16.S == 0) {
                  var5 = 1;
               } else {
                  var5 = 0;
               }

               boolean var6;
               if (var16.S == 2) {
                  var6 = 1;
               } else {
                  var6 = 0;
               }

               boolean var3;
               if (this.G == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                  var3 = 1;
               } else {
                  var3 = 0;
               }

               if ((this.aq == 2 || this.aq == 8) && this.ar[0] && var16.U && !var6 && !var3 && var16.S == 0) {
                  Optimizer.a(this, var1, var7, var16);
               } else if (var7 != 0 && !var6) {
                  float var2 = 0.0F;
                  SolverVariable var62 = null;
                  ConstraintWidget var52 = var10;
                  var10 = var62;

                  while (var52 != null) {
                     if (var52.G != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        var5 = var52.i.d();
                        var3 = var5;
                        if (var10 != null) {
                           var3 = var5 + var10.k.d();
                        }

                        int var29 = 3;
                        if (var52.i.c.a.G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                           var29 = 2;
                        }

                        var1.a(var52.i.f, var52.i.c.f, var3, var29);
                        var29 = var52.k.d();
                        var3 = var29;
                        if (var52.k.c.a.i.c != null) {
                           var3 = var29;
                           if (var52.k.c.a.i.c.a == var52) {
                              var3 = var29 + var52.k.c.a.i.d();
                           }
                        }

                        byte var31 = 3;
                        if (var52.k.c.a.G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                           var31 = 2;
                        }

                        var1.b(var52.k.f, var52.k.c.f, -var3, var31);
                     } else {
                        var2 += var52.W;
                        var3 = 0;
                        if (var52.k.c != null) {
                           var5 = var52.k.d();
                           var3 = var5;
                           if (var52 != this.as[3]) {
                              var3 = var5 + var52.k.c.a.i.d();
                           }
                        }

                        var1.a(var52.k.f, var52.i.f, 0, 1);
                        var1.b(var52.k.f, var52.k.c.f, -var3, 1);
                     }

                     var62 = var52.Y;
                     var10 = var52;
                     var52 = (ConstraintWidget)var62;
                  }

                  if (var7 == 1) {
                     var10 = this.an[0];
                     var5 = var10.i.d();
                     var3 = var5;
                     if (var10.i.c != null) {
                        var3 = var5 + var10.i.c.d();
                     }

                     var6 = var10.k.d();
                     var5 = var6;
                     if (var10.k.c != null) {
                        var5 = var6 + var10.k.c.d();
                     }

                     SolverVariable var54 = var16.k.c.f;
                     if (var10 == this.as[3]) {
                        var54 = this.as[1].k.c.f;
                     }

                     if (var10.c == 1) {
                        var1.a(var16.i.f, var16.i.c.f, var3, 1);
                        var1.b(var16.k.f, var54, -var5, 1);
                        var1.c(var16.k.f, var16.i.f, var16.h(), 2);
                     } else {
                        var1.c(var10.i.f, var10.i.c.f, var3, 1);
                        var1.c(var10.k.f, var54, -var5, 1);
                     }
                  } else {
                     for (int var24 = 0; var24 < var7 - 1; var24++) {
                        ConstraintWidget var73 = this.an[var24];
                        ConstraintWidget var70 = this.an[var24 + 1];
                        SolverVariable var72 = var73.i.f;
                        var62 = var73.k.f;
                        SolverVariable var65 = var70.i.f;
                        SolverVariable var53 = var70.k.f;
                        if (var70 == this.as[3]) {
                           var53 = this.as[1].k.f;
                        }

                        var6 = var73.i.d();
                        var5 = var6;
                        if (var73.i.c != null) {
                           var5 = var6;
                           if (var73.i.c.a.k.c != null) {
                              var5 = var6;
                              if (var73.i.c.a.k.c.a == var73) {
                                 var5 = var6 + var73.i.c.a.k.d();
                              }
                           }
                        }

                        var1.a(var72, var73.i.c.f, var5, 2);
                        var6 = var73.k.d();
                        if (var73.k.c != null && var73.Y != null) {
                           if (var73.Y.i.c != null) {
                              var5 = var73.Y.i.d();
                           } else {
                              var5 = 0;
                           }

                           var5 += var6;
                        } else {
                           var5 = var6;
                        }

                        var1.b(var62, var73.k.c.f, -var5, 2);
                        if (var24 + 1 == var7 - 1) {
                           var6 = var70.i.d();
                           var5 = var6;
                           if (var70.i.c != null) {
                              var5 = var6;
                              if (var70.i.c.a.k.c != null) {
                                 var5 = var6;
                                 if (var70.i.c.a.k.c.a == var70) {
                                    var5 = var6 + var70.i.c.a.k.d();
                                 }
                              }
                           }

                           var1.a(var65, var70.i.c.f, var5, 2);
                           ConstraintAnchor var58 = var70.k;
                           if (var70 == this.as[3]) {
                              var58 = this.as[1].k;
                           }

                           var6 = var58.d();
                           var5 = var6;
                           if (var58.c != null) {
                              var5 = var6;
                              if (var58.c.a.i.c != null) {
                                 var5 = var6;
                                 if (var58.c.a.i.c.a == var70) {
                                    var5 = var6 + var58.c.a.i.d();
                                 }
                              }
                           }

                           var1.b(var53, var58.c.f, -var5, 2);
                        }

                        if (var16.f > 0) {
                           var1.b(var62, var72, var16.f, 2);
                        }

                        ArrayRow var59 = var1.b();
                        var59.a(var73.W, var2, var70.W, var72, var73.i.d(), var62, var73.k.d(), var65, var70.i.d(), var53, var70.k.d());
                        var1.a(var59);
                     }
                  }
               } else {
                  ConstraintWidget var12 = null;
                  int var19 = 0;
                  ConstraintWidget var15 = null;
                  ConstraintWidget var11 = var10;

                  while (var11 != null) {
                     ConstraintWidget var9 = var11.Y;
                     if (var9 == null) {
                        var12 = this.as[1];
                        var19 = 1;
                     }

                     if (var6) {
                        ConstraintAnchor var13 = var11.i;
                        var7 = var13.d();
                        if (var15 != null) {
                           var7 += var15.k.d();
                        }

                        byte var8 = 1;
                        if (var10 != var11) {
                           var8 = 3;
                        }

                        var1.a(var13.f, var13.c.f, var7, var8);
                        if (var11.G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                           ConstraintAnchor var14 = var11.k;
                           if (var11.c == 1) {
                              var7 = Math.max(var11.e, var11.h());
                              var1.c(var14.f, var13.f, var7, 3);
                           } else {
                              var1.a(var13.f, var13.c.f, var13.d, 3);
                              var1.b(var14.f, var13.f, var11.e, 3);
                           }
                        }
                     } else if (!var5 && var19 && var15 != null) {
                        if (var11.k.c == null) {
                           var1.a(var11.k.f, var11.q());
                        } else {
                           var7 = var11.k.d();
                           var1.c(var11.k.f, var12.k.c.f, -var7, 5);
                        }
                     } else if (var5 || var19 || var15 != null) {
                        ConstraintAnchor var18 = var11.i;
                        ConstraintAnchor var17 = var11.k;
                        int var50 = var18.d();
                        var7 = var17.d();
                        var1.a(var18.f, var18.c.f, var50, 1);
                        var1.b(var17.f, var17.c.f, -var7, 1);
                        SolverVariable var66;
                        if (var18.c != null) {
                           var66 = var18.c.f;
                        } else {
                           var66 = null;
                        }

                        SolverVariable var71 = var66;
                        if (var15 == null) {
                           if (var16.i.c != null) {
                              var66 = var16.i.c.f;
                           } else {
                              var66 = null;
                           }

                           var71 = var66;
                        }

                        if (var9 == null) {
                           if (var12.k.c != null) {
                              var9 = var12.k.c.a;
                           } else {
                              var9 = null;
                           }
                        }

                        if (var9 != null) {
                           var66 = var9.i.f;
                           if (var19) {
                              if (var12.k.c != null) {
                                 var66 = var12.k.c.f;
                              } else {
                                 var66 = null;
                              }
                           }

                           if (var71 != null && var66 != null) {
                              var1.a(var18.f, var71, var50, 0.5F, var66, var17.f, var7, 4);
                           }
                        }
                     } else if (var11.i.c == null) {
                        var1.a(var11.i.f, var11.n());
                     } else {
                        var7 = var11.i.d();
                        var1.c(var11.i.f, var16.i.c.f, var7, 5);
                     }

                     if (var19) {
                        var9 = null;
                     }

                     var15 = var11;
                     var11 = var9;
                  }

                  if (var6) {
                     ConstraintAnchor var61 = var10.i;
                     ConstraintAnchor var69 = var12.k;
                     var19 = var61.d();
                     var5 = var69.d();
                     SolverVariable var51;
                     if (var16.i.c != null) {
                        var51 = var16.i.c.f;
                     } else {
                        var51 = null;
                     }

                     SolverVariable var56;
                     if (var12.k.c != null) {
                        var56 = var12.k.c.f;
                     } else {
                        var56 = null;
                     }

                     if (var51 != null && var56 != null) {
                        var1.b(var69.f, var56, -var5, 1);
                        var1.a(var61.f, var51, var19, var16.E, var56, var69.f, var5, 4);
                     }
                  }
               }
            }
         }
      }
   }

   private void c(LinearSystem var1) {
      for (int var5 = 0; var5 < this.am; var5++) {
         ConstraintWidget var17 = this.ao[var5];
         int var8 = this.a(var1, this.as, this.ao[var5], 1, this.ar);
         ConstraintWidget var11 = this.as[2];
         if (var11 != null) {
            if (this.ar[1]) {
               int var27 = var17.o();

               while (var11 != null) {
                  var1.a(var11.j.f, var27);
                  ConstraintWidget var57 = var11.Z;
                  var27 += var11.j.d() + var11.l() + var11.l.d();
                  var11 = var57;
               }
            } else {
               boolean var6;
               if (var17.T == 0) {
                  var6 = 1;
               } else {
                  var6 = 0;
               }

               boolean var7;
               if (var17.T == 2) {
                  var7 = true;
               } else {
                  var7 = false;
               }

               boolean var3;
               if (this.H == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                  var3 = 1;
               } else {
                  var3 = 0;
               }

               if ((this.aq == 2 || this.aq == 8) && this.ar[0] && var17.V && !var7 && !var3 && var17.T == 0) {
                  Optimizer.b(this, var1, var8, var17);
               } else if (var8 != 0 && !var7) {
                  float var2 = 0.0F;
                  ConstraintWidget var64 = null;
                  ConstraintWidget var54 = var11;
                  var11 = var64;

                  while (var54 != null) {
                     if (var54.H != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        int var33 = var54.j.d();
                        var3 = var33;
                        if (var11 != null) {
                           var3 = var33 + var11.l.d();
                        }

                        int var34 = 3;
                        if (var54.j.c.a.H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                           var34 = 2;
                        }

                        var1.a(var54.j.f, var54.j.c.f, var3, var34);
                        var34 = var54.l.d();
                        var3 = var34;
                        if (var54.l.c.a.j.c != null) {
                           var3 = var34;
                           if (var54.l.c.a.j.c.a == var54) {
                              var3 = var34 + var54.l.c.a.j.d();
                           }
                        }

                        byte var36 = 3;
                        if (var54.l.c.a.H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                           var36 = 2;
                        }

                        var1.b(var54.l.f, var54.l.c.f, -var3, var36);
                     } else {
                        var2 += var54.X;
                        var3 = 0;
                        if (var54.l.c != null) {
                           int var37 = var54.l.d();
                           var3 = var37;
                           if (var54 != this.as[3]) {
                              var3 = var37 + var54.l.c.a.j.d();
                           }
                        }

                        var1.a(var54.l.f, var54.j.f, 0, 1);
                        var1.b(var54.l.f, var54.l.c.f, -var3, 1);
                     }

                     var64 = var54.Z;
                     var11 = var54;
                     var54 = (ConstraintWidget)var64;
                  }

                  if (var8 == 1) {
                     var11 = this.an[0];
                     int var43 = var11.j.d();
                     var3 = var43;
                     if (var11.j.c != null) {
                        var3 = var43 + var11.j.c.d();
                     }

                     var6 = var11.l.d();
                     var43 = var6;
                     if (var11.l.c != null) {
                        var43 = var6 + var11.l.c.d();
                     }

                     SolverVariable var56 = var17.l.c.f;
                     if (var11 == this.as[3]) {
                        var56 = this.as[1].l.c.f;
                     }

                     if (var11.d == 1) {
                        var1.a(var17.j.f, var17.j.c.f, var3, 1);
                        var1.b(var17.l.f, var56, -var43, 1);
                        var1.c(var17.l.f, var17.j.f, var17.l(), 2);
                     } else {
                        var1.c(var11.j.f, var11.j.c.f, var3, 1);
                        var1.c(var11.l.f, var56, -var43, 1);
                     }
                  } else {
                     for (int var25 = 0; var25 < var8 - 1; var25++) {
                        ConstraintWidget var67 = this.an[var25];
                        var64 = this.an[var25 + 1];
                        SolverVariable var76 = var67.j.f;
                        SolverVariable var73 = var67.l.f;
                        SolverVariable var75 = var64.j.f;
                        SolverVariable var55 = var64.l.f;
                        if (var64 == this.as[3]) {
                           var55 = this.as[1].l.f;
                        }

                        var6 = var67.j.d();
                        int var38 = var6;
                        if (var67.j.c != null) {
                           var38 = var6;
                           if (var67.j.c.a.l.c != null) {
                              var38 = var6;
                              if (var67.j.c.a.l.c.a == var67) {
                                 var38 = var6 + var67.j.c.a.l.d();
                              }
                           }
                        }

                        var1.a(var76, var67.j.c.f, var38, 2);
                        var6 = var67.l.d();
                        if (var67.l.c != null && var67.Z != null) {
                           if (var67.Z.j.c != null) {
                              var38 = var67.Z.j.d();
                           } else {
                              var38 = 0;
                           }

                           var38 += var6;
                        } else {
                           var38 = var6;
                        }

                        var1.b(var73, var67.l.c.f, -var38, 2);
                        if (var25 + 1 == var8 - 1) {
                           var6 = var64.j.d();
                           var38 = var6;
                           if (var64.j.c != null) {
                              var38 = var6;
                              if (var64.j.c.a.l.c != null) {
                                 var38 = var6;
                                 if (var64.j.c.a.l.c.a == var64) {
                                    var38 = var6 + var64.j.c.a.l.d();
                                 }
                              }
                           }

                           var1.a(var75, var64.j.c.f, var38, 2);
                           ConstraintAnchor var60 = var64.l;
                           if (var64 == this.as[3]) {
                              var60 = this.as[1].l;
                           }

                           var6 = var60.d();
                           var38 = var6;
                           if (var60.c != null) {
                              var38 = var6;
                              if (var60.c.a.j.c != null) {
                                 var38 = var6;
                                 if (var60.c.a.j.c.a == var64) {
                                    var38 = var6 + var60.c.a.j.d();
                                 }
                              }
                           }

                           var1.b(var55, var60.c.f, -var38, 2);
                        }

                        if (var17.h > 0) {
                           var1.b(var73, var76, var17.h, 2);
                        }

                        ArrayRow var61 = var1.b();
                        var61.a(var67.X, var2, var64.X, var76, var67.j.d(), var73, var67.l.d(), var75, var64.j.d(), var55, var64.l.d());
                        var1.a(var61);
                     }
                  }
               } else {
                  ConstraintWidget var13 = null;
                  int var20 = 0;
                  ConstraintWidget var16 = null;
                  ConstraintWidget var12 = var11;

                  while (var12 != null) {
                     ConstraintWidget var10 = var12.Z;
                     if (var10 == null) {
                        var13 = this.as[1];
                        var20 = 1;
                     }

                     if (var7) {
                        ConstraintAnchor var18 = var12.j;
                        var8 = var18.d();
                        int var4 = var8;
                        if (var16 != null) {
                           var4 = var8 + var16.l.d();
                        }

                        byte var51 = 1;
                        if (var11 != var12) {
                           var51 = 3;
                        }

                        SolverVariable var15 = null;
                        SolverVariable var14 = null;
                        int var9;
                        if (var18.c != null) {
                           var15 = var18.f;
                           var14 = var18.c.f;
                           var9 = var4;
                        } else {
                           var9 = var4;
                           if (var12.m.c != null) {
                              var15 = var12.m.f;
                              var14 = var12.m.c.f;
                              var9 = var4 - var18.d();
                           }
                        }

                        if (var15 != null && var14 != null) {
                           var1.a(var15, var14, var9, var51);
                        }

                        if (var12.H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                           ConstraintAnchor var68 = var12.l;
                           if (var12.d == 1) {
                              var4 = Math.max(var12.g, var12.l());
                              var1.c(var68.f, var18.f, var4, 3);
                           } else {
                              var1.a(var18.f, var18.c.f, var18.d, 3);
                              var1.b(var68.f, var18.f, var12.g, 3);
                           }
                        }
                     } else if (!var6 && var20 && var16 != null) {
                        if (var12.l.c == null) {
                           var1.a(var12.l.f, var12.p());
                        } else {
                           int var31 = var12.l.d();
                           var1.c(var12.l.f, var13.l.c.f, -var31, 5);
                        }
                     } else if (var6 || var20 || var16 != null) {
                        ConstraintAnchor var77 = var12.j;
                        ConstraintAnchor var19 = var12.l;
                        int var30 = var77.d();
                        var8 = var19.d();
                        var1.a(var77.f, var77.c.f, var30, 1);
                        var1.b(var19.f, var19.c.f, -var8, 1);
                        SolverVariable var69;
                        if (var77.c != null) {
                           var69 = var77.c.f;
                        } else {
                           var69 = null;
                        }

                        SolverVariable var74 = var69;
                        if (var16 == null) {
                           if (var17.j.c != null) {
                              var69 = var17.j.c.f;
                           } else {
                              var69 = null;
                           }

                           var74 = var69;
                        }

                        if (var10 == null) {
                           if (var13.l.c != null) {
                              var10 = var13.l.c.a;
                           } else {
                              var10 = null;
                           }
                        }

                        if (var10 != null) {
                           var69 = var10.j.f;
                           if (var20) {
                              if (var13.l.c != null) {
                                 var69 = var13.l.c.f;
                              } else {
                                 var69 = null;
                              }
                           }

                           if (var74 != null && var69 != null) {
                              var1.a(var77.f, var74, var30, 0.5F, var69, var19.f, var8, 4);
                           }
                        }
                     } else if (var12.j.c == null) {
                        var1.a(var12.j.f, var12.o());
                     } else {
                        int var29 = var12.j.d();
                        var1.c(var12.j.f, var17.j.c.f, var29, 5);
                     }

                     if (var20) {
                        var10 = null;
                     }

                     var16 = var12;
                     var12 = var10;
                  }

                  if (var7) {
                     ConstraintAnchor var63 = var11.j;
                     ConstraintAnchor var72 = var13.l;
                     var20 = var63.d();
                     int var32 = var72.d();
                     SolverVariable var53;
                     if (var17.j.c != null) {
                        var53 = var17.j.c.f;
                     } else {
                        var53 = null;
                     }

                     SolverVariable var58;
                     if (var13.l.c != null) {
                        var58 = var13.l.c.f;
                     } else {
                        var58 = null;
                     }

                     if (var53 != null && var58 != null) {
                        var1.b(var72.f, var58, -var32, 1);
                        var1.a(var63.f, var53, var20, var17.F, var58, var72.f, var32, 4);
                     }
                  }
               }
            }
         }
      }
   }

   private void d(ConstraintWidget var1) {
      int var2 = 0;

      while (true) {
         if (var2 >= this.al) {
            if (this.al + 1 >= this.ap.length) {
               this.ap = Arrays.copyOf(this.ap, this.ap.length * 2);
            }

            this.ap[this.al] = var1;
            this.al++;
            break;
         }

         if (this.ap[var2] == var1) {
            break;
         }

         var2++;
      }
   }

   private void e(ConstraintWidget var1) {
      int var2 = 0;

      while (true) {
         if (var2 >= this.am) {
            if (this.am + 1 >= this.ao.length) {
               this.ao = Arrays.copyOf(this.ao, this.ao.length * 2);
            }

            this.ao[this.am] = var1;
            this.am++;
            break;
         }

         if (this.ao[var2] == var1) {
            break;
         }

         var2++;
      }
   }

   public boolean D() {
      return this.at;
   }

   public boolean E() {
      return this.au;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public void F() {
      int var8 = this.w;
      int var5 = this.x;
      int var7 = Math.max(0, this.h());
      int var9 = Math.max(0, this.l());
      this.at = false;
      this.au = false;
      if (this.r != null) {
         if (this.ak == null) {
            this.ak = new Snapshot(this);
         }

         this.ak.a(this);
         this.b(this.af);
         this.c(this.ag);
         this.A();
         this.a(this.aa.f());
      } else {
         this.w = 0;
         this.x = 0;
      }

      ConstraintWidget.DimensionBehaviour var17;
      ConstraintWidget.DimensionBehaviour var18;
      boolean var32;
      label205: {
         boolean var12;
         var32 = false;
         var18 = this.H;
         var17 = this.G;
         var12 = var32;
         label204:
         if (this.aq == 2) {
            if (this.H != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
               var12 = var32;
               if (this.G != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                  break label204;
               }
            }

            this.a(this.aj, this.ar);
            var12 = this.ar[0];
            var32 = var12;
            if (var7 > 0) {
               var32 = var12;
               label195:
               if (var9 > 0) {
                  if (this.ad <= var7) {
                     var32 = var12;
                     if (this.ae <= var9) {
                        break label195;
                     }
                  }

                  var32 = false;
               }
            }

            var12 = var32;
            if (var32) {
               if (this.G == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                  this.G = ConstraintWidget.DimensionBehaviour.FIXED;
                  if (var7 > 0 && var7 < this.ad) {
                     this.at = true;
                     this.d(var7);
                  } else {
                     this.d(Math.max(this.B, this.ad));
                  }
               }

               var12 = var32;
               if (this.H == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                  this.H = ConstraintWidget.DimensionBehaviour.FIXED;
                  if (var9 > 0 && var9 < this.ae) {
                     this.au = true;
                     this.e(var9);
                     break label205;
                  }

                  this.e(Math.max(this.C, this.ae));
                  var12 = var32;
               }
            }
         }

         var32 = var12;
      }

      this.J();
      int var6 = this.aj.size();

      for (int var1 = 0; var1 < var6; var1++) {
         ConstraintWidget var19 = this.aj.get(var1);
         if (var19 instanceof WidgetContainer) {
            ((WidgetContainer)var19).F();
         }
      }

      int var23 = 0;
      boolean var35 = true;

      while (var35) {
         int var4 = var23 + 1;
         boolean var13 = var35;

         label214: {
            try {
               this.aa.a();
            } catch (Exception var22) {
               var22.printStackTrace();
               break label214;
            }

            var13 = var35;

            try {
               var35 = this.c(this.aa, Integer.MAX_VALUE);
            } catch (Exception var21) {
               var21.printStackTrace();
               break label214;
            }

            var13 = var35;
            label159:
            if (var35) {
               var13 = var35;

               try {
                  this.aa.e();
               } catch (Exception var20) {
                  var20.printStackTrace();
                  break label159;
               }

               var13 = var35;
            }
         }

         if (var13) {
            this.a(this.aa, Integer.MAX_VALUE, this.ar);
         } else {
            this.b(this.aa, Integer.MAX_VALUE);

            for (int var24 = 0; var24 < var6; var24++) {
               ConstraintWidget var43 = this.aj.get(var24);
               if (var43.G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && var43.h() < var43.k()) {
                  this.ar[2] = true;
                  break;
               }

               if (var43.H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && var43.l() < var43.m()) {
                  this.ar[2] = true;
                  break;
               }
            }
         }

         if (var4 < 8 && this.ar[2]) {
            int var3 = 0;
            var23 = 0;

            for (int var2 = 0; var2 < var6; var2++) {
               ConstraintWidget var44 = this.aj.get(var2);
               var3 = Math.max(var3, var44.w + var44.h());
               int var10 = var44.x;
               var23 = Math.max(var23, var44.l() + var10);
            }

            int var30 = Math.max(this.B, var3);
            var23 = Math.max(this.C, var23);
            boolean var14;
            if (var17 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && this.h() < var30) {
               this.d(var30);
               this.G = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
               var14 = true;
               var13 = true;
            } else {
               var13 = false;
               var14 = var32;
            }

            var35 = var13;
            var32 = var14;
            if (var18 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
               var35 = var13;
               var32 = var14;
               if (this.l() < var23) {
                  this.e(var23);
                  this.H = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                  var32 = true;
                  var35 = true;
               }
            }
         } else {
            var35 = false;
         }

         var23 = Math.max(this.B, this.h());
         var13 = var35;
         var35 = var32;
         if (var23 > this.h()) {
            this.d(var23);
            this.G = ConstraintWidget.DimensionBehaviour.FIXED;
            var35 = true;
            var13 = true;
         }

         var23 = Math.max(this.C, this.l());
         var32 = var13;
         if (var23 > this.l()) {
            this.e(var23);
            this.H = ConstraintWidget.DimensionBehaviour.FIXED;
            var35 = true;
            var32 = true;
         }

         boolean var42 = var32;
         var13 = var35;
         if (!var35) {
            boolean var16 = var32;
            boolean var15 = var35;
            if (this.G == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
               var16 = var32;
               var15 = var35;
               if (var7 > 0) {
                  var16 = var32;
                  var15 = var35;
                  if (this.h() > var7) {
                     this.at = true;
                     var15 = true;
                     this.G = ConstraintWidget.DimensionBehaviour.FIXED;
                     this.d(var7);
                     var16 = true;
                  }
               }
            }

            var42 = var16;
            var13 = var15;
            if (this.H == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
               var42 = var16;
               var13 = var15;
               if (var9 > 0) {
                  var42 = var16;
                  var13 = var15;
                  if (this.l() > var9) {
                     this.au = true;
                     var13 = true;
                     this.H = ConstraintWidget.DimensionBehaviour.FIXED;
                     this.e(var9);
                     var42 = true;
                  }
               }
            }
         }

         var32 = var13;
         var35 = var42;
         var23 = var4;
      }

      if (this.r != null) {
         var23 = Math.max(this.B, this.h());
         int var31 = Math.max(this.C, this.l());
         this.ak.b(this);
         this.d(var23 + this.af + this.ah);
         this.e(this.ag + var31 + this.ai);
      } else {
         this.w = var8;
         this.x = var5;
      }

      if (var32) {
         this.G = var17;
         this.H = var18;
      }

      this.a(this.aa.f());
      if (this == this.H()) {
         this.z();
      }
   }

   public boolean G() {
      return false;
   }

   @Override
   public void a() {
      this.aa.a();
      this.af = 0;
      this.ah = 0;
      this.ag = 0;
      this.ai = 0;
      super.a();
   }

   public void a(LinearSystem var1, int var2, boolean[] var3) {
      var3[2] = false;
      this.b(var1, var2);
      int var5 = this.aj.size();

      for (int var4 = 0; var4 < var5; var4++) {
         ConstraintWidget var6 = this.aj.get(var4);
         var6.b(var1, var2);
         if (var6.G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && var6.h() < var6.k()) {
            var3[2] = true;
         }

         if (var6.H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && var6.l() < var6.m()) {
            var3[2] = true;
         }
      }
   }

   void a(ConstraintWidget var1, int var2) {
      if (var2 != 0) {
         if (var2 == 1) {
            while (var1.j.c != null && var1.j.c.a.l.c != null && var1.j.c.a.l.c == var1.j && var1.j.c.a != var1) {
               var1 = var1.j.c.a;
            }

            this.e(var1);
         }
      } else {
         while (var1.i.c != null && var1.i.c.a.k.c != null && var1.i.c.a.k.c == var1.i && var1.i.c.a != var1) {
            var1 = var1.i.c.a;
         }

         this.d(var1);
      }
   }

   public void a(ConstraintWidget var1, boolean[] var2) {
      ConstraintWidget var11 = null;
      boolean var9 = false;
      int var4 = 0;
      if (var1.G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && var1.H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && var1.u > 0.0F) {
         var2[0] = false;
      } else {
         int var3 = var1.i();
         if (var1.G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && var1.H != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && var1.u > 0.0F) {
            var2[0] = false;
         } else {
            var1.Q = true;
            int var23;
            if (var1 instanceof Guideline) {
               Guideline var13 = (Guideline)var1;
               if (var13.D() == 1) {
                  if (var13.F() != -1) {
                     var3 = var13.F();
                  } else if (var13.G() != -1) {
                     var4 = var13.G();
                     var3 = 0;
                  } else {
                     var3 = 0;
                  }
               } else {
                  int var21 = var3;
                  var4 = var3;
                  var3 = var21;
               }

               var23 = var4;
            } else if (!var1.k.j() && !var1.i.j()) {
               var4 = var1.f();
               var23 = var3;
               var3 = var4 + var3;
            } else {
               if (var1.k.c != null && var1.i.c != null && (var1.k.c == var1.i.c || var1.k.c.a == var1.i.c.a && var1.k.c.a != var1.r)) {
                  var2[0] = false;
                  return;
               }

               ConstraintWidget var10;
               if (var1.k.c != null) {
                  ConstraintWidget var12 = var1.k.c.a;
                  var4 = var1.k.d() + var3;
                  var10 = var12;
                  var23 = var4;
                  if (!var12.b()) {
                     var10 = var12;
                     var23 = var4;
                     if (!var12.Q) {
                        this.a(var12, var2);
                        var23 = var4;
                        var10 = var12;
                     }
                  }
               } else {
                  var10 = null;
                  var23 = var3;
               }

               var4 = var3;
               if (var1.i.c != null) {
                  ConstraintWidget var25 = var1.i.c.a;
                  var3 += var1.i.d();
                  var4 = var3;
                  var11 = var25;
                  if (!var25.b()) {
                     var4 = var3;
                     var11 = var25;
                     if (!var25.Q) {
                        this.a(var25, var2);
                        var11 = var25;
                        var4 = var3;
                     }
                  }
               }

               int var5 = var23;
               if (var1.k.c != null) {
                  var5 = var23;
                  if (!var10.b()) {
                     if (var1.k.c.b == ConstraintAnchor.Type.RIGHT) {
                        var3 = var23 + (var10.K - var10.i());
                     } else {
                        var3 = var23;
                        if (var1.k.c.c() == ConstraintAnchor.Type.LEFT) {
                           var3 = var23 + var10.K;
                        }
                     }

                     boolean var8;
                     if (!var10.N && (var10.i.c == null || var10.k.c == null || var10.G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) {
                        var8 = false;
                     } else {
                        var8 = true;
                     }

                     var1.N = var8;
                     var5 = var3;
                     label115:
                     if (var1.N) {
                        if (var10.i.c != null) {
                           var5 = var3;
                           if (var10.i.c.a == var1) {
                              break label115;
                           }
                        }

                        var5 = var3 + (var3 - var10.K);
                     }
                  }
               }

               var3 = var4;
               var23 = var5;
               if (var1.i.c != null) {
                  var3 = var4;
                  var23 = var5;
                  if (!var11.b()) {
                     int var7;
                     if (var1.i.c.c() == ConstraintAnchor.Type.LEFT) {
                        var7 = var4 + (var11.J - var11.i());
                     } else {
                        var7 = var4;
                        if (var1.i.c.c() == ConstraintAnchor.Type.RIGHT) {
                           var7 = var4 + var11.J;
                        }
                     }

                     boolean var24;
                     label106: {
                        if (!var11.M) {
                           var24 = var9;
                           if (var11.i.c == null) {
                              break label106;
                           }

                           var24 = var9;
                           if (var11.k.c == null) {
                              break label106;
                           }

                           var24 = var9;
                           if (var11.G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                              break label106;
                           }
                        }

                        var24 = true;
                     }

                     var1.M = var24;
                     var3 = var7;
                     var23 = var5;
                     label98:
                     if (var1.M) {
                        if (var11.k.c != null) {
                           var3 = var7;
                           var23 = var5;
                           if (var11.k.c.a == var1) {
                              break label98;
                           }
                        }

                        var3 = var7 + (var7 - var11.J);
                        var23 = var5;
                     }
                  }
               }
            }

            int var22 = var3;
            var4 = var23;
            if (var1.d() == 8) {
               var22 = var3 - var1.s;
               var4 = var23 - var1.s;
            }

            var1.J = var22;
            var1.K = var4;
         }
      }
   }

   public void a(ArrayList<ConstraintWidget> var1, boolean[] var2) {
      int var3 = 0;
      int var7 = 0;
      int var8 = 0;
      int var6 = 0;
      int var5 = 0;
      int var4 = 0;
      int var12 = var1.size();
      var2[0] = true;
      int var11 = 0;

      while (var11 < var12) {
         ConstraintWidget var13 = (ConstraintWidget)var1.get(var11);
         if (var13.b()) {
            int var9 = var4;
            var4 = var5;
            var5 = var8;
            var8 = var7;
            var7 = var3;
            var3 = var9;
         } else {
            if (!var13.Q) {
               this.a(var13, var2);
            }

            if (!var13.R) {
               this.b(var13, var2);
            }

            if (!var2[0]) {
               return;
            }

            int var27 = var13.J + var13.K - var13.h();
            int var10 = var13.I + var13.L - var13.l();
            if (var13.G == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
               var27 = var13.h() + var13.i.d + var13.k.d;
            }

            if (var13.H == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
               var10 = var13.l() + var13.j.d + var13.l.d;
            }

            if (var13.d() == 8) {
               var27 = 0;
               var10 = 0;
            }

            var7 = Math.max(var7, var13.J);
            var8 = Math.max(var8, var13.K);
            var6 = Math.max(var6, var13.L);
            var3 = Math.max(var3, var13.I);
            var27 = Math.max(var5, var27);
            var4 = Math.max(var4, var10);
            var5 = var8;
            var8 = var7;
            var7 = var3;
            var3 = var4;
            var4 = var27;
         }

         var11++;
         int var30 = var8;
         int var29 = var7;
         var8 = var5;
         var5 = var4;
         var4 = var3;
         var7 = var30;
         var3 = var29;
      }

      var7 = Math.max(var7, var8);
      this.ad = Math.max(this.B, Math.max(var7, var5));
      var3 = Math.max(var3, var6);
      this.ae = Math.max(this.C, Math.max(var3, var4));

      for (int var18 = 0; var18 < var12; var18++) {
         ConstraintWidget var14 = (ConstraintWidget)var1.get(var18);
         var14.Q = false;
         var14.R = false;
         var14.M = false;
         var14.N = false;
         var14.O = false;
         var14.P = false;
      }
   }

   public void b(ConstraintWidget var1, boolean[] var2) {
      ConstraintWidget var11 = null;
      boolean var9 = false;
      int var4 = 0;
      if (var1.H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && var1.G != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && var1.u > 0.0F) {
         var2[0] = false;
      } else {
         int var3 = var1.j();
         var1.R = true;
         int var24;
         if (var1 instanceof Guideline) {
            Guideline var13 = (Guideline)var1;
            if (var13.D() == 0) {
               if (var13.F() != -1) {
                  var4 = var13.F();
                  var3 = 0;
               } else if (var13.G() != -1) {
                  var3 = var13.G();
               } else {
                  var3 = 0;
               }
            } else {
               int var22 = var3;
               var4 = var3;
               var3 = var22;
            }

            var24 = var4;
         } else if (var1.m.c == null && var1.j.c == null && var1.l.c == null) {
            var24 = var3 + var1.g();
         } else {
            if (var1.l.c != null && var1.j.c != null && (var1.l.c == var1.j.c || var1.l.c.a == var1.j.c.a && var1.l.c.a != var1.r)) {
               var2[0] = false;
               return;
            }

            if (var1.m.j()) {
               ConstraintWidget var27 = var1.m.c.b();
               if (!var27.R) {
                  this.b(var27, var2);
               }

               var24 = Math.max(var27.I - var27.t + var3, var3);
               int var21 = Math.max(var27.L - var27.t + var3, var3);
               var4 = var21;
               var3 = var24;
               if (var1.d() == 8) {
                  var3 = var24 - var1.t;
                  var4 = var21 - var1.t;
               }

               var1.I = var3;
               var1.L = var4;
               return;
            }

            ConstraintWidget var10;
            if (var1.j.j()) {
               ConstraintWidget var12 = var1.j.c.b();
               var4 = var1.j.d() + var3;
               var10 = var12;
               var24 = var4;
               if (!var12.b()) {
                  var10 = var12;
                  var24 = var4;
                  if (!var12.R) {
                     this.b(var12, var2);
                     var24 = var4;
                     var10 = var12;
                  }
               }
            } else {
               var10 = null;
               var24 = var3;
            }

            var4 = var3;
            if (var1.l.j()) {
               ConstraintWidget var28 = var1.l.c.b();
               var3 += var1.l.d();
               var4 = var3;
               var11 = var28;
               if (!var28.b()) {
                  var4 = var3;
                  var11 = var28;
                  if (!var28.R) {
                     this.b(var28, var2);
                     var11 = var28;
                     var4 = var3;
                  }
               }
            }

            int var5 = var24;
            if (var1.j.c != null) {
               var5 = var24;
               if (!var10.b()) {
                  if (var1.j.c.c() == ConstraintAnchor.Type.TOP) {
                     var3 = var24 + (var10.I - var10.j());
                  } else {
                     var3 = var24;
                     if (var1.j.c.c() == ConstraintAnchor.Type.BOTTOM) {
                        var3 = var24 + var10.I;
                     }
                  }

                  boolean var8;
                  if (!var10.O
                     && (
                        var10.j.c == null
                           || var10.j.c.a == var1
                           || var10.l.c == null
                           || var10.l.c.a == var1
                           || var10.H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
                     )) {
                     var8 = false;
                  } else {
                     var8 = true;
                  }

                  var1.O = var8;
                  var5 = var3;
                  label130:
                  if (var1.O) {
                     if (var10.l.c != null) {
                        var5 = var3;
                        if (var10.l.c.a == var1) {
                           break label130;
                        }
                     }

                     var5 = var3 + (var3 - var10.I);
                  }
               }
            }

            var3 = var4;
            var24 = var5;
            if (var1.l.c != null) {
               var3 = var4;
               var24 = var5;
               if (!var11.b()) {
                  int var7;
                  if (var1.l.c.c() == ConstraintAnchor.Type.BOTTOM) {
                     var7 = var4 + (var11.L - var11.j());
                  } else {
                     var7 = var4;
                     if (var1.l.c.c() == ConstraintAnchor.Type.TOP) {
                        var7 = var4 + var11.L;
                     }
                  }

                  boolean var26;
                  label121: {
                     if (!var11.P) {
                        var26 = var9;
                        if (var11.j.c == null) {
                           break label121;
                        }

                        var26 = var9;
                        if (var11.j.c.a == var1) {
                           break label121;
                        }

                        var26 = var9;
                        if (var11.l.c == null) {
                           break label121;
                        }

                        var26 = var9;
                        if (var11.l.c.a == var1) {
                           break label121;
                        }

                        var26 = var9;
                        if (var11.H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                           break label121;
                        }
                     }

                     var26 = true;
                  }

                  var1.P = var26;
                  var3 = var7;
                  var24 = var5;
                  label109:
                  if (var1.P) {
                     if (var11.j.c != null) {
                        var3 = var7;
                        var24 = var5;
                        if (var11.j.c.a == var1) {
                           break label109;
                        }
                     }

                     var3 = var7 + (var7 - var11.L);
                     var24 = var5;
                  }
               }
            }
         }

         int var23 = var3;
         var4 = var24;
         if (var1.d() == 8) {
            var4 = var24 - var1.t;
            var23 = var3 - var1.t;
         }

         var1.I = var4;
         var1.L = var23;
      }
   }

   public boolean c(LinearSystem var1, int var2) {
      boolean var6 = false;
      this.a(var1, var2);
      int var5 = this.aj.size();
      boolean var3;
      if (this.aq != 2 && this.aq != 4) {
         var3 = true;
      } else {
         if (this.a(var1)) {
            return var6;
         }

         var3 = false;
      }

      for (int var4 = 0; var4 < var5; var4++) {
         ConstraintWidget var9 = this.aj.get(var4);
         if (var9 instanceof ConstraintWidgetContainer) {
            ConstraintWidget.DimensionBehaviour var8 = var9.G;
            ConstraintWidget.DimensionBehaviour var7 = var9.H;
            if (var8 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
               var9.a(ConstraintWidget.DimensionBehaviour.FIXED);
            }

            if (var7 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
               var9.b(ConstraintWidget.DimensionBehaviour.FIXED);
            }

            var9.a(var1, var2);
            if (var8 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
               var9.a(var8);
            }

            if (var7 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
               var9.b(var7);
            }
         } else {
            if (var3) {
               Optimizer.a(this, var1, var9);
            }

            var9.a(var1, var2);
         }
      }

      if (this.al > 0) {
         this.b(var1);
      }

      if (this.am > 0) {
         this.c(var1);
      }

      return true;
   }

   public void m(int var1) {
      this.aq = var1;
   }
}
