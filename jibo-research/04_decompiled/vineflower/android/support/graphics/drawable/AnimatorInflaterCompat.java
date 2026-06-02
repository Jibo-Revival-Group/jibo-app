package android.support.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build.VERSION;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatorInflaterCompat {
   private static int a(Resources var0, Theme var1, AttributeSet var2, XmlPullParser var3) {
      byte var6 = 0;
      TypedArray var7 = TypedArrayUtils.a(var0, var1, var2, AndroidResources.j);
      TypedValue var8 = TypedArrayUtils.b(var7, var3, "value", 0);
      boolean var5;
      if (var8 != null) {
         var5 = true;
      } else {
         var5 = false;
      }

      byte var4 = var6;
      if (var5) {
         var4 = var6;
         if (a(var8.type)) {
            var4 = 3;
         }
      }

      var7.recycle();
      return var4;
   }

   private static int a(TypedArray var0, int var1, int var2) {
      byte var5 = 0;
      TypedValue var6 = var0.peekValue(var1);
      boolean var8;
      if (var6 != null) {
         var8 = 1;
      } else {
         var8 = 0;
      }

      int var3;
      if (var8) {
         var3 = var6.type;
      } else {
         var3 = 0;
      }

      TypedValue var7 = var0.peekValue(var2);
      boolean var10;
      if (var7 != null) {
         var10 = true;
      } else {
         var10 = false;
      }

      int var4;
      if (var10) {
         var4 = var7.type;
      } else {
         var4 = 0;
      }

      if (!var8 || !a(var3)) {
         var8 = var5;
         if (!var10) {
            return var8;
         }

         var8 = var5;
         if (!a(var4)) {
            return var8;
         }
      }

      return 3;
   }

   public static Animator a(Context var0, int var1) throws NotFoundException {
      Animator var2;
      if (VERSION.SDK_INT >= 24) {
         var2 = AnimatorInflater.loadAnimator(var0, var1);
      } else {
         var2 = a(var0, var0.getResources(), var0.getTheme(), var1);
      }

      return var2;
   }

   public static Animator a(Context var0, Resources var1, Theme var2, int var3) throws NotFoundException {
      return a(var0, var1, var2, var3, 1.0F);
   }

   public static Animator a(Context param0, Resources param1, Theme param2, int param3, float param4) throws NotFoundException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 5
      // 03: aconst_null
      // 04: astore 7
      // 06: aconst_null
      // 07: astore 6
      // 09: aload 1
      // 0a: iload 3
      // 0b: invokevirtual android/content/res/Resources.getAnimation (I)Landroid/content/res/XmlResourceParser;
      // 0e: astore 8
      // 10: aload 8
      // 12: astore 6
      // 14: aload 8
      // 16: astore 5
      // 18: aload 8
      // 1a: astore 7
      // 1c: aload 0
      // 1d: aload 1
      // 1e: aload 2
      // 1f: aload 8
      // 21: fload 4
      // 23: invokestatic android/support/graphics/drawable/AnimatorInflaterCompat.a (Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;F)Landroid/animation/Animator;
      // 26: astore 0
      // 27: aload 8
      // 29: ifnull 33
      // 2c: aload 8
      // 2e: invokeinterface android/content/res/XmlResourceParser.close ()V 1
      // 33: aload 0
      // 34: areturn
      // 35: astore 0
      // 36: aload 6
      // 38: astore 5
      // 3a: new android/content/res/Resources$NotFoundException
      // 3d: astore 1
      // 3e: aload 6
      // 40: astore 5
      // 42: new java/lang/StringBuilder
      // 45: astore 2
      // 46: aload 6
      // 48: astore 5
      // 4a: aload 2
      // 4b: invokespecial java/lang/StringBuilder.<init> ()V
      // 4e: aload 6
      // 50: astore 5
      // 52: aload 1
      // 53: aload 2
      // 54: ldc "Can't load animation resource ID #0x"
      // 56: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 59: iload 3
      // 5a: invokestatic java/lang/Integer.toHexString (I)Ljava/lang/String;
      // 5d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 60: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 63: invokespecial android/content/res/Resources$NotFoundException.<init> (Ljava/lang/String;)V
      // 66: aload 6
      // 68: astore 5
      // 6a: aload 1
      // 6b: aload 0
      // 6c: invokevirtual android/content/res/Resources$NotFoundException.initCause (Ljava/lang/Throwable;)Ljava/lang/Throwable;
      // 6f: pop
      // 70: aload 6
      // 72: astore 5
      // 74: aload 1
      // 75: athrow
      // 76: astore 0
      // 77: aload 5
      // 79: ifnull 83
      // 7c: aload 5
      // 7e: invokeinterface android/content/res/XmlResourceParser.close ()V 1
      // 83: aload 0
      // 84: athrow
      // 85: astore 0
      // 86: aload 7
      // 88: astore 5
      // 8a: new android/content/res/Resources$NotFoundException
      // 8d: astore 1
      // 8e: aload 7
      // 90: astore 5
      // 92: new java/lang/StringBuilder
      // 95: astore 2
      // 96: aload 7
      // 98: astore 5
      // 9a: aload 2
      // 9b: invokespecial java/lang/StringBuilder.<init> ()V
      // 9e: aload 7
      // a0: astore 5
      // a2: aload 1
      // a3: aload 2
      // a4: ldc "Can't load animation resource ID #0x"
      // a6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // a9: iload 3
      // aa: invokestatic java/lang/Integer.toHexString (I)Ljava/lang/String;
      // ad: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // b0: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // b3: invokespecial android/content/res/Resources$NotFoundException.<init> (Ljava/lang/String;)V
      // b6: aload 7
      // b8: astore 5
      // ba: aload 1
      // bb: aload 0
      // bc: invokevirtual android/content/res/Resources$NotFoundException.initCause (Ljava/lang/Throwable;)Ljava/lang/Throwable;
      // bf: pop
      // c0: aload 7
      // c2: astore 5
      // c4: aload 1
      // c5: athrow
      // try (6 -> 10): 29 org/xmlpull/v1/XmlPullParserException
      // try (6 -> 10): 70 java/io/IOException
      // try (6 -> 10): 63 null
      // try (16 -> 23): 29 org/xmlpull/v1/XmlPullParserException
      // try (16 -> 23): 70 java/io/IOException
      // try (16 -> 23): 63 null
      // try (32 -> 34): 63 null
      // try (36 -> 38): 63 null
      // try (40 -> 42): 63 null
      // try (44 -> 53): 63 null
      // try (55 -> 59): 63 null
      // try (61 -> 63): 63 null
      // try (73 -> 75): 63 null
      // try (77 -> 79): 63 null
      // try (81 -> 83): 63 null
      // try (85 -> 94): 63 null
      // try (96 -> 100): 63 null
      // try (102 -> 104): 63 null
   }

   private static Animator a(Context var0, Resources var1, Theme var2, XmlPullParser var3, float var4) throws XmlPullParserException, IOException {
      return a(var0, var1, var2, var3, Xml.asAttributeSet(var3), null, 0, var4);
   }

   private static Animator a(Context var0, Resources var1, Theme var2, XmlPullParser var3, AttributeSet var4, AnimatorSet var5, int var6, float var7) throws XmlPullParserException, IOException {
      Object var12 = null;
      ArrayList var11 = null;
      int var9 = var3.getDepth();

      while (true) {
         int var8 = var3.next();
         if (var8 == 3 && var3.getDepth() <= var9 || var8 == 1) {
            if (var5 != null && var11 != null) {
               Animator[] var13 = new Animator[var11.size()];
               Iterator var14 = var11.iterator();

               for (int var17 = 0; var14.hasNext(); var17++) {
                  var13[var17] = (Animator)var14.next();
               }

               if (var6 == 0) {
                  var5.playTogether(var13);
               } else {
                  var5.playSequentially(var13);
               }
            }

            return (Animator)var12;
         }

         if (var8 == 2) {
            String var10 = var3.getName();
            boolean var15;
            Object var18;
            if (var10.equals("objectAnimator")) {
               var18 = a(var0, var1, var2, var4, var7, var3);
               var15 = 0;
            } else if (var10.equals("animator")) {
               var18 = a(var0, var1, var2, var4, null, var7, var3);
               var15 = 0;
            } else if (var10.equals("set")) {
               var18 = new AnimatorSet();
               TypedArray var20 = TypedArrayUtils.a(var1, var2, var4, AndroidResources.h);
               var15 = TypedArrayUtils.a(var20, var3, "ordering", 0, 0);
               a(var0, var1, var2, var3, var4, (AnimatorSet)var18, var15, var7);
               var20.recycle();
               var15 = 0;
            } else {
               if (!var10.equals("propertyValuesHolder")) {
                  throw new RuntimeException("Unknown animator name: " + var3.getName());
               }

               PropertyValuesHolder[] var19 = a(var0, var1, var2, var3, Xml.asAttributeSet(var3));
               if (var19 != null && var12 != null && var12 instanceof ValueAnimator) {
                  ((ValueAnimator)var12).setValues(var19);
               }

               var15 = 1;
               var18 = var12;
            }

            var12 = var18;
            if (var5 != null) {
               var12 = var18;
               if (!var15) {
                  if (var11 == null) {
                     var11 = new ArrayList();
                  }

                  var11.add(var18);
                  var12 = var18;
               }
            }
         }
      }
   }

   private static Keyframe a(Keyframe var0, float var1) {
      if (var0.getType() == float.class) {
         var0 = Keyframe.ofFloat(var1);
      } else if (var0.getType() == int.class) {
         var0 = Keyframe.ofInt(var1);
      } else {
         var0 = Keyframe.ofObject(var1);
      }

      return var0;
   }

   private static Keyframe a(Context var0, Resources var1, Theme var2, AttributeSet var3, int var4, XmlPullParser var5) throws XmlPullParserException, IOException {
      TypedArray var12 = TypedArrayUtils.a(var1, var2, var3, AndroidResources.j);
      Object var11 = null;
      float var6 = TypedArrayUtils.a(var12, var5, "fraction", 3, -1.0F);
      TypedValue var9 = TypedArrayUtils.b(var12, var5, "value", 0);
      boolean var8;
      if (var9 != null) {
         var8 = true;
      } else {
         var8 = false;
      }

      int var7 = var4;
      if (var4 == 4) {
         if (var8 && a(var9.type)) {
            var7 = 3;
         } else {
            var7 = 0;
         }
      }

      Keyframe var10;
      if (var8) {
         var10 = (Keyframe)var11;
         switch (var7) {
            case 0:
               var10 = Keyframe.ofFloat(var6, TypedArrayUtils.a(var12, var5, "value", 0, 0.0F));
               break;
            case 1:
            case 3:
               var10 = Keyframe.ofInt(var6, TypedArrayUtils.a(var12, var5, "value", 0, 0));
            case 2:
               break;
            default:
               var10 = (Keyframe)var11;
         }
      } else if (var7 == 0) {
         var10 = Keyframe.ofFloat(var6);
      } else {
         var10 = Keyframe.ofInt(var6);
      }

      var4 = TypedArrayUtils.c(var12, var5, "interpolator", 1, 0);
      if (var4 > 0) {
         var10.setInterpolator(AnimationUtilsCompat.a(var0, var4));
      }

      var12.recycle();
      return var10;
   }

   private static ObjectAnimator a(Context var0, Resources var1, Theme var2, AttributeSet var3, float var4, XmlPullParser var5) throws NotFoundException {
      ObjectAnimator var6 = new ObjectAnimator();
      a(var0, var1, var2, var3, var6, var4, var5);
      return var6;
   }

   private static PropertyValuesHolder a(Context var0, Resources var1, Theme var2, XmlPullParser var3, String var4, int var5) throws XmlPullParserException, IOException {
      ArrayList var11 = null;
      int var7 = var5;

      while (true) {
         var5 = var3.next();
         if (var5 == 3 || var5 == 1) {
            if (var11 != null) {
               var5 = var11.size();
               if (var5 > 0) {
                  Keyframe var16 = (Keyframe)var11.get(0);
                  Keyframe var14 = (Keyframe)var11.get(var5 - 1);
                  float var6 = var14.getFraction();
                  if (var6 < 1.0F) {
                     if (var6 < 0.0F) {
                        var14.setFraction(1.0F);
                     } else {
                        var11.add(var11.size(), a(var14, 1.0F));
                        var5++;
                     }
                  }

                  var6 = var16.getFraction();
                  int var9 = var5;
                  if (var6 != 0.0F) {
                     if (var6 < 0.0F) {
                        var16.setFraction(0.0F);
                        var9 = var5;
                     } else {
                        var11.add(0, a(var16, 0.0F));
                        var9 = var5 + 1;
                     }
                  }

                  Keyframe[] var15 = new Keyframe[var9];
                  var11.toArray(var15);

                  for (int var22 = 0; var22 < var9; var22++) {
                     Keyframe var17 = var15[var22];
                     if (var17.getFraction() < 0.0F) {
                        if (var22 == 0) {
                           var17.setFraction(0.0F);
                        } else if (var22 == var9 - 1) {
                           var17.setFraction(1.0F);
                        } else {
                           int var8 = var22 + 1;
                           int var10 = var22;

                           while (var8 < var9 - 1 && !(var15[var8].getFraction() >= 0.0F)) {
                              var10 = var8++;
                           }

                           a(var15, var15[var10 + 1].getFraction() - var15[var22 - 1].getFraction(), var22, var10);
                        }
                     }
                  }

                  PropertyValuesHolder var18 = PropertyValuesHolder.ofKeyframe(var4, var15);
                  PropertyValuesHolder var13 = var18;
                  if (var7 == 3) {
                     var18.setEvaluator(ArgbEvaluator.a());
                     var13 = var18;
                  }

                  return var13;
               }
            }

            return null;
         }

         if (var3.getName().equals("keyframe")) {
            var5 = var7;
            if (var7 == 4) {
               var5 = a(var1, var2, Xml.asAttributeSet(var3), var3);
            }

            Keyframe var12 = a(var0, var1, var2, Xml.asAttributeSet(var3), var5, var3);
            if (var12 != null) {
               if (var11 == null) {
                  var11 = new ArrayList();
               }

               var11.add(var12);
            }

            var3.next();
         } else {
            var5 = var7;
         }

         var7 = var5;
      }
   }

   private static PropertyValuesHolder a(TypedArray var0, int var1, int var2, int var3, String var4) {
      TypedValue var12 = var0.peekValue(var2);
      boolean var9;
      if (var12 != null) {
         var9 = true;
      } else {
         var9 = false;
      }

      int var10;
      if (var9) {
         var10 = var12.type;
      } else {
         var10 = 0;
      }

      var12 = var0.peekValue(var3);
      boolean var8;
      if (var12 != null) {
         var8 = true;
      } else {
         var8 = false;
      }

      int var11;
      if (var8) {
         var11 = var12.type;
      } else {
         var11 = 0;
      }

      int var7 = var1;
      if (var1 == 4) {
         if ((!var9 || !a(var10)) && (!var8 || !a(var11))) {
            var7 = 0;
         } else {
            var7 = 3;
         }
      }

      boolean var18;
      if (var7 == 0) {
         var18 = 1;
      } else {
         var18 = 0;
      }

      PropertyValuesHolder var22;
      if (var7 == 2) {
         String var25 = var0.getString(var2);
         String var14 = var0.getString(var3);
         PathParser.PathDataNode[] var15 = PathParser.b(var25);
         PathParser.PathDataNode[] var16 = PathParser.b(var14);
         if (var15 != null || var16 != null) {
            if (var15 != null) {
               AnimatorInflaterCompat.PathDataEvaluator var13 = new AnimatorInflaterCompat.PathDataEvaluator();
               PropertyValuesHolder var28;
               if (var16 != null) {
                  if (!PathParser.a(var15, var16)) {
                     throw new InflateException(" Can't morph from " + var25 + " to " + var14);
                  }

                  var28 = PropertyValuesHolder.ofObject(var4, var13, new Object[]{var15, var16});
               } else {
                  var28 = PropertyValuesHolder.ofObject(var4, var13, new Object[]{var15});
               }

               return var28;
            }

            if (var16 != null) {
               PropertyValuesHolder var27 = PropertyValuesHolder.ofObject(var4, new AnimatorInflaterCompat.PathDataEvaluator(), new Object[]{var16});
               return var27;
            }
         }

         var22 = null;
      } else {
         ArgbEvaluator var26 = null;
         if (var7 == 3) {
            var26 = ArgbEvaluator.a();
         }

         PropertyValuesHolder var17;
         if (var18) {
            if (var9) {
               float var5;
               if (var10 == 5) {
                  var5 = var0.getDimension(var2, 0.0F);
               } else {
                  var5 = var0.getFloat(var2, 0.0F);
               }

               if (var8) {
                  float var6;
                  if (var11 == 5) {
                     var6 = var0.getDimension(var3, 0.0F);
                  } else {
                     var6 = var0.getFloat(var3, 0.0F);
                  }

                  var17 = PropertyValuesHolder.ofFloat(var4, new float[]{var5, var6});
               } else {
                  var17 = PropertyValuesHolder.ofFloat(var4, new float[]{var5});
               }
            } else {
               float var23;
               if (var11 == 5) {
                  var23 = var0.getDimension(var3, 0.0F);
               } else {
                  var23 = var0.getFloat(var3, 0.0F);
               }

               var17 = PropertyValuesHolder.ofFloat(var4, new float[]{var23});
            }
         } else if (var9) {
            if (var10 == 5) {
               var18 = (int)var0.getDimension(var2, 0.0F);
            } else if (a(var10)) {
               var18 = var0.getColor(var2, 0);
            } else {
               var18 = var0.getInt(var2, 0);
            }

            if (var8) {
               if (var11 == 5) {
                  var2 = (int)var0.getDimension(var3, 0.0F);
               } else if (a(var11)) {
                  var2 = var0.getColor(var3, 0);
               } else {
                  var2 = var0.getInt(var3, 0);
               }

               var17 = PropertyValuesHolder.ofInt(var4, new int[]{var18, var2});
            } else {
               var17 = PropertyValuesHolder.ofInt(var4, new int[]{var18});
            }
         } else if (var8) {
            if (var11 == 5) {
               var18 = (int)var0.getDimension(var3, 0.0F);
            } else if (a(var11)) {
               var18 = var0.getColor(var3, 0);
            } else {
               var18 = var0.getInt(var3, 0);
            }

            var17 = PropertyValuesHolder.ofInt(var4, new int[]{var18});
         } else {
            var17 = null;
         }

         var22 = var17;
         if (var17 != null) {
            var22 = var17;
            if (var26 != null) {
               var17.setEvaluator(var26);
               var22 = var17;
            }
         }
      }

      return var22;
   }

   private static ValueAnimator a(Context var0, Resources var1, Theme var2, AttributeSet var3, ValueAnimator var4, float var5, XmlPullParser var6) throws NotFoundException {
      TypedArray var8 = TypedArrayUtils.a(var1, var2, var3, AndroidResources.g);
      TypedArray var10 = TypedArrayUtils.a(var1, var2, var3, AndroidResources.k);
      ValueAnimator var9 = var4;
      if (var4 == null) {
         var9 = new ValueAnimator();
      }

      a(var9, var8, var10, var5, var6);
      int var7 = TypedArrayUtils.c(var8, var6, "interpolator", 0, 0);
      if (var7 > 0) {
         var9.setInterpolator(AnimationUtilsCompat.a(var0, var7));
      }

      var8.recycle();
      if (var10 != null) {
         var10.recycle();
      }

      return var9;
   }

   private static void a(ValueAnimator var0, TypedArray var1, int var2, float var3, XmlPullParser var4) {
      ObjectAnimator var7 = (ObjectAnimator)var0;
      String var6 = TypedArrayUtils.a(var1, var4, "pathData", 1);
      if (var6 != null) {
         String var5 = TypedArrayUtils.a(var1, var4, "propertyXName", 2);
         String var8 = TypedArrayUtils.a(var1, var4, "propertyYName", 3);
         if (var2 != 2 && var2 == 4) {
         }

         if (var5 == null && var8 == null) {
            throw new InflateException(var1.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
         }

         a(PathParser.a(var6), var7, 0.5F * var3, var5, var8);
      } else {
         var7.setPropertyName(TypedArrayUtils.a(var1, var4, "propertyName", 0));
      }
   }

   private static void a(ValueAnimator var0, TypedArray var1, TypedArray var2, float var3, XmlPullParser var4) {
      long var8 = TypedArrayUtils.a(var1, var4, "duration", 1, 300);
      long var10 = TypedArrayUtils.a(var1, var4, "startOffset", 2, 0);
      int var7 = TypedArrayUtils.a(var1, var4, "valueType", 7, 4);
      int var6 = var7;
      if (TypedArrayUtils.a(var4, "valueFrom")) {
         var6 = var7;
         if (TypedArrayUtils.a(var4, "valueTo")) {
            int var5 = var7;
            if (var7 == 4) {
               var5 = a(var1, 5, 6);
            }

            PropertyValuesHolder var12 = a(var1, var5, 5, 6, "");
            var6 = var5;
            if (var12 != null) {
               var0.setValues(new PropertyValuesHolder[]{var12});
               var6 = var5;
            }
         }
      }

      var0.setDuration(var8);
      var0.setStartDelay(var10);
      var0.setRepeatCount(TypedArrayUtils.a(var1, var4, "repeatCount", 3, 0));
      var0.setRepeatMode(TypedArrayUtils.a(var1, var4, "repeatMode", 4, 1));
      if (var2 != null) {
         a(var0, var2, var6, var3, var4);
      }
   }

   private static void a(Path var0, ObjectAnimator var1, float var2, String var3, String var4) {
      PathMeasure var11 = new PathMeasure(var0, false);
      float var5 = 0.0F;
      ArrayList var10 = new ArrayList();
      var10.add(0.0F);

      float var6;
      do {
         var6 = var5 + var11.getLength();
         var10.add(var6);
         var5 = var6;
      } while (var11.nextContour());

      PathMeasure var14 = new PathMeasure(var0, false);
      int var9 = Math.min(100, (int)(var6 / var2) + 1);
      float[] var12 = new float[var9];
      float[] var20 = new float[var9];
      float[] var13 = new float[2];
      int var7 = 0;
      var5 = var6 / (var9 - 1);
      int var8 = 0;
      var2 = 0.0F;

      while (var8 < var9) {
         var14.getPosTan(var2, var13, null);
         var12[var8] = var13[0];
         var20[var8] = var13[1];
         var2 += var5;
         if (var7 + 1 < var10.size() && var2 > (Float)var10.get(var7 + 1)) {
            var2 -= var10.get(var7 + 1);
            var7++;
            var14.nextContour();
         }

         var8++;
      }

      PropertyValuesHolder var15 = null;
      Object var19 = null;
      if (var3 != null) {
         var15 = PropertyValuesHolder.ofFloat(var3, var12);
      }

      PropertyValuesHolder var17 = (PropertyValuesHolder)var19;
      if (var4 != null) {
         var17 = PropertyValuesHolder.ofFloat(var4, var20);
      }

      if (var15 == null) {
         var1.setValues(new PropertyValuesHolder[]{var17});
      } else if (var17 == null) {
         var1.setValues(new PropertyValuesHolder[]{var15});
      } else {
         var1.setValues(new PropertyValuesHolder[]{var15, var17});
      }
   }

   private static void a(Keyframe[] var0, float var1, int var2, int var3) {
      var1 /= var3 - var2 + 2;

      while (var2 <= var3) {
         var0[var2].setFraction(var0[var2 - 1].getFraction() + var1);
         var2++;
      }
   }

   private static boolean a(int var0) {
      boolean var1;
      if (var0 >= 28 && var0 <= 31) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private static PropertyValuesHolder[] a(Context var0, Resources var1, Theme var2, XmlPullParser var3, AttributeSet var4) throws XmlPullParserException, IOException {
      ArrayList var7 = null;

      while (true) {
         int var5 = var3.getEventType();
         if (var5 == 3 || var5 == 1) {
            PropertyValuesHolder[] var11 = null;
            if (var7 != null) {
               int var6 = var7.size();
               var11 = new PropertyValuesHolder[var6];

               for (int var13 = 0; var13 < var6; var13++) {
                  var11[var13] = (PropertyValuesHolder)var7.get(var13);
               }
            }

            return var11;
         }

         if (var5 != 2) {
            var3.next();
         } else {
            if (var3.getName().equals("propertyValuesHolder")) {
               TypedArray var9 = TypedArrayUtils.a(var1, var2, var4, AndroidResources.i);
               String var10 = TypedArrayUtils.a(var9, var3, "propertyName", 3);
               var5 = TypedArrayUtils.a(var9, var3, "valueType", 2, 4);
               PropertyValuesHolder var8 = a(var0, var1, var2, var3, var10, var5);
               if (var8 == null) {
                  var8 = a(var9, var5, 0, 1, var10);
               }

               if (var8 != null) {
                  if (var7 == null) {
                     var7 = new ArrayList();
                  }

                  var7.add(var8);
               }

               var9.recycle();
            }

            var3.next();
         }
      }
   }

   private static class PathDataEvaluator implements TypeEvaluator<PathParser.PathDataNode[]> {
      private PathParser.PathDataNode[] a;

      private PathDataEvaluator() {
      }

      public PathParser.PathDataNode[] a(float var1, PathParser.PathDataNode[] var2, PathParser.PathDataNode[] var3) {
         if (!PathParser.a(var2, var3)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
         }

         if (this.a == null || !PathParser.a(this.a, var2)) {
            this.a = PathParser.a(var2);
         }

         for (int var4 = 0; var4 < var2.length; var4++) {
            this.a[var4].a(var2[var4], var3[var4], var1);
         }

         return this.a;
      }
   }
}
