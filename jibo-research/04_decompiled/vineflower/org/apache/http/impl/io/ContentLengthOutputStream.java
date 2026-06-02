package org.apache.http.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.Args;

@NotThreadSafe
public class ContentLengthOutputStream extends OutputStream {
   private boolean closed;
   private final long contentLength;
   private final SessionOutputBuffer out;
   private long total = 0L;

   public ContentLengthOutputStream(SessionOutputBuffer var1, long var2) {
      this.closed = false;
      this.out = Args.notNull(var1, "Session output buffer");
      this.contentLength = Args.notNegative(var2, "Content length");
   }

   @Override
   public void close() throws IOException {
      if (!this.closed) {
         this.closed = true;
         this.out.flush();
      }
   }

   @Override
   public void flush() throws IOException {
      this.out.flush();
   }

   @Override
   public void write(int var1) throws IOException {
      if (this.closed) {
         throw new IOException("Attempted write to closed stream.");
      }

      if (this.total < this.contentLength) {
         this.out.write(var1);
         this.total++;
      }
   }

   @Override
   public void write(byte[] var1) throws IOException {
      this.write(var1, 0, var1.length);
   }

   @Override
   public void write(byte[] var1, int var2, int var3) throws IOException {
      if (this.closed) {
         throw new IOException("Attempted write to closed stream.");
      }

      if (this.total < this.contentLength) {
         long var5 = this.contentLength - this.total;
         int var4 = var3;
         if (var3 > var5) {
            var4 = (int)var5;
         }

         this.out.write(var1, var2, var4);
         this.total += var4;
      }
   }
}
