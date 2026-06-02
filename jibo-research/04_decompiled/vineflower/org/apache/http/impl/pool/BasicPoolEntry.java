package org.apache.http.impl.pool;

import java.io.IOException;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.pool.PoolEntry;

@ThreadSafe
public class BasicPoolEntry extends PoolEntry<HttpHost, HttpClientConnection> {
   public BasicPoolEntry(String var1, HttpHost var2, HttpClientConnection var3) {
      super(var1, var2, var3);
   }

   @Override
   public void close() {
      try {
         this.getConnection().close();
      } catch (IOException var2) {
      }
   }

   @Override
   public boolean isClosed() {
      boolean var1;
      if (!this.getConnection().isOpen()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }
}
