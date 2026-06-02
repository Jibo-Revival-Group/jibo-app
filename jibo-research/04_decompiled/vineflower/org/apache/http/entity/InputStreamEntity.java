package org.apache.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
public class InputStreamEntity extends AbstractHttpEntity {
   private final InputStream content;
   private final long length;

   public InputStreamEntity(InputStream var1) {
      this(var1, -1L);
   }

   public InputStreamEntity(InputStream var1, long var2) {
      this(var1, var2, null);
   }

   public InputStreamEntity(InputStream var1, long var2, ContentType var4) {
      this.content = Args.notNull(var1, "Source input stream");
      this.length = var2;
      if (var4 != null) {
         this.setContentType(var4.toString());
      }
   }

   public InputStreamEntity(InputStream var1, ContentType var2) {
      this(var1, -1L, var2);
   }

   @Override
   public InputStream getContent() throws IOException {
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
      return true;
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
      // 08: getfield org/apache/http/entity/InputStreamEntity.content Ljava/io/InputStream;
      // 0b: astore 5
      // 0d: sipush 4096
      // 10: newarray 8
      // 12: astore 6
      // 14: aload 0
      // 15: getfield org/apache/http/entity/InputStreamEntity.length J
      // 18: lconst_0
      // 19: lcmp
      // 1a: ifge 3d
      // 1d: aload 5
      // 1f: aload 6
      // 21: invokevirtual java/io/InputStream.read ([B)I
      // 24: istore 2
      // 25: iload 2
      // 26: bipush -1
      // 27: if_icmpeq 5e
      // 2a: aload 1
      // 2b: aload 6
      // 2d: bipush 0
      // 2e: iload 2
      // 2f: invokevirtual java/io/OutputStream.write ([BII)V
      // 32: goto 1d
      // 35: astore 1
      // 36: aload 5
      // 38: invokevirtual java/io/InputStream.close ()V
      // 3b: aload 1
      // 3c: athrow
      // 3d: aload 0
      // 3e: getfield org/apache/http/entity/InputStreamEntity.length J
      // 41: lstore 3
      // 42: lload 3
      // 43: lconst_0
      // 44: lcmp
      // 45: ifle 5e
      // 48: aload 5
      // 4a: aload 6
      // 4c: bipush 0
      // 4d: ldc2_w 4096
      // 50: lload 3
      // 51: invokestatic java/lang/Math.min (JJ)J
      // 54: l2i
      // 55: invokevirtual java/io/InputStream.read ([BII)I
      // 58: istore 2
      // 59: iload 2
      // 5a: bipush -1
      // 5b: if_icmpne 64
      // 5e: aload 5
      // 60: invokevirtual java/io/InputStream.close ()V
      // 63: return
      // 64: aload 1
      // 65: aload 6
      // 67: bipush 0
      // 68: iload 2
      // 69: invokevirtual java/io/OutputStream.write ([BII)V
      // 6c: lload 3
      // 6d: iload 2
      // 6e: i2l
      // 6f: lsub
      // 70: lstore 3
      // 71: goto 42
      // try (7 -> 15): 28 null
      // try (15 -> 19): 28 null
      // try (22 -> 27): 28 null
      // try (33 -> 36): 28 null
      // try (40 -> 49): 28 null
      // try (55 -> 60): 28 null
   }
}
