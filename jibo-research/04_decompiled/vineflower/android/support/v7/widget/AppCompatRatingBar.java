package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.RatingBar;

public class AppCompatRatingBar extends RatingBar {
   private final AppCompatProgressBarHelper a = new AppCompatProgressBarHelper(this);

   public AppCompatRatingBar(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.ratingBarStyle);
   }

   public AppCompatRatingBar(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a.a(var2, var3);
   }

   protected void onMeasure(int param1, int param2) {
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
      // 01: monitorenter
      // 02: aload 0
      // 03: iload 1
      // 04: iload 2
      // 05: invokespecial android/widget/RatingBar.onMeasure (II)V
      // 08: aload 0
      // 09: getfield android/support/v7/widget/AppCompatRatingBar.a Landroid/support/v7/widget/AppCompatProgressBarHelper;
      // 0c: invokevirtual android/support/v7/widget/AppCompatProgressBarHelper.a ()Landroid/graphics/Bitmap;
      // 0f: astore 3
      // 10: aload 3
      // 11: ifnull 2a
      // 14: aload 0
      // 15: aload 3
      // 16: invokevirtual android/graphics/Bitmap.getWidth ()I
      // 19: aload 0
      // 1a: invokevirtual android/support/v7/widget/AppCompatRatingBar.getNumStars ()I
      // 1d: imul
      // 1e: iload 1
      // 1f: bipush 0
      // 20: invokestatic android/view/View.resolveSizeAndState (III)I
      // 23: aload 0
      // 24: invokevirtual android/support/v7/widget/AppCompatRatingBar.getMeasuredHeight ()I
      // 27: invokevirtual android/support/v7/widget/AppCompatRatingBar.setMeasuredDimension (II)V
      // 2a: aload 0
      // 2b: monitorexit
      // 2c: return
      // 2d: astore 3
      // 2e: aload 0
      // 2f: monitorexit
      // 30: aload 3
      // 31: athrow
      // try (2 -> 10): 27 null
      // try (12 -> 24): 27 null
   }
}
