package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.ConnectionClosedException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.Args;

@NotThreadSafe
public class ContentLengthInputStream extends InputStream {
   private static final int BUFFER_SIZE = 2048;
   private boolean closed;
   private final long contentLength;
   private SessionInputBuffer in;
   private long pos = 0L;

   public ContentLengthInputStream(SessionInputBuffer var1, long var2) {
      this.closed = false;
      this.in = null;
      this.in = Args.notNull(var1, "Session input buffer");
      this.contentLength = Args.notNegative(var2, "Content length");
   }

   @Override
   public int available() throws IOException {
      int var1;
      if (this.in instanceof BufferInfo) {
         var1 = Math.min(((BufferInfo)this.in).length(), (int)(this.contentLength - this.pos));
      } else {
         var1 = 0;
      }

      return var1;
   }

   @Override
   public void close() throws IOException {
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
      // 00: aload 0
      // 01: getfield org/apache/http/impl/io/ContentLengthInputStream.closed Z
      // 04: ifne 28
      // 07: aload 0
      // 08: getfield org/apache/http/impl/io/ContentLengthInputStream.pos J
      // 0b: aload 0
      // 0c: getfield org/apache/http/impl/io/ContentLengthInputStream.contentLength J
      // 0f: lcmp
      // 10: ifge 23
      // 13: sipush 2048
      // 16: newarray 8
      // 18: astore 2
      // 19: aload 0
      // 1a: aload 2
      // 1b: invokevirtual org/apache/http/impl/io/ContentLengthInputStream.read ([B)I
      // 1e: istore 1
      // 1f: iload 1
      // 20: ifge 19
      // 23: aload 0
      // 24: bipush 1
      // 25: putfield org/apache/http/impl/io/ContentLengthInputStream.closed Z
      // 28: return
      // 29: astore 2
      // 2a: aload 0
      // 2b: bipush 1
      // 2c: putfield org/apache/http/impl/io/ContentLengthInputStream.closed Z
      // 2f: aload 2
      // 30: athrow
      // try (3 -> 12): 22 null
      // try (12 -> 16): 22 null
   }

   @Override
   public int read() throws IOException {
      int var1 = -1;
      if (this.closed) {
         throw new IOException("Attempted read from closed stream.");
      }

      if (this.pos < this.contentLength) {
         var1 = this.in.read();
         if (var1 == -1) {
            if (this.pos < this.contentLength) {
               throw new ConnectionClosedException(
                  "Premature end of Content-Length delimited message body (expected: " + this.contentLength + "; received: " + this.pos
               );
            }
         } else {
            this.pos++;
         }
      }

      return var1;
   }

   @Override
   public int read(byte[] var1) throws IOException {
      return this.read(var1, 0, var1.length);
   }

   @Override
   public int read(byte[] var1, int var2, int var3) throws IOException {
      int var4 = -1;
      if (this.closed) {
         throw new IOException("Attempted read from closed stream.");
      }

      if (this.pos >= this.contentLength) {
         var2 = var4;
      } else {
         var4 = var3;
         if (this.pos + var3 > this.contentLength) {
            var4 = (int)(this.contentLength - this.pos);
         }

         var2 = this.in.read(var1, var2, var4);
         if (var2 == -1 && this.pos < this.contentLength) {
            throw new ConnectionClosedException(
               "Premature end of Content-Length delimited message body (expected: " + this.contentLength + "; received: " + this.pos
            );
         }

         if (var2 > 0) {
            this.pos += var2;
         }
      }

      return var2;
   }

   @Override
   public long skip(long var1) throws IOException {
      long var4 = 0L;
      if (var1 <= 0L) {
         var1 = var4;
      } else {
         byte[] var6 = new byte[2048];
         var4 = Math.min(var1, this.contentLength - this.pos);
         var1 = 0L;

         while (var4 > 0L) {
            int var3 = this.read(var6, 0, (int)Math.min(2048L, var4));
            if (var3 == -1) {
               break;
            }

            var1 += var3;
            var4 -= var3;
         }
      }

      return var1;
   }
}
