package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileToStreamDecoder<T> implements ResourceDecoder<File, T> {
   private static final FileToStreamDecoder.FileOpener DEFAULT_FILE_OPENER = new FileToStreamDecoder.FileOpener();
   private final FileToStreamDecoder.FileOpener fileOpener;
   private ResourceDecoder<InputStream, T> streamDecoder;

   public FileToStreamDecoder(ResourceDecoder<InputStream, T> var1) {
      this(var1, DEFAULT_FILE_OPENER);
   }

   FileToStreamDecoder(ResourceDecoder<InputStream, T> var1, FileToStreamDecoder.FileOpener var2) {
      this.streamDecoder = var1;
      this.fileOpener = var2;
   }

   public Resource<T> decode(File param1, int param2, int param3) throws IOException {
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
      // 03: aload 0
      // 04: getfield com/bumptech/glide/load/resource/file/FileToStreamDecoder.fileOpener Lcom/bumptech/glide/load/resource/file/FileToStreamDecoder$FileOpener;
      // 07: aload 1
      // 08: invokevirtual com/bumptech/glide/load/resource/file/FileToStreamDecoder$FileOpener.a (Ljava/io/File;)Ljava/io/InputStream;
      // 0b: astore 1
      // 0c: aload 1
      // 0d: astore 4
      // 0f: aload 0
      // 10: getfield com/bumptech/glide/load/resource/file/FileToStreamDecoder.streamDecoder Lcom/bumptech/glide/load/ResourceDecoder;
      // 13: aload 1
      // 14: iload 2
      // 15: iload 3
      // 16: invokeinterface com/bumptech/glide/load/ResourceDecoder.decode (Ljava/lang/Object;II)Lcom/bumptech/glide/load/engine/Resource; 4
      // 1b: astore 5
      // 1d: aload 1
      // 1e: ifnull 25
      // 21: aload 1
      // 22: invokevirtual java/io/InputStream.close ()V
      // 25: aload 5
      // 27: areturn
      // 28: astore 1
      // 29: aload 4
      // 2b: ifnull 33
      // 2e: aload 4
      // 30: invokevirtual java/io/InputStream.close ()V
      // 33: aload 1
      // 34: athrow
      // 35: astore 1
      // 36: goto 25
      // 39: astore 4
      // 3b: goto 33
      // try (2 -> 7): 22 null
      // try (9 -> 16): 22 null
      // try (18 -> 20): 29 java/io/IOException
      // try (25 -> 27): 31 java/io/IOException
   }

   @Override
   public String getId() {
      return "";
   }

   static class FileOpener {
      public InputStream a(File var1) throws FileNotFoundException {
         return new FileInputStream(var1);
      }
   }
}
