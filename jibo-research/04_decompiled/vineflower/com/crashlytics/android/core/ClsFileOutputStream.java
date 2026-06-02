package com.crashlytics.android.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

class ClsFileOutputStream extends FileOutputStream {
   public static final FilenameFilter a = new FilenameFilter() {
      @Override
      public boolean accept(File var1, String var2) {
         return var2.endsWith(".cls_temp");
      }
   };
   private final String b;
   private File c;
   private File d;
   private boolean e = false;

   public ClsFileOutputStream(File var1, String var2) throws FileNotFoundException {
      super(new File(var1, var2 + ".cls_temp"));
      this.b = var1 + File.separator + var2;
      this.c = new File(this.b + ".cls_temp");
   }

   public void a() throws IOException {
      if (!this.e) {
         this.e = true;
         super.flush();
         super.close();
      }
   }

   @Override
   public void close() throws IOException {
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
      // 03: getfield com/crashlytics/android/core/ClsFileOutputStream.e Z
      // 06: istore 1
      // 07: iload 1
      // 08: ifeq 0e
      // 0b: aload 0
      // 0c: monitorexit
      // 0d: return
      // 0e: aload 0
      // 0f: bipush 1
      // 10: putfield com/crashlytics/android/core/ClsFileOutputStream.e Z
      // 13: aload 0
      // 14: invokespecial java/io/FileOutputStream.flush ()V
      // 17: aload 0
      // 18: invokespecial java/io/FileOutputStream.close ()V
      // 1b: new java/io/File
      // 1e: astore 3
      // 1f: new java/lang/StringBuilder
      // 22: astore 2
      // 23: aload 2
      // 24: invokespecial java/lang/StringBuilder.<init> ()V
      // 27: aload 3
      // 28: aload 2
      // 29: aload 0
      // 2a: getfield com/crashlytics/android/core/ClsFileOutputStream.b Ljava/lang/String;
      // 2d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 30: ldc ".cls"
      // 32: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 35: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 38: invokespecial java/io/File.<init> (Ljava/lang/String;)V
      // 3b: aload 0
      // 3c: getfield com/crashlytics/android/core/ClsFileOutputStream.c Ljava/io/File;
      // 3f: aload 3
      // 40: invokevirtual java/io/File.renameTo (Ljava/io/File;)Z
      // 43: ifeq 58
      // 46: aload 0
      // 47: aconst_null
      // 48: putfield com/crashlytics/android/core/ClsFileOutputStream.c Ljava/io/File;
      // 4b: aload 0
      // 4c: aload 3
      // 4d: putfield com/crashlytics/android/core/ClsFileOutputStream.d Ljava/io/File;
      // 50: goto 0b
      // 53: astore 2
      // 54: aload 0
      // 55: monitorexit
      // 56: aload 2
      // 57: athrow
      // 58: ldc ""
      // 5a: astore 2
      // 5b: aload 3
      // 5c: invokevirtual java/io/File.exists ()Z
      // 5f: ifeq 9a
      // 62: ldc " (target already exists)"
      // 64: astore 2
      // 65: new java/io/IOException
      // 68: astore 4
      // 6a: new java/lang/StringBuilder
      // 6d: astore 5
      // 6f: aload 5
      // 71: invokespecial java/lang/StringBuilder.<init> ()V
      // 74: aload 4
      // 76: aload 5
      // 78: ldc "Could not rename temp file: "
      // 7a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 7d: aload 0
      // 7e: getfield com/crashlytics/android/core/ClsFileOutputStream.c Ljava/io/File;
      // 81: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 84: ldc " -> "
      // 86: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 89: aload 3
      // 8a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 8d: aload 2
      // 8e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 91: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 94: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 97: aload 4
      // 99: athrow
      // 9a: aload 0
      // 9b: getfield com/crashlytics/android/core/ClsFileOutputStream.c Ljava/io/File;
      // 9e: invokevirtual java/io/File.exists ()Z
      // a1: ifne 65
      // a4: ldc " (source does not exist)"
      // a6: astore 2
      // a7: goto 65
      // try (2 -> 5): 44 null
      // try (10 -> 43): 44 null
      // try (51 -> 54): 44 null
      // try (56 -> 79): 44 null
      // try (79 -> 83): 44 null
   }
}
