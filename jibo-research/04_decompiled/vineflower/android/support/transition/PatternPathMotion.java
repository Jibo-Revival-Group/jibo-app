package android.support.transition;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;

public class PatternPathMotion extends PathMotion {
   private Path a;
   private final Path b = new Path();
   private final Matrix c = new Matrix();

   public PatternPathMotion() {
      this.b.lineTo(1.0F, 0.0F);
      this.a = this.b;
   }

   public PatternPathMotion(Context param1, AttributeSet param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokespecial android/support/transition/PathMotion.<init> ()V
      // 04: aload 0
      // 05: new android/graphics/Path
      // 08: dup
      // 09: invokespecial android/graphics/Path.<init> ()V
      // 0c: putfield android/support/transition/PatternPathMotion.b Landroid/graphics/Path;
      // 0f: aload 0
      // 10: new android/graphics/Matrix
      // 13: dup
      // 14: invokespecial android/graphics/Matrix.<init> ()V
      // 17: putfield android/support/transition/PatternPathMotion.c Landroid/graphics/Matrix;
      // 1a: aload 1
      // 1b: aload 2
      // 1c: getstatic android/support/transition/Styleable.k [I
      // 1f: invokevirtual android/content/Context.obtainStyledAttributes (Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
      // 22: astore 1
      // 23: aload 1
      // 24: aload 2
      // 25: checkcast org/xmlpull/v1/XmlPullParser
      // 28: ldc "patternPathData"
      // 2a: bipush 0
      // 2b: invokestatic android/support/v4/content/res/TypedArrayUtils.a (Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)Ljava/lang/String;
      // 2e: astore 2
      // 2f: aload 2
      // 30: ifnonnull 46
      // 33: new java/lang/RuntimeException
      // 36: astore 2
      // 37: aload 2
      // 38: ldc "pathData must be supplied for patternPathMotion"
      // 3a: invokespecial java/lang/RuntimeException.<init> (Ljava/lang/String;)V
      // 3d: aload 2
      // 3e: athrow
      // 3f: astore 2
      // 40: aload 1
      // 41: invokevirtual android/content/res/TypedArray.recycle ()V
      // 44: aload 2
      // 45: athrow
      // 46: aload 0
      // 47: aload 2
      // 48: invokestatic android/support/v4/graphics/PathParser.a (Ljava/lang/String;)Landroid/graphics/Path;
      // 4b: invokevirtual android/support/transition/PatternPathMotion.a (Landroid/graphics/Path;)V
      // 4e: aload 1
      // 4f: invokevirtual android/content/res/TypedArray.recycle ()V
      // 52: return
      // try (17 -> 24): 33 null
      // try (26 -> 33): 33 null
      // try (38 -> 42): 33 null
   }

   private static float a(float var0, float var1) {
      return (float)Math.sqrt(var0 * var0 + var1 * var1);
   }

   @Override
   public Path a(float var1, float var2, float var3, float var4) {
      var3 -= var1;
      var4 -= var2;
      float var7 = a(var3, var4);
      double var5 = Math.atan2(var4, var3);
      this.c.setScale(var7, var7);
      this.c.postRotate((float)Math.toDegrees(var5));
      this.c.postTranslate(var1, var2);
      Path var8 = new Path();
      this.b.transform(this.c, var8);
      return var8;
   }

   public void a(Path var1) {
      PathMeasure var9 = new PathMeasure(var1, false);
      float var4 = var9.getLength();
      float[] var8 = new float[2];
      var9.getPosTan(var4, var8, null);
      var4 = var8[0];
      float var5 = var8[1];
      var9.getPosTan(0.0F, var8, null);
      float var7 = var8[0];
      float var6 = var8[1];
      if (var7 == var4 && var6 == var5) {
         throw new IllegalArgumentException("pattern must not end at the starting point");
      }

      this.c.setTranslate(-var7, -var6);
      var4 -= var7;
      var6 = var5 - var6;
      var5 = 1.0F / a(var4, var6);
      this.c.postScale(var5, var5);
      double var2 = Math.atan2(var6, var4);
      this.c.postRotate((float)Math.toDegrees(-var2));
      var1.transform(this.c, this.b);
      this.a = var1;
   }
}
