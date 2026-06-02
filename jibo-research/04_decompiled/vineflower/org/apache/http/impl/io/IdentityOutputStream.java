package org.apache.http.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.Args;

@NotThreadSafe
public class IdentityOutputStream extends OutputStream {
   private boolean closed = false;
   private final SessionOutputBuffer out;

   public IdentityOutputStream(SessionOutputBuffer var1) {
      this.out = Args.notNull(var1, "Session output buffer");
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

      this.out.write(var1);
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

      this.out.write(var1, var2, var3);
   }
}
