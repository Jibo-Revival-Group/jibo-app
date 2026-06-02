package android.support.v4.graphics;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

public class PathParser {
   private static int a(String var0, int var1) {
      while (var1 < var0.length()) {
         char var2 = var0.charAt(var1);
         if ((var2 - 'A') * (var2 - 'Z') > 0 && (var2 - 'a') * (var2 - 'z') > 0 || var2 == 'e' || var2 == 'E') {
            var1++;
            continue;
         }
         break;
      }

      return var1;
   }

   public static Path a(String var0) {
      Path var1 = new Path();
      PathParser.PathDataNode[] var2 = b(var0);
      Path var4;
      if (var2 != null) {
         try {
            PathParser.PathDataNode.a(var2, var1);
         } catch (RuntimeException var3) {
            throw new RuntimeException("Error in parsing " + var0, var3);
         }

         var4 = var1;
      } else {
         var4 = null;
      }

      return var4;
   }

   private static void a(String var0, int var1, PathParser.ExtractFloatResult var2) {
      var2.b = false;
      boolean var3 = false;
      boolean var6 = false;
      boolean var4 = false;

      int var5;
      for (var5 = var1; var5 < var0.length(); var5++) {
         switch (var0.charAt(var5)) {
            case ' ':
            case ',':
               var3 = false;
               var4 = true;
               break;
            case '-':
               if (var5 != var1 && !var3) {
                  var2.b = true;
                  var3 = false;
                  var4 = true;
                  break;
               }
            default:
               var3 = false;
               break;
            case '.':
               if (!var6) {
                  var3 = false;
                  var6 = true;
               } else {
                  var2.b = true;
                  var3 = false;
                  var4 = true;
               }
               break;
            case 'E':
            case 'e':
               var3 = true;
         }

         if (var4) {
            break;
         }
      }

      var2.a = var5;
   }

   private static void a(ArrayList<PathParser.PathDataNode> var0, char var1, float[] var2) {
      var0.add(new PathParser.PathDataNode(var1, var2));
   }

   public static boolean a(PathParser.PathDataNode[] var0, PathParser.PathDataNode[] var1) {
      boolean var4 = false;
      boolean var3 = var4;
      if (var0 != null) {
         if (var1 == null) {
            var3 = var4;
         } else {
            var3 = var4;
            if (var0.length == var1.length) {
               int var2 = 0;

               while (true) {
                  if (var2 >= var0.length) {
                     var3 = true;
                     break;
                  }

                  var3 = var4;
                  if (var0[var2].a != var1[var2].a) {
                     break;
                  }

                  var3 = var4;
                  if (var0[var2].b.length != var1[var2].b.length) {
                     break;
                  }

                  var2++;
               }
            }
         }
      }

      return var3;
   }

   static float[] a(float[] var0, int var1, int var2) {
      if (var1 > var2) {
         throw new IllegalArgumentException();
      } else {
         int var3 = var0.length;
         if (var1 >= 0 && var1 <= var3) {
            var2 -= var1;
            var3 = Math.min(var2, var3 - var1);
            float[] var4 = new float[var2];
            System.arraycopy(var0, var1, var4, 0, var3);
            return var4;
         } else {
            throw new ArrayIndexOutOfBoundsException();
         }
      }
   }

   public static PathParser.PathDataNode[] a(PathParser.PathDataNode[] var0) {
      if (var0 == null) {
         var0 = null;
      } else {
         PathParser.PathDataNode[] var2 = new PathParser.PathDataNode[var0.length];

         for (int var1 = 0; var1 < var0.length; var1++) {
            var2[var1] = new PathParser.PathDataNode(var0[var1]);
         }

         var0 = var2;
      }

      return var0;
   }

   public static void b(PathParser.PathDataNode[] var0, PathParser.PathDataNode[] var1) {
      for (int var2 = 0; var2 < var1.length; var2++) {
         var0[var2].a = var1[var2].a;

         for (int var3 = 0; var3 < var1[var2].b.length; var3++) {
            var0[var2].b[var3] = var1[var2].b[var3];
         }
      }
   }

   public static PathParser.PathDataNode[] b(String var0) {
      PathParser.PathDataNode[] var7;
      if (var0 == null) {
         var7 = null;
      } else {
         ArrayList var5 = new ArrayList();
         int var2 = 1;
         int var1 = 0;

         while (var2 < var0.length()) {
            int var3 = a(var0, var2);
            String var4 = var0.substring(var1, var3).trim();
            if (var4.length() > 0) {
               float[] var6 = c(var4);
               a(var5, var4.charAt(0), var6);
            }

            var2 = var3 + 1;
            var1 = var3;
         }

         if (var2 - var1 == 1 && var1 < var0.length()) {
            a(var5, var0.charAt(var1), new float[0]);
         }

         var7 = var5.toArray(new PathParser.PathDataNode[var5.size()]);
      }

      return var7;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static float[] c(String var0) {
      int var1 = 0;
      float[] var13;
      if (var0.charAt(0) != 'z' && var0.charAt(0) != 'Z') {
         int var5;
         PathParser.ExtractFloatResult var6;
         float[] var7;
         try {
            var7 = new float[var0.length()];
            var6 = new PathParser.ExtractFloatResult();
            var5 = var0.length();
         } catch (NumberFormatException var11) {
            throw new RuntimeException("error in parsing \"" + var0 + "\"", var11);
         }

         int var2 = 1;

         while (var2 < var5) {
            int var3;
            try {
               a(var0, var2, var6);
               var3 = var6.a;
            } catch (NumberFormatException var10) {
               throw new RuntimeException("error in parsing \"" + var0 + "\"", var10);
            }

            if (var2 < var3) {
               int var4 = var1 + 1;

               try {
                  var7[var1] = Float.parseFloat(var0.substring(var2, var3));
               } catch (NumberFormatException var9) {
                  throw new RuntimeException("error in parsing \"" + var0 + "\"", var9);
               }

               var1 = var4;
            }

            label50: {
               try {
                  if (var6.b) {
                     break label50;
                  }
               } catch (NumberFormatException var12) {
                  throw new RuntimeException("error in parsing \"" + var0 + "\"", var12);
               }

               var2 = var3 + 1;
               continue;
            }

            var2 = var3;
         }

         try {
            var14 = a(var7, 0, var1);
         } catch (NumberFormatException var8) {
            throw new RuntimeException("error in parsing \"" + var0 + "\"", var8);
         }

         var13 = var14;
      } else {
         var13 = new float[0];
      }

      return var13;
   }

   private static class ExtractFloatResult {
      int a;
      boolean b;

      ExtractFloatResult() {
      }
   }

   public static class PathDataNode {
      public char a;
      public float[] b;

      PathDataNode(char var1, float[] var2) {
         this.a = var1;
         this.b = var2;
      }

      PathDataNode(PathParser.PathDataNode var1) {
         this.a = var1.a;
         this.b = PathParser.a(var1.b, 0, var1.b.length);
      }

      private static void a(Path var0, double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15, double var17) {
         int var38 = (int)Math.ceil(Math.abs(4.0 * var17 / Math.PI));
         double var29 = Math.cos(var13);
         double var31 = Math.sin(var13);
         double var23 = Math.cos(var15);
         var13 = Math.sin(var15);
         double var21 = -var5;
         double var19 = -var5;
         double var33 = var17 / var38;
         int var37 = 0;
         var19 = var13 * (var19 * var31) + var23 * (var7 * var29);
         var13 = var21 * var29 * var13 - var7 * var31 * var23;
         var17 = var15;
         var15 = var9;
         var9 = var19;

         while (var37 < var38) {
            double var25 = var17 + var33;
            var23 = Math.sin(var25);
            double var35 = Math.cos(var25);
            var19 = var5 * var29 * var35 + var1 - var7 * var31 * var23;
            var21 = var7 * var29 * var23 + (var5 * var31 * var35 + var3);
            double var27 = -var5 * var29 * var23 - var7 * var31 * var35;
            var23 = var35 * (var7 * var29) + var23 * (-var5 * var31);
            var35 = Math.tan((var25 - var17) / 2.0);
            var17 = Math.sin(var25 - var17);
            var17 = (Math.sqrt(var35 * (3.0 * var35) + 4.0) - 1.0) * var17 / 3.0;
            var0.rLineTo(0.0F, 0.0F);
            var0.cubicTo(
               (float)(var13 * var17 + var15),
               (float)(var11 + var9 * var17),
               (float)(var19 - var17 * var27),
               (float)(var21 - var17 * var23),
               (float)var19,
               (float)var21
            );
            var37++;
            var13 = var27;
            var17 = var25;
            var11 = var21;
            var15 = var19;
            var9 = var23;
         }
      }

      private static void a(Path var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, boolean var8, boolean var9) {
         double var22 = Math.toRadians(var7);
         double var18 = Math.cos(var22);
         double var20 = Math.sin(var22);
         double var24 = (var1 * var18 + var2 * var20) / var5;
         double var26 = (-var1 * var20 + var2 * var18) / var6;
         double var10 = (var3 * var18 + var4 * var20) / var5;
         double var16 = (-var3 * var20 + var4 * var18) / var6;
         double var28 = var24 - var10;
         double var30 = var26 - var16;
         double var14 = (var24 + var10) / 2.0;
         double var12 = (var26 + var16) / 2.0;
         double var32 = var28 * var28 + var30 * var30;
         if (var32 == 0.0) {
            Log.w("PathParser", " Points are coincident");
         } else {
            double var34 = 1.0 / var32 - 0.25;
            if (var34 < 0.0) {
               Log.w("PathParser", "Points are too far apart " + var32);
               float var36 = (float)(Math.sqrt(var32) / 1.99999);
               a(var0, var1, var2, var3, var4, var5 * var36, var6 * var36, var7, var8, var9);
            } else {
               var32 = Math.sqrt(var34);
               var28 *= var32;
               var30 *= var32;
               if (var8 == var9) {
                  var14 -= var30;
                  var12 = var28 + var12;
               } else {
                  var14 = var30 + var14;
                  var12 -= var28;
               }

               var24 = Math.atan2(var26 - var12, var24 - var14);
               var16 = Math.atan2(var16 - var12, var10 - var14) - var24;
               if (var16 >= 0.0) {
                  var8 = true;
               } else {
                  var8 = false;
               }

               var10 = var16;
               if (var9 != var8) {
                  if (var16 > 0.0) {
                     var10 = var16 - (Math.PI * 2);
                  } else {
                     var10 = var16 + (Math.PI * 2);
                  }
               }

               var14 = var5 * var14;
               var12 *= var6;
               a(var0, var14 * var18 - var12 * var20, var14 * var20 + var12 * var18, var5, var6, var1, var2, var22, var24, var10);
            }
         }
      }

      private static void a(Path var0, float[] var1, char var2, char var3, float[] var4) {
         float var9 = var1[0];
         float var10 = var1[1];
         float var8 = var1[2];
         float var7 = var1[3];
         float var5 = var1[4];
         float var6 = var1[5];
         byte var14;
         switch (var3) {
            case 'A':
            case 'a':
               var14 = 7;
               break;
            case 'C':
            case 'c':
               var14 = 6;
               break;
            case 'H':
            case 'V':
            case 'h':
            case 'v':
               var14 = 1;
               break;
            case 'L':
            case 'M':
            case 'T':
            case 'l':
            case 'm':
            case 't':
               var14 = 2;
               break;
            case 'Q':
            case 'S':
            case 'q':
            case 's':
               var14 = 4;
               break;
            case 'Z':
            case 'z':
               var0.close();
               var0.moveTo(var5, var6);
               var7 = var6;
               var8 = var5;
               var10 = var6;
               var9 = var5;
               var14 = 2;
               break;
            default:
               var14 = 2;
         }

         byte var15 = 0;
         float var11 = var10;
         var10 = var9;
         var9 = var11;

         while (var15 < var4.length) {
            switch (var3) {
               case 'A':
                  var11 = var4[var15 + 5];
                  var8 = var4[var15 + 6];
                  var7 = var4[var15 + 0];
                  float var89 = var4[var15 + 1];
                  float var91 = var4[var15 + 2];
                  boolean var92;
                  if (var4[var15 + 3] != 0.0F) {
                     var92 = true;
                  } else {
                     var92 = false;
                  }

                  boolean var93;
                  if (var4[var15 + 4] != 0.0F) {
                     var93 = true;
                  } else {
                     var93 = false;
                  }

                  a(var0, var10, var9, var11, var8, var7, var89, var91, var92, var93);
                  var10 = var4[var15 + 5];
                  var11 = var4[var15 + 6];
                  var7 = var5;
                  var8 = var10;
                  var9 = var11;
                  var5 = var6;
                  var6 = var11;
                  break;
               case 'C':
                  var0.cubicTo(var4[var15 + 0], var4[var15 + 1], var4[var15 + 2], var4[var15 + 3], var4[var15 + 4], var4[var15 + 5]);
                  var10 = var4[var15 + 4];
                  var9 = var4[var15 + 5];
                  var8 = var4[var15 + 2];
                  var11 = var4[var15 + 3];
                  var7 = var5;
                  var5 = var6;
                  var6 = var11;
                  break;
               case 'H':
                  var0.lineTo(var4[var15 + 0], var9);
                  var10 = var4[var15 + 0];
                  var11 = var5;
                  var5 = var6;
                  var6 = var7;
                  var7 = var11;
                  break;
               case 'L':
                  var0.lineTo(var4[var15 + 0], var4[var15 + 1]);
                  var10 = var4[var15 + 0];
                  var9 = var4[var15 + 1];
                  var11 = var5;
                  var5 = var6;
                  var6 = var7;
                  var7 = var11;
                  break;
               case 'M':
                  var9 = var4[var15 + 0];
                  var10 = var4[var15 + 1];
                  if (var15 > 0) {
                     var0.lineTo(var4[var15 + 0], var4[var15 + 1]);
                     var11 = var10;
                     var10 = var9;
                     var9 = var5;
                     var5 = var6;
                     var6 = var7;
                     var7 = var9;
                     var9 = var11;
                  } else {
                     var0.moveTo(var4[var15 + 0], var4[var15 + 1]);
                     float var88 = var10;
                     var11 = var9;
                     var6 = var7;
                     var5 = var10;
                     var7 = var9;
                     var9 = var88;
                     var10 = var11;
                  }
                  break;
               case 'Q':
                  var0.quadTo(var4[var15 + 0], var4[var15 + 1], var4[var15 + 2], var4[var15 + 3]);
                  var8 = var4[var15 + 0];
                  var11 = var4[var15 + 1];
                  var10 = var4[var15 + 2];
                  var9 = var4[var15 + 3];
                  var7 = var5;
                  var5 = var6;
                  var6 = var11;
                  break;
               case 'S':
                  if (var2 != 'c' && var2 != 's' && var2 != 'C' && var2 != 'S') {
                     var7 = var10;
                  } else {
                     var8 = 2.0F * var10 - var8;
                     var9 = 2.0F * var9 - var7;
                     var7 = var8;
                  }

                  var0.cubicTo(var7, var9, var4[var15 + 0], var4[var15 + 1], var4[var15 + 2], var4[var15 + 3]);
                  var8 = var4[var15 + 0];
                  var11 = var4[var15 + 1];
                  var10 = var4[var15 + 2];
                  var9 = var4[var15 + 3];
                  var7 = var5;
                  var5 = var6;
                  var6 = var11;
                  break;
               case 'T':
                  float var87;
                  label94: {
                     if (var2 != 'q' && var2 != 't' && var2 != 'Q') {
                        var87 = var9;
                        var11 = var10;
                        if (var2 != 'T') {
                           break label94;
                        }
                     }

                     var11 = 2.0F * var10 - var8;
                     var87 = 2.0F * var9 - var7;
                  }

                  var0.quadTo(var11, var87, var4[var15 + 0], var4[var15 + 1]);
                  var10 = var4[var15 + 0];
                  var9 = var4[var15 + 1];
                  var8 = var11;
                  var7 = var5;
                  var5 = var6;
                  var6 = var87;
                  break;
               case 'V':
                  var0.lineTo(var10, var4[var15 + 0]);
                  var11 = var4[var15 + 0];
                  var9 = var5;
                  var5 = var6;
                  var6 = var7;
                  var7 = var9;
                  var9 = var11;
                  break;
               case 'a':
                  var7 = var4[var15 + 5];
                  float var90 = var4[var15 + 6];
                  float var86 = var4[var15 + 0];
                  var11 = var4[var15 + 1];
                  var8 = var4[var15 + 2];
                  boolean var16;
                  if (var4[var15 + 3] != 0.0F) {
                     var16 = true;
                  } else {
                     var16 = false;
                  }

                  boolean var17;
                  if (var4[var15 + 4] != 0.0F) {
                     var17 = true;
                  } else {
                     var17 = false;
                  }

                  a(var0, var10, var9, var7 + var10, var90 + var9, var86, var11, var8, var16, var17);
                  var10 += var4[var15 + 5];
                  var11 = var4[var15 + 6] + var9;
                  var7 = var5;
                  var8 = var10;
                  var9 = var11;
                  var5 = var6;
                  var6 = var11;
                  break;
               case 'c':
                  var0.rCubicTo(var4[var15 + 0], var4[var15 + 1], var4[var15 + 2], var4[var15 + 3], var4[var15 + 4], var4[var15 + 5]);
                  var8 = var4[var15 + 2];
                  float var85 = var4[var15 + 3];
                  var7 = var4[var15 + 4];
                  var11 = var4[var15 + 5];
                  var8 = var10 + var8;
                  var11 += var9;
                  var10 += var7;
                  var7 = var5;
                  var9 = var85 + var9;
                  var5 = var6;
                  var6 = var9;
                  var9 = var11;
                  break;
               case 'h':
                  var0.rLineTo(var4[var15 + 0], 0.0F);
                  var11 = var4[var15 + 0];
                  var11 = var10 + var11;
                  var10 = var7;
                  var7 = var5;
                  var5 = var6;
                  var6 = var10;
                  var10 = var11;
                  break;
               case 'l':
                  var0.rLineTo(var4[var15 + 0], var4[var15 + 1]);
                  float var84 = var4[var15 + 0];
                  var11 = var4[var15 + 1];
                  var11 += var9;
                  var10 += var84;
                  var9 = var5;
                  var5 = var6;
                  var6 = var7;
                  var7 = var9;
                  var9 = var11;
                  break;
               case 'm':
                  var10 += var4[var15 + 0];
                  var9 += var4[var15 + 1];
                  if (var15 > 0) {
                     var0.rLineTo(var4[var15 + 0], var4[var15 + 1]);
                     var11 = var5;
                     var5 = var6;
                     var6 = var7;
                     var7 = var11;
                  } else {
                     var0.rMoveTo(var4[var15 + 0], var4[var15 + 1]);
                     float var83 = var9;
                     var11 = var10;
                     var6 = var7;
                     var5 = var9;
                     var7 = var10;
                     var9 = var83;
                     var10 = var11;
                  }
                  break;
               case 'q':
                  var0.rQuadTo(var4[var15 + 0], var4[var15 + 1], var4[var15 + 2], var4[var15 + 3]);
                  var8 = var4[var15 + 0];
                  float var82 = var4[var15 + 1];
                  var7 = var4[var15 + 2];
                  var11 = var4[var15 + 3];
                  var8 = var10 + var8;
                  var11 += var9;
                  var10 += var7;
                  var7 = var5;
                  var9 = var82 + var9;
                  var5 = var6;
                  var6 = var9;
                  var9 = var11;
                  break;
               case 's':
                  if (var2 != 'c' && var2 != 's' && var2 != 'C' && var2 != 'S') {
                     var7 = 0.0F;
                     var8 = 0.0F;
                  } else {
                     var8 = var10 - var8;
                     var7 = var9 - var7;
                  }

                  var0.rCubicTo(var8, var7, var4[var15 + 0], var4[var15 + 1], var4[var15 + 2], var4[var15 + 3]);
                  var8 = var4[var15 + 0];
                  float var81 = var4[var15 + 1];
                  var7 = var4[var15 + 2];
                  var11 = var4[var15 + 3];
                  var8 = var10 + var8;
                  var11 += var9;
                  var10 += var7;
                  var7 = var5;
                  var9 = var81 + var9;
                  var5 = var6;
                  var6 = var9;
                  var9 = var11;
                  break;
               case 't':
                  if (var2 != 'q' && var2 != 't' && var2 != 'Q' && var2 != 'T') {
                     var7 = 0.0F;
                     var8 = 0.0F;
                  } else {
                     var8 = var10 - var8;
                     var7 = var9 - var7;
                  }

                  var0.rQuadTo(var8, var7, var4[var15 + 0], var4[var15 + 1]);
                  float var13 = var4[var15 + 0];
                  float var79 = var4[var15 + 1];
                  var11 = var10 + var8;
                  var79 += var9;
                  var10 += var13;
                  var8 = var5;
                  var7 += var9;
                  var5 = var6;
                  var6 = var7;
                  var7 = var8;
                  var8 = var11;
                  var9 = var79;
                  break;
               case 'v':
                  var0.rLineTo(0.0F, var4[var15 + 0]);
                  float var12 = var4[var15 + 0];
                  var11 = var5;
                  var9 += var12;
                  var5 = var6;
                  var6 = var7;
                  var7 = var11;
                  break;
               default:
                  var11 = var6;
                  var6 = var7;
                  var7 = var5;
                  var5 = var11;
            }

            var15 += var14;
            var11 = var5;
            var5 = var7;
            var2 = var3;
            var7 = var6;
            var6 = var11;
         }

         var1[0] = var10;
         var1[1] = var9;
         var1[2] = var8;
         var1[3] = var7;
         var1[4] = var5;
         var1[5] = var6;
      }

      public static void a(PathParser.PathDataNode[] var0, Path var1) {
         float[] var4 = new float[6];
         char var2 = 'm';

         for (int var3 = 0; var3 < var0.length; var3++) {
            a(var1, var4, var2, var0[var3].a, var0[var3].b);
            var2 = var0[var3].a;
         }
      }

      public void a(PathParser.PathDataNode var1, PathParser.PathDataNode var2, float var3) {
         for (int var4 = 0; var4 < var1.b.length; var4++) {
            this.b[var4] = var1.b[var4] * (1.0F - var3) + var2.b[var4] * var3;
         }
      }
   }
}
