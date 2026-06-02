package net.sqlcipher;

import android.database.CharArrayBuffer;

public abstract class AbstractWindowedCursor extends AbstractCursor {
   protected CursorWindow mWindow;

   @Override
   protected void checkPosition() {
      super.checkPosition();
      if (this.mWindow == null) {
         throw new StaleDataException("Access closed cursor");
      }
   }

   @Override
   public void copyStringToBuffer(int param1, CharArrayBuffer param2) {
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
      // 01: invokevirtual net/sqlcipher/AbstractWindowedCursor.checkPosition ()V
      // 04: aload 0
      // 05: getfield net/sqlcipher/AbstractWindowedCursor.mUpdatedRows Ljava/util/HashMap;
      // 08: astore 3
      // 09: aload 3
      // 0a: monitorenter
      // 0b: aload 0
      // 0c: iload 1
      // 0d: invokevirtual net/sqlcipher/AbstractWindowedCursor.isFieldUpdated (I)Z
      // 10: ifeq 19
      // 13: aload 0
      // 14: iload 1
      // 15: aload 2
      // 16: invokespecial net/sqlcipher/AbstractCursor.copyStringToBuffer (ILandroid/database/CharArrayBuffer;)V
      // 19: aload 3
      // 1a: monitorexit
      // 1b: aload 0
      // 1c: getfield net/sqlcipher/AbstractWindowedCursor.mWindow Lnet/sqlcipher/CursorWindow;
      // 1f: aload 0
      // 20: getfield net/sqlcipher/AbstractWindowedCursor.mPos I
      // 23: iload 1
      // 24: aload 2
      // 25: invokevirtual net/sqlcipher/CursorWindow.copyStringToBuffer (IILandroid/database/CharArrayBuffer;)V
      // 28: return
      // 29: astore 2
      // 2a: aload 3
      // 2b: monitorexit
      // 2c: aload 2
      // 2d: athrow
      // try (7 -> 15): 25 null
      // try (15 -> 17): 25 null
      // try (26 -> 28): 25 null
   }

   @Override
   public byte[] getBlob(int param1) {
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
      // 01: invokevirtual net/sqlcipher/AbstractWindowedCursor.checkPosition ()V
      // 04: aload 0
      // 05: getfield net/sqlcipher/AbstractWindowedCursor.mUpdatedRows Ljava/util/HashMap;
      // 08: astore 3
      // 09: aload 3
      // 0a: monitorenter
      // 0b: aload 0
      // 0c: iload 1
      // 0d: invokevirtual net/sqlcipher/AbstractWindowedCursor.isFieldUpdated (I)Z
      // 10: ifeq 20
      // 13: aload 0
      // 14: iload 1
      // 15: invokevirtual net/sqlcipher/AbstractWindowedCursor.getUpdatedField (I)Ljava/lang/Object;
      // 18: checkcast [B
      // 1b: astore 2
      // 1c: aload 3
      // 1d: monitorexit
      // 1e: aload 2
      // 1f: areturn
      // 20: aload 3
      // 21: monitorexit
      // 22: aload 0
      // 23: getfield net/sqlcipher/AbstractWindowedCursor.mWindow Lnet/sqlcipher/CursorWindow;
      // 26: aload 0
      // 27: getfield net/sqlcipher/AbstractWindowedCursor.mPos I
      // 2a: iload 1
      // 2b: invokevirtual net/sqlcipher/CursorWindow.getBlob (II)[B
      // 2e: astore 2
      // 2f: goto 1e
      // 32: astore 2
      // 33: aload 3
      // 34: monitorexit
      // 35: aload 2
      // 36: athrow
      // try (7 -> 18): 30 null
      // try (20 -> 22): 30 null
      // try (31 -> 33): 30 null
   }

   @Override
   public double getDouble(int param1) {
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
      // 01: invokevirtual net/sqlcipher/AbstractWindowedCursor.checkPosition ()V
      // 04: aload 0
      // 05: getfield net/sqlcipher/AbstractWindowedCursor.mUpdatedRows Ljava/util/HashMap;
      // 08: astore 5
      // 0a: aload 5
      // 0c: monitorenter
      // 0d: aload 0
      // 0e: iload 1
      // 0f: invokevirtual net/sqlcipher/AbstractWindowedCursor.isFieldUpdated (I)Z
      // 12: ifeq 26
      // 15: aload 0
      // 16: iload 1
      // 17: invokevirtual net/sqlcipher/AbstractWindowedCursor.getUpdatedField (I)Ljava/lang/Object;
      // 1a: checkcast java/lang/Number
      // 1d: invokevirtual java/lang/Number.doubleValue ()D
      // 20: dstore 2
      // 21: aload 5
      // 23: monitorexit
      // 24: dload 2
      // 25: dreturn
      // 26: aload 5
      // 28: monitorexit
      // 29: aload 0
      // 2a: getfield net/sqlcipher/AbstractWindowedCursor.mWindow Lnet/sqlcipher/CursorWindow;
      // 2d: aload 0
      // 2e: getfield net/sqlcipher/AbstractWindowedCursor.mPos I
      // 31: iload 1
      // 32: invokevirtual net/sqlcipher/CursorWindow.getDouble (II)D
      // 35: dstore 2
      // 36: goto 24
      // 39: astore 4
      // 3b: aload 5
      // 3d: monitorexit
      // 3e: aload 4
      // 40: athrow
      // try (7 -> 19): 31 null
      // try (21 -> 23): 31 null
      // try (32 -> 34): 31 null
   }

   @Override
   public float getFloat(int param1) {
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
      // 01: invokevirtual net/sqlcipher/AbstractWindowedCursor.checkPosition ()V
      // 04: aload 0
      // 05: getfield net/sqlcipher/AbstractWindowedCursor.mUpdatedRows Ljava/util/HashMap;
      // 08: astore 4
      // 0a: aload 4
      // 0c: monitorenter
      // 0d: aload 0
      // 0e: iload 1
      // 0f: invokevirtual net/sqlcipher/AbstractWindowedCursor.isFieldUpdated (I)Z
      // 12: ifeq 26
      // 15: aload 0
      // 16: iload 1
      // 17: invokevirtual net/sqlcipher/AbstractWindowedCursor.getUpdatedField (I)Ljava/lang/Object;
      // 1a: checkcast java/lang/Number
      // 1d: invokevirtual java/lang/Number.floatValue ()F
      // 20: fstore 2
      // 21: aload 4
      // 23: monitorexit
      // 24: fload 2
      // 25: freturn
      // 26: aload 4
      // 28: monitorexit
      // 29: aload 0
      // 2a: getfield net/sqlcipher/AbstractWindowedCursor.mWindow Lnet/sqlcipher/CursorWindow;
      // 2d: aload 0
      // 2e: getfield net/sqlcipher/AbstractWindowedCursor.mPos I
      // 31: iload 1
      // 32: invokevirtual net/sqlcipher/CursorWindow.getFloat (II)F
      // 35: fstore 2
      // 36: goto 24
      // 39: astore 3
      // 3a: aload 4
      // 3c: monitorexit
      // 3d: aload 3
      // 3e: athrow
      // try (7 -> 19): 31 null
      // try (21 -> 23): 31 null
      // try (32 -> 34): 31 null
   }

   @Override
   public int getInt(int param1) {
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
      // 01: invokevirtual net/sqlcipher/AbstractWindowedCursor.checkPosition ()V
      // 04: aload 0
      // 05: getfield net/sqlcipher/AbstractWindowedCursor.mUpdatedRows Ljava/util/HashMap;
      // 08: astore 2
      // 09: aload 2
      // 0a: monitorenter
      // 0b: aload 0
      // 0c: iload 1
      // 0d: invokevirtual net/sqlcipher/AbstractWindowedCursor.isFieldUpdated (I)Z
      // 10: ifeq 23
      // 13: aload 0
      // 14: iload 1
      // 15: invokevirtual net/sqlcipher/AbstractWindowedCursor.getUpdatedField (I)Ljava/lang/Object;
      // 18: checkcast java/lang/Number
      // 1b: invokevirtual java/lang/Number.intValue ()I
      // 1e: istore 1
      // 1f: aload 2
      // 20: monitorexit
      // 21: iload 1
      // 22: ireturn
      // 23: aload 2
      // 24: monitorexit
      // 25: aload 0
      // 26: getfield net/sqlcipher/AbstractWindowedCursor.mWindow Lnet/sqlcipher/CursorWindow;
      // 29: aload 0
      // 2a: getfield net/sqlcipher/AbstractWindowedCursor.mPos I
      // 2d: iload 1
      // 2e: invokevirtual net/sqlcipher/CursorWindow.getInt (II)I
      // 31: istore 1
      // 32: goto 21
      // 35: astore 3
      // 36: aload 2
      // 37: monitorexit
      // 38: aload 3
      // 39: athrow
      // try (7 -> 19): 31 null
      // try (21 -> 23): 31 null
      // try (32 -> 34): 31 null
   }

   @Override
   public long getLong(int param1) {
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
      // 01: invokevirtual net/sqlcipher/AbstractWindowedCursor.checkPosition ()V
      // 04: aload 0
      // 05: getfield net/sqlcipher/AbstractWindowedCursor.mUpdatedRows Ljava/util/HashMap;
      // 08: astore 4
      // 0a: aload 4
      // 0c: monitorenter
      // 0d: aload 0
      // 0e: iload 1
      // 0f: invokevirtual net/sqlcipher/AbstractWindowedCursor.isFieldUpdated (I)Z
      // 12: ifeq 26
      // 15: aload 0
      // 16: iload 1
      // 17: invokevirtual net/sqlcipher/AbstractWindowedCursor.getUpdatedField (I)Ljava/lang/Object;
      // 1a: checkcast java/lang/Number
      // 1d: invokevirtual java/lang/Number.longValue ()J
      // 20: lstore 2
      // 21: aload 4
      // 23: monitorexit
      // 24: lload 2
      // 25: lreturn
      // 26: aload 4
      // 28: monitorexit
      // 29: aload 0
      // 2a: getfield net/sqlcipher/AbstractWindowedCursor.mWindow Lnet/sqlcipher/CursorWindow;
      // 2d: aload 0
      // 2e: getfield net/sqlcipher/AbstractWindowedCursor.mPos I
      // 31: iload 1
      // 32: invokevirtual net/sqlcipher/CursorWindow.getLong (II)J
      // 35: lstore 2
      // 36: goto 24
      // 39: astore 5
      // 3b: aload 4
      // 3d: monitorexit
      // 3e: aload 5
      // 40: athrow
      // try (7 -> 19): 31 null
      // try (21 -> 23): 31 null
      // try (32 -> 34): 31 null
   }

   @Override
   public short getShort(int param1) {
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
      // 01: invokevirtual net/sqlcipher/AbstractWindowedCursor.checkPosition ()V
      // 04: aload 0
      // 05: getfield net/sqlcipher/AbstractWindowedCursor.mUpdatedRows Ljava/util/HashMap;
      // 08: astore 3
      // 09: aload 3
      // 0a: monitorenter
      // 0b: aload 0
      // 0c: iload 1
      // 0d: invokevirtual net/sqlcipher/AbstractWindowedCursor.isFieldUpdated (I)Z
      // 10: ifeq 23
      // 13: aload 0
      // 14: iload 1
      // 15: invokevirtual net/sqlcipher/AbstractWindowedCursor.getUpdatedField (I)Ljava/lang/Object;
      // 18: checkcast java/lang/Number
      // 1b: invokevirtual java/lang/Number.shortValue ()S
      // 1e: istore 2
      // 1f: aload 3
      // 20: monitorexit
      // 21: iload 2
      // 22: ireturn
      // 23: aload 3
      // 24: monitorexit
      // 25: aload 0
      // 26: getfield net/sqlcipher/AbstractWindowedCursor.mWindow Lnet/sqlcipher/CursorWindow;
      // 29: aload 0
      // 2a: getfield net/sqlcipher/AbstractWindowedCursor.mPos I
      // 2d: iload 1
      // 2e: invokevirtual net/sqlcipher/CursorWindow.getShort (II)S
      // 31: istore 2
      // 32: goto 21
      // 35: astore 4
      // 37: aload 3
      // 38: monitorexit
      // 39: aload 4
      // 3b: athrow
      // try (7 -> 19): 31 null
      // try (21 -> 23): 31 null
      // try (32 -> 34): 31 null
   }

   @Override
   public String getString(int param1) {
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
      // 01: invokevirtual net/sqlcipher/AbstractWindowedCursor.checkPosition ()V
      // 04: aload 0
      // 05: getfield net/sqlcipher/AbstractWindowedCursor.mUpdatedRows Ljava/util/HashMap;
      // 08: astore 3
      // 09: aload 3
      // 0a: monitorenter
      // 0b: aload 0
      // 0c: iload 1
      // 0d: invokevirtual net/sqlcipher/AbstractWindowedCursor.isFieldUpdated (I)Z
      // 10: ifeq 20
      // 13: aload 0
      // 14: iload 1
      // 15: invokevirtual net/sqlcipher/AbstractWindowedCursor.getUpdatedField (I)Ljava/lang/Object;
      // 18: checkcast java/lang/String
      // 1b: astore 2
      // 1c: aload 3
      // 1d: monitorexit
      // 1e: aload 2
      // 1f: areturn
      // 20: aload 3
      // 21: monitorexit
      // 22: aload 0
      // 23: getfield net/sqlcipher/AbstractWindowedCursor.mWindow Lnet/sqlcipher/CursorWindow;
      // 26: aload 0
      // 27: getfield net/sqlcipher/AbstractWindowedCursor.mPos I
      // 2a: iload 1
      // 2b: invokevirtual net/sqlcipher/CursorWindow.getString (II)Ljava/lang/String;
      // 2e: astore 2
      // 2f: goto 1e
      // 32: astore 2
      // 33: aload 3
      // 34: monitorexit
      // 35: aload 2
      // 36: athrow
      // try (7 -> 18): 30 null
      // try (20 -> 22): 30 null
      // try (31 -> 33): 30 null
   }

   @Override
   public int getType(int var1) {
      this.checkPosition();
      return this.mWindow.getType(this.mPos, var1);
   }

   @Override
   public CursorWindow getWindow() {
      return this.mWindow;
   }

   public boolean hasWindow() {
      boolean var1;
      if (this.mWindow != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean isBlob(int param1) {
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
      // 01: invokevirtual net/sqlcipher/AbstractWindowedCursor.checkPosition ()V
      // 04: aload 0
      // 05: getfield net/sqlcipher/AbstractWindowedCursor.mUpdatedRows Ljava/util/HashMap;
      // 08: astore 3
      // 09: aload 3
      // 0a: monitorenter
      // 0b: aload 0
      // 0c: iload 1
      // 0d: invokevirtual net/sqlcipher/AbstractWindowedCursor.isFieldUpdated (I)Z
      // 10: ifeq 32
      // 13: aload 0
      // 14: iload 1
      // 15: invokevirtual net/sqlcipher/AbstractWindowedCursor.getUpdatedField (I)Ljava/lang/Object;
      // 18: astore 4
      // 1a: aload 4
      // 1c: ifnull 27
      // 1f: aload 4
      // 21: instanceof [B
      // 24: ifeq 2d
      // 27: bipush 1
      // 28: istore 2
      // 29: aload 3
      // 2a: monitorexit
      // 2b: iload 2
      // 2c: ireturn
      // 2d: bipush 0
      // 2e: istore 2
      // 2f: goto 29
      // 32: aload 3
      // 33: monitorexit
      // 34: aload 0
      // 35: getfield net/sqlcipher/AbstractWindowedCursor.mWindow Lnet/sqlcipher/CursorWindow;
      // 38: aload 0
      // 39: getfield net/sqlcipher/AbstractWindowedCursor.mPos I
      // 3c: iload 1
      // 3d: invokevirtual net/sqlcipher/CursorWindow.isBlob (II)Z
      // 40: istore 2
      // 41: goto 2b
      // 44: astore 4
      // 46: aload 3
      // 47: monitorexit
      // 48: aload 4
      // 4a: athrow
      // try (7 -> 15): 39 null
      // try (17 -> 20): 39 null
      // try (22 -> 24): 39 null
      // try (29 -> 31): 39 null
      // try (40 -> 42): 39 null
   }

   public boolean isFloat(int param1) {
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
      // 01: invokevirtual net/sqlcipher/AbstractWindowedCursor.checkPosition ()V
      // 04: aload 0
      // 05: getfield net/sqlcipher/AbstractWindowedCursor.mUpdatedRows Ljava/util/HashMap;
      // 08: astore 3
      // 09: aload 3
      // 0a: monitorenter
      // 0b: aload 0
      // 0c: iload 1
      // 0d: invokevirtual net/sqlcipher/AbstractWindowedCursor.isFieldUpdated (I)Z
      // 10: ifeq 3a
      // 13: aload 0
      // 14: iload 1
      // 15: invokevirtual net/sqlcipher/AbstractWindowedCursor.getUpdatedField (I)Ljava/lang/Object;
      // 18: astore 4
      // 1a: aload 4
      // 1c: ifnull 35
      // 1f: aload 4
      // 21: instanceof java/lang/Float
      // 24: ifne 2f
      // 27: aload 4
      // 29: instanceof java/lang/Double
      // 2c: ifeq 35
      // 2f: bipush 1
      // 30: istore 2
      // 31: aload 3
      // 32: monitorexit
      // 33: iload 2
      // 34: ireturn
      // 35: bipush 0
      // 36: istore 2
      // 37: goto 31
      // 3a: aload 3
      // 3b: monitorexit
      // 3c: aload 0
      // 3d: getfield net/sqlcipher/AbstractWindowedCursor.mWindow Lnet/sqlcipher/CursorWindow;
      // 40: aload 0
      // 41: getfield net/sqlcipher/AbstractWindowedCursor.mPos I
      // 44: iload 1
      // 45: invokevirtual net/sqlcipher/CursorWindow.isFloat (II)Z
      // 48: istore 2
      // 49: goto 33
      // 4c: astore 4
      // 4e: aload 3
      // 4f: monitorexit
      // 50: aload 4
      // 52: athrow
      // try (7 -> 15): 42 null
      // try (17 -> 23): 42 null
      // try (25 -> 27): 42 null
      // try (32 -> 34): 42 null
      // try (43 -> 45): 42 null
   }

   public boolean isLong(int param1) {
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
      // 01: invokevirtual net/sqlcipher/AbstractWindowedCursor.checkPosition ()V
      // 04: aload 0
      // 05: getfield net/sqlcipher/AbstractWindowedCursor.mUpdatedRows Ljava/util/HashMap;
      // 08: astore 3
      // 09: aload 3
      // 0a: monitorenter
      // 0b: aload 0
      // 0c: iload 1
      // 0d: invokevirtual net/sqlcipher/AbstractWindowedCursor.isFieldUpdated (I)Z
      // 10: ifeq 3a
      // 13: aload 0
      // 14: iload 1
      // 15: invokevirtual net/sqlcipher/AbstractWindowedCursor.getUpdatedField (I)Ljava/lang/Object;
      // 18: astore 4
      // 1a: aload 4
      // 1c: ifnull 35
      // 1f: aload 4
      // 21: instanceof java/lang/Integer
      // 24: ifne 2f
      // 27: aload 4
      // 29: instanceof java/lang/Long
      // 2c: ifeq 35
      // 2f: bipush 1
      // 30: istore 2
      // 31: aload 3
      // 32: monitorexit
      // 33: iload 2
      // 34: ireturn
      // 35: bipush 0
      // 36: istore 2
      // 37: goto 31
      // 3a: aload 3
      // 3b: monitorexit
      // 3c: aload 0
      // 3d: getfield net/sqlcipher/AbstractWindowedCursor.mWindow Lnet/sqlcipher/CursorWindow;
      // 40: aload 0
      // 41: getfield net/sqlcipher/AbstractWindowedCursor.mPos I
      // 44: iload 1
      // 45: invokevirtual net/sqlcipher/CursorWindow.isLong (II)Z
      // 48: istore 2
      // 49: goto 33
      // 4c: astore 4
      // 4e: aload 3
      // 4f: monitorexit
      // 50: aload 4
      // 52: athrow
      // try (7 -> 15): 42 null
      // try (17 -> 23): 42 null
      // try (25 -> 27): 42 null
      // try (32 -> 34): 42 null
      // try (43 -> 45): 42 null
   }

   @Override
   public boolean isNull(int param1) {
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
      // 01: invokevirtual net/sqlcipher/AbstractWindowedCursor.checkPosition ()V
      // 04: aload 0
      // 05: getfield net/sqlcipher/AbstractWindowedCursor.mUpdatedRows Ljava/util/HashMap;
      // 08: astore 3
      // 09: aload 3
      // 0a: monitorenter
      // 0b: aload 0
      // 0c: iload 1
      // 0d: invokevirtual net/sqlcipher/AbstractWindowedCursor.isFieldUpdated (I)Z
      // 10: ifeq 26
      // 13: aload 0
      // 14: iload 1
      // 15: invokevirtual net/sqlcipher/AbstractWindowedCursor.getUpdatedField (I)Ljava/lang/Object;
      // 18: ifnonnull 21
      // 1b: bipush 1
      // 1c: istore 2
      // 1d: aload 3
      // 1e: monitorexit
      // 1f: iload 2
      // 20: ireturn
      // 21: bipush 0
      // 22: istore 2
      // 23: goto 1d
      // 26: aload 3
      // 27: monitorexit
      // 28: aload 0
      // 29: getfield net/sqlcipher/AbstractWindowedCursor.mWindow Lnet/sqlcipher/CursorWindow;
      // 2c: aload 0
      // 2d: getfield net/sqlcipher/AbstractWindowedCursor.mPos I
      // 30: iload 1
      // 31: invokevirtual net/sqlcipher/CursorWindow.isNull (II)Z
      // 34: istore 2
      // 35: goto 1f
      // 38: astore 4
      // 3a: aload 3
      // 3b: monitorexit
      // 3c: aload 4
      // 3e: athrow
      // try (7 -> 15): 34 null
      // try (17 -> 19): 34 null
      // try (24 -> 26): 34 null
      // try (35 -> 37): 34 null
   }

   public boolean isString(int param1) {
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
      // 01: invokevirtual net/sqlcipher/AbstractWindowedCursor.checkPosition ()V
      // 04: aload 0
      // 05: getfield net/sqlcipher/AbstractWindowedCursor.mUpdatedRows Ljava/util/HashMap;
      // 08: astore 3
      // 09: aload 3
      // 0a: monitorenter
      // 0b: aload 0
      // 0c: iload 1
      // 0d: invokevirtual net/sqlcipher/AbstractWindowedCursor.isFieldUpdated (I)Z
      // 10: ifeq 32
      // 13: aload 0
      // 14: iload 1
      // 15: invokevirtual net/sqlcipher/AbstractWindowedCursor.getUpdatedField (I)Ljava/lang/Object;
      // 18: astore 4
      // 1a: aload 4
      // 1c: ifnull 27
      // 1f: aload 4
      // 21: instanceof java/lang/String
      // 24: ifeq 2d
      // 27: bipush 1
      // 28: istore 2
      // 29: aload 3
      // 2a: monitorexit
      // 2b: iload 2
      // 2c: ireturn
      // 2d: bipush 0
      // 2e: istore 2
      // 2f: goto 29
      // 32: aload 3
      // 33: monitorexit
      // 34: aload 0
      // 35: getfield net/sqlcipher/AbstractWindowedCursor.mWindow Lnet/sqlcipher/CursorWindow;
      // 38: aload 0
      // 39: getfield net/sqlcipher/AbstractWindowedCursor.mPos I
      // 3c: iload 1
      // 3d: invokevirtual net/sqlcipher/CursorWindow.isString (II)Z
      // 40: istore 2
      // 41: goto 2b
      // 44: astore 4
      // 46: aload 3
      // 47: monitorexit
      // 48: aload 4
      // 4a: athrow
      // try (7 -> 15): 39 null
      // try (17 -> 20): 39 null
      // try (22 -> 24): 39 null
      // try (29 -> 31): 39 null
      // try (40 -> 42): 39 null
   }

   public void setWindow(CursorWindow var1) {
      if (this.mWindow != null) {
         this.mWindow.close();
      }

      this.mWindow = var1;
   }
}
