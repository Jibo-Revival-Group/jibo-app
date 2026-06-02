package android.support.v4.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.os.CancellationSignal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class CursorLoader extends AsyncTaskLoader<Cursor> {
   final Loader<Cursor>.ForceLoadContentObserver f = new Loader.ForceLoadContentObserver(this);
   Uri g;
   String[] h;
   String i;
   String[] j;
   String k;
   Cursor l;
   CancellationSignal m;

   public CursorLoader(Context var1, Uri var2, String[] var3, String var4, String[] var5, String var6) {
      super(var1);
      this.g = var2;
      this.h = var3;
      this.i = var4;
      this.j = var5;
      this.k = var6;
   }

   public void a(Cursor var1) {
      if (this.q()) {
         if (var1 != null) {
            var1.close();
         }
      } else {
         Cursor var2 = this.l;
         this.l = var1;
         if (this.o()) {
            super.b(var1);
         }

         if (var2 != null && var2 != var1 && !var2.isClosed()) {
            var2.close();
         }
      }
   }

   @Override
   public void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      super.a(var1, var2, var3, var4);
      var3.print(var1);
      var3.print("mUri=");
      var3.println(this.g);
      var3.print(var1);
      var3.print("mProjection=");
      var3.println(Arrays.toString(this.h));
      var3.print(var1);
      var3.print("mSelection=");
      var3.println(this.i);
      var3.print(var1);
      var3.print("mSelectionArgs=");
      var3.println(Arrays.toString(this.j));
      var3.print(var1);
      var3.print("mSortOrder=");
      var3.println(this.k);
      var3.print(var1);
      var3.print("mCursor=");
      var3.println(this.l);
      var3.print(var1);
      var3.print("mContentChanged=");
      var3.println(this.u);
   }

   public void b(Cursor var1) {
      if (var1 != null && !var1.isClosed()) {
         var1.close();
      }
   }

   @Override
   public void f() {
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
      // 01: invokespecial android/support/v4/content/AsyncTaskLoader.f ()V
      // 04: aload 0
      // 05: monitorenter
      // 06: aload 0
      // 07: getfield android/support/v4/content/CursorLoader.m Landroid/support/v4/os/CancellationSignal;
      // 0a: ifnull 14
      // 0d: aload 0
      // 0e: getfield android/support/v4/content/CursorLoader.m Landroid/support/v4/os/CancellationSignal;
      // 11: invokevirtual android/support/v4/os/CancellationSignal.c ()V
      // 14: aload 0
      // 15: monitorexit
      // 16: return
      // 17: astore 1
      // 18: aload 0
      // 19: monitorexit
      // 1a: aload 1
      // 1b: athrow
      // try (4 -> 10): 13 null
      // try (10 -> 12): 13 null
      // try (14 -> 16): 13 null
   }

   public Cursor h() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: invokevirtual android/support/v4/content/CursorLoader.g ()Z
      // 06: ifeq 18
      // 09: new android/support/v4/os/OperationCanceledException
      // 0c: astore 1
      // 0d: aload 1
      // 0e: invokespecial android/support/v4/os/OperationCanceledException.<init> ()V
      // 11: aload 1
      // 12: athrow
      // 13: astore 1
      // 14: aload 0
      // 15: monitorexit
      // 16: aload 1
      // 17: athrow
      // 18: new android/support/v4/os/CancellationSignal
      // 1b: astore 1
      // 1c: aload 1
      // 1d: invokespecial android/support/v4/os/CancellationSignal.<init> ()V
      // 20: aload 0
      // 21: aload 1
      // 22: putfield android/support/v4/content/CursorLoader.m Landroid/support/v4/os/CancellationSignal;
      // 25: aload 0
      // 26: monitorexit
      // 27: aload 0
      // 28: invokevirtual android/support/v4/content/CursorLoader.m ()Landroid/content/Context;
      // 2b: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 2e: aload 0
      // 2f: getfield android/support/v4/content/CursorLoader.g Landroid/net/Uri;
      // 32: aload 0
      // 33: getfield android/support/v4/content/CursorLoader.h [Ljava/lang/String;
      // 36: aload 0
      // 37: getfield android/support/v4/content/CursorLoader.i Ljava/lang/String;
      // 3a: aload 0
      // 3b: getfield android/support/v4/content/CursorLoader.j [Ljava/lang/String;
      // 3e: aload 0
      // 3f: getfield android/support/v4/content/CursorLoader.k Ljava/lang/String;
      // 42: aload 0
      // 43: getfield android/support/v4/content/CursorLoader.m Landroid/support/v4/os/CancellationSignal;
      // 46: invokestatic android/support/v4/content/ContentResolverCompat.a (Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/support/v4/os/CancellationSignal;)Landroid/database/Cursor;
      // 49: astore 1
      // 4a: aload 1
      // 4b: ifnull 5f
      // 4e: aload 1
      // 4f: invokeinterface android/database/Cursor.getCount ()I 1
      // 54: pop
      // 55: aload 1
      // 56: aload 0
      // 57: getfield android/support/v4/content/CursorLoader.f Landroid/support/v4/content/Loader$ForceLoadContentObserver;
      // 5a: invokeinterface android/database/Cursor.registerContentObserver (Landroid/database/ContentObserver;)V 2
      // 5f: aload 0
      // 60: monitorenter
      // 61: aload 0
      // 62: aconst_null
      // 63: putfield android/support/v4/content/CursorLoader.m Landroid/support/v4/os/CancellationSignal;
      // 66: aload 0
      // 67: monitorexit
      // 68: aload 1
      // 69: areturn
      // 6a: astore 2
      // 6b: aload 1
      // 6c: invokeinterface android/database/Cursor.close ()V 1
      // 71: aload 2
      // 72: athrow
      // 73: astore 1
      // 74: aload 0
      // 75: monitorenter
      // 76: aload 0
      // 77: aconst_null
      // 78: putfield android/support/v4/content/CursorLoader.m Landroid/support/v4/os/CancellationSignal;
      // 7b: aload 0
      // 7c: monitorexit
      // 7d: aload 1
      // 7e: athrow
      // 7f: astore 1
      // 80: aload 0
      // 81: monitorexit
      // 82: aload 1
      // 83: athrow
      // 84: astore 1
      // 85: aload 0
      // 86: monitorexit
      // 87: aload 1
      // 88: athrow
      // try (2 -> 11): 11 null
      // try (12 -> 14): 11 null
      // try (16 -> 25): 11 null
      // try (25 -> 42): 65 null
      // try (44 -> 51): 60 java/lang/RuntimeException
      // try (44 -> 51): 65 null
      // try (53 -> 58): 75 null
      // try (61 -> 65): 65 null
      // try (68 -> 73): 80 null
      // try (76 -> 78): 75 null
      // try (81 -> 83): 80 null
   }

   @Override
   protected void i() {
      if (this.l != null) {
         this.a(this.l);
      }

      if (this.y() || this.l == null) {
         this.t();
      }
   }

   @Override
   protected void j() {
      this.s();
   }

   @Override
   protected void k() {
      super.k();
      this.j();
      if (this.l != null && !this.l.isClosed()) {
         this.l.close();
      }

      this.l = null;
   }
}
