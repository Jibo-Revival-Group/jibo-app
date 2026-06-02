package com.salesforce.androidsdk.smartstore.store;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.salesforce.androidsdk.smartstore.util.SmartStoreLogger;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipInputStream;
import net.sqlcipher.database.SQLiteDatabase;

public class SqliteLibraryLoader {
   private static final String a = SqliteLibraryLoader.class.getSimpleName();

   public static boolean a(Context var0) {
      try {
         b(var0);
      } catch (UnsatisfiedLinkError var3) {
         return a(var0, "libsqlcipher.so", a());
      } catch (Exception var4) {
         SmartStoreLogger.a(a, "Error occurred while loading native libs for SQLCipher", var4);
         return false;
      }

      return true;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static boolean a(Context var0, String var1, String[] var2) {
      boolean var5 = true;
      ApplicationInfo var6 = var0.getApplicationInfo();
      String var8 = var0.getFilesDir().toString();
      SmartStoreLogger.b(a, "Extracting to destination: " + var8);

      label61: {
         int var4;
         try {
            StringBuilder var18 = new StringBuilder();
            var19 = var18.append(var8).append(File.separator).append(var1).toString();
            File var7 = new File(var19);
            var7.delete();
            var4 = var2.length;
         } catch (IOException var15) {
            var17 = var15;
            break label61;
         } catch (UnsatisfiedLinkError var16) {
            var17 = var16;
            break label61;
         }

         int var3 = 0;

         while (true) {
            if (var3 < var4) {
               String var23 = var2[var3];

               label45: {
                  try {
                     String var10 = a;
                     StringBuilder var9 = new StringBuilder();
                     SmartStoreLogger.b(var10, var9.append("Using ABI: ").append(var23).toString());
                     var10 = var6.sourceDir;
                     var9 = new StringBuilder();
                     SqliteLibraryLoader.UnzipUtil.a(var10, var9.append("lib/").append(var23).append("/").append(var1).toString(), var8);
                     File var25 = new File(var19);
                     if (a(var25)) {
                        String var21 = a;
                        StringBuilder var20 = new StringBuilder();
                        SmartStoreLogger.b(var21, var20.append("File exists after extracting to ").append(var23).toString());
                        break label45;
                     }
                  } catch (IOException var13) {
                     var17 = var13;
                     break label61;
                  } catch (UnsatisfiedLinkError var14) {
                     var17 = var14;
                     break label61;
                  }

                  var3++;
                  continue;
               }

               var22 = true;
               break;
            }

            var22 = false;
            break;
         }

         if (!var22) {
            return false;
         }

         try {
            System.load(var19);
            return var5;
         } catch (IOException var11) {
            var17 = var11;
         } catch (UnsatisfiedLinkError var12) {
            var17 = var12;
         }
      }

      SmartStoreLogger.a(a, "Error occurred while extracting and loading libs", var17);
      return false;
   }

   public static boolean a(File var0) {
      return var0.canRead();
   }

   @SuppressLint("NewApi")
   public static String[] a() {
      String[] var0;
      if (VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0) {
         var0 = Build.SUPPORTED_ABIS;
      } else {
         var0 = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
      }

      return var0;
   }

   public static void b(Context var0) throws UnsatisfiedLinkError {
      SQLiteDatabase.loadLibs(var0);
   }

   public static class UnzipUtil {
      public static void a(String param0, String param1, String param2) throws IOException {
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
         // 00: new java/io/FileInputStream
         // 03: dup
         // 04: aload 0
         // 05: invokespecial java/io/FileInputStream.<init> (Ljava/lang/String;)V
         // 08: astore 4
         // 0a: aload 4
         // 0c: ifnull 84
         // 0f: new java/util/zip/ZipInputStream
         // 12: dup
         // 13: aload 4
         // 15: invokespecial java/util/zip/ZipInputStream.<init> (Ljava/io/InputStream;)V
         // 18: astore 5
         // 1a: aload 5
         // 1c: invokevirtual java/util/zip/ZipInputStream.getNextEntry ()Ljava/util/zip/ZipEntry;
         // 1f: astore 0
         // 20: aload 0
         // 21: ifnull 75
         // 24: aload 0
         // 25: invokevirtual java/util/zip/ZipEntry.isDirectory ()Z
         // 28: ifne 85
         // 2b: aload 1
         // 2c: aload 0
         // 2d: invokevirtual java/util/zip/ZipEntry.getName ()Ljava/lang/String;
         // 30: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
         // 33: ifeq 85
         // 36: aload 0
         // 37: invokevirtual java/util/zip/ZipEntry.getName ()Ljava/lang/String;
         // 3a: astore 1
         // 3b: aload 1
         // 3c: getstatic java/io/File.separator Ljava/lang/String;
         // 3f: invokevirtual java/lang/String.lastIndexOf (Ljava/lang/String;)I
         // 42: istore 3
         // 43: aload 1
         // 44: astore 0
         // 45: iload 3
         // 46: bipush -1
         // 47: if_icmple 56
         // 4a: aload 1
         // 4b: iload 3
         // 4c: bipush 1
         // 4d: iadd
         // 4e: aload 1
         // 4f: invokevirtual java/lang/String.length ()I
         // 52: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
         // 55: astore 0
         // 56: new java/lang/StringBuilder
         // 59: astore 1
         // 5a: aload 1
         // 5b: invokespecial java/lang/StringBuilder.<init> ()V
         // 5e: aload 5
         // 60: aload 1
         // 61: aload 2
         // 62: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 65: getstatic java/io/File.separator Ljava/lang/String;
         // 68: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 6b: aload 0
         // 6c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 6f: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
         // 72: invokestatic com/salesforce/androidsdk/smartstore/store/SqliteLibraryLoader$UnzipUtil.a (Ljava/util/zip/ZipInputStream;Ljava/lang/String;)V
         // 75: aload 5
         // 77: ifnull 7f
         // 7a: aload 5
         // 7c: invokevirtual java/util/zip/ZipInputStream.close ()V
         // 7f: aload 4
         // 81: invokevirtual java/io/FileInputStream.close ()V
         // 84: return
         // 85: aload 5
         // 87: invokevirtual java/util/zip/ZipInputStream.closeEntry ()V
         // 8a: aload 5
         // 8c: invokevirtual java/util/zip/ZipInputStream.getNextEntry ()Ljava/util/zip/ZipEntry;
         // 8f: astore 0
         // 90: goto 20
         // 93: astore 0
         // 94: aload 5
         // 96: ifnull 9e
         // 99: aload 5
         // 9b: invokevirtual java/util/zip/ZipInputStream.close ()V
         // 9e: aload 4
         // a0: invokevirtual java/io/FileInputStream.close ()V
         // a3: aload 0
         // a4: athrow
         // try (17 -> 32): 72 null
         // try (37 -> 45): 72 null
         // try (45 -> 59): 72 null
         // try (66 -> 71): 72 null
      }

      private static void a(ZipInputStream param0, String param1) throws IOException {
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
         // 00: new java/io/BufferedOutputStream
         // 03: dup
         // 04: new java/io/FileOutputStream
         // 07: dup
         // 08: aload 1
         // 09: invokespecial java/io/FileOutputStream.<init> (Ljava/lang/String;)V
         // 0c: invokespecial java/io/BufferedOutputStream.<init> (Ljava/io/OutputStream;)V
         // 0f: astore 1
         // 10: sipush 4096
         // 13: newarray 8
         // 15: astore 3
         // 16: aload 0
         // 17: aload 3
         // 18: invokevirtual java/util/zip/ZipInputStream.read ([B)I
         // 1b: istore 2
         // 1c: iload 2
         // 1d: bipush -1
         // 1e: if_icmpeq 32
         // 21: aload 1
         // 22: aload 3
         // 23: bipush 0
         // 24: iload 2
         // 25: invokevirtual java/io/BufferedOutputStream.write ([BII)V
         // 28: goto 16
         // 2b: astore 0
         // 2c: aload 1
         // 2d: invokevirtual java/io/BufferedOutputStream.close ()V
         // 30: aload 0
         // 31: athrow
         // 32: aload 1
         // 33: invokevirtual java/io/BufferedOutputStream.close ()V
         // 36: return
         // try (8 -> 11): 24 null
         // try (11 -> 15): 24 null
         // try (18 -> 23): 24 null
      }
   }
}
