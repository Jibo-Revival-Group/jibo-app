package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class PagerAdapter {
   private final DataSetObservable a = new DataSetObservable();
   private DataSetObserver b;

   public int a(Object var1) {
      return -1;
   }

   public Parcelable a() {
      return null;
   }

   @Deprecated
   public Object a(View var1, int var2) {
      throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
   }

   public Object a(ViewGroup var1, int var2) {
      return this.a((View)var1, var2);
   }

   public void a(DataSetObserver var1) {
      this.a.registerObserver(var1);
   }

   public void a(Parcelable var1, ClassLoader var2) {
   }

   @Deprecated
   public void a(View var1) {
   }

   @Deprecated
   public void a(View var1, int var2, Object var3) {
      throw new UnsupportedOperationException("Required method destroyItem was not overridden");
   }

   public void a(ViewGroup var1) {
      this.a((View)var1);
   }

   public void a(ViewGroup var1, int var2, Object var3) {
      this.a((View)var1, var2, var3);
   }

   public abstract boolean a(View var1, Object var2);

   public abstract int b();

   public void b(DataSetObserver var1) {
      this.a.unregisterObserver(var1);
   }

   @Deprecated
   public void b(View var1) {
   }

   @Deprecated
   public void b(View var1, int var2, Object var3) {
   }

   public void b(ViewGroup var1) {
      this.b(var1);
   }

   public void b(ViewGroup var1, int var2, Object var3) {
      this.b((View)var1, var2, var3);
   }

   public CharSequence c(int var1) {
      return null;
   }

   public void c() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield android/support/v4/view/PagerAdapter.b Landroid/database/DataSetObserver;
      // 06: ifnull 10
      // 09: aload 0
      // 0a: getfield android/support/v4/view/PagerAdapter.b Landroid/database/DataSetObserver;
      // 0d: invokevirtual android/database/DataSetObserver.onChanged ()V
      // 10: aload 0
      // 11: monitorexit
      // 12: aload 0
      // 13: getfield android/support/v4/view/PagerAdapter.a Landroid/database/DataSetObservable;
      // 16: invokevirtual android/database/DataSetObservable.notifyChanged ()V
      // 19: return
      // 1a: astore 1
      // 1b: aload 0
      // 1c: monitorexit
      // 1d: aload 1
      // 1e: athrow
      // try (2 -> 8): 14 null
      // try (8 -> 10): 14 null
      // try (15 -> 17): 14 null
   }

   void c(DataSetObserver param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 0: aload 0
      // 1: monitorenter
      // 2: aload 0
      // 3: aload 1
      // 4: putfield android/support/v4/view/PagerAdapter.b Landroid/database/DataSetObserver;
      // 7: aload 0
      // 8: monitorexit
      // 9: return
      // a: astore 1
      // b: aload 0
      // c: monitorexit
      // d: aload 1
      // e: athrow
      // try (2 -> 7): 8 null
      // try (9 -> 11): 8 null
   }

   public float d(int var1) {
      return 1.0F;
   }
}
