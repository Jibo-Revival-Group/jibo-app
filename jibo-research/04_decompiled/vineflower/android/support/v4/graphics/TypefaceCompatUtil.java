package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Process;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class TypefaceCompatUtil {
   public static File a(Context var0) {
      String var4 = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
      int var1 = 0;

      while (true) {
         if (var1 >= 100) {
            var6 = null;
            break;
         }

         File var3 = new File(var0.getCacheDir(), var4 + var1);

         label20: {
            boolean var2;
            try {
               var2 = var3.createNewFile();
            } catch (IOException var5) {
               break label20;
            }

            if (var2) {
               var6 = var3;
               break;
            }
         }

         var1++;
      }

      return var6;
   }

   public static ByteBuffer a(Context param0, Resources param1, int param2) {
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
      // 00: aconst_null
      // 01: astore 4
      // 03: aload 0
      // 04: invokestatic android/support/v4/graphics/TypefaceCompatUtil.a (Landroid/content/Context;)Ljava/io/File;
      // 07: astore 5
      // 09: aload 5
      // 0b: ifnonnull 13
      // 0e: aload 4
      // 10: astore 0
      // 11: aload 0
      // 12: areturn
      // 13: aload 5
      // 15: aload 1
      // 16: iload 2
      // 17: invokestatic android/support/v4/graphics/TypefaceCompatUtil.a (Ljava/io/File;Landroid/content/res/Resources;I)Z
      // 1a: istore 3
      // 1b: iload 3
      // 1c: ifne 2b
      // 1f: aload 5
      // 21: invokevirtual java/io/File.delete ()Z
      // 24: pop
      // 25: aload 4
      // 27: astore 0
      // 28: goto 11
      // 2b: aload 5
      // 2d: invokestatic android/support/v4/graphics/TypefaceCompatUtil.a (Ljava/io/File;)Ljava/nio/ByteBuffer;
      // 30: astore 0
      // 31: aload 5
      // 33: invokevirtual java/io/File.delete ()Z
      // 36: pop
      // 37: goto 11
      // 3a: astore 0
      // 3b: aload 5
      // 3d: invokevirtual java/io/File.delete ()Z
      // 40: pop
      // 41: aload 0
      // 42: athrow
      // try (11 -> 16): 31 null
      // try (24 -> 27): 31 null
   }

   public static ByteBuffer a(Context param0, CancellationSignal param1, Uri param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 04: astore 0
      // 05: aload 0
      // 06: aload 2
      // 07: ldc "r"
      // 09: aload 1
      // 0a: invokevirtual android/content/ContentResolver.openFileDescriptor (Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
      // 0d: astore 2
      // 0e: aload 2
      // 0f: ifnonnull 38
      // 12: aload 2
      // 13: ifnull 1e
      // 16: bipush 0
      // 17: ifeq 31
      // 1a: aload 2
      // 1b: invokevirtual android/os/ParcelFileDescriptor.close ()V
      // 1e: aconst_null
      // 1f: astore 0
      // 20: aload 0
      // 21: areturn
      // 22: astore 0
      // 23: new java/lang/NullPointerException
      // 26: dup
      // 27: invokespecial java/lang/NullPointerException.<init> ()V
      // 2a: athrow
      // 2b: astore 0
      // 2c: aconst_null
      // 2d: astore 0
      // 2e: goto 20
      // 31: aload 2
      // 32: invokevirtual android/os/ParcelFileDescriptor.close ()V
      // 35: goto 1e
      // 38: new java/io/FileInputStream
      // 3b: astore 5
      // 3d: aload 5
      // 3f: aload 2
      // 40: invokevirtual android/os/ParcelFileDescriptor.getFileDescriptor ()Ljava/io/FileDescriptor;
      // 43: invokespecial java/io/FileInputStream.<init> (Ljava/io/FileDescriptor;)V
      // 46: aload 5
      // 48: invokevirtual java/io/FileInputStream.getChannel ()Ljava/nio/channels/FileChannel;
      // 4b: astore 0
      // 4c: aload 0
      // 4d: invokevirtual java/nio/channels/FileChannel.size ()J
      // 50: lstore 3
      // 51: aload 0
      // 52: getstatic java/nio/channels/FileChannel$MapMode.READ_ONLY Ljava/nio/channels/FileChannel$MapMode;
      // 55: lconst_0
      // 56: lload 3
      // 57: invokevirtual java/nio/channels/FileChannel.map (Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
      // 5a: astore 1
      // 5b: aload 5
      // 5d: ifnull 69
      // 60: bipush 0
      // 61: ifeq a0
      // 64: aload 5
      // 66: invokevirtual java/io/FileInputStream.close ()V
      // 69: aload 1
      // 6a: astore 0
      // 6b: aload 2
      // 6c: ifnull 20
      // 6f: bipush 0
      // 70: ifeq ae
      // 73: aload 2
      // 74: invokevirtual android/os/ParcelFileDescriptor.close ()V
      // 77: aload 1
      // 78: astore 0
      // 79: goto 20
      // 7c: astore 0
      // 7d: new java/lang/NullPointerException
      // 80: dup
      // 81: invokespecial java/lang/NullPointerException.<init> ()V
      // 84: athrow
      // 85: astore 0
      // 86: new java/lang/NullPointerException
      // 89: dup
      // 8a: invokespecial java/lang/NullPointerException.<init> ()V
      // 8d: athrow
      // 8e: astore 0
      // 8f: aload 0
      // 90: athrow
      // 91: astore 1
      // 92: aload 2
      // 93: ifnull 9e
      // 96: aload 0
      // 97: ifnull e7
      // 9a: aload 2
      // 9b: invokevirtual android/os/ParcelFileDescriptor.close ()V
      // 9e: aload 1
      // 9f: athrow
      // a0: aload 5
      // a2: invokevirtual java/io/FileInputStream.close ()V
      // a5: goto 69
      // a8: astore 1
      // a9: aconst_null
      // aa: astore 0
      // ab: goto 92
      // ae: aload 2
      // af: invokevirtual android/os/ParcelFileDescriptor.close ()V
      // b2: aload 1
      // b3: astore 0
      // b4: goto 20
      // b7: astore 1
      // b8: aload 1
      // b9: athrow
      // ba: astore 0
      // bb: aload 5
      // bd: ifnull c9
      // c0: aload 1
      // c1: ifnull d6
      // c4: aload 5
      // c6: invokevirtual java/io/FileInputStream.close ()V
      // c9: aload 0
      // ca: athrow
      // cb: astore 5
      // cd: aload 1
      // ce: aload 5
      // d0: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // d3: goto c9
      // d6: aload 5
      // d8: invokevirtual java/io/FileInputStream.close ()V
      // db: goto c9
      // de: astore 2
      // df: aload 0
      // e0: aload 2
      // e1: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // e4: goto 9e
      // e7: aload 2
      // e8: invokevirtual android/os/ParcelFileDescriptor.close ()V
      // eb: goto 9e
      // ee: astore 0
      // ef: aconst_null
      // f0: astore 1
      // f1: goto bb
      // try (3 -> 9): 26 java/io/IOException
      // try (15 -> 17): 21 java/lang/Throwable
      // try (15 -> 17): 26 java/io/IOException
      // try (22 -> 26): 26 java/io/IOException
      // try (30 -> 32): 26 java/io/IOException
      // try (33 -> 39): 78 java/lang/Throwable
      // try (33 -> 39): 93 null
      // try (39 -> 51): 102 java/lang/Throwable
      // try (39 -> 51): 130 null
      // try (55 -> 57): 73 java/lang/Throwable
      // try (55 -> 57): 93 null
      // try (63 -> 65): 68 java/lang/Throwable
      // try (63 -> 65): 26 java/io/IOException
      // try (69 -> 73): 26 java/io/IOException
      // try (74 -> 78): 78 java/lang/Throwable
      // try (74 -> 78): 93 null
      // try (79 -> 81): 81 null
      // try (86 -> 88): 122 java/lang/Throwable
      // try (86 -> 88): 26 java/io/IOException
      // try (88 -> 90): 26 java/io/IOException
      // try (90 -> 92): 78 java/lang/Throwable
      // try (90 -> 92): 93 null
      // try (97 -> 99): 26 java/io/IOException
      // try (103 -> 105): 105 null
      // try (110 -> 112): 114 java/lang/Throwable
      // try (110 -> 112): 93 null
      // try (112 -> 114): 78 java/lang/Throwable
      // try (112 -> 114): 93 null
      // try (115 -> 118): 78 java/lang/Throwable
      // try (115 -> 118): 93 null
      // try (119 -> 121): 78 java/lang/Throwable
      // try (119 -> 121): 93 null
      // try (123 -> 126): 26 java/io/IOException
      // try (127 -> 129): 26 java/io/IOException
   }

   private static ByteBuffer a(File param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: new java/io/FileInputStream
      // 03: astore 4
      // 05: aload 4
      // 07: aload 0
      // 08: invokespecial java/io/FileInputStream.<init> (Ljava/io/File;)V
      // 0b: aload 4
      // 0d: invokevirtual java/io/FileInputStream.getChannel ()Ljava/nio/channels/FileChannel;
      // 10: astore 0
      // 11: aload 0
      // 12: invokevirtual java/nio/channels/FileChannel.size ()J
      // 15: lstore 1
      // 16: aload 0
      // 17: getstatic java/nio/channels/FileChannel$MapMode.READ_ONLY Ljava/nio/channels/FileChannel$MapMode;
      // 1a: lconst_0
      // 1b: lload 1
      // 1c: invokevirtual java/nio/channels/FileChannel.map (Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
      // 1f: astore 3
      // 20: aload 3
      // 21: astore 0
      // 22: aload 4
      // 24: ifnull 32
      // 27: bipush 0
      // 28: ifeq 43
      // 2b: aload 4
      // 2d: invokevirtual java/io/FileInputStream.close ()V
      // 30: aload 3
      // 31: astore 0
      // 32: aload 0
      // 33: areturn
      // 34: astore 0
      // 35: new java/lang/NullPointerException
      // 38: dup
      // 39: invokespecial java/lang/NullPointerException.<init> ()V
      // 3c: athrow
      // 3d: astore 0
      // 3e: aconst_null
      // 3f: astore 0
      // 40: goto 32
      // 43: aload 4
      // 45: invokevirtual java/io/FileInputStream.close ()V
      // 48: aload 3
      // 49: astore 0
      // 4a: goto 32
      // 4d: astore 0
      // 4e: aload 0
      // 4f: athrow
      // 50: astore 3
      // 51: aload 4
      // 53: ifnull 5f
      // 56: aload 0
      // 57: ifnull 6c
      // 5a: aload 4
      // 5c: invokevirtual java/io/FileInputStream.close ()V
      // 5f: aload 3
      // 60: athrow
      // 61: astore 4
      // 63: aload 0
      // 64: aload 4
      // 66: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 69: goto 5f
      // 6c: aload 4
      // 6e: invokevirtual java/io/FileInputStream.close ()V
      // 71: goto 5f
      // 74: astore 3
      // 75: aconst_null
      // 76: astore 0
      // 77: goto 51
      // try (0 -> 5): 34 java/io/IOException
      // try (5 -> 17): 43 java/lang/Throwable
      // try (5 -> 17): 63 null
      // try (23 -> 25): 29 java/lang/Throwable
      // try (23 -> 25): 34 java/io/IOException
      // try (30 -> 34): 34 java/io/IOException
      // try (38 -> 40): 34 java/io/IOException
      // try (44 -> 46): 46 null
      // try (51 -> 53): 55 java/lang/Throwable
      // try (51 -> 53): 34 java/io/IOException
      // try (53 -> 55): 34 java/io/IOException
      // try (56 -> 59): 34 java/io/IOException
      // try (60 -> 62): 34 java/io/IOException
   }

   public static void a(Closeable var0) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (IOException var1) {
         }
      }
   }

   public static boolean a(File param0, Resources param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 4
      // 03: aload 1
      // 04: iload 2
      // 05: invokevirtual android/content/res/Resources.openRawResource (I)Ljava/io/InputStream;
      // 08: astore 1
      // 09: aload 1
      // 0a: astore 4
      // 0c: aload 0
      // 0d: aload 1
      // 0e: invokestatic android/support/v4/graphics/TypefaceCompatUtil.a (Ljava/io/File;Ljava/io/InputStream;)Z
      // 11: istore 3
      // 12: aload 1
      // 13: invokestatic android/support/v4/graphics/TypefaceCompatUtil.a (Ljava/io/Closeable;)V
      // 16: iload 3
      // 17: ireturn
      // 18: astore 0
      // 19: aload 4
      // 1b: invokestatic android/support/v4/graphics/TypefaceCompatUtil.a (Ljava/io/Closeable;)V
      // 1e: aload 0
      // 1f: athrow
      // try (2 -> 6): 16 null
      // try (8 -> 12): 16 null
   }

   public static boolean a(File param0, InputStream param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 3
      // 02: new java/io/FileOutputStream
      // 05: astore 4
      // 07: aload 4
      // 09: aload 0
      // 0a: bipush 0
      // 0b: invokespecial java/io/FileOutputStream.<init> (Ljava/io/File;Z)V
      // 0e: aload 4
      // 10: astore 0
      // 11: sipush 1024
      // 14: newarray 8
      // 16: astore 5
      // 18: aload 4
      // 1a: astore 0
      // 1b: aload 1
      // 1c: aload 5
      // 1e: invokevirtual java/io/InputStream.read ([B)I
      // 21: istore 2
      // 22: iload 2
      // 23: bipush -1
      // 24: if_icmpeq 6b
      // 27: aload 4
      // 29: astore 0
      // 2a: aload 4
      // 2c: aload 5
      // 2e: bipush 0
      // 2f: iload 2
      // 30: invokevirtual java/io/FileOutputStream.write ([BII)V
      // 33: goto 18
      // 36: astore 0
      // 37: aload 4
      // 39: astore 1
      // 3a: aload 0
      // 3b: astore 4
      // 3d: aload 1
      // 3e: astore 0
      // 3f: new java/lang/StringBuilder
      // 42: astore 5
      // 44: aload 1
      // 45: astore 0
      // 46: aload 5
      // 48: invokespecial java/lang/StringBuilder.<init> ()V
      // 4b: aload 1
      // 4c: astore 0
      // 4d: ldc "TypefaceCompatUtil"
      // 4f: aload 5
      // 51: ldc "Error copying resource contents to temp file: "
      // 53: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 56: aload 4
      // 58: invokevirtual java/io/IOException.getMessage ()Ljava/lang/String;
      // 5b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 5e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 61: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 64: pop
      // 65: aload 1
      // 66: invokestatic android/support/v4/graphics/TypefaceCompatUtil.a (Ljava/io/Closeable;)V
      // 69: iload 3
      // 6a: ireturn
      // 6b: bipush 1
      // 6c: istore 3
      // 6d: aload 4
      // 6f: invokestatic android/support/v4/graphics/TypefaceCompatUtil.a (Ljava/io/Closeable;)V
      // 72: goto 69
      // 75: astore 1
      // 76: aconst_null
      // 77: astore 0
      // 78: aload 0
      // 79: invokestatic android/support/v4/graphics/TypefaceCompatUtil.a (Ljava/io/Closeable;)V
      // 7c: aload 1
      // 7d: athrow
      // 7e: astore 1
      // 7f: goto 78
      // 82: astore 4
      // 84: aconst_null
      // 85: astore 1
      // 86: goto 3d
      // try (2 -> 8): 73 java/io/IOException
      // try (2 -> 8): 64 null
      // try (10 -> 13): 30 java/io/IOException
      // try (10 -> 13): 71 null
      // try (15 -> 19): 30 java/io/IOException
      // try (15 -> 19): 71 null
      // try (24 -> 29): 30 java/io/IOException
      // try (24 -> 29): 71 null
      // try (37 -> 39): 71 null
      // try (41 -> 43): 71 null
      // try (45 -> 55): 71 null
   }
}
