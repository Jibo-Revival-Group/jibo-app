package net.sqlcipher.database;

import android.content.res.AssetFileDescriptor;
import android.os.MemoryFile;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SQLiteContentHelper {
   public static AssetFileDescriptor getBlobColumnAsAssetFile(SQLiteDatabase param0, String param1, String[] param2) throws FileNotFoundException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 3
      // 02: aload 0
      // 03: aload 1
      // 04: aload 2
      // 05: invokestatic net/sqlcipher/database/SQLiteContentHelper.simpleQueryForBlobMemoryFile (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)Landroid/os/MemoryFile;
      // 08: astore 1
      // 09: aload 1
      // 0a: ifnonnull 26
      // 0d: new java/io/FileNotFoundException
      // 10: astore 0
      // 11: aload 0
      // 12: ldc "No results."
      // 14: invokespecial java/io/FileNotFoundException.<init> (Ljava/lang/String;)V
      // 17: aload 0
      // 18: athrow
      // 19: astore 0
      // 1a: new java/io/FileNotFoundException
      // 1d: dup
      // 1e: aload 0
      // 1f: invokevirtual java/io/IOException.toString ()Ljava/lang/String;
      // 22: invokespecial java/io/FileNotFoundException.<init> (Ljava/lang/String;)V
      // 25: athrow
      // 26: aload 1
      // 27: invokevirtual java/lang/Object.getClass ()Ljava/lang/Class;
      // 2a: astore 0
      // 2b: aload 0
      // 2c: ldc "getParcelFileDescriptor"
      // 2e: bipush 0
      // 2f: anewarray 38
      // 32: invokevirtual java/lang/Class.getDeclaredMethod (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      // 35: astore 0
      // 36: aload 0
      // 37: bipush 1
      // 38: invokevirtual java/lang/reflect/Method.setAccessible (Z)V
      // 3b: aload 0
      // 3c: aload 1
      // 3d: bipush 0
      // 3e: anewarray 4
      // 41: invokevirtual java/lang/reflect/Method.invoke (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      // 44: checkcast android/os/ParcelFileDescriptor
      // 47: astore 0
      // 48: new android/content/res/AssetFileDescriptor
      // 4b: dup
      // 4c: aload 0
      // 4d: lconst_0
      // 4e: aload 1
      // 4f: invokevirtual android/os/MemoryFile.length ()I
      // 52: i2l
      // 53: invokespecial android/content/res/AssetFileDescriptor.<init> (Landroid/os/ParcelFileDescriptor;JJ)V
      // 56: areturn
      // 57: astore 2
      // 58: new java/lang/StringBuilder
      // 5b: astore 0
      // 5c: aload 0
      // 5d: invokespecial java/lang/StringBuilder.<init> ()V
      // 60: ldc "SQLiteContentHelper"
      // 62: aload 0
      // 63: ldc "SQLiteCursor.java: "
      // 65: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 68: aload 2
      // 69: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 6c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 6f: invokestatic android/util/Log.i (Ljava/lang/String;Ljava/lang/String;)I
      // 72: pop
      // 73: aload 3
      // 74: astore 0
      // 75: goto 48
      // try (2 -> 7): 16 java/io/IOException
      // try (9 -> 16): 16 java/io/IOException
      // try (23 -> 26): 16 java/io/IOException
      // try (26 -> 42): 51 java/lang/Exception
      // try (26 -> 42): 16 java/io/IOException
      // try (42 -> 51): 16 java/io/IOException
      // try (52 -> 65): 16 java/io/IOException
   }

   private static MemoryFile simpleQueryForBlobMemoryFile(SQLiteDatabase param0, String param1, String[] param2) throws IOException {
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
      // 04: aload 1
      // 05: aload 2
      // 06: invokevirtual net/sqlcipher/database/SQLiteDatabase.rawQuery (Ljava/lang/String;[Ljava/lang/String;)Lnet/sqlcipher/Cursor;
      // 09: astore 1
      // 0a: aload 1
      // 0b: ifnonnull 13
      // 0e: aload 4
      // 10: astore 0
      // 11: aload 0
      // 12: areturn
      // 13: aload 1
      // 14: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 19: istore 3
      // 1a: iload 3
      // 1b: ifne 2a
      // 1e: aload 1
      // 1f: invokeinterface android/database/Cursor.close ()V 1
      // 24: aload 4
      // 26: astore 0
      // 27: goto 11
      // 2a: aload 1
      // 2b: bipush 0
      // 2c: invokeinterface android/database/Cursor.getBlob (I)[B 2
      // 31: astore 2
      // 32: aload 2
      // 33: ifnonnull 42
      // 36: aload 1
      // 37: invokeinterface android/database/Cursor.close ()V 1
      // 3c: aload 4
      // 3e: astore 0
      // 3f: goto 11
      // 42: new android/os/MemoryFile
      // 45: astore 0
      // 46: aload 0
      // 47: aconst_null
      // 48: aload 2
      // 49: arraylength
      // 4a: invokespecial android/os/MemoryFile.<init> (Ljava/lang/String;I)V
      // 4d: aload 0
      // 4e: aload 2
      // 4f: bipush 0
      // 50: bipush 0
      // 51: aload 2
      // 52: arraylength
      // 53: invokevirtual android/os/MemoryFile.writeBytes ([BIII)V
      // 56: aload 1
      // 57: invokeinterface android/database/Cursor.close ()V 1
      // 5c: goto 11
      // 5f: astore 0
      // 60: aload 1
      // 61: invokeinterface android/database/Cursor.close ()V 1
      // 66: aload 0
      // 67: athrow
      // try (13 -> 16): 51 null
      // try (23 -> 27): 51 null
      // try (34 -> 48): 51 null
   }
}
