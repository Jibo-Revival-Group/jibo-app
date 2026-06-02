package org.apache.http.impl.io;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.EofSensor;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

@Deprecated
@NotThreadSafe
public class SocketInputBuffer extends AbstractSessionInputBuffer implements EofSensor {
   private boolean eof;
   private final Socket socket;

   public SocketInputBuffer(Socket var1, int var2, HttpParams var3) throws IOException {
      short var4 = 1024;
      super();
      Args.notNull(var1, "Socket");
      this.socket = var1;
      this.eof = false;
      if (var2 < 0) {
         var2 = var1.getReceiveBufferSize();
      }

      if (var2 < 1024) {
         var2 = var4;
      }

      this.init(var1.getInputStream(), var2, var3);
   }

   @Override
   protected int fillBuffer() throws IOException {
      int var1 = super.fillBuffer();
      boolean var2;
      if (var1 == -1) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.eof = var2;
      return var1;
   }

   @Override
   public boolean isDataAvailable(int var1) throws IOException {
      boolean var4 = this.hasBufferedData();
      boolean var3 = var4;
      if (!var4) {
         int var2 = this.socket.getSoTimeout();

         try {
            this.socket.setSoTimeout(var1);
            this.fillBuffer();
            var3 = this.hasBufferedData();
         } finally {
            this.socket.setSoTimeout(var2);
         }
      }

      return var3;
   }

   @Override
   public boolean isEof() {
      return this.eof;
   }
}
