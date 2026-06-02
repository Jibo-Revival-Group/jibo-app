package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import org.apache.http.MessageConstraintException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class SessionInputBufferImpl implements BufferInfo, SessionInputBuffer {
   private final byte[] buffer;
   private int bufferlen;
   private int bufferpos;
   private CharBuffer cbuf;
   private final MessageConstraints constraints;
   private final CharsetDecoder decoder;
   private InputStream instream;
   private final ByteArrayBuffer linebuffer;
   private final HttpTransportMetricsImpl metrics;
   private final int minChunkLimit;

   public SessionInputBufferImpl(HttpTransportMetricsImpl var1, int var2) {
      this(var1, var2, var2, null, null);
   }

   public SessionInputBufferImpl(HttpTransportMetricsImpl var1, int var2, int var3, MessageConstraints var4, CharsetDecoder var5) {
      Args.notNull(var1, "HTTP transport metrcis");
      Args.positive(var2, "Buffer size");
      this.metrics = var1;
      this.buffer = new byte[var2];
      this.bufferpos = 0;
      this.bufferlen = 0;
      if (var3 < 0) {
         var3 = 512;
      }

      this.minChunkLimit = var3;
      if (var4 == null) {
         var4 = MessageConstraints.DEFAULT;
      }

      this.constraints = var4;
      this.linebuffer = new ByteArrayBuffer(var2);
      this.decoder = var5;
   }

   private int appendDecoded(CharArrayBuffer var1, ByteBuffer var2) throws IOException {
      int var3 = 0;
      byte var4 = 0;
      if (!var2.hasRemaining()) {
         var3 = var4;
      } else {
         if (this.cbuf == null) {
            this.cbuf = CharBuffer.allocate(1024);
         }

         this.decoder.reset();

         while (var2.hasRemaining()) {
            var3 += this.handleDecodingResult(this.decoder.decode(var2, this.cbuf, true), var1, var2);
         }

         var3 += this.handleDecodingResult(this.decoder.flush(this.cbuf), var1, var2);
         ((Buffer)this.cbuf).clear();
      }

      return var3;
   }

   private int handleDecodingResult(CoderResult var1, CharArrayBuffer var2, ByteBuffer var3) throws IOException {
      if (var1.isError()) {
         var1.throwException();
      }

      ((Buffer)this.cbuf).flip();
      int var4 = this.cbuf.remaining();

      while (this.cbuf.hasRemaining()) {
         var2.append(this.cbuf.get());
      }

      this.cbuf.compact();
      return var4;
   }

   private int lineFromLineBuffer(CharArrayBuffer var1) throws IOException {
      int var4 = this.linebuffer.length();
      int var2 = var4;
      if (var4 > 0) {
         int var3 = var4;
         if (this.linebuffer.byteAt(var4 - 1) == 10) {
            var3 = var4 - 1;
         }

         var2 = var3;
         if (var3 > 0) {
            var2 = var3;
            if (this.linebuffer.byteAt(var3 - 1) == 13) {
               var2 = var3 - 1;
            }
         }
      }

      if (this.decoder == null) {
         var1.append(this.linebuffer, 0, var2);
      } else {
         var2 = this.appendDecoded(var1, ByteBuffer.wrap(this.linebuffer.buffer(), 0, var2));
      }

      this.linebuffer.clear();
      return var2;
   }

   private int lineFromReadBuffer(CharArrayBuffer var1, int var2) throws IOException {
      int var4 = this.bufferpos;
      this.bufferpos = var2 + 1;
      int var3 = var2;
      if (var2 > var4) {
         var3 = var2;
         if (this.buffer[var2 - 1] == 13) {
            var3 = var2 - 1;
         }
      }

      var2 = var3 - var4;
      if (this.decoder == null) {
         var1.append(this.buffer, var4, var2);
      } else {
         var2 = this.appendDecoded(var1, ByteBuffer.wrap(this.buffer, var4, var2));
      }

      return var2;
   }

   private int streamRead(byte[] var1, int var2, int var3) throws IOException {
      Asserts.notNull(this.instream, "Input stream");
      return this.instream.read(var1, var2, var3);
   }

   @Override
   public int available() {
      return this.capacity() - this.length();
   }

   public void bind(InputStream var1) {
      this.instream = var1;
   }

   @Override
   public int capacity() {
      return this.buffer.length;
   }

   public void clear() {
      this.bufferpos = 0;
      this.bufferlen = 0;
   }

   public int fillBuffer() throws IOException {
      int var1 = -1;
      if (this.bufferpos > 0) {
         int var2 = this.bufferlen - this.bufferpos;
         if (var2 > 0) {
            System.arraycopy(this.buffer, this.bufferpos, this.buffer, 0, var2);
         }

         this.bufferpos = 0;
         this.bufferlen = var2;
      }

      int var3 = this.bufferlen;
      int var4 = this.buffer.length;
      var4 = this.streamRead(this.buffer, var3, var4 - var3);
      if (var4 != -1) {
         this.bufferlen = var3 + var4;
         this.metrics.incrementBytesTransferred(var4);
         var1 = var4;
      }

      return var1;
   }

   @Override
   public HttpTransportMetrics getMetrics() {
      return this.metrics;
   }

   public boolean hasBufferedData() {
      boolean var1;
      if (this.bufferpos < this.bufferlen) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean isBound() {
      boolean var1;
      if (this.instream != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public boolean isDataAvailable(int var1) throws IOException {
      return this.hasBufferedData();
   }

   @Override
   public int length() {
      return this.bufferlen - this.bufferpos;
   }

   @Override
   public int read() throws IOException {
      int var1 = -1;

      do {
         if (this.hasBufferedData()) {
            byte[] var2 = this.buffer;
            var1 = this.bufferpos++;
            var1 = var2[var1] & 255;
            break;
         }
      } while (this.fillBuffer() != -1);

      return var1;
   }

   @Override
   public int read(byte[] var1) throws IOException {
      int var2 = 0;
      if (var1 != null) {
         var2 = this.read(var1, 0, var1.length);
      }

      return var2;
   }

   @Override
   public int read(byte[] var1, int var2, int var3) throws IOException {
      byte var4 = -1;
      if (var1 == null) {
         var2 = 0;
      } else if (this.hasBufferedData()) {
         var3 = Math.min(var3, this.bufferlen - this.bufferpos);
         System.arraycopy(this.buffer, this.bufferpos, var1, var2, var3);
         this.bufferpos += var3;
         var2 = var3;
      } else if (var3 > this.minChunkLimit) {
         var3 = this.streamRead(var1, var2, var3);
         var2 = var3;
         if (var3 > 0) {
            this.metrics.incrementBytesTransferred(var3);
            var2 = var3;
         }
      } else {
         while (true) {
            if (this.hasBufferedData()) {
               var3 = Math.min(var3, this.bufferlen - this.bufferpos);
               System.arraycopy(this.buffer, this.bufferpos, var1, var2, var3);
               this.bufferpos += var3;
               var2 = var3;
               break;
            }

            if (this.fillBuffer() == -1) {
               var2 = var4;
               break;
            }
         }
      }

      return var2;
   }

   @Override
   public int readLine(CharArrayBuffer var1) throws IOException {
      Args.notNull(var1, "Char array buffer");
      int var6 = this.constraints.getMaxLineLength();
      int var2 = 1;
      int var3 = 0;

      while (true) {
         if (!var2) {
            if (var3 == -1 && this.linebuffer.isEmpty()) {
               var2 = -1;
            } else {
               var2 = this.lineFromLineBuffer(var1);
            }
            break;
         }

         int var4 = this.bufferpos;

         while (true) {
            if (var4 >= this.bufferlen) {
               var4 = -1;
               break;
            }

            if (this.buffer[var4] == 10) {
               break;
            }

            var4++;
         }

         if (var6 > 0) {
            int var7 = this.linebuffer.length();
            int var5;
            if (var4 > 0) {
               var5 = var4;
            } else {
               var5 = this.bufferlen;
            }

            if (var5 + var7 - this.bufferpos >= var6) {
               throw new MessageConstraintException("Maximum line length limit exceeded");
            }
         }

         boolean var11;
         if (var4 != -1) {
            if (this.linebuffer.isEmpty()) {
               var2 = this.lineFromReadBuffer(var1, var4);
               break;
            }

            var2 = this.bufferpos;
            this.linebuffer.append(this.buffer, this.bufferpos, var4 + 1 - var2);
            this.bufferpos = var4 + 1;
            boolean var13 = false;
            var2 = var3;
            var11 = var13;
         } else {
            if (this.hasBufferedData()) {
               var4 = this.bufferlen;
               var11 = this.bufferpos;
               this.linebuffer.append(this.buffer, this.bufferpos, var4 - var11);
               this.bufferpos = this.bufferlen;
            }

            var4 = this.fillBuffer();
            if (var4 == -1) {
               var2 = var4;
               var11 = 0;
            } else {
               var11 = var2;
               var2 = var4;
            }
         }

         var4 = var2;
         var2 = var11;
         var3 = var4;
      }

      return var2;
   }

   @Override
   public String readLine() throws IOException {
      CharArrayBuffer var1 = new CharArrayBuffer(64);
      String var2;
      if (this.readLine(var1) != -1) {
         var2 = var1.toString();
      } else {
         var2 = null;
      }

      return var2;
   }
}
