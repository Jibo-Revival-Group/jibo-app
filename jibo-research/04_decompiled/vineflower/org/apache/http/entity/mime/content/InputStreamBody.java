package org.apache.http.entity.mime.content;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.ContentType;
import org.apache.http.util.Args;

public class InputStreamBody extends AbstractContentBody {
   private final String filename;
   private final InputStream in;

   public InputStreamBody(InputStream var1, String var2) {
      this(var1, ContentType.DEFAULT_BINARY, var2);
   }

   @Deprecated
   public InputStreamBody(InputStream var1, String var2, String var3) {
      this(var1, ContentType.create(var2), var3);
   }

   public InputStreamBody(InputStream var1, ContentType var2) {
      this(var1, var2, null);
   }

   public InputStreamBody(InputStream var1, ContentType var2, String var3) {
      super(var2);
      Args.notNull(var1, "Input stream");
      this.in = var1;
      this.filename = var3;
   }

   @Override
   public long getContentLength() {
      return -1L;
   }

   @Override
   public String getFilename() {
      return this.filename;
   }

   public InputStream getInputStream() {
      return this.in;
   }

   @Override
   public String getTransferEncoding() {
      return "binary";
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
      // 07: sipush 4096
      // 0a: newarray 8
      // 0c: astore 3
      // 0d: aload 0
      // 0e: getfield org/apache/http/entity/mime/content/InputStreamBody.in Ljava/io/InputStream;
      // 11: aload 3
      // 12: invokevirtual java/io/InputStream.read ([B)I
      // 15: istore 2
      // 16: iload 2
      // 17: bipush -1
      // 18: if_icmpeq 2f
      // 1b: aload 1
      // 1c: aload 3
      // 1d: bipush 0
      // 1e: iload 2
      // 1f: invokevirtual java/io/OutputStream.write ([BII)V
      // 22: goto 0d
      // 25: astore 1
      // 26: aload 0
      // 27: getfield org/apache/http/entity/mime/content/InputStreamBody.in Ljava/io/InputStream;
      // 2a: invokevirtual java/io/InputStream.close ()V
      // 2d: aload 1
      // 2e: athrow
      // 2f: aload 1
      // 30: invokevirtual java/io/OutputStream.flush ()V
      // 33: aload 0
      // 34: getfield org/apache/http/entity/mime/content/InputStreamBody.in Ljava/io/InputStream;
      // 37: invokevirtual java/io/InputStream.close ()V
      // 3a: return
      // try (4 -> 7): 21 null
      // try (7 -> 12): 21 null
      // try (15 -> 20): 21 null
      // try (27 -> 29): 21 null
   }
}
