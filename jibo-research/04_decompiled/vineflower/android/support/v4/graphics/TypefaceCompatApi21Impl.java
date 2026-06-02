package android.support.v4.graphics;

import android.content.Context;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.support.v4.provider.FontsContractCompat;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;

class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
   private File a(ParcelFileDescriptor var1) {
      try {
         StringBuilder var2 = new StringBuilder();
         String var5 = Os.readlink(var2.append("/proc/self/fd/").append(var1.getFd()).toString());
         if (OsConstants.S_ISREG(Os.stat(var5).st_mode)) {
            return new File(var5);
         }
      } catch (ErrnoException var3) {
         return null;
      }

      return null;
   }

   @Override
   public Typeface a(Context param1, CancellationSignal param2, FontsContractCompat.FontInfo[] param3, int param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 5
      // 003: aload 3
      // 004: arraylength
      // 005: bipush 1
      // 006: if_icmpge 00e
      // 009: aload 5
      // 00b: astore 1
      // 00c: aload 1
      // 00d: areturn
      // 00e: aload 0
      // 00f: aload 3
      // 010: iload 4
      // 012: invokevirtual android/support/v4/graphics/TypefaceCompatApi21Impl.a ([Landroid/support/v4/provider/FontsContractCompat$FontInfo;I)Landroid/support/v4/provider/FontsContractCompat$FontInfo;
      // 015: astore 3
      // 016: aload 1
      // 017: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 01a: astore 6
      // 01c: aload 6
      // 01e: aload 3
      // 01f: invokevirtual android/support/v4/provider/FontsContractCompat$FontInfo.a ()Landroid/net/Uri;
      // 022: ldc "r"
      // 024: aload 2
      // 025: invokevirtual android/content/ContentResolver.openFileDescriptor (Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
      // 028: astore 3
      // 029: aload 0
      // 02a: aload 3
      // 02b: invokespecial android/support/v4/graphics/TypefaceCompatApi21Impl.a (Landroid/os/ParcelFileDescriptor;)Ljava/io/File;
      // 02e: astore 2
      // 02f: aload 2
      // 030: ifnull 03a
      // 033: aload 2
      // 034: invokevirtual java/io/File.canRead ()Z
      // 037: ifne 0d4
      // 03a: new java/io/FileInputStream
      // 03d: astore 6
      // 03f: aload 6
      // 041: aload 3
      // 042: invokevirtual android/os/ParcelFileDescriptor.getFileDescriptor ()Ljava/io/FileDescriptor;
      // 045: invokespecial java/io/FileInputStream.<init> (Ljava/io/FileDescriptor;)V
      // 048: aload 0
      // 049: aload 1
      // 04a: aload 6
      // 04c: invokespecial android/support/v4/graphics/TypefaceCompatBaseImpl.a (Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
      // 04f: astore 1
      // 050: aload 6
      // 052: ifnull 05e
      // 055: bipush 0
      // 056: ifeq 08f
      // 059: aload 6
      // 05b: invokevirtual java/io/FileInputStream.close ()V
      // 05e: aload 3
      // 05f: ifnull 06a
      // 062: bipush 0
      // 063: ifeq 0a6
      // 066: aload 3
      // 067: invokevirtual android/os/ParcelFileDescriptor.close ()V
      // 06a: goto 00c
      // 06d: astore 1
      // 06e: new java/lang/NullPointerException
      // 071: dup
      // 072: invokespecial java/lang/NullPointerException.<init> ()V
      // 075: athrow
      // 076: astore 1
      // 077: aload 1
      // 078: athrow
      // 079: astore 2
      // 07a: aload 3
      // 07b: ifnull 086
      // 07e: aload 1
      // 07f: ifnull 101
      // 082: aload 3
      // 083: invokevirtual android/os/ParcelFileDescriptor.close ()V
      // 086: aload 2
      // 087: athrow
      // 088: astore 1
      // 089: aload 5
      // 08b: astore 1
      // 08c: goto 00c
      // 08f: aload 6
      // 091: invokevirtual java/io/FileInputStream.close ()V
      // 094: goto 05e
      // 097: astore 2
      // 098: aconst_null
      // 099: astore 1
      // 09a: goto 07a
      // 09d: astore 1
      // 09e: new java/lang/NullPointerException
      // 0a1: dup
      // 0a2: invokespecial java/lang/NullPointerException.<init> ()V
      // 0a5: athrow
      // 0a6: aload 3
      // 0a7: invokevirtual android/os/ParcelFileDescriptor.close ()V
      // 0aa: goto 06a
      // 0ad: astore 2
      // 0ae: aload 2
      // 0af: athrow
      // 0b0: astore 1
      // 0b1: aload 6
      // 0b3: ifnull 0bf
      // 0b6: aload 2
      // 0b7: ifnull 0cc
      // 0ba: aload 6
      // 0bc: invokevirtual java/io/FileInputStream.close ()V
      // 0bf: aload 1
      // 0c0: athrow
      // 0c1: astore 6
      // 0c3: aload 2
      // 0c4: aload 6
      // 0c6: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 0c9: goto 0bf
      // 0cc: aload 6
      // 0ce: invokevirtual java/io/FileInputStream.close ()V
      // 0d1: goto 0bf
      // 0d4: aload 2
      // 0d5: invokestatic android/graphics/Typeface.createFromFile (Ljava/io/File;)Landroid/graphics/Typeface;
      // 0d8: astore 1
      // 0d9: aload 3
      // 0da: ifnull 0e5
      // 0dd: bipush 0
      // 0de: ifeq 0f1
      // 0e1: aload 3
      // 0e2: invokevirtual android/os/ParcelFileDescriptor.close ()V
      // 0e5: goto 00c
      // 0e8: astore 1
      // 0e9: new java/lang/NullPointerException
      // 0ec: dup
      // 0ed: invokespecial java/lang/NullPointerException.<init> ()V
      // 0f0: athrow
      // 0f1: aload 3
      // 0f2: invokevirtual android/os/ParcelFileDescriptor.close ()V
      // 0f5: goto 0e5
      // 0f8: astore 3
      // 0f9: aload 1
      // 0fa: aload 3
      // 0fb: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 0fe: goto 086
      // 101: aload 3
      // 102: invokevirtual android/os/ParcelFileDescriptor.close ()V
      // 105: goto 086
      // 108: astore 1
      // 109: aconst_null
      // 10a: astore 2
      // 10b: goto 0b1
      // try (18 -> 25): 75 java/io/IOException
      // try (25 -> 29): 63 java/lang/Throwable
      // try (25 -> 29): 82 null
      // try (31 -> 34): 63 java/lang/Throwable
      // try (31 -> 34): 82 null
      // try (34 -> 40): 63 java/lang/Throwable
      // try (34 -> 40): 82 null
      // try (40 -> 45): 94 java/lang/Throwable
      // try (40 -> 45): 140 null
      // try (49 -> 51): 58 java/lang/Throwable
      // try (49 -> 51): 82 null
      // try (55 -> 57): 86 java/lang/Throwable
      // try (55 -> 57): 75 java/io/IOException
      // try (59 -> 63): 63 java/lang/Throwable
      // try (59 -> 63): 82 null
      // try (64 -> 66): 66 null
      // try (71 -> 73): 132 java/lang/Throwable
      // try (71 -> 73): 75 java/io/IOException
      // try (73 -> 75): 75 java/io/IOException
      // try (79 -> 81): 63 java/lang/Throwable
      // try (79 -> 81): 82 null
      // try (87 -> 91): 75 java/io/IOException
      // try (91 -> 93): 75 java/io/IOException
      // try (95 -> 97): 97 null
      // try (102 -> 104): 106 java/lang/Throwable
      // try (102 -> 104): 82 null
      // try (104 -> 106): 63 java/lang/Throwable
      // try (104 -> 106): 82 null
      // try (107 -> 110): 63 java/lang/Throwable
      // try (107 -> 110): 82 null
      // try (111 -> 113): 63 java/lang/Throwable
      // try (111 -> 113): 82 null
      // try (114 -> 117): 63 java/lang/Throwable
      // try (114 -> 117): 82 null
      // try (121 -> 123): 124 java/lang/Throwable
      // try (121 -> 123): 75 java/io/IOException
      // try (125 -> 129): 75 java/io/IOException
      // try (129 -> 131): 75 java/io/IOException
      // try (133 -> 136): 75 java/io/IOException
      // try (137 -> 139): 75 java/io/IOException
   }
}
