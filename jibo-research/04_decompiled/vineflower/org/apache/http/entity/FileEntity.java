package org.apache.http.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
public class FileEntity extends AbstractHttpEntity implements Cloneable {
   protected final File file;

   public FileEntity(File var1) {
      this.file = Args.notNull(var1, "File");
   }

   @Deprecated
   public FileEntity(File var1, String var2) {
      this.file = Args.notNull(var1, "File");
      this.setContentType(var2);
   }

   public FileEntity(File var1, ContentType var2) {
      this.file = Args.notNull(var1, "File");
      if (var2 != null) {
         this.setContentType(var2.toString());
      }
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   @Override
   public InputStream getContent() throws IOException {
      return new FileInputStream(this.file);
   }

   @Override
   public long getContentLength() {
      return this.file.length();
   }

   @Override
   public boolean isRepeatable() {
      return true;
   }

   @Override
   public boolean isStreaming() {
      return false;
   }

   @Override
   public void writeTo(OutputStream param1) throws IOException {
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
      // 00: aload 1
      // 01: ldc "Output stream"
      // 03: invokestatic org/apache/http/util/Args.notNull (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      // 06: pop
      // 07: new java/io/FileInputStream
      // 0a: dup
      // 0b: aload 0
      // 0c: getfield org/apache/http/entity/FileEntity.file Ljava/io/File;
      // 0f: invokespecial java/io/FileInputStream.<init> (Ljava/io/File;)V
      // 12: astore 3
      // 13: sipush 4096
      // 16: newarray 8
      // 18: astore 4
      // 1a: aload 3
      // 1b: aload 4
      // 1d: invokevirtual java/io/InputStream.read ([B)I
      // 20: istore 2
      // 21: iload 2
      // 22: bipush -1
      // 23: if_icmpeq 38
      // 26: aload 1
      // 27: aload 4
      // 29: bipush 0
      // 2a: iload 2
      // 2b: invokevirtual java/io/OutputStream.write ([BII)V
      // 2e: goto 1a
      // 31: astore 1
      // 32: aload 3
      // 33: invokevirtual java/io/InputStream.close ()V
      // 36: aload 1
      // 37: athrow
      // 38: aload 1
      // 39: invokevirtual java/io/OutputStream.flush ()V
      // 3c: aload 3
      // 3d: invokevirtual java/io/InputStream.close ()V
      // 40: return
      // try (10 -> 13): 26 null
      // try (13 -> 17): 26 null
      // try (20 -> 25): 26 null
      // try (31 -> 33): 26 null
   }
}
