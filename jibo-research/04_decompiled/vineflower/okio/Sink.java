package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public interface Sink extends Closeable, Flushable {
   Timeout a();

   void a_(Buffer var1, long var2) throws IOException;

   @Override
   void close() throws IOException;

   @Override
   void flush() throws IOException;
}
