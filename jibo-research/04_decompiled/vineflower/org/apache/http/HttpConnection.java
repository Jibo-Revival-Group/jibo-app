package org.apache.http;

import java.io.Closeable;
import java.io.IOException;

public interface HttpConnection extends Closeable {
   @Override
   void close() throws IOException;

   HttpConnectionMetrics getMetrics();

   int getSocketTimeout();

   boolean isOpen();

   boolean isStale();

   void setSocketTimeout(int var1);

   void shutdown() throws IOException;
}
