package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.Args;

@NotThreadSafe
public class IdentityInputStream extends InputStream {
   private boolean closed = false;
   private final SessionInputBuffer in;

   public IdentityInputStream(SessionInputBuffer var1) {
      this.in = Args.notNull(var1, "Session input buffer");
   }

   @Override
   public int available() throws IOException {
      int var1;
      if (this.in instanceof BufferInfo) {
         var1 = ((BufferInfo)this.in).length();
      } else {
         var1 = 0;
      }

      return var1;
   }

   @Override
   public void close() throws IOException {
      this.closed = true;
   }

   @Override
   public int read() throws IOException {
      int var1;
      if (this.closed) {
         var1 = -1;
      } else {
         var1 = this.in.read();
      }

      return var1;
   }

   @Override
   public int read(byte[] var1, int var2, int var3) throws IOException {
      if (this.closed) {
         var2 = -1;
      } else {
         var2 = this.in.read(var1, var2, var3);
      }

      return var2;
   }
}
