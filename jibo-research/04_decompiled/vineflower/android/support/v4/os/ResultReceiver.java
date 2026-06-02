package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.Parcelable.Creator;

public class ResultReceiver implements Parcelable {
   public static final Creator<ResultReceiver> CREATOR = new Creator<ResultReceiver>() {
      public ResultReceiver a(Parcel var1) {
         return new ResultReceiver(var1);
      }

      public ResultReceiver[] a(int var1) {
         return new ResultReceiver[var1];
      }
   };
   final boolean a = false;
   final Handler b = null;
   IResultReceiver c;

   ResultReceiver(Parcel var1) {
      this.c = IResultReceiver.Stub.a(var1.readStrongBinder());
   }

   protected void a(int var1, Bundle var2) {
   }

   public void b(int var1, Bundle var2) {
      if (this.a) {
         if (this.b != null) {
            this.b.post(new ResultReceiver.MyRunnable(this, var1, var2));
         } else {
            this.a(var1, var2);
         }
      } else if (this.c != null) {
         try {
            this.c.a(var1, var2);
         } catch (RemoteException var3) {
         }
      }
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel param1, int param2) {
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
      // 03: getfield android/support/v4/os/ResultReceiver.c Landroid/support/v4/os/IResultReceiver;
      // 06: ifnonnull 17
      // 09: new android/support/v4/os/ResultReceiver$MyResultReceiver
      // 0c: astore 3
      // 0d: aload 3
      // 0e: aload 0
      // 0f: invokespecial android/support/v4/os/ResultReceiver$MyResultReceiver.<init> (Landroid/support/v4/os/ResultReceiver;)V
      // 12: aload 0
      // 13: aload 3
      // 14: putfield android/support/v4/os/ResultReceiver.c Landroid/support/v4/os/IResultReceiver;
      // 17: aload 1
      // 18: aload 0
      // 19: getfield android/support/v4/os/ResultReceiver.c Landroid/support/v4/os/IResultReceiver;
      // 1c: invokeinterface android/support/v4/os/IResultReceiver.asBinder ()Landroid/os/IBinder; 1
      // 21: invokevirtual android/os/Parcel.writeStrongBinder (Landroid/os/IBinder;)V
      // 24: aload 0
      // 25: monitorexit
      // 26: return
      // 27: astore 1
      // 28: aload 0
      // 29: monitorexit
      // 2a: aload 1
      // 2b: athrow
      // try (2 -> 13): 21 null
      // try (13 -> 20): 21 null
      // try (22 -> 24): 21 null
   }

   class MyResultReceiver extends IResultReceiver.Stub {
      final ResultReceiver a;

      MyResultReceiver(ResultReceiver var1) {
         this.a = var1;
      }

      @Override
      public void a(int var1, Bundle var2) {
         if (this.a.b != null) {
            this.a.b.post(this.a.new MyRunnable(this.a, var1, var2));
         } else {
            this.a.a(var1, var2);
         }
      }
   }

   class MyRunnable implements Runnable {
      final int a;
      final Bundle b;
      final ResultReceiver c;

      MyRunnable(ResultReceiver var1, int var2, Bundle var3) {
         this.c = var1;
         this.a = var2;
         this.b = var3;
      }

      @Override
      public void run() {
         this.c.a(this.a, this.b);
      }
   }
}
