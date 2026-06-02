package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.TruncatedChunkException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class ChunkedInputStream extends InputStream {
   private static final int BUFFER_SIZE = 2048;
   private static final int CHUNK_CRLF = 3;
   private static final int CHUNK_DATA = 2;
   private static final int CHUNK_INVALID = Integer.MAX_VALUE;
   private static final int CHUNK_LEN = 1;
   private final CharArrayBuffer buffer;
   private int chunkSize;
   private boolean closed;
   private final MessageConstraints constraints;
   private boolean eof = false;
   private Header[] footers;
   private final SessionInputBuffer in;
   private int pos;
   private int state;

   public ChunkedInputStream(SessionInputBuffer var1) {
      this(var1, null);
   }

   public ChunkedInputStream(SessionInputBuffer var1, MessageConstraints var2) {
      this.closed = false;
      this.footers = new Header[0];
      this.in = Args.notNull(var1, "Session input buffer");
      this.pos = 0;
      this.buffer = new CharArrayBuffer(16);
      if (var2 == null) {
         var2 = MessageConstraints.DEFAULT;
      }

      this.constraints = var2;
      this.state = 1;
   }

   private int getChunkSize() throws IOException {
      switch (this.state) {
         case 2:
         default:
            throw new IllegalStateException("Inconsistent codec state");
         case 3:
            this.buffer.clear();
            if (this.in.readLine(this.buffer) == -1) {
               throw new MalformedChunkCodingException("CRLF expected at end of chunk");
            } else if (!this.buffer.isEmpty()) {
               throw new MalformedChunkCodingException("Unexpected content at the end of chunk");
            } else {
               this.state = 1;
            }
         case 1:
            this.buffer.clear();
            if (this.in.readLine(this.buffer) == -1) {
               throw new ConnectionClosedException("Premature end of chunk coded message body: closing chunk expected");
            } else {
               int var2 = this.buffer.indexOf(59);
               int var1 = var2;
               if (var2 < 0) {
                  var1 = this.buffer.length();
               }

               try {
                  return Integer.parseInt(this.buffer.substringTrimmed(0, var1), 16);
               } catch (NumberFormatException var4) {
                  throw new MalformedChunkCodingException("Bad chunk header");
               }
            }
      }
   }

   private void nextChunk() throws IOException {
      if (this.state == Integer.MAX_VALUE) {
         throw new MalformedChunkCodingException("Corrupt data stream");
      }

      try {
         this.chunkSize = this.getChunkSize();
         if (this.chunkSize < 0) {
            MalformedChunkCodingException var1 = new MalformedChunkCodingException("Negative chunk size");
            throw var1;
         }

         this.state = 2;
         this.pos = 0;
         if (this.chunkSize == 0) {
            this.eof = true;
            this.parseTrailerHeaders();
         }
      } catch (MalformedChunkCodingException var2) {
         this.state = Integer.MAX_VALUE;
         throw var2;
      }
   }

   private void parseTrailerHeaders() throws IOException {
      try {
         this.footers = AbstractMessageParser.parseHeaders(this.in, this.constraints.getMaxHeaderCount(), this.constraints.getMaxLineLength(), null);
      } catch (HttpException var3) {
         MalformedChunkCodingException var2 = new MalformedChunkCodingException("Invalid footer: " + var3.getMessage());
         var2.initCause(var3);
         throw var2;
      }
   }

   @Override
   public int available() throws IOException {
      int var1;
      if (this.in instanceof BufferInfo) {
         var1 = Math.min(((BufferInfo)this.in).length(), this.chunkSize - this.pos);
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
      // 01: getfield org/apache/http/impl/io/ChunkedInputStream.closed Z
      // 04: ifne 31
      // 07: aload 0
      // 08: getfield org/apache/http/impl/io/ChunkedInputStream.eof Z
      // 0b: ifne 27
      // 0e: aload 0
      // 0f: getfield org/apache/http/impl/io/ChunkedInputStream.state I
      // 12: ldc 2147483647
      // 14: if_icmpeq 27
      // 17: sipush 2048
      // 1a: newarray 8
      // 1c: astore 2
      // 1d: aload 0
      // 1e: aload 2
      // 1f: invokevirtual org/apache/http/impl/io/ChunkedInputStream.read ([B)I
      // 22: istore 1
      // 23: iload 1
      // 24: ifge 1d
      // 27: aload 0
      // 28: bipush 1
      // 29: putfield org/apache/http/impl/io/ChunkedInputStream.eof Z
      // 2c: aload 0
      // 2d: bipush 1
      // 2e: putfield org/apache/http/impl/io/ChunkedInputStream.closed Z
      // 31: return
      // 32: astore 2
      // 33: aload 0
      // 34: bipush 1
      // 35: putfield org/apache/http/impl/io/ChunkedInputStream.eof Z
      // 38: aload 0
      // 39: bipush 1
      // 3a: putfield org/apache/http/impl/io/ChunkedInputStream.closed Z
      // 3d: aload 2
      // 3e: athrow
      // try (3 -> 13): 26 null
      // try (13 -> 17): 26 null
   }

   public Header[] getFooters() {
      return (Header[])this.footers.clone();
   }

   @Override
   public int read() throws IOException {
      int var1 = -1;
      if (this.closed) {
         throw new IOException("Attempted read from closed stream.");
      }

      if (!this.eof) {
         if (this.state != 2) {
            this.nextChunk();
            if (this.eof) {
               return var1;
            }
         }

         var1 = this.in.read();
         if (var1 != -1) {
            this.pos++;
            if (this.pos >= this.chunkSize) {
               this.state = 3;
            }
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

      if (!this.eof) {
         if (this.state != 2) {
            this.nextChunk();
            if (this.eof) {
               return var4;
            }
         }

         var4 = this.in.read(var1, var2, Math.min(var3, this.chunkSize - this.pos));
         if (var4 == -1) {
            this.eof = true;
            throw new TruncatedChunkException("Truncated chunk ( expected size: " + this.chunkSize + "; actual size: " + this.pos + ")");
         }

         this.pos += var4;
         if (this.pos >= this.chunkSize) {
            this.state = 3;
         }
      }

      return var4;
   }
}
