package net.sqlcipher;

import android.database.CharArrayBuffer;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CursorWindow extends android.database.CursorWindow implements Parcelable {
   public static final Creator<CursorWindow> CREATOR = new Creator<CursorWindow>() {
      public CursorWindow createFromParcel(Parcel var1) {
         return new CursorWindow(var1, 0);
      }

      public CursorWindow[] newArray(int var1) {
         return new CursorWindow[var1];
      }
   };
   private int mStartPos;
   private long nWindow;

   public CursorWindow(Parcel var1, int var2) {
      super(true);
      IBinder var3 = var1.readStrongBinder();
      this.mStartPos = var1.readInt();
      this.native_init(var3);
   }

   public CursorWindow(boolean var1) {
      super(var1);
      this.mStartPos = 0;
      this.native_init(var1);
   }

   private native boolean allocRow_native();

   private native void close_native();

   private native char[] copyStringToBuffer_native(int var1, int var2, int var3, CharArrayBuffer var4);

   private native void freeLastRow_native();

   private native byte[] getBlob_native(int var1, int var2);

   private native double getDouble_native(int var1, int var2);

   private native long getLong_native(int var1, int var2);

   private native int getNumRows_native();

   private native String getString_native(int var1, int var2);

   private native int getType_native(int var1, int var2);

   private native boolean isBlob_native(int var1, int var2);

   private native boolean isFloat_native(int var1, int var2);

   private native boolean isInteger_native(int var1, int var2);

   private native boolean isNull_native(int var1, int var2);

   private native boolean isString_native(int var1, int var2);

   private native void native_clear();

   private native IBinder native_getBinder();

   private native void native_init(IBinder var1);

   private native void native_init(boolean var1);

   public static CursorWindow newFromParcel(Parcel var0) {
      return (CursorWindow)CREATOR.createFromParcel(var0);
   }

   private native boolean putBlob_native(byte[] var1, int var2, int var3);

   private native boolean putDouble_native(double var1, int var3, int var4);

   private native boolean putLong_native(long var1, int var3, int var4);

   private native boolean putNull_native(int var1, int var2);

   private native boolean putString_native(String var1, int var2, int var3);

   private native boolean setNumColumns_native(int var1);

   public boolean allocRow() {
      this.acquireReference();

      try {
         return this.allocRow_native();
      } finally {
         this.releaseReference();
      }
   }

   public void clear() {
      this.acquireReference();

      try {
         this.mStartPos = 0;
         this.native_clear();
      } finally {
         this.releaseReference();
      }
   }

   public void close() {
      this.releaseReference();
   }

   public void copyStringToBuffer(int param1, int param2, CharArrayBuffer param3) {
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
      // 00: aload 3
      // 01: ifnonnull 0e
      // 04: new java/lang/IllegalArgumentException
      // 07: dup
      // 08: ldc "CharArrayBuffer should not be null"
      // 0a: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // 0d: athrow
      // 0e: aload 3
      // 0f: getfield android/database/CharArrayBuffer.data [C
      // 12: ifnonnull 1d
      // 15: aload 3
      // 16: bipush 64
      // 18: newarray 5
      // 1a: putfield android/database/CharArrayBuffer.data [C
      // 1d: aload 0
      // 1e: invokevirtual net/sqlcipher/CursorWindow.acquireReference ()V
      // 21: aload 0
      // 22: iload 1
      // 23: aload 0
      // 24: getfield net/sqlcipher/CursorWindow.mStartPos I
      // 27: isub
      // 28: iload 2
      // 29: aload 3
      // 2a: getfield android/database/CharArrayBuffer.data [C
      // 2d: arraylength
      // 2e: aload 3
      // 2f: invokespecial net/sqlcipher/CursorWindow.copyStringToBuffer_native (IIILandroid/database/CharArrayBuffer;)[C
      // 32: astore 4
      // 34: aload 4
      // 36: ifnull 3f
      // 39: aload 3
      // 3a: aload 4
      // 3c: putfield android/database/CharArrayBuffer.data [C
      // 3f: aload 0
      // 40: invokevirtual net/sqlcipher/CursorWindow.releaseReference ()V
      // 43: return
      // 44: astore 3
      // 45: aload 0
      // 46: invokevirtual net/sqlcipher/CursorWindow.releaseReference ()V
      // 49: aload 3
      // 4a: athrow
      // try (16 -> 28): 36 null
      // try (30 -> 33): 36 null
   }

   public int describeContents() {
      return 0;
   }

   protected void finalize() {
      if (this.nWindow != 0L) {
         this.close_native();
      }
   }

   public void freeLastRow() {
      this.acquireReference();

      try {
         this.freeLastRow_native();
      } finally {
         this.releaseReference();
      }
   }

   public byte[] getBlob(int var1, int var2) {
      this.acquireReference();

      try {
         return this.getBlob_native(var1 - this.mStartPos, var2);
      } finally {
         this.releaseReference();
      }
   }

   public double getDouble(int var1, int var2) {
      this.acquireReference();

      try {
         return this.getDouble_native(var1 - this.mStartPos, var2);
      } finally {
         this.releaseReference();
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public float getFloat(int var1, int var2) {
      this.acquireReference();
      boolean var8 = false /* VF: Semaphore variable */;

      double var3;
      try {
         var8 = true;
         var3 = this.getDouble_native(var1 - this.mStartPos, var2);
         var8 = false;
      } finally {
         if (var8) {
            this.releaseReference();
         }
      }

      float var5 = (float)var3;
      this.releaseReference();
      return var5;
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public int getInt(int var1, int var2) {
      this.acquireReference();
      boolean var7 = false /* VF: Semaphore variable */;

      long var3;
      try {
         var7 = true;
         var3 = this.getLong_native(var1 - this.mStartPos, var2);
         var7 = false;
      } finally {
         if (var7) {
            this.releaseReference();
         }
      }

      var1 = (int)var3;
      this.releaseReference();
      return var1;
   }

   public long getLong(int var1, int var2) {
      this.acquireReference();

      try {
         return this.getLong_native(var1 - this.mStartPos, var2);
      } finally {
         this.releaseReference();
      }
   }

   public int getNumRows() {
      this.acquireReference();

      try {
         return this.getNumRows_native();
      } finally {
         this.releaseReference();
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public short getShort(int var1, int var2) {
      this.acquireReference();
      boolean var8 = false /* VF: Semaphore variable */;

      long var4;
      try {
         var8 = true;
         var4 = this.getLong_native(var1 - this.mStartPos, var2);
         var8 = false;
      } finally {
         if (var8) {
            this.releaseReference();
         }
      }

      short var3 = (short)var4;
      this.releaseReference();
      return var3;
   }

   public int getStartPosition() {
      return this.mStartPos;
   }

   public String getString(int var1, int var2) {
      this.acquireReference();

      try {
         return this.getString_native(var1 - this.mStartPos, var2);
      } finally {
         this.releaseReference();
      }
   }

   public int getType(int var1, int var2) {
      this.acquireReference();

      try {
         return this.getType_native(var1 - this.mStartPos, var2);
      } finally {
         this.releaseReference();
      }
   }

   public boolean isBlob(int var1, int var2) {
      this.acquireReference();

      try {
         return this.isBlob_native(var1 - this.mStartPos, var2);
      } finally {
         this.releaseReference();
      }
   }

   public boolean isFloat(int var1, int var2) {
      this.acquireReference();

      try {
         return this.isFloat_native(var1 - this.mStartPos, var2);
      } finally {
         this.releaseReference();
      }
   }

   public boolean isLong(int var1, int var2) {
      this.acquireReference();

      try {
         return this.isInteger_native(var1 - this.mStartPos, var2);
      } finally {
         this.releaseReference();
      }
   }

   public boolean isNull(int var1, int var2) {
      this.acquireReference();

      try {
         return this.isNull_native(var1 - this.mStartPos, var2);
      } finally {
         this.releaseReference();
      }
   }

   public boolean isString(int var1, int var2) {
      this.acquireReference();

      try {
         return this.isString_native(var1 - this.mStartPos, var2);
      } finally {
         this.releaseReference();
      }
   }

   protected void onAllReferencesReleased() {
      this.close_native();
      super.onAllReferencesReleased();
   }

   public boolean putBlob(byte[] var1, int var2, int var3) {
      this.acquireReference();

      try {
         return this.putBlob_native(var1, var2 - this.mStartPos, var3);
      } finally {
         this.releaseReference();
      }
   }

   public boolean putDouble(double var1, int var3, int var4) {
      this.acquireReference();

      try {
         return this.putDouble_native(var1, var3 - this.mStartPos, var4);
      } finally {
         this.releaseReference();
      }
   }

   public boolean putLong(long var1, int var3, int var4) {
      this.acquireReference();

      try {
         return this.putLong_native(var1, var3 - this.mStartPos, var4);
      } finally {
         this.releaseReference();
      }
   }

   public boolean putNull(int var1, int var2) {
      this.acquireReference();

      try {
         return this.putNull_native(var1 - this.mStartPos, var2);
      } finally {
         this.releaseReference();
      }
   }

   public boolean putString(String var1, int var2, int var3) {
      this.acquireReference();

      try {
         return this.putString_native(var1, var2 - this.mStartPos, var3);
      } finally {
         this.releaseReference();
      }
   }

   public boolean setNumColumns(int var1) {
      this.acquireReference();

      try {
         return this.setNumColumns_native(var1);
      } finally {
         this.releaseReference();
      }
   }

   public void setStartPosition(int var1) {
      this.mStartPos = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeStrongBinder(this.native_getBinder());
      var1.writeInt(this.mStartPos);
   }
}
