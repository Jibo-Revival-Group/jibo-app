package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import org.apache.http.Consts;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
@NotThreadSafe
public abstract class AbstractSessionInputBuffer implements BufferInfo, SessionInputBuffer {
   private boolean ascii;
   private byte[] buffer;
   private int bufferlen;
   private int bufferpos;
   private CharBuffer cbuf;
   private Charset charset;
   private CharsetDecoder decoder;
   private InputStream instream;
   private ByteArrayBuffer linebuffer;
   private int maxLineLen;
   private HttpTransportMetricsImpl metrics;
   private int minChunkLimit;
   private CodingErrorAction onMalformedCharAction;
   private CodingErrorAction onUnmappableCharAction;

   private int appendDecoded(CharArrayBuffer var1, ByteBuffer var2) throws IOException {
      byte var4 = 0;
      int var3 = 0;
      if (var2.hasRemaining()) {
         if (this.decoder == null) {
            this.decoder = this.charset.newDecoder();
            this.decoder.onMalformedInput(this.onMalformedCharAction);
            this.decoder.onUnmappableCharacter(this.onUnmappableCharAction);
         }

         if (this.cbuf == null) {
            this.cbuf = CharBuffer.allocate(1024);
         }

         this.decoder.reset();
         var3 = var4;

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

      if (this.ascii) {
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
      if (this.ascii) {
         var1.append(this.buffer, var4, var2);
      } else {
         var2 = this.appendDecoded(var1, ByteBuffer.wrap(this.buffer, var4, var2));
      }

      return var2;
   }

   private int locateLF() {
      int var1 = this.bufferpos;

      while (true) {
         if (var1 >= this.bufferlen) {
            var1 = -1;
            break;
         }

         if (this.buffer[var1] == 10) {
            break;
         }

         var1++;
      }

      return var1;
   }

   @Override
   public int available() {
      return this.capacity() - this.length();
   }

   @Override
   public int capacity() {
      return this.buffer.length;
   }

   protected HttpTransportMetricsImpl createTransportMetrics() {
      return new HttpTransportMetricsImpl();
   }

   protected int fillBuffer() throws IOException {
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
      var4 = this.instream.read(this.buffer, var3, var4 - var3);
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

   protected boolean hasBufferedData() {
      boolean var1;
      if (this.bufferpos < this.bufferlen) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   protected void init(InputStream var1, int var2, HttpParams var3) {
      Args.notNull(var1, "Input stream");
      Args.notNegative(var2, "Buffer size");
      Args.notNull(var3, "HTTP parameters");
      this.instream = var1;
      this.buffer = new byte[var2];
      this.bufferpos = 0;
      this.bufferlen = 0;
      this.linebuffer = new ByteArrayBuffer(var2);
      String var4 = (String)var3.getParameter("http.protocol.element-charset");
      Charset var5;
      if (var4 != null) {
         var5 = Charset.forName(var4);
      } else {
         var5 = Consts.ASCII;
      }

      this.charset = var5;
      this.ascii = this.charset.equals(Consts.ASCII);
      this.decoder = null;
      this.maxLineLen = var3.getIntParameter("http.connection.max-line-length", -1);
      this.minChunkLimit = var3.getIntParameter("http.connection.min-chunk-limit", 512);
      this.metrics = this.createTransportMetrics();
      CodingErrorAction var6 = (CodingErrorAction)var3.getParameter("http.malformed.input.action");
      if (var6 == null) {
         var6 = CodingErrorAction.REPORT;
      }

      this.onMalformedCharAction = var6;
      CodingErrorAction var7 = (CodingErrorAction)var3.getParameter("http.unmappable.input.action");
      if (var7 == null) {
         var7 = CodingErrorAction.REPORT;
      }

      this.onUnmappableCharAction = var7;
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
         var3 = this.instream.read(var1, var2, var3);
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
      int var3 = 1;
      int var4 = 0;

      int var7;
      while (true) {
         if (!var3) {
            if (var4 == -1 && this.linebuffer.isEmpty()) {
               var7 = -1;
               break;
            }

            var7 = this.lineFromLineBuffer(var1);
            break;
         }

         var7 = this.locateLF();
         int var5;
         boolean var6;
         if (var7 != -1) {
            if (this.linebuffer.isEmpty()) {
               var7 = this.lineFromReadBuffer(var1, var7);
               break;
            }

            var3 = this.bufferpos;
            this.linebuffer.append(this.buffer, this.bufferpos, var7 + 1 - var3);
            this.bufferpos = var7 + 1;
            var6 = 0;
            var5 = var4;
         } else {
            if (this.hasBufferedData()) {
               var6 = this.bufferlen;
               var4 = this.bufferpos;
               this.linebuffer.append(this.buffer, this.bufferpos, var6 - var4);
               this.bufferpos = this.bufferlen;
            }

            var4 = this.fillBuffer();
            var6 = var3;
            var5 = var4;
            if (var4 == -1) {
               var6 = 0;
               var5 = var4;
            }
         }

         var3 = var6;
         var4 = var5;
         if (this.maxLineLen > 0) {
            var3 = var6;
            var4 = var5;
            if (this.linebuffer.length() >= this.maxLineLen) {
               throw new IOException("Maximum line length limit exceeded");
            }
         }
      }

      return var7;
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
