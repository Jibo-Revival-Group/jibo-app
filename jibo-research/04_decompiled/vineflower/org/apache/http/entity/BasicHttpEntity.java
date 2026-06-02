package org.apache.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.impl.io.EmptyInputStream;
import org.apache.http.util.Asserts;

@NotThreadSafe
public class BasicHttpEntity extends AbstractHttpEntity {
   private InputStream content;
   private long length = -1L;

   @Override
   public InputStream getContent() throws IllegalStateException {
      boolean var1;
      if (this.content != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      Asserts.check(var1, "Content has not been provided");
      return this.content;
   }

   @Override
   public long getContentLength() {
      return this.length;
   }

   @Override
   public boolean isRepeatable() {
      return false;
   }

   @Override
   public boolean isStreaming() {
      boolean var1;
      if (this.content != null && this.content != EmptyInputStream.INSTANCE) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void setContent(InputStream var1) {
      this.content = var1;
   }

   public void setContentLength(long var1) {
      this.length = var1;
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
      // 07: aload 0
      // 08: invokevirtual org/apache/http/entity/BasicHttpEntity.getContent ()Ljava/io/InputStream;
      // 0b: astore 3
      // 0c: sipush 4096
      // 0f: newarray 8
      // 11: astore 4
      // 13: aload 3
      // 14: aload 4
      // 16: invokevirtual java/io/InputStream.read ([B)I
      // 19: istore 2
      // 1a: iload 2
      // 1b: bipush -1
      // 1c: if_icmpeq 31
      // 1f: aload 1
      // 20: aload 4
      // 22: bipush 0
      // 23: iload 2
      // 24: invokevirtual java/io/OutputStream.write ([BII)V
      // 27: goto 13
      // 2a: astore 1
      // 2b: aload 3
      // 2c: invokevirtual java/io/InputStream.close ()V
      // 2f: aload 1
      // 30: athrow
      // 31: aload 3
      // 32: invokevirtual java/io/InputStream.close ()V
      // 35: return
      // try (7 -> 10): 23 null
      // try (10 -> 14): 23 null
      // try (17 -> 22): 23 null
   }
}
