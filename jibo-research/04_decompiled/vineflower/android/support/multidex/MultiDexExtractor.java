package android.support.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

final class MultiDexExtractor implements Closeable {
   private final File a;
   private final long b;
   private final File c;
   private final RandomAccessFile d;
   private final FileChannel e;
   private final FileLock f;

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   MultiDexExtractor(File var1, File var2) throws IOException {
      Log.i("MultiDex", "MultiDexExtractor(" + var1.getPath() + ", " + var2.getPath() + ")");
      this.a = var1;
      this.c = var2;
      this.b = b(var1);
      var1 = new File(var2, "MultiDex.lock");
      this.d = new RandomAccessFile(var1, "rw");

      label49: {
         try {
            this.e = this.d.getChannel();
         } catch (IOException var12) {
            var16 = var12;
            break label49;
         } catch (RuntimeException var13) {
            var16 = var13;
            break label49;
         } catch (Error var14) {
            var16 = var14;
            break label49;
         }

         label41: {
            try {
               StringBuilder var18 = new StringBuilder();
               Log.i("MultiDex", var18.append("Blocking on lock ").append(var1.getPath()).toString());
               this.f = this.e.lock();
               break label41;
            } catch (IOException var9) {
               var17 = var9;
            } catch (RuntimeException var10) {
               var17 = var10;
            } catch (Error var11) {
               var17 = var11;
            }

            try {
               a(this.e);
               throw var17;
            } catch (IOException var3) {
               var16 = var3;
               break label49;
            } catch (RuntimeException var4) {
               var16 = var4;
               break label49;
            } catch (Error var5) {
               var16 = var5;
               break label49;
            }
         }

         try {
            StringBuilder var19 = new StringBuilder();
            Log.i("MultiDex", var19.append(var1.getPath()).append(" locked").toString());
            return;
         } catch (IOException var6) {
            var16 = var6;
         } catch (RuntimeException var7) {
            var16 = var7;
         } catch (Error var8) {
            var16 = var8;
         }
      }

      a(this.d);
      throw var16;
   }

   private static long a(File var0) {
      long var3 = var0.lastModified();
      long var1 = var3;
      if (var3 == -1L) {
         var1 = var3 - 1L;
      }

      return var1;
   }

   private static SharedPreferences a(Context var0) {
      byte var1;
      if (VERSION.SDK_INT < 11) {
         var1 = 0;
      } else {
         var1 = 4;
      }

      return var0.getSharedPreferences("multidex.version", var1);
   }

   private List<MultiDexExtractor.ExtractedDex> a() throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: new java/lang/StringBuilder
      // 003: dup
      // 004: invokespecial java/lang/StringBuilder.<init> ()V
      // 007: aload 0
      // 008: getfield android/support/multidex/MultiDexExtractor.a Ljava/io/File;
      // 00b: invokevirtual java/io/File.getName ()Ljava/lang/String;
      // 00e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 011: ldc ".classes"
      // 013: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 016: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 019: astore 8
      // 01b: aload 0
      // 01c: invokespecial android/support/multidex/MultiDexExtractor.b ()V
      // 01f: new java/util/ArrayList
      // 022: dup
      // 023: invokespecial java/util/ArrayList.<init> ()V
      // 026: astore 7
      // 028: new java/util/zip/ZipFile
      // 02b: dup
      // 02c: aload 0
      // 02d: getfield android/support/multidex/MultiDexExtractor.a Ljava/io/File;
      // 030: invokespecial java/util/zip/ZipFile.<init> (Ljava/io/File;)V
      // 033: astore 6
      // 035: new java/lang/StringBuilder
      // 038: astore 4
      // 03a: aload 4
      // 03c: invokespecial java/lang/StringBuilder.<init> ()V
      // 03f: aload 6
      // 041: aload 4
      // 043: ldc "classes"
      // 045: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 048: bipush 2
      // 049: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 04c: ldc ".dex"
      // 04e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 051: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 054: invokevirtual java/util/zip/ZipFile.getEntry (Ljava/lang/String;)Ljava/util/zip/ZipEntry;
      // 057: astore 4
      // 059: bipush 2
      // 05a: istore 3
      // 05b: aload 4
      // 05d: ifnull 20e
      // 060: new java/lang/StringBuilder
      // 063: astore 5
      // 065: aload 5
      // 067: invokespecial java/lang/StringBuilder.<init> ()V
      // 06a: aload 5
      // 06c: aload 8
      // 06e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 071: iload 3
      // 072: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 075: ldc ".zip"
      // 077: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 07a: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 07d: astore 5
      // 07f: new android/support/multidex/MultiDexExtractor$ExtractedDex
      // 082: astore 9
      // 084: aload 9
      // 086: aload 0
      // 087: getfield android/support/multidex/MultiDexExtractor.c Ljava/io/File;
      // 08a: aload 5
      // 08c: invokespecial android/support/multidex/MultiDexExtractor$ExtractedDex.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 08f: aload 7
      // 091: aload 9
      // 093: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 098: pop
      // 099: new java/lang/StringBuilder
      // 09c: astore 5
      // 09e: aload 5
      // 0a0: invokespecial java/lang/StringBuilder.<init> ()V
      // 0a3: ldc "MultiDex"
      // 0a5: aload 5
      // 0a7: ldc "Extraction is needed for file "
      // 0a9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0ac: aload 9
      // 0ae: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 0b1: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0b4: invokestatic android/util/Log.i (Ljava/lang/String;Ljava/lang/String;)I
      // 0b7: pop
      // 0b8: bipush 0
      // 0b9: istore 1
      // 0ba: bipush 0
      // 0bb: istore 2
      // 0bc: iload 2
      // 0bd: bipush 3
      // 0be: if_icmpge 19f
      // 0c1: iload 1
      // 0c2: ifne 19f
      // 0c5: iinc 2 1
      // 0c8: aload 6
      // 0ca: aload 4
      // 0cc: aload 9
      // 0ce: aload 8
      // 0d0: invokestatic android/support/multidex/MultiDexExtractor.a (Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/io/File;Ljava/lang/String;)V
      // 0d3: aload 9
      // 0d5: aload 9
      // 0d7: invokestatic android/support/multidex/MultiDexExtractor.b (Ljava/io/File;)J
      // 0da: putfield android/support/multidex/MultiDexExtractor$ExtractedDex.a J
      // 0dd: bipush 1
      // 0de: istore 1
      // 0df: new java/lang/StringBuilder
      // 0e2: astore 5
      // 0e4: aload 5
      // 0e6: invokespecial java/lang/StringBuilder.<init> ()V
      // 0e9: aload 5
      // 0eb: ldc "Extraction "
      // 0ed: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0f0: astore 10
      // 0f2: iload 1
      // 0f3: ifeq 198
      // 0f6: ldc "succeeded"
      // 0f8: astore 5
      // 0fa: ldc "MultiDex"
      // 0fc: aload 10
      // 0fe: aload 5
      // 100: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 103: ldc " '"
      // 105: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 108: aload 9
      // 10a: invokevirtual android/support/multidex/MultiDexExtractor$ExtractedDex.getAbsolutePath ()Ljava/lang/String;
      // 10d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 110: ldc "': length "
      // 112: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 115: aload 9
      // 117: invokevirtual android/support/multidex/MultiDexExtractor$ExtractedDex.length ()J
      // 11a: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 11d: ldc " - crc: "
      // 11f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 122: aload 9
      // 124: getfield android/support/multidex/MultiDexExtractor$ExtractedDex.a J
      // 127: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 12a: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 12d: invokestatic android/util/Log.i (Ljava/lang/String;Ljava/lang/String;)I
      // 130: pop
      // 131: iload 1
      // 132: ifne 234
      // 135: aload 9
      // 137: invokevirtual android/support/multidex/MultiDexExtractor$ExtractedDex.delete ()Z
      // 13a: pop
      // 13b: aload 9
      // 13d: invokevirtual android/support/multidex/MultiDexExtractor$ExtractedDex.exists ()Z
      // 140: ifeq 234
      // 143: new java/lang/StringBuilder
      // 146: astore 5
      // 148: aload 5
      // 14a: invokespecial java/lang/StringBuilder.<init> ()V
      // 14d: ldc "MultiDex"
      // 14f: aload 5
      // 151: ldc "Failed to delete corrupted secondary dex '"
      // 153: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 156: aload 9
      // 158: invokevirtual android/support/multidex/MultiDexExtractor$ExtractedDex.getPath ()Ljava/lang/String;
      // 15b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 15e: ldc "'"
      // 160: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 163: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 166: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 169: pop
      // 16a: goto 0bc
      // 16d: astore 10
      // 16f: new java/lang/StringBuilder
      // 172: astore 5
      // 174: aload 5
      // 176: invokespecial java/lang/StringBuilder.<init> ()V
      // 179: ldc "MultiDex"
      // 17b: aload 5
      // 17d: ldc "Failed to read crc from "
      // 17f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 182: aload 9
      // 184: invokevirtual android/support/multidex/MultiDexExtractor$ExtractedDex.getAbsolutePath ()Ljava/lang/String;
      // 187: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 18a: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 18d: aload 10
      // 18f: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 192: pop
      // 193: bipush 0
      // 194: istore 1
      // 195: goto 0df
      // 198: ldc "failed"
      // 19a: astore 5
      // 19c: goto 0fa
      // 19f: iload 1
      // 1a0: ifne 1e4
      // 1a3: new java/io/IOException
      // 1a6: astore 5
      // 1a8: new java/lang/StringBuilder
      // 1ab: astore 4
      // 1ad: aload 4
      // 1af: invokespecial java/lang/StringBuilder.<init> ()V
      // 1b2: aload 5
      // 1b4: aload 4
      // 1b6: ldc "Could not create zip file "
      // 1b8: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1bb: aload 9
      // 1bd: invokevirtual android/support/multidex/MultiDexExtractor$ExtractedDex.getAbsolutePath ()Ljava/lang/String;
      // 1c0: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1c3: ldc " for secondary dex ("
      // 1c5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1c8: iload 3
      // 1c9: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 1cc: ldc ")"
      // 1ce: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1d1: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1d4: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 1d7: aload 5
      // 1d9: athrow
      // 1da: astore 4
      // 1dc: aload 6
      // 1de: invokevirtual java/util/zip/ZipFile.close ()V
      // 1e1: aload 4
      // 1e3: athrow
      // 1e4: iinc 3 1
      // 1e7: new java/lang/StringBuilder
      // 1ea: astore 4
      // 1ec: aload 4
      // 1ee: invokespecial java/lang/StringBuilder.<init> ()V
      // 1f1: aload 6
      // 1f3: aload 4
      // 1f5: ldc "classes"
      // 1f7: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1fa: iload 3
      // 1fb: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 1fe: ldc ".dex"
      // 200: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 203: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 206: invokevirtual java/util/zip/ZipFile.getEntry (Ljava/lang/String;)Ljava/util/zip/ZipEntry;
      // 209: astore 4
      // 20b: goto 05b
      // 20e: aload 6
      // 210: invokevirtual java/util/zip/ZipFile.close ()V
      // 213: aload 7
      // 215: areturn
      // 216: astore 4
      // 218: ldc "MultiDex"
      // 21a: ldc "Failed to close resource"
      // 21c: aload 4
      // 21e: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 221: pop
      // 222: goto 213
      // 225: astore 5
      // 227: ldc "MultiDex"
      // 229: ldc "Failed to close resource"
      // 22b: aload 5
      // 22d: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 230: pop
      // 231: goto 1e1
      // 234: goto 0bc
      // try (23 -> 38): 206 null
      // try (42 -> 79): 206 null
      // try (89 -> 94): 206 null
      // try (94 -> 98): 159 java/io/IOException
      // try (94 -> 98): 206 null
      // try (100 -> 108): 206 null
      // try (112 -> 134): 206 null
      // try (136 -> 158): 206 null
      // try (160 -> 175): 206 null
      // try (183 -> 206): 206 null
      // try (207 -> 209): 239 java/io/IOException
      // try (212 -> 227): 206 null
      // try (228 -> 230): 232 java/io/IOException
   }

   private List<MultiDexExtractor.ExtractedDex> a(Context var1, String var2) throws IOException {
      Log.i("MultiDex", "loading existing secondary dex files");
      String var11 = this.a.getName() + ".classes";
      SharedPreferences var14 = a(var1);
      int var4 = var14.getInt(var2 + "dex.number", 1);
      ArrayList var12 = new ArrayList(var4 - 1);

      for (int var3 = 2; var3 <= var4; var3++) {
         String var13 = var11 + var3 + ".zip";
         MultiDexExtractor.ExtractedDex var15 = new MultiDexExtractor.ExtractedDex(this.c, var13);
         if (!var15.isFile()) {
            throw new IOException("Missing extracted secondary dex file '" + var15.getPath() + "'");
         }

         var15.a = b(var15);
         long var5 = var14.getLong(var2 + "dex.crc." + var3, -1L);
         long var9 = var14.getLong(var2 + "dex.time." + var3, -1L);
         long var7 = var15.lastModified();
         if (var9 != var7 || var5 != var15.a) {
            throw new IOException(
               "Invalid extracted dex: "
                  + var15
                  + " (key \""
                  + var2
                  + "\"), expected modification time: "
                  + var9
                  + ", modification time: "
                  + var7
                  + ", expected crc: "
                  + var5
                  + ", file crc: "
                  + var15.a
            );
         }

         var12.add(var15);
      }

      return var12;
   }

   private static void a(Context var0, String var1, long var2, long var4, List<MultiDexExtractor.ExtractedDex> var6) {
      Editor var9 = a(var0).edit();
      var9.putLong(var1 + "timestamp", var2);
      var9.putLong(var1 + "crc", var4);
      var9.putInt(var1 + "dex.number", var6.size() + 1);
      Iterator var8 = var6.iterator();

      for (int var7 = 2; var8.hasNext(); var7++) {
         MultiDexExtractor.ExtractedDex var10 = (MultiDexExtractor.ExtractedDex)var8.next();
         var9.putLong(var1 + "dex.crc." + var7, var10.a);
         var9.putLong(var1 + "dex.time." + var7, var10.lastModified());
      }

      var9.commit();
   }

   private static void a(Closeable var0) {
      try {
         var0.close();
      } catch (IOException var1) {
         Log.w("MultiDex", "Failed to close resource", var1);
      }
   }

   private static void a(ZipFile param0, ZipEntry param1, File param2, String param3) throws IOException, FileNotFoundException {
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
      // 000: aload 0
      // 001: aload 1
      // 002: invokevirtual java/util/zip/ZipFile.getInputStream (Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
      // 005: astore 0
      // 006: new java/lang/StringBuilder
      // 009: dup
      // 00a: invokespecial java/lang/StringBuilder.<init> ()V
      // 00d: ldc_w "tmp-"
      // 010: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 013: aload 3
      // 014: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 017: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 01a: ldc ".zip"
      // 01c: aload 2
      // 01d: invokevirtual java/io/File.getParentFile ()Ljava/io/File;
      // 020: invokestatic java/io/File.createTempFile (Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
      // 023: astore 3
      // 024: ldc "MultiDex"
      // 026: new java/lang/StringBuilder
      // 029: dup
      // 02a: invokespecial java/lang/StringBuilder.<init> ()V
      // 02d: ldc_w "Extracting "
      // 030: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 033: aload 3
      // 034: invokevirtual java/io/File.getPath ()Ljava/lang/String;
      // 037: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 03a: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 03d: invokestatic android/util/Log.i (Ljava/lang/String;Ljava/lang/String;)I
      // 040: pop
      // 041: new java/util/zip/ZipOutputStream
      // 044: astore 5
      // 046: new java/io/BufferedOutputStream
      // 049: astore 6
      // 04b: new java/io/FileOutputStream
      // 04e: astore 7
      // 050: aload 7
      // 052: aload 3
      // 053: invokespecial java/io/FileOutputStream.<init> (Ljava/io/File;)V
      // 056: aload 6
      // 058: aload 7
      // 05a: invokespecial java/io/BufferedOutputStream.<init> (Ljava/io/OutputStream;)V
      // 05d: aload 5
      // 05f: aload 6
      // 061: invokespecial java/util/zip/ZipOutputStream.<init> (Ljava/io/OutputStream;)V
      // 064: new java/util/zip/ZipEntry
      // 067: astore 6
      // 069: aload 6
      // 06b: ldc_w "classes.dex"
      // 06e: invokespecial java/util/zip/ZipEntry.<init> (Ljava/lang/String;)V
      // 071: aload 6
      // 073: aload 1
      // 074: invokevirtual java/util/zip/ZipEntry.getTime ()J
      // 077: invokevirtual java/util/zip/ZipEntry.setTime (J)V
      // 07a: aload 5
      // 07c: aload 6
      // 07e: invokevirtual java/util/zip/ZipOutputStream.putNextEntry (Ljava/util/zip/ZipEntry;)V
      // 081: sipush 16384
      // 084: newarray 8
      // 086: astore 1
      // 087: aload 0
      // 088: aload 1
      // 089: invokevirtual java/io/InputStream.read ([B)I
      // 08c: istore 4
      // 08e: iload 4
      // 090: bipush -1
      // 091: if_icmpeq 0a7
      // 094: aload 5
      // 096: aload 1
      // 097: bipush 0
      // 098: iload 4
      // 09a: invokevirtual java/util/zip/ZipOutputStream.write ([BII)V
      // 09d: aload 0
      // 09e: aload 1
      // 09f: invokevirtual java/io/InputStream.read ([B)I
      // 0a2: istore 4
      // 0a4: goto 08e
      // 0a7: aload 5
      // 0a9: invokevirtual java/util/zip/ZipOutputStream.closeEntry ()V
      // 0ac: aload 5
      // 0ae: invokevirtual java/util/zip/ZipOutputStream.close ()V
      // 0b1: aload 3
      // 0b2: invokevirtual java/io/File.setReadOnly ()Z
      // 0b5: ifne 105
      // 0b8: new java/io/IOException
      // 0bb: astore 1
      // 0bc: new java/lang/StringBuilder
      // 0bf: astore 5
      // 0c1: aload 5
      // 0c3: invokespecial java/lang/StringBuilder.<init> ()V
      // 0c6: aload 1
      // 0c7: aload 5
      // 0c9: ldc_w "Failed to mark readonly \""
      // 0cc: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0cf: aload 3
      // 0d0: invokevirtual java/io/File.getAbsolutePath ()Ljava/lang/String;
      // 0d3: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0d6: ldc_w "\" (tmp of \""
      // 0d9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0dc: aload 2
      // 0dd: invokevirtual java/io/File.getAbsolutePath ()Ljava/lang/String;
      // 0e0: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e3: ldc_w "\")"
      // 0e6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e9: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0ec: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 0ef: aload 1
      // 0f0: athrow
      // 0f1: astore 1
      // 0f2: aload 0
      // 0f3: invokestatic android/support/multidex/MultiDexExtractor.a (Ljava/io/Closeable;)V
      // 0f6: aload 3
      // 0f7: invokevirtual java/io/File.delete ()Z
      // 0fa: pop
      // 0fb: aload 1
      // 0fc: athrow
      // 0fd: astore 1
      // 0fe: aload 5
      // 100: invokevirtual java/util/zip/ZipOutputStream.close ()V
      // 103: aload 1
      // 104: athrow
      // 105: new java/lang/StringBuilder
      // 108: astore 1
      // 109: aload 1
      // 10a: invokespecial java/lang/StringBuilder.<init> ()V
      // 10d: ldc "MultiDex"
      // 10f: aload 1
      // 110: ldc_w "Renaming to "
      // 113: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 116: aload 2
      // 117: invokevirtual java/io/File.getPath ()Ljava/lang/String;
      // 11a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 11d: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 120: invokestatic android/util/Log.i (Ljava/lang/String;Ljava/lang/String;)I
      // 123: pop
      // 124: aload 3
      // 125: aload 2
      // 126: invokevirtual java/io/File.renameTo (Ljava/io/File;)Z
      // 129: ifne 165
      // 12c: new java/io/IOException
      // 12f: astore 5
      // 131: new java/lang/StringBuilder
      // 134: astore 1
      // 135: aload 1
      // 136: invokespecial java/lang/StringBuilder.<init> ()V
      // 139: aload 5
      // 13b: aload 1
      // 13c: ldc_w "Failed to rename \""
      // 13f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 142: aload 3
      // 143: invokevirtual java/io/File.getAbsolutePath ()Ljava/lang/String;
      // 146: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 149: ldc_w "\" to \""
      // 14c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 14f: aload 2
      // 150: invokevirtual java/io/File.getAbsolutePath ()Ljava/lang/String;
      // 153: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 156: ldc_w "\""
      // 159: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 15c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 15f: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 162: aload 5
      // 164: athrow
      // 165: aload 0
      // 166: invokestatic android/support/multidex/MultiDexExtractor.a (Ljava/io/Closeable;)V
      // 169: aload 3
      // 16a: invokevirtual java/io/File.delete ()Z
      // 16d: pop
      // 16e: return
      // try (29 -> 44): 107 null
      // try (44 -> 63): 115 null
      // try (66 -> 75): 115 null
      // try (76 -> 78): 115 null
      // try (78 -> 107): 107 null
      // try (116 -> 120): 107 null
      // try (120 -> 162): 107 null
   }

   private static boolean a(Context var0, File var1, long var2, String var4) {
      SharedPreferences var6 = a(var0);
      boolean var5;
      if (var6.getLong(var4 + "timestamp", -1L) == a(var1) && var6.getLong(var4 + "crc", -1L) == var2) {
         var5 = false;
      } else {
         var5 = true;
      }

      return var5;
   }

   private static long b(File var0) throws IOException {
      long var3 = ZipUtil.a(var0);
      long var1 = var3;
      if (var3 == -1L) {
         var1 = var3 - 1L;
      }

      return var1;
   }

   private void b() {
      File[] var3 = this.c.listFiles(new FileFilter(this) {
         final MultiDexExtractor a;

         {
            this.a = var1;
         }

         @Override
         public boolean accept(File var1) {
            boolean var2;
            if (!var1.getName().equals("MultiDex.lock")) {
               var2 = true;
            } else {
               var2 = false;
            }

            return var2;
         }
      });
      if (var3 == null) {
         Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.c.getPath() + ").");
      } else {
         for (File var4 : var3) {
            Log.i("MultiDex", "Trying to delete old file " + var4.getPath() + " of size " + var4.length());
            if (!var4.delete()) {
               Log.w("MultiDex", "Failed to delete old file " + var4.getPath());
            } else {
               Log.i("MultiDex", "Deleted old file " + var4.getPath());
            }
         }
      }
   }

   List<? extends File> a(Context var1, String var2, boolean var3) throws IOException {
      Log.i("MultiDex", "MultiDexExtractor.load(" + this.a.getPath() + ", " + var3 + ", " + var2 + ")");
      if (!this.f.isValid()) {
         throw new IllegalStateException("MultiDexExtractor was closed");
      }

      label26:
      if (!var3 && !a(var1, this.a, this.b, var2)) {
         List var8;
         try {
            var8 = this.a(var1, var2);
         } catch (IOException var5) {
            Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", var5);
            var8 = this.a();
            a(var1, var2, a(this.a), this.b, var8);
            var6 = var8;
            break label26;
         }

         var6 = var8;
      } else {
         if (var3) {
            Log.i("MultiDex", "Forced extraction must be performed.");
         } else {
            Log.i("MultiDex", "Detected that extraction must be performed.");
         }

         List var4 = this.a();
         a(var1, var2, a(this.a), this.b, var4);
         var6 = var4;
      }

      Log.i("MultiDex", "load found " + var6.size() + " secondary dex files");
      return var6;
   }

   @Override
   public void close() throws IOException {
      this.f.release();
      this.e.close();
      this.d.close();
   }

   private static class ExtractedDex extends File {
      public long a = -1L;

      public ExtractedDex(File var1, String var2) {
         super(var1, var2);
      }
   }
}
