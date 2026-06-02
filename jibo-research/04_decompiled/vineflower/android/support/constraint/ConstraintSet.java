package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintSet {
   private static final int[] a = new int[]{0, 4, 8};
   private static SparseIntArray c = new SparseIntArray();
   private HashMap<Integer, ConstraintSet.Constraint> b = new HashMap<>();

   static {
      c.append(R.styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
      c.append(R.styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
      c.append(R.styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
      c.append(R.styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
      c.append(R.styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
      c.append(R.styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
      c.append(R.styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
      c.append(R.styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
      c.append(R.styleable.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
      c.append(R.styleable.ConstraintSet_layout_editor_absoluteX, 6);
      c.append(R.styleable.ConstraintSet_layout_editor_absoluteY, 7);
      c.append(R.styleable.ConstraintSet_layout_constraintGuide_begin, 17);
      c.append(R.styleable.ConstraintSet_layout_constraintGuide_end, 18);
      c.append(R.styleable.ConstraintSet_layout_constraintGuide_percent, 19);
      c.append(R.styleable.ConstraintSet_android_orientation, 27);
      c.append(R.styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
      c.append(R.styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
      c.append(R.styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
      c.append(R.styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
      c.append(R.styleable.ConstraintSet_layout_goneMarginLeft, 13);
      c.append(R.styleable.ConstraintSet_layout_goneMarginTop, 16);
      c.append(R.styleable.ConstraintSet_layout_goneMarginRight, 14);
      c.append(R.styleable.ConstraintSet_layout_goneMarginBottom, 11);
      c.append(R.styleable.ConstraintSet_layout_goneMarginStart, 15);
      c.append(R.styleable.ConstraintSet_layout_goneMarginEnd, 12);
      c.append(R.styleable.ConstraintSet_layout_constraintVertical_weight, 40);
      c.append(R.styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
      c.append(R.styleable.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
      c.append(R.styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
      c.append(R.styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
      c.append(R.styleable.ConstraintSet_layout_constraintVertical_bias, 37);
      c.append(R.styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
      c.append(R.styleable.ConstraintSet_layout_constraintLeft_creator, 60);
      c.append(R.styleable.ConstraintSet_layout_constraintTop_creator, 60);
      c.append(R.styleable.ConstraintSet_layout_constraintRight_creator, 60);
      c.append(R.styleable.ConstraintSet_layout_constraintBottom_creator, 60);
      c.append(R.styleable.ConstraintSet_layout_constraintBaseline_creator, 60);
      c.append(R.styleable.ConstraintSet_android_layout_marginLeft, 24);
      c.append(R.styleable.ConstraintSet_android_layout_marginRight, 28);
      c.append(R.styleable.ConstraintSet_android_layout_marginStart, 31);
      c.append(R.styleable.ConstraintSet_android_layout_marginEnd, 8);
      c.append(R.styleable.ConstraintSet_android_layout_marginTop, 34);
      c.append(R.styleable.ConstraintSet_android_layout_marginBottom, 2);
      c.append(R.styleable.ConstraintSet_android_layout_width, 23);
      c.append(R.styleable.ConstraintSet_android_layout_height, 21);
      c.append(R.styleable.ConstraintSet_android_visibility, 22);
      c.append(R.styleable.ConstraintSet_android_alpha, 43);
      c.append(R.styleable.ConstraintSet_android_elevation, 44);
      c.append(R.styleable.ConstraintSet_android_rotationX, 45);
      c.append(R.styleable.ConstraintSet_android_rotationY, 46);
      c.append(R.styleable.ConstraintSet_android_scaleX, 47);
      c.append(R.styleable.ConstraintSet_android_scaleY, 48);
      c.append(R.styleable.ConstraintSet_android_transformPivotX, 49);
      c.append(R.styleable.ConstraintSet_android_transformPivotY, 50);
      c.append(R.styleable.ConstraintSet_android_translationX, 51);
      c.append(R.styleable.ConstraintSet_android_translationY, 52);
      c.append(R.styleable.ConstraintSet_android_translationZ, 53);
      c.append(R.styleable.ConstraintSet_layout_constraintWidth_default, 54);
      c.append(R.styleable.ConstraintSet_layout_constraintHeight_default, 55);
      c.append(R.styleable.ConstraintSet_layout_constraintWidth_max, 56);
      c.append(R.styleable.ConstraintSet_layout_constraintHeight_max, 57);
      c.append(R.styleable.ConstraintSet_layout_constraintWidth_min, 58);
      c.append(R.styleable.ConstraintSet_layout_constraintHeight_min, 59);
      c.append(R.styleable.ConstraintSet_android_id, 38);
   }

   private static int a(TypedArray var0, int var1, int var2) {
      int var3 = var0.getResourceId(var1, var2);
      var2 = var3;
      if (var3 == -1) {
         var2 = var0.getInt(var1, -1);
      }

      return var2;
   }

   private ConstraintSet.Constraint a(Context var1, AttributeSet var2) {
      ConstraintSet.Constraint var3 = new ConstraintSet.Constraint();
      TypedArray var4 = var1.obtainStyledAttributes(var2, R.styleable.ConstraintSet);
      this.a(var3, var4);
      var4.recycle();
      return var3;
   }

   private void a(ConstraintSet.Constraint var1, TypedArray var2) {
      int var4 = var2.getIndexCount();

      for (int var3 = 0; var3 < var4; var3++) {
         int var5 = var2.getIndex(var3);
         switch (c.get(var5)) {
            case 1:
               var1.p = a(var2, var5, var1.p);
               break;
            case 2:
               var1.D = var2.getDimensionPixelSize(var5, var1.D);
               break;
            case 3:
               var1.o = a(var2, var5, var1.o);
               break;
            case 4:
               var1.n = a(var2, var5, var1.n);
               break;
            case 5:
               var1.w = var2.getString(var5);
               break;
            case 6:
               var1.x = var2.getDimensionPixelOffset(var5, var1.x);
               break;
            case 7:
               var1.y = var2.getDimensionPixelOffset(var5, var1.y);
               break;
            case 8:
               var1.E = var2.getDimensionPixelSize(var5, var1.E);
               break;
            case 9:
               var1.n = a(var2, var5, var1.t);
               break;
            case 10:
               var1.s = a(var2, var5, var1.s);
               break;
            case 11:
               var1.K = var2.getDimensionPixelSize(var5, var1.K);
               break;
            case 12:
               var1.L = var2.getDimensionPixelSize(var5, var1.L);
               break;
            case 13:
               var1.H = var2.getDimensionPixelSize(var5, var1.H);
               break;
            case 14:
               var1.J = var2.getDimensionPixelSize(var5, var1.J);
               break;
            case 15:
               var1.M = var2.getDimensionPixelSize(var5, var1.M);
               break;
            case 16:
               var1.I = var2.getDimensionPixelSize(var5, var1.I);
               break;
            case 17:
               var1.e = var2.getDimensionPixelOffset(var5, var1.e);
               break;
            case 18:
               var1.f = var2.getDimensionPixelOffset(var5, var1.f);
               break;
            case 19:
               var1.g = var2.getFloat(var5, var1.g);
               break;
            case 20:
               var1.u = var2.getFloat(var5, var1.u);
               break;
            case 21:
               var1.c = var2.getLayoutDimension(var5, var1.c);
               break;
            case 22:
               var1.G = var2.getInt(var5, var1.G);
               var1.G = a[var1.G];
               break;
            case 23:
               var1.b = var2.getLayoutDimension(var5, var1.b);
               break;
            case 24:
               var1.A = var2.getDimensionPixelSize(var5, var1.A);
               break;
            case 25:
               var1.h = a(var2, var5, var1.h);
               break;
            case 26:
               var1.i = a(var2, var5, var1.i);
               break;
            case 27:
               var1.z = var2.getInt(var5, var1.z);
               break;
            case 28:
               var1.B = var2.getDimensionPixelSize(var5, var1.B);
               break;
            case 29:
               var1.j = a(var2, var5, var1.j);
               break;
            case 30:
               var1.k = a(var2, var5, var1.k);
               break;
            case 31:
               var1.F = var2.getDimensionPixelSize(var5, var1.F);
               break;
            case 32:
               var1.q = a(var2, var5, var1.q);
               break;
            case 33:
               var1.r = a(var2, var5, var1.r);
               break;
            case 34:
               var1.C = var2.getDimensionPixelSize(var5, var1.C);
               break;
            case 35:
               var1.m = a(var2, var5, var1.m);
               break;
            case 36:
               var1.l = a(var2, var5, var1.l);
               break;
            case 37:
               var1.v = var2.getFloat(var5, var1.v);
               break;
            case 38:
               var1.d = var2.getResourceId(var5, var1.d);
               break;
            case 39:
               var1.O = var2.getFloat(var5, var1.O);
               break;
            case 40:
               var1.N = var2.getFloat(var5, var1.N);
               break;
            case 41:
               var1.P = var2.getInt(var5, var1.P);
               break;
            case 42:
               var1.Q = var2.getInt(var5, var1.Q);
               break;
            case 43:
               var1.R = var2.getFloat(var5, var1.R);
               break;
            case 44:
               var1.S = true;
               var1.T = var2.getFloat(var5, var1.T);
               break;
            case 45:
               var1.U = var2.getFloat(var5, var1.U);
               break;
            case 46:
               var1.V = var2.getFloat(var5, var1.V);
               break;
            case 47:
               var1.W = var2.getFloat(var5, var1.W);
               break;
            case 48:
               var1.X = var2.getFloat(var5, var1.X);
               break;
            case 49:
               var1.Y = var2.getFloat(var5, var1.Y);
               break;
            case 50:
               var1.Z = var2.getFloat(var5, var1.Z);
               break;
            case 51:
               var1.aa = var2.getFloat(var5, var1.aa);
               break;
            case 52:
               var1.ab = var2.getFloat(var5, var1.ab);
               break;
            case 53:
               var1.ac = var2.getFloat(var5, var1.ac);
               break;
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            default:
               Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(var5) + "   " + c.get(var5));
               break;
            case 60:
               Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(var5) + "   " + c.get(var5));
         }
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public void a(Context var1, int var2) {
      XmlResourceParser var3 = var1.getResources().getXml(var2);

      try {
         var2 = var3.getEventType();
      } catch (XmlPullParserException var12) {
         var12.printStackTrace();
         return;
      } catch (IOException var13) {
         var13.printStackTrace();
         return;
      }

      while (var2 != 1) {
         switch (var2) {
            case 0:
               try {
                  var3.getName();
               } catch (XmlPullParserException var10) {
                  var10.printStackTrace();
                  return;
               } catch (IOException var11) {
                  var11.printStackTrace();
                  return;
               }
            case 1:
            case 3:
            default:
               break;
            case 2:
               ConstraintSet.Constraint var5;
               try {
                  String var4 = var3.getName();
                  var5 = this.a(var1, Xml.asAttributeSet(var3));
                  if (var4.equalsIgnoreCase("Guideline")) {
                     var5.a = true;
                  }
               } catch (XmlPullParserException var14) {
                  var14.printStackTrace();
                  return;
               } catch (IOException var15) {
                  var15.printStackTrace();
                  return;
               }

               try {
                  this.b.put(var5.d, var5);
               } catch (XmlPullParserException var8) {
                  var8.printStackTrace();
                  return;
               } catch (IOException var9) {
                  var9.printStackTrace();
                  return;
               }
         }

         try {
            var2 = var3.next();
         } catch (XmlPullParserException var6) {
            var6.printStackTrace();
            break;
         } catch (IOException var7) {
            var7.printStackTrace();
            break;
         }
      }
   }

   void a(ConstraintLayout var1) {
      int var3 = var1.getChildCount();
      HashSet var5 = new HashSet<>(this.b.keySet());

      for (int var2 = 0; var2 < var3; var2++) {
         View var7 = var1.getChildAt(var2);
         int var4 = var7.getId();
         if (this.b.containsKey(var4)) {
            var5.remove(var4);
            ConstraintSet.Constraint var8 = this.b.get(var4);
            ConstraintLayout.LayoutParams var6 = (ConstraintLayout.LayoutParams)var7.getLayoutParams();
            var8.a(var6);
            var7.setLayoutParams(var6);
            var7.setVisibility(var8.G);
            if (VERSION.SDK_INT >= 17) {
               var7.setAlpha(var8.R);
               var7.setRotationX(var8.U);
               var7.setRotationY(var8.V);
               var7.setScaleX(var8.W);
               var7.setScaleY(var8.X);
               var7.setPivotX(var8.Y);
               var7.setPivotY(var8.Z);
               var7.setTranslationX(var8.aa);
               var7.setTranslationY(var8.ab);
               if (VERSION.SDK_INT >= 21) {
                  var7.setTranslationZ(var8.ac);
                  if (var8.S) {
                     var7.setElevation(var8.T);
                  }
               }
            }
         }
      }

      for (Integer var12 : var5) {
         ConstraintSet.Constraint var11 = this.b.get(var12);
         if (var11.a) {
            Guideline var10 = new Guideline(var1.getContext());
            var10.setId(var12);
            ConstraintLayout.LayoutParams var13 = var1.b();
            var11.a(var13);
            var1.addView(var10, var13);
         }
      }
   }

   private static class Constraint {
      public int A;
      public int B;
      public int C;
      public int D;
      public int E;
      public int F;
      public int G;
      public int H;
      public int I;
      public int J;
      public int K;
      public int L;
      public int M;
      public float N;
      public float O;
      public int P;
      public int Q;
      public float R;
      public boolean S;
      public float T;
      public float U;
      public float V;
      public float W;
      public float X;
      public float Y;
      public float Z;
      boolean a = false;
      public float aa;
      public float ab;
      public float ac;
      public int ad;
      public int ae;
      public int af;
      public int ag;
      public int ah;
      public int ai;
      public int b;
      public int c;
      int d;
      public int e = -1;
      public int f = -1;
      public float g = -1.0F;
      public int h = -1;
      public int i = -1;
      public int j = -1;
      public int k = -1;
      public int l = -1;
      public int m = -1;
      public int n = -1;
      public int o = -1;
      public int p = -1;
      public int q = -1;
      public int r = -1;
      public int s = -1;
      public int t = -1;
      public float u = 0.5F;
      public float v = 0.5F;
      public String w = null;
      public int x = -1;
      public int y = -1;
      public int z = -1;

      private Constraint() {
         this.A = -1;
         this.B = -1;
         this.C = -1;
         this.D = -1;
         this.E = -1;
         this.F = -1;
         this.G = 0;
         this.H = -1;
         this.I = -1;
         this.J = -1;
         this.K = -1;
         this.L = -1;
         this.M = -1;
         this.N = 0.0F;
         this.O = 0.0F;
         this.P = 0;
         this.Q = 0;
         this.R = 1.0F;
         this.S = false;
         this.T = 0.0F;
         this.U = 0.0F;
         this.V = 0.0F;
         this.W = 1.0F;
         this.X = 1.0F;
         this.Y = 0.0F;
         this.Z = 0.0F;
         this.aa = 0.0F;
         this.ab = 0.0F;
         this.ac = 0.0F;
         this.ad = -1;
         this.ae = -1;
         this.af = -1;
         this.ag = -1;
         this.ah = -1;
         this.ai = -1;
      }

      public ConstraintSet.Constraint a() {
         ConstraintSet.Constraint var1 = new ConstraintSet.Constraint();
         var1.a = this.a;
         var1.b = this.b;
         var1.c = this.c;
         var1.e = this.e;
         var1.f = this.f;
         var1.g = this.g;
         var1.h = this.h;
         var1.i = this.i;
         var1.j = this.j;
         var1.k = this.k;
         var1.l = this.l;
         var1.m = this.m;
         var1.n = this.n;
         var1.o = this.o;
         var1.p = this.p;
         var1.q = this.q;
         var1.r = this.r;
         var1.s = this.s;
         var1.t = this.t;
         var1.u = this.u;
         var1.v = this.v;
         var1.w = this.w;
         var1.x = this.x;
         var1.y = this.y;
         var1.u = this.u;
         var1.u = this.u;
         var1.u = this.u;
         var1.u = this.u;
         var1.u = this.u;
         var1.z = this.z;
         var1.A = this.A;
         var1.B = this.B;
         var1.C = this.C;
         var1.D = this.D;
         var1.E = this.E;
         var1.F = this.F;
         var1.G = this.G;
         var1.H = this.H;
         var1.I = this.I;
         var1.J = this.J;
         var1.K = this.K;
         var1.L = this.L;
         var1.M = this.M;
         var1.N = this.N;
         var1.O = this.O;
         var1.P = this.P;
         var1.Q = this.Q;
         var1.R = this.R;
         var1.S = this.S;
         var1.T = this.T;
         var1.U = this.U;
         var1.V = this.V;
         var1.W = this.W;
         var1.X = this.X;
         var1.Y = this.Y;
         var1.Z = this.Z;
         var1.aa = this.aa;
         var1.ab = this.ab;
         var1.ac = this.ac;
         var1.ad = this.ad;
         var1.ae = this.ae;
         var1.af = this.af;
         var1.ag = this.ag;
         var1.ah = this.ah;
         var1.ai = this.ai;
         return var1;
      }

      public void a(ConstraintLayout.LayoutParams var1) {
         var1.d = this.h;
         var1.e = this.i;
         var1.f = this.j;
         var1.g = this.k;
         var1.h = this.l;
         var1.i = this.m;
         var1.j = this.n;
         var1.k = this.o;
         var1.l = this.p;
         var1.m = this.q;
         var1.n = this.r;
         var1.o = this.s;
         var1.p = this.t;
         var1.leftMargin = this.A;
         var1.rightMargin = this.B;
         var1.topMargin = this.C;
         var1.bottomMargin = this.D;
         var1.u = this.M;
         var1.v = this.L;
         var1.w = this.u;
         var1.x = this.v;
         var1.y = this.w;
         var1.L = this.x;
         var1.M = this.y;
         var1.C = this.N;
         var1.B = this.O;
         var1.E = this.Q;
         var1.D = this.P;
         var1.F = this.ad;
         var1.G = this.ae;
         var1.J = this.af;
         var1.K = this.ag;
         var1.H = this.ah;
         var1.I = this.ai;
         var1.N = this.z;
         var1.c = this.g;
         var1.a = this.e;
         var1.b = this.f;
         var1.width = this.b;
         var1.height = this.c;
         if (VERSION.SDK_INT >= 17) {
            var1.setMarginStart(this.F);
            var1.setMarginEnd(this.E);
         }

         var1.a();
      }
   }
}
