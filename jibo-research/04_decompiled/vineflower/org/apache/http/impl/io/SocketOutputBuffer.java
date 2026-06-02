package org.apache.http.impl.io;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

@Deprecated
@NotThreadSafe
public class SocketOutputBuffer extends AbstractSessionOutputBuffer {
   public SocketOutputBuffer(Socket var1, int var2, HttpParams var3) throws IOException {
      short var4 = 1024;
      super();
      Args.notNull(var1, "Socket");
      if (var2 < 0) {
         var2 = var1.getSendBufferSize();
      }

      if (var2 < 1024) {
         var2 = var4;
      }

      this.init(var1.getOutputStream(), var2, var3);
   }
}
